/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util.addressformatting.pgen2;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.util.addressformatting.FormattedHighlightedText;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingRequest;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingResponse;
import de.audi.tghu.navi.app.util.addressformatting.porsche.FormatAddressNARPAG;

public class FormatAddressNARPGen2
extends FormatAddressNARPAG {
    public FormatAddressNARPGen2(NavigationEnv navigationEnv) {
        super(navigationEnv);
    }

    protected LocationFormattingResponse asTwoLines(LocationFormattingRequest locationFormattingRequest) {
        if (!locationFormattingRequest.contactOrFavoriteName.isEmpty()) {
            LocationFormattingResponse locationFormattingResponse = new LocationFormattingResponse();
            locationFormattingResponse.appendToFirstLine(locationFormattingRequest.contactOrFavoriteName);
            this.formatSecondlinefortwoLines(locationFormattingRequest, locationFormattingResponse);
            if (locationFormattingResponse.getSecondLineForTruffles().getText().length() == 0) {
                locationFormattingResponse.appendToSecondLine(new FormattedHighlightedText("(" + this.env.getTranslatedText(13) + ")"));
            }
            return locationFormattingResponse;
        }
        return super.asTwoLines(locationFormattingRequest);
    }
}

