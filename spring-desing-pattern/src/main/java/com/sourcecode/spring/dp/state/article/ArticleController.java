package com.sourcecode.spring.dp.state.article;

import com.sourcecode.spring.dp.state.article.state.ArticleStateEnum;
import com.sourcecode.spring.dp.strategy.sort.SortAlgo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping("/create")
    public ResponseEntity<ArticleDto> createArticleInDraftState(
            @RequestBody ArticleDto articleDto) {
        try {
            log.info("Received articleDto  : {}", articleDto);
            articleService.createArticle();
            return ResponseEntity.ok(articleDto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
