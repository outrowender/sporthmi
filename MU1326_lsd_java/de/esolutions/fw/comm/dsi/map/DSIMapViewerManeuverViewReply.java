/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIMapViewerManeuverViewReply {
    public static final String IPL_COMM_UUID = "85c8b1c2-1f5f-52ad-afae-e1334b7bd44d";
    public static final String IPL_COMM_INTERFACE_KEY = "1a500646-b59a-5441-9796-84145cd7f8f3";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.62";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.62";

    public void updateManoeuvreViewActive(int var1, int var2) throws MethodException;

    public void updateManoeuvreViewsAvailable(short[] var1, int var2) throws MethodException;

    public void updateBapExitViewId(int var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

