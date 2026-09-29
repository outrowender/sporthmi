/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.epg.sdars;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.OptionModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.epg.ClockTimeZoneOffsetHandler;
import de.audi.tuner.app.epg.sdars.AbstractProgramSdarsEpgListRow;
import de.audi.tuner.app.epg.sdars.AbstractSdarsEpgListRow;
import de.audi.tuner.app.epg.sdars.EPGShortInfoExt;
import de.audi.tuner.app.epg.sdars.IEPGAvailibiltyCallback;
import de.audi.tuner.app.epg.sdars.ProgramSdarsEpgListRow;
import de.audi.tuner.app.epg.sdars.SDARSEPGHandler$ButtonListener;
import de.audi.tuner.app.epg.sdars.SDARSEPGHandler$CatFilterListener;
import de.audi.tuner.app.epg.sdars.SDARSEPGHandler$ChoiceListener;
import de.audi.tuner.app.epg.sdars.SDARSEPGHandler$ClockTimeZoneOffsetListener;
import de.audi.tuner.app.epg.sdars.SDARSEPGHandler$DescriptionScreenHelper;
import de.audi.tuner.app.epg.sdars.SDARSEPGHandler$DsiUpListener;
import de.audi.tuner.app.epg.sdars.SDARSEPGHandler$EPGAvailibiltyCallbackHelper;
import de.audi.tuner.app.epg.sdars.SDARSEPGHandler$ListListener;
import de.audi.tuner.app.epg.sdars.SDARSEPGHandler$NextPrevButtonListener;
import de.audi.tuner.app.epg.sdars.SDARSEPGHandler$OptionListener;
import de.audi.tuner.app.sdars.CategoryFilter$ICategoryFilter;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.dsi.ISdarsDsiDownManager;
import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;
import de.audi.tuner.app.sdars.sortandindex.station.AbstractIStationInfoComparatorAndIndexer;
import de.audi.tuner.app.sdars.sortandindex.station.SortAlgoCatAndName;
import de.audi.tuner.app.sdars.sortandindex.station.SortAlgoCatAndStNumber;
import de.audi.tuner.app.sdars.sortandindex.station.SortAlgoName;
import de.audi.tuner.app.sdars.sortandindex.station.SortAlgoStNumber;
import de.audi.tuner.app.sortandindex.AlphabeticalIndexRow;
import de.audi.tuner.ifc.AbstractListRowFactory;
import de.audi.tuner.ifc.IScanHandler;
import de.audi.tuner.ifc.IStoreStationHandler;
import de.audi.tuner.ifc.ITunerVariantExt;
import de.audi.tuner.util.NullStoreStationHandler;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.sdars.EPGDescription;
import org.dsi.ifc.sdars.EPGProgramInfo;

public class SDARSEPGHandler {
    public final CategoryFilter$ICategoryFilter catFilterListener = new SDARSEPGHandler$CatFilterListener(this, null);
    public static final int MAX_PROGRAM_ROWS_IN_ALL_CHANNEL_EPG;
    public final SDARSDsiUpInfo dsiUpInfo = new SDARSEPGHandler$DsiUpListener(this, null);
    private final LogChannel log;
    private final ISdarsDsiDownManager dsiDownManager;
    private final ClockTimeZoneOffsetHandler clockTimeZoneOffsetHandler;
    private final AbstractListRowFactory rowFactory;
    private IStoreStationHandler favoriteHandler;
    private final ITunerVariantExt varExt;
    private final IScanHandler scanHandler;
    private StationInfoExt curSelectedStation = new StationInfoExt();
    private final EPGShortInfoExt[] sidToEPGShortInfo = new EPGShortInfoExt[384];
    private final TunerModels models;
    private final LanguageManager langMngr;
    private final ButtonModelApp showEpgOfAllStationsButton;
    private final OptionModelApp showEpgOfFocussedStationOption;
    private final BaseListModelApp sdarsAllStationsEpgList;
    private final BaseListModelApp sdarsAllStationEpgAlphIndexList;
    private final BaseListModelApp sdarsOneStationEpgList;
    private final SDARSEPGHandler$DescriptionScreenHelper descriptionScreenHelper;
    private static final int NO_REQUEST_RUNNING;
    private int latest24hEPGRequestSID = -1;
    private SDARSEPGHandler$EPGAvailibiltyCallbackHelper epgAvailibilityCallbackHelper = new SDARSEPGHandler$EPGAvailibiltyCallbackHelper();
    private final Object mutex = new Object();
    private AbstractIStationInfoComparatorAndIndexer comparator;
    private ButtonModelApp nextEpgButton;
    private ButtonModelApp prevEpgButton;
    int detailIndex;
    private StationInfoExt detailSdarsStation = new StationInfoExt();
    public boolean[] catFilter = new boolean[256];

