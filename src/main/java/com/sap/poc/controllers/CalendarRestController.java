package com.sap.poc.controllers;

import com.sap.poc.models.Team;
import com.sap.poc.models.TeamIntervalCalendar;
import com.sap.poc.models.TeamMember;
import com.sap.poc.models.TeamMemberShift;
import com.sap.poc.services.TeamIntervalCalendarService;
import com.sap.poc.services.TeamMemberShiftService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.*;

@RestController
public class CalendarRestController extends GenericController{

    @Resource
    private TeamIntervalCalendarService teamIntervalCalendarService;
    @Resource
    private TeamMemberShiftService teamMemberShiftService;

    @RequestMapping(value = "/getTeamCalendar", method = RequestMethod.GET)
    public List<TeamIntervalCalendar> getTeamCalendar(Principal principal){
        TeamMember loggedMember = (TeamMember) getLoggedUser(principal);

        Team team = loggedMember.getTeam();

        return teamIntervalCalendarService.getTeamIntervalsCalendarByTeam(team);
    }

    @RequestMapping(value = "/getMemberShifts", method = RequestMethod.GET)
    public List<TeamMemberShift> getMemberShifts(Principal principal){
        TeamMember loggedMember = (TeamMember) getLoggedUser(principal);
        List<TeamMemberShift> shifts = teamMemberShiftService.getTeamMemberShiftsByMember(loggedMember);

        return shifts;
    }
}
