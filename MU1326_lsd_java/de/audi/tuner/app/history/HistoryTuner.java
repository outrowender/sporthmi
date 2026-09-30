/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.atip.interapp.radio.IHistoryListService;
import de.audi.atip.interapp.radio.IHistoryVetoService;
import de.audi.atip.interapp.tv.TVStation;
import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.AudioFocusInfo;
import de.audi.tuner.app.AudioInfo;
import de.audi.tuner.app.IDrawerFocusManager;
import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.RadioComparators;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.dsi.AMFMDsiDownInfo;
import de.audi.tuner.app.amfm.dsi.AMFMDsiUpInfo;
import de.audi.tuner.app.dab.DABDsiDownInfo;
import de.audi.tuner.app.dab.DABDsiUpInfo;
import de.audi.tuner.app.dab.DabReceptionStatus;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.history.HistoryStationList;
import de.audi.tuner.app.history.IHistoryTuneListener;
import de.audi.tuner.app.history.ITunePlugin;
import de.audi.tuner.app.misc.IOptionsListener;
import de.audi.tuner.app.rsdb.IRSDBResult;
import de.audi.tuner.app.rsdb.IRadioDatabaseListener;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.dsi.SDARSDsiDownInfo;
import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;
import de.audi.tuner.app.storage.TunerStorage;
import de.audi.tuner.app.uni.UniDsiDownInfo;
import de.audi.tuner.app.uni.UniDsiUpInfo;
import de.audi.tuner.app.uni.UnifiedStationExt;
import de.audi.tuner.ifc.AbstractListRowFactory;
import de.audi.tuner.ifc.ILogoDatabase;
import de.audi.tuner.ifc.IMemoryList;
import de.audi.tuner.ifc.IPowerEvent;
import de.audi.tuner.ifc.IPrevNext;
import de.audi.tuner.ifc.IScanHandler;
import de.audi.tuner.ifc.listener.IUpdateListener;
import de.audi.tuner.ifc.listener.MessageListener;
import de.audi.tuner.sds.UpdateListenerHandler;
import de.audi.tuner.util.jobqueue.AbstractNamedRunnable;
import org.dsi.ifc.sdars.ServiceStatus3;

