/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.models;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.listbuilders.IEvoListRowBuilder;
import de.audi.tghu.navi.app.addressinput.poi.models.AbstractPoiScreenModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiBrandScreenModelAccess;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

public class PoiBrandScreenModelAccess
extends AbstractPoiScreenModelAccess
implements IPoiBrandScreenModelAccess {
    private BaseListModelApp previewListModel;
    private final IEvoListRowBuilder listRowBuilder;

    public PoiBrandScreenModelAccess(NavigationEnv navigationEnv, int n, IEvoListRowBuilder iEvoListRowBuilder) {
        super(navigationEnv);
        this.listRowBuilder = iEvoListRowBuilder;
        this.previewListModel = navigationEnv.getBaseListModel(n);
    }

    @Override
    public void onStart() {
        this.previewListModel.removeAll();
    }

    @Override
    public void onElementSelected(LIValueListElement lIValueListElement) {
        this.logChannel.log(-2137614336, "PoiBrandScreenModelAccess#onElementSelected - selectedElement.data=%1", (Object)lIValueListElement.data);
        this.env.getLabelModel(958268928).setText(lIValueListElement.data);
    }

    @Override
    public void onUpdateResultList(LIValueList lIValueList, long l, String string, boolean bl) {
        this.logChannel.log(-2137614336, "PoiBrandScreenModelAccess#onUpdateResultList( %1, %2)", (Object)string, l);
        this.env.getChoiceModel(-1541732864).setValue((int)l);
        if (!Util.isListValid(lIValueList) || lIValueList.getList().length == 0) {
            this.logChannel.log(-2137614336, "PoiBrandScreenModelAccess#onUpdateResultList() - invalid value list: %1", (Object)lIValueList);
            this.previewListModel.removeAll();
            return;
        }
        LIValueListElement[] lIValueListElementArray = lIValueList.getList();
        int n = lIValueListElementArray.length;
        int n2 = this.previewListModel.getLength();
        this.logChannel.log(-2137614336, "PoiBrandScreenModelAccess#onUpdateResultList - previewlistlength: %1, currentListModelLength: %2", (long)n, (long)n2);
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

