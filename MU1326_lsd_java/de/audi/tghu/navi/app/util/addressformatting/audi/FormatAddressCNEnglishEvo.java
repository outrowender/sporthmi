/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util.addressformatting.audi;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.util.Util;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingRequest;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingResponse;
import de.audi.tghu.navi.app.util.addressformatting.audi.FormatAddressAsiaEnglishEvo;

public class FormatAddressCNEnglishEvo
extends FormatAddressAsiaEnglishEvo {
    public FormatAddressCNEnglishEvo(NavigationEnv navigationEnv) {
        super(navigationEnv);
    }

    protected void formatStreet(LocationFormattingRequest locationFormattingRequest, LocationFormattingResponse locationFormattingResponse) {
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
                this.logChannel.log(10000000, "%1#formatDefaultTwoLines -- formatRequest contains no any useful information!", (Object)this.CLASS_NAME);
            }
        } else {
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.district);
            if (!locationFormattingRequest.city.isEmpty()) {
                locationFormattingResponse.appendToSecondLine(locationFormattingRequest.city);
                if (!locationFormattingRequest.state.isEmpty() && !locationFormattingRequest.state.equals(locationFormattingRequest.city)) {
                    locationFormattingResponse.appendToSecondLine(this.commaSymbol);
                    locationFormattingResponse.appendToSecondLine(locationFormattingRequest.state);
                }
            } else if (!locationFormattingRequest.state.isEmpty()) {
                locationFormattingResponse.appendToSecondLine(locationFormattingRequest.state);
            }
        }
    }

    protected void formatFullAddressInformationForSecondLine(LocationFormattingRequest locationFormattingRequest, LocationFormattingResponse locationFormattingResponse) {
        if (!locationFormattingRequest.houseNumber.isEmpty() && !locationFormattingRequest.street.isEmpty()) {
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.houseNumber);
            locationFormattingResponse.appendToSecondLine(this.emptySymbol);
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.street);
        } else {
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.houseNumber);
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.street);
        }
        if (!(locationFormattingRequest.state.isEmpty() && locationFormattingRequest.city.isEmpty() && locationFormattingRequest.district.isEmpty())) {
            if (!Util.isEmpty(locationFormattingResponse.getSecondLineAsText())) {
                locationFormattingResponse.appendToSecondLine(this.commaSymbol);
            }
            this.formatThreeLevelCityForSecondLine(locationFormattingRequest, locationFormattingResponse);
        }
    }

    protected void formatThreeLevelCityForSecondLine(LocationFormattingRequest locationFormattingRequest, LocationFormattingResponse locationFormattingResponse) {
        locationFormattingResponse.appendToSecondLine(locationFormattingRequest.district);
        if (!locationFormattingRequest.city.isEmpty()) {
            if (!locationFormattingRequest.district.isEmpty()) {
                locationFormattingResponse.appendToSecondLine(this.commaSymbol);
            }
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.city);
        }
        if (!locationFormattingRequest.state.isEmpty() && !locationFormattingRequest.state.equals(locationFormattingRequest.city)) {
            locationFormattingResponse.appendToSecondLine(this.commaSymbol);
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.state);
        }
    }
}

