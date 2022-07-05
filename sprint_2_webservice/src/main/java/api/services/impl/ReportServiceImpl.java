package api.services.impl;

import api.dto.IGuestDto;
import api.models.Report;
import api.repositories.IReportRepository;
import api.services.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements IReportService {
    @Autowired
    IReportRepository iReportRepository;
    @Override
    public Page<IGuestDto> getPostReport(String guestName, String reportName, String dateReport, String reportPeopleName, Pageable pageable) {
        return iReportRepository.getPostReport(guestName, reportName, dateReport, reportPeopleName, pageable);
    }

    @Override
    public void save(Report report) {
        iReportRepository.save(report);
    }

    @Override
    public List<Report> findAll() {
        return iReportRepository.findAll();
    }

    @Override
    public List<IGuestDto> getMemberReport(Long id) {
        return iReportRepository.getMemberReport(id);
    }

    @Override
    public void creatPostReBot(IGuestDto iGuestDto) {
        iReportRepository.creatPostReBot(iGuestDto);
    }
}
