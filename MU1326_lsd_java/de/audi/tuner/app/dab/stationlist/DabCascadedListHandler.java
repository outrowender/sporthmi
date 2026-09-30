/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab.stationlist;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.RadioBaseListModelListener;
import de.audi.tuner.app.RadioComparators;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.dab.DABDsiDownInfo;
import de.audi.tuner.app.dab.DABDsiUpInfo;
import de.audi.tuner.app.dab.DABTuner;
import de.audi.tuner.app.dab.DabReceptionStatus;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.dab.sortandindex.station.SortAlgoDabGenre;
import de.audi.tuner.app.dab.sortandindex.station.SortAlgoDabStationName;
import de.audi.tuner.app.dab.stationlist.AbstractDABListHandler;
import de.audi.tuner.app.dab.stationlist.ComparatorComponent;
import de.audi.tuner.app.dab.stationlist.ComparatorEnsemble;
import de.audi.tuner.app.dab.stationlist.DABListMemory;
import de.audi.tuner.app.dab.stationlist.DabListRow;
import de.audi.tuner.app.dab.stationlist.RecordSets;
import de.audi.tuner.app.storage.TunerStorage;
import de.audi.tuner.ifc.AbstractListRowFactory;
import de.audi.tuner.ifc.AbstractRadioListRow;
import de.audi.tuner.ifc.IScanHandler;
import de.audi.tuner.ifc.IStoreStationHandler;
import de.audi.tuner.ifc.ITunerVariantExt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.ServiceInfo;

