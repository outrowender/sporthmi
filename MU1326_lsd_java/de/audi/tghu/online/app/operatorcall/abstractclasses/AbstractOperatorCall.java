/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.abstractclasses;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.event.DrawerEvent;
import de.audi.atip.interapp.online.OnlinePOICall;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.Online;
import de.audi.tghu.online.app.operatorcall.AbstractOperatorCallMain;
import de.audi.tghu.online.app.operatorcall.abstractclasses.AbstractCommand;
import de.audi.tghu.online.app.operatorcall.abstractclasses.AbstractModelHandler;
import de.audi.tghu.online.app.operatorcall.commands.AbortionErrorCommand;
import de.audi.tghu.online.app.operatorcall.commands.OperatorCallCommandList;
import de.audi.tghu.online.app.operatorcall.commands.OperatorCallCommandListManager;
import de.audi.tghu.online.app.operatorcall.data.AbstractHistoryCallListRow;
import de.audi.tghu.online.app.operatorcall.data.AbstractOperatorCallDataContainer;
import de.audi.tghu.online.app.operatorcall.data.PoiResultListRow;
import de.audi.tghu.online.app.operatorcall.handler.NavigationHandler;
import de.audi.tghu.online.app.operatorcall.handler.SDSHandler;
import de.audi.tghu.online.app.operatorcall.handler.TelephoneHandler;
import de.audi.tghu.online.app.operatorcall.services.OperatorCallModelHandlerCommon;
import de.audi.tghu.online.app.operatorcall.truffle.IntelliDestOperatorCallDataProvider;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.online.OperatorCallData;
import org.dsi.ifc.online.OperatorCallResult;

public abstract class AbstractOperatorCall {
    protected static final int ERRCODE_NUMBERDOWNLOAD_FAIL = 9;
    protected static final int ERRCODE_CONNECTION_LOST = 10;
    protected static final int ERRCODE_POIDOWNLOAD_FAIL = 11;
    protected OperatorCallCommandListManager cmdListMngr;
    protected IFrameworkAccess framework;
    protected final LogChannel logChannel = Online.getInstance().getOperatorCallLogChannel();
    private AbstractModelHandler modelHandler;
    protected NavigationHandler naviHandler;
    protected AbstractOperatorCallDataContainer data;
    protected AbstractOperatorCallMain distributor;
    protected boolean started;
    protected boolean applicationIsEnabled;
    public TelephoneHandler telHandler;
    protected boolean aborted;
    protected OperatorCallModelHandlerCommon operatorCall;
    protected boolean jokerkeyMode;
    protected int poiFocused = -1;
    protected boolean ignoreOldSessionForNextCall;
    protected boolean persistenceLoaded;
    private int historyCallFocused = -1;
    private boolean dialingTriggered;
    private boolean wasConnectedAtLeastOnce;
    private boolean isResultListLastVisitedList;
    protected OnlinePOICall onlineOperatorCallService;
    protected RemoteHMIService remoteHMIService;

    protected abstract AbstractModelHandler createModelHandler();

    public abstract int getServiceType();

    protected abstract boolean isReadyToEnableApplication(boolean var1, boolean var2, boolean var3, boolean var4);

    public abstract String getServiceTypeName();

    protected abstract OperatorCallData modifyCarData(OperatorCallData var1);

    public abstract int getDefaultPermissionToTransmitCcp();

    public abstract int getCurrentPermissionToTransmitCcp();

    public abstract void startRouteGuidance();

    public abstract void routeGuidanceCancelled();

    public abstract boolean shouldSendBAPSignalAnotherCallActive();

    public abstract boolean shouldSendBAPSignalGeneralError();

    public abstract boolean shouldSendBAPSignalNoSIM();

    public abstract boolean shouldCloseLeftDrawerAfterStartingWithJokerkey();

    public abstract void startOperatorCallByJokerKey();

    protected abstract boolean shouldPersistLists();

    protected abstract boolean shouldPersistCCP();

    protected abstract AbstractOperatorCallDataContainer createNewOperatorCallDataContainer(IntelliDestOperatorCallDataProvider var1);

    protected abstract int getMaxNumberOfPoisPerCall();

    public abstract int getMaxNumberOfCalls();