    public SDARSEPGHandler(ISdarsDsiDownManager iSdarsDsiDownManager, TunerBasics tunerBasics, ClockTimeZoneOffsetHandler clockTimeZoneOffsetHandler, ITunerVariantExt iTunerVariantExt, LanguageManager languageManager, IScanHandler iScanHandler) {
        this.dsiDownManager = iSdarsDsiDownManager;
        this.models = tunerBasics.getModels();
        this.log = tunerBasics.getLogger().sdarsEPG;
        this.clockTimeZoneOffsetHandler = clockTimeZoneOffsetHandler;
        this.rowFactory = iTunerVariantExt.getListRowFactory();
        this.langMngr = languageManager;
        this.favoriteHandler = new NullStoreStationHandler(this.log);
        this.varExt = iTunerVariantExt;
        this.scanHandler = iScanHandler;
        this.comparator = new SortAlgoStNumber(languageManager);
        this.nextEpgButton = this.models.getButtonModel(1703477504);
        this.prevEpgButton = this.models.getButtonModel(1720254720);
        SDARSEPGHandler$NextPrevButtonListener sDARSEPGHandler$NextPrevButtonListener = new SDARSEPGHandler$NextPrevButtonListener(this, null);
        this.nextEpgButton.setButtonListener(sDARSEPGHandler$NextPrevButtonListener);
        this.prevEpgButton.setButtonListener(sDARSEPGHandler$NextPrevButtonListener);
        this.showEpgOfAllStationsButton = this.models.getButtonModel(1334378752);
        this.showEpgOfFocussedStationOption = this.models.getOptionModel(1317601536);
        this.sdarsAllStationsEpgList = this.models.getBaseListModel(462029056);
        this.sdarsAllStationEpgAlphIndexList = this.models.getBaseListModel(998899968);
        this.sdarsOneStationEpgList = this.models.getBaseListModel(243925248);
        this.descriptionScreenHelper = new SDARSEPGHandler$DescriptionScreenHelper(tunerBasics);
        this.clockTimeZoneOffsetHandler.addClockTimeZoneOffsetListener(new SDARSEPGHandler$ClockTimeZoneOffsetListener(this, null));
        this.showEpgOfAllStationsButton.setButtonListener(new SDARSEPGHandler$ButtonListener(this, null));
        SDARSEPGHandler$ListListener sDARSEPGHandler$ListListener = new SDARSEPGHandler$ListListener(this, null);
        this.sdarsAllStationsEpgList.setListener(sDARSEPGHandler$ListListener);
        this.sdarsOneStationEpgList.setListener(sDARSEPGHandler$ListListener);
        SDARSEPGHandler$OptionListener sDARSEPGHandler$OptionListener = new SDARSEPGHandler$OptionListener(this, null);
        this.showEpgOfFocussedStationOption.setListener(sDARSEPGHandler$OptionListener, 2005401856);
        this.showEpgOfFocussedStationOption.setListener(sDARSEPGHandler$OptionListener, 1938292992);
        this.showEpgOfFocussedStationOption.setListener(sDARSEPGHandler$OptionListener, 1921515776);
        SDARSEPGHandler$ChoiceListener sDARSEPGHandler$ChoiceListener = new SDARSEPGHandler$ChoiceListener(this, null);
        this.models.getChoiceModel(344588544).setChoiceListener(sDARSEPGHandler$ChoiceListener);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Buffer dumpAllStationsEPG() {
        Buffer buffer = new Buffer(10000);
        Object object = this.mutex;
        synchronized (object) {
            List list = this.getEpgShortInfo();
            Collections.sort(list, this.comparator);
            long l = this.clockTimeZoneOffsetHandler.getOffset();
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                EPGShortInfoExt ePGShortInfoExt = (EPGShortInfoExt)iterator.next();
                AbstractSdarsEpgListRow[] abstractSdarsEpgListRowArray = this.rowFactory.getSdarsStationEpgRows(ePGShortInfoExt, l);
                for (int i2 = 0; i2 < abstractSdarsEpgListRowArray.length; ++i2) {
                    buffer.append(abstractSdarsEpgListRowArray[i2]).append("\n");
                }
            }
        }
        return buffer;
    }

