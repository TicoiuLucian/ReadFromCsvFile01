package org.example;

import com.opencsv.bean.CsvBindByName;

public class CsvObject {
  @CsvBindByName(column = "Country")
  private String country;

  @CsvBindByName(column = "Population")
  private long population;

  @CsvBindByName(column = "Language")
  private String language;
  
  @CsvBindByName(column = "Max Temperature (°C)")
  private int maxTemp;

  public String getCountry() {
    return country;
  }

  public void setCountry(final String country) {
    this.country = country;
  }

  public long getPopulation() {
    return population;
  }

  public void setPopulation(final long population) {
    this.population = population;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(final String language) {
    this.language = language;
  }

  public int getMaxTemp() {
    return maxTemp;
  }

  public void setMaxTemp(final int maxTemp) {
    this.maxTemp = maxTemp;
  }

  public CsvObject(final String country, final long population, final String language, final int maxTemp) {
    this.country = country;
    this.population = population;
    this.language = language;
    this.maxTemp = maxTemp;
  }

  public CsvObject() {
  }

  @Override
  public String toString() {
    return "CsvObject{" +
            "country='" + country + '\'' +
            ", population=" + population +
            ", language='" + language + '\'' +
            ", maxTemp=" + maxTemp +
            '}';
  }
}
