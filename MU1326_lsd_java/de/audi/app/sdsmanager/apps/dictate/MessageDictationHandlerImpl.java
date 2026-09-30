/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.dictate;

import de.audi.app.sdsmanager.SDSManagerBaseActivator;
import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSDSApplication;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSAppFactory;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.dictate.MessageDictationHandler;
import de.audi.app.sdsmanager.apps.dictate.commands.MsgAddRecipientCommand;
import de.audi.app.sdsmanager.apps.dictate.commands.MsgClearRecipientCommand;
import de.audi.app.sdsmanager.apps.dictate.commands.MsgDictateActivateCommand;
import de.audi.app.sdsmanager.apps.dictate.commands.MsgDictateDeleteCommand;
import de.audi.app.sdsmanager.apps.dictate.commands.MsgDictateDialogStepSetCommand;
import de.audi.app.sdsmanager.apps.dictate.commands.MsgDictateFinishCommmand;
import de.audi.app.sdsmanager.apps.dictate.commands.MsgDictatePrepareCommand;
import de.audi.app.sdsmanager.apps.dictate.commands.MsgDictateStartCommand;
import de.audi.app.sdsmanager.apps.dictate.commands.MsgDictateStopCommand;
import de.audi.app.sdsmanager.apps.dictate.commands.MsgDictateVoiceDataAvailableCommand;
import de.audi.app.sdsmanager.apps.dictate.commands.MsgSendCommand;
import de.audi.app.sdsmanager.apps.utils.EditorModelHandler;
import de.audi.app.sdsmanager.apps.utils.EditorModelListener;
import de.audi.app.sdsmanager.common.ISDSPopupHelper;
import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.dictation.DictationService;
import de.audi.app.sdsmanager.dictation.dsiadapter.IDsiDictationAdapter;
import de.audi.app.sdsmanager.dictation.dsiadapter.IDsiDictationAdapterListener;
import de.audi.app.sdsmanager.dictation.dsiadapter.ServiceProviderInfo;
import de.audi.app.sdsmanager.grammar.DynamicSlotContent;
import de.audi.app.sdsmanager.grammar.IDynamicLists;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.TextEditorModelDDApp;
import de.audi.atip.interapp.ADBSDSService;
import de.audi.atip.interapp.IMessagingDictationService;
import de.audi.atip.interapp.IMessagingDictationServiceListener;
import de.audi.atip.interapp.def.NullMessagingDictationService;
import de.audi.atip.log.LogChannel;
import de.audi.atip.phone.ITelServiceSDS;
import de.audi.atip.phone.NullITelServiceSDS;
import de.audi.tghu.command.CommandList;
import java.util.LinkedList;

