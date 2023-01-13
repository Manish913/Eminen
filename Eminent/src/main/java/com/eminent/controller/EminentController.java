
package com.eminent.controller;

import com.eminent.model.Admin;
import com.eminent.model.LoginInfo;
import com.eminent.repository.AdminRepository;
import com.eminent.utills.Utility;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
//import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
public class EminentController {
    @Autowired
    private AdminRepository adminRepository;

    @PostMapping("/p")
    public List<Admin> saveAdmin(){

        Admin save = adminRepository.save(new Admin("mano-har", "7448376026", "employee"));
        return (List<Admin>) save;


    }
    // it is admin url so it can show all records
    @GetMapping ("/all")
    public List<Admin> findAll(){
        Iterable<Admin> all = adminRepository.findAll();
        return (List<Admin>) all;

    }
    // it will find all records except only admin records
    @GetMapping ("/man")
    public List<Admin> findByManager(){
        Iterable<Admin> all = adminRepository.findByAdminRoleNotLike("admin");
        return (List<Admin>) all;


    }
    //it will find all records except admin and manager
    @GetMapping ("/ass")
    public List<Admin> findByAssiManager() {
        List<Admin> all = adminRepository.findByAdminRoleNotLikeAndAdminRoleIsNot("admin", "manager");
//        Iterable<Admin> all = adminRepository.findByAdminRoleNotLike("admin");
//        Iterable<Admin> manager = adminRepository.findByAdminRoleNotLike("manager");
//        List<Admin> as=new LinkedList<>();
return all;
    }

    @GetMapping("/co")
    public Admin findById(){
        Optional<Admin> byId = adminRepository.findById(1);
        Admin id = byId.get();
        return id;
    }
//    @GetMapping ("/ass")
//    public List<Admin> findByAssiManager(){
//        Iterable<Admin> all = adminRepository.findByAdminRoleNotLike("admin");
//        Iterable<Admin> manager = adminRepository.findByAdminRoleNotLike("manager");
//        List<Admin> as=new LinkedList<>();
//
//        as.addAll((Collection<? extends Admin>) all);
//       boolean b = as.addAll((Collection<? extends Admin>) manager);
//        return (List<Admin>) all;
//
//    }
    @GetMapping ("/emp")
    public Admin findByEqual(){
        Admin employee = adminRepository.findByAdminRoleEquals("employee");
        return employee;

    }

    @RequestMapping("/l")
    @GetMapping
    public String index(Model model)
    {
        return "index";
    }



//    @RequestMapping("/save")
//    public String saveAdmins(Model model ,Admin admin ){
//        adminRepository.save(admin);
//        model.addAttribute("msg","SAVED......");
//
//        return "message";
//    }
    ///starts from here by tommorow
//    @GetMapping({"/Admin","/Manager","/Assistant Manager","/Employee"})
//    public String getDependOnRole(ModelMap model,String adminRole, Admin admin){
//           if(adminRepository.findByAdminRole("admin")  adminRepository.findByAdminRoleNotLikeAndAdminRoleIsNot("admin", "manager"))
//        return"";
//    }


    @GetMapping({"/","/message"})
    public String message(ModelMap model){
        return "message";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
   public String login(ModelMap model, @ModelAttribute LoginInfo loginInfo , Admin admin ) {

        if (loginInfo.getMobile_no() != null && Strings.isEmpty(loginInfo.getOtp())) {

            if (adminRepository.existsByAdminContact(loginInfo.getMobile_no()) ) {

                 List<Admin> con=adminRepository.findByAdminContactEquals(loginInfo.getMobile_no());

            model.addAttribute(con);
                List<Admin> ls=new ArrayList<>(con);
                for(Admin admi: ls) {

                   model.addAttribute("admi",admi);
                    model.addAttribute(admi.getAdminName());
                    model.addAttribute(admi.getAdminContact());
                    model.addAttribute(admi.getAdminRole());

                }

                model.addAttribute("otp", Utility.GenerateOtp());
              model.addAttribute("mobile", loginInfo.getMobile_no());
//                return "index";
//           return "home";
               return "dashboard";
            }
                //fetch user details from database using mobile_no
                // if user persist ,generate otp and send otp to mobile_no otherwise throw Error user does not exist ...please sing up

//            return "home";
            return "index";//replace
//    return "dashboard";

        } else {


            return "home";
  //return "index";//replace here
        }


    }
}



