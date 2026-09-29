/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi;

public class RemoteHMILocation {
    double longitude;
    double latitude;
    String country;
    String countryAbbreviation;
    String town;
    String street;
    String houseNumber;
    String state;

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double d2) {
        this.longitude = d2;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double d2) {
        this.latitude = d2;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String string) {
        this.country = string;
    }

    public String getCountryAbbreviation() {
        return this.countryAbbreviation;
    }

    public void setCountryAbbreviation(String string) {
        this.countryAbbreviation = string;
    }

    public String getTown() {
        return this.town;
    }

    public void setTown(String string) {
        this.town = string;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String string) {
        this.street = string;
    }

    public String getHouseNumber() {
        return this.houseNumber;
    }

    public void setHouseNumber(String string) {
        this.houseNumber = string;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String string) {
        this.state = string;
    }
}

