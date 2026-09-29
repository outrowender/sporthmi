/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$AbstractExpandableItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ISpellerItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$SingleCharItem;
import java.util.Iterator;
import java.util.List;

public class SpellerIterator
implements Iterator {
    private boolean includeDisabledItems = false;
    private boolean includeSubItems = false;
    private boolean includeClosedItems = false;
    private List spellerBand;
    private int indexMainBand = 0;
    private int currentIndex = 0;
    private List currentList;
    private SpellerController$ISpellerItem deleteItemPos;
    private SpellerController$ISpellerItem deleteItem;
    private boolean isDeleteFocused = false;

    public SpellerIterator(List list, SpellerController$ISpellerItem spellerController$ISpellerItem, boolean bl, boolean bl2, boolean bl3, SpellerController$ISpellerItem spellerController$ISpellerItem2, SpellerController$ISpellerItem spellerController$ISpellerItem3) {
        this.spellerBand = list;
        this.includeDisabledItems = bl;
        this.includeSubItems = bl2;
        this.includeClosedItems = bl3;
        this.deleteItemPos = spellerController$ISpellerItem3;
        this.deleteItem = spellerController$ISpellerItem2;
        this.currentIndex = -1;
        this.indexMainBand = -1;
        this.currentList = list;
        if (spellerController$ISpellerItem2 != null && spellerController$ISpellerItem2.equals(spellerController$ISpellerItem)) {
            this.isDeleteFocused = true;
            this.searchStartItem(spellerController$ISpellerItem3);
            this.backward();
        } else if (spellerController$ISpellerItem != null) {
            this.searchStartItem(spellerController$ISpellerItem);
        }
    }

    private void searchStartItem(SpellerController$ISpellerItem spellerController$ISpellerItem) {
        int n = 0;
        boolean bl = false;
        Iterator iterator = this.spellerBand.iterator();
        while (iterator.hasNext()) {
            SpellerController$ISpellerItem spellerController$ISpellerItem2 = (SpellerController$ISpellerItem)iterator.next();
            if (spellerController$ISpellerItem2.equals(spellerController$ISpellerItem)) {
                this.indexMainBand = this.currentIndex = n;
                break;
            }
            if (this.includeSubItems && spellerController$ISpellerItem2 instanceof SpellerController$AbstractExpandableItem) {
                int n2 = 0;
                this.indexMainBand = n;
                Iterator iterator2 = ((SpellerController$AbstractExpandableItem)spellerController$ISpellerItem2).getSubBand().iterator();
                while (iterator2.hasNext()) {
                    SpellerController$ISpellerItem spellerController$ISpellerItem3 = (SpellerController$ISpellerItem)iterator2.next();
                    if (spellerController$ISpellerItem3.equals(spellerController$ISpellerItem)) {
                        this.currentIndex = n2;
                        this.currentList = ((SpellerController$AbstractExpandableItem)spellerController$ISpellerItem2).getSubBand();
                        this.indexMainBand = n;
                        bl = true;
                        break;
                    }
                    ++n2;
                }
                if (bl) break;
            }
            ++n;
        }
    }

    @Override
    public boolean hasNext() {
        List list = this.currentList;
        int n = this.currentIndex;
        int n2 = this.indexMainBand;
        boolean bl = false;
        this.forward();
        while (this.checkBounds()) {
            SpellerController$ISpellerItem spellerController$ISpellerItem = (SpellerController$ISpellerItem)this.currentList.get(this.currentIndex);
            if (spellerController$ISpellerItem.equals(this.deleteItemPos) && !this.isDeleteFocused && this.includeDeleteItem()) {
                bl = true;
                break;
            }
            if (bl |= this.isValidCanditate(spellerController$ISpellerItem)) break;
            this.forward();
        }
        this.currentList = list;
        this.currentIndex = n;
        this.indexMainBand = n2;
        return bl;
    }

    private boolean includeDeleteItem() {
        if (this.deleteItem == null) {
            return false;
        }
        boolean bl = false;
        if (!this.includeSubItems && this.deleteItemPos instanceof SpellerController$SingleCharItem && ((SpellerController$SingleCharItem)this.deleteItemPos).hasParent()) {
            bl = true;
        }
        return (this.includeDisabledItems || this.deleteItem.isEnabled()) && !bl;
    }

    private void forward() {
        if (this.checkBounds()) {
            SpellerController$ISpellerItem spellerController$ISpellerItem = (SpellerController$ISpellerItem)this.currentList.get(this.currentIndex);
            if (spellerController$ISpellerItem instanceof SpellerController$AbstractExpandableItem) {
                this.currentList = ((SpellerController$AbstractExpandableItem)spellerController$ISpellerItem).getSubBand();
                this.currentIndex = -1;
            } else if (this.currentIndex + 1 >= this.currentList.size() && this.currentList != this.spellerBand) {
                this.currentList = this.spellerBand;
                this.currentIndex = this.indexMainBand;
            }
        }
        ++this.currentIndex;
        if (this.currentList == this.spellerBand) {
            this.indexMainBand = this.currentIndex;
        }
    }

    private void backward() {
        --this.currentIndex;
        if (this.checkBounds()) {
            SpellerController$ISpellerItem spellerController$ISpellerItem = (SpellerController$ISpellerItem)this.currentList.get(this.currentIndex);
            if (spellerController$ISpellerItem instanceof SpellerController$AbstractExpandableItem && (!((SpellerController$AbstractExpandableItem)spellerController$ISpellerItem).isClosed() || this.includeClosedItems)) {
                this.indexMainBand = this.currentIndex;
                this.currentList = ((SpellerController$AbstractExpandableItem)spellerController$ISpellerItem).getSubBand();
                this.currentIndex = this.currentList.size() - 1;
            }
        } else if (this.currentIndex < 0 && this.currentList != this.spellerBand) {
            this.currentList = this.spellerBand;
            this.currentIndex = this.indexMainBand;
        }
        if (this.currentList == this.spellerBand) {
            this.indexMainBand = this.currentIndex;
        }
    }

    private boolean checkBounds() {
        return this.currentIndex >= 0 && this.currentIndex < this.currentList.size();
    }

    @Override
    public Object next() {
        this.forward();
        while (this.checkBounds()) {
            SpellerController$ISpellerItem spellerController$ISpellerItem = (SpellerController$ISpellerItem)this.currentList.get(this.currentIndex);
            if (spellerController$ISpellerItem == this.deleteItemPos && !this.isDeleteFocused && this.includeDeleteItem()) {
                this.backward();
                this.isDeleteFocused = true;
                return this.deleteItem;
            }
            if (this.isValidCanditate(spellerController$ISpellerItem)) {
                this.isDeleteFocused = false;
                return spellerController$ISpellerItem;
            }
            this.forward();
        }
        return null;
    }

    public boolean hasPrevious() {
        List list = this.currentList;
        int n = this.currentIndex;
        int n2 = this.indexMainBand;
        boolean bl = false;
        int n3 = 0;
        while (this.checkBounds()) {
            SpellerController$ISpellerItem spellerController$ISpellerItem = (SpellerController$ISpellerItem)this.currentList.get(this.currentIndex);
            if (!this.isDeleteFocused || n3 > 0) {
                this.backward();
                if (spellerController$ISpellerItem == this.deleteItemPos && this.includeDeleteItem()) {
                    bl = true;
                    break;
                }
                if (!this.checkBounds()) {
                    bl = false;
                    break;
                }
                spellerController$ISpellerItem = (SpellerController$ISpellerItem)this.currentList.get(this.currentIndex);
            }
            if (bl |= this.isValidCanditate(spellerController$ISpellerItem)) break;
            ++n3;
        }
        this.currentList = list;
        this.currentIndex = n;
        this.indexMainBand = n2;
        return bl;
    }

    public Object previous() {
        int n = 0;
        while (this.checkBounds()) {
            SpellerController$ISpellerItem spellerController$ISpellerItem = (SpellerController$ISpellerItem)this.currentList.get(this.currentIndex);
            if (!this.isDeleteFocused || n > 0) {
                this.backward();
                if (spellerController$ISpellerItem == this.deleteItemPos && this.includeDeleteItem()) {
                    this.isDeleteFocused = true;
                    return this.deleteItem;
                }
                if (!this.checkBounds()) {
                    return null;
                }
                spellerController$ISpellerItem = (SpellerController$ISpellerItem)this.currentList.get(this.currentIndex);
            }
            if (this.isValidCanditate(spellerController$ISpellerItem)) {
                this.isDeleteFocused = false;
                return spellerController$ISpellerItem;
            }
            ++n;
        }
        return null;
    }

    private boolean isValidCanditate(SpellerController$ISpellerItem spellerController$ISpellerItem) {
        if (!this.includeSubItems && spellerController$ISpellerItem instanceof SpellerController$SingleCharItem && ((SpellerController$SingleCharItem)spellerController$ISpellerItem).hasParent()) {
            return false;
        }
        if (!this.includeClosedItems && spellerController$ISpellerItem instanceof SpellerController$SingleCharItem && ((SpellerController$SingleCharItem)spellerController$ISpellerItem).hasParent() && ((SpellerController$SingleCharItem)spellerController$ISpellerItem).getParent().isClosed()) {
            return false;
        }
        return this.includeDisabledItems || spellerController$ISpellerItem.isEnabled();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("removing elements is not supported in the speller");
    }
}

