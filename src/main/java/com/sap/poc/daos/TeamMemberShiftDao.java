package com.sap.poc.daos;

import com.sap.poc.models.CalendarDate;
import com.sap.poc.models.Team;
import com.sap.poc.models.TeamMember;
import com.sap.poc.models.TeamMemberShift;

import java.util.List;

public interface TeamMemberShiftDao {

    void create(TeamMemberShift teamMemberShift);
    void refresh(TeamMemberShift teamMemberShift);
    void update(TeamMemberShift teamMemberShift);
    void delete(TeamMemberShift teamMemberShift);
    TeamMemberShift getTeamMemberShiftById(int id);

    List<TeamMemberShift> getTeamMemberShiftsByMember(TeamMember member);

    List<TeamMemberShift> getTeamMemberShiftsByCalendarDate(CalendarDate calendarDate);

    TeamMemberShift getShiftByCalendarDateAndMember(CalendarDate calendarDate, TeamMember member);
}
