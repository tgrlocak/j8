package com.tgrl.exp.j8.model;

import java.util.Collections;
import java.util.List;

public class Dragon {

  private String name;
  private String color;

  public Dragon() {}

  public Dragon(String name, String color) {
    this.name = name;
    this.color = color;
  }

  public boolean isGreen() {
    return color.equals("green");
  }
  
  public DragonDistance distance(Location location) {
    
    return new DragonDistance();
  }

  public static List<Dragon> getDragons() {
    List<Dragon> dragons = Collections.emptyList();
    dragons.add(new Dragon("Viserion", "white"));
    dragons.add(new Dragon("Drogon", "green"));
    dragons.add(new Dragon("Rhaegal", "red"));
    return dragons;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }


}