public class DabCascadedListHandler
extends AbstractDABListHandler {
    public final DABDsiUpInfo dsiUpListener = new DsiUpListener();
    public final DABDsiDownInfo dsiDownListener = new DsiDownListener();
    private final Logger logger;
    private final DABTuner dabTuner;
    private final LanguageManager langMngr;
    private final IScanHandler scanHandler;
    private final AbstractListRowFactory rowFactory;
    private IStoreStationHandler longPressHandler;
    private DabStation[] components = new DabStation[0];
    private DabStation[] ensembles = new DabStation[0];
    private DabStation[] services = new DabStation[0];
    private DabStation currentStation = null;
    private DabStation currentEnsemble = null;
    private final DABListMemory orgLists = new DABListMemory();
    private DabStation tmpAddedEnsemble;
    private DabStation tmpAddedService;
    private DabStation tmpAddedComponent;
    private final BaseListModelApp ensembleList;
    private final BaseListModelApp serviceList;
    private final LabelModelApp curEnsembleNameLabel;
    private Comparator serviceComparator;
    private final RecordSets ensembleRecordSets;
    private final RecordSets serviceRecordSets;
    private int imgType;
    private final Object mutex = new Object();

    public DabCascadedListHandler(DABTuner dABTuner, TunerBasics tunerBasics, TunerStorage tunerStorage, ITunerVariantExt iTunerVariantExt, LanguageManager languageManager, IScanHandler iScanHandler) {
        this.logger = tunerBasics.getLogger();
        this.dabTuner = dABTuner;
        this.currentStation = tunerStorage.loadLastDABService();
        this.currentEnsemble = new DabStation(this.currentStation.ensemble);
        this.langMngr = languageManager;
        this.imgType = tunerStorage.loadPreferredImageType();
        this.ensembleList = tunerBasics.getModels().getBaseListModel(100668);
        this.serviceList = tunerBasics.getModels().getBaseListModel(100667);
        this.curEnsembleNameLabel = tunerBasics.getModels().getLabelModel(100886);
        this.serviceComparator = new SortAlgoDabStationName(languageManager);
        ListListener listListener = new ListListener(tunerBasics.getModels(), 100370);
        this.ensembleList.setListener(listListener);
        this.serviceList.setListener(listListener);
        this.ensembleRecordSets = new RecordSets(this, 0);
        this.serviceRecordSets = new RecordSets(this, 1);
        this.rowFactory = iTunerVariantExt.getListRowFactory();
        this.scanHandler = iScanHandler;
    }

    public void register(IStoreStationHandler iStoreStationHandler) {
        this.longPressHandler = iStoreStationHandler;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void init() {
        this.adjustTemporaryInformation();
        Object object = this.ensembleList;
        synchronized (object) {
            this.buildEnsembleList();
        }
        object = this.mutex;
        synchronized (object) {
            this.buildServiceList(this.currentEnsemble.ensemble);
        }
    }

    public DabStation getCurrentStation() {
        return this.currentStation;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void highlightItem(DabStation dabStation, DabReceptionStatus dabReceptionStatus) {
        int n;
        this.logger.dabList.log(10000000, "[DabCascadedListHandler.highlightItem] %1", (Object)dabStation);
        this.currentStation = dabStation;
        Object object = this.mutex;
        synchronized (object) {
            DabListRow dabListRow = this.createRow(dabStation, this.serviceRecordSets);
            n = this.serviceList.getIndexForUniqueID(dabListRow.getUniqueID());
            if (n != -1) {
                this.adjustTemporaryInformation();
                this.serviceList.setRow(n, dabListRow);
                this.serviceList.setSelectedUniqueID(dabListRow.getUniqueID());
                this.setReceptionStatus(dabReceptionStatus.syncStatus, dabReceptionStatus.linkStatus);
            } else {
                this.serviceList.setSelectedIndex(-1);
            }
        }
        object = this.ensembleList;
        synchronized (object) {
            int n2 = -1;
            for (n = 0; n < this.ensembleList.getLength(); ++n) {
                DabListRow dabListRow = (DabListRow)this.ensembleList.getRow(n);
                if (dabListRow == null || dabListRow.getDabStation() == null || dabListRow.getEnsemble() == null || !RadioComparators.equals(this.currentStation.ensemble, dabListRow.getEnsemble())) continue;
                n2 = n;
                break;
            }
            this.ensembleList.setSelectedIndex(n2);
        }
        this.logger.dabList.log(1000000, "highlightItemLeft");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void listUpdate(DabStation[] dabStationArray, DabStation[] dabStationArray2, DabStation[] dabStationArray3) {
        this.logger.dabList.log(100000000, "[DabCascadedListHandler.listupdate] E:%1 S: %2 C: %3", (long)dabStationArray.length, (long)dabStationArray2.length, (long)dabStationArray3.length);
        BaseListModelApp baseListModelApp = this.ensembleList;
        synchronized (baseListModelApp) {
            this.orgLists.setLists(dabStationArray, dabStationArray2, dabStationArray3);
            this.ensembles = dabStationArray;
            this.services = dabStationArray2;
            this.components = dabStationArray3;
            this.adjustTemporaryInformation();
            this.buildEnsembleList();
        }
    }

    private void adjustTemporaryInformation() {
        this.removeTmpItemsFromArrays();
        this.tmpAddedEnsemble = null;
        this.tmpAddedService = null;
        this.tmpAddedComponent = null;
        this.addActiveStationToList();
    }

    private void removeTmpItemsFromArrays() {
        DABListMemory.DABLists dABLists = this.orgLists.getLists();
        this.ensembles = dABLists.ensembles;
        this.services = dABLists.services;
        this.components = dABLists.components;
    }

    private void addActiveStationToList() {
        if (!this.containsListActiveEnsemble()) {
            this.tmpAddedEnsemble = new DabStation(this.currentStation.ensemble);
            this.ensembles = this.addItemToList(this.tmpAddedEnsemble, this.ensembles);
        }
        if (!this.containsListActiveService()) {
            this.tmpAddedService = new DabStation(this.currentStation.ensemble, this.currentStation.service);
            this.services = this.addItemToList(this.tmpAddedService, this.services);
        }
        if (!this.containsListActiveComponent()) {
            this.tmpAddedComponent = new DabStation(this.currentStation.ensemble, this.currentStation.service, this.currentStation.component);
            this.components = this.addItemToList(this.tmpAddedComponent, this.components);
        }
    }

    private DabStation[] addItemToList(DabStation dabStation, DabStation[] dabStationArray) {
        DabStation[] dabStationArray2 = new DabStation[dabStationArray.length + 1];
        System.arraycopy((Object)dabStationArray, 0, (Object)dabStationArray2, 0, dabStationArray.length);
        dabStationArray2[dabStationArray.length] = dabStation;
        return dabStationArray2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setReceptionStatus(int n, int n2) {
        Object object = this.mutex;
        synchronized (object) {
            BaseListModelApp baseListModelApp = this.serviceList.getEmptyCopy();
            SelectedItem selectedItem = this.serviceList.getSelected();
            for (int i2 = 0; i2 < this.serviceList.getLength(); ++i2) {
                DabListRow dabListRow = (DabListRow)this.serviceList.getRow(i2);
                dabListRow.setReceptionStatus(n, n2);
                baseListModelApp.append(dabListRow);
            }
            if (selectedItem != null && baseListModelApp.getLength() > 0) {
                baseListModelApp.setSelectedIndex(selectedItem.getIndex());
            }
            this.serviceList.update(baseListModelApp);
        }
    }

    private boolean containsListActiveComponent() {
        ComponentInfo componentInfo = this.currentStation.component;
        if (componentInfo.primaryService) {
            return true;
        }
        for (int i2 = 0; i2 < this.components.length; ++i2) {
            if (this.components[i2].component.sID != componentInfo.sID || this.components[i2].component.ensID != componentInfo.ensID || this.components[i2].component.ensECC != componentInfo.ensECC || this.components[i2].component.sCIDI != componentInfo.sCIDI) continue;
            return true;
        }
        return false;
    }

    private boolean containsListActiveEnsemble() {
        EnsembleInfo ensembleInfo = this.currentStation.ensemble;
        for (int i2 = 0; i2 < this.ensembles.length; ++i2) {
            if (this.ensembles[i2].ensemble.ensID != ensembleInfo.ensID || this.ensembles[i2].ensemble.ensECC != ensembleInfo.ensECC) continue;
            return true;
        }
        return false;
    }

    private boolean containsListActiveService() {
        ServiceInfo serviceInfo = this.currentStation.service;
        for (int i2 = 0; i2 < this.services.length; ++i2) {
            if (this.services[i2].service.sID != serviceInfo.sID || this.services[i2].service.ensID != serviceInfo.ensID || this.services[i2].service.ensECC != serviceInfo.ensECC) continue;
            return true;
        }
        return false;
    }

    private void buildEnsembleList() {
        Arrays.sort(this.ensembles, new ComparatorEnsemble(this.langMngr));
        BaseListModelApp baseListModelApp = this.ensembleList.getEmptyCopy();
        int n = -1;
        for (int i2 = 0; i2 < this.ensembles.length; ++i2) {
            if (this.ensembles[i2] == null) continue;
            if (RadioComparators.equals(this.currentStation.ensemble, this.ensembles[i2].ensemble)) {
                n = baseListModelApp.getLength();
            }
            baseListModelApp.append(this.createRow(this.ensembles[i2], this.ensembleRecordSets));
        }
        baseListModelApp.setSelectedIndex(n);
        this.ensembleList.update(baseListModelApp);
    }

    private void buildServiceList(EnsembleInfo ensembleInfo) {
        this.curEnsembleNameLabel.setText(ensembleInfo.fullName);
        Object[] objectArray = this.getServicesByEnsemble(ensembleInfo.ensID, ensembleInfo.ensECC);
        Arrays.sort(objectArray, this.serviceComparator);
        BaseListModelApp baseListModelApp = this.serviceList.getEmptyCopy();
        int n = -1;
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            Utilities.getFramework().getHMIService().getEventDispatcher().doCheckedSleeping();
            if (objectArray[i2] == null) continue;
            if (RadioComparators.equals(this.currentStation, (DabStation)objectArray[i2])) {
                n = baseListModelApp.getLength();
            }
            baseListModelApp.append(this.createRow((DabStation)objectArray[i2], this.serviceRecordSets));
            Object[] objectArray2 = this.getComponentsByService((DabStation)objectArray[i2]);
            Arrays.sort(objectArray2, new ComparatorComponent(this.langMngr));
            for (int i3 = 0; i3 < objectArray2.length; ++i3) {
                if (objectArray2[i3] == null) continue;
                if (RadioComparators.equals(this.currentStation, (DabStation)objectArray2[i3])) {
                    n = baseListModelApp.getLength();
                }
                baseListModelApp.append(this.createRow((DabStation)objectArray2[i3], this.serviceRecordSets));
            }
        }
        baseListModelApp.setSelectedIndex(n);
        this.serviceList.update(baseListModelApp);
    }

    private DabStation[] getServicesByEnsemble(int n, int n2) {
        ArrayList arrayList = new ArrayList(20);
        for (int i2 = 0; i2 < this.services.length; ++i2) {
            if (this.services[i2] == null || this.services[i2].service.ensID != n || this.services[i2].service.ensECC != n2) continue;
            arrayList.add(this.services[i2]);
        }
        return (DabStation[])arrayList.toArray(new DabStation[arrayList.size()]);
    }

    private DabStation[] getComponentsByService(DabStation dabStation) {
        int n = dabStation.service.ensID;
        long l = dabStation.service.sID;
        ArrayList arrayList = new ArrayList(3);
        for (int i2 = 0; i2 < this.components.length; ++i2) {
            if (this.components[i2] == null || this.components[i2].component.ensID != n || this.components[i2].component.sID != l) continue;
            arrayList.add(this.components[i2]);
        }
        return (DabStation[])arrayList.toArray(new DabStation[arrayList.size()]);
    }

    private DabListRow createRow(DabStation dabStation, RecordSets recordSets) {
        DabListRow dabListRow;
        this.logger.dabDeepDebug.log(1000000, "DabCascadedListHandler.createRow %1", (Object)dabStation);
        if (RadioComparators.equals(this.currentStation, dabStation)) {
            dabListRow = this.rowFactory.getDabListRow(recordSets, this.currentStation, false, this.imgType);
            dabListRow.setStationActive(true);
        } else {
            dabListRow = this.rowFactory.getDabListRow(recordSets, dabStation, false, this.imgType);
        }
        dabListRow.setReceptionStatus(this.dabTuner.getCurSyncState(), this.dabTuner.getCurLinkState());
        return dabListRow;
    }

    private DabStation getStation(DabListRow dabListRow) {
        DabStation dabStation = dabListRow.getDabStation();
        DabStation dabStation2 = this.dabTuner.getActiveStation();
        return RadioComparators.equals(dabStation2, dabStation) ? dabStation2 : dabStation;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setPrefImgType(int n) {
        this.imgType = n;
        if (this.currentStation != null) {
            Object object = this.ensembleList;
            synchronized (object) {
                this.buildEnsembleList();
            }
            object = this.mutex;
            synchronized (object) {
                this.buildServiceList(this.currentEnsemble.ensemble);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setSortMode(int n) {
        if (Utilities.isPGen1OrBentley()) {
            switch (n) {
                case 0: {
                    this.serviceComparator = new SortAlgoDabStationName(this.langMngr);
                    break;
                }
                case 2: {
                    this.serviceComparator = new SortAlgoDabGenre(this.langMngr);
                    break;
                }
            }
            Object object = this.mutex;
            synchronized (object) {
                this.buildServiceList(this.currentEnsemble.ensemble);
            }
        }
    }

    private class ListListener
    extends RadioBaseListModelListener {
        public ListListener(TunerModels tunerModels, int n) {
            super(tunerModels, n);
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            DabCascadedListHandler.this.scanHandler.abortScan();
            DabStation dabStation = DabCascadedListHandler.this.getStation((DabListRow)evoListRow);
            if (n == 100667) {
                boolean bl;
                boolean bl2 = bl = n3 == 6;
                if (bl) {
                    if (DabCascadedListHandler.this.longPressHandler != null) {
                        DabCascadedListHandler.this.longPressHandler.prepareStore(n4, ((AbstractRadioListRow)evoListRow).getTOContainer());
                    }
                } else if (this.isNewSelection(evoListRow, n, n2, n3, n4)) {
                    DabCascadedListHandler.this.dabTuner.selectStation(dabStation, dabStation.isComponent() ? 3 : 2, n4);
                }
            } else if (n == 100668) {
                DabCascadedListHandler.this.currentEnsemble = dabStation;
                Object object = DabCascadedListHandler.this.mutex;
                synchronized (object) {
                    DabCascadedListHandler.this.buildServiceList(((DabCascadedListHandler)DabCascadedListHandler.this).currentEnsemble.ensemble);
                }
                DabCascadedListHandler.this.ensembleList.fireEvent(n4);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            DabCascadedListHandler.this.scanHandler.abortScan();
            if (n == 100667) {
                SelectedItem selectedItem = null;
                Object object = DabCascadedListHandler.this.mutex;
                synchronized (object) {
                    selectedItem = DabCascadedListHandler.this.serviceList.getSelected();
                }
                if (selectedItem == null || n2 != selectedItem.getIndex()) {
                    object = ((DabListRow)evoListRow).getDabStation();
                    DabCascadedListHandler.this.dabTuner.selectStation((DabStation)object, 0, n4);
                }
                if (DabCascadedListHandler.this.longPressHandler != null) {
                    DabCascadedListHandler.this.longPressHandler.prepareStore(n4, ((AbstractRadioListRow)evoListRow).getTOContainer());
                }
            }
        }
    }

    private class DsiUpListener
    extends DABDsiUpInfo {
        private DsiUpListener() {
        }

        public void listUpdate(DabStation[] dabStationArray, DabStation[] dabStationArray2, DabStation[] dabStationArray3) {
            DabCascadedListHandler.this.listUpdate(dabStationArray, dabStationArray2, dabStationArray3);
        }

        public void updateCurrentStation(DabStation dabStation, DabReceptionStatus dabReceptionStatus) {
            DabCascadedListHandler.this.highlightItem(dabStation, dabReceptionStatus);
        }
    }

    private class DsiDownListener
    extends DABDsiDownInfo {
        private DsiDownListener() {
        }

        public void preTuneAction(DabStation dabStation, DabReceptionStatus dabReceptionStatus, int n) {
            DabCascadedListHandler.this.highlightItem(dabStation, dabReceptionStatus);
        }
    }
}

