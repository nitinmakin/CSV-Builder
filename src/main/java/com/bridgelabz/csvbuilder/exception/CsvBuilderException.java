package com.bridgelabz.csvbuilder.exception;

public class CsvBuilderException extends Exception {

    public enum ExceptionType {
        CENSUS_FILE_PROBLEM
    }

    public ExceptionType type;

    public CsvBuilderException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
