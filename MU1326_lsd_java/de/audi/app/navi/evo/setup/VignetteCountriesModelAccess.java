/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.setup;

import de.audi.app.navi.setup.VignetteCountriesCoreModelAccess;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ListListener;
import de.audi.tghu.navi.app.IListRowBuilder;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.util.Util;
import java.util.Map;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

public class VignetteCountriesModelAccess
extends VignetteCountriesCoreModelAccess {
    protected VignetteCountriesModelAccess(NavigationEnv navigationEnv, ListListener listListener, IListRowBuilder iListRowBuilder) {
        super(navigationEnv, listListener, iListRowBuilder);
    }

    @Override
    public void onStart(NavLocation navLocation) {
        this.previewListModelApp.clear();
    }

    @Override
    public void onInputChanged() {
    }

    @Override
    public void onUpdateSpeller(String string, String string2, boolean bl, boolean bl2) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void onUpdateResultList(LIValueList lIValueList, long l, String string, boolean bl) {
        this.env.getLogChannel().log(-2137614336, "VignetteCountriesModelAccess#onUpdateResultList");
        LIValueListElement[] lIValueListElementArray = Util.isListValid(lIValueList) ? lIValueList.getList() : new LIValueListElement[]{};
        int n = 0;
        this.previewListModelApp.beginTransaction();
        try {
            this.previewListModelApp.clear();
            for (int i2 = 0; i2 < lIValueListElementArray.length && n < 4; ++n, ++i2) {
                ListCell[] listCellArray = this.listRowBuilder.buildListRow(lIValueListElementArray[i2], i2);
                this.previewListModelApp.addRow(listCellArray);
            }
        }
        finally {
            this.previewListModelApp.endTransaction();
        }
    }

    @Override
    public void onElementSelected(NavLocation navLocation) {
    }

    @Override
    public void onAmbiguousElementSelected() {
    }

    @Override
    public void onUpdateResultList(LIValueList lIValueList, long l, String string, boolean bl, int n, int n2) {
    }

    @Override
    public void onSpellerStatusChanged(int n) {
    }

    @Override
    public void onRestore() {
    }

    @Override
    public void onUpdateLocation(NavLocation navLocation, Map map) {
    }

    @Override
    public void unrequestItems(int n, int n2) {
    }
}

