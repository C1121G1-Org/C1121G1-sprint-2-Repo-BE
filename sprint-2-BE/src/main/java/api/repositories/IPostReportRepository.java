package api.repositories;

import api.dto.IReportDto;
import api.models.LikePost;
import api.models.PostReport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IPostReportRepository extends JpaRepository<PostReport, Long> {

    @Query(value = "select temp.postId as postId, temp.guestName as guestName, temp.dateReport as dateReport, " +
            "temp.reportName as reportName, temp.reportedPeople as reportPeople, guest.name as reportedPeopleName from " +
            "(select post.id as postId, guest.`name` as guestName, post_report.date_report as dateReport, " +
            "report.name as reportName, " +
            "post_report.people_report_id as reportedPeople from report " +
            "join post_report on post_report.report_id = report.id " +
            "join post on post_report.post_id = post.id " +
            "join guest on post.guest_id = guest.id " +
            "where guest.`name` like concat('%', :guestName, '%') " +
            "and report.name like concat('%', :reportName, '%')) " +
            "as temp inner join guest on guest.id = temp.reportedPeople " +
            "where guest.`name` like concat('%', :reportPeopleName, '%') " +
            "and dateReport >= :dateReport ",
            countQuery = "select temp.postId as postId, temp.guestName as guestName, temp.dateReport as dateReport, " +
                    "temp.reportName as reportName, temp.reportedPeople as reportPeople, guest.name as reportedPeopleName from " +
                    "(select post.id as postId, guest.`name` as guestName, post_report.date_report as dateReport, " +
                    "report.name as reportName, " +
                    "post_report.people_report_id as reportedPeople from report " +
                    "join post_report on post_report.report_id = report.id " +
                    "join post on post_report.post_id = post.id " +
                    "join guest on post.guest_id = guest.id " +
                    "where guest.`name` like concat('%', :guestName, '%') " +
                    "and report.name like concat('%', :reportName, '%')) " +
                    "as temp inner join guest on guest.id = temp.reportedPeople " +
                    "where guest.`name` like concat('%', :reportPeopleName, '%') " +
                    "and dateReport >= :dateReport ", nativeQuery = true)
    Page<IReportDto> getPostReport(String guestName, String reportName,
                                   String dateReport, String reportPeopleName, Pageable pageable);

    @Query(value = "insert into post_report (date_report, people_report_id, post_id, report_id) " +
            "values(now(), :#{#postReport.peopleReportId}, :#{#postReport.})", nativeQuery = true)
    void luu(PostReport postReport);
}
