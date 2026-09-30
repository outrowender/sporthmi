/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util.addressformatting.porsche;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.util.addressformatting.FormattedHighlightedText;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingRequest;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingResponse;
import de.audi.tghu.navi.app.util.addressformatting.porsche.FormatAddressPAG;

public class FormatAddressEUPAG
extends FormatAddressPAG {
    public FormatAddressEUPAG(NavigationEnv navigationEnv) {
        super(navigationEnv);
    }

    protected LocationFormattingResponse asTwoLines(LocationFormattingRequest locationFormattingRequest) {
        if (!locationFormattingRequest.contactOrFavoriteName.isEmpty()) {
            if (this.logChannel.isDebug2()) {
                this.logChannel.log(100000000, "%1#asTwoLines -- contactOrFavorite", (Object)this.CLASS_NAME);
            }
            return this.formatContactOrFavorite(locationFormattingRequest);
        }
        if (!locationFormattingRequest.poiName.isEmpty()) {
            if (this.logChannel.isDebug2()) {
                this.logChannel.log(100000000, "%1#asTwoLines -- Poi", (Object)this.CLASS_NAME);
            }
            return this.formatPoi(locationFormattingRequest);
        }
        if (locationFormattingRequest.locationType == 4) {
            if (this.logChannel.isDebug2()) {
                this.logChannel.log(100000000, "%1#asTwoLines -- city center", (Object)this.CLASS_NAME);
            }
            return this.formatCityCenterAddress(locationFormattingRequest);
        }
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "%1#asTwoLines -- returning default result", (Object)this.CLASS_NAME);
        }
        return this.formatDefault(locationFormattingRequest);
    }

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

    protected LocationFormattingResponse formatContactOrFavorite(LocationFormattingRequest locationFormattingRequest) {
        LocationFormattingResponse locationFormattingResponse = new LocationFormattingResponse();
        locationFormattingResponse.appendToFirstLine(locationFormattingRequest.contactOrFavoriteName);
        this.formatSecondlinefortwoLines(locationFormattingRequest, locationFormattingResponse);
        return locationFormattingResponse;
    }

    private LocationFormattingResponse formatCityCenterAddress(LocationFormattingRequest locationFormattingRequest) {
        LocationFormattingResponse locationFormattingResponse = new LocationFormattingResponse();
        this.formatCityandRefinement(locationFormattingRequest, locationFormattingResponse);
        if (!locationFormattingRequest.zip.isEmpty()) {
            locationFormattingResponse.appendToFirstLine(this.commaSymbol);
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.zip);
        }
        locationFormattingResponse.appendToSecondLine(new FormattedHighlightedText(this.env.getTranslatedText(5)));
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
        this.formatSecondlinefortwoLines(locationFormattingRequest, locationFormattingResponse);
        return locationFormattingResponse;
    }

    private LocationFormattingResponse formatDefault(LocationFormattingRequest locationFormattingRequest) {
        boolean bl;
        LocationFormattingResponse locationFormattingResponse = new LocationFormattingResponse();
        boolean bl2 = bl = !locationFormattingRequest.street.isEmpty();
        if (bl) {
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.street);
        }
        if (!locationFormattingRequest.houseNumber.isEmpty()) {
            locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(" "));
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.houseNumber);
        }
        if (!locationFormattingRequest.junction.isEmpty()) {
            locationFormattingResponse.appendToFirstLine(this.slashSymbol);
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.junction);
        }
        if (!locationFormattingRequest.zip.isEmpty()) {
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.zip);
            locationFormattingResponse.appendToSecondLine(this.emptySymbol);
        }
        if (!locationFormattingRequest.cityPart.isEmpty()) {
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.cityPart);
        }
        if (!locationFormattingRequest.city.isEmpty()) {
            if (!locationFormattingRequest.cityPart.isEmpty()) {
                locationFormattingResponse.appendToSecondLine(this.commaSymbol);
            }
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.city);
        }
        if (!locationFormattingRequest.state.isEmpty() && locationFormattingRequest.state.isHighlighted()) {
            locationFormattingResponse.appendToSecondLine(this.commaSymbol);
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.state);
        }
        if (!bl) {
            locationFormattingResponse.swapLines();
        }
        if (!this.isUsefulLocationInfoSet(locationFormattingRequest)) {
            if (locationFormattingRequest.areaInfo.isEmpty()) {
                return this.formattingFallback();
            }
            return this.formattinArea(locationFormattingRequest);
        }
        return locationFormattingResponse;
    }

    private void formatSecondlinefortwoLines(LocationFormattingRequest locationFormattingRequest, LocationFormattingResponse locationFormattingResponse) {
        if (!locationFormattingRequest.street.isEmpty()) {
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.street);
            if (!locationFormattingRequest.houseNumber.isEmpty()) {
                locationFormattingResponse.appendToSecondLine(this.emptySymbol);
                locationFormattingResponse.appendToSecondLine(locationFormattingRequest.houseNumber);
            } else if (!locationFormattingRequest.junction.isEmpty()) {
                locationFormattingResponse.appendToSecondLine(this.slashSymbol);
                locationFormattingResponse.appendToSecondLine(locationFormattingRequest.junction);
            }
            locationFormattingResponse.appendToSecondLine(this.commaSymbol);
        }
        this.formatCityandRefinementforSecondLine(locationFormattingRequest, locationFormattingResponse);
        if (!locationFormattingRequest.zip.isEmpty()) {
            locationFormattingResponse.appendToSecondLine(this.emptySymbol);
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.zip);
        }
    }

    protected LocationFormattingResponse asSingleLine(LocationFormattingRequest locationFormattingRequest) {
        LocationFormattingResponse locationFormattingResponse = new LocationFormattingResponse();
        if (!locationFormattingRequest.contactOrFavoriteName.isEmpty()) {
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.contactOrFavoriteName);
        } else if (!locationFormattingRequest.poiName.isEmpty()) {
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.poiName);
            if (!locationFormattingRequest.poiCategory.isEmpty() && !this.isCategoryInPoiName(locationFormattingRequest.poiName, locationFormattingRequest.poiCategory)) {
                locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(" ("));
                locationFormattingResponse.appendToFirstLine(locationFormattingRequest.poiCategory);
                locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(")"));
            }
        }
        if (!locationFormattingRequest.street.isEmpty()) {
            if (!locationFormattingResponse.getFirstLineList().isEmpty()) {
                locationFormattingResponse.appendToFirstLine(this.commaSymbol);
            }
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.street);
            if (!locationFormattingRequest.houseNumber.isEmpty()) {
                locationFormattingResponse.appendToFirstLine(this.emptySymbol);
                locationFormattingResponse.appendToFirstLine(locationFormattingRequest.houseNumber);
            } else if (!locationFormattingRequest.junction.isEmpty()) {
                locationFormattingResponse.appendToFirstLine(this.slashSymbol);
                locationFormattingResponse.appendToFirstLine(locationFormattingRequest.junction);
            }
        }
        if (!locationFormattingResponse.getFirstLineList().isEmpty() && !locationFormattingRequest.city.isEmpty()) {
            locationFormattingResponse.appendToFirstLine(this.commaSymbol);
        }
        this.formatCityandRefinement(locationFormattingRequest, locationFormattingResponse);
        if (!this.isUsefulLocationInfoSet(locationFormattingRequest) && locationFormattingRequest.contactOrFavoriteName.isEmpty()) {
            if (locationFormattingRequest.areaInfo.isEmpty()) {
                return this.formattingFallback();
            }
            if (!locationFormattingResponse.getFirstLineList().isEmpty()) {
                locationFormattingResponse.appendToFirstLine(this.commaSymbol);
            }
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.areaInfo);
            locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(" ("));
            locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(this.env.getTranslatedText(13)));
            locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(")"));
        }
        return locationFormattingResponse;
    }
}

