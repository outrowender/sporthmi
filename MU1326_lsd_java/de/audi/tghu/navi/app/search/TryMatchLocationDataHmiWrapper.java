/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.search;

import de.audi.atip.log.LogChannel;
import java.lang.reflect.Field;
import java.util.Arrays;
import org.dsi.ifc.navigation.NavPhoneData;
import org.dsi.ifc.navigation.TryMatchLocationData;

public class TryMatchLocationDataHmiWrapper {
    private static final int TML_DATA_FIELD_COUNT;
    private final TryMatchLocationData tmlData;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$TryMatchLocationData;

    public TryMatchLocationDataHmiWrapper(TryMatchLocationData tryMatchLocationData) {
        this.tmlData = tryMatchLocationData;
    }

    public static void checkIfDSIHasChanged(LogChannel logChannel) {
        Field[] fieldArray = (class$org$dsi$ifc$navigation$TryMatchLocationData == null ? (class$org$dsi$ifc$navigation$TryMatchLocationData = TryMatchLocationDataHmiWrapper.class$("org.dsi.ifc.navigation.TryMatchLocationData")) : class$org$dsi$ifc$navigation$TryMatchLocationData).getFields();
        if (fieldArray.length != 16) {
            logChannel.log(10000, "TryMatchLocationDataHmiWrapper#checkIfDSIHasChanged() ", (Throwable)new Exception("The DSI class has been extended with additional fields. HashCode() and Equals() need to be updated."));
        }
    }

    private static int hashCode(NavPhoneData[] navPhoneDataArray) {
        int n = 31;
        if (navPhoneDataArray == null) {
            return 0;
        }
        int n2 = 1;
        for (int i2 = 0; i2 < navPhoneDataArray.length; ++i2) {
            NavPhoneData navPhoneData = navPhoneDataArray[i2];
            if (navPhoneData == null) {
                n2 = n * n2;
                continue;
            }
            n2 = n * n2 + navPhoneData.number.hashCode();
            n2 = n * n2 + navPhoneData.numberType;
        }
        return n2;
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.tmlData.country == null ? 0 : this.tmlData.country.hashCode());
        n = 31 * n + (this.tmlData.dbVersion == null ? 0 : this.tmlData.dbVersion.hashCode());
        n = 31 * n + (this.tmlData.houseNumber == null ? 0 : this.tmlData.houseNumber.hashCode());
        n = 31 * n + (this.tmlData.junction == null ? 0 : this.tmlData.junction.hashCode());
        n = 31 * n + this.tmlData.latitude;
        n = 31 * n + this.tmlData.longitude;
        n = 31 * n + this.tmlData.origin;
        n = 31 * n + TryMatchLocationDataHmiWrapper.hashCode(this.tmlData.phoneNumbers);
        n = 31 * n + this.tmlData.poiCategory;
        n = 31 * n + (this.tmlData.poiName == null ? 0 : this.tmlData.poiName.hashCode());
        n = 31 * n + (this.tmlData.postalCode == null ? 0 : this.tmlData.postalCode.hashCode());
        n = 31 * n + (this.tmlData.state == null ? 0 : this.tmlData.state.hashCode());
        n = 31 * n + (this.tmlData.street == null ? 0 : this.tmlData.street.hashCode());
        n = 31 * n + (this.tmlData.town == null ? 0 : this.tmlData.town.hashCode());
        n = 31 * n + (this.tmlData.townPart == null ? 0 : this.tmlData.townPart.hashCode());
        n = 31 * n + (this.tmlData.unstructured == null ? 0 : this.tmlData.unstructured.hashCode());
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        TryMatchLocationDataHmiWrapper tryMatchLocationDataHmiWrapper = (TryMatchLocationDataHmiWrapper)object;
        if (this.tmlData.country == null ? tryMatchLocationDataHmiWrapper.tmlData.country != null : !this.tmlData.country.equals(tryMatchLocationDataHmiWrapper.tmlData.country)) {
            return false;
        }
        if (this.tmlData.dbVersion == null ? tryMatchLocationDataHmiWrapper.tmlData.dbVersion != null : !this.tmlData.dbVersion.equals(tryMatchLocationDataHmiWrapper.tmlData.dbVersion)) {
            return false;
        }
        if (this.tmlData.houseNumber == null ? tryMatchLocationDataHmiWrapper.tmlData.houseNumber != null : !this.tmlData.houseNumber.equals(tryMatchLocationDataHmiWrapper.tmlData.houseNumber)) {
            return false;
        }
        if (this.tmlData.junction == null ? tryMatchLocationDataHmiWrapper.tmlData.junction != null : !this.tmlData.junction.equals(tryMatchLocationDataHmiWrapper.tmlData.junction)) {
            return false;
        }
        if (this.tmlData.latitude != tryMatchLocationDataHmiWrapper.tmlData.latitude) {
            return false;
        }
        if (this.tmlData.longitude != tryMatchLocationDataHmiWrapper.tmlData.longitude) {
            return false;
        }
        if (this.tmlData.origin != tryMatchLocationDataHmiWrapper.tmlData.origin) {
            return false;
        }
        if (!Arrays.equals(this.tmlData.phoneNumbers, tryMatchLocationDataHmiWrapper.tmlData.phoneNumbers)) {
            return false;
        }
        if (this.tmlData.poiCategory != tryMatchLocationDataHmiWrapper.tmlData.poiCategory) {
            return false;
        }
        if (this.tmlData.poiName == null ? tryMatchLocationDataHmiWrapper.tmlData.poiName != null : !this.tmlData.poiName.equals(tryMatchLocationDataHmiWrapper.tmlData.poiName)) {
            return false;
        }
        if (this.tmlData.postalCode == null ? tryMatchLocationDataHmiWrapper.tmlData.postalCode != null : !this.tmlData.postalCode.equals(tryMatchLocationDataHmiWrapper.tmlData.postalCode)) {
            return false;
        }
        if (this.tmlData.state == null ? tryMatchLocationDataHmiWrapper.tmlData.state != null : !this.tmlData.state.equals(tryMatchLocationDataHmiWrapper.tmlData.state)) {
            return false;
        }
        if (this.tmlData.street == null ? tryMatchLocationDataHmiWrapper.tmlData.street != null : !this.tmlData.street.equals(tryMatchLocationDataHmiWrapper.tmlData.street)) {
            return false;
        }
        if (this.tmlData.town == null ? tryMatchLocationDataHmiWrapper.tmlData.town != null : !this.tmlData.town.equals(tryMatchLocationDataHmiWrapper.tmlData.town)) {
            return false;
        }
        if (this.tmlData.townPart == null ? tryMatchLocationDataHmiWrapper.tmlData.townPart != null : !this.tmlData.townPart.equals(tryMatchLocationDataHmiWrapper.tmlData.townPart)) {
            return false;
        }
        return !(this.tmlData.unstructured == null ? tryMatchLocationDataHmiWrapper.tmlData.unstructured != null : !this.tmlData.unstructured.equals(tryMatchLocationDataHmiWrapper.tmlData.unstructured));
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

