/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.poi;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.map.impl.ContentListItem;
import de.audi.tghu.navi.app.poi.PoiCategoryTree;
import java.util.ArrayList;
import java.util.Iterator;

public class PoiCategoryTreeBuilder {
    private final LogChannel logger;
    private PoiCategoryTree categoryTree;
    private ArrayList freeNodes;

    public PoiCategoryTreeBuilder(LogChannel logChannel) {
        this.logger = logChannel;
        this.categoryTree = new PoiCategoryTree();
        this.freeNodes = new ArrayList();
    }

    public void add(ContentListItem contentListItem) {
        PoiCategoryTree.CategoryTreeNode categoryTreeNode = this.categoryTree.getTreeNode(contentListItem.parentId);
        if (categoryTreeNode != null) {
            PoiCategoryTree.CategoryTreeNode categoryTreeNode2 = new PoiCategoryTree.CategoryTreeNode(contentListItem);
            categoryTreeNode.addChild(categoryTreeNode2);
            Iterator iterator = this.freeNodes.iterator();
            while (iterator.hasNext()) {
                PoiCategoryTree.CategoryTreeNode categoryTreeNode3 = (PoiCategoryTree.CategoryTreeNode)iterator.next();
                if (categoryTreeNode3.getParentUID() != categoryTreeNode2.getUID()) continue;
                categoryTreeNode2.addChild(categoryTreeNode3);
                iterator.remove();
            }
            return;
        }
        Iterator iterator = this.freeNodes.iterator();
        while (iterator.hasNext()) {
            PoiCategoryTree.CategoryTreeNode categoryTreeNode4 = (PoiCategoryTree.CategoryTreeNode)iterator.next();
            categoryTreeNode = this.categoryTree.getTreeNode(contentListItem.parentId, categoryTreeNode4);
            if (categoryTreeNode == null || !categoryTreeNode.getCategory().isParent) continue;
            categoryTreeNode.addChild(new PoiCategoryTree.CategoryTreeNode(contentListItem));
            return;
        }
        this.freeNodes.add(new PoiCategoryTree.CategoryTreeNode(contentListItem));
    }

    public PoiCategoryTree build() {
        PoiCategoryTree.CategoryTreeNode categoryTreeNode = this.categoryTree.getTreeNode(PoiCategoryTree.ROOT_ID);
        if (!this.freeNodes.isEmpty()) {
            this.logger.log(100000, "PoiCategoryTreeBuilder#build %1 where missing their correct parent and added to the root", (long)this.freeNodes.size());
        }
        Iterator iterator = this.freeNodes.iterator();
        while (iterator.hasNext()) {
            PoiCategoryTree.CategoryTreeNode categoryTreeNode2 = (PoiCategoryTree.CategoryTreeNode)iterator.next();
            categoryTreeNode.addChild(categoryTreeNode2);
        }
        return this.categoryTree;
    }
}

