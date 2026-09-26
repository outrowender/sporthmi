/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.list;

import de.audi.atip.hmi.model.BaseListRow;
import de.audi.tghu.swdl.app.list.ISwdlListItem;
import de.esolutions.fw.util.commons.Buffer;

abstract class AbstractSwdlListItem
implements ISwdlListItem {
    public static final int SWDL_LIST_ITEM_LAYOUT_DEFAULT;
    private int id;
    private String name;
    private boolean selectable;
    private int layout;
    private ISwdlListItem parent;
    private ISwdlListItem[] children = new ISwdlListItem[0];

    public AbstractSwdlListItem(ISwdlListItem iSwdlListItem, int n, String string) {
        this.parent = iSwdlListItem;
        this.setId(n);
        this.setName(string);
        this.setSelectable(true);
        this.layout = 0;
    }

    @Override
    public int getId() {
        return this.id;
    }

    private void setId(int n) {
        this.id = n;
    }

    @Override
    public boolean getSelectable() {
        return this.selectable;
    }

    @Override
    public final void setSelectable(boolean bl) {
        this.selectable = bl;
    }

    public int getLayout() {
        return this.layout;
    }

    public final void setLayout(int n) {
        this.layout = n;
    }

    @Override
    public ISwdlListItem getParent() {
        return this.parent;
    }

    @Override
    public ISwdlListItem[] getChildren() {
        return this.children;
    }

    @Override
    public void setChildren(ISwdlListItem[] iSwdlListItemArray) {
        this.children = iSwdlListItemArray != null ? iSwdlListItemArray : new ISwdlListItem[0];
    }

    @Override
    public ISwdlListItem getChild(int n) {
        ISwdlListItem iSwdlListItem = null;
        if (n < this.getChildren().length && n >= 0) {
            iSwdlListItem = this.getChildren()[n];
        }
        return iSwdlListItem;
    }

    public String getName() {
        return this.name;
    }

    private void setName(String string) {
        this.name = string;
    }

    @Override
    public abstract void select(int n) {
    }

    @Override
    public abstract void updateListRow(BaseListRow baseListRow) {
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("[AbstractSwdlListItem]");
        buffer.append("( ");
        buffer.append(this.getId());
        buffer.append(", ");
        buffer.append(this.getName());
        buffer.append(" )");
        return buffer.toString();
    }
}

