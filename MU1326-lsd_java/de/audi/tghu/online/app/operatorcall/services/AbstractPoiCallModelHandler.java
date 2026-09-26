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

    @Override
    public void listItemSelected(EvoListRow evoListRow, int n, int n2) {
        switch (n) {
            case 2301175: {
                this.setModelName("OPERATOR_CALL_RESULTS_TILED_LIST");
                AbstractHistoryCallListRow abstractHistoryCallListRow = this.getHistoryCallListRow(evoListRow);
                AbstractOperatorCallDataContainer abstractOperatorCallDataContainer = this.listener.getData();
                PoiResultListRow[] poiResultListRowArray = abstractOperatorCallDataContainer.getResultsForCall(n2);
                if (poiResultListRowArray.length == 1) {
                    this.logChannel.log(-2137614336, "AbstractPoiCallModelHandler#itemSelected: Call has only one result! Starting route guidance");
                    this.getTiledListModel(-165928192).removeAll();
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

    @Override
    protected void showPoiResults(AbstractHistoryCallListRow abstractHistoryCallListRow, PoiResultListRow[] poiResultListRowArray) {
        this.logChannel.log(1078071040, "AbstractPoiCallModelHandler#showPoiResults: called");
        TiledListModelApp tiledListModelApp = this.getTiledListModel(-165928192);
        Buffer buffer = new Buffer(abstractHistoryCallListRow.getDateAsString());
        buffer.append(" ");
        buffer.append(abstractHistoryCallListRow.getTimeAsString());
        this.setLabelText(-14933248, "OPERATOR_CALL_TITLE_DATE_LABEL", buffer.toString());
        tiledListModelApp.removeAll();
        this.logChannel.log(-2137614336, "AbstractPoiCallModelHandler#showPoiResults: RESULTS_TILED_LIST: length = %1->%2", (long)tiledListModelApp.getLength(), (long)poiResultListRowArray.length);
        this.printPoiResults(poiResultListRowArray);
        tiledListModelApp.append(poiResultListRowArray);
        this.logChannel.log(1078071040, "AbstractPoiCallModelHandler#showPoiResults: ended");
    }

    @Override
    protected void listItemFocused(EvoListRow evoListRow, int n, int n2) {
        switch (n) {
            case 2301175: {
                this.setModelName("OPERATOR_CALL_RESULTS_TILED_LIST");
                AbstractHistoryCallListRow abstractHistoryCallListRow = this.getHistoryCallListRow(evoListRow);
                this.logChannel.log(1078071040, "AbstractPoiCallModelHandler#itemFocused: OPERATOR_CALL_RESULTS_TILED_LIST => name = %1 selected, index = %2", (Object)abstractHistoryCallListRow.getName(), (long)n2);
                this.logChannel.log(-2137614336, "AbstractPoiCallModelHandler#itemFocused: Information:\n%1", (Object)abstractHistoryCallListRow);
                this.showPreviewMap(n2);
                this.listener.setLastCallFocused(n2);
                break;
            }
            case 2301174: {
                this.setModelName("OPERATOR_RESULTS_TILED_LIST");
                PoiResultListRow poiResultListRow = this.getPoiResultListRow(evoListRow);
                this.logChannel.log(1078071040, "AbstractPoiCallModelHandler#itemFocused: OPERATOR_RESULTS_TILED_LIST => name = %1 selected, index = %2", (Object)poiResultListRow.getName(), (long)n2);
                this.logChannel.log(-2137614336, "AbstractPoiCallModelHandler#itemFocused: Information:\n%1", (Object)evoListRow);
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

    @Override
    public void setWelcomeScreen(boolean bl) {
    }

    @Override
    protected void enableApplication(boolean bl) {
    }

    @Override
    public void resetCallInformation() {
        this.setLabelText(-954457344, "OPERATOR_CALL_DURATION_LABEL", "");
    }

    @Override
    public void setCallActive(boolean bl) {
        if (!bl) {
            this.setChoiceValue(-1961090304, "OPERATOR_CALL_ACTIVE_CHOICE", 0);
            this.setChoiceStatus(-1961090304, "OPERATOR_CALL_ACTIVE_CHOICE", 0);
        } else {
            this.setChoiceStatus(-1961090304, "OPERATOR_CALL_ACTIVE_CHOICE", 1);
            this.setChoiceValue(-1961090304, "OPERATOR_CALL_ACTIVE_CHOICE", 1);
        }
    }

    @Override
    public boolean isCallActive() {
        int n = this.getChoiceStatus(-1961090304);
        return n == 1;
    }

    @Override
    protected void setDurationLabel(String string) {
        this.setLabelText(-954457344, "OPERATOR_CALL_DURATION_LABEL", string);
    }

    @Override
    protected String getCallDuration() {
        return this.getLabelText(-954457344);
    }

    @Override
    public void setChoiceDownloadActive(boolean bl) {
        if (bl) {
            this.setChoiceValue(-1373887744, "OPERATOR_RESULTS_FETCHING_MODE_CHOICE", 1);
        } else {
            this.logChannel.log(1078071040, "AbstractPoiCallModelHandler#setChoiceDownloadActive: leave screen Fetching Data ...");
            this.setChoiceValue(-1373887744, "OPERATOR_RESULTS_FETCHING_MODE_CHOICE", 0);
        }
    }

    @Override
    public boolean isDownloadActive() {
        int n = this.getChoiceValue(-1373887744);
        return n == 1;
    }

    @Override
    protected void newPoiResultsReceived(int n) {
        this.defaultNewPoiResultsReceived(n);
    }

    @Override
    public void setOldSession(boolean bl) {
        if (bl) {
            this.setChoiceValue(-1910758656, "OPERATOR_OLD_RESULTS_AVAILABLE_CHOICE", 1);
        } else {
            this.setChoiceValue(-1910758656, "OPERATOR_OLD_RESULTS_AVAILABLE_CHOICE", 0);
        }
        this.toggleChoiceStatus(-1910758656, "OPERATOR_OLD_RESULTS_AVAILABLE_CHOICE");
    }

    @Override
    protected int[] getButtonIdsToRegister() {
        return new int[]{-1021566208, -1877204224, -1860427008, -82042112, -65264896, -199482624, -1726209280, -1742986496, 1276977920, 1243423488, 1344086784, 1377641216, 1411195648, 1444750080};
    }

    @Override
    protected int[] getTiledListIdsToRegister() {
        return new int[]{-149150976, -165928192};
    }

    @Override
    protected void buttonKeyPressed(int n) {
        switch (n) {
            case 2301123: {
                this.logChannel.log(1078071040, "AbstractPoiCallModelHandler#keyPressed: OPERATOR_START_BCALL_BUTTON => start operator call");
                this.setModelName("OPERATOR_START_BCALL_BUTTON");
                this.setJokerKeyBackBehaviour(false);
                this.fireButtonEvent();
                break;
            }
            case 2301072: {
                this.logChannel.log(1078071040, "AbstractPoiCallModelHandler#keyPressed:OPERATOR_DOWNLOAD_OLD_RESULTS_BUTTON => download old results");
                this.setModelName("OPERATOR_DOWNLOAD_OLD_RESULTS_BUTTON");
                this.startDownloadPoi();
                break;
            }
            case 2301073: {
                this.logChannel.log(1078071040, "AbstractPoiCallModelHandler#keyPressed:OPERATOR_START_NEW_CALL_BUTTON => start a new call");
                this.setModelName("OPERATOR_START_NEW_CALL_BUTTON");
                this.startNewCall();
                break;
            }
            case 2301179: {
                this.logChannel.log(1078071040, "AbstractPoiCallModelHandler#OPERATOR_CALL_TRANSMIT_POSITION_BUTTON => transmit car position");
                this.logChannel.log(10000, "AbstractPoiCallModelHandler#keyPressed:OPERATOR_CALL_TRANSMIT_POSITION_BUTTON => should never be called any more");
                this.setModelName("OPERATOR_CALL_TRANSMIT_POSITION_BUTTON");
                this.listener.setTransmissionOfCcp(1);
                this.fireButtonEvent();
                this.startCallPressed();
                break;
            }
            case 2301180: {
                this.logChannel.log(1078071040, "AbstractPoiCallModelHandler#keyPressed:OPERATOR_CALL_NO_TRANSMIT_POSITION_BUTTON => don't transmit car position");
                this.logChannel.log(10000, "AbstractPoiCallModelHandler#keyPressed:OPERATOR_CALL_NO_TRANSMIT_POSITION_BUTTON => should never be called any more!");
                this.setModelName("OPERATOR_CALL_NO_TRANSMIT_POSITION_BUTTON");
                this.listener.setTransmissionOfCcp(0);
                this.fireButtonEvent();
                this.startCallPressed();
                break;
            }
            case 2301172: {
                this.logChannel.log(1078071040, "AbstractPoiCallModelHandler#OPERATOR_CALL_CONFIRM_BUTTON => ok button clicked in a final screen");
                this.setModelName("OPERATOR_CALL_CONFIRM_BUTTON");
                this.confirmButtonPressed();
                this.fireButtonEvent();
                break;
            }
            case 2301081: {
                this.logChannel.log(1078071040, "AbstractPoiCallModelHandler#keyPressed: OPERATOR_END_CALL_BUTTON pressed!");
                this.setModelName("OPERATOR_END_CALL_BUTTON");
                this.hangup();
                break;
            }
            case 2301080: {
                this.logChannel.log(1078071040, "AbstractPoiCallModelHandler#keyPressed: OPERATOR_ABORT_CONNECTING_BUTTON pressed!");
                this.setModelName("OPERATOR_ABORT_CONNECTING_BUTTON");
                this.abortConnection();
                break;
            }
            case 2301260: {
                this.logChannel.log(1078071040, "AbstractPoiCallModelHandler#keyPressed: OPERATOR_DELETE_HISTORYCALL_BUTTON pressed!");
                this.setModelName("OPERATOR_DELETE_HISTORYCALL_BUTTON");
                this.listener.deleteThisHistory();
                break;
            }
            case 2301258: {
                this.logChannel.log(1078071040, "AbstractPoiCallModelHandler#keyPressed: OPERATOR_DELETE_ALL_HISTORYCALLS_BUTTON pressed!");
                this.setModelName("OPERATOR_DELETE_ALL_HISTORYCALLS_BUTTON");
                this.listener.deleteAllCalls(true);
                break;
            }
            case 2301264: {
                this.logChannel.log(1078071040, "AbstractPoiCallModelHandler#keyPressed: OPERATOR_SAVE_AS_FAVORITE_BUTTON pressed!");
                this.setModelName("OPERATOR_SAVE_AS_FAVORITE_BUTTON");
                this.listener.addToFavorite();
                break;
            }
            case 2301266: {
                this.logChannel.log(1078071040, "AbstractPoiCallModelHandler#keyPressed: OPERATOR_ADD_TO_CONTACT_BUTTON pressed!");
                this.setModelName("OPERATOR_ADD_TO_CONTACT_BUTTON");
                this.listener.addToContact();
                break;
            }
            case 2301268: {
                this.logChannel.log(1078071040, "AbstractPoiCallModelHandler#keyPressed: OPERATOR_SHOW_DESTINATION_DETAILS_BUTTON pressed!");
                this.setModelName("OPERATOR_SHOW_DESTINATION_DETAILS_BUTTON");
                this.listener.showDetails();
                break;
            }
            case 2301270: {
                this.logChannel.log(1078071040, "AbstractPoiCallModelHandler#keyPressed: OPERATOR_SHOW_IN_MAP_BUTTON pressed!");
                this.setModelName("OPERATOR_SHOW_IN_MAP_BUTTON");
                this.listener.showInMap();
                break;
            }
            case 2301471: {
                this.logChannel.log(1078071040, "AbstractPoiCallModelHandler#keyPressed: OPERATOR_CALL_AUTOSEND_CCP_CHOICE pressed!");
                this.setModelName("OPERATOR_CALL_AUTOSEND_CCP_CHOICE");
                break;
            }
            default: {
                this.logChannel.log(-1601830656, "AbstractPoiCallModelHandler#keyPressed: unknown button (%1) pressed", (long)n);
            }
        }
    }

    @Override
    public void setConfirmCCPScreen(boolean bl) {
        if (bl) {
            this.setButtonStatus(-82042112, "OPERATOR_CALL_TRANSMIT_POSITION_BUTTON", 1);
        } else {
            this.setButtonStatus(-82042112, "OPERATOR_CALL_TRANSMIT_POSITION_BUTTON", 0);
        }
    }

    @Override
    public boolean isConfirmCCPScreenShown() {
        int n = this.getButtonStatus(-82042112);
        if (n == 0) {
            return true;
        }
        if (n == 1) {
            return false;
        }
        this.logChannel.log(10000, "AbstractPoiCallModelHandler#isConfirmCCPScreenShown: undefined status of OPERATOR_CALL_TRANSMIT_POSITION_BUTTON: %1. This should never happen!", (long)n);
        return true;
    }

    @Override
    public void enableFeatures(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        if (bl && bl2 && bl3 && !bl4) {
            this.setChoiceValue(35463936, "OPERATOR_CALL_CENTER_AVAILABLE_CHOICE", 1);
        } else {
            this.setChoiceValue(35463936, "OPERATOR_CALL_CENTER_AVAILABLE_CHOICE", 0);
        }
    }

    @Override
    protected boolean isFeatureEnabled() {
        return this.getChoiceValue(35463936) == 1;
    }

    @Override
    protected boolean isApplicationEnabled() {
        return true;
    }

    @Override
    public void deleteCachedPois() {
    }

    @Override
    public void clearAllLists() {
        this.getTiledListModel(-149150976).removeAll();
        this.getTiledListModel(-165928192).removeAll();
        this.setFirstUniqueIdInCallList(-1L);
    }

    @Override
    public void showPopup(int n) {
    }

    @Override
    protected void optionKeyPressed(int n, int n2, int n3) {
    }

    @Override
    protected void menuModelItemFocused(int n, long l, int n2) {
        this.logChannel.log(1078071040, "AbstractPoiCallModelHandler#menuModelItemFocused: modelId = %1", (long)n);
        if (n == 85795584 && l == -1L) {
            this.showCcpPreviewMap();
            this.listener.setLastCallFocused(-1);
        }
    }

    @Override
    protected int[] getMenuModelIdsToRegister() {
        return new int[0];
    }

    @Override
    protected int getCallListModelId() {
        return -149150976;
    }

    @Override
    protected String getCallListModelName() {
        return "OPERATOR_CALL_RESULTS_TILED_LIST";
    }

    @Override
    protected int getResultListModelId() {
        return -165928192;
    }

    @Override
    protected String getResultListModelName() {
        return "OPERATOR_RESULTS_TILED_LIST";
    }

    @Override
    public void requestItems(int n, int n2, int n3, int n4, int n5) {
        if (n4 == this.getCallListModelId()) {
            EvoListRow[] evoListRowArray = this.listener.getData().getAllHistoryCallGUIListsInIntervall(n, n2);
            this.getTiledListModel(n4).setRows(n3, n, evoListRowArray);
        }
    }

    @Override
    public void unrequestItems(int n, int n2, int n3, int n4) {
        if (n3 == this.getCallListModelId()) {
            this.getTiledListModel(n3).clearRows(n, n2);
        }
    }

    @Override
    protected int getDownloadResultChoiceId() {
        return -1759763712;
    }

    @Override
    protected String getDownloadResultChoiceName() {
        return "OPERATOR_DOWNLOAD_RESULT_CHOICE";
    }

    @Override
    public void triggerAbortConnection() {
        this.toggleChoiceValue(-635624704, "OPERATOR_ABORT_CONNECTION_CHOICE");
    }

    @Override
    protected void setCcpPermission(int n) {
        int n2 = n == 0 ? 0 : 1;
        this.setChoiceValue(522068736, "OPERATOR_CALL_AUTOSEND_CCP_CHOICE", n2);
    }

    @Override
    protected boolean isTransmissionOfCcpPermitted() {
        int n = this.getChoiceValue(522068736);
        return n == 1;
    }

    @Override
    protected int[] getChoiceIdsToRegister() {
        return new int[]{522068736};
    }

    @Override
    protected void choiceModelItemSelected(int n, int n2, int n3) {
        switch (n) {
            case 2301471: {
                this.logChannel.log(1078071040, "AbstractPoiCallModelHandler#choiceModelItemSelected: OPERATOR_CALL_AUTOSEND_CCP_CHOICE pressed!");
                this.setModelName("OPERATOR_CALL_AUTOSEND_CCP_CHOICE");
                boolean bl = this.isTransmissionOfCcpPermitted();
                int n4 = bl ? 0 : 1;
                this.listener.setTransmissionOfCcp(n4);
                break;
            }
            default: {
                this.logChannel.log(-1601830656, "AbstractPoiCallModelHandler#choiceModelItemSelected: unknown choiceModel (%1) pressed", (long)n);
            }
        }
    }
}

