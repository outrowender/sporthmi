/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.phone.ITelServiceSDSListener;
import de.audi.atip.phone.TelServiceCallStackEntry;

public interface PhoneServiceListener {
    public void pauseSDS();

    public void resumeSDS(boolean var1);

    public void switchEntertainment(boolean var1);

    public void phoneStateChanged();

    public void favoritesListSelected(int var1, boolean var2);

    public void updateFavorites(ITelServiceSDSListener.TelFavoriteSDSListEntry[] var1);

    public void updateCallStacks(TelServiceCallStackEntry[] var1);
}

