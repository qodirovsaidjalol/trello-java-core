package uz.qodirov.dtos.organization;

import lombok.AllArgsConstructor;
import lombok.Data;
import uz.qodirov.dtos.GenericBaseDto;
import uz.qodirov.security.organization.Point;

@Data
@AllArgsConstructor
public class OrganizationCreateDto implements GenericBaseDto {
	private String website;

	private String regNumber;

	private String name;

	private String logo;

	private Point location;

	private String email;

	public OrganizationCreateDto(String regNumber, String name) {
		this.regNumber = regNumber;
		this.name = name;
	}
}