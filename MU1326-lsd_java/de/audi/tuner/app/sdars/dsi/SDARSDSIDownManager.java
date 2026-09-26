/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.dsi;

import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.amfm.dsi.RadioInfo;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.dsi.ISdarsDsiDownManager;
import de.audi.tuner.app.sdars.dsi.SDARSDsiDownInfo;
import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;
import de.audi.tuner.app.sdars.dsi.SDARSTuningQueue;
import de.audi.tuner.util.NullDSISDARSTunerService;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.sdars.DSISDARSTuner;

public class SDARSDSIDownManager
implements ISdarsDsiDownManager {
    private final LogChannel log;
    private DSISDARSTuner dsi;
    private SDARSDsiDownInfo[] listeners = new SDARSDsiDownInfo[0];
    private RadioInfo[] basicListeners = new RadioInfo[0];
    private final SimpleIntObjectMap notifications = new SimpleIntObjectMap(20);
    private int selectionCounter = 0;
    private final SDARSTuningQueue tuningQueue;
    private final Object mutex;

    public SDARSDSIDownManager(TunerBasics tunerBasics, Object object) {
        this.log = tunerBasics.getLogger().sdarsDSI;
        this.dsi = new NullDSISDARSTunerService(this.log);
        this.tuningQueue = new SDARSTuningQueue(this.log, this, object);
        this.mutex = object;
    }

    @Override
    public void setDeviceService(DSISDARSTuner dSISDARSTuner) {
        this.dsi = dSISDARSTuner;
    }

    @Override
    public boolean isDsiFound() {
        return !(this.dsi instanceof NullDSISDARSTunerService);
    }

    @Override
    public void register(RadioInfo radioInfo) {
        if (radioInfo instanceof SDARSDsiDownInfo) {
            SDARSDsiDownInfo[] sDARSDsiDownInfoArray = new SDARSDsiDownInfo[this.listeners.length + 1];
            System.arraycopy((Object)this.listeners, 0, (Object)sDARSDsiDownInfoArray, 0, this.listeners.length);
            sDARSDsiDownInfoArray[this.listeners.length] = (SDARSDsiDownInfo)radioInfo;
            this.listeners = sDARSDsiDownInfoArray;
        } else {
            RadioInfo[] radioInfoArray = new RadioInfo[this.basicListeners.length + 1];
            System.arraycopy((Object)this.basicListeners, 0, (Object)radioInfoArray, 0, this.basicListeners.length);
            radioInfoArray[this.basicListeners.length] = radioInfo;
            this.basicListeners = radioInfoArray;
        }
    }

    @Override
    public SDARSDsiUpInfo getDsiUpListener() {
        return this.tuningQueue.dsiUpListener;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.log.log(-2137614336, "[SDARSDSIDownManager.setNotification] %1", (Object)nArray);
        SimpleIntObjectMap simpleIntObjectMap = this.notifications;
        synchronized (simpleIntObjectMap) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                this.notifications.add(nArray[i2], dSIListener);
            }
        }
        this.dsi.setNotification(nArray, dSIListener);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.log.log(-2137614336, "[SDARSDSIDownManager.clearNotification] %1", (Object)nArray);
        SimpleIntObjectMap simpleIntObjectMap = this.notifications;
        synchronized (simpleIntObjectMap) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                this.notifications.remove(nArray[i2]);
            }
        }
        this.dsi.clearNotification(nArray, dSIListener);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void reNotification(int n) {
        SimpleIntObjectMap simpleIntObjectMap = this.notifications;
        synchronized (simpleIntObjectMap) {
            DSIListener dSIListener = (DSIListener)this.notifications.get(n);
            if (dSIListener != null) {
                this.log.log(-2137614336, "[SDARSDSIDownManager.setNotification] again for arrt %1", (long)n);
                this.dsi.setNotification(n, dSIListener);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void selectStation(int n) {
        Object object = this.mutex;
        synchronized (object) {
            this.log.log(-2137614336, "[SDARSDSIDownManager.selectStation] sid %1", (long)n);
            SDARSDsiDownInfo[] sDARSDsiDownInfoArray = this.listeners;
            for (int i2 = 0; i2 < sDARSDsiDownInfoArray.length; ++i2) {
                sDARSDsiDownInfoArray[i2].blockUpdatesForNextTune();
            }
            this.dsi.selectStation(4, n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void selectStation(StationInfoExt stationInfoExt, int n) {
        this.log.log(-2137614336, "[SDARSDSIDownManager.selectStation]:%1", (Object)stationInfoExt);
        SDARSDsiDownInfo[] sDARSDsiDownInfoArray = this.listeners;
        RadioInfo[] radioInfoArray = this.basicListeners;
        Object object = this.mutex;
        synchronized (object) {
            int n2;
            int n3;
            for (n3 = 0; n3 < sDARSDsiDownInfoArray.length; ++n3) {
                sDARSDsiDownInfoArray[n3].blockUpdatesForNextTune();
            }
            for (n3 = 0; n3 < sDARSDsiDownInfoArray.length; ++n3) {
                sDARSDsiDownInfoArray[n3].preTuneAction(stationInfoExt);
            }
            TunerObjectContainer tunerObjectContainer = new TunerObjectContainer(stationInfoExt);
            for (n2 = 0; n2 < radioInfoArray.length; ++n2) {
                radioInfoArray[n2].updateStation(tunerObjectContainer, n);
                radioInfoArray[n2].preTuneAction();
            }
            this.tuningQueue.tuneStation(stationInfoExt.sID);
            for (n2 = 0; n2 < sDARSDsiDownInfoArray.length; ++n2) {
                sDARSDsiDownInfoArray[n2].postTuneAction(stationInfoExt, this.selectionCounter, n);
            }
        }
        ++this.selectionCounter;
    }

    @Override
    public void getTime() {
        this.log.log(-2137614336, "[SDARSDSIDownManager.getTime] ");
        this.dsi.getTime();
    }

    @Override
    public void reset(int n) {
        this.log.log(-2137614336, "[SDARSDSIDownManager.reset] %1", (long)n);
        this.dsi.reset(n);
    }

    @Override
    public void setHmiReady() {
        this.log.log(-2137614336, "[SDARSDSIDownManager.setHmiReady] ");
        this.dsi.notifyHMIReady(7);
    }

    @Override
    public void getEPG24Hour(int n) {
        this.log.log(-2137614336, "[SDARSDSIDownManager.getEPG24Hour] sId:%1", (long)n);
        this.dsi.getEPG24Hour(n);
    }

    @Override
    public void getEPGDescription(int n, int n2) {
        this.log.log(-2137614336, "[SDARSDSIDownManager.getEPGDescription] sId:%1 programId:%2", (long)n, (long)n2);
        this.dsi.getEPGDescription(n, n2);
    }
}

