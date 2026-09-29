/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.eni.data;

import de.audi.atip.interapp.bap.eni.data.Address;

public final class Address$Builder {
    private String street;
    private String number;
    private String city;
    private String state;
    private String postalCode;
    private String country;

    public Address$Builder setStreet(String string) {
        this.street = string;
        return this;
    }

    public Address$Builder setNumber(String string) {
        this.number = string;
        return this;
    }

    public Address$Builder setCity(String string) {
        this.city = string;
        return this;
    }

    public Address$Builder setState(String string) {
        this.state = string;
        return this;
    }

    public Address$Builder setPostalCode(String string) {
        this.postalCode = string;
        return this;
    }

    public Address$Builder setCountry(String string) {
        this.country = string;
        return this;
    }

    public Address build() {
        return new Address(this.street, this.number, this.city, this.state, this.postalCode, this.country);
    }
}

