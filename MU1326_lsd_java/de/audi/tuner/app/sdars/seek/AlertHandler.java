/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.TunerProxyManager;
import de.audi.tuner.app.sdars.PdtInfoHandler;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.seek.AlertHandler$AlertListModelListener;
import de.audi.tuner.app.sdars.seek.AlertHandler$DsiUpListener;
import de.audi.tuner.app.sdars.seek.AlertHandler$PdtListener;
import de.audi.tuner.app.sdars.seek.AlertHandler$PrevNextListener;
import de.audi.tuner.app.sdars.seek.AlertHandler$UpdateListener;
import de.audi.tuner.app.sdars.seek.AlertRow;
import de.audi.tuner.app.sdars.seek.IAlertListBuilder;
import de.audi.tuner.app.sdars.seek.IEnrichedSeekAlertListener;
import de.audi.tuner.ifc.IPrevNext;
import de.audi.tuner.ifc.IScanHandler;
import de.audi.tuner.ifc.ITunerVariantExt;
import de.audi.tuner.ifc.listener.IPdtListener;
import de.audi.tuner.ifc.listener.IUpdateListener;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.dsi.ifc.sdars.RadioText;
import org.dsi.ifc.sdars.SeekAlert;
import org.dsi.ifc.sdars.SeekEntry;

public class AlertHandler {
    public final IUpdateListener updateListener = new AlertHandler$UpdateListener(this, null);
    static final SeekEntry DUMMY_SEEKENTRY = new SeekEntry();
    public final AlertHandler$DsiUpListener dsiUpListener = new AlertHandler$DsiUpListener(this);
    public final IPrevNext prexNextListener = new AlertHandler$PrevNextListener(this, null);
    private final LogChannel lc;
    private final TunerModels models;
    private final ITunerVariantExt varExt;
    private final IAlertListBuilder alertListBuilder;
    private final BaseListModelApp activeAlertList;
    private final ChoiceModelApp listSelectionChoice;
    private final Object mutex = new Object();
    private final PdtInfoHandler pdtInfoHandler;
    private final IScanHandler scanHandler;
    final IPdtListener pdtListener;
    private SeekEntry[] currentSeekList = new SeekEntry[0];
    private final SimpleIntObjectMap stationIdToActiveSeekAlert = new SimpleIntObjectMap(50);
    private StationInfoExt[] currentStationList = new StationInfoExt[0];
    private StationInfoExt selectedStation = new StationInfoExt();
    private boolean noSignalActive = false;
    private final Collection enrichedSeekAlertListeners = new ArrayList(3);

