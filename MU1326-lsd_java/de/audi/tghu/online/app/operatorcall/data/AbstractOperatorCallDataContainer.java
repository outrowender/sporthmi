/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.data;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.Online;
import de.audi.tghu.online.app.operatorcall.data.AbstractHistoryCallData;
import de.audi.tghu.online.app.operatorcall.data.AbstractHistoryCallListRow;
import de.audi.tghu.online.app.operatorcall.data.OperatorCallHistoryStorageDataContainer;
import de.audi.tghu.online.app.operatorcall.data.OperatorCallInformation;
import de.audi.tghu.online.app.operatorcall.data.OperatorCallPhoneData;
import de.audi.tghu.online.app.operatorcall.data.OperatorCallTransmitCCPDataContainer;
import de.audi.tghu.online.app.operatorcall.data.PoiResultListRow;
import de.audi.tghu.online.app.operatorcall.handler.NavigationHandler;
import de.audi.tghu.online.app.operatorcall.truffle.IntelliDestOperatorCallDataProvider;
import de.audi.tghu.online.app.operatorcall.utils.OperatorCallResultAdapted;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.online.OperatorCallResult;

public abstract class AbstractOperatorCallDataContainer {
    protected final LogChannel logChannel = Online.getInstance().getOperatorCallLogChannel();
    protected String serviceTypeName;
    protected OperatorCallPhoneData phoneData;
    protected ArrayList calls = new ArrayList();
    protected int sdsCallIndex = -1;
    protected IFrameworkAccess framework;
    protected NavigationHandler naviHandler;
    protected OperatorCallHistoryStorageDataContainer persistence;
    protected OperatorCallTransmitCCPDataContainer ccpPersistence;
    private final boolean persistData;
    private final boolean persistTransmitCCP;
    protected IntelliDestOperatorCallDataProvider intelliDestOperatorCallDataProvider;
    private final int maxNumberOfPoisPerCall;
    private final int maxNumberOfCalls;

    protected abstract AbstractHistoryCallData createNewHistoryCallData(OperatorCallResult[] operatorCallResultArray, String string, Date date) {
    }

    public AbstractOperatorCallDataContainer(String string, IFrameworkAccess iFrameworkAccess, NavigationHandler navigationHandler, IntelliDestOperatorCallDataProvider intelliDestOperatorCallDataProvider, boolean bl, boolean bl2, int n, int n2) {
        this.serviceTypeName = string;
        this.framework = iFrameworkAccess;
        this.naviHandler = navigationHandler;
        this.intelliDestOperatorCallDataProvider = intelliDestOperatorCallDataProvider;
        this.persistData = bl;
        this.persistTransmitCCP = bl2;
        this.maxNumberOfCalls = n;
        this.maxNumberOfPoisPerCall = n2;
        this.phoneData = new OperatorCallPhoneData();
        if (bl) {
            this.persistence = new OperatorCallHistoryStorageDataContainer(iFrameworkAccess.getStorageMgr());
        }
        if (bl2) {
            this.ccpPersistence = new OperatorCallTransmitCCPDataContainer(iFrameworkAccess.getStorageMgr());
        }
    }

    public void savePhoneData(String string, String[] stringArray, int n) {
        this.logChannel.log(1078071040, "AbstractOperatorCallDataContainer#savePhoneData: entered (%1)", (Object)this.getServiceTypeName());
        this.phoneData.savePhoneData(string, stringArray, n);
    }

    public void resetPhoneData() {
        this.logChannel.log(1078071040, "AbstractOperatorCallDataContainer#resetPhoneData entered (%1)", (Object)this.getServiceTypeName());
        this.phoneData.resetPhoneData();
    }

    public String getServiceTypeName() {
        return this.serviceTypeName;
    }

    public String[] getPhoneNumber() {
        return this.phoneData.getOperatorPhoneNumber();
    }

    public String getFirstPhoneNumber() {
        String[] stringArray = this.getPhoneNumber();
        if (stringArray != null && stringArray.length > 0) {
            return stringArray[0];
        }
        return null;
    }

    public String getServiceId() {
        return this.phoneData.getServiceId();
    }

    public AbstractHistoryCallListRow setNewPoiResults(OperatorCallResult[] operatorCallResultArray) {
        AbstractHistoryCallData abstractHistoryCallData = this.createNewHistoryCallData(operatorCallResultArray, null, null);
        if (this.persistData) {
            int n = this.persistence.addCall(abstractHistoryCallData);
            abstractHistoryCallData.setPersistenceUniqueId(n);
        }
        this.addCall(abstractHistoryCallData);
        return abstractHistoryCallData.getHistoryCallForGUIList();
    }

