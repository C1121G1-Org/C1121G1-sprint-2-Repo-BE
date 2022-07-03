package api.services.impl;

import api.models.PostReport;
import api.models.Report;
import api.repositories.IReportRepository;
import api.services.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements IReportService {
    @Autowired
    IReportRepository iReportRepository;

    @Override
    public void save(Report report) {
        iReportRepository.save(report);
    }

    @Override
    public List<Report> findAll() {
        return iReportRepository.findAll();
    }

    @Override
    public Report getById(Long id) {
        return iReportRepository.findById(id).orElse(null);
    }
}