    public AbstractOperatorCall(AbstractOperatorCallMain abstractOperatorCallMain, TelephoneHandler telephoneHandler, OperatorCallCommandListManager operatorCallCommandListManager, NavigationHandler navigationHandler, IFrameworkAccess iFrameworkAccess, OperatorCallModelHandlerCommon operatorCallModelHandlerCommon, IntelliDestOperatorCallDataProvider intelliDestOperatorCallDataProvider, OnlinePOICall onlinePOICall, RemoteHMIService remoteHMIService) {
        this.distributor = abstractOperatorCallMain;
        this.telHandler = telephoneHandler;
        this.cmdListMngr = operatorCallCommandListManager;
        this.naviHandler = navigationHandler;
        this.framework = iFrameworkAccess;
        this.operatorCall = operatorCallModelHandlerCommon;
        this.onlineOperatorCallService = onlinePOICall;
        this.logChannel.log(10000000, "AbstractOperatorCall#init: init with remoteHMIService=%1, onlineOperatorCallService=%2.", (Object)remoteHMIService, (Object)onlinePOICall);
        this.remoteHMIService = remoteHMIService;
        this.init(intelliDestOperatorCallDataProvider);
    }

    public void init(IntelliDestOperatorCallDataProvider intelliDestOperatorCallDataProvider) {
        int n;
        this.modelHandler = this.createModelHandler();
        this.data = this.createNewOperatorCallDataContainer(intelliDestOperatorCallDataProvider);
        if (this.shouldPersistCCP()) {
            n = this.data.getTransmitCcpCheckboxCheckedFromPersistence();
            if (n == -1 || n == -2) {
                n = this.getDefaultPermissionToTransmitCcp();
            }
        } else {
            n = this.getDefaultPermissionToTransmitCcp();
        }
        this.modelHandler.setCCPSettings(true, n);
    }

    public final OperatorCallCommandListManager getCommandListManager() {
        return this.cmdListMngr;
    }

    public final AbstractModelHandler getModelHandler() {
        return this.modelHandler;
    }

    public final AbstractOperatorCallDataContainer getData() {
        return this.data;
    }

    protected final IFrameworkAccess getFramework() {
        return this.framework;
    }

    public final AbstractOperatorCallMain getOperatorCall() {
        return this.distributor;
    }

    public final void asyncException(int n, String string, int n2) {
    }

    public final void responseOperatorPhoneNumber(int n, String string, String[] stringArray, int n2, OperatorCallCommandList operatorCallCommandList, boolean bl) {
        this.logChannel.log(1000000, "AbstractOperatorCall#responseOperatorPhoneNumber: gotResponse!");
        switch (n) {
            case 1: {
                this.logChannel.log(1000000, "AbstractOperatorCall#responseOperatorPhoneNumber: NewSession!");
                this.data.savePhoneData(string, stringArray, n2);
                operatorCallCommandList.commandFinished();
                break;
            }
            case 0: {
                this.logChannel.log(1000000, "AbstractOperatorCall#responseOperatorPhoneNumber: OldSession! -> Waiting for user interaction");
                this.setCallStarted(false);
                if (!bl) {
                    this.modelHandler.setOldSession(true);
                    this.replyToSDS(3);
                    operatorCallCommandList.setErrorCommand(new AbortionErrorCommand());
                    operatorCallCommandList.commandAborted("AbstractOperatorCall#responseOperatorPhoneNumber: Oldsession", "AbstractOperatorCall#responseOperatorPhoneNumber: Oldsession");
                    break;
                }
                this.logChannel.log(100000, "AbstractOperatorCall#responseOperatorPhoneNumber: OldSession! ignoreSession = %1 -> internal error occured", bl);
                this.replyToSDS(6);
                operatorCallCommandList.commandAborted("AbstractOperatorCall#responseOperatorPhoneNumber: oldSession -> internal error occured", "AbstractOperatorCall#responseOperatorPhoneNumber: oldSession -> internal error occured");
                break;
            }
            case 2: {
                this.setCallRunning(false);
                this.replyToSDS(1);
                this.modelHandler.setCurrentState(10);
                operatorCallCommandList.commandAborted("AbstractOperatorCall#responseOperatorPhoneNumber: connection error -> error resultType", "AbstractOperatorCall#responseOperatorPhoneNumber: connection error -> error resultType");
                break;
            }
            case 4: {
                this.setCallRunning(false);
                this.replyToSDS(7);
                this.modelHandler.setCurrentState(9);
                operatorCallCommandList.commandAborted("AbstractOperatorCall#responseOperatorPhoneNumber: server error -> error resultType", "AbstractOperatorCall#responseOperatorPhoneNumber: server error -> error resultType");
                break;
            }
            default: {
                this.setCallRunning(false);
                this.replyToSDS(6);
                this.modelHandler.setCurrentState(9);
                Buffer buffer = new Buffer("AbstractOperatorCall#responseOperatorPhoneNumber: resultType is unknown ( ");
                buffer.append(n);
                buffer.append(" -> error resultType");
                operatorCallCommandList.commandAborted(buffer.toString(), buffer.toString());
            }
        }
    }

