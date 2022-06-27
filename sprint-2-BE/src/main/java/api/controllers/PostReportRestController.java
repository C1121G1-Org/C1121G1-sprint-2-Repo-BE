package api.controllers;

import api.dto.IReportDto;
import api.models.PostReport;
import api.models.Report;
import api.models.ResponseObject;
import api.services.IPostReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/postReport")
public class PostReportRestController {

    @Autowired
    IPostReportService iPostReportService;

    @GetMapping(value = "/list")
    public ResponseEntity<Page<IReportDto>> listPostReport(@PageableDefault(value = 5) Pageable pageable,
                                                           @RequestParam(name = "guestName", required = false, defaultValue = "") String guestName,
                                                           @RequestParam(name = "reportName", required = false, defaultValue = "") String reportName,
                                                           @RequestParam(name = "dateReport", required = false, defaultValue = "1900-01-01") String dateReport,
                                                           @RequestParam(name = "reportPeopleName", required = false, defaultValue = "") String reportPeopleName){
        Page<IReportDto> postReportPage =
                iPostReportService.getPostReport(guestName, reportName, dateReport, reportPeopleName, pageable);
        if (postReportPage.isEmpty()){
            return new ResponseEntity<>(postReportPage, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(postReportPage, HttpStatus.OK);
    }


}
