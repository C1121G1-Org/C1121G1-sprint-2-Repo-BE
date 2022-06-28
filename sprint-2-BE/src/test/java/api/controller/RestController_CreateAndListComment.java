package api.controller;

import api.dto.CommentDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@SpringBootTest
@AutoConfigureMockMvc
public class RestController_CreateAndListComment {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    //Case list size=0
    @Test
    public void getListComment_size0() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/comment/list"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Case list size=10
    @Test
    public void getListComment_sizeNotNull() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/comment/list"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.content[2].comment_content").value("Đẹp quá chị ơi!"))
                .andExpect(jsonPath("$.content[2].time").value("1992-06-02"))
                .andExpect(jsonPath("$.content[2].guest_id").value("2"))
                .andExpect(jsonPath("$.content[2].post_id").value("1"))
        ;
    }


    //create comment comment content null
    @Test
    public void createComment_commentContentNull() throws Exception {
        CommentDto commentDto = new CommentDto();

        commentDto.setCommentContent("");
        commentDto.setTime("2022/03/12");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/comment/create")
                        .content(this.objectMapper.writeValueAsString(commentDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //create comment comment content not null
    @Test
    public void createComment_commentContentNull() throws Exception {
        CommentDto commentDto = new CommentDto();

        commentDto.setCommentContent("Đẹp quá chị ơi!");
        commentDto.setTime("2022/03/12");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/comment/create")
                        .content(this.objectMapper.writeValueAsString(commentDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    //create comment time null
    @Test
    public void createComment_commentContentNull() throws Exception {
        CommentDto commentDto = new CommentDto();

        commentDto.setCommentContent("Đẹp quá chị ơi!");
        commentDto.setTime("");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/comment/create")
                        .content(this.objectMapper.writeValueAsString(commentDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //create comment time not null
    @Test
    public void createComment_commentContentNull() throws Exception {
        CommentDto commentDto = new CommentDto();

        commentDto.setCommentContent("Đẹp quá chị ơi!");
        commentDto.setTime("2022/03/12");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/comment/create")
                        .content(this.objectMapper.writeValueAsString(commentDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }



}
