package com.sourcecode.spring.dp.template.file;

import com.sourcecode.spring.dp.template.file.processor.FileFormat;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class FileProcessorController {

    private final FileProcessingService fileProcessingService;

    // Spring automatically converts the string path variable to an Enum
    @GetMapping("/{type}")
    public ResponseEntity<String> processData(@PathVariable FileFormat type) {
        try {
            fileProcessingService.processData(type);
            return ResponseEntity.ok("Successfully processed " + type.name() + " data. Check console logs.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
