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

public class FormatAddressJPNativePAG
extends FormatAddressAsiaNativePAG {
    public FormatAddressJPNativePAG(NavigationEnv navigationEnv) {
        super(navigationEnv);
    }

    @Override
    protected void formatAddressWhenStreetExists(LocationFormattingRequest locationFormattingRequest, LocationFormattingResponse locationFormattingResponse) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "%1#formatStreet House number is empty = %2", (Object)this.CLASS_NAME, (Object)Boolean.toString(locationFormattingRequest.houseNumber.isEmpty()));
        }
        if (!locationFormattingRequest.cityPart.isEmpty()) {
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.cityPart);
            locationFormattingResponse.appendToFirstLine(this.emptySymbol);
        }
        locationFormattingResponse.appendToFirstLine(locationFormattingRequest.street);
        if (!locationFormattingRequest.houseNumber.isEmpty()) {
            locationFormattingResponse.appendToFirstLine(this.emptySymbol);
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.houseNumber);
        }
        this.formatThreeLevelCityForSecondLine(locationFormattingRequest, locationFormattingResponse);
        locationFormattingResponse.swapLines();
    }

    @Override
    protected void formatDefaultTwoLines(LocationFormattingRequest locationFormattingRequest, LocationFormattingResponse locationFormattingResponse) {
        if (!locationFormattingRequest.cityPart.isEmpty()) {
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.cityPart);
            if (!locationFormattingRequest.street.isEmpty()) {
                locationFormattingResponse.appendToFirstLine(this.emptySymbol);
                locationFormattingResponse.appendToFirstLine(locationFormattingRequest.street);
            }
            if (!locationFormattingRequest.houseNumber.isEmpty()) {
                locationFormattingResponse.appendToFirstLine(this.emptySymbol);
                locationFormattingResponse.appendToFirstLine(locationFormattingRequest.houseNumber);
            }
            this.formatThreeLevelCityForSecondLine(locationFormattingRequest, locationFormattingResponse);
        } else if (!locationFormattingRequest.ward.isEmpty()) {
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.ward);
            if (!locationFormattingRequest.city.isEmpty() && !locationFormattingRequest.state.isEmpty()) {
                locationFormattingResponse.appendToSecondLine(locationFormattingRequest.state);
                locationFormattingResponse.appendToSecondLine(this.emptySymbol);
                locationFormattingResponse.appendToSecondLine(locationFormattingRequest.city);
            } else {
                locationFormattingResponse.appendToSecondLine(locationFormattingRequest.state);
                locationFormattingResponse.appendToSecondLine(locationFormattingRequest.city);
            }
        } else if (!locationFormattingRequest.city.isEmpty()) {
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.city);
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.state);
        } else if (!locationFormattingRequest.state.isEmpty()) {
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.state);
        } else if (locationFormattingRequest.areaInfo.isEmpty()) {
            locationFormattingResponse.appendToSecondLine(new FormattedHighlightedText(this.env.getTranslatedText(13)));
        } else {
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.areaInfo);
            locationFormattingResponse.appendToSecondLine(new FormattedHighlightedText(" ("));
            locationFormattingResponse.appendToSecondLine(new FormattedHighlightedText(this.env.getTranslatedText(13)));
            locationFormattingResponse.appendToSecondLine(new FormattedHighlightedText(")"));
        }
        locationFormattingResponse.swapLines();
    }

    @Override
    protected void formatFullAddressInformationForSecondLine(LocationFormattingRequest locationFormattingRequest, LocationFormattingResponse locationFormattingResponse) {
        this.formatThreeLevelCityForSecondLine(locationFormattingRequest, locationFormattingResponse);
        if (!(locationFormattingRequest.cityPart.isEmpty() && locationFormattingRequest.street.isEmpty() && locationFormattingRequest.houseNumber.isEmpty())) {
            if (!Util.isEmpty(locationFormattingResponse.getSecondLineAsText())) {
                locationFormattingResponse.appendToSecondLine(this.emptySymbol);
            }
        } else {
            return;
        }
        if (!locationFormattingRequest.cityPart.isEmpty()) {
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.cityPart);
            if (!locationFormattingRequest.street.isEmpty() && !locationFormattingRequest.houseNumber.isEmpty()) {
                locationFormattingResponse.appendToSecondLine(this.emptySymbol);
                locationFormattingResponse.appendToSecondLine(locationFormattingRequest.street);
                locationFormattingResponse.appendToSecondLine(this.emptySymbol);
                locationFormattingResponse.appendToSecondLine(locationFormattingRequest.houseNumber);
            } else if (!locationFormattingRequest.street.isEmpty() || !locationFormattingRequest.houseNumber.isEmpty()) {
                locationFormattingResponse.appendToSecondLine(this.emptySymbol);
                locationFormattingResponse.appendToSecondLine(locationFormattingRequest.street);
                locationFormattingResponse.appendToSecondLine(locationFormattingRequest.houseNumber);
            }
        } else if (!locationFormattingRequest.street.isEmpty() && !locationFormattingRequest.houseNumber.isEmpty()) {
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.street);
            locationFormattingResponse.appendToSecondLine(this.emptySymbol);
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.houseNumber);
        } else if (!locationFormattingRequest.street.isEmpty() || !locationFormattingRequest.houseNumber.isEmpty()) {
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.street);
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.houseNumber);
        }
    }

    @Override
    protected void formatThreeLevelCityForSecondLine(LocationFormattingRequest locationFormattingRequest, LocationFormattingResponse locationFormattingResponse) {
        if (!locationFormattingRequest.state.isEmpty()) {
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.state);
            locationFormattingResponse.appendToSecondLine(this.emptySymbol);
        }
        if (!locationFormattingRequest.city.isEmpty() && !locationFormattingRequest.ward.isEmpty()) {
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.city);
            locationFormattingResponse.appendToSecondLine(this.emptySymbol);
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.ward);
        } else if (!locationFormattingRequest.city.isEmpty() || !locationFormattingRequest.ward.isEmpty()) {
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.city);
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.ward);
        }
    }
}

