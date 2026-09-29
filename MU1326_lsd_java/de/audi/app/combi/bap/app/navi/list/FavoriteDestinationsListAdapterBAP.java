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
import de.vw.mib.bap.generated.navsd.serializer.FavoriteDest_List_ChangedArray;
import de.vw.mib.bap.generated.navsd.serializer.FavoriteDest_List_Data;
import de.vw.mib.bap.generated.navsd.serializer.FavoriteDest_List_StatusArray;
import de.vw.mib.bap.requests.ChangedArray;
import de.vw.mib.bap.requests.StatusArray;

public class FavoriteDestinationsListAdapterBAP
extends AbstractListAdapterBAP {
    public FavoriteDestinationsListAdapterBAP(AbstractCombiModule abstractCombiModule, ArrayHandler arrayHandler) {
        super(abstractCombiModule, 30, arrayHandler);
    }

    @Override
    protected int getCommonRecordAddress(boolean[] blArray) {
        boolean bl = blArray[15];
        boolean bl2 = blArray[0] || blArray[2];
        boolean bl3 = blArray[0] || blArray[1];
        return CombiBAPDestinationListEntry.getRecordAddress(bl, bl2, bl3);
    }

    @Override
    protected BAPArrayElement convertArrayElement(CombiBAPArrayElement combiBAPArrayElement, ArrayHeader arrayHeader) {
        FavoriteDest_List_Data favoriteDest_List_Data = new FavoriteDest_List_Data(arrayHeader);
        if (combiBAPArrayElement instanceof CombiBAPDestinationListEntry) {
            CombiBAPDestinationListEntry combiBAPDestinationListEntry = (CombiBAPDestinationListEntry)combiBAPArrayElement;
            favoriteDest_List_Data.setPos(combiBAPDestinationListEntry.getPosID());
            favoriteDest_List_Data.poi_Type = combiBAPDestinationListEntry.getPOIType();
            favoriteDest_List_Data.description.setContent(combiBAPDestinationListEntry.getDescription());
        } else {
            this.logChannel.log(10000, "[FavoriteDestinationsListAdapterBAP#convertArrayElement] invalid element type: %1", (Object)super.getClass());
        }
        return favoriteDest_List_Data;
    }

    @Override
    protected BAPArrayElement createArrayElement(ArrayHeader arrayHeader, int n) {
        FavoriteDest_List_Data favoriteDest_List_Data = new FavoriteDest_List_Data(arrayHeader);
        favoriteDest_List_Data.setPos(n);
        return favoriteDest_List_Data;
    }

    @Override
    protected ChangedArray createChangedArraySerializer() {
        return new FavoriteDest_List_ChangedArray();
    }

    @Override
    protected StatusArray createStatusArraySerializer() {
        return new FavoriteDest_List_StatusArray();
    }
}

