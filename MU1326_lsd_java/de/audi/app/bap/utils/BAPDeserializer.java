/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.utils;

import de.audi.app.bap.fw.indication.BAPIndicationData;
import de.audi.app.bap.utils.FunctionIDs;
import de.audi.app.bap.utils.LSGIDs;
import de.audi.atip.log.LogChannel;
import de.vw.mib.bap.stream.BitStreamSerializer;
import de.vw.mib.bap.stream.BitStreamTransformer;
import java.nio.BufferUnderflowException;

public final class BAPDeserializer {
    public static final int DESERIALIZATION_RESULT_SUCCESSFUL;
    public static final int DESERIALIZATION_RESULT_INVALID_SERIALIZER;
    public static final int DESERIALIZATION_RESULT_WRONG_PARAMETER_FORMAT;
    public static final int DESERIALIZATION_RESULT_INVALID_PARAMETERIZATION;
    public static final int DESERIALIZATION_RESULT_NO_DESERIALIZATION_REQUIRED;

    public static int deserializeData(LogChannel logChannel, LogChannel logChannel2, int n, int n2, BitStreamSerializer bitStreamSerializer, BAPIndicationData bAPIndicationData) {
        int n3;
        String string = LSGIDs.getDescription(n);
        String string2 = FunctionIDs.getDescription(n, n2);
        logChannel.log(14808325, "[BAPDeserializer#deserializeData] start deserialization: lsgID=%1, fctID=%2", (Object)string, (Object)string2);
        BitStreamTransformer bitStreamTransformer = new BitStreamTransformer();
        try {
            if (bitStreamSerializer != null) {
                int n4 = bAPIndicationData.getParameterType();
                if (n4 == 0) {
                    logChannel.log(14808325, "[BAPDeserializer#deserializeData] serializerClass=%1, dataParameterType=%3, data=%2", (Object)super.getClass(), (Object)bAPIndicationData.getDataByteArray(), (long)n4);
                    bitStreamTransformer.fromInteger(bitStreamSerializer, bAPIndicationData.getDataInt(), BAPDeserializer.determineBitsize(bitStreamSerializer, bAPIndicationData));
                } else if (n4 == 1) {
                    logChannel.log(14808325, "[BAPDeserializer#deserializeData] serializerClass=%1, dataParameterType=%3, data=%2", (Object)super.getClass(), (Object)bAPIndicationData.getDataByteArray(), (long)n4);
                    bitStreamTransformer.fromArray(bitStreamSerializer, bAPIndicationData.getDataByteArray());
                }
                logChannel.log(14808325, "[BAPDeserializer#deserializeData] deserialization successful: lsgID=%1, fctID=%2", (Object)string, (Object)string2);
                logChannel2.log(14808325, "[BAPDeserializer#deserializeData] deserialization successful: lsgID=%2, fctID=%3, data=%1", (Object)bitStreamSerializer, (Object)string, (Object)string2);
                n3 = 0;
            } else {
                logChannel.log(10000, "[BAPDeserializer#deserializeData] serializer is null: lsgID=%1, fctID=%2", (Object)string, (Object)string2);
                n3 = 1;
            }
        }
        catch (BufferUnderflowException bufferUnderflowException) {
            logChannel.log(10000, "[BAPDeserializer#deserializeData] wrong parameter format: lsgID=%1, fctID=%2", (Object)string, (Object)string2);
            n3 = 2;
        }
        return n3;
    }

    private static int determineBitsize(BitStreamSerializer bitStreamSerializer, BAPIndicationData bAPIndicationData) {
        if (bitStreamSerializer.bitSize() != 0) {
            return bitStreamSerializer.bitSize();
        }
        return BAPDeserializer.getBitstreamTransformerDatatype(bAPIndicationData.getDataType());
    }

    private static int getBitstreamTransformerDatatype(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 8;
                break;
            }
            case 1: {
                n2 = 16;
                break;
            }
            case 2: {
                n2 = 32;
                break;
            }
            default: {
                n2 = 32;
            }
        }
        return n2;
    }
}

