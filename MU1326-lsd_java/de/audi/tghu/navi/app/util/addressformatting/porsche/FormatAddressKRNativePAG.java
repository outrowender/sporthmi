/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util.addressformatting.porsche;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.util.Util;
import de.audi.tghu.navi.app.util.addressformatting.FormattedHighlightedText;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingRequest;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingResponse;
import de.audi.tghu.navi.app.util.addressformatting.porsche.FormatAddressAsiaNativePAG;
import java.util.LinkedList;

public class FormatAddressKRNativePAG
extends FormatAddressAsiaNativePAG {
    public FormatAddressKRNativePAG(NavigationEnv navigationEnv) {
        super(navigationEnv);
    }

    @Override
    protected void formatAddressWhenStreetExists(LocationFormattingRequest locationFormattingRequest, LocationFormattingResponse locationFormattingResponse) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "%1#formatStreet House number is empty = %2", (Object)this.CLASS_NAME, (Object)Boolean.toString(locationFormattingRequest.houseNumber.isEmpty()));
        }
        if (!locationFormattingRequest.cityPart.isEmpty()) {
            this.AppendTextIfNeededToSecondLine(locationFormattingResponse, this.emptySymbol);
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.cityPart);
        }
        if (locationFormattingRequest.houseNumber.isEmpty()) {
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.street);
            this.formatThreeLevelCityForSecondLine(locationFormattingRequest, locationFormattingResponse);
        } else {
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.street);
            locationFormattingResponse.appendToFirstLine(this.emptySymbol);
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.houseNumber);
            this.formatThreeLevelCityForSecondLine(locationFormattingRequest, locationFormattingResponse);
        }
    }

    @Override
    protected LocationFormattingResponse asThreeLines(LocationFormattingRequest locationFormattingRequest) {
        LocationFormattingResponse locationFormattingResponse = new LocationFormattingResponse();
        if (!locationFormattingRequest.contactOrFavoriteName.isEmpty() || !locationFormattingRequest.poiName.isEmpty()) {
            this.appendToFirstLineContactFavOrPOIName(locationFormattingRequest, locationFormattingResponse);
            LocationFormattingResponse locationFormattingResponse2 = new LocationFormattingResponse();
            this.formatStreetAndHouseNumber(locationFormattingRequest, locationFormattingResponse2);
            locationFormattingResponse2.swapLines();
            if (this.swapIfFirstLineIsEmpty(locationFormattingResponse, locationFormattingResponse2)) {
                return locationFormattingResponse2;
            }
            this.appendToSecondAndThirdLine(locationFormattingResponse, locationFormattingResponse2);
        } else {
            this.formatStreetAndHouseNumberForDI(locationFormattingRequest, locationFormattingResponse);
        }
        return locationFormattingResponse;
    }

    private void formatStreetAndHouseNumberForDI(LocationFormattingRequest locationFormattingRequest, LocationFormattingResponse locationFormattingResponse) {
        LocationFormattingResponse locationFormattingResponse2 = new LocationFormattingResponse();
        if (!locationFormattingRequest.city.isEmpty()) {
            if (!locationFormattingRequest.ward.isEmpty()) {
                locationFormattingResponse2.appendToFirstLine(locationFormattingRequest.ward);
                locationFormattingResponse2.appendToSecondLine(locationFormattingRequest.city);
            } else {
                locationFormattingResponse2.appendToFirstLine(locationFormattingRequest.city);
            }
        } else if (!locationFormattingRequest.ward.isEmpty()) {
            locationFormattingResponse2.appendToFirstLine(locationFormattingRequest.ward);
        }
        if (!locationFormattingRequest.state.isEmpty()) {
            this.AppendTextIfNeededToSecondLine(locationFormattingResponse2, this.emptySymbol);
            locationFormattingResponse2.appendToSecondLine(locationFormattingRequest.state);
        }
        if (locationFormattingResponse2.getFirstLineList().isEmpty()) {
            locationFormattingResponse2.swapLines();
        }
        if (!locationFormattingRequest.street.isEmpty()) {
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.street);
            if (!locationFormattingRequest.houseNumber.isEmpty()) {
                this.AppendTextIfNeededToFirstLine(locationFormattingResponse, this.emptySymbol);
                locationFormattingResponse.appendToFirstLine(locationFormattingRequest.houseNumber);
            }
            if (!locationFormattingRequest.cityPart.isEmpty()) {
                locationFormattingResponse.appendToSecondLine(locationFormattingRequest.cityPart);
                locationFormattingResponse.appendToSecondLine(this.emptySymbol);
            }
        } else if (!locationFormattingRequest.houseNumber.isEmpty()) {
            locationFormattingResponse2.replaceFirstLine(new LinkedList());
            locationFormattingResponse2.replaceSecondLine(new LinkedList());
            locationFormattingResponse2.appendToFirstLine(locationFormattingRequest.cityPart);
            locationFormattingResponse2.appendToSecondLine(locationFormattingRequest.city);
            if (!locationFormattingRequest.state.isEmpty()) {
                locationFormattingResponse2.appendToSecondLine(this.emptySymbol);
                locationFormattingResponse2.appendToSecondLine(locationFormattingRequest.state);
            }
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.houseNumber);
        } else if (!locationFormattingRequest.cityPart.isEmpty()) {
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.cityPart);
        }
        if (locationFormattingResponse.getFirstLineList().isEmpty()) {
            locationFormattingResponse.replaceFirstLine(locationFormattingResponse2.getFirstLineList());
            locationFormattingResponse.replaceSecondLine(locationFormattingResponse2.getSecondLineList());
        } else {
            this.appendToSecondAndThirdLine(locationFormattingResponse, locationFormattingResponse2);
        }
    }

    @Override
    protected void formatDefaultTwoLines(LocationFormattingRequest locationFormattingRequest, LocationFormattingResponse locationFormattingResponse) {
        if (!locationFormattingRequest.cityPart.isEmpty()) {
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.cityPart);
            this.formatThreeLevelCityForSecondLine(locationFormattingRequest, locationFormattingResponse);
        } else if (!locationFormattingRequest.ward.isEmpty()) {
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.ward);
            if (!locationFormattingRequest.city.isEmpty() && !locationFormattingRequest.state.isEmpty()) {
                locationFormattingResponse.appendToSecondLine(locationFormattingRequest.city);
                locationFormattingResponse.appendToSecondLine(this.emptySymbol);
                locationFormattingResponse.appendToSecondLine(locationFormattingRequest.state);
            } else {
                locationFormattingResponse.appendToSecondLine(locationFormattingRequest.state);
                locationFormattingResponse.appendToSecondLine(locationFormattingRequest.city);
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

    @Override
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

    private void AppendTextIfNeededToFirstLine(LocationFormattingResponse locationFormattingResponse, FormattedHighlightedText formattedHighlightedText) {
        if (!locationFormattingResponse.getFirstLineList().isEmpty() && !locationFormattingResponse.getFirstLineList().get(locationFormattingResponse.getFirstLineList().size() - 1).equals(formattedHighlightedText)) {
            locationFormattingResponse.appendToFirstLine(formattedHighlightedText);
        }
    }

    private void AppendTextIfNeededToSecondLine(LocationFormattingResponse locationFormattingResponse, FormattedHighlightedText formattedHighlightedText) {
        if (!locationFormattingResponse.getSecondLineList().isEmpty() && !locationFormattingResponse.getSecondLineList().get(locationFormattingResponse.getSecondLineList().size() - 1).equals(formattedHighlightedText)) {
            locationFormattingResponse.appendToSecondLine(formattedHighlightedText);
        }
    }

    @Override
    protected void formatThreeLevelCityForSecondLine(LocationFormattingRequest locationFormattingRequest, LocationFormattingResponse locationFormattingResponse) {
        if (!locationFormattingRequest.ward.isEmpty()) {
            this.AppendTextIfNeededToSecondLine(locationFormattingResponse, this.emptySymbol);
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.ward);
        }
        if (!locationFormattingRequest.city.isEmpty()) {
            this.AppendTextIfNeededToSecondLine(locationFormattingResponse, this.emptySymbol);
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.city);
        }
        if (!locationFormattingRequest.state.isEmpty()) {
            this.AppendTextIfNeededToSecondLine(locationFormattingResponse, this.emptySymbol);
            locationFormattingResponse.appendToSecondLine(locationFormattingRequest.state);
        }
    }
}

