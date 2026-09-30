/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util.addressformatting.audi;

import de.audi.atip.metrics.GeoMetric;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.util.addressformatting.FormatAddress;
import de.audi.tghu.navi.app.util.addressformatting.FormattedHighlightedText;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingRequest;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingResponse;
import de.audi.tghu.navi.app.util.addressformatting.audi.FormatAddressNarCANEvo;
import de.audi.tghu.navi.app.util.addressformatting.audi.FormatAddressNarMEXEvo;
import de.audi.tghu.navi.app.util.addressformatting.audi.FormatAddressNarUSAEvo;

public class FormatAddressNarEvo
extends FormatAddress {
    private static final String COUNTRY_ABBREVIATION_USA = "USA";
    private static final String COUNTRY_ABBREVIATION_MEX = "MEX";
    private static final String COUNTRY_ABBREVIATION_CAN = "CAN";

    public FormatAddressNarEvo(NavigationEnv navigationEnv) {
        super(navigationEnv);
    }

    protected LocationFormattingResponse asTwoLines(LocationFormattingRequest locationFormattingRequest) {
        if (locationFormattingRequest.countryAbbreviation.formattedText.equalsIgnoreCase(COUNTRY_ABBREVIATION_CAN)) {
            return new FormatAddressNarCANEvo(this.env).asTwoLines(locationFormattingRequest);
        }
        if (locationFormattingRequest.countryAbbreviation.formattedText.equalsIgnoreCase(COUNTRY_ABBREVIATION_MEX)) {
            return new FormatAddressNarMEXEvo(this.env).asTwoLines(locationFormattingRequest);
        }
        return new FormatAddressNarUSAEvo(this.env).asTwoLines(locationFormattingRequest);
    }

    protected LocationFormattingResponse asThreeLines(LocationFormattingRequest locationFormattingRequest) {
        return null;
    }

    protected LocationFormattingResponse asSingleLine(LocationFormattingRequest locationFormattingRequest) {
        if (locationFormattingRequest.countryAbbreviation.formattedText.equalsIgnoreCase(COUNTRY_ABBREVIATION_CAN)) {
            return new FormatAddressNarCANEvo(this.env).asSingleLine(locationFormattingRequest);
        }
        if (locationFormattingRequest.countryAbbreviation.formattedText.equalsIgnoreCase(COUNTRY_ABBREVIATION_MEX)) {
            return new FormatAddressNarMEXEvo(this.env).asSingleLine(locationFormattingRequest);
        }
        return new FormatAddressNarUSAEvo(this.env).asSingleLine(locationFormattingRequest);
    }

    protected LocationFormattingResponse formatGeoCoordinateAddress(LocationFormattingRequest locationFormattingRequest) {
        LocationFormattingResponse locationFormattingResponse = new LocationFormattingResponse();
        if (!locationFormattingRequest.countryAbbreviation.isEmpty()) {
            locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText("(" + locationFormattingRequest.countryAbbreviation.formattedText + ") "));
        }
        GeoMetric geoMetric = new GeoMetric(Integer.parseInt(locationFormattingRequest.latitude.formattedText), Integer.parseInt(locationFormattingRequest.longitude.formattedText));
        locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(geoMetric.formatLatitude() + ", " + geoMetric.formatLongitude()));
        return locationFormattingResponse;
    }
}

