package uz.qodirov.dtos.project;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.qodirov.dtos.GenericDto;
import uz.qodirov.dtos.column.ColumnDto;
import uz.qodirov.dtos.label.LabelDto;
import uz.qodirov.dtos.user.UserDto;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto extends GenericDto {
    private String tz;
    private String background;
    private String name;
    private String description;
    private long organizationId;
    private List<LabelDto> labels;
    private List<UserDto> members;
    private List<ColumnDto> columns;

}
