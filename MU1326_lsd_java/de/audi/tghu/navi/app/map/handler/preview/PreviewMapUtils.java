/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler.preview;

import de.audi.atip.interapp.navigation.previewmap.gui.GuiTooltipInformationContainer;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.handler.preview.states.PreviewMapStateAbstract;
import de.audi.tghu.navi.app.map.handler.preview.states.PreviewMapStateDummy;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import de.audi.tghu.navi.app.util.addressformatting.AddressFormatter;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingResponse;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.map.Rect;

public class PreviewMapUtils {
    public static boolean isPreviewMapStateValid(PreviewMapStateAbstract previewMapStateAbstract) {
        return previewMapStateAbstract != null && !(previewMapStateAbstract instanceof PreviewMapStateDummy);
    }

    public static int getMapStyleType(int n, int n2, boolean bl, boolean bl2) {
        int n3 = bl ? PreviewMapUtils.getMapStyleTypeFromArrayPositionForSds(n2) : 28;
        return n3;
    }

    public static int getMapStyleTypeFromArrayPositionForSds(int n) {
        switch (n) {
            case 0: {
                return 117;
            }
            case 1: {
                return 118;
            }
            case 2: {
                return 119;
            }
            case 3: {
                return 120;
            }
            case 4: {
                return 121;
            }
            case 5: {
                return 122;
            }
        }
        return 28;
    }

    public static int getMapStyleTypeFromArrayPositionForTour(int n, int n2) {
        if (n2 <= 1) {
            return 28;
        }
        switch (n) {
            case 0: {
                return 117;
            }
            case 1: {
                return 118;
            }
            case 2: {
                return 119;
            }
            case 3: {
                return 120;
            }
            case 4: {
                return 121;
            }
            case 5: {
                return 122;
            }
        }
        return 28;
    }

    public static int getMapContextCrosshairByClientId(int n) {
        if (n == 0) {
            return 12;
        }
        if (n == 14 || n == 15) {
            return 39;
        }
        return 13;
    }

    public static NavRectangle calculateMapSection(LogChannel logChannel, NavLocationWgs84[] navLocationWgs84Array, NavLocationWgs84 navLocationWgs84, boolean bl) {
        if (navLocationWgs84Array == null) {
            return null;
        }
        logChannel.log(14808325, "PreviewMapUtils#calculateMapSection() - number of locations: %1, referenceLocation: %2, centered: %3", (Object)new Integer(navLocationWgs84Array.length), (Object)navLocationWgs84, (Object)bl);
        NavLocationWgs84[] navLocationWgs84Array2 = navLocationWgs84Array;
        if (navLocationWgs84 != null) {
            navLocationWgs84Array2 = new NavLocationWgs84[navLocationWgs84Array.length + 1];
            System.arraycopy((Object)navLocationWgs84Array, 0, (Object)navLocationWgs84Array2, 0, navLocationWgs84Array.length);
            navLocationWgs84Array2[navLocationWgs84Array.length] = navLocationWgs84;
        } else {
            bl = false;
        }
        Rect rect = PreviewMapUtils.calculateLocationRectangle(logChannel, navLocationWgs84Array2);
        if (rect == null) {
            return null;
        }
        int n = rect.getKordX();
        int n2 = rect.getKordY();
        int n3 = rect.getDiffX();
        int n4 = rect.getDiffY();
        if (bl) {
            if (navLocationWgs84 == null) {
                return null;
            }
            int n5 = 0 * (long)navLocationWgs84.getLatitude() - (long)n2 - (long)n4;
            int n6 = 0 * (long)navLocationWgs84.getLongitude() - (long)n - (long)n3;
            if (n5 >= 0L) {
                n4 = (int)((long)n4 + n5);
            } else {
                n2 = (int)((long)n2 + n5);
            }
            if (n6 >= 0L) {
                n3 = (int)((long)n3 + n6);
            } else {
                n = (int)((long)n + n6);
            }
        }
        logChannel.log(-2137614336, "PreviewMapUtils#calculateMapSection(): smallest location: %1/%2", (long)n, (long)n2);
        logChannel.log(-2137614336, "PreviewMapUtils#calculateMapSection(): largest location: %1/%2", (long)n3, (long)n4);
        NavRectangle navRectangle = new NavRectangle();
        navRectangle.xLeft = n;
        navRectangle.xRight = n3;
        navRectangle.yBottom = n2;
        navRectangle.yUp = n4;
        return navRectangle;
    }

    public static Rect calculateLocationRectangle(LogChannel logChannel, NavLocationWgs84[] navLocationWgs84Array) {
        int n = -129;
        int n2 = -129;
        int n3 = 128;
        int n4 = 128;
        boolean bl = false;
        if (navLocationWgs84Array != null && navLocationWgs84Array.length != 0) {
            int n5 = navLocationWgs84Array.length;
            logChannel.log(-2137614336, "PreviewMapUtils#calculateLocationRectangle(): looking in %1 positions", (long)n5);
            for (int i2 = 0; i2 < n5; ++i2) {
                NavLocationWgs84 navLocationWgs84 = navLocationWgs84Array[i2];
                if (navLocationWgs84 == null) continue;
                bl = true;
                int n6 = navLocationWgs84.getLongitude();
                int n7 = navLocationWgs84.getLatitude();
                if (n6 < n) {
                    n = n6;
                }
                if (n7 < n2) {
                    n2 = n7;
                }
                if (n6 > n3) {
                    n3 = n6;
                }
                if (n7 <= n4) continue;
                n4 = n7;
            }
        } else {
            return null;
        }
        if (!bl) {
            return null;
        }
        logChannel.log(-2137614336, "PreviewMapUtils#calculateLocationRectangle(): smallest location: %1/%2", (long)n, (long)n2);
        logChannel.log(-2137614336, "PreviewMapUtils#calculateLocationRectangle(): largest location: %1/%2", (long)n3, (long)n4);
        return new Rect(n, n2, n3, n4);
    }

    public static void fillToolTipInformationContainerByNavLocation(NavigationEnv navigationEnv, NavLocation navLocation, String string, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        LocationFormattingResponse locationFormattingResponse = AddressFormatter.formatTwoLines(navLocation, navigationEnv, true);
        LocationFormattingResponse locationFormattingResponse2 = AddressFormatter.formatOneLine(navLocation, navigationEnv);
        if (Util.isEmpty(string)) {
            guiTooltipInformationContainer.toolTipTwoLinesLine1st = locationFormattingResponse.getFirstLineAsText();
            guiTooltipInformationContainer.toolTipTwoLinesLine2nd = locationFormattingResponse.getSecondLineAsText();
        } else {
            guiTooltipInformationContainer.toolTipTwoLinesLine1st = string;
            guiTooltipInformationContainer.toolTipTwoLinesLine2nd = locationFormattingResponse2.getFirstLineAsText();
        }
        guiTooltipInformationContainer.toolTipOneLineLine1st = locationFormattingResponse2.getFirstLineAsText();
    }

    public static String toStringNavLocations(NavLocation[] navLocationArray) {
        Buffer buffer = new Buffer();
        if (navLocationArray == null) {
            buffer.append("no navLocations");
        } else {
            for (int i2 = 0; i2 < navLocationArray.length; ++i2) {
                buffer.append("loc[");
                buffer.append(i2);
                buffer.append("]=");
                buffer.append(LocationFormatter.formatLocationShort(navLocationArray[i2]));
                if (i2 == navLocationArray.length - 1) continue;
                buffer.append(" ");
            }
        }
        return buffer.toString();
    }
}

