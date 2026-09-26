/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.uni;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.DrawerFocusManager;
import de.audi.tuner.app.IDrawerFocusManager;
import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.RadioComparators;
import de.audi.tuner.app.RadioObjectIds;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.TunerProxyManager;
import de.audi.tuner.app.storage.TunerStorage;
import de.audi.tuner.app.uni.UniDsiDownInfo;
import de.audi.tuner.app.uni.UniDsiUpInfo;
import de.audi.tuner.app.uni.UniListRow;
import de.audi.tuner.app.uni.UniStationList$CompServiceLookup;
import de.audi.tuner.app.uni.UniStationList$ListListener;
import de.audi.tuner.app.uni.UniStationList$PrevNextHandler;
import de.audi.tuner.app.uni.UniStationList$TimerListener;
import de.audi.tuner.app.uni.UniStationList$UniDownListener;
import de.audi.tuner.app.uni.UniStationList$UniUpListener;
import de.audi.tuner.app.uni.UnifiedListComparator;
import de.audi.tuner.app.uni.UnifiedStationExt;
import de.audi.tuner.app.uni.UnifiedTuner;
import de.audi.tuner.ifc.AbstractListRowFactory;
import de.audi.tuner.ifc.AbstractRadioListRow;
import de.audi.tuner.ifc.IPrevNext;
import de.audi.tuner.ifc.ISearchBreak;
import de.audi.tuner.ifc.IStationListHandler;
import de.audi.tuner.sds.UpdateListenerHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class UniStationList
extends UpdateListenerHandler
implements IStationListHandler {
    final UniDsiUpInfo dsiUpListener = new UniStationList$UniUpListener(this, null);
    final UniDsiDownInfo dsiDownListener = new UniStationList$UniDownListener(this, null);
    final IPrevNext prevNextHandler = new UniStationList$PrevNextHandler(this, null);
    private static final int REASON_NONE;
    private static final int REASON_NEW_STATION;
    private static final int REASON_RESORTING;
    private static final int REASON_PROGRAM_CHANGED;
    private static final int REASON_RADIOTEXT_CHANGED;
    private static final int REASON_SLIDESHOW_CHANGED;
    private static final int AREA_FIX_NAME;
    private static final int AREA_SCROLLING;
    private static final int AREA_FREQUENCY;
    private final Logger logger;
    private final BaseListModelApp listModel;
    private final MenuModelApp menuModel;
    private final AbstractListRowFactory rowFactory;
    private final UnifiedTuner tuner;
    private final List listArray = new ArrayList(200);
    private UnifiedStationExt tmpAddedStation = null;
    private UnifiedStationExt tmpAddedFocussedStation = null;
    private UniListRow focussedRow = null;
    private UnifiedStationExt activeStation = null;
    private Comparator comparator;
    private UnifiedStationExt[] lastList = new UnifiedStationExt[0];
    private final Timer timerTmp;
    private final Timer timerFocus;
    private int imgType;
    private final TunerStorage storage;
    private IDrawerFocusManager drawerFocus = DrawerFocusManager.NULL_DRAWER_FOCUS_MANAGER;

    UniStationList(TunerBasics tunerBasics, UnifiedTuner unifiedTuner, AbstractListRowFactory abstractListRowFactory, LanguageManager languageManager, TunerStorage tunerStorage) {
        this.logger = tunerBasics.getLogger();
        this.storage = tunerStorage;
        TunerModels tunerModels = tunerBasics.getModels();
        this.rowFactory = abstractListRowFactory;
        this.tuner = unifiedTuner;
        this.activeStation = new UnifiedStationExt();
        this.listModel = tunerModels.getBaseListModel(-813235968);
        this.menuModel = tunerModels.getMenuModel(-695795456);
        UniStationList$ListListener uniStationList$ListListener = new UniStationList$ListListener(this, tunerModels, -695795456);
        this.listModel.setListener(uniStationList$ListListener);
        tunerModels.getMenuModel(-695795456).setListener(uniStationList$ListListener);
        this.comparator = new UnifiedListComparator(languageManager, new UniStationList$CompServiceLookup(this));
        UniStationList$TimerListener uniStationList$TimerListener = new UniStationList$TimerListener(this, null);
        this.timerTmp = new Timer("timerTmp", 0, true, uniStationList$TimerListener);
        this.timerFocus = new Timer("timerFocus", 0, true, uniStationList$TimerListener);
        this.imgType = tunerStorage.loadPreferredImageType();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void init() {
        List list = this.listArray;
        synchronized (list) {
            this.highlight(this.storage.loadLastUnifiedStation());
        }
    }

    @Override
    public void register(ISearchBreak iSearchBreak, int n) {
        throw new IllegalArgumentException();
    }

    @Override
    public void register(IDrawerFocusManager iDrawerFocusManager) {
        this.drawerFocus = iDrawerFocusManager;
    }

    private boolean containsListActiveService() {
        UnifiedStationExt unifiedStationExt = this.activeStation.getPrimaryService();
        if (unifiedStationExt == null) {
            return false;
        }
        for (int i2 = 0; i2 < this.lastList.length; ++i2) {
            if (this.lastList[i2].piSId != unifiedStationExt.piSId || this.lastList[i2].ensId != unifiedStationExt.ensId || this.lastList[i2].ecc != unifiedStationExt.ecc) continue;
            return true;
        }
        return false;
    }

    private boolean containsListActiveComponent() {
        UnifiedStationExt unifiedStationExt = this.activeStation;
        if (unifiedStationExt == null) {
            return false;
        }
        for (int i2 = 0; i2 < this.lastList.length; ++i2) {
            if (!UnifiedStationExt.equals(this.activeStation, this.lastList[i2])) continue;
            return true;
        }
        return false;
    }

    private UnifiedStationExt[] addItemToList(UnifiedStationExt unifiedStationExt, UnifiedStationExt[] unifiedStationExtArray) {
        UnifiedStationExt[] unifiedStationExtArray2 = new UnifiedStationExt[unifiedStationExtArray.length + 1];
        System.arraycopy((Object)unifiedStationExtArray, 0, (Object)unifiedStationExtArray2, 0, unifiedStationExtArray.length);
        unifiedStationExtArray2[unifiedStationExtArray.length] = unifiedStationExt;
        return unifiedStationExtArray2;
    }

    private void addActiveStationToList() {
        UnifiedStationExt unifiedStationExt;
        if (this.activeStation == null) {
            return;
        }
        if (this.activeStation.hasPrimaryService() && !this.containsListActiveService() && (unifiedStationExt = this.activeStation.getPrimaryService()) != null) {
            this.lastList = this.addItemToList(unifiedStationExt, this.lastList);
        }
        if (!this.containsListActiveComponent()) {
            unifiedStationExt = this.activeStation;
            this.lastList = this.addItemToList(unifiedStationExt, this.lastList);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void doListUpdate() {
        List list = this.listArray;
        synchronized (list) {
            this.addActiveStationToList();
            boolean bl = false;
            this.listArray.clear();
            UnifiedStationExt unifiedStationExt = null;
            if (this.focussedRow != null) {
                long l;
                SelectedItem selectedItem = this.listModel.getSelected();
                long l2 = l = selectedItem != null ? selectedItem.getUniqueID() : -1L;
                if (this.focussedRow.getUniqueID() != l) {
                    unifiedStationExt = this.focussedRow.getStation();
                }
            }
            boolean bl2 = unifiedStationExt == null;
            for (int i2 = 0; i2 < this.lastList.length; ++i2) {
                block16: {
                    if (UnifiedStationExt.equals(this.lastList[i2], this.tmpAddedFocussedStation)) {
                        this.tmpAddedFocussedStation = null;
                    }
                    if (UnifiedStationExt.equals(this.lastList[i2], this.tmpAddedStation)) {
                        this.tmpAddedStation = null;
                    }
                    if (UnifiedStationExt.equals(this.lastList[i2], this.activeStation)) {
                        if (!bl) {
                            bl = true;
                            UniListRow uniListRow = this.rowFactory.getUniListRow(this.activeStation, false, this.imgType);
                            uniListRow.setStationActive(true);
                            this.listArray.add(uniListRow);
                            this.logger.uniList.log(14808325, "[UniStationList.doListUpdate] active station has index %1", (long)i2);
                            break block16;
                        } else {
                            this.logger.uniList.log(10000, "[UniStationList.doListUpdate] active station already added -> ignore %1", (Object)this.lastList[i2]);
                            continue;
                        }
                    }
                    this.listArray.add(this.rowFactory.getUniListRow(this.lastList[i2], false, this.imgType));
                }
                if (!UnifiedStationExt.equals(this.lastList[i2], unifiedStationExt)) continue;
                bl2 = true;
            }
            if (!bl) {
                this.logger.uniList.log(14808325, "[UniStationList.doListUpdate] active not included %1", (Object)this.activeStation);
                this.tmpAddedStation = null;
                if (this.activeStation.hasPrimaryService()) {
                    UniListRow uniListRow = this.rowFactory.getUniListRow(this.activeStation.getPrimaryService(), true, this.imgType);
                    this.listArray.add(uniListRow);
                }
                UniListRow uniListRow = this.rowFactory.getUniListRow(this.activeStation, true, this.imgType);
                uniListRow.setStationActive(true);
                this.listArray.add(uniListRow);
            }
            if (this.tmpAddedStation != null) {
                this.logger.uniList.log(14808325, "[UniStationList.doListUpdate] add tmpAddedStation %1", (Object)this.tmpAddedStation);
                if (this.tmpAddedStation.hasPrimaryService()) {
                    this.listArray.add(this.rowFactory.getUniListRow(this.tmpAddedStation.getPrimaryService(), true, this.imgType));
                }
                this.listArray.add(this.rowFactory.getUniListRow(this.tmpAddedStation, true, this.imgType));
            }
            if (!bl2 && !UnifiedStationExt.equals(this.activeStation, unifiedStationExt)) {
                this.tmpAddedFocussedStation = unifiedStationExt;
                this.timerFocus.restart();
            }
            if (this.tmpAddedFocussedStation != null) {
                this.logger.uniList.log(14808325, "[UniStationList.doListUpdate] add focused row %1", (Object)this.focussedRow);
                this.listArray.add(this.focussedRow);
            }
            Collections.sort(this.listArray, this.comparator);
            this.setSeparatorLines();
            BaseListModelApp baseListModelApp = this.listModel.getEmptyCopy();
            baseListModelApp.append((EvoListRow[])this.listArray.toArray(new EvoListRow[this.listArray.size()]));
            baseListModelApp.setSelectedUniqueID(this.activeStation.getUniqueId());
            this.listModel.update(baseListModelApp);
        }
        this.propagateUpdatedStationList(11);
    }

    private void setSeparatorLines() {
        UniListRow uniListRow = (UniListRow)this.listArray.get(0);
        int n = this.getArea(uniListRow.getStation());
        for (int i2 = 1; i2 < this.listArray.size(); ++i2) {
            uniListRow = (UniListRow)this.listArray.get(i2);
            int n2 = this.getArea(uniListRow.getStation());
            if (n2 != n) {
                uniListRow.setSeparatorLine(true);
                ((UniListRow)this.listArray.get(i2 - 1)).setSeparatorLine(false);
            }
            n = n2;
        }
    }

    private int getArea(UnifiedStationExt unifiedStationExt) {
        if (unifiedStationExt.longName.length() == 0 && unifiedStationExt.shortName.length() == 0) {
            return 2;
        }
        if (unifiedStationExt.isScroller()) {
            return 1;
        }
        return 0;
    }

    private void highlight(UnifiedStationExt unifiedStationExt) {
        this.logger.uniList.log(-2137614336, "[UniStationList.highlight] %1", (Object)unifiedStationExt);
        int n = this.getUpdateReason(this.activeStation, unifiedStationExt);
        this.logger.uniList.log(-2137614336, "[UniStationList.highlight] reason %1", (long)n);
        if (n != 0) {
            int n2;
            BaseListModelApp baseListModelApp = this.listModel;
            boolean bl = false;
            boolean bl2 = this.activeStation.getAudioStatus() != unifiedStationExt.getAudioStatus();
            this.activeStation = unifiedStationExt;
            int n3 = this.getIndex(unifiedStationExt);
            if (n3 == -1 || n == 2) {
                this.doListUpdate();
                return;
            }
            UniListRow uniListRow = (UniListRow)this.listArray.get(n3);
            SelectedItem selectedItem = baseListModelApp.getSelected();
            int n4 = n2 = selectedItem == null ? -1 : selectedItem.getIndex();
            if (n2 != -1 && n2 != n3 && n2 < this.listArray.size()) {
                UniListRow uniListRow2 = (UniListRow)this.listArray.get(n2);
                baseListModelApp = this.listModel.getCopy();
                bl = true;
                uniListRow2.reset();
                uniListRow2.setStationActive(false);
                if (uniListRow2.isTmpAdded()) {
                    this.timerTmp.restart();
                }
                baseListModelApp.setRow(n2, uniListRow2);
            }
            int n5 = uniListRow.getSeparatorLine();
            boolean bl3 = uniListRow.isTmpAdded();
            UniListRow uniListRow3 = this.rowFactory.getUniListRow(unifiedStationExt, bl3, this.imgType);
            this.listArray.set(n3, uniListRow3);
            uniListRow3.setStationActive(true);
            uniListRow3.setProgramData(unifiedStationExt, this.imgType);
            uniListRow3.setSeparatorLine(n5);
            baseListModelApp.setRow(n3, uniListRow3);
            baseListModelApp.setSelectedIndex(n3);
            if (bl) {
                this.listModel.update(baseListModelApp);
            }
            this.logger.uniList.log(14808325, "[UniStationList.highlight] old %1 new %2", (long)n2, (long)n3);
            if (n2 == n3 && (selectedItem.getUniqueID() != uniListRow3.getUniqueID() || bl2)) {
                this.propagateUpdatedStationList(11);
            } else {
                this.propagateUpdatedActiveStation(11);
            }
        }
    }

    public UnifiedStationExt getActiveStation() {
        return this.activeStation;
    }

    private int getUpdateReason(UnifiedStationExt unifiedStationExt, UnifiedStationExt unifiedStationExt2) {
        if (unifiedStationExt.frequency == unifiedStationExt2.frequency && unifiedStationExt.rds != unifiedStationExt2.rds) {
            return 2;
        }
        if (unifiedStationExt.piSId != unifiedStationExt2.piSId || unifiedStationExt.frequency != unifiedStationExt2.frequency || unifiedStationExt.getAudioStatus() != unifiedStationExt2.getAudioStatus()) {
            return 1;
        }
        if (unifiedStationExt.frequency == unifiedStationExt2.frequency && unifiedStationExt.piSId == unifiedStationExt2.piSId) {
            String string;
            String string2 = unifiedStationExt.getImage(this.imgType).getResourceURI() == null ? "" : unifiedStationExt.getImage(this.imgType).getResourceURI();
            String string3 = string = unifiedStationExt2.getImage(this.imgType).getResourceURI() == null ? "" : unifiedStationExt2.getImage(this.imgType).getResourceURI();
            if (!unifiedStationExt.getName(true).equals(unifiedStationExt2.getName(true)) || unifiedStationExt.scrollingPS != unifiedStationExt2.scrollingPS || unifiedStationExt.isPsFreezed() != unifiedStationExt2.isPsFreezed()) {
                return 2;
            }
            if (!unifiedStationExt.getRtPlus().equals(unifiedStationExt2.getRtPlus()) || !string2.equals(string) || unifiedStationExt.getPty() != unifiedStationExt2.getPty()) {
                return 3;
            }
        }
        if (!unifiedStationExt.isRadioText() && (unifiedStationExt2.isRadioText() || unifiedStationExt2.isEnhancedRadioText())) {
            return 4;
        }
        if (!unifiedStationExt.isSlideshow() && unifiedStationExt2.isSlideshow()) {
            return 5;
        }
        return 0;
    }

    private int getIndex(UnifiedStationExt unifiedStationExt) {
        for (int i2 = 0; i2 < this.listArray.size(); ++i2) {
            if (!RadioComparators.equals(((UniListRow)this.listArray.get(i2)).getStation(), unifiedStationExt)) continue;
            return i2;
        }
        return -1;
    }

    private UnifiedStationExt getStation(UniListRow uniListRow) {
        UnifiedStationExt unifiedStationExt = uniListRow.getStation();
        UnifiedStationExt unifiedStationExt2 = this.tuner.getActiveStation();
        return UnifiedStationExt.equals(unifiedStationExt2, unifiedStationExt) ? unifiedStationExt2 : unifiedStationExt;
    }

    @Override
    public boolean tuneById(long l, int n) {
        this.logger.combi.log(-2137614336, "[UniStationList.tuneById], id: %1", l);
        UniListRow uniListRow = (UniListRow)this.listModel.getRowByUniqueID(l);
        if (uniListRow != null) {
            this.tuner.selectStation(this.getStation(uniListRow), n);
            return true;
        }
        TunerObjectContainer tunerObjectContainer = new RadioObjectIds((long)l, (LogChannel)this.logger.combi).toc;
        if (tunerObjectContainer != null) {
            TunerProxyManager.getInstance().prepareAndTune(tunerObjectContainer, n);
            return true;
        }
        this.logger.combi.log(10000, "[UniStationList.tuneById] id: %1  FAILED: STATION NOT FOUND", l);
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public TunerObjectContainer[] getStationList() {
        TunerObjectContainer[] tunerObjectContainerArray;
        List list = this.listArray;
        synchronized (list) {
            tunerObjectContainerArray = new TunerObjectContainer[this.listArray.size()];
            for (int i2 = 0; i2 < tunerObjectContainerArray.length; ++i2) {
                tunerObjectContainerArray[i2] = ((AbstractRadioListRow)this.listArray.get(i2)).getTOContainer();
            }
        }
        return tunerObjectContainerArray;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void setPrefImgType(int n) {
        this.imgType = n;
        List list = this.listArray;
        synchronized (list) {
            this.doListUpdate();
        }
    }

    @Override
    public boolean isEnsemble(int n) {
        return false;
    }

    static /* synthetic */ UnifiedStationExt access$400(UniStationList uniStationList, UniListRow uniListRow) {
        return uniStationList.getStation(uniListRow);
    }

    static /* synthetic */ UnifiedTuner access$500(UniStationList uniStationList) {
        return uniStationList.tuner;
    }

    static /* synthetic */ List access$600(UniStationList uniStationList) {
        return uniStationList.listArray;
    }

    static /* synthetic */ UniListRow access$702(UniStationList uniStationList, UniListRow uniListRow) {
        uniStationList.focussedRow = uniListRow;
        return uniStationList.focussedRow;
    }

    static /* synthetic */ void access$800(UniStationList uniStationList, UnifiedStationExt unifiedStationExt) {
        uniStationList.highlight(unifiedStationExt);
    }

    static /* synthetic */ void access$900(UniStationList uniStationList) {
        uniStationList.addActiveStationToList();
    }

    static /* synthetic */ UnifiedStationExt access$1000(UniStationList uniStationList) {
        return uniStationList.activeStation;
    }

    static /* synthetic */ UnifiedStationExt[] access$1102(UniStationList uniStationList, UnifiedStationExt[] unifiedStationExtArray) {
        uniStationList.lastList = unifiedStationExtArray;
        return unifiedStationExtArray;
    }

    static /* synthetic */ UnifiedStationExt access$1002(UniStationList uniStationList, UnifiedStationExt unifiedStationExt) {
        uniStationList.activeStation = unifiedStationExt;
        return uniStationList.activeStation;
    }

    static /* synthetic */ void access$1200(UniStationList uniStationList) {
        uniStationList.doListUpdate();
    }

    static /* synthetic */ Timer access$1300(UniStationList uniStationList) {
        return uniStationList.timerTmp;
    }

    static /* synthetic */ UnifiedStationExt access$1402(UniStationList uniStationList, UnifiedStationExt unifiedStationExt) {
        uniStationList.tmpAddedStation = unifiedStationExt;
        return uniStationList.tmpAddedStation;
    }

    static /* synthetic */ UnifiedStationExt access$1502(UniStationList uniStationList, UnifiedStationExt unifiedStationExt) {
        uniStationList.tmpAddedFocussedStation = unifiedStationExt;
        return uniStationList.tmpAddedFocussedStation;
    }

    static /* synthetic */ BaseListModelApp access$1600(UniStationList uniStationList) {
        return uniStationList.listModel;
    }

    static /* synthetic */ Logger access$1700(UniStationList uniStationList) {
        return uniStationList.logger;
    }

    static /* synthetic */ IDrawerFocusManager access$1800(UniStationList uniStationList) {
        return uniStationList.drawerFocus;
    }

    static /* synthetic */ MenuModelApp access$1900(UniStationList uniStationList) {
        return uniStationList.menuModel;
    }

    static /* synthetic */ UnifiedStationExt[] access$1100(UniStationList uniStationList) {
        return uniStationList.lastList;
    }
}

