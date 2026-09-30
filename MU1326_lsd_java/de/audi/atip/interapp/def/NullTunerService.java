/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.interapp.TunerService;
import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;

public class NullTunerService
extends NullService
implements TunerService {
    public NullTunerService(LogChannel logChannel) {
        super(logChannel, "TunerService");
    }

    public byte tuneFrequency(long l, byte by) {
        super.log();
        return 0;
    }

    public TunerService.TunerSettingResult tuneStationByID(long[] lArray) {
        super.log();
        return new TunerService.TunerSettingResult(0, 0L);
    }

    public byte tuneEnsembleByID(long l) {
        super.log();
        return 0;
    }

    public byte selectWaveBand(int n) {
        super.log();
        return 0;
    }

    public void forceStationListUpdate() {
        super.log();
    }

    public byte switchTrafficAnnouncements(boolean bl) {
        super.log();
        return 0;
    }

    public byte freezeDynamicLists() {
        super.log();
        return 0;
    }

    public byte unfreezeDynamicLists() {
        super.log();
        return 0;
    }

    public void abortActiveTA() {
        super.log();
    }

    public byte selectGenre(long l) {
        super.log();
        return 0;
    }

    public byte fillTunerPickList(TunerService.TunerListEntry[] tunerListEntryArray) {
        super.log();
        return 1;
    }

    public byte fillTunerPickList(SDSListEntry[] sDSListEntryArray) {
        super.log();
        return 1;
    }

    public SDSListEntry getTunerPicklistEntry(int n) {
        super.log();
        return null;
    }

    public byte getTypeOfListRow(int n) {
        super.log();
        return 0;
    }

    public int getWavebandForID(long[] lArray) {
        super.log();
        return 0;
    }
}

