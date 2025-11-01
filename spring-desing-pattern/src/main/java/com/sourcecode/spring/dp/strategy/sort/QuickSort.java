package com.sourcecode.spring.dp.strategy.sort;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
public class QuickSort implements SortStrategy {
    @Override
    public SortAlgo getSortAlgorithm() {
        return SortAlgo.QUICK_SORT;
    }

    @Override
    public List<Integer> getSortedList(int[] array) {
        log.info("Sorting using Quick Sort");
        // Quick Sort algorithm
        return Arrays.stream(array).sorted().boxed().toList();
    }

}
