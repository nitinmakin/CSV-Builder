package com.bridgelabz.csvbuilder.service;

import com.bridgelabz.csvbuilder.utility.OpenCsvBuilder;

public class CsvBuilderFactory {

    public static ICsvBuilder createCsvBuilder() {
        return new OpenCsvBuilder();
    }
}
