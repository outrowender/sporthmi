/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.PicNavNaviInterfaceImpl;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.ResourceLocator;

public class Title {
    private static final char INFOS_MARKER;
    private static final char INFOS_SEPARATOR;
    private static final int STRING_POS_ICONINDEX;
    private static final int STRING_POS_SUBINDEX;
    private static final int STRING_POS_ADDITIONALFLAGS;
    private static final int STRING_POS_RLOCATOR_VALID;
    private static final int STRING_POS_RLOCATOR_ID;
    private static final int STRING_POS_RLOCATOR_URL;
    private static final int STRING_POS_MAX;
    private static final int INVALID;
    private static final int VALID;
    private String defaultTitle;
    private int iconIndex;
    private int subIndex;
    private int additionalFlags;
    private int locator_valid;
    private int locator_id;
    private String locator_url;
    private final String defaultCityCenterText;
    private final NavigationEnv env;

    public Title(NavigationEnv navigationEnv, String string) {
        this.env = navigationEnv;
        this.defaultCityCenterText = navigationEnv.getTranslatedText(5);
        this.initializeTitle(navigationEnv, string);
    }

    public Title(NavLocation navLocation, boolean bl, NavigationEnv navigationEnv) {
        this.env = navigationEnv;
        this.defaultCityCenterText = navigationEnv.getTranslatedText(5);
        this.initializeTitle(navLocation, bl);
    }

    public String getDefaultTitle() {
        return this.defaultTitle;
    }

    public int getIconIndex() {
        return this.iconIndex;
    }

    public int getSubIndex() {
        return this.subIndex;
    }

    public int getAdditionalFlags() {
        return this.additionalFlags;
    }

    public ResourceLocator getResourceLocator() {
        return this.locator_valid == 1 ? new ResourceLocator(this.locator_id, this.locator_url) : null;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append('@');
        buffer.append(this.iconIndex);
        buffer.append('|');
        buffer.append(this.subIndex);
        buffer.append('|');
        buffer.append(this.additionalFlags);
        buffer.append('|');
        buffer.append(this.locator_valid);
        buffer.append('|');
        buffer.append(this.locator_id);
        buffer.append('|');
        buffer.append(this.locator_url);
        buffer.append('|');
        buffer.append(this.defaultTitle);
        return buffer.toString();
    }

    private final void initializeTitle(NavigationEnv navigationEnv, String string) {
        boolean bl;
        if (string == null || string.length() == 0) {
            navigationEnv.getLogChannel().log(-1601830656, "Title#initializeTitle() - invalid persistentTitle string: '%1' ", (Object)string);
            this.defaultTitle = "";
            return;
        }
        boolean bl2 = bl = string.charAt(0) == '@';
        if (bl) {
            int n = 1;
            int n2 = string.indexOf(124, n);
            for (int i2 = 0; i2 < 6 && n2 >= 0; ++i2) {
                String string2 = string.substring(n, n2);
                int n3 = i2 == 5 ? -1 : Util.parseInteger(string2);
                switch (i2) {
                    case 0: {
                        this.iconIndex = n3;
                        break;
                    }
                    case 1: {
                        this.subIndex = n3;
                        break;
                    }
                    case 2: {
                        this.additionalFlags = n3;
                        break;
                    }
                    case 3: {
                        this.locator_valid = n3;
                        break;
                    }
                    case 4: {
                        this.locator_id = n3;
                        break;
                    }
                    case 5: {
                        this.locator_url = string2;
                        break;
                    }
                    default: {
                        navigationEnv.getLogChannel().log(10000, "Title#initializeTitle() - invalid parser position %1 ", (long)i2);
                    }
                }
                n = n2 + 1;
                n2 = string.indexOf(124, n);
            }
            this.defaultTitle = string.substring(n);
        } else {
            this.defaultTitle = string;
        }
    }

