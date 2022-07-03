package api.services;

import api.models.PostReport;
import api.models.Report;

import java.util.List;

public interface IReportService {
    void save(Report report);

    List<Report> findAll();

    Report getById(Long id);
}
