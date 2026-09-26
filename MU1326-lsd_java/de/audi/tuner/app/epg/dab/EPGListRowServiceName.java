/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.epg.dab;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tuner.app.epg.dab.EPGListRow;
import de.audi.tuner.app.epg.dab.EPGShortInfoExt;

public class EPGListRowServiceName
extends EPGListRow {
    public EPGListRowServiceName(EPGShortInfoExt ePGShortInfoExt) {
        super(ePGShortInfoExt, ePGShortInfoExt.getDabStation().getUniqueId(), 4);
        this.setInteger(0, 0);
        this.setText(1, this.getDabStation().service.fullName);
    }

    private EPGListRowServiceName(EPGListRowServiceName ePGListRowServiceName) {
        super(ePGListRowServiceName);
    }

    @Override
    public EvoListRow copy() {
        return new EPGListRowServiceName(this);
    }
}

