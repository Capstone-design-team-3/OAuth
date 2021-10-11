package org.capstone.team3.configuration;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.stereotype.Component;
import org.capstone.team3.entity.AppUser;
import org.capstone.team3.entity.Post;
import org.capstone.team3.repository.AppUserRepository;
import org.capstone.team3.repository.PostRepository;

@Component
@Log4j2
public class InitTestData implements ApplicationListener<ApplicationContextEvent> {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public void onApplicationEvent(ApplicationContextEvent applicationContextEvent) {
        postRepository.save(new Post(0, "Post title nr1", "Post content nr1"));
        postRepository.save(new Post(0, "Post title nr2", "Post content nr2"));
        postRepository.save(new Post(0, "Post title nr3", "Post content nr3"));
        log.info("3 posts saved.");

        appUserRepository.save(new AppUser("capcap@google.com", "pass", "USER"));
        log.info("User saved.");
    }
}
