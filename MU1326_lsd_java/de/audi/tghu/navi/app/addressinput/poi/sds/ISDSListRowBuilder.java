/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sds;

import de.audi.atip.hmi.model.list.EvoListRow;

public interface ISDSListRowBuilder {
    default public EvoListRow buildEvoListRow(long l, String string, int n) {
    }

    default public int getColumnCount() {
    }
}

