package api.controllers;

import api.dto.GuestDto;
import api.models.Account;
import api.models.AccountRole;
import api.models.Guest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class GuestRestController_createGuest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    //Test cho trường hợp name = null
    @Test
    public void createGuest_name_13() throws Exception {
        GuestDto guestDto = new GuestDto();
        guestDto.setName(null);
        guestDto.setDateOfBirth("01/01/1993");
        guestDto.setAddress("Cẩm Lệ, Đà Nẵng");
        guestDto.setUserName("khoakhoaVCVC");
        guestDto.setCreateDate("27/06/2022");
        guestDto.setCareer("Game Developer");
        guestDto.setGender(true);
        guestDto.setPassword("123456789");
        guestDto.setEmail("abac@gmail.com");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/guest/create")
                        .content(this.objectMapper.writeValueAsString(guestDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Test cho trường hợp name = ""
    @Test
    public void createGuest_name_14() throws Exception {
        GuestDto guestDto = new GuestDto();
        guestDto.setName("");
        guestDto.setDateOfBirth("01/01/1993");
        guestDto.setAddress("Cẩm Lệ, Đà Nẵng");
        guestDto.setUserName("khoakhoaVCVC");
        guestDto.setCreateDate("27/06/2022");
        guestDto.setCareer("Game Developer");
        guestDto.setGender(true);
        guestDto.setPassword("123456789");
        guestDto.setEmail("abac@gmail.com");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/guest/create")
                        .content(this.objectMapper.writeValueAsString(guestDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Test cho trường hợp name chứa ký tự đặc biệt
    @Test
    public void createGuest_name_15() throws Exception {
        GuestDto guestDto = new GuestDto();
        guestDto.setName("khoa@!#$%");
        guestDto.setDateOfBirth("01/01/1993");
        guestDto.setAddress("Cẩm Lệ, Đà Nẵng");
        guestDto.setUserName("khoakhoaVCVC");
        guestDto.setCreateDate("27/06/2022");
        guestDto.setCareer("Game Developer");
        guestDto.setGender(true);
        guestDto.setPassword("123456789");
        guestDto.setEmail("abac@gmail.com");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/guest/create")
                        .content(this.objectMapper.writeValueAsString(guestDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Test cho trường hợp name ít hơn 6 ký tự
    @Test
    public void createGuest_name_16() throws Exception {
        GuestDto guestDto = new GuestDto();
        guestDto.setName("khoa");
        guestDto.setDateOfBirth("01/01/1993");
        guestDto.setAddress("Cẩm Lệ, Đà Nẵng");
        guestDto.setUserName("khoakhoaVCVC");
        guestDto.setCreateDate("27/06/2022");
        guestDto.setCareer("Game Developer");
        guestDto.setGender(true);
        guestDto.setPassword("123456789");
        guestDto.setEmail("abac@gmail.com");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/guest/create")
                        .content(this.objectMapper.writeValueAsString(guestDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Test cho trường hợp name nhiều hơn 32 ký tự
    @Test
    public void createGuest_name_17() throws Exception {
        GuestDto guestDto = new GuestDto();
        guestDto.setName("khoakhoakhoakhoakhoakhoakhoakhoakhoakhoa");
        guestDto.setDateOfBirth("01/01/1993");
        guestDto.setAddress("Cẩm Lệ, Đà Nẵng");
        guestDto.setUserName("khoakhoaVCVC");
        guestDto.setCreateDate("27/06/2022");
        guestDto.setCareer("Game Developer");
        guestDto.setGender(true);
        guestDto.setPassword("123456789");
        guestDto.setEmail("abac@gmail.com");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/guest/create")
                        .content(this.objectMapper.writeValueAsString(guestDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    //Test cho trường hợp userName = null
    @Test
    public void createGuest_userName_13() throws Exception {
        GuestDto guestDto = new GuestDto();
        guestDto.setName("khoaVC2Valid");
        guestDto.setDateOfBirth("01/01/1993");
        guestDto.setAddress("Cẩm Lệ, Đà Nẵng");
        guestDto.setUserName(null);
        guestDto.setCreateDate("27/06/2022");
        guestDto.setCareer("Game Developer");
        guestDto.setGender(true);
        guestDto.setPassword("123456789");
        guestDto.setEmail("abac@gmail.com");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/guest/create")
                        .content(this.objectMapper.writeValueAsString(guestDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Test cho trường hợp userName = ""
    @Test
    public void createGuest_userName_14() throws Exception {
        GuestDto guestDto = new GuestDto();
        guestDto.setName("khoaVC2Valid");
        guestDto.setDateOfBirth("01/01/1993");
        guestDto.setAddress("Cẩm Lệ, Đà Nẵng");
        guestDto.setUserName("");
        guestDto.setCreateDate("27/06/2022");
        guestDto.setCareer("Game Developer");
        guestDto.setGender(true);
        guestDto.setPassword("123456789");
        guestDto.setEmail("abac@gmail.com");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/guest/create")
                        .content(this.objectMapper.writeValueAsString(guestDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Test cho trường hợp userName chứa ký tự đặc biệt
    @Test
    public void createGuest_userName_15() throws Exception {
        GuestDto guestDto = new GuestDto();
        guestDto.setName("khoaVC2Valid");
        guestDto.setDateOfBirth("01/01/1993");
        guestDto.setAddress("Cẩm Lệ, Đà Nẵng");
        guestDto.setUserName("khoakhoaVCVC@!#$");
        guestDto.setCreateDate("27/06/2022");
        guestDto.setCareer("Game Developer");
        guestDto.setGender(true);
        guestDto.setPassword("123456789");
        guestDto.setEmail("abac@gmail.com");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/guest/create")
                        .content(this.objectMapper.writeValueAsString(guestDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Test cho trường hợp userName ít hơn 6 ký tự
    @Test
    public void createGuest_userName_16() throws Exception {
        GuestDto guestDto = new GuestDto();
        guestDto.setName("khoaVC2Valid");
        guestDto.setDateOfBirth("01/01/1993");
        guestDto.setAddress("Cẩm Lệ, Đà Nẵng");
        guestDto.setUserName("khoa");
        guestDto.setCreateDate("27/06/2022");
        guestDto.setCareer("Game Developer");
        guestDto.setGender(true);
        guestDto.setPassword("123456789");
        guestDto.setEmail("abac@gmail.com");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/guest/create")
                        .content(this.objectMapper.writeValueAsString(guestDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Test cho trường hợp userName nhiều hơn 32 ký tự
    @Test
    public void createGuest_userName_17() throws Exception {
        GuestDto guestDto = new GuestDto();
        guestDto.setName("khoaVC2Valid");
        guestDto.setDateOfBirth("01/01/1993");
        guestDto.setAddress("Cẩm Lệ, Đà Nẵng");
        guestDto.setUserName("khoakhoaVCVCkhoakhoaVCVCkhoakhoaVCVCkhoakhoaVCVCkhoakhoaVCVCkhoakhoaVCVCkhoakhoaVCVCkhoakhoaVCVC");
        guestDto.setCreateDate("27/06/2022");
        guestDto.setCareer("Game Developer");
        guestDto.setGender(true);
        guestDto.setPassword("123456789");
        guestDto.setEmail("abac@gmail.com");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/guest/create")
                        .content(this.objectMapper.writeValueAsString(guestDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Test cho trường hợp userName đã tồn tại
    @Test
    public void createGuest_userName_duplicate() throws Exception {
        GuestDto guestDto = new GuestDto();
        guestDto.setName("khoaVC2Valid");
        guestDto.setDateOfBirth("01/01/1993");
        guestDto.setAddress("Cẩm Lệ, Đà Nẵng");
        guestDto.setUserName("khoaVC");
        guestDto.setCreateDate("27/06/2022");
        guestDto.setCareer("Game Developer");
        guestDto.setGender(true);
        guestDto.setPassword("123456789");
        guestDto.setEmail("abac@gmail.com");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/guest/create")
                        .content(this.objectMapper.writeValueAsString(guestDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Test cho trường hợp password = null
    @Test
    public void createGuest_password_13() throws Exception {
        GuestDto guestDto = new GuestDto();
        guestDto.setName("khoaVC2Valid");
        guestDto.setDateOfBirth("01/01/1993");
        guestDto.setAddress("Cẩm Lệ, Đà Nẵng");
        guestDto.setUserName("khoakhoaVCVC");
        guestDto.setCreateDate("27/06/2022");
        guestDto.setCareer("Game Developer");
        guestDto.setGender(true);
        guestDto.setPassword(null);
        guestDto.setEmail("abac@gmail.com");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/guest/create")
                        .content(this.objectMapper.writeValueAsString(guestDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Test cho trường hợp password = ""
    @Test
    public void createGuest_password_14() throws Exception {
        GuestDto guestDto = new GuestDto();
        guestDto.setName("khoaVC2Valid");
        guestDto.setDateOfBirth("01/01/1993");
        guestDto.setAddress("Cẩm Lệ, Đà Nẵng");
        guestDto.setUserName("khoakhoaVCVC");
        guestDto.setCreateDate("27/06/2022");
        guestDto.setCareer("Game Developer");
        guestDto.setGender(true);
        guestDto.setPassword("");
        guestDto.setEmail("abac@gmail.com");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/guest/create")
                        .content(this.objectMapper.writeValueAsString(guestDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Test cho trường hợp password chứa ký tự đặc biệt
    @Test
    public void createGuest_password_15() throws Exception {
        GuestDto guestDto = new GuestDto();
        guestDto.setName("khoaVC2Valid");
        guestDto.setDateOfBirth("01/01/1993");
        guestDto.setAddress("Cẩm Lệ, Đà Nẵng");
        guestDto.setUserName("khoakhoaVCVC");
        guestDto.setCreateDate("27/06/2022");
        guestDto.setCareer("Game Developer");
        guestDto.setGender(true);
        guestDto.setPassword("123456789@!#$%");
        guestDto.setEmail("abac@gmail.com");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/guest/create")
                        .content(this.objectMapper.writeValueAsString(guestDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Test cho trường hợp password ít hơn 6 ký tự
    @Test
    public void createGuest_password_16() throws Exception {
        GuestDto guestDto = new GuestDto();
        guestDto.setName("khoaVC2Valid");
        guestDto.setDateOfBirth("01/01/1993");
        guestDto.setAddress("Cẩm Lệ, Đà Nẵng");
        guestDto.setUserName("khoakhoaVCVC");
        guestDto.setCreateDate("27/06/2022");
        guestDto.setCareer("Game Developer");
        guestDto.setGender(true);
        guestDto.setPassword("1234");
        guestDto.setEmail("abac@gmail.com");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/guest/create")
                        .content(this.objectMapper.writeValueAsString(guestDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Test cho trường hợp password nhiều hơn 32 ký tự
    @Test
    public void createGuest_password_17() throws Exception {
        GuestDto guestDto = new GuestDto();
        guestDto.setName("khoaVC2Valid");
        guestDto.setDateOfBirth("01/01/1993");
        guestDto.setAddress("Cẩm Lệ, Đà Nẵng");
        guestDto.setUserName("khoakhoaVCVC");
        guestDto.setCreateDate("27/06/2022");
        guestDto.setCareer("Game Developer");
        guestDto.setGender(true);
        guestDto.setPassword("123456789123456789123456789123456789123456789123456789123456789123456789");
        guestDto.setEmail("abac@gmail.com");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/guest/create")
                        .content(this.objectMapper.writeValueAsString(guestDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Test cho trường hợp email = null
    @Test
    public void createGuest_email_13() throws Exception {
        GuestDto guestDto = new GuestDto();
        guestDto.setName("khoaVC2Valid");
        guestDto.setDateOfBirth("01/01/1993");
        guestDto.setAddress("Cẩm Lệ, Đà Nẵng");
        guestDto.setUserName("khoakhoaVCVC");
        guestDto.setCreateDate("27/06/2022");
        guestDto.setCareer("Game Developer");
        guestDto.setGender(true);
        guestDto.setPassword("123456789");
        guestDto.setEmail(null);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/guest/create")
                        .content(this.objectMapper.writeValueAsString(guestDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Test cho trường hợp email = ""
    @Test
    public void createGuest_email_14() throws Exception {
        GuestDto guestDto = new GuestDto();
        guestDto.setName("khoaVC2Valid");
        guestDto.setDateOfBirth("01/01/1993");
        guestDto.setAddress("Cẩm Lệ, Đà Nẵng");
        guestDto.setUserName("khoakhoaVCVC");
        guestDto.setCreateDate("27/06/2022");
        guestDto.setCareer("Game Developer");
        guestDto.setGender(true);
        guestDto.setPassword("123456789");
        guestDto.setEmail("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/guest/create")
                        .content(this.objectMapper.writeValueAsString(guestDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Test cho trường hợp email không đúng định dạng
    @Test
    public void createGuest_email_15() throws Exception {
        GuestDto guestDto = new GuestDto();
        guestDto.setName("khoaVC2Valid");
        guestDto.setDateOfBirth("01/01/1993");
        guestDto.setAddress("Cẩm Lệ, Đà Nẵng");
        guestDto.setUserName("khoakhoaVCVC");
        guestDto.setCreateDate("27/06/2022");
        guestDto.setCareer("Game Developer");
        guestDto.setGender(true);
        guestDto.setPassword("123456789");
        guestDto.setEmail("abac.com");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/guest/create")
                        .content(this.objectMapper.writeValueAsString(guestDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Test cho trường hợp email đã tồn tại
    @Test
    public void createGuest_email_duplicate() throws Exception {
        GuestDto guestDto = new GuestDto();
        guestDto.setName("khoaVC2Valid");
        guestDto.setDateOfBirth("01/01/1993");
        guestDto.setAddress("Cẩm Lệ, Đà Nẵng");
        guestDto.setUserName("khoaVC3Valid");
        guestDto.setCreateDate("27/06/2022");
        guestDto.setCareer("Game Developer");
        guestDto.setGender(true);
        guestDto.setPassword("123456789");
        guestDto.setEmail("khoaVC@gmail.com");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/guest/create")
                        .content(this.objectMapper.writeValueAsString(guestDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Test cho trường hợp dateOfBirth = null
    @Test
    public void createGuest_dateOfBirth_13() throws Exception {
        GuestDto guestDto = new GuestDto();
        guestDto.setName("khoaVC2Valid");
        guestDto.setDateOfBirth(null);
        guestDto.setAddress("Cẩm Lệ, Đà Nẵng");
        guestDto.setUserName("khoakhoaVCVC");
        guestDto.setCreateDate("27/06/2022");
        guestDto.setCareer("Game Developer");
        guestDto.setGender(true);
        guestDto.setPassword("123456789");
        guestDto.setEmail("abc@gmail.com");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/guest/create")
                        .content(this.objectMapper.writeValueAsString(guestDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Test cho trường hợp dateOfBirth = ""
    @Test
    public void createGuest_dateOfBirth_14() throws Exception {
        GuestDto guestDto = new GuestDto();
        guestDto.setName("khoaVC2Valid");
        guestDto.setDateOfBirth("");
        guestDto.setAddress("Cẩm Lệ, Đà Nẵng");
        guestDto.setUserName("khoakhoaVCVC");
        guestDto.setCreateDate("27/06/2022");
        guestDto.setCareer("Game Developer");
        guestDto.setGender(true);
        guestDto.setPassword("123456789");
        guestDto.setEmail("abc@gmail.com");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/guest/create")
                        .content(this.objectMapper.writeValueAsString(guestDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Test cho trường hợp dateOfBirth <= 01-01-1800
    @Test
    public void createGuest_dateOfBirth_16() throws Exception {
        GuestDto guestDto = new GuestDto();
        guestDto.setName("khoaVC2Valid");
        guestDto.setDateOfBirth("01/01/1555");
        guestDto.setAddress("Cẩm Lệ, Đà Nẵng");
        guestDto.setUserName("khoakhoaVCVC");
        guestDto.setCreateDate("27/06/2022");
        guestDto.setCareer("Game Developer");
        guestDto.setGender(true);
        guestDto.setPassword("123456789");
        guestDto.setEmail("abc@gmail.com");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/guest/create")
                        .content(this.objectMapper.writeValueAsString(guestDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Test cho trường hợp dateOfBirth ít hơn 18 tuổi
    @Test
    public void createGuest_dateOfBirth_17() throws Exception {
        GuestDto guestDto = new GuestDto();
        guestDto.setName("khoaVC2Valid");
        guestDto.setDateOfBirth("01/01/2021");
        guestDto.setAddress("Cẩm Lệ, Đà Nẵng");
        guestDto.setUserName("khoakhoaVCVC");
        guestDto.setCreateDate("27/06/2022");
        guestDto.setCareer("Game Developer");
        guestDto.setGender(true);
        guestDto.setPassword("123456789");
        guestDto.setEmail("abc@gmail.com");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/guest/create")
                        .content(this.objectMapper.writeValueAsString(guestDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Test cho trường hợp createDate = null
    @Test
    public void createGuest_createDate_13() throws Exception {
        GuestDto guestDto = new GuestDto();
        guestDto.setName("khoaVC2Valid");
        guestDto.setDateOfBirth("27/06/1993");
        guestDto.setAddress("Cẩm Lệ, Đà Nẵng");
        guestDto.setUserName("khoakhoaVCVC");
        guestDto.setCreateDate(null);
        guestDto.setCareer("Game Developer");
        guestDto.setGender(true);
        guestDto.setPassword("123456789");
        guestDto.setEmail("abc@gmail.com");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/guest/create")
                        .content(this.objectMapper.writeValueAsString(guestDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Test cho trường hợp createDate = ""
    @Test
    public void createGuest_createDate_14() throws Exception {
        GuestDto guestDto = new GuestDto();
        guestDto.setName("khoaVC2Valid");
        guestDto.setDateOfBirth("27/06/1993");
        guestDto.setAddress("Cẩm Lệ, Đà Nẵng");
        guestDto.setUserName("khoakhoaVCVC");
        guestDto.setCreateDate("");
        guestDto.setCareer("Game Developer");
        guestDto.setGender(true);
        guestDto.setPassword("123456789");
        guestDto.setEmail("abc@gmail.com");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/guest/create")
                        .content(this.objectMapper.writeValueAsString(guestDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Test cho trường hợp createDate <= ngày hôm nay
    @Test
    public void createGuest_createDate_16() throws Exception {
        GuestDto guestDto = new GuestDto();
        guestDto.setName("khoaVC2Valid");
        guestDto.setDateOfBirth("27/06/1993");
        guestDto.setAddress("Cẩm Lệ, Đà Nẵng");
        guestDto.setUserName("khoakhoaVCVC");
        guestDto.setCreateDate("27/06/2022");
        guestDto.setCareer("Game Developer");
        guestDto.setGender(true);
        guestDto.setPassword("123456789");
        guestDto.setEmail("abc@gmail.com");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/guest/create")
                        .content(this.objectMapper.writeValueAsString(guestDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Test cho trường hợp address = null
    @Test
    public void createGuest_address_13() throws Exception {
        GuestDto guestDto = new GuestDto();
        guestDto.setName("khoaVC2Valid");
        guestDto.setDateOfBirth("27/06/1993");
        guestDto.setAddress(null);
        guestDto.setUserName("khoakhoaVCVC");
        guestDto.setCreateDate("27/06/2022");
        guestDto.setCareer("Game Developer");
        guestDto.setGender(true);
        guestDto.setPassword("123456789");
        guestDto.setEmail("abc@gmail.com");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/guest/create")
                        .content(this.objectMapper.writeValueAsString(guestDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Test cho trường hợp address = ""
    @Test
    public void createGuest_address_14() throws Exception {
        GuestDto guestDto = new GuestDto();
        guestDto.setName("khoaVC2Valid");
        guestDto.setDateOfBirth("27/06/1993");
        guestDto.setAddress("");
        guestDto.setUserName("khoakhoaVCVC");
        guestDto.setCreateDate("27/06/2022");
        guestDto.setCareer("Game Developer");
        guestDto.setGender(true);
        guestDto.setPassword("123456789");
        guestDto.setEmail("abc@gmail.com");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/guest/create")
                        .content(this.objectMapper.writeValueAsString(guestDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Test cho trường hợp career = null
    @Test
    public void createGuest_career_13() throws Exception {
        GuestDto guestDto = new GuestDto();
        guestDto.setName("khoaVC2Valid");
        guestDto.setDateOfBirth("27/06/1993");
        guestDto.setAddress("Cẩm Lệ, Đà Nẵng");
        guestDto.setUserName("khoakhoaVCVC");
        guestDto.setCreateDate("27/06/2022");
        guestDto.setCareer(null);
        guestDto.setGender(true);
        guestDto.setPassword("123456789");
        guestDto.setEmail("abc@gmail.com");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/guest/create")
                        .content(this.objectMapper.writeValueAsString(guestDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Test cho trường hợp career = ""
    @Test
    public void createGuest_career_14() throws Exception {
        GuestDto guestDto = new GuestDto();
        guestDto.setName("khoaVC2Valid");
        guestDto.setDateOfBirth("27/06/1993");
        guestDto.setAddress("Cẩm Lệ, Đà Nẵng");
        guestDto.setUserName("khoakhoaVCVC");
        guestDto.setCreateDate("27/06/2022");
        guestDto.setCareer("");
        guestDto.setGender(true);
        guestDto.setPassword("123456789");
        guestDto.setEmail("abc@gmail.com");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/guest/create")
                        .content(this.objectMapper.writeValueAsString(guestDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Test cho trường hợp gender = null
    @Test
    public void createGuest_gender_13() throws Exception {
        GuestDto guestDto = new GuestDto();
        guestDto.setName("khoaVC2Valid");
        guestDto.setDateOfBirth("27/06/1993");
        guestDto.setAddress("Cẩm Lệ, Đà Nẵng");
        guestDto.setUserName("khoakhoaVCVC");
        guestDto.setCreateDate("27/06/2022");
        guestDto.setCareer("Game Developer");
        guestDto.setGender(null);
        guestDto.setPassword("123456789");
        guestDto.setEmail("abc@gmail.com");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/guest/create")
                        .content(this.objectMapper.writeValueAsString(guestDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Test cho trường hợp thành công
    @Test
    public void createGuest_name_18() throws Exception {
        GuestDto guestDto = new GuestDto();
        guestDto.setName("khoaVCValid");
        guestDto.setDateOfBirth("01/01/1993");
        guestDto.setAddress("Cẩm Lệ, Đà Nẵng");
        guestDto.setUserName("khoakhoaVCVC");
        guestDto.setCreateDate("27/06/2022");
        guestDto.setCareer("Game Developer");
        guestDto.setGender(true);
        guestDto.setPassword("123456789");
        guestDto.setEmail("abac@gmail.com");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/guest/create")
                        .content(this.objectMapper.writeValueAsString(guestDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
