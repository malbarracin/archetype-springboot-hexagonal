package ${package}.usecases;

import ${package}.application.PostUsecase;
import ${package}.domain.model.Post;
import ${package}.domain.ports.ExternalPostsClient;
import ${package}.domain.service.PostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PostUsecaseTest {

    @Mock
    private ExternalPostsClient externalPostsClient;

    @InjectMocks
    private PostService postService;

    private PostUsecase postUsecase;


    @BeforeEach
    public void setUp() {
        postUsecase = new PostUsecase(postService);
        Post post = new Post();
        post.setId(1L);
        post.setUserId(1234L);
        post.setBody("Mensaje de prueba");
        post.setTitle("titulo de prueba");
        when(externalPostsClient.findPostById("1")).thenReturn(post);
    }

    @Test
    public void findPostByUserIdTest() {
        assertEquals("Mensaje de prueba", postUsecase.getPost("1").getBody());
    }


}
