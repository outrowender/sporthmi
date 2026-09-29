/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.phone.list;

import de.audi.app.bap.fw.arrays.AbstractListAdapterBAP;
import de.audi.app.bap.fw.arrays.ArrayHandler;
import de.audi.app.combi.bap.fw.AbstractCombiModule;
import de.audi.atip.interapp.combi.bap.data.CombiBAPArrayElement;
import de.audi.atip.interapp.combi.bap.phone.data.CombiBAPFavoriteNumberEntry;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.generated.telephone.serializer.FavoriteList_ChangedArray;
import de.vw.mib.bap.generated.telephone.serializer.FavoriteList_Data;
import de.vw.mib.bap.generated.telephone.serializer.FavoriteList_StatusArray;
import de.vw.mib.bap.requests.ChangedArray;
import de.vw.mib.bap.requests.StatusArray;

public class FavoriteNumbersListAdapterBAP
extends AbstractListAdapterBAP {
    public FavoriteNumbersListAdapterBAP(AbstractCombiModule abstractCombiModule, ArrayHandler arrayHandler) {
        super(abstractCombiModule, 60, arrayHandler);
    }

    @Override
    protected int getCommonRecordAddress(boolean[] blArray) {
        boolean bl = blArray[0] || blArray[1] || blArray[2];
        boolean bl2 = blArray[0] || blArray[1];
        boolean bl3 = blArray[0] || blArray[2];
        boolean bl4 = blArray[0] || blArray[15];
        return CombiBAPFavoriteNumberEntry.getRecordAddress(bl4, bl, bl3, bl2);
    }

    @Override
    protected BAPArrayElement convertArrayElement(CombiBAPArrayElement combiBAPArrayElement, ArrayHeader arrayHeader) {
        FavoriteList_Data favoriteList_Data = new FavoriteList_Data(arrayHeader);
        if (combiBAPArrayElement instanceof CombiBAPFavoriteNumberEntry) {
            CombiBAPFavoriteNumberEntry combiBAPFavoriteNumberEntry = (CombiBAPFavoriteNumberEntry)combiBAPArrayElement;
            favoriteList_Data.setPos(combiBAPFavoriteNumberEntry.getPosID());
            favoriteList_Data.name.setContent(combiBAPFavoriteNumberEntry.getName());
            favoriteList_Data.telNumber.setContent(combiBAPFavoriteNumberEntry.getTelNumber());
            favoriteList_Data.numberType = combiBAPFavoriteNumberEntry.getNumberType();
        } else {
            this.logChannel.log(10000, "[FavoriteNumbersListAdapterBAP#convertArrayElement] invalid element type: %1", (Object)super.getClass());
        }
        return favoriteList_Data;
    }

    @Override
    protected BAPArrayElement createArrayElement(ArrayHeader arrayHeader, int n) {
        FavoriteList_Data favoriteList_Data = new FavoriteList_Data(arrayHeader);
        favoriteList_Data.setPos(n);
        return favoriteList_Data;
    }

    @Override
    protected ChangedArray createChangedArraySerializer() {
        return new FavoriteList_ChangedArray();
    }

    @Override
    protected StatusArray createStatusArraySerializer() {
        return new FavoriteList_StatusArray();
    }
}

