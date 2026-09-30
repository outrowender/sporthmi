/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radio;

import org.dsi.ifc.base.DSIListener;

public interface DSITunerAnnouncementListener
extends DSIListener {
    public void updateFilter(int var1, int var2);

    public void updateAvailability(int var1, int var2);

    public void updateStatus(int var1, int var2);

    public void updateStationName(String var1, int var2, long var3, int var5);
}

