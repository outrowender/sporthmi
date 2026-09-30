/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sds;

import de.audi.atip.hmi.model.list.EvoListRow;

public interface ISDSListRowBuilder {
    public EvoListRow buildEvoListRow(long var1, String var3, int var4);

    public int getColumnCount();
}

