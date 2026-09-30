/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.services;

import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.online.app.operatorcall.abstractclasses.AbstractModelHandler;
import de.audi.tghu.online.app.operatorcall.abstractclasses.AbstractOperatorCall;
import de.audi.tghu.online.app.operatorcall.data.AbstractHistoryCallListRow;
import de.audi.tghu.online.app.operatorcall.data.PoiResultListRow;

public abstract class AbstractBreakdownCallModelHandler
extends AbstractModelHandler {
    public AbstractBreakdownCallModelHandler(HMIService hMIService, AbstractOperatorCall abstractOperatorCall) {
        super(hMIService, abstractOperatorCall);
    }

    protected void buttonKeyPressed(int n) {
        switch (n) {
            case 2301155: {
                this.logChannel.log(1000000, "AbstractBreakdownCallModelHandler#keyPressed: BREAKDOWN_START_BCALL_BUTTON => start breakdown call");
                this.setModelName("BREAKDOWN_START_BCALL_BUTTON");
                this.deleteCachedPois();
                this.fireButtonEvent();
                break;
            }
            case 2301160: {
                this.setModelName("BREAKDOWN_END_CALL_BUTTON");
                this.logChannel.log(1000000, "AbstractBreakdownCallModelHandler#keyPressed: BREAKDOWN_END_CALL_BUTTON pressed!");
                this.hangup();
                break;
            }
            case 2301161: {
                this.logChannel.log(1000000, "AbstractBreakdownCallModelHandler#keyPressed: BREAKDOWN_ABORT_CONNECTING_BUTTON pressed!");
                this.setModelName("BREAKDOWN_ABORT_CONNECTING_BUTTON");
                this.abortConnection();
                break;
            }
            case 2301164: {
                this.logChannel.log(1000000, "AbstractBreakdownCallModelHandler#keyPressed: BREAKDOWN_CALL_START_NAVIGATION_BUTTON pressed!");
                this.setModelName("BREAKDOWN_CALL_START_NAVIGATION_BUTTON");
                this.listener.startRouteGuidance();
                break;
            }
            case 2301158: {
                this.logChannel.log(1000000, "AbstractBreakdownCallModelHandler#keyPressed: BREAKDOWN_CANCEL_ROUTE_GUIDANCE_BUTTON pressed!");
                this.setModelName("BREAKDOWN_CANCEL_ROUTE_GUIDANCE_BUTTON");
                this.routeGuidanceCancelled();
                break;
            }
            case 2301148: {
                this.logChannel.log(1000000, "AbstractBreakdownCallModelHandler#keyPressed: BREAKDOWN_DOWNLOAD_OLD_RESULTS_BUTTON => download old results");
                this.setModelName("BREAKDOWN_DOWNLOAD_OLD_RESULTS_BUTTON");
                this.startDownloadPoi();
                break;
            }
            case 2301152: {
                this.logChannel.log(1000000, "AbstractBreakdownCallModelHandler#keyPressed: BREAKDOWN_START_NEW_CALL_BUTTON => start a new call");
                this.setModelName("BREAKDOWN_START_NEW_CALL_BUTTON");
                this.startNewCall();
                break;
            }
            case 2301167: {
                this.logChannel.log(1000000, "AbstractBreakdownCallModelHandler#keyPressed: BREAKDOWN_CALL_CONFIRM_BUTTON => ok button clicked in a final screen");
                this.setModelName("BREAKDOWN_CALL_CONFIRM_BUTTON");
                this.confirmButtonPressed();
                this.fireButtonEvent();
                break;
            }
            default: {
                this.logChannel.log(100000, "AbstractBreakdownCallModelHandler#keyPressed: unknown button (%1) pressed", (long)n);
            }
        }
    }

    protected int[] getButtonIdsToRegister() {
        return new int[]{2301155, 2301148, 2301152, 2301167, 2301160, 2301161, 2301164, 2301158};
    }

    protected int[] getTiledListIdsToRegister() {
        return null;
    }

    protected int[] getOptionIdsToRegister() {
        return null;
    }

    public void setWelcomeScreen(boolean bl) {
        if (bl) {
            this.setChoiceValue(2301156, "BREAKDOWN_CALL_WELCOME_CHOICE", 0);
        } else {
            this.setChoiceValue(2301156, "BREAKDOWN_CALL_WELCOME_CHOICE", 1);
        }
    }

    protected void enableApplication(boolean bl) {
        this.logChannel.log(1000000, "BModelHandler#setApplicationAsEnabled: enable = %1", bl);
        if (bl) {
            this.setChoiceValue(2301149, "BREAKDOWN_CALL_STATE_CHOICE", 1);
        } else {
            this.setChoiceValue(2301149, "BREAKDOWN_CALL_STATE_CHOICE", 0);
            this.abortConnection();
        }
    }

    public void setConfirmCCPScreen(boolean bl) {
    }

    protected boolean isConfirmCCPScreenShown() {
        return false;
    }

    public void resetCallInformation() {
        this.setLabelText(2301151, "BREAKDOWN_CALL_DURATION_LABEL", "");
    }

    protected void setDurationLabel(String string) {
        this.setLabelText(2301151, "BREAKDOWN_CALL_DURATION_LABEL", string);
    }

    protected String getCallDuration() {
        return this.getLabelText(2301151);
    }

    public void setCallActive(boolean bl) {
        if (!bl) {
            this.setChoiceValue(2301157, "BREAKDOWN_CALL_ACTIVE_CHOICE", 0);
            this.setChoiceStatus(2301157, "BREAKDOWN_CALL_ACTIVE_CHOICE", 0);
        } else {
            this.setChoiceStatus(2301157, "BREAKDOWN_CALL_ACTIVE_CHOICE", 1);
            this.setChoiceValue(2301157, "BREAKDOWN_CALL_ACTIVE_CHOICE", 1);
        }
    }

    public boolean isCallActive() {
        int n = this.getChoiceStatus(2301157);
        return n == 1;
    }

    public void setChoiceDownloadActive(boolean bl) {
        if (bl) {
            this.setChoiceValue(2301153, "BREAKDOWN_RESULTS_FETCHING_MODE_CHOICE", 1);
        } else {
            this.logChannel.log(1000000, "AbstractBreakdownCallModelHandler#setChoiceDownloadActive: leave screen Fetching Data ...");
            this.setChoiceValue(2301153, "BREAKDOWN_RESULTS_FETCHING_MODE_CHOICE", 0);
        }
    }

    public boolean isDownloadActive() {
        int n = this.getChoiceValue(2301153);
        return n == 1;
    }

    public void newPoiResultsReceived(int n) {
        if (n > 0) {
            this.logChannel.log(10000000, "AbstractBreakdownCallModelHandler#newPoiResultsReceived: show route guidance screen");
            this.setChoiceValue(2301171, "BREAKDOWN_CALL_POI_RESULT_CHOICE", 1);
        } else {
            this.logChannel.log(10000000, "AbstractBreakdownCallModelHandler#newPoiResultsReceived: show Thank you screen");
            this.setChoiceValue(2301171, "BREAKDOWN_CALL_POI_RESULT_CHOICE", 0);
        }
        this.setChoiceStatus(2301162, "BREAKDOWN_DOWNLOAD_RESULT_CHOICE", 1);
        this.setChoiceValue(2301162, "BREAKDOWN_DOWNLOAD_RESULT_CHOICE", 0);
    }

    public void deleteCachedPois() {
        this.logChannel.log(1000000, "AbstractBreakdownCallModelHandler#deleteCachedPois");
        this.setChoiceValue(2301171, "BREAKDOWN_CALL_POI_RESULT_CHOICE", 0);
        this.setChoiceValue(2301163, "BREAKDOWN_OLD_RESULTS_AVAILABLE_CHOICE", 0);
    }

    public void setOldSession(boolean bl) {
        if (bl) {
            this.setChoiceValue(2301163, "BREAKDOWN_OLD_RESULTS_AVAILABLE_CHOICE", 1);
        } else {
            this.setChoiceValue(2301163, "BREAKDOWN_OLD_RESULTS_AVAILABLE_CHOICE", 0);
        }
        this.toggleChoiceStatus(2301163, "BREAKDOWN_OLD_RESULTS_AVAILABLE_CHOICE");
    }

    protected void listItemSelected(EvoListRow evoListRow, int n, int n2) {
    }

    protected void listItemFocused(EvoListRow evoListRow, int n, int n2) {
    }

    public void enableFeatures(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        if (bl && bl2 && bl3 && !bl4) {
            this.setChoiceValue(2301743, "BREAKDOWN_CALL_CENTER_AVAILABLE_CHOICE", 1);
        } else {
            this.setChoiceValue(2301743, "BREAKDOWN_CALL_CENTER_AVAILABLE_CHOICE", 0);
        }
    }

    protected boolean isFeatureEnabled() {
        return this.getChoiceValue(2301743) == 1;
    }

    protected boolean isApplicationEnabled() {
        return this.getChoiceValue(2301149) == 1;
    }

    public void historyCallSelectedBySDS(int n) {
    }

    protected void showPoiResults(AbstractHistoryCallListRow abstractHistoryCallListRow, PoiResultListRow[] poiResultListRowArray) {
    }

    public void clearAllLists() {
    }

    public void showPopup(int n) {
    }

    protected void optionKeyPressed(int n, int n2, int n3) {
    }

    protected void menuModelItemFocused(int n, long l, int n2) {
    }

    protected int[] getMenuModelIdsToRegister() {
        return new int[0];
    }

    protected int getCallListModelId() {
        return -1;
    }

    protected String getCallListModelName() {
        return null;
    }

    protected int getResultListModelId() {
        return -1;
    }

    protected String getResultListModelName() {
        return null;
    }

    public void requestItems(int n, int n2, int n3, int n4, int n5) {
    }

    public void unrequestItems(int n, int n2, int n3, int n4) {
    }

    protected int getDownloadResultChoiceId() {
        return 2301162;
    }

    protected String getDownloadResultChoiceName() {
        return "BREAKDOWN_DOWNLOAD_RESULT_CHOICE";
    }

    public void triggerAbortConnection() {
        this.toggleChoiceValue(2301403, "BREAKDOWN_ABORT_CONNECTION_CHOICE");
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
        this.logChannel.log(10000, "AbstractBreakdownCallModelHandler#isTransmissionOfCcpPermitted: undefined permission(%1). This should never happen! Returning false.", (long)n);
        return false;
    }
}

