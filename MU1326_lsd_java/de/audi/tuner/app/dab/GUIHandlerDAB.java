/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab;

import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.model.update.ModelTrigger;
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
import de.audi.tuner.app.dab.stationlist.DabCascadedListHandler;
import de.audi.tuner.app.dab.stationlist.DabFlatListHandler;
import de.audi.tuner.app.dab.stationlist.DabFolderListHandler;
import de.audi.tuner.app.dab.stationlist.DabListRow;
import de.audi.tuner.app.storage.TunerStorage;
import de.audi.tuner.ifc.IPowerEvent;
import de.audi.tuner.ifc.IPrevNext;
import de.audi.tuner.ifc.IScanHandler;
import de.audi.tuner.ifc.ISearchBreak;
import de.audi.tuner.ifc.IStationListHandler;
import de.audi.tuner.ifc.IStoreStationHandler;
import de.audi.tuner.ifc.ITunerDABGUIHandler;
import de.audi.tuner.ifc.ITunerVariantExt;
import de.audi.tuner.ifc.listener.IUpdateListener;
import de.audi.tuner.ifc.listener.MessageListener;
import de.esolutions.fw.util.commons.SimpleIntIntMap;

public class GUIHandlerDAB
extends DefaultButtonListener
implements ITunerDABGUIHandler,
ChoiceListener {
    final IPrevNext prevNextHandler = new PrevNextHandler();
    private final DabFolderListHandler folderListHandler;
    private final DabFlatListHandler flatListHandler;
    private final DabCascadedListHandler cascadedListHandler;
    private final IStationListHandler stationList = new StationListHandler();
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
        this.models.getChoiceModel(100374).setChoiceListener(this);
        this.models.getChoiceModel(100528).setChoiceListener(this);
        this.models.getChoiceModel(100528).setStatus(Utilities.isEvoHigh() ? 1 : 0);
        this.models.getChoiceModel(100230).setChoiceListener(this);
        if (Utilities.isDABBand3AndLBandCoded()) {
            this.models.getChoiceModel(100230).setStatus(1);
        } else {
            this.models.getChoiceModel(100230).setStatus(0);
        }
        this.models.getChoiceModel(100375).setChoiceListener(this);
        this.models.getButtonModel(100380).setButtonListener(this);
        this.models.getChoiceModel(100490).setButtonListener(this);
        ButtonListener buttonListener = new ButtonListener();
        this.models.getButtonModel(100506).setButtonListener(buttonListener);
        this.models.getButtonModel(100505).setButtonListener(buttonListener);
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
            this.itemSelected(100375, nArray[2], 0, 0);
        }
    }

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
            this.itemSelected(100230, nArray[0], 0, 0);
            this.itemSelected(100374, nArray[1], 0, 0);
            this.itemSelected(100375, nArray[2], 0, 0);
            this.itemSelected(100528, nArray[3], 0, 0);
        } else {
            this.logger.main.log(10000, "[GUIHandlerDAB.initSetup] setup is null");
        }
    }

    public MessageListener getMessageListener() {
        return new MyMessageListener();
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        this.logger.hmi.log(10000000, "[GUIHandlerDAB.itemSelected] on model: %1 index %2 ", (long)n, (long)n2);
        this.logger.hmi.log(10000000, "[GUIHandlerDAB.itemSelected] on col %1 terminal %2 ", (long)n3, (long)n4);
        switch (n) {
            case 100374: {
                int n5;
                this.models.getChoiceModel(100374).setValue(n2);
                int n6 = n5 = n2 == 1 ? 3 : 2;
                if (n5 == 3 && this.models.getChoiceModel(100528).getValue() == 1) {
                    n5 = 7;
                }
                this.dabTuner.switchLinking(n5);
                break;
            }
            case 100528: {
                this.models.getChoiceModel(100528).setValue(n2);
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
                this.models.getChoiceModel(100375).setValue(n2);
                this.flatListHandler.setSortMode(n2);
                this.folderListHandler.setSortMode(n2);
                this.cascadedListHandler.setSortMode(n2);
                this.flatListHandler.propagateUpdatedStationList(5);
                this.setupHandler.valueUpdated(n2, 2);
                break;
            }
        }
    }

    public void keyTyped(int n, int n2, int n3) {
        switch (n) {
            case 100490: {
                this.dabTuner.forceStationListUpdate(true);
                this.models.getChoiceModel(n).setValue(1);
                this.models.getChoiceModel(n).fireEvent(n3);
                break;
            }
            case 100380: {
                if (this.models.getBaseListModel(100459).getLength() <= 0) break;
                this.models.getButtonModel(100380).fireEvent(n3);
                break;
            }
        }
    }

    public DabFolderListHandler getDabListHandler() {
        return this.folderListHandler;
    }

    public IStationListHandler getStationListHandler() {
        return this.stationList;
    }

    public boolean tuneById(long l, int n) {
        return this.folderListHandler.tuneById(l, n);
    }

    public TunerObjectContainer[] getStationList() {
        if (Utilities.isBentley()) {
            return this.folderListHandler.getStationList();
        }
        if (this.isSortModeAlphabetically()) {
            return this.flatListHandler.getStationList();
        }
        return this.folderListHandler.getStationList();
    }

    public TunerObjectContainer[] getStationListHierarchical() {
        return this.folderListHandler.getStationList();
    }

    public TunerObjectContainer[] getStationList(int n) {
        return this.getStationList();
    }

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
        return this.models.getChoiceModel(100375).getValue() == 0;
    }

    public void setSyncLinkState(DabReceptionStatus dabReceptionStatus) {
        this.folderListHandler.setSyncLinkState(dabReceptionStatus.syncStatus, dabReceptionStatus.linkStatus);
    }

    public IPowerEvent getPoPowerStateListener() {
        return new PowerEventListener();
    }

    private class ButtonListener
    extends DefaultButtonListener {
        private ButtonListener() {
        }

        public void keyTyped(int n, int n2, int n3) {
            switch (n) {
                case 100506: {
                    GUIHandlerDAB.this.dabTuner.seekStation(1, n3);
                    break;
                }
                case 100505: {
                    GUIHandlerDAB.this.dabTuner.seekStation(2, n3);
                    break;
                }
            }
        }

        public void keyLongTyped(int n, int n2, int n3) {
            switch (n) {
                case 100506: {
                    GUIHandlerDAB.this.dabTuner.seekStation(6, n3);
                    break;
                }
                case 100505: {
                    GUIHandlerDAB.this.dabTuner.seekStation(7, n3);
                    break;
                }
            }
        }
    }

    private class PrevNextHandler
    implements IPrevNext {
        private PrevNextHandler() {
        }

        public void handlePrevNext(boolean bl) {
            ((GUIHandlerDAB)GUIHandlerDAB.this).logger.dabDSI.log(1000000, "[GUIHandlerDAB.PrevNextHandler.handlePrevNext]SelectNextSevice, direction is up: %1 ", bl);
            DabListRow dabListRow = GUIHandlerDAB.this.isSortModeAlphabetically() ? GUIHandlerDAB.this.flatListHandler.getNextObjectIndexFromList(bl) : GUIHandlerDAB.this.folderListHandler.getNextObjectIndexFromList(bl);
            if (dabListRow != null) {
                GUIHandlerDAB.this.dabTuner.selectStation(dabListRow.getDabStation(), 0, 0);
            }
            if (!GUIHandlerDAB.this.drawerFocus.isDrawerOpen()) {
                GUIHandlerDAB.this.models.getMenuModel(100370).trigger(ModelTrigger.JOIN_CURSOR);
            }
        }
    }

    private class MyMessageListener
    extends MessageListener {
        private MyMessageListener() {
        }

        public void unitsChanged() {
            GUIHandlerDAB.this.dabTuner.setNotification(new int[]{29});
        }
    }

    private class PowerEventListener
    implements IPowerEvent {
        private PowerEventListener() {
        }

        public void notifyPowerEvent(int n, int n2) {
            if (n == 2) {
                SimpleIntIntMap simpleIntIntMap = GUIHandlerDAB.this.folderListHandler.getFolderStates();
                GUIHandlerDAB.this.storage.storeDABListLM(simpleIntIntMap);
                if (GUIHandlerDAB.this.dabTuner.isSeekActive()) {
                    GUIHandlerDAB.this.dabTuner.abortSeek();
                }
                if (GUIHandlerDAB.this.models.getChoiceModel(100490).getValue() == 1) {
                    GUIHandlerDAB.this.dabTuner.forceStationListUpdate(false);
                }
            }
        }
    }

    private class StationListHandler
    implements IStationListHandler {
        private StationListHandler() {
        }

        public void register(ISearchBreak iSearchBreak, int n) {
            throw new IllegalArgumentException();
        }

        public void register(IDrawerFocusManager iDrawerFocusManager) {
            GUIHandlerDAB.this.drawerFocus = iDrawerFocusManager;
        }

        public boolean tuneById(long l, int n) {
            return GUIHandlerDAB.this.folderListHandler.tuneById(l, n);
        }

        public void addUpdateListener(IUpdateListener iUpdateListener) {
            GUIHandlerDAB.this.folderListHandler.addUpdateListener(iUpdateListener);
        }

        public void setPrefImgType(int n) {
            GUIHandlerDAB.this.flatListHandler.setPrefImgType(n);
            GUIHandlerDAB.this.folderListHandler.setPrefImgType(n);
            GUIHandlerDAB.this.cascadedListHandler.setPrefImgType(n);
            GUIHandlerDAB.this.labels.setPrefImgType(n);
        }

        public boolean isEnsemble(int n) {
            DabListRow dabListRow;
            if (GUIHandlerDAB.this.isSortModeAlphabetically()) {
                return false;
            }
            return n < GUIHandlerDAB.this.models.getBaseListModel(100491).getLength() && (dabListRow = (DabListRow)GUIHandlerDAB.this.models.getBaseListModel(100491).getRow(n)).isEnsemble();
        }
    }
}

