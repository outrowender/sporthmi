/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.serializer.adapter;

import de.esolutions.fw.util.commons.StringConverter;
import de.esolutions.fw.util.serializer.IDeserializable;
import de.esolutions.fw.util.serializer.IDeserializableArrayFactory;
import de.esolutions.fw.util.serializer.IDeserializableFactory;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.IStreamDeserializer;
import de.esolutions.fw.util.serializer.adapter.DefaultExtendedSerializer;
import de.esolutions.fw.util.serializer.adapter.StreamDeserializerProxy;
import de.esolutions.fw.util.serializer.adapter.StringEncodings;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Vector;

public class DefaultExtendedDeserializer
extends StreamDeserializerProxy
implements IDeserializer {
    public DefaultExtendedDeserializer(IStreamDeserializer iStreamDeserializer) {
        super(iStreamDeserializer);
        this.deserializer = iStreamDeserializer;
    }

    public Object clone() {
        return new DefaultExtendedDeserializer((IStreamDeserializer)this.deserializer.clone());
    }

    public String getString() throws SerializerException {
        byte by = this.deserializer.getInt8();
        if (by < 0 || by >= 3) {
            throw new SerializerException("Invalid String Encoding");
        }
        int n = this.deserializer.getUInt16();
        if (n < 0 || n > Short.MAX_VALUE) {
            throw new SerializerException("String has invalid length: " + n);
        }
        int n2 = n * StringEncodings.byteWidth[by];
        byte[] byArray = new byte[n2];
        this.deserializer.getInt8Array(byArray);
        try {
            StringConverter stringConverter = StringEncodings.getConverter(by);
            if (stringConverter == null) {
                throw new SerializerException("No converter found");
            }
            return stringConverter.getString(byArray);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new SerializerException("Unsupported Encoding");
        }
    }

    public String getOptionalString() throws SerializerException {
        boolean bl = this.getOptionalFlag();
        if (bl) {
            return this.getString();
        }
        return null;
    }

    public String[] getStringVarArray() throws SerializerException {
        int n = this.deserializer.getInt32();
        String[] stringArray = new String[n];
        for (int i2 = 0; i2 < n; ++i2) {
            boolean bl = this.getOptionalFlag();
            if (!bl) continue;
            stringArray[i2] = this.getString();
        }
        return stringArray;
    }

    public String[] getOptionalStringVarArray() throws SerializerException {
        boolean bl = this.getOptionalFlag();
        if (bl) {
            return this.getStringVarArray();
        }
        return null;
    }

    public int getEnum() throws SerializerException {
        return this.deserializer.getInt32();
    }

    public boolean getOptionalFlag() throws SerializerException {
        return this.deserializer.getInt8() == 0;
    }

    public IDeserializable getObject(IDeserializableFactory iDeserializableFactory) throws SerializerException {
        IDeserializable iDeserializable = iDeserializableFactory.createDeserializable(this);
        return iDeserializable;
    }

    public IDeserializable getOptionalObject(IDeserializableFactory iDeserializableFactory) throws SerializerException {
        boolean bl = this.getOptionalFlag();
        if (bl) {
            IDeserializable iDeserializable = iDeserializableFactory.createDeserializable(this);
            return iDeserializable;
        }
        return null;
    }

    public void getObjectArray(IDeserializableFactory iDeserializableFactory, IDeserializable[] iDeserializableArray) throws SerializerException {
        for (int i2 = 0; i2 < iDeserializableArray.length; ++i2) {
            IDeserializable iDeserializable;
            boolean bl = this.getOptionalFlag();
            if (!bl) continue;
            iDeserializableArray[i2] = iDeserializable = iDeserializableFactory.createDeserializable(this);
        }
    }

    public IDeserializable[] getOptionalObjectArray(IDeserializableArrayFactory iDeserializableArrayFactory, int n) throws SerializerException {
        boolean bl = this.getOptionalFlag();
        if (bl) {
            IDeserializable[] iDeserializableArray = iDeserializableArrayFactory.createDeserializableArray(n);
            for (int i2 = 0; i2 < n; ++i2) {
                IDeserializable iDeserializable;
                boolean bl2 = this.getOptionalFlag();
                if (!bl2) continue;
                iDeserializableArray[i2] = iDeserializable = iDeserializableArrayFactory.createDeserializable(this);
            }
            return iDeserializableArray;
        }
        return null;
    }

    public IDeserializable[] getObjectVarArray(IDeserializableArrayFactory iDeserializableArrayFactory) throws SerializerException {
        int n = this.deserializer.getInt32();
        IDeserializable[] iDeserializableArray = iDeserializableArrayFactory.createDeserializableArray(n);
        for (int i2 = 0; i2 < n; ++i2) {
            IDeserializable iDeserializable;
            boolean bl = this.getOptionalFlag();
            if (!bl) continue;
            iDeserializableArray[i2] = iDeserializable = iDeserializableArrayFactory.createDeserializable(this);
        }
        return iDeserializableArray;
    }

    public IDeserializable[] getOptionalObjectVarArray(IDeserializableArrayFactory iDeserializableArrayFactory) throws SerializerException {
        boolean bl = this.getOptionalFlag();
        if (bl) {
            int n = this.deserializer.getInt32();
            IDeserializable[] iDeserializableArray = iDeserializableArrayFactory.createDeserializableArray(n);
            for (int i2 = 0; i2 < n; ++i2) {
                IDeserializable iDeserializable;
                boolean bl2 = this.getOptionalFlag();
                if (!bl2) continue;
                iDeserializableArray[i2] = iDeserializable = iDeserializableArrayFactory.createDeserializable(this);
            }
            return iDeserializableArray;
        }
        return null;
    }

    public List getObjectVarList(IDeserializableFactory iDeserializableFactory) throws SerializerException {
        int n = this.deserializer.getInt32();
        Vector vector = new Vector(n);
        for (int i2 = 0; i2 < n; ++i2) {
            boolean bl = this.getOptionalFlag();
            if (!bl) continue;
            IDeserializable iDeserializable = iDeserializableFactory.createDeserializable(this);
            vector.add(iDeserializable);
        }
        return vector;
    }

    public List getOptionalObjectVarList(IDeserializableFactory iDeserializableFactory) throws SerializerException {
        boolean bl = this.getOptionalFlag();
        if (bl) {
            int n = this.deserializer.getInt32();
            Vector vector = new Vector(n);
            for (int i2 = 0; i2 < n; ++i2) {
                boolean bl2 = this.getOptionalFlag();
                if (!bl2) continue;
                IDeserializable iDeserializable = iDeserializableFactory.createDeserializable(this);
                vector.add(iDeserializable);
            }
            return vector;
        }
        return null;
    }

    public boolean[] getBoolVarArray() throws SerializerException {
        long l = this.deserializer.getUInt32();
        boolean[] blArray = new boolean[(int)l];
        this.getBoolArray(blArray);
        return blArray;
    }

    public short[] getUInt8VarArray() throws SerializerException {
        long l = this.deserializer.getUInt32();
        short[] sArray = new short[(int)l];
        this.getUInt8Array(sArray);
        return sArray;
    }

    public byte[] getInt8VarArray() throws SerializerException {
        long l = this.deserializer.getUInt32();
        byte[] byArray = new byte[(int)l];
        this.getInt8Array(byArray);
        return byArray;
    }

    public int[] getUInt16VarArray() throws SerializerException {
        long l = this.deserializer.getUInt32();
        int[] nArray = new int[(int)l];
        this.getUInt16Array(nArray);
        return nArray;
    }

    public short[] getInt16VarArray() throws SerializerException {
        long l = this.deserializer.getUInt32();
        short[] sArray = new short[(int)l];
        this.getInt16Array(sArray);
        return sArray;
    }

    public char[] getUChar16VarArray() throws SerializerException {
        long l = this.deserializer.getUInt32();
        char[] cArray = new char[(int)l];
        this.getUChar16Array(cArray);
        return cArray;
    }

    public long[] getUInt32VarArray() throws SerializerException {
        long l = this.deserializer.getUInt32();
        long[] lArray = new long[(int)l];
        this.getUInt32Array(lArray);
        return lArray;
    }

    public int[] getInt32VarArray() throws SerializerException {
        long l = this.deserializer.getUInt32();
        int[] nArray = new int[(int)l];
        this.getInt32Array(nArray);
        return nArray;
    }

    public long[] getUInt64VarArray() throws SerializerException {
        long l = this.deserializer.getUInt32();
        long[] lArray = new long[(int)l];
        this.getUInt64Array(lArray);
        return lArray;
    }

    public long[] getInt64VarArray() throws SerializerException {
        long l = this.deserializer.getUInt32();
        long[] lArray = new long[(int)l];
        this.getInt64Array(lArray);
        return lArray;
    }

    public float[] getFloatVarArray() throws SerializerException {
        long l = this.deserializer.getUInt32();
        float[] fArray = new float[(int)l];
        this.getFloatArray(fArray);
        return fArray;
    }

    public double[] getDoubleVarArray() throws SerializerException {
        long l = this.deserializer.getUInt32();
        double[] dArray = new double[(int)l];
        this.getDoubleArray(dArray);
        return dArray;
    }

    public boolean[] getOptionalBoolVarArray() throws SerializerException {
        boolean[] blArray = null;
        boolean bl = this.deserializer.getBool();
        if (!bl) {
            blArray = this.getBoolVarArray();
        }
        return blArray;
    }

    public double[] getOptionalDoubleVarArray() throws SerializerException {
        double[] dArray = null;
        boolean bl = this.deserializer.getBool();
        if (!bl) {
            dArray = this.getDoubleVarArray();
        }
        return dArray;
    }

    public float[] getOptionalFloatVarArray() throws SerializerException {
        float[] fArray = null;
        boolean bl = this.deserializer.getBool();
        if (!bl) {
            fArray = this.getFloatVarArray();
        }
        return fArray;
    }

    public short[] getOptionalInt16VarArray() throws SerializerException {
        short[] sArray = null;
        boolean bl = this.deserializer.getBool();
        if (!bl) {
            sArray = this.getInt16VarArray();
        }
        return sArray;
    }

    public char[] getOptionalUChar16VarArray() throws SerializerException {
        char[] cArray = null;
        boolean bl = this.deserializer.getBool();
        if (!bl) {
            cArray = this.getUChar16VarArray();
        }
        return cArray;
    }

    public int[] getOptionalInt32VarArray() throws SerializerException {
        int[] nArray = null;
        boolean bl = this.deserializer.getBool();
        if (!bl) {
            nArray = this.getInt32VarArray();
        }
        return nArray;
    }

    public long[] getOptionalInt64VarArray() throws SerializerException {
        long[] lArray = null;
        boolean bl = this.deserializer.getBool();
        if (!bl) {
            lArray = this.getInt64VarArray();
        }
        return lArray;
    }

    public byte[] getOptionalInt8VarArray() throws SerializerException {
        byte[] byArray = null;
        boolean bl = this.deserializer.getBool();
        if (!bl) {
            byArray = this.getInt8VarArray();
        }
        return byArray;
    }

    public int[] getOptionalUInt16VarArray() throws SerializerException {
        int[] nArray = null;
        boolean bl = this.deserializer.getBool();
        if (!bl) {
            nArray = this.getUInt16VarArray();
        }
        return nArray;
    }

    public long[] getOptionalUInt32VarArray() throws SerializerException {
        long[] lArray = null;
        boolean bl = this.deserializer.getBool();
        if (!bl) {
            lArray = this.getUInt32VarArray();
        }
        return lArray;
    }

    public long[] getOptionalUInt64VarArray() throws SerializerException {
        long[] lArray = null;
        boolean bl = this.deserializer.getBool();
        if (!bl) {
            lArray = this.getUInt64VarArray();
        }
        return lArray;
    }

    public short[] getOptionalUInt8VarArray() throws SerializerException {
        short[] sArray = null;
        boolean bl = this.deserializer.getBool();
        if (!bl) {
            sArray = this.getUInt8VarArray();
        }
        return sArray;
    }

    public int[] getOptionalEnumVarArray() throws SerializerException {
        int[] nArray = null;
        boolean bl = this.deserializer.getBool();
        if (!bl) {
            nArray = this.getInt32VarArray();
        }
        return nArray;
    }

    public ISerializer createCompatibleSerializer() {
        return new DefaultExtendedSerializer(this.deserializer.createCompatibleStreamSerializer());
    }

    public IDeserializer createCompatibleDeserializer() {
        return new DefaultExtendedDeserializer(this.deserializer.createCompatibleStreamDeserializer());
    }
}

