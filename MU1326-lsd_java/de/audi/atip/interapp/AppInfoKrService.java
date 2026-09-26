/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.interapp.AbstractSDSApplicationService;

public interface AppInfoKrService
extends AbstractSDSApplicationService {
    public static final byte RESULT_OK;
    public static final byte RESULT_ERROR;
    public static final byte RESULT_AMBIGUOUS;
    public static final byte RESULT_INVALID;

    default public void showSimpleMaps(String[] stringArray, int[] nArray) {
    }

    default public void startSimpleMapFreeSelection() {
    }

    default public void refreshSpeakableSimpleMaps() {
    }
}

