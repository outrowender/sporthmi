/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public interface OnlineHMIService {
    public static final int REMOTEHMI_LISTINPUT_ITEMTYPE_TEXTFIELD = 0;
    public static final int REMOTEHMI_LISTINPUT_ITEMTYPE_CHECKBOX = 1;
    public static final int REMOTEHMI_LISTINPUT_ITEMTYPE_ACTION = 2;
    public static final int REMOTEHMI_LISTINPUT_ITEMTYPE_PULLDOWN = 3;

    public void updateRemoteHmiListInputScreenConfiguration(int[] var1);
}

