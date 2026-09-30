/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public interface MapServiceListener {
    public static final int POPUP_TYPE_GOOGLE_OFFLINE = 0;
    public static final int POPUP_TYPE_GOOGLE_NO_DATA = 1;

    public void onEnterGoogleMapPopup(int var1);
}

