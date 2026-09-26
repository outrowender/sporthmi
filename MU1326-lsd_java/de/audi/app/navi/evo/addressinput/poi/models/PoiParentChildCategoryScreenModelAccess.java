/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.models;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.listbuilders.IEvoListRowBuilder;
import de.audi.tghu.navi.app.addressinput.poi.models.AbstractPoiScreenModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiParentChildCategoryScreenModelAccess;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

public class PoiParentChildCategoryScreenModelAccess
extends AbstractPoiScreenModelAccess
implements IPoiParentChildCategoryScreenModelAccess {
    private final IEvoListRowBuilder listRowBuilder;
    private BaseListModelApp previewListModel;
    private LIValueListElement parentElement;
    public static final int CHOICE_ENABLED;
    public static final int CHOICE_DISABLED;

    public PoiParentChildCategoryScreenModelAccess(NavigationEnv navigationEnv, IEvoListRowBuilder iEvoListRowBuilder, int n) {
        super(navigationEnv);
        this.listRowBuilder = iEvoListRowBuilder;
        this.previewListModel = navigationEnv.getBaseListModel(n);
    }

    @Override
    public void onStart() {
        this.previewListModel.removeAll();
    }

    @Override
    public void onUpdateResultList(LIValueList lIValueList, long l, String string, boolean bl) {
        this.logChannel.log(-2137614336, "%1#onUpdateResultList(matchCount = %2)", (Object)this.CLASS_NAME, l);
        for (int i2 = 0; i2 < lIValueList.getList().length; ++i2) {
            this.logChannel.log(-2137614336, "%1#onUpdateResultList(element.name = %2, element.listIndex = %3)", (Object)this.CLASS_NAME, (Object)lIValueList.getList()[i2].data, (long)lIValueList.getList()[i2].listIndex);
        }
        if (!Util.isListValid(lIValueList) || lIValueList.getList().length == 0) {
            this.previewListModel.removeAll();
            return;
        }
        LIValueListElement[] lIValueListElementArray = lIValueList.getList();
        int n = lIValueListElementArray.length;
        int n2 = this.previewListModel.getLength();
        this.previewListModel.setLength((int)l + 1);
        this.logChannel.log(-2137614336, "%1#onUpdateResultList - previewlistlength: %2, currentListModelLength: %3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        if (n2 == 0) {
            EvoListRow evoListRow = this.listRowBuilder.buildListRow(this.parentElement, -1);
            this.previewListModel.setRow(0, evoListRow);
        }
        try {
            for (int i3 = 0; i3 < n; ++i3) {
                EvoListRow evoListRow = this.listRowBuilder.buildListRow(lIValueListElementArray[i3], lIValueListElementArray[i3].getListIndex());
                this.previewListModel.setRow(lIValueListElementArray[i3].getListIndex() + 1, evoListRow);
            }
        }
        catch (Exception exception) {
            this.logChannel.log(10000, exception.getMessage());
        }
    }

    @Override
    public void setParentElement(LIValueListElement lIValueListElement) {
        this.parentElement = lIValueListElement;
    }

    @Override
    public void onElementSelected(LIValueListElement lIValueListElement) {
        this.env.getChoiceModel(505284096).setValue(0);
        this.logChannel.log(-2137614336, "%1#onElementSelected - selectedElement.data=%2", (Object)this.CLASS_NAME, (Object)lIValueListElement.data);
        if (!Util.isHURegionAsia()) {
            this.env.getLabelModel(-249559552).setText(lIValueListElement.data);
        }
    }
}

