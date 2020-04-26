package com.rmc.web;

import com.rmc.po.Project;
import com.rmc.service.ProjectService;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/Project")
public class ProjectController {

    private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
    private ProjectService projectService;


    @Autowired
    public void setProjectService(ProjectService projectService){
        this.projectService = projectService;
    }

    /**
     * Back to project data list
     * @return
     */
    @RequestMapping("/project.do")
    public ModelAndView listAllPost() {
        ModelAndView view =new ModelAndView();
        view.setViewName("/projectList");
        return view;
    }
    /**
     * Back to project creation page
     * @return
     */
    @RequestMapping("/CreatePage.do")
    public ModelAndView CreatePage() {
        ModelAndView view =new ModelAndView();
        view.setViewName("/projectCreation");
        return view;
    }
    @RequestMapping(value="/createProject.do", method=RequestMethod.POST)
    @ResponseBody
    public void requestList(@RequestParam Map<String, Object>  map) {
        System.out.println("Request successful. Post param : list - " + map);
        String projectName = map.get("projectName").toString();
        String description = map.get("description").toString();
        System.out.println("projectName: " + projectName);
        System.out.println("description: " + description);
        projectService.createProject(projectName,description);

    }


    /**
     * Back to project data list
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/showList.do")
    @ResponseBody
    public List<Project> showList (HttpServletRequest request,
                                   HttpServletResponse response) throws Exception {
        try {
            List<Project> l= projectService.getAllProjects();
            return l;
        }   catch (Exception e) {
            System.out.println(ExceptionUtils.getStackTrace(e));
            logger.error(ExceptionUtils.getStackTrace(e));
            return  null;
    }
    }
}
