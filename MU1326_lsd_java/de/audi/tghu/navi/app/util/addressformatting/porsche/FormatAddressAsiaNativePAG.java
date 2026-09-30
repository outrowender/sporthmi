/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util.addressformatting.porsche;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.util.Util;
import de.audi.tghu.navi.app.util.addressformatting.FormatAddress;
import de.audi.tghu.navi.app.util.addressformatting.FormattedHighlightedText;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingRequest;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingResponse;

public abstract class FormatAddressAsiaNativePAG
extends FormatAddress {
    public FormatAddressAsiaNativePAG(NavigationEnv navigationEnv) {
        super(navigationEnv);
    }

    protected LocationFormattingResponse asTwoLines(LocationFormattingRequest locationFormattingRequest) {
        LocationFormattingResponse locationFormattingResponse = new LocationFormattingResponse();
        if (!locationFormattingRequest.contactOrFavoriteName.isEmpty()) {
            this.formatContactOrFavourite(locationFormattingRequest, locationFormattingResponse);
        } else if (!locationFormattingRequest.poiName.isEmpty()) {
            this.formatPOI(locationFormattingRequest, locationFormattingResponse);
        } else {
            this.formatStreetAndHouseNumber(locationFormattingRequest, locationFormattingResponse);
        }
        return locationFormattingResponse;
    }

    protected LocationFormattingResponse asThreeLines(LocationFormattingRequest locationFormattingRequest) {
        LocationFormattingResponse locationFormattingResponse = new LocationFormattingResponse();
        this.appendToFirstLineContactFavOrPOIName(locationFormattingRequest, locationFormattingResponse);
        LocationFormattingResponse locationFormattingResponse2 = new LocationFormattingResponse();
        this.formatStreetAndHouseNumber(locationFormattingRequest, locationFormattingResponse2);
        if (!Util.isHURegionJP()) {
            locationFormattingResponse2.swapLines();
        }
        if (this.swapIfFirstLineIsEmpty(locationFormattingResponse, locationFormattingResponse2)) {
            return locationFormattingResponse2;
        }
        this.appendToSecondAndThirdLine(locationFormattingResponse, locationFormattingResponse2);
        return locationFormattingResponse;
    }

    protected boolean swapIfFirstLineIsEmpty(LocationFormattingResponse locationFormattingResponse, LocationFormattingResponse locationFormattingResponse2) {
        if (locationFormattingResponse.getFirstLineList().isEmpty()) {
            if (locationFormattingResponse2.getFirstLineList().isEmpty()) {
                locationFormattingResponse2.swapLines();
            }
            return true;
        }
        return false;
    }

    protected void appendToSecondAndThirdLine(LocationFormattingResponse locationFormattingResponse, LocationFormattingResponse locationFormattingResponse2) {
        int n;
        for (n = 0; n < locationFormattingResponse2.getFirstLineList().size(); ++n) {
            locationFormattingResponse.appendToSecondLine((FormattedHighlightedText)locationFormattingResponse2.getFirstLineList().get(n));
        }
        for (n = 0; n < locationFormattingResponse2.getSecondLineList().size(); ++n) {
            locationFormattingResponse.appendToThirdLine((FormattedHighlightedText)locationFormattingResponse2.getSecondLineList().get(n));
        }
    }

    protected void formatStreetAndHouseNumber(LocationFormattingRequest locationFormattingRequest, LocationFormattingResponse locationFormattingResponse) {
        if (!locationFormattingRequest.street.isEmpty()) {
            this.formatAddressWhenStreetExists(locationFormattingRequest, locationFormattingResponse);
        } else if (locationFormattingRequest.street.isEmpty() && !locationFormattingRequest.houseNumber.isEmpty()) {
            this.formatAddressWhenHouseNumberExists(locationFormattingRequest, locationFormattingResponse);
        } else {
            this.formatDefaultTwoLines(locationFormattingRequest, locationFormattingResponse);
        }
    }

    protected void appendToFirstLineContactFavOrPOIName(LocationFormattingRequest locationFormattingRequest, LocationFormattingResponse locationFormattingResponse) {
        if (!locationFormattingRequest.contactOrFavoriteName.isEmpty()) {
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.contactOrFavoriteName);
        } else if (!locationFormattingRequest.poiName.isEmpty()) {
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.poiName);
        }
    }

    protected void formatContactOrFavourite(LocationFormattingRequest locationFormattingRequest, LocationFormattingResponse locationFormattingResponse) {
        locationFormattingResponse.appendToFirstLine(locationFormattingRequest.contactOrFavoriteName);
        this.formatFullAddressInformationForSecondLine(locationFormattingRequest, locationFormattingResponse);
    }

    protected void formatPOI(LocationFormattingRequest locationFormattingRequest, LocationFormattingResponse locationFormattingResponse) {
        if (!locationFormattingRequest.poiCategory.isEmpty()) {
            if (this.logChannel.isDebug2()) {
                this.logChannel.log(100000000, "%1#formatPOI -- poiCategory isn't empty", (Object)this.CLASS_NAME);
            }
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.poiName);
            this.formatFullAddressInformationForSecondLine(locationFormattingRequest, locationFormattingResponse);
        } else {
            if (this.logChannel.isDebug2()) {
                this.logChannel.log(100000000, "%1#formatPOI -- poiCategory is empty.", (Object)this.CLASS_NAME);
            }
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.poiName);
            this.formatFullAddressInformationForSecondLine(locationFormattingRequest, locationFormattingResponse);
        }
    }

    protected void formatAddressWhenHouseNumberExists(LocationFormattingRequest locationFormattingRequest, LocationFormattingResponse locationFormattingResponse) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "%1#formatHouseNumber formatRequest: %2", (Object)this.CLASS_NAME, (Object)locationFormattingRequest);
        }
        if (Util.isHURegionJP()) {
            this.formatThreeLevelCityForSecondLine(locationFormattingRequest, locationFormattingResponse);
            locationFormattingResponse.swapLines();
            if (!locationFormattingRequest.cityPart.isEmpty()) {
                locationFormattingResponse.appendToSecondLine(locationFormattingRequest.cityPart);
                locationFormattingResponse.appendToSecondLine(this.emptySymbol);
            }
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.houseNumber);
            this.logChannel.log(100000000, "%1#formatHouseNumber JP: %2 %3", (Object)this.CLASS_NAME, (Object)locationFormattingResponse.getFirstLineAsText(), (Object)locationFormattingResponse.getSecondLineAsText());
        } else {
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.houseNumber);
            if (!locationFormattingRequest.cityPart.isEmpty()) {
                locationFormattingResponse.appendToSecondLine(locationFormattingRequest.cityPart);
            }
            this.formatThreeLevelCityForSecondLine(locationFormattingRequest, locationFormattingResponse);
        }
    }

    protected LocationFormattingResponse asSingleLine(LocationFormattingRequest locationFormattingRequest) {
        LocationFormattingResponse locationFormattingResponse = new LocationFormattingResponse();
        LocationFormattingResponse locationFormattingResponse2 = new LocationFormattingResponse();
        if (!locationFormattingRequest.contactOrFavoriteName.isEmpty() || !locationFormattingRequest.poiName.isEmpty()) {
            locationFormattingResponse2 = this.asTwoLines(locationFormattingRequest);
            locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(locationFormattingResponse2.getFirstLineAsText()));
        } else if (!locationFormattingRequest.street.isEmpty() || !locationFormattingRequest.houseNumber.isEmpty()) {
            locationFormattingResponse2 = this.asTwoLines(locationFormattingRequest);
            if ((Util.isHURegionJP() || Util.isHURegionKR()) && !locationFormattingResponse2.getSecondLineList().isEmpty()) {
                locationFormattingResponse2.swapLines();
            }
            String string = locationFormattingResponse2.getFirstLineAsText();
            String string2 = locationFormattingResponse2.getSecondLineAsText();
            if (!Util.isEmpty(string) && !Util.isEmpty(string2)) {
                locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(string2));
                locationFormattingResponse.appendToFirstLine(this.emptySymbol);
                locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(string));
            } else {
                locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(string2));
                locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(string));
            }
        } else {
            this.formatFullAddressInformationForSecondLine(locationFormattingRequest, locationFormattingResponse2);
            if (!Util.isEmpty(locationFormattingResponse2.getSecondLineAsText())) {
                locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(locationFormattingResponse2.getSecondLineAsText()));
            } else if (locationFormattingRequest.areaInfo.isEmpty()) {
                locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(this.env.getTranslatedText(13)));
            } else {
                locationFormattingResponse.appendToFirstLine(locationFormattingRequest.areaInfo);
                locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(" ("));
                locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(this.env.getTranslatedText(13)));
                locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(")"));
            }
        }
        return locationFormattingResponse;
    }

    protected abstract void formatAddressWhenStreetExists(LocationFormattingRequest var1, LocationFormattingResponse var2);

    protected abstract void formatDefaultTwoLines(LocationFormattingRequest var1, LocationFormattingResponse var2);

    protected abstract void formatFullAddressInformationForSecondLine(LocationFormattingRequest var1, LocationFormattingResponse var2);

    protected abstract void formatThreeLevelCityForSecondLine(LocationFormattingRequest var1, LocationFormattingResponse var2);
}

