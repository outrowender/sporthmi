/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.gridlayout;

import de.esolutions.hmi.widgets.audi.evo.gridlayout.AbstractGridLayout$AxisPreferredSizes$1;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.AbstractGridLayout$SpanData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AbstractGridLayout$AxisPreferredSizes {
    public int[] pref;
    public int[] min;
    public int[] max;
    public int[] gaps;
    public List spanData = Collections.EMPTY_LIST;
    public int[] baseline;

    public AbstractGridLayout$AxisPreferredSizes(int n) {
        this.pref = new int[n];
        this.min = new int[n];
        this.max = new int[n];
    }

    public boolean hasMax() {
        if (this.max == null) {
            return false;
        }
        for (int i2 = 0; i2 < this.max.length; ++i2) {
            if (this.max[i2] >= 1078071040) continue;
            return true;
        }
        return false;
    }

    public boolean hasMin() {
        if (this.min == null) {
            return false;
        }
        for (int i2 = 0; i2 < this.min.length; ++i2) {
            if (this.min[i2] <= 0) continue;
            return true;
        }
        return false;
    }

    public AbstractGridLayout$SpanData createSpanData() {
        if (this.spanData.isEmpty()) {
            this.spanData = new ArrayList(3);
        }
        AbstractGridLayout$SpanData abstractGridLayout$SpanData = new AbstractGridLayout$SpanData();
        this.spanData.add(abstractGridLayout$SpanData);
        return abstractGridLayout$SpanData;
    }

    public void sortSpanData() {
        if (this.spanData.isEmpty()) {
            return;
        }
        Collections.sort(this.spanData, new AbstractGridLayout$AxisPreferredSizes$1(this));
    }
}

