/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.contactimport;

import de.audi.app.messaging.core.addressbook.InsertEntryCommand;
import de.audi.app.messaging.core.addressbook.InsertEntryCommand$Result;
import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.attachments.AttachmentUtil;
import de.audi.app.messaging.core.commands.ICommandCallback;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.contactimport.DecodeAttachmentCommand;
import de.audi.app.messaging.core.contactimport.DecodeAttachmentCommand$Result;
import de.audi.app.messaging.core.contactimport.ImportContactController$1;
import de.audi.app.messaging.core.contactimport.ImportContactController$2;
import de.audi.app.messaging.core.contactimport.ImportContactController$3;
import de.audi.app.messaging.core.contactimport.ImportContactController$MessageOptionsManagerObserver;
import de.audi.app.messaging.core.contactimport.ImportContactController$MyButtonListener;
import de.audi.app.messaging.core.contactimport.ParseVCardCommand;
import de.audi.app.messaging.core.contactimport.ParseVCardCommand$Result;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.util.Logs;
import de.audi.app.messaging.core.util.ResourceLocators;
import de.audi.app.messaging.core.util.Strings;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.ICommandList;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.messaging.AttachmentInformation;
import org.dsi.ifc.organizer.AdbEntry;

public class ImportContactController
extends AbstractMessagingComponent {
    public static final int IMPORT_CONTACT_RESULT_OK;
    public static final int IMPORT_CONTACT_ERROR_GENERAL;
    public static final int IMPORT_CONTACT_ERROR_MEMORY_FULL;
    private final ICommandCallback decodeCommandCallback = new ImportContactController$1(this);
    private final ICommandCallback parseCommandCallback = new ImportContactController$2(this);
    private final ICommandCallback insertCommandCallback = new ImportContactController$3(this);
    private volatile AttachmentInformation firstVCardAttachment = null;
    private volatile int firstVCardAttachmentMessageType = 4;

    public ImportContactController(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        abstractMsgApplication.getMessageOptionsManager().addListener(new ImportContactController$MessageOptionsManagerObserver(this, null));
        this.framework.getHmiServiceApp().getButtonModel(2022842624).setButtonListener(new ImportContactController$MyButtonListener(this, null));
    }

    public void importContact(AttachmentInformation attachmentInformation, int n) {
        try {
            String string;
            if (this.log.isDebug()) {
                this.log.log(-2137614336, "[ImportContactController#importContact] vCardAttachment = %1, messageType = %2", (Object)String.valueOf(attachmentInformation), (Object)String.valueOf(n));
            }
            if (Strings.isNullOrEmpty(string = this.getVCardAttachmentPath(attachmentInformation))) {
                this.log.log(10000, "[ImportContactController#importContact] Invalid path.");
            } else {
                this.setImportContactState(0, 1);
                if (AttachmentUtil.isMimeEncoded(n)) {
                    new DecodeAttachmentCommand(this.msgApp, this.decodeCommandCallback, attachmentInformation).schedule();
                } else {
                    new ParseVCardCommand(this.msgApp, this.parseCommandCallback, string).schedule();
                }
            }
        }
        catch (Exception exception) {
            Logs.logException(this.log, exception, "[ImportContactController#importContact]");
            this.setImportContactState(2, 1);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void handleDecodeAttachmentResult(Command command) {
        this.log.log(-2137614336, "[ImportContactController#handleDecodeAttachmentResult] command = %1", (Object)command);
        boolean bl = false;
        int n = 2;
        int n2 = 1;
        try {
            DecodeAttachmentCommand decodeAttachmentCommand = (DecodeAttachmentCommand)command;
            DecodeAttachmentCommand$Result decodeAttachmentCommand$Result = (DecodeAttachmentCommand$Result)decodeAttachmentCommand.getResult();
            int n3 = decodeAttachmentCommand$Result.getResultCode();
            if (n3 == 0) {
                ResourceLocator resourceLocator = decodeAttachmentCommand$Result.getResourceLocator();
                String string = resourceLocator.getUrl();
                ICommandList iCommandList = decodeAttachmentCommand.getCommandList();
                ParseVCardCommand parseVCardCommand = new ParseVCardCommand(this.msgApp, this.parseCommandCallback, string);
                iCommandList.add(parseVCardCommand);
                iCommandList.setErrorCommand(parseVCardCommand.getErrorCommand());
            } else {
                bl = true;
                n = 2;
                n2 = n3 == 7 ? 2 : 1;
            }
        }
        catch (Exception exception) {
            Logs.logException(this.log, exception, "[ImportContactController#handleDecodeAttachmentResult]");
            bl = true;
            n = 2;
            n2 = 1;
        }
        finally {
            if (bl) {
                this.setImportContactState(n, n2);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void handleParseResult(Command command) {
        this.log.log(-2137614336, "[ImportContactController#handleParseResult] command = %1", (Object)command);
        boolean bl = false;
        int n = 2;
        int n2 = 1;
        try {
            ParseVCardCommand parseVCardCommand = (ParseVCardCommand)command;
            ParseVCardCommand$Result parseVCardCommand$Result = (ParseVCardCommand$Result)parseVCardCommand.getResult();
            int n3 = parseVCardCommand$Result.getResultCode();
            AdbEntry[] adbEntryArray = parseVCardCommand$Result.getEntries();
            if (n3 == 0 && adbEntryArray != null && adbEntryArray.length > 0) {
                InsertEntryCommand.schedule(this.msgApp.getMessagingAdbHandler(), adbEntryArray[0], this.insertCommandCallback);
            } else {
                bl = true;
                n = 2;
                n2 = 1;
            }
        }
        catch (Exception exception) {
            Logs.logException(this.log, exception, "[ImportContactController#handleParseResult]");
            bl = true;
            n = 2;
            n2 = 1;
        }
        finally {
            if (bl) {
                this.setImportContactState(n, n2);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void handleInsertResult(Command command) {
        this.log.log(-2137614336, "[ImportContactController#handleInsertResult] command = %1", (Object)command);
        int n = 2;
        int n2 = 1;
        try {
            InsertEntryCommand insertEntryCommand = (InsertEntryCommand)command;
            InsertEntryCommand$Result insertEntryCommand$Result = insertEntryCommand.getResult();
            int n3 = insertEntryCommand$Result.getResultCode();
            if (n3 == 0) {
                n = 1;
                n2 = 0;
            } else if (n3 == 5 || n3 == 6) {
                n2 = 2;
            }
        }
        catch (Exception exception) {
            Logs.logException(this.log, exception, "[ImportContactController#handleInsertResult]");
            n = 2;
            n2 = 1;
        }
        finally {
            this.setImportContactState(n, n2);
        }
    }

    public String getVCardAttachmentPath(AttachmentInformation attachmentInformation) {
        String string = "";
        try {
            ResourceLocator resourceLocator;
            if (AttachmentUtil.isVCardAttachment(attachmentInformation) && ResourceLocators.isValid(resourceLocator = attachmentInformation.getAttachmentPath()) && !Strings.isNullOrEmpty(resourceLocator.getUrl())) {
                string = resourceLocator.getUrl();
            }
        }
        catch (Exception exception) {
            this.log.log(10000, "[ImportContactController#getVCardAttachmentPath] Error examining attachment = %1: ", (Object)attachmentInformation, (Throwable)exception);
        }
        return string;
    }

    private AttachmentInformation getFirstVCardAttachment(AttachmentInformation[] attachmentInformationArray) {
        AttachmentInformation attachmentInformation = null;
        for (int i2 = 0; i2 < attachmentInformationArray.length; ++i2) {
            AttachmentInformation attachmentInformation2 = attachmentInformationArray[i2];
            String string = this.getVCardAttachmentPath(attachmentInformation2);
            if (Strings.isNullOrEmpty(string)) continue;
            attachmentInformation = attachmentInformation2;
            break;
        }
        return attachmentInformation;
    }

    private void setFirstVCardAttachment(AttachmentInformation attachmentInformation, int n) {
        if (this.log.isDebug()) {
            this.log.log(-2137614336, "[ImportContactController#setFirstVCardAttachment] vCardAttachment = %1, messageType = %2", (Object)String.valueOf(attachmentInformation), (Object)String.valueOf(n));
        }
        this.firstVCardAttachment = attachmentInformation;
        this.firstVCardAttachmentMessageType = n;
        int n2 = attachmentInformation == null ? 0 : 1;
        this.framework.getHmiServiceApp().getChoiceModel(-1231937280).setValue(n2);
    }

    private void setImportContactState(int n, int n2) {
        this.log.log(-2137614336, "[ImportContactController#setImportContactState] operationState = %1, resultChoiceValue = %2", (long)n, (long)n2);
        this.framework.getHmiServiceApp().getChoiceModel(-1517149952).setValue(n2);
        this.msgApp.getModelAccess().setOperationStateChoice(1335042304, n);
    }

    private void importContactsButton(int n, int n2) {
        this.log.log(1078071040, "[ImportContactController#importContactsButton]");
        this.importContact(this.firstVCardAttachment, this.firstVCardAttachmentMessageType);
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    static /* synthetic */ void access$000(ImportContactController importContactController, Command command) {
        importContactController.handleDecodeAttachmentResult(command);
    }

    static /* synthetic */ void access$100(ImportContactController importContactController, Command command) {
        importContactController.handleParseResult(command);
    }

    static /* synthetic */ void access$200(ImportContactController importContactController, Command command) {
        importContactController.handleInsertResult(command);
    }

    static /* synthetic */ LogChannel access$500(ImportContactController importContactController) {
        return importContactController.log;
    }

    static /* synthetic */ AbstractMsgApplication access$600(ImportContactController importContactController) {
        return importContactController.msgApp;
    }

    static /* synthetic */ AttachmentInformation access$700(ImportContactController importContactController, AttachmentInformation[] attachmentInformationArray) {
        return importContactController.getFirstVCardAttachment(attachmentInformationArray);
    }

    static /* synthetic */ void access$800(ImportContactController importContactController, AttachmentInformation attachmentInformation, int n) {
        importContactController.setFirstVCardAttachment(attachmentInformation, n);
    }

    static /* synthetic */ void access$900(ImportContactController importContactController, int n, int n2) {
        importContactController.importContactsButton(n, n2);
    }

    static /* synthetic */ LogChannel access$1000(ImportContactController importContactController) {
        return importContactController.log;
    }
}

