package uz.qodirov.dtos.task;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.qodirov.dtos.GenericDto;
import uz.qodirov.dtos.comments.CommentDto;
import uz.qodirov.dtos.user.UserDto;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto extends GenericDto {

    private String level;

    private Long projectColumnId;

    private String name;

    private String description;

    private Date deadline;

    private String priority;

    private List<UserDto> members;

    private List<CommentDto> comments;
}
