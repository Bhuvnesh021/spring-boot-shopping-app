package com.shopping.agro.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "AUTHORITY")
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "AUTHORITY")
    private String authority;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

}
