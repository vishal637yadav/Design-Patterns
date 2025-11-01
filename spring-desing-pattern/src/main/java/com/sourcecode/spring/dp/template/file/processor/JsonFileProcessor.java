package com.sourcecode.spring.dp.template.file.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JsonFileProcessor extends AbstractFileProcessor {

    @Override
    public FileFormat getFileFormat() {
        return FileFormat.JSON;
    }

    @Override
    protected void readData() {
        log.info("Reading data from a JSON file.");
    }

    @Override
    protected void transformData() {
        log.info("Transforming JSON data to a domain object.");
    }

}
