/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.navigation;

import de.esolutions.fw.comm.asi.hmisync.navigation.CarPosition;
import de.esolutions.fw.comm.asi.hmisync.navigation.DestinationInfo;
import de.esolutions.fw.comm.asi.hmisync.navigation.NextDestinationInfo;
import de.esolutions.fw.comm.core.method.MethodException;

public interface ASIHMISyncNavigationReply {
    public static final String IPL_COMM_UUID = "8d39242f-638c-434c-a3c2-23fe7dad4907";
    public static final String IPL_COMM_INTERFACE_KEY = "85677657-50cb-53c6-b534-c27796d5fb16";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.1.00";
    public static final String IPL_COMM_MODULE_VERSION = "1.0.00";

    public void startGuidanceToDestinationsResult(int var1) throws MethodException;

    public void updateASIVersion(String var1, boolean var2) throws MethodException;

    public void updateRequestIDs(short[] var1, boolean var2) throws MethodException;

    public void updateReplyIDs(short[] var1, boolean var2) throws MethodException;

    public void updateRouteGuidanceActive(boolean var1, boolean var2) throws MethodException;

    public void updateCarPosition(CarPosition var1, boolean var2) throws MethodException;

    public void updateDestinationInfo(DestinationInfo[] var1, boolean var2) throws MethodException;

    public void updateDestinationsForGuidance(DestinationInfo[] var1, boolean var2) throws MethodException;

    public void updateNextDestinationInfo(NextDestinationInfo var1, boolean var2) throws MethodException;

    public void updateNightDesignRequested(boolean var1, boolean var2) throws MethodException;
}

