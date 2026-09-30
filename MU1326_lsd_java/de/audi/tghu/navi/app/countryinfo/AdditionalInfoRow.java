/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.countryinfo;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.IconCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ListRow;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.util.Util;

public class AdditionalInfoRow
extends ListRow {
    public static final int CELL_0_ADDITIONAL_ICON = 0;
    public static final int CELL_1_ADDITIONAL_INFO = 1;
    public static final int ROW_NUMBER_OF_CELLS = 2;
    public static final int FORMAT_ICON_TEXT = 0;
    public static final int FORMAT_TEXT = 1;
    private int additionalInfoIconId = 0;

    public AdditionalInfoRow(IconHandler iconHandler, int n, String string) {
        super(new ListCell[2]);
        this.additionalInfoIconId = n;
        int n2 = 0;
        this.cells[0] = this.resolveAdditionalIcon(iconHandler, n, n2);
        if (!Util.isEmpty(string)) {
            this.cells[1] = new TextListCell(string);
        }
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        boolean bl = true;
        try {
            String string = this.getAdditionalInfo();
            String string2 = ((AdditionalInfoRow)object).getAdditionalInfo();
            if (Util.isEmpty(string)) {
                if (!Util.isEmpty(string2)) {
                    bl = false;
                }
            } else if (!string.equals(string2)) {
                return false;
            }
            if (this.getAdditionalInfoIconId() != ((AdditionalInfoRow)object).getAdditionalInfoIconId()) {
                bl = false;
            }
            if (this.getFormat() != ((AdditionalInfoRow)object).getFormat()) {
                bl = false;
            }
        }
        catch (ClassCastException classCastException) {
            bl = false;
        }
        return bl;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public int getFormat() {
        return -1;
    }

    public int getAdditionalInfoIconId() {
        return this.additionalInfoIconId;
    }

    public String getAdditionalInfo() {
        String string;
        try {
            TextListCell textListCell = (TextListCell)this.getCell(1);
            string = textListCell.getText();
        }
        catch (ClassCastException classCastException) {
            string = null;
        }
        return string;
    }

    private IconCell resolveAdditionalIcon(IconHandler iconHandler, int n, int n2) {
        int n3 = iconHandler.resolveAdditionalInfoIconResourceID(n, n2);
        if (n3 != -1) {
            return new IconCell(new HMIResourceLocator(n3));
        }
        return new IconCell(new HMIResourceLocator(-1));
    }
}

