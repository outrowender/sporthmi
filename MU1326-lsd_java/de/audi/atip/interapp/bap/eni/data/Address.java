/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.eni.data;

import de.audi.atip.interapp.bap.eni.data.Address$Builder;

public final class Address {
    private final String street;
    private final String number;
    private final String city;
    private final String state;
    private final String postalCode;
    private final String country;

    public static Address$Builder builder() {
        return new Address$Builder();
    }

    private Address(String string, String string2, String string3, String string4, String string5, String string6) {
        this.street = string;
        this.number = string2;
        this.city = string3;
        this.state = string4;
        this.postalCode = string5;
        this.country = string6;
    }

    public String getStreet() {
        return this.street;
    }

    public String getNumber() {
        return this.number;
    }

    public String getCity() {
        return this.city;
    }

    public String getState() {
        return this.state;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public String getCountry() {
        return this.country;
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.city == null ? 0 : this.city.hashCode());
        n = 31 * n + (this.country == null ? 0 : this.country.hashCode());
        n = 31 * n + (this.number == null ? 0 : this.number.hashCode());
        n = 31 * n + (this.postalCode == null ? 0 : this.postalCode.hashCode());
        n = 31 * n + (this.state == null ? 0 : this.state.hashCode());
        n = 31 * n + (this.street == null ? 0 : this.street.hashCode());
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        Address address = (Address)object;
        if (this.city == null ? address.city != null : !this.city.equals(address.city)) {
            return false;
        }
        if (this.country == null ? address.country != null : !this.country.equals(address.country)) {
            return false;
        }
        if (this.number == null ? address.number != null : !this.number.equals(address.number)) {
            return false;
        }
        if (this.postalCode == null ? address.postalCode != null : !this.postalCode.equals(address.postalCode)) {
            return false;
        }
        if (this.state == null ? address.state != null : !this.state.equals(address.state)) {
            return false;
        }
        return !(this.street == null ? address.street != null : !this.street.equals(address.street));
    }

    public String toString() {
        return new StringBuffer().append("Address [street=").append(this.street).append(", number=").append(this.number).append(", city=").append(this.city).append(", state=").append(this.state).append(", postalCode=").append(this.postalCode).append(", country=").append(this.country).append("]").toString();
    }
}

