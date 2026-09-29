/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPlaceholderMenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPlaceholderMenuController$PlaceholderItemEntry;
import de.esolutions.hmi.widgets.audi.evo.widgets.PlaceholderMenuItem;

public class AbstractPlaceholderMenuController$Slot {
    private AbstractPlaceholderMenuController$PlaceholderItemEntry itemEntry;
    private float position;
    boolean enabled;
    private final /* synthetic */ AbstractPlaceholderMenuController this$0;

    public AbstractPlaceholderMenuController$Slot(AbstractPlaceholderMenuController abstractPlaceholderMenuController) {
        this.this$0 = abstractPlaceholderMenuController;
    }

    void setItemEntry(AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry) {
        this.itemEntry = abstractPlaceholderMenuController$PlaceholderItemEntry;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("Slot [enabled=");
        buffer.append(this.enabled);
        buffer.append(", position=");
        buffer.append(this.position);
        buffer.append(", itemEntry=");
        buffer.append(this.itemEntry);
        buffer.append("]");
        return buffer.toString();
    }

    public float getPosition() {
        if (this.itemEntry == null) {
            return 32959;
        }
        float f2 = this.itemEntry.isSubItem() ? this.this$0.getCurrentSubViewportPosition() : AbstractPlaceholderMenuController.access$900(this.this$0).getCurrent();
        return this.itemEntry.getPosition() - f2;
    }

    public PlaceholderMenuItem getItem() {
        if (this.itemEntry == null) {
            return null;
        }
        return this.itemEntry.getItem();
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public boolean isFocused() {
        if (this.itemEntry == null) {
            return false;
        }
        return this.itemEntry.isFocused();
    }

    public boolean isSelected() {
        if (this.itemEntry == null) {
            return false;
        }
        return this.itemEntry.isHighlighted();
    }

    public float getSubPosition() {
        if (this.itemEntry == null) {
            return 0.0f;
        }
        return this.itemEntry.getSubPosition();
    }

    public AbstractPlaceholderMenuController$PlaceholderItemEntry getItemEntry() {
        return this.itemEntry;
    }
}

