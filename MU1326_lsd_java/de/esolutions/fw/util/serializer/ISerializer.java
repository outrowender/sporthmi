/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.serializer;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.IStreamSerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import java.util.List;

public interface ISerializer
extends IStreamSerializer {
    public void putString(String var1) throws SerializerException;

    public void putOptionalString(String var1) throws SerializerException;

    public void putEnum(int var1) throws SerializerException;

    public void putObject(ISerializable var1) throws SerializerException;

    public void putOptionalObject(ISerializable var1) throws SerializerException;

    public void putObjectArray(ISerializable[] var1) throws SerializerException;

    public void putOptionalObjectArray(ISerializable[] var1) throws SerializerException;

    public void putObjectVarArray(ISerializable[] var1) throws SerializerException;

    public void putOptionalObjectVarArray(ISerializable[] var1) throws SerializerException;

    public void putList(List var1) throws SerializerException;

    public void putOptionalList(List var1) throws SerializerException;

    public void putStringArray(String[] var1) throws SerializerException;

    public void putOptionalStringVarArray(String[] var1) throws SerializerException;

    public void putBoolVarArray(boolean[] var1) throws SerializerException;

    public void putUInt8VarArray(short[] var1) throws SerializerException;

    public void putInt8VarArray(byte[] var1) throws SerializerException;

    public void putUChar16VarArray(char[] var1) throws SerializerException;

    public void putUInt16VarArray(int[] var1) throws SerializerException;

    public void putInt16VarArray(short[] var1) throws SerializerException;

    public void putUInt32VarArray(long[] var1) throws SerializerException;

    public void putInt32VarArray(int[] var1) throws SerializerException;

    public void putUInt64VarArray(long[] var1) throws SerializerException;

    public void putInt64VarArray(long[] var1) throws SerializerException;

    public void putFloatVarArray(float[] var1) throws SerializerException;

    public void putDoubleVarArray(double[] var1) throws SerializerException;

    public void putOptionalBoolVarArray(boolean[] var1) throws SerializerException;

    public void putOptionalUInt8VarArray(short[] var1) throws SerializerException;

    public void putOptionalInt8VarArray(byte[] var1) throws SerializerException;

    public void putOptionalUChar16VarArray(char[] var1) throws SerializerException;

    public void putOptionalUInt16VarArray(int[] var1) throws SerializerException;

    public void putOptionalInt16VarArray(short[] var1) throws SerializerException;

    public void putOptionalUInt32VarArray(long[] var1) throws SerializerException;

    public void putOptionalInt32VarArray(int[] var1) throws SerializerException;

    public void putOptionalUInt64VarArray(long[] var1) throws SerializerException;

    public void putOptionalInt64VarArray(long[] var1) throws SerializerException;

    public void putOptionalFloatVarArray(float[] var1) throws SerializerException;

    public void putOptionalDoubleVarArray(double[] var1) throws SerializerException;

    public void putOptionalEnumVarArray(int[] var1) throws SerializerException;

    public ISerializer createCompatibleSerializer();

    public IDeserializer createCompatibleDeserializer();
}

