/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.DrawerFocusManager;
import de.audi.tuner.app.HmiAppListener;
import de.audi.tuner.app.IDrawerFocusManager;
import de.audi.tuner.app.IStoreHandler;
import de.audi.tuner.app.LanguageManager$ILanguageChangeListener;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.MemoryListHandler$ActionProxy;
import de.audi.tuner.app.MemoryListHandler$ButtonListener;
import de.audi.tuner.app.MemoryListHandler$DABPresetNameUpdateTimer;
import de.audi.tuner.app.MemoryListHandler$HighlightListener;
import de.audi.tuner.app.MemoryListHandler$HmiAppListenerExt;
import de.audi.tuner.app.MemoryListHandler$LanguageChangeListener;
import de.audi.tuner.app.MemoryListHandler$ListListener;
import de.audi.tuner.app.MemoryListHandler$MenuModelListener;
import de.audi.tuner.app.MemoryListHandler$OptModelListener;
import de.audi.tuner.app.MemoryListHandler$PowerEventListener;
import de.audi.tuner.app.MemoryListHandler$PrevNextHandler;
import de.audi.tuner.app.MemoryListHandler$RsdbStatusListener;
import de.audi.tuner.app.MemoryListHandler$SdarsDsiUpListener;
import de.audi.tuner.app.MemoryListHandler$StoreHandler;
import de.audi.tuner.app.MemoryListHandler$TimerListener;
import de.audi.tuner.app.MemoryListHandler$UpdateListener;
import de.audi.tuner.app.NullAmFmDsiDownManager;
import de.audi.tuner.app.PresetIds;
import de.audi.tuner.app.RadioComparators;
import de.audi.tuner.app.RadioPresetHandler$INARMemoryListIndexChangeListener;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.TunerProxyManager;
import de.audi.tuner.app.TunerStatus;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.dsi.IAmFmDsiDownManager;
import de.audi.tuner.app.ap.TunerActionProxyListener;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.epg.sdars.ChoiceModifyingEPGAvailibilityCallback;
import de.audi.tuner.app.epg.sdars.IEPGAvailibiltyCallback;
import de.audi.tuner.app.memory.AbstractMemoryRow;
import de.audi.tuner.app.memory.AmFmMemoryRow;
import de.audi.tuner.app.memory.DABMemoryRow;
import de.audi.tuner.app.memory.EmptyMemoryRow;
import de.audi.tuner.app.memory.MemoryListHelper;
import de.audi.tuner.app.memory.SDARSMemoryRow;
import de.audi.tuner.app.memory.UniMemoryRow;
import de.audi.tuner.app.rsdb.IRadioDatabaseListener;
import de.audi.tuner.app.sdars.ISDARSRow;
import de.audi.tuner.app.sdars.PdtInfoHandler;
import de.audi.tuner.app.sdars.PdtListener;
import de.audi.tuner.app.sdars.SdarsRadioText;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;
import de.audi.tuner.app.sdars.seek.AddToSeeksPossibilityEnum;
import de.audi.tuner.app.storage.TunerStorage;
import de.audi.tuner.app.uni.UnifiedStationExt;
import de.audi.tuner.ifc.AbstractListRowFactory;
import de.audi.tuner.ifc.AbstractRadioListRow;
import de.audi.tuner.ifc.IListResourceProvider;
import de.audi.tuner.ifc.ILogoDatabase;
import de.audi.tuner.ifc.IMemoryList;
import de.audi.tuner.ifc.IPrevNext;
import de.audi.tuner.ifc.IScanHandler;
import de.audi.tuner.ifc.ITunerVariantExt;
import de.audi.tuner.ifc.NullNARMemoryListIndexChangeListener;
import de.audi.tuner.ifc.listener.IUpdateListener;
import de.audi.tuner.sds.UpdateListenerHandler;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.radio.ServiceInfo;
import org.dsi.ifc.radio.UnifiedStation;
import org.dsi.ifc.sdars.SeekPossibility;

