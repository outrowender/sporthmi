/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.ddp20;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.ddp20.DisplayStatus;
import org.dsi.ifc.ddp20.VersionInfo;

public interface DSIDDP20Listener
extends DSIListener {
    public void updateVersionInfo(VersionInfo var1, int var2);

    public void updatePowerStatus(int var1, int var2);

    public void updateDisplayStatus(DisplayStatus var1, int var2);

    public void updateBufferStatus(int var1, int var2);
}

