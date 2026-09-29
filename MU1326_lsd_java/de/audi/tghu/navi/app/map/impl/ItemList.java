/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.impl;

import de.audi.tghu.navi.app.map.impl.ContentListItem;
import de.audi.tghu.navi.app.map.impl.ItemList$Filter;
import java.util.ArrayList;
import java.util.List;

public class ItemList {
    public final int ID;
    private List data;

    public ItemList() {
        this(-1);
    }

    public ItemList(int n) {
        this.ID = n;
        this.data = new ArrayList();
    }

    public void add(ContentListItem contentListItem) {
        this.data.add(contentListItem);
    }

    public ContentListItem getItem(int n) {
        return (ContentListItem)this.data.get(n);
    }

    public void clear() {
        this.data.clear();
    }

    public void addAll(ContentListItem[] contentListItemArray) {
        if (contentListItemArray != null) {
            for (int i2 = 0; i2 < contentListItemArray.length; ++i2) {
                this.data.add(contentListItemArray[i2]);
            }
        }
    }

    public void addAll(ItemList itemList) {
        if (itemList != null) {
            for (int i2 = 0; i2 < itemList.size(); ++i2) {
                this.add(itemList.getItem(i2));
            }
        }
    }

    public int size() {
        return this.data.size();
    }

    public ContentListItem getItem(boolean bl, int n) {
        for (int i2 = 0; i2 < this.size(); ++i2) {
            ContentListItem contentListItem = this.getItem(i2);
            if (contentListItem.isStatic != bl || contentListItem.rowID != n) continue;
            return contentListItem;
        }
        return null;
    }

    public ContentListItem[] toArray() {
        ContentListItem[] contentListItemArray = new ContentListItem[this.data.size()];
        for (int i2 = 0; i2 < this.data.size(); ++i2) {
            contentListItemArray[i2] = (ContentListItem)this.data.get(i2);
        }
        return contentListItemArray;
    }

    public ContentListItem[] getItems(ItemList$Filter itemList$Filter) {
        ItemList itemList = new ItemList();
        for (int i2 = 0; i2 < this.size(); ++i2) {
            if (!itemList$Filter.match(this.getItem(i2))) continue;
            itemList.add(this.getItem(i2));
        }
        return itemList.toArray();
    }
}

