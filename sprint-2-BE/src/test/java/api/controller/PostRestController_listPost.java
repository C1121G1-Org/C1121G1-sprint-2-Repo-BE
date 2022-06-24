package api.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.StatusAssertions;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class PostRestController_listPost {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getListPost_5() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/post/list"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getListPost_5_sizeNotNull() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/post/list"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.totalPages").value(1))
                .andExpect(jsonPath("$.totalElements").value(4))
                .andExpect(jsonPath("$.content[1].content").value("Vitamin Sea"))
                .andExpect(jsonPath("$.content[1].feeling").value("Đang hạnh phúc"))
                .andExpect(jsonPath("$.content[1].image").value("https://znews-photo.zingcdn.me/w660/Uploaded/unvjuas/2021_03_15/20210316_124154.jpg"))
                .andExpect(jsonPath("$.content[1].post_date").value("vanc@codegym.com"))
                .andExpect(jsonPath("$.content[1].privacy").value("Công khai"))
                .andExpect(jsonPath("$.content[1].guestId").value(2));
    }





}
