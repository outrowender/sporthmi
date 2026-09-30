/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.waveplayer;

import org.dsi.ifc.base.DSIListener;

public interface DSIWavePlayerListener
extends DSIListener {
    public void updatePlayTone(int var1, int var2);

    public void updateAudioRequest(int var1, int var2);

    public void setPlayTone(int var1);

    public void audioTriggerResponse(int var1);
}

