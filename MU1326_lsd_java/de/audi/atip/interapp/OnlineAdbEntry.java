/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.interapp.OnlineAdbEntry$FullAdressData;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.organizer.AdbEntry;

public class OnlineAdbEntry {
    private String additionalDescription;
    private AdbEntry adbEntry;
    List adressDataList;
    private boolean isImport;
    private int row;

    public String toString() {
        return new StringBuffer().append("OnlineAdbEntry [additionalDescription=").append(this.additionalDescription).append(", adbEntry=").append(this.adbEntry).append(", adressDataList=").append(this.adressDataList).append(", isImport=").append(this.isImport).append(", row=").append(this.row).append("]").toString();
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

    public void addAdressData(OnlineAdbEntry$FullAdressData onlineAdbEntry$FullAdressData) {
        if (this.adressDataList == null) {
            this.adressDataList = new ArrayList(1);
        }
        this.adressDataList.add(onlineAdbEntry$FullAdressData);
    }
}

