/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.interapp.AbstractSDSApplicationService;

public interface AppInfoKrService
extends AbstractSDSApplicationService {
    public static final byte RESULT_OK = 0;
    public static final byte RESULT_ERROR = 1;
    public static final byte RESULT_AMBIGUOUS = 2;
    public static final byte RESULT_INVALID = 3;

    public void showSimpleMaps(String[] var1, int[] var2);

    public void startSimpleMapFreeSelection();

    public void refreshSpeakableSimpleMaps();
}

