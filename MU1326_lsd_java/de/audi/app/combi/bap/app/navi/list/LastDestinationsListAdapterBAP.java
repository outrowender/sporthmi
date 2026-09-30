/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.navi.list;

import de.audi.app.bap.fw.arrays.AbstractListAdapterBAP;
import de.audi.app.bap.fw.arrays.ArrayHandler;
import de.audi.app.combi.bap.fw.AbstractCombiModule;
import de.audi.atip.interapp.combi.bap.data.CombiBAPArrayElement;
import de.audi.atip.interapp.combi.bap.navi.data.CombiBAPDestinationListEntry;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.generated.navsd.serializer.LastDest_List_ChangedArray;
import de.vw.mib.bap.generated.navsd.serializer.LastDest_List_Data;
import de.vw.mib.bap.generated.navsd.serializer.LastDest_List_StatusArray;
import de.vw.mib.bap.requests.ChangedArray;
import de.vw.mib.bap.requests.StatusArray;

public class LastDestinationsListAdapterBAP
extends AbstractListAdapterBAP {
    public LastDestinationsListAdapterBAP(AbstractCombiModule abstractCombiModule, ArrayHandler arrayHandler) {
        super(abstractCombiModule, 29, arrayHandler);
    }

    protected int getCommonRecordAddress(boolean[] blArray) {
        boolean bl = blArray[15];
        boolean bl2 = blArray[0] || blArray[2];
        boolean bl3 = blArray[0] || blArray[1];
        return CombiBAPDestinationListEntry.getRecordAddress(bl, bl2, bl3);
    }

    protected BAPArrayElement convertArrayElement(CombiBAPArrayElement combiBAPArrayElement, ArrayHeader arrayHeader) {
        LastDest_List_Data lastDest_List_Data = new LastDest_List_Data(arrayHeader);
        if (combiBAPArrayElement instanceof CombiBAPDestinationListEntry) {
            CombiBAPDestinationListEntry combiBAPDestinationListEntry = (CombiBAPDestinationListEntry)combiBAPArrayElement;
            lastDest_List_Data.setPos(combiBAPDestinationListEntry.getPosID());
            lastDest_List_Data.poi_Type = combiBAPDestinationListEntry.getPOIType();
            lastDest_List_Data.description.setContent(combiBAPDestinationListEntry.getDescription());
        } else {
            this.logChannel.log(10000, "[LastDestinationsListAdapterBAP#convertArrayElement] invalid element type: %1", (Object)combiBAPArrayElement.getClass());
        }
        return lastDest_List_Data;
    }

    protected BAPArrayElement createArrayElement(ArrayHeader arrayHeader, int n) {
        LastDest_List_Data lastDest_List_Data = new LastDest_List_Data(arrayHeader);
        lastDest_List_Data.setPos(n);
        return lastDest_List_Data;
    }

    protected ChangedArray createChangedArraySerializer() {
        return new LastDest_List_ChangedArray();
    }

    protected StatusArray createStatusArraySerializer() {
        return new LastDest_List_StatusArray();
    }
}

