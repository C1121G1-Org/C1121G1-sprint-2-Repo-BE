package api.services;

import api.dto.IReportDto;
import api.models.PostReport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPostReportService {

    Page<IReportDto> getPostReport(String guestName, String reportName, String dateReport, String reportPeopleName, Pageable pageable);
}
