/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.media.DSIRadioTagging;
import de.esolutions.fw.comm.dsi.media.DSIRadioTaggingC;
import de.esolutions.fw.comm.dsi.media.DSIRadioTaggingReply;
import de.esolutions.fw.comm.dsi.media.impl.DSIRadioTaggingReplyService;
import de.esolutions.fw.comm.dsi.media.impl.TagInformationSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.media.TagInformation;

public class DSIRadioTaggingProxy
implements DSIRadioTagging,
DSIRadioTaggingC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.media.DSIRadioTagging");
    private Proxy proxy;

    public DSIRadioTaggingProxy(int n, DSIRadioTaggingReply dSIRadioTaggingReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("ad066dac-3241-5d34-b029-32d72a092966", n, "70f39a0c-498b-54a6-9ada-1e10bc686e8e", "dsi.media.DSIRadioTagging");
        DSIRadioTaggingReplyService dSIRadioTaggingReplyService = new DSIRadioTaggingReplyService(dSIRadioTaggingReply);
        this.proxy = new Proxy(serviceInstanceID, dSIRadioTaggingReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void tagSong(final TagInformation tagInformation) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                TagInformationSerializer.putOptionalTagInformation(iSerializer, tagInformation);
            }
        };
        this.proxy.remoteCallMethod((short)9, iSerializable);
    }

    public void tagAmbiguousSong(final TagInformation tagInformation, final TagInformation tagInformation2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                TagInformationSerializer.putOptionalTagInformation(iSerializer, tagInformation);
                TagInformationSerializer.putOptionalTagInformation(iSerializer, tagInformation2);
            }
        };
        this.proxy.remoteCallMethod((short)7, iSerializable);
    }

    public void groupTags(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)13, genericSerializable);
    }

    public void setNotification(int[] nArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)5, genericSerializable);
    }

    public void setNotification(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)6, genericSerializable);
    }

    public void setNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)4, null);
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
        this.proxy.remoteCallMethod((short)12, genericSerializable);
    }
}

