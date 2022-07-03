package api.controllers;

import api.dto.PostReportDto;
import api.models.PostReport;
import api.models.Report;
import api.models.ResponseObject;
import api.services.IPostReportService;
import api.services.IReportService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/report")
public class ReportRestController {
    @Autowired
    IReportService iReportService;

    @Autowired
    IPostReportService iPostReportService;

//    @PostMapping(value = "/create")
//    public ResponseEntity<ResponseObject> createReport(){
//
//        Report report = new Report();
//        iReportService.save(report);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> createLocation(@Valid @RequestBody PostReportDto postReportDto,
                                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors().get(0).getDefaultMessage(), HttpStatus.NOT_FOUND);
        }
        PostReport postReport = new PostReport();
        if (postReportDto.getIdReport() != null) {
            String arrId[] = postReportDto.getIdReport().split(",");
            for (int i = 0; i < arrId.length; i++) {
                postReportDto.setReportId(Long.valueOf(arrId[i]));
                BeanUtils.copyProperties(postReportDto, postReport);
                iPostReportService.createPostReport(postReport);
            }
        }
        return new ResponseEntity<Void>(HttpStatus.OK);
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
