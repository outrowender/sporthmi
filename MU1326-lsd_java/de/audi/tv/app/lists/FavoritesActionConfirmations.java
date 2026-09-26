/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists;

import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.lists.DefaultTVListsListener;

public class FavoritesActionConfirmations
extends DefaultTVListsListener {
    private final TVEnv env;

    public FavoritesActionConfirmations(TVEnv tVEnv) {
        this.env = tVEnv;
    }

    @Override
    public void favoriteAdded() {
        this.env.framework.getHmiServiceApp().showPartialPopup(0, 1856775936);
    }

    @Override
    public void favoritesCleared() {
        this.env.framework.getHmiServiceApp().showPartialPopup(0, 1772889856);
    }
}

