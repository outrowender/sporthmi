/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.folderbrowsing;

import de.audi.app.messaging.core.folderbrowsing.FolderContentSearch;
import de.audi.app.messaging.core.folderbrowsing.FolderContentSearch$1;
import de.audi.app.messaging.core.guide.DefaultCoreActionProxy;
import de.audi.app.messaging.core.guide.IActionProxySubscriber;
import de.audi.app.messaging.core.search.MessagingSearch;

final class FolderContentSearch$CoreActionProxy
extends DefaultCoreActionProxy
implements IActionProxySubscriber {
    private final /* synthetic */ FolderContentSearch this$0;

    private FolderContentSearch$CoreActionProxy(FolderContentSearch folderContentSearch) {
        this.this$0 = folderContentSearch;
    }

    @Override
    public void searchableViewTransition(int n, int n2, int n3) {
        this.this$0.log.log(-2137614336, "[FolderContentSearch#searchableViewTransition]");
        if (n3 == 0 && n2 == 0) {
            ((MessagingSearch)FolderContentSearch.access$400(this.this$0)).switchConfiguration(this.this$0, FolderContentSearch.access$300());
        }
    }

    /* synthetic */ FolderContentSearch$CoreActionProxy(FolderContentSearch folderContentSearch, FolderContentSearch$1 folderContentSearch$1) {
        this(folderContentSearch);
    }
}

