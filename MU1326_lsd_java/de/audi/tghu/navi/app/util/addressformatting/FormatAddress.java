/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util.addressformatting;

import de.audi.atip.interapp.NaviService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.util.Util;
import de.audi.tghu.navi.app.util.addressformatting.FormattedHighlightedText;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingRequest;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingResponse;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.online.OperatorCallResult;
import org.dsi.ifc.search.SearchResult;

public abstract class FormatAddress {
    protected final LogChannel logChannel;
    protected final NavigationEnv env;
    protected final String CLASS_NAME = Util.getClassNameFromPackageName(this.getClass());
    protected final FormattedHighlightedText commaSymbol = new FormattedHighlightedText(", ");
    protected final FormattedHighlightedText slashSymbol = new FormattedHighlightedText("/");
    protected final FormattedHighlightedText minusSymbol = new FormattedHighlightedText("-");
    protected final FormattedHighlightedText emptySymbol = new FormattedHighlightedText(" ");

    public FormatAddress(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getLogChannel("App.Navi.Main");
    }

    protected abstract LocationFormattingResponse asSingleLine(LocationFormattingRequest var1);

    protected abstract LocationFormattingResponse asTwoLines(LocationFormattingRequest var1);

    protected abstract LocationFormattingResponse asThreeLines(LocationFormattingRequest var1);

