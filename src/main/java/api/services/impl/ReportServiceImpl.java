package api.services.impl;

import api.repositories.IReportRepository;
import api.services.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements IReportService {
    @Autowired
    IReportRepository iReportRepository;
}
