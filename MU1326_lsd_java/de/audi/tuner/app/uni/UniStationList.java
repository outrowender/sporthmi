/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.uni;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.hmi.model.menu.MenuModelListener;
import de.audi.atip.hmi.model.update.ModelTrigger;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.DrawerFocusManager;
import de.audi.tuner.app.IDrawerFocusManager;
import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.RadioBaseListModelListener;
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
    final UniDsiUpInfo dsiUpListener = new UniUpListener();
    final UniDsiDownInfo dsiDownListener = new UniDownListener();
    final IPrevNext prevNextHandler = new PrevNextHandler();
    private static final int REASON_NONE = 0;
    private static final int REASON_NEW_STATION = 1;
    private static final int REASON_RESORTING = 2;
    private static final int REASON_PROGRAM_CHANGED = 3;
    private static final int REASON_RADIOTEXT_CHANGED = 4;
    private static final int REASON_SLIDESHOW_CHANGED = 5;
    private static final int AREA_FIX_NAME = 0;
    private static final int AREA_SCROLLING = 1;
    private static final int AREA_FREQUENCY = 2;
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
        this.listModel = tunerModels.getBaseListModel(100303);
        this.menuModel = tunerModels.getMenuModel(100310);
        ListListener listListener = new ListListener(tunerModels, 100310);
        this.listModel.setListener(listListener);
        tunerModels.getMenuModel(100310).setListener(listListener);
        this.comparator = new UnifiedListComparator(languageManager, new CompServiceLookup());
        TimerListener timerListener = new TimerListener();
        this.timerTmp = new Timer("timerTmp", 5000L, true, timerListener);
        this.timerFocus = new Timer("timerFocus", 5000L, true, timerListener);
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

    public void register(ISearchBreak iSearchBreak, int n) {
        throw new IllegalArgumentException();
    }

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
                            this.logger.uniList.log(100000000, "[UniStationList.doListUpdate] active station has index %1", (long)i2);
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
                this.logger.uniList.log(100000000, "[UniStationList.doListUpdate] active not included %1", (Object)this.activeStation);
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
                this.logger.uniList.log(100000000, "[UniStationList.doListUpdate] add tmpAddedStation %1", (Object)this.tmpAddedStation);
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
                this.logger.uniList.log(100000000, "[UniStationList.doListUpdate] add focused row %1", (Object)this.focussedRow);
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
        this.logger.uniList.log(10000000, "[UniStationList.highlight] %1", (Object)unifiedStationExt);
        int n = this.getUpdateReason(this.activeStation, unifiedStationExt);
        this.logger.uniList.log(10000000, "[UniStationList.highlight] reason %1", (long)n);
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
            this.logger.uniList.log(100000000, "[UniStationList.highlight] old %1 new %2", (long)n2, (long)n3);
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

    public boolean tuneById(long l, int n) {
        this.logger.combi.log(10000000, "[UniStationList.tuneById], id: %1", l);
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
    public void setPrefImgType(int n) {
        this.imgType = n;
        List list = this.listArray;
        synchronized (list) {
            this.doListUpdate();
        }
    }

    public boolean isEnsemble(int n) {
        return false;
    }

    static /* synthetic */ UnifiedStationExt[] access$1102(UniStationList uniStationList, UnifiedStationExt[] unifiedStationExtArray) {
        uniStationList.lastList = unifiedStationExtArray;
        return unifiedStationExtArray;
    }

    private class ListListener
    extends RadioBaseListModelListener
    implements MenuModelListener {
        public ListListener(TunerModels tunerModels, int n) {
            super(tunerModels, n);
        }

        public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            if (this.isNewSelection(evoListRow, n, n2, n3, n4)) {
                UnifiedStationExt unifiedStationExt = UniStationList.this.getStation((UniListRow)evoListRow);
                UniStationList.this.tuner.selectStation(unifiedStationExt, n4);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            List list = UniStationList.this.listArray;
            synchronized (list) {
                UniStationList.this.focussedRow = (UniListRow)evoListRow;
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void itemFocused(int n, int n2, long l, int n3) {
            if (n != 100303) {
                List list = UniStationList.this.listArray;
                synchronized (list) {
                    UniStationList.this.focussedRow = null;
                }
            }
        }
    }

    private class TimerListener
    extends DefaultTimerListener {
        private TimerListener() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void fireTimer(Timer timer) {
            if (timer.equals(UniStationList.this.timerTmp)) {
                List list = UniStationList.this.listArray;
                synchronized (list) {
                    UniStationList.this.tmpAddedStation = null;
                    UniStationList.this.doListUpdate();
                }
            }
            List list = UniStationList.this.listArray;
            synchronized (list) {
                UniStationList.this.tmpAddedFocussedStation = null;
                UniStationList.this.doListUpdate();
            }
        }
    }

    private class UniUpListener
    extends UniDsiUpInfo {
        boolean lowReception = false;

        private UniUpListener() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void updateSelectedStation(UnifiedStationExt unifiedStationExt) {
            boolean bl;
            List list = UniStationList.this.listArray;
            synchronized (list) {
                if (UniStationList.this.activeStation != null && UniStationList.this.activeStation.hasPrimaryService() && !unifiedStationExt.hasPrimaryService() && UnifiedStationExt.equals(UniStationList.this.activeStation, unifiedStationExt)) {
                    unifiedStationExt.setPrimaryService(UniStationList.this.activeStation.getPrimaryService());
                }
                UniStationList.this.addActiveStationToList();
                UniStationList.this.highlight(unifiedStationExt);
            }
            boolean bl2 = bl = unifiedStationExt.getAudioStatus() == 3;
            if (this.lowReception != bl) {
                this.lowReception = bl;
                UniStationList.this.propagateUpdatedMuteStatus(11, this.lowReception);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void updateStationList(UnifiedStationExt[] unifiedStationExtArray, UnifiedStationExt unifiedStationExt) {
            List list = UniStationList.this.listArray;
            synchronized (list) {
                UniStationList.access$1102(UniStationList.this, unifiedStationExtArray);
                UniStationList.this.addActiveStationToList();
                if (unifiedStationExt != null) {
                    UniStationList.this.activeStation = unifiedStationExt;
                }
                UniStationList.this.doListUpdate();
            }
        }
    }

    private class PrevNextHandler
    implements IPrevNext {
        private PrevNextHandler() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void handlePrevNext(boolean bl) {
            UniListRow uniListRow = null;
            Object object = UniStationList.this.listArray;
            synchronized (object) {
                SelectedItem selectedItem = UniStationList.this.listModel.getSelected();
                int n = UniStationList.this.listModel.getLength();
                int n2 = 0;
                if (selectedItem != null) {
                    n2 = bl ? ((n2 = selectedItem.getIndex() + 1) >= n ? 0 : n2) : ((n2 = selectedItem.getIndex() - 1) < 0 ? n - 1 : n2);
                }
                ((UniStationList)UniStationList.this).logger.uniDSI.log(10000000, "[UniStationList.handleNextPrev] index %1 -> %2 (length: %3)", (Object)selectedItem, (long)n2, (long)n);
                uniListRow = (UniListRow)UniStationList.this.listModel.getRow(n2);
            }
            object = UniStationList.this.getStation(uniListRow);
            ((UniStationList)UniStationList.this).logger.uniDSI.log(10000000, "[UniStationList.handleNextPrev] stationToSelect: %1 ", object);
            UniStationList.this.tuner.selectStation((UnifiedStationExt)object, 0);
            if (!UniStationList.this.drawerFocus.isDrawerOpen()) {
                UniStationList.this.menuModel.trigger(ModelTrigger.JOIN_CURSOR);
            }
        }
    }

    private class UniDownListener
    extends UniDsiDownInfo {
        private UniDownListener() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void preTuneCommand(UnifiedStationExt unifiedStationExt) {
            List list = UniStationList.this.listArray;
            synchronized (list) {
                UniStationList.this.highlight(unifiedStationExt);
                UniStationList.this.addActiveStationToList();
            }
        }
    }

    protected class CompServiceLookup {
        protected CompServiceLookup() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public String getServiceName(int n) {
            List list = UniStationList.this.listArray;
            synchronized (list) {
                for (int i2 = 0; i2 < UniStationList.this.lastList.length; ++i2) {
                    if (((UniStationList)UniStationList.this).lastList[i2].piSId != n || ((UniStationList)UniStationList.this).lastList[i2].sCIDI != 0) continue;
                    return UniStationList.this.lastList[i2].getName(true);
                }
            }
            ((UniStationList)UniStationList.this).logger.uniList.log(10000, "[UniStationList.getServiceName] service missing pi: %1", (long)n);
            return "";
        }
    }
}

