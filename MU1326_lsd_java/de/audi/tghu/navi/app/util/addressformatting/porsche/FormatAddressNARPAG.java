/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util.addressformatting.porsche;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.util.addressformatting.FormattedHighlightedText;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingRequest;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingResponse;
import de.audi.tghu.navi.app.util.addressformatting.porsche.FormatAddressPAG;

public class FormatAddressNARPAG
extends FormatAddressPAG {
    public FormatAddressNARPAG(NavigationEnv navigationEnv) {
        super(navigationEnv);
    }

    @Override
    protected LocationFormattingResponse asTwoLines(LocationFormattingRequest locationFormattingRequest) {
        if (!locationFormattingRequest.poiName.isEmpty()) {
            return this.formatPoi(locationFormattingRequest);
        }
        if (locationFormattingRequest.locationType == 4) {
            return this.formatCityCenterAddress(locationFormattingRequest);
        }
        if (locationFormattingRequest.locationType == 0 && locationFormattingRequest.city.isEmpty() && locationFormattingRequest.cityPart.isEmpty()) {
            return this.formattingFallback();
        }
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "%1#asTwoLines -- returning default result", (Object)this.CLASS_NAME);
        }
        return this.formatDefault(locationFormattingRequest);
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
        LocationFormattingResponse locationFormattingResponse2 = this.formatDefault(locationFormattingRequest);
        if (locationFormattingResponse.getFirstLineList().isEmpty()) {
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

    protected LocationFormattingResponse formatCityCenterAddress(LocationFormattingRequest locationFormattingRequest) {
        LocationFormattingResponse locationFormattingResponse = new LocationFormattingResponse();
        if (!locationFormattingRequest.city.isEmpty()) {
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.city);
        }
        locationFormattingResponse.appendToSecondLine(new FormattedHighlightedText(this.env.getTranslatedText(5)));
        return locationFormattingResponse;
    }

    protected LocationFormattingResponse formatPoi(LocationFormattingRequest locationFormattingRequest) {
        LocationFormattingResponse locationFormattingResponse = new LocationFormattingResponse();
        if (!locationFormattingRequest.poiName.isEmpty()) {
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.poiName);
            if (!locationFormattingRequest.poiCategory.isEmpty() && !this.isCategoryInPoiName(locationFormattingRequest.poiName, locationFormattingRequest.poiCategory)) {
                locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(" ("));
                locationFormattingResponse.appendToFirstLine(locationFormattingRequest.poiCategory);
                locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(")"));
            }
        }
        this.formatSecondlinefortwoLines(locationFormattingRequest, locationFormattingResponse);
        return locationFormattingResponse;
    }

    protected LocationFormattingResponse formatDefault(LocationFormattingRequest locationFormattingRequest) {
        boolean bl;
        LocationFormattingResponse locationFormattingResponse = new LocationFormattingResponse();
        boolean bl2 = bl = !locationFormattingRequest.street.isEmpty();
        if (!locationFormattingRequest.houseNumber.isEmpty()) {
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.houseNumber);
            locationFormattingResponse.appendToFirstLine(this.emptySymbol);
        }
        if (bl) {
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.street);
        }
        if (!locationFormattingRequest.junction.isEmpty()) {
            locationFormattingResponse.appendToFirstLine(this.slashSymbol);
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.junction);
        }
        if (!locationFormattingRequest.city.isEmpty()) {
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.city);
        }
        if (!locationFormattingRequest.cityPart.isEmpty()) {
            if (!locationFormattingRequest.city.isEmpty()) {
                locationFormattingResponse.appendToSecondLine(this.commaSymbol);
            }
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.cityPart);
        }
        if (!this.getStateFormatted(locationFormattingRequest).isEmpty()) {
            if (!locationFormattingResponse.getSecondLineList().isEmpty()) {
                locationFormattingResponse.appendToSecondLine(this.commaSymbol);
            }
            locationFormattingResponse.appendToSecondLine(this.getStateFormatted(locationFormattingRequest));
            if (!locationFormattingRequest.zip.isEmpty()) {
                locationFormattingResponse.appendToSecondLine(this.emptySymbol);
                locationFormattingResponse.appendToSecondLine(locationFormattingRequest.zip);
            }
        }
        if (!locationFormattingRequest.countryAbbreviation.isEmpty()) {
            if (!locationFormattingResponse.getSecondLineList().isEmpty()) {
                locationFormattingResponse.appendToSecondLine(this.commaSymbol);
            }
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.countryAbbreviation);
        }
        if (!bl) {
            locationFormattingResponse.swapLines();
        }
        if (!this.isUsefulLocationInfoSet(locationFormattingRequest) && locationFormattingRequest.contactOrFavoriteName.isEmpty()) {
            if (locationFormattingRequest.areaInfo.isEmpty()) {
                return this.formattingFallback();
            }
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.areaInfo);
            locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(" ("));
            locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(this.env.getTranslatedText(13)));
            locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(")"));
        }
        return locationFormattingResponse;
    }

    private FormattedHighlightedText getStateFormatted(LocationFormattingRequest locationFormattingRequest) {
        if (!locationFormattingRequest.stateAbbreviation.isEmpty()) {
            return locationFormattingRequest.stateAbbreviation;
        }
        return locationFormattingRequest.state;
    }

    protected void formatSecondlinefortwoLines(LocationFormattingRequest locationFormattingRequest, LocationFormattingResponse locationFormattingResponse) {
        locationFormattingResponse.replaceSecondLine(this.formatDefault(locationFormattingRequest).createOneLineLocationFormattingResponse().getFirstLineList());
    }

    @Override
    protected LocationFormattingResponse asSingleLine(LocationFormattingRequest locationFormattingRequest) {
        LocationFormattingResponse locationFormattingResponse = this.asTwoLines(locationFormattingRequest);
        return locationFormattingResponse.createOneLineLocationFormattingResponse();
    }
}

