/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.fuelwarning;

import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.listbuilders.IEvoListRowBuilder;
import de.audi.tghu.navi.app.addressinput.poi.models.AbstractPoiBaseListModelAccess;
import de.audi.tghu.navi.app.util.Util;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

public class FuelWarningSequenceModelAccess
extends AbstractPoiBaseListModelAccess {
    private final int maximumResults;
    private static final int NO_GAS_STATION_IN_VINCINITY_CHOICE = 0;
    private static final int NO_GAS_STATION_ALONG_ROUTE_CHOICE = 1;
    private static final int NO_DIESEL_STATION_IN_VINCINITY_CHOICE = 2;
    private static final int NO_DIESEL_STATION_ALONG_ROUTE_CHOICE = 3;
    private static final int NO_CNG_STATION_IN_VINCINITY_CHOICE = 4;
    private static final int NO_CNG_STATION_ALONG_ROUTE_CHOICE = 5;
    private static final int NO_FUEL_TYPE_CHOICE = 0;
    private static final int FUEL_TYPE_CNG_CHOICE = 1;
    private static final int FUEL_TYPE_DIESEL_CHOICE = 2;

    public FuelWarningSequenceModelAccess(NavigationEnv navigationEnv, BaseListModelListener baseListModelListener, IEvoListRowBuilder iEvoListRowBuilder, int n, int n2) {
        super(navigationEnv, baseListModelListener, iEvoListRowBuilder, n);
        this.maximumResults = n2;
    }

    public void onUpdateResultList(LIValueList lIValueList, long l, String string, boolean bl, int n, int n2) {
        this.logChannel.log(10000000, "FuelWarningSequenceModelAccess#onUpdateResultList( %2, %3, %1) WAS CALLED BUT IGNORED", (Object)string, (Object)lIValueList, l);
    }

    public void onUpdateResultList(LIValueList lIValueList, long l, String string, boolean bl) {
        this.logChannel.log(10000000, "FuelWarningSequenceModelAccess#onUpdateResultList( %2, %3, %1)", (Object)string, (Object)lIValueList, l);
        if (!Util.isListValid(lIValueList) || lIValueList.getList().length == 0) {
            this.previewListModel.removeAll();
            int n = 401031;
            if (n == 0) {
                this.env.getChoiceModel(401707).setValue(0);
            } else if (n == 1) {
                this.env.getChoiceModel(401707).setValue(4);
            } else if (n == 2) {
                this.env.getChoiceModel(401707).setValue(2);
            }
            return;
        }
        LIValueListElement[] lIValueListElementArray = lIValueList.getList();
        int n = lIValueListElementArray.length;
        int n2 = this.previewListModel.getLength();
        this.logChannel.log(10000000, "FuelWarningSequenceModelAccess#onUpdateResultList - valueListLength: %1, currentListModelLength: %2", (long)n, (long)n2);
        int n3 = this.maximumResults - n2;
        int n4 = Math.min(n3, n);
        this.logChannel.log(10000000, "FuelWarningSequenceModelAccess#onUpdateResultList - previewlistlength: " + n4);
        try {
            for (int i2 = 0; i2 < n4; ++i2) {
                LIValueListElement lIValueListElement = lIValueListElementArray[i2];
                EvoListRow evoListRow = this.listRowBuilder.buildListRow(lIValueListElement, lIValueListElement.listIndex);
                this.previewListModel.setLength(++n2);
                this.previewListModel.setRow(n2 - 1, evoListRow);
            }
        }
        catch (Exception exception) {
            StringWriter stringWriter = new StringWriter();
            exception.printStackTrace(new PrintWriter(stringWriter));
            this.logChannel.log(10000, "Exception caught in FuelWarningSequenceModelAccess: '%1', stacktrace: %2", (Object)exception, (Object)stringWriter);
        }
    }

    public void onElementSelected(LIValueListElement lIValueListElement) {
    }
}

