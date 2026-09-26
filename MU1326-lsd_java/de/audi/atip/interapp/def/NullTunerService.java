/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.interapp.TunerService;
import de.audi.atip.interapp.TunerService$TunerListEntry;
import de.audi.atip.interapp.TunerService$TunerSettingResult;
import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;

public class NullTunerService
extends NullService
implements TunerService {
    public NullTunerService(LogChannel logChannel) {
        super(logChannel, "TunerService");
    }

    @Override
    public byte tuneFrequency(long l, byte by) {
        super.log();
        return 0;
    }

    @Override
    public TunerService$TunerSettingResult tuneStationByID(long[] lArray) {
        super.log();
        return new TunerService$TunerSettingResult(0, 0L);
    }

    @Override
    public byte tuneEnsembleByID(long l) {
        super.log();
        return 0;
    }

    @Override
    public byte selectWaveBand(int n) {
        super.log();
        return 0;
    }

    @Override
    public void forceStationListUpdate() {
        super.log();
    }

    @Override
    public byte switchTrafficAnnouncements(boolean bl) {
        super.log();
        return 0;
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
    public void abortActiveTA() {
        super.log();
    }

    @Override
    public byte selectGenre(long l) {
        super.log();
        return 0;
    }

    @Override
    public byte fillTunerPickList(TunerService$TunerListEntry[] tunerService$TunerListEntryArray) {
        super.log();
        return 1;
    }

    @Override
    public byte fillTunerPickList(SDSListEntry[] sDSListEntryArray) {
        super.log();
        return 1;
    }

    @Override
    public SDSListEntry getTunerPicklistEntry(int n) {
        super.log();
        return null;
    }

    @Override
    public byte getTypeOfListRow(int n) {
        super.log();
        return 0;
    }

    @Override
    public int getWavebandForID(long[] lArray) {
        super.log();
        return 0;
    }
}

