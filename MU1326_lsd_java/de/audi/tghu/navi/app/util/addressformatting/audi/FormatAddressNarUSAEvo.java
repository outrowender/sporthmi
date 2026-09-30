/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util.addressformatting.audi;

import de.audi.atip.metrics.GeoMetric;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.util.Util;
import de.audi.tghu.navi.app.util.addressformatting.FormattedHighlightedText;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingRequest;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingResponse;
import de.audi.tghu.navi.app.util.addressformatting.audi.FormatAddressNarEvo;

public class FormatAddressNarUSAEvo
extends FormatAddressNarEvo {
    public FormatAddressNarUSAEvo(NavigationEnv navigationEnv) {
        super(navigationEnv);
    }

    protected LocationFormattingResponse asTwoLines(LocationFormattingRequest locationFormattingRequest) {
        if (!locationFormattingRequest.contactOrFavoriteName.isEmpty()) {
            return this.formatContactOrFavorite(locationFormattingRequest);
        }
        if (!locationFormattingRequest.poiName.isEmpty()) {
            return this.formatPoi(locationFormattingRequest);
        }
        if (locationFormattingRequest.city.isEmpty() && locationFormattingRequest.cityPart.isEmpty()) {
            return this.formatGeoCoordinateAddress(locationFormattingRequest);
        }
        if (locationFormattingRequest.street.isEmpty()) {
            if (locationFormattingRequest.locationType == 0) {
                return this.formatCityGeoAddress(locationFormattingRequest);
            }
            return this.formatCityCenterAddress(locationFormattingRequest);
        }
        return this.formatFullAddress(locationFormattingRequest);
    }

    protected LocationFormattingResponse asSingleLine(LocationFormattingRequest locationFormattingRequest) {
        if (locationFormattingRequest.city.isEmpty()) {
            return this.formatGeoCoordinateAddress(locationFormattingRequest);
        }
        LocationFormattingResponse locationFormattingResponse = new LocationFormattingResponse();
        LocationFormattingResponse locationFormattingResponse2 = this.asTwoLines(locationFormattingRequest);
        String string = locationFormattingResponse2.getFirstLineAsText();
        String string2 = locationFormattingResponse2.getSecondLineAsText();
        if (!Util.isEmpty(string) && !Util.isEmpty(string2)) {
            locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(string));
            locationFormattingResponse.appendToFirstLine(this.commaSymbol);
            locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(string2));
        } else {
            locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(string));
            locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(string2));
        }
        return locationFormattingResponse;
    }

    private LocationFormattingResponse formatContactOrFavorite(LocationFormattingRequest locationFormattingRequest) {
        LocationFormattingResponse locationFormattingResponse = new LocationFormattingResponse();
        locationFormattingResponse.appendToFirstLine(locationFormattingRequest.contactOrFavoriteName);
        boolean bl = false;
        if (!locationFormattingRequest.houseNumber.isEmpty()) {
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.houseNumber);
            locationFormattingResponse.appendToSecondLine(new FormattedHighlightedText(" "));
        }
        if (!locationFormattingRequest.street.isEmpty()) {
            bl = true;
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.street);
            locationFormattingResponse.appendToSecondLine(this.commaSymbol);
        }
        if (!locationFormattingRequest.city.isEmpty()) {
            bl = true;
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.city);
        }
        if (!locationFormattingRequest.zip.isEmpty()) {
            bl = true;
            locationFormattingResponse.appendToSecondLine(this.commaSymbol);
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.zip);
        }
        if (!locationFormattingRequest.stateAbbreviation.isEmpty() && bl) {
            locationFormattingResponse.appendToSecondLine(this.commaSymbol);
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.stateAbbreviation);
        }
        if (!bl) {
            LocationFormattingResponse locationFormattingResponse2 = this.formatGeoCoordinateAddress(locationFormattingRequest);
            locationFormattingResponse.replaceSecondLine(locationFormattingResponse2.getFirstLineList());
        }
        return locationFormattingResponse;
    }

    private LocationFormattingResponse formatPoi(LocationFormattingRequest locationFormattingRequest) {
        LocationFormattingResponse locationFormattingResponse = new LocationFormattingResponse();
        locationFormattingResponse.appendToFirstLine(locationFormattingRequest.poiName);
        if (!locationFormattingRequest.poiCategory.isEmpty() && !this.isCategoryInPoiName(locationFormattingRequest.poiName, locationFormattingRequest.poiCategory)) {
            locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(" ("));
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.poiCategory);
            locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(")"));
        }
        if (!locationFormattingRequest.houseNumber.isEmpty()) {
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.houseNumber);
            locationFormattingResponse.appendToSecondLine(new FormattedHighlightedText(" "));
        }
        if (!locationFormattingRequest.street.isEmpty()) {
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.street);
        }
        if (!locationFormattingRequest.city.isEmpty()) {
            if (!Util.isEmpty(locationFormattingResponse.getSecondLineAsText())) {
                locationFormattingResponse.appendToSecondLine(this.commaSymbol);
            }
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.city);
        }
        if (!locationFormattingRequest.stateAbbreviation.isEmpty()) {
            if (!Util.isEmpty(locationFormattingResponse.getSecondLineAsText())) {
                locationFormattingResponse.appendToSecondLine(this.commaSymbol);
            }
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.stateAbbreviation);
        }
        return locationFormattingResponse;
    }

    private LocationFormattingResponse formatFullAddress(LocationFormattingRequest locationFormattingRequest) {
        LocationFormattingResponse locationFormattingResponse = new LocationFormattingResponse();
        if (!locationFormattingRequest.houseNumber.isEmpty()) {
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.houseNumber);
            locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(" "));
        }
        if (!locationFormattingRequest.street.isEmpty()) {
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.street);
            if (!locationFormattingRequest.junction.isEmpty()) {
                locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(" & "));
                locationFormattingResponse.appendToFirstLine(locationFormattingRequest.junction);
            }
        }
        if (!locationFormattingRequest.city.isEmpty()) {
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.city);
        } else if (!locationFormattingRequest.cityPart.isEmpty()) {
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.cityPart);
        }
        if (!locationFormattingRequest.stateAbbreviation.isEmpty()) {
            locationFormattingResponse.appendToSecondLine(this.commaSymbol);
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.stateAbbreviation);
        }
        if (!locationFormattingRequest.zip.isEmpty()) {
            locationFormattingResponse.appendToSecondLine(this.commaSymbol);
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.zip);
        }
        return locationFormattingResponse;
    }

    private LocationFormattingResponse formatCityCenterAddress(LocationFormattingRequest locationFormattingRequest) {
        LocationFormattingResponse locationFormattingResponse = new LocationFormattingResponse();
        locationFormattingResponse.appendToFirstLine(locationFormattingRequest.city);
        if (!locationFormattingRequest.cityPart.isEmpty()) {
            if (!locationFormattingRequest.city.isEmpty()) {
                locationFormattingResponse.appendToFirstLine(this.commaSymbol);
            }
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.cityPart);
        }
        if (!locationFormattingRequest.stateAbbreviation.isEmpty()) {
            locationFormattingResponse.appendToFirstLine(this.commaSymbol);
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.stateAbbreviation);
        }
        if (!locationFormattingRequest.zip.isEmpty()) {
            locationFormattingResponse.appendToFirstLine(this.commaSymbol);
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.zip);
        }
        locationFormattingResponse.appendToSecondLine(new FormattedHighlightedText(this.env.getTranslatedText(5)));
        return locationFormattingResponse;
    }

    private LocationFormattingResponse formatCityGeoAddress(LocationFormattingRequest locationFormattingRequest) {
        LocationFormattingResponse locationFormattingResponse = new LocationFormattingResponse();
        locationFormattingResponse.appendToFirstLine(locationFormattingRequest.city);
        if (!locationFormattingRequest.cityPart.isEmpty()) {
            if (!locationFormattingRequest.city.isEmpty()) {
                locationFormattingResponse.appendToFirstLine(this.commaSymbol);
            }
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.cityPart);
        }
        if (!locationFormattingRequest.stateAbbreviation.isEmpty()) {
            locationFormattingResponse.appendToFirstLine(this.commaSymbol);
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.stateAbbreviation);
        }
        if (!locationFormattingRequest.zip.isEmpty()) {
            locationFormattingResponse.appendToFirstLine(this.commaSymbol);
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.zip);
        }
        GeoMetric geoMetric = new GeoMetric(Integer.parseInt(locationFormattingRequest.latitude.formattedText), Integer.parseInt(locationFormattingRequest.longitude.formattedText));
        locationFormattingResponse.appendToSecondLine(new FormattedHighlightedText(geoMetric.formatLatitude() + ", " + geoMetric.formatLongitude()));
        return locationFormattingResponse;
    }
}

