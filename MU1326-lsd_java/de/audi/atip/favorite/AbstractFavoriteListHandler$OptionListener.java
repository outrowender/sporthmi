/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.favorite;

import de.audi.atip.favorite.AbstractFavoriteListHandler;
import de.audi.atip.favorite.AbstractFavoriteListHandler$1;
import de.audi.atip.favorite.FavoriteListRow;
import de.audi.atip.hmi.model.DefaultOptionListener;
import de.audi.atip.hmi.model.update.ModelTrigger;

class AbstractFavoriteListHandler$OptionListener
extends DefaultOptionListener {
    private final /* synthetic */ AbstractFavoriteListHandler this$0;

    private AbstractFavoriteListHandler$OptionListener(AbstractFavoriteListHandler abstractFavoriteListHandler) {
        this.this$0 = abstractFavoriteListHandler;
    }

    @Override
    public void keyTyped(int n, int n2, int n3, int n4, int n5) {
        this.this$0.log.log(14808325, "AbstractFavoriteListHandler#keyPressed modelID = %1, targetModelID = %2, targetRow = %3", (long)n, (long)n2, (long)n3);
        if (n == this.this$0.favoriteMoveOption.getID()) {
            AbstractFavoriteListHandler.access$102(this.this$0, 1);
            AbstractFavoriteListHandler.access$202(this.this$0, (FavoriteListRow)this.this$0.favoriteListModel.getRow(n3));
            AbstractFavoriteListHandler.access$302(this.this$0, this.this$0.favoriteListModel.getIndexForUniqueID(AbstractFavoriteListHandler.access$200(this.this$0).getUniqueID()));
            this.this$0.favoriteListModel.trigger(ModelTrigger.ACTIVATE_MOVE_MODE);
            this.this$0.moveModeActivated();
            this.this$0.favoriteMoveOption.fireEvent(n5);
        }
    }

    /* synthetic */ AbstractFavoriteListHandler$OptionListener(AbstractFavoriteListHandler abstractFavoriteListHandler, AbstractFavoriteListHandler$1 abstractFavoriteListHandler$1) {
        this(abstractFavoriteListHandler);
    }
}

