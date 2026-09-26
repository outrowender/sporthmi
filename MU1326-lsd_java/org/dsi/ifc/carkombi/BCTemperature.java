/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

public class BCTemperature {
    public int state;
    public float temperatureValue;
    public int temperatureUnit;

    public BCTemperature() {
        this.state = 0;
        this.temperatureValue = 0.0f;
        this.temperatureUnit = 0;
    }

    public BCTemperature(int n, float f2, int n2) {
        this.state = n;
        this.temperatureValue = f2;
        this.temperatureUnit = n2;
    }

    public int getState() {
        return this.state;
    }

    public float getTemperatureValue() {
        return this.temperatureValue;
    }

    public int getTemperatureUnit() {
        return this.temperatureUnit;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("BCTemperature(state=");
        stringBuffer.append(this.state);
        stringBuffer.append(",temperatureValue=");
        stringBuffer.append(this.temperatureValue);
        stringBuffer.append(",temperatureUnit=");
        stringBuffer.append(this.temperatureUnit);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

