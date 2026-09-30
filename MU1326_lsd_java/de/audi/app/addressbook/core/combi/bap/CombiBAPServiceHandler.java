/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.combi.bap;

import de.audi.app.addressbook.core.combi.bap.CombiADBHandler;
import de.audi.app.addressbook.core.combi.bap.commands.GetEntryDetailsCommand;
import de.audi.app.addressbook.core.combi.bap.commands.GetPhonebookListElementsCommand;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServiceAddressBook;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServiceAddressBookListener;
import de.audi.atip.interapp.combi.bap.phone.data.CombiBAPPhonebookEntry;
import de.audi.atip.interapp.combi.bap.phone.data.CombiBAPPhonebookEntryDetails;
import de.audi.atip.log.LogChannel;

public class CombiBAPServiceHandler
implements CombiBAPServiceAddressBookListener {
    private LogChannel log;
    private CombiADBHandler adbHandler;
    private CombiBAPServiceAddressBook combiService;

    public CombiBAPServiceHandler(CombiADBHandler combiADBHandler, LogChannel logChannel) {
        this.adbHandler = combiADBHandler;
        this.log = logChannel;
    }

    public void setCombiService(CombiBAPServiceAddressBook combiBAPServiceAddressBook) {
        this.log.log(10000000, "CombiBAPServiceHandler#setCombiService(): combiService: %1", (Object)combiBAPServiceAddressBook);
        this.combiService = combiBAPServiceAddressBook;
        this.updateMobileServiceSupport();
        this.adbHandler.getStateHandler().updateCombiPbState();
    }

    public void updateMobileServiceSupport() {
        if (this.combiService == null) {
            this.log.log(10000000, "CombiBAPServiceHandler#updateMobileServiceSupport(): combiService not available!");
            return;
        }
        this.combiService.updateMobileServiceSupport(true, true, true);
    }

    public void updatePbState(int n, int n2) {
        if (this.combiService == null) {
            this.log.log(10000000, "CombiBAPServiceHandler#updatePbState(): combiService not available!");
            return;
        }
        this.log.log(1000000, "CombiBAPServiceHandler#updatePbState(): downloadState: %1, numberOfEntries: %2", (long)n, (long)n2);
        this.combiService.updatePbState(n, n2);
    }

    public void updatePhonebookDownloadProgress(int n, int n2, int n3, int n4) {
        if (this.combiService == null) {
            this.log.log(1000000, "CombiBAPServiceHandler#updatePhonebookDownloadProgress(): combiService not available!");
            return;
        }
        this.log.log(1000000, "CombiBAPServiceHandler#updatePhonebookDownloadProgress(): downloadState: %1, totalPbEntries: %2, currentlyLoadedPbEntries: %3", (long)n, (long)n3, (long)n4);
        this.combiService.updatePhonebookDownloadProgress(n, n2, n3, n4);
    }

    public void phonebookChanged(int n) {
        if (this.combiService == null) {
            this.log.log(10000000, "CombiBAPServiceHandler#phonebookChanged(): combiService not available!");
            return;
        }
        this.log.log(1000000, "CombiBAPServiceHandler#phonebookChanged(): numberOfEntries: %1", (long)n);
        this.combiService.phonebookChanged(n);
    }

    public void responsePhonebookEntryDetails(long l, CombiBAPPhonebookEntryDetails[] combiBAPPhonebookEntryDetailsArray) {
        if (this.combiService == null) {
            this.log.log(10000000, "CombiBAPServiceHandler#responsePhonebookEntryDetails(): combiService not available!");
            return;
        }
        this.log.log(1000000, "CombiBAPServiceHandler#responsePhonebookEntryDetails(): entryID: %2, details: %1", (Object)combiBAPPhonebookEntryDetailsArray, l);
        this.combiService.responsePhonebookEntryDetails(l, combiBAPPhonebookEntryDetailsArray);
    }

    public void responsePhonebookListElements(CombiBAPPhonebookEntry[] combiBAPPhonebookEntryArray, int n) {
        if (this.combiService == null) {
            this.log.log(10000000, "CombiBAPServiceHandler#responsePhonebookListElements(): combiService not available!");
            return;
        }
        this.log.log(1000000, "CombiBAPServiceHandler#responsePhonebookListElements(): taID: %1, entries.length: %2", (long)n, combiBAPPhonebookEntryArray != null ? (long)combiBAPPhonebookEntryArray.length : -1L);
        this.combiService.responsePhonebookListElements(n, combiBAPPhonebookEntryArray);
    }

    public void requestPhonebookListElements(int n, int n2, int n3) {
        this.log.log(1000000, "CombiBAPServiceHandler#requestPhonebookListElements(): taID: %1, startPos: %2, numberOfElements: %3", (long)n, (long)n2, (long)n3);
        if (this.adbHandler.getStateHandler().isAdbReady()) {
            GetPhonebookListElementsCommand.createGetPhonebookListElementsCommand(this.adbHandler, n2, n3, n);
        } else {
            this.log.log(10000000, "CombiBAPServiceHandler#requestPhonebookListElements(): adb NOT ready!");
            this.responsePhonebookListElements(new CombiBAPPhonebookEntry[0], n);
        }
    }

    public void requestPhonebookEntryDetails(long l) {
        this.log.log(1000000, "CombiBAPServiceHandler#requestPhonebookEntryDetails(): entryID: %1", l);
        if (this.adbHandler.getStateHandler().isAdbReady()) {
            GetEntryDetailsCommand.createGetEntryDetailsCommand(this.adbHandler, l);
        } else {
            this.log.log(10000000, "CombiBAPServiceHandler#requestPhonebookEntryDetails(): adb NOT ready!");
            this.responsePhonebookEntryDetails(l, new CombiBAPPhonebookEntryDetails[0]);
        }
    }

    public void pbSpeller(int n, String string) {
        this.log.log(1000000, "CombiBAPServiceHandler#pbSpeller(): mode: %2, searchString: %1", (Object)string, (long)n);
        if (this.combiService == null) {
            this.log.log(10000, "CombiBAPServiceHandler#pbSpeller(): combiService not available!");
        } else if (!this.adbHandler.getStateHandler().isAdbReady()) {
            this.log.log(10000, "CombiBAPServiceHandler#pbSpeller(): address book not ready yet!");
            this.combiService.pbSpellerResult(1, 0, 0);
        } else if (n != 0) {
            this.log.log(10000, "CombiBAPServiceHandler#pbSpeller(): only CombiBAPConstantsPhone.MODE_MATCH_SPELLER is supported, requested mode is: %1", (long)n);
            this.combiService.pbSpellerResult(1, 0, 0);
        } else if (string == null || string.length() == 0) {
            this.log.log(10000, "CombiBAPServiceHandler#pbSpeller(): searchString is null or empty: %1", (Object)string);
            this.combiService.pbSpellerResult(1, 0, 0);
        } else {
            int n2 = this.adbHandler.findPosByChar(string.charAt(0));
            if (n2 != -1) {
                this.log.log(1000000, "CombiBAPServiceHandler#pbSpeller(): found match at %1", (long)n2);
                this.combiService.pbSpellerResult(0, 65535, n2);
            } else {
                this.log.log(1000000, "CombiBAPServiceHandler#pbSpeller(): character not found");
                this.combiService.pbSpellerResult(1, 65534, 0);
            }
        }
    }
}

