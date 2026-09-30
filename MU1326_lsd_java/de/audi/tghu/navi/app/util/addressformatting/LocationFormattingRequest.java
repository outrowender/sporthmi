/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util.addressformatting;

import de.audi.atip.interapp.IFormattingRequest;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.interapp.locationaccessor.IMyLocationAccessor;
import de.audi.atip.search.util.AbstractSearchResultFormatter;
import de.audi.tghu.navi.app.addressinput.poi.PoiUtil;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import de.audi.tghu.navi.app.util.addressformatting.FormattedHighlightedText;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.online.OperatorCallAddressEntry;
import org.dsi.ifc.online.OperatorCallResult;
import org.dsi.ifc.search.Country;
import org.dsi.ifc.search.SearchResult;
import org.dsi.ifc.search.Token;

public class LocationFormattingRequest
implements IFormattingRequest {
    public static final int LOCATIONTYPE_NOT_VALID = -1;
    public static final int LOCATIONTYPE_GEOGRAPHICAL_POSITION = 0;
    public static final int LOCATIONTYPE_DEFAULT = 1;
    public static final int LOCATIONTYPE_POI = 2;
    public static final int LOCATIONTYPE_WAYPOINT = 3;
    public static final int LOCATIONTYPE_CITY_CENTER = 4;
    public static final int LOCATIONTYPE_CITY_PART = 5;
    public static final int LOCATIONTYPE_INTERSECTION = 6;
    public static final int LOCATIONTYPE_POI_CALL = 7;
    public static final int LOCATIONTYPE_PRESSROUTE = 8;
    public FormattedHighlightedText country;
    public FormattedHighlightedText street;
    public FormattedHighlightedText state;
    public FormattedHighlightedText stateAbbreviation;
    public FormattedHighlightedText city;
    public FormattedHighlightedText cityPart;
    public FormattedHighlightedText district;
    public FormattedHighlightedText ward;
    public FormattedHighlightedText zip;
    public FormattedHighlightedText houseNumber;
    public FormattedHighlightedText poiName;
    public FormattedHighlightedText contactOrFavoriteName;
    public FormattedHighlightedText latitude;
    public FormattedHighlightedText longitude;
    public FormattedHighlightedText countryAbbreviation;
    public FormattedHighlightedText junction;
    public FormattedHighlightedText phonenumber;
    public FormattedHighlightedText poiCategory;
    public FormattedHighlightedText petrolStation;
    public FormattedHighlightedText areaInfo;
    public final int locationType;
    public final boolean poiIs24hOpen;

    public LocationFormattingRequest(NavLocation navLocation, boolean bl) {
        if (navLocation == null || !navLocation.isPositionValid()) {
            throw new IllegalArgumentException("NavLocation is not valid");
        }
        IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
        this.country = new FormattedHighlightedText(LocationFormatter.formatCountry(navLocation), 0);
        this.street = new FormattedHighlightedText(this.getStreet(navLocation, iMyLocationAccessor), 5);
        this.city = new FormattedHighlightedText(LocationFormatter.getCity(iMyLocationAccessor), iMyLocationAccessor.isTownOrder9() ? 3 : 2);
        this.cityPart = new FormattedHighlightedText(this.getCityPart(navLocation, iMyLocationAccessor), iMyLocationAccessor.isTownOrder9() ? 2 : 3);
        this.district = new FormattedHighlightedText(LocationFormatter.getDistrict(iMyLocationAccessor), 15);
        this.ward = new FormattedHighlightedText(this.getWard(navLocation, iMyLocationAccessor), 15);
        this.zip = new FormattedHighlightedText(LocationFormatter.formatZIPCode(navLocation), 12);
        this.houseNumber = new FormattedHighlightedText(LocationFormatter.formatHousenumber(navLocation), 13);
        this.latitude = new FormattedHighlightedText(navLocation.latitude);
        this.longitude = new FormattedHighlightedText(navLocation.longitude);
        this.state = new FormattedHighlightedText(LocationFormatter.formatState(navLocation), 1);
        this.stateAbbreviation = new FormattedHighlightedText(LocationFormatter.formatStateAbbreviation(navLocation), 1);
        this.countryAbbreviation = new FormattedHighlightedText(LocationFormatter.formatCountryAbbreviation(navLocation), 0);
        this.junction = new FormattedHighlightedText(LocationFormatter.formatJunction(navLocation), 7);
        this.phonenumber = new FormattedHighlightedText(LocationFormatter.getPhoneNumber(navLocation));
        this.poiCategory = new FormattedHighlightedText(iMyLocationAccessor.getPoiCategory());
        this.petrolStation = new FormattedHighlightedText(Util.getPetrolStationValue(navLocation));
        this.areaInfo = new FormattedHighlightedText(Util.getAreaInfoFromLocation(navLocation));
        this.poiName = new FormattedHighlightedText(LocationFormatter.formatPOIName(navLocation), 8);
        this.contactOrFavoriteName = new FormattedHighlightedText(LocationFormatter.formatLocationTitle(navLocation), 14);
        this.poiIs24hOpen = PoiUtil.isPoi24h(navLocation);
        if (bl) {
            this.country.formatToPhoneticType(iMyLocationAccessor);
            this.countryAbbreviation.formatToPhoneticType(iMyLocationAccessor);
            this.stateAbbreviation.formatToPhoneticType(iMyLocationAccessor);
            this.street.formatToPhoneticType(iMyLocationAccessor);
            this.city.formatToPhoneticType(iMyLocationAccessor);
            this.cityPart.formatToPhoneticType(iMyLocationAccessor);
            this.ward.formatToPhoneticType(iMyLocationAccessor);
            this.district.formatToPhoneticType(iMyLocationAccessor);
            this.zip.formatToPhoneticType(iMyLocationAccessor);
            this.houseNumber.formatToPhoneticType(iMyLocationAccessor);
            this.state.formatToPhoneticType(iMyLocationAccessor);
            this.junction.formatToPhoneticType(iMyLocationAccessor);
            this.poiName.formatToPhoneticType(iMyLocationAccessor);
            this.contactOrFavoriteName.formatToPhoneticType(iMyLocationAccessor);
        }
        this.locationType = iMyLocationAccessor.getType() != 1 && Util.isGeoPosFlag(navLocation) ? 0 : this.getMappedLocationTypeFromLocationAccessor(iMyLocationAccessor.getType());
    }

    public LocationFormattingRequest(NavLocation navLocation, boolean bl, boolean bl2) {
        this(navLocation, bl);
        if (bl2) {
            this.poiCategory = new FormattedHighlightedText();
        }
    }

    public LocationFormattingRequest(SearchResult searchResult) {
        if (searchResult == null) {
            throw new IllegalArgumentException("SearchResult is not valid");
        }
        this.country = searchResult.country != null ? new FormattedHighlightedText(searchResult.country.name) : new FormattedHighlightedText();
        this.stateAbbreviation = this.extractStateAbbreviation(searchResult);
        this.countryAbbreviation = new FormattedHighlightedText(this.extractCountryAbbreviation(searchResult));
        this.street = new FormattedHighlightedText(Util.extractTokenFromSearchresult(searchResult, 3));
        this.city = new FormattedHighlightedText(Util.extractTokenFromSearchresult(searchResult, 1));
        this.cityPart = new FormattedHighlightedText(Util.extractTokenFromSearchresult(searchResult, 2));
        this.zip = new FormattedHighlightedText(Util.extractTokenFromSearchresult(searchResult, 4));
        this.houseNumber = new FormattedHighlightedText(Util.extractTokenFromSearchresult(searchResult, 7));
        this.state = new FormattedHighlightedText(Util.extractTokenFromSearchresult(searchResult, 6));
        Token token = Util.extractTokenFromSearchresult(searchResult, 103);
        if (Util.isEmpty(token.getToken())) {
            token = Util.extractTokenFromSearchresult(searchResult, 22);
        }
        this.junction = new FormattedHighlightedText(token);
        this.poiName = new FormattedHighlightedText(this.extractPoiNameFromSearchResult(searchResult));
        this.contactOrFavoriteName = new FormattedHighlightedText(this.extractContactOrFavoriteNameFromSearchResult(searchResult));
        this.latitude = new FormattedHighlightedText(this.extractLatitude(searchResult));
        this.longitude = new FormattedHighlightedText(this.extractLongitude(searchResult));
        this.poiCategory = this.filterOutEmptyPoiCategories(searchResult);
        this.areaInfo = new FormattedHighlightedText(Util.extractTokenFromSearchresult(searchResult, 24));
        this.phonenumber = new FormattedHighlightedText();
        this.petrolStation = new FormattedHighlightedText();
        this.district = new FormattedHighlightedText(Util.extractTokenFromSearchresult(searchResult, 2));
        this.ward = new FormattedHighlightedText(Util.extractTokenFromSearchresult(searchResult, 4));
        this.locationType = this.getMappedLocationTypeFromSearchResult(searchResult.getEntryType());
        this.poiIs24hOpen = false;
    }

    public LocationFormattingRequest(OperatorCallResult operatorCallResult) {
        if (operatorCallResult == null) {
            throw new IllegalArgumentException("OperatorCallResult is not valid");
        }
        OperatorCallAddressEntry operatorCallAddressEntry = operatorCallResult.getAddress();
        this.latitude = new FormattedHighlightedText(operatorCallResult.getLocation().getLatitude());
        this.longitude = new FormattedHighlightedText(operatorCallResult.getLocation().getLongitude());
        this.country = new FormattedHighlightedText(operatorCallAddressEntry.getCountry());
        this.street = new FormattedHighlightedText(operatorCallAddressEntry.getStreet());
        this.phonenumber = new FormattedHighlightedText(operatorCallAddressEntry.getPhoneNumber());
        this.city = new FormattedHighlightedText(operatorCallAddressEntry.getCity());
        this.zip = new FormattedHighlightedText(operatorCallAddressEntry.getZip());
        this.poiName = new FormattedHighlightedText(operatorCallResult.getName());
        this.areaInfo = new FormattedHighlightedText();
        this.countryAbbreviation = new FormattedHighlightedText();
        this.junction = new FormattedHighlightedText();
        this.poiCategory = new FormattedHighlightedText();
        this.petrolStation = new FormattedHighlightedText();
        this.state = new FormattedHighlightedText();
        this.stateAbbreviation = new FormattedHighlightedText();
        this.cityPart = new FormattedHighlightedText();
        this.district = new FormattedHighlightedText();
        this.ward = new FormattedHighlightedText();
        this.houseNumber = new FormattedHighlightedText();
        this.contactOrFavoriteName = new FormattedHighlightedText();
        this.locationType = -1;
        this.poiIs24hOpen = false;
    }

    public LocationFormattingRequest(NaviService.NaviDetails naviDetails) {
        if (naviDetails == null) {
            throw new IllegalArgumentException("NaviDetails are null!");
        }
        this.country = new FormattedHighlightedText(naviDetails.country);
        this.street = new FormattedHighlightedText(naviDetails.street);
        this.city = new FormattedHighlightedText(naviDetails.city);
        this.countryAbbreviation = new FormattedHighlightedText(naviDetails.countryAbbreviation);
        this.state = new FormattedHighlightedText(this.getStateNameFromNaviDetails(naviDetails));
        this.stateAbbreviation = new FormattedHighlightedText(naviDetails.stateAbbreviation);
        this.cityPart = new FormattedHighlightedText(this.getCityPart(naviDetails));
        this.houseNumber = new FormattedHighlightedText(naviDetails.houseNumber);
        this.areaInfo = new FormattedHighlightedText();
        this.ward = new FormattedHighlightedText();
        this.district = new FormattedHighlightedText();
        this.contactOrFavoriteName = new FormattedHighlightedText();
        this.latitude = new FormattedHighlightedText();
        this.longitude = new FormattedHighlightedText();
        this.poiCategory = new FormattedHighlightedText();
        this.petrolStation = new FormattedHighlightedText();
        this.junction = new FormattedHighlightedText();
        this.zip = new FormattedHighlightedText();
        this.poiName = new FormattedHighlightedText();
        this.phonenumber = new FormattedHighlightedText();
        this.locationType = -1;
        this.poiIs24hOpen = false;
    }

    private Token extractPoiNameFromSearchResult(SearchResult searchResult) {
        if (searchResult.entryType == 2) {
            return Util.extractTokenFromSearchresult(searchResult, 5);
        }
        return new Token();
    }

    private Token extractContactOrFavoriteNameFromSearchResult(SearchResult searchResult) {
        if (searchResult.entryType == 260 || searchResult.source == 5) {
            return Util.extractTokenFromSearchresult(searchResult, 5);
        }
        return new Token();
    }

    private int extractLatitude(SearchResult searchResult) {
        if (searchResult.position != null && (searchResult.position.lat != 0.0f || searchResult.position.lon != 0.0f)) {
            return new Integer(Util.degreeStringToWgs84(String.valueOf(searchResult.position.lat)));
        }
        Token token = AbstractSearchResultFormatter.getTokenForType(searchResult.getTokens(), 18);
        if (!AbstractSearchResultFormatter.isEmpty(token)) {
            return Integer.valueOf(token.getToken());
        }
        return 0;
    }

    private int extractLongitude(SearchResult searchResult) {
        if (searchResult.position != null && (searchResult.position.lat != 0.0f || searchResult.position.lon != 0.0f)) {
            return new Integer(Util.degreeStringToWgs84(String.valueOf(searchResult.position.lon)));
        }
        Token token = AbstractSearchResultFormatter.getTokenForType(searchResult.getTokens(), 19);
        if (!AbstractSearchResultFormatter.isEmpty(token)) {
            return Integer.valueOf(token.getToken());
        }
        return 0;
    }

    private FormattedHighlightedText filterOutEmptyPoiCategories(SearchResult searchResult) {
        Token[] tokenArray = searchResult.tokens;
        Token token = AbstractSearchResultFormatter.getTokenForType(tokenArray, 12);
        if (!AbstractSearchResultFormatter.isEmpty(token) && token.getToken().trim().length() > 0) {
            return new FormattedHighlightedText(token);
        }
        return new FormattedHighlightedText();
    }

    private String getStreet(NavLocation navLocation, IMyLocationAccessor iMyLocationAccessor) {
        if (Util.isHURegionJP()) {
            if (!Util.isEmpty(iMyLocationAccessor.getStreet())) {
                return iMyLocationAccessor.getStreet();
            }
            return iMyLocationAccessor.getChome();
        }
        if (Util.isHURegionKR()) {
            if (!Util.isEmpty(iMyLocationAccessor.getSubmunicipalTown()) && Util.isEmpty(iMyLocationAccessor.getStreet())) {
                return iMyLocationAccessor.getVillage();
            }
            return iMyLocationAccessor.getStreet();
        }
        return LocationFormatter.formatStreet(navLocation);
    }

    private String getCityPart(NavLocation navLocation, IMyLocationAccessor iMyLocationAccessor) {
        if (Util.isHURegionJP()) {
            return iMyLocationAccessor.getPlaceName();
        }
        if (Util.isHURegionKR()) {
            return iMyLocationAccessor.getSubmunicipalTown();
        }
        if (iMyLocationAccessor.isTownOrder9()) {
            return LocationFormatter.formatCity(navLocation);
        }
        return LocationFormatter.formatStreetRefinement(navLocation);
    }

    private String getStateNameFromNaviDetails(NaviService.NaviDetails naviDetails) {
        if (Util.isHURegionJP() || Util.isHURegionKR()) {
            return naviDetails.provinceOrPrefecture;
        }
        return naviDetails.state;
    }

    private String getCityPart(NaviService.NaviDetails naviDetails) {
        if (Util.isHURegionJP()) {
            return naviDetails.placeName;
        }
        if (Util.isHURegionKR()) {
            return naviDetails.placeName;
        }
        return "";
    }

    private String getWard(NavLocation navLocation, IMyLocationAccessor iMyLocationAccessor) {
        return iMyLocationAccessor.getWard();
    }

    private String extractCountryAbbreviation(SearchResult searchResult) {
        String string = "";
        if (searchResult.getCountry() != null) {
            string = searchResult.getCountry().getCode();
        } else {
            Token token = AbstractSearchResultFormatter.getTokenForType(searchResult.getTokens(), 17);
            if (!AbstractSearchResultFormatter.isEmpty(token)) {
                string = token.getToken();
            }
        }
        return string;
    }

    private FormattedHighlightedText extractStateAbbreviation(SearchResult searchResult) {
        if (searchResult.country != null) {
            return new FormattedHighlightedText(this.getAbbreviation(searchResult.country));
        }
        Token token = Util.extractTokenFromSearchresult(searchResult, 6);
        return new FormattedHighlightedText(token);
    }

    private String getAbbreviation(Country country) {
        String string = country.getStateAbbreviation();
        String string2 = country.getCode();
        return !Util.isEmpty(string) ? string : string2;
    }

    private int getMappedLocationTypeFromLocationAccessor(int n) {
        switch (n) {
            case 2: {
                return 0;
            }
            case 0: {
                return 1;
            }
            case 1: {
                return 2;
            }
            case 3: {
                return 3;
            }
        }
        return -1;
    }

    private int getMappedLocationTypeFromSearchResult(int n) {
        switch (n) {
            case 4: {
                return 1;
            }
            case 16: {
                return 4;
            }
            case 64: {
                return 5;
            }
            case 32: {
                return 6;
            }
            case 2: {
                return 2;
            }
            case 20: {
                return 7;
            }
            case 21: {
                return 8;
            }
            case 22: {
                return 0;
            }
        }
        return -1;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        this.appendIfNotEmpty(buffer, this.country, "country");
        this.appendIfNotEmpty(buffer, this.street, "street");
        this.appendIfNotEmpty(buffer, this.state, "state");
        this.appendIfNotEmpty(buffer, this.stateAbbreviation, "stateAbbreviation");
        this.appendIfNotEmpty(buffer, this.city, "city");
        this.appendIfNotEmpty(buffer, this.cityPart, "cityPart");
        this.appendIfNotEmpty(buffer, this.district, "district");
        this.appendIfNotEmpty(buffer, this.ward, "ward");
        this.appendIfNotEmpty(buffer, this.zip, "zip");
        this.appendIfNotEmpty(buffer, this.houseNumber, "houseNumber");
        this.appendIfNotEmpty(buffer, this.poiName, "poiName");
        this.appendIfNotEmpty(buffer, this.contactOrFavoriteName, "contactOrFavoritetName");
        this.appendIfNotEmpty(buffer, this.latitude, "latitude");
        this.appendIfNotEmpty(buffer, this.longitude, "longitude");
        this.appendIfNotEmpty(buffer, this.countryAbbreviation, "countryAbbreviation");
        this.appendIfNotEmpty(buffer, this.junction, "junction");
        this.appendIfNotEmpty(buffer, this.phonenumber, "phonenumber");
        this.appendIfNotEmpty(buffer, this.poiCategory, "poiCategory");
        this.appendIfNotEmpty(buffer, this.petrolStation, "petrolStation");
        return buffer.toString();
    }

    private void appendIfNotEmpty(Buffer buffer, FormattedHighlightedText formattedHighlightedText, String string) {
        if (formattedHighlightedText != null && !formattedHighlightedText.isEmpty()) {
            buffer.append(string).append(":").append(formattedHighlightedText.formattedText).append(", ");
        }
    }

    public LocationFormattingRequest() {
        this.country = new FormattedHighlightedText();
        this.street = new FormattedHighlightedText();
        this.city = new FormattedHighlightedText();
        this.cityPart = new FormattedHighlightedText();
        this.district = new FormattedHighlightedText();
        this.ward = new FormattedHighlightedText();
        this.zip = new FormattedHighlightedText();
        this.houseNumber = new FormattedHighlightedText();
        this.latitude = new FormattedHighlightedText();
        this.longitude = new FormattedHighlightedText();
        this.state = new FormattedHighlightedText();
        this.stateAbbreviation = new FormattedHighlightedText();
        this.countryAbbreviation = new FormattedHighlightedText();
        this.junction = new FormattedHighlightedText();
        this.phonenumber = new FormattedHighlightedText();
        this.poiCategory = new FormattedHighlightedText();
        this.areaInfo = new FormattedHighlightedText();
        this.petrolStation = new FormattedHighlightedText();
        this.poiName = new FormattedHighlightedText();
        this.contactOrFavoriteName = new FormattedHighlightedText();
        this.poiIs24hOpen = false;
        this.locationType = 1;
    }

    public void setCountry(String string) {
        this.country = new FormattedHighlightedText(string);
    }

    public void setStreet(String string) {
        this.street = new FormattedHighlightedText(string);
    }

    public void setState(String string) {
        this.state = new FormattedHighlightedText(string);
    }

    public void setStateAbbreviation(String string) {
        this.stateAbbreviation = new FormattedHighlightedText(string);
    }

    public void setCity(String string) {
        this.city = new FormattedHighlightedText(string);
    }

    public void setCityPart(String string) {
        this.cityPart = new FormattedHighlightedText(string);
    }

    public void setDistrict(String string) {
        this.district = new FormattedHighlightedText(string);
    }

    public void setWard(String string) {
        this.ward = new FormattedHighlightedText(string);
    }

    public void setZip(String string) {
        this.zip = new FormattedHighlightedText(string);
    }

    public void setHouseNumber(String string) {
        this.houseNumber = new FormattedHighlightedText(string);
    }

    public void setPoiName(String string) {
        this.poiName = new FormattedHighlightedText(string);
    }

    public void setContactOrFavoriteName(String string) {
        this.contactOrFavoriteName = new FormattedHighlightedText(string);
    }
}

