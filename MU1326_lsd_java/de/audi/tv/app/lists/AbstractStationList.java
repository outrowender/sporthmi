/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.dsi.DSITV;
import de.audi.tv.app.lists.AbstractTVStationRow;
import de.audi.tv.app.lists.StationStatus;
import de.audi.tv.app.storage.TVStorage;
import org.dsi.ifc.tvtuner.ProgramInfo;
import org.dsi.ifc.tvtuner.ServiceInfo;

public abstract class AbstractStationList {
    protected final TVEnv env;
    protected final TVStorage storage;
    protected final DSITV dsi;
    protected final BaseListModelApp stationList;
    private final Object muteMutex = new Object();
    private final String listName;
    private volatile int muteState;
    private volatile int casState;

    protected AbstractStationList(TVEnv tVEnv, TVStorage tVStorage, DSITV dSITV, int n, String string) {
        this.env = tVEnv;
        this.storage = tVStorage;
        this.dsi = dSITV;
        this.listName = string;
        this.stationList = tVEnv.getBaseListModel(n);
    }

    public void setNextService() {
        int n = 0;
        if (this.stationList.getSelected() != null && (n = this.stationList.getSelected().getIndex() + 1) >= this.stationList.getLength()) {
            n = 0;
        }
        ServiceInfo serviceInfo = ((AbstractTVStationRow)this.stationList.getRow((int)n)).service;
        this.env.lcHMI.log(10000000, "[%1.setNextService] new index: %3, new service: %2", (Object)this.listName, (Object)serviceInfo, (long)n);
        this.dsi.changeService(serviceInfo, true);
        this.stationList.fireEvent(0);
    }

    public void setPrevService() {
        int n = 0;
        if (this.stationList.getSelected() != null && (n = this.stationList.getSelected().getIndex() - 1) < 0) {
            n = this.stationList.getLength() - 1;
        }
        ServiceInfo serviceInfo = ((AbstractTVStationRow)this.stationList.getRow((int)n)).service;
        this.env.lcHMI.log(10000000, "[%1.setPrevService] new index: %3, new service: %2", (Object)this.listName, (Object)serviceInfo, (long)n);
        this.dsi.changeService(serviceInfo, true);
        this.stationList.fireEvent(0);
    }

    protected void evaluateProgramInfo(BaseListModelApp baseListModelApp, ProgramInfo programInfo, long[] lArray) {
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            if (!baseListModelApp.contains(lArray[i2])) continue;
            int n = baseListModelApp.getIndexForUniqueID(lArray[i2]);
            AbstractTVStationRow abstractTVStationRow = (AbstractTVStationRow)baseListModelApp.getRow(n);
            abstractTVStationRow.evaluateProgramInfo(programInfo);
            baseListModelApp.setRow(n, abstractTVStationRow);
        }
    }

    void setCASstatus(int n) {
        this.casState = n;
        this.updateErrorIcon();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void setMuteStatus(int n) {
        Object object = this.muteMutex;
        synchronized (object) {
            this.muteState = n;
            this.updateErrorIcon();
        }
    }

    protected void updateErrorIcon() {
        this.env.lcMain.log(10000000, "[%1.updateErrorIcon]", (Object)this.listName);
        this.removeErrorIcon();
        SelectedItem selectedItem = this.stationList.getSelected();
        if (selectedItem == null) {
            this.env.lcMain.log(1000000, "[%1.updateErrorIcon] No selected entry found!", (Object)this.listName);
            return;
        }
        AbstractTVStationRow abstractTVStationRow = (AbstractTVStationRow)this.stationList.getRow(selectedItem.getIndex());
        abstractTVStationRow.setStationStatus(new StationStatus(this.casState, this.muteState));
        this.stationList.setRow(selectedItem.getIndex(), abstractTVStationRow);
    }

    private void removeErrorIcon() {
        BaseListModelApp baseListModelApp = this.stationList.getCopy();
        for (int i2 = 0; i2 < baseListModelApp.getLength(); ++i2) {
            AbstractTVStationRow abstractTVStationRow = (AbstractTVStationRow)this.stationList.getRow(i2);
            if (abstractTVStationRow.getState().isOK()) continue;
            abstractTVStationRow.setStationStatus(new StationStatus(0, 0));
            baseListModelApp.setRow(i2, abstractTVStationRow);
        }
        this.stationList.update(baseListModelApp);
    }
}

