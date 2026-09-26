/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.atip.interapp.radio.IHistoryListService;
import de.audi.atip.interapp.radio.IHistoryVetoService;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.IDrawerFocusManager;
import de.audi.tuner.app.LanguageManager$ILanguageChangeListener;
import de.audi.tuner.app.RadioComparators;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.dsi.AMFMDsiDownInfo;
import de.audi.tuner.app.amfm.dsi.AMFMDsiUpInfo;
import de.audi.tuner.app.dab.DABDsiDownInfo;
import de.audi.tuner.app.dab.DABDsiUpInfo;
import de.audi.tuner.app.history.HistoryStationList;
import de.audi.tuner.app.history.HistoryTuner$1;
import de.audi.tuner.app.history.HistoryTuner$2;
import de.audi.tuner.app.history.HistoryTuner$3;
import de.audi.tuner.app.history.HistoryTuner$AMFMDsiDownListener;
import de.audi.tuner.app.history.HistoryTuner$AMFMDsiUpListener;
import de.audi.tuner.app.history.HistoryTuner$AudioFocusInfoListener;
import de.audi.tuner.app.history.HistoryTuner$AudioInfoListener;
import de.audi.tuner.app.history.HistoryTuner$DABDsiDownListener;
import de.audi.tuner.app.history.HistoryTuner$DABDsiUpListener;
import de.audi.tuner.app.history.HistoryTuner$HistoryListService;
import de.audi.tuner.app.history.HistoryTuner$HistoryVetoService;
import de.audi.tuner.app.history.HistoryTuner$RsdbStatusListener;
import de.audi.tuner.app.history.HistoryTuner$SDARSDsiDownListener;
import de.audi.tuner.app.history.HistoryTuner$SDARSDsiUpListener;
import de.audi.tuner.app.history.HistoryTuner$TimerListener;
import de.audi.tuner.app.history.HistoryTuner$UniDsiDownListener;
import de.audi.tuner.app.history.HistoryTuner$UniDsiUpListener;
import de.audi.tuner.app.history.IHistoryTuneListener;
import de.audi.tuner.app.history.ITunePlugin;
import de.audi.tuner.app.misc.IOptionsListener;
import de.audi.tuner.app.sdars.dsi.SDARSDsiDownInfo;
import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;
import de.audi.tuner.app.storage.TunerStorage;
import de.audi.tuner.app.uni.UniDsiDownInfo;
import de.audi.tuner.app.uni.UniDsiUpInfo;
import de.audi.tuner.ifc.AbstractListRowFactory;
import de.audi.tuner.ifc.ILogoDatabase;
import de.audi.tuner.ifc.IMemoryList;
import de.audi.tuner.ifc.IPowerEvent;
import de.audi.tuner.ifc.IPrevNext;
import de.audi.tuner.ifc.IScanHandler;
import de.audi.tuner.ifc.listener.IUpdateListener;
import de.audi.tuner.ifc.listener.MessageListener;
import de.audi.tuner.sds.UpdateListenerHandler;

