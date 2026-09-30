/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.media;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.media.AudioRoute;

public interface DSIMediaRouterListener
extends DSIListener {
    public void responseConfiguration(int var1, int var2);

    public void responseClientStatus(int var1, int var2);

    public void updateStreamingStatus(int var1, int var2, int var3);

    public void updateActiveAudioRoutes(AudioRoute[] var1, int var2);
}

