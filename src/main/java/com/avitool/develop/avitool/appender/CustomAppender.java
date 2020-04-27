package com.avitool.develop.avitool.appender;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

import java.util.ArrayList;
import java.util.List;

public class CustomAppender extends AppenderSkeleton {
    public List<LoggingEvent> eventsList = new ArrayList<>();

    @Override
    protected void append(LoggingEvent loggingEvent) {
        eventsList.add(loggingEvent);
    }

    @Override
    public void close() {

    }

    @Override
    public boolean requiresLayout() {
        return false;
    }
}
