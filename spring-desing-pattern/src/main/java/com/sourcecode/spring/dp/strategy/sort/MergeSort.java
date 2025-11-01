package com.sourcecode.spring.dp.strategy.sort;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
public class MergeSort implements SortStrategy{
    @Override
    public SortAlgo getSortAlgorithm() {
        return SortAlgo.MERGE_SORT;
    }

    @Override
    public List<Integer> getSortedList(int[] array) {
        log.info("Sorting using Merge Sort");
        // Merge Sort algorithm
        Arrays.sort(array);
        return Arrays.stream(array).boxed().toList();
    }

}
