/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.country;

import de.audi.app.navi.evo.addressinput.AbstractEvoMatchspellerModelAccess;
import de.audi.app.navi.evo.addressinput.AddressInputLIValueListElementListRow;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IAddressInputFormModelAccessHelper;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

public class CountryInputModelAccess
extends AbstractEvoMatchspellerModelAccess {
    public CountryInputModelAccess(NavigationEnv navigationEnv, int n, int n2, IAddressInputFormModelAccessHelper iAddressInputFormModelAccessHelper) {
        super(navigationEnv, n, n2, iAddressInputFormModelAccessHelper);
    }

    @Override
    public void onUpdateResultList(LIValueList lIValueList, long l, String string, boolean bl, int n, int n2) {
        LIValueListElement[] lIValueListElementArray;
        int n3 = Util.isEmpty(string) ? 0 : 1;
        this.matchSpellerModelApp.setMatchCount((int)l, n3);
        this.clearNotOverriddenRows(lIValueList, l);
        LIValueListElement[] lIValueListElementArray2 = lIValueListElementArray = Util.isListValid(lIValueList) ? lIValueList.getList() : new LIValueListElement[]{};
        if (Util.isEmpty(string)) {
            this.matchSpellerModelApp.setCompletionText("");
        }
        this.previewListModelApp.setLength((int)l);
        EvoListRow[] evoListRowArray = new AddressInputLIValueListElementListRow[lIValueListElementArray.length];
        for (int i2 = 0; i2 < lIValueListElementArray.length; ++i2) {
            evoListRowArray[i2] = new AddressInputLIValueListElementListRow(lIValueListElementArray[i2], -1, new int[0]);
        }
        this.previewListModelApp.setRows(n, n2, evoListRowArray);
    }

    private void clearNotOverriddenRows(LIValueList lIValueList, long l) {
        int n = lIValueList.getList().length;
        if (l > (long)n) {
            this.previewListModelApp.clearRows(n, this.previewListModelApp.getLength() - 1);
        }
    }
}

