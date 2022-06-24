package api.repositories;

import api.models.GuestReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGuestReportRepository extends JpaRepository<GuestReport, Long> {
}
