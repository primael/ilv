package fr.nimrod.ilv.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {

   @GetMapping(value="/home")
   public String initHome(){
      log.debug("Call home page");
      return "home";
   }
}
