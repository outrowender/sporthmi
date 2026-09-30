/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.hmi.model.update.ModelTrigger;
import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.DrawerFocusManager;
import de.audi.tuner.app.IDrawerFocusManager;
import de.audi.tuner.app.IStoreHandler;
import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.RadioBaseListModelListener;
import de.audi.tuner.app.RadioMenuModelListener;
import de.audi.tuner.app.RadioObjectIds;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.epg.sdars.ChoiceModifyingEPGAvailibilityCallback;
import de.audi.tuner.app.epg.sdars.IEPGAvailibiltyCallback;
import de.audi.tuner.app.epg.sdars.SDARSEPGHandler;
import de.audi.tuner.app.sdars.CategoryFilter;
import de.audi.tuner.app.sdars.CategoryFilterRow;
import de.audi.tuner.app.sdars.CategoryInfoExt;
import de.audi.tuner.app.sdars.PdtListener;
import de.audi.tuner.app.sdars.SDARSListRow;
import de.audi.tuner.app.sdars.SDARSTuner;
import de.audi.tuner.app.sdars.SdarsRadioText;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.dsi.SDARSDsiDownInfo;
import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;
import de.audi.tuner.app.sdars.seek.AddToSeeksPossibilityEnum;
import de.audi.tuner.app.sdars.sortandindex.station.AbstractIStationInfoComparatorAndIndexer;
import de.audi.tuner.app.sdars.sortandindex.station.SortAlgoCatAndName;
import de.audi.tuner.app.sdars.sortandindex.station.SortAlgoCatAndStNumber;
import de.audi.tuner.app.sdars.sortandindex.station.SortAlgoName;
import de.audi.tuner.app.sdars.sortandindex.station.SortAlgoStNumber;
import de.audi.tuner.app.sortandindex.AlphabeticalIndexRow;
import de.audi.tuner.app.storage.TunerStorage;
import de.audi.tuner.ifc.AbstractListRowFactory;
import de.audi.tuner.ifc.AbstractRadioListRow;
import de.audi.tuner.ifc.IListResourceProvider;
import de.audi.tuner.ifc.IPrevNext;
import de.audi.tuner.ifc.IScanHandler;
import de.audi.tuner.ifc.ISearchBreak;
import de.audi.tuner.ifc.IStationListHandler;
import de.audi.tuner.ifc.IStoreStationHandler;
import de.audi.tuner.sds.UpdateListenerHandler;
import de.esolutions.fw.util.commons.SimpleIntIntMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.sdars.CategoryInfo;
import org.dsi.ifc.sdars.SeekPossibility;

