package com.shopping.agro.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "USERS_CREDENTIALS")
public class UserCredentials {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "USER_ID", nullable = false, unique = true)
    private Long id;
    @Column(name = "USER_NAME", unique = true, nullable = false)
    private String username;
    @Column(name = "PASSWORD", nullable = false)
    private String password;
    @Column(name = "enabled")
    private boolean enabled = true;

    public UserCredentials() {
        enabled = true;
    }

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_ROLES",
    joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID")
    )

    private Set<Authority> roles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Authority> getRoles() {
        return roles;
    }

    public void setRoles(Set<Authority> roles) {
        this.roles = roles;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