    protected void addCall(AbstractHistoryCallData abstractHistoryCallData) {
        this.calls.add(abstractHistoryCallData);
        int n = this.calls.size();
        int n2 = n - this.maxNumberOfCalls;
        if (n2 > 0) {
            for (int i2 = 0; i2 < n2; ++i2) {
                this.removeOldestCallInCallList();
            }
        }
        this.saveCallsInTruffle();
    }

    private void removeOldestCallInCallList() {
        this.calls.remove(0);
    }

    public PoiResultListRow[] getResultsForCall(int n) {
        AbstractHistoryCallData abstractHistoryCallData = this.getHistoryCallData(n);
        if (abstractHistoryCallData == null) {
            return null;
        }
        return abstractHistoryCallData.getPoisForGUIList();
    }

    public AbstractHistoryCallData getHistoryCallData(int n) {
        if (n < 0 || n >= this.calls.size()) {
            return null;
        }
        int n2 = this.getInternalHistoryCallIndex(n);
        return (AbstractHistoryCallData)this.calls.get(n2);
    }

    public OperatorCallResult getPOIForSDS(int n) {
        this.logChannel.log(1078071040, "AbstractOperatorCallDataContainer#getPOIForSDS: internal sdsCallindex = %1, gui poiIndex = %2", (long)this.sdsCallIndex, (long)n);
        if (this.sdsCallIndex < 0 || this.sdsCallIndex >= this.calls.size()) {
            return null;
        }
        AbstractHistoryCallData abstractHistoryCallData = (AbstractHistoryCallData)this.calls.get(this.sdsCallIndex);
        if (abstractHistoryCallData == null) {
            this.logChannel.log(10000, "AbstractOperatorCallDataContainer#getPOIForSDS: HistoryCallData for sdsCallIndex = %1 is EMPTY!", (long)this.sdsCallIndex);
            return null;
        }
        return abstractHistoryCallData.getPoiForSDS(n);
    }

    public OperatorCallResult getOperatorCallResult(int n, int n2) {
        AbstractHistoryCallData abstractHistoryCallData = this.getHistoryCallData(n);
        if (abstractHistoryCallData == null) {
            return null;
        }
        return abstractHistoryCallData.getPoi(n2);
    }

    public void setCallIndexForSDS(int n) {
        this.logChannel.log(1078071040, "AbstractOperatorCallDataContainer#setCallIndexForSDS: called with gui index = %1", (long)n);
        int n2 = this.sdsCallIndex;
        this.sdsCallIndex = this.getInternalHistoryCallIndex(n);
        this.logChannel.log(1078071040, "AbstractOperatorCallDataContainer#setCallIndexForSDS: internal sdsCallIndex: %1 -> %2", (long)n2, (long)this.sdsCallIndex);
    }

    public ArrayList getDataFromPersistence() {
        if (this.persistData) {
            this.convertPersistenceData2HistoryCallData(this.persistence.getAllInformation());
            if (this.calls.size() > 0) {
                AbstractHistoryCallListRow abstractHistoryCallListRow = this.getLatestHistoryCallForList();
                long l = abstractHistoryCallListRow.getUniqueID();
                AbstractHistoryCallData.setNextFreeUniqueId(l + 1L);
            }
        }
        return this.calls;
    }

    private void convertPersistenceData2HistoryCallData(OperatorCallInformation[] operatorCallInformationArray) {
        this.calls = new ArrayList();
        for (int i2 = 0; i2 < operatorCallInformationArray.length; ++i2) {
            OperatorCallInformation operatorCallInformation = operatorCallInformationArray[i2];
            AbstractHistoryCallData abstractHistoryCallData = this.createNewHistoryCallData(operatorCallInformation.getResults(), operatorCallInformation.getName(), operatorCallInformation.getDateTime());
            abstractHistoryCallData.setPersistenceUniqueId(operatorCallInformation.getUniqueId());
            this.addCall(abstractHistoryCallData);
        }
    }

    public AbstractHistoryCallListRow getLatestHistoryCallForList() {
        AbstractHistoryCallData abstractHistoryCallData = this.getLatestHistoryCall();
        if (abstractHistoryCallData == null) {
            return null;
        }
        return abstractHistoryCallData.getHistoryCallForGUIList();
    }

    public AbstractHistoryCallListRow getHistoryCallForList(int n) {
        AbstractHistoryCallData abstractHistoryCallData = this.getHistoryCallData(n);
        if (abstractHistoryCallData == null) {
            return null;
        }
        return abstractHistoryCallData.getHistoryCallForGUIList();
    }

    public AbstractHistoryCallData getLatestHistoryCall() {
        if (this.calls.size() == 0) {
            return null;
        }
        return this.getHistoryCallData(0);
    }

