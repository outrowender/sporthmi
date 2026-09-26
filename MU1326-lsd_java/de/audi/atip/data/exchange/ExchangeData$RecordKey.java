/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.data.exchange;

import de.audi.atip.data.exchange.ExchangeData$1;
import de.audi.atip.data.exchange.ExchangeRecord;
import de.audi.atip.data.exchange.ExchangeRecordComparable;

class ExchangeData$RecordKey
implements ExchangeRecordComparable {
    private int key;

    private ExchangeData$RecordKey() {
    }

    void setKey(int n) {
        this.key = n;
    }

    @Override
    public int compareTo(Object object) {
        int n = ((ExchangeRecord)object).getKey();
        return this.key - n;
    }

    @Override
    public int getKey() {
        return this.key;
    }

    /* synthetic */ ExchangeData$RecordKey(ExchangeData$1 exchangeData$1) {
        this();
    }
}

