/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util.addressformatting.porsche;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.util.Util;
import de.audi.tghu.navi.app.util.addressformatting.FormattedHighlightedText;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingRequest;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingResponse;
import de.audi.tghu.navi.app.util.addressformatting.porsche.FormatAddressAsiaNativePAG;

public class FormatAddressCNNativePAG
extends FormatAddressAsiaNativePAG {
    public FormatAddressCNNativePAG(NavigationEnv navigationEnv) {
        super(navigationEnv);
    }

    protected void formatAddressWhenStreetExists(LocationFormattingRequest locationFormattingRequest, LocationFormattingResponse locationFormattingResponse) {
        if (locationFormattingRequest.junction.isEmpty()) {
            if (locationFormattingRequest.houseNumber.isEmpty()) {
                locationFormattingResponse.appendToFirstLine(locationFormattingRequest.street);
                this.formatThreeLevelCityForSecondLine(locationFormattingRequest, locationFormattingResponse);
            } else {
                locationFormattingResponse.appendToFirstLine(locationFormattingRequest.street);
                locationFormattingResponse.appendToFirstLine(this.emptySymbol);
                locationFormattingResponse.appendToFirstLine(locationFormattingRequest.houseNumber);
                this.formatThreeLevelCityForSecondLine(locationFormattingRequest, locationFormattingResponse);
            }
        } else {
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.junction);
            locationFormattingResponse.appendToFirstLine(this.slashSymbol);
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.street);
            this.formatThreeLevelCityForSecondLine(locationFormattingRequest, locationFormattingResponse);
        }
    }

    protected LocationFormattingResponse asThreeLines(LocationFormattingRequest locationFormattingRequest) {
        LocationFormattingResponse locationFormattingResponse = new LocationFormattingResponse();
        this.appendToFirstLineContactFavOrPOIName(locationFormattingRequest, locationFormattingResponse);
        LocationFormattingResponse locationFormattingResponse2 = new LocationFormattingResponse();
        this.formatStreetAndHouseNumber(locationFormattingRequest, locationFormattingResponse2);
        if (this.swapIfFirstLineIsEmpty(locationFormattingResponse, locationFormattingResponse2)) {
            return locationFormattingResponse2;
        }
        this.appendToSecondAndThirdLine(locationFormattingResponse, locationFormattingResponse2);
        return locationFormattingResponse;
    }

    protected void formatDefaultTwoLines(LocationFormattingRequest locationFormattingRequest, LocationFormattingResponse locationFormattingResponse) {
        if (locationFormattingRequest.district.isEmpty()) {
            if (!locationFormattingRequest.city.isEmpty()) {
                locationFormattingResponse.appendToFirstLine(locationFormattingRequest.city);
                if (!locationFormattingRequest.state.isEmpty()) {
                    locationFormattingResponse.appendToSecondLine(locationFormattingRequest.state);
                } else {
                    locationFormattingResponse.appendToSecondLine(locationFormattingRequest.city);
                }
            } else if (!locationFormattingRequest.state.isEmpty()) {
                locationFormattingResponse.appendToFirstLine(locationFormattingRequest.state);
                locationFormattingResponse.appendToSecondLine(locationFormattingRequest.state);
            } else {
                this.logChannel.log(10000000, "%1#formatDefaultTwoLines -- formatRequest contains no any useful information, show Offroad as default text", (Object)this.CLASS_NAME);
                if (locationFormattingRequest.areaInfo.isEmpty()) {
                    locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(this.env.getTranslatedText(13)));
                } else {
                    locationFormattingResponse.appendToFirstLine(locationFormattingRequest.areaInfo);
                    locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(" ("));
                    locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(this.env.getTranslatedText(13)));
                    locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(")"));
                }
            }
        } else {
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.district);
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.state);
            if (!locationFormattingRequest.city.isEmpty() && !locationFormattingRequest.city.equals(locationFormattingRequest.state)) {
                locationFormattingResponse.appendToSecondLine(this.emptySymbol);
                locationFormattingResponse.appendToSecondLine(locationFormattingRequest.city);
            }
        }
    }

    protected void formatFullAddressInformationForSecondLine(LocationFormattingRequest locationFormattingRequest, LocationFormattingResponse locationFormattingResponse) {
        this.formatThreeLevelCityForSecondLine(locationFormattingRequest, locationFormattingResponse);
        if (!locationFormattingRequest.street.isEmpty() || !locationFormattingRequest.houseNumber.isEmpty()) {
            if (!Util.isEmpty(locationFormattingResponse.getSecondLineAsText())) {
                locationFormattingResponse.appendToSecondLine(this.emptySymbol);
            }
        } else {
            return;
        }
        if (!locationFormattingRequest.street.isEmpty() && !locationFormattingRequest.houseNumber.isEmpty()) {
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.street);
            locationFormattingResponse.appendToSecondLine(this.emptySymbol);
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.houseNumber);
        } else {
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.street);
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.houseNumber);
        }
    }

    protected void formatThreeLevelCityForSecondLine(LocationFormattingRequest locationFormattingRequest, LocationFormattingResponse locationFormattingResponse) {
        if (!locationFormattingRequest.state.isEmpty()) {
            if (!locationFormattingRequest.city.isEmpty() && !locationFormattingRequest.state.equals(locationFormattingRequest.city)) {
                locationFormattingResponse.appendToSecondLine(locationFormattingRequest.state);
                locationFormattingResponse.appendToSecondLine(this.emptySymbol);
                locationFormattingResponse.appendToSecondLine(locationFormattingRequest.city);
            } else {
                locationFormattingResponse.appendToSecondLine(locationFormattingRequest.state);
            }
            if (!locationFormattingRequest.district.isEmpty()) {
                locationFormattingResponse.appendToSecondLine(this.emptySymbol);
                locationFormattingResponse.appendToSecondLine(locationFormattingRequest.district);
            }
        } else if (!locationFormattingRequest.city.isEmpty() && !locationFormattingRequest.district.isEmpty()) {
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.city);
            locationFormattingResponse.appendToSecondLine(this.emptySymbol);
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.district);
        } else {
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.city);
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.district);
        }
    }
}

