/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab.stationlist;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.RadioBaseListModelListener;
import de.audi.tuner.app.RadioComparators;
import de.audi.tuner.app.RadioObjectIds;
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
import de.audi.tuner.app.dab.stationlist.AbstractDABListHandler;
import de.audi.tuner.app.dab.stationlist.ComparatorComponent;
import de.audi.tuner.app.dab.stationlist.ComparatorEnsemble;
import de.audi.tuner.app.dab.stationlist.ComparatorService;
import de.audi.tuner.app.dab.stationlist.DABListMemory;
import de.audi.tuner.app.dab.stationlist.DabFolderListModel;
import de.audi.tuner.app.dab.stationlist.DabListRow;
import de.audi.tuner.app.dab.stationlist.IFolderListModel;
import de.audi.tuner.app.dab.stationlist.RecordSets;
import de.audi.tuner.app.storage.TunerStorage;
import de.audi.tuner.ifc.AbstractListRowFactory;
import de.audi.tuner.ifc.AbstractRadioListRow;
import de.audi.tuner.ifc.IScanHandler;
import de.audi.tuner.ifc.IStoreStationHandler;
import de.audi.tuner.ifc.ITunerVariantExt;
import de.esolutions.fw.util.commons.SimpleIntIntMap;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.ServiceInfo;

