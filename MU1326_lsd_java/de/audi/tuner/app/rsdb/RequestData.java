/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.rsdb;

import de.audi.tuner.app.TunerObjectContainer;
import org.dsi.ifc.radiodata.RadioStationDataRequest;

public class RequestData {
    RadioStationDataRequest[] dsiReq;
    Long radioId;
    TunerObjectContainer toc;
    boolean unique;

    public RequestData(RadioStationDataRequest radioStationDataRequest, Long l, TunerObjectContainer tunerObjectContainer) {
        this.dsiReq = new RadioStationDataRequest[]{radioStationDataRequest};
        this.radioId = l;
        this.toc = tunerObjectContainer;
    }
}

