package com.eminent.repository;

import com.eminent.model.Admin;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AdminRepository extends CrudRepository<Admin,Integer> {
    //https://www.bezkoder.com/jpa-repository-query/
    boolean existsByAdminContact(String adminContact);
    Optional<Admin> findByAdminName(String adminName);
    List<Admin> findByAdminContactNotLikeAndAdminContactIsNot(String adminCon,String contact);
    List<Admin> findByAdminContactEquals(String AdContact);//it finds exact data from databased
    List<Admin> findByAdminRole(String adminRole);
   List<Admin> findByAdminContactNotLike(String con);//it don't find records of admin except it find the all
    Admin findByAdminRoleEquals(String employ);
  //  List<Admin> findByAdminDesAndAdminStatus(String adminDes,String adminStatus);
    List<Admin> findByAdminRoleNotLike(String adminRole);
    List<Admin> findByAdminRoleNotLikeAndAdminRoleIsNot(String adminRole,String manager);
}
