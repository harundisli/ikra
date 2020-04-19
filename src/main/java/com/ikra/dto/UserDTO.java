package com.ikra.dto;

import com.ikra.validation.ValidEmail;
import com.ikra.validation.ValidPassword;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter @Setter
public class UserDTO {

    @NotNull
    @Size(min = 1/*, message = "{Size.userDto.fullName}"*/)
    private String fullName;

/*    @NotNull
    @Size(min = 1, message = "{Size.userDto.lastName}")
    private String lastName;
*/
    @ValidEmail
    @NotNull
    @Size(min = 1/*, message = "{Size.userDto.email}"*/)
    private String email;

    @ValidPassword
    private String password;

}
