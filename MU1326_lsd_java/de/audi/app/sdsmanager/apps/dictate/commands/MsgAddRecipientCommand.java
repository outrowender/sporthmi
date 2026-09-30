/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.dictate.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSAppFactory;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.dictate.MessageDictationHandler;
import de.audi.app.sdsmanager.apps.dictate.commands.MessageDictateSDSUtils;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.IPicklist;
import de.audi.app.sdsmanager.nbest.IPicklistSlot;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.interapp.ADBSDSService;
import de.audi.atip.interapp.IMessagingDictationService;
import de.audi.atip.log.LogChannel;
import de.audi.atip.phone.ITelServiceSDS;

public class MsgAddRecipientCommand
extends AbstractSystemCallCommand {
    public static final int MSG_SOURCE_LIST = 0;
    public static final int MSG_SOURCE_NBEST = 1;
    public static final int MSG_SOURCE_DETAIL_LINE_SELECT = 2;
    private final IMessagingDictationService messagingService;
    private final MessageDictationHandler messageHandler;
    private final ITelServiceSDS phoneService;
    private final SDSAppFactory factory;
    private final NBestStorageAccess nBest;
    private final int source;

    public MsgAddRecipientCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, IMessagingDictationService iMessagingDictationService, MessageDictationHandler messageDictationHandler, ITelServiceSDS iTelServiceSDS, SDSAppFactory sDSAppFactory, NBestStorageAccess nBestStorageAccess, ISystemCallParameter[] iSystemCallParameterArray) {
        super(logChannel, string, sDSHandlerService);
        this.messagingService = iMessagingDictationService;
        this.messageHandler = messageDictationHandler;
        this.phoneService = iTelServiceSDS;
        this.factory = sDSAppFactory;
        this.nBest = nBestStorageAccess;
        this.source = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    public void execute() {
        Object object;
        int n = SDSModelAccess.getMsgDictateModel();
        this.logger.log(10000000, "%1#execute: messageType=%2!", (Object)this.getName(), (long)n);
        int[] nArray = SDSUtils.translateMulti(n, MessageDictateSDSUtils.MESSAGE_PARAMETER_2_TYPE_AND_COMPOSITION_MODE);
        int n2 = nArray[0];
        String string = "";
        if (n2 == 0) {
            n2 = this.messageHandler.getMessageType();
        }
        block0 : switch (n2) {
            case 1: {
                string = this.phoneService.getNumberSpellerContent();
                break;
            }
            case 2: {
                switch (this.source) {
                    case 0: {
                        object = this.factory.getSDSHandlerMessageDictation().getEmailAddressDetails();
                        this.logger.log(10000000, "%1#execute: details=%2!", (Object)this.getName(), object);
                        string = object == null ? "" : ((ADBSDSService.EmailAddressDetails)object).email;
                        break block0;
                    }
                    case 2: {
                        int n3 = this.sdsHandlerService.getSelectedRow();
                        int n4 = this.sdsHandlerService.getSelectedModel();
                        this.logger.log(10000000, "%1#execute: selectedRow=%2, selectedModel=%3!", (Object)this.getName(), (long)n3, (long)n4);
                        ADBSDSService aDBSDSService = this.factory.getSDSHandlerADB().getADBService();
                        ADBSDSService.EmailAddressDetails emailAddressDetails = aDBSDSService.getEmailAddressDetails(n4, n3);
                        string = emailAddressDetails == null ? "" : emailAddressDetails.email;
                        break block0;
                    }
                    case 1: {
                        this.logger.log(10000000, "%1#execute: get spoken email-address!", (Object)this.getName());
                        IPicklist iPicklist = this.nBest.getMatchingPicklist((byte)0);
                        if (SDSUtils.isEmpty(iPicklist)) {
                            this.logger.log(100000, "%1#execute: picklist is empty!", (Object)this.getName());
                            break block0;
                        }
                        IPicklistSlot iPicklistSlot = iPicklist.getSlot(0, 0);
                        this.logger.log(10000000, "%1#execute: slot=%2!", (Object)this.getName(), (Object)iPicklistSlot);
                        string = iPicklistSlot == null ? "" : iPicklistSlot.getText();
                        break block0;
                    }
                }
                this.logger.log(100000, "%1#execute: Unhandled source %2!", (Object)this.getName(), (long)this.source);
                break;
            }
            default: {
                this.logger.log(100000, "%1#execute: message type %2 is unknown!", (Object)this.getName(), (long)n2);
            }
        }
        if (SDSUtils.isEmpty(string)) {
            this.logger.log(100000, "%1#execute: No recipient found, sending ERROR!", (Object)this.getName());
            this.sendResult(75001);
            return;
        }
        this.logger.log(10000000, "%1#execute: recipient=%2!", (Object)this.getName(), (Object)string);
        object = SDSModelAccess.getADBEntryNameModel();
        long l = this.factory.getSDSHandlerADB().getCurrentEntryID();
        this.logger.log(10000000, "%1#execute: combinedName=%2, entryID=%3!", (Object)this.getName(), object, l);
        this.messagingService.requestAddRecipient(1, string, l, (String)object);
        this.sendResult(75000);
    }

    public void responseAddRecipient(int n) {
        this.logger.log(10000000, "%1#responseAddRecipient: result=%2", (Object)this.getName(), (long)n);
        this.sendResult(n == 0 ? 75000 : 75001);
    }
}

