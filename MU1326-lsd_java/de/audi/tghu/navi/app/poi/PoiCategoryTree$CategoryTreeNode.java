/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.poi;

import de.audi.tghu.navi.app.map.impl.ContentListItem;
import de.audi.tghu.navi.app.poi.PoiCategoryTree;
import java.util.ArrayList;

public class PoiCategoryTree$CategoryTreeNode {
    private ContentListItem category;
    private ArrayList children;

    public PoiCategoryTree$CategoryTreeNode(ContentListItem contentListItem) {
        this.category = contentListItem;
        this.children = new ArrayList();
    }

    public int getUID() {
        return this.category == null ? PoiCategoryTree.ROOT_ID : this.category.rowID;
    }

    public int getParentUID() {
        return this.category == null ? PoiCategoryTree.ROOT_ID : this.category.parentId;
    }

    public ContentListItem getCategory() {
        return this.category;
    }

    public void addChild(PoiCategoryTree$CategoryTreeNode poiCategoryTree$CategoryTreeNode) {
        this.children.add(poiCategoryTree$CategoryTreeNode);
    }

    static /* synthetic */ ArrayList access$000(PoiCategoryTree$CategoryTreeNode poiCategoryTree$CategoryTreeNode) {
        return poiCategoryTree$CategoryTreeNode.children;
    }

    static /* synthetic */ ContentListItem access$100(PoiCategoryTree$CategoryTreeNode poiCategoryTree$CategoryTreeNode) {
        return poiCategoryTree$CategoryTreeNode.category;
    }
}

