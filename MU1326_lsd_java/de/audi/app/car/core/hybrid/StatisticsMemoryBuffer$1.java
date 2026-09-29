/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.hybrid;

import de.audi.app.car.core.hybrid.StatisticsMemoryBuffer;
import java.util.Iterator;
import java.util.NoSuchElementException;

class StatisticsMemoryBuffer$1
implements Iterator {
    private int index;
    private int lastReturnedIndex;
    private boolean isFirst;
    private final /* synthetic */ StatisticsMemoryBuffer this$0;

    StatisticsMemoryBuffer$1(StatisticsMemoryBuffer statisticsMemoryBuffer) {
        this.this$0 = statisticsMemoryBuffer;
        this.index = StatisticsMemoryBuffer.access$000(this.this$0);
        this.lastReturnedIndex = -1;
        this.isFirst = StatisticsMemoryBuffer.access$100(this.this$0);
    }

    @Override
    public boolean hasNext() {
        return this.isFirst || this.index != StatisticsMemoryBuffer.access$200(this.this$0);
    }

    @Override
    public Object next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        this.isFirst = false;
        this.lastReturnedIndex = this.index;
        this.index = StatisticsMemoryBuffer.access$300(this.this$0, this.index);
        return StatisticsMemoryBuffer.access$400(this.this$0)[this.lastReturnedIndex];
    }

    @Override
    public void remove() {
        if (this.lastReturnedIndex == -1) {
            throw new IllegalStateException();
        }
        if (this.lastReturnedIndex == StatisticsMemoryBuffer.access$000(this.this$0)) {
            this.this$0.dequeue();
            this.lastReturnedIndex = -1;
            return;
        }
        int n = this.lastReturnedIndex + 1;
        if (StatisticsMemoryBuffer.access$000(this.this$0) < this.lastReturnedIndex && n < StatisticsMemoryBuffer.access$200(this.this$0)) {
            System.arraycopy((Object)StatisticsMemoryBuffer.access$400(this.this$0), n, (Object)StatisticsMemoryBuffer.access$400(this.this$0), this.lastReturnedIndex, StatisticsMemoryBuffer.access$200(this.this$0) - n);
        } else {
            while (n != StatisticsMemoryBuffer.access$200(this.this$0)) {
                if (n >= StatisticsMemoryBuffer.access$500(this.this$0)) {
                    StatisticsMemoryBuffer.access$400((StatisticsMemoryBuffer)this.this$0)[n - 1] = StatisticsMemoryBuffer.access$400(this.this$0)[0];
                    n = 0;
                    continue;
                }
                StatisticsMemoryBuffer.access$400((StatisticsMemoryBuffer)this.this$0)[StatisticsMemoryBuffer.access$600((StatisticsMemoryBuffer)this.this$0, (int)n)] = StatisticsMemoryBuffer.access$400(this.this$0)[n];
                n = StatisticsMemoryBuffer.access$300(this.this$0, n);
            }
        }
        this.lastReturnedIndex = -1;
        StatisticsMemoryBuffer.access$202(this.this$0, StatisticsMemoryBuffer.access$600(this.this$0, StatisticsMemoryBuffer.access$200(this.this$0)));
        StatisticsMemoryBuffer.access$400((StatisticsMemoryBuffer)this.this$0)[StatisticsMemoryBuffer.access$200((StatisticsMemoryBuffer)this.this$0)] = null;
        StatisticsMemoryBuffer.access$102(this.this$0, false);
        this.index = StatisticsMemoryBuffer.access$600(this.this$0, this.index);
    }
}

