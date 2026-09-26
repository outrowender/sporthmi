/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.online.coreservice.impl;

import de.esolutions.fw.comm.asi.online.coreservice.ServiceListEntry;
import de.esolutions.fw.comm.dsi.online.impl.OSRLicenseSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.online.OSRLicense;

public class ServiceListEntrySerializer {
    public static void putOptionalServiceListEntry(ISerializer iSerializer, ServiceListEntry serviceListEntry) {
        boolean bl = serviceListEntry == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = serviceListEntry.getServiceId();
            iSerializer.putOptionalString(string);
            String string2 = serviceListEntry.getVersion();
            iSerializer.putOptionalString(string2);
            String string3 = serviceListEntry.getUrl();
            iSerializer.putOptionalString(string3);
            String string4 = serviceListEntry.getScope();
            iSerializer.putOptionalString(string4);
            OSRLicense[] oSRLicenseArray = serviceListEntry.getLicenses();
            OSRLicenseSerializer.putOptionalOSRLicenseVarArray(iSerializer, oSRLicenseArray);
            boolean bl2 = serviceListEntry.isIsEnabled();
            iSerializer.putBool(bl2);
        }
    }

    public static void putOptionalServiceListEntryVarArray(ISerializer iSerializer, ServiceListEntry[] serviceListEntryArray) {
        boolean bl = serviceListEntryArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(serviceListEntryArray.length);
            for (int i2 = 0; i2 < serviceListEntryArray.length; ++i2) {
                ServiceListEntrySerializer.putOptionalServiceListEntry(iSerializer, serviceListEntryArray[i2]);
            }
        }
    }

    public static ServiceListEntry getOptionalServiceListEntry(IDeserializer iDeserializer) {
        ServiceListEntry serviceListEntry = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            String string;
            String string2;
            String string3;
            String string4;
            serviceListEntry = new ServiceListEntry();
            serviceListEntry.serviceId = string4 = iDeserializer.getOptionalString();
            serviceListEntry.version = string3 = iDeserializer.getOptionalString();
            serviceListEntry.url = string2 = iDeserializer.getOptionalString();
            serviceListEntry.scope = string = iDeserializer.getOptionalString();
            OSRLicense[] oSRLicenseArray = OSRLicenseSerializer.getOptionalOSRLicenseVarArray(iDeserializer);
            serviceListEntry.licenses = oSRLicenseArray;
            serviceListEntry.isEnabled = bl2 = iDeserializer.getBool();
        }
        return serviceListEntry;
    }

    public static ServiceListEntry[] getOptionalServiceListEntryVarArray(IDeserializer iDeserializer) {
        ServiceListEntry[] serviceListEntryArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            serviceListEntryArray = new ServiceListEntry[n];
            for (int i2 = 0; i2 < n; ++i2) {
                serviceListEntryArray[i2] = ServiceListEntrySerializer.getOptionalServiceListEntry(iDeserializer);
            }
        }
        return serviceListEntryArray;
    }
}

