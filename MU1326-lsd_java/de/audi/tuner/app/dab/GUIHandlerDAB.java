/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab;

import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.tuner.app.DrawerFocusManager;
import de.audi.tuner.app.IDrawerFocusManager;
import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.MemoryListHandler;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.TunerProxyManager;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.dab.DABDsiDownInfo;
import de.audi.tuner.app.dab.DABDsiUpInfo;
import de.audi.tuner.app.dab.DABLabels;
import de.audi.tuner.app.dab.DABSetupHandler;
import de.audi.tuner.app.dab.DABTuner;
import de.audi.tuner.app.dab.DabReceptionStatus;
import de.audi.tuner.app.dab.GUIHandlerDAB$ButtonListener;
import de.audi.tuner.app.dab.GUIHandlerDAB$MyMessageListener;
import de.audi.tuner.app.dab.GUIHandlerDAB$PowerEventListener;
import de.audi.tuner.app.dab.GUIHandlerDAB$PrevNextHandler;
import de.audi.tuner.app.dab.GUIHandlerDAB$StationListHandler;
import de.audi.tuner.app.dab.stationlist.DabCascadedListHandler;
import de.audi.tuner.app.dab.stationlist.DabFlatListHandler;
import de.audi.tuner.app.dab.stationlist.DabFolderListHandler;
import de.audi.tuner.app.storage.TunerStorage;
import de.audi.tuner.ifc.IPowerEvent;
import de.audi.tuner.ifc.IPrevNext;
import de.audi.tuner.ifc.IScanHandler;
import de.audi.tuner.ifc.IStationListHandler;
import de.audi.tuner.ifc.IStoreStationHandler;
import de.audi.tuner.ifc.ITunerDABGUIHandler;
import de.audi.tuner.ifc.ITunerVariantExt;
import de.audi.tuner.ifc.listener.IUpdateListener;
import de.audi.tuner.ifc.listener.MessageListener;

