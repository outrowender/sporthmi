/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.sds;

import de.audi.app.navi.evo.addressinput.poi.listbuilders.EvoRRDInitialPositionHandler;
import de.audi.app.navi.evo.sds.SUIListRowBuilder$SUIEvoListRow;
import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.NaviService$NaviSUIDetails;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.Distance;
import de.audi.tghu.navi.app.IListRowBuilder;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.sds.ISUIListRowBuilder;
import de.audi.tghu.navi.app.slidinglist.poi.RRDInitialPositionHandler;
import org.dsi.ifc.navigation.LIValueListElement;

public class SUIListRowBuilder
implements ISUIListRowBuilder,
IListRowBuilder {
    static final int LAYOUT_VDE_ADDRESSES;
    static final int LAYOUT_ADB_CONTACT;
    static final int LAYOUT_POI_CATEGORY_DYNAMIC;
    static final int LAYOUT_POI_CATEGORY_STATIC;
    static final int LAYOUT_POI_RESULT_DYNAMIC;
    static final int LAYOUT_POI_RESULT_STATIC;
    static final int LAYOUT_VDE_ADDRESSES_SINGLE_LINE;
    static final int COLUMN_LAYOUT;
    static final int COLUMN_ICON;
    static final int COLUMN_TEXT_LINE1;
    static final int COLUMN_TEXT_LINE2;
    static final int COLUMN_DISTANCE;
    static final int COLUMN_DIRECTION_ARROW;
    final int COLUMN_COUNT;
    final int ICON_ADB;
    final int ICON_VDE;
    private final LogChannel logChannel;
    private final IconHandler iconHandler;
    private final NavigationEnv env;
    private RRDInitialPositionHandler rrdInitialPositionHandler;

    private SUIListRowBuilder(LogChannel logChannel, IconHandler iconHandler, NavigationEnv navigationEnv) {
        this.COLUMN_COUNT = 7;
        this.ICON_ADB = 0;
        this.ICON_VDE = 1;
        this.logChannel = logChannel;
        this.iconHandler = iconHandler;
        this.env = navigationEnv;
    }

    private SUIListRowBuilder(LogChannel logChannel, IconHandler iconHandler, IRouteManager iRouteManager, NavigationEnv navigationEnv, IVehicle iVehicle) {
        this(logChannel, iconHandler, navigationEnv);
        this.rrdInitialPositionHandler = new EvoRRDInitialPositionHandler(iRouteManager, navigationEnv, iVehicle);
    }

    public static SUIListRowBuilder createSUIListRowBuilderDistanceFromCCP(LogChannel logChannel, IconHandler iconHandler, IRouteManager iRouteManager, NavigationEnv navigationEnv, IVehicle iVehicle) {
        return new SUIListRowBuilder(logChannel, iconHandler, iRouteManager, navigationEnv, iVehicle);
    }

    @Override
    public EvoListRow buildEvoListRow(NaviService$NaviSUIDetails naviService$NaviSUIDetails, int n) {
        return new SUIListRowBuilder$SUIEvoListRow(this, null, naviService$NaviSUIDetails, n, this.rrdInitialPositionHandler.getInitialPosition(), null);
    }

    @Override
    public EvoListRow buildEvoListRow(LIValueListElement lIValueListElement, int n) {
        return new SUIListRowBuilder$SUIEvoListRow(this, lIValueListElement, null, n, this.rrdInitialPositionHandler.getInitialPosition(), null);
    }

    @Override
    public ListCell[] buildListRow(LIValueListElement lIValueListElement, int n) {
        this.logChannel.log(-1601830656, "SUIEvoListRow#buildListRow() returning ListCell[] is not supported");
        return new ListCell[0];
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    public static String getName(EvoListRow evoListRow) {
        return evoListRow.getText(2);
    }

    public static Distance getDistance(EvoListRow evoListRow) {
        return (Distance)evoListRow.getMetrics(5);
    }

    public static LIValueListElement getLiValueListElement(EvoListRow evoListRow) {
        return ((SUIListRowBuilder$SUIEvoListRow)evoListRow).getElement();
    }

    public static int getIconResourceId(EvoListRow evoListRow) {
        return ((HMIResourceLocator)evoListRow.getCell(1)).getResourceID();
    }

    public static String getCategoryName(EvoListRow evoListRow) {
        return evoListRow.getText(2);
    }

    public static long getId(EvoListRow evoListRow) {
        return SUIListRowBuilder$SUIEvoListRow.access$100((SUIListRowBuilder$SUIEvoListRow)evoListRow);
    }

    static /* synthetic */ IconHandler access$200(SUIListRowBuilder sUIListRowBuilder) {
        return sUIListRowBuilder.iconHandler;
    }

    static /* synthetic */ LogChannel access$300(SUIListRowBuilder sUIListRowBuilder) {
        return sUIListRowBuilder.logChannel;
    }

    static /* synthetic */ NavigationEnv access$400(SUIListRowBuilder sUIListRowBuilder) {
        return sUIListRowBuilder.env;
    }
}

