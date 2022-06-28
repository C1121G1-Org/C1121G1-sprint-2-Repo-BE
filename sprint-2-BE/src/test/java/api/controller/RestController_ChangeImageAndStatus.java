package api.controller;


import api.dto.AccountDto;
import api.dto.GuestDto;
import api.models.Account;
import api.models.Guest;
import api.services.IAccountService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class RestController_ChangeImageAndStatus {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;



    //test id=null, return error
    @Test
    public void getGuest_id_null() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/api/Guest/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //test id="", return error
    @Test
    public void getGuest_id_empty() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/api/Guest/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //test id=4, return object
    @Test
    public void getGuest_id_4() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/api/Guest/{id}", "4"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.address").value("52 Trương Đình Nghệ"))
                .andExpect(jsonPath("$.career").value("Giáo viên"))
                .andExpect(jsonPath("$.date_of_birth").value("2022-10-12"))
                .andExpect(jsonPath("$.delete_flag").value(1))
                .andExpect(jsonPath("$.email").value("hoangtn97@gmail.com"))
                .andExpect(jsonPath("$.gender").value(1))
                .andExpect(jsonPath("$.image").value("https://loveaodai.com/wp-content/uploads/2021/04/Ao-dai-hoa-loa-ken-13.jpg"))
                .andExpect(jsonPath("$.marital_status").value(1))
                .andExpect(jsonPath("$.name").value("Huy Hoàng"))
                .andExpect(jsonPath("$.account_id").value(1));
    }

    //test right isLogin
    @Test
    public void editAccount_isLogin_right() throws Exception {

        GuestDto guestDto=new GuestDto();
        AccountDto accountDto=new AccountDto();

        accountDto.setId("1");
        accountDto.setEncryptPassword("25f9e794323b453885f5181f1b624d0b");
        accountDto.setIsEnabled("1");
        accountDto.setIsLogin("0");
        accountDto.setUserName("KhoaVC");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/account/edit")
                        .content(this.objectMapper.writeValueAsString(AccountDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    //test 6mb size img (oversize)
    @Test
    public void editGuest_img_oversize() throws Exception {
        GuestDto guestDto=new GuestDto();

        guestDto.setId("1");
        guestDto.setAddress("Đại Lộc, Quảng Nam");
        guestDto.setCareer("IT");
        guestDto.setDateOfBirth("1993-12-10");
        guestDto.setDeleteFlag("0");
        guestDto.setEmail("youandme8668@gmail.com");
        guestDto.setGender("1");
        guestDto.setName("Võ Công Khoa");
        guestDto.setImg("https://images.squarespace-cdn.com/content/v1/58290f14d1758e699d957c28/1480717146986-6NRZ2IL5OQKU8OU9TNTT/04+-+Oregon+Clearcut+20160418+5mb-pano-18-16x9.jpg?format=1500w");
        //this image is 6mb size


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/guest/edit")
                        .content(this.objectMapper.writeValueAsString(guestDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //test null image
    @Test
    public void editGuest_image_null() throws Exception {

        GuestDto guestDto=new GuestDto();

        guestDto.setId("1");
        guestDto.setAddress("Đại Lộc, Quảng Nam");
        guestDto.setCareer("IT");
        guestDto.setDateOfBirth("1993-12-10");
        guestDto.setDeleteFlag("0");
        guestDto.setEmail("youandme8668@gmail.com");
        guestDto.setGender("1");
        guestDto.setName("Võ Công Khoa");
        guestDto.setImg(null);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/customer/edit")
                        .content(this.objectMapper.writeValueAsString(guestDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //test right Image
    @Test
    public void editGuest_Image_right() throws Exception {

        GuestDto guestDto=new GuestDto();

        guestDto.setId("1");
        guestDto.setAddress("Đại Lộc, Quảng Nam");
        guestDto.setCareer("IT");
        guestDto.setDateOfBirth("1993-12-10");
        guestDto.setDeleteFlag("0");
        guestDto.setEmail("youandme8668@gmail.com");
        guestDto.setGender("1");
        guestDto.setName("Võ Công Khoa");
        guestDto.setImg("https://images.squarespace-cdn.com/content/v1/58290f14d1758e699d957c28/1480717146986-6NRZ2IL5OQKU8OU9TNTT/04+-+Oregon+Clearcut+20160418+5mb-pano-18-16x9.jpg?format=1500w");



        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/Guest/edit")
                        .content(this.objectMapper.writeValueAsString(GuestDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }



}
