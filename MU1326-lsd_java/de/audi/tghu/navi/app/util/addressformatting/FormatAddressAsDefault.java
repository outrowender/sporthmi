/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util.addressformatting;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.util.Util;
import de.audi.tghu.navi.app.util.addressformatting.FormatAddress;
import de.audi.tghu.navi.app.util.addressformatting.FormattedHighlightedText;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingRequest;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingResponse;

public class FormatAddressAsDefault
extends FormatAddress {
    public FormatAddressAsDefault(NavigationEnv navigationEnv) {
        super(navigationEnv);
    }

    @Override
    protected LocationFormattingResponse asTwoLines(LocationFormattingRequest locationFormattingRequest) {
        return null;
    }

    @Override
    protected LocationFormattingResponse asThreeLines(LocationFormattingRequest locationFormattingRequest) {
        return null;
    }

    @Override
    protected LocationFormattingResponse asSingleLine(LocationFormattingRequest locationFormattingRequest) {
        LocationFormattingResponse locationFormattingResponse = new LocationFormattingResponse();
        LocationFormattingResponse locationFormattingResponse2 = this.asTwoLines(locationFormattingRequest);
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
        return locationFormattingResponse;
    }
}

