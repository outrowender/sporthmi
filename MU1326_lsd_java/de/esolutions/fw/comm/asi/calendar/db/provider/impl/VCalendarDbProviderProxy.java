/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.calendar.db.provider.impl;

import de.esolutions.fw.comm.asi.calendar.db.provider.VCalendarDbProvider;
import de.esolutions.fw.comm.asi.calendar.db.provider.VCalendarDbProviderC;
import de.esolutions.fw.comm.asi.calendar.db.provider.VCalendarDbProviderReply;
import de.esolutions.fw.comm.asi.calendar.db.provider.impl.VCalendarDbProviderReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.calendar.impl.CalendarConfigSerializer;
import de.esolutions.fw.comm.dsi.calendar.impl.ProfileInfoSerializer;
import de.esolutions.fw.comm.dsi.calendar.impl.VCalendarSerializer;
import de.esolutions.fw.comm.dsi.global.impl.DateTimeSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.calendar.CalendarConfig;
import org.dsi.ifc.calendar.ProfileInfo;
import org.dsi.ifc.calendar.VCalendar;
import org.dsi.ifc.global.DateTime;

public class VCalendarDbProviderProxy
implements VCalendarDbProvider,
VCalendarDbProviderC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.calendar.db.provider.VCalendarDbProvider");
    private Proxy proxy;

    public VCalendarDbProviderProxy(int n, VCalendarDbProviderReply vCalendarDbProviderReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("70b84daa-4b74-4908-83c0-ef7f5a885f6e", n, "612c617b-a23f-54f8-82dd-2e34540b7597", "asi.calendar.db.provider.VCalendarDbProvider");
        VCalendarDbProviderReplyService vCalendarDbProviderReplyService = new VCalendarDbProviderReplyService(vCalendarDbProviderReply);
        this.proxy = new Proxy(serviceInstanceID, vCalendarDbProviderReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void beginTransaction() throws MethodException {
        this.proxy.remoteCallMethod((short)2, null);
    }

    public void commitTransaction() throws MethodException {
        this.proxy.remoteCallMethod((short)4, null);
    }

    public void addEntries(final int n, final int n2, final VCalendar[] vCalendarArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putInt32(n2);
                VCalendarSerializer.putOptionalVCalendarVarArray(iSerializer, vCalendarArray);
            }
        };
        this.proxy.remoteCallMethod((short)18, iSerializable);
    }

    public void removeEntries(int n, int n2, long[] lArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
            genericSerializable.putOptionalInt64VarArray(lArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)12, genericSerializable);
    }

    public void removeProfile(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)14, genericSerializable);
    }

    public void removeAll() throws MethodException {
        this.proxy.remoteCallMethod((short)10, null);
    }

    public void getVersion() throws MethodException {
        this.proxy.remoteCallMethod((short)8, null);
    }

    public void setActiveProfiles(int[] nArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)16, genericSerializable);
    }

    public void forceGetDataResult(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putEnum(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)7, genericSerializable);
    }

    public void setCalendarConfig(final CalendarConfig calendarConfig) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                CalendarConfigSerializer.putOptionalCalendarConfig(iSerializer, calendarConfig);
            }
        };
        this.proxy.remoteCallMethod((short)29, iSerializable);
    }

    public void getCalendarConfig(long l) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)21, genericSerializable);
    }

    public void insertProfile(final ProfileInfo profileInfo) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                ProfileInfoSerializer.putOptionalProfileInfo(iSerializer, profileInfo);
            }
        };
        this.proxy.remoteCallMethod((short)31, iSerializable);
    }

    public void getCalendarEntry(long l) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)23, genericSerializable);
    }

    public void getCalendarSummaries(final DateTime dateTime, final DateTime dateTime2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                DateTimeSerializer.putOptionalDateTime(iSerializer, dateTime);
                DateTimeSerializer.putOptionalDateTime(iSerializer, dateTime2);
            }
        };
        this.proxy.remoteCallMethod((short)25, iSerializable);
    }

    public void deleteProfile(long l) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)19, genericSerializable);
    }
}

