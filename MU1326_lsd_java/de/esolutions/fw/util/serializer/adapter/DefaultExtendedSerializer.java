/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.serializer.adapter;

import de.esolutions.fw.util.commons.StringConverter;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.IStreamSerializer;
import de.esolutions.fw.util.serializer.adapter.DefaultExtendedDeserializer;
import de.esolutions.fw.util.serializer.adapter.StreamSerializerProxy;
import de.esolutions.fw.util.serializer.adapter.StringEncodings;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.ListIterator;

public class DefaultExtendedSerializer
extends StreamSerializerProxy
implements ISerializer {
    protected int stringEncoding;

    public DefaultExtendedSerializer(IStreamSerializer iStreamSerializer) {
        super(iStreamSerializer);
        this.stringEncoding = 0;
    }

    public DefaultExtendedSerializer(IStreamSerializer iStreamSerializer, int n) {
        super(iStreamSerializer);
        this.stringEncoding = n;
    }

    public void setStringEncoding(int n) {
        if (n >= 0 && n < 3) {
            this.stringEncoding = n;
        }
    }

    public int stringEncoding() {
        return this.stringEncoding;
    }

    public void putOptionalFlag(boolean bl) throws SerializerException {
        this.serializer.putInt8(bl ? (byte)0 : -1);
    }

    public void putString(String string) throws SerializerException {
        try {
            StringConverter stringConverter = StringEncodings.getConverter(this.stringEncoding);
            if (stringConverter == null) {
                throw new SerializerException("No converter found");
            }
            byte[] byArray = stringConverter.getBytes(string);
            int n = byArray.length / StringEncodings.byteWidth[this.stringEncoding];
            if (n > Short.MAX_VALUE) {
                throw new SerializerException("String too long: " + n);
            }
            this.serializer.putInt8((byte)this.stringEncoding);
            this.serializer.putInt16((short)n);
            this.serializer.putInt8Array(byArray);
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
            this.serializer.putInt32(stringArray.length);
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                this.putOptionalString(stringArray[i2]);
            }
        }
    }

    public void putEnum(int n) throws SerializerException {
        this.serializer.putInt32(n);
    }

    public void putObject(ISerializable iSerializable) throws SerializerException {
        iSerializable.serialize(this);
    }

    public void putOptionalObject(ISerializable iSerializable) throws SerializerException {
        this.putOptionalFlag(iSerializable != null);
        if (iSerializable != null) {
            iSerializable.serialize(this);
        }
    }

    public void putObjectArray(ISerializable[] iSerializableArray) throws SerializerException {
        for (int i2 = 0; i2 < iSerializableArray.length; ++i2) {
            ISerializable iSerializable = iSerializableArray[i2];
            this.putOptionalFlag(iSerializable != null);
            if (iSerializable == null) continue;
            iSerializable.serialize(this);
        }
    }

    public void putOptionalObjectArray(ISerializable[] iSerializableArray) throws SerializerException {
        this.putOptionalFlag(iSerializableArray != null);
        if (iSerializableArray != null) {
            for (int i2 = 0; i2 < iSerializableArray.length; ++i2) {
                ISerializable iSerializable = iSerializableArray[i2];
                this.putOptionalFlag(iSerializable != null);
                if (iSerializable == null) continue;
                iSerializable.serialize(this);
            }
        }
    }

    public void putObjectVarArray(ISerializable[] iSerializableArray) throws SerializerException {
        this.serializer.putInt32(iSerializableArray.length);
        for (int i2 = 0; i2 < iSerializableArray.length; ++i2) {
            ISerializable iSerializable = iSerializableArray[i2];
            this.putOptionalFlag(iSerializable != null);
            if (iSerializable == null) continue;
            iSerializable.serialize(this);
        }
    }

    public void putOptionalObjectVarArray(ISerializable[] iSerializableArray) throws SerializerException {
        this.putOptionalFlag(iSerializableArray != null);
        if (iSerializableArray != null) {
            this.serializer.putInt32(iSerializableArray.length);
            for (int i2 = 0; i2 < iSerializableArray.length; ++i2) {
                ISerializable iSerializable = iSerializableArray[i2];
                this.putOptionalFlag(iSerializable != null);
                if (iSerializable == null) continue;
                iSerializable.serialize(this);
            }
        }
    }

    public void putList(List list) throws SerializerException {
        this.serializer.putInt32(list.size());
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            ISerializable iSerializable = (ISerializable)listIterator.next();
            this.putOptionalFlag(iSerializable != null);
            if (iSerializable == null) continue;
            iSerializable.serialize(this);
        }
    }

    public void putOptionalList(List list) throws SerializerException {
        this.putOptionalFlag(list != null);
        if (list != null) {
            this.serializer.putInt32(list.size());
            ListIterator listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                ISerializable iSerializable = (ISerializable)listIterator.next();
                this.putOptionalFlag(iSerializable != null);
                if (iSerializable == null) continue;
                iSerializable.serialize(this);
            }
        }
    }

    public void putStringArray(String[] stringArray) throws SerializerException, SerializerException {
        this.serializer.putUInt32(stringArray.length);
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            this.putString(stringArray[i2]);
        }
    }

    public void putBoolVarArray(boolean[] blArray) throws SerializerException {
        this.serializer.putUInt32(blArray.length);
        this.serializer.putBoolArray(blArray);
    }

    public void putUInt8VarArray(short[] sArray) throws SerializerException {
        this.serializer.putUInt32(sArray.length);
        this.serializer.putUInt8Array(sArray);
    }

    public void putInt8VarArray(byte[] byArray) throws SerializerException {
        this.serializer.putUInt32(byArray.length);
        this.serializer.putInt8Array(byArray);
    }

    public void putUInt16VarArray(int[] nArray) throws SerializerException {
        this.serializer.putUInt32(nArray.length);
        this.serializer.putUInt16Array(nArray);
    }

    public void putInt16VarArray(short[] sArray) throws SerializerException {
        this.serializer.putUInt32(sArray.length);
        this.serializer.putInt16Array(sArray);
    }

    public void putUChar16VarArray(char[] cArray) throws SerializerException {
        this.serializer.putUInt32(cArray.length);
        this.serializer.putUChar16Array(cArray);
    }

    public void putUInt32VarArray(long[] lArray) throws SerializerException {
        this.serializer.putUInt32(lArray.length);
        this.serializer.putUInt32Array(lArray);
    }

    public void putInt32VarArray(int[] nArray) throws SerializerException {
        this.serializer.putUInt32(nArray.length);
        this.serializer.putInt32Array(nArray);
    }

    public void putUInt64VarArray(long[] lArray) throws SerializerException {
        this.serializer.putUInt32(lArray.length);
        this.serializer.putUInt64Array(lArray);
    }

    public void putInt64VarArray(long[] lArray) throws SerializerException {
        this.serializer.putUInt32(lArray.length);
        this.serializer.putInt64Array(lArray);
    }

    public void putFloatVarArray(float[] fArray) throws SerializerException {
        this.serializer.putUInt32(fArray.length);
        this.serializer.putFloatArray(fArray);
    }

    public void putDoubleVarArray(double[] dArray) throws SerializerException {
        this.serializer.putUInt32(dArray.length);
        this.serializer.putDoubleArray(dArray);
    }

    public void putOptionalBoolVarArray(boolean[] blArray) throws SerializerException {
        boolean bl = blArray == null;
        this.serializer.putBool(bl);
        if (!bl) {
            this.putBoolVarArray(blArray);
        }
    }

    public void putOptionalDoubleVarArray(double[] dArray) throws SerializerException {
        boolean bl = dArray == null;
        this.serializer.putBool(bl);
        if (!bl) {
            this.putDoubleVarArray(dArray);
        }
    }

    public void putOptionalFloatVarArray(float[] fArray) throws SerializerException {
        boolean bl = fArray == null;
        this.serializer.putBool(bl);
        if (!bl) {
            this.putFloatVarArray(fArray);
        }
    }

    public void putOptionalInt16VarArray(short[] sArray) throws SerializerException {
        boolean bl = sArray == null;
        this.serializer.putBool(bl);
        if (!bl) {
            this.putInt16VarArray(sArray);
        }
    }

    public void putOptionalUChar16VarArray(char[] cArray) throws SerializerException {
        boolean bl = cArray == null;
        this.serializer.putBool(bl);
        if (!bl) {
            this.putUChar16VarArray(cArray);
        }
    }

    public void putOptionalInt32VarArray(int[] nArray) throws SerializerException {
        boolean bl = nArray == null;
        this.serializer.putBool(bl);
        if (!bl) {
            this.putInt32VarArray(nArray);
        }
    }

    public void putOptionalInt64VarArray(long[] lArray) throws SerializerException {
        boolean bl = lArray == null;
        this.serializer.putBool(bl);
        if (!bl) {
            this.putInt64VarArray(lArray);
        }
    }

    public void putOptionalInt8VarArray(byte[] byArray) throws SerializerException {
        boolean bl = byArray == null;
        this.serializer.putBool(bl);
        if (!bl) {
            this.putInt8VarArray(byArray);
        }
    }

    public void putOptionalUInt16VarArray(int[] nArray) throws SerializerException {
        boolean bl = nArray == null;
        this.serializer.putBool(bl);
        if (!bl) {
            this.putUInt16VarArray(nArray);
        }
    }

    public void putOptionalUInt32VarArray(long[] lArray) throws SerializerException {
        boolean bl = lArray == null;
        this.serializer.putBool(bl);
        if (!bl) {
            this.putUInt32VarArray(lArray);
        }
    }

    public void putOptionalUInt64VarArray(long[] lArray) throws SerializerException {
        boolean bl = lArray == null;
        this.serializer.putBool(bl);
        if (!bl) {
            this.putUInt64VarArray(lArray);
        }
    }

    public void putOptionalUInt8VarArray(short[] sArray) throws SerializerException {
        boolean bl = sArray == null;
        this.serializer.putBool(bl);
        if (!bl) {
            this.putUInt8VarArray(sArray);
        }
    }

    public void putOptionalEnumVarArray(int[] nArray) throws SerializerException {
        boolean bl = nArray == null;
        this.serializer.putBool(bl);
        if (!bl) {
            this.putInt32VarArray(nArray);
        }
    }

    public ISerializer createCompatibleSerializer() {
        return new DefaultExtendedSerializer(this.serializer.createCompatibleStreamSerializer());
    }

    public IDeserializer createCompatibleDeserializer() {
        return new DefaultExtendedDeserializer(this.serializer.createCompatibleStreamDeserializer());
    }
}

