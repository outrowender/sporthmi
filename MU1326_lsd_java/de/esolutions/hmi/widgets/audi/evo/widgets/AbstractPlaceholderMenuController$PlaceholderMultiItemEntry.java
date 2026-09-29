/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPlaceholderMenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPlaceholderMenuController$PlaceholderItemEntry;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPlaceholderMenuController$PlaceholderMultiPartItemEntry;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPlaceholderMenuController$PlaceholderSubItemEntry;
import de.esolutions.hmi.widgets.audi.evo.widgets.PlaceholderMenuMultiItem;
import java.util.ArrayList;
import java.util.List;

public class AbstractPlaceholderMenuController$PlaceholderMultiItemEntry
extends AbstractPlaceholderMenuController$PlaceholderItemEntry {
    private final PlaceholderMenuMultiItem multiItem;
    private final List multiItemParts;
    private final /* synthetic */ AbstractPlaceholderMenuController this$0;

    protected AbstractPlaceholderMenuController$PlaceholderMultiItemEntry(AbstractPlaceholderMenuController abstractPlaceholderMenuController, PlaceholderMenuMultiItem placeholderMenuMultiItem, int n) {
        this.this$0 = abstractPlaceholderMenuController;
        super(abstractPlaceholderMenuController, placeholderMenuMultiItem, n);
        this.multiItemParts = new ArrayList();
        this.multiItem = placeholderMenuMultiItem;
    }

    public AbstractPlaceholderMenuController$PlaceholderMultiPartItemEntry getFirstPart() {
        return (AbstractPlaceholderMenuController$PlaceholderMultiPartItemEntry)(this.multiItemParts.isEmpty() ? null : this.multiItemParts.get(0));
    }

    public AbstractPlaceholderMenuController$PlaceholderMultiPartItemEntry getLastPart() {
        return (AbstractPlaceholderMenuController$PlaceholderMultiPartItemEntry)(this.multiItemParts.isEmpty() ? null : this.multiItemParts.get(this.getMultiPartCount() - 1));
    }

    @Override
    public boolean isMultiItem() {
        return true;
    }

    public int getMultiPartCount() {
        return this.multiItemParts.size();
    }

    @Override
    protected void initialize() {
        AbstractPlaceholderMenuController$PlaceholderSubItemEntry abstractPlaceholderMenuController$PlaceholderSubItemEntry;
        int n;
        List list;
        AbstractPlaceholderMenuController$PlaceholderMultiPartItemEntry abstractPlaceholderMenuController$PlaceholderMultiPartItemEntry;
        int n2;
        AbstractPlaceholderMenuController.access$400(this.this$0).log(-2137614336, "PlaceholderMultiItemEntry#initialize multiItem=%1", (Object)this.multiItem);
        int n3 = this.multiItem.getMultiItemCount();
        AbstractPlaceholderMenuController.access$400(this.this$0).log(-2137614336, "PlaceholderMultiItemEntry#initialize multiItemCount=%1, multiItemPart count=%2", (long)n3, (long)this.multiItemParts.size());
        while (this.multiItemParts.size() > n3) {
            int n4 = this.multiItemParts.size() - 1;
            AbstractPlaceholderMenuController$PlaceholderMultiPartItemEntry abstractPlaceholderMenuController$PlaceholderMultiPartItemEntry2 = (AbstractPlaceholderMenuController$PlaceholderMultiPartItemEntry)this.multiItemParts.get(n4);
            AbstractPlaceholderMenuController.access$400(this.this$0).log(-2137614336, "PlaceholderMultiItemEntry#initialize disconnecting %1", (Object)abstractPlaceholderMenuController$PlaceholderMultiPartItemEntry2);
            abstractPlaceholderMenuController$PlaceholderMultiPartItemEntry2.setConnected(false);
            this.multiItemParts.remove(n4);
        }
        while (this.multiItemParts.size() < n3) {
            AbstractPlaceholderMenuController$PlaceholderMultiPartItemEntry abstractPlaceholderMenuController$PlaceholderMultiPartItemEntry3 = new AbstractPlaceholderMenuController$PlaceholderMultiPartItemEntry(this.this$0, this, this.multiItemParts.size());
            AbstractPlaceholderMenuController.access$400(this.this$0).log(-2137614336, "PlaceholderMultiItemEntry#initialize creating %1", (Object)abstractPlaceholderMenuController$PlaceholderMultiPartItemEntry3);
            this.multiItemParts.add(abstractPlaceholderMenuController$PlaceholderMultiPartItemEntry3);
        }
        int n5 = this.multiItem.getMainSelection();
        int n6 = this.multiItem.getSubItemCount();
        AbstractPlaceholderMenuController.access$400(this.this$0).log(-2137614336, "PlaceholderMultiItemEntry#initialize main selection: %1, subItemCount=%2", (long)n5, (long)n6);
        for (n2 = 0; n2 < this.multiItemParts.size(); ++n2) {
            abstractPlaceholderMenuController$PlaceholderMultiPartItemEntry = (AbstractPlaceholderMenuController$PlaceholderMultiPartItemEntry)this.multiItemParts.get(n2);
            list = abstractPlaceholderMenuController$PlaceholderMultiPartItemEntry.subItemEntries;
            if (n2 == n5) {
                for (n = 0; n < n6 && n < list.size(); ++n) {
                    abstractPlaceholderMenuController$PlaceholderSubItemEntry = (AbstractPlaceholderMenuController$PlaceholderSubItemEntry)list.get(n);
                    if (abstractPlaceholderMenuController$PlaceholderSubItemEntry.isConnected()) continue;
                    AbstractPlaceholderMenuController.access$400(this.this$0).log(-2137614336, "PlaceholderMultiItemEntry#initialize reconnected subitem %1 to selected main item", (Object)abstractPlaceholderMenuController$PlaceholderSubItemEntry);
                    abstractPlaceholderMenuController$PlaceholderSubItemEntry.setConnected(true);
                }
                while (list.size() < n6) {
                    AbstractPlaceholderMenuController$PlaceholderSubItemEntry abstractPlaceholderMenuController$PlaceholderSubItemEntry2 = new AbstractPlaceholderMenuController$PlaceholderSubItemEntry(this.this$0, abstractPlaceholderMenuController$PlaceholderMultiPartItemEntry, list.size());
                    AbstractPlaceholderMenuController.access$400(this.this$0).log(-2137614336, "PlaceholderMultiItemEntry#initialize added subitem %1 to selected main item", (Object)abstractPlaceholderMenuController$PlaceholderSubItemEntry2);
                    list.add(abstractPlaceholderMenuController$PlaceholderSubItemEntry2);
                }
                if (n6 > 0) {
                    while (list.size() > n6) {
                        AbstractPlaceholderMenuController$PlaceholderSubItemEntry abstractPlaceholderMenuController$PlaceholderSubItemEntry3 = abstractPlaceholderMenuController$PlaceholderMultiPartItemEntry.removeSubItemEntry(list.size() - 1);
                        AbstractPlaceholderMenuController.access$400(this.this$0).log(-2137614336, "PlaceholderMultiItemEntry#initialize Removing subitem %1 from selected main item", (Object)abstractPlaceholderMenuController$PlaceholderSubItemEntry3);
                    }
                    continue;
                }
                for (n = 0; n < list.size(); ++n) {
                    abstractPlaceholderMenuController$PlaceholderSubItemEntry = abstractPlaceholderMenuController$PlaceholderMultiPartItemEntry.getSubItemEntry(n);
                    AbstractPlaceholderMenuController.access$400(this.this$0).log(-2137614336, "PlaceholderMultiItemEntry#initialize disconnecting subitem %1 from selected main item", (long)n);
                    abstractPlaceholderMenuController$PlaceholderSubItemEntry.setConnected(false);
                }
                continue;
            }
            for (n = 0; n < list.size(); ++n) {
                abstractPlaceholderMenuController$PlaceholderSubItemEntry = (AbstractPlaceholderMenuController$PlaceholderSubItemEntry)list.get(n);
                AbstractPlaceholderMenuController.access$400(this.this$0).log(-2137614336, "PlaceholderMultiItemEntry#initialize disconnecting subitem %1 from not selected main item", (Object)abstractPlaceholderMenuController$PlaceholderSubItemEntry);
                abstractPlaceholderMenuController$PlaceholderSubItemEntry.setConnected(false);
            }
        }
        for (n2 = 0; n2 < n3; ++n2) {
            abstractPlaceholderMenuController$PlaceholderMultiPartItemEntry = (AbstractPlaceholderMenuController$PlaceholderMultiPartItemEntry)this.multiItemParts.get(n2);
            if (abstractPlaceholderMenuController$PlaceholderMultiPartItemEntry.isConnected()) {
                abstractPlaceholderMenuController$PlaceholderMultiPartItemEntry.clearCache();
            }
            list = abstractPlaceholderMenuController$PlaceholderMultiPartItemEntry.subItemEntries;
            for (n = 0; n < list.size(); ++n) {
                abstractPlaceholderMenuController$PlaceholderSubItemEntry = (AbstractPlaceholderMenuController$PlaceholderSubItemEntry)list.get(n);
                if (!abstractPlaceholderMenuController$PlaceholderSubItemEntry.isConnected()) continue;
                abstractPlaceholderMenuController$PlaceholderSubItemEntry.clearCache();
            }
        }
    }

    protected AbstractPlaceholderMenuController$PlaceholderMultiPartItemEntry getPart(int n) {
        return (AbstractPlaceholderMenuController$PlaceholderMultiPartItemEntry)this.multiItemParts.get(n);
    }

    @Override
    public AbstractPlaceholderMenuController$PlaceholderItemEntry getSelectedItemEntry() {
        int n = this.multiItem.getMainSelection();
        if (n < 0 || n >= this.multiItemParts.size()) {
            return null;
        }
        return (AbstractPlaceholderMenuController$PlaceholderItemEntry)this.multiItemParts.get(n);
    }

    @Override
    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("MultiItemEntry[item=");
        buffer.append(this.multiItem);
        buffer.append(']');
        return buffer.toString();
    }

    public void updateSelection() {
        AbstractPlaceholderMenuController$PlaceholderSubItemEntry abstractPlaceholderMenuController$PlaceholderSubItemEntry;
        int n;
        AbstractPlaceholderMenuController$PlaceholderMultiPartItemEntry abstractPlaceholderMenuController$PlaceholderMultiPartItemEntry;
        int n2;
        for (n2 = 0; n2 < this.multiItemParts.size(); ++n2) {
            abstractPlaceholderMenuController$PlaceholderMultiPartItemEntry = (AbstractPlaceholderMenuController$PlaceholderMultiPartItemEntry)this.multiItemParts.get(n2);
            List list = abstractPlaceholderMenuController$PlaceholderMultiPartItemEntry.subItemEntries;
            n = 0;
            while (n2 < list.size()) {
                abstractPlaceholderMenuController$PlaceholderSubItemEntry = (AbstractPlaceholderMenuController$PlaceholderSubItemEntry)list.get(n);
                abstractPlaceholderMenuController$PlaceholderSubItemEntry.setConnected(false);
                ++n;
            }
            list.clear();
        }
        n2 = this.multiItem.getMainSelection();
        if (n2 == -1) {
            return;
        }
        abstractPlaceholderMenuController$PlaceholderMultiPartItemEntry = (AbstractPlaceholderMenuController$PlaceholderMultiPartItemEntry)this.multiItemParts.get(n2);
        int n3 = this.multiItem.getSubItemCount();
        AbstractPlaceholderMenuController.access$400(this.this$0).log(-2137614336, "AbstractPlaceholderMenuController#updateSelection multiItemPart=%1, count=%2", (long)n2, (long)n3);
        for (n = 0; n < n3; ++n) {
            abstractPlaceholderMenuController$PlaceholderSubItemEntry = new AbstractPlaceholderMenuController$PlaceholderSubItemEntry(this.this$0, abstractPlaceholderMenuController$PlaceholderMultiPartItemEntry, n);
            abstractPlaceholderMenuController$PlaceholderMultiPartItemEntry.subItemEntries.add(abstractPlaceholderMenuController$PlaceholderSubItemEntry);
        }
    }

    @Override
    public AbstractPlaceholderMenuController$PlaceholderItemEntry getIterationStart(boolean bl) {
        AbstractPlaceholderMenuController$PlaceholderMultiPartItemEntry abstractPlaceholderMenuController$PlaceholderMultiPartItemEntry;
        AbstractPlaceholderMenuController$PlaceholderMultiPartItemEntry abstractPlaceholderMenuController$PlaceholderMultiPartItemEntry2 = abstractPlaceholderMenuController$PlaceholderMultiPartItemEntry = bl ? this.getFirstPart() : this.getLastPart();
        if (abstractPlaceholderMenuController$PlaceholderMultiPartItemEntry == null) {
            return null;
        }
        return abstractPlaceholderMenuController$PlaceholderMultiPartItemEntry.getIterationStart(bl);
    }

    static /* synthetic */ PlaceholderMenuMultiItem access$000(AbstractPlaceholderMenuController$PlaceholderMultiItemEntry abstractPlaceholderMenuController$PlaceholderMultiItemEntry) {
        return abstractPlaceholderMenuController$PlaceholderMultiItemEntry.multiItem;
    }

    static /* synthetic */ List access$700(AbstractPlaceholderMenuController$PlaceholderMultiItemEntry abstractPlaceholderMenuController$PlaceholderMultiItemEntry) {
        return abstractPlaceholderMenuController$PlaceholderMultiItemEntry.multiItemParts;
    }
}

