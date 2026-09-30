/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radiodata.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.comm.dsi.radiodata.DSIRadioData;
import de.esolutions.fw.comm.dsi.radiodata.DSIRadioDataC;
import de.esolutions.fw.comm.dsi.radiodata.DSIRadioDataReply;
import de.esolutions.fw.comm.dsi.radiodata.impl.DSIRadioDataReplyService;
import de.esolutions.fw.comm.dsi.radiodata.impl.RadioStationDataRequestSerializer;
import de.esolutions.fw.comm.dsi.radiodata.impl.RadioStationDataSerializer;
import de.esolutions.fw.comm.dsi.radiodata.impl.RadioStationLogoRequestSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radiodata.RadioStationData;
import org.dsi.ifc.radiodata.RadioStationDataRequest;
import org.dsi.ifc.radiodata.RadioStationLogoRequest;

public class DSIRadioDataProxy
implements DSIRadioData,
DSIRadioDataC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.radiodata.DSIRadioData");
    private Proxy proxy;

    public DSIRadioDataProxy(int n, DSIRadioDataReply dSIRadioDataReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("4ed4ac19-0c6c-5830-a2bc-a1134fa4522a", n, "11df929b-d035-513f-a3d3-7c4eced78564", "dsi.radiodata.DSIRadioData");
        DSIRadioDataReplyService dSIRadioDataReplyService = new DSIRadioDataReplyService(dSIRadioDataReply);
        this.proxy = new Proxy(serviceInstanceID, dSIRadioDataReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void requestRadioStationData(final RadioStationDataRequest[] radioStationDataRequestArray, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                RadioStationDataRequestSerializer.putOptionalRadioStationDataRequestVarArray(iSerializer, radioStationDataRequestArray);
                iSerializer.putInt32(n);
            }
        };
        this.proxy.remoteCallMethod((short)10, iSerializable);
    }

    public void requestRadioStationLogos(final RadioStationLogoRequest[] radioStationLogoRequestArray, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                RadioStationLogoRequestSerializer.putOptionalRadioStationLogoRequestVarArray(iSerializer, radioStationLogoRequestArray);
                iSerializer.putInt32(n);
            }
        };
        this.proxy.remoteCallMethod((short)11, iSerializable);
    }

    public void requestDynamicDatabaseAlteration(final RadioStationData radioStationData, final ResourceLocator resourceLocator, final int n, final int n2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                RadioStationDataSerializer.putOptionalRadioStationData(iSerializer, radioStationData);
                ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, resourceLocator);
                iSerializer.putInt32(n);
                iSerializer.putInt32(n2);
            }
        };
        this.proxy.remoteCallMethod((short)8, iSerializable);
    }

    public void requestCountryListUpdate(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)4, genericSerializable);
    }

    public void requestDatabaseVersionInfo(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)7, genericSerializable);
    }

    public void requestPersistStationLogos(final RadioStationData[] radioStationDataArray, final ResourceLocator[] resourceLocatorArray, final int n, final int n2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                RadioStationDataSerializer.putOptionalRadioStationDataVarArray(iSerializer, radioStationDataArray);
                ResourceLocatorSerializer.putOptionalResourceLocatorVarArray(iSerializer, resourceLocatorArray);
                iSerializer.putInt32(n);
                iSerializer.putInt32(n2);
            }
        };
        this.proxy.remoteCallMethod((short)9, iSerializable);
    }

    public void requestCountryRegionData(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)5, genericSerializable);
    }

    public void requestCountryRegionTranslationData(int n, String string, int n2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putOptionalString(string);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)6, genericSerializable);
    }

    public void profileChange(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)29, genericSerializable);
    }

    public void profileCopy(int n, int n2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)32, genericSerializable);
    }

    public void profileReset(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)33, genericSerializable);
    }

    public void profileResetAll() throws MethodException {
        this.proxy.remoteCallMethod((short)35, null);
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
        this.proxy.remoteCallMethod((short)26, genericSerializable);
    }
}

