/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.phone;

import org.dsi.ifc.organizer.AdbEntry;

public interface ITelServiceSpeedDial {
    public boolean isFavorite(AdbEntry var1);

    public boolean setFavorite(AdbEntry var1);

    public void removeFavorite(AdbEntry var1);
}

