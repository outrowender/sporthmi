/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm;

import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.MemoryListHandler;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.TunerProxyManager;
import de.audi.tuner.app.TunerStatus;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.AMFMSetupHandler;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.AMFMTuner;
import de.audi.tuner.app.amfm.AbstractAmFmSpellerHandler;
import de.audi.tuner.app.amfm.AmSpellerHandler;
import de.audi.tuner.app.amfm.FmSpellerHandler;
import de.audi.tuner.app.amfm.FunctionWheelHandler;
import de.audi.tuner.app.amfm.dsi.AMFMDsiDownInfo;
import de.audi.tuner.app.amfm.dsi.RadioInfo;
import de.audi.tuner.app.amfm.stationlist.AmStationList;
import de.audi.tuner.app.amfm.stationlist.FmStationList;
import de.audi.tuner.app.amfm.stationlist.FmStationListNAR;
import de.audi.tuner.app.amfm.stationlist.IAmFmStationList;
import de.audi.tuner.app.amfm.stationlist.RecordSets;
import de.audi.tuner.app.amfm.stationlist.TiStationList;
import de.audi.tuner.app.ap.TunerActionProxyListener;
import de.audi.tuner.app.history.HistoryTuner;
import de.audi.tuner.app.storage.TunerStorage;
import de.audi.tuner.ifc.AbstractListRowFactory;
import de.audi.tuner.ifc.IPowerEvent;
import de.audi.tuner.ifc.IScanHandler;
import de.audi.tuner.ifc.IStationListHandler;
import de.audi.tuner.ifc.IStoreStationHandler;
import de.audi.tuner.ifc.ITunerAMFMGUIHandler;
import de.audi.tuner.ifc.ITunerVariantExt;
import de.audi.tuner.ifc.listener.IUpdateListener;
import de.audi.tuner.itunes.TaggingManager;
import java.util.ArrayList;

