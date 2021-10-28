package com.revature.p2.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dnd_users")
public class DNDUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="firstname")
    @NotBlank(message = "FirstName is required")
    private String firstName;
    @Column(name="lastname")
    @NotBlank(message = "LastName is required")
    private String lastName;

    @Email(message = "Username needs to be email")
    @NotBlank(message = "Username is required")
    @Column(unique = true)
    @Email
    private String username;
    @NotBlank(message = "Password is required")
    private String password;
    @Transient
    private String confirmPassword;
    @Column(name="created_at")
    private Date createdAt;
    @Column(name="updated_at")
    private Date updatedAt;

    public DNDUser(String firstName, String lastName, String username, String password, String confirmPassword, Date createdAt, Date updatedAt) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    //    @PrePersist
//    protected  void onCreate(){
//        this.createdAt = new Date();
//    }
//
//    @PreUpdate
//    protected void onUpdate(){
//        this.updatedAt = new Date();
//    }

    /*
    * UserDetails interface methods from Spring Security
    *
    * */

    @Override
    @Transient
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList("USER");
    }

    @Override
    @Transient
    public String getPassword() {
        return password;
    }

    @Override
    @Transient
    public String getUsername() {
        return username;
    }

    @Override
    @Transient
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @Transient
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @Transient

    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @Transient
    public boolean isEnabled() {
        return true;
    }
}
