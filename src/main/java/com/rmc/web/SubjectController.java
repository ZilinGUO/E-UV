package com.rmc.web;

import com.rmc.po.Subject;
import com.rmc.service.SubjectService;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/Subject")
public class SubjectController {
    private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
    private SubjectService subjectService;
    @Autowired
    public void setProjectService(SubjectService subjectService){
        this.subjectService = subjectService;
    }

    @RequestMapping("/subjectPage.do")
    public ModelAndView subjectPage(HttpServletRequest request,
                                    HttpServletResponse response) {
        int projectId = Integer.parseInt(request.getParameter("ProjectId"));
        request.getSession().setAttribute("projectID", projectId);
        System.out.println(projectId);
        ModelAndView view =new ModelAndView();
        view.setViewName("/subjectPage");
        return view;
    }
    @RequestMapping("/showSubjectLists.do")
    @ResponseBody
    public List<Subject> showSubjectLists (@RequestParam Map<String, Object> map) throws Exception {
        try {
            List<Subject> subjectLists= subjectService.getAllSubjects(Integer.parseInt(map.get("projectId").toString()));
            System.out.println(subjectLists);
            return subjectLists;
        }   catch (Exception e) {
            System.out.println(ExceptionUtils.getStackTrace(e));
            logger.error(ExceptionUtils.getStackTrace(e));
            return  null;
        }
    }
}
