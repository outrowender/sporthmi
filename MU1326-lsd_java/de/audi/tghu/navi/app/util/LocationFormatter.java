/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util;

import de.audi.atip.interapp.locationaccessor.IMyLocationAccessor;
import de.audi.atip.metrics.GeoMetric;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.PicNavNaviInterfaceImpl;
import de.audi.tghu.navi.app.addressinput.poi.PoiUtil;
import de.audi.tghu.navi.app.poi.PhoneUtil;
import de.audi.tghu.navi.app.util.MMIInternalData;
import de.audi.tghu.navi.app.util.TextUtil;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.online.PoiOnlineSearchValuelistElement;

public class LocationFormatter {
    public static final String COUNTRY_CODE_USA;

    private static String InvalidGeoMetricAsString() {
        GeoMetric geoMetric = new GeoMetric();
        geoMetric.setGeoValues(0, 0);
        return geoMetric.format();
    }

    private static String GeoMetricAsString(NavLocation navLocation) {
        GeoMetric geoMetric = new GeoMetric();
        geoMetric.setGeoValues(navLocation.getLatitude(), navLocation.getLongitude());
        return geoMetric.format();
    }

    private static GeoMetric GeoMetric(NavLocation navLocation) {
        GeoMetric geoMetric = new GeoMetric();
        geoMetric.setGeoValues(navLocation.getLatitude(), navLocation.getLongitude());
        return geoMetric;
    }

    public static String formatCountryAbbreviation(NavLocation navLocation) {
        if (navLocation != null && !Util.isEmpty(navLocation.getCountryAbbreviation())) {
            return navLocation.getCountryAbbreviation();
        }
        return "";
    }

    public static String formatCountry(NavLocation navLocation) {
        if (navLocation != null && !Util.isEmpty(navLocation.getCountry())) {
            return navLocation.getCountry();
        }
        return "";
    }

    public static String formatCountryCode(NavLocation navLocation) {
        if (navLocation != null && !Util.isEmpty(navLocation.getCountry())) {
            return Util.getLocationAccessor(navLocation).getCountryCode();
        }
        return "";
    }

    public static String formatState(NavLocation navLocation) {
        if (navLocation != null && !Util.isEmpty(Util.getLocationAccessor(navLocation).getState())) {
            return Util.getLocationAccessor(navLocation).getState();
        }
        return "";
    }

    public static String formatStateAbbreviation(NavLocation navLocation) {
        if (navLocation != null && !Util.isEmpty(Util.getLocationAccessor(navLocation).getStateAbbreviation())) {
            return Util.getLocationAccessor(navLocation).getStateAbbreviation();
        }
        return "";
    }

    public static String formatGeocoordinates(NavLocation navLocation) {
        IMyLocationAccessor iMyLocationAccessor;
        if (navLocation != null && ((iMyLocationAccessor = Util.getLocationAccessor(navLocation)).getType() == 2 || Util.isGeoPosFlag(navLocation))) {
            String string = LocationFormatter.GeoMetricAsString(navLocation);
            return LocationFormatter.InvalidGeoMetricAsString().equals(string) ? "" : string;
        }
        return "";
    }

    public static String formatGeocoordinatesForce(NavLocation navLocation) {
        if (navLocation != null && (navLocation.getLatitude() != 0 || navLocation.getLongitude() != 0)) {
            return LocationFormatter.GeoMetric(navLocation).format();
        }
        return "";
    }

    public static String formatLatitude(NavLocation navLocation) {
        return navLocation != null ? LocationFormatter.GeoMetric(navLocation).formatLatitude() : "";
    }

    public static String formatLongitude(NavLocation navLocation) {
        return navLocation != null ? LocationFormatter.GeoMetric(navLocation).formatLongitude() : "";
    }

    public static String formatCity(NavLocation navLocation) {
        if (navLocation != null && !Util.isEmpty(navLocation.getTown())) {
            return navLocation.getTown();
        }
        return "";
    }

    public static String formatTownRefinement(NavLocation navLocation) {
        if (navLocation != null && !Util.isEmpty(navLocation.getTownRefinement())) {
            return navLocation.getTownRefinement();
        }
        return "";
    }

