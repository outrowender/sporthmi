/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public interface OnlineHMIService {
    public static final int REMOTEHMI_LISTINPUT_ITEMTYPE_TEXTFIELD;
    public static final int REMOTEHMI_LISTINPUT_ITEMTYPE_CHECKBOX;
    public static final int REMOTEHMI_LISTINPUT_ITEMTYPE_ACTION;
    public static final int REMOTEHMI_LISTINPUT_ITEMTYPE_PULLDOWN;

    default public void updateRemoteHmiListInputScreenConfiguration(int[] nArray) {
    }
}

