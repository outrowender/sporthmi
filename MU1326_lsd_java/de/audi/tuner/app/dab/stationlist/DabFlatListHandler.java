/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab.stationlist;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.atip.hmi.model.menu.MenuModelListener;
import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.RadioBaseListModelListener;
import de.audi.tuner.app.RadioComparators;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.TunerProxyManager;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.dab.DABDsiDownInfo;
import de.audi.tuner.app.dab.DABDsiUpInfo;
import de.audi.tuner.app.dab.DABTuner;
import de.audi.tuner.app.dab.DabReceptionStatus;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.dab.sortandindex.station.AbstractDabStationComparatorAndIndexer;
import de.audi.tuner.app.dab.sortandindex.station.SortAlgoDabGenre;
import de.audi.tuner.app.dab.sortandindex.station.SortAlgoDabStationName;
import de.audi.tuner.app.dab.stationlist.AbstractDABListHandler;
import de.audi.tuner.app.dab.stationlist.DabListRow;
import de.audi.tuner.app.dab.stationlist.RecordSets;
import de.audi.tuner.app.sortandindex.AlphabeticalIndexRow;
import de.audi.tuner.app.storage.TunerStorage;
import de.audi.tuner.ifc.AbstractListRowFactory;
import de.audi.tuner.ifc.AbstractRadioListRow;
import de.audi.tuner.ifc.IScanHandler;
import de.audi.tuner.ifc.IStoreStationHandler;
import de.audi.tuner.ifc.ITunerVariantExt;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DabFlatListHandler
extends AbstractDABListHandler {
    public final DABDsiUpInfo dsiUpListener = new DsiUpListener();
    public final DABDsiDownInfo dsiDownListener = new DsiDownListener();
    private final Logger logger;
    private final List listArray;
    private final DABTuner dabTuner;
    private List tmpAddedStations = new ArrayList(2);
    private DabListRow focussedRow = null;
    private DabStation[] allServicesAndComponents = new DabStation[0];
    private AbstractDabStationComparatorAndIndexer comparator;
    private final DabComparator servComp;
    private final BaseListModelApp listModel;
    private final BaseListModelApp indexListModel;
    private DabStation currentStation;
    private final AbstractListRowFactory rowFactory;
    private final RecordSets recordSets;
    private final IScanHandler scanHandler;
    private IStoreStationHandler longPressHandler;
    private final Timer timerTmp;
    private final Timer timerFocus;
    private final LanguageManager langMngr;
    private int imgType;
    private DabReceptionStatus reception = new DabReceptionStatus(0, 0);
    private volatile boolean listIsActive;

    public DabFlatListHandler(DABTuner dABTuner, TunerBasics tunerBasics, LanguageManager languageManager, ITunerVariantExt iTunerVariantExt, TunerStorage tunerStorage, IScanHandler iScanHandler) {
        TunerModels tunerModels = tunerBasics.getModels();
        this.dabTuner = dABTuner;
        this.logger = tunerBasics.getLogger();
        this.listArray = new ArrayList(300);
        this.langMngr = languageManager;
        this.comparator = new SortAlgoDabStationName(languageManager);
        this.rowFactory = iTunerVariantExt.getListRowFactory();
        this.currentStation = tunerStorage.loadLastDABService();
        this.listModel = tunerModels.getBaseListModel(100369);
        this.indexListModel = tunerModels.getBaseListModel(100921);
        this.recordSets = new RecordSets(this, 0);
        ListListener listListener = new ListListener(tunerModels, 100370);
        this.listModel.setListener(listListener);
        tunerModels.getMenuModel(100370).setListener(listListener);
        this.servComp = Utilities.isPGen1OrBentley() ? new PorscheComparator() : new AudiComparator();
        TimerListener timerListener = new TimerListener();
        this.timerTmp = new Timer("timerTmp", 5000L, true, timerListener);
        this.timerFocus = new Timer("timerFocus", 5000L, true, timerListener);
        this.scanHandler = iScanHandler;
        this.imgType = tunerStorage.loadPreferredImageType();
    }

    public void init() {
        this.doListUpdate();
    }

    public void register(IStoreStationHandler iStoreStationHandler) {
        this.longPressHandler = iStoreStationHandler;
    }

    public void setSortMode(int n) {
        if (Utilities.isPGen1OrBentley()) {
            switch (n) {
                case 0: {
                    this.comparator = new SortAlgoDabStationName(this.langMngr);
                    break;
                }
                case 2: {
                    this.comparator = new SortAlgoDabGenre(this.langMngr);
                    break;
                }
            }
            this.doListUpdate();
        }
        this.listIsActive = n != 1;
    }

    private void removeDoubleEntries(List list, List list2) {
        Iterator iterator = list.iterator();
        block0: while (iterator.hasNext()) {
            DabStation dabStation = (DabStation)iterator.next();
            Iterator iterator2 = list2.iterator();
            while (iterator2.hasNext()) {
                DabStation dabStation2 = (DabStation)iterator2.next();
                if (!this.servComp.equals(dabStation2, dabStation)) continue;
                iterator2.remove();
                continue block0;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void doListUpdate() {
        List list = this.listArray;
        synchronized (list) {
            Object object;
            Object object2;
            DabStation dabStation;
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(this.currentStation);
            if (this.currentStation.isComponent()) {
                arrayList.add(this.currentStation.getService());
            }
            ArrayList arrayList2 = new ArrayList(2);
            DabStation dabStation2 = dabStation = this.focussedRow != null ? this.focussedRow.station : null;
            if (dabStation != null) {
                arrayList2.add(dabStation);
                if (dabStation.isComponent()) {
                    arrayList2.add(dabStation.getService());
                }
            }
            List list2 = this.tmpAddedStations;
            this.removeDoubleEntries(arrayList, list2);
            this.removeDoubleEntries(arrayList, arrayList2);
            this.removeDoubleEntries(list2, arrayList2);
            this.listArray.clear();
            for (int i2 = 0; i2 < this.allServicesAndComponents.length; ++i2) {
                boolean bl = false;
                object2 = arrayList.iterator();
                while (object2.hasNext()) {
                    DabStation dabStation3 = (DabStation)object2.next();
                    if (!this.servComp.equals(this.allServicesAndComponents[i2], dabStation3)) continue;
                    this.allServicesAndComponents[i2] = dabStation3;
                    object2.remove();
                    bl = true;
                }
                object2 = list2.iterator();
                while (object2.hasNext()) {
                    if (!this.servComp.equals(this.allServicesAndComponents[i2], (DabStation)object2.next())) continue;
                    object2.remove();
                }
                object2 = arrayList2.iterator();
                while (object2.hasNext()) {
                    if (!this.servComp.equals(this.allServicesAndComponents[i2], (DabStation)object2.next())) continue;
                    object2.remove();
                }
                object2 = this.rowFactory.getDabListRow(this.recordSets, this.allServicesAndComponents[i2], false, this.imgType);
                if (bl) {
                    ((DabListRow)object2).setStationActive(true);
                    ((DabListRow)object2).setReceptionStatus(this.reception.syncStatus, this.reception.linkStatus);
                }
                this.listArray.add(object2);
            }
            if (!arrayList.isEmpty()) {
                object = arrayList.iterator();
                while (object.hasNext()) {
                    DabStation dabStation4 = (DabStation)object.next();
                    if (this.servComp.equals(dabStation4, this.currentStation)) {
                        object2 = this.rowFactory.getDabListRow(this.recordSets, this.currentStation, true, this.imgType);
                        ((DabListRow)object2).setStationActive(true);
                        ((DabListRow)object2).setReceptionStatus(this.reception.syncStatus, this.reception.linkStatus);
                        this.listArray.add(object2);
                        continue;
                    }
                    this.listArray.add(this.rowFactory.getDabListRow(this.recordSets, dabStation4, true, this.imgType));
                }
            } else {
                object = list2.iterator();
                while (object.hasNext()) {
                    DabStation dabStation5 = (DabStation)object.next();
                    this.listArray.add(this.rowFactory.getDabListRow(this.recordSets, dabStation5, true, this.imgType));
                }
            }
            if (!arrayList2.isEmpty()) {
                object = arrayList2.iterator();
                while (object.hasNext()) {
                    DabStation dabStation6 = (DabStation)object.next();
                    this.listArray.add(this.rowFactory.getDabListRow(this.recordSets, dabStation6, true, this.imgType));
                }
                this.timerFocus.restart();
            }
            if (!arrayList.isEmpty()) {
                this.tmpAddedStations = arrayList;
            } else {
                this.tmpAddedStations = list2;
                if (!list2.isEmpty() && !this.timerFocus.isRunning()) {
                    this.timerTmp.restart();
                }
            }
            object = this.comparator.sortAndProvideAlphabeticalIndexRowsFor(this.listArray);
            BaseListModelApp baseListModelApp = this.listModel.getEmptyCopy();
            baseListModelApp.append((EvoListRow[])this.listArray.toArray(new EvoListRow[this.listArray.size()]));
            baseListModelApp.setSelectedUniqueID(this.currentStation.getUniqueId());
            this.listModel.update(baseListModelApp);
            object2 = this.indexListModel.getEmptyCopy();
            if (!object.isEmpty()) {
                object2.append((AlphabeticalIndexRow[])object.toArray(new AlphabeticalIndexRow[object.size()]));
            }
            this.indexListModel.update((BaseListModelApp)object2);
        }
        if (this.listIsActive || Utilities.isPGen1OrBentley()) {
            this.propagateUpdatedStationList(5);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void highlightItem(DabStation dabStation, DabReceptionStatus dabReceptionStatus) {
        this.logger.dabList.log(10000000, "[DabFlatListHAndler.highlightItem] %1", (Object)dabStation);
        List list = this.listArray;
        synchronized (list) {
            boolean bl;
            int n = this.getReason(dabStation, dabReceptionStatus);
            boolean bl2 = bl = !this.reception.equals(dabReceptionStatus);
            if (n != 0) {
                DabListRow dabListRow;
                this.currentStation = dabStation;
                this.reception = dabReceptionStatus;
                SelectedItem selectedItem = this.listModel.getSelected();
                int n2 = selectedItem == null ? -1 : selectedItem.getIndex();
                int n3 = this.getIndex(dabStation);
                if (n3 == -1) {
                    this.doListUpdate();
                    return;
                }
                if (n2 != -1 && n2 != n3) {
                    dabListRow = (DabListRow)this.listArray.get(n2);
                    dabListRow.setStationActive(false);
                    dabListRow.resetReception();
                    if (dabListRow.isTmpAdded()) {
                        this.timerTmp.restart();
                    }
                    this.listModel.setRow(n2, dabListRow);
                }
                dabListRow = this.rowFactory.getDabListRow(this.recordSets, dabStation, false, this.imgType);
                dabListRow.setStationActive(true);
                dabListRow.setReceptionStatus(dabReceptionStatus.syncStatus, dabReceptionStatus.linkStatus);
                dabListRow.setProgramData(dabStation, this.imgType);
                this.listArray.set(n3, dabListRow);
                this.listModel.setRow(n3, dabListRow);
                this.listModel.setSelectedIndex(n3);
                if (bl && this.listIsActive) {
                    this.propagateUpdatedStationList(5);
                } else {
                    this.propagateUpdatedActiveStation(5);
                }
            }
        }
    }

    private int getReason(DabStation dabStation, DabReceptionStatus dabReceptionStatus) {
        if (!RadioComparators.equals(this.currentStation.ensemble, dabStation.ensemble)) {
            return 1;
        }
        if (!RadioComparators.equals(this.currentStation.service, dabStation.service)) {
            return 2;
        }
        if (!RadioComparators.equals(this.currentStation.component, dabStation.component)) {
            return 3;
        }
        String string = this.currentStation.getImage(this.imgType).getResourceURI();
        String string2 = dabStation.getImage(this.imgType).getResourceURI();
        if (!(this.currentStation.getRtPlus().equals(dabStation.getRtPlus()) && string.equals(string2) && this.reception.equals(dabReceptionStatus) && this.currentStation.getPTY() == dabStation.getPTY() && this.currentStation.getFullName().equals(dabStation.getFullName()) && this.currentStation.getShortName().equals(this.currentStation.getShortName()))) {
            return 4;
        }
        return 0;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private int getIndex(DabStation dabStation) {
        List list = this.listArray;
        synchronized (list) {
            Iterator iterator = this.listArray.iterator();
            int n = 0;
            while (iterator.hasNext()) {
                DabListRow dabListRow = (DabListRow)iterator.next();
                if (this.servComp.equals(dabStation, dabListRow.getDabStation())) {
                    return n;
                }
                ++n;
            }
        }
        return -1;
    }

    public TunerObjectContainer[] getStationList() {
        List list = this.listModel.asList();
        TunerObjectContainer[] tunerObjectContainerArray = new TunerObjectContainer[list.size()];
        for (int i2 = 0; i2 < tunerObjectContainerArray.length; ++i2) {
            tunerObjectContainerArray[i2] = ((AbstractRadioListRow)list.get(i2)).getTOContainer();
        }
        return tunerObjectContainerArray;
    }

    public DabListRow getNextObjectIndexFromList(boolean bl) {
        int n = this.listModel.getLength();
        if (n == 0 || n == 1) {
            return null;
        }
        int n2 = this.listModel.getSelected().getIndex();
        this.logger.hmi.log(100000000, "Active index DAB list is: %1 ", (long)n2);
        if (n2 == -1) {
            n2 = 0;
        }
        DabListRow dabListRow = null;
        for (int i2 = 0; i2 < n && dabListRow == null; ++i2) {
            n2 = this.getNextListIndex(bl, n, n2);
            this.logger.hmi.log(100000000, "Next index is: %1 ", (long)n2);
            dabListRow = (DabListRow)this.listModel.getRow(n2);
            if (!dabListRow.isEnsemble()) continue;
            dabListRow = null;
        }
        return dabListRow;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public TunerObjectContainer getActiveStation() {
        List list = this.listArray;
        synchronized (list) {
            TunerObjectContainer tunerObjectContainer = new TunerObjectContainer(this.currentStation);
            tunerObjectContainer.setReceptionStatus(this.reception.getReception());
            return tunerObjectContainer;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public DabStation getCurrentStation() {
        List list = this.listArray;
        synchronized (list) {
            return this.currentStation;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setPrefImgType(int n) {
        List list = this.listArray;
        synchronized (list) {
            this.imgType = n;
            this.doListUpdate();
        }
    }

    static /* synthetic */ DabStation[] access$602(DabFlatListHandler dabFlatListHandler, DabStation[] dabStationArray) {
        dabFlatListHandler.allServicesAndComponents = dabStationArray;
        return dabStationArray;
    }

    private class ListListener
    extends RadioBaseListModelListener
    implements MenuModelListener {
        public ListListener(TunerModels tunerModels, int n) {
            super(tunerModels, n);
        }

        public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            boolean bl;
            DabFlatListHandler.this.scanHandler.abortScan();
            boolean bl2 = bl = n3 == 6;
            if (bl) {
                if (DabFlatListHandler.this.longPressHandler != null) {
                    DabFlatListHandler.this.longPressHandler.prepareStore(n4, ((AbstractRadioListRow)evoListRow).getTOContainer());
                }
            } else if (this.isNewSelection(evoListRow, n, n2, n3, n4)) {
                DabStation dabStation = ((DabListRow)evoListRow).getDabStation();
                DabStation dabStation2 = DabFlatListHandler.this.dabTuner.getActiveStation();
                DabStation dabStation3 = RadioComparators.equals(dabStation2, dabStation) ? dabStation2 : dabStation;
                TunerProxyManager.getInstance().getDABTuner().selectStation(dabStation3, dabStation3.isComponent() ? 3 : 1, n4);
            }
        }

        public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            DabFlatListHandler.this.scanHandler.abortScan();
            if (n2 != DabFlatListHandler.this.listModel.getSelected().getIndex()) {
                DabStation dabStation = ((DabListRow)evoListRow).getDabStation();
                TunerProxyManager.getInstance().getDABTuner().selectStation(dabStation, 0, n4);
            }
            if (DabFlatListHandler.this.longPressHandler != null) {
                DabFlatListHandler.this.longPressHandler.prepareStore(n4, ((AbstractRadioListRow)evoListRow).getTOContainer());
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            List list = DabFlatListHandler.this.listArray;
            synchronized (list) {
                DabFlatListHandler.this.focussedRow = (DabListRow)evoListRow;
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void itemFocused(int n, int n2, long l, int n3) {
            if (n != 100369) {
                List list = DabFlatListHandler.this.listArray;
                synchronized (list) {
                    DabFlatListHandler.this.focussedRow = null;
                }
            }
        }
    }

    private static interface DabComparator {
        public boolean equals(DabStation var1, DabStation var2);
    }

    private class DsiUpListener
    extends DABDsiUpInfo {
        private DsiUpListener() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void listUpdate(DabStation[] dabStationArray, DabStation[] dabStationArray2, DabStation[] dabStationArray3) {
            List list = DabFlatListHandler.this.listArray;
            synchronized (list) {
                DabStation[] dabStationArray4 = Utilities.isPGen1OrBentley() ? dabStationArray2 : this.removeDoubleServices(dabStationArray2);
                DabFlatListHandler.access$602(DabFlatListHandler.this, new DabStation[dabStationArray4.length + dabStationArray3.length]);
                System.arraycopy((Object)dabStationArray4, 0, (Object)DabFlatListHandler.this.allServicesAndComponents, 0, dabStationArray4.length);
                System.arraycopy((Object)dabStationArray3, 0, (Object)DabFlatListHandler.this.allServicesAndComponents, dabStationArray4.length, dabStationArray3.length);
                DabFlatListHandler.this.doListUpdate();
            }
        }

        private DabStation[] removeDoubleServices(DabStation[] dabStationArray) {
            SimpleIntObjectMap simpleIntObjectMap = new SimpleIntObjectMap(dabStationArray.length);
            for (int i2 = 0; i2 < dabStationArray.length; ++i2) {
                simpleIntObjectMap.add((int)dabStationArray[i2].service.sID, dabStationArray[i2]);
            }
            Object[] objectArray = simpleIntObjectMap.getValues();
            DabStation[] dabStationArray2 = new DabStation[objectArray.length];
            for (int i3 = 0; i3 < dabStationArray2.length; ++i3) {
                dabStationArray2[i3] = (DabStation)objectArray[i3];
            }
            return dabStationArray2;
        }

        public void updateCurrentStation(DabStation dabStation, DabReceptionStatus dabReceptionStatus) {
            DabFlatListHandler.this.highlightItem(dabStation, dabReceptionStatus);
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
            if (timer.equals(DabFlatListHandler.this.timerTmp)) {
                List list = DabFlatListHandler.this.listArray;
                synchronized (list) {
                    DabFlatListHandler.this.tmpAddedStations = new ArrayList(0);
                    DabFlatListHandler.this.doListUpdate();
                }
            }
            List list = DabFlatListHandler.this.listArray;
            synchronized (list) {
                DabFlatListHandler.this.doListUpdate();
            }
        }
    }

    private static class AudiComparator
    implements DabComparator {
        private AudiComparator() {
        }

        public boolean equals(DabStation dabStation, DabStation dabStation2) {
            if (dabStation == null || dabStation2 == null) {
                return false;
            }
            if (dabStation.isService() && dabStation2.isService()) {
                return dabStation.service.sID == dabStation2.service.sID;
            }
            return RadioComparators.equals(dabStation, dabStation2);
        }
    }

    private class DsiDownListener
    extends DABDsiDownInfo {
        private DsiDownListener() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void preTuneAction(DabStation dabStation, DabReceptionStatus dabReceptionStatus, int n) {
            List list = DabFlatListHandler.this.listArray;
            synchronized (list) {
                DabFlatListHandler.this.highlightItem(dabStation, dabReceptionStatus);
            }
        }
    }

    private static class PorscheComparator
    implements DabComparator {
        private PorscheComparator() {
        }

        public boolean equals(DabStation dabStation, DabStation dabStation2) {
            return RadioComparators.equals(dabStation, dabStation2);
        }
    }
}

