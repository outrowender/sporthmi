/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.models;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.listbuilders.IEvoListRowBuilder;
import de.audi.tghu.navi.app.addressinput.poi.models.AbstractPoiScreenModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiCategoryScreenModelAccess;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

public class PoiCategoryScreenModelAccess
extends AbstractPoiScreenModelAccess
implements IPoiCategoryScreenModelAccess {
    private final BaseListModelApp previewListModel;
    private final IEvoListRowBuilder listRowBuilder;

    public PoiCategoryScreenModelAccess(NavigationEnv navigationEnv, int n, IEvoListRowBuilder iEvoListRowBuilder) {
        super(navigationEnv);
        this.listRowBuilder = iEvoListRowBuilder;
        this.previewListModel = navigationEnv.getBaseListModel(n);
    }

    public void onStart() {
        this.previewListModel.removeAll();
    }

    public void onElementSelected(LIValueListElement lIValueListElement) {
        this.env.getLogChannel().log(10000000, "PoiCategoryScreenModelAccess#onElementSelected - setting label text to %1", (Object)lIValueListElement.data);
        this.env.getChoiceModel(400958).setValue(1);
        this.env.getLabelModel(400956).setText(lIValueListElement.data);
    }

    public void onUpdatePoiList(LIValueList lIValueList) {
    }

    public void onUpdateResultList(LIValueList lIValueList, long l, String string, boolean bl) {
        this.env.getLogChannel().log(10000000, "PoiCategoryScreenModelAccess#onUpdateResultList");
        this.env.getChoiceModel(400640).setValue((int)l);
        this.logChannel.log(10000000, "PoiCategoryScreenModelAccess#onUpdateResultList( %1, %2)", (Object)string, l);
        this.env.getChoiceModel(400642).setValue((int)l);
        if (!Util.isListValid(lIValueList) || lIValueList.getList().length == 0) {
            this.logChannel.log(10000000, "PoiCategoryScreenModelAccess#onUpdateResultList() - invalid value list: %1", (Object)lIValueList);
            this.previewListModel.removeAll();
            return;
        }
        LIValueListElement[] lIValueListElementArray = lIValueList.getList();
        int n = lIValueListElementArray.length;
        int n2 = this.previewListModel.getLength();
        this.logChannel.log(10000000, "PoiCategoryScreenModelAccess#onUpdateResultList - previewlistlength: %1, currentListModelLength: %2", (long)n, (long)n2);
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
}

