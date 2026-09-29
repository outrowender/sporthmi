/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.models;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.listbuilders.IEvoListRowBuilder;
import de.audi.tghu.navi.app.addressinput.poi.models.AbstractPoiScreenModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiParentChildResultScreenModelAccess;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

public class PoiParentChildResultScreenModelAccess
extends AbstractPoiScreenModelAccess
implements IPoiParentChildResultScreenModelAccess {
    private final IEvoListRowBuilder listRowBuilder;
    private final TiledListModelApp previewList;
    public static final int CHOICE_ENABLED;
    public static final int CHOICE_DISABLED;

    public PoiParentChildResultScreenModelAccess(NavigationEnv navigationEnv, IEvoListRowBuilder iEvoListRowBuilder, int n) {
        super(navigationEnv);
        this.listRowBuilder = iEvoListRowBuilder;
        this.previewList = navigationEnv.getTiledListModel(n);
    }

    @Override
    public void onStart() {
        this.env.getPOILogChannel().log(-2137614336, " PoiParentChildResultScreenModelAccess#onStart()");
        this.previewList.removeAll();
    }

    @Override
    public void onUpdateResultList(LIValueList lIValueList, long l, String string, boolean bl) {
        this.env.getChoiceModel(35456512).setValue((int)l);
        this.previewList.setLength((int)l);
        this.env.getPOILogChannel().log(-2137614336, " PoiParentChildResultScreenModelAccess#onUpdateResultList( %1, %2)", (Object)string, l);
        if (!Util.isListValid(lIValueList) || lIValueList.getList().length == 0) {
            this.env.getPOILogChannel().log(-2137614336, "PoiParentChildResultScreenModelAccess#onUpdateResultList() - invalid value list: %1", (Object)lIValueList);
            this.previewList.removeAll();
            return;
        }
        LIValueListElement[] lIValueListElementArray = lIValueList.getList();
        int n = this.previewList.getLength();
        this.env.getPOILogChannel().log(-2137614336, "PoiParentChildResultScreenModelAccess#onUpdateResultList - valueListSize: %1, currentListModelLength: %2", (long)lIValueListElementArray.length, (long)n);
        try {
            EvoListRow[] evoListRowArray = this.createUpdateListRow(lIValueListElementArray);
            this.previewList.setRows(-1, 0, evoListRowArray);
        }
        catch (Exception exception) {
            this.env.getPOILogChannel().log(10000, exception.getMessage());
        }
    }

    private EvoListRow[] createUpdateListRow(LIValueListElement[] lIValueListElementArray) {
        EvoListRow[] evoListRowArray = new EvoListRow[lIValueListElementArray.length];
        for (int i2 = 0; i2 < lIValueListElementArray.length; ++i2) {
            EvoListRow evoListRow;
            LIValueListElement lIValueListElement = lIValueListElementArray[i2];
            evoListRowArray[i2] = evoListRow = this.listRowBuilder.buildListRow(lIValueListElement, lIValueListElement.listIndex);
        }
        return evoListRowArray;
    }

    @Override
    public void onElementSelected(LIValueListElement lIValueListElement) {
        this.env.getChoiceModel(505284096).setValue(1);
        this.env.getLogChannel().log(-2137614336, "PoiParentChildResultScreenModelAccess#onElementSelected");
        this.env.getLabelModel(2098923008).setText(lIValueListElement.data);
    }

    @Override
    public void onUpdateResultListForRequest(LIValueList lIValueList, long l, String string, boolean bl, int n, int n2) {
        this.env.getPOILogChannel().log(-2137614336, " PoiParentChildResultScreenModelAccess#onUpdateResultListForRequest( %1, %2, %3, %4)", (Object)string, (Object)Long.toString(l), (Object)Integer.toString(n), (Object)Integer.toString(n2));
        if (!Util.isListValid(lIValueList) || lIValueList.getList().length == 0) {
            this.env.getPOILogChannel().log(-2137614336, "PoiParentChildResultScreenModelAccess#onUpdateResultListForRequest() - invalid value list: %1", (Object)lIValueList);
            this.previewList.removeAll();
            return;
        }
        LIValueListElement[] lIValueListElementArray = lIValueList.getList();
        int n3 = this.previewList.getLength();
        this.env.getPOILogChannel().log(-2137614336, "PoiParentChildResultScreenModelAccess#onUpdateResultListForRequest - valueListSize: %1, currentListModelLength: %2", (long)lIValueListElementArray.length, (long)n3);
        try {
            EvoListRow[] evoListRowArray = this.createUpdateListRow(lIValueListElementArray);
            this.previewList.setRows(n, n2, evoListRowArray);
        }
        catch (Exception exception) {
            this.env.getPOILogChannel().log(10000, exception.getMessage());
        }
    }

    @Override
    public void onUnrequestItems(int n, int n2) {
        this.env.getPOILogChannel().log(-2137614336, "PoiParentChildResultScreenModelAccess#onUnrequestItems - startIndex = %1, length = %2", (long)n, (long)n2);
        this.previewList.clearRows(n, n2);
    }

    @Override
    public void onElementFocused(NavLocation navLocation) {
        String string = LocationFormatter.getPhoneNumber(navLocation);
        if (this.env.getPOILogChannel().isDebug2()) {
            this.env.getPOILogChannel().log(14808325, "PoiParentChildResultScreenModelAccess#onElementFocused - tel = %1", (Object)string);
        }
        if (Util.isEmpty(string)) {
            this.env.getChoiceModel(-400554496).setValue(2);
        } else {
            this.env.getChoiceModel(-400554496).setValue(1);
        }
    }
}

