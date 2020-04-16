package com.company.logger;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Loggers<T> {

    public Logger log = LogManager.getLogger(Number.class);

    public Loggers(String o) {
        this.log = LogManager.getLogger(o);
    }

}

