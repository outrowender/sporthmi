/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.poi;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.map.impl.ContentListItem;
import de.audi.tghu.navi.app.poi.PoiCategoryTree;
import de.audi.tghu.navi.app.poi.PoiCategoryTree$CategoryTreeNode;
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
        PoiCategoryTree$CategoryTreeNode poiCategoryTree$CategoryTreeNode = this.categoryTree.getTreeNode(contentListItem.parentId);
        if (poiCategoryTree$CategoryTreeNode != null) {
            PoiCategoryTree$CategoryTreeNode poiCategoryTree$CategoryTreeNode2 = new PoiCategoryTree$CategoryTreeNode(contentListItem);
            poiCategoryTree$CategoryTreeNode.addChild(poiCategoryTree$CategoryTreeNode2);
            Iterator iterator = this.freeNodes.iterator();
            while (iterator.hasNext()) {
                PoiCategoryTree$CategoryTreeNode poiCategoryTree$CategoryTreeNode3 = (PoiCategoryTree$CategoryTreeNode)iterator.next();
                if (poiCategoryTree$CategoryTreeNode3.getParentUID() != poiCategoryTree$CategoryTreeNode2.getUID()) continue;
                poiCategoryTree$CategoryTreeNode2.addChild(poiCategoryTree$CategoryTreeNode3);
                iterator.remove();
            }
            return;
        }
        Iterator iterator = this.freeNodes.iterator();
        while (iterator.hasNext()) {
            PoiCategoryTree$CategoryTreeNode poiCategoryTree$CategoryTreeNode4 = (PoiCategoryTree$CategoryTreeNode)iterator.next();
            poiCategoryTree$CategoryTreeNode = this.categoryTree.getTreeNode(contentListItem.parentId, poiCategoryTree$CategoryTreeNode4);
            if (poiCategoryTree$CategoryTreeNode == null || !poiCategoryTree$CategoryTreeNode.getCategory().isParent) continue;
            poiCategoryTree$CategoryTreeNode.addChild(new PoiCategoryTree$CategoryTreeNode(contentListItem));
            return;
        }
        this.freeNodes.add(new PoiCategoryTree$CategoryTreeNode(contentListItem));
    }

    public PoiCategoryTree build() {
        PoiCategoryTree$CategoryTreeNode poiCategoryTree$CategoryTreeNode = this.categoryTree.getTreeNode(PoiCategoryTree.ROOT_ID);
        if (!this.freeNodes.isEmpty()) {
            this.logger.log(-1601830656, "PoiCategoryTreeBuilder#build %1 where missing their correct parent and added to the root", (long)this.freeNodes.size());
        }
        Iterator iterator = this.freeNodes.iterator();
        while (iterator.hasNext()) {
            PoiCategoryTree$CategoryTreeNode poiCategoryTree$CategoryTreeNode2 = (PoiCategoryTree$CategoryTreeNode)iterator.next();
            poiCategoryTree$CategoryTreeNode.addChild(poiCategoryTree$CategoryTreeNode2);
        }
        return this.categoryTree;
    }
}

