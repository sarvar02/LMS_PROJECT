package com.example.lms_project.user;

import com.example.lms_project.role.Role;
import com.example.lms_project.role.RoleDto;
import com.example.lms_project.sertificate.Certificate;
import com.example.lms_project.sertificate.CertificateDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-12T17:23:17+0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.15 (Private Build)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto modelToDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setRole( roleToRoleDto( user.getRole() ) );
        userDto.setRoleId( user.getRoleId() );
        userDto.setCertificate( certificateToCertificateDto( user.getCertificate() ) );
        userDto.setFirstname( user.getFirstname() );
        userDto.setLastname( user.getLastname() );
        userDto.setUsername( user.getUsername() );
        userDto.setPhone( user.getPhone() );
        userDto.setPassword( user.getPassword() );

        return userDto;
    }

    @Override
    public User dtoToModel(UserDto dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setId( dto.getId() );
        user.setRole( roleDtoToRole( dto.getRole() ) );
        user.setRoleId( dto.getRoleId() );
        user.setCertificate( certificateDtoToCertificate( dto.getCertificate() ) );
        user.setFirstname( dto.getFirstname() );
        user.setLastname( dto.getLastname() );
        user.setUsername( dto.getUsername() );
        user.setPhone( dto.getPhone() );
        user.setPassword( dto.getPassword() );

        return user;
    }

    protected RoleDto roleToRoleDto(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDto roleDto = new RoleDto();

        roleDto.setId( role.getId() );
        roleDto.setName( role.getName() );

        return roleDto;
    }

    protected CertificateDto certificateToCertificateDto(Certificate certificate) {
        if ( certificate == null ) {
            return null;
        }

        CertificateDto certificateDto = new CertificateDto();

        certificateDto.setId( certificate.getId() );
        if ( certificate.getCourseId() != null ) {
            certificateDto.setCourseId( certificate.getCourseId().longValue() );
        }
        certificateDto.setToken( certificate.getToken() );
        certificateDto.setName( certificate.getName() );
        certificateDto.setSurname( certificate.getSurname() );
        certificateDto.setUrl( certificate.getUrl() );
        certificateDto.setPath( certificate.getPath() );
        certificateDto.setFinishedDate( certificate.getFinishedDate() );
        certificateDto.setCreatedAt( certificate.getCreatedAt() );
        certificateDto.setDeletedAt( certificate.getDeletedAt() );

        return certificateDto;
    }

    protected Role roleDtoToRole(RoleDto roleDto) {
        if ( roleDto == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( roleDto.getId() );
        role.setName( roleDto.getName() );

        return role;
    }

    protected Certificate certificateDtoToCertificate(CertificateDto certificateDto) {
        if ( certificateDto == null ) {
            return null;
        }

        Certificate certificate = new Certificate();

        certificate.setId( certificateDto.getId() );
        if ( certificateDto.getCourseId() != null ) {
            certificate.setCourseId( certificateDto.getCourseId().intValue() );
        }
        certificate.setToken( certificateDto.getToken() );
        certificate.setName( certificateDto.getName() );
        certificate.setSurname( certificateDto.getSurname() );
        certificate.setUrl( certificateDto.getUrl() );
        certificate.setPath( certificateDto.getPath() );
        certificate.setFinishedDate( certificateDto.getFinishedDate() );
        certificate.setCreatedAt( certificateDto.getCreatedAt() );
        certificate.setDeletedAt( certificateDto.getDeletedAt() );

        return certificate;
    }
}
