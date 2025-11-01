package com.sourcecode.spring.dp.strategy.sort;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;

@Slf4j
@Component
public class SortAlgoResolver {

    private final Map<SortAlgo, SortStrategy> sortStrategies = new EnumMap<>(SortAlgo.class);

    public SortAlgoResolver(ApplicationContext ctx) {
        // Collect all strategies and index by enum key
        ctx.getBeansOfType(SortStrategy.class).values()
                .forEach(s -> sortStrategies.put(s.getSortAlgorithm(), s));
        log.info("Available Sort Strategies: {}", sortStrategies.keySet());
    }

    public SortStrategy resolveSortStrategy(SortAlgo sortAlgo) {
        SortStrategy s = sortStrategies.get(sortAlgo);
        if (s == null) throw new IllegalArgumentException("Unsupported Sort Algo :-:=>> " + sortAlgo);
        return s;
    }

}
