/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.speechrec.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.speechrec.DSISpeechRec;
import de.esolutions.fw.comm.dsi.speechrec.DSISpeechRecC;
import de.esolutions.fw.comm.dsi.speechrec.DSISpeechRecReply;
import de.esolutions.fw.comm.dsi.speechrec.impl.DSISpeechRecReplyService;
import de.esolutions.fw.comm.dsi.speechrec.impl.DictionaryEntrySerializer;
import de.esolutions.fw.comm.dsi.speechrec.impl.GrammarInfoSerializer;
import de.esolutions.fw.comm.dsi.speechrec.impl.GrammarSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.speechrec.DictionaryEntry;
import org.dsi.ifc.speechrec.Grammar;
import org.dsi.ifc.speechrec.GrammarInfo;

public class DSISpeechRecProxy
implements DSISpeechRec,
DSISpeechRecC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.speechrec.DSISpeechRec");
    private Proxy proxy;

    public DSISpeechRecProxy(int n, DSISpeechRecReply dSISpeechRecReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("6a6c7d2a-c4ae-54a3-9625-90dc2f44b96b", n, "86dafd61-127e-567e-a219-d4679b2a8ee6", "dsi.speechrec.DSISpeechRec");
        DSISpeechRecReplyService dSISpeechRecReplyService = new DSISpeechRecReplyService(dSISpeechRecReply);
        this.proxy = new Proxy(serviceInstanceID, dSISpeechRecReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void abort() throws MethodException {
        this.proxy.remoteCallMethod((short)0, null);
    }

    public void deleteProfile(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)38, genericSerializable);
    }

    public void deleteVoiceTag(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)5, genericSerializable);
    }

    public void enableContinuousUpdate(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)103, genericSerializable);
    }

    public void getVersion() throws MethodException {
        this.proxy.remoteCallMethod((short)6, null);
    }

    public void init() throws MethodException {
        this.proxy.remoteCallMethod((short)7, null);
    }

    public void initVoiceTag(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)8, genericSerializable);
    }

    public void loadGrammar(final Grammar[] grammarArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                GrammarSerializer.putOptionalGrammarVarArray(iSerializer, grammarArray);
            }
        };
        this.proxy.remoteCallMethod((short)39, iSerializable);
    }

    public void loadProfile(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)40, genericSerializable);
    }

    public void preloadGrammar(final Grammar[] grammarArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                GrammarSerializer.putOptionalGrammarVarArray(iSerializer, grammarArray);
            }
        };
        this.proxy.remoteCallMethod((short)41, iSerializable);
    }

    public void recordVoiceTag() throws MethodException {
        this.proxy.remoteCallMethod((short)11, null);
    }

    public void setLanguage(String string, int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)17, genericSerializable);
    }

    public void shutdown() throws MethodException {
        this.proxy.remoteCallMethod((short)28, null);
    }

    public void startRecognition(int n, int n2, int n3) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
            genericSerializable.putInt32(n3);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)120, genericSerializable);
    }

    public void unloadGrammar(final GrammarInfo[] grammarInfoArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                GrammarInfoSerializer.putOptionalGrammarInfoVarArray(iSerializer, grammarInfoArray);
            }
        };
        this.proxy.remoteCallMethod((short)34, iSerializable);
    }

    public void unloadProfile(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)42, genericSerializable);
    }

    public void unpreloadGrammar(final GrammarInfo[] grammarInfoArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                GrammarInfoSerializer.putOptionalGrammarInfoVarArray(iSerializer, grammarInfoArray);
            }
        };
        this.proxy.remoteCallMethod((short)35, iSerializable);
    }

    public void waitForResults() throws MethodException {
        this.proxy.remoteCallMethod((short)36, null);
    }

    public void setMaxCommandNBestListSize(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)18, genericSerializable);
    }

    public void setMaxSlotNBestListSize(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)19, genericSerializable);
    }

    public void setRecognitionTimeout(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)23, genericSerializable);
    }

    public void setUnambiguousResultThreshold(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)26, genericSerializable);
    }

    public void setUnambiguousResultRange(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)25, genericSerializable);
    }

    public void setFirstLevelSize(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)16, genericSerializable);
    }

    public void startPostTraining(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)30, genericSerializable);
    }

    public void stopPostTraining() throws MethodException {
        this.proxy.remoteCallMethod((short)33, null);
    }

    public void requestSDSAvailability() throws MethodException {
        this.proxy.remoteCallMethod((short)13, null);
    }

    public void setSpellingMode(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)24, genericSerializable);
    }

    public void deleteLastSpellingBlock() throws MethodException {
        this.proxy.remoteCallMethod((short)4, null);
    }

    public void startDialogue() throws MethodException {
        this.proxy.remoteCallMethod((short)29, null);
    }

    public void stopDialogue() throws MethodException {
        this.proxy.remoteCallMethod((short)32, null);
    }

    public void requestCheckDbPartition() throws MethodException {
        this.proxy.remoteCallMethod((short)104, null);
    }

    public void requestGraphemicGroupAsNBestList(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)12, genericSerializable);
    }

    public void requestVDECapabilities(String string) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)14, genericSerializable);
    }

    public void requestRestoreFactorySettings() throws MethodException {
        this.proxy.remoteCallMethod((short)43, null);
    }

    public void setDictionary(final int n, final String string, final String string2, final DictionaryEntry[] dictionaryEntryArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putOptionalString(string);
                iSerializer.putOptionalString(string2);
                DictionaryEntrySerializer.putOptionalDictionaryEntryVarArray(iSerializer, dictionaryEntryArray);
            }
        };
        this.proxy.remoteCallMethod((short)102, iSerializable);
    }

    public void setASRParameterConfiguration(int[] nArray, int[] nArray2, int[] nArray3) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
            genericSerializable.putOptionalInt32VarArray(nArray2);
            genericSerializable.putOptionalInt32VarArray(nArray3);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)110, genericSerializable);
    }

    public void deleteLastFlexVDEPart() throws MethodException {
        this.proxy.remoteCallMethod((short)114, null);
    }

    public void clearFlexVDEHistory() throws MethodException {
        this.proxy.remoteCallMethod((short)113, null);
    }

    public void setNotification(int[] nArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)21, genericSerializable);
    }

    public void setNotification(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)22, genericSerializable);
    }

    public void setNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)20, null);
    }

    public void clearNotification(int[] nArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)2, genericSerializable);
    }

    public void clearNotification(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)3, genericSerializable);
    }

    public void clearNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)1, null);
    }

    public void yySet(String string, String string2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)37, genericSerializable);
    }
}

