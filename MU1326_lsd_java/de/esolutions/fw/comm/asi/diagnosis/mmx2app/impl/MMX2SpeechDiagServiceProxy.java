/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sClientResponseErrorSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2SpeechDiagService;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2SpeechDiagServiceC;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2SpeechDiagServiceReply;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2SpeechDiagServiceReplyService;
import de.esolutions.fw.comm.asi.diagnosis.navigation.impl.sNavCountryRegionVersionSerializer;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sNavCountryRegionVersion;
import de.esolutions.fw.comm.asi.diagnosis.speech.impl.sCommandSDSSerializer;
import de.esolutions.fw.comm.asi.diagnosis.speech.sCommandSDS;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.tts.impl.LanguageVoiceInfoSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.tts.LanguageVoiceInfo;

public class MMX2SpeechDiagServiceProxy
implements MMX2SpeechDiagService,
MMX2SpeechDiagServiceC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.diagnosis.mmx2app.MMX2SpeechDiagService");
    private Proxy proxy;

    public MMX2SpeechDiagServiceProxy(int n, MMX2SpeechDiagServiceReply mMX2SpeechDiagServiceReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("1afa0c22-bc63-4208-9611-a0303fb2f206", n, "c3528b6d-ac3d-5343-a985-6176b647a3b5", "asi.diagnosis.mmx2app.MMX2SpeechDiagService");
        MMX2SpeechDiagServiceReplyService mMX2SpeechDiagServiceReplyService = new MMX2SpeechDiagServiceReplyService(mMX2SpeechDiagServiceReply);
        this.proxy = new Proxy(serviceInstanceID, mMX2SpeechDiagServiceReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void responseErrorSpeech(final sClientResponseError sClientResponseError2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sClientResponseErrorSerializer.putOptionalsClientResponseError(iSerializer, sClientResponseError2);
            }
        };
        this.proxy.remoteCallMethod((short)15, iSerializable);
    }

    public void responseCommandSDS(final sCommandSDS sCommandSDS2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sCommandSDSSerializer.putOptionalsCommandSDS(iSerializer, sCommandSDS2);
            }
        };
        this.proxy.remoteCallMethod((short)2, iSerializable);
    }

    public void responseCountryRegionVersion(final sNavCountryRegionVersion sNavCountryRegionVersion2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sNavCountryRegionVersionSerializer.putOptionalsNavCountryRegionVersion(iSerializer, sNavCountryRegionVersion2);
            }
        };
        this.proxy.remoteCallMethod((short)13, iSerializable);
    }

    public void updateAvailableLanguages(final LanguageVoiceInfo[] languageVoiceInfoArray, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                LanguageVoiceInfoSerializer.putOptionalLanguageVoiceInfoVarArray(iSerializer, languageVoiceInfoArray);
                iSerializer.putInt32(n);
            }
        };
        this.proxy.remoteCallMethod((short)14, iSerializable);
    }
}

