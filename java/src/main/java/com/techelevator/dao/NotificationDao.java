package com.techelevator.dao;

import com.techelevator.model.Notification;

import java.util.List;

public interface NotificationDao {

    List<Notification> findAllByUserId(Long id);

    void updateNotification(Notification notification);

    void addNotification(Notification notification);

   void deleteNotification(Long notificationId);

}
