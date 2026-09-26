/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util.addressformatting.porsche;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.util.addressformatting.FormatAddress;
import de.audi.tghu.navi.app.util.addressformatting.FormattedHighlightedText;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingRequest;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingResponse;

public class FormatAddressPAG
extends FormatAddress {
    public static final int MINIMUMLENGTHOFFORMATTING;

    public FormatAddressPAG(NavigationEnv navigationEnv) {
        super(navigationEnv);
    }

    public LocationFormattingResponse formattingFallback() {
        LocationFormattingResponse locationFormattingResponse = new LocationFormattingResponse();
        locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(this.env.getTranslatedText(13)));
        locationFormattingResponse.getSecondLineList().clear();
        locationFormattingResponse.getThirdLineList().clear();
        return locationFormattingResponse;
    }

    public LocationFormattingResponse formattinArea(LocationFormattingRequest locationFormattingRequest) {
        LocationFormattingResponse locationFormattingResponse = new LocationFormattingResponse();
        locationFormattingResponse.appendToFirstLine(locationFormattingRequest.areaInfo);
        locationFormattingResponse.appendToSecondLine(new FormattedHighlightedText("("));
        locationFormattingResponse.appendToSecondLine(new FormattedHighlightedText(this.env.getTranslatedText(13)));
        locationFormattingResponse.appendToSecondLine(new FormattedHighlightedText(")"));
        locationFormattingResponse.getThirdLineList().clear();
        return locationFormattingResponse;
    }

    public void formatCityandRefinement(LocationFormattingRequest locationFormattingRequest, LocationFormattingResponse locationFormattingResponse) {
        if (!locationFormattingRequest.cityPart.isEmpty()) {
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.cityPart);
        }
        if (!locationFormattingRequest.city.isEmpty()) {
            if (!locationFormattingRequest.cityPart.isEmpty()) {
                locationFormattingResponse.appendToFirstLine(this.commaSymbol);
            }
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.city);
        }
    }

    public void formatCityandRefinementforSecondLine(LocationFormattingRequest locationFormattingRequest, LocationFormattingResponse locationFormattingResponse) {
        if (!locationFormattingRequest.cityPart.isEmpty()) {
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.cityPart);
        }
        if (!locationFormattingRequest.city.isEmpty()) {
            if (!locationFormattingRequest.cityPart.isEmpty()) {
                locationFormattingResponse.appendToSecondLine(this.commaSymbol);
            }
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.city);
        }
    }

    @Override
    protected LocationFormattingResponse asSingleLine(LocationFormattingRequest locationFormattingRequest) {
        return null;
    }

    @Override
    protected LocationFormattingResponse asTwoLines(LocationFormattingRequest locationFormattingRequest) {
        return null;
    }

    @Override
    protected LocationFormattingResponse asThreeLines(LocationFormattingRequest locationFormattingRequest) {
        return null;
    }

    protected boolean isUsefulLocationInfoSet(LocationFormattingRequest locationFormattingRequest) {
        return !locationFormattingRequest.city.isEmpty() || !locationFormattingRequest.cityPart.isEmpty() || !locationFormattingRequest.street.isEmpty() || !locationFormattingRequest.poiName.isEmpty();
    }
}

