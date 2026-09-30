/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.data.exchange;

import de.audi.atip.data.exchange.ExchangeRecord;
import de.audi.atip.data.exchange.ExchangeRecordComparable;
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
    private final RecordKey recordKey = new RecordKey();

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

    public void add(int n, int n2, boolean bl) {
        this.add(new ExchangeRecord(this.app, n, n2, bl));
    }

    public void add(int n, int n2, byte by) {
        this.add(new ExchangeRecord(this.app, n, n2, by));
    }

    public void add(int n, int n2, short s) {
        this.add(new ExchangeRecord(this.app, n, n2, s));
    }

    public void add(int n, int n2, int n3) {
        this.add(new ExchangeRecord(this.app, n, n2, n3));
    }

    public void add(int n, int n2, long l) {
        this.add(new ExchangeRecord(this.app, n, n2, l));
    }

    public void add(int n, int n2, float f2) {
        this.add(new ExchangeRecord(this.app, n, n2, f2));
    }

    public void add(int n, int n2, double d2) {
        this.add(new ExchangeRecord(this.app, n, n2, d2));
    }

    public void add(int n, int n2, String string) {
        this.add(new ExchangeRecord(this.app, n, n2, string));
    }

    public boolean getBoolean(int n, int n2) throws KeyNotFoundException, UnsupportedVersionException, WrongDataTypeException {
        Object object = this.get(n, n2, 0);
        return (Boolean)object;
    }

    public byte getByte(int n, int n2) throws KeyNotFoundException, UnsupportedVersionException, WrongDataTypeException {
        Object object = this.get(n, n2, 1);
        return (Byte)object;
    }

    public short getShort(int n, int n2) throws KeyNotFoundException, UnsupportedVersionException, WrongDataTypeException {
        Object object = this.get(n, n2, 2);
        return (Short)object;
    }

    public int getInteger(int n, int n2) throws KeyNotFoundException, UnsupportedVersionException, WrongDataTypeException {
        Object object = this.get(n, n2, 3);
        return (Integer)object;
    }

    public long getLong(int n, int n2) throws KeyNotFoundException, UnsupportedVersionException, WrongDataTypeException {
        Object object = this.get(n, n2, 4);
        return (Long)object;
    }

    public float getFloat(int n, int n2) throws KeyNotFoundException, UnsupportedVersionException, WrongDataTypeException {
        Object object = this.get(n, n2, 5);
        return ((Float)object).floatValue();
    }

    public double getDouble(int n, int n2) throws KeyNotFoundException, UnsupportedVersionException, WrongDataTypeException {
        Object object = this.get(n, n2, 6);
        return (Double)object;
    }

    public String getString(int n, int n2) throws KeyNotFoundException, UnsupportedVersionException, WrongDataTypeException {
        return (String)this.get(n, n2, 7);
    }

    private Object get(int n, int n2, int n3) throws KeyNotFoundException, UnsupportedVersionException, WrongDataTypeException {
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

    private static class RecordKey
    implements ExchangeRecordComparable {
        private int key;

        private RecordKey() {
        }

        void setKey(int n) {
            this.key = n;
        }

        public int compareTo(Object object) {
            int n = ((ExchangeRecord)object).getKey();
            return this.key - n;
        }

        public int getKey() {
            return this.key;
        }
    }
}

