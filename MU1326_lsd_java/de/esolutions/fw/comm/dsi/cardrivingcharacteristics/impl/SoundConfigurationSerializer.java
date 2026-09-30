/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl;

import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl.SoundAvailableStylesSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.cardrivingcharacteristics.SoundAvailableStyles;
import org.dsi.ifc.cardrivingcharacteristics.SoundConfiguration;

public class SoundConfigurationSerializer {
    public static void putOptionalSoundConfiguration(ISerializer iSerializer, SoundConfiguration soundConfiguration) throws SerializerException {
        boolean bl = soundConfiguration == null;
        iSerializer.putBool(bl);
        if (!bl) {
            SoundAvailableStyles soundAvailableStyles = soundConfiguration.getAvailableSoundStyles();
            SoundAvailableStylesSerializer.putOptionalSoundAvailableStyles(iSerializer, soundAvailableStyles);
        }
    }

    public static void putOptionalSoundConfigurationVarArray(ISerializer iSerializer, SoundConfiguration[] soundConfigurationArray) throws SerializerException {
        boolean bl = soundConfigurationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(soundConfigurationArray.length);
            for (int i2 = 0; i2 < soundConfigurationArray.length; ++i2) {
                SoundConfigurationSerializer.putOptionalSoundConfiguration(iSerializer, soundConfigurationArray[i2]);
            }
        }
    }

    public static SoundConfiguration getOptionalSoundConfiguration(IDeserializer iDeserializer) throws SerializerException {
        SoundConfiguration soundConfiguration = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            SoundAvailableStyles soundAvailableStyles;
            soundConfiguration = new SoundConfiguration();
            soundConfiguration.availableSoundStyles = soundAvailableStyles = SoundAvailableStylesSerializer.getOptionalSoundAvailableStyles(iDeserializer);
        }
        return soundConfiguration;
    }

    public static SoundConfiguration[] getOptionalSoundConfigurationVarArray(IDeserializer iDeserializer) throws SerializerException {
        SoundConfiguration[] soundConfigurationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            soundConfigurationArray = new SoundConfiguration[n];
            for (int i2 = 0; i2 < n; ++i2) {
                soundConfigurationArray[i2] = SoundConfigurationSerializer.getOptionalSoundConfiguration(iDeserializer);
            }
        }
        return soundConfigurationArray;
    }
}

