package com.sourcecode.spring.dp.template.file.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CsvFileProcessor extends AbstractFileProcessor {

    @Override
    public FileFormat getFileFormat() {
        return FileFormat.CSV;
    }

    @Override
    protected void readData() {
        log.info("Reading data from a CSV file.");
    }

    @Override
    protected void transformData() {
        log.info("Transforming CSV data to a domain object.");
    }

}
