package api.controller;

import api.dto.PostDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PostRestController_createPost {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createPost_content_13() throws Exception {
        PostDto postDto = new PostDto();

        postDto.setImage("sssssssssss");
        postDto.setPostDate("2022-06-24 12:22:58");
        postDto.setPrivacy("Công khai");
        postDto.setFeeling("Vui vẻ");
        postDto.setGuestId(1L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/post/create")
                        .content(this.objectMapper.writeValueAsString(postDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createPost_content_14() throws Exception {
        PostDto postDto = new PostDto();

        postDto.setImage("sssssssssss");
        postDto.setPostDate("2022-06-24 12:22:58");
        postDto.setPrivacy("Công khai");
        postDto.setFeeling("Vui vẻ");
        postDto.setContent("");
        postDto.setGuestId(1L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/post/create")
                        .content(this.objectMapper.writeValueAsString(postDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createPost_content_18() throws Exception {
        PostDto postDto = new PostDto();

        postDto.setImage("sssssssssss");
        postDto.setPostDate("2022-06-24 12:22:58");
        postDto.setPrivacy("Công khai");
        postDto.setFeeling("Vui vẻ");
        postDto.setContent("aaaaaaaaaaaaaa");
        postDto.setGuestId(1L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/post/create")
                        .content(this.objectMapper.writeValueAsString(postDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
