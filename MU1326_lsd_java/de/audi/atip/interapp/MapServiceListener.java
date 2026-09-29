/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public interface MapServiceListener {
    public static final int POPUP_TYPE_GOOGLE_OFFLINE;
    public static final int POPUP_TYPE_GOOGLE_NO_DATA;

    default public void onEnterGoogleMapPopup(int n) {
    }
}

