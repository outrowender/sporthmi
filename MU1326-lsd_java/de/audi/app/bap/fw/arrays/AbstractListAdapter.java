/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.arrays;

import de.audi.app.bap.fw.arrays.ArrayHandler;
import de.audi.app.bap.fw.arrays.IListAdapter;

public abstract class AbstractListAdapter
implements IListAdapter {
    protected final ArrayHandler listHandler;

    public AbstractListAdapter(ArrayHandler arrayHandler) {
        this.listHandler = arrayHandler;
    }
}

