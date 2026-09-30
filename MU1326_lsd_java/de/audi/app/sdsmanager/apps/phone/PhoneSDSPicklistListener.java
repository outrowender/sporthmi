/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.phone;

import de.audi.app.sdsmanager.apps.phone.PhoneSDSHandler;
import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.IPicklist;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;

class PhoneSDSPicklistListener
extends DefaultBaseListModelListener {
    private static final int MAX_PHONE_COLUMNS = 3;
    private final LogChannel lc = Logger.getAppTunerLog();
    private final PhoneSDSHandler sdsHandler;
    private final HMIService hmi;
    private IPicklist entryPicklist;

    PhoneSDSPicklistListener(HMIService hMIService, PhoneSDSHandler phoneSDSHandler) {
        this.hmi = hMIService;
        this.sdsHandler = phoneSDSHandler;
        SDSUtils.initPickList(hMIService.getBaseListModel(3938), 3, this);
        this.lc.log(10000000, "PhoneSDSPicklistListener started.");
    }

    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.lc.log(10000000, "PhoneSDSPicklistListener#itemSelected: id=%1, row=%2 (0-indexed)", (long)n, (long)n2);
        SDSUtils.handleItemSelected(n, n2, this.hmi, this.sdsHandler, this.lc);
    }

    public IPicklist getEntryPicklist() {
        return this.entryPicklist;
    }

    public void setEntryPicklist(IPicklist iPicklist) {
        this.entryPicklist = iPicklist;
    }
}

