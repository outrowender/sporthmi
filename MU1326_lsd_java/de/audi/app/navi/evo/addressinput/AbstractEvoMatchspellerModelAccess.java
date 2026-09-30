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
    public static final int CURSOR_POSITION_COUNTRY = 0;
    public static final int CURSOR_POSITION_CITY = 1;
    public static final int CURSOR_POSITION_STREET = 2;
    public static final int CURSOR_POSITION_HOUSENUMBER = 3;
    public static final int CURSOR_POSITION_CROSSING = 4;
    public static final int CURSOR_POSITION_START_ROUTE_GUIDANCE = 5;
    public static final int CURSOR_POSITION_CITY_CN = 1;
    public static final int CURSOR_POSITION_LOCATION_CN = 2;
    public static final int CURSOR_POSITION_STREET_CN = 3;
    public static final int CURSOR_POSITION_HOUSENUMBER_CN = 4;
    public static final int CURSOR_POSITION_INTERSECTION_CN = 5;
    public static final int CURSOR_POSITION_START_ROUTE_GUIDANCE_CN = 6;
    public static final int CURSOR_POSITION_PERFECTURE_JP = 1;
    public static final int CURSOR_POSITION_CITY_JP = 2;
    public static final int CURSOR_POSITION_FACILITY_JP = 3;
    public static final int CURSOR_POSITION_PLACENAME_JP = 4;
    public static final int CURSOR_POSITION_CHOMENUMBER_JP = 5;
    public static final int CURSOR_POSITION_START_ROUTE_GUIDANCE_JP = 6;
    public static final int CURSOR_POSITION_PROVINCE_KR = 1;
    public static final int CURSOR_POSITION_CITY_KR = 2;
    public static final int CURSOR_POSITION_FACILITY_KR = 3;
    public static final int CURSOR_POSITION_TOWNSTREET_KR = 4;
    public static final int CURSOR_POSITION_NUMBER_KR = 5;
    public static final int CURSOR_POSITION_START_ROUTE_GUIDANCE_KR = 6;

    protected AbstractEvoMatchspellerModelAccess(NavigationEnv navigationEnv, int n, int n2, IAddressInputFormModelAccessHelper iAddressInputFormModelAccessHelper) {
        super(navigationEnv, n, n2, iAddressInputFormModelAccessHelper);
    }

    public void onUpdateLocation(NavLocation navLocation, Map map) {
        this.modelAccessHelper.onUpdateLocation(this.env, this.logChannel, navLocation, map);
    }

    public void onUpdateResultList(LIValueList lIValueList, long l, String string, boolean bl, int n, int n2) {
        LIValueListElement[] lIValueListElementArray;
        this.logChannel.log(10000000, "%1#onUpdateResultList - matchCount=%2, currentInput=%3, fullMatch=%4", (Object)this.CLASS_NAME, (Object)("" + l), (Object)string, (Object)Boolean.toString(bl));
        int n3 = Util.isEmpty(string) ? 0 : 1;
        LIValueListElement[] lIValueListElementArray2 = lIValueListElementArray = Util.isListValid(lIValueList) ? lIValueList.getList() : new LIValueListElement[]{};
        if (Util.isEmpty(string)) {
            this.matchSpellerModelApp.setCompletionText("");
        }
        this.previewListModelApp.setLength((int)l);
        EvoListRow[] evoListRowArray = new AddressInputLIValueListElementListRow[lIValueListElementArray.length];
        for (int i2 = 0; i2 < lIValueListElementArray.length; ++i2) {
            evoListRowArray[i2] = new AddressInputLIValueListElementListRow(lIValueListElementArray[i2], 698976777, new int[0]);
        }
        this.previewListModelApp.setRows(n, n2, evoListRowArray);
        this.matchSpellerModelApp.setMatchCount((int)l, n3);
    }

    public void onSpellerStatusChanged(int n) {
    }
}