public class DabFolderListHandler
extends AbstractDABListHandler {
    public final DABDsiUpInfo dsiUpListener = new DsiUpListener();
    public final DABDsiDownInfo dsiDownListener = new DsiDownListener();
    private final IFolderListModel fullDABList;
    private DabStation[] components = new DabStation[0];
    private DabStation[] ensembles = new DabStation[0];
    private DabStation[] services = new DabStation[0];
    private final DABListMemory orgLists = new DABListMemory();
    private final Logger logger;
    private final DABTuner dabTuner;
    private final LanguageManager langMngr;
    private final AbstractListRowFactory rowFactory;
    private final RecordSets recordSets;
    private DabStation tmpAddedEnsemble;
    private DabStation tmpAddedService;
    private DabStation tmpAddedComponent;
    private DabStation currentStation;
    private final IScanHandler scanHandler;
    private IStoreStationHandler longPressHandler;
    private int imgType;
    private DabReceptionStatus reception = new DabReceptionStatus(0, 0);
    private volatile boolean listIsActive;

    public DabFolderListHandler(DABTuner dABTuner, TunerBasics tunerBasics, TunerStorage tunerStorage, ITunerVariantExt iTunerVariantExt, LanguageManager languageManager, IScanHandler iScanHandler) {
        this.logger = tunerBasics.getLogger();
        this.dabTuner = dABTuner;
        this.currentStation = tunerStorage.loadLastDABService();
        this.langMngr = languageManager;
        this.imgType = tunerStorage.loadPreferredImageType();
        this.fullDABList = new DabFolderListModel(tunerBasics, 100491, this.imgType, this);
        this.fullDABList.setListener(new ListListener(tunerBasics.getModels(), 100370));
        this.recordSets = new RecordSets(this, 1);
        this.rowFactory = iTunerVariantExt.getListRowFactory();
        if (!Utilities.isPGen1OrBentley()) {
            this.initFolderStates(tunerStorage);
        }
        this.scanHandler = iScanHandler;
    }

    public void init() {
        this.buildFullList();
    }

    public void register(IStoreStationHandler iStoreStationHandler) {
        this.longPressHandler = iStoreStationHandler;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void listUpdate(DabStation[] dabStationArray, DabStation[] dabStationArray2, DabStation[] dabStationArray3) {
        this.logger.dabList.log(100000000, "[DABSLH.listupdate] E:%1 S: %2 C: %3", (long)dabStationArray.length, (long)dabStationArray2.length, (long)dabStationArray3.length);
        IFolderListModel iFolderListModel = this.fullDABList;
        synchronized (iFolderListModel) {
            this.orgLists.setLists(dabStationArray, dabStationArray2, dabStationArray3);
            this.ensembles = dabStationArray;
            this.services = dabStationArray2;
            this.components = dabStationArray3;
            if (this.ensembles == null || this.services == null) {
                this.logger.dabList.log(1000000, "listUpdate: invalid source array, ensembles %1, services %2 ", (Object)this.ensembles, (Object)this.services);
                return;
            }
        }
        this.buildFullList();
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void buildFullList() {
        this.logger.dabList.log(1000000, "buildFullList#entry ");
        if (this.ensembles == null || this.services == null) {
            this.logger.dabList.log(1000000, "buildFullList: invalid source array, ensembles %1, services %2 ", (Object)this.ensembles, (Object)this.services);
            return;
        }
        IFolderListModel iFolderListModel = this.fullDABList;
        synchronized (iFolderListModel) {
            try {
                this.removeTmpItemsFromArrays();
                this.logger.dabList.log(1000000, "buildFullList: E:%1 S:%2 C:%3", (long)this.ensembles.length, (long)this.services.length, (long)this.components.length);
                this.tmpAddedEnsemble = null;
                this.tmpAddedService = null;
                this.tmpAddedComponent = null;
                this.addActiveStationToList();
                this.logger.dabDeepDebug.log(1000000, "Tmp added Ens %1", (Object)this.tmpAddedEnsemble);
                this.logger.dabDeepDebug.log(1000000, "Tmp added Ser %1", (Object)this.tmpAddedService);
                this.logger.dabDeepDebug.log(1000000, "Tmp added Com %1", (Object)this.tmpAddedComponent);
                this.logger.dabList.log(1000000, "buildFullList: E:%1 S:%2 C:%3", (long)this.ensembles.length, (long)this.services.length, (long)this.components.length);
                List list = this.buildHierarchicalList();
                this.fullDABList.update(list, this.currentStation);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        if (this.listIsActive) {
            this.propagateUpdatedStationList(5);
        }
        this.logger.dabList.log(1000000, "buildFullList#exit ");
    }

    private List buildHierarchicalList() {
        this.logger.dabDeepDebug.log(10000000, "[DABSLH.buildHierarchicalList]");
        Arrays.sort(this.ensembles, new ComparatorEnsemble(this.langMngr));
        ArrayList arrayList = new ArrayList(this.ensembles.length + this.services.length + this.components.length + 3);
        for (int i2 = 0; i2 < this.ensembles.length; ++i2) {
            int n;
            if (this.ensembles[i2] == null) continue;
            Object[] objectArray = this.getServicesByEnsemble(this.ensembles[i2].ensemble.ensID, this.ensembles[i2].ensemble.ensECC);
            if (objectArray.length == 0) {
                this.logger.dabList.log(10000000, "No services for ensemble %1 found ", (long)this.ensembles[i2].ensemble.ensID);
                for (n = 0; n < this.services.length; ++n) {
                    this.logger.dabList.log(10000000, "%1 ", (Object)this.services[n]);
                }
                continue;
            }
            Arrays.sort(objectArray, new ComparatorService(this.langMngr));
            arrayList.add(this.createRow(this.ensembles[i2]));
            for (n = 0; n < objectArray.length; ++n) {
                Utilities.getFramework().getHMIService().getEventDispatcher().doCheckedSleeping();
                if (objectArray[n] == null) continue;
                arrayList.add(this.createRow((DabStation)objectArray[n]));
                Object[] objectArray2 = this.getComponentsByService((DabStation)objectArray[n]);
                Arrays.sort(objectArray2, new ComparatorComponent(this.langMngr));
                for (int i3 = 0; i3 < objectArray2.length; ++i3) {
                    if (objectArray2[i3] == null) continue;
                    arrayList.add(this.createRow((DabStation)objectArray2[i3]));
                }
            }
        }
        return arrayList;
    }

    private DabListRow createRow(DabStation dabStation) {
        DabListRow dabListRow;
        this.logger.dabDeepDebug.log(1000000, "DABSLH.createRow %1", (Object)dabStation);
        if (RadioComparators.equals(this.currentStation, dabStation)) {
            dabListRow = this.rowFactory.getDabListRow(this.recordSets, this.currentStation, false, this.imgType);
            dabListRow.setStationActive(true);
        } else {
            dabListRow = this.rowFactory.getDabListRow(this.recordSets, dabStation, false, this.imgType);
        }
        dabListRow.setReceptionStatus(this.dabTuner.getCurSyncState(), this.dabTuner.getCurLinkState());
        return dabListRow;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void highlightItem(DabStation dabStation, DabReceptionStatus dabReceptionStatus) {
        this.logger.dabList.log(10000000, "[DabFolderListHandler.highlightItem] %1", (Object)dabStation);
        this.reception = dabReceptionStatus;
        if (dabStation.isEnsemble()) {
            this.logger.dabList.log(10000, "[DabFolderListHandler.highlightItem] with Ensemble called");
            return;
        }
        int n = -1;
        this.currentStation = dabStation;
        this.logger.dabList.log(10000000, "[DabFolderListHandler.highlightItem] highlightItem#%1 ", (Object)dabStation);
        IFolderListModel iFolderListModel = this.fullDABList;
        synchronized (iFolderListModel) {
            n = this.fullDABList.getIndexForUniqueID(dabStation.getUniqueId());
            if (n == -1) {
                this.logger.dabList.log(1000000, "[DabFolderListHandler.highlightItem] highlight: Item not in list: %1 ", (Object)dabStation);
                this.buildFullList();
                return;
            }
            if (this.chkRemoveTmpStations(dabStation)) {
                this.buildFullList();
            } else {
                try {
                    int n2 = this.fullDABList.getSelected();
                    this.fullDABList.setSelectedIndex(n, dabStation, n2);
                }
                catch (Exception exception) {
                    this.logger.dabList.log(10000, "DSIException occured!", (Throwable)exception);
                }
            }
            this.fullDABList.setReceptionStatus(dabReceptionStatus.syncStatus, dabReceptionStatus.linkStatus);
        }
        if (this.listIsActive) {
            this.propagateUpdatedActiveStation(5);
        }
        this.logger.dabList.log(1000000, "[DabFolderListHandler.highlightItem] highlightItemLeft");
    }

    private boolean chkRemoveTmpStations(DabStation dabStation) {
        if (this.tmpAddedEnsemble == null && this.tmpAddedService == null && this.tmpAddedComponent == null) {
            return false;
        }
        int n = -1;
        long l = -1L;
        int n2 = -1;
        if (dabStation.isService()) {
            ServiceInfo serviceInfo = dabStation.service;
            n = serviceInfo.getEnsID();
            l = serviceInfo.getSID();
        } else if (dabStation.isComponent()) {
            ComponentInfo componentInfo = dabStation.component;
            n = componentInfo.getEnsID();
            l = componentInfo.getSID();
            n2 = componentInfo.getSCIDI();
        }
        return this.tmpAddedEnsemble != null && this.tmpAddedEnsemble.ensemble.getEnsID() != n || this.tmpAddedService != null && this.tmpAddedService.service.getSID() != l || this.tmpAddedComponent != null && this.tmpAddedComponent.component.getSCIDI() != n2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setSyncLinkState(int n, int n2) {
        if (this.fullDABList.getLength() == 0) {
            return;
        }
        this.logger.dabList.log(10000000, "[DabFolderListHandler.setSyncLiskState]sync %1 link %2 ", (long)n, (long)n2);
        IFolderListModel iFolderListModel = this.fullDABList;
        synchronized (iFolderListModel) {
            try {
                this.fullDABList.setReceptionStatus(n, n2);
            }
            catch (Exception exception) {
                this.logger.dabList.log(10000, "Exception: ", (Throwable)exception);
            }
            if (this.listIsActive) {
                this.propagateUpdatedStationList(5);
            }
        }
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

    private DabStation[] getServicesByEnsemble(int n, int n2) {
        ArrayList arrayList = new ArrayList(20);
        for (int i2 = 0; i2 < this.services.length; ++i2) {
            if (this.services[i2] == null || this.services[i2].service.ensID != n || this.services[i2].service.ensECC != n2) continue;
            arrayList.add(this.services[i2]);
        }
        return (DabStation[])arrayList.toArray(new DabStation[arrayList.size()]);
    }

    public DabListRow getNextObjectIndexFromList(boolean bl) {
        int n = this.fullDABList.getLength();
        if (n == 0 || n == 1) {
            return null;
        }
        int n2 = this.fullDABList.getSelected();
        this.logger.hmi.log(100000000, "Active index DAB list is: %1 ", (long)n2);
        if (n2 == -1) {
            n2 = 0;
        }
        DabListRow dabListRow = null;
        for (int i2 = 0; i2 < n && dabListRow == null; ++i2) {
            n2 = this.getNextListIndex(bl, n, n2);
            this.logger.hmi.log(100000000, "Next index is: %1 ", (long)n2);
            dabListRow = this.fullDABList.getRow(n2);
            if (!dabListRow.isEnsemble()) continue;
            dabListRow = null;
        }
        return dabListRow;
    }

    private DabStation[] addItemToList(DabStation dabStation, DabStation[] dabStationArray) {
        DabStation[] dabStationArray2 = new DabStation[dabStationArray.length + 1];
        System.arraycopy((Object)dabStationArray, 0, (Object)dabStationArray2, 0, dabStationArray.length);
        dabStationArray2[dabStationArray.length] = dabStation;
        return dabStationArray2;
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

    private void removeTmpItemsFromArrays() {
        DABListMemory.DABLists dABLists = this.orgLists.getLists();
        this.ensembles = dABLists.ensembles;
        this.services = dABLists.services;
        this.components = dABLists.components;
    }

    private void initFolderStates(TunerStorage tunerStorage) {
        SimpleIntIntMap simpleIntIntMap = tunerStorage.loadDABListLM();
        this.fullDABList.setFolderStates(simpleIntIntMap);
    }

    public boolean tuneById(long l, int n) {
        Serializable serializable;
        this.logger.combi.log(10000000, "AbstractStationList#tuneById, id: %1", l);
        DabListRow dabListRow = null;
        for (int i2 = 0; i2 < this.fullDABList.getLength(); ++i2) {
            dabListRow = this.fullDABList.getRow(i2);
            serializable = dabListRow.getDabStation();
            if (serializable.getUniqueId() != l) continue;
            if (dabListRow.isEnsemble()) {
                return false;
            }
            this.dabTuner.selectStation(this.getStation(dabListRow), 0, n);
            return true;
        }
        serializable = new RadioObjectIds((long)l, (LogChannel)this.logger.combi).toc;
        if (serializable != null) {
            TunerProxyManager.getInstance().prepareAndTune((TunerObjectContainer)serializable, n);
            return true;
        }
        this.logger.combi.log(10000, "AbstractStationList#tuneById, id: %1  FAILED: STATION NOT FOUND", l);
        return false;
    }

    private DabStation getStation(DabListRow dabListRow) {
        DabStation dabStation = dabListRow.getDabStation();
        DabStation dabStation2 = this.dabTuner.getActiveStation();
        return RadioComparators.equals(dabStation2, dabStation) ? dabStation2 : dabStation;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public TunerObjectContainer[] getStationList() {
        TunerObjectContainer[] tunerObjectContainerArray;
        IFolderListModel iFolderListModel = this.fullDABList;
        synchronized (iFolderListModel) {
            tunerObjectContainerArray = new TunerObjectContainer[this.fullDABList.getLength()];
            for (int i2 = 0; i2 < this.fullDABList.getLength(); ++i2) {
                tunerObjectContainerArray[i2] = this.fullDABList.getRow(i2).getTOContainer();
            }
        }
        return tunerObjectContainerArray;
    }

    public Object dumpList() {
        return this.fullDABList.toString();
    }

    public TunerObjectContainer getActiveStation() {
        TunerObjectContainer tunerObjectContainer = new TunerObjectContainer(this.currentStation);
        tunerObjectContainer.setReceptionStatus(this.reception.getReception());
        return tunerObjectContainer;
    }

    public DabStation getCurrentStation() {
        return this.currentStation;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setPrefImgType(int n) {
        this.imgType = n;
        this.fullDABList.setPrefImgType(n);
        IFolderListModel iFolderListModel = this.fullDABList;
        synchronized (iFolderListModel) {
            this.buildFullList();
        }
    }

    public SimpleIntIntMap getFolderStates() {
        return this.fullDABList.getFolderStates();
    }

    public void setSortMode(int n) {
        this.listIsActive = n == 1;
    }

    private class ListListener
    extends RadioBaseListModelListener {
        public ListListener(TunerModels tunerModels, int n) {
            super(tunerModels, n);
        }

        public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            DabFolderListHandler.this.scanHandler.abortScan();
            if (this.isNewSelection(evoListRow, n, n2, n3, n4)) {
                DabStation dabStation = DabFolderListHandler.this.getStation((DabListRow)evoListRow);
                DabFolderListHandler.this.dabTuner.selectStation(dabStation, dabStation.isComponent() ? 3 : 2, n4);
            }
        }

        public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            DabFolderListHandler.this.scanHandler.abortScan();
            if (n2 != DabFolderListHandler.this.fullDABList.getSelected()) {
                DabStation dabStation = ((DabListRow)evoListRow).getDabStation();
                TunerProxyManager.getInstance().getDABTuner().selectStation(dabStation, 0, n4);
            }
            if (DabFolderListHandler.this.longPressHandler != null) {
                DabFolderListHandler.this.longPressHandler.prepareStore(n4, ((AbstractRadioListRow)evoListRow).getTOContainer());
            }
        }
    }

    private class DsiUpListener
    extends DABDsiUpInfo {
        private DsiUpListener() {
        }

        public void listUpdate(DabStation[] dabStationArray, DabStation[] dabStationArray2, DabStation[] dabStationArray3) {
            DabFolderListHandler.this.listUpdate(dabStationArray, dabStationArray2, dabStationArray3);
        }

        public void updateCurrentStation(DabStation dabStation, DabReceptionStatus dabReceptionStatus) {
            DabFolderListHandler.this.highlightItem(dabStation, dabReceptionStatus);
        }
    }

    private class DsiDownListener
    extends DABDsiDownInfo {
        private DsiDownListener() {
        }

        public void preTuneAction(DabStation dabStation, DabReceptionStatus dabReceptionStatus, int n) {
            DabFolderListHandler.this.highlightItem(dabStation, dabReceptionStatus);
        }
    }
}

