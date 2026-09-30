/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.pag.entry;

import de.audi.remotehmi.util.DeepCloneable;
import de.esolutions.fw.util.commons.Buffer;

public final class PorschePOIEntry
implements DeepCloneable {
    public double latitude;
    public double longitude;
    public String poiName;
    public String phoneNumber;
    public String street;
    public String country;
    public String housenumber;
    public String city;
    public String zipCode;
    public String line1;
    public String line2;

    public PorschePOIEntry() {
    }

    public PorschePOIEntry(double d2, double d3, String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9) {
        this.latitude = d2;
        this.longitude = d3;
        this.poiName = string7;
        this.phoneNumber = string6;
        this.street = string4;
        this.country = string;
        this.housenumber = string5;
        this.city = string2;
        this.zipCode = string3;
        this.line1 = string8;
        this.line2 = string8;
    }

    public PorschePOIEntry(double d2, double d3, String string, String string2, String string3, String string4, String string5, String string6, String string7) {
        this.latitude = d2;
        this.longitude = d3;
        this.poiName = string7;
        this.phoneNumber = string6;
        this.street = string4;
        this.country = string;
        this.housenumber = string5;
        this.city = string2;
        this.zipCode = string3;
        this.line1 = null;
        this.line2 = null;
    }

    public PorschePOIEntry(String string, String string2) {
        this.line1 = string;
        this.line2 = string2;
        this.latitude = Double.MAX_VALUE;
        this.longitude = Double.MAX_VALUE;
        this.poiName = null;
        this.phoneNumber = null;
        this.street = null;
        this.country = null;
        this.housenumber = null;
        this.city = null;
        this.zipCode = null;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append(this.getClass().getName());
        buffer.append(" ]");
        return buffer.toString();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof PorschePOIEntry)) {
            return false;
        }
        PorschePOIEntry porschePOIEntry = (PorschePOIEntry)object;
        return porschePOIEntry.poiName.equals(this.poiName);
    }

    public Object clone(boolean bl) {
        if (bl) {
            return new PorschePOIEntry(this.latitude, this.longitude, this.country, this.city, this.zipCode, this.street, this.housenumber, this.phoneNumber, this.poiName, this.line1, this.line2);
        }
        return this;
    }
}

