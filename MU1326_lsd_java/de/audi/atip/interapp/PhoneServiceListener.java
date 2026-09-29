/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.phone.ITelServiceSDSListener$TelFavoriteSDSListEntry;
import de.audi.atip.phone.TelServiceCallStackEntry;

public interface PhoneServiceListener {
    default public void pauseSDS() {
    }

    default public void resumeSDS(boolean bl) {
    }

    default public void switchEntertainment(boolean bl) {
    }

    default public void phoneStateChanged() {
    }

    default public void favoritesListSelected(int n, boolean bl) {
    }

    default public void updateFavorites(ITelServiceSDSListener.TelFavoriteSDSListEntry[] telFavoriteSDSListEntryArray) {
    }

    default public void updateCallStacks(TelServiceCallStackEntry[] telServiceCallStackEntryArray) {
    }
}

