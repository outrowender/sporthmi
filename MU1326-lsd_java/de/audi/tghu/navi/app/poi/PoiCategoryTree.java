/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.poi;

import de.audi.tghu.navi.app.map.impl.ContentListItem;
import de.audi.tghu.navi.app.map.impl.ItemList;
import de.audi.tghu.navi.app.poi.PoiCategoryTree$CategoryTreeNode;
import de.audi.tghu.navi.app.poi.PoiCategoryTree$PoiCategoryTreeIterator;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.Formatter;
import java.util.Iterator;

public class PoiCategoryTree {
    public static int ROOT_ID = -1;
    private PoiCategoryTree$CategoryTreeNode root = new PoiCategoryTree$CategoryTreeNode(ContentListItem.createPOIItem(-1, 0, "", true, -1, true));
    private static final String POINTER;
    private static final String BOX_CHECKED;
    private static final String BOX_UNCHECKED;

    public boolean isEmpty() {
        return PoiCategoryTree$CategoryTreeNode.access$000(this.root).isEmpty();
    }

    public ContentListItem getCategory(int n) {
        PoiCategoryTree$CategoryTreeNode poiCategoryTree$CategoryTreeNode = this.getTreeNode(n);
        return poiCategoryTree$CategoryTreeNode == null ? null : poiCategoryTree$CategoryTreeNode.getCategory();
    }

    public ItemList getSubCategoriesOf(int n) {
        PoiCategoryTree$CategoryTreeNode poiCategoryTree$CategoryTreeNode = this.getTreeNode(n);
        ItemList itemList = new ItemList();
        if (poiCategoryTree$CategoryTreeNode == null) {
            return itemList;
        }
        Iterator iterator = PoiCategoryTree$CategoryTreeNode.access$000(poiCategoryTree$CategoryTreeNode).iterator();
        while (iterator.hasNext()) {
            PoiCategoryTree$CategoryTreeNode poiCategoryTree$CategoryTreeNode2 = (PoiCategoryTree$CategoryTreeNode)iterator.next();
            itemList.add(poiCategoryTree$CategoryTreeNode2.getCategory());
        }
        return itemList;
    }

    public ItemList getLeafs() {
        ItemList itemList = new ItemList();
        this.getLeafs(itemList, this.root);
        return itemList;
    }

    private void getLeafs(ItemList itemList, PoiCategoryTree$CategoryTreeNode poiCategoryTree$CategoryTreeNode) {
        if (PoiCategoryTree$CategoryTreeNode.access$100(poiCategoryTree$CategoryTreeNode) != null && (!PoiCategoryTree$CategoryTreeNode.access$100((PoiCategoryTree$CategoryTreeNode)poiCategoryTree$CategoryTreeNode).isParent || PoiCategoryTree$CategoryTreeNode.access$000(poiCategoryTree$CategoryTreeNode).isEmpty())) {
            itemList.add(PoiCategoryTree$CategoryTreeNode.access$100(poiCategoryTree$CategoryTreeNode));
        }
        Iterator iterator = PoiCategoryTree$CategoryTreeNode.access$000(poiCategoryTree$CategoryTreeNode).iterator();
        while (iterator.hasNext()) {
            PoiCategoryTree$CategoryTreeNode poiCategoryTree$CategoryTreeNode2 = (PoiCategoryTree$CategoryTreeNode)iterator.next();
            this.getLeafs(itemList, poiCategoryTree$CategoryTreeNode2);
        }
    }

    public Iterator iterator() {
        return new PoiCategoryTree$PoiCategoryTreeIterator(this, this.root);
    }

    protected PoiCategoryTree$CategoryTreeNode getTreeNode(int n) {
        return n == 0 ? this.root : this.getTreeNode(n, this.root);
    }

    protected PoiCategoryTree$CategoryTreeNode getTreeNode(int n, PoiCategoryTree$CategoryTreeNode poiCategoryTree$CategoryTreeNode) {
        if (poiCategoryTree$CategoryTreeNode.getUID() == n) {
            return poiCategoryTree$CategoryTreeNode;
        }
        Iterator iterator = PoiCategoryTree$CategoryTreeNode.access$000(poiCategoryTree$CategoryTreeNode).iterator();
        while (iterator.hasNext()) {
            PoiCategoryTree$CategoryTreeNode poiCategoryTree$CategoryTreeNode2 = (PoiCategoryTree$CategoryTreeNode)iterator.next();
            PoiCategoryTree$CategoryTreeNode poiCategoryTree$CategoryTreeNode3 = this.getTreeNode(n, poiCategoryTree$CategoryTreeNode2);
            if (poiCategoryTree$CategoryTreeNode3 == null) continue;
            return poiCategoryTree$CategoryTreeNode3;
        }
        return null;
    }

