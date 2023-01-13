//package com.eminent.controller;
//
//import com.eminent.model.Admin;
//import com.eminent.repository.AdminRepository;
//import jdk.nashorn.internal.objects.NativeDebug;
//import org.springframework.ui.Model;
//import org.springframework.validation.Errors;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//@RestController
//public class EmailController {
//    private final AdminRepository adminRepository;
//
//    public EmailController(AdminRepository adminRepository) {
//        this.adminRepository = adminRepository;
//    }
//
//    @RequestMapping("/welcome")
//    public String welcome(){
//       return "home";
//    }
//    @GetMapping("/{contact}")
//    public String home(Model model, Admin admin){
//        Optional<Admin> con = adminRepository.findByAdminContact("" + "contact");
//        model.addAttribute("con",con);
//        return "home";
//    }
//    @GetMapping("/register")
//    public String showRegistration(Model model){
//        Admin admin=new Admin();
//        model.addAttribute("admin",admin);
//        return "register";
//    }
//    @PostMapping("register")
//    public String registration(Admin admin, Model model){
//
//        Optional<Admin> find = adminRepository.findByAdminContact((admin.getAdminContact()));
//        Errors result = null;
//        NativeDebug findByAdminContact = null;
//        if(find != null && find.getClass() != null && ! findByAdminContact.getClass()){
//            result.rejectValue("email",
//                    "There is already an account registered with the same email");
//        }
//        if(result.hasErrors()){
//            model.addAttribute("admin",admin);
//        return "/register";
//    }
//
//        return "redirect:/register?success";
//    }
//}
