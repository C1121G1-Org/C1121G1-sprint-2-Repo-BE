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
public class FriendRestController_deleteFriend {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getDeleteFriend_id_25() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/friend/delete/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getDeleteFriend_id_26() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/friend/delete/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getDeleteFriend_id_27() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/friend/delete/{id}", "100"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getDeleteFriend_id_28() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/friend/delete/{id}", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.totalPages").value(3))
                .andExpect(jsonPath("$.totalElements").value(36))
                .andExpect(jsonPath("$.content[1].name").value("Nguyễn Hồng Nhung"))
                .andExpect(jsonPath("$.content[1].dateOfBirth").value("2000-12-06"))
                .andExpect(jsonPath("$.content[1].address").value("Tp. Hồ Chí Minh"))
                .andExpect(jsonPath("$.content[1].career").value("bác sĩ"))
                .andExpect(jsonPath("$.content[1].email").value("nhungnguyen@gmail.com"))
                .andExpect(jsonPath("$.content[1].image").value("url"))
                .andExpect(jsonPath("$.content[1].favorite").value("hát hò"))
                .andExpect(jsonPath("$.content[1].gender").value(0))
                .andExpect(jsonPath("$.content[1].nickName").value("nhung pham"))
                .andExpect(jsonPath("$.content[1].maritalStatus").value(0));
    }
}