    public void setItemChecked(int n, boolean bl) {
        PoiCategoryTree$CategoryTreeNode poiCategoryTree$CategoryTreeNode = this.getTreeNode(n);
        if (PoiCategoryTree$CategoryTreeNode.access$100(poiCategoryTree$CategoryTreeNode) != null) {
            PoiCategoryTree$CategoryTreeNode.access$100((PoiCategoryTree$CategoryTreeNode)poiCategoryTree$CategoryTreeNode).checked = bl;
        }
    }

    public String toString() {
        Buffer buffer = new Buffer(super.getClass().getName()).append(':').append(Formatter.LINE_SEPARATOR);
        this.buildString(buffer, "", this.root);
        return buffer.toString();
    }

    private void buildString(Buffer buffer, String string, PoiCategoryTree$CategoryTreeNode poiCategoryTree$CategoryTreeNode) {
        if (poiCategoryTree$CategoryTreeNode == null) {
            return;
        }
        if (PoiCategoryTree$CategoryTreeNode.access$000(poiCategoryTree$CategoryTreeNode).isEmpty()) {
            if (PoiCategoryTree$CategoryTreeNode.access$100((PoiCategoryTree$CategoryTreeNode)poiCategoryTree$CategoryTreeNode).rowID == ROOT_ID) {
                buffer.append("EMPTY!");
                return;
            }
            buffer.append(PoiCategoryTree$CategoryTreeNode.access$100((PoiCategoryTree$CategoryTreeNode)poiCategoryTree$CategoryTreeNode).checked ? "\u2611\u202f" : "\u2610\u202f").append(PoiCategoryTree$CategoryTreeNode.access$100((PoiCategoryTree$CategoryTreeNode)poiCategoryTree$CategoryTreeNode).text).append(" <").append(PoiCategoryTree$CategoryTreeNode.access$100((PoiCategoryTree$CategoryTreeNode)poiCategoryTree$CategoryTreeNode).rowID).append(!PoiCategoryTree$CategoryTreeNode.access$100((PoiCategoryTree$CategoryTreeNode)poiCategoryTree$CategoryTreeNode).enabled ? ", n/a>" : ">").append(Formatter.LINE_SEPARATOR);
            return;
        }
        if (PoiCategoryTree$CategoryTreeNode.access$100((PoiCategoryTree$CategoryTreeNode)poiCategoryTree$CategoryTreeNode).rowID == ROOT_ID) {
            buffer.append(this.areAllItemsChecked() ? "\u2611\u202f" : "\u2610\u202f").append("All").append(Formatter.LINE_SEPARATOR);
        } else {
            buffer.append("\u25ba ").append(PoiCategoryTree$CategoryTreeNode.access$100((PoiCategoryTree$CategoryTreeNode)poiCategoryTree$CategoryTreeNode).text).append(" <").append(PoiCategoryTree$CategoryTreeNode.access$100((PoiCategoryTree$CategoryTreeNode)poiCategoryTree$CategoryTreeNode).rowID).append(!PoiCategoryTree$CategoryTreeNode.access$100((PoiCategoryTree$CategoryTreeNode)poiCategoryTree$CategoryTreeNode).enabled ? ", n/a>" : ">").append(Formatter.LINE_SEPARATOR);
        }
        string = new StringBuffer().append(string).append("  ").toString();
        Iterator iterator = PoiCategoryTree$CategoryTreeNode.access$000(poiCategoryTree$CategoryTreeNode).iterator();
        while (iterator.hasNext()) {
            buffer.append(string);
            PoiCategoryTree$CategoryTreeNode poiCategoryTree$CategoryTreeNode2 = (PoiCategoryTree$CategoryTreeNode)iterator.next();
            this.buildString(buffer, string, poiCategoryTree$CategoryTreeNode2);
        }
    }

    private boolean areAllItemsChecked() {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            ContentListItem contentListItem = (ContentListItem)iterator.next();
            if (contentListItem.checked) continue;
            return false;
        }
        return true;
    }
}

