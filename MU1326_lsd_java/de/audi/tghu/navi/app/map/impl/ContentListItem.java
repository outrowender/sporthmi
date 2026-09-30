/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.impl;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.IconCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.util.StringUtilities;

public class ContentListItem {
    public final int format;
    public final int iconID;
    public final String text;
    public final int textID;
    public boolean checked = false;
    public final boolean isStatic;
    public final int rowID;
    public final String iconURI;
    public boolean enabled = true;
    public final boolean isParent;
    public final int parentId;

    private ContentListItem(int n, int n2, String string, int n3, boolean bl, int n4, String string2, boolean bl2, int n5) {
        this.format = n;
        this.iconID = n2;
        this.text = string;
        this.textID = n3;
        this.isStatic = bl;
        this.rowID = n4;
        this.iconURI = string2;
        this.isParent = bl2;
        this.parentId = n5;
    }

    public static ContentListItem createStaticItem(int n, int n2, int n3) {
        return new ContentListItem(1, n2, null, n3, true, n, null, false, -1);
    }

    public static ContentListItem createStaticItem(int n, int n2) {
        return new ContentListItem(1, n2, null, n2, true, n, null, false, -1);
    }

    public static ContentListItem createPOIItem(int n, int n2, String string, boolean bl, int n3, boolean bl2) {
        int n4 = bl && bl2 ? 4 : 0;
        ContentListItem contentListItem = new ContentListItem(n4, n2, string, -1, false, n, null, bl, n3);
        return contentListItem;
    }

    public static ContentListItem createKMLItem(int n, String string, String string2) {
        return new ContentListItem(3, -1, string2, -1, false, n, string, false, -1);
    }

    public static ContentListItem createMyAudiItem(int n, int n2, String string, boolean bl, int n3) {
        return ContentListItem.createPOIItem(n, n2, string, bl, n3, false);
    }

    public EvoListRow toEvoListRow() {
        ContentListRowWrapper contentListRowWrapper = new ContentListRowWrapper(this.isStatic ? 0 : 1, this.rowID, this);
        switch (this.format) {
            case 0: {
                contentListRowWrapper.setIconText(this.iconID, this.text, this.checked);
                break;
            }
            case 4: {
                contentListRowWrapper.setIconTextForParent(this.iconID, this.text, this.checked);
                break;
            }
            case 1: {
                contentListRowWrapper.setIconIDTextID(this.iconID, this.textID, this.checked);
                break;
            }
            case 3: {
                contentListRowWrapper.setIconResText(this.iconURI, this.text, this.checked);
                break;
            }
        }
        contentListRowWrapper.setInteger(9, this.enabled ? 1 : 0);
        return contentListRowWrapper;
    }

    public String toString() {
        return StringUtilities.formatMessage("[Format]%1, [IconID]%2, [Text]%3, [TextID]%4, [Checked]%5, [IsStatic]%6, [RowID]%7, [IconURI]%8, [Enabled]%9 ", new String[]{Integer.toString(this.format), Integer.toString(this.iconID), this.text, Integer.toString(this.textID), Boolean.toString(this.checked), Boolean.toString(this.isStatic), Integer.toString(this.rowID), this.iconURI, Boolean.toString(this.enabled)});
    }

    class ContentListRowWrapper
    extends EvoListRow {
        public final ContentListItem item;

        public ContentListRowWrapper(int n, int n2, ContentListItem contentListItem2) {
            super(n * 1000 + n2, 10);
            this.setInteger(6, n);
            this.setInteger(7, n2);
            this.setInteger(9, 0);
            this.item = contentListItem2;
        }

        public ContentListRowWrapper(ContentListRowWrapper contentListRowWrapper) {
            super(contentListRowWrapper.getUniqueID(), contentListRowWrapper.getColumnCount());
            this.setInteger(0, contentListRowWrapper.getInteger(0));
            this.setIconCell(1, (IconCell)contentListRowWrapper.getCell(1));
            this.setInteger(2, contentListRowWrapper.getInteger(2));
            this.setText(3, contentListRowWrapper.getText(3));
            this.setInteger(4, contentListRowWrapper.getInteger(4));
            this.setInteger(5, contentListRowWrapper.getInteger(5));
            this.setInteger(6, contentListRowWrapper.getInteger(6));
            this.setInteger(7, contentListRowWrapper.getInteger(7));
            this.setIconCell(8, (IconCell)contentListRowWrapper.getCell(8));
            this.setInteger(9, contentListRowWrapper.getInteger(9));
            this.item = contentListRowWrapper.item;
        }

        private void setCells(int n, String string, boolean bl, int n2, int n3, int n4, int n5) {
            this.setInteger(0, n3);
            this.setIconCell(1, new IconCell(new HMIResourceLocator(n)));
            this.setInteger(2, n4);
            this.setText(3, string);
            this.setInteger(4, n2);
            this.setInteger(5, bl ? 1 : 0);
        }

        public ContentListRowWrapper setIconText(int n, String string, boolean bl) {
            this.setCells(n, string, bl, -1, 0, 0, 1);
            return this;
        }

        public ContentListRowWrapper setIconTextForParent(int n, String string, boolean bl) {
            this.setCells(n, string, bl, -1, 4, 0, 1);
            return this;
        }

        public ContentListRowWrapper setIconResText(String string, String string2, boolean bl) {
            this.setInteger(0, 3);
            this.setIconCell(8, new IconCell(new HMIResourceLocator(string)));
            this.setInteger(2, -1);
            this.setText(3, string2);
            this.setInteger(4, -1);
            this.setInteger(5, bl ? 1 : 0);
            return this;
        }

        public ContentListRowWrapper setIconIDTextID(int n, int n2, boolean bl) {
            this.setCells(-1, "", bl, n2, 1, n, 0);
            return this;
        }

        public EvoListRow copy() {
            return new ContentListRowWrapper(this);
        }
    }
}

