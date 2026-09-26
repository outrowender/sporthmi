/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.rsdb;

import de.audi.tuner.app.rsdb.CountryFinder;
import de.audi.tuner.app.rsdb.IRSDBResult;
import de.audi.tuner.app.rsdb.RequestData;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.radiodata.RadioStationDataRequest;
import org.dsi.ifc.radiodata.RadioStationLogoRequest;

public class OutstandingRequest {
    public final int band;
    public final int requestType;
    public final List request;
    public final CountryFinder countryFinder;
    public final IRSDBResult rsdbListener;

    public OutstandingRequest(int n, int n2, IRSDBResult iRSDBResult, int n3) {
        this.requestType = n;
        this.rsdbListener = iRSDBResult;
        this.request = new ArrayList(n2);
        this.countryFinder = new CountryFinder();
        this.band = n3;
    }

    public RadioStationDataRequest[] getDsiDataReq() {
        ArrayList arrayList = new ArrayList(2 * this.request.size());
        Iterator iterator = this.request.iterator();
        while (iterator.hasNext()) {
            RequestData requestData = (RequestData)iterator.next();
            for (int i2 = 0; i2 < requestData.dsiReq.length; ++i2) {
                arrayList.add(requestData.dsiReq[i2]);
            }
        }
        return (RadioStationDataRequest[])arrayList.toArray(new RadioStationDataRequest[arrayList.size()]);
    }

    public RadioStationLogoRequest[] getDsiLogoReq() {
        if (this.requestType == 3) {
            RadioStationLogoRequest[] radioStationLogoRequestArray = new RadioStationLogoRequest[this.request.size()];
            int n = 0;
            Iterator iterator = this.request.iterator();
            while (iterator.hasNext()) {
                RequestData requestData = (RequestData)iterator.next();
                radioStationLogoRequestArray[n] = new RadioStationLogoRequest(requestData.dsiReq[0], new int[]{3});
                ++n;
            }
            return radioStationLogoRequestArray;
        }
        throw new IllegalArgumentException();
    }

    public int getDsiReqSize() {
        int n = 0;
        Iterator iterator = this.request.iterator();
        while (iterator.hasNext()) {
            RequestData requestData = (RequestData)iterator.next();
            n += requestData.dsiReq.length;
        }
        return n;
    }

    public String toString() {
        Buffer buffer = new Buffer(1000);
        buffer.append("OutstandingRequest BEGIN\n");
        buffer.append("Type:").append(this.requestType);
        buffer.append("Size:").append(this.getDsiReqSize());
        buffer.append("OutstandingRequest END");
        return buffer.toString();
    }
}

