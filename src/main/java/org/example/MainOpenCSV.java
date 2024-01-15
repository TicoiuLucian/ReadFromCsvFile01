package org.example;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.util.List;

public class MainOpenCSV {
  public static void main(
          String[] args) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {


    //------------------Read from csv file
    CSVReader reader = new CSVReader(new FileReader("src/main/resources" +
                                                            "/expanded_world_population.csv"));
    CsvToBean<CsvObject> csvReader = new CsvToBeanBuilder<CsvObject>(reader)
            .withType(CsvObject.class)
            .withSeparator(',')
            .withIgnoreLeadingWhiteSpace(true)
            .withIgnoreEmptyLine(true)
            .withSkipLines(1) //skip header
            .build();

    List<CsvObject> results = csvReader.parse();

    System.out.println(results);
    reader.close();

    /////---------------------Write to csv file---------------------
    Writer writer = new BufferedWriter(new FileWriter("src/main/resources/expanded_world_population.csv"));

    StatefulBeanToCsvBuilder<CsvObject> csvWriter = new StatefulBeanToCsvBuilder<>(writer);

    StatefulBeanToCsv<CsvObject> beanWriter = csvWriter.withApplyQuotesToAll(false)
            .withSeparator(',')
            .build();

    List<CsvObject> objects = List.of(
            new CsvObject("Country1", 123, "Language1", 50),
            new CsvObject("Country2", 124, "Language2", 50),
            new CsvObject("Country3", 125, "Language3", 50));
    results.addAll(objects);
    beanWriter.write(results);

    writer.close();

  }

}
