/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.interapp.AppInfoKrService;
import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;

public class NullAppInfoKrService
extends NullService
implements AppInfoKrService {
    public NullAppInfoKrService(LogChannel logChannel) {
        super(logChannel, "AppInfoKrService");
    }

    @Override
    public byte freezeDynamicLists() {
        super.log();
        return 0;
    }

    @Override
    public byte unfreezeDynamicLists() {
        super.log();
        return 0;
    }

    @Override
    public void showSimpleMaps(String[] stringArray, int[] nArray) {
        super.log();
    }

    @Override
    public void startSimpleMapFreeSelection() {
        super.log();
    }

    @Override
    public void refreshSpeakableSimpleMaps() {
    }
}

