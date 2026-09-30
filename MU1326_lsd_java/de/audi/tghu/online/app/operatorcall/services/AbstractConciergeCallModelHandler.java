/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.services;

import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.tghu.online.app.operatorcall.abstractclasses.AbstractModelHandler;
import de.audi.tghu.online.app.operatorcall.abstractclasses.AbstractOperatorCall;
import de.audi.tghu.online.app.operatorcall.data.AbstractHistoryCallListRow;
import de.audi.tghu.online.app.operatorcall.data.AbstractOperatorCallDataContainer;
import de.audi.tghu.online.app.operatorcall.data.PoiResultListRow;
import de.esolutions.fw.util.commons.Buffer;

public abstract class AbstractConciergeCallModelHandler
extends AbstractModelHandler {
    public AbstractConciergeCallModelHandler(HMIService hMIService, AbstractOperatorCall abstractOperatorCall) {
        super(hMIService, abstractOperatorCall);
    }

    public void listItemSelected(EvoListRow evoListRow, int n, int n2) {
        switch (n) {
            case 2301241: {
                this.setModelName("CONCIERGE_CALL_RESULTS_TILED_LIST");
                AbstractHistoryCallListRow abstractHistoryCallListRow = this.getHistoryCallListRow(evoListRow);
                AbstractOperatorCallDataContainer abstractOperatorCallDataContainer = this.listener.getData();
                PoiResultListRow[] poiResultListRowArray = abstractOperatorCallDataContainer.getResultsForCall(n2);
                if (poiResultListRowArray.length == 1) {
                    this.logChannel.log(10000000, "AbstractConciergeCallModelHandler#itemSelected: Call has only one result! Starting route guidance");
                    this.getTiledListModel(2301247).removeAll();
                    PoiResultListRow poiResultListRow = poiResultListRowArray[0];
                    this.listener.poiSelected(poiResultListRow);
                    break;
                }
                this.showPoiResults(abstractHistoryCallListRow, poiResultListRowArray);
                break;
            }
            case 2301247: {
                this.setModelName("CONCIERGE_RESULTS_TILED_LIST");
                PoiResultListRow poiResultListRow = this.getPoiResultListRow(evoListRow);
                this.listener.poiSelected(poiResultListRow);
                break;
            }
            default: {
                return;
            }
        }
        this.fireTiledListEvent();
    }

    protected PoiResultListRow getPoiResultListRow(EvoListRow evoListRow) {
        return (PoiResultListRow)evoListRow;
    }

    protected void showPoiResults(AbstractHistoryCallListRow abstractHistoryCallListRow, PoiResultListRow[] poiResultListRowArray) {
        this.logChannel.log(1000000, "AbstractConciergeCallModelHandler#showPoiResults: called");
        TiledListModelApp tiledListModelApp = this.getTiledListModel(2301247);
        Buffer buffer = new Buffer(abstractHistoryCallListRow.getDateAsString());
        buffer.append(" ");
        buffer.append(abstractHistoryCallListRow.getTimeAsString());
        this.setLabelText(2301183, "OPERATOR_CALL_TITLE_DATE_LABEL", buffer.toString());
        tiledListModelApp.removeAll();
        this.logChannel.log(10000000, "AbstractConciergeCallModelHandler#showPoiResults: RESULTS_TILED_LIST: length = %1->%2", (long)tiledListModelApp.getLength(), (long)poiResultListRowArray.length);
        this.printPoiResults(poiResultListRowArray);
        tiledListModelApp.append(poiResultListRowArray);
        this.logChannel.log(1000000, "AbstractConciergeCallModelHandler#showPoiResults: ended");
    }

    protected void listItemFocused(EvoListRow evoListRow, int n, int n2) {
        switch (n) {
            case 2301241: {
                this.setModelName("CONCIERGE_CALL_RESULTS_TILED_LIST");
                AbstractHistoryCallListRow abstractHistoryCallListRow = this.getHistoryCallListRow(evoListRow);
                this.logChannel.log(1000000, "AbstractConciergeCallModelHandler#itemFocused: CONCIERGE_CALL_RESULTS_TILED_LIST => name = %1 selected, index = %2, col = %3", (Object)abstractHistoryCallListRow.getName(), (long)n2);
                this.logChannel.log(10000000, "AbstractConciergeCallModelHandler#itemFocused: Information:\n%1", (Object)abstractHistoryCallListRow);
                this.showPreviewMap(n2);
                this.listener.setLastCallFocused(n2);
                break;
            }
            case 2301247: {
                this.setModelName("CONCIERGE_RESULTS_TILED_LIST");
                PoiResultListRow poiResultListRow = this.getPoiResultListRow(evoListRow);
                this.logChannel.log(1000000, "AbstractConciergeCallModelHandler#itemFocused: CONCIERGE_RESULTS_TILED_LIST => name = %1 selected, index = %2, col = %3", (Object)poiResultListRow.getName(), (long)n2);
                this.logChannel.log(10000000, "AbstractConciergeCallModelHandler#itemFocused: Information:\n%1", (Object)poiResultListRow);
                this.showPreviewMap(poiResultListRow.getHistoryCallIndex(), n2);
                this.listener.setLastPoiFocused(n2);
                break;
            }
            default: {
                return;
            }
        }
    }

    protected AbstractHistoryCallListRow getHistoryCallListRow(EvoListRow evoListRow) {
        return (AbstractHistoryCallListRow)evoListRow;
    }

    public void setWelcomeScreen(boolean bl) {
    }

    protected void enableApplication(boolean bl) {
    }

    public void resetCallInformation() {
        this.setLabelText(2301127, "OPERATOR_CALL_DURATION_LABEL", "");
    }

    public void setCallActive(boolean bl) {
        if (!bl) {
            this.setChoiceValue(2301067, "OPERATOR_CALL_ACTIVE_CHOICE", 0);
            this.setChoiceStatus(2301067, "OPERATOR_CALL_ACTIVE_CHOICE", 0);
        } else {
            this.setChoiceStatus(2301067, "OPERATOR_CALL_ACTIVE_CHOICE", 1);
            this.setChoiceValue(2301067, "OPERATOR_CALL_ACTIVE_CHOICE", 1);
        }
    }

    public boolean isCallActive() {
        int n = this.getChoiceStatus(2301067);
        return n == 1;
    }

    protected void setDurationLabel(String string) {
        this.setLabelText(2301127, "OPERATOR_CALL_DURATION_LABEL", string);
    }

    protected String getCallDuration() {
        return this.getLabelText(2301127);
    }

    public void setChoiceDownloadActive(boolean bl) {
        if (bl) {
            this.setChoiceValue(2301102, "OPERATOR_RESULTS_FETCHING_MODE_CHOICE", 1);
        } else {
            this.logChannel.log(1000000, "AbstractConciergeCallModelHandler#setChoiceDownloadActive: leave screen Fetching Data ...");
            this.setChoiceValue(2301102, "OPERATOR_RESULTS_FETCHING_MODE_CHOICE", 0);
        }
    }

    public boolean isDownloadActive() {
        int n = this.getChoiceValue(2301102);
        return n == 1;
    }

    protected void newPoiResultsReceived(int n) {
        this.defaultNewPoiResultsReceived(n);
    }

    public void setOldSession(boolean bl) {
        int n = bl ? 1 : 0;
        this.setChoiceValue(2301070, "OPERATOR_OLD_RESULTS_AVAILABLE_CHOICE", n);
        this.toggleChoiceStatus(2301070, "OPERATOR_OLD_RESULTS_AVAILABLE_CHOICE");
    }

    protected int[] getButtonIdsToRegister() {
        return new int[]{2301240, 2301244, 2301246, 2301245, 2301243, 2301242, 2301259, 2301261, 2301265, 2301269, 2301271, 2301267};
    }

    protected int[] getTiledListIdsToRegister() {
        return new int[]{2301241, 2301247};
    }

    protected void buttonKeyPressed(int n) {
        this.logChannel.log(10000000, "AbstractConciergeCallModelHandler#keyPressed: current serviceType is %1", (long)this.listener.getCurrentServiceType());
        switch (n) {
            case 2301240: {
                this.logChannel.log(1000000, "AbstractConciergeCallModelHandler#keyPressed: CONCIERGE_START_BCALL_BUTTON => start concierge call");
                this.setModelName("CONCIERGE_START_BCALL_BUTTON");
                this.setJokerKeyBackBehaviour(false);
                this.fireButtonEvent();
                break;
            }
            case 2301244: {
                this.logChannel.log(1000000, "AbstractConciergeCallModelHandler#keyPressed: CONCIERGE_DOWNLOAD_OLD_RESULTS_BUTTON => download old results");
                this.setModelName("CONCIERGE_DOWNLOAD_OLD_RESULTS_BUTTON");
                this.startDownloadPoi();
                break;
            }
            case 2301246: {
                this.logChannel.log(1000000, "AbstractConciergeCallModelHandler#keyPressed: CONCIERGE_START_NEW_CALL_BUTTON => start a new call");
                this.setModelName("CONCIERGE_START_NEW_CALL_BUTTON");
                this.startNewCall();
                break;
            }
            case 2301245: {
                this.logChannel.log(1000000, "AbstractConciergeCallModelHandler#CONCIERGE_CALL_CONFIRM_BUTTON => ok button clicked in a final screen");
                this.setModelName("CONCIERGE_CALL_CONFIRM_BUTTON");
                this.confirmButtonPressed();
                this.fireButtonEvent();
                break;
            }
            case 2301243: {
                this.logChannel.log(1000000, "AbstractConciergeCallModelHandler#keyPressed: CONCIERGE_END_CALL_BUTTON pressed!");
                this.setModelName("CONCIERGE_END_CALL_BUTTON");
                this.hangup();
                break;
            }
            case 2301242: {
                this.logChannel.log(1000000, "AbstractConciergeCallModelHandler#keyPressed: CONCIERGE_ABORT_CONNECTING_BUTTON pressed!");
                this.setModelName("CONCIERGE_ABORT_CONNECTING_BUTTON");
                this.abortConnection();
                break;
            }
            case 2301259: {
                this.logChannel.log(1000000, "AbstractConciergeCallModelHandler#keyPressed: CONCIERGE_DELETE_HISTORYCALL_BUTTON pressed!");
                this.setModelName("CONCIERGE_DELETE_HISTORYCALL_BUTTON");
                this.listener.deleteThisHistory();
                break;
            }
            case 2301261: {
                this.logChannel.log(1000000, "AbstractConciergeCallModelHandler#keyPressed: CONCIERGE_DELETE_ALL_HISTORYCALLS_BUTTON pressed!");
                this.setModelName("CONCIERGE_DELETE_ALL_HISTORYCALLS_BUTTON");
                this.listener.deleteAllCalls(true);
                break;
            }
            case 2301265: {
                this.logChannel.log(1000000, "AbstractConciergeCallModelHandler#keyPressed: CONCIERGE_SAVE_AS_FAVORITE_BUTTON pressed!");
                this.setModelName("CONCIERGE_SAVE_AS_FAVORITE_BUTTON");
                this.listener.addToFavorite();
                break;
            }
            case 2301269: {
                this.logChannel.log(1000000, "AbstractConciergeCallModelHandler#keyPressed: CONCIERGE_ADD_TO_CONTACT_BUTTON pressed!");
                this.setModelName("CONCIERGE_ADD_TO_CONTACT_BUTTON");
                this.listener.addToContact();
                break;
            }
            case 2301271: {
                this.logChannel.log(1000000, "AbstractConciergeCallModelHandler#keyPressed: CONCIERGE_SHOW_DESTINATION_DETAILS_BUTTON pressed!");
                this.setModelName("CONCIERGE_SHOW_DESTINATION_DETAILS_BUTTON");
                this.listener.showDetails();
                break;
            }
            case 2301267: {
                this.logChannel.log(1000000, "AbstractConciergeCallModelHandler#keyPressed: CONCIERGE_SHOW_IN_MAP_BUTTON pressed!");
                this.setModelName("CONCIERGE_SHOW_IN_MAP_BUTTON");
                this.listener.showInMap();
                break;
            }
            default: {
                this.logChannel.log(100000, "AbstractConciergeCallModelHandler#keyPressed: unknown button (%1) pressed", (long)n);
            }
        }
    }

    public void setConfirmCCPScreen(boolean bl) {
        if (bl) {
            this.setButtonStatus(2301179, "OPERATOR_CALL_TRANSMIT_POSITION_BUTTON", 1);
        } else {
            this.setButtonStatus(2301179, "OPERATOR_CALL_TRANSMIT_POSITION_BUTTON", 0);
        }
    }

    public boolean isConfirmCCPScreenShown() {
        int n = this.getButtonStatus(2301179);
        return n != 1;
    }

    public void enableFeatures(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        if (bl && bl2 && bl3 && !bl4) {
            this.setChoiceValue(2301742, "CONCIERGE_CALL_CENTER_AVAILABLE_CHOICE", 1);
        } else {
            this.setChoiceValue(2301742, "CONCIERGE_CALL_CENTER_AVAILABLE_CHOICE", 0);
        }
    }

    protected boolean isFeatureEnabled() {
        return this.getChoiceValue(2301759) == 0;
    }

    protected boolean isApplicationEnabled() {
        return true;
    }

    public void deleteCachedPois() {
    }

    public void clearAllLists() {
        this.getTiledListModel(this.getCallListModelId()).removeAll();
        this.getTiledListModel(this.getResultListModelId()).removeAll();
        this.setFirstUniqueIdInCallList(-1L);
    }

    public void showPopup(int n) {
    }

    protected void optionKeyPressed(int n, int n2, int n3) {
    }

    protected void menuModelItemFocused(int n, long l, int n2) {
        if (n == 2301189 && l == -1L) {
            this.showCcpPreviewMap();
            this.listener.setLastCallFocused(-1);
        }
    }

    protected int[] getMenuModelIdsToRegister() {
        return new int[]{2301189};
    }

    protected int getCallListModelId() {
        return 2301241;
    }

    protected String getCallListModelName() {
        return "CONCIERGE_CALL_RESULTS_TILED_LIST";
    }

    protected int getResultListModelId() {
        return 2301247;
    }

    protected String getResultListModelName() {
        return "CONCIERGE_RESULTS_TILED_LIST";
    }

    public void requestItems(int n, int n2, int n3, int n4, int n5) {
        if (n4 == this.getCallListModelId()) {
            EvoListRow[] evoListRowArray = this.listener.getData().getAllHistoryCallGUIListsInIntervall(n, n2);
            this.getTiledListModel(n4).setRows(n3, n, evoListRowArray);
        }
    }

    public void unrequestItems(int n, int n2, int n3, int n4) {
        if (n3 == this.getCallListModelId()) {
            this.getTiledListModel(n3).clearRows(n, n2);
        }
    }

    protected int getDownloadResultChoiceId() {
        return 2301079;
    }

    protected String getDownloadResultChoiceName() {
        return "OPERATOR_DOWNLOAD_RESULT_CHOICE";
    }

    public void triggerAbortConnection() {
        this.toggleChoiceValue(2301402, "OPERATOR_ABORT_CONNECTION_CHOICE");
    }

    protected void setCcpPermission(int n) {
    }

    protected int[] getChoiceIdsToRegister() {
        return new int[0];
    }

    protected void choiceModelItemSelected(int n, int n2, int n3) {
    }

    protected boolean isTransmissionOfCcpPermitted() {
        int n = this.listener.getCurrentPermissionToTransmitCcp();
        if (n == 1) {
            return true;
        }
        if (n == 0) {
            return false;
        }
        this.logChannel.log(10000, "AbstractConciergeCallModelHandler#isTransmissionOfCcpPermitted: undefined permission(%1). This should never happen! Returning false.", (long)n);
        return false;
    }
}

