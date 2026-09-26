/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.abstractclasses;

import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.tghu.online.app.operatorcall.abstractclasses.AbstractBaseModelHandler;
import de.audi.tghu.online.app.operatorcall.abstractclasses.AbstractOperatorCall;
import de.audi.tghu.online.app.operatorcall.data.AbstractHistoryCallData;
import de.audi.tghu.online.app.operatorcall.data.AbstractHistoryCallListRow;
import de.audi.tghu.online.app.operatorcall.data.AbstractOperatorCallDataContainer;
import de.audi.tghu.online.app.operatorcall.data.PoiResultListRow;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;

public abstract class AbstractModelHandler
extends AbstractBaseModelHandler {
    public static final int POPUP_OPERATOR;
    protected static final long NONE;
    public static final int ERROR_NONE;
    public static final int ERROR_REAL;
    public static final int ERROR_OTHER;
    public static final int ERROR_NOPHONE;
    public static final int ERROR_OTHERCALL_ACTIVE;
    public static final int ERROR_NUMBERDOWNLOAD_FAILED;
    public static final int ERROR_WRONG_NUMBER_DOWNLOAD_RESPONSE;
    public static final int ERROR_POIDOWNLOAD_FAILED;
    public static final int ERROR_WRONG_POIDOWNLOAD_RESPONSE;
    public static final int ERROR_CONNECTION_LOST;
    public static final int ERROR_POI_NOTREADABLE;
    public static final int ERROR_ROUTEGUIDANCESTART_FAILED;
    public static final int ERROR_INTERNAL_FAILURE;
    protected AbstractOperatorCall listener;
    private boolean callRunning;
    private boolean downloadRunning;
    private long firstUniqueIdInList = -1L;
    protected int currentState;

    public AbstractModelHandler(HMIService hMIService, AbstractOperatorCall abstractOperatorCall) {
        super(hMIService);
        this.listener = abstractOperatorCall;
        this.logChannel.log(-2137614336, "AbstractModelHandler: listener is of type %1", (long)abstractOperatorCall.getServiceType());
        this.setChoiceStatus(-1692654848, "OPERATOR_PRIVATE_CALL_ACTIVE_CHOICE", 0);
        this.setCallActive(false);
        this.setChoiceStatus(4370, "OPERATOR_JOKERKEY_MODE_CHOICE", 0);
    }

    public abstract void setWelcomeScreen(boolean bl) {
    }

    public abstract void resetCallInformation() {
    }

    public abstract void setCallActive(boolean bl) {
    }

    public abstract boolean isCallActive() {
    }

    public abstract void enableFeatures(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
    }

    public abstract void deleteCachedPois() {
    }

    public abstract void clearAllLists() {
    }

    public abstract void triggerAbortConnection() {
    }

    protected abstract void enableApplication(boolean bl) {
    }

    protected abstract boolean isApplicationEnabled() {
    }

    protected abstract void setDurationLabel(String string) {
    }

    protected abstract String getCallDuration() {
    }

    protected abstract void setChoiceDownloadActive(boolean bl) {
    }

    protected abstract boolean isDownloadActive() {
    }

    protected abstract void newPoiResultsReceived(int n) {
    }

    protected abstract void setOldSession(boolean bl) {
    }

    protected abstract int getCallListModelId() {
    }

    protected abstract String getCallListModelName() {
    }

    protected abstract int getResultListModelId() {
    }

    protected abstract String getResultListModelName() {
    }

    protected abstract int getDownloadResultChoiceId() {
    }

    protected abstract String getDownloadResultChoiceName() {
    }

    protected abstract boolean isFeatureEnabled() {
    }

    protected abstract void showPoiResults(AbstractHistoryCallListRow abstractHistoryCallListRow, PoiResultListRow[] poiResultListRowArray) {
    }

    protected abstract void setConfirmCCPScreen(boolean bl) {
    }

    protected abstract boolean isConfirmCCPScreenShown() {
    }

    protected abstract void setCcpPermission(int n) {
    }

    protected abstract boolean isTransmissionOfCcpPermitted() {
    }

    public void setCurrentState(int n) {
    }

    protected abstract boolean isPhoneReadyForJokerkey() {
    }

    protected boolean isCurrentServiceTypeRunning() {
        return this.getCurrentServiceType() == this.listener.getServiceType();
    }

    public void startCallPressed() {
        this.logChannel.log(1078071040, "AbstractModelHandler#startCallPressed");
        if (this.isAnotherCallRunning()) {
            this.logChannel.log(-1601830656, "AbstractModelHandler#startCallPressed: another call is running. We should never come to this point in this case. This should not happen.");
            this.setCurrentState(5);
            this.showDefaultError(true, 1);
            return;
        }
        if (this.isDownloadPoisRunning()) {
            this.logChannel.log(-1601830656, "AbstractModelHandler#startCallPressed: pois are being downloaded. Doing nothing.");
            this.setCurrentState(5);
            this.showDefaultError(true, 2);
            return;
        }
        this.setWelcomeScreen(false);
        if (this.isConfirmCCPScreenShown()) {
            this.logChannel.log(-2137614336, "AbstractModelHandler#startCallPressed: Transmission is not set. Waiting for user interaction.");
            return;
        }
        this.logChannel.log(-2137614336, "AbstractModelHandler#startCallPressed: Transmission is set.");
        this.listener.userStartsNormalCall();
    }

    public boolean isAnotherCallRunning() {
        this.logAnotherCallRunning();
        return this.isAnyCallRunning() && !this.isOwnCallRunning();
    }

    private boolean isOwnCallRunning() {
        int n = this.getChoiceStatus(5535);
        int n2 = this.getChoiceValue(5535);
        int n3 = this.getChoiceValue(-1692654848);
        return n == 1 && n3 == n2;
    }

    private void logAnotherCallRunning() {
        Buffer buffer = new Buffer("AbstractModelHandler#logAnotherCallRunning: serviceType = ");
        buffer.append(this.listener.getServiceType());
        buffer.append("\nCALL_LEADING_DEVICE_CALL_STATE_CHOICE: value = ");
        buffer.append(this.getChoiceValue(4367));
        buffer.append("\nOPERATOR_MODE_CHOICE: status = ");
        buffer.append(this.getChoiceStatus(5535));
        buffer.append(", value = ");
        buffer.append(this.getChoiceValue(5535));
        buffer.append("\nOPERATOR_PRIVATE_CALL_ACTIVE_CHOICE: status = ");
        buffer.append(this.getChoiceStatus(-1692654848));
        buffer.append(", value = ");
        buffer.append(this.getChoiceValue(-1692654848));
        this.logChannel.log(-1601830656, buffer.toString());
    }

    public boolean isAnyCallRunning() {
        int n = this.getChoiceValue(4367);
        return n > 0;
    }

    public void setDuration(int n) {
        int n2 = n / 3600;
        int n3 = (n %= 3600) / 60;
        int n4 = n % 60;
        String string = this.getTimeString(n2, n3, n4);
        this.logChannel.log(14808325, "AbstractModelHandler#setDuration: %1", (Object)string);
        if (n != 0 || "".equalsIgnoreCase(this.getCallDuration())) {
            this.setDurationLabel(string);
        }
    }

    private String getTimeString(int n, int n2, int n3) {
        Buffer buffer = new Buffer();
        if (n != 0) {
            buffer.append(n);
            buffer.append(":");
            if (n2 < 10) {
                buffer.append("0");
            }
        }
        buffer.append(n2);
        buffer.append(":");
        if (n3 < 10) {
            buffer.append("0");
        }
        buffer.append(n3);
        return buffer.toString();
    }

    public void setCallRunning(boolean bl) {
        if (bl) {
            this.callRunning = true;
            this.setChoiceValue(-1692654848, "OPERATOR_PRIVATE_CALL_ACTIVE_CHOICE", 1);
            this.setChoiceValue(-1692654848, "OPERATOR_PRIVATE_CALL_ACTIVE_CHOICE", this.listener.getServiceType());
        } else {
            this.callRunning = false;
            if (!this.listener.isAnotherOperatorCallRunning()) {
                this.setChoiceValue(-1692654848, "OPERATOR_PRIVATE_CALL_ACTIVE_CHOICE", 0);
            }
        }
    }

    public boolean isCallRunning() {
        return this.callRunning;
    }

    public void setDownloadPoisRunning(boolean bl) {
        this.logChannel.log(-2137614336, "AbstractModelHandler#setDownloadPoisRunning: %1 -> %2", this.downloadRunning, bl);
        this.downloadRunning = bl;
    }

    public boolean isDownloadPoisRunning() {
        return this.downloadRunning;
    }

    protected void abortConnection() {
        this.listener.abortConnectionBeforeTelConnectionEstablished();
    }

    protected void hangup() {
        this.listener.hangup();
    }

    protected void routeGuidanceCancelled() {
        this.fireButtonEvent();
        this.listener.routeGuidanceCancelled();
    }

    protected void startDownloadPoi() {
        this.setWelcomeScreen(false);
        this.setOldSession(false);
        this.setDownloadActive(true);
        this.fireButtonEvent();
        this.listener.startDownloadPoi();
    }

    protected void startNewCall() {
        this.setWelcomeScreen(false);
        this.setOldSession(false);
        this.fireButtonEvent();
        if (this.isAnotherCallRunning()) {
            this.logChannel.log(-1601830656, "AbstractModelHandler#startNewCall: another call is running.");
            this.showDefaultError(true, 1);
            return;
        }
        if (this.isDownloadPoisRunning()) {
            this.logChannel.log(-1601830656, "AbstractModelHandler#startNewCall: pois are being downloaded. Doing nothing.");
            this.showDefaultError(true, 2);
            return;
        }
        this.listener.startNewCall();
    }

    protected void muteCall(boolean bl) {
        this.listener.muteCall(bl);
    }

    protected void confirmButtonPressed() {
        this.showDefaultError(false, 0);
    }

    protected void setDownloadActive(boolean bl) {
        if (this.isDownloadActive() != bl) {
            this.setChoiceDownloadActive(bl);
        }
    }

    public void startCallcenterCallBySDS(int n, boolean bl) {
        int n2 = 0;
        int n3 = -1;
        this.logChannel.log(-1601830656, "OperatorCallHMIListener#changeScreenToStartCallBySDS: terminalID and keyID is hardcoded, but there is no other way to do this at the moment!");
        switch (n) {
            case 1: {
                this.keyPressed(941433600, n3, n2);
                break;
            }
            case 2: {
                if (this.isConfirmCCPScreenShown()) {
                    if (bl) {
                        this.keyPressed(-82042112, n3, n2);
                        break;
                    }
                    this.keyPressed(-65264896, n3, n2);
                    break;
                }
                this.keyPressed(-1021566208, n3, n2);
                break;
            }
            default: {
                this.logChannel.log(-1601830656, "OperatorCallModelHandler#changeScreenToStartCallBySDS: sds is not defined for serviceType %1", (long)n);
            }
        }
    }

    protected void printPoiResults(PoiResultListRow[] poiResultListRowArray) {
        this.logChannel.log(1078071040, "OperatorCallModelHandler#printPoiResults called ...");
        for (int i2 = 0; i2 < poiResultListRowArray.length; ++i2) {
            PoiResultListRow poiResultListRow = poiResultListRowArray[i2];
            this.logChannel.log(14808325, "Result %1:\n%2\n", (Object)new Integer(i2 + 1), (Object)poiResultListRow.toString());
        }
    }

    protected void showPreviewMap(int n) {
        this.listener.showLocationsInPreviewMap(n);
    }

    protected void showCcpPreviewMap() {
        this.listener.showCcpInMap();
    }

    protected void showPreviewMap(int n, int n2) {
        this.listener.showLocationInPreviewMap(n, n2);
    }

    public boolean isTelephoneReady() {
        return this.getChoiceValue(186) == 1;
    }

    public boolean isJokerKeyFunctionalityAvailable() {
        if (this.isJokerKeyMode()) {
            this.logChannel.log(-1601830656, "AbstractModelHandler#isJokerKeyFunctionalityAvailable: joker key has already been pressed!");
            return false;
        }
        if (!this.isPhoneReadyForJokerkey()) {
            this.logChannel.log(-1601830656, "AbstractModelHandler#isJokerKeyFunctionalityAvailable: found a reason to ignore jokerkey!");
            return false;
        }
        int n = this.getChoiceStatus(5535);
        int n2 = this.getChoiceValue(5535);
        if (n == 1) {
            if (n2 == 2 || n2 == 1) {
                this.logChannel.log(-1601830656, "AbstractModelHandler#isJokerKeyFunctionalityAvailable: user is already in poi call or concierge call!");
                return false;
            }
            if (this.isCallRunning() || this.isDownloadActive()) {
                this.logChannel.log(-1601830656, "AbstractModelHandler#isJokerKeyFunctionalityAvailable: a call or a download is running!");
                return false;
            }
            if (!this.isApplicationEnabled() || !this.isFeatureEnabled()) {
                this.logChannel.log(-1601830656, "AbstractModelHandler#isJokerKeyFunctionalityAvailable: the application/feature is not ready!");
                return false;
            }
        }
        return true;
    }

    private boolean isJokerKeyMode() {
        return this.listener.isJokerKeyMode();
    }

    public void checksSuccessful() {
        this.logChannel.log(1078071040, "AbstractModelHandler#checksSuccessful: serviceType = %1", (Object)this.listener.getServiceTypeName());
        if (this.isCallActive()) {
            this.logChannel.log(10000, "AbstractModelHandler#checksSuccessful: Another call is in use. In this case guide should not call this method here.");
            return;
        }
        this.startCallPressed();
    }

    public void setJokerKeyBackBehaviour(boolean bl) {
        int n = bl ? 1 : 0;
        this.setChoiceStatus(4370, "OPERATOR_JOKERKEY_MODE_CHOICE", n);
    }

    public void historyCallSelectedBySDS(int n) {
        AbstractOperatorCallDataContainer abstractOperatorCallDataContainer = this.listener.getData();
        PoiResultListRow[] poiResultListRowArray = abstractOperatorCallDataContainer.getResultsForCall(n);
        if (poiResultListRowArray != null && poiResultListRowArray.length > 1) {
            AbstractHistoryCallListRow abstractHistoryCallListRow = abstractOperatorCallDataContainer.getHistoryCallForList(n);
            this.showPoiResults(abstractHistoryCallListRow, poiResultListRowArray);
        }
    }

    public void triggerJokerKey() {
        int n = this.getChoiceValue(4370);
        this.setChoiceValue(4370, "OPERATOR_JOKERKEY_MODE_CHOICE", n ^ 1);
    }

    public void setOption(boolean bl) {
        int n = bl ? 1 : 0;
        this.setChoiceValue(-1675812096, "OPERATOR_CALL_AS_OPTION", n);
    }

    protected void showPartialPopupPoiReceived() {
        this.logChannel.log(1078071040, "AbstractModelHandler#showPartialPopupPoiReceived: called: operatorMode = %1, serviceType = %2", (long)this.getCurrentServiceType(), (long)this.listener.getServiceType());
        if (!this.isCurrentServiceTypeValid() || this.getCurrentServiceType() != this.listener.getServiceType()) {
            int n = this.getChoiceValue(-1591926016);
            if (n == 1) {
                this.setChoiceValue(-1591926016, "OPERATOR_POI_RECEIVED_CHOICE", 2);
            } else {
                this.setChoiceValue(-1591926016, "OPERATOR_POI_RECEIVED_CHOICE", 1);
            }
        }
    }

    private boolean isCurrentServiceTypeValid() {
        return this.getChoiceStatus(5535) == 1;
    }

    public int getCurrentServiceType() {
        return this.getChoiceValue(5535);
    }

    public void triggerJumpToNavi() {
        this.toggleChoiceValue(-1004723456, "OPERATOR_CALL_JUMP_TO_OTHER_CONTEXT_CHOICE");
    }

    protected long insertFirstToTiledListModel(int n, String string, EvoListRow evoListRow) {
        long l = evoListRow.getUniqueID();
        this.logChannel.log(14808325, "AbstractBaseModelHandler#insertFirstToTiledListModel:  %1 ", (Object)string);
        TiledListModelApp tiledListModelApp = this.getTiledListModel(n);
        long l2 = this.getFirstUniqueIdInCallList();
        if (l2 == -1L) {
            tiledListModelApp.append(evoListRow);
        } else {
            tiledListModelApp.insertBefore(l2, evoListRow);
        }
        return this.setFirstUniqueIdInCallList(l);
    }

    private long getFirstUniqueIdInCallList() {
        return this.firstUniqueIdInList;
    }

    protected long setFirstUniqueIdInCallList(long l) {
        this.logChannel.log(14808325, "AbstractBaseModelHandler#insertFirstToTiledListModel: first ID in List %1 -> %2 ", this.firstUniqueIdInList, l);
        this.firstUniqueIdInList = l;
        return this.firstUniqueIdInList;
    }

    public void updateLists(int n) {
        for (int i2 = 0; i2 < n; ++i2) {
            AbstractHistoryCallListRow abstractHistoryCallListRow = this.listener.getHistoryCallForList(i2);
            this.insertFirstToTiledListModel(this.getCallListModelId(), this.getCallListModelName(), abstractHistoryCallListRow);
        }
    }

    public void fillListWithDataFromPersistence(ArrayList arrayList) {
        for (int i2 = 0; i2 < arrayList.size(); ++i2) {
            AbstractHistoryCallData abstractHistoryCallData = (AbstractHistoryCallData)arrayList.get(i2);
            AbstractHistoryCallListRow abstractHistoryCallListRow = abstractHistoryCallData.getHistoryCallForGUIList();
            this.insertFirstToTiledListModel(this.getCallListModelId(), this.getCallListModelName(), abstractHistoryCallListRow);
        }
    }

    public void deleteHistoryCall(int n) {
        TiledListModelApp tiledListModelApp = this.getTiledListModel(this.getCallListModelId());
        EvoListRow evoListRow = tiledListModelApp.getRow(n);
        tiledListModelApp.remove(evoListRow);
        long l = tiledListModelApp.getLength() == 0 ? -1L : tiledListModelApp.getRow(0).getUniqueID();
        this.setFirstUniqueIdInCallList(l);
        TiledListModelApp tiledListModelApp2 = this.getTiledListModel(this.getResultListModelId());
        tiledListModelApp2.clearAll();
    }

    protected void defaultNewPoiResultsReceived(int n) {
        if (n > 0) {
            Object object;
            this.logChannel.log(-2137614336, "AbstractModelHandler#newPoiResultsReceived: with %1 pois", (long)n);
            AbstractHistoryCallData abstractHistoryCallData = this.listener.getData().getLatestHistoryCall();
            if (abstractHistoryCallData == null) {
                this.logChannel.log(10000, "AbstractModelHandler#newPoiResultsReceived: historyCallData is null!");
                return;
            }
            AbstractHistoryCallListRow abstractHistoryCallListRow = abstractHistoryCallData.getHistoryCallForGUIList();
            this.insertFirstToTiledListModel(this.getCallListModelId(), this.getCallListModelName(), abstractHistoryCallListRow);
            TiledListModelApp tiledListModelApp = this.getTiledListModel(this.getCallListModelId());
            int n2 = tiledListModelApp.getLength();
            if (n2 > this.listener.getMaxNumberOfCalls()) {
                for (int i2 = n2 - 1; i2 >= this.listener.getMaxNumberOfCalls(); --i2) {
                    object = tiledListModelApp.getRow(i2);
                    tiledListModelApp.remove((EvoListRow)object);
                }
            }
            EvoListRow[] evoListRowArray = abstractHistoryCallData.getPoisForGUIList();
            object = this.getTiledListModel(this.getResultListModelId());
            if (!this.listener.isResultListLastVisited() && n > 1) {
                object.removeAll();
                object.append(evoListRowArray);
                this.setChoiceValue(18686720, "OPERATOR_CALL_RESULT_CHOICE", 1);
            } else if (n == 1) {
                if (!this.listener.isResultListLastVisited()) {
                    object.removeAll();
                    object.append(evoListRowArray);
                }
                if (this.getChoiceStatus(5535) == 1 && this.isCurrentServiceTypeRunning()) {
                    this.logChannel.log(-2137614336, "CModelHandler#newPoiResultsReceived: start route guidance");
                    this.listener.poiSelected((PoiResultListRow)evoListRowArray[0]);
                } else {
                    this.logChannel.log(-2137614336, "CModelHandler#newPoiResultsReceived: don't start route guidance");
                }
                this.setChoiceValue(18686720, "OPERATOR_CALL_RESULT_CHOICE", 1);
            } else {
                this.listener.increaseLastCallFocusedIndex();
            }
        } else {
            this.logChannel.log(-2137614336, "CModelHandler#newPoiResultsReceived: show Thank you screen");
            this.setChoiceValue(18686720, "OPERATOR_CALL_RESULT_CHOICE", 0);
        }
        this.setChoiceStatus(-1759763712, "OPERATOR_DOWNLOAD_RESULT_CHOICE", 1);
        this.setChoiceValue(-1759763712, "OPERATOR_DOWNLOAD_RESULT_CHOICE", 0);
    }

    public void showDefaultError(boolean bl, int n) {
        this.logChannel.log(1078071040, "AbstractModelHandler#showDefaultError: showError = %1, errorType = %2", bl, (long)n);
        int n2 = this.getDownloadResultChoiceId();
        String string = this.getDownloadResultChoiceName();
        if (bl) {
            this.setChoiceStatus(n2, string, 1);
            this.setChoiceValue(n2, string, 1);
            if (n == 1) {
                this.listener.triggerSetDownloadPoisRunning(false);
                this.setChoiceDownloadActive(false);
            }
            this.listener.sendBAPSignal(106);
        } else {
            this.setChoiceStatus(n2, string, 0);
            this.setChoiceValue(n2, string, 0);
        }
    }

    public void setDownloadPoiResult(int n) {
        this.logChannel.log(1078071040, "AbstractModelHandler#setDownloadPoiResult can be overwritten by variants");
    }

    public void setCCPSettings(boolean bl, int n) {
        this.setConfirmCCPScreen(bl);
        if (this.listener.shouldPersistCCP()) {
            this.setCcpPermission(n);
        }
    }

    protected int getPhoneReadyChoiceValue() {
        return this.getChoiceValue(186);
    }
}

