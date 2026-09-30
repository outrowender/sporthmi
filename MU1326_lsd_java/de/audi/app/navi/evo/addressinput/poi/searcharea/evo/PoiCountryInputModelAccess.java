/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.searcharea.evo;

import de.audi.app.navi.evo.addressinput.AddressInputLIValueListElementListRow;
import de.audi.atip.hmi.model.MatchSpellerListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.hmi.model.list.TiledListModelListener;
import de.audi.atip.hmi.modelaccess.MatchspellerModelApp;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import java.util.Map;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

public class PoiCountryInputModelAccess
implements IMatchspellerModelAccess {
    protected final NavigationEnv env;
    protected final MatchspellerModelApp matchSpellerModelApp;
    protected final TiledListModelApp previewListModel;

    public PoiCountryInputModelAccess(NavigationEnv navigationEnv, MatchSpellerListener matchSpellerListener, TiledListModelListener tiledListModelListener) {
        this.env = navigationEnv;
        this.matchSpellerModelApp = navigationEnv.getMatchSpellerModel(400296);
        this.matchSpellerModelApp.setSpellerListener(matchSpellerListener);
        this.matchSpellerModelApp.setMaxLength(128);
        this.previewListModel = navigationEnv.getTiledListModel(401264);
        this.previewListModel.setListener(tiledListModelListener);
    }

    public void onInputChanged() {
        this.previewListModel.removeAll();
    }

    public void onStart(NavLocation navLocation) {
        Util.setModelStatus(this.matchSpellerModelApp, 0);
        this.matchSpellerModelApp.clear();
        this.matchSpellerModelApp.setMatchCount(-1);
        this.matchSpellerModelApp.setCountryAbbreviation(navLocation.getCountryAbbreviation());
        this.previewListModel.removeAll();
    }

    public void onUpdateSpeller(String string, String string2, boolean bl, boolean bl2) {
        int n = bl2 ? 1 : 0;
        this.matchSpellerModelApp.setFullMatch(bl);
        this.matchSpellerModelApp.setText(string2);
        this.matchSpellerModelApp.setValidChars(string, n);
        Util.setModelStatus(this.matchSpellerModelApp, 1);
    }

    public void onElementSelected(NavLocation navLocation) {
        if (navLocation == null) {
            this.env.getLogChannel().log(10000, "PoiCountryInputModelAccess#onElementSelected the given navLocation is null");
            return;
        }
        String string = navLocation.getCountry();
        if (Util.isHURegionNAR()) {
            string = LocationFormatter.formatState(navLocation);
        }
        if (Util.isEmpty(string)) {
            string = LocationFormatter.formatCountry(navLocation);
        }
        this.env.getTextfieldModel(400278).setText1(string);
    }

    public void onAmbiguousElementSelected() {
    }

    public MatchspellerModelApp getMatchspellerModelApp() {
        return this.matchSpellerModelApp;
    }

    public void onUpdateResultList(LIValueList lIValueList, long l, String string, boolean bl, int n, int n2) {
        LIValueListElement[] lIValueListElementArray;
        int n3 = Util.isEmpty(string) ? 0 : 1;
        this.matchSpellerModelApp.setMatchCount((int)l, n3);
        this.clearNotOverriddenRows(lIValueList, l);
        LIValueListElement[] lIValueListElementArray2 = lIValueListElementArray = Util.isListValid(lIValueList) ? lIValueList.getList() : new LIValueListElement[]{};
        if (Util.isEmpty(string)) {
            this.matchSpellerModelApp.setCompletionText("");
        }
        this.previewListModel.setLength((int)l);
        EvoListRow[] evoListRowArray = new AddressInputLIValueListElementListRow[lIValueListElementArray.length];
        for (int i2 = 0; i2 < lIValueListElementArray.length; ++i2) {
            evoListRowArray[i2] = new AddressInputLIValueListElementListRow(lIValueListElementArray[i2], 698976777, new int[0]);
        }
        this.previewListModel.setRows(n, n2, evoListRowArray);
    }

    private void clearNotOverriddenRows(LIValueList lIValueList, long l) {
        int n = lIValueList.getList().length;
        if (l > (long)n) {
            this.previewListModel.clearRows(n, this.previewListModel.getLength() - 1);
        }
    }

    public void onUpdateResultList(LIValueList lIValueList, long l, String string, boolean bl) {
    }

    public void onRestore() {
    }

    public void onUpdateLocation(NavLocation navLocation, Map map) {
    }

    public void onSpellerStatusChanged(int n) {
    }

    public void unrequestItems(int n, int n2) {
        this.previewListModel.clearRows(n, n2);
    }
}

