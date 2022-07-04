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
public class FriendRestController_searchFriend {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getSearchFriend_name_1() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/friend/list/{name}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getSearchFriend_name_2() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/friend/list/{name}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getSearchFriend_name_3() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/friend/list/{name}", "1234a"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getSearchFriend_name_4() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/employee/list/{name}", "nhung"))
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
