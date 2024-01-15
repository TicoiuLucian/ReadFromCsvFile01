package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainClassic {
  public static void main(String[] args) {

    String csvFile = "src/main/resources/expanded_world_population.csv";
    String line = "";
    String csvSplitBy = ","; // CSV delimiter, often a comma or semicolon
    List<MyCsvObject> objects = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
      br.readLine();
      while ((line = br.readLine()) != null) {
        String[] data = line.split(csvSplitBy);
        MyCsvObject myCsvObject = new MyCsvObject(
                data[0],
                Long.parseLong(data[1]),
                data[2],
                Integer.parseInt(data[3]));
        objects.add(myCsvObject);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println(objects);
  }
}