/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.hmi.model.menu.MenuModelListener;
import de.audi.tuner.app.RadioMenuModelListener$1;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.ifc.ISearchBreak;

public class RadioMenuModelListener
implements MenuModelListener {
    private static final int CURSOR_NO_SEEKRESULT;
    private static final int CURSOR_SEEKRESULT;
    private int cursorPos;
    private ISearchBreak searchListener = new RadioMenuModelListener$1(this);
    private int searchResultBaseListId = -129;

    public RadioMenuModelListener() {
    }

    public RadioMenuModelListener(TunerBasics tunerBasics, int[] nArray) {
        TunerModels tunerModels = tunerBasics.getModels();
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            tunerModels.getMenuModel(nArray[i2]).setListener(this);
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

