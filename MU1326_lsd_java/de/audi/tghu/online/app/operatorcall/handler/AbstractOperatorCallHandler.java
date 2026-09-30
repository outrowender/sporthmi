/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.handler;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.interapp.online.OnlinePOICall;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.online.app.Online;
import de.audi.tghu.online.app.operatorcall.AbstractOperatorCallMain;
import de.audi.tghu.online.app.operatorcall.abstractclasses.AbstractOperatorCall;
import de.audi.tghu.online.app.operatorcall.commands.OperatorCallCommandList;
import de.audi.tghu.online.app.operatorcall.commands.OperatorCallCommandListManager;
import de.audi.tghu.online.app.operatorcall.handler.NavigationHandler;
import de.audi.tghu.online.app.operatorcall.handler.TelephoneHandler;
import de.audi.tghu.online.app.operatorcall.services.AbstractBreakdownCall;
import de.audi.tghu.online.app.operatorcall.services.AbstractConciergeCall;
import de.audi.tghu.online.app.operatorcall.services.AbstractPoiCall;
import de.audi.tghu.online.app.operatorcall.services.OperatorCallModelHandlerCommon;
import de.audi.tghu.online.app.operatorcall.truffle.IntelliDestOperatorCallDataProvider;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;

public abstract class AbstractOperatorCallHandler {
    private AbstractBreakdownCall bCall;
    private AbstractPoiCall pCall;
    private AbstractConciergeCall cCall;
    protected final LogChannel logChannel = Online.getInstance().getOperatorCallLogChannel();
    protected OperatorCallModelHandlerCommon operatorCallModelHandlerCommon;

    protected abstract AbstractConciergeCall createConciergeCall(AbstractOperatorCallMain var1, TelephoneHandler var2, OperatorCallCommandListManager var3, NavigationHandler var4, IFrameworkAccess var5, IntelliDestOperatorCallDataProvider var6, OnlinePOICall var7, RemoteHMIService var8);

    protected abstract AbstractPoiCall createPoiCall(AbstractOperatorCallMain var1, TelephoneHandler var2, OperatorCallCommandListManager var3, NavigationHandler var4, IFrameworkAccess var5, IntelliDestOperatorCallDataProvider var6, OnlinePOICall var7, RemoteHMIService var8);

    protected abstract AbstractBreakdownCall createBreakdownCall(AbstractOperatorCallMain var1, TelephoneHandler var2, OperatorCallCommandListManager var3, NavigationHandler var4, IFrameworkAccess var5, OperatorCallModelHandlerCommon var6, IntelliDestOperatorCallDataProvider var7, OnlinePOICall var8, RemoteHMIService var9);

    public AbstractOperatorCallHandler(AbstractOperatorCallMain abstractOperatorCallMain, TelephoneHandler telephoneHandler, OperatorCallCommandListManager operatorCallCommandListManager, NavigationHandler navigationHandler, IFrameworkAccess iFrameworkAccess, IntelliDestOperatorCallDataProvider intelliDestOperatorCallDataProvider, OnlinePOICall onlinePOICall, RemoteHMIService remoteHMIService) {
        this.logChannel.log(10000000, "AbstractOperatorCallHandler#init remoteHMIService=%1", (Object)remoteHMIService);
        this.operatorCallModelHandlerCommon = new OperatorCallModelHandlerCommon(iFrameworkAccess.getHMIService(), telephoneHandler);
        this.bCall = this.createBreakdownCall(abstractOperatorCallMain, telephoneHandler, operatorCallCommandListManager, navigationHandler, iFrameworkAccess, this.operatorCallModelHandlerCommon, intelliDestOperatorCallDataProvider, onlinePOICall, remoteHMIService);
        this.pCall = this.createPoiCall(abstractOperatorCallMain, telephoneHandler, operatorCallCommandListManager, navigationHandler, iFrameworkAccess, intelliDestOperatorCallDataProvider, onlinePOICall, remoteHMIService);
        this.cCall = this.createConciergeCall(abstractOperatorCallMain, telephoneHandler, operatorCallCommandListManager, navigationHandler, iFrameworkAccess, intelliDestOperatorCallDataProvider, onlinePOICall, remoteHMIService);
    }

    public AbstractOperatorCall getOperatorCall(int n) {
        switch (n) {
            case 0: {
                return this.bCall;
            }
            case 2: {
                return this.pCall;
            }
            case 1: {
                return this.cCall;
            }
        }
        this.logChannel.log(100000, "AbstractOperatorCallHandler#getOperatorCall: serviceType (%1) is unknown!", (long)n);
        return null;
    }

    public void enableServices(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        if (this.bCall != null) {
            this.bCall.enable(bl, bl2, bl3, bl4);
        }
        if (this.pCall != null) {
            this.pCall.enable(bl, bl2, bl3, bl4);
        }
        if (this.cCall != null) {
            this.cCall.enable(bl, bl2, bl3, bl4);
        }
    }

    public OperatorCallCommandList getDsiListener() {
        OperatorCallCommandList operatorCallCommandList = this.getOperatorCallCommandList(this.bCall);
        if (operatorCallCommandList == null && (operatorCallCommandList = this.getOperatorCallCommandList(this.pCall)) == null) {
            return this.getOperatorCallCommandList(this.cCall);
        }
        return operatorCallCommandList;
    }

