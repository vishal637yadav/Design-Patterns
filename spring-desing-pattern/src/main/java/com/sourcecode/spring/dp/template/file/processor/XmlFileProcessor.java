package com.sourcecode.spring.dp.template.file.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class XmlFileProcessor extends AbstractFileProcessor {

    @Override
    public FileFormat getFileFormat() {
        return FileFormat.XML;
    }

    @Override
    protected void readData() {
        log.info("Reading data from a XML file.");
    }

    @Override
    protected void transformData() {
        log.info("Transforming data from a XML file.");
    }

}