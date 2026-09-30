/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.map.LayerProperty;
import org.dsi.ifc.map.Rect;

public interface DSIMapViewerGoogleCtrlReply {
    public static final String IPL_COMM_UUID = "2256d080-8740-5e79-bcc5-6ddcbbeef30e";
    public static final String IPL_COMM_INTERFACE_KEY = "00946153-2f48-5ed2-bed1-4552535374eb";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.62";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.62";

    public void updateAvailableLayers(LayerProperty[] var1, int var2) throws MethodException;

    public void updateVisibleLayers(int[] var1, int var2) throws MethodException;

    public void updateAvailableLanguages(String[] var1, int var2) throws MethodException;

    public void updateCurrentLanguage(String var1, int var2) throws MethodException;

    public void updateGoogleDataStatus(int var1, int var2) throws MethodException;

    public void updateCopyrightPosition(Rect var1, int var2, int var3, int var4) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

