/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.list;

import de.audi.atip.hmi.model.BaseListRow;

public interface ISwdlListItem {
    public int getId();

    public boolean getSelectable();

    public void setSelectable(boolean var1);

    public ISwdlListItem getChild(int var1);

    public ISwdlListItem[] getChildren();

    public ISwdlListItem getParent();

    public void setChildren(ISwdlListItem[] var1);

    public void select(int var1);

    public void updateListRow(BaseListRow var1);
}

