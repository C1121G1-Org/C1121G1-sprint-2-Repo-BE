package api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
