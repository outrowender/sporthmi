/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.epg.dab;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.epg.dab.DABEpgHandler;
import org.dsi.ifc.radio.EPGFullProgramInfo;

class DABEpgHandler$EpgDetailRow
extends EvoListRow {
    private static final int NUM_COLS;
    private static final int RS_NOW_PROGRAM;
    private static final int RS_OTHER_PROGRAM;
    private static final int INDEX_TIME;
    private static final int INDEX_TITLE;
    private static final int INDEX_DETAIL;
    private static final int INDEX_RS;
    private final EPGFullProgramInfo info;
    private final /* synthetic */ DABEpgHandler this$0;

    public DABEpgHandler$EpgDetailRow(DABEpgHandler dABEpgHandler, long l, EPGFullProgramInfo ePGFullProgramInfo, boolean bl) {
        this.this$0 = dABEpgHandler;
        super(l, 4);
        this.info = ePGFullProgramInfo;
        long l2 = DABEpgHandler.access$2000(dABEpgHandler).getOffset();
        long l3 = ePGFullProgramInfo.shortInfo.getStartTime().getTime() + l2;
        this.setText(0, Utilities.getFormatedTime(l3));
        this.setText(1, ePGFullProgramInfo.shortInfo.programInfo);
        this.setText(2, ePGFullProgramInfo.detailProgramInfo);
        this.setInteger(3, bl ? 0 : 1);
    }

    private DABEpgHandler$EpgDetailRow(DABEpgHandler dABEpgHandler, DABEpgHandler$EpgDetailRow dABEpgHandler$EpgDetailRow) {
        this.this$0 = dABEpgHandler;
        super(dABEpgHandler$EpgDetailRow);
        this.info = dABEpgHandler$EpgDetailRow.info;
    }

    @Override
    public EvoListRow copy() {
        return new DABEpgHandler$EpgDetailRow(this.this$0, this);
    }

    public EPGFullProgramInfo getDetails() {
        return this.info;
    }
}

