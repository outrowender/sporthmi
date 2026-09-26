/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.list;

import de.audi.atip.hmi.model.BaseListRow;

public interface ISwdlListItem {
    default public int getId() {
    }

    default public boolean getSelectable() {
    }

    default public void setSelectable(boolean bl) {
    }

    default public ISwdlListItem getChild(int n) {
    }

    default public ISwdlListItem[] getChildren() {
    }

    default public ISwdlListItem getParent() {
    }

    default public void setChildren(ISwdlListItem[] iSwdlListItemArray) {
    }

    default public void select(int n) {
    }

    default public void updateListRow(BaseListRow baseListRow) {
    }
}

