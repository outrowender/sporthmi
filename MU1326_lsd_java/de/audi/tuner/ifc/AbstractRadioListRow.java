/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.ifc;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tuner.app.TunerObjectContainer;

public abstract class AbstractRadioListRow
extends EvoListRow {
    public AbstractRadioListRow(long l, int n) {
        super(l, n);
    }

    public AbstractRadioListRow(AbstractRadioListRow abstractRadioListRow) {
        super(abstractRadioListRow);
    }

    public abstract TunerObjectContainer getTOContainer();
}

