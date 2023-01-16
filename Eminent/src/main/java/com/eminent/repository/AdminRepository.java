package com.eminent.repository;

import com.eminent.model.Admin;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AdminRepository extends CrudRepository<Admin,Integer> {
    //https://www.bezkoder.com/jpa-repository-query/
    boolean existsByAdminContact(String adminContact);

    Optional<Admin> findById(Integer id);

    List<Admin> findByAdminContactEquals(String AdContact);//it finds exact data from databased

    Admin findByAdminRoleEquals(String employ);
  //  List<Admin> findByAdminDesAndAdminStatus(String adminDes,String adminStatus);
    List<Admin> findByAdminRoleNotLike(String adminRole);
    List<Admin> findByAdminRoleNotLikeAndAdminRoleIsNot(String adminRole,String manager);
//    Admin findById(Integer id);
}
