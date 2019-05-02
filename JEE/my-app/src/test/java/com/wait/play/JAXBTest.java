package com.wait.play;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

import com.wait.play.Person.Gender;

/**
 * 1. Read and write XML with JAXB 2. Use glassfish to generate xml schema ``` schemagen -d "Your
 * output location" "Your Java File or Package Location" ```
 */
public class JAXBTest {

  private final Logger logger = Logger.getLogger("JAXBTest");


  @Test
  public void marshaller() {
    Person person = new Person();
    person.setGender(Gender.MALE);
    person.setId(007l);
    person.setName("Bond James");
    Car car = new Car();
    car.setId(1);
    car.setName("BWM");
    House house = new House();
    house.setId(1);
    house.setAddress("SH");
    person.getProperties().add(car);
    person.getProperties().add(house);
    a
    ClassLoader classLoader = getClass().getClassLoader();
    String path = classLoader.getResource("person.xml").getPath();
    logger.info(path);
    try {
      OutputStream outputStream = new FileOutputStream(path);
      JAXBContext jc = JAXBContext.newInstance(Person.class);
      Marshaller marshaller = jc.createMarshaller();
      marshaller.marshal(person, outputStream);
      logger.info(path);
    } catch (Exception e) {
      logger.severe(e.getMessage());
      e.printStackTrace();
    }

  }

  @Test
  public void unMarshaller() {
    ClassLoader classLoader = getClass().getClassLoader();
    String path = classLoader.getResource("person.xml").getPath();
    try {
      JAXBContext jc = JAXBContext.newInstance(Person.class);
      Unmarshaller unmarshaller = jc.createUnmarshaller();
      InputStream inputStream = new FileInputStream(path);
      Person person = (Person) unmarshaller.unmarshal(inputStream);
      logger.info(person.getName());
      logger.info(person.getId().toString());
      logger.info(person.getGender().name());
    } catch (Exception e) {
      logger.severe(e.getMessage());
      e.printStackTrace();
    }
  }


}
