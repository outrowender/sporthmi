/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists;

import de.audi.atip.hmi.model.menu.MenuModelListener;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.lists.ISearchBreak;
import de.audi.tv.app.lists.TVMenuModelListener$1;

public class TVMenuModelListener
implements MenuModelListener {
    private static final int CURSOR_NO_SEEKRESULT;
    private static final int CURSOR_SEEKRESULT;
    private int cursorPos;
    private ISearchBreak searchListener = new TVMenuModelListener$1(this);
    private int searchResultBaseListId = -129;

    public TVMenuModelListener(TVEnv tVEnv, int[] nArray) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            tVEnv.getMenuModel(nArray[i2]).setListener(this);
        }
    }

    public void register(ISearchBreak iSearchBreak, int n) {
        this.searchListener = iSearchBreak;
        this.searchResultBaseListId = n;
    }

    @Override
    public void itemFocused(int n, int n2, long l, int n3) {
        int n4 = n == this.searchResultBaseListId ? 2 : 1;
        if (this.cursorPos != n4) {
            this.cursorPos = n4;
            this.searchListener.cursorInSearchResult(n4 == 2);
        }
    }
}

