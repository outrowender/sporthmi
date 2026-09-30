/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController;
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
    private SpellerController.ISpellerItem deleteItemPos;
    private SpellerController.ISpellerItem deleteItem;
    private boolean isDeleteFocused = false;

    public SpellerIterator(List list, SpellerController.ISpellerItem iSpellerItem, boolean bl, boolean bl2, boolean bl3, SpellerController.ISpellerItem iSpellerItem2, SpellerController.ISpellerItem iSpellerItem3) {
        this.spellerBand = list;
        this.includeDisabledItems = bl;
        this.includeSubItems = bl2;
        this.includeClosedItems = bl3;
        this.deleteItemPos = iSpellerItem3;
        this.deleteItem = iSpellerItem2;
        this.currentIndex = -1;
        this.indexMainBand = -1;
        this.currentList = list;
        if (iSpellerItem2 != null && iSpellerItem2.equals(iSpellerItem)) {
            this.isDeleteFocused = true;
            this.searchStartItem(iSpellerItem3);
            this.backward();
        } else if (iSpellerItem != null) {
            this.searchStartItem(iSpellerItem);
        }
    }

    private void searchStartItem(SpellerController.ISpellerItem iSpellerItem) {
        int n = 0;
        boolean bl = false;
        Iterator iterator = this.spellerBand.iterator();
        while (iterator.hasNext()) {
            SpellerController.ISpellerItem iSpellerItem2 = (SpellerController.ISpellerItem)iterator.next();
            if (iSpellerItem2.equals(iSpellerItem)) {
                this.indexMainBand = this.currentIndex = n;
                break;
            }
            if (this.includeSubItems && iSpellerItem2 instanceof SpellerController.AbstractExpandableItem) {
                int n2 = 0;
                this.indexMainBand = n;
                Iterator iterator2 = ((SpellerController.AbstractExpandableItem)iSpellerItem2).getSubBand().iterator();
                while (iterator2.hasNext()) {
                    SpellerController.ISpellerItem iSpellerItem3 = (SpellerController.ISpellerItem)iterator2.next();
                    if (iSpellerItem3.equals(iSpellerItem)) {
                        this.currentIndex = n2;
                        this.currentList = ((SpellerController.AbstractExpandableItem)iSpellerItem2).getSubBand();
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

    public boolean hasNext() {
        List list = this.currentList;
        int n = this.currentIndex;
        int n2 = this.indexMainBand;
        boolean bl = false;
        this.forward();
        while (this.checkBounds()) {
            SpellerController.ISpellerItem iSpellerItem = (SpellerController.ISpellerItem)this.currentList.get(this.currentIndex);
            if (iSpellerItem.equals(this.deleteItemPos) && !this.isDeleteFocused && this.includeDeleteItem()) {
                bl = true;
                break;
            }
            if (bl |= this.isValidCanditate(iSpellerItem)) break;
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
        if (!this.includeSubItems && this.deleteItemPos instanceof SpellerController.SingleCharItem && ((SpellerController.SingleCharItem)this.deleteItemPos).hasParent()) {
            bl = true;
        }
        return (this.includeDisabledItems || this.deleteItem.isEnabled()) && !bl;
    }

    private void forward() {
        if (this.checkBounds()) {
            SpellerController.ISpellerItem iSpellerItem = (SpellerController.ISpellerItem)this.currentList.get(this.currentIndex);
            if (iSpellerItem instanceof SpellerController.AbstractExpandableItem) {
                this.currentList = ((SpellerController.AbstractExpandableItem)iSpellerItem).getSubBand();
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
            SpellerController.ISpellerItem iSpellerItem = (SpellerController.ISpellerItem)this.currentList.get(this.currentIndex);
            if (iSpellerItem instanceof SpellerController.AbstractExpandableItem && (!((SpellerController.AbstractExpandableItem)iSpellerItem).isClosed() || this.includeClosedItems)) {
                this.indexMainBand = this.currentIndex;
                this.currentList = ((SpellerController.AbstractExpandableItem)iSpellerItem).getSubBand();
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

    public Object next() {
        this.forward();
        while (this.checkBounds()) {
            SpellerController.ISpellerItem iSpellerItem = (SpellerController.ISpellerItem)this.currentList.get(this.currentIndex);
            if (iSpellerItem == this.deleteItemPos && !this.isDeleteFocused && this.includeDeleteItem()) {
                this.backward();
                this.isDeleteFocused = true;
                return this.deleteItem;
            }
            if (this.isValidCanditate(iSpellerItem)) {
                this.isDeleteFocused = false;
                return iSpellerItem;
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
            SpellerController.ISpellerItem iSpellerItem = (SpellerController.ISpellerItem)this.currentList.get(this.currentIndex);
            if (!this.isDeleteFocused || n3 > 0) {
                this.backward();
                if (iSpellerItem == this.deleteItemPos && this.includeDeleteItem()) {
                    bl = true;
                    break;
                }
                if (!this.checkBounds()) {
                    bl = false;
                    break;
                }
                iSpellerItem = (SpellerController.ISpellerItem)this.currentList.get(this.currentIndex);
            }
            if (bl |= this.isValidCanditate(iSpellerItem)) break;
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
            SpellerController.ISpellerItem iSpellerItem = (SpellerController.ISpellerItem)this.currentList.get(this.currentIndex);
            if (!this.isDeleteFocused || n > 0) {
                this.backward();
                if (iSpellerItem == this.deleteItemPos && this.includeDeleteItem()) {
                    this.isDeleteFocused = true;
                    return this.deleteItem;
                }
                if (!this.checkBounds()) {
                    return null;
                }
                iSpellerItem = (SpellerController.ISpellerItem)this.currentList.get(this.currentIndex);
            }
            if (this.isValidCanditate(iSpellerItem)) {
                this.isDeleteFocused = false;
                return iSpellerItem;
            }
            ++n;
        }
        return null;
    }

    private boolean isValidCanditate(SpellerController.ISpellerItem iSpellerItem) {
        if (!this.includeSubItems && iSpellerItem instanceof SpellerController.SingleCharItem && ((SpellerController.SingleCharItem)iSpellerItem).hasParent()) {
            return false;
        }
        if (!this.includeClosedItems && iSpellerItem instanceof SpellerController.SingleCharItem && ((SpellerController.SingleCharItem)iSpellerItem).hasParent() && ((SpellerController.SingleCharItem)iSpellerItem).getParent().isClosed()) {
            return false;
        }
        return this.includeDisabledItems || iSpellerItem.isEnabled();
    }

    public void remove() {
        throw new UnsupportedOperationException("removing elements is not supported in the speller");
    }
}