public class HistoryTuner
extends UpdateListenerHandler {
    private final Timer addTimer = new Timer("history", 10000L, true, new TimerListener());
    public final IHistoryListService historyListService = new HistoryListService();
    public final IHistoryVetoService historyVetoService = new HistoryVetoService();
    public ILogoDatabase logoDb = null;
    public final AMFMDsiUpInfo amfmDsiUpListener = new AMFMDsiUpListener();
    public final DABDsiUpInfo dabDsiUpListener = new DABDsiUpListener();
    public final SDARSDsiUpInfo sdarsDsiUpListener = new SDARSDsiUpListener();
    public final UniDsiUpInfo uniDsiUpListener = new UniDsiUpListener();
    public final AMFMDsiDownInfo amfmDsiDownListener = new AMFMDsiDownListener();
    public final UniDsiDownInfo uniDsiDownListener = new UniDsiDownListener();
    public final SDARSDsiDownInfo sdarsDsiDownListener = new SDARSDsiDownListener();
    public final DABDsiDownInfo dabDsiDownListener = new DABDsiDownListener();
    public final AudioInfoListener audioInfoListener = new AudioInfoListener();
    public final AudioFocusInfoListener audioFocusListener = new AudioFocusInfoListener();
    public final RsdbStatusListener rsdbStatusListener = new RsdbStatusListener();
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

    public LanguageManager.ILanguageChangeListener getLanguageChangeListener() {
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

    public void updatePSFreeze(final AMFMStation aMFMStation) {
        if (!this.basics.tunerJobQueue.isJobQueueDispatchThread()) {
            this.basics.tunerJobQueue.enqueue(new AbstractNamedRunnable("HistroyTuner.updatePSFreeze"){

                public void run() {
                    HistoryTuner.this.updatePSFreeze(aMFMStation);
                }
            });
            return;
        }
        this.basics.getLogger().history.log(10000000, "[HistoryTuner.updatePSFreeze] (un)freeze station %1", (Object)aMFMStation);
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
            this.basics.getLogger().history.log(10000000, "[HistoryTuner.processAdd] veto for station: %1", (Object)this.lastStation);
        } else {
            this.basics.getLogger().history.log(10000000, "[HistoryTuner.processAdd] add station: %1", (Object)this.lastStation);
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

    public void setPreferredImgType(final int n) {
        if (!this.basics.tunerJobQueue.isJobQueueDispatchThread()) {
            this.basics.tunerJobQueue.enqueue(new AbstractNamedRunnable("HistroyTuner.setPreferredImgType"){

                public void run() {
                    HistoryTuner.this.setPreferredImgType(n);
                }
            });
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

    public void setNamesOnOff(final boolean bl) {
        if (!this.basics.tunerJobQueue.isJobQueueDispatchThread()) {
            this.basics.tunerJobQueue.enqueue(new AbstractNamedRunnable("HistroyTuner.setNamesOnOff"){

                public void run() {
                    HistoryTuner.this.setNamesOnOff(bl);
                }
            });
            return;
        }
        this.historyList.setNamesOnOff(bl);
    }

    private class TimerListener
    extends DefaultTimerListener {
        private TimerListener() {
        }

        public void fireTimer(Timer timer) {
            ((HistoryTuner)HistoryTuner.this).basics.tunerJobQueue.enqueue(new AbstractNamedRunnable("HistroyTuner.TimerListener.fireTimer"){

                public void run() {
                    HistoryTuner.this.processAdd();
                }
            });
        }
    }

    private class DABDsiUpListener
    extends DABDsiUpInfo {
        private DABDsiUpListener() {
        }

        public void updateCurrentStation(final DabStation dabStation, final DabReceptionStatus dabReceptionStatus) {
            if (!((HistoryTuner)HistoryTuner.this).basics.tunerJobQueue.isJobQueueDispatchThread()) {
                ((HistoryTuner)HistoryTuner.this).basics.tunerJobQueue.enqueue(new AbstractNamedRunnable("HistroyTuner.DABDsiUpListener.updateCurrentStation"){

                    public void run() {
                        DABDsiUpListener.this.updateCurrentStation(dabStation, dabReceptionStatus);
                    }
                });
                return;
            }
            ((HistoryTuner)HistoryTuner.this).basics.getLogger().history.log(10000000, "[HistoryTuner.updateCurrentStation] DAB station: %1", (Object)dabStation);
            HistoryTuner.this.dabStation = new TunerObjectContainer(dabStation);
            HistoryTuner.this.dabStation.setReceptionStatus(dabReceptionStatus.getReception());
            int n = HistoryTuner.this.basics.getModels().getActiveTuner();
            if (HistoryTuner.this.radioHasAudioFocus && n == 5) {
                HistoryTuner.this.update();
                if (HistoryTuner.this.historyList.highlight(HistoryTuner.this.dabStation) == 0) {
                    HistoryTuner.this.addTimer.cancel();
                }
            }
        }
    }

    private class UniDsiUpListener
    extends UniDsiUpInfo {
        private UniDsiUpListener() {
        }

        public void updateSelectedStation(final UnifiedStationExt unifiedStationExt) {
            if (!((HistoryTuner)HistoryTuner.this).basics.tunerJobQueue.isJobQueueDispatchThread()) {
                ((HistoryTuner)HistoryTuner.this).basics.tunerJobQueue.enqueue(new AbstractNamedRunnable("HistroyTuner.UniDsiUpListener.updateSelectedStation"){

                    public void run() {
                        UniDsiUpListener.this.updateSelectedStation(unifiedStationExt);
                    }
                });
                return;
            }
            ((HistoryTuner)HistoryTuner.this).basics.getLogger().history.log(10000000, "[HistoryTuner.updateSelectedStation] Unified station: %1", (Object)unifiedStationExt);
            HistoryTuner.this.uniStation = new TunerObjectContainer(unifiedStationExt);
            int n = HistoryTuner.this.basics.getModels().getActiveTuner();
            if (HistoryTuner.this.radioHasAudioFocus && n == 11) {
                HistoryTuner.this.update();
                if (HistoryTuner.this.historyList.highlight(HistoryTuner.this.uniStation) == 0) {
                    HistoryTuner.this.addTimer.cancel();
                }
            }
        }
    }

    private class AMFMDsiUpListener
    extends AMFMDsiUpInfo {
        private AMFMDsiUpListener() {
        }

        public void updateSelectedStation(final AMFMStation aMFMStation) {
            if (!((HistoryTuner)HistoryTuner.this).basics.tunerJobQueue.isJobQueueDispatchThread()) {
                ((HistoryTuner)HistoryTuner.this).basics.tunerJobQueue.enqueue(new AbstractNamedRunnable("HistroyTuner.AMFMDsiUpListener.updateSelectedStation"){

                    public void run() {
                        AMFMDsiUpListener.this.updateSelectedStation(aMFMStation);
                    }
                });
                return;
            }
            ((HistoryTuner)HistoryTuner.this).basics.getLogger().history.log(10000000, "[HistoryTuner.updateSelectedStation] AM/FM station: %1", (Object)aMFMStation);
            HistoryTuner.this.amFmSelStation = new TunerObjectContainer(aMFMStation);
            int n = HistoryTuner.this.basics.getModels().getActiveTuner();
            if (HistoryTuner.this.radioHasAudioFocus && (n == 1 || n == 4 || n == 10)) {
                HistoryTuner.this.update();
                if (HistoryTuner.this.historyList.highlight(HistoryTuner.this.amFmSelStation) == 0) {
                    HistoryTuner.this.addTimer.cancel();
                }
            }
        }
    }

    private class AudioInfoListener
    extends AudioInfo {
        private AudioInfoListener() {
        }

        public void fadedInConnForBand(final int n) {
            if (!((HistoryTuner)HistoryTuner.this).basics.tunerJobQueue.isJobQueueDispatchThread()) {
                ((HistoryTuner)HistoryTuner.this).basics.tunerJobQueue.enqueue(new AbstractNamedRunnable("HistroyTuner.AudioInfoListener.fadedInConnForBand"){

                    public void run() {
                        AudioInfoListener.this.fadedInConnForBand(n);
                    }
                });
                return;
            }
            ((HistoryTuner)HistoryTuner.this).basics.getLogger().history.log(10000000, "[HistoryTuner.fadedInConnForBand] %1", (long)n);
            HistoryTuner.this.update();
        }
    }

    private class DABDsiDownListener
    extends DABDsiDownInfo {
        private DABDsiDownListener() {
        }

        public void preTuneAction(final DabStation dabStation, final DabReceptionStatus dabReceptionStatus, final int n) {
            if (!((HistoryTuner)HistoryTuner.this).basics.tunerJobQueue.isJobQueueDispatchThread()) {
                ((HistoryTuner)HistoryTuner.this).basics.tunerJobQueue.enqueue(new AbstractNamedRunnable("HistroyTuner.DABDsiDownListener.preTuneAction"){

                    public void run() {
                        DABDsiDownListener.this.preTuneAction(dabStation, dabReceptionStatus, n);
                    }
                });
                return;
            }
            ((HistoryTuner)HistoryTuner.this).basics.getLogger().history.log(10000000, "[HistoryTuner.preTuneAction] DAB station: %1", (Object)dabStation);
            HistoryTuner.this.dabStation = new TunerObjectContainer(dabStation);
            HistoryTuner.this.dabStation.setReceptionStatus(dabReceptionStatus.getReception());
            int n2 = HistoryTuner.this.basics.getModels().getActiveTuner();
            if (HistoryTuner.this.radioHasAudioFocus && n2 == 5) {
                HistoryTuner.this.update();
                if (HistoryTuner.this.historyList.highlight(HistoryTuner.this.dabStation) == 0) {
                    HistoryTuner.this.addTimer.cancel();
                }
            }
        }
    }

    private class HistoryListService
    implements IHistoryListService {
        private HistoryListService() {
        }

        public void updateAudibleTVStation(final TVStation tVStation) {
            if (!((HistoryTuner)HistoryTuner.this).basics.tunerJobQueue.isJobQueueDispatchThread()) {
                ((HistoryTuner)HistoryTuner.this).basics.tunerJobQueue.enqueue(new AbstractNamedRunnable("HistroyTuner.HistoryListService.updateAudibleTVStation"){

                    public void run() {
                        HistoryListService.this.updateAudibleTVStation(tVStation);
                    }
                });
                return;
            }
            ((HistoryTuner)HistoryTuner.this).basics.getLogger().history.log(10000000, "[HistoryListService.updateAudibleTVStation] %1", (Object)tVStation);
            if (tVStation == null) {
                HistoryTuner.this.tvStation = TunerObjectContainer.EMPTY_CONTAINER;
                HistoryTuner.this.tvHasAudioFocus = false;
            } else {
                HistoryTuner.this.tvStation = new TunerObjectContainer(tVStation);
                HistoryTuner.this.tvHasAudioFocus = true;
                HistoryTuner.this.update();
                if (HistoryTuner.this.historyList.highlight(HistoryTuner.this.tvStation) == 0) {
                    HistoryTuner.this.addTimer.cancel();
                }
            }
        }
    }

    private class HistoryVetoService
    implements IHistoryVetoService {
        private HistoryVetoService() {
        }

        public void updateVeto(final int n, final boolean bl) {
            if (!((HistoryTuner)HistoryTuner.this).basics.tunerJobQueue.isJobQueueDispatchThread()) {
                ((HistoryTuner)HistoryTuner.this).basics.tunerJobQueue.enqueue(new AbstractNamedRunnable("HistroyTuner.HistoryVetoService.updateVeto"){

                    public void run() {
                        HistoryVetoService.this.updateVeto(n, bl);
                    }
                });
                return;
            }
            ((HistoryTuner)HistoryTuner.this).basics.getLogger().history.log(10000000, "[HistoryVetoService.updateVeto] app %2, veto %1", bl, (long)n);
            if (n < 0 || n >= 2) {
                ((HistoryTuner)HistoryTuner.this).basics.getLogger().history.log(10000, "[HistoryVetoService.updateVeto] veto ignored! %1 is a illegal app identifier", (long)n);
            } else {
                boolean bl2 = Utilities.checkIfAtLeastOneBooleanIsTrue(HistoryTuner.this.addOperationVetos);
                ((HistoryTuner)HistoryTuner.this).addOperationVetos[n] = bl;
                if (!HistoryTuner.this.addTimer.isRunning()) {
                    boolean bl3 = Utilities.checkIfAtLeastOneBooleanIsTrue(HistoryTuner.this.addOperationVetos);
                    if (bl2 && !bl3) {
                        HistoryTuner.this.addTimer.restart();
                    }
                }
            }
        }
    }

    private class RsdbResultListener
    implements IRSDBResult {
        private RsdbResultListener() {
        }

        public void resultAvailable() {
            if (!((HistoryTuner)HistoryTuner.this).basics.tunerJobQueue.isJobQueueDispatchThread()) {
                ((HistoryTuner)HistoryTuner.this).basics.tunerJobQueue.enqueue(new AbstractNamedRunnable("HistroyTuner.RsdbResultListener.resultAvailable"){

                    public void run() {
                        RsdbResultListener.this.resultAvailable();
                    }
                });
                return;
            }
            HistoryTuner.this.historyList.init(HistoryTuner.this.logoDb);
        }
    }

    private class RsdbStatusListener
    implements IRadioDatabaseListener {
        private RsdbStatusListener() {
        }

        public void databaseReady(final ILogoDatabase iLogoDatabase) {
            if (!((HistoryTuner)HistoryTuner.this).basics.tunerJobQueue.isJobQueueDispatchThread()) {
                ((HistoryTuner)HistoryTuner.this).basics.tunerJobQueue.enqueue(new AbstractNamedRunnable("HistroyTuner.RsdbStatusListener.databaseReady"){

                    public void run() {
                        RsdbStatusListener.this.databaseReady(iLogoDatabase);
                    }
                });
                return;
            }
            HistoryTuner.this.historyList.persist();
            if (iLogoDatabase.isRealDatabase()) {
                HistoryTuner.this.logoDb = iLogoDatabase;
                TunerObjectContainer[] tunerObjectContainerArray = HistoryTuner.this.getList();
                iLogoDatabase.requestDataById(tunerObjectContainerArray, new RsdbResultListener());
            } else {
                HistoryTuner.this.logoDb = null;
                HistoryTuner.this.historyList.init(null);
            }
        }
    }

    private class SDARSDsiUpListener
    extends SDARSDsiUpInfo {
        private ServiceStatus3 serviceStatus = new ServiceStatus3();

        private SDARSDsiUpListener() {
        }

        public void updateSelectedStation(final StationInfoExt stationInfoExt) {
            if (!((HistoryTuner)HistoryTuner.this).basics.tunerJobQueue.isJobQueueDispatchThread()) {
                ((HistoryTuner)HistoryTuner.this).basics.tunerJobQueue.enqueue(new AbstractNamedRunnable("HistroyTuner.SDARSDsiUpListener.updateSelectedStation"){

                    public void run() {
                        SDARSDsiUpListener.this.updateSelectedStation(stationInfoExt);
                    }
                });
                return;
            }
            ((HistoryTuner)HistoryTuner.this).basics.getLogger().history.log(10000000, "[HistoryTuner.updateSelectedStation] SDARS station: %1", (Object)stationInfoExt);
            HistoryTuner.this.sdarsStation = new TunerObjectContainer(stationInfoExt);
            int n = HistoryTuner.this.basics.getModels().getActiveTuner();
            if (HistoryTuner.this.radioHasAudioFocus && n == 7) {
                HistoryTuner.this.update();
                if (HistoryTuner.this.historyList.highlight(HistoryTuner.this.sdarsStation) == 0) {
                    HistoryTuner.this.addTimer.cancel();
                }
            }
        }

        public void updateStationList(final StationInfoExt[] stationInfoExtArray) {
            if (!((HistoryTuner)HistoryTuner.this).basics.tunerJobQueue.isJobQueueDispatchThread()) {
                ((HistoryTuner)HistoryTuner.this).basics.tunerJobQueue.enqueue(new AbstractNamedRunnable("HistroyTuner.SDARSDsiUpListener.updateStationList"){

                    public void run() {
                        SDARSDsiUpListener.this.updateStationList(stationInfoExtArray);
                    }
                });
                return;
            }
            HistoryTuner.this.historyList.updateSdarsList(stationInfoExtArray);
        }

        public void updateServiceStatus3(final ServiceStatus3 serviceStatus3) {
            if (!((HistoryTuner)HistoryTuner.this).basics.tunerJobQueue.isJobQueueDispatchThread()) {
                ((HistoryTuner)HistoryTuner.this).basics.tunerJobQueue.enqueue(new AbstractNamedRunnable("HistroyTuner.SDARSDsiUpListener.updateServiceStatus3"){

                    public void run() {
                        SDARSDsiUpListener.this.updateServiceStatus3(serviceStatus3);
                    }
                });
                return;
            }
            if (this.serviceStatus.antennaStatus != serviceStatus3.antennaStatus) {
                this.serviceStatus = serviceStatus3;
                if (this.serviceStatus.antennaStatus == 1) {
                    HistoryTuner.this.historyList.setSDARSState(6);
                } else {
                    HistoryTuner.this.historyList.setSDARSState(0);
                }
            }
        }
    }

    private class UniDsiDownListener
    extends UniDsiDownInfo {
        private UniDsiDownListener() {
        }

        public void preTuneCommand(final UnifiedStationExt unifiedStationExt) {
            if (!((HistoryTuner)HistoryTuner.this).basics.tunerJobQueue.isJobQueueDispatchThread()) {
                ((HistoryTuner)HistoryTuner.this).basics.tunerJobQueue.enqueue(new AbstractNamedRunnable("HistroyTuner.UniDsiDownListener.preTuneCommand"){

                    public void run() {
                        UniDsiDownListener.this.preTuneCommand(unifiedStationExt);
                    }
                });
                return;
            }
            ((HistoryTuner)HistoryTuner.this).basics.getLogger().history.log(10000000, "[HistoryTuner.preTuneCommand] Unified station: %1", (Object)unifiedStationExt);
            HistoryTuner.this.uniStation = new TunerObjectContainer(unifiedStationExt);
            int n = HistoryTuner.this.basics.getModels().getActiveTuner();
            if (HistoryTuner.this.radioHasAudioFocus && n == 11) {
                HistoryTuner.this.historyList.highlight(HistoryTuner.this.uniStation);
            }
        }
    }

    private class AMFMDsiDownListener
    extends AMFMDsiDownInfo {
        private AMFMDsiDownListener() {
        }

        public void preTuneAction(final AMFMStation aMFMStation, final boolean bl) {
            if (!((HistoryTuner)HistoryTuner.this).basics.tunerJobQueue.isJobQueueDispatchThread()) {
                ((HistoryTuner)HistoryTuner.this).basics.tunerJobQueue.enqueue(new AbstractNamedRunnable("HistroyTuner.AMFMDsiDownListener.preTuneAction"){

                    public void run() {
                        AMFMDsiDownListener.this.preTuneAction(aMFMStation, bl);
                    }
                });
                return;
            }
            ((HistoryTuner)HistoryTuner.this).basics.getLogger().history.log(10000000, "[HistoryTuner.preTuneAction] AM/FM station: %1", (Object)aMFMStation);
            HistoryTuner.this.amFmSelStation = new TunerObjectContainer(aMFMStation);
            int n = HistoryTuner.this.basics.getModels().getActiveTuner();
            if (HistoryTuner.this.radioHasAudioFocus && (n == 1 || n == 4 || n == 10)) {
                HistoryTuner.this.update();
                HistoryTuner.this.historyList.highlight(HistoryTuner.this.amFmSelStation);
            }
        }
    }

    private class SDARSDsiDownListener
    extends SDARSDsiDownInfo {
        private SDARSDsiDownListener() {
        }

        public void preTuneAction(final StationInfoExt stationInfoExt) {
            if (!((HistoryTuner)HistoryTuner.this).basics.tunerJobQueue.isJobQueueDispatchThread()) {
                ((HistoryTuner)HistoryTuner.this).basics.tunerJobQueue.enqueue(new AbstractNamedRunnable("HistroyTuner.SDARSDsiDownListener.preTuneAction"){

                    public void run() {
                        SDARSDsiDownListener.this.preTuneAction(stationInfoExt);
                    }
                });
                return;
            }
            ((HistoryTuner)HistoryTuner.this).basics.getLogger().history.log(10000000, "[HistoryTuner.preTuneAction] SDARS station: %1", (Object)stationInfoExt);
            HistoryTuner.this.sdarsStation = new TunerObjectContainer(stationInfoExt);
            int n = HistoryTuner.this.basics.getModels().getActiveTuner();
            if (HistoryTuner.this.radioHasAudioFocus && n == 7) {
                HistoryTuner.this.update();
                if (HistoryTuner.this.historyList.highlight(HistoryTuner.this.sdarsStation) == 0) {
                    HistoryTuner.this.addTimer.cancel();
                }
            }
        }
    }

    private class AudioFocusInfoListener
    extends AudioFocusInfo {
        private AudioFocusInfoListener() {
        }

        public void audioFocusLost() {
            if (!((HistoryTuner)HistoryTuner.this).basics.tunerJobQueue.isJobQueueDispatchThread()) {
                ((HistoryTuner)HistoryTuner.this).basics.tunerJobQueue.enqueue(new AbstractNamedRunnable("HistroyTuner.AudioFocusInfoListener.audioFocusLost"){

                    public void run() {
                        AudioFocusInfoListener.this.audioFocusLost();
                    }
                });
                return;
            }
            HistoryTuner.this.radioHasAudioFocus = false;
            HistoryTuner.this.addTimer.cancel();
        }

        public void audioFocus(final int n, final int n2) {
            if (!((HistoryTuner)HistoryTuner.this).basics.tunerJobQueue.isJobQueueDispatchThread()) {
                ((HistoryTuner)HistoryTuner.this).basics.tunerJobQueue.enqueue(new AbstractNamedRunnable("HistroyTuner.AudioFocusInfoListener.audioFocus"){

                    public void run() {
                        AudioFocusInfoListener.this.audioFocus(n, n2);
                    }
                });
                return;
            }
            HistoryTuner.this.radioHasAudioFocus = true;
            HistoryTuner.this.update();
        }
    }
}

