/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.favorite;

import de.audi.app.navi.favorite.DefaultFavoriteLocationFormat;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

public class FavoriteLocationFormatNAR
extends DefaultFavoriteLocationFormat {
    public FavoriteLocationFormatNAR(NavigationEnv navigationEnv) {
        super(navigationEnv);
    }

    @Override
    public String getDefaultName(NavLocation navLocation) {
        if (navLocation == null) {
            return "";
        }
        this.init(navLocation);
        String string = "";
        string = this.isLocationPOI() ? this.getPOIName() : (this.isLocationContact() ? this.getContactName() : this.formatAddress(navLocation));
        if (Util.isEmpty(string)) {
            string = this.getTimeStamp();
        }
        this.clear();
        return string;
    }

    private String formatAddress(NavLocation navLocation) {
        String string = this.locationAccessor.getCountryCode();
        if ("CAN".equalsIgnoreCase(string)) {
            return this.formatAddressCAN(navLocation);
        }
        if ("MEX".equalsIgnoreCase(string)) {
            return this.formatAddressMEX(navLocation);
        }
        if ("USA".equalsIgnoreCase(string)) {
            return this.formatAddressUSA(navLocation);
        }
        return this.formatAddressUSA(navLocation);
    }

    private String formatAddressUSA(NavLocation navLocation) {
        StringBuffer stringBuffer = new StringBuffer();
        String string = LocationFormatter.formatStreetTextfield(navLocation);
        String string2 = LocationFormatter.formatHousenumber(navLocation);
        String string3 = LocationFormatter.formatCity(navLocation);
        String string4 = this.getAbbreviation(navLocation);
        String string5 = LocationFormatter.formatZIPCode(navLocation);
        if (!Util.isEmpty(string)) {
            if (!Util.isEmpty(string2)) {
                stringBuffer.append(string2);
                stringBuffer.append(" ");
            }
            stringBuffer.append(string);
        }
        if (!Util.isEmpty(string3)) {
            this.addSeparator(stringBuffer);
            stringBuffer.append(string3);
        }
        if (!Util.isEmpty(string4)) {
            this.addSeparator(stringBuffer);
            stringBuffer.append(string4);
        }
        if (!Util.isEmpty(string5)) {
            this.addSeparator(stringBuffer);
            stringBuffer.append(string5);
        }
        return stringBuffer.toString();
    }

    private String formatAddressCAN(NavLocation navLocation) {
        StringBuffer stringBuffer = new StringBuffer();
        String string = LocationFormatter.formatStreetTextfield(navLocation);
        String string2 = LocationFormatter.formatHousenumber(navLocation);
        String string3 = LocationFormatter.formatCity(navLocation);
        String string4 = LocationFormatter.formatZIPCode(navLocation);
        if (!Util.isEmpty(string)) {
            if (!Util.isEmpty(string2)) {
                stringBuffer.append(string2);
                stringBuffer.append(" ");
            }
            stringBuffer.append(string);
        }
        if (!Util.isEmpty(string3)) {
            this.addSeparator(stringBuffer);
            stringBuffer.append(string3);
        }
        this.addSeparator(stringBuffer);
        stringBuffer.append("CAN");
        if (!Util.isEmpty(string4)) {
            this.addSeparator(stringBuffer);
            stringBuffer.append(string4);
        }
        return stringBuffer.toString();
    }

    private String formatAddressMEX(NavLocation navLocation) {
        boolean bl;
        StringBuffer stringBuffer = new StringBuffer();
        String string = LocationFormatter.formatStreetTextfield(navLocation);
        String string2 = LocationFormatter.formatHousenumber(navLocation);
        String string3 = LocationFormatter.formatCity(navLocation);
        String string4 = this.getAbbreviation(navLocation);
        String string5 = LocationFormatter.formatZIPCode(navLocation);
        if (!Util.isEmpty(string)) {
            stringBuffer.append(string);
            if (!Util.isEmpty(string2)) {
                stringBuffer.append(" ");
                stringBuffer.append(string2);
            }
        }
        boolean bl2 = bl = !Util.isEmpty(string5);
        if (bl) {
            this.addSeparator(stringBuffer);
            stringBuffer.append(string5);
        }
        if (!Util.isEmpty(string3)) {
            if (bl) {
                stringBuffer.append(" ");
            } else {
                this.addSeparator(stringBuffer);
            }
            stringBuffer.append(string3);
        }
        if (!Util.isEmpty(string4)) {
            this.addSeparator(stringBuffer);
            stringBuffer.append(string4);
        }
        return stringBuffer.toString();
    }

    private void addSeparator(StringBuffer stringBuffer) {
        if (stringBuffer.length() > 0) {
            stringBuffer.append(", ");
        }
    }

    private String getAbbreviation(NavLocation navLocation) {
        String string = LocationFormatter.formatStateAbbreviation(navLocation);
        String string2 = LocationFormatter.formatCountryAbbreviation(navLocation);
        return !Util.isEmpty(string) ? string : string2;
    }
}

