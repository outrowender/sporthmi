/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.suppservices;

import org.dsi.ifc.telephoneng.ServiceCodeTypeStruct;
import org.dsi.ifc.telephoneng.SuppServiceResponseStruct;

public interface ITelDialSuppServiceHandler {
    default public void updateServiceCodeType(ServiceCodeTypeStruct serviceCodeTypeStruct, int n) {
    }

    default public void responseDialNumber(int n, SuppServiceResponseStruct suppServiceResponseStruct) {
    }
}

