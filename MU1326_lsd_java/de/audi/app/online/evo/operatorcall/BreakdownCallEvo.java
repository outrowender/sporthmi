/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.operatorcall;

import de.audi.app.online.evo.operatorcall.BreakdownCallModelHandlerEvo;
import de.audi.app.online.evo.operatorcall.OperatorCallDataContainerEvo;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.interapp.online.OnlinePOICall;
import de.audi.tghu.online.app.operatorcall.AbstractOperatorCallMain;
import de.audi.tghu.online.app.operatorcall.abstractclasses.AbstractModelHandler;
import de.audi.tghu.online.app.operatorcall.commands.OperatorCallCommandListManager;
import de.audi.tghu.online.app.operatorcall.data.AbstractOperatorCallDataContainer;
import de.audi.tghu.online.app.operatorcall.handler.NavigationHandler;
import de.audi.tghu.online.app.operatorcall.handler.TelephoneHandler;
import de.audi.tghu.online.app.operatorcall.services.AbstractBreakdownCall;
import de.audi.tghu.online.app.operatorcall.services.OperatorCallModelHandlerCommon;
import de.audi.tghu.online.app.operatorcall.truffle.IntelliDestOperatorCallDataProvider;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;

public class BreakdownCallEvo
extends AbstractBreakdownCall {
    public BreakdownCallEvo(AbstractOperatorCallMain abstractOperatorCallMain, TelephoneHandler telephoneHandler, OperatorCallCommandListManager operatorCallCommandListManager, NavigationHandler navigationHandler, IFrameworkAccess iFrameworkAccess, OperatorCallModelHandlerCommon operatorCallModelHandlerCommon, IntelliDestOperatorCallDataProvider intelliDestOperatorCallDataProvider, OnlinePOICall onlinePOICall, RemoteHMIService remoteHMIService) {
        super(abstractOperatorCallMain, telephoneHandler, operatorCallCommandListManager, navigationHandler, iFrameworkAccess, operatorCallModelHandlerCommon, intelliDestOperatorCallDataProvider, onlinePOICall, remoteHMIService);
    }

    @Override
    protected AbstractModelHandler createModelHandler() {
        return new BreakdownCallModelHandlerEvo(this.framework.getHMIService(), this);
    }

    @Override
    protected AbstractOperatorCallDataContainer createNewOperatorCallDataContainer(IntelliDestOperatorCallDataProvider intelliDestOperatorCallDataProvider) {
        return new OperatorCallDataContainerEvo(this.getServiceTypeName(), this.framework, this.naviHandler, intelliDestOperatorCallDataProvider, this.shouldPersistLists(), this.shouldPersistCCP(), this.getMaxNumberOfCalls(), this.getMaxNumberOfPoisPerCall());
    }

    @Override
    public int getCurrentPermissionToTransmitCcp() {
        return 1;
    }
}

