/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.mapcode;

import de.audi.atip.hmi.modelaccess.MatchspellerModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.util.Util;
import java.util.Map;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

public class MapcodeMatchSpellerModelAccess
implements IMatchspellerModelAccess {
    private final NavigationEnv env;
    private final LogChannel logChannel;
    private final MatchspellerModelApp matchSpellerModelApp;

    public MapcodeMatchSpellerModelAccess(NavigationEnv navigationEnv, LogChannel logChannel, int n, int n2) {
        this.env = navigationEnv;
        this.logChannel = logChannel;
        this.matchSpellerModelApp = navigationEnv.getMatchSpellerModel(n);
    }

    public void onStart(NavLocation navLocation) {
        Util.setModelStatus(this.matchSpellerModelApp, 0);
        this.matchSpellerModelApp.clear();
        this.matchSpellerModelApp.setMatchCount(-1);
    }

    public void onUpdateSpeller(String string, String string2, boolean bl, boolean bl2) {
        this.logChannel.log(10000000, "MapcodeMatchSpellerModelAccess#onUpdateSpeller(%1, %2, %3, %4)", (Object)string, (Object)string2, (Object)(bl + ""), (Object)(bl2 + ""));
        int n = bl2 ? 1 : 0;
        this.matchSpellerModelApp.setText(string2);
        this.matchSpellerModelApp.setValidChars(string, n);
        this.matchSpellerModelApp.setFullMatch(bl);
        Util.setModelStatus(this.matchSpellerModelApp, 1);
        LIValueList lIValueList = this.env.getContainer().getLispValueList();
        if (Util.isListValid(lIValueList) && lIValueList.getList().length == 1) {
            LIValueListElement lIValueListElement = lIValueList.getList()[0];
            if (lIValueListElement.validDestination && lIValueListElement.latitude != 0 && lIValueListElement.longitude != 0) {
                this.logChannel.log(10000000, "MapcodeMatchSpellerModelAccess#onUpdateSpeller -- checkStartRGButtonStatus: returned value is valid");
                Util.setModelStatus(this.matchSpellerModelApp, 1);
            } else {
                this.logChannel.log(10000000, "MapcodeMatchSpellerModelAccess#onUpdateSpeller -- checkStartRGButtonStatus: returned value is invalid");
                Util.setModelStatus(this.matchSpellerModelApp, 0);
            }
        } else if ("".equals(string2.trim()) || lIValueList.getList().length == 0) {
            this.logChannel.log(10000000, "MapcodeMatchSpellerModelAccess#onUpdateSpeller -- checkStartRGButtonStatus: no valid list or current speller input is empty");
            Util.setModelStatus(this.matchSpellerModelApp, 0);
        } else {
            Util.setModelStatus(this.matchSpellerModelApp, 1);
        }
    }

    public void onUpdateResultList(LIValueList lIValueList, long l, String string, boolean bl, int n, int n2) {
    }

    public void onRestore() {
    }

    public void onUpdateLocation(NavLocation navLocation, Map map) {
    }

    public void onUpdateResultList(LIValueList lIValueList, long l, String string, boolean bl) {
    }

    public void onElementSelected(NavLocation navLocation) {
    }

    public void onAmbiguousElementSelected() {
    }

    public void unrequestItems(int n, int n2) {
    }

    public void onInputChanged() {
    }

    public void onSpellerStatusChanged(int n) {
    }
}

