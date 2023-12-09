package com.mkshop.mkshop.data.model;

import com.fasterxml.jackson.annotation.*;
import com.mkshop.mkshop.data.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column
    @CreationTimestamp
    private Date created_at;

    @Column
    @UpdateTimestamp
    private Date updated_at;

    @Column(nullable = false)
    private String full_name;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)// Nao mostra a senha encriptada
    private String password;

    @Column
    private String phone_number;

    @Column(nullable = false)
    private String cpf;

    @OneToOne(cascade = CascadeType.PERSIST, orphanRemoval = true)
    private Address address;

    @OneToMany(mappedBy = "user")
    @JsonIdentityReference(alwaysAsId = true)
    private List<Order> order;

    private UserRole role;

    public User(String full_name, String username,
                String passwordEncrypted, String phone_number, String cpf, UserRole role) {
        this.setFull_name(full_name);
        this.setUsername(username);
        this.setPassword(passwordEncrypted);
        this.setPhone_number(phone_number);
        this.setCpf(cpf);
        this.setRole(role);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == UserRole.ADMIN) {
            return List.of(
                    new SimpleGrantedAuthority("ROLE_ADMIN"),
                    new SimpleGrantedAuthority("ROLE_USER")
            );
        } else {
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        }
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
