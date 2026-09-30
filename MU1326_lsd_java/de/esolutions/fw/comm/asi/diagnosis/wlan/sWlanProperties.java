/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.wlan;

public class sWlanProperties {
    public long msg_id;
    public long mac_AP;
    public long mac_Tethering;
    public int ipProtocolVersion;
    public long ipV4;
    public long subnetmaskV4;
    public String ipV6;
    public String subnetmaskV6;

    public long getMsg_id() {
        return this.msg_id;
    }

    public void setMsg_id(long l) {
        this.msg_id = l;
    }

    public long getMac_AP() {
        return this.mac_AP;
    }

    public void setMac_AP(long l) {
        this.mac_AP = l;
    }

    public long getMac_Tethering() {
        return this.mac_Tethering;
    }

    public void setMac_Tethering(long l) {
        this.mac_Tethering = l;
    }

    public int getIpProtocolVersion() {
        return this.ipProtocolVersion;
    }

    public void setIpProtocolVersion(int n) {
        this.ipProtocolVersion = n;
    }

    public long getIpV4() {
        return this.ipV4;
    }

    public void setIpV4(long l) {
        this.ipV4 = l;
    }

    public long getSubnetmaskV4() {
        return this.subnetmaskV4;
    }

    public void setSubnetmaskV4(long l) {
        this.subnetmaskV4 = l;
    }

    public String getIpV6() {
        return this.ipV6;
    }

    public void setIpV6(String string) {
        this.ipV6 = string;
    }

    public String getSubnetmaskV6() {
        return this.subnetmaskV6;
    }

    public void setSubnetmaskV6(String string) {
        this.subnetmaskV6 = string;
    }

    public sWlanProperties() {
    }

    public sWlanProperties(long l, long l2, long l3, int n, long l4, long l5, String string, String string2) {
        this.msg_id = l;
        this.mac_AP = l2;
        this.mac_Tethering = l3;
        this.ipProtocolVersion = n;
        this.ipV4 = l4;
        this.subnetmaskV4 = l5;
        this.ipV6 = string;
        this.subnetmaskV6 = string2;
    }

    public String toString() {
        return "sWlanProperties{" + "msg_id=" + this.msg_id + ", mac_AP=" + this.mac_AP + ", mac_Tethering=" + this.mac_Tethering + ", ipProtocolVersion=" + this.ipProtocolVersion + ", ipV4=" + this.ipV4 + ", subnetmaskV4=" + this.subnetmaskV4 + ", ipV6=" + this.ipV6 + ", subnetmaskV6=" + this.subnetmaskV6 + "}";
    }
}

