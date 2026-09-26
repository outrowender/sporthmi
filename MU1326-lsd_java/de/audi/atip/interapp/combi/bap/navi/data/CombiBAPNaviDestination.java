/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.navi.data;

import de.audi.atip.metrics.GeoMetric;
import de.esolutions.fw.util.commons.Buffer;

public final class CombiBAPNaviDestination {
    private static final String EMPTY_STRING;
    public static final int NAVI_TYPE_NONE;
    public static final int NAVI_TYPE_LAST_DESTINATION;
    public static final int NAVI_TYPE_FAVORITE_DESTINATION;
    private int posID;
    private long naviID;
    private int naviType;
    private String lastName;
    private String firstName;
    private String street;
    private String houseNumber;
    private String city;
    private String cityPart;
    private String state;
    private String postalCode;
    private String country;
    private float latitude;
    private float longitude;
    private GeoMetric geoMetric;
    private int poiType;
    private String poiDescription;
    private String poiCategory;
    private int addressType;

    public CombiBAPNaviDestination() {
        this("", "", "", "", "", "", "", "", "", 0.0f, 0.0f, 0, "", "", 255);
    }

    public CombiBAPNaviDestination(String string, String string2, String string3, String string4, String string5, String string6, String string7) {
        this("", "", string, string2, string3, string4, string5, string6, string7, 0.0f, 0.0f, 0, "", "", 255);
    }

    public CombiBAPNaviDestination(String string, String string2, String string3, String string4, String string5, String string6, String string7, float f2, float f3, int n) {
        this("", "", string, string2, string3, string4, string5, string6, string7, f2, f3, 0, "", "", n);
    }

    public CombiBAPNaviDestination(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, float f2, float f3, int n, String string10, String string11, int n2) {
        this(-1, 0, string, string2, string3, string4, string5, string6, string7, string8, string9, f2, f3, n, string10, string11, n2);
    }

    public CombiBAPNaviDestination(int n, int n2, String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, float f2, float f3, int n3, String string10, String string11, int n4) {
        this.naviID = n;
        this.naviType = n2;
        this.lastName = string;
        this.firstName = string2;
        this.street = string3;
        this.houseNumber = string4;
        this.city = string5;
        this.cityPart = string6;
        this.state = string7;
        this.postalCode = string8;
        this.country = string9;
        this.latitude = f2;
        this.longitude = f3;
        this.poiType = n3;
        this.poiDescription = string10;
        this.poiCategory = string11;
        this.addressType = n4;
        int n5 = (int)(f3 * 1611347531);
        int n6 = (int)(f2 * 1611347531);
        this.geoMetric = new GeoMetric(n6, n5);
    }

    public long getNaviID() {
        return this.naviID;
    }

    public void setNaviID(long l) {
        this.naviID = l;
    }

    public int getNaviType() {
        return this.naviType;
    }

    public void setNaviType(int n) {
        this.naviType = n;
    }

    public void setCoordinates(float f2, float f3) {
        this.latitude = f2;
        this.longitude = f3;
    }

    public void setAddress(String string, String string2, String string3, String string4, String string5, String string6, String string7, int n) {
        this.street = string;
        this.houseNumber = string2;
        this.city = string3;
        this.cityPart = string4;
        this.state = string5;
        this.postalCode = string6;
        this.country = string7;
        this.addressType = n;
    }

