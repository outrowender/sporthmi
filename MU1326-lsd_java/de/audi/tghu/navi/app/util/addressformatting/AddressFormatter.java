/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util.addressformatting;

import de.audi.atip.interapp.NaviService$NaviDetails;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.util.addressformatting.AddressFormatter$VariantSpecificFormatter;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingRequest;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingResponse;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.online.OperatorCallResult;
import org.dsi.ifc.search.SearchResult;

public class AddressFormatter {
    public static LocationFormattingResponse formatOneLine(NavLocation navLocation, NavigationEnv navigationEnv) {
        return new AddressFormatter$VariantSpecificFormatter(navigationEnv).formatOneLine(navLocation);
    }

    public static LocationFormattingResponse formatOneLine(NavLocation navLocation, NavigationEnv navigationEnv, boolean bl) {
        return new AddressFormatter$VariantSpecificFormatter(navigationEnv).formatOneLine(navLocation, bl);
    }

    public static LocationFormattingResponse formatOneLine(SearchResult searchResult, NavigationEnv navigationEnv) {
        return new AddressFormatter$VariantSpecificFormatter(navigationEnv).formatOneLine(searchResult);
    }

    public static LocationFormattingResponse formatOneLine(NaviService$NaviDetails naviService$NaviDetails, NavigationEnv navigationEnv) {
        return new AddressFormatter$VariantSpecificFormatter(navigationEnv).formatOneLine(naviService$NaviDetails);
    }

    public static LocationFormattingResponse formatOneLine(LocationFormattingRequest locationFormattingRequest, NavigationEnv navigationEnv) {
        return new AddressFormatter$VariantSpecificFormatter(navigationEnv).formatOneLine(locationFormattingRequest);
    }

    public static LocationFormattingResponse formatTwoLines(NavLocation navLocation, NavigationEnv navigationEnv) {
        return new AddressFormatter$VariantSpecificFormatter(navigationEnv).formatTwoLines(navLocation, false);
    }

    public static LocationFormattingResponse formatTwoLines(NavLocation navLocation, NavigationEnv navigationEnv, boolean bl) {
        return new AddressFormatter$VariantSpecificFormatter(navigationEnv).formatTwoLines(navLocation, false, bl);
    }

    public static LocationFormattingResponse formatTwoLines(SearchResult searchResult, NavigationEnv navigationEnv) {
        return new AddressFormatter$VariantSpecificFormatter(navigationEnv).formatTwoLines(searchResult);
    }

    public static LocationFormattingResponse formatTwoLines(OperatorCallResult operatorCallResult, NavigationEnv navigationEnv) {
        return new AddressFormatter$VariantSpecificFormatter(navigationEnv).formatTwoLines(operatorCallResult);
    }

    public static LocationFormattingResponse formatTwoLines(NaviService$NaviDetails naviService$NaviDetails, NavigationEnv navigationEnv) {
        return new AddressFormatter$VariantSpecificFormatter(navigationEnv).formatTwoLines(naviService$NaviDetails);
    }

    public static LocationFormattingResponse formatTwoLines(LocationFormattingRequest locationFormattingRequest, NavigationEnv navigationEnv) {
        return new AddressFormatter$VariantSpecificFormatter(navigationEnv).formatTwoLines(locationFormattingRequest);
    }

    public static LocationFormattingResponse formatThreeLines(NavLocation navLocation, NavigationEnv navigationEnv) {
        return new AddressFormatter$VariantSpecificFormatter(navigationEnv).formatThreeLines(navLocation, false);
    }

    public static LocationFormattingResponse formatThreeLines(SearchResult searchResult, NavigationEnv navigationEnv) {
        return new AddressFormatter$VariantSpecificFormatter(navigationEnv).formatThreeLines(searchResult);
    }

    public static LocationFormattingResponse formatThreeLines(OperatorCallResult operatorCallResult, NavigationEnv navigationEnv) {
        return new AddressFormatter$VariantSpecificFormatter(navigationEnv).formatThreeLines(operatorCallResult);
    }

    public static LocationFormattingResponse formatThreeLines(NaviService$NaviDetails naviService$NaviDetails, NavigationEnv navigationEnv) {
        return new AddressFormatter$VariantSpecificFormatter(navigationEnv).formatThreeLines(naviService$NaviDetails);
    }

    public static LocationFormattingResponse formatThreeLines(LocationFormattingRequest locationFormattingRequest, NavigationEnv navigationEnv) {
        return new AddressFormatter$VariantSpecificFormatter(navigationEnv).formatThreeLines(locationFormattingRequest);
    }

    public static LocationFormattingResponse formatPhonetics(NavLocation navLocation, NavigationEnv navigationEnv) {
        return new AddressFormatter$VariantSpecificFormatter(navigationEnv).formatTwoLines(navLocation, true);
    }
}

