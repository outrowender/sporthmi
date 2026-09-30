/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.IconCell;
import de.audi.atip.interapp.icon.ExtRenderingInfo;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.navigation.ManeuverElement;

public class IconUtil {
    public static final int IMG_DESTINATION = 69;
    public static final int IMG_STOPOVER_FIRST = 70;
    public static final int IMG_STOPOVER_LAST = 78;

    public static synchronized boolean setStreetIconImage(IconHandler iconHandler, int n, String string, IconCell iconCell) {
        boolean bl = false;
        if (!Util.isEmpty(string)) {
            ExtRenderingInfo extRenderingInfo = iconHandler.resolveStreetIconResourceID(n, string.length());
            if (extRenderingInfo != null && extRenderingInfo.isValid()) {
                bl = true;
                iconCell.initializeIconTextLocator(new HMIResourceLocator(extRenderingInfo.getResourceId()), string, extRenderingInfo.getFontSize(), extRenderingInfo.getFontSize(), extRenderingInfo.getFontColor(), extRenderingInfo.getDeltaX(), extRenderingInfo.getDeltaY());
            } else {
                iconCell.initializeIconSimpleLocator(new HMIResourceLocator(-1));
            }
        }
        return bl;
    }

    public static synchronized void setPOIIconImage(IconHandler iconHandler, int n, int n2, IconCell iconCell) {
        int n3 = iconHandler.resolvePOIIconResourceID(n, n2);
        if (n3 != -1) {
            iconCell.initializeIconSimpleLocator(new HMIResourceLocator(n3));
        } else {
            iconCell.initializeIconSimpleLocator(new HMIResourceLocator(-1));
        }
    }

    public static synchronized void setTMCIconImage(IconHandler iconHandler, int n, int n2, IconCell iconCell) {
        int n3 = iconHandler.resolveTMCIconResourceID(n, n2);
        if (n3 != -1) {
            iconCell.initializeIconSimpleLocator(new HMIResourceLocator(n3));
        } else {
            iconCell.initializeIconSimpleLocator(new HMIResourceLocator(-1));
        }
    }

    public static synchronized int getDestinationIconID(int n) {
        return n;
    }

    public static synchronized int getManeuverIconID(LogChannel logChannel, ManeuverElement maneuverElement, int n, int n2) {
        byte[] byArray = new byte[]{-1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1};
        byte[] byArray2 = new byte[]{0, -1, 1, 1, 1, -1, -1, -1, -1, -1, -1, -1, 1, 1, 1, -1};
        byte[] byArray3 = new byte[]{2, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, 2};
        byte[] byArray4 = new byte[]{-1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1};
        byte[] byArray5 = new byte[]{-1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1};
        byte[] byArray6 = new byte[]{0, 1, 1, 1, 2, 3, 3, 3, 4, 5, 5, 5, 6, 7, 7, 7};
        byte[] byArray7 = new byte[]{0, 1, 1, 1, 2, 3, 3, 3, 4, 5, 5, 5, 6, 7, 7, 7};
        byte[] byArray8 = new byte[]{0, 1, 2, 3, 3, 3, 4, 4, 5, 6, 6, 7, 7, 7, 8, 9};
        byte[] byArray9 = new byte[]{0, 1, 1, 1, 2, 3, 3, 3, -1, 4, 4, 4, 5, 6, 6, 6};
        byte[] byArray10 = new byte[]{-1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1};
        int n3 = maneuverElement.getElement();
        int n4 = maneuverElement.getDirection() >> 4;
        int n5 = -1;
        if (logChannel.isDebug2()) {
            logChannel.log(100000000, "IconUtil#getManeuverIconID(): manoeuvre element/direction = %1/%2", (long)n3, (long)n4);
        }
        switch (n3) {
            case 3: 
            case 4: 
            case 5: {
                n5 = 69 + n2;
                break;
            }
            case 12: {
                if (byArray[n4] < 0) break;
                n5 = 1 + byArray[n4];
                break;
            }
            case 16: {
                if (byArray2[n4] < 0) break;
                n5 = 3 + byArray2[n4];
                break;
            }
            case 15: {
                if (byArray2[n4] < 0) break;
                n5 = 5 + byArray2[n4];
                break;
            }
            case 11: {
                if (byArray3[n4] < 0) break;
                n5 = 7 + byArray3[n4];
                break;
            }
            case 19: 
            case 20: {
                if (byArray4[n4] < 0) break;
                n5 = 10 + byArray4[n4];
                break;
            }
            case 14: {
                if (byArray5[n4] < 0) break;
                n5 = 12 + byArray5[n4];
                break;
            }
            case 2: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: {
                if (byArray6[n4] < 0) break;
                n5 = 14 + byArray6[n4];
                break;
            }
            case 22: {
                if (byArray7[n4] < 0) break;
                n5 = 22 + byArray7[n4];
                break;
            }
            case 21: {
                if (byArray7[n4] < 0) break;
                n5 = 30 + byArray7[n4];
                break;
            }
            case 18: {
                n5 = 38;
                break;
            }
            case 17: {
                n5 = 39;
                break;
            }
            case 24: {
                if (byArray8[n4] < 0) break;
                n5 = 40 + byArray8[n4];
                break;
            }
            case 23: {
                if (byArray8[n4] < 0) break;
                n5 = 50 + byArray8[n4];
                break;
            }
            case 13: {
                if (byArray9[n4] < 0) break;
                n5 = 60 + byArray9[n4];
                break;
            }
            case 25: {
                if (byArray10[n4] < 0) break;
                n5 = 67 + byArray10[n4];
                break;
            }
        }
        if (n5 != -1) {
            n5 += n;
        }
        if (n5 == -1 && n3 != 0) {
            logChannel.log(10000, "IconUtil#getManeuverIconID(): unknown manoeuvre element/direction = %1/%2", (long)n3, (long)n4);
        }
        return n5;
    }
}

