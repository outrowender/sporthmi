/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.dsi.fastlist.navi;

import de.audi.app.combi.bap.dsi.fastlist.navi.DSIFastListNavi;
import de.audi.app.combi.bap.dsi.fastlist.navi.FastListNaviSizes;
import de.audi.app.combi.bap.dsi.fastlist.navi.IDSIFastListNavBook;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.kombifastlist.ArrayHeader;
import org.dsi.ifc.kombifastlist.DataAddress;

public final class DSIFastListNavBook
extends DSIFastListNavi
implements IDSIFastListNavBook {
    @Override
    public void responseNavBook(int n, int n2, int n3, int n4, ArrayHeader arrayHeader) {
        this.dsiLogChannel.log(1078071040, "[DSIFastListNavBook#responseNavBook] asgID=%1, taID=%2, ...", (long)n, (long)n2);
        this.dsiLogChannel.log(1078071040, "[DSIFastListNavBook#responseNavBook] totalNumListElements=%1, ...", (long)n3);
        this.dsiLogChannel.log(1078071040, "[DSIFastListNavBook#responseNavBook] sendReason=%2, arrayHeader=%1, ...", (Object)arrayHeader, (long)n4);
        this.dsi.responseNavBook(n, n2, n3, arrayHeader.mode, arrayHeader.recordAddress, arrayHeader.start, arrayHeader.relativeJump, arrayHeader.elements, arrayHeader.absoluteListPos, arrayHeader.jobModification, arrayHeader.jobID, arrayHeader.jobPriority, n4);
    }

    @Override
    public void responseNavBookArray(DataAddress[] dataAddressArray) {
        this.dsiLogChannel.log(1078071040, "[DSIFastListNavBook#responseNavBookArray] data.length=%1", (long)dataAddressArray.length);
        if (this.dsiLogChannel.isDebug2()) {
            Buffer buffer = new Buffer();
            for (int i2 = 0; i2 < dataAddressArray.length; ++i2) {
                buffer.append(dataAddressArray[i2]);
                buffer.append('\n');
            }
            this.dsiLogChannel.log(14808325, "[DSIFastListNavBook#responseNavBookArray] DataMediaBrowser[] {\n%1}", (Object)buffer);
        }
        this.dsi.responseNavBookArray(0, 0, dataAddressArray);
    }

    @Override
    public void responseNavBookJobs(int n, int n2) {
        this.dsiLogChannel.log(1078071040, "[DSIFastListNavBook#responseNavBookJobs] jobID=%1, jobsResult=%2", (long)n, (long)n2);
        this.dsi.responseNavBookJobs(0, n, n2);
    }

    @Override
    public void pushCurrentListSizeNavBook(int n) {
        this.dsiLogChannel.log(1078071040, "[DSIFastListNavBook#pushCurrentListSizeNavBook] listSize=%1", (long)n);
        FastListNaviSizes.pushListSizeNavBook(this.dsi, n);
    }
}

