package api.controllers;

import api.dto.IGuestDto;
import api.models.ResponseObject;
import api.services.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/api/report")
public class ReportRestController {
    @Autowired
    IReportService iReportService;

    @PostMapping(value = "/create")
    public ResponseEntity<ResponseObject> createReport(){
        return null;
    }

    @GetMapping(value = "/list")
    public ResponseEntity<ResponseObject> listReport(){
        return null;
    }

    @PatchMapping(value = "/update/{id}")
    public ResponseEntity<ResponseObject> updateReport(@PathVariable String id){
        return null;
    }

    @PatchMapping(value = "/delete/{id}")
    public ResponseEntity<ResponseObject> deleteReport(@PathVariable String id){
        return null;
    } //Xóa bằng cách update lại các delete_flag = 1

    /**
     Created by TuanPD
     ROLE: ADMIN
     Time: 13:00 27/07/2022
     Function: getAllMember = Select All by Member
     Class:
     **/
//    @PatchMapping("/warning/{id}")
//    public ResponseEntity<Page<IGuestDto>> getWarningMember() {
//
//        Page<IGuestDto> iReportDtoPage = iGuestService.getAllMember(nameMember, pageable);
//        if (iReportDtoPage.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(iReportDtoPage, HttpStatus.OK);
//    }

}
