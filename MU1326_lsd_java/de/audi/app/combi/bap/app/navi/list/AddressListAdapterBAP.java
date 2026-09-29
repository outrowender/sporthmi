/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.navi.list;

import de.audi.app.bap.fw.arrays.AbstractListAdapterBAP;
import de.audi.app.bap.fw.arrays.ArrayHandler;
import de.audi.app.bap.fw.arrays.GetArrayIndication;
import de.audi.app.combi.bap.fw.AbstractCombiModule;
import de.audi.app.combi.bap.fw.arrays.GetArrayIndicationAddressList;
import de.audi.atip.interapp.combi.bap.data.CombiBAPArrayElement;
import de.audi.atip.interapp.combi.bap.phone.data.CombiBAPAddressListEntry;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.generated.navsd.serializer.Address_List_ChangedArray;
import de.vw.mib.bap.generated.navsd.serializer.Address_List_Data;
import de.vw.mib.bap.generated.navsd.serializer.Address_List_StatusArray;
import de.vw.mib.bap.requests.ChangedArray;
import de.vw.mib.bap.requests.StatusArray;

public class AddressListAdapterBAP
extends AbstractListAdapterBAP {
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$phone$data$CombiBAPAddressListEntry;

    public AddressListAdapterBAP(AbstractCombiModule abstractCombiModule, ArrayHandler arrayHandler) {
        super(abstractCombiModule, 33, arrayHandler);
    }

    @Override
    protected int getCommonRecordAddress(boolean[] blArray) {
        boolean bl;
        boolean bl2;
        boolean bl3;
        boolean bl4;
        boolean bl5 = bl4 = blArray[0];
        boolean bl6 = bl4 || blArray[15];
        boolean bl7 = bl4 || blArray[3];
        boolean bl8 = bl7 || blArray[1];
        boolean bl9 = bl3 = bl8 || blArray[4];
        boolean bl10 = bl3;
        boolean bl11 = bl2 = bl3 || blArray[6];
        boolean bl12 = bl = bl7 || blArray[5];
        return CombiBAPAddressListEntry.getRecordAddress(bl6, bl4, bl5, bl2, bl11, bl7, bl3, bl8, bl9, bl, bl12, bl10);
    }

    @Override
    protected BAPArrayElement convertArrayElement(CombiBAPArrayElement combiBAPArrayElement, ArrayHeader arrayHeader) {
        Address_List_Data address_List_Data = new Address_List_Data(arrayHeader);
        if (combiBAPArrayElement instanceof CombiBAPAddressListEntry) {
            CombiBAPAddressListEntry combiBAPAddressListEntry = (CombiBAPAddressListEntry)combiBAPArrayElement;
            address_List_Data.setPos(combiBAPAddressListEntry.getPosID());
            address_List_Data.lastName.setContent(combiBAPAddressListEntry.getLastName());
            address_List_Data.firstName.setContent(combiBAPAddressListEntry.getFirstName());
            address_List_Data.street.setContent(combiBAPAddressListEntry.getStreet());
            address_List_Data.city.setContent(combiBAPAddressListEntry.getCity());
            address_List_Data.region.setContent(combiBAPAddressListEntry.getRegion());
            address_List_Data.postalCode.setContent(combiBAPAddressListEntry.getPostalCode());
            address_List_Data.country.setContent(combiBAPAddressListEntry.getCountry());
            address_List_Data.coordinates.setContent(combiBAPAddressListEntry.getCoordinates());
            address_List_Data.poi_Description.setContent(combiBAPAddressListEntry.getPOIDescription());
            address_List_Data.poi_Type = combiBAPAddressListEntry.getPOIType();
            address_List_Data.address_Type = combiBAPAddressListEntry.getAddressType();
        } else {
            this.logChannel.log(10000, "[AddressListAdapterBAP#convertArrayElement] wrong dataType (expected: %1, is: %2)", (Object)(class$de$audi$atip$interapp$combi$bap$phone$data$CombiBAPAddressListEntry == null ? (class$de$audi$atip$interapp$combi$bap$phone$data$CombiBAPAddressListEntry = AddressListAdapterBAP.class$("de.audi.atip.interapp.combi.bap.phone.data.CombiBAPAddressListEntry")) : class$de$audi$atip$interapp$combi$bap$phone$data$CombiBAPAddressListEntry).getName(), (Object)super.getClass().getName());
        }
        return address_List_Data;
    }

    @Override
    protected BAPArrayElement createArrayElement(ArrayHeader arrayHeader, int n) {
        Address_List_Data address_List_Data = new Address_List_Data(arrayHeader);
        address_List_Data.setPos(n);
        return address_List_Data;
    }

    @Override
    protected ChangedArray createChangedArraySerializer() {
        return new Address_List_ChangedArray();
    }

    @Override
    protected StatusArray createStatusArraySerializer() {
        return new Address_List_StatusArray();
    }

    @Override
    protected void sendStatusRequest(GetArrayIndication getArrayIndication, CombiBAPArrayElement[] combiBAPArrayElementArray, StatusArray statusArray) {
        Address_List_StatusArray address_List_StatusArray = (Address_List_StatusArray)statusArray;
        address_List_StatusArray.otherListType = ((GetArrayIndicationAddressList)getArrayIndication).getOtherListType();
        address_List_StatusArray.otherList_Reference = ((GetArrayIndicationAddressList)getArrayIndication).getOtherListReference();
        super.sendStatusRequest(getArrayIndication, combiBAPArrayElementArray, address_List_StatusArray);
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

