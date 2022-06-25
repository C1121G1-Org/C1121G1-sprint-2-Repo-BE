package api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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
public class GuestRestController_Search {

    @Autowired
    private MockMvc mockMvc;



    @Test
    public void getListGuest_SearchKeyName1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("http://localhost:8080/api/guest/list?{keyName}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getListGuest_SearchKeyName2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("http://localhost:8080/api/guest/list?{keyName}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError())
        ;
    }


    @Test
    public void getListGuest_SearchKeyName3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("http://localhost:8080/api/guest/list?{keyName}", "123123a"))
                .andDo(print())
                .andExpect(status().is4xxClientError())
        ;
    }

    @Test
    public void getListGuest_SearchKeyName4() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("http://localhost:8080/api/guest/list?{keyName}", "khoa"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.totalPages").value(1))
                .andExpect(jsonPath("$.content[1].name").value("Võ Công Khoa"))
                .andExpect(jsonPath("$.content[1].dateOfBirth").value("1993-12-10"))
                .andExpect(jsonPath("$.content[1].address").value("Đại Lộc, Quảng Nam"))
                .andExpect(jsonPath("$.content[1].gender").value(1))
                .andExpect(jsonPath("$.content[1].career").value("IT"))
                .andExpect(jsonPath("$.content[1].favorite.id").value(2));

    }



    @Test
    public void getListGuest_SearchKeyYear1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("http://localhost:8080/api/guest/list?{keyYearOfBirth}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getListGuest_SearchKeyYear2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("http://localhost:8080/api/guest/list?{keyYearOfBirth}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError())
        ;
    }


    @Test
    public void getListGuest_SearchKeyYear3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("http://localhost:8080/api/guest/list?{keyYearOfBirth}", "2003"))
                .andDo(print())
                .andExpect(status().is4xxClientError())
        ;
    }

    @Test
    public void getListGuest_SearchKeyYear4() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("http://localhost:8080/api/guest/list?{keyYearOfBirth}", "1993"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.totalPages").value(1))
                .andExpect(jsonPath("$.content[1].name").value("Võ Công Khoa"))
                .andExpect(jsonPath("$.content[1].dateOfBirth").value("1993-12-10"))
                .andExpect(jsonPath("$.content[1].address").value("Đại Lộc, Quảng Nam"))
                .andExpect(jsonPath("$.content[1].gender").value(1))
                .andExpect(jsonPath("$.content[1].career").value("IT"))
                .andExpect(jsonPath("$.content[1].favorite.id").value(2));

    }

    @Test
    public void getListGuest_SearchKeyAddress1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("http://localhost:8080/api/guest/list?{keyAddress}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getListGuest_SearchKeyAddress2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("http://localhost:8080/api/guest/list?{keyAddress}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError())
        ;
    }


    @Test
    public void getListGuest_SearchKeyAddress3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("http://localhost:8080/api/guest/list?{keyAddress}", "Tứ Xuyên"))
                .andDo(print())
                .andExpect(status().is4xxClientError())
        ;
    }

    @Test
    public void getListGuest_SearchKeyAddress4() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("http://localhost:8080/api/guest/list?{keyAddress}", "Quảng Nam"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.totalPages").value(1))
                .andExpect(jsonPath("$.content[1].name").value("Võ Công Khoa"))
                .andExpect(jsonPath("$.content[1].dateOfBirth").value("1993-12-10"))
                .andExpect(jsonPath("$.content[1].address").value("Đại Lộc, Quảng Nam"))
                .andExpect(jsonPath("$.content[1].gender").value(1))
                .andExpect(jsonPath("$.content[1].career").value("IT"))
                .andExpect(jsonPath("$.content[1].favorite.id").value(2));

    }
    @Test
    public void getListGuest_SearchKeyGender1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("http://localhost:8080/api/guest/list?{keyGender}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getListGuest_SearchKeyGender2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("http://localhost:8080/api/guest/list?{keyGender}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError())
        ;
    }


    @Test
    public void getListGuest_SearchKeyGender3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("http://localhost:8080/api/guest/list?{keyGender}", "3"))
                .andDo(print())
                .andExpect(status().is4xxClientError())
        ;
    }

    @Test
    public void getListGuest_SearchKeyGender4() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("http://localhost:8080/api/guest/list?{keyGender}", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.totalPages").value(1))
                .andExpect(jsonPath("$.content[1].name").value("Võ Công Khoa"))
                .andExpect(jsonPath("$.content[1].dateOfBirth").value("1993-12-10"))
                .andExpect(jsonPath("$.content[1].address").value("Đại Lộc, Quảng Nam"))
                .andExpect(jsonPath("$.content[1].gender").value(1))
                .andExpect(jsonPath("$.content[1].career").value("IT"))
                .andExpect(jsonPath("$.content[1].favorite.id").value(2));

    }
    @Test
    public void getListGuest_SearchKeyCareer1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("http://localhost:8080/api/guest/list?{keyCareer}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getListGuest_SearchKeyCareer2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("http://localhost:8080/api/guest/list?{keyCareer}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError())
        ;
    }


    @Test
    public void getListGuest_SearchKeyCareer3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("http://localhost:8080/api/guest/list?{keyCareer}", "Nông"))
                .andDo(print())
                .andExpect(status().is4xxClientError())
        ;
    }

    @Test
    public void getListGuest_SearchKeyCareer4() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("http://localhost:8080/api/guest/list?{keyCareer}", "IT"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.totalPages").value(1))
                .andExpect(jsonPath("$.content[1].name").value("Võ Công Khoa"))
                .andExpect(jsonPath("$.content[1].dateOfBirth").value("1993-12-10"))
                .andExpect(jsonPath("$.content[1].address").value("Đại Lộc, Quảng Nam"))
                .andExpect(jsonPath("$.content[1].gender").value(1))
                .andExpect(jsonPath("$.content[1].career").value("IT"))
                .andExpect(jsonPath("$.content[1].favorite.id").value(2));

    }

    @Test
    public void getListGuest_SearchKeyFavorite1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("http://localhost:8080/api/guest/list?{KeyFavorite}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getListGuest_SearchKeyFavorite2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("http://localhost:8080/api/guest/list?{KeyFavorite}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError())
        ;
    }


    @Test
    public void getListGuest_SearchKeyFavorite3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("http://localhost:8080/api/guest/list?{KeyFavorite}", "11"))
                .andDo(print())
                .andExpect(status().is4xxClientError())
        ;
    }

    @Test
    public void getListGuest_SearchKeyFavorite4() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("http://localhost:8080/api/guest/list?{KeyFavorite}", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.totalPages").value(1))
                .andExpect(jsonPath("$.content[1].name").value("Võ Công Khoa"))
                .andExpect(jsonPath("$.content[1].dateOfBirth").value("1993-12-10"))
                .andExpect(jsonPath("$.content[1].address").value("Đại Lộc, Quảng Nam"))
                .andExpect(jsonPath("$.content[1].gender").value(1))
                .andExpect(jsonPath("$.content[1].career").value("IT"))
                .andExpect(jsonPath("$.content[1].favorite.id").value(2));

    }

}
