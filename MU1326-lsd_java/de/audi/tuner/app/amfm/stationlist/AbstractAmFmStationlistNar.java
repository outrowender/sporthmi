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
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.DrawerFocusManager;
import de.audi.tuner.app.IDrawerFocusManager;
import de.audi.tuner.app.IStoreHandler;
import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.MemoryListHandler;
import de.audi.tuner.app.PresetIds;
import de.audi.tuner.app.RadioObjectIds;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.TunerProxyManager;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.AMFMTuner;
import de.audi.tuner.app.amfm.dsi.AMFMDsiDownInfo;
import de.audi.tuner.app.amfm.dsi.RadioInfo;
import de.audi.tuner.app.amfm.stationlist.AbstractAmFmRow;
import de.audi.tuner.app.amfm.stationlist.AbstractAmFmStationlistNar$DsiDownListener;
import de.audi.tuner.app.amfm.stationlist.AbstractAmFmStationlistNar$MenuModelListener;
import de.audi.tuner.app.amfm.stationlist.AbstractAmFmStationlistNar$PrevNextHandler;
import de.audi.tuner.app.amfm.stationlist.AbstractAmFmStationlistNar$TimerListener;
import de.audi.tuner.app.amfm.stationlist.IAmFmStationList;
import de.audi.tuner.app.amfm.stationlist.RecordSets;
import de.audi.tuner.app.amfm.stationlist.RowSortAlgoAlphabeticallyNAR;
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
import de.audi.tuner.ifc.ISimpleTuner;
import de.audi.tuner.ifc.IStationListHandler;
import de.audi.tuner.ifc.IStoreStationHandler;
import de.audi.tuner.sds.UpdateListenerHandler;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractAmFmStationlistNar
extends UpdateListenerHandler
implements IStationListHandler,
IAmFmStationList {
    private final AMFMDsiDownInfo dsiDownListener = new AbstractAmFmStationlistNar$DsiDownListener(this, null);
    private final IPrevNext prevNextHandler = new AbstractAmFmStationlistNar$PrevNextHandler(this, null);
    static final int[] allChannels = new int[]{1, 2, 4, 8, 16, 32, 64, 128};
    public static final int SORT_ALGO_ALPHABETICAL;
    private static final int SORT_ALGO_PI_ASC;
    public static final int SORT_ALGO_FREQ;
    private static final int SORT_ALGO_GENRE;
    private static final int SORT_ALGO_SIGNAL;
    private static final int REASON_NONE;
    private static final int REASON_NEW_STATION;
    private static final int REASON_HD_STRUCT_CHANGED;
    private final LogChannel log;
    private final TunerModels models;
    protected final BaseListModelApp listModel;
    protected final MenuModelApp listMenuModel;
    protected final AbstractAmFmStationlistNar$MenuModelListener menuModelListener;
    private final AbstractListRowFactory rowFactory;
    private final AMFMTuner tuner;
    protected final RecordSets recordSets;
    private final LanguageManager langMngr;
    private final IStoreHandler storeHandler;
    private final MemoryListHandler memoryListHandler;
    private boolean updateWaiting;
    protected final Object mutex = new Object();
    private List tmpAddedStation = new ArrayList();
    private List tmpAddedFocussedStation = new ArrayList();
    private AbstractAmFmRow focussedRow = null;
    private AMFMStation activeStation = new AMFMStation();
    private Comparator comparator;
    protected AMFMStation[] lastList = new AMFMStation[0];
    private final Timer timerTmp;
    private final Timer timerFocus;
    private final Timer timerListUpdate;
    private final int band;
    private IStoreStationHandler longPressHandler;
    private final IScanHandler scanHandler;
    private int imgType;
    private boolean cursorMoving = false;
    private boolean listUpdateWaiting = false;
    private IDrawerFocusManager drawerFocus = DrawerFocusManager.NULL_DRAWER_FOCUS_MANAGER;

    AbstractAmFmStationlistNar(TunerBasics tunerBasics, int n, int n2, RecordSets recordSets, AbstractListRowFactory abstractListRowFactory, AMFMTuner aMFMTuner, int n3, LanguageManager languageManager, IScanHandler iScanHandler, TunerStorage tunerStorage, IStoreHandler iStoreHandler, MemoryListHandler memoryListHandler, int n4) {
        this.log = tunerBasics.getLogger().amfmList;
        this.models = tunerBasics.getModels();
        this.recordSets = recordSets;
        this.rowFactory = abstractListRowFactory;
        this.tuner = aMFMTuner;
        this.band = n3;
        this.langMngr = languageManager;
        this.scanHandler = iScanHandler;
        this.storeHandler = iStoreHandler;
        this.memoryListHandler = memoryListHandler;
        this.listModel = this.models.getBaseListModel(n);
        this.listMenuModel = this.models.getMenuModel(n2);
        this.menuModelListener = new AbstractAmFmStationlistNar$MenuModelListener(this);
        this.listMenuModel.setListener(this.menuModelListener);
        this.mkNewAlgo(n4);
        AbstractAmFmStationlistNar$TimerListener abstractAmFmStationlistNar$TimerListener = new AbstractAmFmStationlistNar$TimerListener(this, null);
        this.timerTmp = new Timer("timerTmp", 0, true, abstractAmFmStationlistNar$TimerListener);
        this.timerFocus = new Timer("timerFocus", 0, true, abstractAmFmStationlistNar$TimerListener);
        this.timerListUpdate = new Timer("timerListUpdate", Utilities.isStd() ? 0 : 0, true, abstractAmFmStationlistNar$TimerListener);
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
        this.doListUpdate(true);
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
                this.comparator = new RowSortAlgoAlphabeticallyNAR(this.langMngr);
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
        this.log.log(14808325, "[AbstractAmFmStationlistNar.doListUpdate] %1", (Object)this.activeStation);
        Object object = this.mutex;
        synchronized (object) {
            Object object2;
            Object object3;
            AMFMStation aMFMStation;
            ArrayList arrayList = new ArrayList(this.lastList.length + 10);
            if (this.cursorMoving && !bl) {
                this.listUpdateWaiting = true;
                return;
            }
            this.listUpdateWaiting = false;
            List list = this.hdStruct2Channels(this.activeStation);
            ArrayList arrayList2 = new ArrayList();
            AMFMStation aMFMStation2 = aMFMStation = this.focussedRow != null ? this.focussedRow.getStation() : null;
            if (aMFMStation != null) {
                arrayList2.add(new AMFMStation(aMFMStation));
                if (aMFMStation.serviceId > 1) {
                    AMFMStation aMFMStation3 = new AMFMStation(aMFMStation);
                    aMFMStation3.serviceId = 1;
                    arrayList2.add(aMFMStation3);
                }
            }
            this.removeDoubleEntries(list, arrayList2);
            this.removeDoubleEntries(list, this.tmpAddedStation);
            this.removeDoubleEntries(this.tmpAddedStation, arrayList2);
            boolean bl2 = false;
            for (int i2 = 0; i2 < this.lastList.length; ++i2) {
                block24: {
                    if (this.equals(this.lastList[i2], this.activeStation)) {
                        if (!bl2) {
                            bl2 = true;
                            object3 = this.rowFactory.getAmFmListRow(this.band, this.activeStation, this.recordSets, this.imgType);
                            ((AbstractAmFmRow)object3).setProgramData(this.activeStation, this.imgType, this.tuner.getStatus());
                            ((AbstractAmFmRow)object3).setStationActive(true);
                            arrayList.add(object3);
                            this.log.log(14808325, "[AbstractAmFmStationlistNar.doListUpdate] active station has index %1", (long)i2);
                            this.lastList[i2] = new AMFMStation(this.activeStation);
                            this.lastList[i2].resetProgramData();
                            break block24;
                        } else {
                            this.log.log(10000, "[AbstractAmFmStationlistNar.doListUpdate] active station already added -> ignore %1", (Object)this.lastList[i2]);
                            continue;
                        }
                    }
                    arrayList.add(this.rowFactory.getAmFmListRow(this.band, this.lastList[i2], this.recordSets, this.imgType));
                }
                object3 = arrayList2.iterator();
                while (object3.hasNext()) {
                    object2 = (AMFMStation)object3.next();
                    if (!this.equals((AMFMStation)object2, this.lastList[i2])) continue;
                    this.log.log(14808325, "[AbstractAmFmStationlistNar.doListUpdate] remove focussed %1", object2);
                    object3.remove();
                }
                object3 = list.iterator();
                while (object3.hasNext()) {
                    object2 = (AMFMStation)object3.next();
                    if (!this.equals(this.lastList[i2], (AMFMStation)object2)) continue;
                    object3.remove();
                }
                object3 = this.tmpAddedStation.iterator();
                while (object3.hasNext()) {
                    object2 = (AMFMStation)object3.next();
                    if (!this.equals(this.lastList[i2], (AMFMStation)object2)) continue;
                    object3.remove();
                }
            }
            if (list.isEmpty()) {
                if (!this.tmpAddedStation.isEmpty()) {
                    Iterator iterator = this.tmpAddedStation.iterator();
                    while (iterator.hasNext()) {
                        object3 = (AMFMStation)iterator.next();
                        ((AMFMStation)object3).setTmpAdded(true);
                        ((AMFMStation)object3).setAudioStatus(1);
                        object2 = this.rowFactory.getAmFmListRow(this.band, (AMFMStation)object3, this.recordSets, this.imgType);
                        arrayList.add(object2);
                        this.log.log(14808325, "[AbstractAmFmStationlistNar.doListUpdate] add temp station %1", object3);
                    }
                    this.timerTmp.restart();
                }
            } else {
                this.tmpAddedStation = list;
                Iterator iterator = list.iterator();
                while (iterator.hasNext()) {
                    Object object4;
                    object3 = (AMFMStation)iterator.next();
                    ((AMFMStation)object3).setTmpAdded(true);
                    boolean bl3 = false;
                    if (((AMFMStation)object3).serviceId == this.activeStation.serviceId) {
                        bl3 = true;
                    } else {
                        object4 = this.memoryListHandler.getPresetIds(new TunerObjectContainer(object3));
                        if (((PresetIds)object4).posId > 0) {
                            ((AMFMStation)object3).setPresetPos(((PresetIds)object4).posId);
                        }
                    }
                    object4 = this.rowFactory.getAmFmListRow(this.band, (AMFMStation)object3, this.recordSets, this.imgType);
                    if (bl3) {
                        ((AbstractAmFmRow)object4).setProgramData((AMFMStation)object3, this.imgType, this.tuner.getStatus());
                    }
                    ((AbstractAmFmRow)object4).setStationActive(bl3);
                    arrayList.add(object4);
                    this.log.log(14808325, "[AbstractAmFmStationlistNar.doListUpdate] active station added temporary");
                }
            }
            if (!arrayList2.isEmpty()) {
                this.tmpAddedFocussedStation = arrayList2;
                this.timerFocus.restart();
                Iterator iterator = arrayList2.iterator();
                while (iterator.hasNext()) {
                    object3 = (AMFMStation)iterator.next();
                    this.log.log(14808325, "[AbstractAmFmStationlistNar.doListUpdate] focussed station added temporary %1", object3);
                    ((AMFMStation)object3).setTmpAdded(true);
                    AbstractAmFmRow abstractAmFmRow = this.rowFactory.getAmFmListRow(this.band, (AMFMStation)object3, this.recordSets, this.imgType);
                    arrayList.add(abstractAmFmRow);
                }
            } else {
                this.focussedRow = null;
            }
            Collections.sort(arrayList, this.comparator);
            BaseListModelApp baseListModelApp = this.listModel.getEmptyCopy();
            baseListModelApp.append((EvoListRow[])arrayList.toArray(new EvoListRow[arrayList.size()]));
            baseListModelApp.setSelectedUniqueID(this.activeStation.getUniqueId());
            this.listModel.update(baseListModelApp);
        }
        this.propagateUpdatedStationList(this.band);
        boolean bl4 = this.activeStation.getAudioStatus() == 3;
        this.propagateUpdatedMuteStatus(this.band, bl4);
    }

    private void removeDoubleEntries(List list, List list2) {
        Iterator iterator = list.iterator();
        block0: while (iterator.hasNext()) {
            AMFMStation aMFMStation = (AMFMStation)iterator.next();
            Iterator iterator2 = list2.iterator();
            while (iterator2.hasNext()) {
                AMFMStation aMFMStation2 = (AMFMStation)iterator2.next();
                if (!this.equals(aMFMStation2, aMFMStation)) continue;
                iterator2.remove();
                continue block0;
            }
        }
    }

    private boolean equals(AMFMStation aMFMStation, AMFMStation aMFMStation2) {
        if (aMFMStation == null || aMFMStation2 == null) {
            return false;
        }
        return aMFMStation.frequency == aMFMStation2.frequency && aMFMStation.serviceId == aMFMStation2.serviceId;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void highlight(AMFMStation aMFMStation) {
        this.log.log(-2137614336, "[AbstractAmFmStationlistNar.highlight] %1", (Object)aMFMStation);
        this.log.log(-2137614336, "[AbstractAmFmStationlistNar.highlight] audio %1, hdStruct %2", (long)aMFMStation.getAudioStatus(), (long)aMFMStation.getHdStructure());
        int n = this.getUpdateReason(this.activeStation, aMFMStation);
        this.log.log(14808325, "[AbstractAmFmStationlistNar.highlight] reason %1", (long)n);
        if (n != 0) {
            int n2;
            boolean bl = this.activeStation.getAudioStatus() == 3;
            boolean bl2 = aMFMStation.getAudioStatus() == 3;
            this.activeStation = new AMFMStation(aMFMStation);
            int n3 = this.getIndex(aMFMStation);
            this.log.log(14808325, "[AbstractAmFmStationlistNar.highlight] index %1", (long)n3);
            if (n3 == -1) {
                this.doListUpdate(true);
                return;
            }
            if (n == 2) {
                Object object = this.mutex;
                synchronized (object) {
                    ArrayList arrayList = new ArrayList(this.lastList.length);
                    for (int i2 = 0; i2 < this.lastList.length; ++i2) {
                        AMFMStation aMFMStation2 = this.lastList[i2];
                        if (aMFMStation2.frequency == aMFMStation.frequency) {
                            int n4 = aMFMStation.getHdStructure();
                            if ((n4 & aMFMStation2.serviceId) != aMFMStation2.serviceId) continue;
                            arrayList.add(aMFMStation2);
                            continue;
                        }
                        arrayList.add(aMFMStation2);
                    }
                    this.lastList = (AMFMStation[])arrayList.toArray(new AMFMStation[arrayList.size()]);
                }
                this.doListUpdate(true);
                return;
            }
            SelectedItem selectedItem = this.listModel.getSelected();
            int n5 = n2 = selectedItem == null ? -1 : selectedItem.getIndex();
            if (n2 != -1 && n2 != n3) {
                AbstractAmFmRow abstractAmFmRow = (AbstractAmFmRow)this.listModel.getRow(n2);
                abstractAmFmRow.setStationActive(false);
                if (abstractAmFmRow.isTmpAdded()) {
                    this.timerTmp.restart();
                }
                this.listModel.setRow(n2, abstractAmFmRow);
            }
            boolean bl3 = ((AbstractAmFmRow)this.listModel.getRow(n3)).isTmpAdded();
            aMFMStation.setTmpAdded(bl3);
            AbstractAmFmRow abstractAmFmRow = this.rowFactory.getAmFmListRow(this.band, aMFMStation, this.recordSets, this.imgType);
            abstractAmFmRow.setProgramData(aMFMStation, this.imgType, this.tuner.getStatus());
            abstractAmFmRow.setStationActive(true);
            abstractAmFmRow.setSeparatorLine(0);
            abstractAmFmRow.setHdStatus(aMFMStation.getAudioStatus());
            this.listModel.setRow(n3, abstractAmFmRow);
            this.listModel.setSelectedIndex(n3);
            if (this.updateWaiting) {
                this.listMenuModel.trigger(ModelTrigger.JOIN_CURSOR);
                this.updateWaiting = false;
            }
            if (bl != bl2) {
                this.propagateUpdatedMuteStatus(this.band, bl2);
            }
            this.propagateUpdatedStationList(this.band);
        }
    }

    private int getUpdateReason(AMFMStation aMFMStation, AMFMStation aMFMStation2) {
        if (aMFMStation.frequency == aMFMStation2.frequency && aMFMStation.getHdStructure() != aMFMStation2.getHdStructure()) {
            return 2;
        }
        return 1;
    }

    protected int getIndex(AMFMStation aMFMStation) {
        SimpleIntObjectMap simpleIntObjectMap = new SimpleIntObjectMap(8);
        for (int i2 = 0; i2 < this.listModel.getLength(); ++i2) {
            AMFMStation aMFMStation2 = ((AbstractAmFmRow)this.listModel.getRow(i2)).getStation();
            if (aMFMStation.frequency != aMFMStation2.frequency) continue;
            simpleIntObjectMap.add(i2, aMFMStation2);
        }
        int[] nArray = this.hdStruct2Channels(aMFMStation.getHdStructure());
        int n = 0;
        int n2 = -1;
        Object[] objectArray = simpleIntObjectMap.getValues();
        block1: for (int i3 = 0; i3 < nArray.length; ++i3) {
            for (int i4 = 0; i4 < objectArray.length; ++i4) {
                if ((((AMFMStation)objectArray[i4]).serviceId & nArray[i3]) == 0) continue;
                ++n;
                if (nArray[i3] != aMFMStation.serviceId) continue block1;
                n2 = i4;
                continue block1;
            }
        }
        if (n == nArray.length && n2 != -1) {
            return simpleIntObjectMap.getKeys()[n2];
        }
        return -1;
    }

    private int[] hdStruct2Channels(int n) {
        if (n == 0) {
            return new int[]{1};
        }
        int[] nArray = new int[8];
        int n2 = 0;
        for (int i2 = 0; i2 < allChannels.length; ++i2) {
            if ((n & allChannels[i2]) == 0) continue;
            nArray[n2++] = allChannels[i2];
        }
        int[] nArray2 = new int[n2];
        System.arraycopy((Object)nArray, 0, (Object)nArray2, 0, n2);
        return nArray2;
    }

    private List hdStruct2Channels(AMFMStation aMFMStation) {
        int[] nArray = this.hdStruct2Channels(aMFMStation.getHdStructure());
        ArrayList arrayList = new ArrayList(nArray.length);
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            AMFMStation aMFMStation2 = new AMFMStation(aMFMStation);
            aMFMStation2.serviceId = nArray[i2];
            if (aMFMStation2.serviceId != aMFMStation.serviceId) {
                aMFMStation2.setAudioStatus(1);
                aMFMStation2.setPresetPos(0);
                aMFMStation2.stationArt = ISimpleTuner.EMPTY_DSI_RL;
            }
            arrayList.add(aMFMStation2);
        }
        return arrayList;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean tuneById(long l, int n) {
        AbstractAmFmRow abstractAmFmRow;
        this.log.log(-2137614336, "[AbstractAmFmStationList#tuneById], id: %1", l);
        Object object = this.mutex;
        synchronized (object) {
            abstractAmFmRow = (AbstractAmFmRow)this.listModel.getRowByUniqueID(l);
        }
        if (abstractAmFmRow != null) {
            this.tuner.tuneStation(abstractAmFmRow.getStation(), false, false, n);
            return true;
        }
        object = new RadioObjectIds((long)l, (LogChannel)this.log).toc;
        if (object != null) {
            TunerProxyManager.getInstance().prepareAndTune((TunerObjectContainer)object, n);
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
        List list = null;
        TunerObjectContainer[] tunerObjectContainerArray = this.mutex;
        synchronized (this.mutex) {
            list = this.listModel.asList();
            // ** MonitorExit[var2_2] (shouldn't be in output)
            tunerObjectContainerArray = new TunerObjectContainer[list.size()];
            int n = 0;
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                AbstractRadioListRow abstractRadioListRow = (AbstractRadioListRow)iterator.next();
                tunerObjectContainerArray[n] = abstractRadioListRow.getTOContainer();
                ++n;
            }
            return tunerObjectContainerArray;
        }
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

    static /* synthetic */ Timer access$300(AbstractAmFmStationlistNar abstractAmFmStationlistNar) {
        return abstractAmFmStationlistNar.timerTmp;
    }

    static /* synthetic */ List access$400(AbstractAmFmStationlistNar abstractAmFmStationlistNar) {
        return abstractAmFmStationlistNar.tmpAddedStation;
    }

    static /* synthetic */ Timer access$500(AbstractAmFmStationlistNar abstractAmFmStationlistNar) {
        return abstractAmFmStationlistNar.timerFocus;
    }

    static /* synthetic */ List access$600(AbstractAmFmStationlistNar abstractAmFmStationlistNar) {
        return abstractAmFmStationlistNar.tmpAddedFocussedStation;
    }

    static /* synthetic */ Timer access$700(AbstractAmFmStationlistNar abstractAmFmStationlistNar) {
        return abstractAmFmStationlistNar.timerListUpdate;
    }

    static /* synthetic */ boolean access$800(AbstractAmFmStationlistNar abstractAmFmStationlistNar) {
        return abstractAmFmStationlistNar.listUpdateWaiting;
    }

    static /* synthetic */ boolean access$900(AbstractAmFmStationlistNar abstractAmFmStationlistNar) {
        return abstractAmFmStationlistNar.cursorMoving;
    }

    static /* synthetic */ boolean access$802(AbstractAmFmStationlistNar abstractAmFmStationlistNar, boolean bl) {
        abstractAmFmStationlistNar.listUpdateWaiting = bl;
        return abstractAmFmStationlistNar.listUpdateWaiting;
    }

    static /* synthetic */ boolean access$1002(AbstractAmFmStationlistNar abstractAmFmStationlistNar, boolean bl) {
        abstractAmFmStationlistNar.updateWaiting = bl;
        return abstractAmFmStationlistNar.updateWaiting;
    }

    static /* synthetic */ int access$1100(AbstractAmFmStationlistNar abstractAmFmStationlistNar) {
        return abstractAmFmStationlistNar.band;
    }

    static /* synthetic */ TunerModels access$1200(AbstractAmFmStationlistNar abstractAmFmStationlistNar) {
        return abstractAmFmStationlistNar.models;
    }

    static /* synthetic */ boolean access$902(AbstractAmFmStationlistNar abstractAmFmStationlistNar, boolean bl) {
        abstractAmFmStationlistNar.cursorMoving = bl;
        return abstractAmFmStationlistNar.cursorMoving;
    }

    static /* synthetic */ IStoreStationHandler access$1300(AbstractAmFmStationlistNar abstractAmFmStationlistNar) {
        return abstractAmFmStationlistNar.longPressHandler;
    }

    static /* synthetic */ IStoreHandler access$1400(AbstractAmFmStationlistNar abstractAmFmStationlistNar) {
        return abstractAmFmStationlistNar.storeHandler;
    }

    static /* synthetic */ IScanHandler access$1500(AbstractAmFmStationlistNar abstractAmFmStationlistNar) {
        return abstractAmFmStationlistNar.scanHandler;
    }

    static /* synthetic */ AMFMTuner access$1600(AbstractAmFmStationlistNar abstractAmFmStationlistNar) {
        return abstractAmFmStationlistNar.tuner;
    }

    static /* synthetic */ LogChannel access$1700(AbstractAmFmStationlistNar abstractAmFmStationlistNar) {
        return abstractAmFmStationlistNar.log;
    }

    static /* synthetic */ AbstractAmFmRow access$1802(AbstractAmFmStationlistNar abstractAmFmStationlistNar, AbstractAmFmRow abstractAmFmRow) {
        abstractAmFmStationlistNar.focussedRow = abstractAmFmRow;
        return abstractAmFmStationlistNar.focussedRow;
    }

    static /* synthetic */ AbstractAmFmRow access$1800(AbstractAmFmStationlistNar abstractAmFmStationlistNar) {
        return abstractAmFmStationlistNar.focussedRow;
    }

    static /* synthetic */ IDrawerFocusManager access$1900(AbstractAmFmStationlistNar abstractAmFmStationlistNar) {
        return abstractAmFmStationlistNar.drawerFocus;
    }
}

