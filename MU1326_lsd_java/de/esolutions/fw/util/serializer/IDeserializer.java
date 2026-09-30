/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.serializer;

import de.esolutions.fw.util.serializer.IDeserializable;
import de.esolutions.fw.util.serializer.IDeserializableArrayFactory;
import de.esolutions.fw.util.serializer.IDeserializableFactory;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.IStreamDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import java.util.List;

public interface IDeserializer
extends IStreamDeserializer {
    public String getString() throws SerializerException;

    public String getOptionalString() throws SerializerException;

    public String[] getOptionalStringVarArray() throws SerializerException;

    public int getEnum() throws SerializerException;

    public IDeserializable getObject(IDeserializableFactory var1) throws SerializerException;

    public IDeserializable getOptionalObject(IDeserializableFactory var1) throws SerializerException;

    public void getObjectArray(IDeserializableFactory var1, IDeserializable[] var2) throws SerializerException;

    public IDeserializable[] getOptionalObjectArray(IDeserializableArrayFactory var1, int var2) throws SerializerException;

    public IDeserializable[] getObjectVarArray(IDeserializableArrayFactory var1) throws SerializerException;

    public IDeserializable[] getOptionalObjectVarArray(IDeserializableArrayFactory var1) throws SerializerException;

    public List getObjectVarList(IDeserializableFactory var1) throws SerializerException;

    public List getOptionalObjectVarList(IDeserializableFactory var1) throws SerializerException;

    public boolean[] getBoolVarArray() throws SerializerException;

    public char[] getUChar16VarArray() throws SerializerException;

    public short[] getUInt8VarArray() throws SerializerException;

    public byte[] getInt8VarArray() throws SerializerException;

    public int[] getUInt16VarArray() throws SerializerException;

    public short[] getInt16VarArray() throws SerializerException;

    public long[] getUInt32VarArray() throws SerializerException;

    public int[] getInt32VarArray() throws SerializerException;

    public long[] getUInt64VarArray() throws SerializerException;

    public long[] getInt64VarArray() throws SerializerException;

    public float[] getFloatVarArray() throws SerializerException;

    public double[] getDoubleVarArray() throws SerializerException;

    public boolean[] getOptionalBoolVarArray() throws SerializerException;

    public char[] getOptionalUChar16VarArray() throws SerializerException;

    public short[] getOptionalUInt8VarArray() throws SerializerException;

    public byte[] getOptionalInt8VarArray() throws SerializerException;

    public int[] getOptionalUInt16VarArray() throws SerializerException;

    public short[] getOptionalInt16VarArray() throws SerializerException;

    public long[] getOptionalUInt32VarArray() throws SerializerException;

    public int[] getOptionalInt32VarArray() throws SerializerException;

    public long[] getOptionalUInt64VarArray() throws SerializerException;

    public long[] getOptionalInt64VarArray() throws SerializerException;

    public float[] getOptionalFloatVarArray() throws SerializerException;

    public double[] getOptionalDoubleVarArray() throws SerializerException;

    public int[] getOptionalEnumVarArray() throws SerializerException;

    public ISerializer createCompatibleSerializer();

    public IDeserializer createCompatibleDeserializer();
}

