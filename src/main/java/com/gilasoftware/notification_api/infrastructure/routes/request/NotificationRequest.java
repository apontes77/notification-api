package com.gilasoftware.notification_api.infrastructure.routes.request;

import com.gilasoftware.notification_api.domain.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class NotificationRequest {

    private Category category;
    private String body;
}
