/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util.addressformatting.porsche;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.util.Util;
import de.audi.tghu.navi.app.util.addressformatting.FormattedHighlightedText;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingRequest;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingResponse;
import de.audi.tghu.navi.app.util.addressformatting.porsche.FormatAddressAsiaEnglishPAG;

public class FormatAddressKREnglishPAG
extends FormatAddressAsiaEnglishPAG {
    public FormatAddressKREnglishPAG(NavigationEnv navigationEnv) {
        super(navigationEnv);
    }

    protected void formatStreet(LocationFormattingRequest locationFormattingRequest, LocationFormattingResponse locationFormattingResponse) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "%1#formatStreet House number is empty = %2", (Object)this.CLASS_NAME, (Object)Boolean.toString(locationFormattingRequest.houseNumber.isEmpty()));
        }
        if (locationFormattingRequest.houseNumber.isEmpty()) {
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.street);
            if (!locationFormattingRequest.cityPart.isEmpty()) {
                locationFormattingResponse.appendToSecondLine(locationFormattingRequest.cityPart);
                locationFormattingResponse.appendToSecondLine(this.commaSymbol);
            }
            this.formatThreeLevelCityForSecondLine(locationFormattingRequest, locationFormattingResponse);
        } else {
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.houseNumber);
            locationFormattingResponse.appendToFirstLine(this.commaSymbol);
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.street);
            if (!locationFormattingRequest.cityPart.isEmpty()) {
                locationFormattingResponse.appendToSecondLine(locationFormattingRequest.cityPart);
                locationFormattingResponse.appendToSecondLine(this.commaSymbol);
            }
            this.formatThreeLevelCityForSecondLine(locationFormattingRequest, locationFormattingResponse);
        }
    }

    protected void formatDefaultTwoLines(LocationFormattingRequest locationFormattingRequest, LocationFormattingResponse locationFormattingResponse) {
        if (!locationFormattingRequest.cityPart.isEmpty()) {
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.cityPart);
            this.formatThreeLevelCityForSecondLine(locationFormattingRequest, locationFormattingResponse);
        } else if (!locationFormattingRequest.ward.isEmpty()) {
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.ward);
            if (!locationFormattingRequest.state.isEmpty() && !locationFormattingRequest.city.isEmpty()) {
                locationFormattingResponse.appendToSecondLine(locationFormattingRequest.city);
                locationFormattingResponse.appendToSecondLine(this.commaSymbol);
                locationFormattingResponse.appendToSecondLine(locationFormattingRequest.state);
            } else {
                locationFormattingResponse.appendToSecondLine(locationFormattingRequest.city);
                locationFormattingResponse.appendToSecondLine(locationFormattingRequest.state);
            }
        } else if (!locationFormattingRequest.city.isEmpty()) {
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.city);
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.state);
        } else if (!locationFormattingRequest.state.isEmpty()) {
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.state);
        } else if (locationFormattingRequest.areaInfo.isEmpty()) {
            locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(this.env.getTranslatedText(13)));
        } else {
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.areaInfo);
            locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(" ("));
            locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(this.env.getTranslatedText(13)));
            locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(")"));
        }
    }

    protected void formatFullAddressInformationForSecondLine(LocationFormattingRequest locationFormattingRequest, LocationFormattingResponse locationFormattingResponse) {
        if (!locationFormattingRequest.houseNumber.isEmpty()) {
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.houseNumber);
            if (!locationFormattingRequest.street.isEmpty() && !locationFormattingRequest.cityPart.isEmpty()) {
                locationFormattingResponse.appendToSecondLine(this.commaSymbol);
                locationFormattingResponse.appendToSecondLine(locationFormattingRequest.street);
                locationFormattingResponse.appendToSecondLine(this.commaSymbol);
                locationFormattingResponse.appendToSecondLine(locationFormattingRequest.cityPart);
            } else if (!locationFormattingRequest.street.isEmpty() || !locationFormattingRequest.cityPart.isEmpty()) {
                locationFormattingResponse.appendToSecondLine(this.commaSymbol);
                locationFormattingResponse.appendToSecondLine(locationFormattingRequest.street);
                locationFormattingResponse.appendToSecondLine(locationFormattingRequest.cityPart);
            }
        } else if (!locationFormattingRequest.street.isEmpty() && !locationFormattingRequest.cityPart.isEmpty()) {
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.street);
            locationFormattingResponse.appendToSecondLine(this.commaSymbol);
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.cityPart);
        } else if (!locationFormattingRequest.street.isEmpty() || !locationFormattingRequest.cityPart.isEmpty()) {
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.street);
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.cityPart);
        }
        if (!(locationFormattingRequest.state.isEmpty() && locationFormattingRequest.city.isEmpty() && locationFormattingRequest.ward.isEmpty())) {
            if (!Util.isEmpty(locationFormattingResponse.getSecondLineAsText())) {
                locationFormattingResponse.appendToSecondLine(this.commaSymbol);
            }
            this.formatThreeLevelCityForSecondLine(locationFormattingRequest, locationFormattingResponse);
        }
    }

    protected void formatThreeLevelCityForSecondLine(LocationFormattingRequest locationFormattingRequest, LocationFormattingResponse locationFormattingResponse) {
        if (!locationFormattingRequest.ward.isEmpty()) {
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.ward);
            if (!locationFormattingRequest.city.isEmpty() && !locationFormattingRequest.state.isEmpty()) {
                locationFormattingResponse.appendToSecondLine(this.commaSymbol);
                locationFormattingResponse.appendToSecondLine(locationFormattingRequest.city);
                locationFormattingResponse.appendToSecondLine(this.commaSymbol);
                locationFormattingResponse.appendToSecondLine(locationFormattingRequest.state);
            } else if (!locationFormattingRequest.city.isEmpty() || !locationFormattingRequest.state.isEmpty()) {
                locationFormattingResponse.appendToSecondLine(this.commaSymbol);
                locationFormattingResponse.appendToSecondLine(locationFormattingRequest.city);
                locationFormattingResponse.appendToSecondLine(locationFormattingRequest.state);
            }
        } else if (!locationFormattingRequest.city.isEmpty() && !locationFormattingRequest.state.isEmpty()) {
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.city);
            locationFormattingResponse.appendToSecondLine(this.commaSymbol);
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.state);
        } else if (!locationFormattingRequest.city.isEmpty() || !locationFormattingRequest.state.isEmpty()) {
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.city);
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.state);
        }
    }
}

