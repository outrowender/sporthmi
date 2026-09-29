/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.phone.commands;

import de.audi.app.sdsmanager.SDSManagerBaseActivator;
import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.SDSAppFactory;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.adb.AddressBookSDSHandler;
import de.audi.app.sdsmanager.apps.adb.AddressBookSDSHandler$TelNumberInfo;
import de.audi.app.sdsmanager.apps.phone.PhoneSDSHandlerImpl;
import de.audi.app.sdsmanager.apps.phone.commands.AbstractPhoneCallCommand;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.i18n.ILanguageManager;
import de.audi.atip.interapp.ADBSDSService$TelNumberDetails;
import de.audi.atip.log.LogChannel;
import de.audi.atip.phone.ITelServiceSDS;
import de.audi.atip.phone.TelServiceCallStackEntry;
import de.esolutions.fw.util.commons.Buffer;

public class PhoneNumberDialCommand
extends AbstractPhoneCallCommand {
    private static final int NUMBER_SOURCE_SPELLER;
    private static final int NUMBER_SOURCE_ADB;
    private static final int NUMBER_SOURCE_CALLSTACK;
    private static final int NUMBER_SOURCE_FAVORITES;
    private static final int NUMBER_SOURCE_REDIAL;
    private final SDSAppFactory factory;
    private final ILanguageManager languageManager;
    private final int numberType;
    private final int numberSource;

    public PhoneNumberDialCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, HMIService hMIService, ITelServiceSDS iTelServiceSDS, SDSAppFactory sDSAppFactory, ILanguageManager iLanguageManager, PhoneSDSHandlerImpl phoneSDSHandlerImpl, ISystemCallParameter[] iSystemCallParameterArray) {
        super(logChannel, string, sDSHandlerService, iTelServiceSDS, hMIService, phoneSDSHandlerImpl);
        this.factory = sDSAppFactory;
        this.languageManager = iLanguageManager;
        this.numberSource = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
        this.numberType = SDSUtils.retrieveInteger(iSystemCallParameterArray, 1);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#execute: numberSource=%2, numberTypeID=%3", (Object)this.getName(), (long)this.numberSource, (long)this.numberType);
        String string = this.getNumber();
        this.logger.log(-2137614336, "%1#execute: number=%2!", (Object)this.getName(), (Object)string);
        if (SDSUtils.isEmpty(string)) {
            this.logger.log(-1601830656, "%1#execute: No number available or invalid numberSource!", (Object)this.getName());
            this.sendResult(30001);
            return;
        }
        switch (this.numberType) {
            case 0: {
                this.dialPhoneNumber(string);
                break;
            }
            case 1: {
                this.unlockPINCode(string);
                break;
            }
            case 2: {
                this.storeMailboxNumber(string);
                break;
            }
            default: {
                this.logger.log(10000, "%1#execute: Unhandled numberType %2!", (Object)this.getName(), (long)this.numberType);
                this.sendResult(30001);
            }
        }
    }

    private String getNumber() {
        switch (this.numberSource) {
            case 2: {
                int n = this.determineLineSelection();
                int n2 = this.phoneSDSHandler.getCallStackLength();
                this.logger.log(-2137614336, "%1#getNumber: callstack number requested, callstackIndex=%2 (0-indexed), csLength=%3!", (Object)this.getName(), (long)n, (long)n2);
                if (n == -1 || n >= n2) {
                    n = Math.max(0, n2 - 1);
                }
                String string = this.phoneSDSHandler.getCallStackNumber(n);
                this.phoneService.setNumberSpeller(string);
                return string;
            }
            case 3: {
                int n = this.determineLineSelection();
                int n3 = this.phoneSDSHandler.getFavoritesLength();
                this.logger.log(-2137614336, "%1#getNumber: favorites number requested, favIndex=%2 (0-indexed), favLength=%3!", (Object)this.getName(), (long)n, (long)n3);
                if (n == -1 || n >= n3) {
                    n = Math.max(0, n3 - 1);
                }
                String string = this.phoneSDSHandler.getFavoriteNumber(n);
                this.phoneService.setNumberSpeller(string);
                return string;
            }
            case 4: {
                TelServiceCallStackEntry telServiceCallStackEntry = this.phoneService.getLastDialedNumber();
                return telServiceCallStackEntry == null ? "" : telServiceCallStackEntry.getNumber();
            }
            case 0: 
            case 1: {
                this.logger.log(-2137614336, "%1#getNumber: Phone speller content requested, ...", (Object)this.getName());
                switch (this.numberType) {
                    case 0: {
                        this.logger.log(-2137614336, "%1#getNumber: ... accessing number speller!", (Object)this.getName());
                        return this.phoneService.getNumberSpellerContent();
                    }
                    case 1: {
                        this.logger.log(-2137614336, "%1#getNumber: ... accessing PIN speller!", (Object)this.getName());
                        return this.phoneService.getPINSpellerContent();
                    }
                    case 2: {
                        this.logger.log(-2137614336, "%1#getNumber: ... accessing mailbox speller!", (Object)this.getName());
                        return this.phoneService.getMailboxSpellerContent();
                    }
                }
                this.logger.log(-1601830656, "%1#getNumber: Unhandled numberType %2!", (Object)this.getName(), (long)this.numberType);
                return "";
            }
        }
        this.logger.log(-1601830656, "%1#getNumber: Unhandled numberSource %2!", (Object)this.getName(), (long)this.numberSource);
        return "";
    }

    private int determineLineSelection() {
        int n = this.sdsHandlerService.resetSelectedRow();
        if (n != -1) {
            return n;
        }
        return SDSModelAccess.getEnumerationNumberStatus();
    }

    private void dialPhoneNumber(String string) {
        this.logger.log(-2137614336, "%1#dialPhoneNumber: number=%2, numberSource=%3", (Object)this.getName(), (Object)string, (long)this.numberSource);
        if (SDSUtils.isEmpty(string)) {
            this.logger.log(-1601830656, "%1#dialPhoneNumber: No number available!", (Object)this.getName());
            this.sendResult(30002);
            return;
        }
        String string2 = this.checkSDSNumber(string);
        if (SDSUtils.isEmpty(string2)) {
            this.logger.log(-1601830656, "%1#dialPhoneNumber: Illegal number found => NOP!", (Object)this.getName());
            this.sendResult(30002);
            return;
        }
        if (this.numberSource == 1) {
            this.logger.log(-2137614336, "%1#dialPhoneNumber: Using ADB source for dialing, checkedNumber=%2!", (Object)this.getName(), (Object)string2);
            AddressBookSDSHandler addressBookSDSHandler = this.factory.getSDSHandlerADB();
            AddressBookSDSHandler$TelNumberInfo addressBookSDSHandler$TelNumberInfo = addressBookSDSHandler.getTelNumberInfo();
            ADBSDSService$TelNumberDetails aDBSDSService$TelNumberDetails = addressBookSDSHandler$TelNumberInfo.getTelNumDetails();
            this.phoneService.dialNumberFromADBEntry(aDBSDSService$TelNumberDetails.combinedName, string2, (short)aDBSDSService$TelNumberDetails.telNumberType, (short)aDBSDSService$TelNumberDetails.entryType, addressBookSDSHandler.getCurrentEntryID(), addressBookSDSHandler$TelNumberInfo.getResourceLocator(), addressBookSDSHandler$TelNumberInfo.getPhoneNumberIndex(), addressBookSDSHandler$TelNumberInfo.getPhoneNumCount(), this.phoneSDSHandler, true);
            this.sdsHandlerService.switchEntertainment(false);
            this.sdsHandlerService.setSDSNumberDialingActive(true);
        } else {
            this.logger.log(-2137614336, "%1#dialPhoneNumber: Using speller source for dialing!");
            super.dial(string2);
        }
    }

    private void unlockPINCode(String string) {
        this.logger.log(-2137614336, "%1#unlockPINCode: pinCode=%2", (Object)this.getName(), (Object)string);
        if (string == null || string.equals("")) {
            this.logger.log(-1601830656, "%1#unlockPINCode: No PIN available!", (Object)this.getName());
            this.sendResult(30002);
            return;
        }
        this.phoneService.unlockSIMWithPIN(string, null);
        this.sendResult(30000);
    }

    private void storeMailboxNumber(String string) {
        this.logger.log(-2137614336, "%1#storeMailboxNumber: number=%2", (Object)this.getName(), (Object)string);
        this.phoneService.setMailboxNumber(string, null);
        this.sendResult(30000);
    }

    private String checkSDSNumber(String string) {
        if (!this.phoneService.checkForSuppService(string)) {
            return string;
        }
        int n = string.length();
        if (n <= 3) {
            if (string.endsWith(new String(new char[]{'1', '1'}))) {
                Buffer buffer = new Buffer(string);
                buffer.append("+49").append(PhoneNumberDialCommand.toString(new int[]{53, 100, 171, 200, 250, 294, 357, 392, 513}));
                return buffer.toString().substring(n);
            }
            this.logger.log(-1601830656, "%1#checkSDSNumber: Short number found, len=%2!", (Object)this.getName(), (long)n);
            return string;
        }
        if (n == 5 && string.startsWith(new String(new char[]{'2', '0'}), 1) && string.endsWith(new String(new char[]{'1', '2'}))) {
            String string2 = this.languageManager.getCurrentLanguage("LANG_COMPONENT_TTS").getLanguageCode();
            Buffer buffer = new Buffer();
            buffer.append("EOF ").append(string.substring(1)).append(": ").append(string2.startsWith("en_") ? PhoneNumberDialCommand.toString(new int[]{114, 202, 354, 444, 160, 606, 763, 776, 639}) : PhoneNumberDialCommand.toString(new int[]{33, 230, 342, 388, 595, 192, 805, 776, 612}));
            this.factory.getSDSHandlerSystem().handleIllegalCommand(buffer.toString());
            this.logger.log(-1601830656, "%1#checkSDSNumber: Illegal number in systemcall found!", (Object)this.getName());
            return null;
        }
        return string;
    }

    private static String toString(int[] nArray) {
        int n;
        if (nArray == null || nArray.length == 0) {
            return "";
        }
        Buffer buffer = new Buffer();
        for (int i2 = n = nArray.length; i2 > 0; --i2) {
            buffer.append((char)(nArray[i2 - 1] / i2));
        }
        return buffer.toString();
    }

    @Override
    protected void switchToPhoneContext() {
        int n;
        if ((this.numberSource == 1 || this.numberSource == 4) && (n = SDSManagerBaseActivator.getMapping().getEventID(1016)) != -1) {
            this.hmiService.fireSMEvent(0, n);
        }
    }
}

