/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.storage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.tvtuner.LogoInfo;
import org.dsi.ifc.tvtuner.ServiceInfo;

final class ServiceStoreHelper {
    static void serializeServices(ServiceInfo serviceInfo, DataOutputStream dataOutputStream) {
        dataOutputStream.writeLong(serviceInfo.namePID);
        dataOutputStream.writeInt(serviceInfo.servicePID);
        dataOutputStream.writeInt(serviceInfo.sType);
        dataOutputStream.writeInt(serviceInfo.contentGroup);
        dataOutputStream.writeUTF(serviceInfo.name);
    }

    static ServiceInfo deserializeServices(DataInputStream dataInputStream) {
        ServiceInfo serviceInfo = new ServiceInfo();
        serviceInfo.namePID = dataInputStream.readLong();
        serviceInfo.servicePID = dataInputStream.readInt();
        serviceInfo.sType = dataInputStream.readInt();
        serviceInfo.contentGroup = dataInputStream.readInt();
        serviceInfo.name = dataInputStream.readUTF();
        return serviceInfo;
    }

    static void serializeLogo(LogoInfo logoInfo, DataOutputStream dataOutputStream) {
        dataOutputStream.writeLong(logoInfo.namePID);
        if (logoInfo.channelLogo != null) {
            dataOutputStream.writeInt(logoInfo.channelLogo.id);
            dataOutputStream.writeUTF(logoInfo.channelLogo.url);
        } else {
            dataOutputStream.writeInt(-1);
            dataOutputStream.writeUTF("");
        }
    }

    static LogoInfo deserializeLogo(DataInputStream dataInputStream) {
        LogoInfo logoInfo = new LogoInfo();
        logoInfo.namePID = dataInputStream.readLong();
        ResourceLocator resourceLocator = new ResourceLocator();
        resourceLocator.id = dataInputStream.readInt();
        resourceLocator.url = dataInputStream.readUTF();
        logoInfo.channelLogo = resourceLocator;
        return logoInfo;
    }

    private ServiceStoreHelper() {
    }
}

