/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.KeyEvent;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPlaceholderMenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPlaceholderMenuController$PlaceholderItemEntry;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPlaceholderMenuController$PlaceholderMultiItemEntry;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPlaceholderMenuController$PlaceholderMultiPartItemEntry;

public class AbstractPlaceholderMenuController$PlaceholderSubItemEntry
extends AbstractPlaceholderMenuController$PlaceholderItemEntry {
    protected AbstractPlaceholderMenuController$PlaceholderMultiPartItemEntry mainItemEntry;
    protected final int itemEntrySubIndex;
    private final /* synthetic */ AbstractPlaceholderMenuController this$0;

    protected AbstractPlaceholderMenuController$PlaceholderSubItemEntry(AbstractPlaceholderMenuController abstractPlaceholderMenuController, AbstractPlaceholderMenuController$PlaceholderMultiPartItemEntry abstractPlaceholderMenuController$PlaceholderMultiPartItemEntry, int n) {
        this.this$0 = abstractPlaceholderMenuController;
        super(abstractPlaceholderMenuController, abstractPlaceholderMenuController$PlaceholderMultiPartItemEntry.item, abstractPlaceholderMenuController$PlaceholderMultiPartItemEntry.itemEntryIndex);
        this.itemEntrySubIndex = n;
        this.mainItemEntry = abstractPlaceholderMenuController$PlaceholderMultiPartItemEntry;
    }

    @Override
    public boolean isSubItem() {
        return true;
    }

    @Override
    public AbstractPlaceholderMenuController$PlaceholderItemEntry getNext() {
        int n = this.itemEntrySubIndex + 1;
        int n2 = this.mainItemEntry.getSubItemCount();
        if (n >= n2) {
            return null;
        }
        return this.mainItemEntry.getSubItemEntry(n);
    }

    @Override
    public AbstractPlaceholderMenuController$PlaceholderItemEntry getPrevious() {
        int n = this.itemEntrySubIndex - 1;
        if (n < 0) {
            return null;
        }
        return this.mainItemEntry.getSubItemEntry(n);
    }

    @Override
    public float getSubPosition() {
        return 1.0f;
    }

    @Override
    public boolean isSelected() {
        if (!this.isConnected()) {
            return false;
        }
        return AbstractPlaceholderMenuController$PlaceholderMultiItemEntry.access$000(this.mainItemEntry.multiItemEntry).isSelected(this.mainItemEntry.itemEntryIndex, this.itemEntrySubIndex);
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        AbstractPlaceholderMenuController.access$400(this.this$0).log(-2137614336, "AbstractPlaceholderMenuController#keyPressed sublist item %1, index=%2, subindex=%3", (Object)this.mainItemEntry, (long)this.mainItemEntry.itemEntryIndex, (long)this.itemEntrySubIndex);
        AbstractPlaceholderMenuController$PlaceholderMultiItemEntry.access$000(this.mainItemEntry.multiItemEntry).itemSelected(this.mainItemEntry.itemEntryIndex, this.itemEntrySubIndex);
        AbstractPlaceholderMenuController.access$400(this.this$0).log(-2137614336, "AbstractPlaceholderMenuController#PlaceholderSubItemEntry#keyPressed closing drawer");
        this.this$0.closeSelectionDrawer();
    }

    @Override
    public boolean isVisible() {
        return AbstractPlaceholderMenuController$PlaceholderMultiItemEntry.access$000(this.mainItemEntry.multiItemEntry).isVisible(this.mainItemEntry.itemEntryIndex, this.itemEntrySubIndex);
    }

    @Override
    public boolean isEnabled() {
        return AbstractPlaceholderMenuController$PlaceholderMultiItemEntry.access$000(this.mainItemEntry.multiItemEntry).isEnabled(this.mainItemEntry.itemEntryIndex, this.itemEntrySubIndex);
    }

    @Override
    public Object loadIconData(int n) {
        return AbstractPlaceholderMenuController$PlaceholderMultiItemEntry.access$000(this.mainItemEntry.multiItemEntry).getIconData(this.mainItemEntry.itemEntryIndex, this.itemEntrySubIndex, n);
    }

    @Override
    public String loadLabelText() {
        return AbstractPlaceholderMenuController$PlaceholderMultiItemEntry.access$000(this.mainItemEntry.multiItemEntry).getLabelText(AbstractPlaceholderMenuController$PlaceholderMultiPartItemEntry.access$800(this.mainItemEntry), this.itemEntrySubIndex);
    }

    @Override
    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("SubItemEntry[main=");
        buffer.append(this.mainItemEntry);
        buffer.append(", itemEntrySubIndex=");
        buffer.append(this.itemEntrySubIndex);
        buffer.append(']');
        return buffer.toString();
    }

    @Override
    public int getModelID() {
        return AbstractPlaceholderMenuController$PlaceholderMultiItemEntry.access$000(this.mainItemEntry.multiItemEntry).getSubMenuMultiItem().getWidget().getModelID();
    }
}

