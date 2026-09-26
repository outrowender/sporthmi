/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.esolutions.fw.util.commons.Buffer;

public class NaviService$NaviDetails {
    public String country;
    public String countryAbbreviation;
    public String state;
    public String stateAbbreviation;
    public String city;
    public String cityStringID;
    public String street;
    public String streetStringID;
    public String houseNumber;
    public String houseNumberStringID;
    public long poiID;
    public String poiName;
    public String provinceOrPrefecture;
    public String provinceOrPrefectureStringID;
    public String placeName;
    public String placeNameStringID;
    public String ward;
    public String wardStringID;
    public String chome;
    public String chomeStringID;

    public String toString() {
        Buffer buffer = new Buffer("country=");
        buffer.append(this.country).append(" (").append(this.countryAbbreviation).append("), state=").append(this.state).append(" (").append(this.stateAbbreviation).append("), city=").append(this.city).append(" (").append(this.cityStringID).append("), street=").append(this.street).append(" (").append(this.streetStringID).append("), houseNumber=").append(this.houseNumber).append(" (").append(this.houseNumberStringID).append("), poiName=").append(this.poiName).append(" (").append(this.poiID).append("), provinceOrPrefecture=").append(this.provinceOrPrefecture).append(" (").append(this.provinceOrPrefectureStringID).append("), placeName=").append(this.placeName).append(" (").append(this.placeNameStringID).append("), ward=").append(this.ward).append(" (").append(this.wardStringID).append("), chome=").append(this.chome).append(" (").append(this.chomeStringID).append(")");
        return buffer.toString();
    }
}

