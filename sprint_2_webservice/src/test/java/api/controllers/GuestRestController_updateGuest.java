package api.controllers;

import api.dto.ExtraInforDto;
import api.dto.GuestDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class GuestRestController_updateGuest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    //Test cho trường hợp không tìm thấy Guest từ tham số userName = null
    @Test
    public void createGuest_name_1() throws Exception {
        ExtraInforDto extraInforDto = new ExtraInforDto();
        List<Integer> favoriteList = new ArrayList<>();
        favoriteList.add(1);
        favoriteList.add(2);
        favoriteList.add(3);
        List<Integer> targetList = new ArrayList<>();
        targetList.add(1);
        targetList.add(2);
        targetList.add(3);
        extraInforDto.setImage("https://romanroadtrust.co.uk/wp-content/uploads/2018/01/profile-icon-png-898-300x300.png");
        extraInforDto.setMaritalStatus(true);
        extraInforDto.setFavoriteList(favoriteList);
        extraInforDto.setTargetList(targetList);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/guest/update", extraInforDto).param(null)
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Test cho trường hợp không tìm thấy Guest từ tham số userName = ""
    @Test
    public void createGuest_name_2() throws Exception {
        ExtraInforDto extraInforDto = new ExtraInforDto();
        List<Integer> favoriteList = new ArrayList<>();
        favoriteList.add(1);
        favoriteList.add(2);
        favoriteList.add(3);
        List<Integer> targetList = new ArrayList<>();
        targetList.add(1);
        targetList.add(2);
        targetList.add(3);
        extraInforDto.setImage("https://romanroadtrust.co.uk/wp-content/uploads/2018/01/profile-icon-png-898-300x300.png");
        extraInforDto.setMaritalStatus(true);
        extraInforDto.setFavoriteList(favoriteList);
        extraInforDto.setTargetList(targetList);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/guest/update", extraInforDto).param("")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Test cho trường hợp không tìm thấy Guest từ tham số userName
    @Test
    public void createGuest_name_3() throws Exception {
        ExtraInforDto extraInforDto = new ExtraInforDto();
        List<Integer> favoriteList = new ArrayList<>();
        favoriteList.add(1);
        favoriteList.add(2);
        favoriteList.add(3);
        List<Integer> targetList = new ArrayList<>();
        targetList.add(1);
        targetList.add(2);
        targetList.add(3);
        extraInforDto.setImage("https://romanroadtrust.co.uk/wp-content/uploads/2018/01/profile-icon-png-898-300x300.png");
        extraInforDto.setMaritalStatus(true);
        extraInforDto.setFavoriteList(favoriteList);
        extraInforDto.setTargetList(targetList);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/guest/update", extraInforDto).param("khoaVC123456789")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Test cho trường hợp thành công
    @Test
    public void createGuest_name_24() throws Exception {
        ExtraInforDto extraInforDto = new ExtraInforDto();
        List<Integer> favoriteList = new ArrayList<>();
        favoriteList.add(1);
        favoriteList.add(2);
        favoriteList.add(3);
        List<Integer> targetList = new ArrayList<>();
        targetList.add(1);
        targetList.add(2);
        targetList.add(3);
        extraInforDto.setImage("https://romanroadtrust.co.uk/wp-content/uploads/2018/01/profile-icon-png-898-300x300.png");
        extraInforDto.setMaritalStatus(true);
        extraInforDto.setFavoriteList(favoriteList);
        extraInforDto.setTargetList(targetList);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/guest/update", extraInforDto).param("khoaVC")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
