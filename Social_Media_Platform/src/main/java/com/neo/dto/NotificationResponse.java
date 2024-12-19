package com.neo.dto;


import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.SqlResultSetMapping;

//==============================================
//Using @SqlResultSetMapping for Native Queries 
// Add this Annotation at class level
//=============================================

@SqlResultSetMapping(
		name = "NotificationResponseMapping",
		classes = @ConstructorResult(
				targetClass = NotificationResponse.class,
				columns = {
						@ColumnResult(name = "user_id", type = Long.class),
						@ColumnResult(name = "notification_count", type = Long.class),
				}
				)
		
		)

@NamedNativeQuery(
	    name = "NotificationRepository.getMaxNotificationByUser",
	    query ="SELECT user_id, COUNT(*) AS notification_count FROM notifications GROUP BY user_id HAVING notification_count = (SELECT MAX(cnt) FROM (SELECT COUNT(*) AS cnt FROM notifications GROUP BY user_id) AS subquery",
	    resultSetMapping = "NotificationResponseMapping"
	)

public class NotificationResponse {
    private Long userId;
    private Long notificationCount;


    public NotificationResponse(Long userId, Long notificationCount) {
        this.userId = userId;
        this.notificationCount = notificationCount;
    }

    
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getNotificationCount() {
        return notificationCount;
    }

    public void setNotificationCount(Long notificationCount) {
        this.notificationCount = notificationCount;
    }

    @Override
    public String toString() {
        return "NotificationResponse{" +
                "userId=" + userId +
                ", notificationCount=" + notificationCount +
                '}';
    }
}
