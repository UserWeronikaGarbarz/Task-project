package com.crud.tasks.scheduler;

import com.crud.tasks.config.AdminConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmailSchedulerService {

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    public String buildOneEmailPerDay(String message) {
        List<String> functionality = new ArrayList<>();
        functionality.add("You should carefully analyze your tasks.");
        functionality.add("Sorting tasks by importance is a good practice.");
        functionality.add("You should not postpone your tasks.");

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "http://localhost:8888/crud");
        context.setVariable("show_button", true);
        context.setVariable("button", "Visit website");
        context.setVariable("is_friend", true);
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("goodbye", "Regards");
        context.setVariable("company_name", adminConfig.getCompanyName());
        context.setVariable("company_goal", adminConfig.getCompanyGoal());
        context.setVariable("company_email", adminConfig.getAdminMail());
        context.setVariable("application_functionality", functionality);
        return templateEngine.process("mail/one-mail-per-day", context);
    }
}
