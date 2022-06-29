package api.controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*
 Created by ChienLV
 Time: 20:00 25/06/2022
*/
@SpringBootTest
@AutoConfigureMockMvc
public class GuestFriendController_getListFriendSuggestions {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void getListFriendSuggestions_5() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/guest-friend/list-friend-suggests/6"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getListFriendSuggestions_6() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/guest-friend/list-friend-suggests/1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$.[0].id").value(6))
                .andExpect(jsonPath("$.[0].guest.id").value(4))
                .andExpect(jsonPath("$.[0].friend.id").value(2))
                .andExpect(jsonPath("$.[0].isAccept").value(1))
                .andExpect(jsonPath("$.[0].isSuggest").value(1))
                .andExpect(jsonPath("$.[1].id").value(9))
                .andExpect(jsonPath("$.[1].guest.id").value(3))
                .andExpect(jsonPath("$.[1].friend.id").value(5))
                .andExpect(jsonPath("$.[1].isAccept").value(1))
                .andExpect(jsonPath("$.[1].isSuggest").value(1));
    }
}
