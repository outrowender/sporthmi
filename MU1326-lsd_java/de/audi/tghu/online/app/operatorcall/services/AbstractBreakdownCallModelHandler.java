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

    @Override
    protected void buttonKeyPressed(int n) {
        switch (n) {
            case 2301155: {
                this.logChannel.log(1078071040, "AbstractBreakdownCallModelHandler#keyPressed: BREAKDOWN_START_BCALL_BUTTON => start breakdown call");
                this.setModelName("BREAKDOWN_START_BCALL_BUTTON");
                this.deleteCachedPois();
                this.fireButtonEvent();
                break;
            }
            case 2301160: {
                this.setModelName("BREAKDOWN_END_CALL_BUTTON");
                this.logChannel.log(1078071040, "AbstractBreakdownCallModelHandler#keyPressed: BREAKDOWN_END_CALL_BUTTON pressed!");
                this.hangup();
                break;
            }
            case 2301161: {
                this.logChannel.log(1078071040, "AbstractBreakdownCallModelHandler#keyPressed: BREAKDOWN_ABORT_CONNECTING_BUTTON pressed!");
                this.setModelName("BREAKDOWN_ABORT_CONNECTING_BUTTON");
                this.abortConnection();
                break;
            }
            case 2301164: {
                this.logChannel.log(1078071040, "AbstractBreakdownCallModelHandler#keyPressed: BREAKDOWN_CALL_START_NAVIGATION_BUTTON pressed!");
                this.setModelName("BREAKDOWN_CALL_START_NAVIGATION_BUTTON");
                this.listener.startRouteGuidance();
                break;
            }
            case 2301158: {
                this.logChannel.log(1078071040, "AbstractBreakdownCallModelHandler#keyPressed: BREAKDOWN_CANCEL_ROUTE_GUIDANCE_BUTTON pressed!");
                this.setModelName("BREAKDOWN_CANCEL_ROUTE_GUIDANCE_BUTTON");
                this.routeGuidanceCancelled();
                break;
            }
            case 2301148: {
                this.logChannel.log(1078071040, "AbstractBreakdownCallModelHandler#keyPressed: BREAKDOWN_DOWNLOAD_OLD_RESULTS_BUTTON => download old results");
                this.setModelName("BREAKDOWN_DOWNLOAD_OLD_RESULTS_BUTTON");
                this.startDownloadPoi();
                break;
            }
            case 2301152: {
                this.logChannel.log(1078071040, "AbstractBreakdownCallModelHandler#keyPressed: BREAKDOWN_START_NEW_CALL_BUTTON => start a new call");
                this.setModelName("BREAKDOWN_START_NEW_CALL_BUTTON");
                this.startNewCall();
                break;
            }
            case 2301167: {
                this.logChannel.log(1078071040, "AbstractBreakdownCallModelHandler#keyPressed: BREAKDOWN_CALL_CONFIRM_BUTTON => ok button clicked in a final screen");
                this.setModelName("BREAKDOWN_CALL_CONFIRM_BUTTON");
                this.confirmButtonPressed();
                this.fireButtonEvent();
                break;
            }
            default: {
                this.logChannel.log(-1601830656, "AbstractBreakdownCallModelHandler#keyPressed: unknown button (%1) pressed", (long)n);
            }
        }
    }

    @Override
    protected int[] getButtonIdsToRegister() {
        return new int[]{-484695296, -602135808, -535026944, -283368704, -400809216, -384032000, -333700352, -434363648};
    }

    @Override
    protected int[] getTiledListIdsToRegister() {
        return null;
    }

    protected int[] getOptionIdsToRegister() {
        return null;
    }

    @Override
    public void setWelcomeScreen(boolean bl) {
        if (bl) {
            this.setChoiceValue(-467918080, "BREAKDOWN_CALL_WELCOME_CHOICE", 0);
        } else {
            this.setChoiceValue(-467918080, "BREAKDOWN_CALL_WELCOME_CHOICE", 1);
        }
    }

    @Override
    protected void enableApplication(boolean bl) {
        this.logChannel.log(1078071040, "BModelHandler#setApplicationAsEnabled: enable = %1", bl);
        if (bl) {
            this.setChoiceValue(-585358592, "BREAKDOWN_CALL_STATE_CHOICE", 1);
        } else {
            this.setChoiceValue(-585358592, "BREAKDOWN_CALL_STATE_CHOICE", 0);
            this.abortConnection();
        }
    }

    @Override
    public void setConfirmCCPScreen(boolean bl) {
    }

    @Override
    protected boolean isConfirmCCPScreenShown() {
        return false;
    }

    @Override
    public void resetCallInformation() {
        this.setLabelText(-551804160, "BREAKDOWN_CALL_DURATION_LABEL", "");
    }

    @Override
    protected void setDurationLabel(String string) {
        this.setLabelText(-551804160, "BREAKDOWN_CALL_DURATION_LABEL", string);
    }

    @Override
    protected String getCallDuration() {
        return this.getLabelText(-551804160);
    }

    @Override
    public void setCallActive(boolean bl) {
        if (!bl) {
            this.setChoiceValue(-451140864, "BREAKDOWN_CALL_ACTIVE_CHOICE", 0);
            this.setChoiceStatus(-451140864, "BREAKDOWN_CALL_ACTIVE_CHOICE", 0);
        } else {
            this.setChoiceStatus(-451140864, "BREAKDOWN_CALL_ACTIVE_CHOICE", 1);
            this.setChoiceValue(-451140864, "BREAKDOWN_CALL_ACTIVE_CHOICE", 1);
        }
    }

    @Override
    public boolean isCallActive() {
        int n = this.getChoiceStatus(-451140864);
        return n == 1;
    }

    @Override
    public void setChoiceDownloadActive(boolean bl) {
        if (bl) {
            this.setChoiceValue(-518249728, "BREAKDOWN_RESULTS_FETCHING_MODE_CHOICE", 1);
        } else {
            this.logChannel.log(1078071040, "AbstractBreakdownCallModelHandler#setChoiceDownloadActive: leave screen Fetching Data ...");
            this.setChoiceValue(-518249728, "BREAKDOWN_RESULTS_FETCHING_MODE_CHOICE", 0);
        }
    }

    @Override
    public boolean isDownloadActive() {
        int n = this.getChoiceValue(-518249728);
        return n == 1;
    }

    @Override
    public void newPoiResultsReceived(int n) {
        if (n > 0) {
            this.logChannel.log(-2137614336, "AbstractBreakdownCallModelHandler#newPoiResultsReceived: show route guidance screen");
            this.setChoiceValue(-216259840, "BREAKDOWN_CALL_POI_RESULT_CHOICE", 1);
        } else {
            this.logChannel.log(-2137614336, "AbstractBreakdownCallModelHandler#newPoiResultsReceived: show Thank you screen");
            this.setChoiceValue(-216259840, "BREAKDOWN_CALL_POI_RESULT_CHOICE", 0);
        }
        this.setChoiceStatus(-367254784, "BREAKDOWN_DOWNLOAD_RESULT_CHOICE", 1);
        this.setChoiceValue(-367254784, "BREAKDOWN_DOWNLOAD_RESULT_CHOICE", 0);
    }

    @Override
    public void deleteCachedPois() {
        this.logChannel.log(1078071040, "AbstractBreakdownCallModelHandler#deleteCachedPois");
        this.setChoiceValue(-216259840, "BREAKDOWN_CALL_POI_RESULT_CHOICE", 0);
        this.setChoiceValue(-350477568, "BREAKDOWN_OLD_RESULTS_AVAILABLE_CHOICE", 0);
    }

    @Override
    public void setOldSession(boolean bl) {
        if (bl) {
            this.setChoiceValue(-350477568, "BREAKDOWN_OLD_RESULTS_AVAILABLE_CHOICE", 1);
        } else {
            this.setChoiceValue(-350477568, "BREAKDOWN_OLD_RESULTS_AVAILABLE_CHOICE", 0);
        }
        this.toggleChoiceStatus(-350477568, "BREAKDOWN_OLD_RESULTS_AVAILABLE_CHOICE");
    }

    @Override
    protected void listItemSelected(EvoListRow evoListRow, int n, int n2) {
    }

    @Override
    protected void listItemFocused(EvoListRow evoListRow, int n, int n2) {
    }

    @Override
    public void enableFeatures(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        if (bl && bl2 && bl3 && !bl4) {
            this.setChoiceValue(790569728, "BREAKDOWN_CALL_CENTER_AVAILABLE_CHOICE", 1);
        } else {
            this.setChoiceValue(790569728, "BREAKDOWN_CALL_CENTER_AVAILABLE_CHOICE", 0);
        }
    }

    @Override
    protected boolean isFeatureEnabled() {
        return this.getChoiceValue(790569728) == 1;
    }

    @Override
    protected boolean isApplicationEnabled() {
        return this.getChoiceValue(-585358592) == 1;
    }

    @Override
    public void historyCallSelectedBySDS(int n) {
    }

    @Override
    protected void showPoiResults(AbstractHistoryCallListRow abstractHistoryCallListRow, PoiResultListRow[] poiResultListRowArray) {
    }

    @Override
    public void clearAllLists() {
    }

    @Override
    public void showPopup(int n) {
    }

    @Override
    protected void optionKeyPressed(int n, int n2, int n3) {
    }

    @Override
    protected void menuModelItemFocused(int n, long l, int n2) {
    }

    @Override
    protected int[] getMenuModelIdsToRegister() {
        return new int[0];
    }

    @Override
    protected int getCallListModelId() {
        return -1;
    }

    @Override
    protected String getCallListModelName() {
        return null;
    }

    @Override
    protected int getResultListModelId() {
        return -1;
    }

    @Override
    protected String getResultListModelName() {
        return null;
    }

    @Override
    public void requestItems(int n, int n2, int n3, int n4, int n5) {
    }

    @Override
    public void unrequestItems(int n, int n2, int n3, int n4) {
    }

    @Override
    protected int getDownloadResultChoiceId() {
        return -367254784;
    }

    @Override
    protected String getDownloadResultChoiceName() {
        return "BREAKDOWN_DOWNLOAD_RESULT_CHOICE";
    }

    @Override
    public void triggerAbortConnection() {
        this.toggleChoiceValue(-618847488, "BREAKDOWN_ABORT_CONNECTION_CHOICE");
    }

    @Override
    protected void setCcpPermission(int n) {
    }

    @Override
    protected int[] getChoiceIdsToRegister() {
        return new int[0];
    }

    @Override
    protected void choiceModelItemSelected(int n, int n2, int n3) {
    }

    @Override
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

