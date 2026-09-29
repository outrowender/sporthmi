/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.poi;

import de.audi.tghu.navi.app.poi.PoiCategoryTree;
import de.audi.tghu.navi.app.poi.PoiCategoryTree$CategoryTreeNode;
import java.util.Iterator;
import java.util.Stack;

class PoiCategoryTree$PoiCategoryTreeIterator
implements Iterator {
    Iterator currentIterator;
    Stack nextIterators;
    private final /* synthetic */ PoiCategoryTree this$0;

    public PoiCategoryTree$PoiCategoryTreeIterator(PoiCategoryTree poiCategoryTree, PoiCategoryTree$CategoryTreeNode poiCategoryTree$CategoryTreeNode) {
        this.this$0 = poiCategoryTree;
        this.currentIterator = PoiCategoryTree$CategoryTreeNode.access$000(poiCategoryTree$CategoryTreeNode).iterator();
        this.nextIterators = new Stack();
    }

    @Override
    public boolean hasNext() {
        if (this.currentIterator.hasNext()) {
            return true;
        }
        if (this.nextIterators.isEmpty()) {
            return false;
        }
        while (!this.nextIterators.isEmpty()) {
            this.currentIterator = (Iterator)this.nextIterators.pop();
            if (!this.currentIterator.hasNext()) continue;
            return true;
        }
        return false;
    }

    @Override
    public Object next() {
        PoiCategoryTree$CategoryTreeNode poiCategoryTree$CategoryTreeNode = (PoiCategoryTree$CategoryTreeNode)this.currentIterator.next();
        if (!PoiCategoryTree$CategoryTreeNode.access$000(poiCategoryTree$CategoryTreeNode).isEmpty()) {
            this.nextIterators.push(PoiCategoryTree$CategoryTreeNode.access$000(poiCategoryTree$CategoryTreeNode).iterator());
        }
        return PoiCategoryTree$CategoryTreeNode.access$100(poiCategoryTree$CategoryTreeNode);
    }

    @Override
    public void remove() {
    }
}

