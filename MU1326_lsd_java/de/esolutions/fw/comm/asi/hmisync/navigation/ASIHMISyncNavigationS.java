/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.navigation;

import de.esolutions.fw.comm.asi.hmisync.navigation.ASIHMISyncNavigationReply;
import de.esolutions.fw.comm.asi.hmisync.navigation.DestinationInfo;
import de.esolutions.fw.comm.core.method.MethodException;

public interface ASIHMISyncNavigationS {
    public void startGuidanceToDestinations(DestinationInfo[] var1, ASIHMISyncNavigationReply var2) throws MethodException;

    public void setNotification(ASIHMISyncNavigationReply var1) throws MethodException;

    public void setNotification(long var1, ASIHMISyncNavigationReply var3) throws MethodException;

    public void setNotification(long[] var1, ASIHMISyncNavigationReply var2) throws MethodException;

    public void clearNotification(ASIHMISyncNavigationReply var1) throws MethodException;

    public void clearNotification(long var1, ASIHMISyncNavigationReply var3) throws MethodException;

    public void clearNotification(long[] var1, ASIHMISyncNavigationReply var2) throws MethodException;
}

