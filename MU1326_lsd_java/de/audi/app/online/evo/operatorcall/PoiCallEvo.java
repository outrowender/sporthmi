/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.operatorcall;

import de.audi.app.online.evo.operatorcall.OperatorCallDataContainerEvo;
import de.audi.app.online.evo.operatorcall.PoiCallModelHandlerEvo;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.interapp.online.OnlinePOICall;
import de.audi.tghu.online.app.operatorcall.AbstractOperatorCallMain;
import de.audi.tghu.online.app.operatorcall.abstractclasses.AbstractModelHandler;
import de.audi.tghu.online.app.operatorcall.commands.OperatorCallCommandListManager;
import de.audi.tghu.online.app.operatorcall.data.AbstractOperatorCallDataContainer;
import de.audi.tghu.online.app.operatorcall.handler.NavigationHandler;
import de.audi.tghu.online.app.operatorcall.handler.TelephoneHandler;
import de.audi.tghu.online.app.operatorcall.services.AbstractPoiCall;
import de.audi.tghu.online.app.operatorcall.services.OperatorCallModelHandlerCommon;
import de.audi.tghu.online.app.operatorcall.truffle.IntelliDestOperatorCallDataProvider;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;

public class PoiCallEvo
extends AbstractPoiCall {
    public PoiCallEvo(AbstractOperatorCallMain abstractOperatorCallMain, TelephoneHandler telephoneHandler, OperatorCallCommandListManager operatorCallCommandListManager, NavigationHandler navigationHandler, IFrameworkAccess iFrameworkAccess, OperatorCallModelHandlerCommon operatorCallModelHandlerCommon, IntelliDestOperatorCallDataProvider intelliDestOperatorCallDataProvider, OnlinePOICall onlinePOICall, RemoteHMIService remoteHMIService) {
        super(abstractOperatorCallMain, telephoneHandler, operatorCallCommandListManager, navigationHandler, iFrameworkAccess, operatorCallModelHandlerCommon, intelliDestOperatorCallDataProvider, onlinePOICall, remoteHMIService);
        this.logChannel.log(1000000, "PoiCallEvo#constructor: called");
    }

    protected AbstractModelHandler createModelHandler() {
        return new PoiCallModelHandlerEvo(this.getFramework().getHMIService(), this);
    }

    protected AbstractOperatorCallDataContainer createNewOperatorCallDataContainer(IntelliDestOperatorCallDataProvider intelliDestOperatorCallDataProvider) {
        return new OperatorCallDataContainerEvo(this.getServiceTypeName(), this.framework, this.naviHandler, intelliDestOperatorCallDataProvider, this.shouldPersistLists(), this.shouldPersistCCP(), this.getMaxNumberOfCalls(), this.getMaxNumberOfPoisPerCall());
    }

    public int getCurrentPermissionToTransmitCcp() {
        return 1;
    }
}

