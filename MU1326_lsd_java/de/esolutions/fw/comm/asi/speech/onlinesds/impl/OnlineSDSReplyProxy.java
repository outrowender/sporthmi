/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.speech.onlinesds.impl;

import de.esolutions.fw.comm.asi.speech.onlinesds.AudioData;
import de.esolutions.fw.comm.asi.speech.onlinesds.LanguageInfo;
import de.esolutions.fw.comm.asi.speech.onlinesds.OnlineSDSReply;
import de.esolutions.fw.comm.asi.speech.onlinesds.impl.AudioDataSerializer;
import de.esolutions.fw.comm.asi.speech.onlinesds.impl.LanguageInfoSerializer;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class OnlineSDSReplyProxy
implements OnlineSDSReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.speech.onlinesds.OnlineSDS");
    private static final int INVALID_HANDLE = -1;
    private Proxy proxy;

    public OnlineSDSReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("8a66769b-5812-4288-95b1-6ebd66230a2d", -1, "05e2991f-3978-5b4f-8580-84236c6e9c67", "asi.speech.onlinesds.OnlineSDS");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void setLanguage(final LanguageInfo languageInfo) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                LanguageInfoSerializer.putOptionalLanguageInfo(iSerializer, languageInfo);
            }
        };
        this.proxy.remoteCallMethod((short)20, iSerializable);
    }

    public void speechDataUpdate(final int n, final int n2, final AudioData audioData) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putUInt16(n);
                iSerializer.putEnum(n2);
                AudioDataSerializer.putOptionalAudioData(iSerializer, audioData);
            }
        };
        this.proxy.remoteCallMethod((short)21, iSerializable);
    }

    public void cancel(final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putUInt16(n);
            }
        };
        this.proxy.remoteCallMethod((short)16, iSerializable);
    }
}

