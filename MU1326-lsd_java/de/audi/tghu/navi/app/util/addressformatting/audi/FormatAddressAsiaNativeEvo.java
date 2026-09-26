/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util.addressformatting.audi;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.util.Util;
import de.audi.tghu.navi.app.util.addressformatting.FormatAddress;
import de.audi.tghu.navi.app.util.addressformatting.FormattedHighlightedText;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingRequest;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingResponse;

public abstract class FormatAddressAsiaNativeEvo
extends FormatAddress {
    public FormatAddressAsiaNativeEvo(NavigationEnv navigationEnv) {
        super(navigationEnv);
    }

    @Override
    protected LocationFormattingResponse asTwoLines(LocationFormattingRequest locationFormattingRequest) {
        LocationFormattingResponse locationFormattingResponse = new LocationFormattingResponse();
        if (!locationFormattingRequest.contactOrFavoriteName.isEmpty()) {
            this.formatContactOrFavourite(locationFormattingRequest, locationFormattingResponse);
        } else if (!locationFormattingRequest.poiName.isEmpty()) {
            this.formatPOI(locationFormattingRequest, locationFormattingResponse);
        } else if (!locationFormattingRequest.street.isEmpty()) {
            this.formatStreet(locationFormattingRequest, locationFormattingResponse);
        } else if (locationFormattingRequest.street.isEmpty() && !locationFormattingRequest.houseNumber.isEmpty()) {
            this.formatHouseNumber(locationFormattingRequest, locationFormattingResponse);
        } else {
            this.formatDefaultTwoLines(locationFormattingRequest, locationFormattingResponse);
        }
        return locationFormattingResponse;
    }

    @Override
    protected LocationFormattingResponse asThreeLines(LocationFormattingRequest locationFormattingRequest) {
        return null;
    }

    protected void formatContactOrFavourite(LocationFormattingRequest locationFormattingRequest, LocationFormattingResponse locationFormattingResponse) {
        locationFormattingResponse.appendToFirstLine(locationFormattingRequest.contactOrFavoriteName);
        this.formatFullAddressInformationForSecondLine(locationFormattingRequest, locationFormattingResponse);
    }

    protected void formatPOI(LocationFormattingRequest locationFormattingRequest, LocationFormattingResponse locationFormattingResponse) {
        if (!locationFormattingRequest.poiCategory.isEmpty()) {
            if (this.logChannel.isDebug2()) {
                this.logChannel.log(14808325, "%1#formatPOI -- poiCategory isn't empty", (Object)this.CLASS_NAME);
            }
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.poiName);
            if (!this.isCategoryInPoiName(locationFormattingRequest.poiName, locationFormattingRequest.poiCategory)) {
                if (this.logChannel.isDebug2()) {
                    this.logChannel.log(14808325, "%1#formatPOI -- poiCategory isn't in POIName", (Object)this.CLASS_NAME);
                }
                locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(" ("));
                locationFormattingResponse.appendToFirstLine(locationFormattingRequest.poiCategory);
                locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(")"));
            }
            this.formatFullAddressInformationForSecondLine(locationFormattingRequest, locationFormattingResponse);
        } else {
            if (this.logChannel.isDebug2()) {
                this.logChannel.log(14808325, "%1#formatPOI -- poiCategory is empty.", (Object)this.CLASS_NAME);
            }
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.poiName);
            this.formatFullAddressInformationForSecondLine(locationFormattingRequest, locationFormattingResponse);
        }
    }

    private void formatHouseNumber(LocationFormattingRequest locationFormattingRequest, LocationFormattingResponse locationFormattingResponse) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "%1#formatHouseNumber", (Object)this.CLASS_NAME);
        }
        if (!locationFormattingRequest.cityPart.isEmpty()) {
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.cityPart);
            locationFormattingResponse.appendToFirstLine(this.emptySymbol);
        }
        locationFormattingResponse.appendToFirstLine(locationFormattingRequest.houseNumber);
        this.formatThreeLevelCityForSecondLine(locationFormattingRequest, locationFormattingResponse);
    }

    @Override
    protected LocationFormattingResponse asSingleLine(LocationFormattingRequest locationFormattingRequest) {
        LocationFormattingResponse locationFormattingResponse = new LocationFormattingResponse();
        LocationFormattingResponse locationFormattingResponse2 = new LocationFormattingResponse();
        if (!locationFormattingRequest.contactOrFavoriteName.isEmpty() || !locationFormattingRequest.poiName.isEmpty()) {
            locationFormattingResponse2 = this.asTwoLines(locationFormattingRequest);
            locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(locationFormattingResponse2.getFirstLineAsText()));
        } else if (!locationFormattingRequest.street.isEmpty() || !locationFormattingRequest.houseNumber.isEmpty()) {
            locationFormattingResponse2 = this.asTwoLines(locationFormattingRequest);
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
            locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(locationFormattingResponse2.getSecondLineAsText()));
        }
        return locationFormattingResponse;
    }

    protected abstract void formatStreet(LocationFormattingRequest locationFormattingRequest, LocationFormattingResponse locationFormattingResponse) {
    }

    protected abstract void formatDefaultTwoLines(LocationFormattingRequest locationFormattingRequest, LocationFormattingResponse locationFormattingResponse) {
    }

    protected abstract void formatFullAddressInformationForSecondLine(LocationFormattingRequest locationFormattingRequest, LocationFormattingResponse locationFormattingResponse) {
    }

    protected abstract void formatThreeLevelCityForSecondLine(LocationFormattingRequest locationFormattingRequest, LocationFormattingResponse locationFormattingResponse) {
    }
}

