/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput;

import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.rows.LiValueListRow;
import de.audi.tghu.navi.app.util.TextUtil;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.navigation.LIValueListElement;

public class AddressInputLIValueListElementListRow
extends LiValueListRow {
    public static final int COLUMN_BEAUTIFIED_TEXT = 0;
    public static final int COLUMN_IS_VALID_DEST = 1;
    public static final int COLUMN_IS_TO_REFINE = 2;
    public static final int COLUMN_IS_HISTORY_ELEMENT = 3;
    public static final int COLUMN_PROPERTY = 4;
    public static final int MAX_COLUMNS = 5;
    public static final int FOCUSED_ITEM_IS_INVALID_PROPERTY = -1515095522;
    public static final int FOCUSED_DUMMY_PROPERTY = -1112037785;

    public AddressInputLIValueListElementListRow(LIValueListElement lIValueListElement, int n, int[] nArray) {
        super(lIValueListElement.getListIndex(), 5, lIValueListElement);
        this.setText(0, this.getRowName(lIValueListElement));
        int n2 = lIValueListElement.isValidDestination() ? 0 : 1;
        this.setInteger(1, n2);
        this.setInteger(3, 0);
        int n3 = lIValueListElement.isToRefine() ? 0 : 1;
        this.setInteger(2, n3);
        if (n != -1) {
            this.setPropertyCell(4, new PropertyListCell(n, nArray));
        } else {
            this.setPropertyCell(4, null);
        }
    }

    public AddressInputLIValueListElementListRow(LIValueListElement lIValueListElement, int n) {
        this(lIValueListElement, n, new int[]{-1515095522});
    }

    public EvoListRow copy() {
        return new AddressInputLIValueListElementListRow(this);
    }

    public AddressInputLIValueListElementListRow(AddressInputLIValueListElementListRow addressInputLIValueListElementListRow) {
        super(addressInputLIValueListElementListRow);
    }

    private String getRowName(LIValueListElement lIValueListElement) {
        Buffer buffer = new Buffer(lIValueListElement.getData());
        if (Util.isHURegionNAR() && AddressInputLIValueListElementListRow.isStreetBasename(lIValueListElement)) {
            buffer.append(" ").append(TextUtil.getStreetBasenameMarker());
        }
        if (Util.isHURegionNAR() && AddressInputLIValueListElementListRow.isPoi24h(lIValueListElement)) {
            buffer.append(" ").append(TextUtil.getPoi24hMarker());
        }
        return buffer.toString();
    }

    private static boolean isStreetBasename(LIValueListElement lIValueListElement) {
        return (lIValueListElement.getAdditionalFlags() & 0x10) == 16;
    }

    private static boolean isPoi24h(LIValueListElement lIValueListElement) {
        return (lIValueListElement.getAdditionalFlags() & 1) == 1;
    }
}

