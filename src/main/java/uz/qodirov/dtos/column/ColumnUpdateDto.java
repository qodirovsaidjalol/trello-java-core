package uz.qodirov.dtos.column;

import lombok.Data;
import uz.qodirov.dtos.GenericDto;

@Data
public class ColumnUpdateDto extends GenericDto {

    private String emoji;

    private String name;

    private int order;
}