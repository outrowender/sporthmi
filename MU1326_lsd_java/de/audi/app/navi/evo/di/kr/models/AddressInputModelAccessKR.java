/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.kr.models;

import de.audi.app.navi.evo.addressinput.AddressInputLIValueListElementListRow;
import de.audi.app.navi.evo.di.AbstractAddressInputModelAccessEvo;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.MatchspellerModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IAddressInputFormModelAccessHelper;
import de.audi.tghu.navi.app.util.Util;
import java.util.Map;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

public class AddressInputModelAccessKR
extends AbstractAddressInputModelAccessEvo {
    protected final NavigationEnv env;
    protected final LogChannel logChannel;
    protected final MatchspellerModelApp matchSpellerModelApp;
    protected final TiledListModelApp previewListModelApp;
    protected final ChoiceModelApp reInitNDFScreenModel;

    public AddressInputModelAccessKR(NavigationEnv navigationEnv, int n, int n2, IAddressInputFormModelAccessHelper iAddressInputFormModelAccessHelper) {
        super(iAddressInputFormModelAccessHelper);
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getAddressInputLogChannel();
        this.matchSpellerModelApp = navigationEnv.getMatchSpellerModel(n);
        this.previewListModelApp = navigationEnv.getTiledListModel(n2);
        this.reInitNDFScreenModel = navigationEnv.getChoiceModel(402172);
    }

    public void onInputChanged() {
        this.previewListModelApp.removeAll();
    }

    public void onStart(NavLocation navLocation) {
        Util.setModelStatus(this.matchSpellerModelApp, 1);
        this.matchSpellerModelApp.clear();
        this.matchSpellerModelApp.setMatchCount(-1);
        this.previewListModelApp.clearAll();
        this.reInitNDFScreenModel.setValue(0);
    }

    public void onUpdateSpeller(String string, String string2, boolean bl, boolean bl2) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#onUpdateSpeller(%1, %2, %3, %4)", (Object)string, (Object)string2, (Object)(bl + ""), (Object)(bl2 + ""));
        int n = bl2 ? 1 : 0;
        this.matchSpellerModelApp.setText(string2);
        this.matchSpellerModelApp.setValidChars(string, n);
        this.matchSpellerModelApp.setFullMatch(bl);
        Util.setModelStatus(this.matchSpellerModelApp, 1);
    }

    public void onUpdateResultList(LIValueList lIValueList, long l, String string, boolean bl, int n, int n2) {
        int n3;
        this.logChannel.log(10000000, this.CLASS_NAME + "#onUpdateResultList with matchCount = %1, currentInput = %2, valueList = %3", (Object)Long.toString(l), (Object)string, (Object)lIValueList);
        if (Util.isEmpty(string)) {
            this.matchSpellerModelApp.setCompletionText("");
        }
        LIValueListElement[] lIValueListElementArray = Util.isListValid(lIValueList) ? lIValueList.getList() : new LIValueListElement[]{};
        EvoListRow[] evoListRowArray = new AddressInputLIValueListElementListRow[lIValueListElementArray.length];
        for (n3 = 0; n3 < lIValueListElementArray.length; ++n3) {
            evoListRowArray[n3] = new AddressInputLIValueListElementListRow(lIValueListElementArray[n3], 698976777, new int[0]);
        }
        this.previewListModelApp.setLength((int)l);
        this.previewListModelApp.setRows(n, n2, evoListRowArray);
        if (l > 0L && l <= 5L) {
            this.logChannel.log(10000000, this.CLASS_NAME + "#onUpdateResultList automatically select first item when the amount of result list is less than 5");
            n3 = Util.isEmpty(string) ? 0 : 1;
            this.matchSpellerModelApp.setMatchCount((int)l, n3);
        }
    }

    public void onUpdateLocation(NavLocation navLocation, Map map) {
        this.modelAccessHelper.onUpdateLocation(this.env, this.logChannel, navLocation, map);
    }

    public void unrequestItems(int n, int n2) {
        this.previewListModelApp.clearRows(n, n2);
    }

    public void onUpdateResultList(LIValueList lIValueList, long l, String string, boolean bl) {
    }

    public void onElementSelected(NavLocation navLocation) {
    }

    public void onAmbiguousElementSelected() {
    }

    public void onRestore() {
    }
}

