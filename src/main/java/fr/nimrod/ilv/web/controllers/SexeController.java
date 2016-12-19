package fr.nimrod.ilv.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SexeController {

   @GetMapping(value="/sexe")
   public String initSexe(){
      log.debug("Call sexe page");
      return "sexe";
   }
   
}
