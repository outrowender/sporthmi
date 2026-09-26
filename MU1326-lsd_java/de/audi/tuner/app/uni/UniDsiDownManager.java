/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.uni;

import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.amfm.dsi.RadioInfo;
import de.audi.tuner.app.uni.UniDsiDownInfo;
import de.audi.tuner.app.uni.UnifiedStationExt;
import de.audi.tuner.util.NullDSIUnifiedTunerService;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.radio.DSIUnifiedTuner;
import org.dsi.ifc.radio.DSIUnifiedTunerListener;

public class UniDsiDownManager {
    private final LogChannel log;
    private DSIUnifiedTuner dsi;
    private UniDsiDownInfo[] listeners = new UniDsiDownInfo[0];
    private RadioInfo[] basicListeners = new RadioInfo[0];
    private final SimpleIntObjectMap notifications = new SimpleIntObjectMap(20);
    private int selectionCounter = 0;
    private final Object globalUniLock;

    UniDsiDownManager(TunerBasics tunerBasics, Object object) {
        this.globalUniLock = object;
        this.log = tunerBasics.getLogger().uniDSI;
        this.dsi = new NullDSIUnifiedTunerService(this.log);
    }

    public void setDeviceService(DSIUnifiedTuner dSIUnifiedTuner) {
        this.dsi = dSIUnifiedTuner;
    }

    public boolean isDsiFound() {
        return !(this.dsi instanceof NullDSIUnifiedTunerService);
    }

    void register(RadioInfo radioInfo) {
        if (radioInfo instanceof UniDsiDownInfo) {
            UniDsiDownInfo[] uniDsiDownInfoArray = new UniDsiDownInfo[this.listeners.length + 1];
            System.arraycopy((Object)this.listeners, 0, (Object)uniDsiDownInfoArray, 0, this.listeners.length);
            uniDsiDownInfoArray[this.listeners.length] = (UniDsiDownInfo)radioInfo;
            this.listeners = uniDsiDownInfoArray;
        } else {
            RadioInfo[] radioInfoArray = new RadioInfo[this.basicListeners.length + 1];
            System.arraycopy((Object)this.basicListeners, 0, (Object)radioInfoArray, 0, this.basicListeners.length);
            radioInfoArray[this.basicListeners.length] = radioInfo;
            this.basicListeners = radioInfoArray;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void setNotification(int[] nArray, DSIUnifiedTunerListener dSIUnifiedTunerListener) {
        this.log.log(-2137614336, "[UniDSIDownManager.setNotification] %1", (Object)nArray);
        Object object = this.globalUniLock;
        synchronized (object) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                this.notifications.add(nArray[i2], dSIUnifiedTunerListener);
            }
        }
        this.dsi.setNotification(nArray, (DSIListener)dSIUnifiedTunerListener);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void clearNotification(int[] nArray, DSIUnifiedTunerListener dSIUnifiedTunerListener) {
        this.log.log(-2137614336, "[UniDsiDownManager.clearNotification] %1", (Object)nArray);
        Object object = this.globalUniLock;
        synchronized (object) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                this.notifications.remove(nArray[i2]);
            }
        }
        this.dsi.clearNotification(nArray, (DSIListener)dSIUnifiedTunerListener);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void reNotification(int n) {
        Object object;
        if (n == 3) {
            object = this.listeners;
            for (int i2 = 0; i2 < ((UniDsiDownInfo[])object).length; ++i2) {
                object[i2].unBlockUpdates();
            }
        }
        object = this.globalUniLock;
        synchronized (object) {
            DSIListener dSIListener = (DSIListener)this.notifications.get(n);
            if (dSIListener != null) {
                this.log.log(-2137614336, "[UniDsiDownManager.setNotification] again for arrt %1", (long)n);
                this.dsi.setNotification(n, dSIListener);
            } else {
                this.log.log(10000, "[UniDsiDownManager.setNotification] No listener set for reNotification in UNITuner arrt: %1", (long)n);
            }
        }
    }

    public void selectStation(UnifiedStationExt unifiedStationExt, int n) {
        this.log.log(-2137614336, "[UniDsiDownManager.selectStation] %1", (Object)unifiedStationExt);
        UnifiedStationExt unifiedStationExt2 = new UnifiedStationExt(unifiedStationExt);
        unifiedStationExt2.resetProgramData();
        this.blockUpdates();
        this.preTuneCommand(unifiedStationExt2, n);
        int n2 = unifiedStationExt2.ensId == 0 ? 1 : 2;
        this.dsi.selectStation(n2, unifiedStationExt2.frequency, unifiedStationExt2.piSId, unifiedStationExt2.ensId, unifiedStationExt2.ecc, unifiedStationExt2.sCIDI);
        this.postTuneCommand(unifiedStationExt2);
    }

    public void setStationFollowingMode(int n) {
        this.log.log(-2137614336, "[UniDsiDownManager.setStationFollowingMode] %1", (long)n);
        this.dsi.setStationFollowingMode(n);
    }

    public void setListMode(int n) {
        this.log.log(-2137614336, "[UniDsiDownManager.setListMode] %1", (long)n);
        this.dsi.setListMode(n);
    }

    void switchDeviceUsage(boolean bl) {
        this.log.log(-2137614336, "[UniDsiDownManager.switchDeviceUsage] %1", bl);
        this.dsi.switchDeviceUsage(bl ? 1 : 0);
    }

    public void setSoftLinkSwitch(boolean bl) {
        this.log.log(-2137614336, "[UniDsiDownManager.setSoftLinkSwitch] %1", bl);
        this.dsi.setSoftLinkSwitch(bl ? 1 : 0);
    }

    public void setRegMode(int n) {
        this.log.log(-2137614336, "[UniDsiDownManager.setRegMode] %1", (long)n);
        this.dsi.setRegMode(n);
    }

    public void enableRadioTextPlus(int[] nArray) {
        this.log.log(-2137614336, "[UniDsiDownManager.enableRadioTextPlus] %1", (Object)nArray);
        this.dsi.enableRadioTextPlus(nArray);
    }

    private void postTuneCommand(UnifiedStationExt unifiedStationExt) {
        UniDsiDownInfo[] uniDsiDownInfoArray = this.listeners;
        for (int i2 = 0; i2 < uniDsiDownInfoArray.length; ++i2) {
            uniDsiDownInfoArray[i2].postTuneCommand(unifiedStationExt, this.selectionCounter);
        }
        ++this.selectionCounter;
    }

    private void preTuneCommand(UnifiedStationExt unifiedStationExt, int n) {
        UniDsiDownInfo[] uniDsiDownInfoArray = this.listeners;
        for (int i2 = 0; i2 < uniDsiDownInfoArray.length; ++i2) {
            uniDsiDownInfoArray[i2].preTuneCommand(unifiedStationExt);
        }
        TunerObjectContainer tunerObjectContainer = new TunerObjectContainer(unifiedStationExt);
        RadioInfo[] radioInfoArray = this.basicListeners;
        for (int i3 = 0; i3 < radioInfoArray.length; ++i3) {
            radioInfoArray[i3].updateStation(tunerObjectContainer, n);
        }
    }

    private void blockUpdates() {
        UniDsiDownInfo[] uniDsiDownInfoArray = this.listeners;
        for (int i2 = 0; i2 < uniDsiDownInfoArray.length; ++i2) {
            uniDsiDownInfoArray[i2].blockUpdates();
        }
    }
}

