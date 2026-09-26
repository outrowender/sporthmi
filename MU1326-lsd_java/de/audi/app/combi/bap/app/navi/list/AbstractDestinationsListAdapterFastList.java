/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.navi.list;

import de.audi.app.bap.fw.arrays.AbstractManagedListHandler;
import de.audi.app.bap.fw.arrays.ArrayHandler;
import de.audi.app.bap.fw.arrays.GetArrayIndication;
import de.audi.app.bap.fw.arrays.ListDelta;
import de.audi.app.combi.bap.app.navi.list.AbstractListAdapterFastListNavi;
import de.audi.atip.interapp.NavigationUtilities;
import de.audi.atip.interapp.combi.bap.data.CombiBAPArrayElement;
import de.audi.atip.interapp.combi.bap.navi.data.CombiBAPDestinationListEntry;
import de.audi.atip.interapp.combi.bap.navi.data.CombiBAPNaviDestination;
import de.audi.atip.interapp.combi.bap.navi.data.FormattedDestination;
import de.audi.atip.metrics.GeoMetric;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.kombifastlist.ArrayHeader;
import org.dsi.ifc.kombifastlist.DataAddress;

public abstract class AbstractDestinationsListAdapterFastList
extends AbstractListAdapterFastListNavi {
    private volatile boolean pushListNotification = false;
    private volatile boolean currentListSizeNotification = false;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$navi$data$CombiBAPDestinationListEntry;

    public AbstractDestinationsListAdapterFastList(ArrayHandler arrayHandler) {
        super(arrayHandler);
    }

    @Override
    public int[] getDSINotifications() {
        return new int[0];
    }

    @Override
    public boolean sendFullRangeUpdate() {
        this.sendCurrentListSize();
        this.sendCurrentList();
        return false;
    }

    private void sendCurrentListSize() {
        this.logChannel.log(-2137614336, "[AbstractDestinationsListAdapterFastList#sendCurrentListSize] called (currentListSizeNotification=%1", this.currentListSizeNotification);
        if (this.currentListSizeNotification) {
            CombiBAPArrayElement[] combiBAPArrayElementArray = ((AbstractManagedListHandler)this.listHandler).getManagedList();
            this.pushCurrentListSize(combiBAPArrayElementArray.length);
        }
    }

    protected void sendCurrentList() {
        this.logChannel.log(-2137614336, "[AbstractDestinationsListAdapterFastList#sendCurrentList] called (pushListNotification=%1)", this.pushListNotification);
        if (this.pushListNotification) {
            CombiBAPArrayElement[] combiBAPArrayElementArray = ((AbstractManagedListHandler)this.listHandler).getManagedList();
            this.pushList(this.convertList(combiBAPArrayElementArray));
        }
    }

    protected abstract void pushCurrentListSize(int n) {
    }

    protected abstract void pushList(DataAddress[] dataAddressArray) {
    }

    private DataAddress[] convertList(CombiBAPArrayElement[] combiBAPArrayElementArray) {
        DataAddress[] dataAddressArray = new DataAddress[combiBAPArrayElementArray.length];
        for (int i2 = 0; i2 < combiBAPArrayElementArray.length; ++i2) {
            dataAddressArray[i2] = this.convertArrayElement(combiBAPArrayElementArray[i2]);
        }
        return dataAddressArray;
    }

    private DataAddress convertArrayElement(CombiBAPArrayElement combiBAPArrayElement) {
        DataAddress dataAddress = new DataAddress();
        if (combiBAPArrayElement instanceof CombiBAPDestinationListEntry) {
            CombiBAPDestinationListEntry combiBAPDestinationListEntry = (CombiBAPDestinationListEntry)combiBAPArrayElement;
            dataAddress.pos = combiBAPDestinationListEntry.getPosID();
            CombiBAPNaviDestination[] combiBAPNaviDestinationArray = combiBAPDestinationListEntry.getAddressList();
            if (combiBAPNaviDestinationArray.length == 0) {
                dataAddress.poiDescription = combiBAPDestinationListEntry.getDescription();
                dataAddress.poiType = combiBAPDestinationListEntry.getPOIType();
            } else {
                if (combiBAPDestinationListEntry.hasFormattedDestination()) {
                    FormattedDestination formattedDestination = combiBAPDestinationListEntry.getFormattedDestination();
                    dataAddress.poiDescription = formattedDestination.getFirstLine();
                    dataAddress.coordinates = formattedDestination.getSecondLine();
                } else {
                    dataAddress.lastName = combiBAPNaviDestinationArray[0].getLastName();
                    dataAddress.firstName = combiBAPNaviDestinationArray[0].getFirstName();
                    dataAddress.street = combiBAPNaviDestinationArray[0].getStreet();
                    dataAddress.city = combiBAPNaviDestinationArray[0].getCity();
                    dataAddress.region = combiBAPNaviDestinationArray[0].getState();
                    dataAddress.postalCode = combiBAPNaviDestinationArray[0].getPostalCode();
                    dataAddress.country = combiBAPNaviDestinationArray[0].getCountry();
                    dataAddress.coordinates = AbstractDestinationsListAdapterFastList.getCoordinates(combiBAPNaviDestinationArray[0].getLatitude(), combiBAPNaviDestinationArray[0].getLongitude());
                    dataAddress.poiDescription = combiBAPNaviDestinationArray[0].getPOIDescription();
                }
                dataAddress.poiType = combiBAPNaviDestinationArray[0].getPOIType();
                dataAddress.addressType = combiBAPNaviDestinationArray[0].getAddressType();
            }
        } else {
            this.logChannel.log(10000, "[AbstractDestinationsListAdapterFastList#convertArrayElement] wrong dataType (expected: %1, is: %2)", (Object)(class$de$audi$atip$interapp$combi$bap$navi$data$CombiBAPDestinationListEntry == null ? (class$de$audi$atip$interapp$combi$bap$navi$data$CombiBAPDestinationListEntry = AbstractDestinationsListAdapterFastList.class$("de.audi.atip.interapp.combi.bap.navi.data.CombiBAPDestinationListEntry")) : class$de$audi$atip$interapp$combi$bap$navi$data$CombiBAPDestinationListEntry).getName(), (Object)super.getClass().getName());
        }
        return dataAddress;
    }

    private static String getCoordinates(float f2, float f3) {
        if (Float.isNaN(f2) || Float.isNaN(f3)) {
            return null;
        }
        int n = NavigationUtilities.degreeToWgs84(f2);
        int n2 = NavigationUtilities.degreeToWgs84(f3);
        GeoMetric geoMetric = new GeoMetric(n, n2);
        Buffer buffer = new Buffer();
        buffer.append(geoMetric.formatLatitude()).append(", ").append(geoMetric.formatLongitude());
        return buffer.toString();
    }

    @Override
    public boolean isSpontaneousStatusRequestSupported() {
        return true;
    }

    @Override
    public void sendStatusRequest(GetArrayIndication getArrayIndication, CombiBAPArrayElement[] combiBAPArrayElementArray) {
    }

    @Override
    public void sendChangedArrayRequest(ListDelta listDelta) {
        this.sendFullRangeUpdate();
    }

    @Override
    public void setNotificationCurrentListSizes(boolean bl) {
        this.currentListSizeNotification = bl;
        if (bl) {
            this.sendCurrentListSize();
        }
    }

    @Override
    public void addNavBookJob(int n, int n2, ArrayHeader arrayHeader) {
    }

    @Override
    public void addNavBookJobs(int n, int n2, ArrayHeader[] arrayHeaderArray) {
    }

    public boolean isPushListNotification() {
        return this.pushListNotification;
    }

    public void setPushListNotification(boolean bl) {
        this.pushListNotification = bl;
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

