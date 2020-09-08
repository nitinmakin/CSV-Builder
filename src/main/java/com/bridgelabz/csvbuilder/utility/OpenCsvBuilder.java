package com.bridgelabz.csvbuilder.utility;

import com.bridgelabz.csvbuilder.exception.CsvBuilderException;
import com.bridgelabz.csvbuilder.service.ICsvBuilder;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.Reader;
import java.util.Iterator;
import java.util.List;

public class OpenCsvBuilder implements ICsvBuilder {
    @Override
    public Iterator getCSVFileIterator(Reader reader,
                                       Class csvClass) throws CsvBuilderException {
        return this.getCsvBean(reader,csvClass).iterator();
    }

    @Override
    public List getCSVFileList(Reader reader, Class csvClass) throws CsvBuilderException {
        return this.getCsvBean(reader,csvClass).parse();
    }

    private CsvToBean getCsvBean(Reader reader, Class csvClass) throws CsvBuilderException {
        try {
            CsvToBeanBuilder csvToBeanBuilder = new CsvToBeanBuilder(reader);
            csvToBeanBuilder.withType(csvClass);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            return csvToBeanBuilder.build();
        } catch (IllegalStateException e) {
            throw new CsvBuilderException(e.getMessage(),
                    CsvBuilderException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
    }
}
