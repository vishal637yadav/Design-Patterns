package com.sourcecode.spring.dp.state.article.state;

import com.sourcecode.spring.dp.state.article.ArticleContext;
import com.sourcecode.spring.dp.state.article.ArticleDto;

public interface ArticleState {

    ArticleContext create(ArticleDto articleDto);

    void draft(ArticleContext article);

    void review(ArticleContext article);

    void publish(ArticleContext article);

    void archive(ArticleContext article);

    ArticleStateEnum getState();

}
