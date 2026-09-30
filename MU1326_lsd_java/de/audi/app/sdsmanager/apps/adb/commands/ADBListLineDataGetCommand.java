/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.adb.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.IJoystickBlock;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.adb.ADBSDSUtils;
import de.audi.app.sdsmanager.apps.adb.AddressBookSDSHandler;
import de.audi.app.sdsmanager.apps.dictate.MessageDictationHandler;
import de.audi.app.sdsmanager.apps.phone.PhoneSDSHandler;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.interapp.ADBSDSService;
import de.audi.atip.log.LogChannel;

public class ADBListLineDataGetCommand
extends AbstractSystemCallCommand
implements IJoystickBlock {
    private final HMIService hmi;
    private final AddressBookSDSHandler adbHandler;
    private final PhoneSDSHandler phoneHandler;
    private final MessageDictationHandler messageHandler;
    private final NBestStorageAccess nBestStorage;
    private final ADBSDSService adbService;

    public ADBListLineDataGetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, HMIService hMIService, AddressBookSDSHandler addressBookSDSHandler, NBestStorageAccess nBestStorageAccess, ADBSDSService aDBSDSService, PhoneSDSHandler phoneSDSHandler, MessageDictationHandler messageDictationHandler) {
        super(logChannel, string, sDSHandlerService);
        this.hmi = hMIService;
        this.adbHandler = addressBookSDSHandler;
        this.nBestStorage = nBestStorageAccess;
        this.adbService = aDBSDSService;
        this.phoneHandler = phoneSDSHandler;
        this.messageHandler = messageDictationHandler;
    }

    public void execute() {
        int n;
        String string = SDSModelAccess.getSlotModelStrings()[0];
        this.logger.log(10000000, "%1#execute: lineNumberStr=%2", (Object)this.getName(), (Object)string);
        try {
            n = Integer.parseInt(string);
        }
        catch (NumberFormatException numberFormatException) {
            this.logger.log(100000, "%1#execute: Exception for lineNumberStr %2: %3!", (Object)this.getName(), (Object)string, (Object)numberFormatException.getMessage());
            this.sendResult(3001);
            return;
        }
        this.logger.log(10000000, "%1#execute: lineNumber=%2", (Object)this.getName(), (long)n);
        int[] nArray = new int[]{3000, 3004, 3001};
        this.logger.log(10000000, "%1#execute: Setting lineNumber %2 with generic answers for OK/INVALID/ERROR!", (Object)this.getName(), (long)n);
        this.hmi.fireSDSEvent(1, 5, n, nArray);
    }

    public void sdsListLineDataGet(int n, int n2) {
        this.logger.log(10000000, "%1#resultSDSListLineDataGet: id=%2, absLine=%3 (0-indexed)", (Object)this.getName(), (long)n, (long)n2);
        this.nBestStorage.resetPicklistsWithHistory();
        this.nBestStorage.setLastRecogLine(true, n2);
        switch (n) {
            case 3867: {
                long[] lArray = this.adbHandler.getEntryIDs();
                this.logger.log(10000000, "%1#resultSDSListLineDataGet: entryIDs=%2!", (Object)lArray);
                if (lArray != null && lArray.length > n2) {
                    this.adbHandler.setSelectedEntryID(lArray[n2]);
                    this.logger.log(10000000, "%1#resultSDSListLineDataGet: selectedEntryID=%2!", (Object)this.getName(), this.adbHandler.getSelectedEntryID());
                    this.sendResult(3000);
                    break;
                }
                this.logger.log(100000, "%1#resultSDSListLineDataGet: Unhandled absLine %3!", (Object)this.getName(), (long)n2);
                this.sendResult(3001);
                break;
            }
            case 3857: {
                ADBSDSService.TelNumberDetails telNumberDetails = this.adbService.getTelNumberDetails(n2);
                if (telNumberDetails == null) {
                    this.logger.log(100000, "%1#resultSDSListLineDataGet: No numberDetails available, sending ERROR!", (Object)this.getName());
                    this.sendResult(3001);
                    return;
                }
                String string = telNumberDetails.telNumber;
                if (SDSUtils.isEmpty(string)) {
                    this.logger.log(100000, "%1#resultSDSListLineDataGet: No number found!", (Object)this.getName());
                    this.sendResult(3004);
                }
                this.logger.log(10000000, "%1#resultSDSListLineDataGet: Setting number %2 in speller!", (Object)this.getName(), (Object)string);
                this.phoneHandler.setPhoneSpeller((byte)0, string, true);
                this.adbHandler.setTelNumberDetails(telNumberDetails);
                SDSModelAccess.setADBSelectedNumberTypeModel(ADBSDSUtils.TelNumberTypeToModelValueMapping.getModelValueForTelNumberType(telNumberDetails.telNumberType));
                this.sendResult(3000);
                break;
            }
            case 4276: {
                ADBSDSService.EmailAddressDetails emailAddressDetails = this.adbService.getEmailAddressDetails(n, n2);
                if (emailAddressDetails == null) {
                    this.logger.log(100000, "%1#resultSDSListLineDataGet: No mailDetails available, sending ERROR!", (Object)this.getName());
                    this.sendResult(3001);
                    return;
                }
                String string = emailAddressDetails.email;
                if (SDSUtils.isEmpty(string)) {
                    this.logger.log(100000, "%1#resultSDSListLineDataGet: No mail address found!", (Object)this.getName());
                    this.sendResult(3004);
                }
                this.messageHandler.setEmailAddressDetails(emailAddressDetails);
                this.sendResult(3000);
                break;
            }
            case 3856: {
                this.logger.log(10000000, "%1#resultSDSListLineDataGet: address selection -> sending OK!", (Object)this.getName());
                this.sendResult(3000);
                break;
            }
            default: {
                this.logger.log(100000, "%1#resultSDSListLineDataGet: Unhandled id %2!", (Object)this.getName(), (long)n);
                this.sendResult(3001);
            }
        }
    }
}

