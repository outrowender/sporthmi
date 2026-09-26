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
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.util.Util;
import java.util.Map;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

public class PoiAreaCityZipInputModelAccess
implements IMatchspellerModelAccess {
    private final NavigationEnv env;
    private final MatchspellerModelApp matchSpellerModelApp;
    private final TiledListModelApp previewListModelApp;
    private final LogChannel logChannel;

    public PoiAreaCityZipInputModelAccess(NavigationEnv navigationEnv, MatchSpellerListener matchSpellerListener, TiledListModelListener tiledListModelListener) {
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getLogChannel();
        this.matchSpellerModelApp = navigationEnv.getMatchSpellerModel(-1843722752);
        this.matchSpellerModelApp.setSpellerListener(matchSpellerListener);
        this.matchSpellerModelApp.setMaxLength(128);
        this.previewListModelApp = navigationEnv.getTiledListModel(1847526912);
        this.previewListModelApp.setListener(tiledListModelListener);
    }

    public MatchspellerModelApp getMatchspellerModelApp() {
        return this.matchSpellerModelApp;
    }

    @Override
    public void onInputChanged() {
        this.previewListModelApp.removeAll();
    }

    @Override
    public void onStart(NavLocation navLocation) {
        Util.setModelStatus(this.matchSpellerModelApp, 0);
        this.matchSpellerModelApp.clear();
        this.matchSpellerModelApp.setMatchCount(-1);
        this.matchSpellerModelApp.setCountryAbbreviation(navLocation.getCountryAbbreviation());
        this.previewListModelApp.removeAll();
    }

    @Override
    public void onUpdateSpeller(String string, String string2, boolean bl, boolean bl2) {
        if (this.env.getPOILogChannel().isDebug2()) {
            this.env.getPOILogChannel().log(14808325, "PoiAreaCityZipInputModelAccess#onUpdateSpeller");
        }
        int n = bl2 ? 1 : 0;
        this.matchSpellerModelApp.setFullMatch(bl);
        this.matchSpellerModelApp.setText(string2);
        this.matchSpellerModelApp.setValidChars(string, n);
        Util.setModelStatus(this.matchSpellerModelApp, 1);
    }

    @Override
    public void onUpdateResultList(LIValueList lIValueList, long l, String string, boolean bl) {
        if (!Util.isListValid(lIValueList) || lIValueList.getList().length == 0) {
            this.logChannel.log(-2137614336, "[PoiSearchArea] PoiAreaCityZipInputModelAccess#onUpdateResultList() - invalid value list: %1", (Object)lIValueList);
            this.previewListModelApp.removeAll();
            this.previewListModelApp.clearAll();
            return;
        }
        int n = Util.isEmpty(string) ? 0 : 1;
        this.matchSpellerModelApp.setMatchCount((int)l, n);
        LIValueListElement[] lIValueListElementArray = Util.isListValid(lIValueList) ? lIValueList.getList() : new LIValueListElement[]{};
        int n2 = lIValueListElementArray.length;
        this.matchSpellerModelApp.setCompletionText("");
        EvoListRow[] evoListRowArray = new EvoListRow[n2];
        this.previewListModelApp.setLength((int)l);
        for (int i2 = 0; i2 < n2; ++i2) {
            evoListRowArray[i2] = new AddressInputLIValueListElementListRow(lIValueListElementArray[i2], 160082217, new int[0]);
        }
        this.previewListModelApp.setRows(-1, 0, evoListRowArray);
    }

    @Override
    public void onElementSelected(NavLocation navLocation) {
        if (navLocation == null) {
            this.env.getLogChannel().log(10000, "AbstractModelAccess#onElementSelected the given navLocation is null");
            return;
        }
    }

    @Override
    public void onAmbiguousElementSelected() {
    }

    @Override
    public void onUpdateResultList(LIValueList lIValueList, long l, String string, boolean bl, int n, int n2) {
        this.logChannel.log(-2137614336, "PoiAreaCityZipInputModelAccess#onUpdateResultList( %1, %2, %3 )", (Object)lIValueList, (Object)string, l);
        this.logChannel.log(-2137614336, "PoiAreaCityZipInputModelAccess#onUpdateResultList( %1, %2 )", (long)n, (long)n2);
        if (!Util.isListValid(lIValueList) || lIValueList.getList().length == 0) {
            this.logChannel.log(-2137614336, "[PoiInputModel] AbstractPoiBaseListModelAccess#onUpdateResultList() - invalid value list: %1", (Object)lIValueList);
            this.previewListModelApp.removeAll();
            this.previewListModelApp.clearAll();
            return;
        }
        int n3 = Util.isEmpty(string) ? 0 : 1;
        this.matchSpellerModelApp.setMatchCount((int)l, n3);
        LIValueListElement[] lIValueListElementArray = Util.isListValid(lIValueList) ? lIValueList.getList() : new LIValueListElement[]{};
        int n4 = lIValueListElementArray.length;
        this.matchSpellerModelApp.setCompletionText("");
        EvoListRow[] evoListRowArray = new EvoListRow[n4];
        this.previewListModelApp.setLength((int)l);
        for (int i2 = 0; i2 < n4; ++i2) {
            evoListRowArray[i2] = new AddressInputLIValueListElementListRow(lIValueListElementArray[i2], 160082217, new int[0]);
        }
        this.previewListModelApp.setRows(n, n2, evoListRowArray);
    }

    @Override
    public void onRestore() {
    }

    @Override
    public void onUpdateLocation(NavLocation navLocation, Map map) {
    }

    @Override
    public void unrequestItems(int n, int n2) {
        this.previewListModelApp.clearRows(n, n2);
    }

    @Override
    public void onSpellerStatusChanged(int n) {
    }
}

