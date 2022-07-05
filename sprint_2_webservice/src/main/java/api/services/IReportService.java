package api.services;

import api.dto.IGuestDto;
import api.models.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IReportService {
    Page<IGuestDto> getPostReport(String guestName, String reportName, String dateReport, String reportPeopleName, Pageable pageable);

    void save(Report report);

    List<Report> findAll();

    List<IGuestDto> getMemberReport(Long id);

    void creatPostReBot(IGuestDto iGuestDto);
}
