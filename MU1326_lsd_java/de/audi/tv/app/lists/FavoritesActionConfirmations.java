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

    public void favoriteAdded() {
        this.env.framework.getHmiServiceApp().showPartialPopup(0, 2600046);
    }

    public void favoritesCleared() {
        this.env.framework.getHmiServiceApp().showPartialPopup(0, 2600041);
    }
}

