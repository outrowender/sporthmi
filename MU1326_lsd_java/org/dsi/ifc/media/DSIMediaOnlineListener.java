/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.media;

import org.dsi.ifc.base.DSIListener;

public interface DSIMediaOnlineListener
extends DSIListener {
    public void updateBufferState(int var1, int var2);

    public void updateBufferFillInfo(int var1, int var2, int var3);

    public void updateAudioSettings(int var1, int var2, int var3);
}

