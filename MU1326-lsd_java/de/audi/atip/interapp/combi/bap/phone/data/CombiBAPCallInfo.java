/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.phone.data;

import de.esolutions.fw.util.commons.Buffer;

public final class CombiBAPCallInfo {
    private static final String EMPTY_STRING;
    private static final int EMPTY_PICTURE_ID;
    private String pbName;
    private String telNumber;
    private int category;
    private String pictureURL;
    private int pictureID;
    private int telCallType;

    public CombiBAPCallInfo() {
        this("", "", 0, 0, "", -1);
    }

    public CombiBAPCallInfo(String string, String string2, int n, int n2) {
        this(string, string2, n, n2, "", -1);
    }

    public CombiBAPCallInfo(String string, String string2, int n, int n2, String string3, int n3) {
        this.pbName = string;
        this.telNumber = string2;
        this.category = n2;
        this.pictureURL = string3;
        this.pictureID = n3;
        this.telCallType = n;
    }

    public String getPbName() {
        return this.pbName;
    }

    public void setPbName(String string) {
        this.pbName = string;
    }

    public String getTelNumber() {
        return this.telNumber;
    }

    public void setTelNumber(String string) {
        this.telNumber = string;
    }

    public int getTelCallType() {
        return this.telCallType;
    }

    public void setTelCallType(int n) {
        this.telCallType = n;
    }

    public int getCategory() {
        return this.category;
    }

    public void setCategory(int n) {
        this.category = n;
    }

    public String getPictureURL() {
        return this.pictureURL;
    }

    public void setPictureURL(String string) {
        this.pictureURL = string;
    }

    public int getPictureID() {
        return this.pictureID;
    }

    public void setPictureID(int n) {
        this.pictureID = n;
    }

    public void setPicture(int n, String string) {
        this.pictureID = n;
        this.pictureURL = string;
    }

    public boolean equals(Object object) {
        if (object instanceof CombiBAPCallInfo) {
            CombiBAPCallInfo combiBAPCallInfo = (CombiBAPCallInfo)object;
            boolean bl = false;
            boolean bl2 = false;
            boolean bl3 = false;
            boolean bl4 = false;
            boolean bl5 = false;
            boolean bl6 = false;
            bl = this.pbName == null ? combiBAPCallInfo.pbName == null : this.pbName.equals(combiBAPCallInfo.pbName);
            bl2 = this.telNumber == null ? combiBAPCallInfo.telNumber == null : this.telNumber.equals(combiBAPCallInfo.telNumber);
            bl4 = this.category == combiBAPCallInfo.category;
            boolean bl7 = bl3 = this.telCallType == combiBAPCallInfo.telCallType;
            bl5 = this.pictureURL == null ? combiBAPCallInfo.pictureURL == null : this.pictureURL.equals(combiBAPCallInfo.pictureURL);
            bl6 = this.pictureID == combiBAPCallInfo.pictureID;
            return bl && bl2 && bl3 && bl4 && bl5 && bl6;
        }
        return false;
    }

    public int hashCode() {
        int n = 11;
        int n2 = 29;
        n = n * n2 + (this.pbName == null ? 0 : this.pbName.hashCode());
        n = n * n2 + (this.telNumber == null ? 0 : this.telNumber.hashCode());
        n = n * n2 + this.category;
        n = n * n2 + (this.pictureURL == null ? 0 : this.pictureURL.hashCode());
        n = n * n2 + this.pictureID;
        n = n * n2 + this.telCallType;
        return n;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("CombiBAPCallInfo {pbName=").append(this.pbName);
        buffer.append(", telNumber=").append(this.telNumber);
        buffer.append(", telCallType=").append(this.telCallType);
        buffer.append(", category=").append(this.category);
        buffer.append(", pictureURL=").append(this.pictureURL);
        buffer.append(", pictureID=").append(this.pictureID);
        buffer.append("}");
        return buffer.toString();
    }
}

