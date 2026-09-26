/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio.list;

import de.audi.app.bap.fw.arrays.AbstractListAdapterBAP;
import de.audi.app.bap.fw.arrays.GetArrayIndication;
import de.audi.app.combi.bap.app.audio.list.ReceptionListHandler;
import de.audi.app.combi.bap.fw.AbstractCombiModule;
import de.audi.app.combi.bap.fw.arrays.GetArrayIndicationReceptionList;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPReceptionListEntry;
import de.audi.atip.interapp.combi.bap.data.CombiBAPArrayElement;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.generated.audiosd.serializer.ReceptionList_ChangedArray;
import de.vw.mib.bap.generated.audiosd.serializer.ReceptionList_Data;
import de.vw.mib.bap.generated.audiosd.serializer.ReceptionList_StatusArray;
import de.vw.mib.bap.requests.ChangedArray;
import de.vw.mib.bap.requests.StatusArray;

public class ReceptionListAdapterBAP
extends AbstractListAdapterBAP {
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$audio$data$CombiBAPReceptionListEntry;

    public ReceptionListAdapterBAP(AbstractCombiModule abstractCombiModule, ReceptionListHandler receptionListHandler) {
        super(abstractCombiModule, 23, receptionListHandler);
    }

    @Override
    protected void sendStatusRequest(GetArrayIndication getArrayIndication, CombiBAPArrayElement[] combiBAPArrayElementArray, StatusArray statusArray) {
        ReceptionList_StatusArray receptionList_StatusArray = (ReceptionList_StatusArray)statusArray;
        receptionList_StatusArray.elementType = ((GetArrayIndicationReceptionList)getArrayIndication).getElementType();
        receptionList_StatusArray.parent_Id = ((GetArrayIndicationReceptionList)getArrayIndication).getParentID();
        super.sendStatusRequest(getArrayIndication, combiBAPArrayElementArray, receptionList_StatusArray);
    }

    @Override
    protected int getCommonRecordAddress(boolean[] blArray) {
        boolean bl = blArray[0] || blArray[15];
        boolean bl2 = blArray[0] || blArray[1] || blArray[2] || blArray[6];
        boolean bl3 = blArray[0] || blArray[1] || blArray[2] || blArray[6];
        boolean bl4 = blArray[0] || blArray[1] || blArray[3];
        boolean bl5 = blArray[0] || blArray[1] || blArray[3];
        boolean bl6 = blArray[0] || blArray[1] || blArray[3] || blArray[6];
        boolean bl7 = blArray[0] || blArray[1] || blArray[3] || blArray[4] || blArray[6];
        boolean bl8 = blArray[0] || blArray[5];
        return CombiBAPReceptionListEntry.getRecordAddress(bl, bl2, bl3, bl4, bl5, bl6, bl7, bl8);
    }

    @Override
    protected BAPArrayElement convertArrayElement(CombiBAPArrayElement combiBAPArrayElement, ArrayHeader arrayHeader) {
        ReceptionList_Data receptionList_Data = new ReceptionList_Data(arrayHeader);
        if (combiBAPArrayElement instanceof CombiBAPReceptionListEntry) {
            CombiBAPReceptionListEntry combiBAPReceptionListEntry = (CombiBAPReceptionListEntry)combiBAPArrayElement;
            receptionList_Data.setPos(combiBAPReceptionListEntry.getPosID());
            receptionList_Data.type = combiBAPReceptionListEntry.getType();
            receptionList_Data.attributes.available = combiBAPReceptionListEntry.hasAttribute(1);
            receptionList_Data.attributes.dvbServiceCorrupted = combiBAPReceptionListEntry.hasAttribute(2);
            receptionList_Data.attributes.dabPrimaryServiceContainsSecondaryService = combiBAPReceptionListEntry.hasAttribute(4);
            receptionList_Data.attributes.dabPrimaryServiceCorrupted = combiBAPReceptionListEntry.hasAttribute(8);
            receptionList_Data.attributes.dabServiceLinkedToFm = combiBAPReceptionListEntry.hasAttribute(16);
            receptionList_Data.attributes.tpAvailableSupportedByStation = combiBAPReceptionListEntry.hasAttribute(32);
            receptionList_Data.attributes.tmcAvailableSupportedByStation = combiBAPReceptionListEntry.hasAttribute(64);
            receptionList_Data.attributes.sdarsStationSubscribedOrNotAnSdarsStation = combiBAPReceptionListEntry.hasAttribute(128);
            receptionList_Data.attributes.dabServiceLinkedToOnlineRadio = combiBAPReceptionListEntry.hasAttribute(256);
            receptionList_Data.attributes.fmLinkedToOnlineRadio = combiBAPReceptionListEntry.hasAttribute(512);
            receptionList_Data.presetId = combiBAPReceptionListEntry.getPresetID();
            receptionList_Data.fmReg_Code = combiBAPReceptionListEntry.getFmRegionCode();
            receptionList_Data.category = combiBAPReceptionListEntry.getCategory();
            receptionList_Data.name.setContent(combiBAPReceptionListEntry.getName());
            receptionList_Data.frequency.setContent(combiBAPReceptionListEntry.getFrequency());
        } else {
            this.logChannel.log(10000, "[ReceptionListAdapterBAP#convertArrayElement] wrong dataType (expected: %1, is: %2)", (Object)(class$de$audi$atip$interapp$combi$bap$audio$data$CombiBAPReceptionListEntry == null ? (class$de$audi$atip$interapp$combi$bap$audio$data$CombiBAPReceptionListEntry = ReceptionListAdapterBAP.class$("de.audi.atip.interapp.combi.bap.audio.data.CombiBAPReceptionListEntry")) : class$de$audi$atip$interapp$combi$bap$audio$data$CombiBAPReceptionListEntry).getName(), (Object)super.getClass().getName());
        }
        return receptionList_Data;
    }

    @Override
    protected BAPArrayElement createArrayElement(ArrayHeader arrayHeader, int n) {
        ReceptionList_Data receptionList_Data = new ReceptionList_Data(arrayHeader);
        receptionList_Data.setPos(n);
        return receptionList_Data;
    }

    @Override
    protected ChangedArray createChangedArraySerializer() {
        ReceptionList_ChangedArray receptionList_ChangedArray = new ReceptionList_ChangedArray();
        receptionList_ChangedArray.elementType = ((ReceptionListHandler)this.listHandler).getListType() == 3 ? (((ReceptionListHandler)this.listHandler).isDABSortAlphabetically() ? 4 : 3) : 5;
        receptionList_ChangedArray.parent_Id = 0;
        return receptionList_ChangedArray;
    }

    @Override
    protected StatusArray createStatusArraySerializer() {
        return new ReceptionList_StatusArray();
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

