/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.map;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.map.Rect;

public interface DSIMapViewerGoogleCtrl
extends DSIBase {
    public static final String VERSION = "2.11.62";
    public static final int ATTR_AVAILABLELAYERS = 1;
    public static final int ATTR_VISIBLELAYERS = 2;
    public static final int ATTR_AVAILABLELANGUAGES = 3;
    public static final int ATTR_CURRENTLANGUAGE = 4;
    public static final int ATTR_GOOGLEDATASTATUS = 6;
    public static final int ATTR_COPYRIGHTPOSITION = 7;
    public static final int CONNECTIONSTATE_NONE = 0;
    public static final int CONNECTIONSTATE_CONNECTING = 1;
    public static final int CONNECTIONSTATE_GPRS = 2;
    public static final int CONNECTIONSTATE_UMTS = 3;
    public static final int CONNECTIONSTATE_LAN = 4;
    public static final int CONNECTIONSTATE_FORBIDDENROAMING = 5;
    public static final int CONNECTIONSTATE_ROAMING = 6;
    public static final int CONNECTIONSTATE_WIFI = 7;
    public static final int CONNECTIONSTATE_INVALID_CONNECTIONSTATE = 255;
    public static final int CONNECTIONSTATE_ALLOWCONNECTIONWHENPENDING = 0;
    public static final int CONNECTIONSTATE_FORBIDCONNECTIONWHENPENDING = 255;
    public static final int LAYERTYPE_USER_LAYER = 0;
    public static final int LAYERTYPE_SYSTEM = 1;
    public static final int DATACONNECTIONSTATE_DATA_CONNECTION_NEEDED_NO_DATA = 0;
    public static final int DATACONNECTIONSTATE_DATA_CONNECTION_NEEDED_RENDERER_LOGIN = 1;
    public static final int DATACONNECTIONSTATE_DATA_CONNECTION_NEEDED_RENDERER_NOT_RECOMMENDED = 2;
    public static final int DATACONNECTIONSTATE_DATA_CONNECTION_NEEDED_RENDERER_RECOMMENDED = 3;
    public static final int DATACONNECTIONSTATE_DATA_CONNECTION_NEEDED_DB_CORRUPTED = 4;
    public static final int LABELPOSITION_UNDEFINED = 0;
    public static final int LABELPOSITION_TOPLEFT = 1;
    public static final int LABELPOSITION_TOP = 2;
    public static final int LABELPOSITION_TOPRIGHT = 3;
    public static final int LABELPOSITION_LEFT = 4;
    public static final int LABELPOSITION_CENTER = 5;
    public static final int LABELPOSITION_RIGHT = 6;
    public static final int LABELPOSITION_BOTTOMLEFT = 7;
    public static final int LABELPOSITION_BOTTOM = 8;
    public static final int LABELPOSITION_BOTTOMRIGHT = 9;
    public static final int LABELALIGNMENT_UNDEFINED = 0;
    public static final int LABELALIGNMENT_LEFT = 1;
    public static final int LABELALIGNMENT_CENTER = 2;
    public static final int LABELALIGNMENT_RIGHT = 3;
    public static final int RT_REQUESTCLEARCACHE = 1000;
    public static final int RT_SETLANGUAGE = 1001;
    public static final int RT_SETLAYERVISIBILITY = 1002;
    public static final int RT_SETCONNECTIONINFORMATION = 1003;
    public static final int RT_LOADKML = 1004;
    public static final int RT_SETCOPYRIGHTPOSITION = 1005;

    public void requestClearCache();

    public void setLanguage(String var1);

    public void setLayerVisibility(int[] var1);

    public void setConnectionInformation(int var1);

    public void loadKml(String[] var1);

    public void setCopyrightPosition(Rect var1, int var2, int var3);
}

