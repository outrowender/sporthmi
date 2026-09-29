/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab;

import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.dsi.RadioInfo;
import de.audi.tuner.app.dab.DABDsiDownInfo;
import de.audi.tuner.app.dab.DabReceptionStatus;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.util.NullDSIDABTunerService;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.radio.DSIDABTuner;

public class DABDSIDownManager {
    private final LogChannel log;
    private DSIDABTuner dsi;
    private DABDsiDownInfo[] listeners = new DABDsiDownInfo[0];
    private RadioInfo[] basicListeners = new RadioInfo[0];
    private final SimpleIntObjectMap notifications = new SimpleIntObjectMap(20);
    private int selectionCounter = 0;

    DABDSIDownManager(TunerBasics tunerBasics) {
        this.log = tunerBasics.getLogger().dabDSI;
        this.dsi = new NullDSIDABTunerService(this.log);
    }

    public void setDeviceService(DSIDABTuner dSIDABTuner) {
        this.dsi = dSIDABTuner;
    }

    public boolean isDsiFound() {
        return !(this.dsi instanceof NullDSIDABTunerService);
    }

    void register(RadioInfo radioInfo) {
        if (radioInfo instanceof DABDsiDownInfo) {
            DABDsiDownInfo[] dABDsiDownInfoArray = new DABDsiDownInfo[this.listeners.length + 1];
            System.arraycopy((Object)this.listeners, 0, (Object)dABDsiDownInfoArray, 0, this.listeners.length);
            dABDsiDownInfoArray[this.listeners.length] = (DABDsiDownInfo)radioInfo;
            this.listeners = dABDsiDownInfoArray;
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
    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.log.log(-2137614336, "[DABDSIDownManager.setNotification] %1", (Object)nArray);
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
    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.log.log(-2137614336, "[DABDSIDownManager.clearNotification] %1", (Object)nArray);
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
    public void reNotification(int n) {
        SimpleIntObjectMap simpleIntObjectMap = this.notifications;
        synchronized (simpleIntObjectMap) {
            DSIListener dSIListener = (DSIListener)this.notifications.get(n);
            if (dSIListener != null) {
                this.log.log(-2137614336, "[DABDSIDownManager.reNotification] again for arrt %1", (long)n);
                this.dsi.setNotification(n, dSIListener);
            }
        }
    }

    public void selectStation(DabStation dabStation, int n, DabReceptionStatus dabReceptionStatus, int n2) {
        int n3;
        this.log.log(-2137614336, "[DABDSIDownManager.selectStation] %1 Mode: %2", (Object)dabStation, (long)n);
        DabStation dabStation2 = new DabStation(dabStation);
        dabStation2.resetProgramData();
        DABDsiDownInfo[] dABDsiDownInfoArray = this.listeners;
        for (int i2 = 0; i2 < dABDsiDownInfoArray.length; ++i2) {
            dABDsiDownInfoArray[i2].preTuneAction(dabStation2, dabReceptionStatus, this.selectionCounter);
        }
        TunerObjectContainer tunerObjectContainer = new TunerObjectContainer(dabStation2);
        RadioInfo[] radioInfoArray = this.basicListeners;
        for (n3 = 0; n3 < radioInfoArray.length; ++n3) {
            radioInfoArray[n3].updateStation(tunerObjectContainer, n2);
            radioInfoArray[n3].preTuneAction();
        }
        if (dabStation2.isService()) {
            n3 = n == 0 ? 2 : n;
            this.selectService(n3, dabStation2.service.sID, dabStation2.service.ensID, dabStation2.service.ensECC, 0, 0, dabStation2.ensemble.frequencyValue);
        } else if (dabStation2.isComponent()) {
            n3 = n == 0 ? 3 : n;
            this.selectService(n3, dabStation2.component.sID, dabStation2.component.ensID, dabStation2.component.ensECC, dabStation2.component.sCIDI, 0, dabStation2.ensemble.frequencyValue);
        } else {
            this.log.log(10000, "%1", (Throwable)new IllegalArgumentException("selectStation wrong parameters! "));
            n3 = n == 0 ? 2 : n;
            this.selectService(n3, dabStation2.service.sID, dabStation2.service.ensID, dabStation2.service.ensECC, dabStation2.component.ensECC, 0, dabStation2.ensemble.frequencyValue);
        }
        for (int i3 = 0; i3 < dABDsiDownInfoArray.length; ++i3) {
            dABDsiDownInfoArray[i3].postTuneAction(dabStation2, this.selectionCounter);
        }
        ++this.selectionCounter;
    }

    private void selectService(int n, long l, int n2, int n3, int n4, int n5, long l2) {
        if (this.log.isDebug()) {
            Buffer buffer = new Buffer(100);
            buffer.append("Mode:").append(n);
            buffer.append(" sID:").append(l);
            buffer.append(" ensID:").append(n2);
            buffer.append(" ensECC:").append(n3);
            buffer.append(" sCIDI:").append(n4);
            buffer.append(" frequency:").append(l2);
            this.log.log(-2137614336, "[DABDSIDownManager.selectService] %1", (Object)buffer);
        }
        this.dsi.selectService(n, l, n2, n3, n4, n5, l2);
    }

    public void seekService(int n) {
        this.log.log(-2137614336, "[DABDSIDownManager.seekService] mode %1", (long)n);
        if (n != 4) {
            DABDsiDownInfo[] dABDsiDownInfoArray = this.listeners;
            for (int i2 = 0; i2 < dABDsiDownInfoArray.length; ++i2) {
                dABDsiDownInfoArray[i2].seekStarted();
            }
        }
        this.dsi.seekService(n);
    }

    public void switchLinking(int n) {
        this.log.log(-2137614336, "[DABDSIDownManager.switchLinking] %1", (long)n);
        this.dsi.switchLinking(n);
    }

    public void switchLinkingDeviceUsage(int n) {
        this.log.log(-2137614336, "[DABDSIDownManager.switchLinkingDeviceUsage] %1", (long)n);
        this.dsi.switchLinkingDeviceUsage(n);
    }

    public void switchFrequencyTable(int n) {
        this.log.log(-2137614336, "[DABDSIDownManager.switchFrequencyTable] %1", (long)n);
        this.dsi.switchFrequencyTable(n);
    }

    public void reset(int n) {
        if (Utilities.isStd()) {
            this.log.log(-2137614336, "[DABDSIDownManager.reset] ignored at Std platform");
            return;
        }
        this.log.log(-2137614336, "[DABDSIDownManager.reset] %1", (long)n);
        this.dsi.reset(n);
    }

    public void forceLMUpdate(int n) {
        this.log.log(-2137614336, "[DABDSIDownManager.forceLMUpdate] %1", (long)n);
        this.dsi.forceLMUpdate(n);
    }

    public void enableRadioTextPlus(int[] nArray) {
        this.log.log(-2137614336, "[DABDSIDownManager.enableRadioTextPlus] %1", (Object)nArray);
        this.dsi.enableRadioTextPlus(nArray);
    }

    public void setEpgMode(int n) {
        this.log.log(-2137614336, "[DABDSIDownManager.setEpgMode] %1", (long)n);
        this.dsi.setEpgMode(n);
    }

    public void setSlideShowMode(int n) {
        this.log.log(-2137614336, "[DABDSIDownManager.setSlideShowMode] %1", (long)n);
        this.dsi.setSlideShowMode(n);
    }

    public void getEPGDetailData(DabStation dabStation) {
        this.log.log(-2137614336, "[DABDSIDownManager.getEPGDetailData] %1", (Object)dabStation);
        this.dsi.getEPGDetailData(dabStation.ensemble.ensID, dabStation.ensemble.ensECC, dabStation.service.sID, dabStation.component.sCIDI);
    }
}