    public void responseOperatorCallResult(int n, OperatorCallResult[] operatorCallResultArray) {
        this.distributor.setDownloadPoisRunning(false);
        this.modelHandler.setJokerKeyBackBehaviour(false);
        switch (n) {
            case 1: {
                OperatorCallResult[] operatorCallResultArray2;
                if (operatorCallResultArray != null) {
                    this.logChannel.log(1000000, "AbstractOperatorCall#responseOperatorCallResult: Pois received:");
                    operatorCallResultArray2 = new Buffer();
                    for (int i2 = 0; i2 < operatorCallResultArray.length; ++i2) {
                        operatorCallResultArray2.append("________________________");
                        operatorCallResultArray2.append(i2 + 1);
                        operatorCallResultArray2.append(". Result:\n");
                        operatorCallResultArray2.append(operatorCallResultArray[i2]);
                        this.logChannel.log(1000000, "AbstractOperatorCall#responseOperatorCallResult: original pois from backend: %1", (Object)operatorCallResultArray2.toString());
                    }
                }
                if (operatorCallResultArray != null && operatorCallResultArray.length > 0) {
                    operatorCallResultArray2 = operatorCallResultArray;
                    operatorCallResultArray2 = this.data.modifyResultsToValidResults(operatorCallResultArray2);
                    this.data.setNewPoiResults(operatorCallResultArray2);
                    this.modelHandler.newPoiResultsReceived(operatorCallResultArray2.length);
                    this.modelHandler.showPartialPopupPoiReceived();
                    break;
                }
                this.modelHandler.newPoiResultsReceived(0);
                break;
            }
            case 0: {
                this.replyToSDS(6);
                this.modelHandler.setCurrentState(11);
                this.getCommandList().commandAborted("AbstractOperatorCall#responseOperatorCallResult: resulttype is oldsession.", "AbstractOperatorCall#responseOperatorCallResult: resulttype is oldSession.");
                break;
            }
            case 3: {
                this.replyToSDS(7);
                this.modelHandler.setCurrentState(11);
                this.getCommandList().commandAborted("AbstractOperatorCall#responseOperatorCallResult: resulttype is invalidSession.", "AbstractOperatorCall#responseOperatorCallResult: resulttype is invalidSession.");
                break;
            }
            case 2: {
                this.replyToSDS(1);
                this.modelHandler.setCurrentState(10);
                this.getCommandList().commandAborted("AbstractOperatorCall#responseOperatorCallResult: resulttype is connection error.", "AbstractOperatorCall#responseOperatorCallResult: resulttype is connection error.");
                break;
            }
            case 4: {
                this.replyToSDS(7);
                this.modelHandler.setCurrentState(11);
                this.getCommandList().commandAborted("AbstractOperatorCall#responseOperatorCallResult: resulttype is server error.", "AbstractOperatorCall#responseOperatorCallResult: resulttype is server error.");
                break;
            }
            default: {
                this.replyToSDS(6);
                Buffer buffer = new Buffer("AbstractOperatorCall#responseOperatorCallResult: resulttype is unknown (");
                buffer.append(n);
                buffer.append(") .");
                this.modelHandler.setCurrentState(11);
                this.getCommandList().commandAborted(buffer.toString(), buffer.toString());
            }
        }
        this.modelHandler.setDownloadActive(false);
    }

    public void setTransmissionOfCcp(int n) {
        boolean bl = true;
        this.logChannel.log(1000000, "AbstractOperatorCall#setTransmissionOfCcp: transmissionSet = %1, transmissionPermission = %2", bl, (long)n);
        this.modelHandler.setCCPSettings(bl, n);
        if (this.shouldPersistCCP()) {
            this.data.saveCCPInPersistence(n);
        }
    }

    public void setCallStarted(boolean bl) {
        this.logChannel.log(1000000, "AbstractOperatorCall#userStartsCall: %1 -> %2", this.started, bl);
        this.started = bl;
        this.setCallRunning(bl);
    }

