/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.data;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.RemoteHMILocation;
import de.audi.tghu.online.app.Online;
import de.audi.tghu.online.app.operatorcall.data.AbstractHistoryCallListRow;
import de.audi.tghu.online.app.operatorcall.data.PoiResultListRow;
import de.audi.tghu.online.app.operatorcall.handler.NavigationHandler;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import org.dsi.ifc.online.OperatorCallAddressEntry;
import org.dsi.ifc.online.OperatorCallResult;

public abstract class AbstractHistoryCallData {
    public static final int PERSISTENCE_UNIQUE_ID_NONE = -1;
    protected OperatorCallResult[] operatorCallResults;
    protected PoiResultListRow[] poiResultItems;
    protected AbstractHistoryCallListRow historyCallItem;
    protected final LogChannel logChannel = Online.getInstance().getOperatorCallLogChannel();
    protected IFrameworkAccess framework;
    protected NavigationHandler naviHandler;
    protected ArrayList callsArray;
    protected String name;
    protected Date dateTime;
    private int persistenceUniqueId = -1;

    protected abstract AbstractHistoryCallListRow createHistoryCallListRow(boolean var1);

    public AbstractHistoryCallData(IFrameworkAccess iFrameworkAccess, NavigationHandler navigationHandler, OperatorCallResult[] operatorCallResultArray, ArrayList arrayList, String string, Date date) {
        this.framework = iFrameworkAccess;
        this.naviHandler = navigationHandler;
        this.operatorCallResults = operatorCallResultArray;
        this.callsArray = arrayList;
        this.name = string;
        this.dateTime = date;
        this.init();
    }

    public final void init() {
        this.createPoiResultItems();
        this.createHistoryCallForGUIList(this.name, this.dateTime);
    }

    public void createPoiResultItems() {
        this.poiResultItems = new PoiResultListRow[this.operatorCallResults.length];
        for (int i2 = 0; i2 < this.operatorCallResults.length; ++i2) {
            this.poiResultItems[i2] = this.createNewPoiResultListRow(this.operatorCallResults[i2]);
        }
    }

    protected PoiResultListRow createNewPoiResultListRow(OperatorCallResult operatorCallResult) {
        return new PoiResultListRow(operatorCallResult, this.naviHandler, this);
    }

    public void createHistoryCallForGUIList(String string, Date date) {
        boolean bl = this.operatorCallResults.length <= 1;
        if (string == null) {
            this.name = this.operatorCallResults[0].getName();
        }
        this.historyCallItem = this.createHistoryCallListRow(bl);
    }

    public AbstractHistoryCallListRow getHistoryCallForGUIList() {
        return this.historyCallItem;
    }

    public PoiResultListRow[] getPoisForGUIList() {
        this.updateDistance();
        return this.poiResultItems;
    }

    protected void updateDistance() {
        for (int i2 = 0; i2 < this.poiResultItems.length; ++i2) {
            this.poiResultItems[i2].computeDistanceAndUpdateData(1);
        }
    }

    public OperatorCallResult getPoiForSDS(int n) {
        if (n < this.operatorCallResults.length) {
            return this.operatorCallResults[n];
        }
        this.logChannel.log(10000, "AbstractHistoryCallData#getPoiForSDS: poiIndex is illegal!");
        return null;
    }

    public OperatorCallResult[] getPois() {
        return this.operatorCallResults;
    }

    public OperatorCallResult getPoi(int n) {
        if (n > this.operatorCallResults.length - 1) {
            this.logChannel.log(100000, "AbstractHistoryCallData#getPoi: index exceeds limits! Requested index = %1, poi list size = %2", (long)n, (long)this.operatorCallResults.length);
        }
        return this.operatorCallResults[n];
    }

    public RemoteHMILocation getPoiForAudiConnect(int n) {
        OperatorCallResult operatorCallResult = this.getPoi(n);
        RemoteHMILocation remoteHMILocation = new RemoteHMILocation();
        OperatorCallAddressEntry operatorCallAddressEntry = operatorCallResult.getAddress();
        remoteHMILocation.setCountry(operatorCallAddressEntry.getCountry());
        int n2 = operatorCallResult.getLocation().getLatitude();
        int n3 = operatorCallResult.getLocation().getLongitude();
        double d2 = this.convertToWgs(n2);
        double d3 = this.convertToWgs(n3);
        DecimalFormat decimalFormat = new DecimalFormat("0.00000");
        d2 = Double.parseDouble(decimalFormat.format(d2));
        d3 = Double.parseDouble(decimalFormat.format(d3));
        remoteHMILocation.setLatitude(d2);
        remoteHMILocation.setLongitude(d3);
        remoteHMILocation.setStreet(operatorCallAddressEntry.getStreet());
        remoteHMILocation.setTown(operatorCallAddressEntry.getCity());
        return remoteHMILocation;
    }

    protected double convertToWgs(long l) {
        return (double)l / 1.1930464E7;
    }

    public int getCallIndexForGUI() {
        int n = this.callsArray.indexOf(this);
        return this.callsArray.size() - 1 - n;
    }

    public String getName() {
        return this.historyCallItem.getName();
    }

    public Date getDateTime() {
        return this.historyCallItem.getDateTime();
    }

    public int getNumberOfPois() {
        return this.historyCallItem.getNumberOfPois();
    }

    public static void setNextFreeUniqueId(long l) {
        AbstractHistoryCallListRow.setNextFreeUniqueId(l);
    }

    public void setPersistenceUniqueId(int n) {
        this.logChannel.log(10000000, "AbstractHistoryCallData#setPersistenceUniqueId: %1 -> %2", (long)this.persistenceUniqueId, (long)n);
        this.persistenceUniqueId = n;
        this.historyCallItem.setPersistenceUniqueId(n);
    }

    public int getPersistenceUniqueId() {
        return this.persistenceUniqueId;
    }
}

