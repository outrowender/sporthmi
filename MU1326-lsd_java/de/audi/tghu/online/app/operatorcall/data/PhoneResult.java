/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.data;

public class PhoneResult {
    private String serviceId;
    private String[] phoneNumber;
    private int transfertype;

    public PhoneResult(String string, String[] stringArray, int n) {
        this.serviceId = string;
        this.phoneNumber = stringArray;
        this.transfertype = n;
    }

    public String getServiceId() {
        return this.serviceId;
    }

    public String[] getPhoneNumber() {
        return this.phoneNumber;
    }

    public int getTransferType() {
        return this.transfertype;
    }
}

