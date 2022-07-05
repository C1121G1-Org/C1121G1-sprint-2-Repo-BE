package api.services.impl;

import api.repositories.IGuestReportRepository;
import api.services.IGuestReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestReportServiceImpl implements IGuestReportService {
    @Autowired
    IGuestReportRepository iGuestReportRepository;
}