    public static String formatCityRefinement(NavLocation navLocation) {
        if (navLocation != null && !Util.isEmpty(navLocation.getTownRefinement())) {
            return navLocation.getTownRefinement();
        }
        return "";
    }

    public static String formatZIPCode(NavLocation navLocation) {
        if (navLocation != null && !Util.isEmpty(navLocation.getZipCode())) {
            return navLocation.getZipCode();
        }
        return "";
    }

    public static String formatCityWithCountryAbbreviation(NavLocation navLocation) {
        if (navLocation != null) {
            boolean bl;
            boolean bl2 = !Util.isEmpty(LocationFormatter.formatCountryAbbreviation(navLocation));
            boolean bl3 = bl = !Util.isEmpty(LocationFormatter.formatCity(navLocation));
            if (bl && bl2) {
                return LocationFormatter.formatCityWithCityAndCountryAbbreviation(navLocation);
            }
            if (bl2) {
                return LocationFormatter.formatCityWithOnlyCountryAbbreviation(navLocation);
            }
            if (bl) {
                return LocationFormatter.formatCity(navLocation);
            }
        }
        return "";
    }

    private static String formatCityWithCityAndCountryAbbreviation(NavLocation navLocation) {
        Buffer buffer = new Buffer();
        buffer.append('(').append(LocationFormatter.formatCountryAbbreviation(navLocation)).append(')');
        buffer.append(", ").append(LocationFormatter.formatCity(navLocation));
        return buffer.toString();
    }

    private static String formatCityWithOnlyCountryAbbreviation(NavLocation navLocation) {
        Buffer buffer = new Buffer();
        buffer.append('(').append(LocationFormatter.formatCountryAbbreviation(navLocation)).append(')');
        return buffer.toString();
    }

    public static boolean hasFullPostalCode(NavLocation navLocation) {
        return navLocation != null ? Util.isAdditionalFlagSet(navLocation, 8) : false;
    }

    public static String formatCityZipTextfield(NavLocation navLocation) {
        return Util.isHURegionNAR() ? LocationFormatter.formatCityZipTextfieldNAR(navLocation) : LocationFormatter.formatCityZipTextfieldDefault(navLocation);
    }

    private static String formatCityZipTextfieldDefault(NavLocation navLocation) {
        if (navLocation != null) {
            String string = LocationFormatter.formatCityTitleWithoutCityCenter(navLocation);
            String string2 = LocationFormatter.formatZIPCode(navLocation);
            boolean bl = !Util.isEmpty(string);
            boolean bl2 = !Util.isEmpty(string2);
            boolean bl3 = Util.isAdditionalFlagSet(navLocation, 96) || Util.isGeoPosType(navLocation);
            Buffer buffer = new Buffer();
            if (bl && bl2 && bl3) {
                buffer.append(string2).append(' ').append(string);
            } else if (bl) {
                buffer.append(string);
            } else if (bl2) {
                buffer.append(string2);
            }
            return buffer.toString();
        }
        return "";
    }

    private static String formatCityZipTextfieldNAR(NavLocation navLocation) {
        if (navLocation != null) {
            String string = LocationFormatter.formatCityTitleWithoutCityCenter(navLocation);
            String string2 = LocationFormatter.formatZIPCode(navLocation);
            String string3 = LocationFormatter.formatStateAbbreviation(navLocation);
            boolean bl = !Util.isEmpty(string);
            boolean bl2 = !Util.isEmpty(string2);
            boolean bl3 = Util.isAdditionalFlagSet(navLocation, 96) || Util.isGeoPosType(navLocation);
            boolean bl4 = !Util.isEmpty(string3);
            Buffer buffer = new Buffer();
            if (bl && bl2 && bl3) {
                buffer.append(string).append(' ').append(string2);
            } else if (bl) {
                buffer.append(string);
            } else if (bl2) {
                buffer.append(string2);
            }
            if (bl4 && bl) {
                buffer.append(", ").append(string3);
            }
            return buffer.toString();
        }
        return "";
    }

