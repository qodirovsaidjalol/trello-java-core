package uz.qodirov.dtos.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.qodirov.dtos.GenericDto;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto extends GenericDto {
    private String phone;
    private Long organizationId;
    private String lastName;
    private String language;
    private String firstName;
    private String email;
    private String username;
}
