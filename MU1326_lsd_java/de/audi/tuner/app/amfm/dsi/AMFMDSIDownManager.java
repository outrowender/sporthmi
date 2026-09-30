/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.dsi;

import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.dsi.AMFMDsiDownInfo;
import de.audi.tuner.app.amfm.dsi.AMFMDsiUpInfo;
import de.audi.tuner.app.amfm.dsi.AMFMTuningQueue;
import de.audi.tuner.app.amfm.dsi.IAmFmDsiDownManager;
import de.audi.tuner.app.amfm.dsi.RadioInfo;
import de.audi.tuner.util.NullDSIAMFMTunerService;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.radio.DSIAMFMTuner;

public class AMFMDSIDownManager
implements IAmFmDsiDownManager {
    private final LogChannel log;
    private DSIAMFMTuner dsi;
    private AMFMDsiDownInfo[] listeners = new AMFMDsiDownInfo[0];
    private RadioInfo[] basicListeners = new RadioInfo[0];
    private final SimpleIntObjectMap notifications = new SimpleIntObjectMap(20);
    private final AMFMTuningQueue tuningQueue;
    private int selectionCounter = 0;
    private final Object globalAmFmLock;
    private volatile boolean ertDisplayable;
    private boolean notifiedForSelStation = false;

    public AMFMDSIDownManager(TunerBasics tunerBasics, Object object) {
        this.log = tunerBasics.getLogger().amfmDSI;
        this.dsi = new NullDSIAMFMTunerService(this.log);
        this.tuningQueue = new AMFMTuningQueue(tunerBasics.getLogger(), this, object);
        this.globalAmFmLock = object;
    }

    public AMFMDsiUpInfo getDsiUpListener() {
        return this.tuningQueue.dsiUpListener;
    }

    public void setDeviceService(DSIAMFMTuner dSIAMFMTuner) {
        this.dsi = dSIAMFMTuner;
    }

    public boolean isDsiFound() {
        return !(this.dsi instanceof NullDSIAMFMTunerService);
    }

    public void register(RadioInfo radioInfo) {
        if (radioInfo instanceof AMFMDsiDownInfo) {
            AMFMDsiDownInfo[] aMFMDsiDownInfoArray = new AMFMDsiDownInfo[this.listeners.length + 1];
            System.arraycopy((Object)this.listeners, 0, (Object)aMFMDsiDownInfoArray, 0, this.listeners.length);
            aMFMDsiDownInfoArray[this.listeners.length] = (AMFMDsiDownInfo)radioInfo;
            this.listeners = aMFMDsiDownInfoArray;
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
        this.log.log(10000000, "[AMFMDSIDownManager.setNotification] %1", (Object)nArray);
        Object object = this.globalAmFmLock;
        synchronized (object) {
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
        this.log.log(10000000, "[AMFMDSIDownManager.clearNotification] %1", (Object)nArray);
        Object object = this.globalAmFmLock;
        synchronized (object) {
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
        Object object = this.globalAmFmLock;
        synchronized (object) {
            Object object2;
            if (n == 1) {
                object2 = this.listeners;
                for (int i2 = 0; i2 < ((AMFMDsiDownInfo[])object2).length; ++i2) {
                    object2[i2].unBlockUpdates();
                }
            }
            if ((object2 = (DSIListener)this.notifications.get(n)) != null) {
                this.log.log(10000000, "[AMFMDSIDownManager.setNotification] again for arrt %1", (long)n);
                this.dsi.setNotification(n, (DSIListener)object2);
            }
        }
    }

    void selectStation(int n, int n2, int n3) {
        int n4;
        Object object;
        if (this.log.isDebug()) {
            object = new Buffer(30);
            ((Buffer)object).append("f:").append(n);
            ((Buffer)object).append(" pi:0x").append(Integer.toHexString(n2));
            ((Buffer)object).append(" sc:").append(n3);
            this.log.log(10000000, "[AMFMDSIDownManager.selectStation] %1", object);
        }
        object = this.listeners;
        for (n4 = 0; n4 < ((Object)object).length; ++n4) {
            ((AMFMDsiDownInfo)object[n4]).blockUpdates();
        }
        this.dsi.selectStation(n, n2, n3);
        this.setERTDisplayable(true);
        if (!this.notifiedForSelStation) {
            for (n4 = 0; n4 < ((Object)object).length; ++n4) {
                ((AMFMDsiDownInfo)object[n4]).setNotificationForSelectedStation();
            }
            this.notifiedForSelStation = true;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void tuneStation(AMFMStation aMFMStation, boolean bl, boolean bl2, int n) {
        AMFMStation aMFMStation2 = new AMFMStation(aMFMStation);
        aMFMStation2.resetProgramData();
        Object object = this.globalAmFmLock;
        synchronized (object) {
            int n2;
            int n3;
            AMFMDsiDownInfo[] aMFMDsiDownInfoArray = this.listeners;
            if (aMFMStation.isHd()) {
                for (n3 = 0; n3 < aMFMDsiDownInfoArray.length; ++n3) {
                    aMFMDsiDownInfoArray[n3].switchHdOn(aMFMStation);
                }
            }
            for (n3 = 0; n3 < aMFMDsiDownInfoArray.length; ++n3) {
                aMFMDsiDownInfoArray[n3].preTuneAction(aMFMStation2, bl);
            }
            RadioInfo[] radioInfoArray = this.basicListeners;
            TunerObjectContainer tunerObjectContainer = new TunerObjectContainer(aMFMStation2);
            for (n2 = 0; n2 < radioInfoArray.length; ++n2) {
                radioInfoArray[n2].updateStation(tunerObjectContainer, n);
                radioInfoArray[n2].preTuneAction();
            }
            if (bl2) {
                return;
            }
            this.tuningQueue.tuneStation((int)aMFMStation2.frequency, aMFMStation2.pi, aMFMStation2.serviceId, bl);
            for (n2 = 0; n2 < aMFMDsiDownInfoArray.length; ++n2) {
                aMFMDsiDownInfoArray[n2].postTuneAction(aMFMStation2, this.selectionCounter);
            }
            ++this.selectionCounter;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void seekStation(int n) {
        Object object = this.globalAmFmLock;
        synchronized (object) {
            this.log.log(10000000, "[AMFMDSIDownManager.seekStation] %1", (long)n);
            this.dsi.seekStation(n);
            this.setERTDisplayable(true);
        }
    }

    public void switchAF(boolean bl) {
        this.log.log(10000000, "[AMFMDSIDownManager.switchAF] %1", bl);
        this.dsi.switchAF(bl);
    }

    public void switchREG(int n) {
        this.log.log(10000000, "[AMFMDSIDownManager.switchREG] %1", (long)n);
        this.dsi.switchREG(n);
    }

    public void switchLinkingDeviceUsage(int n) {
        this.log.log(10000000, "[AMFMDSIDownManager.switchLinkingDeviceUsage] %1", (long)n);
        this.dsi.switchLinkingDeviceUsage(n);
    }

    public void reset(int n) {
        this.log.log(10000000, "[AMFMDSIDownManager.reset] %1", (long)n);
        this.dsi.reset(n);
    }

    void selectFrequency(int n) {
        this.log.log(10000000, "[AMFMDSIDownManager.selectFrequency] %1", (long)n);
        AMFMDsiDownInfo[] aMFMDsiDownInfoArray = this.listeners;
        for (int i2 = 0; i2 < aMFMDsiDownInfoArray.length; ++i2) {
            aMFMDsiDownInfoArray[i2].blockUpdates();
        }
        this.dsi.selectFrequency(n);
        this.setERTDisplayable(true);
    }

    public void isOnPreset(int n, int n2, int n3, String string) {
        if (this.log.isDebug()) {
            Buffer buffer = new Buffer(30);
            buffer.append("f:").append(n);
            buffer.append(" pi:0x").append(Integer.toHexString(n2));
            buffer.append(" loc:").append(n3);
            buffer.append(" name:").append(string);
            this.log.log(10000000, "[AMFMDSIDownManager.isOnPreset] %1", (Object)buffer);
        }
        this.dsi.isOnPreset(n, n2, n3, string);
    }

    public void freePreset(int n) {
        this.log.log(10000000, "[AMFMDSIDownManager.freePreset] %1", (long)n);
        this.dsi.freePreset(n);
    }

    public void forceAMUpdate(int n) {
        this.log.log(10000000, "[AMFMDSIDownManager.forceAMUpdate] %1", (long)n);
        this.dsi.forceAMUpdate(n);
    }

    public void switchRDSIgnore(boolean bl) {
        this.log.log(10000000, "[AMFMDSIDownManager.switchRDSIgnore] %1", bl);
        this.dsi.switchRDSIgnore(bl);
    }

    public void enableRadiotextPlus(int[] nArray) {
        this.log.log(10000000, "[AMFMDSIDownManager.enableRadiotextPlus] %1", (Object)nArray);
        this.dsi.enableRadiotextPlus(nArray);
    }

    public void setModeHD(int n) {
        this.log.log(10000000, "[AMFMDSIDownManager.setModeHD] %1", (long)n);
        this.dsi.setModeHD(n);
    }

    public void setERTPrefered(boolean bl) {
        this.log.log(10000000, "[AMFMDSIDownManager.setERTPrefered] %1", bl);
        this.dsi.setERTPrefered(bl);
    }

    public void setERTDisplayable(boolean bl) {
        this.log.log(10000000, "[AMFMDSIDownManager.setERTDisplayable] %1", bl);
        if (bl != this.ertDisplayable) {
            this.ertDisplayable = bl;
            this.dsi.setERTDisplayable(bl);
        }
    }
}

