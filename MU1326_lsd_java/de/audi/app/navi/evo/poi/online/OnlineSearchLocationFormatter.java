/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.poi.online;

import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.TextUtil;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.NavLocation;

public class OnlineSearchLocationFormatter {
    private static final String CENTER_TOKEN;

    public String formatLocation(NavLocation navLocation) {
        if (navLocation == null) {
            return "";
        }
        String string = this.formatTitle(navLocation);
        return this.replaceTownCenter(string);
    }

    private String replaceTownCenter(String string) {
        int n = string.indexOf("%C");
        if (n < 0) {
            return string;
        }
        Buffer buffer = new Buffer();
        buffer.append(string.substring(0, n));
        buffer.append(TextUtil.getCenterName());
        buffer.append(string.substring(n + "%C".length()));
        return buffer.toString();
    }

    private String formatTitle(NavLocation navLocation) {
        if (Util.isHURegionNAR()) {
            return this.formatDefaultTitleNAR(navLocation);
        }
        return this.formatDefaultTitleECE(navLocation);
    }

    private String formatDefaultTitleECE(NavLocation navLocation) {
        String string = LocationFormatter.formatCountryAbbreviation(navLocation);
        String string2 = LocationFormatter.formatZIPCode(navLocation);
        String string3 = LocationFormatter.formatCity(navLocation);
        String string4 = LocationFormatter.formatCityRefinement(navLocation);
        String string5 = LocationFormatter.formatStreet(navLocation);
        String string6 = LocationFormatter.formatStreetRefinement(navLocation);
        String string7 = LocationFormatter.formatHousenumber(navLocation);
        String string8 = LocationFormatter.formatJunction(navLocation);
        String string9 = LocationFormatter.formatTownCenter(navLocation);
        boolean bl = LocationFormatter.hasFullPostalCode(navLocation);
        Buffer buffer = new Buffer();
        if (!Util.isEmpty(string)) {
            buffer.append('(');
            buffer.append(string);
            buffer.append(") ");
        }
        if (!Util.isEmpty(string3)) {
            boolean bl2 = false;
            if (!Util.isEmpty(string5)) {
                buffer.append(string5);
                bl2 = true;
                if (!Util.isEmpty(string7)) {
                    buffer.append(" ");
                    buffer.append(string7);
                } else if (!Util.isEmpty(string8)) {
                    buffer.append(", ");
                    buffer.append(string8);
                }
            } else if (!Util.isEmpty(string9)) {
                buffer.append(string9);
                bl2 = true;
            }
            boolean bl3 = false;
            if (!Util.isEmpty(string2) && Util.isAdditionalFlagSet(navLocation, 96)) {
                buffer.append(", ");
                bl3 = true;
                buffer.append(string2);
                buffer.append(" ");
            }
            if (!Util.isEmpty(string6)) {
                buffer.append(", ");
                bl3 = true;
                buffer.append(string6);
                buffer.append(", ");
            }
            if (bl2 && !bl3) {
                buffer.append(", ");
            }
            buffer.append(string3);
            if (!Util.isEmpty(string4) && Util.isAdditionalFlagSet(navLocation, 144)) {
                buffer.append(", ");
                buffer.append(string4);
            }
        } else if (!Util.isEmpty(string2)) {
            buffer.append(string2);
        } else {
            String string10 = LocationFormatter.formatGeocoordinatesForce(navLocation);
            if (!Util.isEmpty(string10)) {
                buffer.append(string10);
            }
        }
        return buffer.toString();
    }

    private String formatDefaultTitleNAR(NavLocation navLocation) {
        String string = LocationFormatter.formatZIPCode(navLocation);
        String string2 = LocationFormatter.formatCity(navLocation);
        String string3 = LocationFormatter.formatStreet(navLocation);
        String string4 = LocationFormatter.formatHousenumber(navLocation);
        String string5 = LocationFormatter.formatJunction(navLocation);
        String string6 = LocationFormatter.formatTownCenter(navLocation);
        String string7 = LocationFormatter.formatPOIName(navLocation);
        boolean bl = LocationFormatter.hasFullPostalCode(navLocation);
        Buffer buffer = new Buffer();
        if (!Util.isEmpty(string3)) {
            if (!Util.isEmpty(string4)) {
                buffer.append(string4);
                buffer.append(" ");
                buffer.append(string3);
            } else if (!Util.isEmpty(string5)) {
                buffer.append(string3);
                buffer.append(", ");
                buffer.append(string5);
            } else {
                buffer.append(string3);
            }
            if (!Util.isEmpty(string2)) {
                buffer.append(", ");
                buffer.append(string2);
            }
        } else if (!Util.isEmpty(string2)) {
            if (!Util.isEmpty(string6)) {
                buffer.append(string6);
                buffer.append(", ");
                buffer.append(string2);
            } else if (bl) {
                buffer.append(string2);
            } else {
                buffer.append("%C");
                buffer.append(", ");
                buffer.append(string2);
            }
        } else if (!Util.isEmpty(string)) {
            buffer.append(string);
        } else {
            String string8 = LocationFormatter.formatGeocoordinatesForce(navLocation);
            if (!Util.isEmpty(string8)) {
                buffer.append(string8);
            }
        }
        return buffer.toString();
    }
}

