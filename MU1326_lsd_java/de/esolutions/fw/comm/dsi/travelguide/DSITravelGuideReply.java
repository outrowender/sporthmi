/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.travelguide;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.travelguide.TravelGuideMemoryListElement;

public interface DSITravelGuideReply {
    public static final String IPL_COMM_UUID = "9e6ce532-4a34-5e70-9afe-46d5debc1126";
    public static final String IPL_COMM_INTERFACE_KEY = "5c1eb755-beb0-51c7-b069-79b0037789b9";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.0";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.0";

    public void importTravelGuideResult(int var1, int var2) throws MethodException;

    public void updateTravelGuideMemoryListElement(TravelGuideMemoryListElement var1, int var2, int var3) throws MethodException;

    public void deleteTravelGuideResult(int var1) throws MethodException;

    public void updateTravelGuideMemoryList(TravelGuideMemoryListElement[] var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

