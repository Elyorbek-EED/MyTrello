package uz.boom.ergashov.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.boom.ergashov.configs.security.SessionUser;
import uz.boom.ergashov.configs.security.UserDetails;
import uz.boom.ergashov.criteria.GenericCriteria;
import uz.boom.ergashov.services.organization.OrganizationService;
import uz.boom.ergashov.services.project.ProjectServiceImpl;
import uz.boom.ergashov.services.task.TaskServiceImpl;

@Controller
public class HomeController {

    private final OrganizationService organizationService;
    private final ProjectServiceImpl projectService;
    private final TaskServiceImpl taskService;

    public HomeController(OrganizationService organizationService, ProjectServiceImpl projectService, TaskServiceImpl taskService) {
        this.organizationService = organizationService;
        this.projectService = projectService;
        this.taskService = taskService;
    }


    @PreAuthorize("isAuthenticated()"   )
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String homePage(Model model) {
        model.addAttribute("session_user", SessionUser.session());
        model.addAttribute("projects", projectService.getAll(new GenericCriteria()));
        model.addAttribute("my_projects", projectService.getAllById(new GenericCriteria(),SessionUser.session().getId()));
        model.addAttribute("tasks_emp", taskService.getAll(new GenericCriteria()));
        UserDetails user = SessionUser.session();
        if (user.isSuperUser()) return "panel/superAdmin";
        if (user.getRole().getCode().equals("ADMIN")) return "panel/admin";
        if (user.getRole().getCode().equals("MANAGER")) return "panel/manager";
        return "panel/employee";
    }
}
