/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.system;

import org.dsi.ifc.base.DSIListener;

public interface DSIHMIWatchDogListener
extends DSIListener {
    public void triggerErrorLogDump();

    public void updateQueryHeartbeat(int var1, int var2);
}

