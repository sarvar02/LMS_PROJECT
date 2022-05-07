package com.example.lms_project.user;
import com.example.lms_project.role.Role;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

    private Integer id;
    private Role role;
    @NotNull(message = ("User Role id is mandatory!"))
    private Integer roleId;
//    private Certificate certificate;
//    @NotNull(message = ("Certificate id is mandatory!"))
//    private Integer certificateId;
    @NotBlank(message = ("User firstname is mandatory!"))
    private String firstname;
    @NotBlank(message = ("User lastname is mandatory!"))
    private String lastname;
    @NotBlank(message = ("User username is mandatory!"))
    private String username;
    @NotBlank(message = ("User phone is mandatory!"))
    private String phone;
    @NotBlank(message = ("User password is mandatory!"))
    private String password;
}
