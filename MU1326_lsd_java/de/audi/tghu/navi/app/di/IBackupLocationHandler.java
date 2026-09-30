/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di;

import org.dsi.ifc.global.NavLocation;

public interface IBackupLocationHandler {
    public NavLocation getBackupLocation();

    public NavLocation getPersistedBackupLocation();

    public void invalidateBackupLocation();

    public void persistBackupLocation(NavLocation var1);

    public void setBackupLocation(NavLocation var1);
}

