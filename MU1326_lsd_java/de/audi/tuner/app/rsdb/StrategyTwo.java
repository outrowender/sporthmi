/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.rsdb;

import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.rsdb.CountryRegionMngr;
import de.audi.tuner.app.rsdb.OutstandingRequest;
import de.audi.tuner.app.rsdb.RequestData;
import de.audi.tuner.app.rsdb.RequestStrategy;
import org.dsi.ifc.radiodata.RadioStationDataRequest;

public class StrategyTwo
extends RequestStrategy {
    public StrategyTwo(CountryRegionMngr countryRegionMngr, LogChannel logChannel) {
        super(countryRegionMngr, logChannel);
    }

    public OutstandingRequest createStationDetectRequest(int n, OutstandingRequest outstandingRequest) {
        OutstandingRequest outstandingRequest2 = new OutstandingRequest(2, 2 * outstandingRequest.request.size(), outstandingRequest.rsdbListener, outstandingRequest.band);
        for (int i2 = 0; i2 < outstandingRequest.request.size(); ++i2) {
            RequestData requestData = (RequestData)outstandingRequest.request.get(i2);
            RadioStationDataRequest radioStationDataRequest = requestData.dsiReq[0];
            if (!radioStationDataRequest.useStationId && "FM".equals(radioStationDataRequest.stationType)) {
                if (radioStationDataRequest.usePiSid && !radioStationDataRequest.useFrequency) {
                    RadioStationDataRequest[] radioStationDataRequestArray = this.addCountry(radioStationDataRequest, n);
                    requestData.dsiReq = radioStationDataRequestArray;
                } else {
                    radioStationDataRequest.useFrequency = false;
                    requestData.dsiReq = new RadioStationDataRequest[0];
                }
            }
            outstandingRequest2.request.add(requestData);
        }
        return outstandingRequest2;
    }

    private RadioStationDataRequest[] addCountry(RadioStationDataRequest radioStationDataRequest, int n) {
        RadioStationDataRequest[] radioStationDataRequestArray;
        if (radioStationDataRequest.useFrequency) {
            radioStationDataRequest.country = n;
            radioStationDataRequest.useCountry = true;
            radioStationDataRequestArray = new RadioStationDataRequest[]{radioStationDataRequest};
        } else {
            int n2 = Utilities.getCcByPi(radioStationDataRequest.piSid);
            int n3 = this.countryRegionMngr.getHome(n, n2);
            if (n3 <= 0) {
                radioStationDataRequestArray = new RadioStationDataRequest[]{radioStationDataRequest};
            } else if (n3 == n) {
                radioStationDataRequest.country = n3;
                radioStationDataRequest.useCountry = true;
                radioStationDataRequestArray = new RadioStationDataRequest[]{radioStationDataRequest};
            } else {
                RadioStationDataRequest radioStationDataRequest2 = this.copy(radioStationDataRequest);
                radioStationDataRequest.country = n;
                radioStationDataRequest.useCountry = true;
                radioStationDataRequest2.country = n3;
                radioStationDataRequest2.useCountry = true;
                radioStationDataRequestArray = new RadioStationDataRequest[]{radioStationDataRequest, radioStationDataRequest2};
            }
        }
        return radioStationDataRequestArray;
    }
}

