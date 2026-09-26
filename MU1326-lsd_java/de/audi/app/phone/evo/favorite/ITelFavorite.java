/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.favorite;

import de.audi.atip.favorite.IFavoriteStorage;

public interface ITelFavorite
extends IFavoriteStorage {
    default public String getTelNumber() {
    }

    default public String getName() {
    }

    default public int getPhoneNumberType() {
    }
}