    private OperatorCallCommandList getOperatorCallCommandList(AbstractOperatorCall abstractOperatorCall) {
        CommandList commandList = null;
        OperatorCallCommandListManager operatorCallCommandListManager = null;
        if (abstractOperatorCall == null) {
            return null;
        }
        operatorCallCommandListManager = abstractOperatorCall.getCommandListManager();
        if (operatorCallCommandListManager == null) {
            return null;
        }
        commandList = operatorCallCommandListManager.getActiveCommandList();
        if (commandList == null) {
            return null;
        }
        return (OperatorCallCommandList)commandList;
    }

    public void setWelcomeScreen(int n, boolean bl) {
        this.getOperatorCall(n).setWelcomeScreen(bl);
    }

    public String getServiceTypeName(int n) {
        return this.getOperatorCall(n).getServiceTypeName();
    }

    public void setDownloadPoisRunning(boolean bl) {
        if (this.bCall != null) {
            this.bCall.setDownloadPoisRunning(bl);
        }
        if (this.pCall != null) {
            this.pCall.setDownloadPoisRunning(bl);
        }
        if (this.cCall != null) {
            this.cCall.setDownloadPoisRunning(bl);
        }
    }

    public void setCurrentServiceType(int n) {
        this.operatorCallModelHandlerCommon.setCurrentServiceType(n);
    }

    public void deleteCurrentServiceType() {
        this.operatorCallModelHandlerCommon.deleteCurrentServiceType();
    }

    public boolean isAnotherOperatorCallRunning(int n) {
        switch (n) {
            case 0: {
                return this.isCallRunning(this.pCall) || this.isCallRunning(this.cCall);
            }
            case 2: {
                return this.isCallRunning(this.bCall) || this.isCallRunning(this.cCall);
            }
        }
        return this.isCallRunning(this.pCall) || this.isCallRunning(this.bCall);
    }

    private boolean isCallRunning(AbstractOperatorCall abstractOperatorCall) {
        if (abstractOperatorCall != null) {
            return abstractOperatorCall.isCallRunning();
        }
        return false;
    }

    public void startOperatorCallByJokerKey(int n, int n2, int n3, int n4) {
        AbstractOperatorCall abstractOperatorCall = this.getOperatorCall(n);
        abstractOperatorCall.enterJokerKeyMode(n2, n3, n4);
    }

    public void leaveJokerKeyMode(int n) {
        AbstractOperatorCall abstractOperatorCall = this.getOperatorCall(n);
        abstractOperatorCall.leaveJokerKeyMode();
    }

    public void checksSuccessful(int n) {
        this.getOperatorCall(n).checksSuccessful();
    }

    public void operatorCallCenterLeft() {
        AbstractOperatorCall abstractOperatorCall = this.getCurrentOperatorCall();
        abstractOperatorCall.operatorCallCenterLeft();
    }

    public void operatorEndMsgLeft() {
        AbstractOperatorCall abstractOperatorCall = this.getCurrentOperatorCall();
        abstractOperatorCall.operatorEndMsgLeft();
    }

    public void setOption(boolean bl) {
        AbstractOperatorCall abstractOperatorCall = this.getCurrentOperatorCall();
        abstractOperatorCall.setOption(bl);
    }

    private AbstractOperatorCall getCurrentOperatorCall() {
        return this.getOperatorCall(this.operatorCallModelHandlerCommon.getCurrentServiceType());
    }

    public void operatorUpdateDetailInfo() {
        AbstractOperatorCall abstractOperatorCall = this.getCurrentOperatorCall();
        abstractOperatorCall.operatorUpdateDetailInfo();
    }

    public void getDataFromPersistence(int n) {
        AbstractOperatorCall abstractOperatorCall = this.getOperatorCall(n);
        abstractOperatorCall.getDataFromPersistence();
    }

    public void resetFactorySettings(int n) {
        switch (n) {
            case 2: {
                if (this.pCall == null) break;
                this.pCall.deleteAllCalls(false);
                this.pCall.resetCCP();
                break;
            }
            case 1: {
                if (this.cCall == null) break;
                this.cCall.deleteAllCalls(false);
                this.cCall.resetCCP();
                break;
            }
            default: {
                this.logChannel.log(100000, "AbstractOperatorCallHandler#resetFactorySettings: invalid serviceType (%1)", (long)n);
            }
        }
    }

    public void getDataFromPersistence(boolean bl, boolean bl2) {
        if (bl) {
            this.getDataFromPersistence(2);
        } else if (bl2) {
            this.getDataFromPersistence(1);
        }
    }

    public void setTerminalMode(boolean bl) {
        this.operatorCallModelHandlerCommon.setTerminalMode(bl);
    }

    public void abortConnectionBeforeTelConnectionEstablished() {
        if (this.bCall != null) {
            this.bCall.abortConnectionBeforeTelConnectionEstablished();
        }
        if (this.pCall != null) {
            this.pCall.abortConnectionBeforeTelConnectionEstablished();
        }
        if (this.cCall != null) {
            this.cCall.abortConnectionBeforeTelConnectionEstablished();
        }
    }
}

