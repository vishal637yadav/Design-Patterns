package com.sourcecode.spring.dp.template.file.processor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractFileProcessor {

    // The template method remains unchanged
    public final void process() {
        readData();
        if (validateData()) {
            transformData();
            saveData();
        } else {
            log.warn("Validation failed for {}. Aborting process.", getFileFormat());
        }
    }

    // NEW: Each subclass must declare its type
    public abstract FileFormat getFileFormat();

    protected abstract void readData();

    protected abstract void transformData();

    protected void saveData() {
        log.info("[{}] Saving transformed data to the database...", getFileFormat());
    }

    protected boolean validateData() {
        log.info("[{}] Performing common data validation...", getFileFormat());
        return true;
    }
}
