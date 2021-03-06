package com.sap.poc.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Team {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private TeamOwner owner;

    @OneToMany(mappedBy = "team")
    private Set<TeamMember> members = new HashSet<>();

    @OneToMany(mappedBy = "team")
    private Set<TeamIntervalCalendar> intervalCalendars = new HashSet<>();

    @OneToMany(mappedBy = "team")
    private Set<Notification> notifications;

    public Team(){
        owner = null;
    }

    public TeamOwner getOwner() {
        return owner;
    }

    public void setOwner(TeamOwner owner) {
        this.owner = owner;
    }

    public Set<TeamMember> getMembers() {
        return members;
    }

    public void setMembers(Set<TeamMember> members) {
        this.members = members;
    }

    public void addMember(TeamMember member){
        this.members.add(member);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<TeamIntervalCalendar> getIntervalCalendars() {
        return intervalCalendars;
    }

    public void setIntervalCalendars(Set<TeamIntervalCalendar> intervalCalendars) {
        this.intervalCalendars = intervalCalendars;
    }

    public void addIntervalCalendar(TeamIntervalCalendar intervalCalendar) {
        this.intervalCalendars.add(intervalCalendar);
    }

    public Set<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(Set<Notification> notifications) {
        this.notifications = notifications;
    }

    public void addNotification(Notification notification) {
        this.notifications.add(notification);
    }
}
