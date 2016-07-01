package app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
@RequestMapping("/")
@Controller
public class MainController {

  
  @RequestMapping(method = RequestMethod.GET)
  public String index() {
    return "index.jsp" ;
  }

}
