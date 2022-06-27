package api;

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
public class Search {

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
}
