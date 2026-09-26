/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking;

import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.carparkingsystem.DisplayContent;

class AbstractParkingSystemControllerComponent$LogUtil {
    private static final String[] popupDesc = new String[]{"NONE", "OPS", "VPS", "VPSOPS", "OPSAUTOACTIVATION", "SETTINGS", "GENERAL", "OPSFLANKGUARD", "VPSOPSFLANKGUARD", "ARA", "ARAOPS", "ARAOPSFLANKGUARD", "ARAVPS", "ARAVPSOPS", "ARAVPSOPSFLANKGUARD", "OPSFLANKGUARDPLA", "VPSOPSFLANKGUARDPLA", "OPSOFFROAD", "VPSOPSOFFROAD"};
    private static final String[] vpsScreenDesc = new String[]{"NOSCREEN", "FULLSCREEN", "SPLITSCREEN", "LASTSCREEN"};
    private static final String[] vpsViewDesc = new String[]{"NOVIEW", "REARVIEW", "FRONTVIEW", "SIDEVIEW", "BIRDVIEW"};
    private static final String[] vpsModeDesc = new String[]{"NOMODE", "PARKBOX", "PARALLELTOROAD", "OFFROAD", "RIGHTSIDEVIEW", "LEFTSIDEVIEW", "LEFTRIGHTSIDEVIEW", "CROSSING", "TRAILERASSIST", "BIRDVIEW", "ONLYSIDEVIEW", "3DBIRDVIEW", "TRAILERASSIST_ARA", "OFFROAD_KOG", "14 [INVALID]", "LASTMODE"};

    private AbstractParkingSystemControllerComponent$LogUtil() {
    }

    private static String logDisplayContent(DisplayContent displayContent) {
        Buffer buffer = new Buffer();
        buffer.append("popup=").append(AbstractParkingSystemControllerComponent$LogUtil.getDescription(popupDesc, displayContent.popup));
        buffer.append(", screen=").append(AbstractParkingSystemControllerComponent$LogUtil.getDescription(vpsScreenDesc, displayContent.screen));
        buffer.append(", view=").append(AbstractParkingSystemControllerComponent$LogUtil.getDescription(vpsViewDesc, displayContent.view));
        buffer.append(", mode=").append(AbstractParkingSystemControllerComponent$LogUtil.getDescription(vpsModeDesc, displayContent.mode));
        return buffer.toString();
    }

    private static String getDescription(String[] stringArray, int n) {
        Buffer buffer = new Buffer();
        buffer.append(n);
        buffer.append(" (");
        if (n >= 0 && n < stringArray.length) {
            buffer.append(stringArray[n]);
        } else {
            buffer.append("UNKNOWN");
        }
        buffer.append(')');
        return buffer.toString();
    }

    static /* synthetic */ String access$2500(DisplayContent displayContent) {
        return AbstractParkingSystemControllerComponent$LogUtil.logDisplayContent(displayContent);
    }
}

