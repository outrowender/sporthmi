/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.interapp.NaviSDSPOIOnlineService;
import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;

public class NullPOIOnlineService
extends NullService
implements NaviSDSPOIOnlineService {
    public NullPOIOnlineService(LogChannel logChannel) {
        super(logChannel, "POIOnlineService");
    }

    @Override
    public byte poiOnlineSearchInit(boolean bl, int n, String string) {
        super.log();
        return 0;
    }

    @Override
    public byte poiOnlineSearchCancel() {
        super.log();
        return 0;
    }

    @Override
    public byte poiOnlineVoiceDataAvailable(String string, int n) {
        super.log();
        return 0;
    }

    @Override
    public void poiOnlineSetSearchArea(byte by) {
        super.log();
    }

    @Override
    public void markCurrentPOIUsedFor(byte by) {
        super.log();
    }

    @Override
    public void poiOnlineSearchDidYouMean() {
        super.log();
    }

    @Override
    public int getCurrentPOIOnlineListSize() {
        super.log();
        return 0;
    }

    @Override
    public void resetCurrentPOIOnlineList() {
        super.log();
    }

    @Override
    public void poiOnlineShowList(byte by) {
        super.log();
    }

    @Override
    public void selectDestination(int n) {
        super.log();
    }
}

