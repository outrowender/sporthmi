/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.phone.data;

import de.audi.atip.interapp.combi.bap.data.CombiBAPArrayElement;
import de.audi.atip.interapp.combi.bap.navi.data.CombiBAPNaviDestination;
import de.esolutions.fw.util.commons.Buffer;

public final class CombiBAPAddressListEntry
implements CombiBAPArrayElement {
    private int posID;
    private CombiBAPNaviDestination destination;

    public CombiBAPAddressListEntry(int n, CombiBAPNaviDestination combiBAPNaviDestination) {
        this.posID = n;
        this.destination = combiBAPNaviDestination;
    }

    @Override
    public int getPosID() {
        return this.posID;
    }

    public void setPosID(int n) {
        this.posID = n;
    }

    public String getLastName() {
        return this.destination.getLastName();
    }

    public String getFirstName() {
        return this.destination.getFirstName();
    }

    public String getStreet() {
        return this.destination.getStreet();
    }

    public String getCity() {
        return this.destination.getCity();
    }

    public String getRegion() {
        return this.destination.getState();
    }

    public String getPostalCode() {
        return this.destination.getPostalCode();
    }

    public String getCountry() {
        return this.destination.getCountry();
    }

    public String getCoordinates() {
        Buffer buffer = new Buffer();
        buffer.append(this.destination.getNauticLatitude());
        buffer.append(buffer.length() == 0 ? "" : ";");
        buffer.append(this.destination.getNauticLongitude());
        return buffer.toString();
    }

    public String getPOIDescription() {
        return this.destination.getPOIDescription();
    }

    public int getPOIType() {
        return this.destination.getPOIType();
    }

    public int getAddressType() {
        return this.destination.getAddressType();
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("CombiBAPAddressListEntry {posID=");
        buffer.append(this.posID);
        buffer.append(" (0x");
        buffer.append(Integer.toHexString(this.posID));
        buffer.append("), destination=");
        buffer.append(this.destination);
        buffer.append("}");
        return buffer.toString();
    }

    @Override
    public boolean hasSameContent(CombiBAPArrayElement combiBAPArrayElement) {
        if (combiBAPArrayElement == this) {
            return true;
        }
        if (combiBAPArrayElement instanceof CombiBAPAddressListEntry) {
            CombiBAPAddressListEntry combiBAPAddressListEntry = (CombiBAPAddressListEntry)combiBAPArrayElement;
            return this.posID == combiBAPAddressListEntry.posID && this.destination.equals(combiBAPAddressListEntry.destination);
        }
        return false;
    }

    @Override
    public int getDiffRecordAddress(CombiBAPArrayElement combiBAPArrayElement) {
        int n = 0;
        if (combiBAPArrayElement == this) {
            n = -1;
        } else if (combiBAPArrayElement instanceof CombiBAPAddressListEntry) {
            CombiBAPAddressListEntry combiBAPAddressListEntry = (CombiBAPAddressListEntry)combiBAPArrayElement;
            n = CombiBAPAddressListEntry.getRecordAddress(this.posID != combiBAPAddressListEntry.posID, !this.destination.getLastName().equals(combiBAPAddressListEntry.destination.getLastName()), !this.destination.getFirstName().equals(combiBAPAddressListEntry.destination.getFirstName()), !this.destination.getStreet().equals(combiBAPAddressListEntry.destination.getStreet()), !this.destination.getCity().equals(combiBAPAddressListEntry.destination.getCity()), !this.destination.getState().equals(combiBAPAddressListEntry.destination.getState()), !this.destination.getPostalCode().equals(combiBAPAddressListEntry.destination.getPostalCode()), !this.destination.getCountry().equals(combiBAPAddressListEntry.destination.getCountry()), !this.getCoordinates().equals(combiBAPAddressListEntry.getCoordinates()), !this.destination.getPOIDescription().equals(combiBAPAddressListEntry.destination.getPOIDescription()), this.destination.getPOIType() != combiBAPAddressListEntry.destination.getPOIType(), this.destination.getAddressType() != combiBAPAddressListEntry.destination.getAddressType());
        }
        return n;
    }

    public static int getRecordAddress(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, boolean bl9, boolean bl10, boolean bl11, boolean bl12) {
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
        if (bl11) {
            ++n;
        }
        if (bl12) {
            ++n;
        }
        int n2 = n == 0 ? -1 : (n == 1 && bl ? 15 : (n == 1 && (bl4 || bl5) || n == 2 && bl4 && bl5 ? 6 : (n == 1 && (bl10 || bl11) || n == 2 && bl10 && bl11 ? 5 : (n <= 5 && !bl && !bl2 && !bl3 && !bl6 && !bl8 && !bl10 && !bl11 ? 4 : (n <= 6 && !bl && !bl2 && !bl3 && !bl6 && !bl10 && !bl11 ? 1 : (n <= 9 && !bl && !bl2 && !bl3 ? 3 : 0))))));
        return n2;
    }
}

