/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.ncfs;

import de.esolutions.fw.comm.asi.navigation.ncfs.sBoundingBox;
import de.esolutions.fw.comm.asi.navigation.ncfs.sEdge;
import de.esolutions.fw.comm.asi.navigation.ncfs.sLGIEvent;
import de.esolutions.fw.comm.asi.navigation.ncfs.sRestriction;
import de.esolutions.fw.comm.asi.navigation.ncfs.sTileInfo;
import de.esolutions.fw.comm.core.method.MethodException;

public interface NCFSProviderReply {
    public static final String IPL_COMM_UUID = "7114efbf-e1b7-4c0f-a8ef-4e4718806d54";
    public static final String IPL_COMM_INTERFACE_KEY = "45c3e4f9-004e-561f-92cf-4451d9da24ab";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.0.0";
    public static final String IPL_COMM_MODULE_VERSION = "1.0.0";

    public void updateVZOTileIndexes(int[] var1, sBoundingBox var2, int var3) throws MethodException;

    public void updateVZORestrictions(sTileInfo[] var1, sEdge[] var2, sRestriction[] var3, int var4) throws MethodException;

    public void updateLGITileIndexes(int[] var1, sBoundingBox var2, int var3) throws MethodException;

    public void updateLGIEvents(sTileInfo[] var1, sLGIEvent[] var2, int var3) throws MethodException;
}

