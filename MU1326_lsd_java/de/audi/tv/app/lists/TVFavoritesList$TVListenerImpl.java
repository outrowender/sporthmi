/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists;

import de.audi.tv.app.dsi.DefaultTVListener;
import de.audi.tv.app.lists.TVFavoritesList;
import de.audi.tv.app.lists.TVFavoritesList$1;

class TVFavoritesList$TVListenerImpl
extends DefaultTVListener {
    private final /* synthetic */ TVFavoritesList this$0;

    private TVFavoritesList$TVListenerImpl(TVFavoritesList tVFavoritesList) {
        this.this$0 = tVFavoritesList;
    }

    @Override
    public void updateMuteState(int n) {
        this.this$0.setMuteStatus(n);
    }

    /* synthetic */ TVFavoritesList$TVListenerImpl(TVFavoritesList tVFavoritesList, TVFavoritesList$1 tVFavoritesList$1) {
        this(tVFavoritesList);
    }
}

