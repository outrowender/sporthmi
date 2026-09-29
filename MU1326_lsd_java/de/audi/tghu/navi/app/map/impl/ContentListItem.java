/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.impl;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.util.StringUtilities;
import de.audi.tghu.navi.app.map.impl.ContentListItem$ContentListRowWrapper;

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
        ContentListItem$ContentListRowWrapper contentListItem$ContentListRowWrapper = new ContentListItem$ContentListRowWrapper(this, this.isStatic ? 0 : 1, this.rowID, this);
        switch (this.format) {
            case 0: {
                contentListItem$ContentListRowWrapper.setIconText(this.iconID, this.text, this.checked);
                break;
            }
            case 4: {
                contentListItem$ContentListRowWrapper.setIconTextForParent(this.iconID, this.text, this.checked);
                break;
            }
            case 1: {
                contentListItem$ContentListRowWrapper.setIconIDTextID(this.iconID, this.textID, this.checked);
                break;
            }
            case 3: {
                contentListItem$ContentListRowWrapper.setIconResText(this.iconURI, this.text, this.checked);
                break;
            }
        }
        contentListItem$ContentListRowWrapper.setInteger(9, this.enabled ? 1 : 0);
        return contentListItem$ContentListRowWrapper;
    }

    public String toString() {
        return StringUtilities.formatMessage("[Format]%1, [IconID]%2, [Text]%3, [TextID]%4, [Checked]%5, [IsStatic]%6, [RowID]%7, [IconURI]%8, [Enabled]%9 ", new String[]{Integer.toString(this.format), Integer.toString(this.iconID), this.text, Integer.toString(this.textID), Boolean.toString(this.checked), Boolean.toString(this.isStatic), Integer.toString(this.rowID), this.iconURI, Boolean.toString(this.enabled)});
    }
}