    public void tryToStartCall() {
        this.logChannel.log(1000000, "AbstractOperatorCall#tryToStartCall");
        if (this.isApplicationEnabled() && this.hasUserStartedCall()) {
            this.telHandler.deleteTelListener();
            if (this.isTransmissionOfCcpSet()) {
                OperatorCallData operatorCallData = this.getCarPositionData(this.modelHandler.isTransmissionOfCcpPermitted());
                operatorCallData = this.modifyCarData(operatorCallData);
                this.cmdListMngr.startFullSequence(operatorCallData, this);
            } else {
                this.logChannel.log(10000000, "AbstractOperatorCall#tryToStartCall: transmission of ccp is not set. User has to set the transmission permission.");
            }
        } else {
            if (!this.isApplicationEnabled()) {
                this.logChannel.log(10000000, "AbstractOperatorCall#tryToStartCall: application is not enabled yet!");
            }
            if (!this.hasUserStartedCall()) {
                this.logChannel.log(10000000, "AbstractOperatorCall#tryToStartCall: user didn't start call yet!");
            }
        }
    }

    public void muteCall(boolean bl) {
        this.telHandler.muteMicrophone(bl);
    }

    private boolean isTransmissionOfCcpSet() {
        return !this.modelHandler.isConfirmCCPScreenShown();
    }

    private boolean isApplicationEnabled() {
        return this.applicationIsEnabled;
    }

    protected boolean hasUserStartedCall() {
        return this.started;
    }

    public void enable(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        boolean bl5;
        this.logChannel.log(1000000, "AbstractOperatorCall#enable: %1 | %2 | %3 (dsi | navi | tel )", bl, bl2, bl3);
        this.applicationIsEnabled = bl5 = this.isReadyToEnableApplication(bl, bl2, bl3, bl4);
        this.modelHandler.enableApplication(bl5);
        this.modelHandler.enableFeatures(bl, bl2, bl3, bl4);
    }

    public OperatorCallData getCarPositionData(boolean bl) {
        return this.naviHandler.getCarPositionData(bl);
    }

    public void setWelcomeScreen(boolean bl) {
        this.modelHandler.setWelcomeScreen(bl);
    }

    public void setDownloadPoisRunning(boolean bl) {
        this.modelHandler.setDownloadPoisRunning(bl);
    }

    public void setCallRunning(boolean bl) {
        this.modelHandler.setCallRunning(bl);
    }

    public boolean isCallRunning() {
        return this.modelHandler.isCallRunning();
    }

    protected OperatorCallCommandList getCommandList() {
        return this.cmdListMngr.getCommandList();
    }

    public void resetCallInformation() {
        this.modelHandler.resetCallInformation();
    }

    public String getFirstPhoneNumber() {
        return this.data.getFirstPhoneNumber();
    }

    public void callConnected() {
        if (!this.modelHandler.isCallActive()) {
            this.setAtLeastOnceCallConnected(true);
            this.setIgnoreOldSessionForNextCall(false);
            this.setOperatorCallInUse(true);
            this.modelHandler.setCallActive(true);
            this.replyToSDS(0);
            OperatorCallCommandList operatorCallCommandList = this.getCommandList();
            AbstractCommand abstractCommand = null;
            if (operatorCallCommandList != null) {
                abstractCommand = (AbstractCommand)operatorCallCommandList.getActiveCommand();
            }
            if (abstractCommand != null && "DialNumber".equalsIgnoreCase(abstractCommand.getName())) {
                this.getCommandList().commandFinished();
                this.logChannel.log(10000000, "AbstractOperatorCall#callConnected: dial command end");
            }
            this.logChannel.log(10000000, "AbstractOperatorCall#callConnected: Show screen Connected");
        }
    }

    private boolean wasConnectedAtLeastOnce() {
        return this.wasConnectedAtLeastOnce;
    }

    protected void setAtLeastOnceCallConnected(boolean bl) {
        this.logChannel.log(1000000, "AbstractOperatorCall#setAtLeastOnceCallConnected: %1 -> %2", this.wasConnectedAtLeastOnce, bl);
        this.wasConnectedAtLeastOnce = bl;
    }

