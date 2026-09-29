/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.rsdb;

import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.rsdb.CountryRegionMngr;
import de.audi.tuner.app.rsdb.OutstandingRequest;
import de.audi.tuner.app.rsdb.RequestData;
import de.audi.tuner.app.rsdb.RequestStrategy;
import java.util.ArrayList;
import org.dsi.ifc.radiodata.RadioStationDataRequest;

public class StrategyFive
extends RequestStrategy {
    public StrategyFive(CountryRegionMngr countryRegionMngr, LogChannel logChannel) {
        super(countryRegionMngr, logChannel);
    }

    public OutstandingRequest createStationDetectRequest(int n, OutstandingRequest outstandingRequest) {
        OutstandingRequest outstandingRequest2 = new OutstandingRequest(2, 10 * outstandingRequest.request.size(), outstandingRequest.rsdbListener, outstandingRequest.band);
        for (int i2 = 0; i2 < outstandingRequest.request.size(); ++i2) {
            RequestData requestData = (RequestData)outstandingRequest.request.get(i2);
            RadioStationDataRequest radioStationDataRequest = requestData.dsiReq[0];
            if (!radioStationDataRequest.useStationId && "FM".equals(radioStationDataRequest.stationType)) {
                radioStationDataRequest.usePiSid = false;
                radioStationDataRequest.useFrequency = false;
                RadioStationDataRequest[] radioStationDataRequestArray = this.addCountry(radioStationDataRequest, n);
                requestData.dsiReq = radioStationDataRequestArray;
            }
            outstandingRequest2.request.add(requestData);
        }
        return outstandingRequest2;
    }

    private RadioStationDataRequest[] addCountry(RadioStationDataRequest radioStationDataRequest, int n) {
        ArrayList arrayList = new ArrayList(32);
        int[] nArray = this.countryRegionMngr.getAllNeighbors(n);
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            RadioStationDataRequest radioStationDataRequest2;
            if (nArray[i2] == 0) continue;
            if (radioStationDataRequest.piSid != -1) {
                radioStationDataRequest2 = this.copy(radioStationDataRequest);
                radioStationDataRequest2.country = nArray[i2];
                radioStationDataRequest2.useCountry = true;
                radioStationDataRequest2.usePiSid = true;
                arrayList.add(radioStationDataRequest2);
            }
            radioStationDataRequest2 = this.copy(radioStationDataRequest);
            radioStationDataRequest2.country = nArray[i2];
            radioStationDataRequest2.useCountry = true;
            radioStationDataRequest2.useFrequency = true;
            arrayList.add(radioStationDataRequest2);
        }
        return (RadioStationDataRequest[])arrayList.toArray(new RadioStationDataRequest[arrayList.size()]);
    }
}

