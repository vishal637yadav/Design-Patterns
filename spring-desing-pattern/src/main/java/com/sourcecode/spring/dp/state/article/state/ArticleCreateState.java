package com.sourcecode.spring.dp.state.article.state;

import com.sourcecode.spring.dp.state.article.ArticleContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Primary
public class ArticleCreateState implements ArticleState {
    @Override
    public void create(ArticleContext article) {
        log.info("Article is created and in 'New' state.");
        article.setState(new ArticleDraftState());
    }

    @Override
    public void draft(ArticleContext article) {
        log.info("Cannot draft an article in 'New' state. Please create it first.");
        throw new IllegalStateException("Cannot draft an article in 'New' state. Please create it first.");
    }

    @Override
    public void review(ArticleContext article) {
        log.info("Cannot review an article in 'New' state. Please create and draft it first.");
        throw new IllegalStateException("Cannot review an article in 'New' state. Please create and draft it first.");
    }

    @Override
    public void publish(ArticleContext article) {
        log.info("Cannot publish an article in 'New' state. Please create, draft & review it first.");
        throw  new IllegalStateException("Cannot publish an article in 'New' state. Please create it first.");
    }

    @Override
    public void archive(ArticleContext article) {
        log.info("Cannot archive an article in 'New' state. Please create, draft, review & publish it first.");
        throw new IllegalStateException("Cannot archive an article in 'New' state. Please create it first.");
    }

    @Override
    public ArticleStateEnum getState() {
        return ArticleStateEnum.NEW;
    }
}
