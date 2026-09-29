/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.services;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.interapp.online.OnlinePOICall;
import de.audi.tghu.online.app.operatorcall.AbstractOperatorCallMain;
import de.audi.tghu.online.app.operatorcall.abstractclasses.AbstractModelHandler;
import de.audi.tghu.online.app.operatorcall.abstractclasses.AbstractOperatorCall;
import de.audi.tghu.online.app.operatorcall.commands.OperatorCallCommandListManager;
import de.audi.tghu.online.app.operatorcall.handler.NavigationHandler;
import de.audi.tghu.online.app.operatorcall.handler.TelephoneHandler;
import de.audi.tghu.online.app.operatorcall.services.OperatorCallModelHandlerCommon;
import de.audi.tghu.online.app.operatorcall.truffle.IntelliDestOperatorCallDataProvider;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import org.dsi.ifc.online.OperatorCallData;

public abstract class AbstractConciergeCall
extends AbstractOperatorCall {
    @Override
    protected abstract AbstractModelHandler createModelHandler() {
    }

    public AbstractConciergeCall(AbstractOperatorCallMain abstractOperatorCallMain, TelephoneHandler telephoneHandler, OperatorCallCommandListManager operatorCallCommandListManager, NavigationHandler navigationHandler, IFrameworkAccess iFrameworkAccess, OperatorCallModelHandlerCommon operatorCallModelHandlerCommon, IntelliDestOperatorCallDataProvider intelliDestOperatorCallDataProvider, OnlinePOICall onlinePOICall, RemoteHMIService remoteHMIService) {
        super(abstractOperatorCallMain, telephoneHandler, operatorCallCommandListManager, navigationHandler, iFrameworkAccess, operatorCallModelHandlerCommon, intelliDestOperatorCallDataProvider, onlinePOICall, remoteHMIService);
    }

    @Override
    public int getServiceType() {
        return 1;
    }

    @Override
    protected boolean isReadyToEnableApplication(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.logChannel.log(1078071040, "AbstractConciergeCall#isReadyToEnableApplication: interested in naviFullyOperable = %1", bl2);
        return bl2;
    }

    @Override
    public String getServiceTypeName() {
        return "ConciergeCall";
    }

    @Override
    protected OperatorCallData modifyCarData(OperatorCallData operatorCallData) {
        return operatorCallData;
    }

    @Override
    public int getDefaultPermissionToTransmitCcp() {
        return 1;
    }

    @Override
    public void startRouteGuidance() {
    }

    @Override
    public void routeGuidanceCancelled() {
    }

    @Override
    public void startOperatorCallByJokerKey() {
        this.logChannel.log(1078071040, "AbstractConciergeCall#startOperatorCallByJokerKey: JOKER1ONLINE_BUTTON pressed => start concierge call!");
        this.getModelHandler().setModelName("JOKER1ONLINE_BUTTON");
        this.distributor.enterService(this.getServiceType());
        this.setLastCallFocused(-1);
        this.getModelHandler().triggerJokerKey();
    }

    @Override
    protected boolean shouldPersistLists() {
        return true;
    }

    @Override
    public boolean shouldSendBAPSignalAnotherCallActive() {
        return true;
    }

    @Override
    public boolean shouldSendBAPSignalGeneralError() {
        return true;
    }

    @Override
    public boolean shouldSendBAPSignalNoSIM() {
        return true;
    }

    @Override
    public boolean shouldCloseLeftDrawerAfterStartingWithJokerkey() {
        return true;
    }

    @Override
    protected boolean shouldPersistCCP() {
        return true;
    }

    @Override
    public boolean isTrufflesAvailable() {
        return true;
    }

    @Override
    protected int getMaxNumberOfPoisPerCall() {
        return 5;
    }

    @Override
    public int getMaxNumberOfCalls() {
        return 10;
    }
}

