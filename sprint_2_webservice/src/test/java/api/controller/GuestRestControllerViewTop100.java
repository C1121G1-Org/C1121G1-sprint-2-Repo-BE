package api.controller;

import api.dto.Top100Dto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

@SpringBootTest
@AutoConfigureMockMvc

class GuestRestControllerViewTop100 {

    @Autowired
    private api.controllers.GuestRestController guestRestController;

    @Test
    void viewTop100_1(){
        ResponseEntity<Page<Top100Dto>> pageResponseEntity = this.guestRestController.viewTop100(1);
        Assertions.assertEquals(404,pageResponseEntity.getStatusCodeValue());
    }

}
