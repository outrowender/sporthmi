/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.navi.list;

import de.audi.app.bap.fw.arrays.AbstractManagedListHandler;
import de.audi.app.bap.fw.arrays.ArrayHandler;
import de.audi.app.bap.fw.arrays.GetArrayIndication;
import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodFSG;
import de.audi.app.combi.bap.fw.AbstractCombiModule;
import de.audi.app.combi.bap.fw.arrays.GetArrayIndicationAddressList;
import de.audi.atip.interapp.combi.bap.data.CombiBAPArrayElement;
import de.audi.atip.interapp.combi.bap.navi.data.CombiBAPDestinationListEntry;
import de.audi.atip.interapp.combi.bap.navi.data.CombiBAPNaviDestination;
import de.audi.atip.interapp.combi.bap.phone.data.CombiBAPAddressListEntry;
import de.vw.mib.bap.generated.navsd.serializer.GetNextListPos_Result;

public class AddressListArrayHandler
extends AbstractManagedListHandler {
    private CombiBAPArrayElement[] homeAddressList = null;

    public AddressListArrayHandler(AbstractCombiModule abstractCombiModule) {
        super(abstractCombiModule, "AddressListArrayHandler");
    }

    public void updateList(CombiBAPArrayElement[] combiBAPArrayElementArray) {
        if (combiBAPArrayElementArray == null) {
            this.logChannel.log(10000, "[%1#updateList] invalid list update: newList is null", (Object)this.className);
            return;
        }
        this.logChannel.log(10000000, "[%1#updateList] listSize=%2", (Object)this.className, (long)combiBAPArrayElementArray.length);
        this.list = combiBAPArrayElementArray;
    }

    public void updateHomeAddress(CombiBAPNaviDestination combiBAPNaviDestination) {
        this.homeAddressList = null == combiBAPNaviDestination ? new CombiBAPArrayElement[0] : AddressListArrayHandler.createDataArray(new CombiBAPNaviDestination[]{combiBAPNaviDestination});
    }

    private void sendHomeAddress(GetArrayIndicationAddressList getArrayIndicationAddressList) {
        if (this.homeAddressList != null && this.homeAddressList.length != 0) {
            this.logChannel.log(1000000, "[%1#requestListElements] send home address destination", (Object)this.className);
            this.updateList(this.homeAddressList);
            this.responseListElements(getArrayIndicationAddressList.getTaID(), this.homeAddressList);
        } else {
            this.logChannel.log(100000, "[%1#requestListElements] home address destination is not set", (Object)this.className);
            this.sendEmptyList();
        }
    }

    public void requestListElements(GetArrayIndication getArrayIndication) {
        this.logChannel.log(10000000, "[%1#requestListElements] called", (Object)this.className);
        this.setPendingRequest(getArrayIndication);
        if (getArrayIndication instanceof GetArrayIndicationAddressList) {
            int n = ((GetArrayIndicationAddressList)getArrayIndication).getOtherListType();
            switch (n) {
                case 0: {
                    this.sendList(29, (GetArrayIndicationAddressList)getArrayIndication);
                    break;
                }
                case 1: {
                    this.sendList(30, (GetArrayIndicationAddressList)getArrayIndication);
                    break;
                }
                case 2: 
                case 3: 
                case 4: {
                    this.sendHomeAddress((GetArrayIndicationAddressList)getArrayIndication);
                    break;
                }
                default: {
                    this.logChannel.log(10000, "[%1#requestListElements] list type not supported: %2", (Object)this.className, (long)n);
                    this.sendEmptyList();
                    break;
                }
            }
        } else {
            this.logChannel.log(10000, "[%1#requestListElements] invalid indication - must be of type GetArrayRequestAddressList", (Object)this.className);
            this.sendEmptyList();
        }
    }

    public void responseListElements(int n, CombiBAPArrayElement[] combiBAPArrayElementArray) {
        super.responseListElements(n, combiBAPArrayElementArray);
    }

    private void sendList(int n, GetArrayIndicationAddressList getArrayIndicationAddressList) {
        ArrayHandler arrayHandler = this.moduleFsg.getBAPFunctionArrayFSG(n).getArrayHandler();
        CombiBAPDestinationListEntry combiBAPDestinationListEntry = (CombiBAPDestinationListEntry)arrayHandler.getArrayElement(getArrayIndicationAddressList.getOtherListReference());
        if (combiBAPDestinationListEntry != null) {
            this.updateList(AddressListArrayHandler.createDataArray(combiBAPDestinationListEntry.getAddressList()));
            super.requestListElements(getArrayIndicationAddressList);
        } else {
            this.logChannel.log(10000, "[%1#requestListElements] element with listReference=%2 not found in list with listType=%3", (Object)this.className, (long)getArrayIndicationAddressList.getOtherListReference(), (long)getArrayIndicationAddressList.getOtherListType());
            this.sendEmptyList();
        }
    }

    private static CombiBAPAddressListEntry[] createDataArray(CombiBAPNaviDestination[] combiBAPNaviDestinationArray) {
        CombiBAPAddressListEntry[] combiBAPAddressListEntryArray = new CombiBAPAddressListEntry[combiBAPNaviDestinationArray.length];
        for (int i2 = 0; i2 < combiBAPNaviDestinationArray.length; ++i2) {
            combiBAPAddressListEntryArray[i2] = new CombiBAPAddressListEntry(i2 + 1, combiBAPNaviDestinationArray[i2]);
        }
        return combiBAPAddressListEntryArray;
    }

    public void getNextListPos(int n, int n2) {
        super.getNextListPosForArbitraryIds(n, n2);
    }

    public void getNextListPosResult(boolean bl, int n, int n2, int n3) {
        this.logChannel.log(10000000, "[%1#getNextListPosResult] called (result=%2, currentEntryID=%3,...)", (Object)this.className, (Object)(bl ? "successful" : "unsuccessful"), (long)n);
        this.logChannel.log(10000000, "[%1#getNextListPosResult] ..., nextEntryID=%2, absoluteListPos=%3", (Object)this.className, (long)n2, (long)n3);
        BAPFunctionMethodFSG bAPFunctionMethodFSG = this.moduleFsg.getBAPFunctionMethodFSG(41);
        GetNextListPos_Result getNextListPos_Result = (GetNextListPos_Result)this.moduleFsg.createResultSerializer(41);
        getNextListPos_Result.getNextListPos_Result = bl ? 0 : 1;
        getNextListPos_Result.currentPos = n;
        getNextListPos_Result.nextPos = n2;
        getNextListPos_Result.absoluteListPos = n3;
        bAPFunctionMethodFSG.resultREQ(getNextListPos_Result);
    }
}

