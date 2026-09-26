/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.KeyEvent;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPlaceholderMenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPlaceholderMenuController$PlaceholderItemEntry;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPlaceholderMenuController$PlaceholderMultiItemEntry;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPlaceholderMenuController$PlaceholderSubItemEntry;

public class AbstractPlaceholderMenuController$PlaceholderMultiPartItemEntry
extends AbstractPlaceholderMenuController$PlaceholderItemEntry {
    protected final AbstractPlaceholderMenuController$PlaceholderMultiItemEntry multiItemEntry;
    private int multiPartIndex;
    private final /* synthetic */ AbstractPlaceholderMenuController this$0;

    protected AbstractPlaceholderMenuController$PlaceholderMultiPartItemEntry(AbstractPlaceholderMenuController abstractPlaceholderMenuController, AbstractPlaceholderMenuController$PlaceholderMultiItemEntry abstractPlaceholderMenuController$PlaceholderMultiItemEntry, int n) {
        this.this$0 = abstractPlaceholderMenuController;
        super(abstractPlaceholderMenuController, AbstractPlaceholderMenuController$PlaceholderMultiItemEntry.access$000(abstractPlaceholderMenuController$PlaceholderMultiItemEntry), abstractPlaceholderMenuController$PlaceholderMultiItemEntry.itemEntryIndex);
        this.multiItemEntry = abstractPlaceholderMenuController$PlaceholderMultiItemEntry;
        this.multiPartIndex = n;
    }

    @Override
    public void initializeSubItems() {
    }

    @Override
    public AbstractPlaceholderMenuController$PlaceholderItemEntry getNext() {
        if (this.multiPartIndex + 1 < AbstractPlaceholderMenuController$PlaceholderMultiItemEntry.access$700(this.multiItemEntry).size()) {
            return (AbstractPlaceholderMenuController$PlaceholderMultiPartItemEntry)AbstractPlaceholderMenuController$PlaceholderMultiItemEntry.access$700(this.multiItemEntry).get(this.multiPartIndex + 1);
        }
        return null;
    }

    @Override
    public AbstractPlaceholderMenuController$PlaceholderItemEntry getPrevious() {
        if (this.multiPartIndex > 0) {
            return (AbstractPlaceholderMenuController$PlaceholderMultiPartItemEntry)AbstractPlaceholderMenuController$PlaceholderMultiItemEntry.access$700(this.multiItemEntry).get(this.multiPartIndex - 1);
        }
        return null;
    }

    @Override
    public boolean isMultiPart() {
        return true;
    }

    @Override
    public boolean isVisible() {
        return AbstractPlaceholderMenuController$PlaceholderMultiItemEntry.access$000(this.multiItemEntry).isVisible(this.multiPartIndex, -1);
    }

    @Override
    public boolean isSubItem() {
        return false;
    }

    @Override
    public boolean isSelected() {
        if (!this.isConnected()) {
            return false;
        }
        return AbstractPlaceholderMenuController$PlaceholderMultiItemEntry.access$000(this.multiItemEntry).isSelected(this.multiPartIndex, -1);
    }

    @Override
    public boolean isEnabled() {
        return AbstractPlaceholderMenuController$PlaceholderMultiItemEntry.access$000(this.multiItemEntry).isEnabled(this.multiPartIndex, -1);
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(33);
        stringBuffer.append("MultiPartItemEntry[listIndex=");
        stringBuffer.append(this.multiPartIndex);
        stringBuffer.append(']');
        return stringBuffer.toString();
    }

    public int getListIndex() {
        return this.multiPartIndex;
    }

    public void setListIndex(int n) {
        this.multiPartIndex = n;
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        AbstractPlaceholderMenuController$PlaceholderMultiItemEntry.access$000(this.multiItemEntry).itemSelected(this.multiPartIndex, -1);
        if (!AbstractPlaceholderMenuController$PlaceholderMultiItemEntry.access$000(this.multiItemEntry).hasSubList()) {
            AbstractPlaceholderMenuController.access$400(this.this$0).log(-2137614336, "AbstractPlaceholderMenuController#PlaceholderMultiPartItemEntrykeyPressed closing drawer");
            this.this$0.closeSelectionDrawer();
        }
    }

    @Override
    protected String loadLabelText() {
        return AbstractPlaceholderMenuController$PlaceholderMultiItemEntry.access$000(this.multiItemEntry).getLabelText(this.multiPartIndex, -1);
    }

    @Override
    public Object loadIconData(int n) {
        return AbstractPlaceholderMenuController$PlaceholderMultiItemEntry.access$000(this.multiItemEntry).getIconData(this.multiPartIndex, -1, n);
    }

    @Override
    public AbstractPlaceholderMenuController$PlaceholderItemEntry getNextIteratedEntry(boolean bl) {
        AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry = super.getNextIteratedEntry(bl);
        if (abstractPlaceholderMenuController$PlaceholderItemEntry != null) {
            return abstractPlaceholderMenuController$PlaceholderItemEntry;
        }
        AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry2 = this.multiItemEntry.getNextIteratedEntry(bl);
        if (abstractPlaceholderMenuController$PlaceholderItemEntry2 != null) {
            return abstractPlaceholderMenuController$PlaceholderItemEntry2.getIterationStart(bl);
        }
        return null;
    }

    @Override
    public int getModelID() {
        return AbstractPlaceholderMenuController$PlaceholderMultiItemEntry.access$000(this.multiItemEntry).getWidget().getModelID();
    }

    public AbstractPlaceholderMenuController$PlaceholderSubItemEntry removeSubItemEntry(int n) {
        return (AbstractPlaceholderMenuController$PlaceholderSubItemEntry)this.subItemEntries.remove(n);
    }

    static /* synthetic */ int access$800(AbstractPlaceholderMenuController$PlaceholderMultiPartItemEntry abstractPlaceholderMenuController$PlaceholderMultiPartItemEntry) {
        return abstractPlaceholderMenuController$PlaceholderMultiPartItemEntry.multiPartIndex;
    }
}

