/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.eni.data;

import de.audi.atip.interapp.bap.eni.data.Address;
import de.audi.atip.interapp.bap.eni.data.Destination$Builder;
import de.audi.atip.interapp.bap.eni.data.GeoCoordinates;
import de.audi.atip.interapp.bap.eni.data.PhoneNumber;
import de.esolutions.fw.util.commons.Buffer;

public final class Destination {
    private final int internalId;
    private final String name;
    private final GeoCoordinates geoCoordinates;
    private final int destinationKind;
    private final int poiKind;
    private final String poiExtension;
    private final int tourId;
    private final int stopOverSequenceNumber;
    private final Address address;
    private final PhoneNumber phoneNumber;

    public static Destination$Builder builder() {
        return new Destination$Builder();
    }

    private Destination(int n, String string, GeoCoordinates geoCoordinates, int n2, int n3, String string2, int n4, int n5, Address address, PhoneNumber phoneNumber) {
        this.internalId = n;
        this.name = string;
        this.geoCoordinates = geoCoordinates;
        this.destinationKind = n2;
        this.poiKind = n3;
        this.poiExtension = string2;
        this.tourId = n4;
        this.stopOverSequenceNumber = n5;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public int getInternalId() {
        return this.internalId;
    }

    public String getName() {
        return this.name;
    }

    public GeoCoordinates getGeoCoordinates() {
        return this.geoCoordinates;
    }

    public int getDestinationKind() {
        return this.destinationKind;
    }

    public int getPoiKind() {
        return this.poiKind;
    }

    public String getPoiExtension() {
        return this.poiExtension;
    }

    public int getTourId() {
        return this.tourId;
    }

    public int getStopOverSequenceNumber() {
        return this.stopOverSequenceNumber;
    }

    public Address getAddress() {
        return this.address;
    }

    public PhoneNumber getPhoneNumber() {
        return this.phoneNumber;
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.address == null ? 0 : this.address.hashCode());
        n = 31 * n + this.destinationKind;
        n = 31 * n + (this.geoCoordinates == null ? 0 : this.geoCoordinates.hashCode());
        n = 31 * n + this.internalId;
        n = 31 * n + (this.name == null ? 0 : this.name.hashCode());
        n = 31 * n + (this.phoneNumber == null ? 0 : this.phoneNumber.hashCode());
        n = 31 * n + (this.poiExtension == null ? 0 : this.poiExtension.hashCode());
        n = 31 * n + this.poiKind;
        n = 31 * n + this.stopOverSequenceNumber;
        n = 31 * n + this.tourId;
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
        Destination destination = (Destination)object;
        if (this.address == null ? destination.address != null : !this.address.equals(destination.address)) {
            return false;
        }
        if (this.destinationKind != destination.destinationKind) {
            return false;
        }
        if (this.geoCoordinates == null ? destination.geoCoordinates != null : !this.geoCoordinates.equals(destination.geoCoordinates)) {
            return false;
        }
        if (this.internalId != destination.internalId) {
            return false;
        }
        if (this.name == null ? destination.name != null : !this.name.equals(destination.name)) {
            return false;
        }
        if (this.phoneNumber == null ? destination.phoneNumber != null : !this.phoneNumber.equals(destination.phoneNumber)) {
            return false;
        }
        if (this.poiExtension == null ? destination.poiExtension != null : !this.poiExtension.equals(destination.poiExtension)) {
            return false;
        }
        if (this.poiKind != destination.poiKind) {
            return false;
        }
        if (this.stopOverSequenceNumber != destination.stopOverSequenceNumber) {
            return false;
        }
        return this.tourId == destination.tourId;
    }

    public String toString() {
        return new Buffer("Poi [name=").append(this.name).append(", internalId=").append(this.internalId).append(", geoCoordinates=").append(this.geoCoordinates).append(", destinationKind=").append(this.destinationKind).append(", poiKind=").append(this.poiKind).append(", poiExtension=").append(this.poiExtension).append(", tourId=").append(this.tourId).append(", stopOverSequenceNumber=").append(this.stopOverSequenceNumber).append(", address=").append(this.address).append(", phoneNumber=").append(this.phoneNumber).append("]").toString();
    }
}

