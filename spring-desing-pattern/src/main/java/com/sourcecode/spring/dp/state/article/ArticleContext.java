package com.sourcecode.spring.dp.state.article;

import com.sourcecode.spring.dp.state.article.state.ArticleState;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class ArticleContext {

    private ArticleState state;

    // Article properties
    private String heading;
    private String content;
    private List<String> auditTrail;
    private String author;

    public void setState(ArticleState state) {
        log.info("ArticleState Transition : {} ---> {}  !!", this.state.getState(), state.getState());
        this.state = state;
    }

    public void create(ArticleContext article) {
        state.create(this);
    }

    public void draft(ArticleContext article) {
        state.draft(this);
    }

    public void review(ArticleContext article) {
        state.review(this);
    }

    public void publish(ArticleContext article) {
        state.publish(this);
    }

    public void archive(ArticleContext article) {
        state.archive(this);
    }

}