public class SDARSStationListHandler
extends UpdateListenerHandler
implements IStationListHandler,
IListResourceProvider {
    final SDARSDsiUpInfo dsiUpInfo = new DsiUpListener();
    final SDARSDsiDownInfo dsiDownInfo = new DsiDownListener();
    final IPrevNext prevNextHandler = new PrevNextHandler();
    public static final int ALGO_ST_NUMBER = 0;
    public static final int ALGO_ST_NAME = 1;
    public static final int ALGO_CAT_STNUM = 2;
    public static final int ALGO_CAT_STNAM = 3;
    private boolean noSignalActive = false;
    private int activeSortAlgo = 0;
    private CategoryInfoExt[] currentCategoryList = new CategoryInfoExt[0];
    private Object catListMutex = new Object();
    private final SDARSTuner sdarsTuner;
    private final Logger logger;
    private final TunerModels models;
    private final BaseListModelApp listModel;
    private final MenuModelApp menuModel;
    private final AbstractListRowFactory rowFactory;
    private final MenuModelListener menuModelListener;
    private final PdtListener pdtListener;
    private final IStoreHandler storeHandler;
    private final SDARSEPGHandler epgHandler;
    private final Object mutex = new Object();
    private final LanguageManager langMngr;
    private final IScanHandler scanHandler;
    private StationInfoExt activeStation;
    private StationInfoExt[] stationList = new StationInfoExt[0];
    private final CategoryFilter catFilter;
    private volatile int registeredSid = -1;
    private IStoreStationHandler longPressHandler;
    private final IEPGAvailibiltyCallback epgAvailibilityCallback;
    private int imgType;
    private SeekPossibility lastReceivedSeekPossibility = new SeekPossibility(-1, -1, null, null);
    private IDrawerFocusManager drawerFocus = DrawerFocusManager.NULL_DRAWER_FOCUS_MANAGER;
    public boolean focusSet;

    public SDARSStationListHandler(SDARSTuner sDARSTuner, TunerBasics tunerBasics, IStoreHandler iStoreHandler, LanguageManager languageManager, AbstractListRowFactory abstractListRowFactory, IScanHandler iScanHandler, TunerStorage tunerStorage) {
        this.langMngr = languageManager;
        this.sdarsTuner = sDARSTuner;
        this.logger = tunerBasics.getLogger();
        this.models = tunerBasics.getModels();
        this.storeHandler = iStoreHandler;
        this.catFilter = new CategoryFilter(tunerBasics, languageManager, this, tunerStorage);
        this.epgHandler = sDARSTuner.getSdarsEpgHandler();
        this.epgAvailibilityCallback = ChoiceModifyingEPGAvailibilityCallback.forSdarsFocussedChannelEPGAvailibilityChoice(this.models);
        this.menuModel = this.models.getMenuModel(100568);
        this.menuModelListener = new MenuModelListener(tunerBasics, new int[]{100568});
        this.listModel = this.models.getBaseListModel(100471);
        ListListener listListener = new ListListener(this.models, 100568);
        this.listModel.setListener(listListener);
        this.models.getBaseListModel(100479).setListener(listListener);
        this.rowFactory = abstractListRowFactory;
        this.scanHandler = iScanHandler;
        this.imgType = tunerStorage.loadPreferredImageType();
        this.pdtListener = new PdtListener(this, this.listModel, this.mutex, this.imgType);
        this.activeStation = tunerStorage.loadLastSDARSStation();
    }

    void register(IStoreStationHandler iStoreStationHandler) {
        this.longPressHandler = iStoreStationHandler;
    }

    public void register(ISearchBreak iSearchBreak, int n) {
        this.menuModelListener.register(iSearchBreak, n);
    }

    public void register(IDrawerFocusManager iDrawerFocusManager) {
        this.drawerFocus = iDrawerFocusManager;
    }

    public boolean isListBlocked() {
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setSdarsCategoryList(CategoryInfoExt[] categoryInfoExtArray) {
        Object object = this.catListMutex;
        synchronized (object) {
            this.currentCategoryList = categoryInfoExtArray;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public CategoryInfo[] getSdarsCategoryList() {
        Object object = this.catListMutex;
        synchronized (object) {
            return this.currentCategoryList;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void doUpdateStationList() {
        Object object = this.mutex;
        synchronized (object) {
            List list = this.formatSdarsStationList(this.stationList);
            List list2 = this.getActiveSortAlgo().sortAndProvideAlphabeticalIndexRowsFor(list);
            BaseListModelApp baseListModelApp = this.listModel.getEmptyCopy();
            baseListModelApp.append((SDARSListRow[])list.toArray(new SDARSListRow[list.size()]));
            baseListModelApp.setSelectedUniqueID(RadioObjectIds.getSDARSObjectId(this.activeStation.sID));
            this.listModel.update(baseListModelApp);
            BaseListModelApp baseListModelApp2 = this.models.getBaseListModel(100915);
            BaseListModelApp baseListModelApp3 = baseListModelApp2.getEmptyCopy();
            baseListModelApp3.append((AlphabeticalIndexRow[])list2.toArray(new AlphabeticalIndexRow[list2.size()]));
            baseListModelApp2.update(baseListModelApp3);
            this.setSeekPossibility(this.lastReceivedSeekPossibility);
        }
        this.propagateUpdatedStationList(7);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private AbstractIStationInfoComparatorAndIndexer getActiveSortAlgo() {
        Object object = this.mutex;
        synchronized (object) {
            switch (this.activeSortAlgo) {
                case 1: {
                    return new SortAlgoName(this.langMngr);
                }
                case 0: {
                    return new SortAlgoStNumber(this.langMngr);
                }
                case 3: {
                    return new SortAlgoCatAndName(this.langMngr);
                }
                case 2: {
                    return new SortAlgoCatAndStNumber(this.langMngr);
                }
            }
            this.activeSortAlgo = 1;
            return new SortAlgoName(this.langMngr);
        }
    }

    public void setSortAlgo(int n) {
        if (this.activeSortAlgo != n) {
            this.activeSortAlgo = n;
            this.doUpdateStationList();
        }
    }

    private StationInfoExt getNextServiceFromList(boolean bl, boolean bl2) {
        int n;
        int n2 = this.listModel.getSelected().getIndex();
        StationInfoExt stationInfoExt = null;
        int n3 = n = this.listModel.getLength();
        boolean bl3 = false;
        while (n3 > 0 && !bl3) {
            --n3;
            n2 = bl ? (n2 == n - 1 ? 0 : ++n2) : (n2 == 0 ? n - 1 : --n2);
            stationInfoExt = ((SDARSListRow)this.listModel.getRow(n2)).getStation();
            if (bl2 && stationInfoExt.subscription != 2) {
                stationInfoExt = null;
            }
            bl3 = stationInfoExt != null;
        }
        return stationInfoExt;
    }

    public List formatSdarsStationList(StationInfoExt[] stationInfoExtArray) {
        SdarsRadioText sdarsRadioText = this.pdtListener.getActualPdt();
        int n = sdarsRadioText != null ? (int)sdarsRadioText.sID : -1;
        this.logger.hmi.log(10000000, "formatSdarsStationList");
        SimpleIntIntMap simpleIntIntMap = this.catFilter.getFilterStates();
        boolean bl = this.catFilter.isShowAllCategoriesChecked();
        ArrayList arrayList = new ArrayList(stationInfoExtArray.length);
        boolean bl2 = false;
        for (int i2 = 0; i2 < stationInfoExtArray.length; ++i2) {
            if (!this.isStationOkForStationList(stationInfoExtArray[i2])) continue;
            SDARSListRow sDARSListRow = null;
            int n2 = simpleIntIntMap.get(stationInfoExtArray[i2].categoryNumber);
            if (!bl2 && stationInfoExtArray[i2].sID == this.activeStation.sID) {
                sDARSListRow = n2 == 1 || bl ? this.rowFactory.getSdarsListRow(this.activeStation, false, this.noSignalActive) : this.rowFactory.getSdarsListRow(this.activeStation, true, this.noSignalActive);
                sDARSListRow.setStationActive(true);
                bl2 = true;
            } else if (n2 == 1 || bl) {
                sDARSListRow = this.rowFactory.getSdarsListRow(stationInfoExtArray[i2], false, this.noSignalActive);
            }
            if (sDARSListRow == null) continue;
            if (sDARSListRow.getStation().sID == n && sdarsRadioText != null) {
                sDARSListRow.setProgramData(sdarsRadioText, this.imgType);
            }
            arrayList.add(sDARSListRow);
        }
        if (!bl2) {
            SDARSListRow sDARSListRow = this.rowFactory.getSdarsListRow(this.activeStation, true, this.noSignalActive);
            sDARSListRow.setStationActive(true);
            if (this.activeStation.sID == n && sdarsRadioText != null) {
                sDARSListRow.setProgramData(sdarsRadioText, this.imgType);
            }
            arrayList.add(sDARSListRow);
        }
        return arrayList;
    }

    protected boolean isStationOkForStationList(StationInfoExt stationInfoExt) {
        return stationInfoExt.stationNumber != 0;
    }

    public boolean isCatFilterActive() {
        return this.models.getChoiceModel(100150).getValue() == 0;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setNoSignal(boolean bl) {
        this.noSignalActive = bl;
        this.logger.sdarsDSI.log(10000000, "setNoSignal: %1 ", this.noSignalActive);
        Object object = this.mutex;
        synchronized (object) {
            if (bl) {
                BaseListModelApp baseListModelApp = this.listModel.getCopy();
                int n = this.listModel.getLength();
                for (int i2 = 0; i2 < n; ++i2) {
                    SDARSListRow sDARSListRow = (SDARSListRow)baseListModelApp.getRow(i2);
                    sDARSListRow.setNoSignal(bl);
                    baseListModelApp.setRow(i2, sDARSListRow);
                }
                baseListModelApp.setSelectedUniqueID(this.listModel.getSelected().getUniqueID());
                this.listModel.update(baseListModelApp);
            } else {
                this.doUpdateStationList();
            }
        }
        this.propagateUpdatedMuteStatus(7, this.noSignalActive);
    }

    public boolean tuneById(long l, int n) {
        this.logger.combi.log(10000000, "[SDARSStationListHandler#tuneById] radioId: %1", l);
        TunerObjectContainer tunerObjectContainer = new RadioObjectIds((long)l, (LogChannel)this.logger.combi).toc;
        int n2 = this.getIndexBySID(tunerObjectContainer.getSDARSService().sID);
        if (n2 == -1) {
            this.logger.combi.log(10000, "[SDARSStationListHandler#tuneById] STATION NOT FOUND: sID %1", l);
            return false;
        }
        StationInfoExt stationInfoExt = ((SDARSListRow)this.listModel.getRow(n2)).getStation();
        if (stationInfoExt.subscription == 2) {
            this.sdarsTuner.selectStation(stationInfoExt, 0);
            return true;
        }
        return false;
    }

    public TunerObjectContainer[] getStationList() {
        BaseListModelApp baseListModelApp = this.listModel.getCopy();
        TunerObjectContainer[] tunerObjectContainerArray = new TunerObjectContainer[baseListModelApp.getLength()];
        for (int i2 = 0; i2 < baseListModelApp.getLength(); ++i2) {
            tunerObjectContainerArray[i2] = ((SDARSListRow)baseListModelApp.getRow(i2)).getTOContainer();
        }
        return tunerObjectContainerArray;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private int getIndexBySID(int n) {
        Object object = this.mutex;
        synchronized (object) {
            int n2 = this.listModel.getLength();
            for (int i2 = 0; i2 < n2; ++i2) {
                if (((SDARSListRow)this.listModel.getRow((int)i2)).getStation().sID != n) continue;
                return i2;
            }
        }
        return -1;
    }

    public void setPrefImgType(int n) {
        this.pdtListener.setPrefImgType(n);
        this.imgType = n;
        this.doUpdateStationList();
    }

    public boolean isEnsemble(int n) {
        return false;
    }

    void catFilterChanged() {
        this.doUpdateStationList();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void highlight(StationInfoExt stationInfoExt) {
        Object object;
        int n;
        this.activeStation = stationInfoExt;
        int n2 = this.listModel.getIndexForUniqueID(RadioObjectIds.getSDARSObjectId(this.activeStation.sID));
        if (n2 == -1) {
            this.doUpdateStationList();
            return;
        }
        SelectedItem selectedItem = this.listModel.getSelected();
        int n3 = n = selectedItem == null ? -1 : selectedItem.getIndex();
        if (n != -1 && n != n2) {
            object = this.mutex;
            synchronized (object) {
                SDARSListRow sDARSListRow = (SDARSListRow)this.listModel.getRow(n);
                sDARSListRow.resetPdt();
                sDARSListRow.setStationActive(false);
                if (sDARSListRow.isTmpAdded()) {
                    this.doUpdateStationList();
                    return;
                }
                this.listModel.setRow(n, sDARSListRow);
            }
        }
        object = this.mutex;
        synchronized (object) {
            boolean bl = ((SDARSListRow)this.listModel.getRow(n2)).isTmpAdded();
            SDARSListRow sDARSListRow = this.rowFactory.getSdarsListRow(stationInfoExt, bl, this.noSignalActive);
            sDARSListRow.setStationActive(true);
            SdarsRadioText sdarsRadioText = this.pdtListener.getActualPdt();
            if (sdarsRadioText != null && sdarsRadioText.sID == stationInfoExt.sID) {
                sDARSListRow.setProgramData(sdarsRadioText, this.imgType);
            }
            if (stationInfoExt.sID == this.lastReceivedSeekPossibility.sID) {
                AddToSeeksPossibilityEnum.setSeekDependingModelsAndProperties(stationInfoExt.sID, this.lastReceivedSeekPossibility, sdarsRadioText, sDARSListRow, this.models);
            }
            this.listModel.setRow(n2, sDARSListRow);
            this.listModel.setSelectedIndex(n2);
        }
        this.logger.sdarsList.log(100000000, "[SDARSSLH.highlight] old %1 new %2", (long)n, (long)n2);
    }

    private void orderPdt(int n) {
        if (n != -1) {
            if (this.registeredSid != -1) {
                this.sdarsTuner.getPdtHandler().removeListener(this.registeredSid, this.pdtListener);
            }
            this.registeredSid = n;
            this.sdarsTuner.getPdtHandler().addListener(n, this.pdtListener, 0);
        } else {
            this.sdarsTuner.getPdtHandler().removeListener(this.registeredSid, this.pdtListener);
            this.registeredSid = -1;
        }
    }

    public long getFocussedItemUniqueId() {
        return 0L;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setSeekPossibility(SeekPossibility seekPossibility) {
        long l;
        Object object = this.mutex;
        synchronized (object) {
            this.lastReceivedSeekPossibility = seekPossibility;
        }
        object = this.listModel.getSelected();
        if (object != null && (l = (long)RadioObjectIds.getSDARSsId(((SelectedItem)object).getUniqueID())) == (long)seekPossibility.sID) {
            SDARSListRow sDARSListRow = (SDARSListRow)this.listModel.getRow(((SelectedItem)object).getIndex());
            AddToSeeksPossibilityEnum.setSeekDependingModelsAndProperties(l, this.lastReceivedSeekPossibility, this.pdtListener.getActualPdt(), sDARSListRow, this.models);
            this.listModel.setRow(((SelectedItem)object).getIndex(), sDARSListRow);
        }
    }

    public void resetToDefaultSettings() {
        this.catFilter.resetToDefaultSettings();
    }

    public CategoryFilter getCategoryListHandler() {
        return this.catFilter;
    }

    static /* synthetic */ StationInfoExt[] access$502(SDARSStationListHandler sDARSStationListHandler, StationInfoExt[] stationInfoExtArray) {
        sDARSStationListHandler.stationList = stationInfoExtArray;
        return stationInfoExtArray;
    }

    private class ListListener
    extends RadioBaseListModelListener {
        public ListListener(TunerModels tunerModels, int n) {
            super(tunerModels, n);
        }

        public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            switch (n) {
                case 100471: {
                    if (SDARSStationListHandler.this.storeHandler.isStoreModeActive()) {
                        SDARSStationListHandler.this.storeHandler.store((AbstractRadioListRow)evoListRow);
                        SDARSStationListHandler.this.listModel.fireEvent(n4);
                        return;
                    }
                    SDARSStationListHandler.this.scanHandler.abortScan();
                    if (!this.isNewSelection(evoListRow, n, n2, n3, n4)) break;
                    StationInfoExt stationInfoExt = ((SDARSListRow)evoListRow).getStation();
                    if (stationInfoExt.subscription != 2) {
                        if (SDARSStationListHandler.this.sdarsTuner.isEntertainmentDrawerOpened()) {
                            return;
                        }
                        SDARSStationListHandler.this.models.getLabelModel(100632).setText(stationInfoExt.fullLabel);
                        SDARSStationListHandler.this.sdarsTuner.getAdvisoryHandler().requestAdvisory(3);
                        break;
                    }
                    SDARSStationListHandler.this.sdarsTuner.selectStation(stationInfoExt, n4);
                    break;
                }
                case 100479: {
                    int n5 = ((CategoryFilterRow)evoListRow).getCategory();
                    List list = SDARSStationListHandler.this.listModel.asList();
                    Iterator iterator = list.iterator();
                    while (iterator.hasNext()) {
                        SDARSListRow sDARSListRow = (SDARSListRow)iterator.next();
                        StationInfoExt stationInfoExt = sDARSListRow.getStation();
                        if (stationInfoExt.categoryNumber != n5 || stationInfoExt.subscription != 2) continue;
                        SDARSStationListHandler.this.sdarsTuner.selectStation(stationInfoExt, n4);
                        MenuModelApp menuModelApp = SDARSStationListHandler.this.models.getMenuModel(100568);
                        menuModelApp.setFocusedItem(100471, FocusAdvice.VIEWPORT_FIRST_POSITION, sDARSListRow.getUniqueID());
                        SDARSStationListHandler.this.focusSet = true;
                        SDARSStationListHandler.this.models.getBaseListModel(100479).fireEvent(n4);
                        return;
                    }
                    break;
                }
            }
        }

        public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            SDARSStationListHandler.this.scanHandler.abortScan();
            if (SDARSStationListHandler.this.listModel.getSelected().getIndex() != n2) {
                int n5 = ((SDARSListRow)evoListRow).getStation().getSubscription();
                if (n5 != 2) {
                    SDARSStationListHandler.this.sdarsTuner.getAdvisoryHandler().requestAdvisory(3);
                } else {
                    StationInfoExt stationInfoExt = ((SDARSListRow)evoListRow).getStation();
                    SDARSStationListHandler.this.sdarsTuner.selectStation(stationInfoExt, n4);
                }
            }
            if (SDARSStationListHandler.this.longPressHandler != null) {
                SDARSStationListHandler.this.longPressHandler.prepareStore(n4, ((AbstractRadioListRow)evoListRow).getTOContainer());
            }
        }

        public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            StationInfoExt stationInfoExt = ((SDARSListRow)evoListRow).getStation();
            SDARSStationListHandler.this.orderPdt(stationInfoExt.sID);
            boolean bl = SDARSStationListHandler.this.epgHandler.isEPGAvailableFor(stationInfoExt, SDARSStationListHandler.this.epgAvailibilityCallback);
            SDARSStationListHandler.this.epgAvailibilityCallback.epgAvailibiltyChanged(stationInfoExt, bl);
        }
    }

    private class DsiUpListener
    extends SDARSDsiUpInfo {
        private DsiUpListener() {
        }

        public void updateSelectedStation(StationInfoExt stationInfoExt) {
            SDARSStationListHandler.this.highlight(stationInfoExt);
        }

        public void updateStationList(StationInfoExt[] stationInfoExtArray) {
            ((SDARSStationListHandler)SDARSStationListHandler.this).catFilter.dsiUpInfo.updateStationList(stationInfoExtArray);
            SDARSStationListHandler.access$502(SDARSStationListHandler.this, stationInfoExtArray);
            SDARSStationListHandler.this.doUpdateStationList();
        }

        public void updateCategoryList(CategoryInfoExt[] categoryInfoExtArray) {
            ((SDARSStationListHandler)SDARSStationListHandler.this).catFilter.dsiUpInfo.updateCategoryList(categoryInfoExtArray);
            SDARSStationListHandler.this.setSdarsCategoryList(categoryInfoExtArray);
        }

        public void updateSeekPossibility(SeekPossibility seekPossibility) {
            SDARSStationListHandler.this.setSeekPossibility(seekPossibility);
        }

        public void updateSignalStatus(boolean bl) {
            SDARSStationListHandler.this.setNoSignal(bl);
        }
    }

    private class DsiDownListener
    extends SDARSDsiDownInfo {
        private DsiDownListener() {
        }

        public void preTuneAction(StationInfoExt stationInfoExt) {
            SDARSStationListHandler.this.highlight(stationInfoExt);
        }
    }

    private class PrevNextHandler
    implements IPrevNext {
        private PrevNextHandler() {
        }

        public void handlePrevNext(boolean bl) {
            StationInfoExt stationInfoExt = SDARSStationListHandler.this.getNextServiceFromList(bl, true);
            if (stationInfoExt != null) {
                SDARSStationListHandler.this.sdarsTuner.selectStation(stationInfoExt, 0);
                if (!SDARSStationListHandler.this.drawerFocus.isDrawerOpen()) {
                    SDARSStationListHandler.this.menuModel.trigger(ModelTrigger.JOIN_CURSOR);
                }
            }
        }
    }

    private class MenuModelListener
    extends RadioMenuModelListener {
        private boolean cursorIsAt000;

        public MenuModelListener(TunerBasics tunerBasics, int[] nArray) {
            super(tunerBasics, nArray);
            this.cursorIsAt000 = false;
            SDARSStationListHandler.this.models.getChoiceModel(100227).setButtonListener(new ButtonListener());
        }

        public void itemFocused(int n, int n2, long l, int n3) {
            super.itemFocused(n, n2, l, n3);
            if (n2 == 100568) {
                boolean bl = this.cursorIsAt000 = n == 1;
                if (SDARSStationListHandler.this.focusSet) {
                    SDARSStationListHandler.this.models.getMenuModel(100568).resetFocusedItem();
                    SDARSStationListHandler.this.focusSet = false;
                }
            }
            if (n != 100471) {
                SDARSStationListHandler.this.orderPdt(-1);
            }
        }

        private class ButtonListener
        extends DefaultButtonListener {
            private ButtonListener() {
            }

            public void keyTyped(int n, int n2, int n3) {
                if (MenuModelListener.this.cursorIsAt000) {
                    SDARSStationListHandler.this.models.getChoiceModel(n).fireEvent(n3);
                } else {
                    SDARSStationListHandler.this.models.getMenuModel(100568).setFocusedItem(1, FocusAdvice.KEEP_POSITION, 1L);
                    ((MenuModelListener)MenuModelListener.this).SDARSStationListHandler.this.focusSet = true;
                }
            }
        }
    }
}

