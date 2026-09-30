/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.interapp.TVService;
import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;

public class NullTVService
extends NullService
implements TVService {
    public NullTVService(LogChannel logChannel) {
        super(logChannel, "TVService");
    }

    public byte freezeDynamicLists() {
        super.log();
        return 0;
    }

    public byte unfreezeDynamicLists() {
        super.log();
        return 0;
    }

    public TVService.TVSettingResult tuneStationByID(long l) {
        super.log();
        return new TVService.TVSettingResult(0, 0L);
    }

    public byte getTypeOfListRow(int n) {
        super.log();
        return 0;
    }

    public byte selectSource(int n) {
        super.log();
        return 0;
    }

    public byte fillTvPickList(SDSListEntry[] sDSListEntryArray) {
        super.log();
        return 1;
    }

    public SDSListEntry getTvPicklistEntry(int n) {
        super.log();
        return null;
    }
}

