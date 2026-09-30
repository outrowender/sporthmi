/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.sse;

import org.dsi.ifc.base.DSIListener;

public interface DSISSEListener
extends DSIListener {
    public void responseSetMode(int var1);

    public void updateMode(int var1, int var2);

    public void updateMicGainLevel(int var1, int var2);

    public void responseSetMicGainLevel(int var1);

    public void updateMicMuteState(int var1, int var2);

    public void responseSetMicMuteState(int var1);
}

