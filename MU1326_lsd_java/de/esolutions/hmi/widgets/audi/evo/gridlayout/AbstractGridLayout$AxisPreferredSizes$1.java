/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.gridlayout;

import de.esolutions.hmi.widgets.audi.evo.gridlayout.AbstractGridLayout$AxisPreferredSizes;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.AbstractGridLayout$SpanData;
import java.util.Comparator;

class AbstractGridLayout$AxisPreferredSizes$1
implements Comparator {
    private final /* synthetic */ AbstractGridLayout$AxisPreferredSizes this$0;

    AbstractGridLayout$AxisPreferredSizes$1(AbstractGridLayout$AxisPreferredSizes abstractGridLayout$AxisPreferredSizes) {
        this.this$0 = abstractGridLayout$AxisPreferredSizes;
    }

    @Override
    public int compare(Object object, Object object2) {
        AbstractGridLayout$SpanData abstractGridLayout$SpanData = (AbstractGridLayout$SpanData)object;
        AbstractGridLayout$SpanData abstractGridLayout$SpanData2 = (AbstractGridLayout$SpanData)object2;
        return abstractGridLayout$SpanData.span - abstractGridLayout$SpanData2.span;
    }
}

