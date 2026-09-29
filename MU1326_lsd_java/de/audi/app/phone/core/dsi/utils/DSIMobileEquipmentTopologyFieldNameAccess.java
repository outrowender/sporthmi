/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.utils;

import de.audi.app.phone.core.util.PhoneUtils;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;

public class DSIMobileEquipmentTopologyFieldNameAccess {
    private static final SimpleIntObjectMap attributeMap = PhoneUtils.getDSIAttributeFieldNames(class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopology == null ? (class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopology = DSIMobileEquipmentTopologyFieldNameAccess.class$("org.dsi.ifc.telephoneng.DSIMobileEquipmentTopology")) : class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopology);
    private static final SimpleIntObjectMap requestMap = PhoneUtils.getDSIRequestFieldNames(class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopology == null ? (class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopology = DSIMobileEquipmentTopologyFieldNameAccess.class$("org.dsi.ifc.telephoneng.DSIMobileEquipmentTopology")) : class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopology);
    private static final SimpleIntObjectMap responseMap = PhoneUtils.getDSIResponseFieldNames(class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopology == null ? (class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopology = DSIMobileEquipmentTopologyFieldNameAccess.class$("org.dsi.ifc.telephoneng.DSIMobileEquipmentTopology")) : class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopology);
    static /* synthetic */ Class class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopology;

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

