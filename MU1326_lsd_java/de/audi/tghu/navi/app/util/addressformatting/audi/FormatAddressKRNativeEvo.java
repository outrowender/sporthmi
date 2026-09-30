/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util.addressformatting.audi;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.util.Util;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingRequest;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingResponse;
import de.audi.tghu.navi.app.util.addressformatting.audi.FormatAddressAsiaNativeEvo;

public class FormatAddressKRNativeEvo
extends FormatAddressAsiaNativeEvo {
    public FormatAddressKRNativeEvo(NavigationEnv navigationEnv) {
        super(navigationEnv);
    }

    protected void formatStreet(LocationFormattingRequest locationFormattingRequest, LocationFormattingResponse locationFormattingResponse) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "%1#formatStreet House number is empty = %2", (Object)this.CLASS_NAME, (Object)Boolean.toString(locationFormattingRequest.houseNumber.isEmpty()));
        }
        if (locationFormattingRequest.houseNumber.isEmpty()) {
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.street);
            this.formatThreeLevelCityForSecondLine(locationFormattingRequest, locationFormattingResponse);
            if (!locationFormattingRequest.cityPart.isEmpty()) {
                locationFormattingResponse.appendToSecondLine(this.emptySymbol);
                locationFormattingResponse.appendToSecondLine(locationFormattingRequest.cityPart);
            }
        } else {
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.street);
            locationFormattingResponse.appendToFirstLine(this.emptySymbol);
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.houseNumber);
            this.formatThreeLevelCityForSecondLine(locationFormattingRequest, locationFormattingResponse);
            if (!locationFormattingRequest.cityPart.isEmpty()) {
                locationFormattingResponse.appendToSecondLine(this.emptySymbol);
                locationFormattingResponse.appendToSecondLine(locationFormattingRequest.cityPart);
            }
        }
    }

    protected void formatDefaultTwoLines(LocationFormattingRequest locationFormattingRequest, LocationFormattingResponse locationFormattingResponse) {
        if (!locationFormattingRequest.cityPart.isEmpty()) {
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.cityPart);
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
        } else {
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.state);
        }
    }

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

    protected void formatThreeLevelCityForSecondLine(LocationFormattingRequest locationFormattingRequest, LocationFormattingResponse locationFormattingResponse) {
        if (!locationFormattingRequest.state.isEmpty()) {
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.state);
            if (!locationFormattingRequest.city.isEmpty() && !locationFormattingRequest.ward.isEmpty()) {
                locationFormattingResponse.appendToSecondLine(this.emptySymbol);
                locationFormattingResponse.appendToSecondLine(locationFormattingRequest.city);
                locationFormattingResponse.appendToSecondLine(this.emptySymbol);
                locationFormattingResponse.appendToSecondLine(locationFormattingRequest.ward);
            } else if (!locationFormattingRequest.city.isEmpty() || !locationFormattingRequest.ward.isEmpty()) {
                locationFormattingResponse.appendToSecondLine(this.emptySymbol);
                locationFormattingResponse.appendToSecondLine(locationFormattingRequest.city);
                locationFormattingResponse.appendToSecondLine(locationFormattingRequest.ward);
            }
        } else if (!locationFormattingRequest.city.isEmpty() && !locationFormattingRequest.ward.isEmpty()) {
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.city);
            locationFormattingResponse.appendToSecondLine(this.emptySymbol);
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.ward);
        } else if (!locationFormattingRequest.city.isEmpty() || !locationFormattingRequest.ward.isEmpty()) {
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.city);
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.ward);
        }
    }
}

