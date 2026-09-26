/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.eni.data;

import de.audi.atip.interapp.bap.eni.data.Address;
import de.audi.atip.interapp.bap.eni.data.Destination;
import de.audi.atip.interapp.bap.eni.data.GeoCoordinates;
import de.audi.atip.interapp.bap.eni.data.PhoneNumber;

public final class Destination$Builder {
    private int internalId;
    private String name;
    private GeoCoordinates geoCoordinates;
    private int destinationKind;
    private int poiKind;
    private String poiExtension;
    private int tourId;
    private int stopOverSequenceNumber;
    private Address address;
    private PhoneNumber phoneNumber;

    public Destination$Builder setInternalId(int n) {
        this.internalId = n;
        return this;
    }

    public Destination$Builder setName(String string) {
        this.name = string;
        return this;
    }

    public Destination$Builder setGeoCoordinates(GeoCoordinates geoCoordinates) {
        this.geoCoordinates = geoCoordinates;
        return this;
    }

    public Destination$Builder setDestinationKind(int n) {
        this.destinationKind = n;
        return this;
    }

    public Destination$Builder setPoiKind(int n) {
        this.poiKind = n;
        return this;
    }

    public Destination$Builder setPoiExtension(String string) {
        this.poiExtension = string;
        return this;
    }

    public Destination$Builder setTourId(int n) {
        this.tourId = n;
        return this;
    }

    public Destination$Builder setStopOverSequenceNumber(int n) {
        this.stopOverSequenceNumber = n;
        return this;
    }

    public Destination$Builder setAddress(Address address) {
        this.address = address;
        return this;
    }

    public Destination$Builder setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Destination build() {
        return new Destination(this.internalId, this.name, this.geoCoordinates, this.destinationKind, this.poiKind, this.poiExtension, this.tourId, this.stopOverSequenceNumber, this.address, this.phoneNumber);
    }
}

