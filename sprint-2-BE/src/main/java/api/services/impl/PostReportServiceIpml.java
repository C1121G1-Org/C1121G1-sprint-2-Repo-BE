package api.services.impl;

import api.dto.IReportDto;
import api.models.PostReport;
import api.repositories.IPostReportRepository;
import api.services.IPostReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostReportServiceIpml implements IPostReportService {
    @Autowired
    IPostReportRepository iPostReportRepository;


    @Override
    public Page<IReportDto> getPostReport(String guestName, String reportName, String dateReport, String reportPeopleName, Pageable pageable) {
        return iPostReportRepository.getPostReport(guestName, reportName, dateReport, reportPeopleName, pageable);
    }
}
