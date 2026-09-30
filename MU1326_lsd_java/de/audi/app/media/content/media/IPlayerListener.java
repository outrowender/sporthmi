/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import org.dsi.ifc.media.Capabilities;

public interface IPlayerListener {
    public void playerStartupComplete();

    public void repeatScopeChanged(int var1, boolean var2);

    public void repeatModeChanged(int var1);

    public void playbackStateChanged(int var1);

    public void capabilitiesChanged(Capabilities var1);

    public void commandBlocked();

    public void currentPMLevelChanged(int var1);
}

