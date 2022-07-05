package api;

import api.controllers.GuestRestController;
import api.dto.IGuestDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

@SpringBootTest
@AutoConfigureMockMvc
public class GuestRestController_getAllMember {

    @Autowired
    private GuestRestController guestRestController;

//    @Test
//    public void findAllGuest_1() {
//        ResponseEntity<Page<IGuestDto>> responseEntity = this.guestRestController.getAllMember( null,0);
//        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
//    }
//
//    @Test
//    public void findAllGuest_2() {
//        ResponseEntity<Page<IGuestDto>> responseEntity = this.guestRestController.getAllMember("",  0);
//        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
//    }
//
//    @Test
//    public void findAllGuest_3() {
//        ResponseEntity<Page<IGuestDto>> responseEntity = this.guestRestController.getAllMember("Không Tồn Tại",  0);
//        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
//    }
//
//    @Test
//    public void findAllGuest_4() {
//        ResponseEntity<Page<IGuestDto>> responseEntity = this.guestRestController.getAllMember("Lê",  0);
//        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
//    }

}