    public int getNumberOfPois(int n) {
        AbstractHistoryCallData abstractHistoryCallData = this.getHistoryCallData(n);
        if (abstractHistoryCallData != null) {
            return abstractHistoryCallData.getNumberOfPois();
        }
        return 0;
    }

    public NavLocationWgs84[] getResultLocationsForPreviewMap(int n) {
        AbstractHistoryCallData abstractHistoryCallData = this.getHistoryCallData(n);
        OperatorCallResult[] operatorCallResultArray = abstractHistoryCallData.getPois();
        NavLocationWgs84[] navLocationWgs84Array = new NavLocationWgs84[operatorCallResultArray.length];
        for (int i2 = 0; i2 < operatorCallResultArray.length; ++i2) {
            navLocationWgs84Array[i2] = operatorCallResultArray[i2].getLocation();
        }
        return navLocationWgs84Array;
    }

    public NavLocationWgs84 getResultLocationForPreviewMap(int n, int n2) {
        AbstractHistoryCallData abstractHistoryCallData = this.getHistoryCallData(n);
        OperatorCallResult operatorCallResult = abstractHistoryCallData.getPoi(n2);
        return operatorCallResult.getLocation();
    }

    private int getInternalHistoryCallIndex(int n) {
        int n2 = this.calls.size() - 1 - n;
        this.logChannel.log(-2137614336, "AbstractOperatorCallDataContainer#getInternalHistoryCallIndex: return internal index of history call = %1", (long)n2);
        return n2;
    }

    public void deleteAllHistoryCalls() {
        if (this.persistData) {
            this.persistence.removeAllCalls();
        }
        this.calls = new ArrayList();
    }

    public int getNumberOfCalls() {
        return this.calls.size();
    }

    public void deleteHistoryCall(int n) {
        int n2 = this.getInternalHistoryCallIndex(n);
        if (this.persistData) {
            AbstractHistoryCallData abstractHistoryCallData = (AbstractHistoryCallData)this.calls.get(n2);
            this.persistence.removeCall(abstractHistoryCallData.getPersistenceUniqueId());
        }
        this.calls.remove(n2);
    }

    public AbstractHistoryCallListRow[] getAllHistoryCallGUIListsInIntervall(int n, int n2) {
        this.logChannel.log(-2137614336, "AbstractOperatorCallDataContainer#getAllHistoryCallGUIListsInIntervall: startIndex = %1, length = %2", (long)n, (long)n2);
        int n3 = this.calls.size() - 1 - n;
        int n4 = Math.max(0, n3 - n2);
        ArrayList arrayList = new ArrayList(this.calls.subList(n4, n3));
        Collections.reverse(arrayList);
        return (AbstractHistoryCallListRow[])arrayList.toArray(new AbstractHistoryCallListRow[arrayList.size()]);
    }

    public int getTransmitCcpCheckboxCheckedFromPersistence() {
        if (this.persistTransmitCCP) {
            return this.ccpPersistence.getSendCCPStatus();
        }
        this.logChannel.log(10000, "AbstractOperatorCallDataContainer#getTransmitCcpCheckboxCheckedFromPersistence: persistence of ccp is not allowed for this call! This should never happen!");
        return -2;
    }

    public void saveCCPInPersistence(int n) {
        this.ccpPersistence.setSendCcpAndPersist(n);
    }

    public void saveCallsInTruffle() {
        if (this.intelliDestOperatorCallDataProvider != null && this.calls != null) {
            this.intelliDestOperatorCallDataProvider.saveInTruffles(this.calls);
        }
    }

    public OperatorCallResult[] modifyResultsToValidResults(OperatorCallResult[] operatorCallResultArray) {
        this.logChannel.log(1078071040, "AbstractOperatorCallDataContainer#modifyResultsToValidResults: maxNumberOfPoisPerCall = %1", (long)this.maxNumberOfPoisPerCall);
        int n = operatorCallResultArray.length;
        int n2 = Math.min(this.maxNumberOfPoisPerCall, n);
        if (n2 == this.maxNumberOfPoisPerCall) {
            this.logChannel.log(-1601830656, "AbstractOperatorCallDataContainer#modifyResultsToValidResults: too many pois were downloaded for this call (%1). The max number of pois should not exceed %2. Saving only the first %2 number of pois. ", (long)n, (long)this.maxNumberOfPoisPerCall);
        }
        OperatorCallResult[] operatorCallResultArray2 = new OperatorCallResultAdapted[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            operatorCallResultArray2[i2] = new OperatorCallResultAdapted(operatorCallResultArray[i2]);
        }
        return operatorCallResultArray2;
    }
}