public class GUIHandlerDAB
extends DefaultButtonListener
implements ITunerDABGUIHandler,
ChoiceListener {
    final IPrevNext prevNextHandler = new GUIHandlerDAB$PrevNextHandler(this, null);
    private final DabFolderListHandler folderListHandler;
    private final DabFlatListHandler flatListHandler;
    private final DabCascadedListHandler cascadedListHandler;
    private final IStationListHandler stationList = new GUIHandlerDAB$StationListHandler(this, null);
    private final Logger logger;
    private final TunerModels models;
    private final DABTuner dabTuner;
    private final TunerStorage storage;
    final DABLabels labels;
    private DABSetupHandler setupHandler;
    private IDrawerFocusManager drawerFocus = DrawerFocusManager.NULL_DRAWER_FOCUS_MANAGER;

    GUIHandlerDAB(DABTuner dABTuner, TunerBasics tunerBasics, TunerStorage tunerStorage, ITunerVariantExt iTunerVariantExt, LanguageManager languageManager, MemoryListHandler memoryListHandler, IScanHandler iScanHandler) {
        this.logger = tunerBasics.getLogger();
        this.models = tunerBasics.getModels();
        this.dabTuner = dABTuner;
        this.storage = tunerStorage;
        this.labels = new DABLabels(tunerBasics.getModels(), this.storage);
        this.models.getChoiceModel(378011904).setChoiceListener(this);
        this.models.getChoiceModel(-1333264128).setChoiceListener(this);
        this.models.getChoiceModel(-1333264128).setStatus(Utilities.isEvoHigh() ? 1 : 0);
        this.models.getChoiceModel(-2037972736).setChoiceListener(this);
        if (Utilities.isDABBand3AndLBandCoded()) {
            this.models.getChoiceModel(-2037972736).setStatus(1);
        } else {
            this.models.getChoiceModel(-2037972736).setStatus(0);
        }
        this.models.getChoiceModel(394789120).setChoiceListener(this);
        this.models.getButtonModel(478675200).setButtonListener(this);
        this.models.getChoiceModel(-1970798336).setButtonListener(this);
        GUIHandlerDAB$ButtonListener gUIHandlerDAB$ButtonListener = new GUIHandlerDAB$ButtonListener(this, null);
        this.models.getButtonModel(-1702362880).setButtonListener(gUIHandlerDAB$ButtonListener);
        this.models.getButtonModel(-1719140096).setButtonListener(gUIHandlerDAB$ButtonListener);
        this.folderListHandler = new DabFolderListHandler(dABTuner, tunerBasics, tunerStorage, iTunerVariantExt, languageManager, iScanHandler);
        this.flatListHandler = new DabFlatListHandler(dABTuner, tunerBasics, languageManager, iTunerVariantExt, tunerStorage, iScanHandler);
        this.cascadedListHandler = new DabCascadedListHandler(dABTuner, tunerBasics, tunerStorage, iTunerVariantExt, languageManager, iScanHandler);
        this.setupHandler = new DABSetupHandler(this.logger, tunerStorage);
        this.setupHandler.init();
        this.flatListHandler.init();
        this.folderListHandler.init();
        this.cascadedListHandler.init();
        int[] nArray = this.setupHandler.getCurrentSetup();
        if (nArray != null && nArray.length > 2) {
            this.itemSelected(394789120, nArray[2], 0, 0);
        }
    }

    @Override
    public void register(IStoreStationHandler iStoreStationHandler) {
        this.flatListHandler.register(iStoreStationHandler);
        this.folderListHandler.register(iStoreStationHandler);
        this.cascadedListHandler.register(iStoreStationHandler);
    }

    void initSetup() {
        int[] nArray = this.setupHandler.getCurrentSetup();
        this.processSetup(nArray);
    }

    void processSetup(int[] nArray) {
        if (nArray != null) {
            this.itemSelected(-2037972736, nArray[0], 0, 0);
            this.itemSelected(378011904, nArray[1], 0, 0);
            this.itemSelected(394789120, nArray[2], 0, 0);
            this.itemSelected(-1333264128, nArray[3], 0, 0);
        } else {
            this.logger.main.log(10000, "[GUIHandlerDAB.initSetup] setup is null");
        }
    }

    @Override
    public MessageListener getMessageListener() {
        return new GUIHandlerDAB$MyMessageListener(this, null);
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.logger.hmi.log(-2137614336, "[GUIHandlerDAB.itemSelected] on model: %1 index %2 ", (long)n, (long)n2);
        this.logger.hmi.log(-2137614336, "[GUIHandlerDAB.itemSelected] on col %1 terminal %2 ", (long)n3, (long)n4);
        switch (n) {
            case 100374: {
                int n5;
                this.models.getChoiceModel(378011904).setValue(n2);
                int n6 = n5 = n2 == 1 ? 3 : 2;
                if (n5 == 3 && this.models.getChoiceModel(-1333264128).getValue() == 1) {
                    n5 = 7;
                }
                this.dabTuner.switchLinking(n5);
                break;
            }
            case 100528: {
                this.models.getChoiceModel(-1333264128).setValue(n2);
                this.dabTuner.setSoftlinking(n2);
                TunerProxyManager.getInstance().getUnifiedTuner().setSoftlinking(n2);
                break;
            }
            case 100230: {
                int n7 = n2 == 1 ? 1 : 8;
                this.dabTuner.switchFrequencyTable(n7);
                break;
            }
            case 100375: {
                this.models.getChoiceModel(394789120).setValue(n2);
                this.flatListHandler.setSortMode(n2);
                this.folderListHandler.setSortMode(n2);
                this.cascadedListHandler.setSortMode(n2);
                this.flatListHandler.propagateUpdatedStationList(5);
                this.setupHandler.valueUpdated(n2, 2);
                break;
            }
        }
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        switch (n) {
            case 100490: {
                this.dabTuner.forceStationListUpdate(true);
                this.models.getChoiceModel(n).setValue(1);
                this.models.getChoiceModel(n).fireEvent(n3);
                break;
            }
            case 100380: {
                if (this.models.getBaseListModel(1804075264).getLength() <= 0) break;
                this.models.getButtonModel(478675200).fireEvent(n3);
                break;
            }
        }
    }

    public DabFolderListHandler getDabListHandler() {
        return this.folderListHandler;
    }

    @Override
    public IStationListHandler getStationListHandler() {
        return this.stationList;
    }

    @Override
    public boolean tuneById(long l, int n) {
        return this.folderListHandler.tuneById(l, n);
    }

    @Override
    public TunerObjectContainer[] getStationList() {
        if (Utilities.isBentley()) {
            return this.folderListHandler.getStationList();
        }
        if (this.isSortModeAlphabetically()) {
            return this.flatListHandler.getStationList();
        }
        return this.folderListHandler.getStationList();
    }

    @Override
    public TunerObjectContainer[] getStationListHierarchical() {
        return this.folderListHandler.getStationList();
    }

    @Override
    public TunerObjectContainer[] getStationList(int n) {
        return this.getStationList();
    }

    @Override
    public TunerObjectContainer getCurrentStation() {
        if (Utilities.isPGen1OrBentley() || this.isSortModeAlphabetically()) {
            return this.flatListHandler.getActiveStation();
        }
        return this.folderListHandler.getActiveStation();
    }

    void setupValueUpdated(int n, int n2) {
        this.setupHandler.valueUpdated(n, n2);
    }

    public boolean isManModeActive(int n) {
        return false;
    }

    public DABDsiUpInfo[] getDsiUpListeners() {
        return new DABDsiUpInfo[]{this.folderListHandler.dsiUpListener, this.flatListHandler.dsiUpListener, this.cascadedListHandler.dsiUpListener, this.labels.dsiUpListener};
    }

    public DABDsiDownInfo[] getDsiDownListeners() {
        return new DABDsiDownInfo[]{this.folderListHandler.dsiDownListener, this.flatListHandler.dsiDownListener, this.cascadedListHandler.dsiDownListener, this.labels.dsiDownListener};
    }

    void addUpdateListeners(IUpdateListener[] iUpdateListenerArray) {
        for (int i2 = 0; i2 < iUpdateListenerArray.length; ++i2) {
            this.folderListHandler.addUpdateListener(iUpdateListenerArray[i2]);
            this.flatListHandler.addUpdateListener(iUpdateListenerArray[i2]);
            this.cascadedListHandler.addUpdateListener(iUpdateListenerArray[i2]);
        }
    }

    boolean isSortModeAlphabetically() {
        return this.models.getChoiceModel(394789120).getValue() == 0;
    }

    @Override
    public void setSyncLinkState(DabReceptionStatus dabReceptionStatus) {
        this.folderListHandler.setSyncLinkState(dabReceptionStatus.syncStatus, dabReceptionStatus.linkStatus);
    }

    @Override
    public IPowerEvent getPoPowerStateListener() {
        return new GUIHandlerDAB$PowerEventListener(this, null);
    }

    static /* synthetic */ Logger access$400(GUIHandlerDAB gUIHandlerDAB) {
        return gUIHandlerDAB.logger;
    }

    static /* synthetic */ DabFlatListHandler access$500(GUIHandlerDAB gUIHandlerDAB) {
        return gUIHandlerDAB.flatListHandler;
    }

    static /* synthetic */ DabFolderListHandler access$600(GUIHandlerDAB gUIHandlerDAB) {
        return gUIHandlerDAB.folderListHandler;
    }

    static /* synthetic */ DABTuner access$700(GUIHandlerDAB gUIHandlerDAB) {
        return gUIHandlerDAB.dabTuner;
    }

    static /* synthetic */ IDrawerFocusManager access$800(GUIHandlerDAB gUIHandlerDAB) {
        return gUIHandlerDAB.drawerFocus;
    }

    static /* synthetic */ TunerModels access$900(GUIHandlerDAB gUIHandlerDAB) {
        return gUIHandlerDAB.models;
    }

    static /* synthetic */ IDrawerFocusManager access$802(GUIHandlerDAB gUIHandlerDAB, IDrawerFocusManager iDrawerFocusManager) {
        gUIHandlerDAB.drawerFocus = iDrawerFocusManager;
        return gUIHandlerDAB.drawerFocus;
    }

    static /* synthetic */ DabCascadedListHandler access$1000(GUIHandlerDAB gUIHandlerDAB) {
        return gUIHandlerDAB.cascadedListHandler;
    }

    static /* synthetic */ TunerStorage access$1200(GUIHandlerDAB gUIHandlerDAB) {
        return gUIHandlerDAB.storage;
    }
}

