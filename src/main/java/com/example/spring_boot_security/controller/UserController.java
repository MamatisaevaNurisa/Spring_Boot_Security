package com.example.spring_boot_security.controller;

import com.example.spring_boot_security.entity.User;
import com.example.spring_boot_security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

  private final UserRepository userRepository;

  public String profile(HttpServletRequest request, Model model){
      Principal principal = request.getUserPrincipal();
      User user = userRepository.getUsersByUsername(principal.getName());
      model.addAttribute("user",user);
      return "profile";
  }

}
