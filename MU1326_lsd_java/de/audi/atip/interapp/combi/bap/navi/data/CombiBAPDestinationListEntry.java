/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.navi.data;

import de.audi.atip.interapp.combi.bap.data.CombiBAPArrayElement;
import de.audi.atip.interapp.combi.bap.navi.data.CombiBAPNaviDestination;
import de.audi.atip.interapp.combi.bap.navi.data.FormattedDestination;
import de.esolutions.fw.util.commons.Buffer;

public final class CombiBAPDestinationListEntry
implements CombiBAPArrayElement {
    private int posID;
    private int poiType;
    private String description;
    private final FormattedDestination formattedDestination;
    private CombiBAPNaviDestination[] addressList;

    public CombiBAPDestinationListEntry(int n, CombiBAPNaviDestination[] combiBAPNaviDestinationArray) {
        this(n, 0, "", combiBAPNaviDestinationArray);
    }

    public CombiBAPDestinationListEntry(int n, int n2, CombiBAPNaviDestination[] combiBAPNaviDestinationArray) {
        this(n, n2, "", combiBAPNaviDestinationArray);
    }

    public CombiBAPDestinationListEntry(int n, int n2, String string, CombiBAPNaviDestination[] combiBAPNaviDestinationArray) {
        this(n, n2, string, combiBAPNaviDestinationArray, null);
    }

    public CombiBAPDestinationListEntry(int n, int n2, String string, CombiBAPNaviDestination[] combiBAPNaviDestinationArray, FormattedDestination formattedDestination) {
        this.posID = n;
        this.poiType = n2;
        this.description = string;
        this.addressList = combiBAPNaviDestinationArray;
        this.formattedDestination = formattedDestination;
    }

    public int getPosID() {
        return this.posID;
    }

    public int getPOIType() {
        return this.poiType;
    }

    public String getDescription() {
        if (this.description != null && this.description.length() > 0) {
            return this.description;
        }
        if (this.addressList != null && this.addressList.length > 0) {
            Buffer buffer = new Buffer();
            CombiBAPDestinationListEntry.appendToBuffer(buffer, this.addressList[0].getLastName());
            CombiBAPDestinationListEntry.appendToBuffer(buffer, this.addressList[0].getFirstName());
            if (buffer.length() == 0) {
                CombiBAPDestinationListEntry.appendToBuffer(buffer, this.addressList[0].getCity());
                CombiBAPDestinationListEntry.appendToBuffer(buffer, this.addressList[0].getCityPart());
                CombiBAPDestinationListEntry.appendToBuffer(buffer, this.addressList[0].getPostalCode());
                CombiBAPDestinationListEntry.appendToBuffer(buffer, this.addressList[0].getStreet());
                CombiBAPDestinationListEntry.appendToBuffer(buffer, this.addressList[0].getHouseNumber());
            }
            return buffer.toString();
        }
        return "[description not available]";
    }

    private static void appendToBuffer(Buffer buffer, String string) {
        if (string != null && string.length() > 0) {
            if (buffer.length() > 0) {
                buffer.append(", ");
            }
            buffer.append(string);
        }
    }

    public CombiBAPNaviDestination[] getAddressList() {
        return this.addressList;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("CombiBAPDestinationListEntry {posID=");
        buffer.append(this.posID);
        buffer.append(" (0x");
        buffer.append(Integer.toHexString(this.posID));
        buffer.append("), poiType=");
        buffer.append(this.poiType);
        buffer.append(", description=");
        buffer.append(this.getDescription());
        buffer.append(", addressList=");
        if (this.addressList != null) {
            for (int i2 = 0; i2 < this.addressList.length; ++i2) {
                buffer.append("\n");
                buffer.append(this.addressList[i2].toString());
            }
        } else {
            buffer.append("null");
        }
        buffer.append("}");
        return buffer.toString();
    }

    public boolean hasSameContent(CombiBAPArrayElement combiBAPArrayElement) {
        if (combiBAPArrayElement == this) {
            return true;
        }
        if (combiBAPArrayElement instanceof CombiBAPDestinationListEntry) {
            CombiBAPDestinationListEntry combiBAPDestinationListEntry = (CombiBAPDestinationListEntry)combiBAPArrayElement;
            return this.posID == combiBAPDestinationListEntry.posID && this.poiType == combiBAPDestinationListEntry.poiType && this.getDescription().equals(combiBAPDestinationListEntry.getDescription());
        }
        return false;
    }

    public int getDiffRecordAddress(CombiBAPArrayElement combiBAPArrayElement) {
        int n = 0;
        if (this.hasSameContent(combiBAPArrayElement)) {
            n = -1;
        } else if (combiBAPArrayElement instanceof CombiBAPDestinationListEntry) {
            CombiBAPDestinationListEntry combiBAPDestinationListEntry = (CombiBAPDestinationListEntry)combiBAPArrayElement;
            n = CombiBAPDestinationListEntry.getRecordAddress(this.posID != combiBAPDestinationListEntry.posID, this.poiType != combiBAPDestinationListEntry.poiType, !this.getDescription().equals(combiBAPDestinationListEntry.getDescription()));
        }
        return n;
    }

    public static int getRecordAddress(boolean bl, boolean bl2, boolean bl3) {
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
        int n2 = n == 0 ? -1 : (n == 1 && bl ? 15 : (n == 1 && bl3 ? 1 : (n == 1 && bl2 ? 2 : 0)));
        return n2;
    }

    public FormattedDestination getFormattedDestination() {
        return this.formattedDestination;
    }

    public boolean hasFormattedDestination() {
        return this.formattedDestination != null;
    }
}

