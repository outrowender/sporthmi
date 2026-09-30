/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists;

import de.audi.atip.hmi.model.menu.MenuModelListener;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.lists.ISearchBreak;

public class TVMenuModelListener
implements MenuModelListener {
    private static final int CURSOR_NO_SEEKRESULT = 1;
    private static final int CURSOR_SEEKRESULT = 2;
    private int cursorPos;
    private ISearchBreak searchListener = new ISearchBreak(){

        public void cursorInSearchResult(boolean bl) {
        }
    };
    private int searchResultBaseListId = Integer.MAX_VALUE;

    public TVMenuModelListener(TVEnv tVEnv, int[] nArray) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            tVEnv.getMenuModel(nArray[i2]).setListener(this);
        }
    }

    public void register(ISearchBreak iSearchBreak, int n) {
        this.searchListener = iSearchBreak;
        this.searchResultBaseListId = n;
    }

    public void itemFocused(int n, int n2, long l, int n3) {
        int n4 = n == this.searchResultBaseListId ? 2 : 1;
        if (this.cursorPos != n4) {
            this.cursorPos = n4;
            this.searchListener.cursorInSearchResult(n4 == 2);
        }
    }
}

