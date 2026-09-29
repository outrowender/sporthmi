/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.sound.impl;

import de.esolutions.fw.comm.asi.hmisync.sound.SoundShapeValue;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class SoundShapeValueSerializer {
    public static void putOptionalSoundShapeValue(ISerializer iSerializer, SoundShapeValue soundShapeValue) {
        boolean bl = soundShapeValue == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = soundShapeValue.getX();
            iSerializer.putInt32(n);
            int n2 = soundShapeValue.getY();
            iSerializer.putInt32(n2);
            int n3 = soundShapeValue.getZ();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalSoundShapeValueVarArray(ISerializer iSerializer, SoundShapeValue[] soundShapeValueArray) {
        boolean bl = soundShapeValueArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(soundShapeValueArray.length);
            for (int i2 = 0; i2 < soundShapeValueArray.length; ++i2) {
                SoundShapeValueSerializer.putOptionalSoundShapeValue(iSerializer, soundShapeValueArray[i2]);
            }
        }
    }

    public static SoundShapeValue getOptionalSoundShapeValue(IDeserializer iDeserializer) {
        SoundShapeValue soundShapeValue = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            soundShapeValue = new SoundShapeValue();
            soundShapeValue.x = n3 = iDeserializer.getInt32();
            soundShapeValue.y = n2 = iDeserializer.getInt32();
            soundShapeValue.z = n = iDeserializer.getInt32();
        }
        return soundShapeValue;
    }

    public static SoundShapeValue[] getOptionalSoundShapeValueVarArray(IDeserializer iDeserializer) {
        SoundShapeValue[] soundShapeValueArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            soundShapeValueArray = new SoundShapeValue[n];
            for (int i2 = 0; i2 < n; ++i2) {
                soundShapeValueArray[i2] = SoundShapeValueSerializer.getOptionalSoundShapeValue(iDeserializer);
            }
        }
        return soundShapeValueArray;
    }
}

