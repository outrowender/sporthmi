/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operator.porsche;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.interapp.online.OnlinePOICall;
import de.audi.atip.phone.ITelService;
import de.audi.tghu.online.app.operator.porsche.ConciergeCallModelHandlerPorscheCommon;
import de.audi.tghu.online.app.operator.porsche.OperatorCallDataContainerPorscheCommon;
import de.audi.tghu.online.app.operatorcall.AbstractOperatorCallMain;
import de.audi.tghu.online.app.operatorcall.commands.OperatorCallCommandListManager;
import de.audi.tghu.online.app.operatorcall.data.AbstractHistoryCallData;
import de.audi.tghu.online.app.operatorcall.data.AbstractOperatorCallDataContainer;
import de.audi.tghu.online.app.operatorcall.handler.NavigationHandler;
import de.audi.tghu.online.app.operatorcall.handler.TelephoneHandler;
import de.audi.tghu.online.app.operatorcall.services.AbstractConciergeCall;
import de.audi.tghu.online.app.operatorcall.services.OperatorCallModelHandlerCommon;
import de.audi.tghu.online.app.operatorcall.truffle.IntelliDestOperatorCallDataProvider;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.online.OperatorCallResult;

public abstract class ConciergeCallPorscheCommon
extends AbstractConciergeCall {
    private List results;
    public static final int ACTIVE_DEVICE_CARPLAY = 1;

    public ConciergeCallPorscheCommon(AbstractOperatorCallMain abstractOperatorCallMain, TelephoneHandler telephoneHandler, OperatorCallCommandListManager operatorCallCommandListManager, NavigationHandler navigationHandler, IFrameworkAccess iFrameworkAccess, OperatorCallModelHandlerCommon operatorCallModelHandlerCommon, IntelliDestOperatorCallDataProvider intelliDestOperatorCallDataProvider, OnlinePOICall onlinePOICall, RemoteHMIService remoteHMIService) {
        super(abstractOperatorCallMain, telephoneHandler, operatorCallCommandListManager, navigationHandler, iFrameworkAccess, operatorCallModelHandlerCommon, intelliDestOperatorCallDataProvider, onlinePOICall, remoteHMIService);
        int n = this.data.getTransmitCcpCheckboxCheckedFromPersistence();
        this.getModelHandlerPorsche().setCCPPersistenceState(n);
    }

    protected boolean shouldPersistLists() {
        return true;
    }

    public final void responseOperatorCallResult(int n, OperatorCallResult[] operatorCallResultArray) {
        int n2;
        this.distributor.setDownloadPoisRunning(false);
        this.logChannel.log(1000000, "ConciergeCallPorscheCommon#responseOperatorCallresult resultType: %1, results-length: %2", (long)n, (long)operatorCallResultArray.length);
        if (n == 1 && operatorCallResultArray.length != 0) {
            this.getData().setNewPoiResults(operatorCallResultArray);
            for (n2 = 0; n2 < operatorCallResultArray.length; ++n2) {
                this.results.add(operatorCallResultArray[n2]);
            }
            this.getModelHandlerPorsche().extendResultsListModel(this.results);
        }
        n2 = this.getModelHandlerPorsche().mapDsiResultCodeToHMI(n, operatorCallResultArray.length);
        this.getModelHandler().setDownloadPoiResult(n2);
    }

    public void refreshList() {
        if (this.results != null) {
            this.getModelHandlerPorsche().clearAllLists();
            this.getModelHandlerPorsche().extendResultsListModel(this.results);
        }
    }

    public void getDataFromPersistence() {
        this.logChannel.log(1000000, "ConciergeCallPorscheCommon#getDataFromPersistence");
        ArrayList arrayList = this.data.getDataFromPersistence();
        this.persistenceLoaded = true;
        List list = this.transformHistoryCalls(arrayList);
        this.logChannel.log(1000000, "ConciergeCallPorscheCommon#getDataFromPersistence adding persisted POIs: %1", (long)list.size());
        this.getModelHandlerPorsche().extendResultsListModel(list);
        this.results = list;
    }

    private List transformHistoryCalls(List list) {
        if (list == null || list.size() == 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); ++i2) {
            AbstractHistoryCallData abstractHistoryCallData = (AbstractHistoryCallData)list.get(i2);
            this.addPoisToResultList(abstractHistoryCallData.getPois(), arrayList);
        }
        return arrayList;
    }

    private void addPoisToResultList(OperatorCallResult[] operatorCallResultArray, List list) {
        if (operatorCallResultArray == null || operatorCallResultArray.length == 0) {
            return;
        }
        for (int i2 = 0; i2 < operatorCallResultArray.length; ++i2) {
            list.add(operatorCallResultArray[i2]);
        }
    }

    public void setCurrentCallStatus(int n) {
        ConciergeCallModelHandlerPorscheCommon conciergeCallModelHandlerPorscheCommon = this.getModelHandlerPorsche();
        conciergeCallModelHandlerPorscheCommon.setCurrentState(n);
        conciergeCallModelHandlerPorscheCommon.setCurrentStateChoice(n);
    }

    private ConciergeCallModelHandlerPorscheCommon getModelHandlerPorsche() {
        return (ConciergeCallModelHandlerPorscheCommon)this.getModelHandler();
    }

    public void setTelService(ITelService iTelService) {
        this.getModelHandlerPorsche().setTelService(iTelService);
    }

    protected AbstractOperatorCallDataContainer createNewOperatorCallDataContainer(IntelliDestOperatorCallDataProvider intelliDestOperatorCallDataProvider) {
        return new OperatorCallDataContainerPorscheCommon(this.getServiceTypeName(), this.framework, this.naviHandler, intelliDestOperatorCallDataProvider, this.shouldPersistLists(), this.shouldPersistCCP(), this.getMaxNumberOfCalls(), this.getMaxNumberOfPoisPerCall());
    }

    public void setNaviHandler(NavigationHandler navigationHandler) {
        this.getModelHandlerPorsche().setNaviHandler(navigationHandler);
    }

    public int getDefaultPermissionToTransmitCcp() {
        this.logChannel.log(1000000, "ConciergeCallPorscheCommon#getDefaultPermissionToTransmitCcp()");
        return -1;
    }

    public void deleteAllCalls(boolean bl) {
        this.results.clear();
        super.deleteAllCalls(bl);
    }

    protected boolean isCarPlay() {
        return this.getFramework().getHMIService().getChoiceModel(4239).getValue() == 1;
    }
}

