/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.epg.sdars;

import de.audi.atip.hmi.model.DefaultOptionListener;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.epg.sdars.SDARSEPGHandler;
import de.audi.tuner.app.epg.sdars.SDARSEPGHandler$1;
import de.audi.tuner.ifc.AbstractRadioListRow;

class SDARSEPGHandler$OptionListener
extends DefaultOptionListener {
    private final /* synthetic */ SDARSEPGHandler this$0;

    private SDARSEPGHandler$OptionListener(SDARSEPGHandler sDARSEPGHandler) {
        this.this$0 = sDARSEPGHandler;
    }

    @Override
    public void keyTyped(int n, int n2, int n3, int n4, int n5) {
        AbstractRadioListRow abstractRadioListRow = (AbstractRadioListRow)SDARSEPGHandler.access$1500(this.this$0).getBaseListModel(n2).getRow(n3);
        TunerObjectContainer tunerObjectContainer = abstractRadioListRow.getTOContainer();
        if (tunerObjectContainer.getType() == 5) {
            this.this$0.onOptionShowEPGForFocussedStationInSDARSStationList(tunerObjectContainer.getSDARSService().sID, n5);
        }
    }

    /* synthetic */ SDARSEPGHandler$OptionListener(SDARSEPGHandler sDARSEPGHandler, SDARSEPGHandler$1 sDARSEPGHandler$1) {
        this(sDARSEPGHandler);
    }
}

