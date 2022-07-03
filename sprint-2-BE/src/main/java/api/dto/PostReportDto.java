package api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostReportDto {
    private Long postId;
    private Long reportId;
    private String dateReport;

    private Long peopleId;

    private String idReport;


}
