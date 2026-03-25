package br.edu.ifgoiano.httpdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/http")
public class HttpDemoController {

 @GetMapping("/ok")
 @ResponseBody
 public ResponseEntity<String> ok() {
  return ResponseEntity.ok("200 OK - Sucesso");
 }

 @GetMapping("/created")
 @ResponseBody
 public ResponseEntity<String> created() {
  return new ResponseEntity<>("201 Created", HttpStatus.CREATED);
 }

 @GetMapping("/badrequest")
 @ResponseBody
 public ResponseEntity<String> badRequest() {
  return ResponseEntity.badRequest().body("400 Bad Request");
 }

 @GetMapping("/error")
 @ResponseBody
 public ResponseEntity<String> error() {
  return new ResponseEntity<>("500 Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
 }

 @GetMapping("/headers")
 public String headers(@RequestHeader(value="User-Agent", defaultValue="desconhecido") String userAgent,
                       Model model) {
  model.addAttribute("ua", userAgent);
  return "headers";
 }
}
