/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public interface ADBSDSServiceListener {
    default public void responseFillAdbPickList(int n) {
    }

    default public void responseFillTelNumberList(int n, String string, int n2, String string2, int[] nArray) {
    }

    default public void responseFillEmailList(int n, String string, int n2, String string2, int n3) {
    }

    default public void responseShowAddresses(int n, int[] nArray, String string) {
    }

    default public void responseOpenEntryDetails(int n, String string) {
    }

    default public void responseGetEntryNames(String[] stringArray) {
    }
}

