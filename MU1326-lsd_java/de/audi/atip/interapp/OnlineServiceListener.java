/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.interapp.OnlineServiceListener$OnlineSpeechDictionary;
import de.audi.atip.interapp.SDSListEntry;

public interface OnlineServiceListener {
    public static final byte REC_RESULT_CONTINUE_DIALOG;
    public static final byte REC_RESULT_END_DIALOG;

    default public void updateRemoteHMIList(SDSListEntry[] sDSListEntryArray, boolean bl) {
    }

    default public void updateRemoteHMIGlobalList(SDSListEntry[] sDSListEntryArray, boolean bl) {
    }

    default public void updateRemoteHMIHelpList(SDSListEntry[] sDSListEntryArray, boolean bl) {
    }

    default public void setRemoteHMICategorySetFinished(byte by) {
    }

    default public void setDictionary(OnlineSpeechDictionary onlineSpeechDictionary) {
    }
}

