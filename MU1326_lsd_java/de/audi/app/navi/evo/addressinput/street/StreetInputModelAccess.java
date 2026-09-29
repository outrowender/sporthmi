/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.street;

import de.audi.app.navi.evo.addressinput.AbstractEvoMatchspellerModelAccess;
import de.audi.app.navi.evo.addressinput.AddressInputLIValueListElementListRow;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IAddressInputFormModelAccessHelper;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

public class StreetInputModelAccess
extends AbstractEvoMatchspellerModelAccess {
    public StreetInputModelAccess(NavigationEnv navigationEnv, int n, int n2, IAddressInputFormModelAccessHelper iAddressInputFormModelAccessHelper) {
        super(navigationEnv, n, n2, iAddressInputFormModelAccessHelper);
    }

    @Override
    public void onElementSelected(NavLocation navLocation) {
        super.onElementSelected(navLocation);
        this.env.getChoiceModel(-1172634112).setValue(0);
    }

    @Override
    public void onAmbiguousElementSelected() {
        this.env.getChoiceModel(-1172634112).setValue(1);
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
            evoListRowArray[i2] = new AddressInputLIValueListElementListRow(lIValueListElementArray[i2], 160082217);
        }
        this.previewListModelApp.setRows(n, n2, evoListRowArray);
        this.matchSpellerModelApp.setMatchCount((int)l, n3);
    }
}

