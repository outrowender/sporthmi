/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm;

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
import de.audi.tuner.app.amfm.GUIHandlerAMFM$ChoiceListener;
import de.audi.tuner.app.amfm.GUIHandlerAMFM$DsiDownListener;
import de.audi.tuner.app.amfm.GUIHandlerAMFM$PowerEventListener;
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
    final AMFMDsiDownInfo dsiDownInfo = new GUIHandlerAMFM$DsiDownListener(this, null);
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
    private final GUIHandlerAMFM$ChoiceListener choiceListener = new GUIHandlerAMFM$ChoiceListener(this, null);
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
        this.fmWheel = new FunctionWheelHandler(tunerBasics, aMFMTuner, this.models.getRangeModel(1032323328), 1, iScanHandler, this.models.getLabelModel(-527957760));
        this.amWheel = new FunctionWheelHandler(tunerBasics, aMFMTuner, this.models.getRangeModel(881328384), 3, iScanHandler, this.models.getLabelModel(1619591424));
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
        this.models.getChoiceModel(-1417215744).setValue(Utilities.isPiIgnore() ? 1 : 0);
        if (Utilities.isPiIgnore()) {
            this.models.getChoiceModel(780665088).setStatus(0);
            this.models.getChoiceModel(797442304).setStatus(0);
            this.models.getChoiceModel(763887872).setStatus(0);
        } else {
            this.models.getChoiceModel(780665088).setStatus(1);
            this.models.getChoiceModel(797442304).setStatus(1);
            this.models.getChoiceModel(763887872).setStatus(1);
        }
        if (Utilities.isNARBuild() && Utilities.isNARBandCoded()) {
            this.models.getChoiceModel(227082496).setStatus(1);
        }
        this.models.setChoiceDataUpdateMediator(646447360, 3);
        this.models.getChoiceModel(780665088).setChoiceListener(this.choiceListener);
        if (Utilities.isJapan() && Utilities.isHigh()) {
            this.models.getChoiceModel(713556224).setStatus(0);
            this.models.getChoiceModel(747110656).setStatus(0);
        } else {
            this.models.getChoiceModel(747110656).setStatus(0);
        }
        if (!Utilities.isPiIgnore() || Utilities.isJapan()) {
            this.models.getChoiceModel(730333440).setStatus(0);
        } else {
            this.models.getChoiceModel(730333440).setStatus(1);
            this.models.getChoiceModel(713556224).setStatus(0);
        }
        this.models.getChoiceModel(713556224).setChoiceListener(this.choiceListener);
        this.models.getChoiceModel(763887872).setChoiceListener(this.choiceListener);
        this.models.getChoiceModel(-1400372992).setChoiceListener(this.choiceListener);
        this.models.getChoiceModel(797442304).setChoiceListener(this.choiceListener);
        this.models.getChoiceModel(747110656).setChoiceListener(this.choiceListener);
        this.models.getChoiceModel(730333440).setChoiceListener(this.choiceListener);
        this.models.getChoiceModel(-561512192).setChoiceListener(this.choiceListener);
        this.models.getChoiceModel(-544734976).setChoiceListener(this.choiceListener);
        this.models.getChoiceModel(-1987575552).setButtonListener(this.choiceListener);
        this.models.getButtonModel(-74972928).setButtonListener(this.choiceListener);
        this.models.getButtonModel(528941312).setButtonListener(this.choiceListener);
        this.models.getButtonModel(830931200).setButtonListener(this.choiceListener);
    }

    @Override
    public void register(IStoreStationHandler iStoreStationHandler) {
        this.fmStationList.register(iStoreStationHandler);
        this.amStationList.register(iStoreStationHandler);
    }

    @Override
    public IPowerEvent getPoPowerStateListener() {
        return new GUIHandlerAMFM$PowerEventListener(this, null);
    }

    void initSetup() {
        int[] nArray = this.setupHandler.getCurrentSetup();
        this.processSetup(nArray);
    }

    void processSetup(int[] nArray) {
        if (nArray != null) {
            this.choiceListener.itemSelected(780665088, nArray[1], 0, 0);
            this.choiceListener.itemSelected(797442304, nArray[2], 0, 0);
            this.choiceListener.itemSelected(730333440, nArray[5], 0, 0);
            this.choiceListener.itemSelected(747110656, nArray[6], 0, 0);
            this.choiceListener.itemSelected(763887872, nArray[7], 0, 0);
            this.choiceListener.itemSelected(-1400372992, nArray[0], 0, 0);
            this.models.getChoiceModel(-561512192).setValue(nArray[9]);
            this.choiceListener.itemSelected(-544734976, nArray[8], 0, 0);
        }
    }

    @Override
    public IStationListHandler getStationListHandler() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setSelectedStation(AMFMStation aMFMStation) {
        this.logger.amfmDSI.log(-2137614336, "[GUIHandlerAMFM.setSelectedStation] %1", (Object)aMFMStation);
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
        this.models.getChoiceModel(747110656).setValue(n);
        this.amFmTuner.reNotification(2);
        this.amFmTuner.reNotification(3);
    }

    @Override
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

    @Override
    public TunerObjectContainer[] getStationList() {
        return this.getStationList(this.models.getActiveTuner());
    }

    @Override
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

    @Override
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

    static /* synthetic */ long access$300(GUIHandlerAMFM gUIHandlerAMFM) {
        return gUIHandlerAMFM.afOffFrequency;
    }

    static /* synthetic */ TunerModels access$400(GUIHandlerAMFM gUIHandlerAMFM) {
        return gUIHandlerAMFM.models;
    }

    static /* synthetic */ Logger access$500(GUIHandlerAMFM gUIHandlerAMFM) {
        return gUIHandlerAMFM.logger;
    }

    static /* synthetic */ GUIHandlerAMFM$ChoiceListener access$600(GUIHandlerAMFM gUIHandlerAMFM) {
        return gUIHandlerAMFM.choiceListener;
    }

    static /* synthetic */ IAmFmStationList access$700(GUIHandlerAMFM gUIHandlerAMFM) {
        return gUIHandlerAMFM.fmStationList;
    }

    static /* synthetic */ AMFMSetupHandler access$800(GUIHandlerAMFM gUIHandlerAMFM) {
        return gUIHandlerAMFM.setupHandler;
    }

    static /* synthetic */ AmStationList access$900(GUIHandlerAMFM gUIHandlerAMFM) {
        return gUIHandlerAMFM.amStationList;
    }

    static /* synthetic */ AMFMTuner access$1000(GUIHandlerAMFM gUIHandlerAMFM) {
        return gUIHandlerAMFM.amFmTuner;
    }

    static /* synthetic */ long access$302(GUIHandlerAMFM gUIHandlerAMFM, long l) {
        gUIHandlerAMFM.afOffFrequency = l;
        return gUIHandlerAMFM.afOffFrequency;
    }
}

