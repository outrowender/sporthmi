/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util.addressformatting.pgen2;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.util.Util;
import de.audi.tghu.navi.app.util.addressformatting.FormattedHighlightedText;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingRequest;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingResponse;
import de.audi.tghu.navi.app.util.addressformatting.porsche.FormatAddressEUPAG;

public class FormatAddressEUPGen2
extends FormatAddressEUPAG {
    public FormatAddressEUPGen2(NavigationEnv navigationEnv) {
        super(navigationEnv);
    }

    protected LocationFormattingResponse asTwoLines(LocationFormattingRequest locationFormattingRequest) {
        if (!locationFormattingRequest.poiName.isEmpty()) {
            return this.formatPoi(locationFormattingRequest);
        }
        if (!locationFormattingRequest.contactOrFavoriteName.isEmpty()) {
            LocationFormattingResponse locationFormattingResponse = new LocationFormattingResponse();
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.contactOrFavoriteName);
            this.formatSecondlinefortwoLines(locationFormattingRequest, locationFormattingResponse);
            if (locationFormattingResponse.getSecondLineForTruffles().getText().length() == 0) {
                locationFormattingResponse.appendToSecondLine(new FormattedHighlightedText("(" + this.env.getTranslatedText(13) + ")"));
            }
            return locationFormattingResponse;
        }
        if (locationFormattingRequest.locationType == 4) {
            return this.formatCityCenterAddress(locationFormattingRequest);
        }
        return this.formatDefault(locationFormattingRequest);
    }

    private LocationFormattingResponse formatCityCenterAddress(LocationFormattingRequest locationFormattingRequest) {
        LocationFormattingResponse locationFormattingResponse = new LocationFormattingResponse();
        this.formatCityandRefinement(locationFormattingRequest, locationFormattingResponse);
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
        LocationFormattingResponse locationFormattingResponse = new LocationFormattingResponse();
        if (!locationFormattingRequest.street.isEmpty()) {
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.street);
            if (!locationFormattingRequest.houseNumber.isEmpty()) {
                locationFormattingResponse.appendToFirstLine(this.emptySymbol);
                locationFormattingResponse.appendToFirstLine(locationFormattingRequest.houseNumber);
            } else if (!locationFormattingRequest.junction.isEmpty()) {
                locationFormattingResponse.appendToFirstLine(this.slashSymbol);
                locationFormattingResponse.appendToFirstLine(locationFormattingRequest.junction);
            }
        }
        this.formatCityandRefinementforSecondLine(locationFormattingRequest, locationFormattingResponse);
        if (!locationFormattingRequest.zip.isEmpty()) {
            locationFormattingResponse.appendToSecondLine(this.emptySymbol);
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.zip);
        }
        if (Util.isEmpty(locationFormattingResponse.getFirstLineAsText())) {
            locationFormattingResponse = Util.isEmpty(locationFormattingResponse.getSecondLineAsText()) ? super.asTwoLines(locationFormattingRequest) : this.formatCityCenterAddress(locationFormattingRequest);
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
                locationFormattingResponse.appendToSecondLine(this.emptySymbol);
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
        }
        if (!locationFormattingRequest.street.isEmpty()) {
            if (locationFormattingResponse.getFirstLineList().size() > 0) {
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
        if (!locationFormattingRequest.city.isEmpty()) {
            if (locationFormattingResponse.getFirstLineList().size() > 0) {
                locationFormattingResponse.appendToFirstLine(this.commaSymbol);
            }
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.city);
        }
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

