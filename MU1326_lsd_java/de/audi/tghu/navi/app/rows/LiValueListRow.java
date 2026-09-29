/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.rows;

import de.audi.atip.hmi.model.list.EvoListRow;
import org.dsi.ifc.navigation.LIValueListElement;

public abstract class LiValueListRow
extends EvoListRow {
    private final LIValueListElement element;

    protected LiValueListRow(LiValueListRow liValueListRow) {
        super(liValueListRow);
        this.element = liValueListRow.element;
    }

    public LiValueListRow(long l, int n, LIValueListElement lIValueListElement) {
        super(l, n);
        this.element = lIValueListElement;
    }

    public LIValueListElement getElement() {
        return this.element;
    }
}

