/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists;

import de.audi.atip.log.LogChannel;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.lists.AbstractStationList;
import de.audi.tv.app.lists.DefaultTVListsListener;
import de.audi.tv.app.lists.FocusHandler$1;
import de.audi.tv.app.lists.IFocusProvider;
import de.audi.tv.app.lists.IListFocusListener;
import de.audi.tv.app.storage.FocusedListStorage;

public class FocusHandler
extends DefaultTVListsListener {
    private final TVEnv env;
    private final LogChannel log;
    private final FocusedListStorage storage;
    private final IListFocusListener listFocusListener;
    private IFocusProvider provider = new FocusHandler$1(this);
    private volatile long favoritesCount = 0L;

    public FocusHandler(TVEnv tVEnv, IListFocusListener iListFocusListener) {
        this.env = tVEnv;
        this.log = tVEnv.lcMain;
        this.listFocusListener = iListFocusListener;
        this.storage = new FocusedListStorage(tVEnv.framework.getStorageMgr(), this.log);
        this.changeFocus(this.storage.getFocusedList());
    }

    public void registerFocusProvider(IFocusProvider iFocusProvider) {
        this.provider = iFocusProvider;
    }

    public void resetToDefault() {
        this.changeFocus(0);
    }

    public AbstractStationList getFocusedList() {
        return this.provider.getFocusedList(this.storage.getFocusedList());
    }

    public int getFocusedListId() {
        return this.storage.getFocusedList();
    }

    public boolean isFavoritesEmpty() {
        return this.favoritesCount == 0L;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void changeFocus(int n) {
        FocusHandler focusHandler = this;
        synchronized (focusHandler) {
            this.log.log(-2137614336, "[FocusHandler.focusChanged] focusedList:%1", (long)n);
            this.env.getChoiceModel(1756112640).setValue(-1);
            this.env.getChoiceModel(1756112640).setValue(n);
            this.storage.saveFocusedList(n);
            this.listFocusListener.onFocusedListChanged(n);
        }
    }

    @Override
    public void updateFavoritesListSize(int n) {
        this.favoritesCount = n;
        if (n == 0 && this.storage.getFocusedList() == 1) {
            this.changeFocus(0);
        }
    }
}

