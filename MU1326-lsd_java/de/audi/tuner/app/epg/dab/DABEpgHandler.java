/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.epg.dab;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.RadioObjectIds;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.dsi.RadioInfo;
import de.audi.tuner.app.dab.DABDsiDownInfo;
import de.audi.tuner.app.dab.DABDsiUpInfo;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.dab.sortandindex.station.AbstractDabStationComparatorAndIndexer;
import de.audi.tuner.app.dab.sortandindex.station.SortAlgoDabStationName;
import de.audi.tuner.app.epg.ClockTimeZoneOffsetHandler;
import de.audi.tuner.app.epg.dab.DABEpgHandler$ButtonListener;
import de.audi.tuner.app.epg.dab.DABEpgHandler$ChoiceListener;
import de.audi.tuner.app.epg.dab.DABEpgHandler$ClockTimeZoneOffsetListener;
import de.audi.tuner.app.epg.dab.DABEpgHandler$DabDsiDownListener;
import de.audi.tuner.app.epg.dab.DABEpgHandler$DabDsiUpListener;
import de.audi.tuner.app.epg.dab.DABEpgHandler$EpgDetailRow;
import de.audi.tuner.app.epg.dab.DABEpgHandler$ListListener;
import de.audi.tuner.app.epg.dab.DABEpgHandler$UniDsiDownListener;
import de.audi.tuner.app.epg.dab.DABEpgHandler$UniDsiUpListener;
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
    private final DABDsiUpInfo dabDsiUpListener = new DABEpgHandler$DabDsiUpListener(this, null);
    private final DABDsiDownInfo dabDsiDownListener = new DABEpgHandler$DabDsiDownListener(this, null);
    private final UniDsiUpInfo uniDsiUpListener = new DABEpgHandler$UniDsiUpListener(this, null);
    private final UniDsiDownInfo uniDsiDownListener = new DABEpgHandler$UniDsiDownListener(this, null);
    private static final String LOGCLASS;
    public static final int REQUESTED_NOW;
    public static final int REQUESTED_NEXT;
    public static final int SELECTED_PROGRAM_ACTIVE;
    public static final int SELECTED_PROGRAM_INACTIVE;
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
        this.epgList = this.models.getBaseListModel(1804075264);
        this.indexEpgList = this.models.getBaseListModel(982122752);
        this.comparator = new SortAlgoDabStationName(languageManager);
        DABEpgHandler$ListListener dABEpgHandler$ListListener = new DABEpgHandler$ListListener(this, null);
        this.epgList.setListener(dABEpgHandler$ListListener);
        this.models.getBaseListModel(-1266155264).setListener(dABEpgHandler$ListListener);
        DABEpgHandler$ButtonListener dABEpgHandler$ButtonListener = new DABEpgHandler$ButtonListener(this, null);
        this.models.getButtonModel(-108527360).setButtonListener(dABEpgHandler$ButtonListener);
        this.models.getButtonModel(-142081792).setButtonListener(dABEpgHandler$ButtonListener);
        this.models.getChoiceModel(-1534525184).setChoiceListener(new DABEpgHandler$ChoiceListener(this, null));
        this.timeZoneOffset.addClockTimeZoneOffsetListener(new DABEpgHandler$ClockTimeZoneOffsetListener(this, null));
        this.epgList.setStatus(0);
    }

    @Override
    public RadioInfo[] getDabListeners() {
        return new RadioInfo[]{this.dabDsiUpListener, this.dabDsiDownListener};
    }

    @Override
    public RadioInfo[] getUniListeners() {
        return new RadioInfo[]{this.uniDsiUpListener, this.uniDsiDownListener};
    }

    @Override
    public void setFavoriteHandler(IStoreStationHandler iStoreStationHandler) {
        if (iStoreStationHandler == null) {
            iStoreStationHandler = new NullStoreStationHandler(this.logger.main);
        }
        this.favoriteHandler = iStoreStationHandler;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void setEPGList(EPGShortInfoExt[] ePGShortInfoExtArray) {
        Object object;
        if (ePGShortInfoExtArray.length == 0) {
            this.epgList.removeAll();
            this.epgList.setStatus(0);
            this.models.getButtonModel(478675200).setStatus(3);
            this.models.getChoiceModel(1485373696).setValue(0);
            this.logger.dabData.log(1078071040, "[%1#setEpgList]Received empty epgListData", (Object)"DABEpgHandler");
            return;
        }
        ArrayList arrayList = new ArrayList(ePGShortInfoExtArray.length);
        for (int i2 = 0; i2 < ePGShortInfoExtArray.length; ++i2) {
            EPGShortInfoExt ePGShortInfoExt = ePGShortInfoExtArray[i2];
            if (ePGShortInfoExt == null || ePGShortInfoExt.getNowProgramInfo() == null || ePGShortInfoExt.getNextProgramInfo() == null) {
                this.logger.dabData.log(-1601830656, "[%1#setEpgList]Received invalid EPGShortInfo %2", (Object)"DABEpgHandler", (Object)ePGShortInfoExt);
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
        this.models.getButtonModel(478675200).setStatus(1);
        Object object3 = this.mutex;
        synchronized (object3) {
            this.updateHighlighting((BaseListModelApp)object);
            this.epgList.update((BaseListModelApp)object);
            this.epgList.setStatus(1);
            this.indexEpgList.update(baseListModelApp);
            this.models.getChoiceModel(1485373696).setValue(1);
        }
    }

    @Override
    public void setEPGDetailData(EPGFullInfo ePGFullInfo) {
        if (this.detailsRequested.getDabStation().ensemble.ensID != ePGFullInfo.getEnsID() || this.detailsRequested.getDabStation().ensemble.ensECC != ePGFullInfo.getEnsECC() || this.detailsRequested.getDabStation().service.sID != ePGFullInfo.getSID() || this.detailsRequested.getDabStation().component.sCIDI != ePGFullInfo.getSCIDI()) {
            this.logger.main.log(-1601830656, "[%1.setEPGDetailData] received data for not requested channel req: %2 rec:%3", (Object)"DABEpgHandler", (Object)this.detailsRequested.getDabStation(), ePGFullInfo.getSID());
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
                this.logger.main.log(-1601830656, "[%1.setEPGDetailData] received EPGFullProgramInfo == null", (Object)"DABEpgHandler");
            }
        }
    }

    @Override
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
        this.models.getChoiceModel(-1601634048).setValue(ePGListRow != null ? 1 : 0);
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
        this.models.getLabelModel(495452416).setText(ePGListRow.getStationName());
        this.models.getLabelModel(495452416).setStatus(this.nowOrNextRequested);
        this.models.getLabelModel(126484736).setText(this.detailDabStation.ensemble.fullName);
        this.models.getChoiceModel(277479680).setValue(this.detailDabStation.getPTY());
        boolean bl = this.favoriteHandler.isStored(new TunerObjectContainer(this.detailDabStation));
        this.models.getChoiceModel(-1534525184).setValue(bl ? 1 : 0);
        this.models.getResourceLocatorModel(193593600).setResourceLocator(ePGListRow.getDabStation().getStationLogo());
        this.models.getResourceLocatorModel(-192413440).setResourceLocator(ePGListRow.getDabStation().getStationLogo());
    }

    private void showDetails(EPGFullProgramInfo ePGFullProgramInfo) {
        EPGShortProgramInfo ePGShortProgramInfo = ePGFullProgramInfo.getShortInfo();
        if (ePGShortProgramInfo != null) {
            this.models.getLabelModel(545784064).setText(ePGShortProgramInfo.getProgramInfo());
            this.models.getLabelModel(529006848).setText(this.getTimeString(ePGShortProgramInfo));
            this.models.getLabelModel(-125304576).setText(this.getBeginTimeString(ePGShortProgramInfo));
            this.models.getLabelModel(-158859008).setText(this.getBeginDateString(ePGShortProgramInfo));
        } else {
            this.logger.main.log(-1601830656, "[%1.setEPGDetailData] received EPGShortProgramInfo == null", (Object)"DABEpgHandler");
        }
        String string = ePGFullProgramInfo.getDetailProgramInfo();
        this.models.getLabelModel(512229632).setText(string);
        this.models.getLabelModel(512229632).setStatus(Utilities.isEmpty(string) ? 0 : 1);
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
        BaseListModelApp baseListModelApp = this.models.getBaseListModel(-1266155264);
        baseListModelApp.removeAll();
        baseListModelApp.setSelectedIndex(-1);
        EPGFullProgramInfo ePGFullProgramInfo = this.epgDetailData.nowProgramInfo;
        DABEpgHandler$EpgDetailRow dABEpgHandler$EpgDetailRow = new DABEpgHandler$EpgDetailRow(this, this.detailId++, ePGFullProgramInfo, true);
        baseListModelApp.append(dABEpgHandler$EpgDetailRow);
        ePGFullProgramInfo = this.epgDetailData.nextProgramInfo;
        dABEpgHandler$EpgDetailRow = new DABEpgHandler$EpgDetailRow(this, this.detailId++, ePGFullProgramInfo, false);
        baseListModelApp.append(dABEpgHandler$EpgDetailRow);
        EPGFullProgramInfo[] ePGFullProgramInfoArray = this.epgDetailData.extendedProgramInfo.fullProgramInfoList;
        for (int i2 = 0; i2 < ePGFullProgramInfoArray.length; ++i2) {
            dABEpgHandler$EpgDetailRow = new DABEpgHandler$EpgDetailRow(this, this.detailId++, ePGFullProgramInfoArray[i2], false);
            baseListModelApp.append(dABEpgHandler$EpgDetailRow);
        }
        if (this.epgDetailData != null && this.currentDabStation.ensemble.ensID == this.epgDetailData.ensID && this.currentDabStation.ensemble.ensECC == this.epgDetailData.ensECC && this.currentDabStation.service.sID == this.epgDetailData.sID && this.currentDabStation.component.sCIDI == this.epgDetailData.sCIDI) {
            baseListModelApp.setSelectedIndex(0);
        }
    }

    private void resetDetailView(EPGShortProgramInfo ePGShortProgramInfo) {
        if (ePGShortProgramInfo != null) {
            this.models.getLabelModel(545784064).setText(ePGShortProgramInfo.getProgramInfo());
            this.models.getLabelModel(529006848).setText(this.getTimeString(ePGShortProgramInfo));
            this.models.getLabelModel(512229632).setText("");
        } else {
            this.models.getLabelModel(545784064).setText("");
            this.models.getLabelModel(529006848).setText("");
            this.models.getLabelModel(512229632).setText("");
        }
        this.models.getLabelModel(512229632).setStatus(1);
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
            if (this.models.getBaseListModel(-1266155264).getLength() > 0) {
                this.models.getBaseListModel(-1266155264).setSelectedIndex(n);
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
            this.models.getButtonModel(-142081792).setStatus(3);
            this.models.getChoiceModel(-527892224).setValue(1);
        } else {
            this.models.getButtonModel(-142081792).setStatus(1);
            this.models.getChoiceModel(-527892224).setValue(0);
        }
        if (n == this.models.getBaseListModel(-1266155264).getLength() - 1) {
            this.models.getButtonModel(-108527360).setStatus(3);
        } else {
            this.models.getButtonModel(-108527360).setStatus(1);
        }
    }

    static /* synthetic */ void access$800(DABEpgHandler dABEpgHandler, UnifiedStationExt unifiedStationExt) {
        dABEpgHandler.setCurrentStation(unifiedStationExt);
    }

    static /* synthetic */ void access$900(DABEpgHandler dABEpgHandler, DabStation dabStation) {
        dABEpgHandler.setCurrentStation(dabStation);
    }

    static /* synthetic */ BaseListModelApp access$1000(DABEpgHandler dABEpgHandler) {
        return dABEpgHandler.epgList;
    }

    static /* synthetic */ TunerModels access$1100(DABEpgHandler dABEpgHandler) {
        return dABEpgHandler.models;
    }

    static /* synthetic */ void access$1200(DABEpgHandler dABEpgHandler, EPGListRow ePGListRow) {
        dABEpgHandler.updateEPGDetailDataFor(ePGListRow);
    }

    static /* synthetic */ void access$1300(DABEpgHandler dABEpgHandler, int n) {
        dABEpgHandler.setDetailIndex(n);
    }

    static /* synthetic */ void access$1400(DABEpgHandler dABEpgHandler, EPGFullProgramInfo ePGFullProgramInfo) {
        dABEpgHandler.showDetails(ePGFullProgramInfo);
    }

    static /* synthetic */ ITunerVariantExt access$1500(DABEpgHandler dABEpgHandler) {
        return dABEpgHandler.varExt;
    }

    static /* synthetic */ DabStation access$1602(DABEpgHandler dABEpgHandler, DabStation dabStation) {
        dABEpgHandler.detailDabStation = dabStation;
        return dABEpgHandler.detailDabStation;
    }

    static /* synthetic */ IDABTuner access$1700(DABEpgHandler dABEpgHandler) {
        return dABEpgHandler.dabTuner;
    }

    static /* synthetic */ void access$1800(DABEpgHandler dABEpgHandler, EPGShortProgramInfo ePGShortProgramInfo) {
        dABEpgHandler.resetDetailView(ePGShortProgramInfo);
    }

    static /* synthetic */ EPGListRow access$1902(DABEpgHandler dABEpgHandler, EPGListRow ePGListRow) {
        dABEpgHandler.detailsRequested = ePGListRow;
        return dABEpgHandler.detailsRequested;
    }

    static /* synthetic */ ClockTimeZoneOffsetHandler access$2000(DABEpgHandler dABEpgHandler) {
        return dABEpgHandler.timeZoneOffset;
    }

    static /* synthetic */ int access$2100(DABEpgHandler dABEpgHandler) {
        return dABEpgHandler.detailIndex;
    }

    static /* synthetic */ DabStation access$1600(DABEpgHandler dABEpgHandler) {
        return dABEpgHandler.detailDabStation;
    }

    static /* synthetic */ IStoreStationHandler access$2200(DABEpgHandler dABEpgHandler) {
        return dABEpgHandler.favoriteHandler;
    }
}

