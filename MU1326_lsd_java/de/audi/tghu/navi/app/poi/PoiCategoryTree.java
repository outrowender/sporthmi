/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.poi;

import de.audi.tghu.navi.app.map.impl.ContentListItem;
import de.audi.tghu.navi.app.map.impl.ItemList;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.Formatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class PoiCategoryTree {
    public static int ROOT_ID = -1;
    private CategoryTreeNode root = new CategoryTreeNode(ContentListItem.createPOIItem(-1, 0, "", true, -1, true));
    private static final String POINTER = "\u25ba ";
    private static final String BOX_CHECKED = "\u2611\u202f";
    private static final String BOX_UNCHECKED = "\u2610\u202f";

    public boolean isEmpty() {
        return this.root.children.isEmpty();
    }

    public ContentListItem getCategory(int n) {
        CategoryTreeNode categoryTreeNode = this.getTreeNode(n);
        return categoryTreeNode == null ? null : categoryTreeNode.getCategory();
    }

    public ItemList getSubCategoriesOf(int n) {
        CategoryTreeNode categoryTreeNode = this.getTreeNode(n);
        ItemList itemList = new ItemList();
        if (categoryTreeNode == null) {
            return itemList;
        }
        Iterator iterator = categoryTreeNode.children.iterator();
        while (iterator.hasNext()) {
            CategoryTreeNode categoryTreeNode2 = (CategoryTreeNode)iterator.next();
            itemList.add(categoryTreeNode2.getCategory());
        }
        return itemList;
    }

    public ItemList getLeafs() {
        ItemList itemList = new ItemList();
        this.getLeafs(itemList, this.root);
        return itemList;
    }

    private void getLeafs(ItemList itemList, CategoryTreeNode categoryTreeNode) {
        if (categoryTreeNode.category != null && (!((CategoryTreeNode)categoryTreeNode).category.isParent || categoryTreeNode.children.isEmpty())) {
            itemList.add(categoryTreeNode.category);
        }
        Iterator iterator = categoryTreeNode.children.iterator();
        while (iterator.hasNext()) {
            CategoryTreeNode categoryTreeNode2 = (CategoryTreeNode)iterator.next();
            this.getLeafs(itemList, categoryTreeNode2);
        }
    }

    public Iterator iterator() {
        return new PoiCategoryTreeIterator(this.root);
    }

    protected CategoryTreeNode getTreeNode(int n) {
        return n == 0 ? this.root : this.getTreeNode(n, this.root);
    }

    protected CategoryTreeNode getTreeNode(int n, CategoryTreeNode categoryTreeNode) {
        if (categoryTreeNode.getUID() == n) {
            return categoryTreeNode;
        }
        Iterator iterator = categoryTreeNode.children.iterator();
        while (iterator.hasNext()) {
            CategoryTreeNode categoryTreeNode2 = (CategoryTreeNode)iterator.next();
            CategoryTreeNode categoryTreeNode3 = this.getTreeNode(n, categoryTreeNode2);
            if (categoryTreeNode3 == null) continue;
            return categoryTreeNode3;
        }
        return null;
    }

    public void setItemChecked(int n, boolean bl) {
        CategoryTreeNode categoryTreeNode = this.getTreeNode(n);
        if (categoryTreeNode.category != null) {
            ((CategoryTreeNode)categoryTreeNode).category.checked = bl;
        }
    }

    public String toString() {
        Buffer buffer = new Buffer(this.getClass().getName()).append(':').append(Formatter.LINE_SEPARATOR);
        this.buildString(buffer, "", this.root);
        return buffer.toString();
    }

    private void buildString(Buffer buffer, String string, CategoryTreeNode categoryTreeNode) {
        if (categoryTreeNode == null) {
            return;
        }
        if (categoryTreeNode.children.isEmpty()) {
            if (((CategoryTreeNode)categoryTreeNode).category.rowID == ROOT_ID) {
                buffer.append("EMPTY!");
                return;
            }
            buffer.append(((CategoryTreeNode)categoryTreeNode).category.checked ? BOX_CHECKED : BOX_UNCHECKED).append(((CategoryTreeNode)categoryTreeNode).category.text).append(" <").append(((CategoryTreeNode)categoryTreeNode).category.rowID).append(!((CategoryTreeNode)categoryTreeNode).category.enabled ? ", n/a>" : ">").append(Formatter.LINE_SEPARATOR);
            return;
        }
        if (((CategoryTreeNode)categoryTreeNode).category.rowID == ROOT_ID) {
            buffer.append(this.areAllItemsChecked() ? BOX_CHECKED : BOX_UNCHECKED).append("All").append(Formatter.LINE_SEPARATOR);
        } else {
            buffer.append(POINTER).append(((CategoryTreeNode)categoryTreeNode).category.text).append(" <").append(((CategoryTreeNode)categoryTreeNode).category.rowID).append(!((CategoryTreeNode)categoryTreeNode).category.enabled ? ", n/a>" : ">").append(Formatter.LINE_SEPARATOR);
        }
        string = string + "  ";
        Iterator iterator = categoryTreeNode.children.iterator();
        while (iterator.hasNext()) {
            buffer.append(string);
            CategoryTreeNode categoryTreeNode2 = (CategoryTreeNode)iterator.next();
            this.buildString(buffer, string, categoryTreeNode2);
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

    protected static class CategoryTreeNode {
        private ContentListItem category;
        private ArrayList children;

        public CategoryTreeNode(ContentListItem contentListItem) {
            this.category = contentListItem;
            this.children = new ArrayList();
        }

        public int getUID() {
            return this.category == null ? ROOT_ID : this.category.rowID;
        }

        public int getParentUID() {
            return this.category == null ? ROOT_ID : this.category.parentId;
        }

        public ContentListItem getCategory() {
            return this.category;
        }

        public void addChild(CategoryTreeNode categoryTreeNode) {
            this.children.add(categoryTreeNode);
        }
    }

    private class PoiCategoryTreeIterator
    implements Iterator {
        Iterator currentIterator;
        Stack nextIterators;

        public PoiCategoryTreeIterator(CategoryTreeNode categoryTreeNode) {
            this.currentIterator = categoryTreeNode.children.iterator();
            this.nextIterators = new Stack();
        }

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

        public Object next() {
            CategoryTreeNode categoryTreeNode = (CategoryTreeNode)this.currentIterator.next();
            if (!categoryTreeNode.children.isEmpty()) {
                this.nextIterators.push(categoryTreeNode.children.iterator());
            }
            return categoryTreeNode.category;
        }

        public void remove() {
        }
    }
}

