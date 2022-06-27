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
public class PostReportRestController_ListPostReport {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    //Case list size=0
    @Test
    public void getListPostReport_size0() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/postReport/list"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//    Long getPostId();
//    String getGuestName();
//    String getDateReport();
//    String getReportName();
//    Long getReportPeople();
//    String getReportedPeopleName();

    //Case list size=15, 5 elements per page
    @Test
    public void getListPostReport_sizeNotNull() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/postReport/list"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.totalPages").value(5))
                .andExpect(jsonPath("$.totalElements").value(15))
                .andExpect(jsonPath("$.content[2].guestName").value("Đặng Quang Huy"))
                .andExpect(jsonPath("$.content[2].dateReport").value("2022-06-02"))
                .andExpect(jsonPath("$.content[2].reportName").value("Commit chửi thề, gây hiềm khích với các thành viên khác."))
                .andExpect(jsonPath("$.content[2].reportPeople").value("Võ Công Khoa"))
        ;
    }

    //input search key guestName =2@, wrong type of search
    @Test
    public void getListPostReport_SearchFall1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/postReport/list?guestName=2@"))
                .andDo(print())
                .andExpect(status().is4xxClientError())
        ;
    }

    //Input search = khoa, right input search
    @Test
    public void getListPostReport_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/postReport/list/?guestName=khoa"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.totalPages").value(1))
                .andExpect(jsonPath("$.totalElements").value(1))
                .andExpect(jsonPath("$.content[2].guestName").value("Võ Công Khoa"))
                .andExpect(jsonPath("$.content[2].dateReport").value("2022-02-11"))
                .andExpect(jsonPath("$.content[2].reportName").value("Commit chửi thề, gây hiềm khích với các thành viên khác."))
                .andExpect(jsonPath("$.content[2].reportPeople").value("Đặng Quang Huy"));
    }

    //input search key dateReport =@, wrong type of search
    @Test
    public void getListPostReport_SearchFall1_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/postReport/list?dateReport=2@"))
                .andDo(print())
                .andExpect(status().is4xxClientError())
        ;
    }

    //Input search = 2022-02-11, right input search
    @Test
    public void getListPostReport_10() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/postReport/list/?dateReport=khoa"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.totalPages").value(1))
                .andExpect(jsonPath("$.totalElements").value(1))
                .andExpect(jsonPath("$.content[2].guestName").value("Võ Công Khoa"))
                .andExpect(jsonPath("$.content[2].dateReport").value("2022-02-11"))
                .andExpect(jsonPath("$.content[2].reportName").value("Commit chửi thề, gây hiềm khích với các thành viên khác."))
                .andExpect(jsonPath("$.content[2].reportPeople").value("Đặng Quang Huy"));
    }

    //input search key reportName =@@@, wrong type of search
    @Test
    public void getListPostReport_SearchFall1_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/postReport/list?reportName=@@@"))
                .andDo(print())
                .andExpect(status().is4xxClientError())
        ;
    }

    //Input search = Commit chửi thề, right input search
    @Test
    public void getListPostReport_12() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/postReport/list/?reportName=Commit chửi thề"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.totalPages").value(1))
                .andExpect(jsonPath("$.totalElements").value(1))
                .andExpect(jsonPath("$.content[2].guestName").value("Võ Công Khoa"))
                .andExpect(jsonPath("$.content[2].dateReport").value("2022-02-11"))
                .andExpect(jsonPath("$.content[2].reportName").value("Commit chửi thề, gây hiềm khích với các thành viên khác."))
                .andExpect(jsonPath("$.content[2].reportPeople").value("Đặng Quang Huy"));
    }

    //input search key reportName =khoa, wrong type of search
    @Test
    public void getListPostReport_SearchFall1_13() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/postReport/list?reportPeople=2@"))
                .andDo(print())
                .andExpect(status().is4xxClientError())
        ;
    }


    //Input search = khoa, right input search
    @Test
    public void getListPostReport_14() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/postReport/list/?reportPeople=khoa"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.totalPages").value(1))
                .andExpect(jsonPath("$.totalElements").value(1))
                .andExpect(jsonPath("$.content[2].guestName").value("Đặng Quang Huy"))
                .andExpect(jsonPath("$.content[2].dateReport").value("2022-02-11"))
                .andExpect(jsonPath("$.content[2].reportName").value("Commit chửi thề, gây hiềm khích với các thành viên khác."))
                .andExpect(jsonPath("$.content[2].reportPeople").value("Võ Công Khoa"));
    }
}