    public AlertHandler(TunerBasics tunerBasics, PdtInfoHandler pdtInfoHandler, ITunerVariantExt iTunerVariantExt, IScanHandler iScanHandler) {
        this.lc = tunerBasics.getLogger().sdarsSeekDSI;
        this.varExt = iTunerVariantExt;
        this.alertListBuilder = this.varExt.getSdarsAlertListBuilder();
        this.models = tunerBasics.getModels();
        this.activeAlertList = this.models.getBaseListModel(747176192);
        this.listSelectionChoice = this.models.getChoiceModel(-1182203648);
        this.scanHandler = iScanHandler;
        this.pdtInfoHandler = pdtInfoHandler;
        this.pdtListener = new AlertHandler$PdtListener(this, null);
        this.activeAlertList.setListener(new AlertHandler$AlertListModelListener(this, null));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addEnrichedSeekAlertListener(IEnrichedSeekAlertListener iEnrichedSeekAlertListener) {
        Collection collection = this.enrichedSeekAlertListeners;
        synchronized (collection) {
            this.enrichedSeekAlertListeners.add(iEnrichedSeekAlertListener);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void onDSIUpdateSeekList(SeekEntry[] seekEntryArray) {
        Object object = this.mutex;
        synchronized (object) {
            this.currentSeekList = seekEntryArray;
        }
    }

    private void onDSIUpdateSeekAlert(SeekAlert seekAlert) {
        switch (seekAlert.alertType) {
            case 1: {
                this.handleDSIUpdateSeekAlertStart(seekAlert);
                break;
            }
            case 2: {
                this.handleDSIUpdateSeekAlertEnd(seekAlert);
                break;
            }
            default: {
                this.lc.log(-1601830656, "[AlertHandler.onDSIUpdateSeekAlert] called with illegal alertType %1", (long)seekAlert.alertType);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void handleDSIUpdateSeekAlertStart(SeekAlert seekAlert) {
        SeekEntry seekEntry;
        this.lc.log(-2137614336, "[AlertHandler.handleDSIUpdateSeekAlertStart] seekId: %1, stationId: %2", (long)seekAlert.seekID, (long)seekAlert.sID);
        Object object = this.mutex;
        synchronized (object) {
            seekEntry = AlertHandler.findSeekEntryForSeekId(seekAlert.seekID, this.currentSeekList, this.lc);
            this.stationIdToActiveSeekAlert.add(seekAlert.sID, seekAlert);
            this.pdtInfoHandler.addListener(seekAlert.sID, this.pdtListener, 0);
        }
        object = new SeekEntry(seekEntry.seekID, seekEntry.contentLink, seekEntry.typeOfContent, seekEntry.title1, seekEntry.title2, seekEntry.seekActive);
        this.sendEnrichedSeekAlertListenersAlertStarted(seekAlert.seekID, seekAlert.sID, (SeekEntry)object);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void handleDSIUpdateSeekAlertEnd(SeekAlert seekAlert) {
        this.lc.log(-2137614336, "[AlertHandler.handleDSIUpdateSeekAlertEnd] seekId: %1, stationId: %2", (long)seekAlert.seekID, (long)seekAlert.sID);
        Object object = this.mutex;
        synchronized (object) {
            this.stationIdToActiveSeekAlert.remove(seekAlert.sID);
            this.pdtInfoHandler.removeListener(seekAlert.sID, this.pdtListener);
            SeekEntry seekEntry = AlertHandler.findSeekEntryForSeekId(seekAlert.seekID, this.currentSeekList, this.lc);
            if (seekEntry == DUMMY_SEEKENTRY) {
                this.lc.log(-1601830656, "[AlertHandler.onNewRadioTextReceived] no SeekEntry for stationId %1. ABORTING!", (long)seekAlert.sID);
            }
            this.alertListBuilder.alertEnded(this.activeAlertList, seekAlert, seekEntry);
            if (seekAlert.sID == this.selectedStation.sID) {
                this.listSelectionChoice.setValue(0);
            }
        }
        this.sendEnrichedSeekAlertListenersAlertStopped(seekAlert.seekID, seekAlert.sID);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setNoSignal(boolean bl) {
        this.noSignalActive = bl;
        Object object = this.mutex;
        synchronized (object) {
            BaseListModelApp baseListModelApp = this.activeAlertList.getCopy();
            int n = this.activeAlertList.getLength();
            for (int i2 = 0; i2 < n; ++i2) {
                EvoListRow evoListRow = baseListModelApp.getRow(i2);
                if (!(evoListRow instanceof AlertRow)) continue;
                AlertRow alertRow = (AlertRow)evoListRow;
                alertRow.setNoSignal(bl);
                baseListModelApp.setRow(i2, alertRow);
            }
            SelectedItem selectedItem = this.activeAlertList.getSelected();
            baseListModelApp.setSelectedUniqueID(selectedItem != null ? selectedItem.getUniqueID() : 0L);
            this.activeAlertList.update(baseListModelApp);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void onNewRadioTextReceived(int n, RadioText radioText) {
        if (this.lc.isDebug()) {
            this.lc.log(-2137614336, "[AlertHandler.onNewRadioTextReceived] stationId: %2, radio text: %1", (Object)radioText, (long)n);
        }
        Object object = this.mutex;
        synchronized (object) {
            int n2;
            String string;
            SeekAlert seekAlert = (SeekAlert)this.stationIdToActiveSeekAlert.get(n);
            if (seekAlert == null) {
                this.lc.log(10000, "[AlertHandler.onNewRadioTextReceived] no SeekAlert for stationId %1. ABORTING!", (long)n);
                return;
            }
            SeekEntry seekEntry = AlertHandler.findSeekEntryForSeekId(seekAlert.seekID, this.currentSeekList, this.lc);
            if (seekEntry == DUMMY_SEEKENTRY) {
                this.lc.log(10000, "[AlertHandler.onNewRadioTextReceived] no SeekEntry for stationId %1. ABORTING!", (long)n);
                return;
            }
            StationInfoExt stationInfoExt = AlertHandler.findStationInfoForStationid(n, this.currentStationList);
            if (stationInfoExt == null) {
                this.lc.log(10000, "[AlertHandler.onNewRadioTextReceived] no StationInfoExt for stationId %1. ABORTING!", (long)n);
                return;
            }
            String string2 = radioText != null ? radioText.longArtistName : seekEntry.title1;
            String string3 = string = radioText != null ? radioText.longProgramTitle : seekEntry.title2;
            if (this.activeAlertList.contains(n)) {
                n2 = this.activeAlertList.getIndexForUniqueID(n);
                AlertRow alertRow = (AlertRow)this.activeAlertList.getRow(n2);
                this.lc.log(-2137614336, "[AlertHandler.onNewRadioTextReceived] update row %1", (long)n2);
                alertRow.updateTexts(string2, string);
                alertRow.setNoSignal(this.noSignalActive);
                this.alertListBuilder.alertUpdated(this.activeAlertList, seekAlert, seekEntry, n2, alertRow);
            } else {
                AlertRow alertRow = this.varExt.getListRowFactory().getSdarsAlertRow(stationInfoExt, seekEntry, string2, string);
                alertRow.setNoSignal(this.noSignalActive);
                this.alertListBuilder.alertStarted(this.activeAlertList, seekAlert, seekEntry, alertRow);
            }
            if (this.selectedStation.sID == stationInfoExt.sID) {
                n2 = this.activeAlertList.setSelectedUniqueID(stationInfoExt.sID) ? 1 : 0;
                this.listSelectionChoice.setValue(n2 != 0 ? 1 : 0);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void onDSIUpdateStationList(StationInfoExt[] stationInfoExtArray) {
        Object object = this.mutex;
        synchronized (object) {
            this.currentStationList = stationInfoExtArray;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void onDSIUpdateSelectedStation(StationInfoExt stationInfoExt) {
        Object object = this.mutex;
        synchronized (object) {
            this.selectedStation = stationInfoExt;
            int n = this.models.getActiveTuner() == 7 ? this.selectedStation.sID : 0;
            boolean bl = this.activeAlertList.setSelectedUniqueID(n);
            this.listSelectionChoice.setValue(bl ? 1 : 0);
            if (!bl) {
                this.activeAlertList.setSelectedIndex(-1);
            }
        }
    }

    private void onItemSelectedInAlertList(AlertRow alertRow, int n) {
        this.scanHandler.abortScan();
        TunerProxyManager.getInstance().prepareAndTune(alertRow.getTOContainer(), n);
        this.listSelectionChoice.setValue(1);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void onPrevNextPressed(boolean bl, int n) {
        AlertRow alertRow = null;
        Object object = this.mutex;
        synchronized (object) {
            if (this.activeAlertList.getLength() == 0) {
                return;
            }
            int n2 = -1;
            int n3 = this.activeAlertList.getLength() - 1;
            SelectedItem selectedItem = this.activeAlertList.getSelected();
            if (selectedItem == null) {
                n2 = bl ? 0 : n3;
            } else {
                long l = selectedItem.getUniqueID();
                n2 = this.activeAlertList.getIndexForUniqueID(l) + (bl ? 1 : -1);
                n2 = n2 > n3 ? 0 : n2;
                n2 = n2 < 0 ? n3 : n2;
            }
            alertRow = (AlertRow)this.activeAlertList.getRow(n2);
        }
        TunerProxyManager.getInstance().prepareAndTune(alertRow.getTOContainer(), n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void sendEnrichedSeekAlertListenersAlertStarted(int n, int n2, SeekEntry seekEntry) {
        Collection collection = this.enrichedSeekAlertListeners;
        synchronized (collection) {
            Iterator iterator = this.enrichedSeekAlertListeners.iterator();
            while (iterator.hasNext()) {
                ((IEnrichedSeekAlertListener)iterator.next()).alertStarted(n, n2, seekEntry);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void sendEnrichedSeekAlertListenersAlertStopped(int n, int n2) {
        Collection collection = this.enrichedSeekAlertListeners;
        synchronized (collection) {
            Iterator iterator = this.enrichedSeekAlertListeners.iterator();
            while (iterator.hasNext()) {
                ((IEnrichedSeekAlertListener)iterator.next()).alertStopped(n, n2);
            }
        }
    }

    private static SeekEntry findSeekEntryForSeekId(int n, SeekEntry[] seekEntryArray, LogChannel logChannel) {
        for (int i2 = 0; i2 < seekEntryArray.length; ++i2) {
            if (seekEntryArray[i2].seekID != n) continue;
            return seekEntryArray[i2];
        }
        logChannel.log(10000, "[AlertHandler.findSeekEntryForSeekId] No SeekEntry found for seekID %1", (long)n);
        return DUMMY_SEEKENTRY;
    }

    private static StationInfoExt findStationInfoForStationid(int n, StationInfoExt[] stationInfoExtArray) {
        for (int i2 = 0; i2 < stationInfoExtArray.length; ++i2) {
            if (stationInfoExtArray[i2].sID != n) continue;
            return stationInfoExtArray[i2];
        }
        return null;
    }

    static /* synthetic */ void access$400(AlertHandler alertHandler, SeekEntry[] seekEntryArray) {
        alertHandler.onDSIUpdateSeekList(seekEntryArray);
    }

    static /* synthetic */ void access$500(AlertHandler alertHandler, SeekAlert seekAlert) {
        alertHandler.onDSIUpdateSeekAlert(seekAlert);
    }

    static /* synthetic */ void access$600(AlertHandler alertHandler, StationInfoExt[] stationInfoExtArray) {
        alertHandler.onDSIUpdateStationList(stationInfoExtArray);
    }

    static /* synthetic */ void access$700(AlertHandler alertHandler, StationInfoExt stationInfoExt) {
        alertHandler.onDSIUpdateSelectedStation(stationInfoExt);
    }

    static /* synthetic */ void access$800(AlertHandler alertHandler, boolean bl) {
        alertHandler.setNoSignal(bl);
    }

    static /* synthetic */ void access$900(AlertHandler alertHandler, AlertRow alertRow, int n) {
        alertHandler.onItemSelectedInAlertList(alertRow, n);
    }

    static /* synthetic */ void access$1000(AlertHandler alertHandler, int n, RadioText radioText) {
        alertHandler.onNewRadioTextReceived(n, radioText);
    }

    static /* synthetic */ void access$1100(AlertHandler alertHandler, boolean bl, int n) {
        alertHandler.onPrevNextPressed(bl, n);
    }

    static /* synthetic */ StationInfoExt access$1200(AlertHandler alertHandler) {
        return alertHandler.selectedStation;
    }
}

