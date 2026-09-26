/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.search;

import de.audi.tghu.navi.app.search.LastDestCacheSearchHandler;
import de.audi.tghu.navi.app.search.LastDestSearch;

class LastDestCacheSearchHandler$1
implements Runnable {
    private final /* synthetic */ LastDestCacheSearchHandler this$0;

    LastDestCacheSearchHandler$1(LastDestCacheSearchHandler lastDestCacheSearchHandler) {
        this.this$0 = lastDestCacheSearchHandler;
    }

    @Override
    public void run() {
        ((LastDestSearch)LastDestCacheSearchHandler.access$000(this.this$0)).notifyObservers();
    }
}

