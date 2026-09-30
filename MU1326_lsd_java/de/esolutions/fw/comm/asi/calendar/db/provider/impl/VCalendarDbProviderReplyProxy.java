/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.calendar.db.provider.impl;

import de.esolutions.fw.comm.asi.calendar.db.provider.VCalendarDbProviderReply;
import de.esolutions.fw.comm.asi.calendar.db.provider.VersionInfo;
import de.esolutions.fw.comm.asi.calendar.db.provider.impl.VersionInfoSerializer;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.calendar.impl.CalendarConfigSerializer;
import de.esolutions.fw.comm.dsi.calendar.impl.VEventSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.calendar.CalendarConfig;
import org.dsi.ifc.calendar.VEvent;

public class VCalendarDbProviderReplyProxy
implements VCalendarDbProviderReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.calendar.db.provider.VCalendarDbProvider");
    private static final int INVALID_HANDLE = -1;
    private Proxy proxy;

    public VCalendarDbProviderReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("958eeab9-87d2-470a-b62e-bd9bdd6070f6", -1, "c499e56b-0fd0-59f4-9181-c70e221b3299", "asi.calendar.db.provider.VCalendarDbProvider");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void beginTransactionResult(final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)3, iSerializable);
    }

    public void commitTransactionResult(final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)5, iSerializable);
    }

    public void addEntriesResult(final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)1, iSerializable);
    }

    public void removeEntriesResult(final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)13, iSerializable);
    }

    public void removeProfileResult(final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)15, iSerializable);
    }

    public void removeAllResult(final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)11, iSerializable);
    }

    public void getVersionResult(final VersionInfo[] versionInfoArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                VersionInfoSerializer.putOptionalVersionInfoVarArray(iSerializer, versionInfoArray);
            }
        };
        this.proxy.remoteCallMethod((short)9, iSerializable);
    }

    public void setActiveProfilesResult(final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)17, iSerializable);
    }

    public void forceGetData() throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
            }
        };
        this.proxy.remoteCallMethod((short)6, iSerializable);
    }

    public void setCalendarConfigResult(final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)30, iSerializable);
    }

    public void getCalendarConfigResult(final int n, final CalendarConfig calendarConfig) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putEnum(n);
                CalendarConfigSerializer.putOptionalCalendarConfig(iSerializer, calendarConfig);
            }
        };
        this.proxy.remoteCallMethod((short)22, iSerializable);
    }

    public void insertProfileResult(final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)28, iSerializable);
    }

    public void getCalendarEntryResult(final int n, final VEvent vEvent) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putEnum(n);
                VEventSerializer.putOptionalVEvent(iSerializer, vEvent);
            }
        };
        this.proxy.remoteCallMethod((short)24, iSerializable);
    }

    public void getCalendarSummariesResult(final int n, final VEvent[] vEventArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putEnum(n);
                VEventSerializer.putOptionalVEventVarArray(iSerializer, vEventArray);
            }
        };
        this.proxy.remoteCallMethod((short)26, iSerializable);
    }

    public void deleteProfileResult(final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)20, iSerializable);
    }
}

