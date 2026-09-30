/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.navi.data;

import de.audi.atip.interapp.combi.bap.data.CombiBAPArrayElement;
import de.esolutions.fw.util.commons.Buffer;

public final class CombiBAPPOIListEntry
implements CombiBAPArrayElement {
    int posID;
    int directionSymbolic;
    int poiType;
    int distanceType;
    long distance;
    int unit;
    String mainDescription;
    String street;
    String city;
    String postalCode;

    public CombiBAPPOIListEntry(int n, int n2, int n3, int n4, long l, int n5, String string, String string2, String string3, String string4) {
        this.posID = n;
        this.directionSymbolic = n2;
        this.poiType = n3;
        this.distanceType = n4;
        this.distance = l;
        this.unit = n5;
        this.mainDescription = string;
        this.street = string2;
        this.city = string3;
        this.postalCode = string4;
    }

    public CombiBAPPOIListEntry(int n, int n2, int n3, int n4, long l, int n5, String string) {
        this.posID = n;
        this.directionSymbolic = n2;
        this.poiType = n3;
        this.distanceType = n4;
        this.distance = l;
        this.unit = n5;
        this.mainDescription = string;
    }

    public int getPosID() {
        return this.posID;
    }

    public int getDirectionSymbolic() {
        return this.directionSymbolic;
    }

    public int getPoiType() {
        return this.poiType;
    }

    public int getDistanceType() {
        return this.distanceType;
    }

    public long getDistance() {
        return this.distance;
    }

    public int getUnit() {
        return this.unit;
    }

    public String getMainDescription() {
        return this.mainDescription;
    }

    public String getStreet() {
        return this.street;
    }

    public String getCity() {
        return this.city;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public boolean hasSameContent(CombiBAPArrayElement combiBAPArrayElement) {
        if (combiBAPArrayElement == this) {
            return true;
        }
        if (combiBAPArrayElement instanceof CombiBAPPOIListEntry) {
            CombiBAPPOIListEntry combiBAPPOIListEntry = (CombiBAPPOIListEntry)combiBAPArrayElement;
            return this.posID == combiBAPPOIListEntry.posID && this.directionSymbolic == combiBAPPOIListEntry.directionSymbolic && this.poiType == combiBAPPOIListEntry.poiType && this.distanceType == combiBAPPOIListEntry.distanceType && this.distance == combiBAPPOIListEntry.distance && this.unit == combiBAPPOIListEntry.unit && this.mainDescription.equals(combiBAPPOIListEntry.mainDescription) && this.street.equals(combiBAPPOIListEntry.street) && this.city.equals(combiBAPPOIListEntry.city) && this.postalCode.equals(combiBAPPOIListEntry.postalCode);
        }
        return false;
    }

    public int getDiffRecordAddress(CombiBAPArrayElement combiBAPArrayElement) {
        int n = 0;
        if (combiBAPArrayElement == this) {
            n = -1;
        } else if (combiBAPArrayElement instanceof CombiBAPPOIListEntry) {
            CombiBAPPOIListEntry combiBAPPOIListEntry = (CombiBAPPOIListEntry)combiBAPArrayElement;
            n = CombiBAPPOIListEntry.getRecordAddress(this.posID != combiBAPPOIListEntry.posID, this.directionSymbolic != combiBAPPOIListEntry.directionSymbolic, this.poiType != combiBAPPOIListEntry.poiType, this.distanceType != combiBAPPOIListEntry.distanceType, this.distance != combiBAPPOIListEntry.distance, this.unit != combiBAPPOIListEntry.unit, !this.mainDescription.equals(combiBAPPOIListEntry.mainDescription), !this.street.equals(combiBAPPOIListEntry.street), !this.city.equals(combiBAPPOIListEntry.city), !this.postalCode.equals(combiBAPPOIListEntry.postalCode));
        }
        return n;
    }

    public static int getRecordAddress(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, boolean bl9, boolean bl10) {
        int n = 0;
        if (bl) {
            ++n;
        }
        if (bl2) {
            ++n;
        }
        if (bl3) {
            ++n;
        }
        if (bl4) {
            ++n;
        }
        if (bl5) {
            ++n;
        }
        if (bl6) {
            ++n;
        }
        if (bl7) {
            ++n;
        }
        if (bl8) {
            ++n;
        }
        if (bl9) {
            ++n;
        }
        if (bl10) {
            ++n;
        }
        int n2 = n == 1 && bl ? 15 : (n == 1 && bl2 ? 3 : (n == 1 && (bl5 || bl6) || n == 2 && bl5 && bl6 ? 2 : (n <= 4 && !bl && !bl2 && !bl3 && !bl4 && !bl5 && !bl6 ? 4 : (n <= 6 && !bl && !bl2 && !bl3 && !bl4 ? 1 : (n <= 6 && !bl && !bl8 && !bl9 && !bl10 ? 5 : 0)))));
        return n2;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("CombiBAPPOIListEntry {posID=");
        buffer.append(this.posID);
        buffer.append(" (0x");
        buffer.append(Integer.toHexString(this.posID));
        buffer.append("), directionSymbolic=");
        buffer.append(this.directionSymbolic);
        buffer.append(", poiType=");
        buffer.append(this.poiType);
        buffer.append(", distanceType=");
        buffer.append(this.distanceType);
        buffer.append(", distance=");
        buffer.append(this.distance);
        buffer.append(", unit=");
        buffer.append(this.unit);
        buffer.append(", mainDescription=");
        buffer.append(this.mainDescription);
        buffer.append(", street=");
        buffer.append(this.street);
        buffer.append(", city=");
        buffer.append(this.city);
        buffer.append(", postalCode=");
        buffer.append(this.postalCode);
        buffer.append("}");
        return buffer.toString();
    }
}

