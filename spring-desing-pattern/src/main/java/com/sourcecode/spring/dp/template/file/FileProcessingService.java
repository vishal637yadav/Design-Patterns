package com.sourcecode.spring.dp.template.file;

import com.sourcecode.spring.dp.template.file.processor.AbstractFileProcessor;
import com.sourcecode.spring.dp.template.file.processor.FileFormat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
public class FileProcessingService {

    private final Map<FileFormat, AbstractFileProcessor> processorMap;

    // Spring injects all beans of type AbstractDataProcessor into the list
    public FileProcessingService(List<AbstractFileProcessor> processors) {
        processorMap = new EnumMap<>(FileFormat.class);
        for (AbstractFileProcessor processor : processors) {
            processorMap.put(processor.getFileFormat(), processor);
        }
    }

    public void processData(FileFormat type) {
        // Find the correct processor from the map
        AbstractFileProcessor processor = Optional.ofNullable(processorMap.get(type))
                .orElseThrow(() -> new IllegalArgumentException("Unsupported data processor type: " + type));

        processor.process(); // Execute the template method
    }
}
