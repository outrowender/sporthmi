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

public class FormatAddressEUEvo
extends FormatAddress {
    public FormatAddressEUEvo(NavigationEnv navigationEnv) {
        super(navigationEnv);
    }

    @Override
    protected LocationFormattingResponse asTwoLines(LocationFormattingRequest locationFormattingRequest) {
        if (!locationFormattingRequest.poiName.isEmpty() || !locationFormattingRequest.contactOrFavoriteName.isEmpty()) {
            return this.formatNamedAddress(locationFormattingRequest);
        }
        return this.formatAddress(locationFormattingRequest);
    }

    @Override
    protected LocationFormattingResponse asThreeLines(LocationFormattingRequest locationFormattingRequest) {
        return null;
    }

    @Override
    protected LocationFormattingResponse asSingleLine(LocationFormattingRequest locationFormattingRequest) {
        LocationFormattingResponse locationFormattingResponse = this.asTwoLines(locationFormattingRequest);
        return locationFormattingResponse.createOneLineLocationFormattingResponse();
    }

    private LocationFormattingResponse formatAddress(LocationFormattingRequest locationFormattingRequest) {
        if (locationFormattingRequest.city.isEmpty() && locationFormattingRequest.cityPart.isEmpty()) {
            return this.formatGeoCoordinateAddress(locationFormattingRequest);
        }
        if (locationFormattingRequest.street.isEmpty() && locationFormattingRequest.locationType != 0) {
            return this.formatCityCenterAddress(locationFormattingRequest);
        }
        return this.formatFullAddress(locationFormattingRequest);
    }

    private LocationFormattingResponse formatFullAddress(LocationFormattingRequest locationFormattingRequest) {
        boolean bl;
        LocationFormattingResponse locationFormattingResponse = new LocationFormattingResponse();
        boolean bl2 = bl = !locationFormattingRequest.street.isEmpty();
        if (bl) {
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.street);
        } else {
            GeoMetric geoMetric = new GeoMetric(Integer.parseInt(locationFormattingRequest.latitude.formattedText), Integer.parseInt(locationFormattingRequest.longitude.formattedText));
            locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(new StringBuffer().append(geoMetric.formatLatitude()).append(", ").append(geoMetric.formatLongitude()).toString()));
        }
        if (!locationFormattingRequest.houseNumber.isEmpty()) {
            locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(" "));
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.houseNumber);
        }
        if (!locationFormattingRequest.junction.isEmpty()) {
            locationFormattingResponse.appendToFirstLine(this.commaSymbol);
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.junction);
        }
        if (!locationFormattingRequest.countryAbbreviation.isEmpty()) {
            locationFormattingResponse.appendToSecondLine(new FormattedHighlightedText(new StringBuffer().append("(").append(locationFormattingRequest.countryAbbreviation.formattedText).append(") ").toString()));
        }
        locationFormattingResponse.appendToSecondLine(locationFormattingRequest.city);
        if (!locationFormattingRequest.cityPart.isEmpty()) {
            if (!locationFormattingRequest.city.isEmpty()) {
                locationFormattingResponse.appendToSecondLine(this.commaSymbol);
            }
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.cityPart);
        }
        if (!locationFormattingRequest.zip.isEmpty()) {
            locationFormattingResponse.appendToSecondLine(this.commaSymbol);
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.zip);
        }
        if (!locationFormattingRequest.state.isEmpty() && locationFormattingRequest.state.isHighlighted()) {
            locationFormattingResponse.appendToSecondLine(this.commaSymbol);
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.state);
        }
        if (!bl) {
            locationFormattingResponse.swapLines();
        }
        return locationFormattingResponse;
    }

    private LocationFormattingResponse formatCityCenterAddress(LocationFormattingRequest locationFormattingRequest) {
        LocationFormattingResponse locationFormattingResponse = new LocationFormattingResponse();
        if (!locationFormattingRequest.countryAbbreviation.isEmpty()) {
            locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(new StringBuffer().append("(").append(locationFormattingRequest.countryAbbreviation.formattedText).append(") ").toString()));
        }
        if (!locationFormattingRequest.city.isEmpty()) {
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.city);
            if (!locationFormattingRequest.cityPart.isEmpty()) {
                locationFormattingResponse.appendToFirstLine(this.commaSymbol);
                locationFormattingResponse.appendToFirstLine(locationFormattingRequest.cityPart);
            }
            if (!locationFormattingRequest.zip.isEmpty()) {
                locationFormattingResponse.appendToFirstLine(this.commaSymbol);
                locationFormattingResponse.appendToFirstLine(locationFormattingRequest.zip);
            }
            if (!locationFormattingRequest.state.isEmpty() && locationFormattingRequest.state.isHighlighted()) {
                locationFormattingResponse.appendToFirstLine(this.commaSymbol);
                locationFormattingResponse.appendToFirstLine(locationFormattingRequest.state);
            }
        }
        locationFormattingResponse.appendToSecondLine(new FormattedHighlightedText(this.env.getTranslatedText(5)));
        return locationFormattingResponse;
    }

    private LocationFormattingResponse formatGeoCoordinateAddress(LocationFormattingRequest locationFormattingRequest) {
        LocationFormattingResponse locationFormattingResponse = new LocationFormattingResponse();
        if (!locationFormattingRequest.countryAbbreviation.isEmpty()) {
            locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(new StringBuffer().append("(").append(locationFormattingRequest.countryAbbreviation.formattedText).append(") ").toString()));
        }
        GeoMetric geoMetric = new GeoMetric(Integer.parseInt(locationFormattingRequest.latitude.formattedText), Integer.parseInt(locationFormattingRequest.longitude.formattedText));
        locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(new StringBuffer().append(geoMetric.formatLatitude()).append(", ").append(geoMetric.formatLongitude()).toString()));
        return locationFormattingResponse;
    }

    private LocationFormattingResponse formatNamedAddress(LocationFormattingRequest locationFormattingRequest) {
        LocationFormattingResponse locationFormattingResponse = new LocationFormattingResponse();
        if (!locationFormattingRequest.contactOrFavoriteName.isEmpty()) {
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.contactOrFavoriteName);
        } else {
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.poiName);
            if (!locationFormattingRequest.poiCategory.isEmpty() && !this.isCategoryInPoiName(locationFormattingRequest.poiName, locationFormattingRequest.poiCategory)) {
                locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(" ("));
                locationFormattingResponse.appendToFirstLine(locationFormattingRequest.poiCategory);
                locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(")"));
            }
        }
        if (!locationFormattingRequest.countryAbbreviation.isEmpty()) {
            locationFormattingResponse.appendToSecondLine(new FormattedHighlightedText(new StringBuffer().append("(").append(locationFormattingRequest.countryAbbreviation.formattedText).append(") ").toString()));
        }
        if (!locationFormattingRequest.city.isEmpty()) {
            if (!locationFormattingRequest.street.isEmpty()) {
                locationFormattingResponse.appendToSecondLine(locationFormattingRequest.street);
                if (!locationFormattingRequest.houseNumber.isEmpty()) {
                    locationFormattingResponse.appendToSecondLine(new FormattedHighlightedText(" "));
                    locationFormattingResponse.appendToSecondLine(locationFormattingRequest.houseNumber);
                }
                locationFormattingResponse.appendToSecondLine(this.commaSymbol);
            }
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.city);
            if (!locationFormattingRequest.cityPart.isEmpty() && locationFormattingRequest.cityPart.isHighlighted()) {
                locationFormattingResponse.appendToSecondLine(this.commaSymbol);
                locationFormattingResponse.appendToSecondLine(locationFormattingRequest.cityPart);
            }
            if (!locationFormattingRequest.state.isEmpty() && locationFormattingRequest.state.isHighlighted()) {
                locationFormattingResponse.appendToSecondLine(this.commaSymbol);
                locationFormattingResponse.appendToSecondLine(locationFormattingRequest.state);
            }
        } else {
            GeoMetric geoMetric = new GeoMetric(Integer.parseInt(locationFormattingRequest.latitude.formattedText), Integer.parseInt(locationFormattingRequest.longitude.formattedText));
            locationFormattingResponse.appendToSecondLine(new FormattedHighlightedText(new StringBuffer().append(geoMetric.formatLatitude()).append(", ").append(geoMetric.formatLongitude()).toString()));
        }
        return locationFormattingResponse;
    }
}

