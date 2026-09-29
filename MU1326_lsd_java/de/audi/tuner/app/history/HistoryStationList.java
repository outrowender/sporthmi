/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.atip.hmi.model.DragAndDropHandler;
import de.audi.atip.hmi.model.list.BaseListModel;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.hmi.model.update.ModelTrigger;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tuner.app.DrawerFocusManager;
import de.audi.tuner.app.IDrawerFocusManager;
import de.audi.tuner.app.LanguageManager$ILanguageChangeListener;
import de.audi.tuner.app.MemoryListHandler;
import de.audi.tuner.app.RadioBaseListModelListener;
import de.audi.tuner.app.RadioComparators;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.TunerProxyManager;
import de.audi.tuner.app.TunerStatus;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.epg.sdars.ChoiceModifyingEPGAvailibilityCallback;
import de.audi.tuner.app.epg.sdars.IEPGAvailibiltyCallback;
import de.audi.tuner.app.history.HistoryStationList$1;
import de.audi.tuner.app.history.HistoryStationList$2;
import de.audi.tuner.app.history.HistoryStationList$3;
import de.audi.tuner.app.history.HistoryStationList$ButtonListener;
import de.audi.tuner.app.history.HistoryStationList$DefaultTunePlugin;
import de.audi.tuner.app.history.HistoryStationList$LanguageChangeListener;
import de.audi.tuner.app.history.HistoryStationList$MemoryListener;
import de.audi.tuner.app.history.HistoryStationList$MenuModelListener;
import de.audi.tuner.app.history.HistoryStationList$MyMessageListener;
import de.audi.tuner.app.history.HistoryStationList$OptionsListener;
import de.audi.tuner.app.history.HistoryStationList$PowerEventListener;
import de.audi.tuner.app.history.HistoryStationList$PrevNextHandler;
import de.audi.tuner.app.history.HistoryTuner;
import de.audi.tuner.app.history.IHistoryTuneListener;
import de.audi.tuner.app.history.ITunePlugin;
import de.audi.tuner.app.memory.AbstractMemoryRow;
import de.audi.tuner.app.memory.AmFmMemoryRow;
import de.audi.tuner.app.memory.SDARSMemoryRow;
import de.audi.tuner.app.memory.UniMemoryRow;
import de.audi.tuner.app.misc.IOptionsListener;
import de.audi.tuner.app.sdars.PdtInfoHandler;
import de.audi.tuner.app.sdars.PdtListener;
import de.audi.tuner.app.sdars.SdarsRadioText;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.storage.TunerStorage;
import de.audi.tuner.ifc.AbstractListRowFactory;
import de.audi.tuner.ifc.DefaultDragAndDropListener;
import de.audi.tuner.ifc.IListResourceProvider;
import de.audi.tuner.ifc.ILogoDatabase;
import de.audi.tuner.ifc.IMemoryList;
import de.audi.tuner.ifc.IPrevNext;
import de.audi.tuner.ifc.IScanHandler;
import de.audi.tuner.ifc.listener.IUpdateListener;
import de.audi.tuner.ifc.listener.MessageListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class HistoryStationList
extends RadioBaseListModelListener
implements IListResourceProvider {
    final HistoryStationList$PowerEventListener powerEventListener = new HistoryStationList$PowerEventListener(this, null);
    final MessageListener messageListener = new HistoryStationList$MyMessageListener(this, null);
    final LanguageManager$ILanguageChangeListener languageChangeListener = new HistoryStationList$LanguageChangeListener(this, null);
    final IOptionsListener optionsListener = new HistoryStationList$OptionsListener(this, null);
    public final IPrevNext prevNextHandler = new HistoryStationList$PrevNextHandler(this, null);
    private final BaseListModel model;
    private final MenuModelApp menu;
    private final ChoiceModelApp curStIsInHist;
    private final TunerStatus status;
    private TunerObjectContainer[] presets = new TunerObjectContainer[0];
    private final TunerModels models;
    private final TunerBasics basics;
    private final AbstractListRowFactory rowFactory;
    private int imgType;
    private final TunerStorage storage;
    private final HistoryTuner historyTuner;
    private final IScanHandler scanHandler;
    private final PdtListener pdtListener;
    private final IEPGAvailibiltyCallback sdarsEpgAvailibilityCallback;
    private ITunePlugin tunePlugin = new HistoryStationList$DefaultTunePlugin(null);
    private volatile long focussedItemUniqueID = 0L;
    private volatile int registeredSid = -1;
    private final ArrayList historyTuneListeners = new ArrayList();
    private IDrawerFocusManager drawerFocus = DrawerFocusManager.NULL_DRAWER_FOCUS_MANAGER;

    HistoryStationList(TunerBasics tunerBasics, AbstractListRowFactory abstractListRowFactory, TunerStorage tunerStorage, HistoryTuner historyTuner, IScanHandler iScanHandler) {
        super(tunerBasics.getModels(), -678952704);
        this.basics = tunerBasics;
        this.models = tunerBasics.getModels();
        this.status = tunerBasics.getStatus();
        this.model = (BaseListModel)tunerBasics.getModels().getBaseListModel(1921515776);
        this.menu = tunerBasics.getModels().getMenuModel(-678952704);
        this.menu.setListener(new HistoryStationList$MenuModelListener(this, tunerBasics, new int[]{-678952704}));
        this.curStIsInHist = tunerBasics.getModels().getChoiceModel(-964165376);
        this.model.setListener(this);
        this.storage = tunerStorage;
        this.historyTuner = historyTuner;
        this.scanHandler = iScanHandler;
        this.sdarsEpgAvailibilityCallback = ChoiceModifyingEPGAvailibilityCallback.forSdarsFocussedChannelEPGAvailibilityChoice(this.models);
        tunerBasics.getModels().getButtonModel(-477626112).setButtonListener(new HistoryStationList$ButtonListener(this, null));
        this.rowFactory = abstractListRowFactory;
        this.imgType = tunerStorage.loadPreferredImageType();
        this.pdtListener = new HistoryStationList$1(this, this, this.model, new Object(), this.imgType, tunerBasics);
        this.model.setDragAndDropHandler(new DragAndDropHandler(new int[0]));
        this.model.setDragAndDropListener(new DefaultDragAndDropListener());
    }

    void init(ILogoDatabase iLogoDatabase) {
        EvoListRow[] evoListRowArray = this.storage.loadHistoryList(iLogoDatabase);
        BaseListModelApp baseListModelApp = this.model.getEmptyCopy();
        baseListModelApp.append(evoListRowArray);
        MemoryListHandler.adjustRowLayoutsIfNecessary(baseListModelApp, this.models.getChoiceModel(1636368640), this.status.isDisplayStationNames(), this.storage.getAmfmView());
        this.model.update(baseListModelApp);
    }

    public void register(IDrawerFocusManager iDrawerFocusManager) {
        this.drawerFocus = iDrawerFocusManager;
    }

    public void addHistoryTuneListener(IHistoryTuneListener iHistoryTuneListener) {
        this.historyTuneListeners.add(iHistoryTuneListener);
    }

    public IUpdateListener getUpdateListener(IMemoryList iMemoryList) {
        return new HistoryStationList$MemoryListener(this, iMemoryList);
    }

    void setTunePlugin(ITunePlugin iTunePlugin) {
        if (iTunePlugin == null) {
            iTunePlugin = new HistoryStationList$DefaultTunePlugin(null);
        }
        this.tunePlugin = iTunePlugin;
    }

    void add(TunerObjectContainer tunerObjectContainer) {
        if (tunerObjectContainer.getType() == 5 && (long)tunerObjectContainer.getSDARSService().sID == 0L) {
            return;
        }
        AbstractMemoryRow abstractMemoryRow = null;
        BaseListModelApp baseListModelApp = this.model.getCopy();
        for (int i2 = baseListModelApp.getLength() - 1; i2 >= 0; --i2) {
            AbstractMemoryRow abstractMemoryRow2 = (AbstractMemoryRow)baseListModelApp.getRow(i2);
            if (abstractMemoryRow2.getTOContainer().getType() == tunerObjectContainer.getType() && tunerObjectContainer.getType() == 6 && RadioComparators.equalsNoEnsemble(abstractMemoryRow2.getTOContainer().getDABStation(), tunerObjectContainer.getDABStation())) {
                abstractMemoryRow = abstractMemoryRow2;
                baseListModelApp.remove(abstractMemoryRow2);
                continue;
            }
            if (abstractMemoryRow2.getTOContainer().getType() == tunerObjectContainer.getType() && RadioComparators.equals(abstractMemoryRow2.getTOContainer(), tunerObjectContainer)) {
                abstractMemoryRow = abstractMemoryRow2;
                baseListModelApp.remove(abstractMemoryRow2);
                continue;
            }
            abstractMemoryRow2.setStationActive(false);
            baseListModelApp.setRow(i2, abstractMemoryRow2);
        }
        if (abstractMemoryRow == null) {
            abstractMemoryRow = this.rowFactory.getFavRow(tunerObjectContainer, this.getPresetPosition(tunerObjectContainer), this.imgType);
        }
        abstractMemoryRow.setProgramData(tunerObjectContainer, this.imgType);
        abstractMemoryRow.setStationActive(true);
        abstractMemoryRow.adjustLayoutIfNecessary(this.status.isDisplayStationNames(), Utilities.isArabicLanguage(this.models), this.storage.getAmfmView());
        if (baseListModelApp.getLength() > 0) {
            long l = baseListModelApp.getRow(0).getUniqueID();
            baseListModelApp.insertBefore(l, abstractMemoryRow);
        } else {
            baseListModelApp.append(abstractMemoryRow);
        }
        int n = baseListModelApp.getLength();
        if (n > 30) {
            baseListModelApp.remove(baseListModelApp.getRow(n - 1));
        }
        baseListModelApp.setSelectedIndex(0);
        this.model.update(baseListModelApp);
        this.menu.trigger(ModelTrigger.JOIN_CURSOR);
        this.curStIsInHist.setValue(1);
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        if (!this.basics.tunerJobQueue.isJobQueueDispatchThread()) {
            this.basics.tunerJobQueue.enqueue(new HistoryStationList$2(this, "HistoryStationList.itemSelected", evoListRow, n, n2, n3, n4));
            return;
        }
        this.scanHandler.abortScan();
        if (this.isNewSelection(evoListRow, n, n2, n3, n4)) {
            int n5 = ((AbstractMemoryRow)evoListRow).getState();
            TunerObjectContainer tunerObjectContainer = ((AbstractMemoryRow)evoListRow).getTOContainer();
            if (TunerProxyManager.getInstance().isTuneForbidden(n5, tunerObjectContainer)) {
                return;
            }
            Iterator iterator = this.historyTuneListeners.iterator();
            while (iterator.hasNext()) {
                ((IHistoryTuneListener)iterator.next()).historyTunePerformed(tunerObjectContainer);
            }
            boolean bl = this.tunePlugin.doTune(tunerObjectContainer, n4, n3);
            if (bl) {
                SelectedItem selectedItem = this.model.getSelected();
                int n6 = selectedItem != null ? selectedItem.getIndex() : -1;
                this.setSelectedIndex(n6, n2);
            }
        }
    }

    @Override
    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        if (!this.basics.tunerJobQueue.isJobQueueDispatchThread()) {
            this.basics.tunerJobQueue.enqueue(new HistoryStationList$3(this, "HistoryStationList.itemFocused", evoListRow, n, n2, n3, n4));
            return;
        }
        AbstractMemoryRow abstractMemoryRow = (AbstractMemoryRow)evoListRow;
        this.focussedItemUniqueID = abstractMemoryRow.getUniqueID();
        int n5 = -1;
        if (abstractMemoryRow.isSDARS()) {
            StationInfoExt stationInfoExt = abstractMemoryRow.getTOContainer().getSDARSService();
            n5 = stationInfoExt.sID;
            boolean bl = TunerProxyManager.getInstance().getSdarsEpgHandler().isEPGAvailableFor(stationInfoExt, this.sdarsEpgAvailibilityCallback);
            this.sdarsEpgAvailibilityCallback.epgAvailibiltyChanged(stationInfoExt, bl);
        }
        this.orderPdt(n5);
    }

    int highlight(TunerObjectContainer tunerObjectContainer) {
        AbstractMemoryRow abstractMemoryRow;
        SelectedItem selectedItem;
        int n;
        int n2 = -1;
        for (int i2 = 0; i2 < this.model.getLength(); ++i2) {
            AbstractMemoryRow abstractMemoryRow2 = (AbstractMemoryRow)this.model.getRow(i2);
            if (abstractMemoryRow2.getTOContainer().getType() != tunerObjectContainer.getType()) continue;
            if (tunerObjectContainer.getType() == 6 && RadioComparators.equalsNoEnsemble(abstractMemoryRow2.getTOContainer().getDABStation(), tunerObjectContainer.getDABStation())) {
                n2 = i2;
                break;
            }
            if (!RadioComparators.equals(abstractMemoryRow2.getTOContainer(), tunerObjectContainer)) continue;
            n2 = i2;
            break;
        }
        int n3 = n = (selectedItem = this.model.getSelected()) != null ? selectedItem.getIndex() : -1;
        if (n != n2 && n != -1) {
            abstractMemoryRow = (AbstractMemoryRow)this.model.getRow(n);
            abstractMemoryRow.setStationActive(false);
            this.model.setRow(n, abstractMemoryRow);
        }
        if (n2 != -1) {
            SdarsRadioText sdarsRadioText;
            abstractMemoryRow = this.rowFactory.getFavRow(tunerObjectContainer, this.getPresetPosition(tunerObjectContainer), this.imgType);
            abstractMemoryRow.setProgramData(tunerObjectContainer, this.imgType);
            abstractMemoryRow.setStationActive(true);
            abstractMemoryRow.adjustLayoutIfNecessary(this.status.isDisplayStationNames(), Utilities.isArabicLanguage(this.models), this.storage.getAmfmView());
            if (tunerObjectContainer.getBand() == 7 && (sdarsRadioText = this.pdtListener.getActualPdt()) != null && sdarsRadioText.sID == tunerObjectContainer.getSDARSService().sID) {
                ((SDARSMemoryRow)abstractMemoryRow).setProgramData(sdarsRadioText, this.imgType);
            }
            this.model.setRow(n2, abstractMemoryRow);
        }
        this.model.setSelectedIndex(n2);
        this.curStIsInHist.setValue(n2 == -1 ? 0 : 1);
        return n2;
    }

    private int getPresetPosition(TunerObjectContainer tunerObjectContainer) {
        for (int i2 = 0; i2 < this.presets.length; ++i2) {
            if (!tunerObjectContainer.equals(this.presets[i2])) continue;
            return this.presets[i2].getPresetPos();
        }
        return 0;
    }

    public TunerObjectContainer[] getList() {
        BaseListModelApp baseListModelApp = this.model.getCopy();
        TunerObjectContainer[] tunerObjectContainerArray = new TunerObjectContainer[baseListModelApp.getLength()];
        for (int i2 = 0; i2 < baseListModelApp.getLength(); ++i2) {
            tunerObjectContainerArray[i2] = ((AbstractMemoryRow)baseListModelApp.getRow(i2)).getTOContainer();
        }
        return tunerObjectContainerArray;
    }

    private void setSelectedIndex(int n, int n2) {
        AbstractMemoryRow abstractMemoryRow;
        if (n == n2) {
            return;
        }
        if (n != -1) {
            abstractMemoryRow = (AbstractMemoryRow)this.model.getRow(n);
            abstractMemoryRow.setStationActive(false);
            this.model.setRow(n, abstractMemoryRow);
        }
        abstractMemoryRow = (AbstractMemoryRow)this.model.getRow(n2);
        abstractMemoryRow.setStationActive(true);
        this.model.setRow(n2, abstractMemoryRow);
        this.model.setSelectedIndex(n2);
        this.curStIsInHist.setValue(n2 == -1 ? 0 : 1);
    }

    public void persist() {
        List list = this.model.asList();
        this.storage.storeHistoryList((AbstractMemoryRow[])list.toArray(new AbstractMemoryRow[list.size()]));
    }

    void updatePSFreeze(AMFMStation aMFMStation) {
        SelectedItem selectedItem = this.model.getSelected();
        for (int i2 = 0; i2 < this.model.getLength(); ++i2) {
            AbstractMemoryRow abstractMemoryRow = (AbstractMemoryRow)this.model.getRow(i2);
            if (abstractMemoryRow instanceof AmFmMemoryRow && RadioComparators.equals(aMFMStation, ((AmFmMemoryRow)abstractMemoryRow).getStation())) {
                ((AmFmMemoryRow)abstractMemoryRow).setPSFreeze(aMFMStation.isPsFreezed(), aMFMStation.name);
                if (selectedItem != null && i2 == selectedItem.getIndex()) {
                    abstractMemoryRow.setStationActive(true);
                }
                this.model.setRow(i2, abstractMemoryRow);
                continue;
            }
            if (!(abstractMemoryRow instanceof UniMemoryRow) || !RadioComparators.equals(aMFMStation, ((UniMemoryRow)abstractMemoryRow).getStation().getFmStation())) continue;
            ((UniMemoryRow)abstractMemoryRow).setPSFreeze(aMFMStation.isPsFreezed(), aMFMStation.name);
            if (selectedItem != null && i2 == selectedItem.getIndex()) {
                abstractMemoryRow.setStationActive(true);
            }
            this.model.setRow(i2, abstractMemoryRow);
        }
    }

    private void orderPdt(int n) {
        PdtInfoHandler pdtInfoHandler = TunerProxyManager.getInstance().getSDARSTuner().getPdtHandler();
        if (pdtInfoHandler != null) {
            if (n != -1) {
                if (this.registeredSid != -1) {
                    pdtInfoHandler.removeListener(this.registeredSid, this.pdtListener);
                }
                this.registeredSid = n;
                pdtInfoHandler.addListener(n, this.pdtListener, 0);
            } else {
                pdtInfoHandler.removeListener(this.registeredSid, this.pdtListener);
                this.registeredSid = -1;
            }
        }
    }

    @Override
    public long getFocussedItemUniqueId() {
        return this.focussedItemUniqueID;
    }

    public void setPreferredImgType(int n) {
        this.pdtListener.setPrefImgType(n);
        this.imgType = n;
    }

    private void reset() {
        this.historyTuner.fireTimerImmediately();
        SelectedItem selectedItem = this.model.getSelected();
        EvoListRow evoListRow = null;
        if (selectedItem != null) {
            evoListRow = this.model.getRow(selectedItem.getIndex());
        }
        BaseListModelApp baseListModelApp = this.model.getEmptyCopy();
        if (evoListRow != null) {
            baseListModelApp.append(evoListRow);
            baseListModelApp.setSelectedIndex(0);
        }
        this.model.update(baseListModelApp);
        this.curStIsInHist.setValue(1);
        this.persist();
    }

    public int getIndex() {
        SelectedItem selectedItem = this.model.getSelected();
        return selectedItem == null ? -1 : selectedItem.getIndex();
    }

    public void setNamesOnOff(boolean bl) {
        if (Utilities.isJapan()) {
            MemoryListHandler.adjustRowLayoutsIfNecessary(this.model, this.models.getChoiceModel(1636368640), bl, this.storage.getAmfmView());
        }
    }

    private void updateAmFmView(int n) {
        boolean bl = this.status.isDisplayStationNames();
        MemoryListHandler.adjustRowLayoutsIfNecessary(this.model, this.models.getChoiceModel(1636368640), bl, n);
    }

    public void updateSdarsList(StationInfoExt[] stationInfoExtArray) {
        boolean bl = false;
        BaseListModelApp baseListModelApp = this.model.getCopy();
        for (int i2 = 0; i2 < baseListModelApp.getLength(); ++i2) {
            AbstractMemoryRow abstractMemoryRow = (AbstractMemoryRow)baseListModelApp.getRow(i2);
            if (abstractMemoryRow.getBand() != 7) continue;
            StationInfoExt stationInfoExt = abstractMemoryRow.getTOContainer().getSDARSService();
            StationInfoExt stationInfoExt2 = null;
            for (int i3 = 0; i3 < stationInfoExtArray.length; ++i3) {
                if (stationInfoExt.sID != stationInfoExtArray[i3].sID) continue;
                stationInfoExt2 = stationInfoExtArray[i3];
                break;
            }
            if (!((SDARSMemoryRow)abstractMemoryRow).synchronize(stationInfoExt2)) continue;
            baseListModelApp.setRow(i2, abstractMemoryRow);
            bl = true;
        }
        if (bl) {
            this.model.update(baseListModelApp);
        }
    }

    public void setSDARSState(int n) {
        MemoryListHandler.setSdarsListState(n, this.model);
    }

    static /* synthetic */ PdtListener access$800(HistoryStationList historyStationList) {
        return historyStationList.pdtListener;
    }

    static /* synthetic */ BaseListModel access$900(HistoryStationList historyStationList) {
        return historyStationList.model;
    }

    static /* synthetic */ void access$1000(HistoryStationList historyStationList, int n, int n2) {
        historyStationList.setSelectedIndex(n, n2);
    }

    static /* synthetic */ TunerBasics access$1100(HistoryStationList historyStationList) {
        return historyStationList.basics;
    }

    static /* synthetic */ ArrayList access$1200(HistoryStationList historyStationList) {
        return historyStationList.historyTuneListeners;
    }

    static /* synthetic */ ITunePlugin access$1300(HistoryStationList historyStationList) {
        return historyStationList.tunePlugin;
    }

    static /* synthetic */ IDrawerFocusManager access$1400(HistoryStationList historyStationList) {
        return historyStationList.drawerFocus;
    }

    static /* synthetic */ MenuModelApp access$1500(HistoryStationList historyStationList) {
        return historyStationList.menu;
    }

    static /* synthetic */ void access$1700(HistoryStationList historyStationList, int n) {
        historyStationList.orderPdt(n);
    }

    static /* synthetic */ void access$1900(HistoryStationList historyStationList, int n) {
        historyStationList.updateAmFmView(n);
    }

    static /* synthetic */ void access$2000(HistoryStationList historyStationList) {
        historyStationList.reset();
    }

    static /* synthetic */ TunerStatus access$2200(HistoryStationList historyStationList) {
        return historyStationList.status;
    }

    static /* synthetic */ TunerModels access$2300(HistoryStationList historyStationList) {
        return historyStationList.models;
    }

    static /* synthetic */ TunerStorage access$2400(HistoryStationList historyStationList) {
        return historyStationList.storage;
    }

    static /* synthetic */ TunerObjectContainer[] access$2502(HistoryStationList historyStationList, TunerObjectContainer[] tunerObjectContainerArray) {
        historyStationList.presets = tunerObjectContainerArray;
        return tunerObjectContainerArray;
    }

    static /* synthetic */ int access$2600(HistoryStationList historyStationList, TunerObjectContainer tunerObjectContainer) {
        return historyStationList.getPresetPosition(tunerObjectContainer);
    }
}

