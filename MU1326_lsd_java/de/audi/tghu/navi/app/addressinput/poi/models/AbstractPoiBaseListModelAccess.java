/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.models;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.listbuilders.IEvoListRowBuilder;
import de.audi.tghu.navi.app.addressinput.poi.IPoiSpellerModelAccess;
import de.audi.tghu.navi.app.util.Util;
import java.util.Map;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;
import org.dsi.ifc.navigation.ValueListStatus;

public abstract class AbstractPoiBaseListModelAccess
implements IPoiSpellerModelAccess {
    public static final int CHOICE_ENABLED;
    public static final int CHOICE_DISABLED;
    protected final NavigationEnv env;
    protected final LogChannel logChannel;
    protected final BaseListModelApp previewListModel;
    protected final IEvoListRowBuilder listRowBuilder;

    protected AbstractPoiBaseListModelAccess(NavigationEnv navigationEnv, BaseListModelListener baseListModelListener, IEvoListRowBuilder iEvoListRowBuilder, int n) {
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getPOILogChannel();
        this.logChannel.log(-2137614336, "[PoiInputModel] AbstractPoiBaseListModelAccess#AbstractPoiModelAccess()");
        this.listRowBuilder = iEvoListRowBuilder;
        this.logChannel.log(-2137614336, "[PoiInputModel] AbstractPoiBaseListModelAccess#AbstractPoiModelAccess(), previewList = %1", (long)n);
        this.previewListModel = navigationEnv.getBaseListModel(n);
        this.logChannel.log(-2137614336, "[PoiInputModel] AbstractPoiBaseListModelAccess#AbstractPoiModelAccess() model = %1", (Object)this.previewListModel);
        if (baseListModelListener != null) {
            this.previewListModel.setListener(baseListModelListener);
        }
    }

    @Override
    public void onStart(NavLocation navLocation) {
        this.clearPreviewList();
    }

    @Override
    public void onInputChanged() {
        this.clearPreviewList();
    }

    private void clearPreviewList() {
        this.previewListModel.removeAll();
        this.setPoiResultsAvailableModel(false);
    }

    @Override
    public void onUpdateSearchStatus(ValueListStatus valueListStatus) {
    }

    @Override
    public void onUpdateResultList(LIValueList lIValueList, long l, String string, boolean bl) {
        this.logChannel.log(-2137614336, "[PoiInputModel] AbstractPoiBaseListModelAccess#onUpdateResultList( %1, %2)", (Object)string, l);
        this.env.getChoiceModel(35456512).setValue((int)l);
        if (!Util.isListValid(lIValueList) || lIValueList.getList().length == 0) {
            this.logChannel.log(-2137614336, "[PoiInputModel] AbstractPoiBaseListModelAccess#onUpdateResultList() - invalid value list: %1", (Object)lIValueList);
            this.clearPreviewList();
            return;
        }
        LIValueListElement[] lIValueListElementArray = lIValueList.getList();
        int n = lIValueListElementArray.length;
        int n2 = this.previewListModel.getLength();
        this.logChannel.log(-2137614336, "[PoiInputModel] AbstractPoiBaseListModelAccess#onUpdateResultList - previewlistlength: %1, currentListModelLength: %2", (long)n, (long)n2);
        try {
            Object object;
            int n3;
            for (n3 = 0; n3 < n; ++n3) {
                object = lIValueListElementArray[n3];
                EvoListRow evoListRow = this.listRowBuilder.buildListRow((LIValueListElement)object, ((LIValueListElement)object).listIndex);
                this.previewListModel.setLength(++n2);
                this.previewListModel.setRow(n2 - 1, evoListRow);
            }
            this.setPoiResultsAvailableModel(this.previewListModel.getLength() > 0);
            for (n3 = 0; n3 < this.previewListModel.getLength(); ++n3) {
                object = this.previewListModel.getRow(n3);
                if (!this.logChannel.isDebug2()) continue;
                this.logChannel.log(14808325, "[PoiInputModel] AbstractPoiBaseListModelAccess#onUpdateResultList() - row = %1, Text = %2 modelID = %3", (Object)new StringBuffer().append(n3).append("").toString(), (Object)((EvoListRow)object).getText(1), (long)this.previewListModel.getID());
            }
        }
        catch (Exception exception) {
            this.logChannel.log(10000, exception.getMessage());
        }
    }

    @Override
    public void onUpdateResultList(LIValueList lIValueList, long l, String string, boolean bl, int n, int n2) {
        this.env.getChoiceModel(35456512).setValue((int)l);
        this.logChannel.log(-2137614336, "[PoiInputModel] AbstractPoiBaseListModelAccess#onUpdateResultList( %1, %2, %3 )", (Object)string, l, (long)n);
        if (!Util.isListValid(lIValueList) || lIValueList.getList().length == 0) {
            this.logChannel.log(-2137614336, "[PoiInputModel] AbstractPoiBaseListModelAccess#onUpdateResultList() - invalid value list: %1", (Object)lIValueList);
            this.previewListModel.clearAll();
            if (n > -1) {
                this.previewListModel.setRows(n, n2, null);
            }
            return;
        }
        LIValueListElement[] lIValueListElementArray = lIValueList.getList();
        int n3 = lIValueListElementArray.length;
        this.logChannel.log(-2137614336, "[PoiInputModel] AbstractPoiBaseListModelAccess#onUpdateResultList - previewlistlength: %1", (long)n3);
        EvoListRow[] evoListRowArray = new EvoListRow[n3];
        try {
            for (int i2 = 0; i2 < n3; ++i2) {
                LIValueListElement lIValueListElement = lIValueListElementArray[i2];
                evoListRowArray[i2] = this.listRowBuilder.buildListRow(lIValueListElement, lIValueListElement.listIndex);
            }
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "AbstractPoiBaseList#onUpdateResultList() Exception ocurred!", (Throwable)exception);
        }
        this.previewListModel.setLength((int)l);
        this.previewListModel.setRows(n, n2, evoListRowArray);
        this.setPoiResultsAvailableModel(this.previewListModel.getLength() > 0);
    }

    @Override
    public void unrequestItems(int n, int n2) {
        this.previewListModel.clearRows(n, n2);
    }

    @Override
    public void onAmbiguousElementSelected() {
    }

    @Override
    public void onElementSelected(NavLocation navLocation) {
    }

    @Override
    public void onUpdateSpeller(String string, String string2, boolean bl, boolean bl2) {
    }

    @Override
    public void onUpdatePoiList(LIValueList lIValueList) {
    }

    @Override
    public void onUpdateLocation(NavLocation navLocation, Map map) {
    }

    @Override
    public void onSpellerStatusChanged(int n) {
    }

    @Override
    public void onRestore() {
    }

    protected void setPoiResultsAvailableModel(boolean bl) {
    }
}