    public void callDisconnected() {
        if (!this.wasConnectedAtLeastOnce()) {
            this.abortConnection(this.getCommandList());
        } else {
            this.distributor.setDownloadPoisRunning(true);
            this.modelHandler.setDownloadActive(true);
            this.logChannel.log(10000000, "AbstractOperatorCall#callDisconnected: Show screen Fetching Data ...");
            this.getCommandList().commandFinished();
        }
        this.setAtLeastOnceCallConnected(false);
        this.setCallStarted(false);
        this.logChannel.log(1000000, "AbstractOperatorCall#callDisconnected setCallStarted called. setCallActive to listener: %1", (Object)this.modelHandler);
        this.modelHandler.setCallActive(false);
        this.setOperatorCallInUse(false);
    }

    public boolean getLastCallAborted() {
        return this.ignoreOldSessionForNextCall;
    }

    public void updateCallInformation(int n) {
        this.modelHandler.setDuration(n);
    }

    public void abortConnectionBeforeTelConnectionEstablished() {
        this.logChannel.log(1000000, "AbstractOperatorCall#abortConnectionBeforeTelConnectionEstablished was called");
        OperatorCallCommandList operatorCallCommandList = this.getCommandList();
        AbstractCommand abstractCommand = null;
        if (operatorCallCommandList != null) {
            abstractCommand = (AbstractCommand)operatorCallCommandList.getActiveCommand();
        }
        if (abstractCommand == null || "DownloadNumber".equalsIgnoreCase(abstractCommand.getName())) {
            this.abortConnection(operatorCallCommandList);
        } else if ("DialNumber".equalsIgnoreCase(abstractCommand.getName())) {
            if (!this.telHandler.isDialNumberTriggered()) {
                this.abortConnection(operatorCallCommandList);
            } else {
                operatorCallCommandList.setErrorCommand(new AbortionErrorCommand());
                operatorCallCommandList.commandAborted("AbstractOperatorCall#abortConnectionBeforeTelConnectionEstablished: hangup while dialing", "AbstractOperatorCall#abortConnectionBeforeTelConnectionEstablished: hangup while dialing");
                this.cmdListMngr.abortCall(this);
            }
        }
    }

    public void abortConnection(OperatorCallCommandList operatorCallCommandList) {
        this.logChannel.log(1000000, "AbstractOperatorCall#abortConnection: call has been aborted");
        if (operatorCallCommandList != null) {
            AbstractCommand abstractCommand = (AbstractCommand)operatorCallCommandList.getActiveCommand();
            if (abstractCommand != null && "Hangup".equalsIgnoreCase(abstractCommand.getName())) {
                operatorCallCommandList.commandFinished();
                this.logChannel.log(10000000, "AbstractOperatorCall#abortConnection: call has been aborted while command hangup");
            } else {
                operatorCallCommandList.setErrorCommand(new AbortionErrorCommand());
                operatorCallCommandList.commandAborted("AbstractOperatorCall#abortConnection: Connection aborted by user", "AbstractOperatorCall#abortConnection: Connection aborted by user");
            }
        }
        this.getSdsListener().replyToSDS(5);
        this.setIgnoreOldSessionForNextCall(true);
        this.modelHandler.triggerAbortConnection();
        this.leaveJokerKeyMode();
    }

    private void setIgnoreOldSessionForNextCall(boolean bl) {
        this.logChannel.log(10000000, "AbstractOperatorCall#setIgnoreOldSessionForNextCall: %1->%2", this.ignoreOldSessionForNextCall, bl);
        this.ignoreOldSessionForNextCall = bl;
    }

    protected SDSHandler getSdsListener() {
        return this.distributor.getSdsHandler();
    }

    public void hangup() {
        this.getCommandList().setErrorCommand(new AbortionErrorCommand());
        this.getCommandList().commandAborted("AbstractOperatorCall#hangup: hangup call when calling", "AbstractOperatorCall#hangup: hangup call when calling");
        this.cmdListMngr.hangupAndDownloadPoi(this);
    }

    public String getServiceId() {
        return this.data.getServiceId();
    }

    public void startDownloadPoi() {
        this.distributor.setDownloadPoisRunning(true);
        this.cmdListMngr.startDownloadPoi(this);
    }

    public void startNewCall() {
        this.logChannel.log(1000000, "AbstractOperatorCall#startNewCall");
        this.telHandler.deleteTelListener();
        this.setCallStarted(true);
        OperatorCallData operatorCallData = this.getCarPositionData(this.modelHandler.isTransmissionOfCcpPermitted());
        operatorCallData = this.modifyCarData(operatorCallData);
        this.cmdListMngr.startNewCall(operatorCallData, this);
    }