public class MemoryListHandler
extends UpdateListenerHandler
implements IMemoryList,
IListResourceProvider {
    final MemoryListHandler$PowerEventListener powerEventListener = new MemoryListHandler$PowerEventListener(this, null);
    public final IStoreHandler storeHandler = new MemoryListHandler$StoreHandler(this, null);
    final TunerActionProxyListener actionProxyListener = new MemoryListHandler$ActionProxy(this, null);
    final LanguageManager$ILanguageChangeListener languageChangeListener = new MemoryListHandler$LanguageChangeListener(this, null);
    final IRadioDatabaseListener databaseListener = new MemoryListHandler$RsdbStatusListener(this, null);
    private static final int LOAD_MODE;
    private static final int MOVE_MODE;
    private static final int STORE_MODE;
    private volatile int storeIndex = -1;
    private volatile int userActionIndex = -1;
    private int operationMode = 0;
    private boolean sdarsNoSignal;
    public final SDARSDsiUpInfo sdarsDsiUpListener = new MemoryListHandler$SdarsDsiUpListener(this, null);
    public final MemoryListHandler$HighlightListener highlightListener = new MemoryListHandler$HighlightListener(this, null);
    final HmiAppListener hmiAppListener = new MemoryListHandler$HmiAppListenerExt(this, null);
    private final PdtListener pdtListener;
    final IPrevNext prevNextHandler = new MemoryListHandler$PrevNextHandler(this, null);
    private volatile int registeredSid = -1;
    private final Logger logger;
    private final TunerModels models;
    private final TunerStatus status;
    private final TunerStorage storage;
    private final IScanHandler scanHandler;
    private IAmFmDsiDownManager dsiAmFmTuner;
    private final Object mutex = new Object();
    private final MemoryListHelper listHelper;
    private final MemoryListHandler$DABPresetNameUpdateTimer dabPresetNameUpdateTimer = new MemoryListHandler$DABPresetNameUpdateTimer(this, 0);
    final IUpdateListener updateListener = new MemoryListHandler$UpdateListener(this, null);
    private final BaseListModelApp listModel;
    private final BaseListModelApp entDrawerListModel;
    private final MenuModelApp menuModel;
    private final AbstractListRowFactory rowFactory;
    private AMFMStation amFmCurStation = new AMFMStation();
    private DabStation dabCurStation = new DabStation();
    private StationInfoExt sdarsCurService = new StationInfoExt();
    private UnifiedStationExt uniCurStation = new UnifiedStationExt();
    private AbstractMemoryRow moveRow;
    private int moveIndex;
    private final ITunerVariantExt variantExt;
    private int imgType;
    private int dabReception = 0;
    private volatile boolean clearAllWaiting;
    private final Timer animationTimer;
    private final Object animationMutex = new Object();
    private boolean memoryListVisible;
    private volatile long focussedItemUniqueID = 0L;
    private RadioPresetHandler$INARMemoryListIndexChangeListener narMemoryListPresetIndexChangeListener;
    private final IEPGAvailibiltyCallback sdarsEpgAvailibilityCallback;
    private MemoryListHandler$ListListener listListener;
    private SeekPossibility lastReceivedSeekPossibility = new SeekPossibility(-1, -1, null, null);
    private IDrawerFocusManager drawerFocus = DrawerFocusManager.NULL_DRAWER_FOCUS_MANAGER;
    public boolean firstHighlightCall = true;
    public ILogoDatabase logoDb = null;

    MemoryListHandler(TunerBasics tunerBasics, ITunerVariantExt iTunerVariantExt, TunerStorage tunerStorage, IScanHandler iScanHandler) {
        this.logger = tunerBasics.getLogger();
        this.status = tunerBasics.getStatus();
        this.models = tunerBasics.getModels();
        this.rowFactory = iTunerVariantExt.getListRowFactory();
        this.variantExt = iTunerVariantExt;
        this.storage = tunerStorage;
        this.scanHandler = iScanHandler;
        this.narMemoryListPresetIndexChangeListener = new NullNARMemoryListIndexChangeListener(this.logger.main);
        this.sdarsEpgAvailibilityCallback = ChoiceModifyingEPGAvailibilityCallback.forSdarsFocussedChannelEPGAvailibilityChoice(this.models);
        this.dsiAmFmTuner = new NullAmFmDsiDownManager(this.logger.amfmDSI);
        this.listHelper = new MemoryListHelper(this.models.getBaseListModel(1938292992), this.logger.dd, this.rowFactory.getNumOfCols(12));
        this.listModel = this.models.getBaseListModel(1938292992);
        this.menuModel = this.models.getMenuModel(-1299709696);
        this.entDrawerListModel = this.models.getBaseListModel(-1970732800);
        this.animationTimer = new Timer("animationTimer", 0, true, new MemoryListHandler$TimerListener(this, null));
        this.imgType = tunerStorage.loadPreferredImageType();
        this.pdtListener = new PdtListener(this, this.listModel, this.mutex, this.imgType);
        this.models.getChoiceModel(1636303104).setValue(1);
        MemoryListHandler$ButtonListener memoryListHandler$ButtonListener = new MemoryListHandler$ButtonListener(this, null);
        this.models.getButtonModel(-343473920).setButtonListener(memoryListHandler$ButtonListener);
        this.models.getButtonModel(159973632).setButtonListener(memoryListHandler$ButtonListener);
        this.listListener = new MemoryListHandler$ListListener(this, this.models, -1299709696);
        this.listModel.setListener(this.listListener);
        this.entDrawerListModel.setListener(this.listListener);
        this.menuModel.setListener(new MemoryListHandler$MenuModelListener(this, null));
        MemoryListHandler$OptModelListener memoryListHandler$OptModelListener = new MemoryListHandler$OptModelListener(this, null);
        this.models.getOptionModel(-1400438528).setListener(memoryListHandler$OptModelListener, 1753743616);
        this.models.getOptionModel(-1400438528).setListener(memoryListHandler$OptModelListener, 1770520832);
        this.models.getOptionModel(-1400438528).setListener(memoryListHandler$OptModelListener, 1820852480);
        this.models.getOptionModel(-1400438528).setListener(memoryListHandler$OptModelListener, 0x11880100);
        this.models.getOptionModel(-1400438528).setListener(memoryListHandler$OptModelListener, -1954021120);
        this.models.getOptionModel(-1400438528).setListener(memoryListHandler$OptModelListener, 2005401856);
        this.models.getOptionModel(-1400438528).setListener(memoryListHandler$OptModelListener, 747176192);
        this.models.getOptionModel(-1400438528).setListener(memoryListHandler$OptModelListener, 1921515776);
        this.models.getOptionModel(-1400438528).setListener(memoryListHandler$OptModelListener, -813235968);
        this.models.getOptionModel(1988624640).setListener(memoryListHandler$OptModelListener, 1938292992);
        this.models.getOptionModel(-1282932480).setListener(memoryListHandler$OptModelListener, 1938292992);
    }

    public void setDeviceServiceAMFM(IAmFmDsiDownManager iAmFmDsiDownManager) {
        this.dsiAmFmTuner = iAmFmDsiDownManager;
    }

    public void setNARMemoryListPresetIndexChangeListener(RadioPresetHandler$INARMemoryListIndexChangeListener radioPresetHandler$INARMemoryListIndexChangeListener) {
        if (radioPresetHandler$INARMemoryListIndexChangeListener == null) {
            radioPresetHandler$INARMemoryListIndexChangeListener = new NullNARMemoryListIndexChangeListener(this.logger.main);
        }
        this.narMemoryListPresetIndexChangeListener = radioPresetHandler$INARMemoryListIndexChangeListener;
    }

    public void register(IDrawerFocusManager iDrawerFocusManager) {
        this.drawerFocus = iDrawerFocusManager;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setNamesOnOff(boolean bl) {
        if (Utilities.isJapan()) {
            Object object = this.mutex;
            synchronized (object) {
                MemoryListHandler.adjustRowLayoutsIfNecessary(this.listModel, this.models.getChoiceModel(1636368640), bl, this.storage.getAmfmView());
            }
        }
    }

    public static void adjustRowLayoutsIfNecessary(BaseListModelApp baseListModelApp, ChoiceModelApp choiceModelApp, boolean bl, int n) {
        boolean bl2 = choiceModelApp.getValue() == 1;
        for (int i2 = 0; i2 < baseListModelApp.getLength(); ++i2) {
            AbstractMemoryRow abstractMemoryRow = (AbstractMemoryRow)baseListModelApp.getRow(i2);
            boolean bl3 = abstractMemoryRow.adjustLayoutIfNecessary(bl, bl2, n);
            if (!bl3) continue;
            baseListModelApp.setRow(i2, abstractMemoryRow);
        }
    }

    void clearMemoryList() {
        if (!Utilities.isPGen1OrBentley()) {
            this.setSelection(-1);
            if (Utilities.isNARBuild()) {
                for (int i2 = 0; i2 < this.listModel.getLength(); ++i2) {
                    this.listModel.setRow(i2, this.rowFactory.getEmptyFavRow(i2));
                    this.narMemoryListPresetIndexChangeListener.memoryListPresetIndexChanged(i2, null);
                }
            } else {
                this.listModel.removeAll();
            }
            this.postChangeMemlist();
        }
    }

    void clearMemoryListForHardKeys() {
        if (Utilities.isNARBuild() && !Utilities.isPGen1OrBentley()) {
            this.setSelection(-1);
            int n = Math.min(8, this.listModel.getLength());
            for (int i2 = 0; i2 < n; ++i2) {
                this.listModel.setRow(i2, this.rowFactory.getEmptyFavRow(i2));
                this.narMemoryListPresetIndexChangeListener.memoryListPresetIndexChanged(i2, null);
            }
            this.postChangeMemlist();
        }
    }

    private void clearMemoryListAndSwitchToActiveTuner() {
        int n = this.models.getActiveTuner();
        this.models.getChoiceModel(-595132160).setValue(n);
        this.clearAllWaiting = true;
        this.storage.storeLastMode(n, n);
        this.propagateUpdatedActiveList(n);
    }

    private boolean isStoreNotAllowed(TunerObjectContainer tunerObjectContainer) {
        int n = 0;
        long l = 0L;
        ServiceInfo serviceInfo = tunerObjectContainer.getDABStation().service;
        n = serviceInfo.getEnsID();
        l = serviceInfo.getSID();
        if (n == 0 && l == 0L) {
            this.logger.dabDSI.log(-2137614336, "[MLH.storeNotAllowed] %1", (Object)tunerObjectContainer);
            return true;
        }
        return false;
    }

    private void informTunerStore(int n, TunerObjectContainer tunerObjectContainer) {
        AMFMStation aMFMStation = tunerObjectContainer.getAMFMService();
        if (aMFMStation.isRds()) {
            this.logger.amfmDSI.log(1078071040, "DSIAMFMTuner.isOnPreset( f=%1, pi=%2, pos=%3 )", (long)((int)aMFMStation.getFrequency()), (long)aMFMStation.getPi(), (long)n);
            this.dsiAmFmTuner.isOnPreset((int)aMFMStation.getFrequency(), aMFMStation.getPi(), n, aMFMStation.getShortNameHD());
        }
    }

    private int getIndexOfDABService(long l, int n, int n2) {
        Object object;
        EvoListRow evoListRow;
        if (n2 != -1 && (evoListRow = this.listModel.getRow(n2)) instanceof DABMemoryRow && (object = ((DABMemoryRow)evoListRow).getService()) != null && l == ((ServiceInfo)object).sID && n == ((ServiceInfo)object).ensID) {
            return n2;
        }
        for (int i2 = 0; i2 < this.listModel.getLength(); ++i2) {
            ServiceInfo serviceInfo;
            object = this.listModel.getRow(i2);
            if (!(object instanceof DABMemoryRow) || (serviceInfo = ((DABMemoryRow)object).getService()) == null || l != serviceInfo.sID || n != serviceInfo.ensID) continue;
            return i2;
        }
        return -1;
    }

    private int getIndexOfUniStation(UnifiedStationExt unifiedStationExt, int n) {
        Object object;
        EvoListRow evoListRow;
        if (n != -1 && (evoListRow = this.listModel.getRow(n)) instanceof UniMemoryRow && RadioComparators.equals(unifiedStationExt, (UnifiedStation)(object = ((UniMemoryRow)evoListRow).getStation()))) {
            return n;
        }
        for (int i2 = 0; i2 < this.listModel.getLength(); ++i2) {
            UnifiedStationExt unifiedStationExt2;
            object = this.listModel.getRow(i2);
            if (!(object instanceof UniMemoryRow) || !RadioComparators.equals(unifiedStationExt, unifiedStationExt2 = ((UniMemoryRow)object).getStation())) continue;
            return i2;
        }
        return -1;
    }

    private int getIndexOfSDARSstation(StationInfoExt stationInfoExt, int n) {
        Object object;
        EvoListRow evoListRow;
        if (this.scanHandler.isScanActive() && stationInfoExt.getPresetPos() != 0 && (evoListRow = this.listModel.getRow(stationInfoExt.getPresetPos() - 1)) instanceof ISDARSRow && ((ISDARSRow)((Object)evoListRow)).getStation().getSID() == stationInfoExt.sID) {
            return stationInfoExt.getPresetPos() - 1;
        }
        if (n != -1 && (evoListRow = this.listModel.getRow(n)) instanceof ISDARSRow && (object = ((ISDARSRow)((Object)evoListRow)).getStation()) != null && ((StationInfoExt)object).sID == stationInfoExt.sID) {
            return n;
        }
        for (int i2 = 0; i2 < this.listModel.getLength(); ++i2) {
            object = this.listModel.getRow(i2);
            if (!(object instanceof ISDARSRow) || ((ISDARSRow)object).getStation().getSID() != stationInfoExt.sID) continue;
            return i2;
        }
        return -1;
    }

    public void setPreferredImgType(int n) {
        this.pdtListener.setPrefImgType(n);
        this.imgType = n;
    }

    public static void setSdarsListState(int n, BaseListModelApp baseListModelApp) {
        int n2 = 0;
        switch (n) {
            case 6: {
                n2 = 2;
                break;
            }
        }
        BaseListModelApp baseListModelApp2 = baseListModelApp.getCopy();
        int n3 = baseListModelApp2.getLength();
        boolean bl = false;
        for (int i2 = 0; i2 < n3; ++i2) {
            AbstractMemoryRow abstractMemoryRow = (AbstractMemoryRow)baseListModelApp2.getRow(i2);
            if (abstractMemoryRow.getBand() != 7) continue;
            abstractMemoryRow.setBandStatus(n2);
            baseListModelApp2.setRow(i2, abstractMemoryRow);
            bl = true;
        }
        if (bl) {
            baseListModelApp.update(baseListModelApp2);
        }
    }

    @Override
    public boolean tuneByCombiID(int n, int n2) {
        int n3 = n - 1;
        AbstractMemoryRow abstractMemoryRow = (AbstractMemoryRow)this.listModel.getRow(n3);
        if (abstractMemoryRow != null) {
            this.tuneFromMemoryList(abstractMemoryRow, n3, n2);
            return true;
        }
        return false;
    }

    private void tuneFromMemoryList(AbstractMemoryRow abstractMemoryRow, int n, int n2) {
        DabStation dabStation;
        DabStation dabStation2;
        this.logger.main.log(-2137614336, "[MLH.tuneFromMemoryList] row: %1", (Object)abstractMemoryRow);
        TunerProxyManager.getInstance().stopActiveActions();
        TunerObjectContainer tunerObjectContainer = abstractMemoryRow.getTOContainer();
        if (abstractMemoryRow instanceof DABMemoryRow && RadioComparators.equals(dabStation2 = tunerObjectContainer.getDABStation(), dabStation = TunerProxyManager.getInstance().getDABTuner().getActiveStation())) {
            tunerObjectContainer = new TunerObjectContainer(dabStation);
        }
        tunerObjectContainer.setPresetPos(n + 1);
        TunerProxyManager.getInstance().prepareAndTune(tunerObjectContainer, n2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setCurrentStation(AMFMStation aMFMStation, int n) {
        this.logger.main.log(-2137614336, "[MLH.setCurrentStation] %1", (Object)aMFMStation);
        Object object = this.mutex;
        synchronized (object) {
            this.amFmCurStation = aMFMStation;
        }
        int n2 = this.models.getActiveTuner();
        if (n2 == 4 || n2 == 1 || n2 == 10) {
            this.highlight(aMFMStation, n);
            String string = aMFMStation.getFullName();
            if (Utilities.isEmpty(string)) {
                string = aMFMStation.getFrequencyString();
            }
            this.models.getLabelModel(2072576256).setText(string);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setCurrentStation(DabStation dabStation, int n, int n2) {
        this.logger.main.log(-2137614336, "[MLH.setCurrentStation] %1", (Object)dabStation);
        Object object = this.mutex;
        synchronized (object) {
            this.dabCurStation = dabStation;
            this.dabReception = n;
        }
        if (this.models.getActiveTuner() == 5) {
            this.highlight(dabStation, n2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setCurrentStation(UnifiedStationExt unifiedStationExt, int n) {
        this.logger.main.log(-2137614336, "[MLH.setCurrentStation] %1", (Object)unifiedStationExt);
        Object object = this.mutex;
        synchronized (object) {
            this.uniCurStation = unifiedStationExt;
        }
        if (this.models.getActiveTuner() == 11) {
            this.highlight(unifiedStationExt, n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setCurrentStation(StationInfoExt stationInfoExt, int n) {
        this.logger.main.log(-2137614336, "[MLH.setCurrentStation] %1", (Object)stationInfoExt);
        Object object = this.mutex;
        synchronized (object) {
            this.sdarsCurService = stationInfoExt;
        }
        if (stationInfoExt.isAudioOk() && this.sdarsNoSignal) {
            stationInfoExt.setAudioOk(false);
        }
        if (this.models.getActiveTuner() == 7) {
            this.highlight(stationInfoExt, n);
            this.models.getLabelModel(2072576256).setText(stationInfoExt.getShortLabel());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setSeekPossibility(SeekPossibility seekPossibility) {
        Object object = this.mutex;
        synchronized (object) {
            AbstractMemoryRow abstractMemoryRow;
            TunerObjectContainer tunerObjectContainer;
            this.lastReceivedSeekPossibility = seekPossibility;
            SelectedItem selectedItem = this.listModel.getSelected();
            if (selectedItem != null && (tunerObjectContainer = (abstractMemoryRow = (AbstractMemoryRow)this.listModel.getRow(selectedItem.getIndex())).getTOContainer()).getBand() == 7 && tunerObjectContainer.getSDARSService().sID == seekPossibility.sID) {
                SDARSMemoryRow sDARSMemoryRow = (SDARSMemoryRow)this.listModel.getRow(selectedItem.getIndex());
                AddToSeeksPossibilityEnum.setSeekDependingModelsAndProperties(tunerObjectContainer.getSDARSService().sID, this.lastReceivedSeekPossibility, this.pdtListener.getActualPdt(), sDARSMemoryRow, this.models);
                this.listModel.setRow(selectedItem.getIndex(), sDARSMemoryRow);
            }
        }
    }

    @Override
    public PresetIds getPresetIds(TunerObjectContainer tunerObjectContainer) {
        int n = -1;
        switch (tunerObjectContainer.getType()) {
            case 3: {
                n = this.getIndexOfAmFmStation(tunerObjectContainer.getAMFMService(), tunerObjectContainer.getPresetPos() - 1);
                break;
            }
            case 6: {
                DabStation dabStation = tunerObjectContainer.getDABStation();
                n = this.getIndexOfDABService(dabStation.service.sID, dabStation.service.ensID, tunerObjectContainer.getPresetPos() - 1);
                break;
            }
            case 7: {
                n = this.getIndexOfUniStation(tunerObjectContainer.getUniStation(), tunerObjectContainer.getPresetPos() - 1);
                break;
            }
            case 5: {
                n = this.getIndexOfSDARSstation(tunerObjectContainer.getSDARSService(), tunerObjectContainer.getPresetPos() - 1);
                break;
            }
        }
        if (n != -1) {
            return new PresetIds(n + 1, n + 1);
        }
        return new PresetIds(0, 0);
    }

    private void highlight(AMFMStation aMFMStation, int n) {
        this.logger.main.log(-2137614336, "[MLH.highlight] %1", (Object)aMFMStation);
        if (!this.status.isMemoryListInitialized()) {
            return;
        }
        SelectedItem selectedItem = this.listModel.getSelected();
        int n2 = selectedItem != null ? selectedItem.getIndex() : -1;
        int n3 = this.getIndexOfAmFmStation(aMFMStation, n2);
        this.highlight(new TunerObjectContainer(aMFMStation), n2, n3, n);
    }

    private void highlight(TunerObjectContainer tunerObjectContainer, int n, int n2, int n3) {
        this.resetProgramData(n, n2);
        if (n2 == -1 && n3 == 0) {
            int n4;
            int n5 = n4 = n != -1 ? ((AbstractMemoryRow)this.listModel.getRow(n)).getBand() : -1;
            if (n4 == tunerObjectContainer.getBand() && this.memoryListVisible && n4 != 7) {
                n2 = n;
            }
        }
        if (n2 != -1) {
            AbstractMemoryRow abstractMemoryRow = (AbstractMemoryRow)this.listModel.getRow(n2);
            abstractMemoryRow.setProgramData(tunerObjectContainer, this.imgType);
            abstractMemoryRow.setStationActive(true);
            if (tunerObjectContainer.getBand() == 7) {
                SdarsRadioText sdarsRadioText = this.pdtListener.getActualPdt();
                if (sdarsRadioText != null && sdarsRadioText.sID == tunerObjectContainer.getSDARSService().sID) {
                    ((SDARSMemoryRow)abstractMemoryRow).setProgramData(sdarsRadioText, this.imgType);
                }
                SeekPossibility seekPossibility = this.lastReceivedSeekPossibility;
                if (seekPossibility.sID == tunerObjectContainer.getSDARSService().sID) {
                    AddToSeeksPossibilityEnum.setSeekDependingModelsAndProperties(tunerObjectContainer.getSDARSService().sID, this.lastReceivedSeekPossibility, this.pdtListener.getActualPdt(), (SDARSMemoryRow)abstractMemoryRow, this.models);
                }
            }
            this.listModel.setRow(n2, abstractMemoryRow);
        }
        this.setSelection(n2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void highlight(int n, int n2) {
        Object object = this.mutex;
        synchronized (object) {
            switch (n) {
                case 1: 
                case 4: 
                case 10: {
                    this.setCurrentStation(this.amFmCurStation, n2);
                    break;
                }
                case 5: {
                    this.setCurrentStation(this.dabCurStation, this.dabReception, n2);
                    break;
                }
                case 11: {
                    this.setCurrentStation(this.uniCurStation, n2);
                    break;
                }
                case 7: {
                    this.setCurrentStation(this.sdarsCurService, n2);
                    break;
                }
            }
        }
    }

    private void resetProgramData(int n, int n2) {
        if (n != n2 && n != -1) {
            AbstractMemoryRow abstractMemoryRow = (AbstractMemoryRow)this.listModel.getRow(n);
            abstractMemoryRow.setStationActive(false);
            this.listModel.setRow(n, abstractMemoryRow);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void highlight(DabStation dabStation, int n) {
        this.logger.main.log(-2137614336, "[MLH.highlight] %1", (Object)dabStation);
        if (!this.status.isMemoryListInitialized()) {
            return;
        }
        SelectedItem selectedItem = this.listModel.getSelected();
        int n2 = selectedItem != null ? selectedItem.getIndex() : -1;
        int n3 = this.getIndexOfDABService(dabStation.service.sID, dabStation.service.ensID, n2);
        TunerObjectContainer tunerObjectContainer = new TunerObjectContainer(dabStation);
        Object object = this.mutex;
        synchronized (object) {
            tunerObjectContainer.setReceptionStatus(this.dabReception);
        }
        this.highlight(tunerObjectContainer, n2, n3, n);
        this.dabPresetNameUpdateTimer.setActiveService(dabStation);
    }

    private void highlight(UnifiedStationExt unifiedStationExt, int n) {
        this.logger.main.log(-2137614336, "[MLH.highlight] %1", (Object)unifiedStationExt);
        if (!this.status.isMemoryListInitialized()) {
            return;
        }
        SelectedItem selectedItem = this.listModel.getSelected();
        int n2 = selectedItem != null ? selectedItem.getIndex() : -1;
        int n3 = this.getIndexOfUniStation(unifiedStationExt, n2);
        this.highlight(new TunerObjectContainer(unifiedStationExt), n2, n3, n);
    }

    private void highlight(StationInfoExt stationInfoExt, int n) {
        this.logger.main.log(-2137614336, "[MLH.highlight] %1", (Object)stationInfoExt);
        if (!this.status.isMemoryListInitialized()) {
            return;
        }
        SelectedItem selectedItem = this.listModel.getSelected();
        int n2 = selectedItem != null ? selectedItem.getIndex() : -1;
        int n3 = this.getIndexOfSDARSstation(stationInfoExt, n2);
        this.highlight(new TunerObjectContainer(stationInfoExt), n2, n3, n);
    }

    public void cancelActions() {
    }

    @Override
    public TunerObjectContainer[] getList() {
        ArrayList arrayList = new ArrayList(this.listHelper.getLength());
        if (!Utilities.isPGen1OrBentley()) {
            for (int i2 = 0; i2 < this.listModel.getLength(); ++i2) {
                AbstractMemoryRow abstractMemoryRow = (AbstractMemoryRow)this.listModel.getRow(i2);
                if (!abstractMemoryRow.isOccupied()) continue;
                TunerObjectContainer tunerObjectContainer = abstractMemoryRow.getTOContainer();
                tunerObjectContainer.setPresetPos(i2 + 1);
                tunerObjectContainer.setListID((int)abstractMemoryRow.getUniqueID());
                arrayList.add(tunerObjectContainer);
            }
        }
        Object[] objectArray = new TunerObjectContainer[arrayList.size()];
        arrayList.toArray(objectArray);
        return objectArray;
    }

    public TunerObjectContainer getPreset(int n) {
        if (n > 0 && n <= this.listModel.getLength()) {
            return ((AbstractRadioListRow)this.listModel.getRow(n - 1)).getTOContainer();
        }
        return null;
    }

    public TunerObjectContainer prepareTune(int n) {
        EvoListRow evoListRow = this.listModel.getRow(n - 1);
        int n2 = ((AbstractMemoryRow)evoListRow).getState();
        TunerObjectContainer tunerObjectContainer = ((AbstractMemoryRow)evoListRow).getTOContainer();
        tunerObjectContainer.setPresetPos(n);
        this.scanHandler.abortScan();
        if (TunerProxyManager.getInstance().isTuneForbidden(n2, tunerObjectContainer)) {
            return null;
        }
        return tunerObjectContainer;
    }

    @Override
    public TunerObjectContainer[] getList(int n) {
        ArrayList arrayList = new ArrayList(this.listModel.getLength());
        for (int i2 = 0; i2 < this.listModel.getLength(); ++i2) {
            AbstractMemoryRow abstractMemoryRow = (AbstractMemoryRow)this.listModel.getRow(i2);
            if (abstractMemoryRow.getBand() != n) continue;
            TunerObjectContainer tunerObjectContainer = abstractMemoryRow.getTOContainer();
            tunerObjectContainer.setListID((int)abstractMemoryRow.getUniqueID());
            tunerObjectContainer.setPresetPos(i2 + 1);
            arrayList.add(tunerObjectContainer);
        }
        return (TunerObjectContainer[])arrayList.toArray(new TunerObjectContainer[arrayList.size()]);
    }

    @Override
    public TunerObjectContainer[] getList(int[] nArray) {
        ArrayList arrayList = new ArrayList(this.listModel.getLength());
        for (int i2 = 0; i2 < this.listModel.getLength(); ++i2) {
            AbstractMemoryRow abstractMemoryRow = (AbstractMemoryRow)this.listModel.getRow(i2);
            boolean bl = false;
            for (int i3 = 0; i3 < nArray.length; ++i3) {
                if (abstractMemoryRow.getBand() != nArray[i3]) continue;
                bl = true;
                break;
            }
            if (!bl) continue;
            TunerObjectContainer tunerObjectContainer = abstractMemoryRow.getTOContainer();
            tunerObjectContainer.setListID((int)abstractMemoryRow.getUniqueID());
            tunerObjectContainer.setPresetPos(i2 + 1);
            arrayList.add(tunerObjectContainer);
        }
        return (TunerObjectContainer[])arrayList.toArray(new TunerObjectContainer[arrayList.size()]);
    }

    void updatePSFreeze(AMFMStation aMFMStation) {
        for (int i2 = 0; i2 < this.listModel.getLength(); ++i2) {
            AbstractMemoryRow abstractMemoryRow = (AbstractMemoryRow)this.listModel.getRow(i2);
            if (abstractMemoryRow instanceof AmFmMemoryRow && RadioComparators.equals(aMFMStation, ((AmFmMemoryRow)abstractMemoryRow).getStation())) {
                ((AmFmMemoryRow)abstractMemoryRow).setPSFreeze(aMFMStation.isPsFreezed(), aMFMStation.name);
                this.listModel.setRow(i2, abstractMemoryRow);
                continue;
            }
            if (!(abstractMemoryRow instanceof UniMemoryRow) || !RadioComparators.equals(aMFMStation, ((UniMemoryRow)abstractMemoryRow).getStation().getFmStation())) continue;
            ((UniMemoryRow)abstractMemoryRow).setPSFreeze(aMFMStation.isPsFreezed(), aMFMStation.name);
            this.listModel.setRow(i2, abstractMemoryRow);
        }
        this.postChangeMemlist();
    }

    AbstractMemoryRow[] getRows(int n) {
        return this.listHelper.getRows(n);
    }

    private int getIndexOfAmFmStation(AMFMStation aMFMStation, int n) {
        EvoListRow evoListRow;
        int n2 = aMFMStation.getPresetPos();
        if (this.scanHandler.isScanActive() && n2 != 0 && (evoListRow = this.listModel.getRow(n2 - 1)) instanceof AmFmMemoryRow && RadioComparators.equals(aMFMStation, ((AmFmMemoryRow)evoListRow).getStation())) {
            return n2 - 1;
        }
        if (n != -1 && (evoListRow = this.listModel.getRow(n)) instanceof AmFmMemoryRow && RadioComparators.equals(aMFMStation, ((AmFmMemoryRow)evoListRow).getStation())) {
            return n2 > 0 ? n2 - 1 : n;
        }
        for (int i2 = 0; i2 < this.listModel.getLength(); ++i2) {
            EvoListRow evoListRow2 = this.listModel.getRow(i2);
            if (!(evoListRow2 instanceof AmFmMemoryRow) || !RadioComparators.equals(aMFMStation, ((AmFmMemoryRow)evoListRow2).getStation())) continue;
            return i2;
        }
        return -1;
    }

    protected void initMemoryList(ILogoDatabase iLogoDatabase) {
        EvoListRow[] evoListRowArray = this.storage.loadMemoryList(12, iLogoDatabase);
        this.imgType = this.storage.loadPreferredImageType();
        BaseListModelApp baseListModelApp = this.listModel.getEmptyCopy();
        baseListModelApp.append(evoListRowArray);
        MemoryListHandler.adjustRowLayoutsIfNecessary(baseListModelApp, this.models.getChoiceModel(1636368640), this.status.isDisplayStationNames(), this.storage.getAmfmView());
        this.listModel.update(baseListModelApp);
        this.fillEntertaimnentDrawer();
        this.propagateUpdatedMemoryList();
        this.status.setMemoryListInitialized(true);
        this.refreshHighlight();
        this.checkIfFull();
        this.logger.main.log(-2137614336, "MemoryList initialized. ");
    }

    private void storeMemoryList() {
        List list = this.listModel.asList();
        this.storage.storeMemoryList(12, (AbstractMemoryRow[])list.toArray(new AbstractMemoryRow[list.size()]));
        this.propagateUpdatedMemoryList();
    }

    private void refreshHighlight() {
        switch (this.models.getActiveTuner()) {
            case 1: 
            case 4: 
            case 10: {
                this.highlight(this.amFmCurStation, 0);
                break;
            }
            case 5: {
                this.highlight(this.dabCurStation, 0);
                break;
            }
            case 11: {
                this.highlight(this.uniCurStation, 0);
                break;
            }
            case 7: {
                this.highlight(this.sdarsCurService, 0);
                break;
            }
        }
    }

    private void setSelection(int n) {
        this.listModel.setSelectedIndex(n);
        this.models.getChoiceModel(-980942592).setValue(n == -1 ? 0 : 1);
        SelectedItem selectedItem = this.listModel.getSelected();
        if (selectedItem == null) {
            this.entDrawerListModel.setSelectedIndex(-1);
        } else {
            this.entDrawerListModel.setSelectedUniqueID(selectedItem != null ? selectedItem.getUniqueID() : 0L);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int getNumberOfStoredFavorites() {
        int n = 0;
        Object object = this.mutex;
        synchronized (object) {
            for (int i2 = 0; i2 < this.listModel.getLength(); ++i2) {
                if (!((AbstractMemoryRow)this.listModel.getRow(i2)).isOccupied()) continue;
                ++n;
            }
        }
        return n;
    }

    @Override
    public void propagateUpdatedMemoryList() {
        super.propagateUpdatedMemoryList();
        int n = this.getNumberOfStoredFavorites();
        this.models.getChoiceModel(914948352).setValue(n);
    }

    private void storeStation(TunerObjectContainer tunerObjectContainer) {
        if (tunerObjectContainer != null) {
            int n = 0;
            if (Utilities.isNARBuild()) {
                int n2 = this.getNextFreePosition();
                if (n2 != -1) {
                    AbstractMemoryRow abstractMemoryRow = this.createMemoryRow(tunerObjectContainer, n2 + 1);
                    this.listModel.setRow(n2, abstractMemoryRow);
                    n = n2 + 1;
                    this.narMemoryListPresetIndexChangeListener.memoryListPresetIndexChanged(n2, tunerObjectContainer);
                }
            } else {
                AbstractMemoryRow abstractMemoryRow = this.createMemoryRow(tunerObjectContainer, 0);
                abstractMemoryRow.adjustLayoutIfNecessary(this.status.isDisplayStationNames(), this.models.getChoiceModel(1636368640).getValue() == 1, this.storage.getAmfmView());
                this.listModel.append(abstractMemoryRow);
                n = this.listModel.getLength();
            }
            this.models.getChoiceModel(1099497728).setValue(n);
        }
        this.postChangeMemlist();
    }

    void storeStationAt(TunerObjectContainer tunerObjectContainer, int n) {
        if (tunerObjectContainer != null) {
            boolean bl;
            boolean bl2 = bl = n >= 0 && n < this.listModel.getLength();
            if (bl) {
                AbstractMemoryRow abstractMemoryRow = this.createMemoryRow(tunerObjectContainer, n + 1);
                this.listModel.setRow(n, abstractMemoryRow);
            }
        }
        this.postChangeMemlist();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void postChangeMemlist() {
        this.storeMemoryList();
        this.checkIfFull();
        Object object = this.mutex;
        synchronized (object) {
            this.refreshHighlight();
        }
        this.fillEntertaimnentDrawer();
    }

    private void fillEntertaimnentDrawer() {
        BaseListModelApp baseListModelApp = this.entDrawerListModel.getEmptyCopy();
        List list = this.listModel.asList();
        Object object = list.iterator();
        while (object.hasNext()) {
            AbstractMemoryRow abstractMemoryRow = (AbstractMemoryRow)object.next();
            if (abstractMemoryRow.isEmpty()) continue;
            baseListModelApp.append(abstractMemoryRow);
        }
        object = this.listModel.getSelected();
        baseListModelApp.setSelectedUniqueID(object != null ? ((SelectedItem)object).getUniqueID() : 0L);
        this.entDrawerListModel.update(baseListModelApp);
    }

    private int getNextFreePosition() {
        for (int i2 = 0; i2 < this.listModel.getLength(); ++i2) {
            if (!((AbstractMemoryRow)this.listModel.getRow(i2)).isEmpty()) continue;
            return i2;
        }
        return -1;
    }

    private TunerObjectContainer getCurrentStation() {
        switch (this.models.getActiveTuner()) {
            case 1: 
            case 4: 
            case 10: {
                return new TunerObjectContainer(this.amFmCurStation);
            }
            case 7: {
                return new TunerObjectContainer(this.sdarsCurService);
            }
        }
        return TunerObjectContainer.EMPTY_CONTAINER;
    }

    private AbstractMemoryRow createMemoryRow(TunerObjectContainer tunerObjectContainer, int n) {
        AbstractMemoryRow abstractMemoryRow = null;
        switch (tunerObjectContainer.getType()) {
            case 6: {
                if (tunerObjectContainer.getDABStation().isEnsemble()) {
                    tunerObjectContainer = new TunerObjectContainer(this.dabCurStation);
                }
                if (this.isStoreNotAllowed(tunerObjectContainer)) {
                    return null;
                }
                abstractMemoryRow = this.rowFactory.getDabFavRow(tunerObjectContainer, this.imgType);
                break;
            }
            case 7: {
                abstractMemoryRow = this.rowFactory.getUniFavRow(tunerObjectContainer.getUniStation(), this.imgType);
                break;
            }
            case 5: {
                abstractMemoryRow = this.rowFactory.getSdarsFavRow(tunerObjectContainer, n, this.imgType);
                break;
            }
            case 3: {
                abstractMemoryRow = this.rowFactory.getAmFmFavRow(tunerObjectContainer.getAMFMService(), n, this.imgType);
                this.informTunerStore(42, tunerObjectContainer);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Unexpected band ").append(tunerObjectContainer.getType()).toString());
            }
        }
        return abstractMemoryRow;
    }

    private void checkIfFull() {
        if (this.listModel.getLength() >= 50) {
            for (int i2 = 0; i2 < this.listModel.getLength(); ++i2) {
                if (!((AbstractMemoryRow)this.listModel.getRow(i2)).isEmpty()) continue;
                this.models.getChoiceModel(344523008).setValue(0);
                return;
            }
            this.models.getChoiceModel(344523008).setValue(1);
        } else {
            this.models.getChoiceModel(344523008).setValue(0);
        }
    }

    @Override
    public boolean isEmpty() {
        return this.listModel.getLength() == 0;
    }

    private void orderPdt(int n) {
        PdtInfoHandler pdtInfoHandler = TunerProxyManager.getInstance().getSDARSTuner().getPdtHandler();
        if (pdtInfoHandler != null) {
            if (n != -1) {
                if (this.registeredSid != -1) {
                    pdtInfoHandler.removeListener(this.registeredSid, this.pdtListener);
                }
                this.registeredSid = n;
                pdtInfoHandler.addListener(n, this.pdtListener, 0);
            } else {
                pdtInfoHandler.removeListener(this.registeredSid, this.pdtListener);
                this.registeredSid = -1;
            }
        }
    }

    @Override
    public long getFocussedItemUniqueId() {
        return this.focussedItemUniqueID;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void resetUserAction() {
        this.animationTimer.cancel();
        Object object = this.animationMutex;
        synchronized (object) {
            if (this.userActionIndex != -1) {
                EvoListRow evoListRow = this.listModel.getRow(this.userActionIndex);
                if (evoListRow instanceof EmptyMemoryRow) {
                    EmptyMemoryRow emptyMemoryRow = (EmptyMemoryRow)evoListRow;
                    emptyMemoryRow.setUserAction(false);
                    this.listModel.setRow(this.userActionIndex, emptyMemoryRow);
                }
                this.userActionIndex = -1;
            }
        }
    }

    TunerObjectContainer[] startScan() {
        int n;
        TunerObjectContainer[] tunerObjectContainerArray = this.getList();
        ArrayList arrayList = new ArrayList(tunerObjectContainerArray.length);
        SelectedItem selectedItem = this.listModel.getSelected();
        int n2 = selectedItem.getIndex() + 1;
        this.logger.main.log(-2137614336, "[MemoryListHandler.startScan] selected preset: %1", (long)n2);
        for (n = 0; n < tunerObjectContainerArray.length; ++n) {
            if (tunerObjectContainerArray[n].getPresetPos() < n2 || !tunerObjectContainerArray[n].isEnabled()) continue;
            arrayList.add(tunerObjectContainerArray[n]);
        }
        for (n = 0; n < tunerObjectContainerArray.length && tunerObjectContainerArray[n].getPresetPos() < n2; ++n) {
            if (!tunerObjectContainerArray[n].isEnabled()) continue;
            arrayList.add(tunerObjectContainerArray[n]);
        }
        TunerObjectContainer[] tunerObjectContainerArray2 = (TunerObjectContainer[])arrayList.toArray(new TunerObjectContainer[arrayList.size()]);
        for (int i2 = 0; i2 < tunerObjectContainerArray2.length; ++i2) {
            this.logger.main.log(-2137614336, "[MemoryListHandler.startScan] listToScan: %1", (Object)tunerObjectContainerArray2[i2].toString());
        }
        return tunerObjectContainerArray2;
    }

    public TunerObjectContainer getCorrentStation4Freeze() {
        switch (this.models.getActiveTuner()) {
            case 1: {
                return new TunerObjectContainer(this.amFmCurStation);
            }
            case 11: {
                return new TunerObjectContainer(this.uniCurStation);
            }
        }
        return null;
    }

    static /* synthetic */ MemoryListHandler$DABPresetNameUpdateTimer access$1400(MemoryListHandler memoryListHandler) {
        return memoryListHandler.dabPresetNameUpdateTimer;
    }

    static /* synthetic */ Logger access$1500(MemoryListHandler memoryListHandler) {
        return memoryListHandler.logger;
    }

    static /* synthetic */ int access$1600(MemoryListHandler memoryListHandler, long l, int n, int n2) {
        return memoryListHandler.getIndexOfDABService(l, n, n2);
    }

    static /* synthetic */ BaseListModelApp access$1700(MemoryListHandler memoryListHandler) {
        return memoryListHandler.listModel;
    }

    static /* synthetic */ void access$1800(MemoryListHandler memoryListHandler) {
        memoryListHandler.postChangeMemlist();
    }

    static /* synthetic */ boolean access$1902(MemoryListHandler memoryListHandler, boolean bl) {
        memoryListHandler.sdarsNoSignal = bl;
        return memoryListHandler.sdarsNoSignal;
    }

    static /* synthetic */ RadioPresetHandler$INARMemoryListIndexChangeListener access$2000(MemoryListHandler memoryListHandler) {
        return memoryListHandler.narMemoryListPresetIndexChangeListener;
    }

    static /* synthetic */ void access$2100(MemoryListHandler memoryListHandler, SeekPossibility seekPossibility) {
        memoryListHandler.setSeekPossibility(seekPossibility);
    }

    static /* synthetic */ void access$2200(MemoryListHandler memoryListHandler, AMFMStation aMFMStation, int n) {
        memoryListHandler.setCurrentStation(aMFMStation, n);
    }

    static /* synthetic */ void access$2300(MemoryListHandler memoryListHandler, DabStation dabStation, int n, int n2) {
        memoryListHandler.setCurrentStation(dabStation, n, n2);
    }

    static /* synthetic */ void access$2400(MemoryListHandler memoryListHandler, UnifiedStationExt unifiedStationExt, int n) {
        memoryListHandler.setCurrentStation(unifiedStationExt, n);
    }

    static /* synthetic */ MenuModelApp access$2500(MemoryListHandler memoryListHandler) {
        return memoryListHandler.menuModel;
    }

    static /* synthetic */ IScanHandler access$2600(MemoryListHandler memoryListHandler) {
        return memoryListHandler.scanHandler;
    }

    static /* synthetic */ int access$2700(MemoryListHandler memoryListHandler) {
        return memoryListHandler.operationMode;
    }

    static /* synthetic */ int access$2702(MemoryListHandler memoryListHandler, int n) {
        memoryListHandler.operationMode = n;
        return memoryListHandler.operationMode;
    }

    static /* synthetic */ TunerModels access$2800(MemoryListHandler memoryListHandler) {
        return memoryListHandler.models;
    }

    static /* synthetic */ int access$2902(MemoryListHandler memoryListHandler, int n) {
        memoryListHandler.storeIndex = n;
        return memoryListHandler.storeIndex;
    }

    static /* synthetic */ void access$3000(MemoryListHandler memoryListHandler, int n, int n2) {
        memoryListHandler.resetProgramData(n, n2);
    }

    static /* synthetic */ void access$3100(MemoryListHandler memoryListHandler, int n) {
        memoryListHandler.setSelection(n);
    }

    static /* synthetic */ void access$3200(MemoryListHandler memoryListHandler, AbstractMemoryRow abstractMemoryRow, int n, int n2) {
        memoryListHandler.tuneFromMemoryList(abstractMemoryRow, n, n2);
    }

    static /* synthetic */ int access$3300(MemoryListHandler memoryListHandler) {
        return memoryListHandler.moveIndex;
    }

    static /* synthetic */ AbstractListRowFactory access$3400(MemoryListHandler memoryListHandler) {
        return memoryListHandler.rowFactory;
    }

    static /* synthetic */ AbstractMemoryRow access$3500(MemoryListHandler memoryListHandler) {
        return memoryListHandler.moveRow;
    }

    static /* synthetic */ Object access$3600(MemoryListHandler memoryListHandler) {
        return memoryListHandler.animationMutex;
    }

    static /* synthetic */ int access$3700(MemoryListHandler memoryListHandler) {
        return memoryListHandler.userActionIndex;
    }

    static /* synthetic */ void access$3800(MemoryListHandler memoryListHandler) {
        memoryListHandler.resetUserAction();
    }

    static /* synthetic */ int access$3702(MemoryListHandler memoryListHandler, int n) {
        memoryListHandler.userActionIndex = n;
        return memoryListHandler.userActionIndex;
    }

    static /* synthetic */ Timer access$3900(MemoryListHandler memoryListHandler) {
        return memoryListHandler.animationTimer;
    }

    static /* synthetic */ long access$4002(MemoryListHandler memoryListHandler, long l) {
        memoryListHandler.focussedItemUniqueID = l;
        return memoryListHandler.focussedItemUniqueID;
    }

    static /* synthetic */ IEPGAvailibiltyCallback access$4100(MemoryListHandler memoryListHandler) {
        return memoryListHandler.sdarsEpgAvailibilityCallback;
    }

    static /* synthetic */ void access$4200(MemoryListHandler memoryListHandler, int n) {
        memoryListHandler.orderPdt(n);
    }

    static /* synthetic */ void access$4300(MemoryListHandler memoryListHandler, TunerObjectContainer tunerObjectContainer) {
        memoryListHandler.storeStation(tunerObjectContainer);
    }

    static /* synthetic */ ITunerVariantExt access$4400(MemoryListHandler memoryListHandler) {
        return memoryListHandler.variantExt;
    }

    static /* synthetic */ void access$4500(MemoryListHandler memoryListHandler) {
        memoryListHandler.clearMemoryListAndSwitchToActiveTuner();
    }

    static /* synthetic */ void access$4600(MemoryListHandler memoryListHandler, int n, int n2) {
        memoryListHandler.highlight(n, n2);
    }

    static /* synthetic */ AbstractMemoryRow access$3502(MemoryListHandler memoryListHandler, AbstractMemoryRow abstractMemoryRow) {
        memoryListHandler.moveRow = abstractMemoryRow;
        return memoryListHandler.moveRow;
    }

    static /* synthetic */ int access$3302(MemoryListHandler memoryListHandler, int n) {
        memoryListHandler.moveIndex = n;
        return memoryListHandler.moveIndex;
    }

    static /* synthetic */ IDrawerFocusManager access$4700(MemoryListHandler memoryListHandler) {
        return memoryListHandler.drawerFocus;
    }

    static /* synthetic */ boolean access$4800(MemoryListHandler memoryListHandler) {
        return memoryListHandler.clearAllWaiting;
    }

    static /* synthetic */ boolean access$4802(MemoryListHandler memoryListHandler, boolean bl) {
        memoryListHandler.clearAllWaiting = bl;
        return memoryListHandler.clearAllWaiting;
    }

    static /* synthetic */ int access$2900(MemoryListHandler memoryListHandler) {
        return memoryListHandler.storeIndex;
    }

    static /* synthetic */ TunerObjectContainer access$4900(MemoryListHandler memoryListHandler) {
        return memoryListHandler.getCurrentStation();
    }

    static /* synthetic */ AbstractMemoryRow access$5000(MemoryListHandler memoryListHandler, TunerObjectContainer tunerObjectContainer, int n) {
        return memoryListHandler.createMemoryRow(tunerObjectContainer, n);
    }

    static /* synthetic */ boolean access$5102(MemoryListHandler memoryListHandler, boolean bl) {
        memoryListHandler.memoryListVisible = bl;
        return memoryListHandler.memoryListVisible;
    }

    static /* synthetic */ Object access$5200(MemoryListHandler memoryListHandler) {
        return memoryListHandler.mutex;
    }

    static /* synthetic */ TunerStatus access$5300(MemoryListHandler memoryListHandler) {
        return memoryListHandler.status;
    }

    static /* synthetic */ TunerStorage access$5400(MemoryListHandler memoryListHandler) {
        return memoryListHandler.storage;
    }
}

