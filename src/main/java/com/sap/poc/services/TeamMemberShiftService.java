package com.sap.poc.services;

import com.sap.poc.models.CalendarDate;
import com.sap.poc.models.Team;
import com.sap.poc.models.TeamMember;
import com.sap.poc.models.TeamMemberShift;

import java.util.List;
import java.util.Set;

public interface TeamMemberShiftService {

    void create(TeamMemberShift teamMemberShift);
    void refresh(TeamMemberShift teamMemberShift);
    void update(TeamMemberShift teamMemberShift);
    void delete(TeamMemberShift teamMemberShift);
    TeamMemberShift getTeamMemberShiftById(int id);
    void createShifts(Set<TeamMemberShift> shifts);
    void createShiftsOfMembers(Set<TeamMember> members);
    List<TeamMemberShift> getTeamMemberShiftsByMember(TeamMember member);
    void changeAvailabilityByDate(CalendarDate date, boolean availability);
    void updateShiftsByMembers(List<TeamMember> members);
    List<TeamMemberShift> getTeamMemberShiftsByCalendarDate(CalendarDate calendarDate);

    TeamMemberShift getShiftByCalendarDateAndMember(CalendarDate calendarDate, TeamMember member);
}