public class GUIHandlerAMFM
implements ITunerAMFMGUIHandler {
    final AMFMDsiDownInfo dsiDownInfo = new DsiDownListener();
    private final FunctionWheelHandler fmWheel;
    private final FunctionWheelHandler amWheel;
    private boolean blockDuringManualTune = false;
    private final IAmFmStationList fmStationList;
    private final AmStationList amStationList;
    private final TiStationList tiStationList;
    private final RecordSets recordSets;
    private final AMFMTuner amFmTuner;
    private final Logger logger;
    private final TunerModels models;
    private final TunerStatus status;
    private final MemoryListHandler memory;
    private final AMFMSetupHandler setupHandler;
    private final ChoiceListener choiceListener = new ChoiceListener();
    private long afOffFrequency;
    private final AbstractAmFmSpellerHandler fmSpellerHandler;
    private final AbstractAmFmSpellerHandler amSpellerHandler;

    GUIHandlerAMFM(AMFMTuner aMFMTuner, TunerBasics tunerBasics, MemoryListHandler memoryListHandler, TunerStorage tunerStorage, TaggingManager taggingManager, ITunerVariantExt iTunerVariantExt, LanguageManager languageManager, IScanHandler iScanHandler) {
        this.amFmTuner = aMFMTuner;
        this.logger = tunerBasics.getLogger();
        this.models = tunerBasics.getModels();
        this.status = tunerBasics.getStatus();
        this.memory = memoryListHandler;
        AbstractListRowFactory abstractListRowFactory = iTunerVariantExt.getListRowFactory();
        this.recordSets = new RecordSets(tunerBasics);
        this.setupHandler = new AMFMSetupHandler(this.logger, tunerStorage);
        this.setupHandler.init();
        int n = this.setupHandler.getCurrentSetup()[7];
        this.fmStationList = Utilities.isNARBuild() ? new FmStationListNAR(tunerBasics, this.recordSets, abstractListRowFactory, aMFMTuner, languageManager, iScanHandler, tunerStorage, memoryListHandler.storeHandler, memoryListHandler, n) : new FmStationList(tunerBasics, this.recordSets, abstractListRowFactory, aMFMTuner, languageManager, iScanHandler, tunerStorage, memoryListHandler.storeHandler, n);
        this.fmStationList.init(tunerStorage);
        this.amStationList = new AmStationList(tunerBasics, this.recordSets, abstractListRowFactory, aMFMTuner, languageManager, iScanHandler, tunerStorage, memoryListHandler.storeHandler);
        this.amStationList.init(tunerStorage);
        this.tiStationList = new TiStationList(tunerBasics, this.recordSets, abstractListRowFactory, aMFMTuner, languageManager, iScanHandler, tunerStorage, memoryListHandler.storeHandler);
        this.tiStationList.init(tunerStorage);
        this.fmWheel = new FunctionWheelHandler(tunerBasics, aMFMTuner, this.models.getRangeModel(100413), 1, iScanHandler, this.models.getLabelModel(100576));
        this.amWheel = new FunctionWheelHandler(tunerBasics, aMFMTuner, this.models.getRangeModel(100404), 3, iScanHandler, this.models.getLabelModel(100704));
        if (Utilities.isPGen1OrBentley() && Utilities.isNARBuild()) {
            FmSpellerHandler fmSpellerHandler = new FmSpellerHandler(tunerBasics, aMFMTuner, iScanHandler);
            aMFMTuner.registerDsiUpDownListener(fmSpellerHandler.fmUpListener);
            this.fmSpellerHandler = fmSpellerHandler;
            AmSpellerHandler amSpellerHandler = new AmSpellerHandler(tunerBasics, aMFMTuner, iScanHandler);
            aMFMTuner.registerDsiUpDownListener(amSpellerHandler.amUpListener);
            this.amSpellerHandler = amSpellerHandler;
        } else {
            this.fmSpellerHandler = null;
            this.amSpellerHandler = null;
        }
        this.initModels();
        this.afOffFrequency = tunerStorage.getAMFMLSM((int)1).frequency;
    }

    private void initModels() {
        this.models.getChoiceModel(100267).setValue(Utilities.isPiIgnore() ? 1 : 0);
        if (Utilities.isPiIgnore()) {
            this.models.getChoiceModel(100398).setStatus(0);
            this.models.getChoiceModel(100399).setStatus(0);
            this.models.getChoiceModel(100397).setStatus(0);
        } else {
            this.models.getChoiceModel(100398).setStatus(1);
            this.models.getChoiceModel(100399).setStatus(1);
            this.models.getChoiceModel(100397).setStatus(1);
        }
        if (Utilities.isNARBuild() && Utilities.isNARBandCoded()) {
            this.models.getChoiceModel(100621).setStatus(1);
        }
        this.models.setChoiceDataUpdateMediator(100390, 3);
        this.models.getChoiceModel(100398).setChoiceListener(this.choiceListener);
        if (Utilities.isJapan() && Utilities.isHigh()) {
            this.models.getChoiceModel(100394).setStatus(0);
            this.models.getChoiceModel(100396).setStatus(0);
        } else {
            this.models.getChoiceModel(100396).setStatus(0);
        }
        if (!Utilities.isPiIgnore() || Utilities.isJapan()) {
            this.models.getChoiceModel(100395).setStatus(0);
        } else {
            this.models.getChoiceModel(100395).setStatus(1);
            this.models.getChoiceModel(100394).setStatus(0);
        }
        this.models.getChoiceModel(100394).setChoiceListener(this.choiceListener);
        this.models.getChoiceModel(100397).setChoiceListener(this.choiceListener);
        this.models.getChoiceModel(100524).setChoiceListener(this.choiceListener);
        this.models.getChoiceModel(100399).setChoiceListener(this.choiceListener);
        this.models.getChoiceModel(100396).setChoiceListener(this.choiceListener);
        this.models.getChoiceModel(100395).setChoiceListener(this.choiceListener);
        this.models.getChoiceModel(100574).setChoiceListener(this.choiceListener);
        this.models.getChoiceModel(100575).setChoiceListener(this.choiceListener);
        this.models.getChoiceModel(100489).setButtonListener(this.choiceListener);
        this.models.getButtonModel(100603).setButtonListener(this.choiceListener);
        this.models.getButtonModel(100127).setButtonListener(this.choiceListener);
        this.models.getButtonModel(100145).setButtonListener(this.choiceListener);
    }

    public void register(IStoreStationHandler iStoreStationHandler) {
        this.fmStationList.register(iStoreStationHandler);
        this.amStationList.register(iStoreStationHandler);
    }

    public IPowerEvent getPoPowerStateListener() {
        return new PowerEventListener();
    }

    void initSetup() {
        int[] nArray = this.setupHandler.getCurrentSetup();
        this.processSetup(nArray);
    }

    void processSetup(int[] nArray) {
        if (nArray != null) {
            this.choiceListener.itemSelected(100398, nArray[1], 0, 0);
            this.choiceListener.itemSelected(100399, nArray[2], 0, 0);
            this.choiceListener.itemSelected(100395, nArray[5], 0, 0);
            this.choiceListener.itemSelected(100396, nArray[6], 0, 0);
            this.choiceListener.itemSelected(100397, nArray[7], 0, 0);
            this.choiceListener.itemSelected(100524, nArray[0], 0, 0);
            this.models.getChoiceModel(100574).setValue(nArray[9]);
            this.choiceListener.itemSelected(100575, nArray[8], 0, 0);
        }
    }

    public IStationListHandler getStationListHandler() {
        throw new UnsupportedOperationException();
    }

    public void setSelectedStation(AMFMStation aMFMStation) {
        this.logger.amfmDSI.log(10000000, "[GUIHandlerAMFM.setSelectedStation] %1", (Object)aMFMStation);
        switch (aMFMStation.waveband) {
            case 1: {
                if (this.blockDuringManualTune && aMFMStation.frequency != this.fmWheel.getPosition()) {
                    return;
                }
                this.amFmTuner.setActiveStationFM(aMFMStation);
                break;
            }
            case 3: 
            case 4: {
                if (this.models.getActiveTuner() == 10) {
                    this.amFmTuner.setActiveStationTI(aMFMStation);
                    break;
                }
                if (this.blockDuringManualTune && aMFMStation.frequency != this.amWheel.getPosition()) {
                    return;
                }
                this.amFmTuner.setActiveStationAM(aMFMStation);
                break;
            }
            default: {
                return;
            }
        }
    }

    public void switchNamesOnOff(int n) {
        boolean bl = n == 1;
        this.status.setDisplayStationNames(bl);
        this.recordSets.setNamesOnOff(bl);
        this.memory.setNamesOnOff(bl);
        HistoryTuner historyTuner = TunerProxyManager.getInstance().getHistoryTuner();
        if (historyTuner != null) {
            historyTuner.setNamesOnOff(bl);
        }
        this.models.getChoiceModel(100396).setValue(n);
        this.amFmTuner.reNotification(2);
        this.amFmTuner.reNotification(3);
    }

    public boolean tuneById(long l, int n) {
        int n2 = this.models.getActiveTuner();
        switch (n2) {
            case 1: {
                return this.fmStationList.tuneById(l, n);
            }
            case 4: {
                return this.amStationList.tuneById(l, n);
            }
            case 10: {
                return this.tiStationList.tuneById(l, n);
            }
        }
        return false;
    }

    public TunerObjectContainer[] getStationList() {
        return this.getStationList(this.models.getActiveTuner());
    }

    public TunerObjectContainer[] getStationList(int n) {
        switch (n) {
            case 1: {
                return this.fmStationList.getStationList();
            }
            case 4: {
                return this.amStationList.getStationList();
            }
            case 10: {
                return this.tiStationList.getStationList();
            }
        }
        return new TunerObjectContainer[0];
    }

    public TunerObjectContainer getCurrentStation() {
        IAmFmStationList iAmFmStationList = null;
        int n = this.models.getActiveTuner();
        switch (n) {
            case 4: {
                iAmFmStationList = this.amStationList;
                break;
            }
            case 1: {
                iAmFmStationList = this.fmStationList;
                break;
            }
            case 10: {
                iAmFmStationList = this.tiStationList;
                break;
            }
        }
        if (iAmFmStationList == null) {
            return null;
        }
        return new TunerObjectContainer(iAmFmStationList.getActiveStation());
    }

    void addUpdateListeners(IUpdateListener[] iUpdateListenerArray) {
        for (int i2 = 0; i2 < iUpdateListenerArray.length; ++i2) {
            this.fmStationList.addUpdateListener(iUpdateListenerArray[i2]);
            this.amStationList.addUpdateListener(iUpdateListenerArray[i2]);
            this.tiStationList.addUpdateListener(iUpdateListenerArray[i2]);
        }
    }

    void setupValueUpdated(int n, int n2) {
        this.setupHandler.valueUpdated(n, n2);
    }

    public IAmFmStationList getFMStationList() {
        return this.fmStationList;
    }

    public IAmFmStationList getAMStationList() {
        return this.amStationList;
    }

    public IAmFmStationList getTIStationList() {
        return this.tiStationList;
    }

    public TunerActionProxyListener[] getActionProxyListeners() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.fmWheel.actionProxyListener);
        if (this.fmSpellerHandler != null) {
            arrayList.add(this.fmSpellerHandler.proxyListener);
        }
        if (this.amSpellerHandler != null) {
            arrayList.add(this.amSpellerHandler.proxyListener);
        }
        return (TunerActionProxyListener[])arrayList.toArray(new TunerActionProxyListener[arrayList.size()]);
    }

    AMFMDsiDownInfo getManWheelDownListener(int n) {
        switch (n) {
            case 4: {
                return this.amWheel.dsiDownListener;
            }
            case 1: {
                return this.fmWheel.dsiDownListener;
            }
        }
        throw new IllegalArgumentException();
    }

    RadioInfo[] getDsiUpListeners() {
        ArrayList arrayList = new ArrayList(10);
        arrayList.add(this.amWheel.dsiUpListener);
        arrayList.add(this.fmWheel.dsiUpListener);
        arrayList.add(this.fmStationList.getDsiUpListener());
        arrayList.add(this.amStationList.getDsiUpListener());
        arrayList.add(this.tiStationList.getDsiUpListener());
        if (this.fmSpellerHandler != null && this.amSpellerHandler != null) {
            arrayList.add(this.fmSpellerHandler.dsiUpListener);
            arrayList.add(this.amSpellerHandler.dsiUpListener);
        }
        return (RadioInfo[])arrayList.toArray(new RadioInfo[arrayList.size()]);
    }

    private class ChoiceListener
    extends DefaultChoiceListener {
        private ChoiceListener() {
        }

        public void itemSelected(int n, int n2, int n3, int n4) {
            ((GUIHandlerAMFM)GUIHandlerAMFM.this).logger.hmi.log(100000000, "[GUIHandlerAMFM.itemSelected] model:%1 index:%2", (long)n, (long)n2);
            switch (n) {
                case 100397: {
                    GUIHandlerAMFM.this.models.getChoiceModel(100397).setValue(n2);
                    GUIHandlerAMFM.this.fmStationList.setSortAlgo(n2);
                    GUIHandlerAMFM.this.setupHandler.valueUpdated(n2, 7);
                    break;
                }
                case 100524: {
                    GUIHandlerAMFM.this.models.getChoiceModel(100524).setValue(n2);
                    GUIHandlerAMFM.this.amStationList.setSortAlgo(n2);
                    GUIHandlerAMFM.this.setupHandler.valueUpdated(n2, 0);
                    break;
                }
                case 100398: {
                    GUIHandlerAMFM.this.models.getChoiceModel(100398).setValue(n2);
                    GUIHandlerAMFM.this.amFmTuner.switchAF(n2 == 1);
                    if (!Utilities.isAfAutoResetActivated()) break;
                    GUIHandlerAMFM.this.afOffFrequency = (int)((GUIHandlerAMFM)GUIHandlerAMFM.this).amFmTuner.getActiveStationFM().frequency;
                    break;
                }
                case 100399: {
                    GUIHandlerAMFM.this.models.getChoiceModel(100399).setValue(n2);
                    GUIHandlerAMFM.this.amFmTuner.switchReg(n2 == 1);
                    break;
                }
                case 100574: {
                    boolean bl = n2 == 1;
                    boolean bl2 = GUIHandlerAMFM.this.models.getChoiceModel(100575).getValue() == 1;
                    GUIHandlerAMFM.this.amFmTuner.switchHD(bl, bl2);
                    break;
                }
                case 100575: {
                    boolean bl = GUIHandlerAMFM.this.models.getChoiceModel(100574).getValue() == 1;
                    boolean bl3 = n2 == 1;
                    GUIHandlerAMFM.this.amFmTuner.switchHD(bl, bl3);
                    break;
                }
                case 100396: {
                    GUIHandlerAMFM.this.switchNamesOnOff(n2);
                    GUIHandlerAMFM.this.models.getChoiceModel(100396).setValue(n2);
                    GUIHandlerAMFM.this.setupHandler.valueUpdated(n2, 6);
                    break;
                }
                case 100395: {
                    GUIHandlerAMFM.this.amFmTuner.getStationNameHistory().setStationDisplayModeFixed(n2 == 1);
                    GUIHandlerAMFM.this.models.getChoiceModel(100395).setValue(n2);
                    GUIHandlerAMFM.this.setupHandler.valueUpdated(n2, 5);
                    break;
                }
                default: {
                    return;
                }
            }
        }

        public void keyTyped(int n, int n2, int n3) {
            ((GUIHandlerAMFM)GUIHandlerAMFM.this).logger.amfmGUI.log(100000000, "[GUIHAMFM.keyTyped] %1", (long)n);
            switch (n) {
                case 100489: {
                    GUIHandlerAMFM.this.amFmTuner.forceStationListUpdate(true);
                    GUIHandlerAMFM.this.models.getChoiceModel(n).setValue(1);
                    GUIHandlerAMFM.this.models.getChoiceModel(n).fireEvent(n3);
                    break;
                }
                case 100603: {
                    GUIHandlerAMFM.this.amFmTuner.nextSubChannel(n3);
                    break;
                }
                default: {
                    return;
                }
            }
        }

        public void keyReleased(int n, int n2, int n3) {
            ((GUIHandlerAMFM)GUIHandlerAMFM.this).logger.amfmGUI.log(100000000, "[GUIHAMFM.keyReleased] %1", (long)n);
            switch (n) {
                case 100127: {
                    GUIHandlerAMFM.this.amFmTuner.seekStation(1, n3);
                    break;
                }
                case 100145: {
                    GUIHandlerAMFM.this.amFmTuner.seekStation(2, n3);
                    break;
                }
            }
        }

        public void keyLongTyped(int n, int n2, int n3) {
            ((GUIHandlerAMFM)GUIHandlerAMFM.this).logger.amfmGUI.log(100000000, "[GUIHAMFM.keyLongTyped] %1", (long)n);
            switch (n) {
                case 100127: {
                    GUIHandlerAMFM.this.amFmTuner.seekStation(5, n3);
                    break;
                }
                case 100145: {
                    GUIHandlerAMFM.this.amFmTuner.seekStation(6, n3);
                    break;
                }
            }
        }
    }

    private class DsiDownListener
    extends AMFMDsiDownInfo {
        private DsiDownListener() {
        }

        public void preTuneAction(AMFMStation aMFMStation, boolean bl) {
            if (Utilities.isAfAutoResetActivated() && aMFMStation.waveband == 1 && GUIHandlerAMFM.this.afOffFrequency != aMFMStation.frequency && GUIHandlerAMFM.this.models.getChoiceModel(100398).getValue() == 0) {
                ((GUIHandlerAMFM)GUIHandlerAMFM.this).logger.amfmDSI.log(1000000, "[GUIHandlerAMFM] auto enable AF");
                GUIHandlerAMFM.this.choiceListener.itemSelected(100398, 1, 0, 0);
            }
        }

        public void switchHdOn(AMFMStation aMFMStation) {
            if (aMFMStation.waveband == 1 && GUIHandlerAMFM.this.models.getChoiceModel(100575).getValue() == 0) {
                GUIHandlerAMFM.this.choiceListener.itemSelected(100575, 1, 0, 0);
            } else if (aMFMStation.waveband == 3 && GUIHandlerAMFM.this.models.getChoiceModel(100574).getValue() == 0) {
                GUIHandlerAMFM.this.choiceListener.itemSelected(100574, 1, 0, 0);
            }
        }
    }

    private class PowerEventListener
    implements IPowerEvent {
        private PowerEventListener() {
        }

        public void notifyPowerEvent(int n, int n2) {
            if (n == 2 && GUIHandlerAMFM.this.models.getChoiceModel(100489).getValue() == 1) {
                GUIHandlerAMFM.this.amFmTuner.forceStationListUpdate(false);
            }
        }
    }
}

