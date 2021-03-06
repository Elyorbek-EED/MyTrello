package uz.boom.ergashov.controller.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.boom.ergashov.controller.AbstractController;
import uz.boom.ergashov.criteria.GenericCriteria;
import uz.boom.ergashov.dto.comment.CreateCommentDto;
import uz.boom.ergashov.dto.comment.UpdateCommentDto;
import uz.boom.ergashov.services.comment.CommentService;

import java.io.IOException;

/**
 * Created by Elyor Ergashov
 *
 * @author : mreed
 * @date : 3/7/2022
 * @project : mealDeliver
 */

@Component
@RequestMapping(value = "/comment/*")
public class CommentController extends AbstractController<CommentService> {

    @Autowired
    public CommentController(CommentService service) {
        super(service);
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createPage(){
        return "comment/create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@ModelAttribute CreateCommentDto dto) throws IOException {
        service.create(dto);
        return "redirect:/";
    }

    @RequestMapping(value = "update/{id}",method = RequestMethod.GET)
    public String updatePage(@ModelAttribute Model model, @PathVariable(name = "id") Long id){
        model.addAttribute("comment", service.get(id));
        return "comment/update";
    }

    @RequestMapping(value = "update/{id}",method = RequestMethod.POST)
    public String update(@ModelAttribute UpdateCommentDto dto) throws IOException {
        service.update(dto);
        return "redirect:/";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deletePage( Model model, @PathVariable(name = "id") Long id){
        model.addAttribute("comment", service.get(id));
        return "comment/delete";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable(name = "id") Long id){
        service.delete(id);
        return "comment/delete";
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("comments",service.getAll(new GenericCriteria()));
        return "comment/list";
    }


}
