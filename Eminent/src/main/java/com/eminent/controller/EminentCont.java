//package com.eminent.controller;
//
//import com.eminent.model.Admin;
//import com.eminent.repository.AdminRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//@RestController
//public class EminentCont {
//    @Autowired
//    private AdminRepository repo;
//    @RequestMapping(value="/rest",method= RequestMethod.POST)
//    @GetMapping("")
//    public String getEmployeeByNumber(Model model, Admin admin){
//
//        if(repo.existsByAdminContact("mobile_no")){
//            boolean mobileNo = repo.findByAdminContact("mobile_no").isPresent();
//            model.addAttribute("mobileNo");
////            for (:
////                 ) {
////
////            }
//            System.out.println(mobileNo);
//            return "regist";
//    }
//        return null;
//    }
//    @RequestMapping(value = "/message", method = RequestMethod.GET)
//    public String messages(Model model) {
//        model.addAttribute("messages", repo.findAll());
//        return "message";
//    }
//}
