/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.tuner;

import de.audi.app.sdsmanager.apps.tuner.TunerSDSHandler;
import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;

class TunerSDSPicklistListener
extends DefaultBaseListModelListener {
    private final LogChannel lc = Logger.getAppTunerLog();
    private final TunerSDSHandler sdsHandler;
    private final HMIService hmi;

    TunerSDSPicklistListener(HMIService hMIService, TunerSDSHandler tunerSDSHandler) {
        this.hmi = hMIService;
        this.sdsHandler = tunerSDSHandler;
        SDSUtils.initPickList(hMIService.getBaseListModel(3865), 2, this);
        this.lc.log(10000000, "TunerSDSPicklistListener started.");
    }

    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.lc.log(10000000, "TunerSDSPicklistListener#itemSelected: id=%1, row=%2 (0-indexed)", (long)n, (long)n2);
        SDSUtils.handleItemSelected(n, n2, this.hmi, this.sdsHandler, this.lc);
    }
}

