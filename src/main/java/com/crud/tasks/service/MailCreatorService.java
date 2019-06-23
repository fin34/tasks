package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;


@Service
public class MailCreatorService {

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    private TaskRepository taskRepository;

    public String buildTrelloCardEmail(String message) {
        List<String> functionality = new ArrayList();
        functionality.add("You can manage your tasks");
        functionality.add("Provides connection with trello account");
        functionality.add("Application allows sending tasks to trello");

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "https://fin34.github.io");
        context.setVariable("button", "Visit website");
        context.setVariable("admin_config", adminConfig);
        context.setVariable("company_details", adminConfig.getCompanyName());
        context.setVariable("preview_message", "Add trello card.");
        context.setVariable("show_button", false);
        context.setVariable("is_friend", true);
        context.setVariable("application_functionality", functionality);

        return templateEngine.process("mail/created-trello-card-mail", context);
    }

    public String buildNumberOfTasksMail(String message) {
        List<String> tasksName = new ArrayList<>();
        for (int i = 1; i <= 3 ; i++) {
            tasksName.add(taskRepository.findAll().get((int)taskRepository.count()-i).getTitle());

        }
        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("admin_config", adminConfig);
        context.setVariable("tasks_url", "https://fin34.github.io");
        context.setVariable("button", "Show all tasks");
        context.setVariable("is_president", true);
        context.setVariable("preview_message", "Numbers of tasks in your app");
        context.setVariable("last_three_tasks", tasksName);

        return templateEngine.process("mail/number-of-tasks", context);
    }
}
