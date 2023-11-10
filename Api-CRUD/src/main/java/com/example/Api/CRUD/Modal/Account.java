package com.example.Api.CRUD.Modal;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Account {

      @Id
      @GeneratedValue

        private Long id;

     @Column(unique = true)
        private  String userName;

      // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        private String password;

        private  boolean enabled = true;

        private boolean credentialexpired =false;
        private  boolean expired = false;
        private boolean Locked  = false;

    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
            name="AccountRoles",
            joinColumns={@JoinColumn(name="AccountId", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="RolesId", referencedColumnName="id")})

        private Set<Roles>roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isCredentialexpired() {
        return credentialexpired;
    }

    public void setCredentialexpired(boolean credentialexpired) {
        this.credentialexpired = credentialexpired;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public boolean isLocked() {
        return Locked;
    }

    public void setLocked(boolean locked) {
        Locked = locked;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }
}
