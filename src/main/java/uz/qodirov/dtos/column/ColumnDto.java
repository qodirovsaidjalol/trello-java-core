package uz.qodirov.dtos.column;

import uz.qodirov.dtos.GenericDto;
import uz.qodirov.dtos.task.TaskDto;

import java.util.List;

public class ColumnDto extends GenericDto {

    private String emoji;

    private String name;

    private int order;

    private List<TaskDto> tasks;
}