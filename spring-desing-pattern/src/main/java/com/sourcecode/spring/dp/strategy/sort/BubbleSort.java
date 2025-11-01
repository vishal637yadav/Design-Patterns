package com.sourcecode.spring.dp.strategy.sort;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
public class BubbleSort implements SortStrategy {

    @Override
    public SortAlgo getSortAlgorithm() {
        return SortAlgo.BUBBLE_SORT;
    }

    @Override
    public List<Integer> getSortedList(int[] array) {
        log.info("Sorting using Bubble Sort");
        // Bubble Sort algorithm
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    // swap array[j] and array[j + 1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return Arrays.stream(array).boxed().toList();
    }
}
