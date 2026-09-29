/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.utils;

import de.audi.app.phone.core.util.PhoneUtils;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;

public class DSIMobileEquipmentFieldNameAccess {
    private static final SimpleIntObjectMap attributeMap = PhoneUtils.getDSIAttributeFieldNames(class$org$dsi$ifc$telephoneng$DSIMobileEquipment == null ? (class$org$dsi$ifc$telephoneng$DSIMobileEquipment = DSIMobileEquipmentFieldNameAccess.class$("org.dsi.ifc.telephoneng.DSIMobileEquipment")) : class$org$dsi$ifc$telephoneng$DSIMobileEquipment);
    private static final SimpleIntObjectMap requestMap = PhoneUtils.getDSIRequestFieldNames(class$org$dsi$ifc$telephoneng$DSIMobileEquipment == null ? (class$org$dsi$ifc$telephoneng$DSIMobileEquipment = DSIMobileEquipmentFieldNameAccess.class$("org.dsi.ifc.telephoneng.DSIMobileEquipment")) : class$org$dsi$ifc$telephoneng$DSIMobileEquipment);
    private static final SimpleIntObjectMap responseMap = PhoneUtils.getDSIResponseFieldNames(class$org$dsi$ifc$telephoneng$DSIMobileEquipment == null ? (class$org$dsi$ifc$telephoneng$DSIMobileEquipment = DSIMobileEquipmentFieldNameAccess.class$("org.dsi.ifc.telephoneng.DSIMobileEquipment")) : class$org$dsi$ifc$telephoneng$DSIMobileEquipment);
    static /* synthetic */ Class class$org$dsi$ifc$telephoneng$DSIMobileEquipment;

    public static String getAttributeName(int n) {
        return (String)attributeMap.get(n);
    }

    public static String getResponseName(int n) {
        return (String)responseMap.get(n);
    }

    public static String getRequestName(int n) {
        return (String)requestMap.get(n);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

