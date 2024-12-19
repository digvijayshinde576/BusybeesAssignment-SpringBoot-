package com.neo.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neo.dto.NotificationResponse;
import com.neo.repo.NotificationRepo;

@Service
public class NotificationService {


	private final NotificationRepo notificationRepo;

    public NotificationService(NotificationRepo notificationRepo) {
        this.notificationRepo = notificationRepo;
    }

//===========================================================================================
	
// Manually Mapping resultset 

	
	public List<Object[]> getMaxNotificationByUser(){
		
		List<Object[]> response = notificationRepo.getMaxNotificationByUser();
		
		return response;
	}
	
//==============================================================================================	
	
	
//	 Using Constructor Based JPQL Query
	
//	public List<NotificationResponse> getMaxNotificationByUser(){
//		
//		List<NotificationResponse> response = notificationRepo.getMaxNotificationByUser();
//		
//		return response;
//	}
//	
	
//==========================================================================================================================================
	
	
//Using @SqlResultSetMapping for Native Queries
	
}
