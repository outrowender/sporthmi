/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.info.app.tmc.TMCSimulation;
import java.util.HashMap;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.tmc.DSITmc;
import org.dsi.ifc.tmc.DSITmcListener;

public class TMCSimulationFacade
implements DSITmc {
    private IFrameworkAccess framework;
    private DSITmcListener tmcListener;
    private LogChannel logCh;
    private HashMap map;

    public TMCSimulationFacade(DSITmcListener dSITmcListener, IFrameworkAccess iFrameworkAccess) {
        this.framework = iFrameworkAccess;
        this.tmcListener = dSITmcListener;
        this.map = new HashMap(5);
        this.logCh = iFrameworkAccess.getLogChannel("App.Info.SimFacade");
    }

    @Override
    public void requestTmcWindow(int n, int n2, int n3, int[] nArray, int n4) {
        this.logCh.log(-2137614336, "[TMCSimulationFacade#requestTmcWindow] Called, window ID: %1", (long)n);
        this.getSimulation(0).requestTmcWindow(n, n2, n3, nArray, n4);
        this.logCh.log(-2137614336, "[TMCSimulationFacade#requestTmcWindow] Finished, window ID: %1 (=WINDOW_OVERVIEW_LIST) ", 0L);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private TMCSimulation getSimulation(int n) {
        TMCSimulation tMCSimulation = null;
        HashMap hashMap = this.map;
        synchronized (hashMap) {
            Long l = new Long(n);
            tMCSimulation = (TMCSimulation)this.map.get(l);
            if (tMCSimulation == null) {
                tMCSimulation = new TMCSimulation(this.framework, this.tmcListener, n);
                this.map.put(l, tMCSimulation);
            }
            return tMCSimulation;
        }
    }

    @Override
    public void clearNotification(DSIListener dSIListener) {
        this.logCh.log(-2137614336, "[TMCSimulationFacade#clearNotification] called. ");
    }

    public void clearNotification(short[] sArray, DSIListener dSIListener) {
        this.logCh.log(-2137614336, "[TMCSimulationFacade#clearNotification] called. ");
    }

    public void clearNotification(short s, DSIListener dSIListener) {
        this.logCh.log(-2137614336, "[TMCSimulationFacade#clearNotification] called. ");
    }

    public String getName() {
        return "TMC-Simulation-Facade";
    }

    public String getServiceAdapterVersion() {
        return null;
    }

    @Override
    public void setNotification(DSIListener dSIListener) {
        this.logCh.log(-2137614336, "[TMCSimulationFacade#setNotification] called. ");
    }

    public void setNotification(short[] sArray, DSIListener dSIListener) {
        this.logCh.log(-2137614336, "[TMCSimulationFacade#setNotification] called. ");
    }

    public void setNotification(short s, DSIListener dSIListener) {
        this.logCh.log(-2137614336, "[TMCSimulationFacade#setNotification] called. ");
    }

    @Override
    public void setMessageFilter(int n, int n2) {
    }

    @Override
    public void clearNotification(int[] nArray, DSIListener dSIListener) {
    }

    @Override
    public void clearNotification(int n, DSIListener dSIListener) {
    }

    @Override
    public void setNotification(int[] nArray, DSIListener dSIListener) {
    }

    @Override
    public void setNotification(int n, DSIListener dSIListener) {
    }

    @Override
    public void getMessageIdsForListElement(long l) {
    }

    @Override
    public void getBoundingRectangleForTrafficMessages(long[] lArray) {
    }

    @Override
    public void enableAreaWarnings(boolean bl) {
    }

    @Override
    public void enableTrafficFlowStatistics(boolean bl) {
    }
}

