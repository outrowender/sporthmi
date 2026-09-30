/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.remotehmi.sds;

import de.audi.app.online.evo.HMIViewLocationInputListenerEvo;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.interapp.OnlineService;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.TimerListener;
import de.audi.remotehmi.IRemoteHMISpeechCommandSDS;
import de.audi.remotehmi.IRemoteHMISpeechContext;
import de.audi.remotehmi.IRemoteHMISpeechEntity;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.tghu.online.app.Online;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.audi.tghu.online.app.remotehmi.sds.HMISpeechASRListener;
import de.esolutions.fw.util.commons.Buffer;

public class HMISpeechASRListenerEvo
extends HMISpeechASRListener
implements OnlineService,
TimerListener {
    public static final int SDS_COMMAND_DISPLAY_TYPE_BIG = 0;
    public static final int SDS_COMMAND_DISPLAY_TYPE_SMALL = 1;
    public static final int SDS_COMMAND_DISPLAY_TYPE_DEFAULT = 2;
    public static final int SDS_COMMAND_DISPLAY_TYPE_NAVI = 3;
    public static final int SDS_COMMAND_DISPLAY_TYPE_FURTHER = 4;
    public static final int SDS_COMMAND_DISPLAY_TYPE_RESET = 100;
    private static final long DIALOG_MOVE_TIMEOUT = 45000L;
    private static final int SDS_HELP_TYPE_TOPICS = 0;
    private static final int SDS_HELP_TYPE_SUBTOPIC = 1;
    private IRemoteHMISpeechContext.CommandDisplay applicationCommandDisplay;
    private static final int HELP_LINE_NUMBERS_DISABLED = 0;
    private static final int HELP_LINE_NUMBERS_ENABLED = 1;
    public static final int[] SDS_REMOTHMI_HELP_PROMPT_LONG_MODELS = new int[]{2300858, 2300859};
    public static final int[] SDS_REMOTHMI_HELP_PROMPT_SHORT_MODELS = new int[]{2300860, 2300861};
    public static final int[] SDS_REMOTEHMI_PROMPT_LONG_MODELS = new int[]{2300888, 2300889};
    public static final int[] SDS_REMOTEHMI_ONLINE_PROMPT_MODELS = new int[]{2301343, 2301343};
    public static final int[] SDS_REMOTEHMI_PROMPT_SHORT_MODELS = new int[]{2300890, 2300891};
    public static final int[] SDS_REMOTHMI_CONFIRMATIONPROMPT_SHORT_MODELS = new int[]{2300886, 2300887};
    public static final int[] SDS_REMOTHMI_CONFIRMATIONPROMPT_LONG_MODELS = new int[]{2300884, 2300885};
    public static final int[] SDS_SMALL_COMMAND_DISPLAY_TEXT_MODELS = new int[]{4003, 3997, 3998, 4192, 4191, 3999, 4001, 4000, 4002};
    public static final int[] SDS_FURTHER_COMMAND_DISPLAY_TEXT_MODELS = new int[]{2300893, 2300894, 2300895, 2300896, 2300897};
    public static final int[] SDS_BIG_COMMAND_DISPLAY_TEXT_MODELS = new int[]{2300534, 2300535, 2300536, 2300537, 2300538, 2300539};
    public static final int[] SDS_PTTBIG_COMMAND_DISPLAY_TEXT_MODELS = new int[]{2300970, 2300971, 2300972, 2300973, 2300974, 2300975};

    protected void setupModelGroup() {
        super.setupModelGroup();
        this.addToModelGroup(SDS_PTTBIG_COMMAND_DISPLAY_TEXT_MODELS);
        this.addToModelGroup(SDS_BIG_COMMAND_DISPLAY_TEXT_MODELS);
        this.addToModelGroup(SDS_FURTHER_COMMAND_DISPLAY_TEXT_MODELS);
        this.addToModelGroup(SDS_SMALL_COMMAND_DISPLAY_TEXT_MODELS);
        this.addToModelGroup(SDS_REMOTHMI_CONFIRMATIONPROMPT_LONG_MODELS);
        this.addToModelGroup(SDS_REMOTHMI_CONFIRMATIONPROMPT_SHORT_MODELS);
        this.addToModelGroup(SDS_REMOTEHMI_PROMPT_SHORT_MODELS);
        this.addToModelGroup(SDS_REMOTEHMI_PROMPT_LONG_MODELS);
        this.addToModelGroup(SDS_REMOTHMI_HELP_PROMPT_SHORT_MODELS);
        this.addToModelGroup(SDS_REMOTHMI_HELP_PROMPT_LONG_MODELS);
    }

    public void init(LogChannel logChannel, RemoteHMIService remoteHMIService) {
        super.init(logChannel, remoteHMIService);
        this.logChannel = Online.getInstance().getLogChannelRemoteHMISpeech();
        this.setCommandDisplayType(2);
        this.setHelpEnabled(false);
        this.setHelpDisplayType(1);
        this.setCommandModeInPassiveSMEnabled(true);
        this.setHelpLineNumbersEnabled(1);
        this.setSystemCorrectionCommandDisabled(false);
    }

    protected void setHelpCommandsEnabled(boolean bl) {
        this.logChannel.log(1000000, "HMISpeechASRListenerEvo#setHelpCommandsEnabled: value %1", (Object)Boolean.toString(bl));
    }

    protected void processPrompts(IRemoteHMISpeechContext iRemoteHMISpeechContext) {
        String[] stringArray;
        String[] stringArray2;
        String[] stringArray3;
        String[] stringArray4;
        String[] stringArray5;
        if (iRemoteHMISpeechContext == null) {
            this.logChannel.log(1000000, "HMISpeechASRListenerEvo#processPrompts: speech context is null, aborting setting prompts");
            return;
        }
        IRemoteHMISpeechEntity iRemoteHMISpeechEntity = iRemoteHMISpeechContext.getOnlinePrompt();
        this.logChannel.log(1000000, "HMISpeechASRListenerEvo#processPrompts: setting labels for online prompts");
        if (iRemoteHMISpeechEntity == null) {
            String[] stringArray6 = new String[1];
            stringArray5 = stringArray6;
            stringArray6[0] = "";
        } else {
            stringArray5 = iRemoteHMISpeechEntity.getTexts();
        }
        this.setModelsByArray(stringArray5, SDS_REMOTEHMI_ONLINE_PROMPT_MODELS, true);
        int n = 0;
        if (iRemoteHMISpeechEntity != null && iRemoteHMISpeechEntity.getTexts() != null && iRemoteHMISpeechEntity.getTexts().length > 0) {
            n = 1;
        }
        this.logChannel.log(1000000, "HMISpeechASRListenerEvo#processPrompts: setting choice model for activating online prompt to %1", (long)n);
        this.getModelBank().getChoiceModel(2301342).setValue(n);
        iRemoteHMISpeechEntity = iRemoteHMISpeechContext.getPrompt();
        this.logChannel.log(1000000, "HMISpeechASRListenerEvo#processPrompts: setting labels for long prompts");
        if (iRemoteHMISpeechEntity == null) {
            String[] stringArray7 = new String[1];
            stringArray4 = stringArray7;
            stringArray7[0] = "";
        } else {
            stringArray4 = iRemoteHMISpeechEntity.getTexts();
        }
        this.setModelsByArray(stringArray4, SDS_REMOTEHMI_PROMPT_LONG_MODELS, true);
        iRemoteHMISpeechEntity = iRemoteHMISpeechContext.getShortPrompt();
        this.logChannel.log(1000000, "HMISpeechASRListenerEvo#processPrompts: setting labels for short prompts");
        if (iRemoteHMISpeechEntity == null) {
            String[] stringArray8 = new String[1];
            stringArray3 = stringArray8;
            stringArray8[0] = "";
        } else {
            stringArray3 = iRemoteHMISpeechEntity.getTexts();
        }
        this.setModelsByArray(stringArray3, SDS_REMOTEHMI_PROMPT_SHORT_MODELS, true);
        iRemoteHMISpeechEntity = iRemoteHMISpeechContext.getPardonPrompt();
        this.logChannel.log(1000000, "HMISpeechASRListenerEvo#processPrompts: setting labels for long pardonprompts");
        if (iRemoteHMISpeechEntity == null) {
            String[] stringArray9 = new String[1];
            stringArray2 = stringArray9;
            stringArray9[0] = "";
        } else {
            stringArray2 = iRemoteHMISpeechEntity.getTexts();
        }
        this.setModelsByArray(stringArray2, SDS_REMOTHMI_HELP_PROMPT_LONG_MODELS, true);
        iRemoteHMISpeechEntity = iRemoteHMISpeechContext.getShortPardonPrompt();
        this.logChannel.log(1000000, "HMISpeechASRListenerEvo#processPrompts: setting labels for short pardonprompts");
        if (iRemoteHMISpeechEntity == null) {
            String[] stringArray10 = new String[1];
            stringArray = stringArray10;
            stringArray10[0] = "";
        } else {
            stringArray = iRemoteHMISpeechEntity.getTexts();
        }
        this.setModelsByArray(stringArray, SDS_REMOTHMI_HELP_PROMPT_SHORT_MODELS, true);
    }

    private void setModelsByArray(String[] stringArray, int[] nArray, boolean bl) {
        String string = "";
        int n = 0;
        Integer n2 = new Integer(nArray.length > 1 ? nArray.length - 1 : nArray.length);
        Buffer buffer = new Buffer("HMISpeechASRListenerEvo#setModelsByArray: ");
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            try {
                if (stringArray != null && i2 < stringArray.length && stringArray[i2] != null && stringArray[i2].length() > 0) {
                    string = stringArray[i2];
                    n = 1;
                } else if (stringArray == null || i2 >= stringArray.length && string != null && string.length() > 0 && bl) {
                    n = 1;
                } else {
                    string = "";
                    n = 0;
                }
                buffer.append("setting model label (");
                buffer.append(i2);
                buffer.append("/");
                buffer.append(n2);
                buffer.append("): ");
                buffer.append(string);
                buffer.append("\n");
                this.getModelBank().getLabelModel(nArray[i2]).setText(string);
                this.getModelBank().getLabelModel(nArray[i2]).setStatus(n);
                continue;
            }
            catch (Exception exception) {
                this.logChannel.log(1000000, "HMISpeechASRListenerEvo#setModelsByArray: Exception occured %1", (Throwable)exception);
            }
        }
        this.logChannel.log(1000000, buffer.toString());
    }

    protected void processCommandDisplay(IRemoteHMISpeechContext iRemoteHMISpeechContext) {
        Object object;
        IRemoteHMISpeechContext.CommandDisplay commandDisplay;
        IRemoteHMISpeechContext.CommandDisplay commandDisplay2 = iRemoteHMISpeechContext != null ? iRemoteHMISpeechContext.getCommandDisplay() : null;
        IRemoteHMISpeechContext.CommandDisplay commandDisplay3 = commandDisplay = iRemoteHMISpeechContext != null ? iRemoteHMISpeechContext.getFurtherCommandsDisplay() : null;
        if (commandDisplay != null) {
            this.logChannel.log(10000000, "HMISpeechASRListenerEvo#processCommandDisplay: further command display");
            object = commandDisplay.getFurtherCommands();
            this.setModelsByArray((String[])object, SDS_FURTHER_COMMAND_DISPLAY_TEXT_MODELS, false);
        }
        if (iRemoteHMISpeechContext != null && iRemoteHMISpeechContext.isNavLocationInput()) {
            this.logChannel.log(10000000, "HMISpeechASRListenerEvo#processCommandDisplay: no command display");
            this.setCommandDisplayType(2);
        } else if (commandDisplay2 != null) {
            if (iRemoteHMISpeechContext != null && iRemoteHMISpeechContext.isSkipSds()) {
                this.logChannel.log(10000000, "HMISpeechASRListenerEvo#processCommandDisplay: 'Please wait' command display");
                this.setCommandDisplayType(3);
                return;
            }
            if (commandDisplay2.getType() == 0) {
                this.logChannel.log(10000000, "HMISpeechASRListenerEvo#processCommandDisplay: big command display");
                this.setCommandDisplayType(0);
                object = commandDisplay2.getMessage();
                this.setModelsByArray((String[])object, SDS_BIG_COMMAND_DISPLAY_TEXT_MODELS, false);
            } else if (commandDisplay2.getType() == 1) {
                this.logChannel.log(10000000, "HMISpeechASRListenerEvo#processCommandDisplay: small command display");
                this.setCommandDisplayType(1);
                object = commandDisplay2.getMessageZeroLines();
                String string = commandDisplay2.getMessageOneLine();
                String string2 = commandDisplay2.getMessageOneLinePrev();
                String string3 = commandDisplay2.getMessageOneLinePrevNext();
                String string4 = commandDisplay2.getMessageOneLineNext();
                String string5 = commandDisplay2.getMessageXLines();
                String string6 = commandDisplay2.getMessageXLinesPrev();
                String string7 = commandDisplay2.getMessageXLinesNext();
                String string8 = commandDisplay2.getMessageXLinesPrevNext();
                String[] stringArray = new String[]{object, string, string2, string3, string4, string5, string6, string7, string8};
                this.replacePipe(stringArray);
                this.setModelsByArray(stringArray, SDS_SMALL_COMMAND_DISPLAY_TEXT_MODELS, false);
            } else {
                this.logChannel.log(10000000, "HMISpeechASRListenerEvo#processCommandDisplay: default command display");
                this.setCommandDisplayType(2);
            }
        } else if (iRemoteHMISpeechContext != null && iRemoteHMISpeechContext.isSkipSds()) {
            this.logChannel.log(10000000, "HMISpeechASRListenerEvo#processCommandDisplay: 'Please wait' command display else");
            this.setCommandDisplayType(3);
        } else {
            this.logChannel.log(10000000, "HMISpeechASRListenerEvo#processCommandDisplay: default command display");
            this.setCommandDisplayType(2);
        }
    }

    private void replacePipe(String[] stringArray) {
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            String string;
            if (stringArray[i2] == null || stringArray[i2].indexOf("|") == -1) continue;
            stringArray[i2] = string = stringArray[i2].replace('|', '\n');
        }
    }

    private void setConfirmationPromptModels(IRemoteHMISpeechCommandSDS iRemoteHMISpeechCommandSDS, String[] stringArray, int[] nArray) {
        String string = "";
        int n = 0;
        Integer n2 = new Integer(nArray.length > 1 ? nArray.length - 1 : nArray.length);
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            try {
                if (stringArray != null && i2 < stringArray.length && stringArray[i2] != null && stringArray[i2].length() > 0) {
                    string = stringArray[i2];
                    n = 1;
                    string = this.replacePlaceholder(iRemoteHMISpeechCommandSDS, string);
                    this.logChannel.log(1000000, "HMISpeechASRListenerEvo#setConfirmationPromptModels: setting model label (%1/%2):  %3", (Object)Integer.toString(i2), (Object)n2, (Object)string);
                } else if (stringArray == null || i2 >= stringArray.length && string != null && string.length() > 0) {
                    n = 1;
                    this.logChannel.log(1000000, "HMISpeechASRListenerEvo#setConfirmationPromptModels: setting model label (%1/%2):  %3", (Object)new Integer(i2), (Object)n2, (Object)string);
                } else {
                    string = "";
                    n = 0;
                    this.logChannel.log(1000000, "HMISpeechASRListenerEvo#setConfirmationPromptModels: disabling model label (%1/%2)", (Object)new Integer(i2), (Object)n2);
                }
                this.getModelBank().getLabelModel(nArray[i2]).setText(string);
                this.getModelBank().getLabelModel(nArray[i2]).setStatus(n);
                continue;
            }
            catch (Exception exception) {
                this.logChannel.log(1000000, "HMISpeechASRListenerEvo#setConfirmationPromptModels: exception %1", (Throwable)exception);
                exception.printStackTrace();
            }
        }
    }

    protected void setConfirmationPrompts(IRemoteHMISpeechCommandSDS iRemoteHMISpeechCommandSDS, String[] stringArray, String[] stringArray2) {
        this.logChannel.log(1000000, "HMISpeechASRListenerEvo#setConfirmationPrompts: setting labels for long confirmationPrompts");
        this.setConfirmationPromptModels(iRemoteHMISpeechCommandSDS, stringArray, SDS_REMOTHMI_CONFIRMATIONPROMPT_LONG_MODELS);
        this.logChannel.log(1000000, "HMISpeechASRListenerEvo#setConfirmationPrompts: setting labels for short confirmationPrompts");
        this.setConfirmationPromptModels(iRemoteHMISpeechCommandSDS, stringArray2, SDS_REMOTHMI_CONFIRMATIONPROMPT_SHORT_MODELS);
    }

    private String replacePlaceholder(IRemoteHMISpeechCommandSDS iRemoteHMISpeechCommandSDS, String string) {
        if (iRemoteHMISpeechCommandSDS != null && string != null && string.length() > 0 && string.equals("$")) {
            this.logChannel.log(1000000, "HMISpeechASRListenerEvo#replacePlaceholder: replacing %1 with %2", (Object)string, (Object)iRemoteHMISpeechCommandSDS.getText());
            string = iRemoteHMISpeechCommandSDS.getText();
            return iRemoteHMISpeechCommandSDS.getText();
        }
        return string;
    }

    protected void handleRecognizedId(final int n, int n2) {
        try {
            Object object;
            IRemoteHMISpeechCommandSDS iRemoteHMISpeechCommandSDS;
            this.logChannel.log(10000000, "HMISpeechASRListenerEvo#handleRecognizedId: Called.");
            this.setCommandModeInPassiveSMEnabled(false);
            this.setDialogMoveType(-1);
            this.helpIsOpen = false;
            boolean bl = false;
            boolean bl2 = false;
            String string = null;
            IRemoteHMISpeechCommandSDS iRemoteHMISpeechCommandSDS2 = iRemoteHMISpeechCommandSDS = n2 == 3 ? null : this.findRecognizedCommand(n);
            if (iRemoteHMISpeechCommandSDS != null) {
                this.logChannel.log(10000000, "HMISpeechASRListenerEvo#handleRecognizedId: recognized command found %1", (Object)iRemoteHMISpeechCommandSDS.getText());
                object = iRemoteHMISpeechCommandSDS.getConfirmationPrompts();
                String[] stringArray = iRemoteHMISpeechCommandSDS.getShortConfirmationPrompts();
                if (object != null || stringArray != null) {
                    bl2 = true;
                    this.setConfirmationPrompts(iRemoteHMISpeechCommandSDS, (String[])object, stringArray);
                } else if (object == null) {
                    this.logChannel.log(1000000, "HMISpeechASRListenerEvo#handleRecognizedId: command found, but no confirmation prompt");
                } else if (stringArray == null) {
                    this.logChannel.log(1000000, "HMISpeechASRListenerEvo#handleRecognizedId: command found, but no short confirmation prompt");
                }
                bl = iRemoteHMISpeechCommandSDS.isStopDialog();
                string = iRemoteHMISpeechCommandSDS.getIDName();
                this.logChannel.log(1000000, "HMISpeechASRListenerEvo#handleRecognizedId: command idName %1, dialog stop is %2", (Object)string, (Object)Boolean.toString(bl));
            }
            if (n2 == 3) {
                this.logChannel.log(1000000, "HMISpeechASRListenerEvo#handleRecognizedId: using 'Audi connect' confirmation prompt");
                this.getModelBank().getLabelModel(2300884).setStatus(2);
                this.getModelBank().getLabelModel(2300886).setStatus(2);
            } else if (!bl2) {
                this.setConfirmationPrompts(null, new String[]{""}, new String[]{""});
            }
            if (n2 != 3 && iRemoteHMISpeechCommandSDS == null) {
                this.logChannel.log(100000, "HMISpeechASRListenerEvo#handleRecognizedId: no command found for ID %1", (Object)Integer.toString(n));
                this.setDialogMoveType(1);
                return;
            }
            if (bl) {
                this.logChannel.log(1000000, "HMISpeechASRListenerEvo#handleRecognizedId: sending end_without_prompt dialog event, stop set to true");
                this.setDialogMoveType(7);
            } else {
                int n3 = this.getDialogMoveType();
                if (n3 == -1) {
                    this.logChannel.log(1000000, "HMISpeechASRListenerEvo#handleRecognizedId: delaying dialog move");
                    this.setDialogMoveType(-2);
                }
            }
            if (n2 == 3) {
                this.setDialogMoveType(-2);
                this.remoteHmiService.execute(new AbstractRemoteHMITask("handleRecognizedId"){

                    public void run() {
                        RemoteHMIAction remoteHMIAction = HMISpeechASRListenerEvo.this.getAction(901);
                        remoteHMIAction.getParameters().put("selectedId", "-1");
                        HMISpeechASRListenerEvo.this.remoteHmiService.invokeAction(remoteHMIAction);
                    }
                });
            } else if (this.localSpeechConfiguration != null && this.localSpeechConfiguration.isNavLocationInput() && n2 == 0) {
                this.finishNavDestFormInput();
            } else if (n2 == 2 || n2 == 1) {
                this.logChannel.log(1000000, "HMISpeechASRListenerEvo#handleRecognizedId: sending selectedID ASR HELP");
                this.remoteHmiService.execute(new AbstractRemoteHMITask("handleRecognizedId"){

                    public void run() {
                        HMISpeechASRListenerEvo.this.logChannel.log(1000000, "HMISpeechASRListenerEvo#invokeAction: running selectedID ASR HELP");
                        RemoteHMIAction remoteHMIAction = HMISpeechASRListenerEvo.this.getAction(901);
                        remoteHMIAction.getParameters().put("selectedId", Integer.toString(n));
                        HMISpeechASRListenerEvo.this.remoteHmiService.invokeAction(remoteHMIAction);
                    }
                });
            } else if (n2 == 0) {
                this.logChannel.log(1000000, "HMISpeechASRListenerEvo#handleRecognizedId: sending selectedID action %1", (Object)string);
                object = string;
                this.remoteHmiService.execute(new AbstractRemoteHMITask("handleRecognizedId", (String)object){
                    private final /* synthetic */ String val$idString;
                    {
                        this.val$idString = string2;
                        super(string);
                    }

                    public void run() {
                        RemoteHMIAction remoteHMIAction = HMISpeechASRListenerEvo.this.getAction(900);
                        remoteHMIAction.getParameters().put("selectedId", this.val$idString);
                        remoteHMIAction.getParameters().put("actionId", this.val$idString);
                        HMISpeechASRListenerEvo.this.remoteHmiService.invokeAction(remoteHMIAction);
                    }
                });
            }
        }
        catch (Exception exception) {
            this.logChannel.log(10000000, "HMISpeechASRListenerEvo#handleRecognizedId: exception %1", (Throwable)exception);
        }
        this.modelGroup.flush();
    }

    public void performDialogMove(int n) {
        this.logChannel.log(1000000, "HMISpeechASRListenerEvo#performDialogMove: called");
        this.cancelDialogMoveTimer();
        int n2 = -1;
        if (n == 2) {
            n2 = 1338;
        } else if (n == 1) {
            n2 = 1337;
        } else if (n == 7) {
            n2 = 2445;
        } else if (n == 3) {
            n2 = 1331;
        } else if (n == 4) {
            this.remoteHmiService.getNaviComponent().setRemoteHMILocationInputMode(true);
            n2 = 1936;
        } else if (n == 5) {
            n2 = 1975;
        } else if (n == 6) {
            n2 = this.distributedServiceEvent;
        }
        if (n2 != -1) {
            this.logChannel.log(1000000, "HMISpeechASRListenerEvo#performDialogMove: move type is %1, firing event %2", (long)n, (long)n2);
            this.getFrameworkAccess().getHMIService().fireSMEvent(6, n2);
        } else {
            this.logChannel.log(10000, "HMISpeechASRListenerEvo#performDialogMove: invalid parameter %1", (long)n);
        }
    }

    public void remoteHMIUpdateHelp() {
        this.logChannel.log(1000000, "HMISpeechASRListenerEvo#remoteHMIUpdateHelp: remoteHMIUpdateHelp %1", (Object)this.lastSpeechContext);
        if (this.contextSpeechConfiguration == null) {
            this.logChannel.log(100000, "HMISpeechASRListenerEvo#remoteHMIUpdateHelp: No help config found.");
            this.loadHelpForSubTopic(null);
        } else {
            this.loadHelpForSubTopic(this.lastSpeechContext);
        }
    }

    public void remoteHMIResetNavLocationInput() {
        this.logChannel.log(1000000, "HMISpeechASRListenerEvo#remoteHMIResetNavLocationInput: Called");
        this.remoteHmiService.getNaviComponent().setRemoteHMILocationInputMode(false);
    }

    public void onExit() {
        this.setSystemCorrectionCommandDisabled(false);
    }

    public void helpClosed() {
        this.logChannel.log(1000000, "HMISpeechASRListenerEvo#helpClosed: Called");
        this.unhideAllLineNumbers();
    }

    protected void unhideLineNumbers(int n) {
        ChoiceModelApp choiceModelApp = this.getModelBank().getChoiceModel(n);
        choiceModelApp.setValue(1);
    }

    public void indicateApplicationCommands(IRemoteHMISpeechContext.CommandDisplay commandDisplay) {
        if (this.isSDSRunning() && this.checkIsPTTCommandDisplayFilled() && this.applicationCommandDisplay != null && commandDisplay != null && this.applicationCommandDisplay.getContext() != null && commandDisplay != null && this.applicationCommandDisplay.getContext().equals(commandDisplay.getContext())) {
            this.logChannel.log(10000000, "HMISpeechASRListenerEvo#indicateApplicationCommands: sds running, discarding changes on PTT commandDisplay for context %1", (Object)commandDisplay.getContext());
            return;
        }
        if (commandDisplay != null) {
            this.applicationCommandDisplay = commandDisplay;
            if (commandDisplay.getMessage() == null || commandDisplay.getMessage().length < 1) {
                this.logChannel.log(100000, "HMISpeechASRListenerEvo#indicateApplicationCommands: messages are empty in CMD");
            }
            String[] stringArray = commandDisplay.getMessage();
            this.logChannel.log(10000000, "HMISpeechASRListenerEvo#indicateApplicationCommands: setting ptt big command display");
            this.setModelsByArray(stringArray, SDS_PTTBIG_COMMAND_DISPLAY_TEXT_MODELS, false);
        }
        this.modelGroup.flush();
    }

    public boolean checkIsPTTCommandDisplayFilled() {
        LabelModelApp labelModelApp = this.getModelBank().getLabelModel(2300970);
        if (labelModelApp.getText() == null || labelModelApp.getText().length() == 0) {
            this.logChannel.log(10000000, "HMISpeechASRListenerEvo#indicateApplicationCommands: ptt commandDisplay is empty");
            return false;
        }
        return true;
    }

    protected void disableSubtopicCommandDisplay(int n, String string) {
        HMIModelApp hMIModelApp;
        this.logChannel.log(10000000, "HMISpeechASRListenerEvo#disableSubtopicCommandDisplay: %1 SubTopic HelpCommandDisplay", (Object)(n == 0 ? "disabling" : "enabling"));
        if (string != null && string.length() > 0) {
            n = 1;
            hMIModelApp = this.getFrameworkAccess().getHMIService().getLabelModel(2301199);
            hMIModelApp.setText(string);
            this.logChannel.log(10000000, "HMISpeechASRListenerEvo#disableSubtopicCommandDisplay: setting helpPrompt %1", (Object)string);
        } else {
            this.logChannel.log(10000000, "HMISpeechASRListenerEvo#disableSubtopicCommandDisplay: no helpPrompt available");
        }
        hMIModelApp = this.getFrameworkAccess().getHMIService().getChoiceModel(2300987);
        hMIModelApp.setValue(n);
    }

    protected void disablePleaseWaitLoop(int n) {
        this.logChannel.log(10000000, "HMISpeechASRListenerEvo#disablePleaseWaitLoop: %1 data update Running Loop", (Object)(n == 0 ? "disabling" : "enabling"));
        ChoiceModelApp choiceModelApp = this.getFrameworkAccess().getHMIService().getChoiceModel(2300988);
        choiceModelApp.setValue(n);
    }

    protected void hideAllLineNumbers() {
        this.logChannel.log(1000000, "HMISpeechASRListenerEvo#hideAllLineNumbers: Called");
        this.hideLineNumbers(2301016);
    }

    protected void unhideAllLineNumbers() {
        this.logChannel.log(1000000, "HMISpeechASRListenerEvo#unhideAllLineNumbers: Called");
        this.unhideLineNumbers(2301016);
    }

    protected void finishNavDestFormInput() {
        this.logChannel.log(1000000, "HMISpeechASRListener#finishNavDestFormInput: Called.");
        this.setDialogMoveType(-2);
        HMIViewLocationInputListenerEvo hMIViewLocationInputListenerEvo = (HMIViewLocationInputListenerEvo)this.remoteHmiService.getViewListener(6100);
    }
}

