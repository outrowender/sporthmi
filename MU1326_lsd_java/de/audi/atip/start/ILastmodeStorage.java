/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.start;

public interface ILastmodeStorage {
    public int getBrightness();

    public int getKombiBrightness();

    public int getTemperature();

    public int getPressure();

    public int getDistance();

    public int getSpeed();

    public int getConsumption();

    public int getConsumptionElectro();

    public int getVolume();

    public int getSkin();

    public void setBrightness(int var1, boolean var2);

    public void setKombiBrightness(int var1, boolean var2);

    public void setTemperature(int var1, boolean var2);

    public void setConsumption(int var1, boolean var2);

    public void setConsumptionElectro(int var1, boolean var2);

    public void setDistance(int var1, boolean var2);

    public void setSpeed(int var1, boolean var2);

    public void setPressure(int var1, boolean var2);

    public void setVolume(int var1, boolean var2);

    public void setSkin(int var1);
}

