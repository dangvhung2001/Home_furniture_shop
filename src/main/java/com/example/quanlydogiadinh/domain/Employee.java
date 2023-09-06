package com.example.quanlydogiadinh.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employee")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "img_url", length = 255)
    private String imgUrl;

    @Column(name = "lastname", nullable = false, length = 255)
    private String name;

    @Column(nullable = false, length = 255)
    @Size(min = 6, message = "Mật khẩu phải có ít nhất 6 ký tự")
    private String password;

    @Column
    private Byte sex;

    @Column(name = "marital_status", length = 255)
    private String maritalStatus;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    private String citizenCode;

    private Date issueDate;

    private String placeOfIssue;

    private String employeeCode;
    @Email
    private String email;

    private String address;

    @Column(length = 255)
    private String position;

    private String status;

    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    private String phone;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private Salary salary;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "employee_role",
            joinColumns = {@JoinColumn(name = "employee_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_name")})
    private Set<Role> roles = new HashSet<>();
}
