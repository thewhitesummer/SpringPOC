package com.sap.poc.controllers;

import com.sap.poc.models.TeamMember;
import com.sap.poc.models.TeamOwner;
import com.sap.poc.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/edit")
public class EditController extends GenericController {

    @Resource
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public String editOwner(Model model, HttpServletRequest request, @ModelAttribute("owner") TeamOwner owner){
        TeamOwner editOwner = (TeamOwner) userService.getUserByLogin(owner.getUsername());

        editOwner.setPassword(owner.getPassword());
        editOwner.setName(owner.getName());
        editOwner.setEmail(owner.getEmail());

        userService.update(editOwner);

        updateLoggedUser(request);
        model.addAttribute("members", getMembersList(request));
        return "ownerHome";
    }

    @RequestMapping(value = "/member", method = RequestMethod.POST)
    public String editMember(Model model, HttpServletRequest request, @ModelAttribute("member") TeamMember member){
        TeamMember editMember = (TeamMember) userService.getUserByLogin(member.getUsername());

        editMember.setPassword(member.getPassword());
        editMember.setName(member.getName());
        editMember.setEmail(member.getEmail());

        userService.update(editMember);

        model.addAttribute("members", getMembersList(request));
        return "ownerHome";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getEditOwnerPage(Model model, @ModelAttribute("editOwner") TeamOwner editOwner){
        editOwner = (TeamOwner) userService.getUserByLogin(editOwner.getUsername());
        model.addAttribute("editOwner", editOwner);
        return "editOwner";
    }

    @RequestMapping(value = "/member", method = RequestMethod.GET)
    public String getEditMemberPage(Model model, @ModelAttribute("editMember") TeamMember editMember){
        editMember = (TeamMember) userService.getUserByLogin(editMember.getUsername());
        model.addAttribute("editMember", editMember);
        return "editMember";
    }

}
