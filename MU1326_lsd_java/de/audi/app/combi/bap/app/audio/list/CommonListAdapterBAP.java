/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio.list;

import de.audi.app.bap.fw.arrays.AbstractListAdapterBAP;
import de.audi.app.bap.fw.arrays.ArrayHandler;
import de.audi.app.combi.bap.fw.AbstractCombiModule;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPCommonListEntry;
import de.audi.atip.interapp.combi.bap.data.CombiBAPArrayElement;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.generated.audiosd.serializer.CommonList_ChangedArray;
import de.vw.mib.bap.generated.audiosd.serializer.CommonList_Data;
import de.vw.mib.bap.generated.audiosd.serializer.CommonList_StatusArray;
import de.vw.mib.bap.requests.ChangedArray;
import de.vw.mib.bap.requests.StatusArray;

public class CommonListAdapterBAP
extends AbstractListAdapterBAP {
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$audio$data$CombiBAPCommonListEntry;

    public CommonListAdapterBAP(AbstractCombiModule abstractCombiModule, ArrayHandler arrayHandler) {
        super(abstractCombiModule, 50, arrayHandler);
    }

    protected int getCommonRecordAddress(boolean[] blArray) {
        boolean bl = blArray[0] || blArray[15];
        boolean bl2 = blArray[0] || blArray[1];
        boolean bl3 = blArray[0] || blArray[1] || blArray[3];
        boolean bl4 = blArray[0] || blArray[1];
        boolean bl5 = blArray[0] || blArray[1];
        boolean bl6 = blArray[0] || blArray[1] || blArray[2];
        boolean bl7 = blArray[0] || blArray[3];
        return CombiBAPCommonListEntry.getRecordAddress(bl, bl2, bl3, bl4, bl5, bl6, bl7);
    }

    protected BAPArrayElement convertArrayElement(CombiBAPArrayElement combiBAPArrayElement, ArrayHeader arrayHeader) {
        CommonList_Data commonList_Data = new CommonList_Data(arrayHeader);
        if (combiBAPArrayElement instanceof CombiBAPCommonListEntry) {
            CombiBAPCommonListEntry combiBAPCommonListEntry = (CombiBAPCommonListEntry)combiBAPArrayElement;
            commonList_Data.setPos(combiBAPCommonListEntry.getPosID());
            commonList_Data.sourceType = combiBAPCommonListEntry.getSourceType();
            commonList_Data.attributes.available = combiBAPCommonListEntry.hasAttribute(1);
            commonList_Data.attributes.dvbServiceCorrupted = combiBAPCommonListEntry.hasAttribute(2);
            commonList_Data.attributes.dabPrimaryServiceContainsSecondaryService = combiBAPCommonListEntry.hasAttribute(4);
            commonList_Data.attributes.dabPrimaryServiceCorrupted = combiBAPCommonListEntry.hasAttribute(8);
            commonList_Data.attributes.dabServiceLinkedToFm = combiBAPCommonListEntry.hasAttribute(16);
            commonList_Data.attributes.tpAvailableSupportedByStation = combiBAPCommonListEntry.hasAttribute(32);
            commonList_Data.attributes.tmcAvailableSupportedByStation = combiBAPCommonListEntry.hasAttribute(64);
            commonList_Data.attributes.sdarsStationSubscribedOrNotAnSdarsStation = combiBAPCommonListEntry.hasAttribute(128);
            commonList_Data.attributes.dabServiceLinkedToOnlineRadio = combiBAPCommonListEntry.hasAttribute(256);
            commonList_Data.attributes.fmLinkedToOnlineRadio = combiBAPCommonListEntry.hasAttribute(512);
            commonList_Data.presetId = combiBAPCommonListEntry.getPresetID();
            commonList_Data.category = combiBAPCommonListEntry.getCategory();
            commonList_Data.name.setContent(combiBAPCommonListEntry.getName());
            commonList_Data.frequency.setContent(combiBAPCommonListEntry.getFrequency());
        } else {
            this.logChannel.log(10000, "[CommonListAdapterBAP#convertArrayElement] wrong dataType (expected: %1, is: %2)", (Object)(class$de$audi$atip$interapp$combi$bap$audio$data$CombiBAPCommonListEntry == null ? (class$de$audi$atip$interapp$combi$bap$audio$data$CombiBAPCommonListEntry = CommonListAdapterBAP.class$("de.audi.atip.interapp.combi.bap.audio.data.CombiBAPCommonListEntry")) : class$de$audi$atip$interapp$combi$bap$audio$data$CombiBAPCommonListEntry).getName(), (Object)combiBAPArrayElement.getClass().getName());
        }
        return commonList_Data;
    }

    protected BAPArrayElement createArrayElement(ArrayHeader arrayHeader, int n) {
        CommonList_Data commonList_Data = new CommonList_Data(arrayHeader);
        commonList_Data.setPos(n);
        return commonList_Data;
    }

    protected ChangedArray createChangedArraySerializer() {
        return new CommonList_ChangedArray();
    }

    protected StatusArray createStatusArraySerializer() {
        return new CommonList_StatusArray();
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

