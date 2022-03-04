package uz.qodirov.dtos.project;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import uz.qodirov.dtos.GenericDto;

@Data
public class ProjectUpdateDto extends GenericDto {
	private String tz;

	private String background;

	@SerializedName("organization_id")
	private int organizationId;

	private String name;

	private String description;
}