package uz.qodirov.dtos.column;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import uz.qodirov.dtos.GenericBaseDto;

@Data
public class ColumnCreateDto implements GenericBaseDto {
    private String emoji;
    @SerializedName("project_id")
    private long projectId;

    private String name;

    private int order;
}