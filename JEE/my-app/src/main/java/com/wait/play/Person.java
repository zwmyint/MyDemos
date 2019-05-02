package com.wait.play;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = {"name", "id", "gender", "properties"})
public class Person {

  @XmlElement
  private String name;

  @XmlAttribute
  private Long id;


  @XmlElement
  private Gender gender;


  @XmlElements(value = {
      @XmlElement(name = "car", type = Car.class),
      @XmlElement(name = "house", type = House.class)
  })
  private List properties = new ArrayList();

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public List getProperties() {
    return properties;
  }

  public void setProperties(List properties) {
    this.properties = properties;
  }

  @XmlType
  @XmlEnum
  public enum Gender {
    @XmlEnumValue("M")
    MALE,
    @XmlEnumValue("F")
    FEMALE

  }

  ;
}




