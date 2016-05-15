package ch07.se04.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import ch07.se04.event.EmailEvent;

public class EmailListener implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if (applicationEvent instanceof EmailEvent) {
            EmailEvent emailEvent = (EmailEvent)applicationEvent;
            System.out.println("邮件接收地址：" + emailEvent.getAddress());
            System.out.println("邮件正文：" + emailEvent.getText());
        } else {
            System.out.println("监听到其他事件：" + applicationEvent);
        }
    }

}
