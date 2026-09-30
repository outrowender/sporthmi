/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi;

import de.audi.app.sdsmanager.apps.navi.NaviSDSHandler;
import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;

class NaviSDSPicklistListener
extends DefaultBaseListModelListener {
    private static final int MAX_COLS_VDE = 3;
    private static final int MAX_COLS_SUI = 3;
    private static final int MAX_COLS_POI_PICKLIST = 3;
    private static final int MAX_COLS_POI_RESULT_LIST = 3;
    private static final int MAX_COLS_MY_AUDI_RESULT_LIST = 3;
    private final LogChannel lc = Logger.getAppNaviLog();
    private final NaviSDSHandler sdsHandler;
    private final HMIService hmi;

    NaviSDSPicklistListener(HMIService hMIService, NaviSDSHandler naviSDSHandler) {
        this.hmi = hMIService;
        this.sdsHandler = naviSDSHandler;
        SDSUtils.initPickList(hMIService.getBaseListModel(3869), 3, this);
        SDSUtils.initPickList(hMIService.getBaseListModel(3870), 3, this);
        SDSUtils.initPickList(hMIService.getBaseListModel(3871), 3, this);
        SDSUtils.initPickList(hMIService.getBaseListModel(3901), 3, this);
        this.lc.log(10000000, "NaviSDSPicklistListener started.");
    }

    public void initOnlineLists() {
        SDSUtils.initPickList(this.hmi.getBaseListModel(401814), 3, this);
    }

    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.lc.log(10000000, "NaviSDSPicklistListener#itemReleased: id=%1, row=%2", (long)n, (long)n2);
    }

    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.lc.log(10000000, "NaviSDSPicklistListener#itemSelected: id=%1, index=%2 (0-indexed)", (long)n, (long)n2);
        SDSUtils.handleItemSelected(n, n2, this.hmi, this.sdsHandler, this.lc);
    }
}

