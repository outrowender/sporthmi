/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.truffle;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.Online;
import de.audi.tghu.online.app.operatorcall.truffle.AbstractNaviSearchDataProvider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.dsi.ifc.online.OperatorCallResult;
import org.dsi.ifc.search.DataSet;
import org.dsi.ifc.search.Searchable;
import org.osgi.framework.BundleContext;

public class IntelliDestOperatorCallDataProvider
extends AbstractNaviSearchDataProvider {
    private static long uniqueID = 1L;
    private ArrayList callDatas;
    private static final LogChannel logChannel = Online.getInstance().getOperatorCallLogChannel();

    public IntelliDestOperatorCallDataProvider(IFrameworkAccess iFrameworkAccess, BundleContext bundleContext, int n) {
        super(logChannel, iFrameworkAccess, bundleContext, n);
    }

    protected DataSet[] getDataSet() {
        logChannel.log(1000000, "IntelliDestOperatorCallDataProvider#getDataSet: ... called!");
        ArrayList arrayList = new ArrayList();
        if (this.callDatas != null) {
            Object object;
            DataSet[] dataSetArray;
            Iterator iterator = this.callDatas.iterator();
            while (iterator.hasNext()) {
                dataSetArray = (DataSet[])iterator.next();
                object = dataSetArray.getPois();
                if (object == null) continue;
                arrayList.addAll(Arrays.asList((Object[])object));
            }
            int n = arrayList.size();
            if (n == 0) {
                logChannel.log(1000000, "IntelliDestOperatorCallDataProvider#getDataSet: no pois");
                return new DataSet[0];
            }
            dataSetArray = new DataSet[n];
            object = arrayList.listIterator();
            while (object.hasNext()) {
                OperatorCallResult operatorCallResult = (OperatorCallResult)object.next();
                logChannel.log(10000000, "IntelliDestOperatorCallDataProvider#getDataSet(): Creating searchable for poi %1", (Object)operatorCallResult);
                Searchable[] searchableArray = this.getSearchablesForPoiCall(operatorCallResult);
                dataSetArray[object.previousIndex()] = new DataSet(uniqueID, 0, 0, searchableArray);
                ++uniqueID;
            }
            return dataSetArray;
        }
        logChannel.log(100000, "IntelliDestOperatorCallDataProvider#getDataSet: calls-array is null");
        return new DataSet[0];
    }

    private Searchable[] getSearchablesForPoiCall(OperatorCallResult operatorCallResult) {
        if (operatorCallResult != null) {
            return new Searchable[]{new Searchable(5, operatorCallResult.getName()), new Searchable(3, operatorCallResult.getAddress().getStreet()), new Searchable(4, operatorCallResult.getAddress().getZip()), new Searchable(1, operatorCallResult.getAddress().getCity()), new Searchable(2, operatorCallResult.getAddress().getCity()), new Searchable(6, operatorCallResult.getAddress().getRegion()), new Searchable(17, operatorCallResult.getAddress().getCountry()), new Searchable(18, String.valueOf(operatorCallResult.getLocation().getLatitude())), new Searchable(19, String.valueOf(operatorCallResult.getLocation().getLongitude()))};
        }
        logChannel.log(10000, "IntelliDestOperatorCallDataProvider#getSearchablesForPoiCall: operatorCallResult is null! This should never happen!");
        return new Searchable[0];
    }

    public void saveInTruffles(ArrayList arrayList) {
        if (arrayList != null) {
            this.callDatas = arrayList;
            logChannel.log(1000000, "IntelliDestOperatorCallDataProvider#saveInTruffles: invalidateData ...!");
            this.invalidateData();
        } else {
            logChannel.log(100000, "IntelliDestOperatorCallDataProvider#saveInTruffles: call list is null !");
        }
    }
}

