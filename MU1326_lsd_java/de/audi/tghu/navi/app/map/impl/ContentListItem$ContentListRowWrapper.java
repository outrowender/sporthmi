/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.impl;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.IconCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.map.impl.ContentListItem;

class ContentListItem$ContentListRowWrapper
extends EvoListRow {
    public final ContentListItem item;
    private final /* synthetic */ ContentListItem this$0;

    public ContentListItem$ContentListRowWrapper(ContentListItem contentListItem, int n, int n2, ContentListItem contentListItem2) {
        this.this$0 = contentListItem;
        super(n * 1000 + n2, 10);
        this.setInteger(6, n);
        this.setInteger(7, n2);
        this.setInteger(9, 0);
        this.item = contentListItem2;
    }

    public ContentListItem$ContentListRowWrapper(ContentListItem contentListItem, ContentListItem$ContentListRowWrapper contentListItem$ContentListRowWrapper) {
        this.this$0 = contentListItem;
        super(contentListItem$ContentListRowWrapper.getUniqueID(), contentListItem$ContentListRowWrapper.getColumnCount());
        this.setInteger(0, contentListItem$ContentListRowWrapper.getInteger(0));
        this.setIconCell(1, (IconCell)contentListItem$ContentListRowWrapper.getCell(1));
        this.setInteger(2, contentListItem$ContentListRowWrapper.getInteger(2));
        this.setText(3, contentListItem$ContentListRowWrapper.getText(3));
        this.setInteger(4, contentListItem$ContentListRowWrapper.getInteger(4));
        this.setInteger(5, contentListItem$ContentListRowWrapper.getInteger(5));
        this.setInteger(6, contentListItem$ContentListRowWrapper.getInteger(6));
        this.setInteger(7, contentListItem$ContentListRowWrapper.getInteger(7));
        this.setIconCell(8, (IconCell)contentListItem$ContentListRowWrapper.getCell(8));
        this.setInteger(9, contentListItem$ContentListRowWrapper.getInteger(9));
        this.item = contentListItem$ContentListRowWrapper.item;
    }

    private void setCells(int n, String string, boolean bl, int n2, int n3, int n4, int n5) {
        this.setInteger(0, n3);
        this.setIconCell(1, new IconCell(new HMIResourceLocator(n)));
        this.setInteger(2, n4);
        this.setText(3, string);
        this.setInteger(4, n2);
        this.setInteger(5, bl ? 1 : 0);
    }

    public ContentListItem$ContentListRowWrapper setIconText(int n, String string, boolean bl) {
        this.setCells(n, string, bl, -1, 0, 0, 1);
        return this;
    }

    public ContentListItem$ContentListRowWrapper setIconTextForParent(int n, String string, boolean bl) {
        this.setCells(n, string, bl, -1, 4, 0, 1);
        return this;
    }

    public ContentListItem$ContentListRowWrapper setIconResText(String string, String string2, boolean bl) {
        this.setInteger(0, 3);
        this.setIconCell(8, new IconCell(new HMIResourceLocator(string)));
        this.setInteger(2, -1);
        this.setText(3, string2);
        this.setInteger(4, -1);
        this.setInteger(5, bl ? 1 : 0);
        return this;
    }

    public ContentListItem$ContentListRowWrapper setIconIDTextID(int n, int n2, boolean bl) {
        this.setCells(-1, "", bl, n2, 1, n, 0);
        return this;
    }

    @Override
    public EvoListRow copy() {
        return new ContentListItem$ContentListRowWrapper(this.this$0, this);
    }
}

