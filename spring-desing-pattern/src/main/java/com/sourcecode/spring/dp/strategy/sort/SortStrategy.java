package com.sourcecode.spring.dp.strategy.sort;

import java.util.List;

public interface SortStrategy {
    SortAlgo getSortAlgorithm();
    List<Integer> getSortedList(int[] array);
}

