/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.epg.dab;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.RadioObjectIds;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.TunerProxyManager;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.dsi.RadioInfo;
import de.audi.tuner.app.dab.DABDsiDownInfo;
import de.audi.tuner.app.dab.DABDsiUpInfo;
import de.audi.tuner.app.dab.DabReceptionStatus;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.dab.sortandindex.station.AbstractDabStationComparatorAndIndexer;
import de.audi.tuner.app.dab.sortandindex.station.SortAlgoDabStationName;
import de.audi.tuner.app.epg.ClockTimeZoneOffsetHandler;
import de.audi.tuner.app.epg.dab.EPGListRow;
import de.audi.tuner.app.epg.dab.EPGListRowInfo;
import de.audi.tuner.app.epg.dab.EPGShortInfoExt;
import de.audi.tuner.app.epg.dab.IDabEpgHandler;
import de.audi.tuner.app.sortandindex.AlphabeticalIndexRow;
import de.audi.tuner.app.uni.UniDsiDownInfo;
import de.audi.tuner.app.uni.UniDsiUpInfo;
import de.audi.tuner.app.uni.UnifiedStationExt;
import de.audi.tuner.ifc.AbstractListRowFactory;
import de.audi.tuner.ifc.IDABTuner;
import de.audi.tuner.ifc.IScanHandler;
import de.audi.tuner.ifc.IStoreStationHandler;
import de.audi.tuner.ifc.ITunerVariantExt;
import de.audi.tuner.util.NullStoreStationHandler;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.Collections;
import org.dsi.ifc.radio.EPGFullInfo;
import org.dsi.ifc.radio.EPGFullProgramInfo;
import org.dsi.ifc.radio.EPGShortProgramInfo;

