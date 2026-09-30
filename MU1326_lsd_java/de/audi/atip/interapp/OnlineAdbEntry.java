/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.AddressData;

public class OnlineAdbEntry {
    private String additionalDescription;
    private AdbEntry adbEntry;
    List adressDataList;
    private boolean isImport;
    private int row;

    public String toString() {
        return "OnlineAdbEntry [additionalDescription=" + this.additionalDescription + ", adbEntry=" + this.adbEntry + ", adressDataList=" + this.adressDataList + ", isImport=" + this.isImport + ", row=" + this.row + "]";
    }

    public OnlineAdbEntry(AdbEntry adbEntry, String string) {
        this.adbEntry = adbEntry;
        this.additionalDescription = string;
    }

    public void setImport(boolean bl) {
        this.isImport = bl;
    }

    public AdbEntry getAdbEntry() {
        return this.adbEntry;
    }

    public String getAdditionalDescription() {
        return this.additionalDescription;
    }

    public boolean isImport() {
        return this.isImport;
    }

    public List getAddressDataList() {
        return this.adressDataList;
    }

    public void setRowId(int n) {
        this.row = n;
    }

    public int getRowId() {
        return this.row;
    }

    public void addAdressData(FullAdressData fullAdressData) {
        if (this.adressDataList == null) {
            this.adressDataList = new ArrayList(1);
        }
        this.adressDataList.add(fullAdressData);
    }

    public static class FullAdressData {
        public NavLocationWgs84 navLocation;
        public AddressData adress;

        public String toString() {
            return "FullAdressData [navLocation=" + this.navLocation + ", adress=" + this.adress + "]";
        }
    }
}

