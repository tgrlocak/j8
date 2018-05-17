package com.tgrl.exp.j8.model;

public class DragonDistance {

  public Dragon dragon;

  public static DragonDistance worstMatch() {
    return new DragonDistance();
  }

  public static DragonDistance closest(DragonDistance dist1, DragonDistance dist2) {
    return dist1;
  }

  public Dragon getDragon() {
    return dragon;
  }

  public void setDragon(Dragon dragon) {
    this.dragon = dragon;
  }
}
