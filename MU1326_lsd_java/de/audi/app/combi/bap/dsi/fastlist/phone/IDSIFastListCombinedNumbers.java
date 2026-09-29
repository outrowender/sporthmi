/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.dsi.fastlist.phone;

import de.audi.app.combi.bap.dsi.fastlist.phone.IDSIFastListPhone;
import org.dsi.ifc.kombifastlist.DataCombinedNumbers;

public interface IDSIFastListCombinedNumbers
extends IDSIFastListPhone {
    default public void pushCombinedNumbers(DataCombinedNumbers[] dataCombinedNumbersArray) {
    }

    default public void pushCurrentListSizeCombinedNumbers(int n) {
    }

    default public void responseNotifyCombinedNumbersPush(boolean bl) {
    }
}