    public static String formatCityTitleWithoutCityCenter(NavLocation navLocation) {
        return LocationFormatter.formatCityTitle(navLocation, false);
    }

    public static String formatCityTitleIncludingCityCenter(NavLocation navLocation) {
        return LocationFormatter.formatCityTitle(navLocation, true);
    }

    private static String formatCityTitle(NavLocation navLocation, boolean bl) {
        if (navLocation != null) {
            Buffer buffer = new Buffer();
            String string = navLocation.getTown();
            String string2 = navLocation.getTowncenter();
            String string3 = navLocation.getTownRefinement();
            String string4 = navLocation.getStreetRefinement();
            if (!Util.isEmpty(string)) {
                if (!Util.isEmpty(string4)) {
                    buffer.append(string4).append(", ");
                }
                buffer.append(string);
                if (!Util.isEmpty(string3) && Util.isAdditionalFlagSet(navLocation, 144)) {
                    buffer.append(", ").append(string3);
                }
                if (bl && !Util.isEmpty(string2)) {
                    buffer.append(", ").append(string2);
                }
            }
            return buffer.toString();
        }
        return "";
    }

    public static String formatStreetTextfield(NavLocation navLocation) {
        if (navLocation != null) {
            if (!Util.isEmpty(navLocation.getStreet())) {
                return LocationFormatter.formatStreet(navLocation);
            }
            if (LocationFormatter.hasFullPostalCode(navLocation) || Util.isGeoPosFlag(navLocation) || LocationFormatter.getLocationType(navLocation) == 0x800000 || LocationFormatter.getLocationType(navLocation) == 124) {
                return "";
            }
            if (!Util.isEmpty(navLocation.getTown()) || !Util.isEmpty(navLocation.getZipCode())) {
                return TextUtil.getCenterName();
            }
        }
        return "";
    }

    public static String formatChomeTextField(NavLocation navLocation) {
        if (navLocation != null) {
            return LocationFormatter.formatChome(navLocation);
        }
        return "";
    }

    public static String formatWardTextField(NavLocation navLocation) {
        if (navLocation != null) {
            return LocationFormatter.formatWard(navLocation);
        }
        return "";
    }

    public static String formatPlaceNameTextField(NavLocation navLocation) {
        if (navLocation != null) {
            return LocationFormatter.formatPlaceName(navLocation);
        }
        return "";
    }

    public static String formatSubmunicipalTownTextField(NavLocation navLocation) {
        if (navLocation != null) {
            return LocationFormatter.formatSubmunicipalTown(navLocation);
        }
        return "";
    }

    public static String formatVillageTextField(NavLocation navLocation) {
        if (navLocation != null) {
            return LocationFormatter.formatVillage(navLocation);
        }
        return "";
    }

    public static int getLocationType(NavLocation navLocation) {
        if (navLocation != null) {
            switch (Util.getLocationAccessor(navLocation).getType()) {
                case 1: {
                    return 0x800000;
                }
                case 2: {
                    return 124;
                }
            }
            return 0;
        }
        return 0;
    }

    public static String formatStreet(NavLocation navLocation) {
        if (navLocation != null && !Util.isEmpty(navLocation.getStreet())) {
            return navLocation.getStreet();
        }
        return "";
    }

    public static String formatChome(NavLocation navLocation) {
        if (navLocation != null && !Util.isEmpty(Util.getLocationAccessor(navLocation).getChome())) {
            return Util.getLocationAccessor(navLocation).getChome();
        }
        return "";
    }

    public static String formatWard(NavLocation navLocation) {
        if (navLocation != null && !Util.isEmpty(Util.getLocationAccessor(navLocation).getWard())) {
            return Util.getLocationAccessor(navLocation).getWard();
        }
        return "";
    }

    public static String formatPlaceName(NavLocation navLocation) {
        if (navLocation != null && !Util.isEmpty(Util.getLocationAccessor(navLocation).getPlaceName())) {
            return Util.getLocationAccessor(navLocation).getPlaceName();
        }
        return "";
    }

    public static String formatSubmunicipalTown(NavLocation navLocation) {
        if (navLocation != null && !Util.isEmpty(Util.getLocationAccessor(navLocation).getSubmunicipalTown())) {
            return Util.getLocationAccessor(navLocation).getSubmunicipalTown();
        }
        return "";
    }

