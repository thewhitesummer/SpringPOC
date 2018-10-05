package com.sap.poc.services.impl;

import com.sap.poc.daos.TeamDao;
import com.sap.poc.daos.UserDao;
import com.sap.poc.models.Team;
import com.sap.poc.models.TeamMember;
import com.sap.poc.models.User;
import com.sap.poc.services.TeamService;
import com.sap.poc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class UserServiceImp implements UserService, UserDetailsService {

    @Resource
    private UserDao hibernateUserDao;
    @Resource
    private TeamService teamService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserServiceImp(UserDao hibernateUserDao) {
        this.hibernateUserDao = hibernateUserDao;
    }

    @Override
    public void create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        hibernateUserDao.create(user);
    }

    @Override
    public void refresh(User user) {
        hibernateUserDao.refresh(user);
    }

    @Override
    public void update(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        hibernateUserDao.update(user);
    }

    @Override
    public void delete(User user) {
        hibernateUserDao.delete(user);
    }

    @Override
    public User getUserByName(String name) {
        return hibernateUserDao.getUserByName(name);
    }

    @Override
    public User getUserByLogin(String login) {
        return hibernateUserDao.getUserByLogin(login);
    }

    @Override
    public List<User> getUsers() {
        return hibernateUserDao.getUsers();
    }

    @Override
    public List<TeamMember> getMembersByTeamId(int teamId) {
        Team team = teamService.getTeamById(teamId);
        return hibernateUserDao.getMembersByTeam(team);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = hibernateUserDao.getUserByLogin(s);
        if(user == null)
            throw new UsernameNotFoundException(s);
        return user;
    }
}
