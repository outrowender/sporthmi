/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.stationlist;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.DrawerFocusManager;
import de.audi.tuner.app.IDrawerFocusManager;
import de.audi.tuner.app.IStoreHandler;
import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.RadioComparators;
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
import de.audi.tuner.app.amfm.stationlist.AbstractAmFmStationlist$DsiDownListener;
import de.audi.tuner.app.amfm.stationlist.AbstractAmFmStationlist$ListListener;
import de.audi.tuner.app.amfm.stationlist.AbstractAmFmStationlist$MenuModelListener;
import de.audi.tuner.app.amfm.stationlist.AbstractAmFmStationlist$PrevNextHandler;
import de.audi.tuner.app.amfm.stationlist.AbstractAmFmStationlist$StationComparator;
import de.audi.tuner.app.amfm.stationlist.AbstractAmFmStationlist$StationComparatorEU;
import de.audi.tuner.app.amfm.stationlist.AbstractAmFmStationlist$StationComparatorPiIgnore;
import de.audi.tuner.app.amfm.stationlist.AbstractAmFmStationlist$TimerListener;
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
    private final AMFMDsiDownInfo dsiDownListener = new AbstractAmFmStationlist$DsiDownListener(this, null);
    private final IPrevNext prevNextHandler = new AbstractAmFmStationlist$PrevNextHandler(this, null);
    public static final int SORT_ALGO_ALPHABETICAL;
    private static final int SORT_ALGO_PI_ASC;
    public static final int SORT_ALGO_FREQ;
    private static final int SORT_ALGO_GENRE;
    private static final int SORT_ALGO_SIGNAL;
    protected static final int REASON_NONE;
    protected static final int REASON_NEW_STATION;
    protected static final int REASON_RESORTING;
    protected static final int REASON_PROGRAM_CHANGED;
    private static final int AREA_FIX_NAME;
    private static final int AREA_SCROLLING;
    private static final int AREA_FREQUENCY;
    private final LogChannel log;
    protected final TunerModels models;
    protected final BaseListModelApp listModel;
    protected final MenuModelApp menuModel;
    protected final AbstractAmFmStationlist$MenuModelListener menuModelListener;
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
    private final AbstractAmFmStationlist$StationComparator stComp;
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
        this.stComp = Utilities.isPiIgnore() ? new AbstractAmFmStationlist$StationComparatorPiIgnore(null) : new AbstractAmFmStationlist$StationComparatorEU(null);
        this.listModel = this.models.getBaseListModel(n);
        this.listModel.setListener(new AbstractAmFmStationlist$ListListener(this, tunerBasics.getModels(), n2));
        this.menuModel = this.models.getMenuModel(n2);
        this.menuModelListener = new AbstractAmFmStationlist$MenuModelListener(this);
        this.menuModel.setListener(this.menuModelListener);
        AbstractAmFmStationlist$TimerListener abstractAmFmStationlist$TimerListener = new AbstractAmFmStationlist$TimerListener(this, null);
        this.timerTmp = new Timer("timerTmp", 0, true, abstractAmFmStationlist$TimerListener);
        this.timerFocus = new Timer("timerFocus", 0, true, abstractAmFmStationlist$TimerListener);
        this.timerListUpdate = new Timer("timerListUpdate", Utilities.isStd() ? 0 : 0, true, abstractAmFmStationlist$TimerListener);
        this.imgType = tunerStorage.loadPreferredImageType();
    }

    @Override
    public void init(TunerStorage tunerStorage) {
        this.highlight(tunerStorage.getAMFMLSM(this.band));
    }

    @Override
    public void register(IStoreStationHandler iStoreStationHandler) {
        this.longPressHandler = iStoreStationHandler;
    }

    @Override
    public void register(ISearchBreak iSearchBreak, int n) {
        this.menuModelListener.register(iSearchBreak, n);
    }

    @Override
    public void register(IDrawerFocusManager iDrawerFocusManager) {
        this.drawerFocus = iDrawerFocusManager;
    }

    @Override
    public RadioInfo getDsiDownListener() {
        return this.dsiDownListener;
    }

    @Override
    public IPrevNext getPrevNextHandler() {
        return this.prevNextHandler;
    }

    @Override
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
        this.log.log(14808325, "[AbstractAmFmStationlist.doListUpdate]");
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
                            this.log.log(14808325, "[AbstractAmFmStationlist.doListUpdate] active station has index %1", (long)n);
                            this.lastList[n] = this.activeStation;
                            break block16;
                        } else {
                            this.log.log(-1601830656, "[AbstractAmFmStationlist.doListUpdate] active station already added -> ignore %1", (Object)this.lastList[n]);
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
                this.log.log(14808325, "[AbstractAmFmStationlist.doListUpdate] active station added temporary");
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
                    this.log.log(1078071040, "[AbstractAmFmStationlist.doListUpdate] focussed station was double");
                } else {
                    arrayList.add(this.rowFactory.getAmFmListRow(this.band, this.tmpAddedFocussedStation, this.recordSets, this.imgType));
                    this.log.log(14808325, "[AbstractAmFmStationlist.doListUpdate] focussed station added temporary");
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
        this.log.log(-2137614336, "[AbstractAmFmStationlist.highlight] %1", (Object)aMFMStation);
        int n = this.getUpdateReason(this.activeStation, aMFMStation);
        this.log.log(14808325, "[AbstractAmFmStationlist.highlight] reason %1", (long)n);
        if (n != 0) {
            int n2;
            this.activeStation = new AMFMStation(aMFMStation);
            int n3 = this.getIndex(aMFMStation);
            this.log.log(14808325, "[AbstractAmFmStationlist.highlight] index %1", (long)n3);
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

    @Override
    public boolean tuneById(long l, int n) {
        this.log.log(-2137614336, "[AbstractAmFmStationList#tuneById], id: %1", l);
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
    @Override
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
    @Override
    public AMFMStation getActiveStation() {
        Object object = this.mutex;
        synchronized (object) {
            return this.activeStation;
        }
    }

    @Override
    public boolean isEnsemble(int n) {
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void setPrefImgType(int n) {
        Object object = this.mutex;
        synchronized (object) {
            this.imgType = n;
            this.doListUpdate(true);
        }
    }

    static /* synthetic */ Timer access$500(AbstractAmFmStationlist abstractAmFmStationlist) {
        return abstractAmFmStationlist.timerTmp;
    }

    static /* synthetic */ AMFMStation access$602(AbstractAmFmStationlist abstractAmFmStationlist, AMFMStation aMFMStation) {
        abstractAmFmStationlist.tmpAddedStation = aMFMStation;
        return abstractAmFmStationlist.tmpAddedStation;
    }

    static /* synthetic */ Timer access$700(AbstractAmFmStationlist abstractAmFmStationlist) {
        return abstractAmFmStationlist.timerFocus;
    }

    static /* synthetic */ AMFMStation access$802(AbstractAmFmStationlist abstractAmFmStationlist, AMFMStation aMFMStation) {
        abstractAmFmStationlist.tmpAddedFocussedStation = aMFMStation;
        return abstractAmFmStationlist.tmpAddedFocussedStation;
    }

    static /* synthetic */ Timer access$900(AbstractAmFmStationlist abstractAmFmStationlist) {
        return abstractAmFmStationlist.timerListUpdate;
    }

    static /* synthetic */ boolean access$1000(AbstractAmFmStationlist abstractAmFmStationlist) {
        return abstractAmFmStationlist.listUpdateWaiting;
    }

    static /* synthetic */ boolean access$1100(AbstractAmFmStationlist abstractAmFmStationlist) {
        return abstractAmFmStationlist.cursorMoving;
    }

    static /* synthetic */ boolean access$1002(AbstractAmFmStationlist abstractAmFmStationlist, boolean bl) {
        abstractAmFmStationlist.listUpdateWaiting = bl;
        return abstractAmFmStationlist.listUpdateWaiting;
    }

    static /* synthetic */ int access$1200(AbstractAmFmStationlist abstractAmFmStationlist) {
        return abstractAmFmStationlist.band;
    }

    static /* synthetic */ boolean access$1102(AbstractAmFmStationlist abstractAmFmStationlist, boolean bl) {
        abstractAmFmStationlist.cursorMoving = bl;
        return abstractAmFmStationlist.cursorMoving;
    }

    static /* synthetic */ IStoreStationHandler access$1300(AbstractAmFmStationlist abstractAmFmStationlist) {
        return abstractAmFmStationlist.longPressHandler;
    }

    static /* synthetic */ IStoreHandler access$1400(AbstractAmFmStationlist abstractAmFmStationlist) {
        return abstractAmFmStationlist.storeHandler;
    }

    static /* synthetic */ IScanHandler access$1500(AbstractAmFmStationlist abstractAmFmStationlist) {
        return abstractAmFmStationlist.scanHandler;
    }

    static /* synthetic */ AMFMTuner access$1600(AbstractAmFmStationlist abstractAmFmStationlist) {
        return abstractAmFmStationlist.tuner;
    }

    static /* synthetic */ LogChannel access$1700(AbstractAmFmStationlist abstractAmFmStationlist) {
        return abstractAmFmStationlist.log;
    }

    static /* synthetic */ AbstractAmFmRow access$1802(AbstractAmFmStationlist abstractAmFmStationlist, AbstractAmFmRow abstractAmFmRow) {
        abstractAmFmStationlist.focussedRow = abstractAmFmRow;
        return abstractAmFmStationlist.focussedRow;
    }

    static /* synthetic */ IDrawerFocusManager access$1900(AbstractAmFmStationlist abstractAmFmStationlist) {
        return abstractAmFmStationlist.drawerFocus;
    }
}

