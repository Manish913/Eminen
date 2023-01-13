package com.eminent.model;

import javax.persistence.*;


@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "admin_id")
    private Integer adminId;
    @Column(name = "admin_name")
    private String adminName;
    @Column(name = "admin_contact")
    private String adminContact;
    @Column(name = "admin_role")
    private String adminRole;
    public Admin() {}

    public Admin(String adminName,String adminContact,String adminRole) {

        this.adminName = adminName;
        this.adminContact = adminContact;
        this.adminRole = adminRole;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }


    public String getAdminContact() {
        return adminContact;
    }

    public void setAdminContact(String adminContact) {
        this.adminContact = adminContact;
    }

    public String getAdminRole() {
        return adminRole;
    }

    public void setAdminRole(String adminRole) {
        this.adminRole = adminRole;
    }
}
