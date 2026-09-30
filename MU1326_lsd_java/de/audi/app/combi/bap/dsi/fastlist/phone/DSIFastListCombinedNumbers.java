/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.dsi.fastlist.phone;

import de.audi.app.combi.bap.dsi.fastlist.phone.DSIFastListPhone;
import de.audi.app.combi.bap.dsi.fastlist.phone.FastListPhoneSizes;
import de.audi.app.combi.bap.dsi.fastlist.phone.IDSIFastListCombinedNumbers;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.kombifastlist.DataCombinedNumbers;

public final class DSIFastListCombinedNumbers
extends DSIFastListPhone
implements IDSIFastListCombinedNumbers {
    public void pushCombinedNumbers(DataCombinedNumbers[] dataCombinedNumbersArray) {
        this.dsiLogChannel.log(1000000, "[DSIFastListCombinedNumbers#pushCombinedNumbers] data.length=%1", (long)dataCombinedNumbersArray.length);
        if (this.dsiLogChannel.isDebug2()) {
            Buffer buffer = new Buffer();
            for (int i2 = 0; i2 < dataCombinedNumbersArray.length; ++i2) {
                buffer.append(dataCombinedNumbersArray[i2]);
                buffer.append('\n');
            }
            this.dsiLogChannel.log(100000000, "[DSIFastListCombinedNumbers#pushCombinedNumbers] DataCombinedNumbers[] {\n%1}", (Object)buffer);
        }
        this.dsi.pushCombinedNumbers(0, 0, dataCombinedNumbersArray);
    }

    public void pushCurrentListSizeCombinedNumbers(int n) {
        this.dsiLogChannel.log(1000000, "[DSIFastListCombinedNumbers#pushCurrentListSizeCombinedNumbers] listSize=%1", (long)n);
        FastListPhoneSizes.pushListSizeCombinedNumbers(this.dsi, n);
    }

    public void responseNotifyCombinedNumbersPush(boolean bl) {
        this.dsiLogChannel.log(1000000, "[DSIFastListCombinedNumbers#responseNotifyCombinedNumbersPush] successful=%1", bl);
        this.dsi.responseNotifyCombinedNumbersPush(bl);
    }
}

