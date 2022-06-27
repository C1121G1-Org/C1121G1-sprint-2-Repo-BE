package api.controllers;

import api.models.Report;
import api.models.ResponseObject;
import api.services.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/report")
public class ReportRestController {
    @Autowired
    IReportService iReportService;

    @PostMapping(value = "/create")
    public ResponseEntity<ResponseObject> createReport(){

        Report report = new Report();
        iReportService.save(report);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<Report>> listReport(){
        List<Report> reportPage = iReportService.findAll();
        if (reportPage.isEmpty()){
            return new ResponseEntity<>(reportPage, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(reportPage, HttpStatus.OK);
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
