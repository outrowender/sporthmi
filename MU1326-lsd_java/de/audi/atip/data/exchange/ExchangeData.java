/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.audi.atip.data.exchange;

import de.audi.atip.data.exchange.ExchangeData$RecordKey;
import de.audi.atip.data.exchange.ExchangeRecord;
import de.audi.atip.data.exchange.ExportData;
import de.audi.atip.data.exchange.ImportData;
import de.audi.atip.data.exchange.KeyNotFoundException;
import de.audi.atip.data.exchange.UnsupportedVersionException;
import de.audi.atip.data.exchange.WrongDataTypeException;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class ExchangeData
implements ImportData,
ExportData {
    final int app;
    private final List recordList = new ArrayList(200);
    private final ExchangeData$RecordKey recordKey = new ExchangeData$RecordKey(null);

    ExchangeData(int n) {
        this.app = n;
    }

    ExchangeRecord[] getSortedRecords() {
        Object[] objectArray = new ExchangeRecord[this.recordList.size()];
        this.recordList.toArray(objectArray);
        Arrays.sort(objectArray);
        return objectArray;
    }

    int size() {
        return this.recordList.size();
    }

    public String toString() {
        Buffer buffer = new Buffer();
        ExchangeRecord[] exchangeRecordArray = this.getSortedRecords();
        for (int i2 = 0; i2 < exchangeRecordArray.length; ++i2) {
            buffer.append('\n');
            buffer.append(exchangeRecordArray[i2]);
        }
        return buffer.toString();
    }

    void add(ExchangeRecord exchangeRecord) {
        this.recordList.add(exchangeRecord);
    }

    @Override
    public void add(int n, int n2, boolean bl) {
        this.add(new ExchangeRecord(this.app, n, n2, bl));
    }

    @Override
    public void add(int n, int n2, byte by) {
        this.add(new ExchangeRecord(this.app, n, n2, by));
    }

    @Override
    public void add(int n, int n2, short s) {
        this.add(new ExchangeRecord(this.app, n, n2, s));
    }

    @Override
    public void add(int n, int n2, int n3) {
        this.add(new ExchangeRecord(this.app, n, n2, n3));
    }

    @Override
    public void add(int n, int n2, long l) {
        this.add(new ExchangeRecord(this.app, n, n2, l));
    }

    @Override
    public void add(int n, int n2, float f2) {
        this.add(new ExchangeRecord(this.app, n, n2, f2));
    }

    @Override
    public void add(int n, int n2, double d2) {
        this.add(new ExchangeRecord(this.app, n, n2, d2));
    }

    @Override
    public void add(int n, int n2, String string) {
        this.add(new ExchangeRecord(this.app, n, n2, string));
    }

    @Override
    public boolean getBoolean(int n, int n2) {
        Object object = this.get(n, n2, 0);
        return (Boolean)object;
    }

    @Override
    public byte getByte(int n, int n2) {
        Object object = this.get(n, n2, 1);
        return (Byte)object;
    }

    @Override
    public short getShort(int n, int n2) {
        Object object = this.get(n, n2, 2);
        return (Short)object;
    }

    @Override
    public int getInteger(int n, int n2) {
        Object object = this.get(n, n2, 3);
        return (Integer)object;
    }

    @Override
    public long getLong(int n, int n2) {
        Object object = this.get(n, n2, 4);
        return (Long)object;
    }

    @Override
    public float getFloat(int n, int n2) {
        Object object = this.get(n, n2, 5);
        return ((Float)object).floatValue();
    }

    @Override
    public double getDouble(int n, int n2) {
        Object object = this.get(n, n2, 6);
        return (Double)object;
    }

    @Override
    public String getString(int n, int n2) {
        return (String)this.get(n, n2, 7);
    }

    private Object get(int n, int n2, int n3) {
        this.recordKey.setKey(n);
        int n4 = Collections.binarySearch(this.recordList, this.recordKey);
        if (n4 < 0) {
            throw new KeyNotFoundException(n);
        }
        ExchangeRecord exchangeRecord = (ExchangeRecord)this.recordList.get(n4);
        if (exchangeRecord.getVersion() != n2) {
            throw new UnsupportedVersionException(exchangeRecord.getVersion(), n2);
        }
        if (exchangeRecord.getDatatype() != n3 && n3 != 7 && exchangeRecord.getDatatype() != 8) {
            throw new WrongDataTypeException(exchangeRecord.getDatatype(), n3);
        }
        return exchangeRecord.getValue();
    }
}