    public static String formatVillage(NavLocation navLocation) {
        if (navLocation != null && !Util.isEmpty(Util.getLocationAccessor(navLocation).getVillage())) {
            return Util.getLocationAccessor(navLocation).getVillage();
        }
        return "";
    }

    public static String formatStreetRefinement(NavLocation navLocation) {
        if (navLocation != null && !Util.isEmpty(navLocation.getStreetRefinement())) {
            return navLocation.getStreetRefinement();
        }
        return "";
    }

    public static String formatStreetHousenumber(NavLocation navLocation) {
        return Util.isHURegionNAR() ? LocationFormatter.formatStreetHousenumberNAR(navLocation) : LocationFormatter.formatStreetHousenumberEU(navLocation);
    }

    private static String formatStreetHousenumberNAR(NavLocation navLocation) {
        String string;
        if (navLocation != null && !Util.isEmpty(string = LocationFormatter.formatStreet(navLocation))) {
            String string2 = navLocation.getHousenumber();
            if (!Util.isEmpty(string2)) {
                Buffer buffer = new Buffer();
                buffer.append(string2).append(' ').append(string);
                return buffer.toString();
            }
            return string;
        }
        return "";
    }

    private static String formatStreetHousenumberEU(NavLocation navLocation) {
        String string;
        if (navLocation != null && !Util.isEmpty(string = LocationFormatter.formatStreet(navLocation))) {
            String string2 = navLocation.getHousenumber();
            if (!Util.isEmpty(string2)) {
                Buffer buffer = new Buffer();
                buffer.append(string).append(' ').append(string2);
                return buffer.toString();
            }
            return string;
        }
        return "";
    }

    public static String formatHousenumber(NavLocation navLocation) {
        if (navLocation != null && !Util.isEmpty(navLocation.getHousenumber())) {
            return navLocation.getHousenumber();
        }
        return "";
    }

    public static String formatTownCenter(NavLocation navLocation) {
        if (navLocation != null && !Util.isEmpty(navLocation.getTowncenter())) {
            return navLocation.getTowncenter();
        }
        return "";
    }

    public static String formatJunction(NavLocation navLocation) {
        if (navLocation != null && !Util.isEmpty(navLocation.getJunction())) {
            return navLocation.getJunction();
        }
        return "";
    }

    public static String formatPOIName(NavLocation navLocation) {
        if (navLocation != null) {
            Buffer buffer = new Buffer();
            IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
            if (!Util.isEmpty(iMyLocationAccessor.getMmiInternalData())) {
                MMIInternalData mMIInternalData = new MMIInternalData();
                mMIInternalData.init(iMyLocationAccessor.getMmiInternalData());
                buffer.append(mMIInternalData.getValue("OnlineName"));
            }
            if (buffer.length() == 0 && !Util.isEmpty(iMyLocationAccessor.getPoiName())) {
                buffer.append(Util.stripNumber(iMyLocationAccessor.getPoiName()));
            }
            if (Util.isHURegionNAR() && buffer.length() > 0 && PoiUtil.isPoi24h(navLocation)) {
                PoiUtil.appendPoi24hMarker(buffer);
            }
            return buffer.toString();
        }
        return "";
    }

    public static String formatPOIAdditionalInfo(NavLocation navLocation) {
        if (navLocation != null) {
            String string = Util.getLocationAccessor(navLocation).getAdditionalPoiAttributeString(6);
            return string == null ? "" : string;
        }
        return "";
    }

    public static String formatPOICategory(NavLocation navLocation) {
        if (navLocation != null) {
            String string = Util.getLocationAccessor(navLocation).getPoiCategory();
            return string == null ? "" : string;
        }
        return "";
    }

    public static int getIconResourceID(IconHandler iconHandler, NavLocation navLocation) {
        if (navLocation != null && iconHandler != null) {
            IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
            int n = iMyLocationAccessor.getIconIndex();
            int n2 = iMyLocationAccessor.getSubIconIndex();
            return iconHandler.resolvePOIIconResourceID(n, n2);
        }
        return -1;
    }

