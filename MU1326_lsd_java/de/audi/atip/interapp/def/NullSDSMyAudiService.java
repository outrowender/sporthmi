/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.interapp.def.NullService;
import de.audi.atip.interapp.online.IOnlineSDSMyAudiService;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.organizer.AdbEntry;

public class NullSDSMyAudiService
extends NullService
implements IOnlineSDSMyAudiService {
    public NullSDSMyAudiService(LogChannel logChannel) {
        super(logChannel, "OnlineSDSMyAudiService");
    }

    @Override
    public AdbEntry selectContactById(long l) {
        super.log();
        return null;
    }
}