    public void setDownloadRunning(boolean bl) {
        this.distributor.setDownloadPoisRunning(bl);
    }

    public void replyToSDS(int n) {
        this.distributor.getSdsHandler().replyToSDS(n);
    }

    public int getCurrentServiceType() {
        return this.operatorCall.getCurrentServiceType();
    }

    public void showLocationsInPreviewMap(int n) {
        NavLocationWgs84[] navLocationWgs84Array = this.data.getResultLocationsForPreviewMap(n);
        this.naviHandler.showPreviewMap(navLocationWgs84Array);
    }

    public void showLocationInPreviewMap(int n, int n2) {
        NavLocationWgs84 navLocationWgs84 = this.data.getResultLocationForPreviewMap(n, n2);
        this.naviHandler.showPreviewMap(navLocationWgs84);
    }

    public boolean isAnotherOperatorCallRunning() {
        return this.distributor.isAnotherOperatorCallRunning(this.getServiceType());
    }

    public boolean isAnotherCallRunning() {
        return this.modelHandler.isAnotherCallRunning();
    }

    public void leaveJokerKeyMode() {
        this.logChannel.log(1000000, "AbstractOperatorCall#leaveJokerKeyMode called");
        this.setJokerKeyMode(false);
        this.modelHandler.setJokerKeyBackBehaviour(false);
    }

    public boolean isTelephoneReady() {
        return this.modelHandler.isTelephoneReady();
    }

    public void enterJokerKeyMode(int n, int n2, int n3) {
        this.logChannel.log(1000000, "AbstractOperatorCall#jokerKeyPressed: called");
        this.modelHandler.saveModelData(n, n3);
        this.modelHandler.setModelName("JOKER1ONLINE_BUTTON");
        if (this.modelHandler.isJokerKeyFunctionalityAvailable()) {
            this.setJokerKeyMode(true);
            this.modelHandler.setJokerKeyBackBehaviour(true);
            this.startOperatorCallByJokerKey();
            if (this.shouldCloseLeftDrawerAfterStartingWithJokerkey()) {
                this.logChannel.log(10000000, "AbstractOperatorCall#enterJokerKeyMode: closing left drawer ...");
                HMIService hMIService = this.framework.getHMIService();
                DrawerEvent drawerEvent = new DrawerEvent(hMIService.getRootWindow(0), 1);
                hMIService.getEventDispatcher().postEvent(drawerEvent);
            }
            this.logChannel.log(1000000, "AbstractOperatorCall#enterJokerKeyMode: waiting for AP-call checksSuccessful");
        } else {
            this.logChannel.log(100000, "AbstractOperatorCall#jokerKeyPressed: Ignoring jokerkey.");
        }
    }

    protected void setJokerKeyMode(boolean bl) {
        this.logChannel.log(1000000, "AbstractOperatorCall#setJokerKeyMode: %1 -> %2", this.jokerkeyMode, bl);
        this.jokerkeyMode = bl;
    }

    public boolean isJokerKeyMode() {
        return this.jokerkeyMode;
    }

    public void checksSuccessful() {
        this.modelHandler.checksSuccessful();
    }

    public boolean poiSelected(PoiResultListRow poiResultListRow) {
        return this.naviHandler.poiSelected(poiResultListRow, this);
    }

    public void setLastCallFocused(int n) {
        this.logChannel.log(10000000, "AbstractOperatorCall#setLastCallFocused: %1 -> %2", (long)this.historyCallFocused, (long)n);
        this.historyCallFocused = n;
    }

    public void setLastPoiFocused(int n) {
        this.logChannel.log(10000000, "AbstractOperatorCall#setLastPoiFocused: %1 -> %2", (long)this.poiFocused, (long)n);
        this.poiFocused = n;
    }

    protected OperatorCallResult getLastFocusedPoi() {
        AbstractOperatorCallDataContainer abstractOperatorCallDataContainer = this.getData();
        if (this.historyCallFocused != -1) {
            int n = abstractOperatorCallDataContainer.getNumberOfPois(this.historyCallFocused);
            if (n == 1) {
                this.setLastPoiFocused(0);
                return abstractOperatorCallDataContainer.getOperatorCallResult(this.historyCallFocused, 0);
            }
            return abstractOperatorCallDataContainer.getOperatorCallResult(this.historyCallFocused, this.poiFocused);
        }
        if (this.poiFocused != -1) {
            this.setLastCallFocused(0);
            return abstractOperatorCallDataContainer.getOperatorCallResult(0, this.poiFocused);
        }
        this.logChannel.log(100000, "AbstractOperatorCall#getLastFocusedItem: No last focused item! This should never happen!");
        return null;
    }

