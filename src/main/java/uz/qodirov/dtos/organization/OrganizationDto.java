package uz.qodirov.dtos.organization;

import lombok.Getter;
import lombok.Setter;
import uz.qodirov.dtos.GenericDto;

@Getter
@Setter
public class OrganizationDto extends GenericDto {
    private String website;

    private String regNumber;

    private String name;

    private String logo;

    private String location;

    private String email;
}