    public LocationFormattingResponse asTwoLines(NavLocation navLocation, NavigationEnv navigationEnv, boolean bl) {
        try {
            return this.asTwoLines(new LocationFormattingRequest(navLocation, bl));
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "FormatAddress#asTwoLines Exception: %1", (Throwable)exception);
            this.logChannel.log(10000, "FormatAddress#asTwoLines NavLocation: %1", (Object)navLocation);
            return new LocationFormattingResponse();
        }
    }

    public LocationFormattingResponse asTwoLines(NavLocation navLocation, NavigationEnv navigationEnv, boolean bl, boolean bl2) {
        try {
            return this.asTwoLines(new LocationFormattingRequest(navLocation, bl, bl2));
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "FormatAddress#asTwoLines Exception: %1", (Throwable)exception);
            this.logChannel.log(10000, "FormatAddress#asTwoLines NavLocation: %1, hidePoiCategory: %2", (Object)navLocation, (Object)String.valueOf(bl2));
            return new LocationFormattingResponse();
        }
    }

    public LocationFormattingResponse asTwoLines(SearchResult searchResult, NavigationEnv navigationEnv) {
        try {
            return this.asTwoLines(new LocationFormattingRequest(searchResult));
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "FormatAddress#asTwoLines Exception: %1", (Throwable)exception);
            this.logChannel.log(10000, "FormatAddress#asTwoLines SearchResult: %1", (Object)searchResult);
            return new LocationFormattingResponse();
        }
    }

    public LocationFormattingResponse asTwoLines(OperatorCallResult operatorCallResult, NavigationEnv navigationEnv) {
        try {
            return this.asTwoLines(new LocationFormattingRequest(operatorCallResult));
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "FormatAddress#asTwoLines Exception: %1", (Throwable)exception);
            this.logChannel.log(10000, "FormatAddress#asTwoLines OperatorCallResult: %1", (Object)operatorCallResult);
            return new LocationFormattingResponse();
        }
    }

    public LocationFormattingResponse asTwoLines(NaviService.NaviDetails naviDetails, NavigationEnv navigationEnv) {
        try {
            return this.asTwoLines(new LocationFormattingRequest(naviDetails));
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "FormatAddress#asTwoLines Exception: %1", (Throwable)exception);
            this.logChannel.log(10000, "FormatAddress#asTwoLines NaviDetails: %1", (Object)naviDetails);
            return new LocationFormattingResponse();
        }
    }

    public LocationFormattingResponse asThreeLines(NavLocation navLocation, NavigationEnv navigationEnv, boolean bl) {
        try {
            return this.asThreeLines(new LocationFormattingRequest(navLocation, bl));
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "FormatAddress#asThreeLines Exception: %1", (Throwable)exception);
            this.logChannel.log(10000, "FormatAddress#asThreeLines NavLocation: %1", (Object)navLocation);
            return new LocationFormattingResponse();
        }
    }

    public LocationFormattingResponse asThreeLines(SearchResult searchResult, NavigationEnv navigationEnv) {
        try {
            return this.asThreeLines(new LocationFormattingRequest(searchResult));
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "FormatAddress#asThreeLines Exception: %1", (Throwable)exception);
            this.logChannel.log(10000, "FormatAddress#asThreeLines SearchResult: %1", (Object)searchResult);
            return new LocationFormattingResponse();
        }
    }

    public LocationFormattingResponse asThreeLines(OperatorCallResult operatorCallResult, NavigationEnv navigationEnv) {
        try {
            return this.asThreeLines(new LocationFormattingRequest(operatorCallResult));
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "FormatAddress#asThreeLines Exception: %1", (Throwable)exception);
            this.logChannel.log(10000, "FormatAddress#asThreeLines OperatorCallResult: %1", (Object)operatorCallResult);
            return new LocationFormattingResponse();
        }
    }

    public LocationFormattingResponse asThreeLines(NaviService.NaviDetails naviDetails, NavigationEnv navigationEnv) {
        try {
            return this.asThreeLines(new LocationFormattingRequest(naviDetails));
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "FormatAddress#asThreeLines Exception: %1", (Throwable)exception);
            this.logChannel.log(10000, "FormatAddress#asThreeLines NaviDetails: %1", (Object)naviDetails);
            return new LocationFormattingResponse();
        }
    }

    public LocationFormattingResponse asSingleLine(NavLocation navLocation, NavigationEnv navigationEnv) {
        try {
            return this.asSingleLine(new LocationFormattingRequest(navLocation, false));
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "FormatAddress#asSingleLine Exception: %1", (Throwable)exception);
            this.logChannel.log(10000, "FormatAddress#asSingleLine NavLocation: %1", (Object)navLocation);
            return new LocationFormattingResponse();
        }
    }

    public LocationFormattingResponse asSingleLine(NavLocation navLocation, NavigationEnv navigationEnv, boolean bl) {
        try {
            return this.asSingleLine(new LocationFormattingRequest(navLocation, false, bl));
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "FormatAddress#asSingleLine Exception: %1", (Throwable)exception);
            this.logChannel.log(10000, "FormatAddress#asSingleLine NavLocation: %1", (Object)navLocation);
            return new LocationFormattingResponse();
        }
    }

    public LocationFormattingResponse asSingleLine(SearchResult searchResult, NavigationEnv navigationEnv) {
        try {
            return this.asSingleLine(new LocationFormattingRequest(searchResult));
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "FormatAddress#asSingleLine Exception: %1", (Throwable)exception);
            this.logChannel.log(10000, "FormatAddress#asSingleLine SearchResult: %1", (Object)searchResult);
            return new LocationFormattingResponse();
        }
    }

    public LocationFormattingResponse asSingleLine(NaviService.NaviDetails naviDetails, NavigationEnv navigationEnv) {
        try {
            return this.asSingleLine(new LocationFormattingRequest(naviDetails));
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "FormatAddress#asSingleLine Exception: %1", (Throwable)exception);
            this.logChannel.log(10000, "FormatAddress#asSingleLine NaviDetails: %1", (Object)naviDetails);
            return new LocationFormattingResponse();
        }
    }

    protected boolean isCategoryInPoiName(FormattedHighlightedText formattedHighlightedText, FormattedHighlightedText formattedHighlightedText2) {
        String string = formattedHighlightedText.formattedText;
        String string2 = formattedHighlightedText2.formattedText;
        return string.indexOf(string2) != -1;
    }
}

