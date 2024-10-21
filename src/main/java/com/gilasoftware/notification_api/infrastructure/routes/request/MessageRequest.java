package com.gilasoftware.notification_api.infrastructure.routes.request;

import com.gilasoftware.notification_api.domain.enums.Category;
import com.gilasoftware.notification_api.domain.utils.CategoryValidator;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MessageRequest {
    @NotNull(message = "Category must be not null")
    @CategoryValidator(enumClass = Category.class, message = "Category must be one of SPORTS, FINANCE, MOVIES")
    private Category category;
    @NotNull(message = "Message body must be not null")
    @NotEmpty
    private String body;
}
