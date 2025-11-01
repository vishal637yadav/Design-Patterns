package com.sourcecode.spring.dp.strategy.sort;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class SortController {

    private final SortService sortService;

    @PostMapping("/sort/{sortAlgo}")
    public ResponseEntity<List<Integer>> performSorting(
            @PathVariable SortAlgo sortAlgo,
            @RequestBody int[] numbers) {
        try {
            log.info("Received: {}", Arrays.toString(numbers));
            List<Integer> sortedList = sortService.performSorting(sortAlgo, numbers);
            log.info("performSorting -- Sorted:---->>> {}", sortedList);
            return ResponseEntity.ok(sortedList);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/allSortAlgo")
    public ResponseEntity<List<SortAlgo>> getSupportedSortAlgo() {
        return ResponseEntity.ok(sortService.getSupportedSortAlgorithms());
    }
}
