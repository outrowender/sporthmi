/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.stationlist;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.hmi.model.update.ModelTrigger;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.DrawerFocusManager;
import de.audi.tuner.app.IDrawerFocusManager;
import de.audi.tuner.app.IStoreHandler;
import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.RadioBaseListModelListener;
import de.audi.tuner.app.RadioComparators;
import de.audi.tuner.app.RadioMenuModelListener;
import de.audi.tuner.app.RadioObjectIds;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.TunerProxyManager;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.AMFMTuner;
import de.audi.tuner.app.amfm.HdStationInfoExt;
import de.audi.tuner.app.amfm.dsi.AMFMDsiDownInfo;
import de.audi.tuner.app.amfm.dsi.RadioInfo;
import de.audi.tuner.app.amfm.stationlist.AbstractAmFmRow;
import de.audi.tuner.app.amfm.stationlist.AmListRow;
import de.audi.tuner.app.amfm.stationlist.FmListRow;
import de.audi.tuner.app.amfm.stationlist.IAmFmStationList;
import de.audi.tuner.app.amfm.stationlist.RecordSets;
import de.audi.tuner.app.amfm.stationlist.RowSortAlgoAlphabetically;
import de.audi.tuner.app.amfm.stationlist.RowSortAlgoFrequency;
import de.audi.tuner.app.amfm.stationlist.RowSortAlgoGenre;
import de.audi.tuner.app.amfm.stationlist.RowSortAlgoPiAscending;
import de.audi.tuner.app.amfm.stationlist.RowSortAlgoSignal;
import de.audi.tuner.app.storage.TunerStorage;
import de.audi.tuner.ifc.AbstractListRowFactory;
import de.audi.tuner.ifc.AbstractRadioListRow;
import de.audi.tuner.ifc.IPrevNext;
import de.audi.tuner.ifc.IScanHandler;
import de.audi.tuner.ifc.ISearchBreak;
import de.audi.tuner.ifc.IStationListHandler;
import de.audi.tuner.ifc.IStoreStationHandler;
import de.audi.tuner.sds.UpdateListenerHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class AbstractAmFmStationlist
extends UpdateListenerHandler
implements IStationListHandler,
IAmFmStationList {
    private final AMFMDsiDownInfo dsiDownListener = new DsiDownListener();
    private final IPrevNext prevNextHandler = new PrevNextHandler();
    public static final int SORT_ALGO_ALPHABETICAL = 0;
    private static final int SORT_ALGO_PI_ASC = 1;
    public static final int SORT_ALGO_FREQ = 2;
    private static final int SORT_ALGO_GENRE = 3;
    private static final int SORT_ALGO_SIGNAL = 4;
    protected static final int REASON_NONE = 0;
    protected static final int REASON_NEW_STATION = 1;
    protected static final int REASON_RESORTING = 2;
    protected static final int REASON_PROGRAM_CHANGED = 3;
    private static final int AREA_FIX_NAME = 0;
    private static final int AREA_SCROLLING = 1;
    private static final int AREA_FREQUENCY = 2;
    private final LogChannel log;
    protected final TunerModels models;
    protected final BaseListModelApp listModel;
    protected final MenuModelApp menuModel;
    protected final MenuModelListener menuModelListener;
    private final AbstractListRowFactory rowFactory;
    private final AMFMTuner tuner;
    protected final RecordSets recordSets;
    private final LanguageManager langMngr;
    private final IStoreHandler storeHandler;
    protected final Object mutex = new Object();
    private AMFMStation tmpAddedStation = null;
    private AMFMStation tmpAddedFocussedStation = null;
    private AbstractAmFmRow focussedRow = null;
    private AMFMStation activeStation = new AMFMStation();
    private Comparator comparator;
    protected AMFMStation[] lastList = new AMFMStation[0];
    private final Timer timerTmp;
    private final Timer timerFocus;
    private final Timer timerListUpdate;
    private final int band;
    private final StationComparator stComp;
    private IStoreStationHandler longPressHandler;
    private final IScanHandler scanHandler;
    private int imgType;
    private boolean cursorMoving = false;
    private boolean listUpdateWaiting = false;
    private IDrawerFocusManager drawerFocus = DrawerFocusManager.NULL_DRAWER_FOCUS_MANAGER;

    AbstractAmFmStationlist(TunerBasics tunerBasics, int n, int n2, RecordSets recordSets, AbstractListRowFactory abstractListRowFactory, AMFMTuner aMFMTuner, int n3, LanguageManager languageManager, IScanHandler iScanHandler, TunerStorage tunerStorage, IStoreHandler iStoreHandler, int n4) {
        this.log = tunerBasics.getLogger().amfmList;
        this.models = tunerBasics.getModels();
        this.recordSets = recordSets;
        this.rowFactory = abstractListRowFactory;
        this.tuner = aMFMTuner;
        this.band = n3;
        this.langMngr = languageManager;
        this.scanHandler = iScanHandler;
        this.storeHandler = iStoreHandler;
        this.mkNewAlgo(n4);
        this.stComp = Utilities.isPiIgnore() ? new StationComparatorPiIgnore() : new StationComparatorEU();
        this.listModel = this.models.getBaseListModel(n);
        this.listModel.setListener(new ListListener(tunerBasics.getModels(), n2));
        this.menuModel = this.models.getMenuModel(n2);
        this.menuModelListener = new MenuModelListener();
        this.menuModel.setListener(this.menuModelListener);
        TimerListener timerListener = new TimerListener();
        this.timerTmp = new Timer("timerTmp", 20000L, true, timerListener);
        this.timerFocus = new Timer("timerFocus", 5000L, true, timerListener);
        this.timerListUpdate = new Timer("timerListUpdate", Utilities.isStd() ? 1500L : 400L, true, timerListener);
        this.imgType = tunerStorage.loadPreferredImageType();
    }

    public void init(TunerStorage tunerStorage) {
        this.highlight(tunerStorage.getAMFMLSM(this.band));
    }

    public void register(IStoreStationHandler iStoreStationHandler) {
        this.longPressHandler = iStoreStationHandler;
    }

    public void register(ISearchBreak iSearchBreak, int n) {
        this.menuModelListener.register(iSearchBreak, n);
    }

    public void register(IDrawerFocusManager iDrawerFocusManager) {
        this.drawerFocus = iDrawerFocusManager;
    }

    public RadioInfo getDsiDownListener() {
        return this.dsiDownListener;
    }

    public IPrevNext getPrevNextHandler() {
        return this.prevNextHandler;
    }

    public void setSortAlgo(int n) {
        this.mkNewAlgo(n);
        if (this.activeStation.frequency != 0L) {
            this.doListUpdate(true);
        }
    }

    private void mkNewAlgo(int n) {
        switch (n) {
            case 1: {
                this.comparator = new RowSortAlgoPiAscending();
                break;
            }
            case 3: {
                this.comparator = new RowSortAlgoGenre(this.langMngr);
                break;
            }
            case 4: {
                this.comparator = new RowSortAlgoSignal(this.langMngr);
                break;
            }
            case 2: {
                this.comparator = new RowSortAlgoFrequency();
                break;
            }
            default: {
                this.comparator = new RowSortAlgoAlphabetically(this.langMngr);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected void doListUpdate(boolean bl) {
        this.log.log(100000000, "[AbstractAmFmStationlist.doListUpdate]");
        ArrayList arrayList = new ArrayList(200);
        Object object = this.mutex;
        synchronized (object) {
            Object object2;
            int n;
            if (this.cursorMoving && !bl) {
                this.listUpdateWaiting = true;
                return;
            }
            this.listUpdateWaiting = false;
            boolean bl2 = false;
            AMFMStation aMFMStation = this.focussedRow != null ? this.focussedRow.getStation() : null;
            boolean bl3 = aMFMStation == null;
            for (n = 0; n < this.lastList.length; ++n) {
                block16: {
                    if (this.stComp.equals(this.lastList[n], this.tmpAddedFocussedStation)) {
                        this.tmpAddedFocussedStation = null;
                    }
                    if (this.stComp.equals(this.lastList[n], this.tmpAddedStation)) {
                        this.tmpAddedStation = null;
                    }
                    if (this.stComp.equals(this.lastList[n], this.activeStation)) {
                        if (!bl2) {
                            bl2 = true;
                            object2 = this.rowFactory.getAmFmListRow(this.band, this.activeStation, this.recordSets, this.imgType);
                            ((AbstractAmFmRow)object2).setProgramData(this.activeStation, this.imgType, this.tuner.getStatus());
                            ((AbstractAmFmRow)object2).setStationActive(true);
                            arrayList.add(object2);
                            this.log.log(100000000, "[AbstractAmFmStationlist.doListUpdate] active station has index %1", (long)n);
                            this.lastList[n] = this.activeStation;
                            break block16;
                        } else {
                            this.log.log(100000, "[AbstractAmFmStationlist.doListUpdate] active station already added -> ignore %1", (Object)this.lastList[n]);
                            continue;
                        }
                    }
                    arrayList.add(this.rowFactory.getAmFmListRow(this.band, this.lastList[n], this.recordSets, this.imgType));
                }
                if (!this.stComp.equals(this.lastList[n], aMFMStation)) continue;
                bl3 = true;
            }
            n = 0;
            if (!bl2) {
                this.activeStation.setTmpAdded(true);
                this.tmpAddedStation = new AMFMStation(this.activeStation);
                object2 = this.rowFactory.getAmFmListRow(this.band, this.activeStation, this.recordSets, this.imgType);
                ((AbstractAmFmRow)object2).setProgramData(this.activeStation, this.imgType, this.tuner.getStatus());
                ((AbstractAmFmRow)object2).setStationActive(true);
                arrayList.add(object2);
                n = 1;
                this.log.log(100000000, "[AbstractAmFmStationlist.doListUpdate] active station added temporary");
            } else if (this.tmpAddedStation != null) {
                arrayList.add(this.rowFactory.getAmFmListRow(this.band, this.tmpAddedStation, this.recordSets, this.imgType));
                n = 1;
            }
            if (!bl3 && !this.stComp.equals(this.activeStation, aMFMStation)) {
                this.tmpAddedFocussedStation = aMFMStation;
                this.timerFocus.restart();
            }
            if (this.tmpAddedFocussedStation != null) {
                if (n != 0 && this.stComp.equals(this.tmpAddedStation, this.tmpAddedFocussedStation)) {
                    this.log.log(1000000, "[AbstractAmFmStationlist.doListUpdate] focussed station was double");
                } else {
                    arrayList.add(this.rowFactory.getAmFmListRow(this.band, this.tmpAddedFocussedStation, this.recordSets, this.imgType));
                    this.log.log(100000000, "[AbstractAmFmStationlist.doListUpdate] focussed station added temporary");
                }
            }
            Collections.sort(arrayList, this.comparator);
            this.setSeparatorLines(arrayList);
            object2 = this.listModel.getEmptyCopy();
            object2.append((EvoListRow[])arrayList.toArray(new EvoListRow[arrayList.size()]));
            object2.setSelectedUniqueID(this.activeStation.getUniqueId());
            this.listModel.update((BaseListModelApp)object2);
        }
        this.propagateUpdatedStationList(this.band);
    }

    private void setSeparatorLines(List list) {
        if (this.band == 1 && Utilities.isSinglePiMode()) {
            boolean bl = this.comparator instanceof RowSortAlgoAlphabetically;
            FmListRow fmListRow = (FmListRow)list.get(0);
            int n = this.getArea(fmListRow.station, bl);
            for (int i2 = 1; i2 < list.size(); ++i2) {
                fmListRow = (FmListRow)list.get(i2);
                int n2 = this.getArea(fmListRow.station, bl);
                if (n2 != n) {
                    fmListRow.setSeparatorLine(true);
                    ((FmListRow)list.get(i2 - 1)).setSeparatorLine(false);
                }
                n = n2;
            }
        }
    }

    private int getArea(AMFMStation aMFMStation, boolean bl) {
        if (!aMFMStation.isRds() && aMFMStation.name.length() == 0) {
            return 2;
        }
        if (aMFMStation.isScroller() && bl) {
            return 1;
        }
        return 0;
    }

    protected void highlight(AMFMStation aMFMStation) {
        this.log.log(10000000, "[AbstractAmFmStationlist.highlight] %1", (Object)aMFMStation);
        int n = this.getUpdateReason(this.activeStation, aMFMStation);
        this.log.log(100000000, "[AbstractAmFmStationlist.highlight] reason %1", (long)n);
        if (n != 0) {
            int n2;
            this.activeStation = new AMFMStation(aMFMStation);
            int n3 = this.getIndex(aMFMStation);
            this.log.log(100000000, "[AbstractAmFmStationlist.highlight] index %1", (long)n3);
            if (n3 == -1 || n == 2) {
                this.doListUpdate(true);
                return;
            }
            SelectedItem selectedItem = this.listModel.getSelected();
            int n4 = n2 = selectedItem == null ? -1 : selectedItem.getIndex();
            if (n2 != -1 && n2 != n3) {
                AbstractAmFmRow abstractAmFmRow = (AbstractAmFmRow)this.listModel.getRow(n2);
                abstractAmFmRow.setStationActive(false);
                if (abstractAmFmRow.isTmpAdded()) {
                    this.timerTmp.restart();
                }
                this.listModel.setRow(n2, abstractAmFmRow);
            } else {
                aMFMStation.setTmpAdded(((AbstractAmFmRow)this.listModel.getRow(n3)).isTmpAdded());
            }
            int n5 = ((AbstractAmFmRow)this.listModel.getRow(n3)).getSeparatorLine();
            AbstractAmFmRow abstractAmFmRow = this.rowFactory.getAmFmListRow(this.band, aMFMStation, this.recordSets, this.imgType);
            abstractAmFmRow.setProgramData(aMFMStation, this.imgType, this.tuner.getStatus());
            abstractAmFmRow.setStationActive(true);
            abstractAmFmRow.setSeparatorLine(n5);
            this.listModel.setRow(n3, abstractAmFmRow);
            this.listModel.setSelectedIndex(n3);
            this.propagateUpdatedActiveStation(this.band);
            if (Utilities.isNARBuild()) {
                this.propagateUpdatedStationList(this.band);
            }
        }
    }

    protected int getUpdateReason(AMFMStation aMFMStation, AMFMStation aMFMStation2) {
        if (aMFMStation.pi != aMFMStation2.pi || aMFMStation.pi == aMFMStation2.pi && aMFMStation.frequency != aMFMStation2.frequency || !aMFMStation.rds && !aMFMStation2.rds && aMFMStation.frequency != aMFMStation2.frequency || aMFMStation.hd != aMFMStation2.hd) {
            return 1;
        }
        if (aMFMStation.frequency == aMFMStation2.frequency && aMFMStation.pi == aMFMStation2.pi) {
            String string;
            String string2 = aMFMStation.getImage(this.imgType).getResourceURI() == null ? "" : aMFMStation.getImage(this.imgType).getResourceURI();
            String string3 = string = aMFMStation2.getImage(this.imgType).getResourceURI() == null ? "" : aMFMStation2.getImage(this.imgType).getResourceURI();
            if (!aMFMStation.name.equals(aMFMStation2.name) || aMFMStation.isScroller() != aMFMStation2.isScroller() || aMFMStation.isPsFreezed() != aMFMStation2.isPsFreezed()) {
                return 2;
            }
            if (!aMFMStation.getRtPlus().equals(aMFMStation2.getRtPlus()) || !string2.equals(string) || aMFMStation.ptyCode != aMFMStation2.ptyCode || aMFMStation.getAudioStatus() != aMFMStation2.getAudioStatus() || aMFMStation.getPresetPos() != aMFMStation2.getPresetPos()) {
                return 3;
            }
            if (aMFMStation2.hd) {
                HdStationInfoExt hdStationInfoExt = aMFMStation.getHdInfo();
                HdStationInfoExt hdStationInfoExt2 = aMFMStation2.getHdInfo();
                if (!(hdStationInfoExt.artistName.equals(hdStationInfoExt2.artistName) && hdStationInfoExt.albumTitle.equals(hdStationInfoExt2.albumTitle) && hdStationInfoExt.songTitle.equals(hdStationInfoExt2.songTitle))) {
                    return 3;
                }
                if (aMFMStation.getAudioStatus() != aMFMStation2.getAudioStatus()) {
                    return 3;
                }
            }
        }
        return 0;
    }

    protected int getIndex(AMFMStation aMFMStation) {
        for (int i2 = 0; i2 < this.listModel.getLength(); ++i2) {
            if (!RadioComparators.equals(((AbstractAmFmRow)this.listModel.getRow(i2)).getStation(), aMFMStation)) continue;
            return i2;
        }
        return -1;
    }

    public boolean tuneById(long l, int n) {
        this.log.log(10000000, "[AbstractAmFmStationList#tuneById], id: %1", l);
        AbstractAmFmRow abstractAmFmRow = (AbstractAmFmRow)this.listModel.getRowByUniqueID(l);
        if (abstractAmFmRow != null) {
            this.tuner.tuneStation(abstractAmFmRow.getStation(), false, false, n);
            return true;
        }
        TunerObjectContainer tunerObjectContainer = new RadioObjectIds((long)l, (LogChannel)this.log).toc;
        if (tunerObjectContainer != null) {
            TunerProxyManager.getInstance().prepareAndTune(tunerObjectContainer, n);
            return true;
        }
        this.log.log(10000, "[AbstractAmFmStationList#tuneById], id: %1  FAILED: STATION NOT FOUND", l);
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public TunerObjectContainer[] getStationList() {
        TunerObjectContainer[] tunerObjectContainerArray;
        Object object = this.mutex;
        synchronized (object) {
            List list = this.listModel.asList();
            tunerObjectContainerArray = new TunerObjectContainer[list.size()];
            for (int i2 = 0; i2 < tunerObjectContainerArray.length; ++i2) {
                tunerObjectContainerArray[i2] = ((AbstractRadioListRow)list.get(i2)).getTOContainer();
            }
        }
        return tunerObjectContainerArray;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public AMFMStation getActiveStation() {
        Object object = this.mutex;
        synchronized (object) {
            return this.activeStation;
        }
    }

    public boolean isEnsemble(int n) {
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setPrefImgType(int n) {
        Object object = this.mutex;
        synchronized (object) {
            this.imgType = n;
            this.doListUpdate(true);
        }
    }

    protected class ListListener
    extends RadioBaseListModelListener {
        public ListListener(TunerModels tunerModels, int n) {
            super(tunerModels, n);
        }

        public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            boolean bl;
            boolean bl2 = evoListRow instanceof FmListRow && n3 == 8;
            boolean bl3 = bl = evoListRow instanceof AmListRow && n3 == 4;
            if (bl2 || bl) {
                if (AbstractAmFmStationlist.this.longPressHandler != null) {
                    AbstractAmFmStationlist.this.longPressHandler.prepareStore(n4, ((AbstractRadioListRow)evoListRow).getTOContainer());
                }
            } else {
                if (AbstractAmFmStationlist.this.storeHandler.isStoreModeActive()) {
                    AbstractAmFmStationlist.this.storeHandler.store((AbstractRadioListRow)evoListRow);
                    AbstractAmFmStationlist.this.listModel.fireEvent(n4);
                    return;
                }
                AbstractAmFmStationlist.this.scanHandler.abortScan();
                if (this.isNewSelection(evoListRow, n, n2, n3, n4)) {
                    AMFMStation aMFMStation = ((AbstractAmFmRow)evoListRow).getStation();
                    AbstractAmFmStationlist.this.tuner.tuneStation(aMFMStation, false, false, n4);
                    AbstractAmFmStationlist.this.propagateUpdatedActiveStation(AbstractAmFmStationlist.this.band);
                }
            }
        }

        public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            AbstractAmFmStationlist.this.scanHandler.abortScan();
            if (AbstractAmFmStationlist.this.listModel.getSelected().getIndex() != n2) {
                AMFMStation aMFMStation = ((AbstractAmFmRow)evoListRow).getStation();
                AbstractAmFmStationlist.this.tuner.tuneStation(aMFMStation, false, false, n4);
                AbstractAmFmStationlist.this.propagateUpdatedActiveStation(AbstractAmFmStationlist.this.band);
            }
            if (AbstractAmFmStationlist.this.longPressHandler != null) {
                AbstractAmFmStationlist.this.longPressHandler.prepareStore(n4, ((AbstractRadioListRow)evoListRow).getTOContainer());
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            AbstractAmFmStationlist.this.log.log(100000000, "[BAFS.itemFocused] model %1 index %2", (long)n, (long)n2);
            Object object = AbstractAmFmStationlist.this.mutex;
            synchronized (object) {
                AbstractAmFmStationlist.this.focussedRow = (AbstractAmFmRow)evoListRow;
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
            if (timer.equals(AbstractAmFmStationlist.this.timerTmp)) {
                Object object = AbstractAmFmStationlist.this.mutex;
                synchronized (object) {
                    AbstractAmFmStationlist.this.tmpAddedStation = null;
                    AbstractAmFmStationlist.this.doListUpdate(false);
                }
            }
            if (timer.equals(AbstractAmFmStationlist.this.timerFocus)) {
                Object object = AbstractAmFmStationlist.this.mutex;
                synchronized (object) {
                    AbstractAmFmStationlist.this.tmpAddedFocussedStation = null;
                    AbstractAmFmStationlist.this.doListUpdate(false);
                }
            }
            if (timer.equals(AbstractAmFmStationlist.this.timerListUpdate)) {
                Object object = AbstractAmFmStationlist.this.mutex;
                synchronized (object) {
                    if (AbstractAmFmStationlist.this.listUpdateWaiting && !AbstractAmFmStationlist.this.cursorMoving) {
                        AbstractAmFmStationlist.this.listUpdateWaiting = false;
                        AbstractAmFmStationlist.this.doListUpdate(false);
                    }
                }
            }
        }
    }

    private class DsiDownListener
    extends AMFMDsiDownInfo {
        private DsiDownListener() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void preTuneAction(AMFMStation aMFMStation, boolean bl) {
            Object object = AbstractAmFmStationlist.this.mutex;
            synchronized (object) {
                if (aMFMStation.waveband == 1 && AbstractAmFmStationlist.this.band == 1 || aMFMStation.waveband == 3 && AbstractAmFmStationlist.this.band != 1 && AbstractAmFmStationlist.this.band == AbstractAmFmStationlist.this.models.getActiveTuner()) {
                    AbstractAmFmStationlist.this.highlight(aMFMStation);
                }
            }
        }
    }

    private class PrevNextHandler
    implements IPrevNext {
        private PrevNextHandler() {
        }

        public void handlePrevNext(boolean bl) {
            if (AbstractAmFmStationlist.this.tuner.isForcedStationListUpdateRunning()) {
                AbstractAmFmStationlist.this.log.log(10000000, "[AAFS.PNH.handlePrevNext] ignore skip: listupdate running");
                return;
            }
            SelectedItem selectedItem = AbstractAmFmStationlist.this.listModel.getSelected();
            int n = 0;
            if (selectedItem != null) {
                n = bl ? ((n = selectedItem.getIndex() + 1) >= AbstractAmFmStationlist.this.listModel.getLength() ? 0 : n) : ((n = selectedItem.getIndex() - 1) < 0 ? AbstractAmFmStationlist.this.listModel.getLength() - 1 : n);
            }
            AbstractAmFmRow abstractAmFmRow = (AbstractAmFmRow)AbstractAmFmStationlist.this.listModel.getRow(n);
            AbstractAmFmStationlist.this.tuner.tuneStation(abstractAmFmRow.getStation(), false, false, 0);
            if (!AbstractAmFmStationlist.this.drawerFocus.isDrawerOpen()) {
                AbstractAmFmStationlist.this.menuModel.trigger(ModelTrigger.JOIN_CURSOR);
            }
        }
    }

    protected class MenuModelListener
    extends RadioMenuModelListener {
        protected MenuModelListener() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void itemFocused(int n, int n2, long l, int n3) {
            super.itemFocused(n, n2, l, n3);
            Object object = AbstractAmFmStationlist.this.mutex;
            synchronized (object) {
                AbstractAmFmStationlist.this.cursorMoving = n == -1;
                if (AbstractAmFmStationlist.this.listUpdateWaiting) {
                    if (AbstractAmFmStationlist.this.cursorMoving) {
                        AbstractAmFmStationlist.this.timerListUpdate.cancel();
                    } else {
                        AbstractAmFmStationlist.this.timerListUpdate.restart();
                    }
                }
            }
        }
    }

    private static interface StationComparator {
        public boolean equals(AMFMStation var1, AMFMStation var2);
    }

    private static class StationComparatorEU
    implements StationComparator {
        private StationComparatorEU() {
        }

        public boolean equals(AMFMStation aMFMStation, AMFMStation aMFMStation2) {
            if (aMFMStation == null || aMFMStation2 == null) {
                return false;
            }
            if (aMFMStation.pi > 0 || aMFMStation2.pi > 0) {
                return aMFMStation.pi == aMFMStation2.pi || aMFMStation.frequency == aMFMStation2.frequency;
            }
            return aMFMStation.frequency == aMFMStation2.frequency;
        }
    }

    private static class StationComparatorPiIgnore
    implements StationComparator {
        private StationComparatorPiIgnore() {
        }

        public boolean equals(AMFMStation aMFMStation, AMFMStation aMFMStation2) {
            if (aMFMStation == null || aMFMStation2 == null) {
                return false;
            }
            return aMFMStation.frequency == aMFMStation2.frequency;
        }
    }
}

