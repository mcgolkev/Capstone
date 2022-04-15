package com.techelevator.controller;

import com.techelevator.dao.NotificationDao;
import com.techelevator.model.Notification;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class NotificationController {
    private NotificationDao notificationDao;
    private Notification notification;

    public NotificationController(Notification notification,NotificationDao notificationDao){
        this.notificationDao = notificationDao; this.notification = notification;
    }

    @RequestMapping(path = "/notification", method = RequestMethod.GET)
        public List<Notification> findAllByUsername(Principal principal){
        return notificationDao.findAllByUsername(principal.getName());
    }


    @RequestMapping(path = "/notification", method = RequestMethod.PUT)
    public void updateNotification( @RequestBody Notification notification){
        notificationDao.updateNotification(notification);
    }
}
