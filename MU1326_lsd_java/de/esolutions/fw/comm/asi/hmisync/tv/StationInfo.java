/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.tv;

public class StationInfo {
    public long id;
    public String name;
    public int serviceType;
    public int contentGroup;

    public long getId() {
        return this.id;
    }

    public void setId(long l) {
        this.id = l;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }

    public int getServiceType() {
        return this.serviceType;
    }

    public void setServiceType(int n) {
        this.serviceType = n;
    }

    public int getContentGroup() {
        return this.contentGroup;
    }

    public void setContentGroup(int n) {
        this.contentGroup = n;
    }

    public StationInfo() {
    }

    public StationInfo(long l, String string, int n, int n2) {
        this.id = l;
        this.name = string;
        this.serviceType = n;
        this.contentGroup = n2;
    }

    public String toString() {
        return "StationInfo{" + "id=" + this.id + ", name=" + this.name + ", serviceType=" + this.serviceType + ", contentGroup=" + this.contentGroup + "}";
    }
}

