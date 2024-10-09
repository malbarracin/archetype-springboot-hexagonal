package ${package}.adapter.in.client;

import ${package}.client.exception.HttpClientException;
import ${package}.domain.exception.PlaceHolderException;
import ${package}.domain.model.Post;
import ${package}.client.model.JsonWebClient;
import ${package}.client.model.JsonWebRequest;
import ${package}.domain.ports.ExternalPostsAsyncClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@Slf4j
@RequiredArgsConstructor
public class ExternalPostsAsyncClientImpl implements ExternalPostsAsyncClient {

    @Value("${jsonplaceholder.host}")
    private String JSON_PLACEHOLDER_HOST;

    private static final String POSTS = "/POSTS/";
    private final JsonWebClient jsonWebClient;

    @Override
    public Mono<Post> findPostByIdAsync(String id) throws PlaceHolderException {
        try{
            String urlUsers = JSON_PLACEHOLDER_HOST + POSTS + id;
            log.info("Get Users Async: {}", urlUsers);
            return jsonWebClient
                    .get(JsonWebRequest.builder(Post.class).url(urlUsers).build())
                    // doOnNext: Realiza una acción secundaria cuando se recibe la respuesta
                    .doOnNext(this::doOnNextResponse)
                    // onErrorComplete: Maneja errores, registra el error y lanza una excepción personalizada
                    .onErrorComplete(this::handleError)
                    // onErrorResume: Proporciona un flujo alternativo en caso de error
                    .onErrorResume(this::onErrorResume)
                    // map: Transforma la respuesta, en este caso, posiblemente modifica la respuesta
                    .map(this::mapResponse);
        }catch (HttpClientException exception) {
            log.error(String.format("Get Users error: %s", exception.getBody()), exception);
            throw new PlaceHolderException(exception.getMessage(), exception);
        }
    }

    void doOnNextResponse(Post post)
    {
        log.info("The post is: {}", post);
    }

    boolean handleError(Throwable e) {
        log.error(String.format("Get Users error: %s", e.getMessage()), e);
        throw new PlaceHolderException(e.getMessage(), e);
    }

    // Método utilizado en onErrorResume para proporcionar un flujo alternativo en caso de error
    Mono<Post> onErrorResume(Throwable e) {
        log.error("Handling error in onErrorResume: {}", e.getMessage());

        Post defaultPost = new Post();
        defaultPost.setId((long) -1);
        defaultPost.setTitle("Error Post");
        defaultPost.setBody("This is a error post");
        defaultPost.setUserId(0L);

        return Mono.just(defaultPost);
    }

    Post mapResponse(Post post)
    {
        log.info("The post is: {}", post);
        return post;
    }

}
