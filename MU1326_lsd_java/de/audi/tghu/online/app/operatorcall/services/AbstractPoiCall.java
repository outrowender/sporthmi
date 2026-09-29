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

public abstract class AbstractPoiCall
extends AbstractOperatorCall {
    @Override
    protected abstract AbstractModelHandler createModelHandler() {
    }

    public AbstractPoiCall(AbstractOperatorCallMain abstractOperatorCallMain, TelephoneHandler telephoneHandler, OperatorCallCommandListManager operatorCallCommandListManager, NavigationHandler navigationHandler, IFrameworkAccess iFrameworkAccess, OperatorCallModelHandlerCommon operatorCallModelHandlerCommon, IntelliDestOperatorCallDataProvider intelliDestOperatorCallDataProvider, OnlinePOICall onlinePOICall, RemoteHMIService remoteHMIService) {
        super(abstractOperatorCallMain, telephoneHandler, operatorCallCommandListManager, navigationHandler, iFrameworkAccess, operatorCallModelHandlerCommon, intelliDestOperatorCallDataProvider, onlinePOICall, remoteHMIService);
    }

    @Override
    public int getServiceType() {
        return 2;
    }

    @Override
    protected boolean isReadyToEnableApplication(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.logChannel.log(1078071040, "AbstractPoiCall#isReadyToEnableApplication: interested in naviFullyOperable = %1", bl2);
        this.logChannel.log(-2137614336, "AbstractPoiCall#isReadyToEnableApplication: return %1", bl2);
        return bl2;
    }

    @Override
    public String getServiceTypeName() {
        return "OperatorCall";
    }

    @Override
    protected OperatorCallData modifyCarData(OperatorCallData operatorCallData) {
        int n = operatorCallData.getValidBitMask();
        int n2 = operatorCallData.getAltitude();
        n2 = 0;
        int n3 = n & 2;
        if (n3 == 2) {
            n -= 2;
        }
        return new OperatorCallData(operatorCallData.getHeading(), n2, operatorCallData.getPosition(), operatorCallData.getDestination(), n);
    }

    @Override
    public int getDefaultPermissionToTransmitCcp() {
        this.logChannel.log(-1601830656, "AbstractPoiCall#setDefaultPermissionToTransmitCcp: If CCP is never persisted before or has been resetted, the call of this method is OK. Otherwise this method should not be called!");
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
        this.logChannel.log(1078071040, "AbstractPoiCall#startOperatorCallByJokerKey: JOKER1ONLINE_BUTTON pressed => start operator call!");
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