    public static int getIconResourceID(IconHandler iconHandler, int n, int n2) {
        if (iconHandler != null) {
            return iconHandler.resolvePOIIconResourceID(n, n2);
        }
        return -1;
    }

    public static String formatPhonenumber(NavLocation navLocation) {
        if (navLocation != null) {
            String string = PhoneUtil.formatPhonenumber(LocationFormatter.getPhoneNumberFromMmiInternalData(navLocation));
            return string == "" ? PhoneUtil.formatPhonenumber(LocationFormatter.getPhoneNumberFromAccessor(navLocation)) : string;
        }
        return "";
    }

    public static String getPhoneNumber(NavLocation navLocation) {
        if (navLocation != null) {
            IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
            if (!Util.isEmpty(iMyLocationAccessor.getPhonenumber())) {
                return LocationFormatter.getPhoneNumberFromAccessor(navLocation);
            }
            if (!Util.isEmpty(iMyLocationAccessor.getMmiInternalData())) {
                return LocationFormatter.getPhoneNumberFromMmiInternalData(navLocation);
            }
        }
        return "";
    }

    private static String getPhoneNumberFromAccessor(NavLocation navLocation) {
        IMyLocationAccessor iMyLocationAccessor;
        if (navLocation != null && !Util.isEmpty((iMyLocationAccessor = Util.getLocationAccessor(navLocation)).getPhonenumber())) {
            String string = iMyLocationAccessor.getPhonenumber();
            return string == null ? "" : string;
        }
        return "";
    }

    private static String getPhoneNumberFromMmiInternalData(NavLocation navLocation) {
        IMyLocationAccessor iMyLocationAccessor;
        if (navLocation != null && !Util.isEmpty((iMyLocationAccessor = Util.getLocationAccessor(navLocation)).getMmiInternalData())) {
            MMIInternalData mMIInternalData = new MMIInternalData();
            mMIInternalData.init(iMyLocationAccessor.getMmiInternalData());
            String string = mMIInternalData.getValue("Phone");
            return string == null ? "" : string;
        }
        return "";
    }

    public static String formatWaypointTitle(NavLocation navLocation) {
        if (navLocation != null) {
            String string = LocationFormatter.formatLocationTitle(navLocation);
            String string2 = Util.isEmpty(string) ? LocationFormatter.formatGeocoordinates(navLocation) : string;
            return string2 == null ? "" : string2;
        }
        return "";
    }

    public static String formatLocationTitle(NavLocation navLocation) {
        IMyLocationAccessor iMyLocationAccessor;
        if (navLocation != null && !Util.isEmpty((iMyLocationAccessor = Util.getLocationAccessor(navLocation)).getMmiInternalData())) {
            MMIInternalData mMIInternalData = new MMIInternalData();
            mMIInternalData.init(iMyLocationAccessor.getMmiInternalData());
            String string = mMIInternalData.getValue("Title");
            return string == null ? "" : string;
        }
        return "";
    }

    public static String getOnlinePoiID(NavLocation navLocation) {
        IMyLocationAccessor iMyLocationAccessor;
        if (navLocation != null && !Util.isEmpty((iMyLocationAccessor = Util.getLocationAccessor(navLocation)).getMmiInternalData())) {
            MMIInternalData mMIInternalData = new MMIInternalData();
            mMIInternalData.init(iMyLocationAccessor.getMmiInternalData());
            String string = mMIInternalData.getValue("OnlienPoiID");
            return string == null ? "" : string;
        }
        return "";
    }

    public static String getURLAddress(NavLocation navLocation) {
        if (navLocation != null) {
            IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
            if (!Util.isEmpty(iMyLocationAccessor.getURLAddress())) {
                return iMyLocationAccessor.getURLAddress();
            }
            if (!Util.isEmpty(iMyLocationAccessor.getMmiInternalData())) {
                return LocationFormatter.getUrlAddressFromInternalData(iMyLocationAccessor);
            }
        }
        return "";
    }

