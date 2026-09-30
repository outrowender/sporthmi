/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.dsi.fastlist.phone;

import de.audi.app.combi.bap.dsi.fastlist.phone.DSIFastListPhone;
import de.audi.app.combi.bap.dsi.fastlist.phone.FastListPhoneSizes;
import de.audi.app.combi.bap.dsi.fastlist.phone.IDSIFastListPhoneBook;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.kombifastlist.ArrayHeader;
import org.dsi.ifc.kombifastlist.DataPhonebook;

public final class DSIFastListPhoneBook
extends DSIFastListPhone
implements IDSIFastListPhoneBook {
    public void responsePhoneBook(int n, int n2, int n3, int n4, ArrayHeader arrayHeader) {
        this.dsiLogChannel.log(1000000, "[DSIFastListPhoneBook#responsePhonebook] asgID=%1, taID=%2, ...", (long)n, (long)n2);
        this.dsiLogChannel.log(1000000, "[DSIFastListPhoneBook#responsePhonebook] totalNumListElements=%1, ...", (long)n3);
        this.dsiLogChannel.log(1000000, "[DSIFastListPhoneBook#responsePhonebook] sendReason=%2, arrayHeader=%1, ...", (Object)arrayHeader, (long)n4);
        this.dsi.responsePhonebook(n, n2, n3, arrayHeader.mode, arrayHeader.recordAddress, arrayHeader.start, arrayHeader.relativeJump, arrayHeader.elements, arrayHeader.absoluteListPos, arrayHeader.jobModification, arrayHeader.jobID, arrayHeader.jobPriority, n4);
    }

    public void responsePhoneBookArray(DataPhonebook[] dataPhonebookArray) {
        this.dsiLogChannel.log(1000000, "[DSIFastListPhoneBook#responsePhonebookArray] data.length=%1", (long)dataPhonebookArray.length);
        if (this.dsiLogChannel.isDebug()) {
            Buffer buffer = new Buffer();
            for (int i2 = 0; i2 < dataPhonebookArray.length; ++i2) {
                buffer.append(dataPhonebookArray[i2]);
                buffer.append('\n');
            }
            this.dsiLogChannel.log(10000000, "[DSIFastListPhoneBook#responsePhonebookArray] DataPhonebook[] {\n%1}", (Object)buffer);
        }
        this.dsi.responsePhonebookArray(0, 0, dataPhonebookArray);
    }

    public void responsePhoneBookJobs(int n, int n2) {
        this.dsiLogChannel.log(1000000, "[DSIFastListPhoneBook#responsePhonebookJobs] jobID=%1, jobsResult=%2", (long)n, (long)n2);
        this.dsi.responsePhonebookJobs(0, n, n2);
    }

    public void pushCurrentListSizePhoneBook(int n) {
        this.dsiLogChannel.log(1000000, "[DSIFastListPhoneBook#pushCurrentListSizePhonebook] listSize=%1", (long)n);
        FastListPhoneSizes.pushListSizePhoneBook(this.dsi, n);
    }
}

