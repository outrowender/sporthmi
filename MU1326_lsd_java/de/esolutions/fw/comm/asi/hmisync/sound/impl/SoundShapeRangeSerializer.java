/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.sound.impl;

import de.esolutions.fw.comm.asi.hmisync.sound.SoundShapeRange;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class SoundShapeRangeSerializer {
    public static void putOptionalSoundShapeRange(ISerializer iSerializer, SoundShapeRange soundShapeRange) {
        boolean bl = soundShapeRange == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = soundShapeRange.getMinXRange();
            iSerializer.putInt32(n);
            int n2 = soundShapeRange.getMinYRange();
            iSerializer.putInt32(n2);
            int n3 = soundShapeRange.getMinZRange();
            iSerializer.putInt32(n3);
            int n4 = soundShapeRange.getMaxXRange();
            iSerializer.putInt32(n4);
            int n5 = soundShapeRange.getMaxYRange();
            iSerializer.putInt32(n5);
            int n6 = soundShapeRange.getMaxZRange();
            iSerializer.putInt32(n6);
        }
    }

    public static void putOptionalSoundShapeRangeVarArray(ISerializer iSerializer, SoundShapeRange[] soundShapeRangeArray) {
        boolean bl = soundShapeRangeArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(soundShapeRangeArray.length);
            for (int i2 = 0; i2 < soundShapeRangeArray.length; ++i2) {
                SoundShapeRangeSerializer.putOptionalSoundShapeRange(iSerializer, soundShapeRangeArray[i2]);
            }
        }
    }

    public static SoundShapeRange getOptionalSoundShapeRange(IDeserializer iDeserializer) {
        SoundShapeRange soundShapeRange = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            soundShapeRange = new SoundShapeRange();
            soundShapeRange.minXRange = n6 = iDeserializer.getInt32();
            soundShapeRange.minYRange = n5 = iDeserializer.getInt32();
            soundShapeRange.minZRange = n4 = iDeserializer.getInt32();
            soundShapeRange.maxXRange = n3 = iDeserializer.getInt32();
            soundShapeRange.maxYRange = n2 = iDeserializer.getInt32();
            soundShapeRange.maxZRange = n = iDeserializer.getInt32();
        }
        return soundShapeRange;
    }

    public static SoundShapeRange[] getOptionalSoundShapeRangeVarArray(IDeserializer iDeserializer) {
        SoundShapeRange[] soundShapeRangeArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            soundShapeRangeArray = new SoundShapeRange[n];
            for (int i2 = 0; i2 < n; ++i2) {
                soundShapeRangeArray[i2] = SoundShapeRangeSerializer.getOptionalSoundShapeRange(iDeserializer);
            }
        }
        return soundShapeRangeArray;
    }
}