    private static String getUrlAddressFromInternalData(IMyLocationAccessor iMyLocationAccessor) {
        MMIInternalData mMIInternalData = new MMIInternalData();
        mMIInternalData.init(iMyLocationAccessor.getMmiInternalData());
        String string = mMIInternalData.getValue("URL");
        return string == null ? "" : string;
    }

    public static String formatLocation(NavLocation navLocation, String string) {
        if (navLocation != null) {
            Buffer buffer = new Buffer(1024);
            String string2 = LocationFormatter.formatCountry(navLocation);
            String string3 = LocationFormatter.formatCountryAbbreviation(navLocation);
            String string4 = LocationFormatter.formatState(navLocation);
            String string5 = LocationFormatter.formatCityZipTextfield(navLocation);
            String string6 = LocationFormatter.formatWardTextField(navLocation);
            String string7 = LocationFormatter.formatSubmunicipalTownTextField(navLocation);
            String string8 = LocationFormatter.formatVillageTextField(navLocation);
            String string9 = LocationFormatter.formatStreetTextfield(navLocation);
            String string10 = LocationFormatter.formatPlaceNameTextField(navLocation);
            String string11 = LocationFormatter.formatChomeTextField(navLocation);
            String string12 = LocationFormatter.formatHousenumber(navLocation);
            String string13 = LocationFormatter.formatTownCenter(navLocation);
            String string14 = LocationFormatter.formatJunction(navLocation);
            String string15 = LocationFormatter.formatGeocoordinatesForce(navLocation);
            String string16 = LocationFormatter.formatPOIName(navLocation);
            String string17 = LocationFormatter.formatLocationTitle(navLocation);
            String string18 = LocationFormatter.formatPhonenumber(navLocation);
            String string19 = LocationFormatter.getURLAddress(navLocation);
            String string20 = Util.getPetrolStationValue(navLocation);
            boolean bl = PicNavNaviInterfaceImpl.isPicNavLocationStatic(navLocation);
            boolean bl2 = navLocation.isPositionValid();
            if (!Util.isEmpty(string2)) {
                buffer.append(string).append("Country: ").append(string2).append("\n");
            }
            if (!Util.isEmpty(string3)) {
                buffer.append(string).append("CountryAbbreviation: ").append(string3).append("\n");
            }
            if (!Util.isEmpty(string4)) {
                buffer.append(string).append("State: ").append(string4).append("\n");
            }
            if (!Util.isEmpty(string5)) {
                buffer.append(string).append("CityZip: ").append(string5).append("\n");
            }
            if (!Util.isEmpty(string6)) {
                buffer.append(string).append("Ward: ").append(string6).append("\n");
            }
            if (!Util.isEmpty(string7)) {
                buffer.append(string).append("Submunicipal Town: ").append(string7).append("\n");
            }
            if (!Util.isEmpty(string8)) {
                buffer.append(string).append("Village: ").append(string8).append("\n");
            }
            if (!Util.isEmpty(string9)) {
                buffer.append(string).append("Street: ").append(string9).append("\n");
            }
            if (!Util.isEmpty(string10)) {
                buffer.append(string).append("PlaceName: ").append(string10).append("\n");
            }
            if (!Util.isEmpty(string11)) {
                buffer.append(string).append("Chome: ").append(string11).append("\n");
            }
            if (!Util.isEmpty(string12)) {
                buffer.append(string).append("HouseNumber: ").append(string12).append("\n");
            }
            if (!Util.isEmpty(string13)) {
                buffer.append(string).append("Towncenter: ").append(string13).append("\n");
            }
            if (!Util.isEmpty(string14)) {
                buffer.append(string).append("Junction: ").append(string14).append("\n");
            }
            if (!Util.isEmpty(string15)) {
                buffer.append(string).append("GeoCoordinates: ").append(string15).append("\n");
            }
            if (!Util.isEmpty(string16)) {
                buffer.append(string).append("POIName: ").append(string16).append("\n");
            }
            if (!Util.isEmpty(string17)) {
                buffer.append(string).append("Title: ").append(string17).append("\n");
            }
            if (!Util.isEmpty(string18)) {
                buffer.append(string).append("Phone: ").append(string18).append("\n");
            }
            if (!Util.isEmpty(string19)) {
                buffer.append(string).append("URL: ").append(string19).append("\n");
            }
            if (!Util.isEmpty(string20)) {
                buffer.append(string).append("PETROL: ").append(string20).append("\n");
            }
            if (bl) {
                buffer.append(string).append("PICNAV").append("\n");
            }
            if (bl2) {
                buffer.append(string).append("positionValid: ").append(bl2).append("\n");
            }
            return buffer.toString();
        }
        return "null\n";
    }

