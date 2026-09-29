/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.sds;

import de.audi.app.navi.evo.addressinput.poi.models.PoiResultScreenNoSpellerModelAccess;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.IListRowBuilder;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;
import org.dsi.ifc.navigation.ValueListStatus;

public class PoiSDSUidResultsModelAccess
extends PoiResultScreenNoSpellerModelAccess {
    private final IListRowBuilder listRowBuilder;

    public PoiSDSUidResultsModelAccess(NavigationEnv navigationEnv, IListRowBuilder iListRowBuilder, int n) {
        super(navigationEnv, n);
        this.listRowBuilder = iListRowBuilder;
    }

    @Override
    public void onUpdateResultList(LIValueList lIValueList, long l, String string, boolean bl) {
        this.logChannel.log(-2137614336, "PoiSDSUidResultsModelAccess#onUpdateResultList( %2, %3, %1)", (Object)string, (Object)lIValueList, l);
        if (!Util.isListValid(lIValueList) || lIValueList.getList().length == 0) {
            this.previewListModel.removeAll();
            return;
        }
        LIValueListElement[] lIValueListElementArray = lIValueList.getList();
        int n = lIValueListElementArray.length;
        BaseListModelApp baseListModelApp = this.previewListModel.getCopy();
        this.logChannel.log(-2137614336, new StringBuffer().append("PoiSDSUidResultsModelAccess#onUpdateResultList - previewlistlength: ").append(n).toString());
        for (int i2 = 0; i2 < n; ++i2) {
            EvoListRow evoListRow = this.listRowBuilder.buildEvoListRow(lIValueListElementArray[i2], lIValueListElementArray[i2].getListIndex());
            baseListModelApp.append(evoListRow);
        }
        this.previewListModel.update(baseListModelApp);
    }

    @Override
    public void onUpdateSearchStatus(ValueListStatus valueListStatus) {
    }
}

