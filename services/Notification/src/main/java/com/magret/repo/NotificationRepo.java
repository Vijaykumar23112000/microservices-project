package com.magret.repo;

import com.magret.entity.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepo extends MongoRepository<Notification , String> {
}