    protected int getLastFocusedHistoryCall() {
        return this.historyCallFocused;
    }

    public AbstractHistoryCallListRow getHistoryCallForList(int n) {
        return this.getData().getHistoryCallForList(n);
    }

    public void addToFavorite() {
        this.logChannel.log(1000000, "AbstractOperatorCall#addToFavorite called");
        OperatorCallResult operatorCallResult = this.getLastFocusedPoi();
        boolean bl = this.naviHandler.addToFavorite(operatorCallResult);
        if (!bl) {
            this.modelHandler.showDefaultError(true, 2);
        } else {
            this.modelHandler.fireButtonEvent();
        }
    }

    public void addToContact() {
        this.logChannel.log(1000000, "AbstractOperatorCall#addToContact called");
        OperatorCallResult operatorCallResult = this.getLastFocusedPoi();
        boolean bl = this.naviHandler.addToContact(operatorCallResult);
        if (!bl) {
            this.modelHandler.showDefaultError(true, 2);
        } else {
            this.modelHandler.fireButtonEvent();
        }
    }

    public void deleteThisHistory() {
        this.logChannel.log(1000000, "AbstractOperatorCall#deleteThisHistory called");
        int n = this.getLastFocusedHistoryCall();
        this.data.deleteHistoryCall(n);
        this.modelHandler.deleteHistoryCall(n);
        this.saveCallsInTruffles();
    }

    public void deleteAllCalls(boolean bl) {
        this.logChannel.log(1000000, "AbstractOperatorCall#deleteAllCalls called");
        this.getData().deleteAllHistoryCalls();
        this.modelHandler.clearAllLists();
        if (bl) {
            this.modelHandler.fireButtonEvent();
        }
        this.saveCallsInTruffles();
    }

    public void showDetails() {
        this.logChannel.log(1000000, "AbstractOperatorCall#showDetails called");
        OperatorCallResult operatorCallResult = this.getLastFocusedPoi();
        boolean bl = this.naviHandler.showDetails(operatorCallResult);
        if (!bl) {
            this.modelHandler.setCurrentState(11);
            this.modelHandler.showDefaultError(true, 2);
        } else {
            this.modelHandler.fireButtonEvent();
        }
    }

    public void showInMap() {
        this.logChannel.log(1000000, "AbstractOperatorCall#showInMap called");
        OperatorCallResult operatorCallResult = this.getLastFocusedPoi();
        boolean bl = this.naviHandler.showInMap(operatorCallResult, this.getServiceType());
        if (!bl) {
            this.modelHandler.setCurrentState(11);
            this.modelHandler.showDefaultError(true, 2);
        } else {
            this.modelHandler.fireButtonEvent();
        }
    }

    public void operatorCallCenterLeft() {
        this.logChannel.log(1000000, "AbstractOperatorCall#operatorCallCenterLeft called");
        this.leaveJokerKeyMode();
    }

    public void operatorEndMsgLeft() {
        this.modelHandler.confirmButtonPressed();
    }

    public void setOption(boolean bl) {
        this.modelHandler.setOption(bl);
    }

    public void operatorUpdateDetailInfo() {
        this.showDetails();
    }

    public void getDataFromPersistence() {
        if (this.shouldPersistLists() && !this.persistenceLoaded) {
            ArrayList arrayList = this.data.getDataFromPersistence();
            this.modelHandler.fillListWithDataFromPersistence(arrayList);
            this.persistenceLoaded = true;
            this.saveCallsInTruffles();
        }
    }

    public void showCcpInMap() {
        this.naviHandler.showCcpInMap();
    }

    public void triggerJumpToNavi() {
        this.modelHandler.triggerJumpToNavi();
    }

    public void setDialingNumberTriggered(boolean bl) {
        this.logChannel.log(10000000, "AbstractOperatorCall#setDialingNumberTriggered: %1 -> %2", this.getDialingNumberTriggered(), bl);
        this.dialingTriggered = bl;
    }

    private boolean getDialingNumberTriggered() {
        return this.dialingTriggered;
    }