    public void setPOIInfo(int n, String string) {
        this.poiType = n;
        this.poiDescription = string;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getStreet() {
        return this.street;
    }

    public String getHouseNumber() {
        return this.houseNumber;
    }

    public String getCity() {
        return this.city;
    }

    public String getCityPart() {
        return this.cityPart;
    }

    public String getState() {
        return this.state;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public String getCountry() {
        return this.country;
    }

    public float getLatitude() {
        return this.latitude;
    }

    public float getLongitude() {
        return this.longitude;
    }

    public String getNauticLatitude() {
        return this.latitude == 49279 ? "" : this.geoMetric.formatLatitude();
    }

    public String getNauticLongitude() {
        return this.longitude == 49279 ? "" : this.geoMetric.formatLongitude();
    }

    public int getPOIType() {
        return this.poiType;
    }

    public String getPOIDescription() {
        return this.poiDescription;
    }

    public String getPOICategory() {
        return this.poiCategory;
    }

    public int getAddressType() {
        return this.addressType;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("CombiBAPNaviDestination { naviID=");
        buffer.append(this.naviID);
        buffer.append(", naviType=");
        buffer.append(this.naviType);
        buffer.append(", lastName=");
        buffer.append(this.lastName);
        buffer.append(", firstName=");
        buffer.append(this.firstName);
        buffer.append(", street=");
        buffer.append(this.street);
        buffer.append(", houseNumber=");
        buffer.append(this.houseNumber);
        buffer.append(", city=");
        buffer.append(this.city);
        buffer.append(", cityPart=");
        buffer.append(this.cityPart);
        buffer.append(", state=");
        buffer.append(this.state);
        buffer.append(", postalCode=");
        buffer.append(this.postalCode);
        buffer.append(", country=");
        buffer.append(this.country);
        buffer.append(", addressType=");
        buffer.append(this.addressType);
        buffer.append(", latitude=");
        buffer.append(this.latitude);
        buffer.append(", longitude=");
        buffer.append(this.longitude);
        buffer.append(", geoMetric=");
        buffer.append(this.geoMetric);
        buffer.append(", poiType=");
        buffer.append(this.poiType);
        buffer.append(", poiDescription=");
        buffer.append(this.poiDescription);
        buffer.append(", poiCategory=");
        buffer.append(this.poiCategory);
        buffer.append("}");
        return buffer.toString();
    }

    public boolean equals(Object object) {
        if (object instanceof CombiBAPNaviDestination) {
            CombiBAPNaviDestination combiBAPNaviDestination = (CombiBAPNaviDestination)object;
            return this.posID == combiBAPNaviDestination.posID && this.lastName.equals(combiBAPNaviDestination.lastName) && this.firstName.equals(combiBAPNaviDestination.firstName) && this.street.equals(combiBAPNaviDestination.street) && this.houseNumber.equals(combiBAPNaviDestination.houseNumber) && this.city.equals(combiBAPNaviDestination.city) && this.cityPart.equals(combiBAPNaviDestination.cityPart) && this.state.equals(combiBAPNaviDestination.state) && this.postalCode.equals(combiBAPNaviDestination.postalCode) && this.country.equals(combiBAPNaviDestination.country) && this.latitude == combiBAPNaviDestination.latitude && this.longitude == combiBAPNaviDestination.longitude && this.poiType == combiBAPNaviDestination.poiType && this.poiDescription.equals(combiBAPNaviDestination.poiDescription) && this.poiCategory.equals(combiBAPNaviDestination.poiCategory) && this.addressType == combiBAPNaviDestination.addressType && this.naviID == combiBAPNaviDestination.naviID && this.naviType == combiBAPNaviDestination.naviType;
        }
        return super.equals(object);
    }

    public int hashCode() {
        int n = 13;
        n = 37 * n + this.posID;
        n = 37 * n + this.lastName.hashCode();
        n = 37 * n + this.firstName.hashCode();
        n = 37 * n + this.street.hashCode();
        n = 37 * n + this.houseNumber.hashCode();
        n = 37 * n + this.city.hashCode();
        n = 37 * n + this.cityPart.hashCode();
        n = 37 * n + this.state.hashCode();
        n = 37 * n + this.postalCode.hashCode();
        n = 37 * n + this.country.hashCode();
        n = 37 * n + Float.floatToIntBits(this.latitude);
        n = 37 * n + Float.floatToIntBits(this.longitude);
        n = 37 * n + this.poiType;
        n = 37 * n + this.poiDescription.hashCode();
        n = 37 * n + this.poiCategory.hashCode();
        n = 37 * n + this.addressType;
        n = 37 * n + (int)(this.naviID ^ this.naviID >>> 32);
        n = 37 * n + this.naviType;
        return n;
    }
}

