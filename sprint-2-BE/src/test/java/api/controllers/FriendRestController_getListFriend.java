package api.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FriendRestController_getListFriend {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getListFriend_5() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/friend/list/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getListFriend_6() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/friend/list/"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.totalPages").value(3))
                .andExpect(jsonPath("$.totalElements").value(36))
                .andExpect(jsonPath("$.content[3].name").value("Trần Thị Quyên"))
                .andExpect(jsonPath("$.content[3].dateOfBirth").value("1996-10-20"))
                .andExpect(jsonPath("$.content[3].address").value("Đà Nẵng"))
                .andExpect(jsonPath("$.content[3].career").value("diễn viên"))
                .andExpect(jsonPath("$.content[3].email").value("locle@gmail.com"))
                .andExpect(jsonPath("$.content[3].image").value("url"))
                .andExpect(jsonPath("$.content[3].favorite").value("tennis"))
                .andExpect(jsonPath("$.content[3].gender").value(0))
                .andExpect(jsonPath("$.content[3].nickName").value("adele"))
                .andExpect(jsonPath("$.content[3].maritalStatus").value(0));

    }
}
