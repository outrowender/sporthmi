/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.tpegpoi.models;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.tpegpoi.AbstractTpegPOIModelAccess;
import de.audi.tghu.navi.app.addressinput.tpegpoi.ITpegPOICategoryListModelAccess;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

public class TpegPOICategoryScreenModelAccess
extends AbstractTpegPOIModelAccess
implements ITpegPOICategoryListModelAccess {
    private BaseListModelApp baseList;
    private ChoiceModelApp dataAvailableChoice;

    public TpegPOICategoryScreenModelAccess(NavigationEnv navigationEnv, int n, int n2) {
        super(navigationEnv);
        this.baseList = navigationEnv.getBaseListModel(n);
        this.dataAvailableChoice = navigationEnv.getChoiceModel(n2);
    }

    @Override
    public void onStart() {
        this.baseList.removeAll();
    }

    @Override
    public void onUpdateResultList(LIValueList lIValueList, long l, String string, boolean bl) {
        this.logChannel.log(-2137614336, "%1#updateResultList with valueList = %2", (Object)this.CLASS_NAME, (Object)lIValueList);
        this.updateDataAvailableModelValue(l);
        LIValueListElement[] lIValueListElementArray = Util.isListValid(lIValueList) ? lIValueList.getList() : new LIValueListElement[]{};
        EvoListRow[] evoListRowArray = new EvoListRow[lIValueListElementArray.length];
        for (int i2 = 0; i2 < lIValueListElementArray.length; ++i2) {
            evoListRowArray[i2] = TpegPOICategoryScreenModelAccess.createCategoryListRow(lIValueListElementArray[i2]);
        }
        this.baseList.setLength((int)l);
        this.baseList.setRows(-1, 0, evoListRowArray);
    }

    private void updateDataAvailableModelValue(long l) {
        this.logChannel.log(-2137614336, "%1#updateDataAvailableModelValue with resultCount = %2", (Object)this.CLASS_NAME, l);
        if (l > 0L) {
            this.dataAvailableChoice.setValue(1);
        } else {
            this.dataAvailableChoice.setValue(0);
        }
    }

    private static EvoListRow createCategoryListRow(LIValueListElement lIValueListElement) {
        EvoListRow evoListRow = new EvoListRow(lIValueListElement.listIndex, 4);
        evoListRow.setText(1, lIValueListElement.getData());
        return evoListRow;
    }
}

