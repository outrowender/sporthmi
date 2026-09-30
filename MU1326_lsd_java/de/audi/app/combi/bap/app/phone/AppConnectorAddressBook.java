/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.phone;

import de.audi.app.bap.fw.arrays.ArrayHandler;
import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodFSG;
import de.audi.app.combi.bap.app.phone.AbstractAppConnectorPhone;
import de.audi.app.combi.bap.app.phone.CombiModulePhone;
import de.audi.app.combi.bap.app.phone.list.PhonebookHandler;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServiceAddressBook;
import de.audi.atip.interapp.combi.bap.phone.data.CombiBAPPhonebookEntry;
import de.audi.atip.interapp.combi.bap.phone.data.CombiBAPPhonebookEntryDetails;
import de.vw.mib.bap.generated.telephone.serializer.MobileServiceSupport_Status;
import de.vw.mib.bap.generated.telephone.serializer.PbSpeller_Result;
import de.vw.mib.bap.generated.telephone.serializer.PbState_Status;
import de.vw.mib.bap.generated.telephone2.serializer.PhonebookDownloadProgress_Status;

public class AppConnectorAddressBook
extends AbstractAppConnectorPhone
implements CombiBAPServiceAddressBook {
    protected AppConnectorAddressBook(CombiModulePhone combiModulePhone) {
        super(combiModulePhone);
    }

    public void updateMobileServiceSupport(boolean bl, boolean bl2, boolean bl3) {
        this.logChannel.log(1000000, "[AppConnectorAddressBook#updateMobileServiceSupport] pbStateSupported=%1, phonebookSupported=%2, pbSpellerSupported=%3", bl, bl2, bl3);
        MobileServiceSupport_Status mobileServiceSupport_Status = this.getMobileServiceSupportStatusCopy();
        mobileServiceSupport_Status.fctList.fctPbStateSupported = bl && this.moduleFsg.getFunctionList().isFunctionSupported(51);
        mobileServiceSupport_Status.fctList.fctPhonebookSupported = bl2 && this.moduleFsg.getFunctionList().isFunctionSupported(52);
        mobileServiceSupport_Status.fctList.fctPbSpellerSupported = bl3 && this.moduleFsg.getFunctionList().isFunctionSupported(53);
        this.sendPropertyStatus(16, mobileServiceSupport_Status);
    }

    public void updatePbState(int n, int n2) {
        this.logChannel.log(1000000, "[AppConnectorAddressBook#updatePbState] called (downloadState=%1, numberOfEntries=%2)", (long)n, (long)n2);
        PbState_Status pbState_Status = new PbState_Status();
        pbState_Status.downloadState = n;
        pbState_Status.pbEntriesUhv = n2;
        this.moduleFsg.getBAPFunctionPropertyFSG(51).sendStatusIfChanged(pbState_Status);
    }

    public void responsePhonebookListElements(int n, CombiBAPPhonebookEntry[] combiBAPPhonebookEntryArray) {
        this.logChannel.log(1000000, "[AppConnectorAddressBook#responsePhonebookListElements] called (entries.length=%1)", (long)combiBAPPhonebookEntryArray.length);
        ArrayHandler arrayHandler = this.moduleFsg.getBAPFunctionArrayFSG(52).getArrayHandler();
        arrayHandler.responseListElements(n, combiBAPPhonebookEntryArray);
    }

    public void responsePhonebookEntryDetails(long l, CombiBAPPhonebookEntryDetails[] combiBAPPhonebookEntryDetailsArray) {
        this.logChannel.log(1000000, "[AppConnectorAddressBook#responsePhonebookEntryDetails] called (entryID=%1)", l);
        ArrayHandler arrayHandler = this.moduleFsg.getBAPFunctionArrayFSG(52).getArrayHandler();
        ((PhonebookHandler)arrayHandler).setEntryDetails(l, combiBAPPhonebookEntryDetailsArray);
    }

    public void phonebookChanged(int n) {
        this.logChannel.log(1000000, "[AppConnectorAddressBook#phonebookChanged] called (numberOfEntries=%1)", (long)n);
        ArrayHandler arrayHandler = this.moduleFsg.getBAPFunctionArrayFSG(52).getArrayHandler();
        ((PhonebookHandler)arrayHandler).notifyPhonebookChanged(n);
    }

    public void pbSpellerResult(int n, int n2, int n3) {
        this.logChannel.log(1000000, "[AppConnectorAddressBook#pbSpellerResult] called (result=%1, matchingEntries=%2, matchingPos=%3", (long)n, (long)n2, (long)n3);
        BAPFunctionMethodFSG bAPFunctionMethodFSG = this.moduleFsg.getBAPFunctionMethodFSG(53);
        PbSpeller_Result pbSpeller_Result = (PbSpeller_Result)this.moduleFsg.createResultSerializer(53);
        pbSpeller_Result.pbSpeller_Result = n;
        pbSpeller_Result.matchingEntries = n2;
        pbSpeller_Result.pos = this.convertAdbIndexToPosID(n3);
        bAPFunctionMethodFSG.resultREQ(pbSpeller_Result);
    }

    private int convertAdbIndexToPosID(int n) {
        return n + 1;
    }

    public void updatePhonebookDownloadProgress(int n, int n2, int n3, int n4) {
        this.logChannel.log(1000000, "[AppConnectorAddressBook#updatePhonebookDownloadProgress] downloadState=%1, progressPhonebookDownload=%2, ...", (long)n, (long)n2);
        this.logChannel.log(1000000, "[AppConnectorAddressBook#updatePhonebookDownloadProgress] ... totalPbEntries=%1, currentlyLoadedPbEntries=%2", (long)n3, (long)n4);
        PhonebookDownloadProgress_Status phonebookDownloadProgress_Status = new PhonebookDownloadProgress_Status();
        phonebookDownloadProgress_Status.downloadState = n;
        phonebookDownloadProgress_Status.progressPhonebookDownload = n2 == -1 ? (n4 < 0 || n3 <= 0 ? 255 : (int)((float)n4 / (float)n3 * 100.0f)) : n2;
        phonebookDownloadProgress_Status.totalPbEntries = n3 == -1 ? 65535 : n3;
        phonebookDownloadProgress_Status.currentlyLoadedPbEntries = n4 == -1 ? 65535 : n4;
        this.sendPhone2PropertyStatus(26, phonebookDownloadProgress_Status);
    }
}

