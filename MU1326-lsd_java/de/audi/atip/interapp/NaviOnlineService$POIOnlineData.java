/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.esolutions.fw.util.commons.Buffer;

public class NaviOnlineService$POIOnlineData {
    public int latitude;
    public int longitude;
    public String line0;
    public String line1;
    public String poiName;
    public String phoneNumber;
    public String street;
    public String country;
    public String housenumber;
    public String city;
    public String zipCode;

    public String toString() {
        Buffer buffer = new Buffer(100);
        buffer.append("POIOnlineData [latitude=").append(this.latitude);
        buffer.append(", longitude=").append(this.longitude);
        buffer.append(", line0=").append(this.line0).append(", line1=").append(this.line1);
        buffer.append(", poiName=").append(this.poiName);
        buffer.append(", phoneNumber=").append(this.phoneNumber);
        buffer.append(", street=").append(this.street);
        buffer.append(", country=").append(this.country);
        buffer.append(", housenumber=").append(this.housenumber);
        buffer.append(", city=").append(this.city);
        buffer.append(", zipCode=").append(this.zipCode);
        return buffer.toString();
    }
}

