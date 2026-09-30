/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.search.organizer;

import de.audi.atip.hmi.model.list.EvoListRow;
import org.dsi.ifc.global.CharacterInfo;

public final class AlphabeticalFastscrollRow
extends EvoListRow {
    private static final int MAX_COLUMNS = 2;
    private static final int COL_CHARACTER = 0;
    private static final int COL_INDEX = 1;

    public static EvoListRow createFastscrollRow(long l, CharacterInfo characterInfo) {
        return new AlphabeticalFastscrollRow(l, characterInfo);
    }

    private AlphabeticalFastscrollRow(long l, CharacterInfo characterInfo) {
        super(l, 2);
        this.setInteger(0, characterInfo.getValue());
        this.setInteger(1, characterInfo.getIndex());
    }
}

