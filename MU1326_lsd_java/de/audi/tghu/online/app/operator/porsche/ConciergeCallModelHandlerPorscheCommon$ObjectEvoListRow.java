/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operator.porsche;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.remotehmi.util.DeepCloneable;
import de.audi.tghu.online.app.operator.porsche.ConciergeCallModelHandlerPorscheCommon;

public class ConciergeCallModelHandlerPorscheCommon$ObjectEvoListRow
extends EvoListRow {
    private DeepCloneable entry;
    private final /* synthetic */ ConciergeCallModelHandlerPorscheCommon this$0;

    protected ConciergeCallModelHandlerPorscheCommon$ObjectEvoListRow(ConciergeCallModelHandlerPorscheCommon conciergeCallModelHandlerPorscheCommon, ConciergeCallModelHandlerPorscheCommon$ObjectEvoListRow conciergeCallModelHandlerPorscheCommon$ObjectEvoListRow) {
        this.this$0 = conciergeCallModelHandlerPorscheCommon;
        super(conciergeCallModelHandlerPorscheCommon$ObjectEvoListRow);
        this.setObject((DeepCloneable)conciergeCallModelHandlerPorscheCommon$ObjectEvoListRow.getObject().clone(true));
    }

    public ConciergeCallModelHandlerPorscheCommon$ObjectEvoListRow(ConciergeCallModelHandlerPorscheCommon conciergeCallModelHandlerPorscheCommon, long l, int n) {
        this.this$0 = conciergeCallModelHandlerPorscheCommon;
        super(l, n);
    }

    public void setObject(DeepCloneable deepCloneable) {
        if (deepCloneable != null) {
            this.entry = deepCloneable;
        }
    }

    public DeepCloneable getObject() {
        return this.entry;
    }

    @Override
    public EvoListRow copy() {
        return new ConciergeCallModelHandlerPorscheCommon$ObjectEvoListRow(this.this$0, this);
    }
}

