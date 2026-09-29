/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.comfort;

import de.audi.app.car.core.comfort.AbstractRDKComponent;
import de.audi.app.car.core.comfort.AbstractRDKComponent$1;
import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;

final class AbstractRDKComponent$RDKBaseListModelListener
extends DefaultBaseListModelListener {
    private final /* synthetic */ AbstractRDKComponent this$0;

    private AbstractRDKComponent$RDKBaseListModelListener(AbstractRDKComponent abstractRDKComponent) {
        this.this$0 = abstractRDKComponent;
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.this$0.getLogChannel().log(-2137614336, "[AbstractRDKComponent#itemSelected] modelID='%1', index='%2', col='%3'", (long)n, (long)n2, (long)n3);
        switch (n) {
            case 601718: {
                if (evoListRow == null) break;
                int n5 = evoListRow.getInteger(0);
                AbstractRDKComponent.access$700(this.this$0, n5);
                break;
            }
        }
    }

    /* synthetic */ AbstractRDKComponent$RDKBaseListModelListener(AbstractRDKComponent abstractRDKComponent, AbstractRDKComponent$1 abstractRDKComponent$1) {
        this(abstractRDKComponent);
    }
}