    public void triggerSetDownloadPoisRunning(boolean bl) {
        this.distributor.setDownloadPoisRunning(bl);
    }

    public void userStartsNormalCall() {
        this.setCallStarted(true);
        this.tryToStartCall();
    }

    public void sendBAPSignal(int n) {
        this.logChannel.log(1000000, "AbstractOperatorCall#sendBAPSignal: trying to send signal %1", (long)n);
        if (!this.isJokerKeyMode()) {
            this.logChannel.log(10000000, "AbstractOperatorCall#sendBAPSignal: jokerkey is not on: signal %1 not sent", (long)n);
            return;
        }
        switch (n) {
            case 104: {
                if (this.shouldSendBAPSignalAnotherCallActive()) break;
                this.logChannel.log(10000000, "AbstractOperatorCall#sendBAPSignal: signal %1 not sent", (long)n);
                return;
            }
            case 105: {
                if (this.shouldSendBAPSignalNoSIM()) break;
                this.logChannel.log(10000000, "AbstractOperatorCall#sendBAPSignal: signal %1 not sent", (long)n);
                return;
            }
            case 106: {
                if (this.shouldSendBAPSignalGeneralError()) break;
                this.logChannel.log(10000000, "AbstractOperatorCall#sendBAPSignal: signal %1 not sent", (long)n);
                return;
            }
            default: {
                this.logChannel.log(100000, "AbstractOperatorCall#sendBAPSignal: signal(%1) not defined for operator call. BAP-Signal not sent!", (long)n);
                return;
            }
        }
        this.logChannel.log(1000000, "AbstractOperatorCall#sendBAPSignal: signal %1 sent", (long)n);
        this.distributor.sendBAPSignal(n);
    }

    public void callActiveShown() {
        this.sendBAPSignal(104);
    }

    public void setResultListLastVisited(boolean bl) {
        this.logChannel.log(10000000, "AbstractOperatorCall#setResultListLastVisited: %1 -> %2", this.isResultListLastVisitedList, bl);
        this.isResultListLastVisitedList = bl;
    }

    public boolean isResultListLastVisited() {
        return this.isResultListLastVisitedList;
    }

    public void increaseLastCallFocusedIndex() {
        this.setLastCallFocused(this.getLastFocusedHistoryCall() + 1);
    }

    public void setCurrentCallStatus(int n) {
    }

    public void resetCCP() {
        this.logChannel.log(1000000, "AbstractOperatorCall#resetCCP: reset ccp");
        this.setTransmissionOfCcp(this.getDefaultPermissionToTransmitCcp());
    }

    public abstract boolean isTrufflesAvailable();

    public void saveCallsInTruffles() {
        if (this.isTrufflesAvailable()) {
            this.data.saveCallsInTruffle();
        }
    }

    public void refreshList() {
        this.logChannel.log(1000000, "AbstractOperatorCall#refreshList: not implemented");
    }

    private void setOperatorCallInUse(boolean bl) {
        if (this.onlineOperatorCallService == null) {
            this.logChannel.log(1000000, "AbstractOperatorCall#setOperatorCallInUse: onlineOperatorCallService was null! Trying to get onlineOperatorCallService....");
            if (this.remoteHMIService != null) {
                this.onlineOperatorCallService = this.remoteHMIService.getOnlineOperatorCallService();
                this.logChannel.log(1000000, "AbstractOperatorCall#setOperatorCallInUse: onlineOperatorCallService=%1.", (Object)this.onlineOperatorCallService);
            } else {
                this.logChannel.log(10000, "AbstractOperatorCall#setOperatorCallInUse: remoteHMIService is null!");
            }
        }
        if (this.onlineOperatorCallService != null) {
            this.triggerUpdatePOICall(bl);
        } else {
            this.logChannel.log(100000, "AbstractOperatorCall#setOperatorCallInUse: could not set inUse to '%1', because onlineOperatorCallService is null.", (Object)Boolean.toString(bl));
        }
    }

    protected void triggerUpdatePOICall(boolean bl) {
        this.logChannel.log(10000000, "AbstractOperatorCall#setOperatorCallInUse: trying to set inUse to '%1'.", (Object)Boolean.toString(bl));
        this.onlineOperatorCallService.updatePOICall(bl);
        this.logChannel.log(1000000, "AbstractOperatorCall#setOperatorCallInUse: set inUse to '%1'.", (Object)Boolean.toString(bl));
    }
}