public class DABEpgHandler
implements IDabEpgHandler {
    private final DABDsiUpInfo dabDsiUpListener = new DabDsiUpListener();
    private final DABDsiDownInfo dabDsiDownListener = new DabDsiDownListener();
    private final UniDsiUpInfo uniDsiUpListener = new UniDsiUpListener();
    private final UniDsiDownInfo uniDsiDownListener = new UniDsiDownListener();
    private static final String LOGCLASS = "DABEpgHandler";
    public static final int REQUESTED_NOW = 1;
    public static final int REQUESTED_NEXT = 2;
    public static final int SELECTED_PROGRAM_ACTIVE = 1;
    public static final int SELECTED_PROGRAM_INACTIVE = 0;
    private final Logger logger;
    private final TunerModels models;
    private final IDABTuner dabTuner;
    private IStoreStationHandler favoriteHandler;
    private final BaseListModelApp epgList;
    private final BaseListModelApp indexEpgList;
    private final AbstractListRowFactory rowFactory;
    private final ITunerVariantExt varExt;
    private final AbstractDabStationComparatorAndIndexer comparator;
    private int nowOrNextRequested;
    private EPGListRow detailsRequested;
    private final ClockTimeZoneOffsetHandler timeZoneOffset;
    private DabStation currentDabStation = new DabStation();
    private UnifiedStationExt currentUniStation = new UnifiedStationExt();
    private DabStation detailDabStation = new DabStation();
    private final Object mutex = new Object();
    private EPGFullInfo epgDetailData;
    private long detailId = 0L;
    private int detailIndex;

    public DABEpgHandler(TunerBasics tunerBasics, IDABTuner iDABTuner, LanguageManager languageManager, ITunerVariantExt iTunerVariantExt, ClockTimeZoneOffsetHandler clockTimeZoneOffsetHandler, IScanHandler iScanHandler) {
        this.logger = tunerBasics.getLogger();
        this.models = tunerBasics.getModels();
        this.dabTuner = iDABTuner;
        this.rowFactory = iTunerVariantExt.getListRowFactory();
        this.varExt = iTunerVariantExt;
        this.timeZoneOffset = clockTimeZoneOffsetHandler;
        this.favoriteHandler = new NullStoreStationHandler(this.logger.main);
        this.epgList = this.models.getBaseListModel(100459);
        this.indexEpgList = this.models.getBaseListModel(100922);
        this.comparator = new SortAlgoDabStationName(languageManager);
        ListListener listListener = new ListListener();
        this.epgList.setListener(listListener);
        this.models.getBaseListModel(100532).setListener(listListener);
        ButtonListener buttonListener = new ButtonListener();
        this.models.getButtonModel(100601).setButtonListener(buttonListener);
        this.models.getButtonModel(100599).setButtonListener(buttonListener);
        this.models.getChoiceModel(100772).setChoiceListener(new ChoiceListener());
        this.timeZoneOffset.addClockTimeZoneOffsetListener(new ClockTimeZoneOffsetListener());
        this.epgList.setStatus(0);
    }

    public RadioInfo[] getDabListeners() {
        return new RadioInfo[]{this.dabDsiUpListener, this.dabDsiDownListener};
    }

    public RadioInfo[] getUniListeners() {
        return new RadioInfo[]{this.uniDsiUpListener, this.uniDsiDownListener};
    }

    public void setFavoriteHandler(IStoreStationHandler iStoreStationHandler) {
        if (iStoreStationHandler == null) {
            iStoreStationHandler = new NullStoreStationHandler(this.logger.main);
        }
        this.favoriteHandler = iStoreStationHandler;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setEPGList(EPGShortInfoExt[] ePGShortInfoExtArray) {
        Object object;
        if (ePGShortInfoExtArray.length == 0) {
            this.epgList.removeAll();
            this.epgList.setStatus(0);
            this.models.getButtonModel(100380).setStatus(3);
            this.models.getChoiceModel(100696).setValue(0);
            this.logger.dabData.log(1000000, "[%1#setEpgList]Received empty epgListData", (Object)LOGCLASS);
            return;
        }
        ArrayList arrayList = new ArrayList(ePGShortInfoExtArray.length);
        for (int i2 = 0; i2 < ePGShortInfoExtArray.length; ++i2) {
            EPGShortInfoExt ePGShortInfoExt = ePGShortInfoExtArray[i2];
            if (ePGShortInfoExt == null || ePGShortInfoExt.getNowProgramInfo() == null || ePGShortInfoExt.getNextProgramInfo() == null) {
                this.logger.dabData.log(100000, "[%1#setEpgList]Received invalid EPGShortInfo %2", (Object)LOGCLASS, (Object)ePGShortInfoExt);
                continue;
            }
            arrayList.add(ePGShortInfoExt);
        }
        Collections.sort(arrayList, this.comparator);
        long l = this.timeZoneOffset.getOffset();
        ArrayList arrayList2 = new ArrayList(3 * ePGShortInfoExtArray.length);
        Object object2 = arrayList.iterator();
        while (object2.hasNext()) {
            object = this.rowFactory.getEpgRows((EPGShortInfoExt)object2.next(), l);
            for (int i3 = 0; i3 < ((EPGListRow[])object).length; ++i3) {
                arrayList2.add(object[i3]);
            }
        }
        object2 = this.comparator.provideAlphabeticalIndexRowsForAlreadySortedList(arrayList2);
        object = this.epgList.getEmptyCopy();
        object.append((EvoListRow[])arrayList2.toArray(new EvoListRow[arrayList2.size()]));
        BaseListModelApp baseListModelApp = this.indexEpgList.getEmptyCopy();
        if (!object2.isEmpty()) {
            baseListModelApp.append((AlphabeticalIndexRow[])object2.toArray(new AlphabeticalIndexRow[object2.size()]));
        }
        this.models.getButtonModel(100380).setStatus(1);
        Object object3 = this.mutex;
        synchronized (object3) {
            this.updateHighlighting((BaseListModelApp)object);
            this.epgList.update((BaseListModelApp)object);
            this.epgList.setStatus(1);
            this.indexEpgList.update(baseListModelApp);
            this.models.getChoiceModel(100696).setValue(1);
        }
    }

    public void setEPGDetailData(EPGFullInfo ePGFullInfo) {
        if (this.detailsRequested.getDabStation().ensemble.ensID != ePGFullInfo.getEnsID() || this.detailsRequested.getDabStation().ensemble.ensECC != ePGFullInfo.getEnsECC() || this.detailsRequested.getDabStation().service.sID != ePGFullInfo.getSID() || this.detailsRequested.getDabStation().component.sCIDI != ePGFullInfo.getSCIDI()) {
            this.logger.main.log(100000, "[%1.setEPGDetailData] received data for not requested channel req: %2 rec:%3", (Object)LOGCLASS, (Object)this.detailsRequested.getDabStation(), ePGFullInfo.getSID());
            return;
        }
        this.epgDetailData = ePGFullInfo;
        if (Utilities.isPGen1OrBentley()) {
            this.fillDetailedList();
        } else {
            EPGFullProgramInfo ePGFullProgramInfo;
            EPGFullProgramInfo ePGFullProgramInfo2 = ePGFullProgramInfo = this.nowOrNextRequested == 1 ? ePGFullInfo.getNowProgramInfo() : ePGFullInfo.getNextProgramInfo();
            if (ePGFullProgramInfo != null) {
                this.showDetails(ePGFullProgramInfo);
            } else {
                this.logger.main.log(100000, "[%1.setEPGDetailData] received EPGFullProgramInfo == null", (Object)LOGCLASS);
            }
        }
    }

    public void updateEPGDetailData() {
        EPGListRow ePGListRow = null;
        SelectedItem selectedItem = this.epgList.getSelected();
        if (selectedItem != null) {
            ePGListRow = (EPGListRow)this.epgList.getRowByUniqueID(selectedItem.getUniqueID());
        }
        if (ePGListRow == null && this.epgList.getLength() > 0) {
            ePGListRow = (EPGListRow)this.epgList.getRow(0);
        }
        if (ePGListRow != null) {
            this.updateEPGDetailDataFor(ePGListRow);
        }
        this.models.getChoiceModel(100768).setValue(ePGListRow != null ? 1 : 0);
    }

    private void updateEPGDetailDataFor(EPGListRow ePGListRow) {
        this.detailDabStation = ePGListRow.getDabStation();
        EPGShortInfoExt ePGShortInfoExt = ePGListRow.getShortInfo();
        this.nowOrNextRequested = 1;
        if (ePGListRow instanceof EPGListRowInfo) {
            this.nowOrNextRequested = ((EPGListRowInfo)ePGListRow).getNowOrNext();
        }
        EPGShortProgramInfo ePGShortProgramInfo = this.nowOrNextRequested == 1 ? ePGShortInfoExt.nowProgramInfo : ePGShortInfoExt.nextProgramInfo;
        this.resetDetailView(ePGShortProgramInfo);
        this.dabTuner.getEPGDetailData(this.detailDabStation);
        this.detailsRequested = ePGListRow;
        this.models.getLabelModel(100381).setText(ePGListRow.getStationName());
        this.models.getLabelModel(100381).setStatus(this.nowOrNextRequested);
        this.models.getLabelModel(100871).setText(this.detailDabStation.ensemble.fullName);
        this.models.getChoiceModel(100880).setValue(this.detailDabStation.getPTY());
        boolean bl = this.favoriteHandler.isStored(new TunerObjectContainer(this.detailDabStation));
        this.models.getChoiceModel(100772).setValue(bl ? 1 : 0);
        this.models.getResourceLocatorModel(100875).setResourceLocator(ePGListRow.getDabStation().getStationLogo());
        this.models.getResourceLocatorModel(100596).setResourceLocator(ePGListRow.getDabStation().getStationLogo());
    }

    private void showDetails(EPGFullProgramInfo ePGFullProgramInfo) {
        EPGShortProgramInfo ePGShortProgramInfo = ePGFullProgramInfo.getShortInfo();
        if (ePGShortProgramInfo != null) {
            this.models.getLabelModel(100384).setText(ePGShortProgramInfo.getProgramInfo());
            this.models.getLabelModel(100383).setText(this.getTimeString(ePGShortProgramInfo));
            this.models.getLabelModel(100600).setText(this.getBeginTimeString(ePGShortProgramInfo));
            this.models.getLabelModel(100598).setText(this.getBeginDateString(ePGShortProgramInfo));
        } else {
            this.logger.main.log(100000, "[%1.setEPGDetailData] received EPGShortProgramInfo == null", (Object)LOGCLASS);
        }
        String string = ePGFullProgramInfo.getDetailProgramInfo();
        this.models.getLabelModel(100382).setText(string);
        this.models.getLabelModel(100382).setStatus(Utilities.isEmpty(string) ? 0 : 1);
    }

    private String getBeginDateString(EPGShortProgramInfo ePGShortProgramInfo) {
        long l = this.timeZoneOffset.getOffset();
        long l2 = ePGShortProgramInfo.getStartTime().getTime() + l;
        return Utilities.getFormatedDate(l2);
    }

    private String getBeginTimeString(EPGShortProgramInfo ePGShortProgramInfo) {
        long l = this.timeZoneOffset.getOffset();
        long l2 = ePGShortProgramInfo.getStartTime().getTime() + l;
        return Utilities.getFormatedTime(l2);
    }

    private String getTimeString(EPGShortProgramInfo ePGShortProgramInfo) {
        long l = this.timeZoneOffset.getOffset();
        long l2 = ePGShortProgramInfo.getStartTime().getTime() + l;
        long l3 = ePGShortProgramInfo.getEndTime().getTime() + l;
        return new Buffer(20).append(Utilities.getFormatedTime(l2)).append(" - ").append(Utilities.getFormatedTime(l3)).toString();
    }

    private void fillDetailedList() {
        BaseListModelApp baseListModelApp = this.models.getBaseListModel(100532);
        baseListModelApp.removeAll();
        baseListModelApp.setSelectedIndex(-1);
        EPGFullProgramInfo ePGFullProgramInfo = this.epgDetailData.nowProgramInfo;
        EpgDetailRow epgDetailRow = new EpgDetailRow(this.detailId++, ePGFullProgramInfo, true);
        baseListModelApp.append(epgDetailRow);
        ePGFullProgramInfo = this.epgDetailData.nextProgramInfo;
        epgDetailRow = new EpgDetailRow(this.detailId++, ePGFullProgramInfo, false);
        baseListModelApp.append(epgDetailRow);
        EPGFullProgramInfo[] ePGFullProgramInfoArray = this.epgDetailData.extendedProgramInfo.fullProgramInfoList;
        for (int i2 = 0; i2 < ePGFullProgramInfoArray.length; ++i2) {
            epgDetailRow = new EpgDetailRow(this.detailId++, ePGFullProgramInfoArray[i2], false);
            baseListModelApp.append(epgDetailRow);
        }
        if (this.epgDetailData != null && this.currentDabStation.ensemble.ensID == this.epgDetailData.ensID && this.currentDabStation.ensemble.ensECC == this.epgDetailData.ensECC && this.currentDabStation.service.sID == this.epgDetailData.sID && this.currentDabStation.component.sCIDI == this.epgDetailData.sCIDI) {
            baseListModelApp.setSelectedIndex(0);
        }
    }

    private void resetDetailView(EPGShortProgramInfo ePGShortProgramInfo) {
        if (ePGShortProgramInfo != null) {
            this.models.getLabelModel(100384).setText(ePGShortProgramInfo.getProgramInfo());
            this.models.getLabelModel(100383).setText(this.getTimeString(ePGShortProgramInfo));
            this.models.getLabelModel(100382).setText("");
        } else {
            this.models.getLabelModel(100384).setText("");
            this.models.getLabelModel(100383).setText("");
            this.models.getLabelModel(100382).setText("");
        }
        this.models.getLabelModel(100382).setStatus(1);
    }

    private void updateHighlighting(BaseListModelApp baseListModelApp) {
        if (this.models.getActiveTuner() == 5) {
            if (!baseListModelApp.setSelectedUniqueID(this.currentDabStation.getUniqueId())) {
                baseListModelApp.setSelectedIndex(-1);
            }
        } else if (this.models.getActiveTuner() == 11) {
            if (!baseListModelApp.setSelectedUniqueID(RadioObjectIds.getDabId(this.currentUniStation.ensId, this.currentUniStation.ecc, this.currentUniStation.piSId, this.currentUniStation.sCIDI, this.currentUniStation.sCIDI == 0))) {
                baseListModelApp.setSelectedIndex(-1);
            }
        } else {
            baseListModelApp.setSelectedIndex(-1);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setCurrentStation(DabStation dabStation) {
        Object object = this.mutex;
        synchronized (object) {
            this.currentDabStation = dabStation;
            this.updateHighlighting(this.epgList);
            int n = -1;
            if (this.epgDetailData != null && this.currentDabStation.ensemble.ensID == this.epgDetailData.ensID && this.currentDabStation.ensemble.ensECC == this.epgDetailData.ensECC && this.currentDabStation.service.sID == this.epgDetailData.sID && this.currentDabStation.component.sCIDI == this.epgDetailData.sCIDI) {
                n = 0;
            }
            if (this.models.getBaseListModel(100532).getLength() > 0) {
                this.models.getBaseListModel(100532).setSelectedIndex(n);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setCurrentStation(UnifiedStationExt unifiedStationExt) {
        Object object = this.mutex;
        synchronized (object) {
            this.currentUniStation = unifiedStationExt;
            this.updateHighlighting(this.epgList);
        }
    }

    private void setDetailIndex(int n) {
        this.detailIndex = n;
        if (n == 0) {
            this.models.getButtonModel(100599).setStatus(3);
            this.models.getChoiceModel(100832).setValue(1);
        } else {
            this.models.getButtonModel(100599).setStatus(1);
            this.models.getChoiceModel(100832).setValue(0);
        }
        if (n == this.models.getBaseListModel(100532).getLength() - 1) {
            this.models.getButtonModel(100601).setStatus(3);
        } else {
            this.models.getButtonModel(100601).setStatus(1);
        }
    }

    private class EpgDetailRow
    extends EvoListRow {
        private static final int NUM_COLS = 4;
        private static final int RS_NOW_PROGRAM = 0;
        private static final int RS_OTHER_PROGRAM = 1;
        private static final int INDEX_TIME = 0;
        private static final int INDEX_TITLE = 1;
        private static final int INDEX_DETAIL = 2;
        private static final int INDEX_RS = 3;
        private final EPGFullProgramInfo info;

        public EpgDetailRow(long l, EPGFullProgramInfo ePGFullProgramInfo, boolean bl) {
            super(l, 4);
            this.info = ePGFullProgramInfo;
            long l2 = DABEpgHandler.this.timeZoneOffset.getOffset();
            long l3 = ePGFullProgramInfo.shortInfo.getStartTime().getTime() + l2;
            this.setText(0, Utilities.getFormatedTime(l3));
            this.setText(1, ePGFullProgramInfo.shortInfo.programInfo);
            this.setText(2, ePGFullProgramInfo.detailProgramInfo);
            this.setInteger(3, bl ? 0 : 1);
        }

        private EpgDetailRow(EpgDetailRow epgDetailRow) {
            super(epgDetailRow);
            this.info = epgDetailRow.info;
        }

        public EvoListRow copy() {
            return new EpgDetailRow(this);
        }

        public EPGFullProgramInfo getDetails() {
            return this.info;
        }
    }

    private class ListListener
    extends DefaultBaseListModelListener {
        private ListListener() {
        }

        public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            switch (n) {
                case 100459: {
                    DabStation dabStation = ((EPGListRow)evoListRow).getDabStation();
                    if (evoListRow.getInteger(0) == 0) {
                        if (n3 == 0) {
                            DABEpgHandler.this.epgList.setSelectedIndex(n2);
                            if (DABEpgHandler.this.models.getActiveTuner() == 5) {
                                TunerProxyManager.getInstance().prepareAndTune(new TunerObjectContainer(dabStation), n4);
                                break;
                            }
                            UnifiedStationExt unifiedStationExt = new UnifiedStationExt();
                            unifiedStationExt.shortName = dabStation.getShortName();
                            unifiedStationExt.longName = dabStation.getFullName();
                            unifiedStationExt.frequency = dabStation.ensemble.frequencyValue;
                            unifiedStationExt.piSId = (int)dabStation.service.sID;
                            unifiedStationExt.ensId = dabStation.service.ensID;
                            unifiedStationExt.ecc = dabStation.service.ensECC;
                            unifiedStationExt.sCIDI = dabStation.component.sCIDI;
                            TunerProxyManager.getInstance().prepareAndTune(new TunerObjectContainer(unifiedStationExt), n4);
                            break;
                        }
                        this.prepareDetailsList(evoListRow, n4);
                        break;
                    }
                    DABEpgHandler.this.updateEPGDetailDataFor((EPGListRow)evoListRow);
                    DABEpgHandler.this.models.getChoiceModel(100768).setValue(1);
                    DABEpgHandler.this.epgList.fireEvent(n4);
                    break;
                }
                case 100532: {
                    DABEpgHandler.this.setDetailIndex(n2);
                    EpgDetailRow epgDetailRow = (EpgDetailRow)evoListRow;
                    DABEpgHandler.this.showDetails(epgDetailRow.getDetails());
                    DABEpgHandler.this.models.getBaseListModel(100532).fireEvent(n4);
                    DABEpgHandler.this.varExt.showPartialPopup(22);
                    break;
                }
            }
        }

        public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            if (Utilities.isPGen1OrBentley()) {
                this.prepareDetailsList(evoListRow, n4);
            }
        }

        private void prepareDetailsList(EvoListRow evoListRow, int n) {
            BaseListModelApp baseListModelApp = DABEpgHandler.this.models.getBaseListModel(100532);
            baseListModelApp.removeAll();
            DabStation dabStation = ((EPGListRow)evoListRow).getDabStation();
            DABEpgHandler.this.detailDabStation = dabStation;
            DABEpgHandler.this.dabTuner.getEPGDetailData(dabStation);
            DABEpgHandler.this.resetDetailView(null);
            DABEpgHandler.this.detailsRequested = (EPGListRow)evoListRow;
            DABEpgHandler.this.models.getLabelModel(100381).setText(((EPGListRow)evoListRow).getStationName());
            DABEpgHandler.this.models.getResourceLocatorModel(100875).setResourceLocator(dabStation.getStationLogo());
            DABEpgHandler.this.models.getResourceLocatorModel(100596).setResourceLocator(dabStation.getStationLogo());
            DABEpgHandler.this.epgList.fireEvent(n);
        }
    }

    private class ButtonListener
    extends DefaultButtonListener {
        private ButtonListener() {
        }

        public void keyPressed(int n, int n2, int n3) {
            int n4 = n == 100599 ? DABEpgHandler.this.detailIndex - 1 : DABEpgHandler.this.detailIndex + 1;
            EpgDetailRow epgDetailRow = (EpgDetailRow)DABEpgHandler.this.models.getBaseListModel(100532).getRow(n4);
            if (epgDetailRow != null) {
                DABEpgHandler.this.setDetailIndex(n4);
                DABEpgHandler.this.showDetails(epgDetailRow.getDetails());
            }
        }
    }

    private class ChoiceListener
    extends DefaultChoiceListener {
        private ChoiceListener() {
        }

        public void keyPressed(int n, int n2, int n3) {
            TunerObjectContainer tunerObjectContainer = new TunerObjectContainer(DABEpgHandler.this.detailDabStation);
            int n4 = DABEpgHandler.this.favoriteHandler.toggleStore(tunerObjectContainer);
            DABEpgHandler.this.models.getChoiceModel(100772).setValue(n4);
        }
    }

    private class DabDsiUpListener
    extends DABDsiUpInfo {
        private DabDsiUpListener() {
        }

        public void setEPGList(EPGShortInfoExt[] ePGShortInfoExtArray) {
            DABEpgHandler.this.setEPGList(ePGShortInfoExtArray);
        }

        public void setEPGDetailData(EPGFullInfo ePGFullInfo) {
            DABEpgHandler.this.setEPGDetailData(ePGFullInfo);
        }

        public void updateCurrentStation(DabStation dabStation, DabReceptionStatus dabReceptionStatus) {
            DABEpgHandler.this.setCurrentStation(dabStation);
        }
    }

    private class UniDsiUpListener
    extends UniDsiUpInfo {
        private UniDsiUpListener() {
        }

        public void updateSelectedStation(UnifiedStationExt unifiedStationExt) {
            DABEpgHandler.this.setCurrentStation(unifiedStationExt);
        }
    }

    private class DabDsiDownListener
    extends DABDsiDownInfo {
        private DabDsiDownListener() {
        }

        public void preTuneAction(DabStation dabStation, DabReceptionStatus dabReceptionStatus, int n) {
            DABEpgHandler.this.setCurrentStation(dabStation);
        }
    }

    private class UniDsiDownListener
    extends UniDsiDownInfo {
        private UniDsiDownListener() {
        }

        public void preTuneCommand(UnifiedStationExt unifiedStationExt) {
            DABEpgHandler.this.setCurrentStation(unifiedStationExt);
        }
    }

    private class ClockTimeZoneOffsetListener
    implements ClockTimeZoneOffsetHandler.IClockTimeZoneOffsetListener {
        private ClockTimeZoneOffsetListener() {
        }

        public void offsetChanged(long l) {
            DABEpgHandler.this.dabTuner.setNotification(new int[]{29});
        }
    }
}

