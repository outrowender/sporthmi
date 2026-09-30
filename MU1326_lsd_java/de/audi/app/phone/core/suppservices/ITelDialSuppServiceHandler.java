/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.suppservices;

import org.dsi.ifc.telephoneng.ServiceCodeTypeStruct;
import org.dsi.ifc.telephoneng.SuppServiceResponseStruct;

public interface ITelDialSuppServiceHandler {
    public void updateServiceCodeType(ServiceCodeTypeStruct var1, int var2);

    public void responseDialNumber(int var1, SuppServiceResponseStruct var2);
}

