/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.dsi.fastlist.phone;

import de.audi.app.combi.bap.dsi.fastlist.phone.IDSIFastListPhone;
import org.dsi.ifc.kombifastlist.DataCombinedNumbers;

public interface IDSIFastListCombinedNumbers
extends IDSIFastListPhone {
    public void pushCombinedNumbers(DataCombinedNumbers[] var1);

    public void pushCurrentListSizeCombinedNumbers(int var1);

    public void responseNotifyCombinedNumbersPush(boolean var1);
}

