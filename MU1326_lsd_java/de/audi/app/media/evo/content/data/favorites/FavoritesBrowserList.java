/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.favorites;

import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.actionproxy.IActionProxyListener;
import de.audi.app.media.evo.content.data.favorites.FavoritesList;
import de.audi.app.media.evo.content.data.favorites.FavoritesListRow;
import de.audi.app.media.evo.content.data.favorites.IFavoriteSelectionListener;
import de.audi.app.media.evo.content.data.favorites.IFavoritesBrowserList;
import de.audi.app.media.evo.content.data.favorites.IFavoritesController;
import de.audi.app.media.evo.content.data.favorites.IMediaFavoriteListListener;
import de.audi.app.media.evo.content.data.favorites.MediaFavorite;
import de.audi.app.media.selection.IFavoritePlayerSelectionListener;
import de.audi.atip.hmi.model.OptionModelListener;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.update.ModelTrigger;
import de.audi.atip.log.LogChannel;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FavoritesBrowserList
extends AbstractMediaTerminalComponent
implements IFavoritesBrowserList,
IMediaFavoriteListListener,
BaseListModelListener,
IFavoritePlayerSelectionListener,
IActionProxyListener,
OptionModelListener {
    private static final String LOGCLASS = "FavoritesBrowserList";
    private static final int MOVE_NOT_ACTIVE = 0;
    private static final int MOVE_ACTIVE = 1;
    private final LogChannel logger;
    private final IFavoritesController favoritesController;
    private volatile IFavoriteSelectionListener favoriteSelectionListener;
    private volatile FavoritesList favoritesList;
    private volatile boolean moveModus;
    private volatile int moveSourceIndex;
    private volatile MediaFavorite selectedFavorite = null;

    public FavoritesBrowserList(IMediaTerminal iMediaTerminal, IFavoritesController iFavoritesController) {
        super(iMediaTerminal);
        this.logger = iMediaTerminal.getLogger().main();
        this.favoritesController = iFavoritesController;
    }

    public void init() {
        this.logger.log(1000000, "[%1.init]", (Object)LOGCLASS);
    }

    public void deinit() {
        this.logger.log(1000000, "[%1.deinit]", (Object)LOGCLASS);
    }

    public void reset() {
        this.getChoiceModel(200629).setValue(0);
    }

    public void activate(IFavoriteSelectionListener iFavoriteSelectionListener) {
        this.logger.log(1000000, "[%1.activate]", (Object)LOGCLASS);
        this.favoriteSelectionListener = iFavoriteSelectionListener;
        this.favoritesController.addFavoriteListListener(this);
        this.getBaseListModel(200598).setListener(this);
        this.getOptionModel(200751).setListener(this, 200598);
        this.getTerminal().addActionProxyListener(35, (IActionProxyListener)this);
    }

    public void deactivate() {
        this.logger.log(1000000, "[%1.deactivate]", (Object)LOGCLASS);
        this.getBaseListModel(200598).setListener(null);
        this.favoritesController.removeFavoriteListListener(this);
        this.getOptionModel(200751).removeListener(200598);
        this.getTerminal().removeActionProxyListener(this);
    }

    private void blockList() {
        this.logger.log(1000000, "[%1.blockList]", (Object)LOGCLASS);
        this.getBaseListModel(200598).setStatus(0);
    }

    private void unblockList() {
        this.logger.log(1000000, "[%1.unblockList]", (Object)LOGCLASS);
        this.getBaseListModel(200598).setStatus(1);
    }

    private boolean isListBlocked() {
        return this.getBaseListModel(200598).getStatus() == 0;
    }

    private void selectEntry(FavoritesListRow favoritesListRow) {
        this.logger.log(1000000, "[%1.selectEntry]", (Object)LOGCLASS);
        if (this.isListBlocked()) {
            this.logger.log(1000000, "[%1.itemSelected] List is blocked, ignore select.", (Object)LOGCLASS);
            return;
        }
        this.blockList();
        this.getChoiceModel(200616).setValue(11);
        this.selectedFavorite = favoritesListRow.getMediaFavorite();
        this.favoriteSelectionListener.playFavoriteSelection(this.selectedFavorite, this);
    }

    public void selectFavoriteEntry(int n) {
        this.logger.log(1000000, "[%1.selectFavoriteEntry] idx='%2'", (Object)LOGCLASS, (long)n);
        this.selectEntry((FavoritesListRow)this.getBaseListModel(200598).getRow(n));
    }

    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        if (this.moveModus) {
            this.logger.log(1000000, "[%1.itemSelected] Move finished", (Object)LOGCLASS);
            this.moveFavorite(n2);
            this.moveModus = false;
        } else {
            this.logger.log(1000000, "[%1.itemSelected] entry selected", (Object)LOGCLASS);
            this.selectEntry((FavoritesListRow)evoListRow);
        }
    }

    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void keyPressed(int n, int n2, int n3, int n4, int n5) {
    }

    public void keyReleased(int n, int n2, int n3, int n4, int n5) {
    }

    public void keyTyped(int n, int n2, int n3, int n4, int n5) {
        if (n == 200751) {
            this.logger.log(1000000, "[%1.keyTyped] Move favorite.", (Object)LOGCLASS);
            this.getChoiceModel(200829).setValue(1);
            this.moveModus = true;
            this.moveSourceIndex = n3;
            this.getBaseListModel(200598).trigger(ModelTrigger.ACTIVATE_MOVE_MODE);
        }
    }

    public void actionProxyCallPerformed(int n, Map map) {
        if (n == 35) {
            this.logger.log(1000000, "[%1.actionProxyCallPerformed]", (Object)LOGCLASS);
            this.reset();
            this.getChoiceModel(200628).setValue(11);
        }
    }

    private void moveFavorite(int n) {
        this.logger.log(1000000, "[%1.moveFavorite]", (Object)LOGCLASS);
        FavoritesList favoritesList = this.favoritesList;
        favoritesList.moveFavorite(this.moveSourceIndex, n);
        this.getChoiceModel(200829).setValue(0);
        favoritesList.addTrigger(ModelTrigger.DEACTIVATE_MOVE_MODE);
        this.favoritesController.listChanged(favoritesList);
    }

    public void listChanged(FavoritesList favoritesList) {
        this.logger.log(1000000, "[%1.listChanged]", (Object)LOGCLASS);
        this.blockList();
        this.favoritesList = favoritesList;
        BaseListModelApp baseListModelApp = this.getBaseListModel(200598);
        BaseListModelApp baseListModelApp2 = baseListModelApp.getCopy();
        List list = favoritesList.getFavoritesList();
        baseListModelApp2.clearAll();
        baseListModelApp2.setLength(list.size());
        EvoListRow[] evoListRowArray = this.fillList(list);
        baseListModelApp2.setRows(-1, 0, evoListRowArray);
        if (favoritesList.isTriggerAvailable()) {
            baseListModelApp2.trigger(favoritesList.getAndRemoveTrigger());
        }
        baseListModelApp.update(baseListModelApp2);
        this.unblockList();
    }

    public void playFavoriteSelectionDone(boolean bl) {
        if (this.selectedFavorite != null) {
            this.selectedFavorite.setPlayable(bl);
            this.favoritesController.updateFavorite(this.selectedFavorite);
            this.selectedFavorite = null;
            if (bl) {
                this.logger.log(1000000, "[%1.playFavoriteSelectionDone]", (Object)LOGCLASS);
                this.getChoiceModel(200629).setValue(1);
            }
        }
        this.unblockList();
    }

    private EvoListRow[] fillList(List list) {
        this.logger.log(1000000, "[%1.fillList]", (Object)LOGCLASS);
        EvoListRow[] evoListRowArray = new FavoritesListRow[list.size()];
        int n = 0;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            MediaFavorite mediaFavorite = (MediaFavorite)iterator.next();
            evoListRowArray[n] = new FavoritesListRow(n, mediaFavorite);
            ++n;
        }
        return evoListRowArray;
    }

    public void customAction(int n, int n2, int n3, int n4, int n5) {
    }
}

