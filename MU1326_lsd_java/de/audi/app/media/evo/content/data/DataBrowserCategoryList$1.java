/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.evo.content.data.DataBrowserCategoryList;
import de.audi.app.media.evo.content.data.favorites.FavoritesList;

class DataBrowserCategoryList$1
extends AbstractDispatcherRunnable {
    private final /* synthetic */ FavoritesList val$pFavoriteList;
    private final /* synthetic */ DataBrowserCategoryList this$0;

    DataBrowserCategoryList$1(DataBrowserCategoryList dataBrowserCategoryList, String string, FavoritesList favoritesList) {
        this.this$0 = dataBrowserCategoryList;
        this.val$pFavoriteList = favoritesList;
        super(string);
    }

    @Override
    public void run() {
        DataBrowserCategoryList.access$000(this.this$0).hmi().log(1078071040, "[%1.listChanged] listsize='%2'", (Object)"DataBrowserCategoryList", (long)this.val$pFavoriteList.getListSize());
        boolean bl = DataBrowserCategoryList.access$100(this.this$0);
        DataBrowserCategoryList.access$102(this.this$0, this.val$pFavoriteList.getListSize() > 0);
        if (bl && this.val$pFavoriteList.getListSize() == 0) {
            DataBrowserCategoryList.access$200(this.this$0, 11);
        }
        if (!bl && this.val$pFavoriteList.getListSize() > 0) {
            DataBrowserCategoryList.access$300(this.this$0, 11, 4);
        }
    }
}

