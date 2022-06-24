package api.controller;


import api.dto.PostDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class PostRestController_editPost {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getInfoPost_id_null() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/api/post/update/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getInfoPost_id_empty() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/api/post/update/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //test id=1, return object
    @Test
    public void getInfoCustomer_id_4() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/api/post/update/{id}", "4"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.content").value("Vitamin Sea"))
                .andExpect(jsonPath("$.feeling").value("Đang hạnh phúc"))
                .andExpect(jsonPath("$.image").value("https://znews-photo.zingcdn.me/w660/Uploaded/unvjuas/2021_03_15/20210316_124154.jpg"))
                .andExpect(jsonPath("$.post_date").value("vanc@codegym.com"))
                .andExpect(jsonPath("$.privacy").value("Công khai"))
                .andExpect(jsonPath("$.guestId").value(2));
    }

    @Test
    public void editPost_content_wrong() throws Exception {

        PostDto postDto = new PostDto();

        postDto.setContent(" Vitamin Sea sea");
        postDto.setFeeling("Đang hạnh phúc");
        postDto.setImage("https://znews-photo.zingcdn.me/w660/Uploaded/unvjuas/2021_03_15/20210316_124154.jpg");
        postDto.setPostDate("vanc@codegym.com");
        postDto.setPrivacy("Công khai");
        postDto.setGuestId(2L);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/post/update/{id}")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


}
