/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.tv;

import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.tvtuner.ServiceInfo;

public class TVStation {
    public long namePID;
    public int servicePID;
    public String name;
    public int sType;
    public int contentGroup;
    public ResourceLocator logo;

    public TVStation(ServiceInfo serviceInfo, ResourceLocator resourceLocator) {
        this.namePID = serviceInfo.namePID;
        this.servicePID = serviceInfo.servicePID;
        this.name = serviceInfo.name;
        this.sType = serviceInfo.sType;
        this.contentGroup = serviceInfo.getContentGroup();
        this.logo = resourceLocator;
    }

    public TVStation(long l, int n, String string, int n2, int n3, ResourceLocator resourceLocator) {
        this.namePID = l;
        this.servicePID = n;
        this.name = string;
        this.sType = n2;
        this.contentGroup = n3;
        this.logo = resourceLocator;
    }

    public long getNamePID() {
        return this.namePID;
    }

    public int getServicePID() {
        return this.servicePID;
    }

    public String getName() {
        return this.name;
    }

    public int getSType() {
        return this.sType;
    }

    public int getContentGroup() {
        return this.contentGroup;
    }

    public ResourceLocator getLogo() {
        return this.logo;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("ServiceInfo(namePID=");
        stringBuffer.append(this.namePID);
        stringBuffer.append(",servicePID=");
        stringBuffer.append(this.servicePID);
        stringBuffer.append(",name=\"");
        stringBuffer.append(this.name);
        stringBuffer.append("\",sType=");
        stringBuffer.append(this.sType);
        stringBuffer.append(",contentGroup=");
        stringBuffer.append(this.contentGroup);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