public class HistoryTuner
extends UpdateListenerHandler {
    private final Timer addTimer = new Timer("history", 0, true, new HistoryTuner$TimerListener(this, null));
    public final IHistoryListService historyListService = new HistoryTuner$HistoryListService(this, null);
    public final IHistoryVetoService historyVetoService = new HistoryTuner$HistoryVetoService(this, null);
    public ILogoDatabase logoDb = null;
    public final AMFMDsiUpInfo amfmDsiUpListener = new HistoryTuner$AMFMDsiUpListener(this, null);
    public final DABDsiUpInfo dabDsiUpListener = new HistoryTuner$DABDsiUpListener(this, null);
    public final SDARSDsiUpInfo sdarsDsiUpListener = new HistoryTuner$SDARSDsiUpListener(this, null);
    public final UniDsiUpInfo uniDsiUpListener = new HistoryTuner$UniDsiUpListener(this, null);
    public final AMFMDsiDownInfo amfmDsiDownListener = new HistoryTuner$AMFMDsiDownListener(this, null);
    public final UniDsiDownInfo uniDsiDownListener = new HistoryTuner$UniDsiDownListener(this, null);
    public final SDARSDsiDownInfo sdarsDsiDownListener = new HistoryTuner$SDARSDsiDownListener(this, null);
    public final DABDsiDownInfo dabDsiDownListener = new HistoryTuner$DABDsiDownListener(this, null);
    public final HistoryTuner$AudioInfoListener audioInfoListener = new HistoryTuner$AudioInfoListener(this, null);
    public final HistoryTuner$AudioFocusInfoListener audioFocusListener = new HistoryTuner$AudioFocusInfoListener(this, null);
    public final HistoryTuner$RsdbStatusListener rsdbStatusListener = new HistoryTuner$RsdbStatusListener(this, null);
    private TunerObjectContainer amFmSelStation;
    private TunerObjectContainer dabStation;
    private TunerObjectContainer uniStation;
    private TunerObjectContainer sdarsStation;
    private TunerObjectContainer tvStation;
    private boolean radioHasAudioFocus = false;
    private boolean tvHasAudioFocus = false;
    private volatile TunerObjectContainer lastStation = new TunerObjectContainer(new AMFMStation());
    private final boolean[] addOperationVetos = new boolean[2];
    private final HistoryStationList historyList;
    private final TunerBasics basics;
    private final TunerStorage storage;

    public HistoryTuner(TunerBasics tunerBasics, AbstractListRowFactory abstractListRowFactory, TunerStorage tunerStorage, IScanHandler iScanHandler) {
        this.basics = tunerBasics;
        this.storage = tunerStorage;
        this.historyList = new HistoryStationList(tunerBasics, abstractListRowFactory, tunerStorage, this, iScanHandler);
    }

    public void init() {
        int[] nArray = this.storage.loadLastMode();
        this.amFmSelStation = new TunerObjectContainer(this.storage.getAMFMLSM(nArray[1] == 4 ? 4 : 1));
        this.dabStation = new TunerObjectContainer(this.storage.loadLastDABService());
        this.uniStation = new TunerObjectContainer(this.storage.loadLastUnifiedStation());
        this.sdarsStation = new TunerObjectContainer(this.storage.loadLastSDARSStation());
        this.tvStation = TunerObjectContainer.EMPTY_CONTAINER;
        this.historyList.init(null);
    }

    public void register(IDrawerFocusManager iDrawerFocusManager) {
        this.historyList.register(iDrawerFocusManager);
    }

    public void addHistoryTuneListener(IHistoryTuneListener iHistoryTuneListener) {
        this.historyList.addHistoryTuneListener(iHistoryTuneListener);
    }

    public void setTunePlugin(ITunePlugin iTunePlugin) {
        this.historyList.setTunePlugin(iTunePlugin);
    }

    public IPowerEvent getPowerEventListener() {
        return this.historyList.powerEventListener;
    }

    public IOptionsListener getOptionsListener() {
        return this.historyList.optionsListener;
    }

    public MessageListener getMessageListener() {
        return this.historyList.messageListener;
    }

    public LanguageManager$ILanguageChangeListener getLanguageChangeListener() {
        return this.historyList.languageChangeListener;
    }

    public IUpdateListener getUpdateListener(IMemoryList iMemoryList) {
        return this.historyList.getUpdateListener(iMemoryList);
    }

    private void update() {
        boolean bl = false;
        TunerObjectContainer tunerObjectContainer = this.lastStation;
        if (this.radioHasAudioFocus) {
            int n = this.basics.getModels().getActiveTuner();
            switch (n) {
                case 1: 
                case 4: 
                case 10: {
                    tunerObjectContainer = this.amFmSelStation;
                    break;
                }
                case 5: {
                    tunerObjectContainer = this.dabStation;
                    break;
                }
                case 11: {
                    tunerObjectContainer = this.uniStation;
                    break;
                }
                case 7: {
                    tunerObjectContainer = this.sdarsStation;
                    break;
                }
                default: {
                    this.basics.getLogger().history.log(10000, "[HistoryTuner.update] Invalid radio band %1", (long)n);
                }
            }
            bl = !RadioComparators.equals(tunerObjectContainer, this.lastStation);
        } else if (this.tvHasAudioFocus) {
            tunerObjectContainer = this.tvStation;
            bl = !RadioComparators.equals(tunerObjectContainer, this.lastStation);
        } else {
            this.addTimer.cancel();
        }
        if (bl) {
            this.addTimer.restart();
        }
        this.lastStation = tunerObjectContainer;
    }

    public void updatePSFreeze(AMFMStation aMFMStation) {
        if (!this.basics.tunerJobQueue.isJobQueueDispatchThread()) {
            this.basics.tunerJobQueue.enqueue(new HistoryTuner$1(this, "HistroyTuner.updatePSFreeze", aMFMStation));
            return;
        }
        this.basics.getLogger().history.log(-2137614336, "[HistoryTuner.updatePSFreeze] (un)freeze station %1", (Object)aMFMStation);
        this.historyList.updatePSFreeze(aMFMStation);
        if (this.lastStation.getType() == 3 && RadioComparators.equals(aMFMStation, this.lastStation.getAMFMService())) {
            this.lastStation.getAMFMService().freezePs(aMFMStation.name);
        } else if (this.lastStation.getType() == 7 && RadioComparators.equals(aMFMStation, this.lastStation.getUniStation().getFmStation())) {
            this.lastStation.getUniStation().freezePs(aMFMStation.name);
        }
    }

    private void processAdd() {
        boolean bl = false;
        boolean bl2 = Utilities.checkIfAtLeastOneBooleanIsTrue(this.addOperationVetos);
        if (bl2) {
            this.basics.getLogger().history.log(-2137614336, "[HistoryTuner.processAdd] veto for station: %1", (Object)this.lastStation);
        } else {
            this.basics.getLogger().history.log(-2137614336, "[HistoryTuner.processAdd] add station: %1", (Object)this.lastStation);
            this.historyList.add(this.lastStation);
            bl = true;
        }
        if (bl) {
            this.propagateUpdatedStationList(13);
        }
    }

    public TunerObjectContainer[] getList() {
        return this.historyList.getList();
    }

    public IPrevNext getPrevNextHandler() {
        return this.historyList.prevNextHandler;
    }

    public void setPreferredImgType(int n) {
        if (!this.basics.tunerJobQueue.isJobQueueDispatchThread()) {
            this.basics.tunerJobQueue.enqueue(new HistoryTuner$2(this, "HistroyTuner.setPreferredImgType", n));
            return;
        }
        this.historyList.setPreferredImgType(n);
    }

    void fireTimerImmediately() {
        if (this.addTimer.cancel()) {
            this.processAdd();
        }
    }

    public TunerObjectContainer[] startScan() {
        TunerObjectContainer[] tunerObjectContainerArray = this.historyList.getList();
        int n = this.historyList.getIndex();
        if (n == -1 || n == tunerObjectContainerArray.length - 1) {
            return tunerObjectContainerArray;
        }
        TunerObjectContainer[] tunerObjectContainerArray2 = new TunerObjectContainer[tunerObjectContainerArray.length];
        int n2 = tunerObjectContainerArray.length - (n + 1);
        System.arraycopy((Object)tunerObjectContainerArray, n + 1, (Object)tunerObjectContainerArray2, 0, n2);
        System.arraycopy((Object)tunerObjectContainerArray, 0, (Object)tunerObjectContainerArray2, n2, tunerObjectContainerArray.length - n2);
        return tunerObjectContainerArray2;
    }

    public void setNamesOnOff(boolean bl) {
        if (!this.basics.tunerJobQueue.isJobQueueDispatchThread()) {
            this.basics.tunerJobQueue.enqueue(new HistoryTuner$3(this, "HistroyTuner.setNamesOnOff", bl));
            return;
        }
        this.historyList.setNamesOnOff(bl);
    }

    static /* synthetic */ TunerBasics access$1400(HistoryTuner historyTuner) {
        return historyTuner.basics;
    }

    static /* synthetic */ TunerObjectContainer access$1502(HistoryTuner historyTuner, TunerObjectContainer tunerObjectContainer) {
        historyTuner.amFmSelStation = tunerObjectContainer;
        return historyTuner.amFmSelStation;
    }

    static /* synthetic */ boolean access$1600(HistoryTuner historyTuner) {
        return historyTuner.radioHasAudioFocus;
    }

    static /* synthetic */ void access$1700(HistoryTuner historyTuner) {
        historyTuner.update();
    }

    static /* synthetic */ TunerObjectContainer access$1500(HistoryTuner historyTuner) {
        return historyTuner.amFmSelStation;
    }

    static /* synthetic */ HistoryStationList access$1800(HistoryTuner historyTuner) {
        return historyTuner.historyList;
    }

    static /* synthetic */ Timer access$1900(HistoryTuner historyTuner) {
        return historyTuner.addTimer;
    }

    static /* synthetic */ TunerObjectContainer access$2002(HistoryTuner historyTuner, TunerObjectContainer tunerObjectContainer) {
        historyTuner.dabStation = tunerObjectContainer;
        return historyTuner.dabStation;
    }

    static /* synthetic */ TunerObjectContainer access$2000(HistoryTuner historyTuner) {
        return historyTuner.dabStation;
    }

    static /* synthetic */ TunerObjectContainer access$2102(HistoryTuner historyTuner, TunerObjectContainer tunerObjectContainer) {
        historyTuner.uniStation = tunerObjectContainer;
        return historyTuner.uniStation;
    }

    static /* synthetic */ TunerObjectContainer access$2100(HistoryTuner historyTuner) {
        return historyTuner.uniStation;
    }

    static /* synthetic */ TunerObjectContainer access$2202(HistoryTuner historyTuner, TunerObjectContainer tunerObjectContainer) {
        historyTuner.sdarsStation = tunerObjectContainer;
        return historyTuner.sdarsStation;
    }

    static /* synthetic */ TunerObjectContainer access$2200(HistoryTuner historyTuner) {
        return historyTuner.sdarsStation;
    }

    static /* synthetic */ boolean access$1602(HistoryTuner historyTuner, boolean bl) {
        historyTuner.radioHasAudioFocus = bl;
        return historyTuner.radioHasAudioFocus;
    }

    static /* synthetic */ void access$2400(HistoryTuner historyTuner) {
        historyTuner.processAdd();
    }

    static /* synthetic */ TunerObjectContainer access$2602(HistoryTuner historyTuner, TunerObjectContainer tunerObjectContainer) {
        historyTuner.tvStation = tunerObjectContainer;
        return historyTuner.tvStation;
    }

    static /* synthetic */ boolean access$2702(HistoryTuner historyTuner, boolean bl) {
        historyTuner.tvHasAudioFocus = bl;
        return historyTuner.tvHasAudioFocus;
    }

    static /* synthetic */ TunerObjectContainer access$2600(HistoryTuner historyTuner) {
        return historyTuner.tvStation;
    }

    static /* synthetic */ boolean[] access$2800(HistoryTuner historyTuner) {
        return historyTuner.addOperationVetos;
    }
}

