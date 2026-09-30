/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.admin;

public interface JDSIAdmin {
    public boolean startService(String var1, int var2);

    public boolean stopService(String var1, int var2);

    public boolean restartService(String var1, int var2);

    public String[] diagnoseGetSummaryReceivedStreams();
}

