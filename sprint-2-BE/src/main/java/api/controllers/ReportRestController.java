package api.controllers;

import api.models.ResponseObject;
import api.services.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
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
}