public class MessageDictationHandlerImpl
extends AbstractSDSApplication
implements MessageDictationHandler,
IMessagingDictationServiceListener,
IDsiDictationAdapterListener {
    private static final int[] commands = new int[]{77001, 77000, 77002, 77011, 77004, 77008, 77009, 77010, 75001, 75005, 77003};
    private LogChannel lc = Logger.getAppDictationLog();
    private IMessagingDictationService messagingService = new NullMessagingDictationService(this.lc);
    private ITelServiceSDS phoneService = new NullITelServiceSDS(this.lc);
    private final SDSAppFactory factory;
    private final HMIService hmi;
    private final ISDSPopupHelper sdsPopupHelper;
    private final IDsiDictationAdapter dictationAdapter;
    private volatile boolean stopRequested = false;
    private int activationState = 0;
    private EditorModelHandler bodyEditor;
    private EditorModelHandler subjectEditor;
    private EditorModelListener bodyListener;
    private EditorModelListener subjectListener;
    private ChoiceModelApp messageTypeModel = null;
    private int currentDictationStep;
    private IMessagingDictationService.CompositionState currentCompositionState;
    private boolean dictationRunning;
    private DictationService dictationService;
    private IDynamicLists dynamicLists;
    private ADBSDSService.EmailAddressDetails emailAddressDetails;

    public MessageDictationHandlerImpl(SDSHandlerService sDSHandlerService, SDSAppFactory sDSAppFactory, NBestStorageAccess nBestStorageAccess, ISDSPopupHelper iSDSPopupHelper, DictationService dictationService, HMIService hMIService, IDynamicLists iDynamicLists) {
        super(sDSHandlerService, nBestStorageAccess);
        this.factory = sDSAppFactory;
        this.hmi = hMIService;
        this.sdsPopupHelper = iSDSPopupHelper;
        this.dynamicLists = iDynamicLists;
        if (dictationService == null) {
            this.dictationAdapter = null;
        } else {
            this.dictationService = dictationService;
            this.dictationAdapter = dictationService.getDsiDictationAdapter();
            this.dictationAdapter.addListener(this);
        }
        this.lc.log(10000000, "MessageDictationHandlerImpl initialized.");
    }

    public int[] getCommands() {
        return commands;
    }

    public void processCommand(int n, ISystemCallParameter[] iSystemCallParameterArray) {
        String string = SDSManagerBaseActivator.getSystemCallNames().getName(n);
        this.lc.log(10000000, "MessageDictationHandlerImpl#processCommand: id=%2, params=%1", (Object)SDSUtils.toString((Object[])iSystemCallParameterArray, false), (Object)string);
        CommandList commandList = new CommandList(SDSManagerBaseActivator.getSysCallCmdListManager());
        switch (n) {
            case 77001: {
                commandList.add(new MsgClearRecipientCommand(this.lc, string, this.sdsHandlerService, this.messagingService));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 77000: {
                commandList.add(new MsgDictateActivateCommand(this.lc, string, this.sdsHandlerService, this.dictationAdapter, this));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 77002: {
                commandList.add(new MsgDictateDeleteCommand(this.lc, string, this.sdsHandlerService, this, iSystemCallParameterArray));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 77011: {
                commandList.add(new MsgDictateDialogStepSetCommand(this.lc, string, this.sdsHandlerService, this, this.messagingService, iSystemCallParameterArray));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 77004: {
                commandList.add(new MsgDictateFinishCommmand(this.lc, string, this.sdsHandlerService, this.messagingService));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 77003: {
                commandList.add(new MsgDictatePrepareCommand(this.lc, string, this.sdsHandlerService, this, this.messagingService, iSystemCallParameterArray));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 77008: {
                commandList.add(new MsgDictateStartCommand(this.lc, string, this.sdsHandlerService, iSystemCallParameterArray, this, this.dictationAdapter, this.sdsPopupHelper));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 77009: {
                commandList.add(new MsgDictateStopCommand(this.lc, string, this.sdsHandlerService, this, this.dictationAdapter, this.sdsPopupHelper));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 77010: {
                commandList.add(new MsgDictateVoiceDataAvailableCommand(this.lc, string, this.sdsHandlerService, this, this.dictationAdapter, this.sdsPopupHelper));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 75001: {
                commandList.add(new MsgAddRecipientCommand(this.lc, string, this.sdsHandlerService, this.messagingService, this, this.phoneService, this.factory, this.nBestStorage, iSystemCallParameterArray));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            case 75005: {
                commandList.add(new MsgSendCommand(this.lc, string, this.sdsHandlerService, this.messagingService));
                commandList.execute("SYSTEMCALL " + string);
                break;
            }
            default: {
                this.lc.log(10000, "MessageDictationHandlerImpl#processCommand: Unhandled id %1!", (long)n);
            }
        }
    }

    public boolean freezeLists() {
        this.lc.log(10000000, "MessageDictationHandlerImpl#freezeLists: called");
        return this.messagingService.freezeDynamicLists() == 0;
    }

    public boolean unfreezeLists() {
        this.lc.log(10000000, "MessageDictationHandlerImpl#unfreezeLists: called");
        return this.messagingService.unfreezeDynamicLists() == 0;
    }

    public boolean ignoreJoystick() {
        this.lc.log(10000000, "MessageDictationHandlerImpl#ignoreJoystick: bodyEditor=%1, subjectEditor=%2.", (Object)(this.bodyEditor == null ? "null" : "not null"), (Object)(this.subjectEditor == null ? "null" : "not null"));
        this.lc.log(10000000, "MessageDictationHandlerImpl#ignoreJoystick: bodyEditor.areAlternativesOpen=%1, subjectEditor.areAlternativesOpen=%2.", (Object)(this.bodyEditor == null ? "null" : Boolean.toString(this.bodyEditor.areAlternativesOpen())), (Object)(this.subjectEditor == null ? "null" : Boolean.toString(this.subjectEditor.areAlternativesOpen())));
        if (this.bodyEditor == null || this.subjectEditor == null) {
            return false;
        }
        return this.bodyEditor.areAlternativesOpen() || this.subjectEditor.areAlternativesOpen();
    }

    public void setMessagingDictationService(IMessagingDictationService iMessagingDictationService) {
        if (iMessagingDictationService == null) {
            return;
        }
        this.messagingService = iMessagingDictationService;
        this.messageTypeModel = this.hmi.getChoiceModel(2200505);
        if (this.bodyEditor == null) {
            TextEditorModelDDApp textEditorModelDDApp = this.messagingService.getBodyEditorModel();
            TextEditorModelDDApp textEditorModelDDApp2 = this.messagingService.getSubjectEditorModel();
            LabelModelApp labelModelApp = this.hmi.getLabelModel(4380);
            LabelModelApp labelModelApp2 = this.hmi.getLabelModel(4379);
            this.bodyListener = EditorModelListener.registerListener(textEditorModelDDApp, labelModelApp, this.hmi.getChoiceModel(4009), this.sdsHandlerService, this.lc);
            this.subjectListener = EditorModelListener.registerListener(textEditorModelDDApp2, labelModelApp2, this.hmi.getChoiceModel(4293), this.sdsHandlerService, this.lc);
            this.bodyEditor = new EditorModelHandler(textEditorModelDDApp, this.messagingService.getBodyEditorInputModeModel(), this.lc);
            this.subjectEditor = new EditorModelHandler(textEditorModelDDApp2, this.messagingService.getSubjectEditorInputModeModel(), this.lc);
        }
    }

    public IMessagingDictationService getMessagingDictationService() {
        return this.messagingService;
    }

    public void unsetMessagingDictationService() {
        this.messagingService = new NullMessagingDictationService(this.lc);
    }

    public void setPhoneService(ITelServiceSDS iTelServiceSDS) {
        if (iTelServiceSDS == null) {
            return;
        }
        this.phoneService = iTelServiceSDS;
    }

    public void unsetPhoneService() {
        this.phoneService = new NullITelServiceSDS(this.lc);
    }

    public void clearBody() {
        this.lc.log(10000000, "MessageDictationHandlerImpl#clearBody() called");
        if (this.bodyEditor != null) {
            this.bodyEditor.clearText();
            this.messagingService.indicateBodyEditorModelWrite();
            this.bodyListener.updateTextModelInfo();
        }
    }

    public void clearSubject() {
        this.lc.log(10000000, "MessageDictationHandlerImpl#clearSubject() called");
        if (this.subjectEditor != null) {
            this.subjectEditor.clearText();
            this.messagingService.indicateSubjectEditorModelWrite();
            this.subjectListener.updateTextModelInfo();
        }
    }

    public void handleDictationResult(LinkedList linkedList) {
        this.lc.log(10000000, "MessageDictationHandlerImpl#handleDictationResult, currentDictationStep=%1", (long)this.currentDictationStep);
        String string = "";
        try {
            string = SDSUtils.convertToString(linkedList);
            SDSModelAccess.setDictationPromptLabel(string);
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "MessageDictationHandlerImpl#handleDictationResult, conversion of dictation text failed: %1", (Object)classCastException.toString());
        }
        switch (this.currentDictationStep) {
            case 4: {
                this.bodyEditor.setText(linkedList);
                this.messagingService.indicateBodyEditorModelWrite();
                this.bodyListener.updateTextModelInfo();
                break;
            }
            case 3: {
                this.subjectEditor.setText(linkedList);
                this.messagingService.indicateSubjectEditorModelWrite();
                this.subjectListener.updateTextModelInfo();
                break;
            }
            case 0: {
                this.bodyEditor.appendText(linkedList);
                this.messagingService.indicateBodyEditorModelWrite();
                this.bodyListener.updateTextModelInfo();
                break;
            }
            case 1: {
                this.subjectEditor.appendText(linkedList);
                this.messagingService.indicateSubjectEditorModelWrite();
                this.subjectListener.updateTextModelInfo();
                break;
            }
            case 2: {
                SDSModelAccess.setMsgWordPromptLabel(string);
                this.bodyEditor.replaceSelectedWord(linkedList);
                this.messagingService.indicateBodyEditorModelWrite();
                this.bodyListener.updateTextModelInfo();
                break;
            }
            case 5: {
                SDSModelAccess.setMsgWordPromptLabel(string);
                this.subjectEditor.replaceSelectedWord(linkedList);
                this.messagingService.indicateSubjectEditorModelWrite();
                this.subjectListener.updateTextModelInfo();
                break;
            }
            case 6: {
                this.subjectEditor.resetText();
                this.messagingService.indicateSubjectEditorModelWrite();
                this.subjectListener.updateTextModelInfo();
                break;
            }
            default: {
                this.lc.log(100000, "MessageDictationHandlerImpl#handleDictationResult, dictation step not handled -> NOP");
            }
        }
    }

    public void undoLastInsertion() {
        this.lc.log(10000000, "MessageDictationHandlerImpl#undoLastInsertion, lastDictationStep=%1", (long)this.currentDictationStep);
        switch (this.currentDictationStep) {
            case 0: 
            case 4: {
                this.lc.log(10000000, "MessageDictationHandlerImpl#undoLastInsertion for body");
                if (this.bodyEditor.undoLastInsertion()) {
                    SDSModelAccess.setMsgTextChangedChoiceModel(1);
                    this.messagingService.indicateBodyEditorModelWrite();
                    this.bodyListener.updateTextModelInfo();
                    break;
                }
                SDSModelAccess.setMsgTextChangedChoiceModel(0);
                break;
            }
            case 1: 
            case 3: {
                this.lc.log(10000000, "MessageDictationHandlerImpl#undoLastInsertion for subject");
                if (this.subjectEditor.undoLastInsertion()) {
                    SDSModelAccess.setMsgTextChangedChoiceModel(1);
                    this.messagingService.indicateSubjectEditorModelWrite();
                    this.subjectListener.updateTextModelInfo();
                    break;
                }
                SDSModelAccess.setMsgTextChangedChoiceModel(0);
                break;
            }
            case 2: 
            case 5: {
                this.lc.log(10000000, "MessageDictationHandlerImpl#undoLastInsertion, last dictation step replacement -> NOP");
                break;
            }
            default: {
                this.lc.log(100000, "MessageDictationHandlerImpl#undoLastInsertion, dictation step not handled -> NOP");
            }
        }
    }

    public void positionBodyCursor(int n) {
        this.bodyEditor.positionCursor(n);
    }

    public void positionSubjectCursor(int n) {
        this.subjectEditor.positionCursor(n);
    }

    public void responseSetLanguage(int n) {
        this.lc.log(10000000, "MessageDictationHandlerImpl#responseSetLanguage: result=%1", (long)n);
    }

    public void responseSetFallbackLanguage(int n) {
        this.lc.log(10000000, "MessageDictationHandlerImpl#responseSetFallbackLanguage: result=%1", (long)n);
    }

    public void responseSetUserId(int n) {
        this.lc.log(10000000, "MessageDictationHandlerImpl#responseSetFallbackLanguage: result=%1", (long)n);
    }

    public void responseProcessVoiceData(int n, LinkedList linkedList) {
        this.lc.log(10000000, "MessageDictationHandlerImpl#responseProcessVoiceData: result=%1", (long)n);
        if (this.isStopRequested()) {
            this.lc.log(100000, "MessageDictationHandlerImpl#responseProcessVoiceData: Dictation stop requested => NOP!");
            return;
        }
        if (SDSUtils.getActiveSystemCall() instanceof MsgDictateVoiceDataAvailableCommand) {
            ((MsgDictateVoiceDataAvailableCommand)SDSUtils.getActiveSystemCall()).responseProcessVoiceData(n, linkedList);
            return;
        }
        this.lc.log(100000, "MessageDictationHandlerImpl#responseProcessVoiceData: Active systemcall is not MsgDictateVoiceDataAvailableCommand => NOP!");
    }

    public void updateLanguage(String string, String string2) {
        this.lc.log(10000000, "MessageDictationHandlerImpl#updateLanguage: language=%1, fallbackLanguage=%2", (Object)string, (Object)string2);
    }

    public void updateUserId(String string) {
        this.lc.log(10000000, "MessageDictationHandlerImpl#updateUserId: userId=%1", (Object)string);
    }

    public void updateActivationState(int n) {
        this.lc.log(10000000, "MessageDictationHandlerImpl#updateActivationState: activationState=%1", (long)n);
        this.setActivationState(n);
    }

    public int getActivationState() {
        return this.activationState;
    }

    public void setActivationState(int n) {
        this.activationState = n;
    }

    public void updateServiceProviderInfo(ServiceProviderInfo serviceProviderInfo) {
        this.lc.log(10000000, "MessageDictationHandlerImpl#updateActivationState: serviceProviderInfo=%1", (Object)serviceProviderInfo);
    }

    public void updateDsiAvailability(boolean bl) {
        this.lc.log(10000000, "MessageDictationHandlerImpl#updateDsiAvailability: dsiAvailable=%1", bl);
    }

    public void responseActivateDictation(int n) {
        this.lc.log(10000000, "MessageDictationHandlerImpl#responseActivateDictation: result=%1", (long)n);
        try {
            ((MsgDictateActivateCommand)SDSUtils.getActiveSystemCall()).responseActivateDictation(n);
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "MessageDictationHandlerImpl#responseActivateDictation: Active command is no MsgDictateActivateCommand!");
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(100000, "MessageDictationHandlerImpl#responseActivateDictation: NullpointerException. No active command!");
        }
    }

    public void responseStartDictation(int n) {
        this.lc.log(10000000, "MessageDictationHandlerImpl#responseStartDictation: result=%1", (long)n);
        if (this.isStopRequested()) {
            this.lc.log(100000, "MessageDictationHandlerImpl#responseStartDictation: Dictation stop requested => NOP!");
            return;
        }
        AbstractSystemCallCommand abstractSystemCallCommand = SDSUtils.getActiveSystemCall();
        if (abstractSystemCallCommand == null) {
            this.lc.log(10000, "MessageDictationHandlerImpl#responseStartDictation: No active command!");
            return;
        }
        if (abstractSystemCallCommand instanceof MsgDictateActivateCommand) {
            ((MsgDictateActivateCommand)abstractSystemCallCommand).responseStartDictation(n);
        } else if (abstractSystemCallCommand instanceof MsgDictateStartCommand) {
            ((MsgDictateStartCommand)abstractSystemCallCommand).responseStartDictation(n);
        } else {
            this.lc.log(10000, "MessageDictationHandlerImpl#responseStartDictation: Active command is no MsgDictate[Activate|Continue|Start]Command!");
        }
    }

    public void responseStopDictation(int n) {
        this.lc.log(10000000, "MessageDictationHandlerImpl#responseStopDictation: result=%1", (long)n);
        try {
            ((MsgDictateStopCommand)SDSUtils.getActiveSystemCall()).responseStopDictation(n);
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "MessageDictationHandlerImpl#responseStopDictation: Active command is no MsgDictateDeleteCommand!");
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(100000, "MessageDictationHandlerImpl#responseStopDictation: NullpointerException. No active command!");
        }
    }

    public void responseSendMessage(int n) {
        this.lc.log(10000000, "MessageDictationHandlerImpl#responseSendMessage: result=%1", (long)n);
        try {
            ((MsgSendCommand)SDSUtils.getActiveSystemCall()).responseSendMessage(n);
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "MessageDictationHandlerImpl#responseSendMessage: Active command is no MsgSendCommand!");
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(100000, "MessageDictationHandlerImpl#responseClearBody: NullpointerException. No active command!");
        }
    }

    private boolean isStopRequested() {
        this.lc.log(10000000, "MessageDictationHandlerImpl#isStopRequested: stopRequested=%1", this.stopRequested);
        return this.stopRequested;
    }

    public void setStopRequested(boolean bl) {
        this.lc.log(10000000, "MessageDictationHandlerImpl#setStopRequested: value=%1", bl);
        this.stopRequested = bl;
    }

    public String toString() {
        return "MessageDictationHandlerImpl";
    }

    public void responseBeginDialog(int n) {
        this.lc.log(10000000, "MessageDictationHandlerImpl#responseBeginDialog: result=%1", (long)n);
        try {
            ((MsgDictatePrepareCommand)SDSUtils.getActiveSystemCall()).responseBeginDialog(n);
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "MessageDictationHandlerImpl#responseBeginDialog: Active command is no MsgPrepareDictationCommand!");
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(100000, "MessageDictationHandlerImpl#responseBeginDialog: NullpointerException. No active command!");
        }
    }

    public void responseEndDialog(int n) {
        this.lc.log(10000000, "MessageDictationHandlerImpl#responseEndDialog: result=%1", (long)n);
        AbstractSystemCallCommand abstractSystemCallCommand = SDSUtils.getActiveSystemCall();
        if (abstractSystemCallCommand instanceof MsgSendCommand) {
            ((MsgSendCommand)abstractSystemCallCommand).responseEndDialog(n);
        } else if (abstractSystemCallCommand instanceof MsgDictateFinishCommmand) {
            ((MsgDictateFinishCommmand)abstractSystemCallCommand).responseEndDialog(n);
        } else {
            this.lc.log(10000, "MessageDictationHandlerImpl#responseEndDialog: No active command or active command is no MsgDictateFinish|SendCommand!");
        }
    }

    public void responseNextDialogStep(int n) {
        this.lc.log(10000000, "MessageDictationHandlerImpl#responseNextDialogStep: result=%1", (long)n);
        try {
            ((MsgDictateDialogStepSetCommand)SDSUtils.getActiveSystemCall()).responseNextDialogStep(n);
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "MessageDictationHandlerImpl#responseAddRecipient: Active command is no MsgDictateDialogStepSetCommand!");
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(100000, "MessageDictationHandlerImpl#responseAddRecipient: NullpointerException. No active command!");
        }
    }

    public void responseAddRecipient(int n) {
        this.lc.log(10000000, "MessageDictationHandlerImpl#responseAddRecipient: result=%1", (long)n);
        try {
            ((MsgAddRecipientCommand)SDSUtils.getActiveSystemCall()).responseAddRecipient(n);
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "MessageDictationHandlerImpl#responseAddRecipient: Active command is no MsgNumberAddCommand!");
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(100000, "MessageDictationHandlerImpl#responseAddRecipient: NullpointerException. No active command!");
        }
    }

    public void responseClearRecipients(int n) {
        this.lc.log(10000000, "MessageDictationHandlerImpl#responseClearRecipients: result=%1", (long)n);
        try {
            ((MsgClearRecipientCommand)SDSUtils.getActiveSystemCall()).responseClearRecipients(n);
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "MessageDictationHandlerImpl#responseClearRecipients: Active command is no MsgClearRecipientCommand!");
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(100000, "MessageDictationHandlerImpl#responseClearRecipients: NullpointerException. No active command!");
        }
    }

    public void updateCompositionState(IMessagingDictationService.CompositionState compositionState) {
        this.lc.log(10000000, "MessageDictationHandlerImpl#updateCompositionState: compositionState=%1", (Object)compositionState);
        this.currentCompositionState = compositionState;
    }

    public void evaluateCompositionState() {
        if (this.currentCompositionState == null) {
            return;
        }
        SDSModelAccess.setMsgAccountSelectedModel(this.currentCompositionState.hasAccount() ? 1 : 0);
        this.bodyListener.updateTextModelInfo();
        this.subjectListener.updateTextModelInfo();
        SDSModelAccess.setMsgTemplatesAvailableModel(this.currentCompositionState.getTemplateCount() > 0 ? 1 : 0);
    }

    public void signalStartOfSpeech() {
        if (this.dictationRunning) {
            this.sdsPopupHelper.triggerHapticalPopup(76, true);
            this.sdsPopupHelper.removeFurtherCommandDisplay();
            this.dictationService.getRecognizerStateObserver().indicateStartOfSpeech();
            this.lc.log(10000000, "MessageDictationHandlerImpl#signalStartOfSpeech: send event SDS_ONLINE_RECOG_STARTED");
            this.sdsHandlerService.sendEvent(2005);
        }
    }

    public void signalEndOfSpeech() {
        if (this.dictationRunning) {
            this.lc.log(10000000, "MessageDictationHandlerImpl#signalEndOfSpeech: show processing popup");
            this.sdsPopupHelper.triggerHapticalPopup(77, true);
            this.sdsPopupHelper.removeFurtherCommandDisplay();
            this.sdsPopupHelper.triggerHapticalPopup(76, false);
            this.dictationRunning = false;
            this.dictationService.getRecognizerStateObserver().indicateEndOfSpeech();
        }
    }

    public void updateEmailList(String[] stringArray) {
        this.dynamicLists.addToLookup(33, new DynamicSlotContent("adb email addresses", stringArray, 0));
    }

    public String getCurrentRecipient() {
        if (this.currentCompositionState == null || SDSUtils.isEmpty(this.currentCompositionState.getPrimaryRecipientName())) {
            return SDSModelAccess.getADBEntryNameModel();
        }
        return this.currentCompositionState.getPrimaryRecipientName();
    }

    public void setDictationStep(int n) {
        this.currentDictationStep = n;
    }

    public void dictationStarted() {
        this.dictationRunning = true;
    }

    public void dictationStopped() {
        this.dictationRunning = false;
    }

    public void setEmailAddressDetails(ADBSDSService.EmailAddressDetails emailAddressDetails) {
        this.emailAddressDetails = emailAddressDetails;
    }

    public ADBSDSService.EmailAddressDetails getEmailAddressDetails() {
        return this.emailAddressDetails;
    }

    public int getMessageType() {
        if (this.messageTypeModel == null) {
            return 0;
        }
        switch (this.messageTypeModel.getValue()) {
            case 0: {
                return 1;
            }
            case 1: {
                return 2;
            }
        }
        return 0;
    }

    public boolean isDictationRunning() {
        return this.dictationRunning;
    }
}

