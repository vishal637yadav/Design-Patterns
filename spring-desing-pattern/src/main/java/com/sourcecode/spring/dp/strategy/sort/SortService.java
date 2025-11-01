package com.sourcecode.spring.dp.strategy.sort;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SortService {
    private final SortAlgoResolver sortAlgoResolver;

    public List<Integer> performSorting(SortAlgo sortAlgo, int[] array) {
        SortStrategy strategy = sortAlgoResolver.resolveSortStrategy(sortAlgo);
        return strategy.getSortedList(array);
    }

    public List<SortAlgo> getSupportedSortAlgorithms() {
        return List.of(SortAlgo.values());
    }
}
