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
    private static final String LOGCLASS;
    private static final int MOVE_NOT_ACTIVE;
    private static final int MOVE_ACTIVE;
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
        this.logger.log(1078071040, "[%1.init]", (Object)"FavoritesBrowserList");
    }

    public void deinit() {
        this.logger.log(1078071040, "[%1.deinit]", (Object)"FavoritesBrowserList");
    }

    public void reset() {
        this.getChoiceModel(-1257307392).setValue(0);
    }

    public void activate(IFavoriteSelectionListener iFavoriteSelectionListener) {
        this.logger.log(1078071040, "[%1.activate]", (Object)"FavoritesBrowserList");
        this.favoriteSelectionListener = iFavoriteSelectionListener;
        this.favoritesController.addFavoriteListListener(this);
        this.getBaseListModel(-1777401088).setListener(this);
        this.getOptionModel(789578496).setListener(this, -1777401088);
        this.getTerminal().addActionProxyListener(35, (IActionProxyListener)this);
    }

    public void deactivate() {
        this.logger.log(1078071040, "[%1.deactivate]", (Object)"FavoritesBrowserList");
        this.getBaseListModel(-1777401088).setListener(null);
        this.favoritesController.removeFavoriteListListener(this);
        this.getOptionModel(789578496).removeListener(-1777401088);
        this.getTerminal().removeActionProxyListener(this);
    }

    private void blockList() {
        this.logger.log(1078071040, "[%1.blockList]", (Object)"FavoritesBrowserList");
        this.getBaseListModel(-1777401088).setStatus(0);
    }

    private void unblockList() {
        this.logger.log(1078071040, "[%1.unblockList]", (Object)"FavoritesBrowserList");
        this.getBaseListModel(-1777401088).setStatus(1);
    }

    private boolean isListBlocked() {
        return this.getBaseListModel(-1777401088).getStatus() == 0;
    }

    private void selectEntry(FavoritesListRow favoritesListRow) {
        this.logger.log(1078071040, "[%1.selectEntry]", (Object)"FavoritesBrowserList");
        if (this.isListBlocked()) {
            this.logger.log(1078071040, "[%1.itemSelected] List is blocked, ignore select.", (Object)"FavoritesBrowserList");
            return;
        }
        this.blockList();
        this.getChoiceModel(-1475411200).setValue(11);
        this.selectedFavorite = favoritesListRow.getMediaFavorite();
        this.favoriteSelectionListener.playFavoriteSelection(this.selectedFavorite, this);
    }

    @Override
    public void selectFavoriteEntry(int n) {
        this.logger.log(1078071040, "[%1.selectFavoriteEntry] idx='%2'", (Object)"FavoritesBrowserList", (long)n);
        this.selectEntry((FavoritesListRow)this.getBaseListModel(-1777401088).getRow(n));
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        if (this.moveModus) {
            this.logger.log(1078071040, "[%1.itemSelected] Move finished", (Object)"FavoritesBrowserList");
            this.moveFavorite(n2);
            this.moveModus = false;
        } else {
            this.logger.log(1078071040, "[%1.itemSelected] entry selected", (Object)"FavoritesBrowserList");
            this.selectEntry((FavoritesListRow)evoListRow);
        }
    }

    @Override
    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void keyPressed(int n, int n2, int n3, int n4, int n5) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3, int n4, int n5) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3, int n4, int n5) {
        if (n == 789578496) {
            this.logger.log(1078071040, "[%1.keyTyped] Move favorite.", (Object)"FavoritesBrowserList");
            this.getChoiceModel(2098201344).setValue(1);
            this.moveModus = true;
            this.moveSourceIndex = n3;
            this.getBaseListModel(-1777401088).trigger(ModelTrigger.ACTIVATE_MOVE_MODE);
        }
    }

    @Override
    public void actionProxyCallPerformed(int n, Map map) {
        if (n == 35) {
            this.logger.log(1078071040, "[%1.actionProxyCallPerformed]", (Object)"FavoritesBrowserList");
            this.reset();
            this.getChoiceModel(-1274084608).setValue(11);
        }
    }

    private void moveFavorite(int n) {
        this.logger.log(1078071040, "[%1.moveFavorite]", (Object)"FavoritesBrowserList");
        FavoritesList favoritesList = this.favoritesList;
        favoritesList.moveFavorite(this.moveSourceIndex, n);
        this.getChoiceModel(2098201344).setValue(0);
        favoritesList.addTrigger(ModelTrigger.DEACTIVATE_MOVE_MODE);
        this.favoritesController.listChanged(favoritesList);
    }

    @Override
    public void listChanged(FavoritesList favoritesList) {
        this.logger.log(1078071040, "[%1.listChanged]", (Object)"FavoritesBrowserList");
        this.blockList();
        this.favoritesList = favoritesList;
        BaseListModelApp baseListModelApp = this.getBaseListModel(-1777401088);
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

    @Override
    public void playFavoriteSelectionDone(boolean bl) {
        if (this.selectedFavorite != null) {
            this.selectedFavorite.setPlayable(bl);
            this.favoritesController.updateFavorite(this.selectedFavorite);
            this.selectedFavorite = null;
            if (bl) {
                this.logger.log(1078071040, "[%1.playFavoriteSelectionDone]", (Object)"FavoritesBrowserList");
                this.getChoiceModel(-1257307392).setValue(1);
            }
        }
        this.unblockList();
    }

    private EvoListRow[] fillList(List list) {
        this.logger.log(1078071040, "[%1.fillList]", (Object)"FavoritesBrowserList");
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

    @Override
    public void customAction(int n, int n2, int n3, int n4, int n5) {
    }
}

