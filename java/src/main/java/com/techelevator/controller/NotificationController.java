package com.techelevator.controller;

import com.techelevator.dao.NotificationDao;
import com.techelevator.model.Notification;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
public class NotificationController {
    private NotificationDao notificationDao;
    private Notification notification;

    public NotificationController(Notification notification,NotificationDao notificationDao){
        this.notificationDao = notificationDao; this.notification = notification;
    }

    @RequestMapping(value = "/notification/{id}", method = RequestMethod.GET)
        public List<Notification> findAllByUserId( @PathVariable long id){
        return notificationDao.findAllByUserId(id);
    }


    @RequestMapping(path = "/notification", method = RequestMethod.PUT)
    public void updateNotification( @RequestBody Notification notification){
        notificationDao.updateNotification(notification);
    }
}
