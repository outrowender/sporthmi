/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput;

import de.audi.app.navi.evo.addressinput.AddressInputLIValueListElementListRow;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.AbstractMatchspellerModelAccess;
import de.audi.tghu.navi.app.addressinput.IAddressInputFormModelAccessHelper;
import de.audi.tghu.navi.app.util.Util;
import java.util.Map;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

public abstract class AbstractEvoMatchspellerModelAccess
extends AbstractMatchspellerModelAccess {
    public static final int CURSOR_POSITION_COUNTRY;
    public static final int CURSOR_POSITION_CITY;
    public static final int CURSOR_POSITION_STREET;
    public static final int CURSOR_POSITION_HOUSENUMBER;
    public static final int CURSOR_POSITION_CROSSING;
    public static final int CURSOR_POSITION_START_ROUTE_GUIDANCE;
    public static final int CURSOR_POSITION_CITY_CN;
    public static final int CURSOR_POSITION_LOCATION_CN;
    public static final int CURSOR_POSITION_STREET_CN;
    public static final int CURSOR_POSITION_HOUSENUMBER_CN;
    public static final int CURSOR_POSITION_INTERSECTION_CN;
    public static final int CURSOR_POSITION_START_ROUTE_GUIDANCE_CN;
    public static final int CURSOR_POSITION_PERFECTURE_JP;
    public static final int CURSOR_POSITION_CITY_JP;
    public static final int CURSOR_POSITION_FACILITY_JP;
    public static final int CURSOR_POSITION_PLACENAME_JP;
    public static final int CURSOR_POSITION_CHOMENUMBER_JP;
    public static final int CURSOR_POSITION_START_ROUTE_GUIDANCE_JP;
    public static final int CURSOR_POSITION_PROVINCE_KR;
    public static final int CURSOR_POSITION_CITY_KR;
    public static final int CURSOR_POSITION_FACILITY_KR;
    public static final int CURSOR_POSITION_TOWNSTREET_KR;
    public static final int CURSOR_POSITION_NUMBER_KR;
    public static final int CURSOR_POSITION_START_ROUTE_GUIDANCE_KR;

    protected AbstractEvoMatchspellerModelAccess(NavigationEnv navigationEnv, int n, int n2, IAddressInputFormModelAccessHelper iAddressInputFormModelAccessHelper) {
        super(navigationEnv, n, n2, iAddressInputFormModelAccessHelper);
    }

    @Override
    public void onUpdateLocation(NavLocation navLocation, Map map) {
        this.modelAccessHelper.onUpdateLocation(this.env, this.logChannel, navLocation, map);
    }

    @Override
    public void onUpdateResultList(LIValueList lIValueList, long l, String string, boolean bl, int n, int n2) {
        LIValueListElement[] lIValueListElementArray;
        this.logChannel.log(-2137614336, "%1#onUpdateResultList - matchCount=%2, currentInput=%3, fullMatch=%4", (Object)this.CLASS_NAME, (Object)new StringBuffer().append("").append(l).toString(), (Object)string, (Object)Boolean.toString(bl));
        int n3 = Util.isEmpty(string) ? 0 : 1;
        LIValueListElement[] lIValueListElementArray2 = lIValueListElementArray = Util.isListValid(lIValueList) ? lIValueList.getList() : new LIValueListElement[]{};
        if (Util.isEmpty(string)) {
            this.matchSpellerModelApp.setCompletionText("");
        }
        this.previewListModelApp.setLength((int)l);
        EvoListRow[] evoListRowArray = new AddressInputLIValueListElementListRow[lIValueListElementArray.length];
        for (int i2 = 0; i2 < lIValueListElementArray.length; ++i2) {
            evoListRowArray[i2] = new AddressInputLIValueListElementListRow(lIValueListElementArray[i2], 160082217, new int[0]);
        }
        this.previewListModelApp.setRows(n, n2, evoListRowArray);
        this.matchSpellerModelApp.setMatchCount((int)l, n3);
    }

    @Override
    public void onSpellerStatusChanged(int n) {
    }
}