    public void setFavoriteHandler(IStoreStationHandler iStoreStationHandler) {
        if (iStoreStationHandler == null) {
            iStoreStationHandler = new NullStoreStationHandler(this.log);
        }
        this.favoriteHandler = iStoreStationHandler;
    }

    public void requestEPGDescription(int n, int n2) {
        this.log.log(-2137614336, "[SDARSEPGHandler.requestEPGDescription] sID:%1 programID:%2", (long)n, (long)n2);
        StationInfoExt stationInfoExt = new StationInfoExt();
        EPGProgramInfo ePGProgramInfo = new EPGProgramInfo();
        stationInfoExt.sID = n;
        ePGProgramInfo.programID = n2;
        ProgramSdarsEpgListRow programSdarsEpgListRow = new ProgramSdarsEpgListRow(stationInfoExt, ePGProgramInfo, 0, 0L);
        this.requestEPGDescription(programSdarsEpgListRow, 0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void requestEPGDescription(AbstractProgramSdarsEpgListRow abstractProgramSdarsEpgListRow, int n) {
        this.log.log(-2137614336, "[SDARSEPGHandler.requestEPGDescription] row:%1", (Object)abstractProgramSdarsEpgListRow);
        Object object = this.mutex;
        synchronized (object) {
            this.descriptionScreenHelper.initFor(abstractProgramSdarsEpgListRow, n, this.curSelectedStation);
        }
        this.dsiDownManager.getEPGDescription(abstractProgramSdarsEpgListRow.getSID(), abstractProgramSdarsEpgListRow.getProgramID());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean isEPGAvailableFor(StationInfoExt stationInfoExt, IEPGAvailibiltyCallback iEPGAvailibiltyCallback) {
        Object object = this.mutex;
        synchronized (object) {
            boolean bl = stationInfoExt.subscription == 2;
            boolean bl2 = this.sidToEPGShortInfo[stationInfoExt.sID] != null;
            boolean bl3 = bl ? bl2 : false;
            this.epgAvailibilityCallbackHelper = new SDARSEPGHandler$EPGAvailibiltyCallbackHelper(iEPGAvailibiltyCallback, stationInfoExt, bl3);
            return bl3;
        }
    }

    private static void highlightStationRowFor(StationInfoExt stationInfoExt, BaseListModelApp baseListModelApp) {
        int n = -1;
        for (int i2 = 0; i2 < baseListModelApp.getLength(); ++i2) {
            AbstractSdarsEpgListRow abstractSdarsEpgListRow = (AbstractSdarsEpgListRow)baseListModelApp.getRow(i2);
            if (!abstractSdarsEpgListRow.correspondsTo(stationInfoExt) || !abstractSdarsEpgListRow.representsStation() && (!abstractSdarsEpgListRow.representsProgram() || i2 != 0)) continue;
            n = i2;
            break;
        }
        baseListModelApp.setSelectedIndex(n);
    }

    private static void adjustTimeInformations(BaseListModelApp baseListModelApp, long l) {
        for (int i2 = 0; i2 < baseListModelApp.getLength(); ++i2) {
            AbstractSdarsEpgListRow abstractSdarsEpgListRow = (AbstractSdarsEpgListRow)baseListModelApp.getRow(i2);
            if (!abstractSdarsEpgListRow.representsProgram()) continue;
            ((AbstractProgramSdarsEpgListRow)abstractSdarsEpgListRow).updateTimesWithTimezoneOffset(l);
            baseListModelApp.setRow(i2, abstractSdarsEpgListRow);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void onDSIInformationEPGChannelList(EPGShortInfoExt[] ePGShortInfoExtArray) {
        SDARSEPGHandler$EPGAvailibiltyCallbackHelper sDARSEPGHandler$EPGAvailibiltyCallbackHelper = null;
        boolean bl = false;
        Object object = this.mutex;
        synchronized (object) {
            for (int i2 = 0; i2 < ePGShortInfoExtArray.length; ++i2) {
                EPGShortInfoExt ePGShortInfoExt = ePGShortInfoExtArray[i2];
                if (ePGShortInfoExt.sID < 0 || ePGShortInfoExt.sID >= 384) {
                    this.log.log(10000, "[SDARSEPGH.onDSIInformationEPGChannelList] wrong sid %1", (long)ePGShortInfoExt.sID);
                    continue;
                }
                boolean bl2 = ePGShortInfoExt.epgProgramInfo != null && ePGShortInfoExt.epgProgramInfo.length > 0;
                this.sidToEPGShortInfo[ePGShortInfoExt.sID] = bl2 ? ePGShortInfoExtArray[i2] : null;
                if (!this.epgAvailibilityCallbackHelper.isInterestedInEPGAvailibityChangesFor(ePGShortInfoExt.station)) continue;
                sDARSEPGHandler$EPGAvailibiltyCallbackHelper = this.epgAvailibilityCallbackHelper;
                boolean bl3 = ePGShortInfoExt.station.subscription == 2;
                bl = bl3 ? bl2 : false;
            }
            this.updateEPGForAllStations();
        }
        if (sDARSEPGHandler$EPGAvailibiltyCallbackHelper != null) {
            sDARSEPGHandler$EPGAvailibiltyCallbackHelper.notifyEPGAvailibity(bl);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void onDSIUpdateSelectedStation(StationInfoExt stationInfoExt) {
        Object object = this.mutex;
        synchronized (object) {
            this.curSelectedStation = stationInfoExt;
            SDARSEPGHandler.highlightStationRowFor(stationInfoExt, this.sdarsAllStationsEpgList);
            SDARSEPGHandler.highlightStationRowFor(stationInfoExt, this.sdarsOneStationEpgList);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void onDSIResponseEPG24Hour(EPGShortInfoExt ePGShortInfoExt) {
        BaseListModelApp baseListModelApp;
        Object object = this.mutex;
        synchronized (object) {
            if (this.latest24hEPGRequestSID != ePGShortInfoExt.sID) {
                return;
            }
            baseListModelApp = this.sdarsOneStationEpgList.getEmptyCopy();
            baseListModelApp.setSelectedIndex(-1);
            baseListModelApp.append(this.rowFactory.getSdarsStationEpgRows(ePGShortInfoExt, this.clockTimeZoneOffsetHandler.getOffset()));
            if (this.curSelectedStation.sID == ePGShortInfoExt.sID) {
                SDARSEPGHandler.highlightStationRowFor(this.curSelectedStation, baseListModelApp);
            }
            this.latest24hEPGRequestSID = -1;
        }
        this.sdarsOneStationEpgList.update(baseListModelApp);
        this.models.getChoiceModel(-1500970752).setValue(1);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void onDSIResponseEPGDescription(EPGDescription ePGDescription) {
        Object object = this.mutex;
        synchronized (object) {
            this.descriptionScreenHelper.updateEPGDescriptionIfMatches(ePGDescription);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void onTimeZoneOffsetChanged(long l) {
        this.log.log(-2137614336, "[SDARSEPGHandler.onTimeZoneOffsetChanged] offset:%1", l);
        BaseListModelApp baseListModelApp = this.sdarsAllStationsEpgList.getCopy();
        BaseListModelApp baseListModelApp2 = this.sdarsOneStationEpgList.getCopy();
        SDARSEPGHandler.adjustTimeInformations(baseListModelApp, l);
        SDARSEPGHandler.adjustTimeInformations(baseListModelApp2, l);
        Object object = this.mutex;
        synchronized (object) {
            this.descriptionScreenHelper.updateTimeZoneOffset(l);
        }
        this.sdarsAllStationsEpgList.update(baseListModelApp);
        this.sdarsOneStationEpgList.update(baseListModelApp2);
    }

    private void onButtonShowEPGForAllStationsTyped(int n) {
        this.log.log(-2137614336, "[SDARSEPGHandler.onButtonShowEPGForAllChannelsTyped]");
        this.showEpgOfAllStationsButton.fireEvent(n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateEPGForAllStations() {
        BaseListModelApp baseListModelApp = this.sdarsAllStationsEpgList.getEmptyCopy();
        BaseListModelApp baseListModelApp2 = this.sdarsAllStationEpgAlphIndexList.getEmptyCopy();
        Object object = this.mutex;
        synchronized (object) {
            List list = this.getEpgShortInfo();
            List list2 = this.comparator.sortAndProvideAlphabeticalIndexRowsFor(list);
            long l = this.clockTimeZoneOffsetHandler.getOffset();
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                EPGShortInfoExt ePGShortInfoExt = (EPGShortInfoExt)iterator.next();
                EvoListRow[] evoListRowArray = this.rowFactory.getSdarsGlobalEpgRows(ePGShortInfoExt, l, 2);
                baseListModelApp.append(evoListRowArray);
            }
            SDARSEPGHandler.highlightStationRowFor(this.curSelectedStation, baseListModelApp);
            if (!list2.isEmpty()) {
                baseListModelApp2.append((AlphabeticalIndexRow[])list2.toArray(new AlphabeticalIndexRow[list2.size()]));
            }
        }
        this.sdarsAllStationsEpgList.update(baseListModelApp);
        this.sdarsAllStationEpgAlphIndexList.update(baseListModelApp2);
    }

    private List getEpgShortInfo() {
        ArrayList arrayList = new ArrayList(384);
        for (int i2 = 0; i2 < this.sidToEPGShortInfo.length; ++i2) {
            EPGShortInfoExt ePGShortInfoExt = this.sidToEPGShortInfo[i2];
            if (ePGShortInfoExt == null || ePGShortInfoExt.station.subscription != 2 || !this.catFilter[ePGShortInfoExt.station.categoryNumber]) continue;
            arrayList.add(ePGShortInfoExt);
        }
        return arrayList;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void onOptionShowEPGForFocussedStationInSDARSStationList(int n, int n2) {
        this.log.log(-2137614336, "[SDARSEPGHandler.onOptionShowEPGForFocussedStationInSDARSStationList] %1", (long)n);
        Object object = this.mutex;
        synchronized (object) {
            if (this.latest24hEPGRequestSID == n) {
                return;
            }
            this.latest24hEPGRequestSID = n;
        }
        this.dsiDownManager.getEPG24Hour(n);
        this.showEpgOfFocussedStationOption.fireEvent(n2);
    }

    private void onListItemSelectedInSDARSEPGList(int n, int n2, int n3, int n4) {
        BaseListModelApp baseListModelApp = this.models.getBaseListModel(n);
        AbstractSdarsEpgListRow abstractSdarsEpgListRow = (AbstractSdarsEpgListRow)baseListModelApp.getRow(n2);
        int n5 = abstractSdarsEpgListRow.getActionForSelection(n3);
        switch (n5) {
            case 3: {
                this.log.log(-2137614336, "[SDARSEPGHandler.onListItemSelectedInSDARSEPGList] station row, sID %2 (%1)", (Object)abstractSdarsEpgListRow, (long)abstractSdarsEpgListRow.station.sID);
                this.scanHandler.abortScan();
                this.dsiDownManager.selectStation(abstractSdarsEpgListRow.station, n4);
                break;
            }
            case 1: {
                this.updateEPGDetailDataFor(abstractSdarsEpgListRow);
                baseListModelApp.fireEvent(n4);
                break;
            }
            case 2: {
                this.setDetailIndex(n2);
                AbstractProgramSdarsEpgListRow abstractProgramSdarsEpgListRow = (AbstractProgramSdarsEpgListRow)abstractSdarsEpgListRow;
                this.log.log(-2137614336, "[SDARSEPGHandler.onListItemSelectedInSDARSEPGList] program row, sID %2, programID %3 (%1)", (Object)abstractProgramSdarsEpgListRow, (long)abstractProgramSdarsEpgListRow.getSID(), (long)abstractProgramSdarsEpgListRow.getProgramID());
                this.models.getResourceLocatorModel(260702464).setResourceLocator(abstractProgramSdarsEpgListRow.getStation().getStationArt());
                this.requestEPGDescription(abstractProgramSdarsEpgListRow, n2);
                baseListModelApp.fireEvent(n4);
                this.varExt.showPartialPopup(23);
                break;
            }
        }
    }

    public void updateEPGDetailData() {
        AbstractSdarsEpgListRow abstractSdarsEpgListRow = null;
        SelectedItem selectedItem = this.sdarsAllStationsEpgList.getSelected();
        if (selectedItem != null) {
            abstractSdarsEpgListRow = (AbstractSdarsEpgListRow)this.sdarsAllStationsEpgList.getRowByUniqueID(selectedItem.getUniqueID());
        }
        if (abstractSdarsEpgListRow == null && this.sdarsAllStationsEpgList.getLength() > 0) {
            abstractSdarsEpgListRow = (AbstractSdarsEpgListRow)this.sdarsAllStationsEpgList.getRow(0);
        }
        if (abstractSdarsEpgListRow != null) {
            this.updateEPGDetailDataFor(abstractSdarsEpgListRow);
        }
        this.models.getChoiceModel(-1500970752).setValue(selectedItem != null ? 1 : 0);
    }

    private void updateEPGDetailDataFor(AbstractSdarsEpgListRow abstractSdarsEpgListRow) {
        StationInfoExt stationInfoExt;
        this.detailSdarsStation = stationInfoExt = abstractSdarsEpgListRow.station;
        this.descriptionScreenHelper.setChannelName(stationInfoExt.getFullLabel());
        this.models.getLabelModel(1602814208).setText(stationInfoExt.getFullLabel());
        this.models.getLabelModel(227148032).setText(Utilities.getFormatedStationNumber(stationInfoExt.stationNumber));
        this.models.getLabelModel(-1568079616).setText(stationInfoExt.getFullCategory());
        this.models.getResourceLocatorModel(260702464).setResourceLocator(stationInfoExt.getStationArt());
        boolean bl = this.favoriteHandler.isStored(new TunerObjectContainer(stationInfoExt));
        this.models.getChoiceModel(344588544).setValue(bl ? 1 : 0);
        this.onOptionShowEPGForFocussedStationInSDARSStationList(stationInfoExt.sID, 0);
    }

    private void setDetailIndex(int n) {
        this.detailIndex = n;
        if (n == 0) {
            this.prevEpgButton.setStatus(3);
        } else {
            this.prevEpgButton.setStatus(1);
        }
        if (n == this.sdarsOneStationEpgList.getLength() - 1) {
            this.nextEpgButton.setStatus(3);
        } else {
            this.nextEpgButton.setStatus(1);
        }
    }

    public void setSortAlgo(int n) {
        switch (n) {
            case 1: {
                this.comparator = new SortAlgoName(this.langMngr);
                break;
            }
            case 0: {
                this.comparator = new SortAlgoStNumber(this.langMngr);
                break;
            }
            case 3: {
                this.comparator = new SortAlgoCatAndName(this.langMngr);
                break;
            }
            case 2: {
                this.comparator = new SortAlgoCatAndStNumber(this.langMngr);
                break;
            }
            default: {
                this.comparator = new SortAlgoName(this.langMngr);
            }
        }
        this.updateEPGForAllStations();
    }

    static /* synthetic */ void access$800(SDARSEPGHandler sDARSEPGHandler, EPGShortInfoExt[] ePGShortInfoExtArray) {
        sDARSEPGHandler.onDSIInformationEPGChannelList(ePGShortInfoExtArray);
    }

    static /* synthetic */ void access$900(SDARSEPGHandler sDARSEPGHandler, StationInfoExt stationInfoExt) {
        sDARSEPGHandler.onDSIUpdateSelectedStation(stationInfoExt);
    }

    static /* synthetic */ void access$1000(SDARSEPGHandler sDARSEPGHandler, EPGShortInfoExt ePGShortInfoExt) {
        sDARSEPGHandler.onDSIResponseEPG24Hour(ePGShortInfoExt);
    }

    static /* synthetic */ void access$1100(SDARSEPGHandler sDARSEPGHandler, EPGDescription ePGDescription) {
        sDARSEPGHandler.onDSIResponseEPGDescription(ePGDescription);
    }

    static /* synthetic */ void access$1200(SDARSEPGHandler sDARSEPGHandler, int n) {
        sDARSEPGHandler.onButtonShowEPGForAllStationsTyped(n);
    }

    static /* synthetic */ StationInfoExt access$1300(SDARSEPGHandler sDARSEPGHandler) {
        return sDARSEPGHandler.detailSdarsStation;
    }

    static /* synthetic */ IStoreStationHandler access$1400(SDARSEPGHandler sDARSEPGHandler) {
        return sDARSEPGHandler.favoriteHandler;
    }

    static /* synthetic */ TunerModels access$1500(SDARSEPGHandler sDARSEPGHandler) {
        return sDARSEPGHandler.models;
    }

    static /* synthetic */ BaseListModelApp access$1600(SDARSEPGHandler sDARSEPGHandler) {
        return sDARSEPGHandler.sdarsOneStationEpgList;
    }

    static /* synthetic */ void access$1700(SDARSEPGHandler sDARSEPGHandler, int n) {
        sDARSEPGHandler.setDetailIndex(n);
    }

    static /* synthetic */ void access$1800(SDARSEPGHandler sDARSEPGHandler, AbstractProgramSdarsEpgListRow abstractProgramSdarsEpgListRow, int n) {
        sDARSEPGHandler.requestEPGDescription(abstractProgramSdarsEpgListRow, n);
    }

    static /* synthetic */ void access$1900(SDARSEPGHandler sDARSEPGHandler, int n, int n2, int n3, int n4) {
        sDARSEPGHandler.onListItemSelectedInSDARSEPGList(n, n2, n3, n4);
    }

    static /* synthetic */ void access$2000(SDARSEPGHandler sDARSEPGHandler, long l) {
        sDARSEPGHandler.onTimeZoneOffsetChanged(l);
    }
}

