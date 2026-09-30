/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.phonenumber;

import de.audi.app.navi.evo.addressinput.AddressInputLIValueListElementListRow;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.hmi.modelaccess.MatchspellerModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.util.Util;
import java.util.Map;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

public class PhonenumberMatchSpellerModelAccess
implements IMatchspellerModelAccess {
    private final LogChannel logChannel;
    private final MatchspellerModelApp matchSpellerModelApp;
    private final TiledListModelApp previewListModelApp;
    private final NavigationEnv env;

    public PhonenumberMatchSpellerModelAccess(NavigationEnv navigationEnv, LogChannel logChannel, int n, int n2) {
        this.logChannel = logChannel;
        this.matchSpellerModelApp = navigationEnv.getMatchSpellerModel(n);
        this.previewListModelApp = navigationEnv.getTiledListModel(n2);
        this.env = navigationEnv;
    }

    public void onStart(NavLocation navLocation) {
        Util.setModelStatus(this.matchSpellerModelApp, 0);
        this.matchSpellerModelApp.clear();
        this.matchSpellerModelApp.setMatchCount(-1);
    }

    public void onInputChanged() {
        this.previewListModelApp.removeAll();
    }

    public void onUpdateSpeller(String string, String string2, boolean bl, boolean bl2) {
        this.logChannel.log(10000000, "PhonenumberMatchSpellerModelAccess#onUpdateSpeller(%1, %2, %3, %4)", (Object)string, (Object)string2, (Object)(bl + ""), (Object)(bl2 + ""));
        int n = bl2 ? 1 : 0;
        this.matchSpellerModelApp.setText(string2);
        this.matchSpellerModelApp.setValidChars(string, n);
        this.matchSpellerModelApp.setFullMatch(bl);
        Util.setModelStatus(this.matchSpellerModelApp, 1);
    }

    public void onUpdateResultList(LIValueList lIValueList, long l, String string, boolean bl, int n, int n2) {
        int n3;
        this.logChannel.log(10000000, "PhonenumberMatchSpellerModelAccess#onUpdateResultList with matchCount = %1, currentInput = %2, valueList = %3", (Object)Long.toString(l), (Object)string, (Object)lIValueList);
        if (Util.isEmpty(string)) {
            this.matchSpellerModelApp.setCompletionText("");
        }
        LIValueListElement[] lIValueListElementArray = Util.isListValid(lIValueList) ? lIValueList.getList() : new LIValueListElement[]{};
        EvoListRow[] evoListRowArray = new AddressInputLIValueListElementListRow[lIValueListElementArray.length];
        for (n3 = 0; n3 < lIValueListElementArray.length; ++n3) {
            evoListRowArray[n3] = new AddressInputLIValueListElementListRow(lIValueListElementArray[n3], 1055316784, new int[0]);
        }
        if (lIValueListElementArray.length > 0) {
            this.previewListModelApp.setLength((int)l);
        } else {
            this.previewListModelApp.setLength(0);
        }
        this.previewListModelApp.setRows(n, n2, evoListRowArray);
        if (l == 1L) {
            this.matchSpellerModelApp.setCommandAvailable(7, true);
        } else {
            this.matchSpellerModelApp.setCommandAvailable(7, false);
        }
        if (l > 0L && l <= 4L) {
            this.logChannel.log(10000000, "PhonenumberMatchSpellerModelAccess#onUpdateResultList automatically select first item when the amount of result list is less than 4");
            n3 = Util.isEmpty(string) ? 0 : 1;
            this.matchSpellerModelApp.setMatchCount((int)l, n3);
        }
    }

    public void unrequestItems(int n, int n2) {
        this.previewListModelApp.clearRows(n, n2);
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

    public void onSpellerStatusChanged(int n) {
    }
}

