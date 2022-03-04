package uz.qodirov.dtos.permission;

import lombok.Data;
import uz.qodirov.dtos.GenericDto;

@Data
public class PermissionSetDto extends GenericDto {
	private int permission;
}