    public static String formatLocationShort(NavLocation navLocation) {
        if (navLocation != null) {
            Buffer buffer = new Buffer(1024);
            buffer.append('[');
            String string = LocationFormatter.formatCountry(navLocation);
            String string2 = LocationFormatter.formatCountryAbbreviation(navLocation);
            String string3 = LocationFormatter.formatState(navLocation);
            String string4 = LocationFormatter.formatCityZipTextfield(navLocation);
            String string5 = LocationFormatter.formatWardTextField(navLocation);
            String string6 = LocationFormatter.formatStreetTextfield(navLocation);
            String string7 = LocationFormatter.formatPlaceNameTextField(navLocation);
            String string8 = LocationFormatter.formatChomeTextField(navLocation);
            String string9 = LocationFormatter.formatSubmunicipalTownTextField(navLocation);
            String string10 = LocationFormatter.formatVillageTextField(navLocation);
            String string11 = LocationFormatter.formatHousenumber(navLocation);
            String string12 = LocationFormatter.formatTownCenter(navLocation);
            String string13 = LocationFormatter.formatJunction(navLocation);
            String string14 = LocationFormatter.formatGeocoordinatesForce(navLocation);
            String string15 = LocationFormatter.formatPOIName(navLocation);
            String string16 = LocationFormatter.formatLocationTitle(navLocation);
            String string17 = LocationFormatter.formatPhonenumber(navLocation);
            String string18 = LocationFormatter.getURLAddress(navLocation);
            String string19 = Util.getPetrolStationValue(navLocation);
            boolean bl = PicNavNaviInterfaceImpl.isPicNavLocationStatic(navLocation);
            boolean bl2 = navLocation.isPositionValid();
            boolean bl3 = Util.getLocationAccessor(navLocation).isTownOrder9();
            if (!Util.isEmpty(string)) {
                buffer.append(string).append(", ");
            }
            if (!Util.isEmpty(string2)) {
                buffer.append(string2).append(", ");
            }
            if (!Util.isEmpty(string3)) {
                buffer.append(string3).append(", ");
            }
            if (!Util.isEmpty(string4)) {
                buffer.append(string4).append(", ");
            }
            if (!Util.isEmpty(string5)) {
                buffer.append(string5).append(", ");
            }
            if (!Util.isEmpty(string9)) {
                buffer.append(string9).append(", ");
            }
            if (!Util.isEmpty(string10)) {
                buffer.append(string10).append(", ");
            }
            if (!Util.isEmpty(string6)) {
                buffer.append(string6).append(", ");
            }
            if (!Util.isEmpty(string7)) {
                buffer.append(string7).append(", ");
            }
            if (!Util.isEmpty(string8)) {
                buffer.append(string8).append(", ");
            }
            if (!Util.isEmpty(string11)) {
                buffer.append(string11).append(", ");
            }
            if (!Util.isEmpty(string12)) {
                buffer.append(string12).append(", ");
            }
            if (!Util.isEmpty(string13)) {
                buffer.append(string13).append(", ");
            }
            if (!Util.isEmpty(string14)) {
                buffer.append(string14).append(", ");
            }
            if (!Util.isEmpty(string15)) {
                buffer.append(string15).append(", ");
            }
            if (!Util.isEmpty(string16)) {
                buffer.append(string16).append(", ");
            }
            if (!Util.isEmpty(string17)) {
                buffer.append(string17).append(", ");
            }
            if (!Util.isEmpty(string18)) {
                buffer.append("URL").append(", ");
            }
            if (!Util.isEmpty(string19)) {
                buffer.append("PETROL: ").append(string19).append(", ");
            }
            if (bl) {
                buffer.append("PICNAV").append(", ");
            }
            if (bl3) {
                buffer.append("townOrder9").append(", ");
            }
            if (bl2) {
                buffer.append("posValid");
            }
            buffer.append(']');
            return buffer.toString();
        }
        return "[null]";
    }

