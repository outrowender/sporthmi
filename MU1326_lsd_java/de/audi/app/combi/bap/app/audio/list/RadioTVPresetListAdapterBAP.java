/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio.list;

import de.audi.app.bap.fw.arrays.AbstractListAdapterBAP;
import de.audi.app.combi.bap.app.audio.list.RadioTVPresetListHandler;
import de.audi.app.combi.bap.fw.AbstractCombiModule;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPPresetListEntry;
import de.audi.atip.interapp.combi.bap.data.CombiBAPArrayElement;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.generated.audiosd.serializer.RadioTV_PresetList_ChangedArray;
import de.vw.mib.bap.generated.audiosd.serializer.RadioTV_PresetList_Data;
import de.vw.mib.bap.generated.audiosd.serializer.RadioTV_PresetList_StatusArray;
import de.vw.mib.bap.requests.ChangedArray;
import de.vw.mib.bap.requests.StatusArray;

public class RadioTVPresetListAdapterBAP
extends AbstractListAdapterBAP {
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$audio$data$CombiBAPPresetListEntry;

    public RadioTVPresetListAdapterBAP(AbstractCombiModule abstractCombiModule, RadioTVPresetListHandler radioTVPresetListHandler) {
        super(abstractCombiModule, 33, radioTVPresetListHandler);
    }

    protected int getCommonRecordAddress(boolean[] blArray) {
        boolean bl = blArray[0] || blArray[1] || blArray[2];
        boolean bl2 = blArray[0] || blArray[1];
        boolean bl3 = blArray[0];
        boolean bl4 = blArray[0] || blArray[1] || blArray[2];
        return CombiBAPPresetListEntry.getRecordAddress(false, bl, bl2, bl3, bl4);
    }

    protected BAPArrayElement convertArrayElement(CombiBAPArrayElement combiBAPArrayElement, ArrayHeader arrayHeader) {
        RadioTV_PresetList_Data radioTV_PresetList_Data = new RadioTV_PresetList_Data(arrayHeader);
        if (combiBAPArrayElement instanceof CombiBAPPresetListEntry) {
            CombiBAPPresetListEntry combiBAPPresetListEntry = (CombiBAPPresetListEntry)combiBAPArrayElement;
            radioTV_PresetList_Data.setPos(combiBAPPresetListEntry.getPosID());
            radioTV_PresetList_Data.presetIndex = combiBAPPresetListEntry.getPresetIndex();
            radioTV_PresetList_Data.waveband = combiBAPPresetListEntry.getWaveband();
            radioTV_PresetList_Data.attributes.sdarsStationSubscribedOrNotAnSdarsStation = combiBAPPresetListEntry.hasAttribute(128);
            radioTV_PresetList_Data.attributes.tmcAvailableSupportedByStation = combiBAPPresetListEntry.hasAttribute(64);
            radioTV_PresetList_Data.attributes.tpAvailableSupportedByStation = combiBAPPresetListEntry.hasAttribute(32);
            radioTV_PresetList_Data.attributes.dabPrimaryServiceContainsSecondaryService = combiBAPPresetListEntry.hasAttribute(4);
            radioTV_PresetList_Data.attributes.dabSecondaryService = combiBAPPresetListEntry.hasAttribute(2);
            radioTV_PresetList_Data.attributes.ibocService = combiBAPPresetListEntry.hasAttribute(1);
            radioTV_PresetList_Data.name.setContent(combiBAPPresetListEntry.getName());
        } else {
            this.logChannel.log(10000, "[RadioTVPresetListAdapterBAP#convertArrayElement] wrong dataType (expected: %1, is: %2)", (Object)(class$de$audi$atip$interapp$combi$bap$audio$data$CombiBAPPresetListEntry == null ? (class$de$audi$atip$interapp$combi$bap$audio$data$CombiBAPPresetListEntry = RadioTVPresetListAdapterBAP.class$("de.audi.atip.interapp.combi.bap.audio.data.CombiBAPPresetListEntry")) : class$de$audi$atip$interapp$combi$bap$audio$data$CombiBAPPresetListEntry).getName(), (Object)combiBAPArrayElement.getClass().getName());
        }
        return radioTV_PresetList_Data;
    }

    protected BAPArrayElement createArrayElement(ArrayHeader arrayHeader, int n) {
        RadioTV_PresetList_Data radioTV_PresetList_Data = new RadioTV_PresetList_Data(arrayHeader);
        radioTV_PresetList_Data.setPos(n);
        return radioTV_PresetList_Data;
    }

    protected ChangedArray createChangedArraySerializer() {
        return new RadioTV_PresetList_ChangedArray();
    }

    protected StatusArray createStatusArraySerializer() {
        return new RadioTV_PresetList_StatusArray();
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

