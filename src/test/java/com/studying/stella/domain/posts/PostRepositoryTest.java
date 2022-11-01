package com.studying.stella.domain.posts;

import static org.junit.Assert.assertThat;
import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertThat;

public class PostRepositoryTest {

    @Autowired
    PostRepository postsRepository;

    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("stellayoonz@naver.com")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        //assertThat(posts.getTitle()).isEqualTo(title);
        //assertThat(posts.getContent()).isEqualTo(content);
    }

}