    public static String formatPoiOnlineElementShort(PoiOnlineSearchValuelistElement poiOnlineSearchValuelistElement) {
        if (poiOnlineSearchValuelistElement != null) {
            Buffer buffer = new Buffer(1024);
            String string = poiOnlineSearchValuelistElement.name;
            String string2 = poiOnlineSearchValuelistElement.city;
            String string3 = poiOnlineSearchValuelistElement.postal;
            String string4 = poiOnlineSearchValuelistElement.street;
            String string5 = poiOnlineSearchValuelistElement.url;
            String string6 = poiOnlineSearchValuelistElement.phone;
            if (!Util.isEmpty(string)) {
                buffer.append("name=").append(string).append(", ");
            }
            if (!Util.isEmpty(string2)) {
                buffer.append("city=").append(string2).append(", ");
            }
            if (!Util.isEmpty(string3)) {
                buffer.append("postal=").append(string3).append(", ");
            }
            if (!Util.isEmpty(string4)) {
                buffer.append("street=").append(string4).append(", ");
            }
            if (!Util.isEmpty(string5)) {
                buffer.append("url=").append(string5).append(", ");
            }
            if (!Util.isEmpty(string6)) {
                buffer.append("phone=").append(string6);
            }
            return buffer.toString();
        }
        return "<null>";
    }

    public static boolean isEmpty(String string) {
        return string == null || string.length() == 0;
    }

    public static String getStringForPhoneticType(int n) {
        String string = null;
        switch (n) {
            case 8: {
                string = LocationFormatter.createPhonemeString("POIName=");
                break;
            }
            case 14: {
                string = LocationFormatter.createPhonemeString("displayString=");
                break;
            }
            case 0: {
                string = LocationFormatter.createPhonemeString("country=");
                break;
            }
            case 12: {
                string = LocationFormatter.createPhonemeString("zipCode=");
                break;
            }
            case 2: {
                string = LocationFormatter.createPhonemeString("town=");
                break;
            }
            case 1: {
                string = LocationFormatter.createPhonemeString("state=");
                break;
            }
            case 4: {
                string = LocationFormatter.createPhonemeString("towncenter=");
                break;
            }
            case 3: {
                string = LocationFormatter.createPhonemeString("citypart=");
                break;
            }
            case 5: {
                string = LocationFormatter.createPhonemeString("street=");
                break;
            }
            case 7: {
                string = LocationFormatter.createPhonemeString("junction=");
                break;
            }
            case 13: {
                string = LocationFormatter.createPhonemeString("housenumber=");
                break;
            }
            case 15: {
                string = LocationFormatter.createPhonemeString("district=");
                break;
            }
            default: {
                string = null;
            }
        }
        return string;
    }

    private static String createPhonemeString(String string) {
        return new StringBuffer().append("\u241d").append(string).toString();
    }

    public static String splitStringToSingleCharactersWithWhitespace(String string) {
        String string2 = string;
        if (string != null) {
            Buffer buffer = new Buffer();
            for (int i2 = 0; i2 < string.length(); ++i2) {
                buffer.append(string.charAt(i2));
                if (i2 >= string.length() - 1) continue;
                buffer.append(' ');
            }
            string2 = buffer.toString();
        }
        return string2;
    }

    public static String getCity(IMyLocationAccessor iMyLocationAccessor) {
        if (Util.isHURegionKR() && iMyLocationAccessor.isLocationInCityState()) {
            return "";
        }
        if (iMyLocationAccessor.isTownOrder9()) {
            return iMyLocationAccessor.getTownRefinement();
        }
        return iMyLocationAccessor.getTown();
    }

    public static String getDistrict(IMyLocationAccessor iMyLocationAccessor) {
        if (iMyLocationAccessor.isTownOrder9()) {
            return iMyLocationAccessor.getTown();
        }
        return "";
    }
}

