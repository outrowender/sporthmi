/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.rsdb;

import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.rsdb.CountryRegionMngr;
import org.dsi.ifc.radiodata.RadioStationDataRequest;

public class RequestStrategy {
    protected final CountryRegionMngr countryRegionMngr;
    protected final LogChannel lc;

    public RequestStrategy(CountryRegionMngr countryRegionMngr, LogChannel logChannel) {
        this.countryRegionMngr = countryRegionMngr;
        this.lc = logChannel;
    }

    protected RadioStationDataRequest copy(RadioStationDataRequest radioStationDataRequest) {
        return new RadioStationDataRequest(radioStationDataRequest.maxItemCount, radioStationDataRequest.stationId, radioStationDataRequest.useStationId, radioStationDataRequest.country, radioStationDataRequest.useCountry, radioStationDataRequest.extendedCountryCode, radioStationDataRequest.useExtendedCountryCode, radioStationDataRequest.piSid, radioStationDataRequest.usePiSid, radioStationDataRequest.linkedPiSid, radioStationDataRequest.useLinkedPiSid, radioStationDataRequest.ensembleId, radioStationDataRequest.useEnsembleId, radioStationDataRequest.scidi, radioStationDataRequest.useScidi, radioStationDataRequest.longName, radioStationDataRequest.useLongName, radioStationDataRequest.shortName, radioStationDataRequest.useShortName, radioStationDataRequest.frequency, radioStationDataRequest.useFrequency, radioStationDataRequest.subChannelId, radioStationDataRequest.useSubChannelId, radioStationDataRequest.stationType, radioStationDataRequest.useStationType, radioStationDataRequest.logoId, radioStationDataRequest.useLogoId);
    }
}

