package uz.qodirov.dtos.label;

import lombok.*;
import uz.qodirov.dtos.GenericDto;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LabelDto extends GenericDto {
    private String color;
    private String text;
    private Long projectId;
}
