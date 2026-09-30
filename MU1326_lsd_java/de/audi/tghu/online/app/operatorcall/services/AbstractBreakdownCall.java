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
import de.audi.tghu.online.app.operatorcall.data.AbstractHistoryCallData;
import de.audi.tghu.online.app.operatorcall.data.PoiResultListRow;
import de.audi.tghu.online.app.operatorcall.handler.NavigationHandler;
import de.audi.tghu.online.app.operatorcall.handler.TelephoneHandler;
import de.audi.tghu.online.app.operatorcall.services.OperatorCallModelHandlerCommon;
import de.audi.tghu.online.app.operatorcall.truffle.IntelliDestOperatorCallDataProvider;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import org.dsi.ifc.online.OperatorCallData;

public abstract class AbstractBreakdownCall
extends AbstractOperatorCall {
    protected abstract AbstractModelHandler createModelHandler();

    public AbstractBreakdownCall(AbstractOperatorCallMain abstractOperatorCallMain, TelephoneHandler telephoneHandler, OperatorCallCommandListManager operatorCallCommandListManager, NavigationHandler navigationHandler, IFrameworkAccess iFrameworkAccess, OperatorCallModelHandlerCommon operatorCallModelHandlerCommon, IntelliDestOperatorCallDataProvider intelliDestOperatorCallDataProvider, OnlinePOICall onlinePOICall, RemoteHMIService remoteHMIService) {
        super(abstractOperatorCallMain, telephoneHandler, operatorCallCommandListManager, navigationHandler, iFrameworkAccess, operatorCallModelHandlerCommon, intelliDestOperatorCallDataProvider, onlinePOICall, remoteHMIService);
    }

    public int getServiceType() {
        return 0;
    }

    public String getServiceTypeName() {
        return "BreakdownCall";
    }

    protected boolean isReadyToEnableApplication(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.logChannel.log(1000000, "AbstractBreakdownCall#isReadyToEnableApplication: %1 | %2 | %3 (dsiAvailable, naviFullyOperable, telServiceAvailable)", bl, bl2, bl3);
        boolean bl5 = bl && bl2 && bl3;
        this.logChannel.log(10000000, "AbstractBreakdownCall#isReadyToEnableApplication: return %1", bl5);
        return bl5;
    }

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

    public int getDefaultPermissionToTransmitCcp() {
        return 1;
    }

    public void startRouteGuidance() {
        AbstractHistoryCallData abstractHistoryCallData = this.getData().getLatestHistoryCall();
        if (abstractHistoryCallData == null) {
            this.getModelHandler().showDefaultError(true, 2);
            return;
        }
        PoiResultListRow[] poiResultListRowArray = abstractHistoryCallData.getPoisForGUIList();
        PoiResultListRow poiResultListRow = poiResultListRowArray[0];
        boolean bl = this.poiSelected(poiResultListRow);
        if (bl) {
            this.getModelHandler().deleteCachedPois();
        } else {
            this.getModelHandler().showDefaultError(true, 2);
        }
    }

    public void routeGuidanceCancelled() {
        this.getModelHandler().deleteCachedPois();
    }

    public void startOperatorCallByJokerKey() {
    }

    public void audiConnectForThisLocation(int n) {
    }

    protected boolean shouldPersistLists() {
        return false;
    }

    public boolean shouldSendBAPSignalAnotherCallActive() {
        return false;
    }

    public boolean shouldSendBAPSignalGeneralError() {
        return false;
    }

    public boolean shouldSendBAPSignalNoSIM() {
        return false;
    }

    public boolean shouldCloseLeftDrawerAfterStartingWithJokerkey() {
        return false;
    }

    protected boolean shouldPersistCCP() {
        return false;
    }

    public boolean isTrufflesAvailable() {
        return false;
    }

    protected int getMaxNumberOfPoisPerCall() {
        return 1;
    }

    public int getMaxNumberOfCalls() {
        return 1;
    }
}

