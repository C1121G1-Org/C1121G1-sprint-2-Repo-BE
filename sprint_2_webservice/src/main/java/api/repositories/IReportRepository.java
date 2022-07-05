package api.repositories;

import api.dto.IGuestDto;
import api.models.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IReportRepository extends JpaRepository<Report, Long> {

    @Query(value = "select temp.postReportId as postReportId, temp.postId as postId, temp.guestName as guestName, temp.dateReport as dateReport, " +
            "temp.reportName as reportName, temp.reportedPeople as reportPeople, guest.name as reportedPeopleName from " +
            "(select post_report.id as postReportId, post.id as postId, guest.`name` as guestName, post_report.date_report as dateReport, " +
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
            countQuery = "select temp.postReportId as postReportId, temp.postId as postId, temp.guestName as guestName, temp.dateReport as dateReport, " +
                    "temp.reportName as reportName, temp.reportedPeople as reportPeople, guest.name as reportedPeopleName from " +
                    "(select post_report.id as postReportId, post.id as postId, guest.`name` as guestName, post_report.date_report as dateReport, " +
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
    Page<IGuestDto> getPostReport(String guestName, String reportName,
                                  String dateReport, String reportPeopleName, Pageable pageable);



    @Query(value = "select temp.postReportId as postReportId, temp.postId as postId, temp.guestName as guestName, temp.dateReport as dateReport,\n" +
            "    temp.reportName as reportName, temp.reportedPeople as reportPeople, guest.name as reportedPeopleName from\n" +
            "            (select post_report.id as postReportId, post.id as postId, guest.`name` as guestName, post_report.date_report as dateReport,\n" +
            "             report.name as reportName,\n" +
            "             post_report.people_report_id as reportedPeople from report\n" +
            "                     join post_report on post_report.report_id = report.id\n" +
            "                     join post on post_report.post_id = post.id\n" +
            "                     join guest on post.guest_id = guest.id\n" +
            "                     where guest.`name` like concat('%', '', '%')\n" +
            "    and report.name like concat('%', '', '%'))\n" +
            "    as temp inner join guest on guest.id = temp.reportedPeople\n" +
            "    where postReportId = ?1 ",
            countQuery = "select temp.postReportId as postReportId, post_report.id as postReportId, temp.postId as postId, temp.guestName as guestName, temp.dateReport as dateReport,\n" +
                    "    temp.reportName as reportName, temp.reportedPeople as reportPeople, guest.name as reportedPeopleName from\n" +
                    "            (select post_report.id as postReportId, post.id as postId, guest.`name` as guestName, post_report.date_report as dateReport,\n" +
                    "             report.name as reportName,\n" +
                    "             post_report.people_report_id as reportedPeople from report\n" +
                    "                     join post_report on post_report.report_id = report.id\n" +
                    "                     join post on post_report.post_id = post.id\n" +
                    "                     join guest on post.guest_id = guest.id\n" +
                    "                     where guest.`name` like concat('%', '', '%')\n" +
                    "    and report.name like concat('%', '', '%'))\n" +
                    "    as temp inner join guest on guest.id = temp.reportedPeople\n" +
                    "    where postReportId = ?1 ", nativeQuery = true)
    List<IGuestDto> getMemberReport(Long id);


    @Query(value = "insert into post_report(date_report, post_id, report_id, people_report_id ) value " +
            "(:#{#iGuestDto.dateReport}, :#{#iGuestDto.postId}, :#{#iGuestDto.reportId}, :#{#iGuestDto.reportedPeopleId})",nativeQuery = true)
    void creatPostReBot(IGuestDto iGuestDto);
}
