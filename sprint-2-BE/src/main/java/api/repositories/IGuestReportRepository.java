package api.repositories;

import api.models.PostReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGuestReportRepository extends JpaRepository<PostReport, Long> {
}
