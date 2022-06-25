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
public class PostRestController_updatePost {
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

    //    test post's  content null
    @Test
    public void updatePost_contentPostList_19() throws Exception {

        PostDto postDto = new PostDto();

        postDto.setFeeling("Đang hạnh phúc");
        postDto.setImage("https://znews-photo.zingcdn.me/w660/Uploaded/unvjuas/2021_03_15/20210316_124154.jpg");
        postDto.setPostDate("2022-06-20");
        postDto.setPrivacy("Công khai");
        postDto.setGuestId(2L);

        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/post/update/{id}")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }


    //    test post no content
    @Test
    public void updatePost_contentPostList_20() throws Exception {

        PostDto postDto = new PostDto();

        postDto.setContent("");
        postDto.setFeeling("Đang hạnh phúc");
        postDto.setImage("https://znews-photo.zingcdn.me/w660/Uploaded/unvjuas/2021_03_15/20210316_124154.jpg");
        postDto.setPostDate("2022-06-20");
        postDto.setPrivacy("Công khai");
        postDto.setGuestId(2L);

        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/post/update/{id}")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    //    test post's  date null
    @Test
    public void updatePost_postDate_19() throws Exception {

        PostDto postDto = new PostDto();
        postDto.setContent("vitamin sea");
        postDto.setFeeling("Đang hạnh phúc");
        postDto.setImage("https://znews-photo.zingcdn.me/w660/Uploaded/unvjuas/2021_03_15/20210316_124154.jpg");
        postDto.setPrivacy("Công khai");
        postDto.setGuestId(2L);

        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/post/update/{id}")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }


    //    test post's  date empty
    @Test
    public void updatePost_postDate_20() throws Exception {

        PostDto postDto = new PostDto();

        postDto.setContent("vitamin sea");
        postDto.setFeeling("Đang hạnh phúc");
        postDto.setImage("https://znews-photo.zingcdn.me/w660/Uploaded/unvjuas/2021_03_15/20210316_124154.jpg");
        postDto.setPostDate("");
        postDto.setPrivacy("Công khai");
        postDto.setGuestId(2L);

        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/post/update/{id}")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    //    test post's  privacy null
    @Test
    public void updatePost_privacyPostList_19() throws Exception {

        PostDto postDto = new PostDto();
        postDto.setContent("vitamin sea");
        postDto.setFeeling("Đang hạnh phúc");
        postDto.setImage("https://znews-photo.zingcdn.me/w660/Uploaded/unvjuas/2021_03_15/20210316_124154.jpg");
        postDto.setPostDate("2022-06-20");
        postDto.setGuestId(2L);

        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/post/update/{id}")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }


    //    test post's  privacy empty
    @Test
    public void updatePost_privacyPostList_20() throws Exception {

        PostDto postDto = new PostDto();

        postDto.setContent("vitamin sea");
        postDto.setFeeling("Đang hạnh phúc");
        postDto.setImage("https://znews-photo.zingcdn.me/w660/Uploaded/unvjuas/2021_03_15/20210316_124154.jpg");
        postDto.setPostDate("2022-06-20");
        postDto.setPrivacy("");
        postDto.setGuestId(2L);

        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/post/update/{id}")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    // Test edit success
    @Test
    public void updatePost_24() throws Exception {
        PostDto postDto = new PostDto();

        postDto.setContent("vitamin sea and girl");
        postDto.setFeeling("Đang vui vẻ");
        postDto.setImage("https://znews-photo.zingcdn.me/w660/Uploaded/unvjuas/2021_03_15/20210316_124154.jpg");
        postDto.setPostDate("2022-06-20");
        postDto.setPrivacy("Công khai");
        postDto.setGuestId(2L);

        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/post/update/{id}")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }


}
