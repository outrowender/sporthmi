/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.serializer.adapter;

import de.esolutions.fw.util.commons.StringConverter;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.adapter.StringEncodings;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class GenericSerializable
implements ISerializable {
    private static final int INT8 = 0;
    private static final int INT16 = 1;
    private static final int INT32 = 2;
    private static final int INT64 = 3;
    private static final int STRING = 4;
    private static final int FLOAT = 5;
    private static final int DOUBLE = 6;
    private static final int BOOL = 7;
    private static final int UINT8 = 8;
    private static final int UINT16 = 9;
    private static final int UINT32 = 10;
    private static final int UINT64 = 11;
    private static final int INT8_ARRAY = 12;
    private static final int INT16_ARRAY = 13;
    private static final int INT32_ARRAY = 14;
    private static final int INT64_ARRAY = 15;
    private static final int STRING_ARRAY = 16;
    private static final int FLOAT_ARRAY = 17;
    private static final int DOUBLE_ARRAY = 18;
    private static final int BOOL_ARRAY = 19;
    private static final int UINT8_ARRAY = 20;
    private static final int UINT16_ARRAY = 21;
    private static final int UINT32_ARRAY = 22;
    private static final int UINT64_ARRAY = 23;
    private static final int UCHAR16 = 24;
    private static final int UCHAR16_ARRAY = 25;
    private int stringEncoding;
    private List items;

    public GenericSerializable() {
        this(0);
    }

    public GenericSerializable(int n) {
        this.stringEncoding = n;
        this.items = new ArrayList();
    }

    public void putBool(boolean bl) throws SerializerException {
        this.items.add(new Item(7, new Boolean(bl)));
    }

    public void putBoolArray(boolean[] blArray) throws SerializerException {
        this.items.add(new Item(19, blArray));
    }

    public void putDouble(double d2) throws SerializerException {
        this.items.add(new Item(6, new Double(d2)));
    }

    public void putDoubleArray(double[] dArray) throws SerializerException {
        this.items.add(new Item(18, dArray));
    }

    public void putFloat(float f2) throws SerializerException {
        this.items.add(new Item(5, new Float(f2)));
    }

    public void putFloatArray(float[] fArray) throws SerializerException {
        this.items.add(new Item(17, fArray));
    }

    public void putInt16(short s) throws SerializerException {
        this.items.add(new Item(1, new Short(s)));
    }

    public void putInt16Array(short[] sArray) throws SerializerException {
        this.items.add(new Item(13, sArray));
    }

    public void putInt32(int n) throws SerializerException {
        this.items.add(new Item(2, new Integer(n)));
    }

    public void putInt32Array(int[] nArray) throws SerializerException {
        this.items.add(new Item(14, nArray));
    }

    public void putInt64(long l) throws SerializerException {
        this.items.add(new Item(3, new Long(l)));
    }

    public void putInt64Array(long[] lArray) throws SerializerException {
        this.items.add(new Item(15, lArray));
    }

    public void putInt8(byte by) throws SerializerException {
        this.items.add(new Item(0, new Byte(by)));
    }

    public void putInt8Array(byte[] byArray) throws SerializerException {
        this.items.add(new Item(12, byArray));
    }

    public void putUInt16(int n) throws SerializerException {
        this.items.add(new Item(9, new Integer(n)));
    }

    public void putUInt16Array(int[] nArray) throws SerializerException {
        this.items.add(new Item(21, nArray));
    }

    public void putUInt32(long l) throws SerializerException {
        this.items.add(new Item(10, new Long(l)));
    }

    public void putUInt32Array(long[] lArray) throws SerializerException {
        this.items.add(new Item(22, lArray));
    }

    public void putUInt64(long l) throws SerializerException {
        this.items.add(new Item(11, new Long(l)));
    }

    public void putUInt64Array(long[] lArray) throws SerializerException {
        this.items.add(new Item(23, lArray));
    }

    public void putUInt8(short s) throws SerializerException {
        this.items.add(new Item(8, new Short(s)));
    }

    public void putUInt8Array(short[] sArray) throws SerializerException {
        this.items.add(new Item(20, sArray));
    }

    public void putUChar16(char c2) throws SerializerException {
        this.items.add(new Item(24, new Character(c2)));
    }

    public void putUChar16Array(char[] cArray) throws SerializerException {
        this.items.add(new Item(25, cArray));
    }

    public void putOptionalFlag(boolean bl) throws SerializerException {
        this.putInt8(bl ? (byte)0 : -1);
    }

    public void putString(String string) throws SerializerException {
        try {
            StringConverter stringConverter = StringEncodings.getConverter(this.stringEncoding);
            if (stringConverter == null) {
                throw new SerializerException("No converter found");
            }
            byte[] byArray = stringConverter.getBytes(string);
            int n = byArray.length / StringEncodings.byteWidth[this.stringEncoding];
            this.putInt8((byte)this.stringEncoding);
            this.putInt16((short)n);
            this.putInt8Array(byArray);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new SerializerException("Invalid String Type");
        }
    }

    public void putOptionalString(String string) throws SerializerException {
        this.putOptionalFlag(string != null);
        if (string != null) {
            this.putString(string);
        }
    }

    public void putOptionalStringVarArray(String[] stringArray) throws SerializerException {
        this.putOptionalFlag(stringArray != null);
        if (stringArray != null) {
            this.putInt32(stringArray.length);
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                this.putOptionalString(stringArray[i2]);
            }
        }
    }

    public void putEnum(int n) throws SerializerException {
        this.putInt32(n);
    }

    public void putStringArray(String[] stringArray) throws SerializerException, SerializerException {
        this.putUInt32(stringArray.length);
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            this.putString(stringArray[i2]);
        }
    }

    public void putBoolVarArray(boolean[] blArray) throws SerializerException {
        this.putUInt32(blArray.length);
        this.putBoolArray(blArray);
    }

    public void putUChar16VarArray(char[] cArray) throws SerializerException {
        this.putUInt32(cArray.length);
        this.putUChar16Array(cArray);
    }

    public void putUInt8VarArray(short[] sArray) throws SerializerException {
        this.putUInt32(sArray.length);
        this.putUInt8Array(sArray);
    }

    public void putInt8VarArray(byte[] byArray) throws SerializerException {
        this.putUInt32(byArray.length);
        this.putInt8Array(byArray);
    }

    public void putUInt16VarArray(int[] nArray) throws SerializerException {
        this.putUInt32(nArray.length);
        this.putUInt16Array(nArray);
    }

    public void putInt16VarArray(short[] sArray) throws SerializerException {
        this.putUInt32(sArray.length);
        this.putInt16Array(sArray);
    }

    public void putUInt32VarArray(long[] lArray) throws SerializerException {
        this.putUInt32(lArray.length);
        this.putUInt32Array(lArray);
    }

    public void putInt32VarArray(int[] nArray) throws SerializerException {
        this.putUInt32(nArray.length);
        this.putInt32Array(nArray);
    }

    public void putUInt64VarArray(long[] lArray) throws SerializerException {
        this.putUInt32(lArray.length);
        this.putUInt64Array(lArray);
    }

    public void putInt64VarArray(long[] lArray) throws SerializerException {
        this.putUInt32(lArray.length);
        this.putInt64Array(lArray);
    }

    public void putFloatVarArray(float[] fArray) throws SerializerException {
        this.putUInt32(fArray.length);
        this.putFloatArray(fArray);
    }

    public void putDoubleVarArray(double[] dArray) throws SerializerException {
        this.putUInt32(dArray.length);
        this.putDoubleArray(dArray);
    }

    public void putOptionalBoolVarArray(boolean[] blArray) throws SerializerException {
        boolean bl = blArray == null;
        this.putBool(bl);
        if (!bl) {
            this.putBoolVarArray(blArray);
        }
    }

    public void putOptionalUChar16VarArray(char[] cArray) throws SerializerException {
        boolean bl = cArray == null;
        this.putBool(bl);
        if (!bl) {
            this.putUChar16VarArray(cArray);
        }
    }

    public void putOptionalDoubleVarArray(double[] dArray) throws SerializerException {
        boolean bl = dArray == null;
        this.putBool(bl);
        if (!bl) {
            this.putDoubleVarArray(dArray);
        }
    }

    public void putOptionalFloatVarArray(float[] fArray) throws SerializerException {
        boolean bl = fArray == null;
        this.putBool(bl);
        if (!bl) {
            this.putFloatVarArray(fArray);
        }
    }

    public void putOptionalInt16VarArray(short[] sArray) throws SerializerException {
        boolean bl = sArray == null;
        this.putBool(bl);
        if (!bl) {
            this.putInt16VarArray(sArray);
        }
    }

    public void putOptionalInt32VarArray(int[] nArray) throws SerializerException {
        boolean bl = nArray == null;
        this.putBool(bl);
        if (!bl) {
            this.putInt32VarArray(nArray);
        }
    }

    public void putOptionalInt64VarArray(long[] lArray) throws SerializerException {
        boolean bl = lArray == null;
        this.putBool(bl);
        if (!bl) {
            this.putInt64VarArray(lArray);
        }
    }

    public void putOptionalInt8VarArray(byte[] byArray) throws SerializerException {
        boolean bl = byArray == null;
        this.putBool(bl);
        if (!bl) {
            this.putInt8VarArray(byArray);
        }
    }

    public void putOptionalUInt16VarArray(int[] nArray) throws SerializerException {
        boolean bl = nArray == null;
        this.putBool(bl);
        if (!bl) {
            this.putUInt16VarArray(nArray);
        }
    }

    public void putOptionalUInt32VarArray(long[] lArray) throws SerializerException {
        boolean bl = lArray == null;
        this.putBool(bl);
        if (!bl) {
            this.putUInt32VarArray(lArray);
        }
    }

    public void putOptionalUInt64VarArray(long[] lArray) throws SerializerException {
        boolean bl = lArray == null;
        this.putBool(bl);
        if (!bl) {
            this.putUInt64VarArray(lArray);
        }
    }

    public void putOptionalUInt8VarArray(short[] sArray) throws SerializerException {
        boolean bl = sArray == null;
        this.putBool(bl);
        if (!bl) {
            this.putUInt8VarArray(sArray);
        }
    }

    public void putOptionalEnumVarArray(int[] nArray) throws SerializerException {
        boolean bl = nArray == null;
        this.putBool(bl);
        if (!bl) {
            this.putInt32VarArray(nArray);
        }
    }

    public void serialize(ISerializer iSerializer) throws SerializerException {
        block28: for (int i2 = 0; i2 < this.items.size(); ++i2) {
            Item item = (Item)this.items.get(i2);
            switch (item.type) {
                case 0: {
                    iSerializer.putInt8((Byte)item.value);
                    continue block28;
                }
                case 1: {
                    iSerializer.putInt16((Short)item.value);
                    continue block28;
                }
                case 2: {
                    iSerializer.putInt32((Integer)item.value);
                    continue block28;
                }
                case 3: {
                    iSerializer.putInt64((Long)item.value);
                    continue block28;
                }
                case 4: {
                    iSerializer.putString((String)item.value);
                    continue block28;
                }
                case 5: {
                    iSerializer.putFloat(((Float)item.value).floatValue());
                    continue block28;
                }
                case 6: {
                    iSerializer.putDouble((Double)item.value);
                    continue block28;
                }
                case 7: {
                    iSerializer.putBool((Boolean)item.value);
                    continue block28;
                }
                case 8: {
                    iSerializer.putUInt8((Short)item.value);
                    continue block28;
                }
                case 9: {
                    iSerializer.putUInt16((Integer)item.value);
                    continue block28;
                }
                case 10: {
                    iSerializer.putUInt32((Long)item.value);
                    continue block28;
                }
                case 11: {
                    iSerializer.putUInt64((Long)item.value);
                    continue block28;
                }
                case 12: {
                    iSerializer.putInt8Array((byte[])item.value);
                    continue block28;
                }
                case 13: {
                    iSerializer.putInt16Array((short[])item.value);
                    continue block28;
                }
                case 14: {
                    iSerializer.putInt32Array((int[])item.value);
                    continue block28;
                }
                case 15: {
                    iSerializer.putInt64Array((long[])item.value);
                    continue block28;
                }
                case 16: {
                    iSerializer.putStringArray((String[])item.value);
                    continue block28;
                }
                case 17: {
                    iSerializer.putFloatArray((float[])item.value);
                    continue block28;
                }
                case 18: {
                    iSerializer.putDoubleArray((double[])item.value);
                    continue block28;
                }
                case 19: {
                    iSerializer.putBoolArray((boolean[])item.value);
                    continue block28;
                }
                case 20: {
                    iSerializer.putUInt8Array((short[])item.value);
                    continue block28;
                }
                case 21: {
                    iSerializer.putUInt16Array((int[])item.value);
                    continue block28;
                }
                case 22: {
                    iSerializer.putUInt32Array((long[])item.value);
                    continue block28;
                }
                case 23: {
                    iSerializer.putUInt64Array((long[])item.value);
                    continue block28;
                }
                case 24: {
                    iSerializer.putUChar16(((Character)item.value).charValue());
                    continue block28;
                }
                case 25: {
                    iSerializer.putUChar16Array((char[])item.value);
                    continue block28;
                }
                default: {
                    throw new SerializerException("Unknown item type: " + item.type);
                }
            }
        }
    }

    private static class Item {
        public int type;
        public Object value;

        public Item(int n, Object object) {
            this.type = n;
            this.value = object;
        }
    }
}

