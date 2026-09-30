/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.navi.ISDSNaviInputStartingCommand;
import de.audi.app.sdsmanager.apps.navi.ISDSNaviPOIValueSettingCommand;
import de.audi.app.sdsmanager.apps.navi.NaviSDSHandler;
import de.audi.app.sdsmanager.apps.navi.NaviSDSUtils;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.IPicklistSlot;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.log.LogChannel;

public class NaviPOIValueSetCommand
extends AbstractSystemCallCommand
implements ISDSNaviInputStartingCommand,
ISDSNaviPOIValueSettingCommand {
    private static final int POI_VALUE_SOURCE_NBEST = 0;
    private static final int POI_VALUE_SOURCE_PICKLIST = 1;
    private static final int POI_VALUE_SOURCE_TOP_POI_LIST = 2;
    private static final int POI_VALUE_SOURCE_RESULT_LIST = 3;
    private static final int POI_VALUE_SOURCE_SUI_PICKLIST = 4;
    private static final int POI_VALUE_SOURCE_ONESHOT = 5;
    protected final NaviService naviService;
    private final NBestStorageAccess nBestStorage;
    private final NaviSDSHandler sdsHandler;
    private final int poiValueSource;

    public NaviPOIValueSetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, NaviService naviService, NBestStorageAccess nBestStorageAccess, NaviSDSHandler naviSDSHandler) {
        super(logChannel, string, sDSHandlerService);
        this.naviService = naviService;
        this.nBestStorage = nBestStorageAccess;
        this.sdsHandler = naviSDSHandler;
        this.poiValueSource = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute: poiValueSource=%2!", (Object)this.getName(), (long)this.poiValueSource);
        if (this.poiValueSource == 3) {
            this.handlePoiSelection();
            return;
        }
        NaviSDSUtils.resetVDEData(11, this.sdsHandler);
        NaviSDSUtils.setInputStartedMode((byte)11, this.sdsHandler, this.logger);
        this.naviService.startDestinationInput(10);
    }

    public void responseStartDestinationInput(byte by) {
        this.logger.log(10000000, "%1#responseStartDestinationInput: result=%2", (Object)this.getName(), (long)by);
        if (by != 0) {
            this.sendResult(NaviSDSUtils.getGenericSDSResult(by));
            return;
        }
        this.handlePoiSelection();
    }

    private void handlePoiSelection() {
        int n = this.nBestStorage.getLastRecogLine();
        int n2 = this.sdsHandlerService.resetSelectedRow();
        this.logger.log(10000000, "%1#handlePoiSelection: pickListIndex=%2, hapticalListIndex=%3!", (Object)this.getName(), (long)n, (long)n2);
        int n3 = this.poiValueSource == 2 ? n2 : (n == -1 ? n2 : n);
        byte by = this.getContext(n3);
        if (by == -1) {
            return;
        }
        this.logger.log(10000000, "%1#handlePoiSelection: index=%2, context=%3!", (Object)this.getName(), (long)n3, (long)by);
        SDSListEntry sDSListEntry = this.getPOIEntryDetails(n3, by);
        if (sDSListEntry == null) {
            this.logger.log(10000000, "%1#handlePoiSelection: Empty poiEntry, sending ERROR!", (Object)this.getName());
            this.sendResult(3001);
            return;
        }
        int n4 = (int)sDSListEntry.getId();
        this.logger.log(10000000, "%1#handlePoiSelection: poiEntry=%2, poiEntryID=%3, calling selectPOI!", (Object)this.getName(), (Object)sDSListEntry, (long)n4);
        this.naviService.selectPOI(n4);
    }

    private SDSListEntry getPOIEntryDetails(int n, byte by) {
        NaviService.POISDSListEntry pOISDSListEntry = this.naviService.getPOIEntryDetails(n, by);
        String string = pOISDSListEntry == null ? "" : pOISDSListEntry.getName();
        this.logger.log(10000000, "%1#getPOIEntryDetails: poiName=%2!", (Object)this.getName(), (Object)string);
        SDSModelAccess.setListLineDataGetModel(string);
        return pOISDSListEntry;
    }

    private byte getContext(int n) {
        this.logger.log(10000000, "%1#getContext: index=%2", (Object)this.getName(), (long)n);
        switch (this.poiValueSource) {
            case 0: {
                this.handleNBestList();
                return -1;
            }
            case 5: {
                this.handleOneshot();
                return -1;
            }
            case 2: {
                return 0;
            }
            case 1: {
                return 1;
            }
            case 3: {
                this.handleResultList(n);
                return -1;
            }
            case 4: {
                return 3;
            }
        }
        this.logger.log(100000, "%1#execute: Unhandled poiValueSource %2, sending ERROR!", (Object)this.getName(), (long)this.poiValueSource);
        this.sendResult(3001);
        return -1;
    }

    private void handleNBestList() {
        IPicklistSlot iPicklistSlot = this.nBestStorage.getMatchingPicklist((byte)0).getSlot(0, 0);
        int n = iPicklistSlot != null ? (int)iPicklistSlot.getObjID() : -1;
        this.logger.log(10000000, "%1#handleNBestList: poiID=%2, calling selectPOI!", (Object)this.getName(), (long)n);
        this.naviService.selectPOI(n);
    }

    private void handleOneshot() {
        this.logger.log(10000000, "%1#handleOneshot valled!", (Object)this.getName());
        NaviService.OneshotData oneshotData = this.sdsHandler.getOneshotData((byte)0);
        int n = oneshotData != null ? (int)oneshotData.getObjId() : -1;
        String string = oneshotData != null ? oneshotData.getText() : "";
        SDSModelAccess.setOneshotPoiLabel(string);
        this.logger.log(10000000, "%1#handleOneshot: poi=%2, poiID=%3, calling selectPOI!", (Object)this.getName(), (Object)string, (long)n);
        this.naviService.selectPOI(n);
    }

    private void handleResultList(int n) {
        this.logger.log(10000000, "%1#handleResultList: lastRecogLine=%2", (Object)this.getName(), (long)n);
        BaseListModelApp baseListModelApp = SDSModelAccess.getSDSNaviPOIResultList();
        int n2 = baseListModelApp.getLength();
        int n3 = n2 == 1 ? 0 : n;
        this.logger.log(10000000, "%1#handleResultList: popupListLen=%2, poiIndex=%3!", (Object)this.getName(), (long)n2, (long)n3);
        EvoListRow evoListRow = baseListModelApp.getRow(n3);
        int n4 = (int)evoListRow.getUniqueID();
        SDSListEntry sDSListEntry = this.getPOIEntryDetails(n4, (byte)2);
        if (sDSListEntry == null) {
            this.logger.log(10000000, "%1#handleResultList: Empty poiEntry, sending ERROR!", (Object)this.getName());
            this.sendResult(3001);
            return;
        }
        this.sdsHandler.setSDSAddressInputMode((byte)1);
        this.naviService.selectPOIbyListIndex(n4);
    }

    public void responseSelectPOIByUID(byte by, NaviService.POISDSListEntry[] pOISDSListEntryArray) {
        this.logger.log(10000000, "%1#responseSelectPOIByUID: result=%3, entries=%2", (Object)this.getName(), (Object)SDSUtils.toString((Object[])pOISDSListEntryArray, false), (long)by);
        this.responseSelectPOIByListIndex(by);
    }

    public void responseSelectPOIByListIndex(byte by) {
        this.logger.log(10000000, "%1#responseSelectPOIByListIndex: result=%2", (Object)this.getName(), (long)by);
        int n = NaviSDSUtils.getGenericSDSResult(by);
        this.logger.log(10000000, "%1#responseSelectPOI: sdsRes=%2!", (Object)this.getName(), (long)n);
        this.naviService.showPoiDetailsPopup();
        this.doPostResultAction();
        this.sendResult(n);
    }

    protected void doPostResultAction() {
    }
}

