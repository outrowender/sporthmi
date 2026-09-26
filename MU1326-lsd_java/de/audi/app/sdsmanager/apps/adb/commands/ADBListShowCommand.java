/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.adb.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.adb.ADBSDSUtils;
import de.audi.app.sdsmanager.apps.adb.ADBSDSUtils$TelNumberTypeToModelValueMapping;
import de.audi.app.sdsmanager.apps.adb.AddressBookSDSHandler;
import de.audi.app.sdsmanager.apps.adb.IAddressBookPicklistHandler;
import de.audi.app.sdsmanager.apps.dictate.MessageDictationHandler;
import de.audi.app.sdsmanager.apps.phone.PhoneSDSHandler;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.interapp.ADBSDSService;
import de.audi.atip.interapp.ADBSDSService$EmailAddressDetails;
import de.audi.atip.interapp.ADBSDSService$TelNumberDetails;
import de.audi.atip.log.LogChannel;

public class ADBListShowCommand
extends AbstractSystemCallCommand {
    private final int listMode;
    private final IAddressBookPicklistHandler pickListHandler;
    protected ADBSDSService adbService;
    protected final AddressBookSDSHandler adbHandler;
    private final PhoneSDSHandler phoneHandler;
    private final MessageDictationHandler messageHandler;
    protected final NBestStorageAccess nBestStorage;
    private boolean hasEmptyNumberList;

    public ADBListShowCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, IAddressBookPicklistHandler iAddressBookPicklistHandler, AddressBookSDSHandler addressBookSDSHandler, ADBSDSService aDBSDSService, PhoneSDSHandler phoneSDSHandler, MessageDictationHandler messageDictationHandler, NBestStorageAccess nBestStorageAccess) {
        super(logChannel, string, sDSHandlerService);
        this.listMode = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
        this.pickListHandler = iAddressBookPicklistHandler;
        this.adbService = aDBSDSService;
        this.adbHandler = addressBookSDSHandler;
        this.phoneHandler = phoneSDSHandler;
        this.messageHandler = messageDictationHandler;
        this.nBestStorage = nBestStorageAccess;
        this.hasEmptyNumberList = false;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#execute: listMode=%2", (Object)this.getName(), (long)this.listMode);
        this.nBestStorage.resetPicklistsWithHistory();
        switch (this.listMode) {
            case 0: {
                this.triggerADBPicklist();
                break;
            }
            case 2: {
                this.showNumberList(0);
                break;
            }
            case 1: {
                this.triggerADBPicklist();
                break;
            }
            case 3: {
                this.showDestinationList();
                break;
            }
            case 4: {
                this.showDetailScreen();
                break;
            }
            case 5: {
                this.showNumberList(2);
                break;
            }
            case 6: {
                this.showMailList();
                break;
            }
            default: {
                this.logger.log(-2137614336, "%1#processListShow: Unhandled list mode %2!", (Object)this.getName(), (long)this.listMode);
                this.sendResult(3001);
            }
        }
    }

    private void showNumberList(int n) {
        int n2 = SDSModelAccess.getAdrSDSTelNumberListLength();
        this.logger.log(-2137614336, "%1#showNumberList: numberListLen=%2, title=%3", (Object)this.getName(), (long)n2, (long)n);
        SDSModelAccess.setAdbTitlePicklistChoiceModel(n);
        switch (n2) {
            case 0: {
                this.handleEmptyNumberList();
                break;
            }
            case 1: {
                this.handleSingleNumberList();
                break;
            }
            default: {
                this.handleMultipleNumberList();
            }
        }
    }

    private void showMailList() {
        int n = SDSModelAccess.getAdrSDSMailListLength();
        this.logger.log(-2137614336, "%1#showMailList: mailListLen=%2", (Object)this.getName(), (long)n);
        switch (n) {
            case 0: {
                this.sendResult(3007);
                return;
            }
            case 1: {
                ADBSDSService$EmailAddressDetails aDBSDSService$EmailAddressDetails = this.adbService.getEmailAddressDetails(4276, 0);
                this.logger.log(-2137614336, "%1#showMailList: emailDetails=%2", (Object)this.getName(), (Object)aDBSDSService$EmailAddressDetails);
                this.messageHandler.setEmailAddressDetails(aDBSDSService$EmailAddressDetails);
                this.sendResult(3000);
                return;
            }
        }
        this.pickListHandler.showMailPopup();
        this.sendResult(3005);
    }

    private void handleEmptyNumberList() {
        if (SDSModelAccess.isMsgDictateActive()) {
            this.sendResult(3007);
            return;
        }
        int n = this.adbHandler.getPhoneNumberTypes();
        this.logger.log(-2137614336, "%1#handleEmptyNumberList: No number found for phoneNumberTypes %2!", (Object)this.getName(), (long)n);
        long l = this.adbHandler.getCurrentEntryID();
        if (n == 0) {
            this.logger.log(-2137614336, "%1#handleEmptyNumberList: No number found at all, showing details for entryID %2!", (Object)this.getName(), l);
            this.hasEmptyNumberList = true;
            this.adbService.openEntryDetails(l);
            return;
        }
        this.adbHandler.setPhoneNumberTypes(0);
        this.logger.log(-2137614336, "%1#handleEmptyNumberList: entryID=%2, getting entries with noFilterTypes %3!", (Object)this.getName(), l, 0L);
        this.adbService.fillTelNumberList(l, 0);
    }

    private void handleSingleNumberList() {
        if (!this.storeSinglePhoneNumber()) {
            this.sendResult(3001);
            return;
        }
        if (SDSModelAccess.isMsgDictateActive() || SDSModelAccess.getCounterSecondChoice() > 0) {
            this.logger.log(-2137614336, "%1#handleSingleNumberList: not showing number screen - MsgDictation active or second counter > 0!", (Object)this.getName());
        } else {
            this.logger.log(-2137614336, "%1#handleSingleNumberList: showing number screen!", (Object)this.getName());
            this.pickListHandler.showTelContactPopup();
        }
        this.sendResult(3000);
    }

    private boolean storeSinglePhoneNumber() {
        ADBSDSService$TelNumberDetails aDBSDSService$TelNumberDetails = this.adbService.getTelNumberDetails(0);
        if (aDBSDSService$TelNumberDetails == null) {
            this.logger.log(-1601830656, "%1#handleSingleNumberList: No numberDetails available!", (Object)this.getName());
            return false;
        }
        String string = aDBSDSService$TelNumberDetails.telNumber;
        SDSModelAccess.setADBSelectedNumberTypeModel(ADBSDSUtils$TelNumberTypeToModelValueMapping.getModelValueForTelNumberType(aDBSDSService$TelNumberDetails.telNumberType));
        this.logger.log(-2137614336, "%1#handleSingleNumberList: Setting unique number %2 in speller!", (Object)this.getName(), (Object)string);
        this.phoneHandler.setPhoneSpeller((byte)0, string, true);
        this.adbHandler.setTelNumberDetails(aDBSDSService$TelNumberDetails);
        return true;
    }

    private void handleMultipleNumberList() {
        this.logger.log(-2137614336, "%1#handleMultipleNumberList: More than one number found, showing number screen!", (Object)this.getName());
        this.pickListHandler.showTelContactPopup();
        this.sendResult(3005);
    }

    private void showDestinationList() {
        int n = this.adbHandler.getNavLocationSize();
        this.logger.log(-2137614336, "%1#showDestinationList: length of addresses=%2!", (Object)this.getName(), (long)n);
        switch (n) {
            case 0: {
                this.sendResult(3007);
                break;
            }
            case 1: {
                this.handleSingleAddress();
                break;
            }
            default: {
                this.showADBPicklistScreen();
                this.sendResult(3005);
            }
        }
    }

    private void handleSingleAddress() {
        this.logger.log(-2137614336, "%1#handleSingleAddress called!", (Object)this.getName());
        int n = SDSModelAccess.getADBCategoryLocationModel();
        if (n != 0) {
            if (SDSModelAccess.getCounterSecondChoice() > 0) {
                this.showADBPicklistScreen();
            }
            this.logger.log(-2137614336, "%1#handleSingleAddress: category filter=%2 -> send OK!", (Object)this.getName(), (long)n);
            this.sendResult(3000);
            return;
        }
        this.logger.log(-2137614336, "%1#handleSingleAddress: category filter=%2 -> send PRIVATE / BUSINESS!", (Object)this.getName(), (long)n);
        int n2 = this.adbHandler.getNavLocationType(0);
        int n3 = SDSUtils.translate(n2, ADBSDSUtils.detailedAddressTypes2EventId);
        this.logger.log(-2137614336, "%1#handleSingleAddress: location type=%2, mapped onto %3!", (Object)this.getName(), (long)n2, (long)n3);
        if (n3 == 128) {
            this.logger.log(10000, "%1#handleSingleAddress: invalid/unhandled locationCategory!", (Object)this.getName());
            this.sendResult(3001);
            return;
        }
        this.sendResult(n3);
    }

    private void showDetailScreen() {
        this.logger.log(-2137614336, "%1#showDetailScreen: show detail screen for contact!", (Object)this.getName());
        this.adbService.openEntryDetails(this.adbHandler.getCurrentEntryID());
    }

    private boolean showADBPicklistScreen() {
        this.logger.log(-2137614336, "%1#showADBPicklistScreen: listModeID=%2", (Object)this.getName(), (long)this.listMode);
        switch (this.listMode) {
            case 0: {
                this.pickListHandler.showADBPopup();
                return true;
            }
            case 1: {
                this.pickListHandler.showADBNaviPopup();
                return true;
            }
            case 3: {
                this.pickListHandler.showADBContactPopup();
                return true;
            }
        }
        this.logger.log(-1601830656, "%1#showADBPicklistScreen: Unhandled listModeID %2!", (Object)this.getName(), (long)this.listMode);
        return false;
    }

    protected void triggerADBPicklist() {
        this.logger.log(-2137614336, "%1#triggerADBPicklist: called", (Object)this.getName());
        long[][] lArray = this.nBestStorage.getPreparedPicklistObjIDs((byte)1);
        this.logger.log(-2137614336, "%1#triggerADBPicklist: preparedObjIDs=%2!", (Object)this.getName(), (Object)SDSUtils.toString(lArray, false));
        this.adbHandler.setEntryIDs(SDSUtils.getColumnSlotIDs(lArray, 0));
        String[][] stringArray = this.nBestStorage.getPreparedPicklistTexts((byte)1);
        this.logger.log(-2137614336, "%1#triggerADBPicklist: preparedTexts=%2!", (Object)this.getName(), (Object)SDSUtils.toString(stringArray, false));
        String[] stringArray2 = SDSUtils.concatenateEntryStrings(stringArray);
        this.logger.log(-2137614336, "%1#triggerADBPicklist: entryNames=%2!", (Object)this.getName(), (Object)stringArray2);
        int[] nArray = this.nBestStorage.getPreparedPicklistGraphGroupSizes((byte)1);
        this.logger.log(-2137614336, "%1#triggerADBPicklist: graphemicGroupSizes=%2!", (Object)this.getName(), (Object)nArray);
        long[] lArray2 = this.adbHandler.getEntryIDs();
        this.logger.log(-2137614336, "%1#triggerADBPicklist: entryIDs=%2!", (Object)this.getName(), (Object)lArray2);
        int n = nArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            if (nArray[i2] <= 0) continue;
            lArray2[i2] = 0L;
        }
        this.logger.log(-2137614336, "%1#triggerADBPicklist: entryIDs=%2, entryNames=%3, graphemicGroupSizes=%4!", (Object)this.getName(), (Object)lArray2, (Object)stringArray2, (Object)nArray);
        this.adbService.fillAdbPickList(lArray2, stringArray2, nArray);
    }

    public void responseFillAdbPickList(int n) {
        this.logger.log(-2137614336, "%1#responseFillAdbPickList: resultCode=%2", (Object)this.getName(), (long)n);
        switch (n) {
            case 1: {
                this.sendResult(3001);
                break;
            }
            case 0: {
                this.sendResult(this.showADBPicklistScreen() ? 3000 : 3001);
                break;
            }
            default: {
                this.logger.log(-2137614336, "%1#responseFillAdbPickList: Unhandled resultCode %2, sending ERROR!", (Object)this.getName(), (long)n);
                this.sendResult(3001);
            }
        }
    }

    public void responseOpenEntryDetails(int n, String string) {
        this.logger.log(-2137614336, "%1#responseOpenEntryDetails: combinedName=%1", (Object)this.getName(), (Object)string);
        if (n != 0) {
            this.logger.log(-1601830656, "%1#responseOpenEntryDetails: Unhandled resultCode %2, sending ERROR!", (Object)this.getName(), (long)n);
            this.sendResult(3001);
            return;
        }
        SDSModelAccess.setADBEntryNameModel(string);
        this.sendResult(this.hasEmptyNumberList ? 3007 : 3000);
    }

    public void responseFillTelNumberList(int n, String string, int n2, String string2, int n3) {
        this.logger.log(-2137614336, "%1#responseFillTelNumberList: resultCode=%3, combinedName=%2!", (Object)this.getName(), (Object)string, (long)n);
        if (n != 0) {
            this.logger.log(-1601830656, "%1#responseFillTelNumberList: Unhandled resultCode %2, sending ERROR!", (Object)this.getName(), (long)n);
            this.sendResult(3001);
            return;
        }
        int n4 = SDSModelAccess.getAdrSDSTelNumberListLength();
        this.logger.log(-2137614336, "%1#responseFillTelNumberList: numberListLen=%2!", (Object)this.getName(), (long)n4);
        if (n4 == 0) {
            long l = this.adbHandler.getCurrentEntryID();
            this.hasEmptyNumberList = true;
            this.logger.log(-2137614336, "%1#responseFillTelNumberList: No number found at all, showing details for entryID %2!", (Object)this.getName(), l);
            this.adbService.openEntryDetails(l);
            return;
        }
        SDSModelAccess.setADBEntryNameModel(string);
        this.adbHandler.updateTelNumberInfo(n3, n2, string2);
        if (n3 == 1 && !this.storeSinglePhoneNumber()) {
            this.sendResult(3001);
            return;
        }
        this.logger.log(-2137614336, "%1#responseFillTelNumberList: At least one number available, show popup and send DISABLED!", (Object)this.getName());
        this.pickListHandler.showTelContactPopup();
        this.sendResult(3006);
    }
}

