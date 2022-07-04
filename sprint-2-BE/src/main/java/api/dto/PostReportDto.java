package api.dto;

import api.models.Guest;
import api.models.Post;
import api.models.Report;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostReportDto {

    private Long id;

    private String dateReport;

    private Long report_id;

    private Long post_id;

    private Long guest_id;

}
