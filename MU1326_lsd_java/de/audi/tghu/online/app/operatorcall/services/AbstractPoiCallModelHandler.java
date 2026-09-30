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

public abstract class AbstractPoiCallModelHandler
extends AbstractModelHandler {
    public AbstractPoiCallModelHandler(HMIService hMIService, AbstractOperatorCall abstractOperatorCall) {
        super(hMIService, abstractOperatorCall);
    }

    public void listItemSelected(EvoListRow evoListRow, int n, int n2) {
        switch (n) {
            case 2301175: {
                this.setModelName("OPERATOR_CALL_RESULTS_TILED_LIST");
                AbstractHistoryCallListRow abstractHistoryCallListRow = this.getHistoryCallListRow(evoListRow);
                AbstractOperatorCallDataContainer abstractOperatorCallDataContainer = this.listener.getData();
                PoiResultListRow[] poiResultListRowArray = abstractOperatorCallDataContainer.getResultsForCall(n2);
                if (poiResultListRowArray.length == 1) {
                    this.logChannel.log(10000000, "AbstractPoiCallModelHandler#itemSelected: Call has only one result! Starting route guidance");
                    this.getTiledListModel(2301174).removeAll();
                    PoiResultListRow poiResultListRow = poiResultListRowArray[0];
                    this.listener.poiSelected(poiResultListRow);
                    break;
                }
                this.showPoiResults(abstractHistoryCallListRow, poiResultListRowArray);
                break;
            }
            case 2301174: {
                this.setModelName("OPERATOR_RESULTS_TILED_LIST");
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
        this.logChannel.log(1000000, "AbstractPoiCallModelHandler#showPoiResults: called");
        TiledListModelApp tiledListModelApp = this.getTiledListModel(2301174);
        Buffer buffer = new Buffer(abstractHistoryCallListRow.getDateAsString());
        buffer.append(" ");
        buffer.append(abstractHistoryCallListRow.getTimeAsString());
        this.setLabelText(2301183, "OPERATOR_CALL_TITLE_DATE_LABEL", buffer.toString());
        tiledListModelApp.removeAll();
        this.logChannel.log(10000000, "AbstractPoiCallModelHandler#showPoiResults: RESULTS_TILED_LIST: length = %1->%2", (long)tiledListModelApp.getLength(), (long)poiResultListRowArray.length);
        this.printPoiResults(poiResultListRowArray);
        tiledListModelApp.append(poiResultListRowArray);
        this.logChannel.log(1000000, "AbstractPoiCallModelHandler#showPoiResults: ended");
    }

    protected void listItemFocused(EvoListRow evoListRow, int n, int n2) {
        switch (n) {
            case 2301175: {
                this.setModelName("OPERATOR_CALL_RESULTS_TILED_LIST");
                AbstractHistoryCallListRow abstractHistoryCallListRow = this.getHistoryCallListRow(evoListRow);
                this.logChannel.log(1000000, "AbstractPoiCallModelHandler#itemFocused: OPERATOR_CALL_RESULTS_TILED_LIST => name = %1 selected, index = %2", (Object)abstractHistoryCallListRow.getName(), (long)n2);
                this.logChannel.log(10000000, "AbstractPoiCallModelHandler#itemFocused: Information:\n%1", (Object)abstractHistoryCallListRow);
                this.showPreviewMap(n2);
                this.listener.setLastCallFocused(n2);
                break;
            }
            case 2301174: {
                this.setModelName("OPERATOR_RESULTS_TILED_LIST");
                PoiResultListRow poiResultListRow = this.getPoiResultListRow(evoListRow);
                this.logChannel.log(1000000, "AbstractPoiCallModelHandler#itemFocused: OPERATOR_RESULTS_TILED_LIST => name = %1 selected, index = %2", (Object)poiResultListRow.getName(), (long)n2);
                this.logChannel.log(10000000, "AbstractPoiCallModelHandler#itemFocused: Information:\n%1", (Object)evoListRow);
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
            this.logChannel.log(1000000, "AbstractPoiCallModelHandler#setChoiceDownloadActive: leave screen Fetching Data ...");
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
        if (bl) {
            this.setChoiceValue(2301070, "OPERATOR_OLD_RESULTS_AVAILABLE_CHOICE", 1);
        } else {
            this.setChoiceValue(2301070, "OPERATOR_OLD_RESULTS_AVAILABLE_CHOICE", 0);
        }
        this.toggleChoiceStatus(2301070, "OPERATOR_OLD_RESULTS_AVAILABLE_CHOICE");
    }

    protected int[] getButtonIdsToRegister() {
        return new int[]{2301123, 2301072, 2301073, 2301179, 2301180, 2301172, 2301081, 2301080, 2301260, 2301258, 2301264, 2301266, 2301268, 2301270};
    }

    protected int[] getTiledListIdsToRegister() {
        return new int[]{2301175, 2301174};
    }

    protected void buttonKeyPressed(int n) {
        switch (n) {
            case 2301123: {
                this.logChannel.log(1000000, "AbstractPoiCallModelHandler#keyPressed: OPERATOR_START_BCALL_BUTTON => start operator call");
                this.setModelName("OPERATOR_START_BCALL_BUTTON");
                this.setJokerKeyBackBehaviour(false);
                this.fireButtonEvent();
                break;
            }
            case 2301072: {
                this.logChannel.log(1000000, "AbstractPoiCallModelHandler#keyPressed:OPERATOR_DOWNLOAD_OLD_RESULTS_BUTTON => download old results");
                this.setModelName("OPERATOR_DOWNLOAD_OLD_RESULTS_BUTTON");
                this.startDownloadPoi();
                break;
            }
            case 2301073: {
                this.logChannel.log(1000000, "AbstractPoiCallModelHandler#keyPressed:OPERATOR_START_NEW_CALL_BUTTON => start a new call");
                this.setModelName("OPERATOR_START_NEW_CALL_BUTTON");
                this.startNewCall();
                break;
            }
            case 2301179: {
                this.logChannel.log(1000000, "AbstractPoiCallModelHandler#OPERATOR_CALL_TRANSMIT_POSITION_BUTTON => transmit car position");
                this.logChannel.log(10000, "AbstractPoiCallModelHandler#keyPressed:OPERATOR_CALL_TRANSMIT_POSITION_BUTTON => should never be called any more");
                this.setModelName("OPERATOR_CALL_TRANSMIT_POSITION_BUTTON");
                this.listener.setTransmissionOfCcp(1);
                this.fireButtonEvent();
                this.startCallPressed();
                break;
            }
            case 2301180: {
                this.logChannel.log(1000000, "AbstractPoiCallModelHandler#keyPressed:OPERATOR_CALL_NO_TRANSMIT_POSITION_BUTTON => don't transmit car position");
                this.logChannel.log(10000, "AbstractPoiCallModelHandler#keyPressed:OPERATOR_CALL_NO_TRANSMIT_POSITION_BUTTON => should never be called any more!");
                this.setModelName("OPERATOR_CALL_NO_TRANSMIT_POSITION_BUTTON");
                this.listener.setTransmissionOfCcp(0);
                this.fireButtonEvent();
                this.startCallPressed();
                break;
            }
            case 2301172: {
                this.logChannel.log(1000000, "AbstractPoiCallModelHandler#OPERATOR_CALL_CONFIRM_BUTTON => ok button clicked in a final screen");
                this.setModelName("OPERATOR_CALL_CONFIRM_BUTTON");
                this.confirmButtonPressed();
                this.fireButtonEvent();
                break;
            }
            case 2301081: {
                this.logChannel.log(1000000, "AbstractPoiCallModelHandler#keyPressed: OPERATOR_END_CALL_BUTTON pressed!");
                this.setModelName("OPERATOR_END_CALL_BUTTON");
                this.hangup();
                break;
            }
            case 2301080: {
                this.logChannel.log(1000000, "AbstractPoiCallModelHandler#keyPressed: OPERATOR_ABORT_CONNECTING_BUTTON pressed!");
                this.setModelName("OPERATOR_ABORT_CONNECTING_BUTTON");
                this.abortConnection();
                break;
            }
            case 2301260: {
                this.logChannel.log(1000000, "AbstractPoiCallModelHandler#keyPressed: OPERATOR_DELETE_HISTORYCALL_BUTTON pressed!");
                this.setModelName("OPERATOR_DELETE_HISTORYCALL_BUTTON");
                this.listener.deleteThisHistory();
                break;
            }
            case 2301258: {
                this.logChannel.log(1000000, "AbstractPoiCallModelHandler#keyPressed: OPERATOR_DELETE_ALL_HISTORYCALLS_BUTTON pressed!");
                this.setModelName("OPERATOR_DELETE_ALL_HISTORYCALLS_BUTTON");
                this.listener.deleteAllCalls(true);
                break;
            }
            case 2301264: {
                this.logChannel.log(1000000, "AbstractPoiCallModelHandler#keyPressed: OPERATOR_SAVE_AS_FAVORITE_BUTTON pressed!");
                this.setModelName("OPERATOR_SAVE_AS_FAVORITE_BUTTON");
                this.listener.addToFavorite();
                break;
            }
            case 2301266: {
                this.logChannel.log(1000000, "AbstractPoiCallModelHandler#keyPressed: OPERATOR_ADD_TO_CONTACT_BUTTON pressed!");
                this.setModelName("OPERATOR_ADD_TO_CONTACT_BUTTON");
                this.listener.addToContact();
                break;
            }
            case 2301268: {
                this.logChannel.log(1000000, "AbstractPoiCallModelHandler#keyPressed: OPERATOR_SHOW_DESTINATION_DETAILS_BUTTON pressed!");
                this.setModelName("OPERATOR_SHOW_DESTINATION_DETAILS_BUTTON");
                this.listener.showDetails();
                break;
            }
            case 2301270: {
                this.logChannel.log(1000000, "AbstractPoiCallModelHandler#keyPressed: OPERATOR_SHOW_IN_MAP_BUTTON pressed!");
                this.setModelName("OPERATOR_SHOW_IN_MAP_BUTTON");
                this.listener.showInMap();
                break;
            }
            case 2301471: {
                this.logChannel.log(1000000, "AbstractPoiCallModelHandler#keyPressed: OPERATOR_CALL_AUTOSEND_CCP_CHOICE pressed!");
                this.setModelName("OPERATOR_CALL_AUTOSEND_CCP_CHOICE");
                break;
            }
            default: {
                this.logChannel.log(100000, "AbstractPoiCallModelHandler#keyPressed: unknown button (%1) pressed", (long)n);
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
        if (n == 0) {
            return true;
        }
        if (n == 1) {
            return false;
        }
        this.logChannel.log(10000, "AbstractPoiCallModelHandler#isConfirmCCPScreenShown: undefined status of OPERATOR_CALL_TRANSMIT_POSITION_BUTTON: %1. This should never happen!", (long)n);
        return true;
    }

    public void enableFeatures(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        if (bl && bl2 && bl3 && !bl4) {
            this.setChoiceValue(2301186, "OPERATOR_CALL_CENTER_AVAILABLE_CHOICE", 1);
        } else {
            this.setChoiceValue(2301186, "OPERATOR_CALL_CENTER_AVAILABLE_CHOICE", 0);
        }
    }

    protected boolean isFeatureEnabled() {
        return this.getChoiceValue(2301186) == 1;
    }

    protected boolean isApplicationEnabled() {
        return true;
    }

    public void deleteCachedPois() {
    }

    public void clearAllLists() {
        this.getTiledListModel(2301175).removeAll();
        this.getTiledListModel(2301174).removeAll();
        this.setFirstUniqueIdInCallList(-1L);
    }

    public void showPopup(int n) {
    }

    protected void optionKeyPressed(int n, int n2, int n3) {
    }

    protected void menuModelItemFocused(int n, long l, int n2) {
        this.logChannel.log(1000000, "AbstractPoiCallModelHandler#menuModelItemFocused: modelId = %1", (long)n);
        if (n == 2301189 && l == -1L) {
            this.showCcpPreviewMap();
            this.listener.setLastCallFocused(-1);
        }
    }

    protected int[] getMenuModelIdsToRegister() {
        return new int[0];
    }

    protected int getCallListModelId() {
        return 2301175;
    }

    protected String getCallListModelName() {
        return "OPERATOR_CALL_RESULTS_TILED_LIST";
    }

    protected int getResultListModelId() {
        return 2301174;
    }

    protected String getResultListModelName() {
        return "OPERATOR_RESULTS_TILED_LIST";
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
        int n2 = n == 0 ? 0 : 1;
        this.setChoiceValue(2301471, "OPERATOR_CALL_AUTOSEND_CCP_CHOICE", n2);
    }

    protected boolean isTransmissionOfCcpPermitted() {
        int n = this.getChoiceValue(2301471);
        return n == 1;
    }

    protected int[] getChoiceIdsToRegister() {
        return new int[]{2301471};
    }

    protected void choiceModelItemSelected(int n, int n2, int n3) {
        switch (n) {
            case 2301471: {
                this.logChannel.log(1000000, "AbstractPoiCallModelHandler#choiceModelItemSelected: OPERATOR_CALL_AUTOSEND_CCP_CHOICE pressed!");
                this.setModelName("OPERATOR_CALL_AUTOSEND_CCP_CHOICE");
                boolean bl = this.isTransmissionOfCcpPermitted();
                int n4 = bl ? 0 : 1;
                this.listener.setTransmissionOfCcp(n4);
                break;
            }
            default: {
                this.logChannel.log(100000, "AbstractPoiCallModelHandler#choiceModelItemSelected: unknown choiceModel (%1) pressed", (long)n);
            }
        }
    }
}

