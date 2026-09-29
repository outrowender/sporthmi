/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.models;

import de.audi.app.navi.evo.addressinput.poi.listbuilders.evo.POIIconedListRowBuilder;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.models.AbstractPoiScreenModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiMainScreenModelAccess;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

public class PoiMainScreenModelAccess
extends AbstractPoiScreenModelAccess
implements IPoiMainScreenModelAccess {
    private static final int SUBTITLE_DYNAMIC_OFFSET;
    protected final BaseListModelApp previewListModel;
    protected final POIIconedListRowBuilder listRowBuilder;

    public PoiMainScreenModelAccess(NavigationEnv navigationEnv, POIIconedListRowBuilder pOIIconedListRowBuilder, int n) {
        super(navigationEnv);
        this.listRowBuilder = pOIIconedListRowBuilder;
        this.previewListModel = navigationEnv.getBaseListModel(n);
    }

    @Override
    public void onStart() {
        this.previewListModel.removeAll();
    }

    @Override
    public void onUpdateResultList(LIValueList lIValueList, long l, String string, boolean bl) {
        super.onUpdateResultList(lIValueList, l, string, bl);
        this.logChannel.log(-2137614336, "PoiMainScreenModelAccess#onUpdateResultList( %1, %2)", (Object)string, l);
        if (!Util.isListValid(lIValueList) || lIValueList.getList().length == 0) {
            this.logChannel.log(-2137614336, "PoiMainScreenModelAccess#onUpdateResultList() - invalid value list: %1", (Object)lIValueList);
            this.previewListModel.removeAll();
            return;
        }
        LIValueListElement[] lIValueListElementArray = lIValueList.getList();
        int n = lIValueListElementArray.length;
        int n2 = this.previewListModel.getLength();
        this.logChannel.log(-2137614336, "PoiMainScreenModelAccess#onUpdateResultList - previewlistlength: %1, currentListModelLength: %2", (long)n, (long)n2);
        try {
            for (int i2 = 0; i2 < n; ++i2) {
                LIValueListElement lIValueListElement = lIValueListElementArray[i2];
                EvoListRow evoListRow = this.listRowBuilder.buildListRow(lIValueListElement, lIValueListElement.listIndex);
                this.previewListModel.setLength(++n2);
                this.previewListModel.setRow(n2 - 1, evoListRow);
            }
        }
        catch (Exception exception) {
            this.logChannel.log(10000, exception.getMessage());
        }
    }

    @Override
    public void onElementSelected(LIValueListElement lIValueListElement) {
        this.logChannel.log(-2137614336, "PoiMainScreenModelAccess#onElementSelectedselectedElement.data=%1", (Object)lIValueListElement.data);
        this.env.getChoiceModel(1058932224).setValue(0);
        this.env.getChoiceModel(1075709440).setValue(1);
        int n = this.env.getChoiceModel(-1859910144).getValue();
        this.env.getChoiceModel(606406144).setValue(n + 6);
        this.env.getLabelModel(-1776024064).setText(lIValueListElement.data);
    }
}

