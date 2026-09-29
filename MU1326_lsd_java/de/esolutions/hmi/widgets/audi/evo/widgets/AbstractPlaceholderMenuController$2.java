/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPlaceholderMenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPlaceholderMenuController$PlaceholderItemEntry;
import java.util.Iterator;

class AbstractPlaceholderMenuController$2
implements Iterator {
    private AbstractPlaceholderMenuController$PlaceholderItemEntry nextItem;
    private final /* synthetic */ AbstractPlaceholderMenuController$PlaceholderItemEntry val$itemEntryStart;
    private final /* synthetic */ boolean val$forward;
    private final /* synthetic */ AbstractPlaceholderMenuController this$0;

    AbstractPlaceholderMenuController$2(AbstractPlaceholderMenuController abstractPlaceholderMenuController, AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry, boolean bl) {
        this.this$0 = abstractPlaceholderMenuController;
        this.val$itemEntryStart = abstractPlaceholderMenuController$PlaceholderItemEntry;
        this.val$forward = bl;
        this.nextItem = this.val$itemEntryStart;
    }

    private AbstractPlaceholderMenuController$PlaceholderItemEntry findNext() {
        if (this.nextItem == null) {
            return null;
        }
        return this.nextItem.getNextIteratedEntry(this.val$forward);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }

    @Override
    public Object next() {
        AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry = this.nextItem;
        this.nextItem = this.findNext();
        return abstractPlaceholderMenuController$PlaceholderItemEntry;
    }

    @Override
    public boolean hasNext() {
        return this.nextItem != null;
    }
}

