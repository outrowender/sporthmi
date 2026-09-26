/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.epg.dab;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tuner.app.RadioObjectIds;
import de.audi.tuner.app.epg.dab.EPGListRow;
import de.audi.tuner.app.epg.dab.EPGShortInfoExt;
import org.dsi.ifc.radio.EPGShortProgramInfo;

public class EPGListRowInfo
extends EPGListRow {
    private final int nowOrNext;

    public EPGListRowInfo(EPGShortInfoExt ePGShortInfoExt, int n, long l) {
        super(ePGShortInfoExt, n == 1 ? RadioObjectIds.toEpgProgNowID(ePGShortInfoExt.getDabStation().getUniqueId()) : RadioObjectIds.toEpgProgNextID(ePGShortInfoExt.getDabStation().getUniqueId()), 4);
        this.nowOrNext = n;
        EPGShortProgramInfo ePGShortProgramInfo = n == 1 ? ePGShortInfoExt.getNowProgramInfo() : ePGShortInfoExt.getNextProgramInfo();
        this.fillTimeColumn(2, ePGShortProgramInfo.getStartTime().getTime() + l);
        this.setInteger(0, 1);
        this.setText(3, ePGShortProgramInfo.getProgramInfo());
    }

    private EPGListRowInfo(EPGListRowInfo ePGListRowInfo) {
        super(ePGListRowInfo);
        this.nowOrNext = ePGListRowInfo.nowOrNext;
    }

    @Override
    public EvoListRow copy() {
        return new EPGListRowInfo(this);
    }

    public int getNowOrNext() {
        return this.nowOrNext;
    }
}

