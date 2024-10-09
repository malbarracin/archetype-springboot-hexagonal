package ${package}.adapter.in.client;

import ${package}.client.exception.HttpClientException;
import ${package}.domain.exception.PlaceHolderException;
import ${package}.domain.model.Post;
import ${package}.client.JsonHttpClient;
import ${package}.client.JsonHttpRequest;
import ${package}.domain.ports.ExternalPostsClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class ExternalPostsClientImpl implements ExternalPostsClient {

    @Value("${jsonplaceholder.host}")
    private String JSON_PLACEHOLDER_HOST;

    private static final String POSTS = "/POSTS/";
    private final JsonHttpClient jsonHttpClient;

    @Override
    public Post findPostById(String id) throws PlaceHolderException {
        try{
            String urlUsers = JSON_PLACEHOLDER_HOST + POSTS + id;
            log.info("Get Users: {}", urlUsers);
            return jsonHttpClient.get(JsonHttpRequest.builder(Post.class).url(urlUsers).build());
        }catch (HttpClientException exception) {
            log.error(String.format("Get Users error: %s", exception.getBody()), exception);
            throw new PlaceHolderException(exception.getMessage(), exception);
        }
    }

}
