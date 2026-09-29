/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.epg.sdars;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.tuner.app.epg.sdars.AbstractProgramSdarsEpgListRow;
import de.audi.tuner.app.epg.sdars.SDARSEPGHandler;
import de.audi.tuner.app.epg.sdars.SDARSEPGHandler$1;

class SDARSEPGHandler$NextPrevButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ SDARSEPGHandler this$0;

    private SDARSEPGHandler$NextPrevButtonListener(SDARSEPGHandler sDARSEPGHandler) {
        this.this$0 = sDARSEPGHandler;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        int n4 = n == 1720254720 ? this.this$0.detailIndex - 1 : this.this$0.detailIndex + 1;
        AbstractProgramSdarsEpgListRow abstractProgramSdarsEpgListRow = (AbstractProgramSdarsEpgListRow)SDARSEPGHandler.access$1600(this.this$0).getRow(n4);
        if (abstractProgramSdarsEpgListRow != null) {
            SDARSEPGHandler.access$1700(this.this$0, n4);
            SDARSEPGHandler.access$1800(this.this$0, abstractProgramSdarsEpgListRow, n4);
        }
    }

    /* synthetic */ SDARSEPGHandler$NextPrevButtonListener(SDARSEPGHandler sDARSEPGHandler, SDARSEPGHandler$1 sDARSEPGHandler$1) {
        this(sDARSEPGHandler);
    }
}

