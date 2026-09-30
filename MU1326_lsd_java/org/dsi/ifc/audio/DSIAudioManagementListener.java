/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.audio;

import org.dsi.ifc.base.DSIListener;

public interface DSIAudioManagementListener
extends DSIListener {
    public void errorConnection(int var1, int var2, int var3);

    public void fadedIn(int var1, int var2);

    public void pauseConnection(int var1, int var2);

    public void updateActiveConnection(int var1, int var2, int var3);

    public void updateActiveEntertainmentConnection(int var1, int var2, int var3);

    public void startConnection(int var1, int var2);

    public void stopConnection(int var1, int var2);

    public void updateAMAvailable(int var1, int var2, int var3);

    public void responseVolumelock(int var1, int var2, boolean var3);
}

