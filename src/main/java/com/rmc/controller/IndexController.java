package com.rmc.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String login() {
    	return "login";
    }
    
    @RequestMapping("/index")
    public String index() {
    	return "index";
    }
    
    @RequestMapping("/returnAutoList")
    public String returnAutoList() {
    	return "automataList";
    }
    
    @RequestMapping("/addAutomata")
    public String addAutomata() {
    	return "addAutomata";
    }
    
    
    @RequestMapping("/returnUserList")
    public String returnUserList() {
    	return "userList";
    }
    
    @RequestMapping("/addUser")
    public String addUser() {
    	return "addUser";
    }
    
    @RequestMapping("/returnJobList")
    public String returnJobList() {
    	return "jobList.html";
    }
    
    @RequestMapping("/addJob")
    public String addJob() {
    	return "addJob";
    }
    
    @RequestMapping("/returnWorkflowList")
    public String returnWorkflowList() {
    	return "workflowList";
    }
    
    @RequestMapping("/addWorkflow")
    public String addWorkflow() {
    	return "addWorkflow";
    }
    
    @RequestMapping("/returnScheduleList")
    public String returnScheduleList() {
    	return "scheduleList";
    }
    
    @RequestMapping("/addSchedule")
    public String addSchedule() {
    	return "addSchedule";
    }
    
    @RequestMapping("/returnKeyWordList")
    public String returnKeyWordList() {
    	return "KeyWordList";
    }
    
    @RequestMapping("/addKeyWord")
    public String addKeyWord() {
    	return "addKeyWord";
    }
    
    @RequestMapping("/returnResourceList")
    public String returnResourceList() {
    	return "ResourceList";
    }
    
    @RequestMapping("/addResource")
    public String addResource() {
    	return "addResource";
    }
    
    @RequestMapping("/returnBusinessList")
    public String returnBusinessList() {
    	return "BusinessList";
    }
    
    @RequestMapping("/addBusiness")
    public String addBusiness() {
    	return "addBusiness";
    }
    
    @RequestMapping("/returnClientList")
    public String returnClientList() {
    	return "ClientList";
    }
    
    @RequestMapping("/addClient")
    public String addClient() {
    	return "addClient";
    }
    
    @RequestMapping("/returnServerList")
    public String returnServerList() {
    	return "ServerList";
    }
    
    @RequestMapping("/addServer")
    public String addServer() {
    	return "addServer";
    }
    
    @RequestMapping("/returnLessonList")
    public String returnLessonList() {
    	return "LessonList";
    }
    
    @RequestMapping("/addLesson")
    public String addLesson() {
    	return "addLesson";
    }
    
    
    
    @RequestMapping("/whoim")
    @ResponseBody
    public Object whoIm()
    {
          return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}