    private final void initializeTitle(NavLocation navLocation, boolean bl) {
        String string;
        Object object;
        this.iconIndex = 0;
        this.subIndex = 0;
        this.additionalFlags = 0;
        this.locator_valid = 0;
        this.locator_id = 0;
        this.locator_url = null;
        if (LocationFormatter.getLocationType(navLocation) == 0x800000) {
            object = Util.getLocationAccessor(navLocation);
            this.iconIndex = object.getIconIndex();
            this.subIndex = object.getSubIconIndex();
            this.additionalFlags = object.getAdditionalFlags();
        }
        if (PicNavNaviInterfaceImpl.isPicNavLocationStatic(navLocation) && (object = PicNavNaviInterfaceImpl.getPictureFromPicNavLocationStatic(navLocation)) != null) {
            this.locator_valid = 1;
            this.locator_id = ((ResourceLocator)object).getId();
            this.locator_url = ((ResourceLocator)object).getUrl();
        }
        object = new Buffer();
        if (bl && !Util.isEmpty(string = LocationFormatter.formatLocationTitle(navLocation))) {
            ((Buffer)object).append(string);
            ((Buffer)object).append(" ");
        }
        ((Buffer)object).append(this.formatDefaultTitle(navLocation));
        this.defaultTitle = ((Buffer)object).toString();
    }

    private String formatDefaultTitle(NavLocation navLocation) {
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
        String string10 = LocationFormatter.formatPOIName(navLocation);
        boolean bl = LocationFormatter.hasFullPostalCode(navLocation);
        Buffer buffer = new Buffer();
        if (!Util.isEmpty(string10)) {
            buffer.append(string10);
            buffer.append(", ");
        }
        if (!Util.isEmpty(string)) {
            buffer.append('(');
            buffer.append(string);
            buffer.append(") ");
        }
        if (!Util.isEmpty(string10)) {
            if (!Util.isEmpty(string3)) {
                buffer.append(string3);
            }
        } else {
            String string11 = LocationFormatter.formatGeocoordinates(navLocation);
            if (!Util.isEmpty(string3)) {
                if (!Util.isEmpty(string2) && Util.isAdditionalFlagSet(navLocation, 96)) {
                    buffer.append(string2);
                    buffer.append(" ");
                }
                if (!Util.isEmpty(string6)) {
                    buffer.append(string6);
                    buffer.append(", ");
                }
                buffer.append(string3);
                if (!Util.isEmpty(string5)) {
                    buffer.append(", ");
                    buffer.append(string5);
                    if (!Util.isEmpty(string7)) {
                        buffer.append(" ");
                        buffer.append(string7);
                    } else if (!Util.isEmpty(string8)) {
                        buffer.append(", ");
                        buffer.append(string8);
                    }
                } else if (!Util.isEmpty(string9)) {
                    buffer.append(", ");
                    buffer.append(string9);
                } else if (!Util.isEmpty(string11) && !Util.isHURegionAsia()) {
                    buffer.append(", ");
                    buffer.append(string11);
                } else if (!bl) {
                    buffer.append(", ");
                    buffer.append(this.defaultCityCenterText);
                    if (this.env.getLogChannel().isDebug2()) {
                        this.env.getLogChannel().log(14808325, "Title#formatDefaultTitleECE() - CityCenterText: %1 ", (Object)this.defaultCityCenterText);
                    }
                }
                if (!Util.isEmpty(string4) && Util.isAdditionalFlagSet(navLocation, 144)) {
                    buffer.append(", ");
                    buffer.append(string4);
                }
            } else if (!Util.isEmpty(string2)) {
                buffer.append(string2);
            } else {
                String string12 = LocationFormatter.formatGeocoordinatesForce(navLocation);
                if (!Util.isEmpty(string12) && !Util.isHURegionAsia()) {
                    buffer.append(string12);
                }
            }
        }
        if (this.env.getLogChannel().isDebug2()) {
            this.env.getLogChannel().log(14808325, "Title#formatDefaultTitleECE() - %1 ", (Object)buffer.toString());
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
        if (!Util.isEmpty(string7)) {
            buffer.append(string7);
            if (!Util.isEmpty(string2)) {
                buffer.append(", ");
                buffer.append(string2);
            }
        } else {
            String string8 = LocationFormatter.formatGeocoordinates(navLocation);
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
                } else if (!Util.isEmpty(string8)) {
                    buffer.append(string2);
                    buffer.append(", ");
                    buffer.append(string8);
                } else if (bl) {
                    buffer.append(string2);
                } else {
                    buffer.append(this.defaultCityCenterText);
                    buffer.append(", ");
                    buffer.append(string2);
                }
            } else if (!Util.isEmpty(string)) {
                buffer.append(string);
            } else if (!Util.isEmpty(string8)) {
                buffer.append(string8);
            }
        }
        return buffer.toString();
    }
}

