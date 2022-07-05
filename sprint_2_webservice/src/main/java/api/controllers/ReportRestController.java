package api.controllers;

import api.dto.IGuestDto;
import api.models.Report;
import api.models.ResponseObject;
import api.services.IReportService;
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
@RequestMapping("/api/report")
public class ReportRestController {
    @Autowired
    IReportService iReportService;

    @GetMapping(value = "/list-report")
    public ResponseEntity<Page<IGuestDto>> listPostReport(@PageableDefault(value = 5) Pageable pageable,
                                                          @RequestParam(name = "guestName", required = false, defaultValue = "") String guestName,
                                                          @RequestParam(name = "reportName", required = false, defaultValue = "") String reportName,
                                                          @RequestParam(name = "dateReport", required = false, defaultValue = "1900-01-01") String dateReport,
                                                          @RequestParam(name = "reportPeopleName", required = false, defaultValue = "") String reportPeopleName) {
        Page<IGuestDto> postReportPage =
                iReportService.getPostReport(guestName, reportName, dateReport, reportPeopleName, pageable);
        if (postReportPage.isEmpty()) {
            return new ResponseEntity<>(postReportPage, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(postReportPage, HttpStatus.OK);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<Report>> listReport() {
        List<Report> reportPage = iReportService.findAll();
        if (reportPage.isEmpty()) {
            return new ResponseEntity<>(reportPage, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(reportPage, HttpStatus.OK);
    }

    /*
     Created by TuanPD
     ROLE: ADMIN
     Time: 13:00 27/07/2022
     Function: getAllMember = Select All by Member
     Class:
     */
    @GetMapping("/warning/{id}")
    public ResponseEntity<?> getWarningMember(@PathVariable("id") Long id) {
        List<IGuestDto> iReportDtoPage = iReportService.getMemberReport(id);
        if (iReportDtoPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(iReportDtoPage, HttpStatus.OK);
    }


//    @PostMapping(value = "/create")
//    public ResponseEntity<?> createLocation(@Valid @RequestBody PostReportDto postReportDto,
//                                            BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return new ResponseEntity<>(bindingResult.getAllErrors().get(0).getDefaultMessage(),
//                    HttpStatus.NOT_FOUND);
//        }
//        PostReport postReport = new PostReport();
//        BeanUtils.copyProperties(postReportDto, postReport);
//        if (postReportDto.getReport_id() != null) {
//            Set<PostReport> postReportSet = new HashSet<>();
//            for (int i = 0; i < arrId.length; i++) {
//                Long id = Long.parseLong(arrId[i]);
//                Post post = iPostService.
//            }
//        }
//        return new ResponseEntity<Void>(HttpStatus.OK);
//    }
}
