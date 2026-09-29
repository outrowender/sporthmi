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

public abstract class FormatAddressAsiaEnglishPAG
extends FormatAddress {
    public FormatAddressAsiaEnglishPAG(NavigationEnv navigationEnv) {
        super(navigationEnv);
    }

    @Override
    protected LocationFormattingResponse asTwoLines(LocationFormattingRequest locationFormattingRequest) {
        LocationFormattingResponse locationFormattingResponse = new LocationFormattingResponse();
        if (!locationFormattingRequest.contactOrFavoriteName.isEmpty()) {
            this.formatContactOrFavorite(locationFormattingRequest, locationFormattingResponse);
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
        int n;
        LocationFormattingResponse locationFormattingResponse = new LocationFormattingResponse();
        if (!locationFormattingRequest.contactOrFavoriteName.isEmpty()) {
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.contactOrFavoriteName);
        } else if (!locationFormattingRequest.poiName.isEmpty()) {
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.poiName);
        }
        LocationFormattingResponse locationFormattingResponse2 = new LocationFormattingResponse();
        if (!locationFormattingRequest.street.isEmpty()) {
            this.formatStreet(locationFormattingRequest, locationFormattingResponse2);
        } else if (locationFormattingRequest.street.isEmpty() && !locationFormattingRequest.houseNumber.isEmpty()) {
            this.formatHouseNumber(locationFormattingRequest, locationFormattingResponse2);
        } else {
            this.formatDefaultTwoLines(locationFormattingRequest, locationFormattingResponse2);
        }
        if (locationFormattingResponse.getFirstLineList().isEmpty()) {
            if (locationFormattingResponse2.getFirstLineList().isEmpty()) {
                locationFormattingResponse2.swapLines();
            }
            return locationFormattingResponse2;
        }
        for (n = 0; n < locationFormattingResponse2.getFirstLineList().size(); ++n) {
            locationFormattingResponse.appendToSecondLine((FormattedHighlightedText)locationFormattingResponse2.getFirstLineList().get(n));
        }
        for (n = 0; n < locationFormattingResponse2.getSecondLineList().size(); ++n) {
            locationFormattingResponse.appendToThirdLine((FormattedHighlightedText)locationFormattingResponse2.getSecondLineList().get(n));
        }
        return locationFormattingResponse;
    }

    protected void formatContactOrFavorite(LocationFormattingRequest locationFormattingRequest, LocationFormattingResponse locationFormattingResponse) {
        locationFormattingResponse.appendToFirstLine(locationFormattingRequest.contactOrFavoriteName);
        this.formatFullAddressInformationForSecondLine(locationFormattingRequest, locationFormattingResponse);
    }

    protected void formatPOI(LocationFormattingRequest locationFormattingRequest, LocationFormattingResponse locationFormattingResponse) {
        if (!locationFormattingRequest.poiCategory.isEmpty()) {
            if (this.logChannel.isDebug2()) {
                this.logChannel.log(14808325, "%1#formatPOI -- poiCategory isn't empty", (Object)this.CLASS_NAME);
            }
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.poiName);
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
        locationFormattingResponse.appendToFirstLine(locationFormattingRequest.houseNumber);
        if (!locationFormattingRequest.cityPart.isEmpty()) {
            locationFormattingResponse.appendToFirstLine(this.commaSymbol);
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.cityPart);
        }
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
                locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(string));
                locationFormattingResponse.appendToFirstLine(this.commaSymbol);
                locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(string2));
            } else {
                locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(string));
                locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(string2));
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

    protected abstract void formatStreet(LocationFormattingRequest locationFormattingRequest, LocationFormattingResponse locationFormattingResponse) {
    }

    protected abstract void formatFullAddressInformationForSecondLine(LocationFormattingRequest locationFormattingRequest, LocationFormattingResponse locationFormattingResponse) {
    }

    protected abstract void formatThreeLevelCityForSecondLine(LocationFormattingRequest locationFormattingRequest, LocationFormattingResponse locationFormattingResponse) {
    }

    protected abstract void formatDefaultTwoLines(LocationFormattingRequest locationFormattingRequest, LocationFormattingResponse locationFormattingResponse) {
    }
}

