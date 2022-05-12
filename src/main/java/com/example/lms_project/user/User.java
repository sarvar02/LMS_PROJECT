package com.example.lms_project.user;
import com.example.lms_project.role.Role;
import com.example.lms_project.sertificate.Certificate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = ("users"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = ("role_id"), insertable = false, updatable = false)
    private Role role;

    @Column(name = ("role_id"))
    private Integer roleId;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = ("certificate_id"), referencedColumnName = ("id"), insertable = false, updatable = false)
//    private Certificate certificate;
//
//    @Column(name = ("certificate_id"))
//    private Integer certificateId;

    @Column(name = ("firstname"))
    private String firstname;

    @Column(name = ("lastname"))
    private String lastname;

    @Column(name = ("username"))
    private String username;

    @Column(name = ("phone"))
    private String phone;

    @Column(name = ("password"))
    private String password;

    @Column(name = ("status"))
    private Boolean status;

    @Column(name = ("created_at"))
    private LocalDateTime createdAt;

    @Column(name = ("updated_at"))
    private LocalDateTime updatedAt;

    @Column(name = ("deleted_at"))
    private LocalDateTime deletedAt;
}
