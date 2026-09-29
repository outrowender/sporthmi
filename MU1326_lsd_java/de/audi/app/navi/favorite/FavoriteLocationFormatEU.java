/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.favorite;

import de.audi.app.navi.favorite.DefaultFavoriteLocationFormat;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

public class FavoriteLocationFormatEU
extends DefaultFavoriteLocationFormat {
    public FavoriteLocationFormatEU(NavigationEnv navigationEnv) {
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

    public String formatAddress(NavLocation navLocation) {
        StringBuffer stringBuffer = new StringBuffer();
        String string = LocationFormatter.formatStreetTextfield(navLocation);
        String string2 = LocationFormatter.formatHousenumber(navLocation);
        String string3 = LocationFormatter.formatCity(navLocation);
        if (!Util.isEmpty(string)) {
            stringBuffer.append(string);
            if (!Util.isEmpty(string2)) {
                stringBuffer.append(" ");
                stringBuffer.append(string2);
            }
        }
        if (!Util.isEmpty(string3)) {
            if (stringBuffer.length() > 1) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(string3);
        }
        return stringBuffer.toString();
    }
}

