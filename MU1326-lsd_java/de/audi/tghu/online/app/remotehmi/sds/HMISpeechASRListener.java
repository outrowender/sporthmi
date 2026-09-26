/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi.sds;

import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.interapp.OnlineService;
import de.audi.atip.interapp.OnlineServiceListener;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.remotehmi.IRemoteHMISpeechCommandSDS;
import de.audi.remotehmi.IRemoteHMISpeechContext;
import de.audi.remotehmi.IRemoteHMISpeechContext$CommandDisplay;
import de.audi.remotehmi.IRemoteHMISpeechEntity;
import de.audi.remotehmi.IRemoteHMISpeechHelpContext;
import de.audi.remotehmi.IRemoteHMISpeechHelpIntroPrompt;
import de.audi.remotehmi.IRemoteHMISpeechTopicCommandSDS;
import de.audi.remotehmi.IRemoteHMISpeechTopicContext;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.tghu.online.app.Online;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMIComponent;
import de.audi.tghu.online.app.remotehmi.RemoteHMIContext;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.StringUtils;
import java.util.ArrayList;

public class HMISpeechASRListener
extends AbstractRemoteHMIComponent
implements OnlineService,
TimerListener {
    public static final int SDS_COMMAND_DISPLAY_TYPE_BIG;
    public static final int SDS_COMMAND_DISPLAY_TYPE_SMALL;
    public static final int SDS_COMMAND_DISPLAY_TYPE_DEFAULT;
    public static final int SDS_COMMAND_DISPLAY_TYPE_NAVI;
    public static final int SDS_COMMAND_DISPLAY_PLEASE_WAIT;
    public static final int SDS_COMMAND_DISPLAY_TYPE_RESET;
    private static final long DIALOG_MOVE_TIMEOUT;
    private static final int SDS_HELP_TYPE_TOPICS;
    private static final int SDS_HELP_TYPE_SUBTOPIC;
    protected static final int DIALOG_MOVE_TYPE_UNKNOWN;
    protected static final int DIALOG_MOVE_TYPE_DELAYED;
    protected static final int DIALOG_MOVE_TYPE_END;
    protected static final int DIALOG_MOVE_TYPE_CONTINUE;
    protected static final int DIALOG_MOVE_TYPE_HELP_SUBTOPIC;
    protected static final int DIALOG_MOVE_TYPE_NAV_LOCATION_INPUT;
    protected static final int DIALOG_MOVE_TYPE_DATA_UPDATE_ABORT;
    protected static final int DIALOG_MOVE_TYPE_DISTRIBUTES_SERVICE;
    protected static final int DIALOG_MOVE_TYPE_END_WITHOUT_PROMPT;
    protected static final int SCOPE_LOCAL;
    protected static final int SCOPE_CONTEXT;
    protected static final int SCOPE_GLOBAL;
    protected static final int SCOPE_GLOBAL_ENTER;
    private static final int HELP_LINE_NUMBERS_DISABLED;
    private static final int HELP_LINE_NUMBERS_ENABLED;
    protected String lastSpeechContext;
    public static final int[] SDS_HELP_DISPLAY_TEXT_MODELS;
    public static final int[] SDS_HELP_DISPLAY_PROMPT_MODELS;
    public static final int[] SDS_HELP_TOPICS_LABEL_MODELS;
    public static final int[] SDS_HELP_TOPICS_PROMPTS_MODELS;
    protected static final int CONFIRMATION_PROMPT_AUDI_CONNECT;
    protected OnlineServiceListener onlineServiceListener;
    protected int dialogMoveType = -1;
    protected Object dialogMoveLock = new Object();
    protected SDSListEntry[] contextSpeechConfigurationSDS = null;
    protected SDSListEntry[] globalSpeechConfigurationSDS = null;
    protected IRemoteHMISpeechContext localSpeechConfiguration;
    protected IRemoteHMISpeechHelpContext[] contextSpeechConfiguration;
    protected IRemoteHMISpeechTopicContext[] topicSpeechConfiguration;
    protected IRemoteHMISpeechCommandSDS[] globalSpeechConfiguration;
    protected boolean commandModeInPassiveSMEnabled = true;
    protected Timer dialogMoveTimer;
    protected Object dialogMoveTimerLock = new Object();
    protected boolean helpIsOpen = false;
    protected ModelGroup modelGroup = new ModelGroup();
    protected int distributedServiceEvent;

    protected void setupModelGroup() {
        this.addToModelGroup(SDS_HELP_TOPICS_PROMPTS_MODELS);
        this.addToModelGroup(SDS_HELP_TOPICS_LABEL_MODELS);
        this.addToModelGroup(SDS_HELP_DISPLAY_PROMPT_MODELS);
        this.addToModelGroup(SDS_HELP_DISPLAY_TEXT_MODELS);
        this.addToModelGroup(new int[]{-1055251712});
        this.addToModelGroup(new int[]{-602266880});
        this.addToModelGroup(new int[]{-2112216320});
        this.addToModelGroup(new int[]{2132419328});
        this.addToModelGroup(new int[]{232});
    }

    protected void addToModelGroup(int[] nArray) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            try {
                HMIModelApp hMIModelApp = this.getModelBank().getModelApp(nArray[i2]);
                if (hMIModelApp == null) continue;
                this.modelGroup.add(hMIModelApp);
                continue;
            }
            catch (Exception exception) {
                this.logChannel.log(1078071040, "HMISpeechASRListener#addToModelGroup: Exception occured %1", (Throwable)exception);
            }
        }
    }

    @Override
    public void init(LogChannel logChannel, RemoteHMIService remoteHMIService) {
        super.init(logChannel, remoteHMIService);
        this.logChannel = Online.getInstance().getLogChannelRemoteHMISpeech();
        this.setCommandDisplayType(2);
        this.setHelpEnabled(false);
        this.setHelpDisplayType(1);
        this.setCommandModeInPassiveSMEnabled(true);
        this.setHelpLineNumbersEnabled(1);
        this.setSystemCorrectionCommandDisabled(false);
        this.setupModelGroup();
    }

    public void setDistributedServiceMoveType(int n) {
        this.logChannel.log(1078071040, "HMISpeechASRListener#setDistributedServiceMoveType: setting DialogMoveType to %1 and distributedServiceEvent to %2", (Object)new Integer(6), (long)n);
        this.setDialogMoveType(6);
        this.distributedServiceEvent = n;
    }

    protected void setHelpLineNumbersEnabled(int n) {
        this.logChannel.log(1078071040, "HMISpeechASRListener#setHelpLineNumbersEnabled(%1)", (Object)Integer.toString(n));
        this.getModelBank().getChoiceModel(-2112216320).setValue(n);
    }

    public void indicateSpeechContext(IRemoteHMISpeechContext iRemoteHMISpeechContext) {
        RemoteHMIContext remoteHMIContext = this.remoteHmiService.getContext();
        String string = null;
        if (remoteHMIContext != null) {
            string = remoteHMIContext.getContextName();
        }
        this.logChannel.log(1078071040, "HMISpeechASRListener#indicateSpeechContext: Called for context %1.", (Object)string);
        if (iRemoteHMISpeechContext != null) {
            this.processCommandDisplay(iRemoteHMISpeechContext);
            this.logChannel.log(1078071040, "HMISpeechASRListener#indicateSpeechContext: loading new speech context with %1 elements", (long)iRemoteHMISpeechContext.getCommandLength());
            SDSListEntry[] sDSListEntryArray = new SDSListEntry[iRemoteHMISpeechContext.getCommandLength()];
            Buffer buffer = new Buffer();
            for (int i2 = 0; i2 < iRemoteHMISpeechContext.getCommandLength(); ++i2) {
                IRemoteHMISpeechCommandSDS iRemoteHMISpeechCommandSDS = iRemoteHMISpeechContext.getCommand(i2);
                if (iRemoteHMISpeechCommandSDS == null || iRemoteHMISpeechCommandSDS.getText() == null) {
                    this.flushCommandBuffer(buffer);
                    this.logChannel.log(10000, "HMISpeechASRListener#indicateSpeechContext: command %1 is null - skipping", (long)i2);
                    continue;
                }
                sDSListEntryArray[i2] = new SDSListEntry(iRemoteHMISpeechCommandSDS.getText(), iRemoteHMISpeechCommandSDS.getID());
                this.appendToCommandBuffer(buffer, i2, iRemoteHMISpeechCommandSDS.getText(), iRemoteHMISpeechCommandSDS.getID());
            }
            this.flushCommandBuffer(buffer);
            ChoiceModelApp choiceModelApp = this.getModelBank().getChoiceModel(-602266880);
            if (iRemoteHMISpeechContext.useLineNumbers()) {
                this.logChannel.log(1078071040, "HMISpeechASRListener#indicateSpeechContext: activating line numbers grammar");
            }
            choiceModelApp.setValue(iRemoteHMISpeechContext.useLineNumbers() ? 1 : 0);
            this.setSystemCorrectionCommandDisabled(iRemoteHMISpeechContext.isSystemCorrectionCommandDisabled());
            this.setHelpCommandsEnabled(iRemoteHMISpeechContext.isHelpCommandsEnabled());
            boolean bl = iRemoteHMISpeechContext.isDynamicState();
            boolean bl2 = iRemoteHMISpeechContext.isDataUpdateAvailable();
            this.logChannel.log(1078071040, "HMISpeechASRListener#indicateSpeechContext: dynamicState %1 and dataUpdateAvailable %2", bl, bl2);
            if (iRemoteHMISpeechContext.isSkipSds()) {
                this.logChannel.log(1078071040, "HMISpeechASRListener#indicateSpeechContext: isSkip, enabling Please wait Loop and Updating Icon");
                this.disablePleaseWaitLoop(1);
            } else {
                this.logChannel.log(1078071040, "HMISpeechASRListener#indicateSpeechContext: disable Please Wait Loop");
                this.disablePleaseWaitLoop(0);
            }
            if (this.onlineServiceListener != null) {
                this.onlineServiceListener.updateRemoteHMIList(sDSListEntryArray, true);
                this.triggerGrammarUpdate();
            } else {
                this.logChannel.log(10000, "HMISpeechASRListener#indicateSpeechContext: no SDS service found.");
            }
        } else if (this.onlineServiceListener != null) {
            this.onlineServiceListener.updateRemoteHMIList(new SDSListEntry[0], true);
            this.triggerGrammarUpdate();
        } else {
            this.logChannel.log(10000, "HMISpeechASRListener#indicateSpeechContext: no SDS service found.");
        }
        this.processPrompts(iRemoteHMISpeechContext);
        if (remoteHMIContext.getContextName().equals("top_wizard") && iRemoteHMISpeechContext != null && iRemoteHMISpeechContext.isSkipSds()) {
            this.logChannel.log(1078071040, "HMISpeechASRListener#indicateSpeechContext: skip state in top_wizard found, not setting as last localSpeechConfiguration");
        } else {
            this.logChannel.log(1078071040, "HMISpeechASRListener#indicateSpeechContext: setting speechContext as last localSpeechConfiguration");
            this.localSpeechConfiguration = iRemoteHMISpeechContext;
        }
        if (iRemoteHMISpeechContext != null && iRemoteHMISpeechContext.isSkipSds()) {
            this.logChannel.log(1078071040, "HMISpeechASRListener#indicateSpeechContext: found skip state, waiting for next SDS configuration");
            this.setDialogMoveType(-1);
        } else {
            int n = this.getDialogMoveType();
            if (iRemoteHMISpeechContext == null || iRemoteHMISpeechContext.getCommandLength() == 0 && !iRemoteHMISpeechContext.isNavLocationInput()) {
                if (n == 7) {
                    this.logChannel.log(1078071040, "HMISpeechASRListener#indicateSpeechContext: no speech configuration, but DIALOG_MOVE_TYPE_END_WITHOUT_PROMPT, not setting move type");
                } else if (n != 6) {
                    this.logChannel.log(1078071040, "HMISpeechASRListener#indicateSpeechContext: no speech configuration, setting dialog move type to END");
                    this.setDialogMoveType(1);
                } else {
                    this.logChannel.log(1078071040, "HMISpeechASRListener#indicateSpeechContext: no speech configuration, but distributed Service, not setting move type");
                }
            } else if (n != 1) {
                if (iRemoteHMISpeechContext.isNavLocationInput()) {
                    this.logChannel.log(1078071040, "HMISpeechASRListener#indicateSpeechContext: setting dialog move type to NAV_LOCATION_INPUT");
                    this.setDialogMoveType(4);
                } else if (n == 6) {
                    this.logChannel.log(1078071040, "HMISpeechASRListener#indicateSpeechContext: keeping dialog move type for distributed service");
                    this.setDialogMoveType(6);
                } else if (n == 7) {
                    this.logChannel.log(1078071040, "HMISpeechASRListener#indicateSpeechContext: keeping dialog move type for DIALOG_MOVE_TYPE_END_WITHOUT_PROMPT");
                    this.setDialogMoveType(7);
                } else {
                    this.logChannel.log(1078071040, "HMISpeechASRListener#indicateSpeechContext: setting dialog move type to CONTINUE");
                    this.setDialogMoveType(2);
                }
            } else {
                this.logChannel.log(1078071040, "HMISpeechASRListener#indicateSpeechContext: dialog move type is END, doing nothing");
            }
            this.performDialogMove(this.getDialogMoveType());
        }
        this.modelGroup.flush();
    }

    private void flushCommandBuffer(Buffer buffer) {
        this.logChannel.log(1078071040, buffer.toString());
        buffer.clear();
    }

    private void appendToCommandBuffer(Buffer buffer, int n, String string, int n2) {
        if (buffer.length() == 0) {
            buffer.append("HMISpeechASRListener#indicateSpeechContext: ");
        } else {
            buffer.append("\n");
        }
        buffer.append("command ");
        buffer.append(n);
        buffer.append(" is ");
        buffer.append(string);
        buffer.append(" with ID ");
        buffer.append(n2);
    }

    protected void disablePleaseWaitLoop(int n) {
    }

    protected void setHelpCommandsEnabled(boolean bl) {
        this.logChannel.log(1078071040, "HMISpeechASRListener#setHelpCommandsEnabled: value %1", (Object)Boolean.toString(bl));
    }

    protected void processPrompts(IRemoteHMISpeechContext iRemoteHMISpeechContext) {
        this.logChannel.log(1078071040, "HMISpeechASRListener#processPrompts: Called");
    }

    public final void setSystemCorrectionCommandDisabled(boolean bl) {
        this.logChannel.log(1078071040, "HMISpeechASRListener#setSystemCorrectionCommandDisabled: %1", bl);
        ChoiceModelApp choiceModelApp = this.getFrameworkAccess().getHMIService().getChoiceModel(232);
        if (choiceModelApp != null) {
            choiceModelApp.setValue(bl ? 1 : 0);
        }
    }

    protected void triggerGrammarUpdate() {
        if (this.commandModeInPassiveSMEnabled) {
            this.logChannel.log(1078071040, "HMISpeechASRListener#triggerGrammarUpdate: triggering update of grammar in passive SM");
            ChoiceModelApp choiceModelApp = this.getModelBank().getChoiceModel(-568712448);
            int n = choiceModelApp.getValue() != 0 ? 0 : 1;
            choiceModelApp.setValue(n);
        } else {
            this.logChannel.log(1078071040, "HMISpeechASRListener#triggerGrammarUpdate: no update, because dialog is active");
        }
    }

    protected void processCommandDisplay(IRemoteHMISpeechContext iRemoteHMISpeechContext) {
    }

    protected void setCommandDisplayType(int n) {
        this.getModelBank().getChoiceModel(2132419328).setValue(n);
    }

    protected void setHelpDisplayType(int n) {
        this.logChannel.log(1078071040, "HMISpeechASRListener#setHelpDisplayType(%1)", (Object)Integer.toString(n));
        this.getModelBank().getChoiceModel(-619044096).setValue(n);
        int n2 = n == 0 ? 1 : 0;
        this.setHelpLineNumbersEnabled(n2);
    }

    @Override
    public byte freezeDynamicLists() {
        return 0;
    }

    @Override
    public byte unfreezeDynamicLists() {
        return 0;
    }

    protected IRemoteHMISpeechCommandSDS findRecognizedCommand(int n) {
        Object object;
        int n2;
        if (this.localSpeechConfiguration != null) {
            for (n2 = 0; n2 < this.localSpeechConfiguration.getCommandLength(); ++n2) {
                object = this.localSpeechConfiguration.getCommand(n2);
                if (object.getID() != n) continue;
                this.logChannel.log(1078071040, "HMISpeechASRListener#findRecognizedCommand: checking localCommand %1 with id %2", (Object)object.getText(), (Object)new Integer(object.getID()));
                return object;
            }
        }
        if (this.contextSpeechConfiguration != null) {
            for (n2 = 0; n2 < this.contextSpeechConfiguration.length; ++n2) {
                object = this.contextSpeechConfiguration[n2];
                if (object == null) continue;
                for (int i2 = 0; i2 < object.getCommandLength(); ++i2) {
                    IRemoteHMISpeechCommandSDS iRemoteHMISpeechCommandSDS = object.getCommand(i2);
                    if (iRemoteHMISpeechCommandSDS == null || iRemoteHMISpeechCommandSDS.getID() != n) continue;
                    this.logChannel.log(1078071040, "HMISpeechASRListener#findRecognizedCommand: checking helpCommand %1 with id %2", (Object)iRemoteHMISpeechCommandSDS.getText(), (Object)new Integer(iRemoteHMISpeechCommandSDS.getID()));
                    return iRemoteHMISpeechCommandSDS;
                }
            }
        }
        this.logChannel.log(1078071040, "HMISpeechASRListener#findRecognizedCommand: checking global commands");
        if (this.globalSpeechConfiguration != null) {
            this.logChannel.log(1078071040, "HMISpeechASRListener#findRecognizedCommand: checking global commands, count is %1", (Object)new Integer(this.globalSpeechConfiguration.length));
            for (n2 = 0; n2 < this.globalSpeechConfiguration.length; ++n2) {
                object = this.globalSpeechConfiguration[n2];
                this.logChannel.log(1078071040, "HMISpeechASRListener#findRecognizedCommand: checking global command %1", (Object)new Integer(object.getID()));
                if (object.getID() != n) continue;
                return object;
            }
        }
        return null;
    }

    @Override
    public void setRemoteHMIRecognizedID(int n) {
        this.logChannel.log(1078071040, "HMISpeechASRListener#setRemoteHMIRecognizedID: id is %1", (long)n);
        this.handleRecognizedId(n, 0);
    }

    protected void handleRecognizedId(int n, int n2) {
    }

    protected void finishNavDestFormInput() {
    }

    protected void setConfirmationPrompts(IRemoteHMISpeechCommandSDS iRemoteHMISpeechCommandSDS, String[] stringArray, String[] stringArray2) {
        this.logChannel.log(1078071040, "HMISpeechASRListener#setConfirmationPrompts: Called.");
    }

    public void performDialogMove(int n) {
        this.logChannel.log(10000, "HMISpeechASRListener#performDialogMove: Called");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected synchronized void setDialogMoveType(int n) {
        int n2 = this.getDialogMoveType();
        this.logChannel.log(1078071040, "HMISpeechASRListener#setDialogMoveType: type %1 -> %2", (long)n2, (long)n);
        Object object = this.dialogMoveLock;
        synchronized (object) {
            this.dialogMoveType = n;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected int getDialogMoveType() {
        Object object = this.dialogMoveLock;
        synchronized (object) {
            return this.dialogMoveType;
        }
    }

    @Override
    public void setRemoteHMIGlobalRecognizedID(int n) {
        this.logChannel.log(1078071040, "HMISpeechASRListener#setRemoteHMIGlobalRecognizedID *** GLOBAL: id is %1", (long)n);
        this.handleRecognizedId(n, 2);
    }

    @Override
    public void setRemoteHMIHelpRecognizedID(int n, byte by) {
        this.logChannel.log(1078071040, "HMISpeechASRListener#setRemoteHMIHelpRecognizedID *** HELP: type is %1, id is %2", (long)by, (long)n);
        this.helpIsOpen = false;
        if (by == 1) {
            this.setRemoteHMIHelpRecognizedID_ID(n);
        } else if (by == 0) {
            this.setRemoteHMIHelpRecognizedID_Index(n);
        }
    }

    private void setRemoteHMIHelpRecognizedID_ID(int n) {
        this.logChannel.log(1078071040, "HMISpeechASRListener#setRemoteHMIHelpRecognizedID_ID *** HELP: id is %1", (long)n);
        if (n >= 2961665) {
            IRemoteHMISpeechTopicCommandSDS iRemoteHMISpeechTopicCommandSDS = (IRemoteHMISpeechTopicCommandSDS)this.findRecognizedHelpTopicCommand(n);
            if (iRemoteHMISpeechTopicCommandSDS != null) {
                String string = iRemoteHMISpeechTopicCommandSDS.getContext();
                this.logChannel.log(1078071040, "HMISpeechASRListener#setRemoteHMIHelpRecognizedID_ID: loading help topic %1", (Object)string);
                this.loadHelpForSubTopic(string);
                this.setConfirmationPrompts(iRemoteHMISpeechTopicCommandSDS, iRemoteHMISpeechTopicCommandSDS.getConfirmationPrompts(), null);
            } else {
                this.logChannel.log(-1601830656, "HMISpeechASRListener#setRemoteHMIHelpRecognizedID_ID: could not find topic for ID %1", (long)n);
            }
            this.setDialogMoveType(3);
        } else {
            this.handleRecognizedId(n, 1);
        }
    }

    private void setRemoteHMIHelpRecognizedID_Index(int n) {
        this.logChannel.log(1078071040, "HMISpeechASRListener#setRemoteHMIHelpRecognizedID_Index *** HELP: index is %1", (long)n);
        if (n < this.topicSpeechConfiguration.length) {
            IRemoteHMISpeechTopicContext iRemoteHMISpeechTopicContext = this.topicSpeechConfiguration[n];
            IRemoteHMISpeechTopicCommandSDS iRemoteHMISpeechTopicCommandSDS = (IRemoteHMISpeechTopicCommandSDS)iRemoteHMISpeechTopicContext.getCommand(0);
            String string = iRemoteHMISpeechTopicCommandSDS.getContext();
            for (int i2 = 0; i2 < this.topicSpeechConfiguration.length; ++i2) {
                this.logChannel.log(1078071040, "HMISpeechASRListener#setRemoteHMIHelpRecognizedID_Index: context %1 is %2", (Object)Integer.toString(i2), (Object)iRemoteHMISpeechTopicCommandSDS.getContext());
            }
            this.logChannel.log(1078071040, "HMISpeechASRListener#setRemoteHMIHelpRecognizedID_Index: loading help topic %1", (Object)string);
            this.loadHelpForSubTopic(string);
            this.setConfirmationPrompts(iRemoteHMISpeechTopicCommandSDS, iRemoteHMISpeechTopicCommandSDS.getConfirmationPrompts(), null);
            this.setDialogMoveType(3);
        } else {
            this.logChannel.log(-1601830656, "HMISpeechASRListener#setRemoteHMIHelpRecognizedID_Index: invalid index");
        }
    }

    private IRemoteHMISpeechCommandSDS findRecognizedHelpTopicCommand(int n) {
        if (this.topicSpeechConfiguration == null) {
            return null;
        }
        for (int i2 = 0; i2 < this.topicSpeechConfiguration.length; ++i2) {
            for (int i3 = 0; i3 < this.topicSpeechConfiguration[i2].getCommandLength(); ++i3) {
                IRemoteHMISpeechCommandSDS iRemoteHMISpeechCommandSDS = this.topicSpeechConfiguration[i2].getCommand(i3);
                if (n != iRemoteHMISpeechCommandSDS.getID()) continue;
                return iRemoteHMISpeechCommandSDS;
            }
        }
        return null;
    }

    public void setOnlineServiceListener(OnlineServiceListener onlineServiceListener) {
        this.onlineServiceListener = onlineServiceListener;
        this.logChannel.log(1078071040, "HMISpeechASRListener#setOnlineServiceListener: received onlineServiceListener %1", (Object)onlineServiceListener);
        if (onlineServiceListener != null) {
            if (this.contextSpeechConfigurationSDS != null) {
                this.logChannel.log(1078071040, "HMISpeechASRListener#setOnlineServiceListener: updating help commands");
                this.onlineServiceListener.updateRemoteHMIHelpList(this.contextSpeechConfigurationSDS, true);
            } else {
                this.logChannel.log(1078071040, "HMISpeechASRListener#setOnlineServiceListener: contextSpeechConfigurationSDS is null");
            }
            if (this.globalSpeechConfigurationSDS != null) {
                this.logChannel.log(1078071040, "HMISpeechASRListener#setOnlineServiceListener: updating global commands, sending %1 command", (Object)Integer.toString(this.globalSpeechConfigurationSDS.length));
                this.onlineServiceListener.updateRemoteHMIGlobalList(this.globalSpeechConfigurationSDS, true);
            } else {
                this.logChannel.log(1078071040, "HMISpeechASRListener#setOnlineServiceListener: globalSpeechConfigurationSDS is null");
            }
        } else {
            this.logChannel.log(-2137614336, "HMISpeechASRListener#setOnlineServiceListener: receveived null listener");
        }
    }

    protected void setCommandModeInPassiveSMEnabled(boolean bl) {
        this.getModelBank().getChoiceModel(-2145770752).setValue(bl ? 1 : 0);
        this.commandModeInPassiveSMEnabled = bl;
    }

    @Override
    public void requestDialogContinuation() {
        int n;
        this.logChannel.log(1078071040, "HMISpeechASRListener#requestDialogContinuation, current moveType %1", (long)this.getDialogMoveType());
        if (this.onlineServiceListener != null) {
            this.onlineServiceListener.setRemoteHMICategorySetFinished((byte)0);
        }
        if ((n = this.getDialogMoveType()) != -1 && n != -2) {
            this.logChannel.log(1078071040, "HMISpeechASRListener#requestDialogContinuation: dialog step information was provided, using %1", (Object)Integer.toString(n));
            this.performDialogMove(n);
        } else {
            this.startDialogMoveTimer();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void startDialogMoveTimer() {
        this.logChannel.log(1078071040, "HMISpeechASRListener#startDialogMoveTimer: starting timeout timer");
        Object object = this.dialogMoveTimerLock;
        synchronized (object) {
            if (this.dialogMoveTimer != null) {
                this.dialogMoveTimer.cancel();
            }
            this.dialogMoveTimer = new Timer("HMISpeechASRListener#dialogMoveTimer", 5, this.logChannel, this, 0, true);
            this.dialogMoveTimer.start();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void cancelDialogMoveTimer() {
        Object object = this.dialogMoveTimerLock;
        synchronized (object) {
            if (this.dialogMoveTimer != null) {
                this.dialogMoveTimer.cancel();
                this.dialogMoveTimer = null;
            }
        }
    }

    @Override
    public void dialogStepFinished() {
        this.logChannel.log(1078071040, "HMISpeechASRListener#dialogStepFinished");
        this.setCommandModeInPassiveSMEnabled(true);
        this.setDialogMoveType(-1);
    }

    @Override
    public void helpOpened(int n) {
        try {
            this.logChannel.log(1078071040, "HMISpeechASRListener#helpOpened: %1", (long)n);
            this.hideAllLineNumbers();
            if (n == 1) {
                this.setHelpDisplayType(0);
            } else if (n == 2) {
                this.setHelpDisplayType(1);
            }
            this.helpIsOpen = true;
        }
        catch (Exception exception) {
            this.logChannel.log(1078071040, "HMISpeechASRListener#helpOpened: Exception %1", (Throwable)exception);
        }
    }

    protected void hideAllLineNumbers() {
        this.logChannel.log(1078071040, "HMISpeechASRListener#hideAllLineNumbers: Called");
    }

    protected void hideLineNumbers(int n) {
        ChoiceModelApp choiceModelApp = this.getModelBank().getChoiceModel(n);
        choiceModelApp.setValue(0);
    }

    public void indicateSpeechHelpContexts(IRemoteHMISpeechHelpContext[] iRemoteHMISpeechHelpContextArray, IRemoteHMISpeechTopicContext[] iRemoteHMISpeechTopicContextArray, IRemoteHMISpeechHelpIntroPrompt iRemoteHMISpeechHelpIntroPrompt) {
        try {
            Object object;
            Object object2;
            Object object3;
            int n;
            this.logChannel.log(1078071040, "HMISpeechASRListener#indicateSpeechHelpContexts: updating topic and subtopic commands.");
            if (iRemoteHMISpeechHelpContextArray == null && iRemoteHMISpeechTopicContextArray == null) {
                this.logChannel.log(1078071040, "HMISpeechASRListener#indicateSpeechHelpContexts: helpContexts and topicCommands are empty -> no Speech Help available");
            }
            if (iRemoteHMISpeechHelpContextArray == null) {
                iRemoteHMISpeechHelpContextArray = new IRemoteHMISpeechHelpContext[]{};
            }
            if (iRemoteHMISpeechTopicContextArray == null) {
                iRemoteHMISpeechTopicContextArray = new IRemoteHMISpeechTopicContext[]{};
            }
            this.logChannel.log(-2137614336, "HMISpeechASRListener#indicateSpeechHelpContexts: received contexts, help count=%1, topic count=%2", (long)iRemoteHMISpeechHelpContextArray.length, (long)iRemoteHMISpeechTopicContextArray.length);
            this.contextSpeechConfiguration = iRemoteHMISpeechHelpContextArray;
            this.topicSpeechConfiguration = iRemoteHMISpeechTopicContextArray;
            ArrayList arrayList = new ArrayList(5);
            if (!this.helpIsOpen) {
                this.loadHelpForSubTopic(null);
            } else {
                this.logChannel.log(-2137614336, "HMISpeechASRListener#indicateSpeechHelpContexts: not calling loadHelpForSubTopic, because help is open");
            }
            if (iRemoteHMISpeechHelpIntroPrompt != null) {
                String string = iRemoteHMISpeechHelpIntroPrompt.getHelpIntroPrompts() != null && iRemoteHMISpeechHelpIntroPrompt.getHelpIntroPrompts().length > 0 ? iRemoteHMISpeechHelpIntroPrompt.getHelpIntroPrompts()[0] : "";
                this.logChannel.log(1078071040, "HMISpeechASRListener#indicateSpeechHelpContexts: received global help intro prompt %1", (Object)string);
                this.getModelBank().getLabelModel(-1055251712).setText(string);
            }
            for (n = 0; n < iRemoteHMISpeechTopicContextArray.length; ++n) {
                object3 = iRemoteHMISpeechTopicContextArray[n];
                if (object3 != null && object3.getCommandLength() > 0) {
                    Object object4;
                    object2 = (IRemoteHMISpeechTopicCommandSDS)object3.getCommand(0);
                    if (object2 != null && object2.getText() != null && object2.getText().length() > 0) {
                        if (n < SDS_HELP_TOPICS_PROMPTS_MODELS.length) {
                            String string = object3.getLabel() != null && object3.getLabel().length() > 0 ? object3.getLabel() : "";
                            object = object3.getPrompt() != null && object3.getPrompt().getTexts() != null && object3.getPrompt().getTexts().length > 0 ? object3.getPrompt().getTexts()[0] : "";
                            this.logChannel.log(-2137614336, "HMISpeechASRListener#indicateSpeechHelpContexts: topicContext label: %1, and prompt: %2, noHelpPrompt: %3", (Object)string, object, (Object)(object3.getNoHelpPrompt() == null ? "empty" : object3.getNoHelpPrompt().getNoHelpPrompts()[0]));
                            object4 = this.getModelBank().getLabelModel(SDS_HELP_TOPICS_PROMPTS_MODELS[n]);
                            object4.setText((String)object);
                            object4.setStatus(1);
                            LabelModelApp labelModelApp = this.getModelBank().getLabelModel(SDS_HELP_TOPICS_LABEL_MODELS[n]);
                            labelModelApp.setText(string);
                            labelModelApp.setStatus(1);
                        }
                    } else {
                        this.logChannel.log(-2137614336, "HMISpeechASRListener#indicateSpeechHelpContexts: topicCommand is null or text is empty");
                    }
                    for (int i2 = 0; i2 < object3.getCommandLength(); ++i2) {
                        object = (IRemoteHMISpeechTopicCommandSDS)object3.getCommand(i2);
                        if (object == null) continue;
                        this.logChannel.log(-2137614336, "HMISpeechASRListener#indicateSpeechHelpContexts: topicCommand SDSListEntry: text %1 ID %2", (Object)object.getText(), (Object)Integer.toString(object.getID()));
                        this.logChannel.log(-2137614336, "HMISpeechASRListener#indicateSpeechHelpContexts: topicCommand text: %1, confirmationPrompt: %2, id: %3", (Object)object.getText(), object.getConfirmationPrompts() != null && object.getConfirmationPrompts().length > 0 ? object.getConfirmationPrompts()[0] : null, (Object)Integer.toString(object.getID()));
                        this.logChannel.log(-2137614336, "HMISpeechASRListener#indicateSpeechHelpContexts: topicCommand context:  %1", (Object)object.getContext());
                        object4 = new SDSListEntry(object.getText(), object.getID());
                        arrayList.add(object4);
                    }
                    continue;
                }
                this.logChannel.log(-2137614336, "HMISpeechASRListener#indicateSpeechHelpContexts: topicContext has no Commands");
            }
            for (n = iRemoteHMISpeechTopicContextArray.length; n < SDS_HELP_TOPICS_LABEL_MODELS.length; ++n) {
                object3 = this.getModelBank().getLabelModel(SDS_HELP_TOPICS_PROMPTS_MODELS[n]);
                object3.setText("");
                object3.setStatus(0);
                object2 = this.getModelBank().getLabelModel(SDS_HELP_TOPICS_LABEL_MODELS[n]);
                object2.setText("");
                object2.setStatus(0);
            }
            if (iRemoteHMISpeechHelpContextArray != null) {
                this.logChannel.log(-2137614336, "HMISpeechASRListener#indicateSpeechHelpContexts: having %1 help contexts", (long)iRemoteHMISpeechHelpContextArray.length);
                for (n = 0; n < iRemoteHMISpeechHelpContextArray.length; ++n) {
                    object3 = iRemoteHMISpeechHelpContextArray[n];
                    if (object3 != null) {
                        for (int i3 = 0; i3 < object3.getCommandLength(); ++i3) {
                            IRemoteHMISpeechCommandSDS iRemoteHMISpeechCommandSDS = object3.getCommand(i3);
                            this.logChannel.log(-2137614336, "HMISpeechASRListener#indicateSpeechHelpContexts: helpCommand SDSListEntry: text %1 ID %2", (Object)(iRemoteHMISpeechCommandSDS != null && iRemoteHMISpeechCommandSDS.getText() != null ? iRemoteHMISpeechCommandSDS.getText() : ""), (Object)(iRemoteHMISpeechCommandSDS != null ? Integer.toString(iRemoteHMISpeechCommandSDS.getID()) : ""));
                            this.logChannel.log(-2137614336, "HMISpeechASRListener#indicateSpeechHelpContexts: helpCommand text: %1, confirmationPrompt: %2, id: %3, helpIntroPrompt: %4", (Object)(iRemoteHMISpeechCommandSDS != null && iRemoteHMISpeechCommandSDS.getText() != null ? iRemoteHMISpeechCommandSDS.getText() : ""), (Object)(iRemoteHMISpeechCommandSDS != null && iRemoteHMISpeechCommandSDS.getConfirmationPrompts() != null && iRemoteHMISpeechCommandSDS.getConfirmationPrompts().length > 0 ? iRemoteHMISpeechCommandSDS.getConfirmationPrompts() : null), (Object)(iRemoteHMISpeechCommandSDS == null ? null : Integer.toString(iRemoteHMISpeechCommandSDS.getID())), object3.getIntroPrompts() != null && object3.getIntroPrompts().length > 0 ? object3.getIntroPrompts()[0] : null);
                            object = new SDSListEntry(iRemoteHMISpeechCommandSDS.getText(), iRemoteHMISpeechCommandSDS.getID());
                            arrayList.add(object);
                        }
                        continue;
                    }
                    this.logChannel.log(1078071040, "HMISpeechASRListener#indicateSpeechHelpContexts: helpContext is null");
                }
            }
            this.setHelpEnabled(iRemoteHMISpeechHelpContextArray.length > 0);
            SDSListEntry[] sDSListEntryArray = new SDSListEntry[arrayList.size()];
            for (int i4 = 0; i4 < arrayList.size(); ++i4) {
                sDSListEntryArray[i4] = (SDSListEntry)arrayList.get(i4);
                this.logChannel.log(-2137614336, "HMISpeechASRListener#indicateSpeechHelpContexts: list entry %1 is %2", (Object)Integer.toString(i4), (Object)sDSListEntryArray[i4]);
            }
            this.contextSpeechConfigurationSDS = sDSListEntryArray;
            if (this.onlineServiceListener != null) {
                this.logChannel.log(-2137614336, "HMISpeechASRListener#indicateSpeechHelpContexts: sending list to recognizer");
                this.onlineServiceListener.updateRemoteHMIHelpList(sDSListEntryArray, true);
            } else {
                this.logChannel.log(10000, "HMISpeechASRListener#indicateSpeechHelpContexts: no online service listener");
            }
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "HMISpeechASRListener#indicateSpeechHelpContexts: error on setting topic and subtopics %1", (Throwable)exception);
        }
        this.modelGroup.flush();
    }

    protected void setHelpEnabled(boolean bl) {
        this.logChannel.log(1078071040, "HMISpeechASRListener#setHelpEnabled: help enabled: %1", (Object)Boolean.toString(bl));
        ChoiceModelApp choiceModelApp = this.getFrameworkAccess().getHMIService().getChoiceModel(451);
        if (choiceModelApp != null) {
            choiceModelApp.setStatus(bl ? 1 : 0);
        }
    }

    protected void loadHelpForSubTopic(String string) {
        Object object;
        this.logChannel.log(1078071040, "HMISpeechASRListener#loadHelpForSubTopic: loading help for index %1", (Object)string);
        if (string == null) {
            this.setHelpDisplayType(0);
        } else {
            this.setHelpDisplayType(1);
        }
        ArrayList arrayList = new ArrayList(5);
        if (this.contextSpeechConfiguration != null && string != null) {
            for (int i2 = 0; i2 < this.contextSpeechConfiguration.length; ++i2) {
                String string2;
                String string3 = string2 = this.contextSpeechConfiguration[i2] != null ? this.contextSpeechConfiguration[i2].getContext() : "";
                if (string2 == null || !string2.equals(string)) continue;
                arrayList.add(this.contextSpeechConfiguration[i2]);
            }
        }
        String string4 = null;
        if (this.topicSpeechConfiguration != null) {
            for (int i3 = 0; i3 < this.topicSpeechConfiguration.length; ++i3) {
                IRemoteHMISpeechTopicContext iRemoteHMISpeechTopicContext = this.topicSpeechConfiguration[i3];
                if (string == null || iRemoteHMISpeechTopicContext == null || iRemoteHMISpeechTopicContext.getCommands() == null || iRemoteHMISpeechTopicContext.getCommands().length < 1 || !((IRemoteHMISpeechTopicCommandSDS)iRemoteHMISpeechTopicContext.getCommands()[0]).getContext().equals(string) || iRemoteHMISpeechTopicContext.getNoHelpPrompt() == null || (object = iRemoteHMISpeechTopicContext.getNoHelpPrompt().getNoHelpPrompts()) == null || ((String[])object).length <= 0) continue;
                string4 = object[0];
            }
        } else {
            this.logChannel.log(-2137614336, "HMISpeechASRListener#loadHelpForSubtopic: no topicSpeechConfiguration");
        }
        if (arrayList.isEmpty()) {
            this.disableSubtopicCommandDisplay(0, string4);
            this.setHelpDisplayType(0);
        } else {
            this.disableSubtopicCommandDisplay(2, string4);
        }
        String[] stringArray = null;
        for (int i4 = 0; i4 < SDS_HELP_DISPLAY_TEXT_MODELS.length; ++i4) {
            IRemoteHMISpeechHelpContext iRemoteHMISpeechHelpContext;
            object = "";
            String string5 = "";
            IRemoteHMISpeechHelpContext iRemoteHMISpeechHelpContext2 = iRemoteHMISpeechHelpContext = arrayList.size() > i4 ? (IRemoteHMISpeechHelpContext)arrayList.get(i4) : null;
            if (iRemoteHMISpeechHelpContext != null && iRemoteHMISpeechHelpContext.getPrompt() != null && iRemoteHMISpeechHelpContext.getPromptLength() > 0 && iRemoteHMISpeechHelpContext.getPrompt().getTexts() != null && iRemoteHMISpeechHelpContext.getPrompt().getTexts().length > 0) {
                string5 = iRemoteHMISpeechHelpContext.getPrompt().getTexts()[0];
                this.logChannel.log(1078071040, "HMISpeechASRListener#loadHelpForSubTopic: setting help prompt %1", (Object)string5);
            }
            if (iRemoteHMISpeechHelpContext != null && iRemoteHMISpeechHelpContext.getHelpTitle() != null) {
                object = iRemoteHMISpeechHelpContext.getHelpTitle();
                this.logChannel.log(1078071040, "HMISpeechASRListener#loadHelpForSubTopic: loading help text %1", object);
            }
            LabelModelApp labelModelApp = this.getModelBank().getLabelModel(SDS_HELP_DISPLAY_TEXT_MODELS[i4]);
            labelModelApp.setText((String)object);
            labelModelApp.setStatus(((String)object).length() > 0 ? 1 : 0);
            labelModelApp = this.getModelBank().getLabelModel(SDS_HELP_DISPLAY_PROMPT_MODELS[i4]);
            labelModelApp.setText(string5);
            labelModelApp.setStatus(string5.length() > 0 ? 1 : 0);
            if (iRemoteHMISpeechHelpContext == null) continue;
            stringArray = iRemoteHMISpeechHelpContext.getIntroPrompts();
        }
        LabelModelApp labelModelApp = this.getModelBank().getLabelModel(-1793449216);
        if (stringArray != null && stringArray.length > 0) {
            labelModelApp.setText((String)stringArray[0]);
            labelModelApp.setStatus(1);
            this.logChannel.log(1078071040, "HMISpeechASRListener#loadHelpForSubTopic: loading subtopic introHelpText %1", (Object)stringArray[0]);
        } else {
            labelModelApp.setStatus(0);
            this.logChannel.log(1078071040, "HMISpeechASRListener#loadHelpForSubTopic: disabling introPrompt");
        }
        object = "";
        if (this.topicSpeechConfiguration != null) {
            block3: for (int i5 = 0; i5 < this.topicSpeechConfiguration.length; ++i5) {
                for (int i6 = 0; i6 < this.topicSpeechConfiguration[i5].getCommandLength(); ++i6) {
                    if (this.topicSpeechConfiguration[i5].getCommand(i6) == null || ((IRemoteHMISpeechTopicCommandSDS)this.topicSpeechConfiguration[i5].getCommand(i6)).getContext() == null || !((IRemoteHMISpeechTopicCommandSDS)this.topicSpeechConfiguration[i5].getCommand(i6)).getContext().equals(string)) continue;
                    object = this.topicSpeechConfiguration[i5].getLabel();
                    continue block3;
                }
            }
        }
        this.getModelBank().getLabelModel(-1474682112).setText((String)object);
        this.modelGroup.flush();
    }

    protected void disableSubtopicCommandDisplay(int n, String string) {
    }

    public void indicateSpeechGlobalCommands(IRemoteHMISpeechCommandSDS[] iRemoteHMISpeechCommandSDSArray) {
        IRemoteHMISpeechCommandSDS[] iRemoteHMISpeechCommandSDSArray2 = iRemoteHMISpeechCommandSDSArray;
        if (iRemoteHMISpeechCommandSDSArray2 == null) {
            iRemoteHMISpeechCommandSDSArray2 = new IRemoteHMISpeechCommandSDS[]{};
        }
        this.logChannel.log(-2137614336, "HMISpeechASRListener#indicateSpeechGlobalCommands(): Called, number of elements is %1.", (long)iRemoteHMISpeechCommandSDSArray2.length);
        this.globalSpeechConfiguration = iRemoteHMISpeechCommandSDSArray2;
        SDSListEntry[] sDSListEntryArray = new SDSListEntry[this.globalSpeechConfiguration.length];
        for (int i2 = 0; i2 < iRemoteHMISpeechCommandSDSArray2.length; ++i2) {
            sDSListEntryArray[i2] = new SDSListEntry(iRemoteHMISpeechCommandSDSArray2[i2].getText(), iRemoteHMISpeechCommandSDSArray2[i2].getID());
        }
        this.globalSpeechConfigurationSDS = sDSListEntryArray;
        if (this.onlineServiceListener != null) {
            this.logChannel.log(-2137614336, "HMISpeechASRListener#indicateSpeechGlobalCommands(): Updating global commands, count is %1.", (long)sDSListEntryArray.length);
            this.onlineServiceListener.updateRemoteHMIGlobalList(sDSListEntryArray, true);
        } else {
            this.logChannel.log(-2137614336, "HMISpeechASRListener#indicateSpeechGlobalCommands(): Not updating global commands (len %1), no listener.", (Object)Integer.toString(sDSListEntryArray.length));
        }
    }

    public void indicateCurrentSpeechHelpContext(String string) {
        this.lastSpeechContext = string;
        this.logChannel.log(1078071040, "HMISpeechASRListener#indicateCurrentSpeechHelpContext(): Received context ID %1.", (Object)string);
        if (this.contextSpeechConfiguration == null) {
            this.logChannel.log(-1601830656, "HMISpeechASRListener#indicateCurrentSpeechHelpContext(): No help config found.");
            this.loadHelpForSubTopic(null);
        } else {
            this.loadHelpForSubTopic(string);
        }
        this.modelGroup.flush();
    }

    public String getCurrentLocalConfigurationAsString() {
        Buffer buffer = new Buffer();
        buffer.append("Local configuration:\n");
        if (this.localSpeechConfiguration != null) {
            this.appendContext(buffer, this.localSpeechConfiguration);
        }
        return buffer.toString();
    }

    public String getCurrentGlobalConfigurationAsString() {
        Buffer buffer = new Buffer();
        buffer.append("Global configuration:\n");
        if (this.globalSpeechConfiguration != null) {
            for (int i2 = 0; i2 < this.globalSpeechConfiguration.length; ++i2) {
                IRemoteHMISpeechCommandSDS iRemoteHMISpeechCommandSDS = this.globalSpeechConfiguration[i2];
                buffer.append("* command: ");
                buffer.append(iRemoteHMISpeechCommandSDS.getText());
                buffer.append(", id ");
                buffer.append(iRemoteHMISpeechCommandSDS.getID());
                buffer.append("\n");
            }
        }
        return buffer.toString();
    }

    public String getCurrentContextConfigurationAsString() {
        int n;
        Buffer buffer = new Buffer();
        buffer.append("Context configuration:\n");
        if (this.contextSpeechConfiguration != null) {
            for (n = 0; n < this.contextSpeechConfiguration.length; ++n) {
                IRemoteHMISpeechHelpContext iRemoteHMISpeechHelpContext = this.contextSpeechConfiguration[n];
                buffer.append("-- Context ");
                buffer.append(iRemoteHMISpeechHelpContext.getHelpTitle());
                buffer.append("\n");
                this.appendContext(buffer, iRemoteHMISpeechHelpContext);
            }
        }
        buffer.append("Topic list configuration:\n");
        if (this.topicSpeechConfiguration != null) {
            for (n = 0; n < this.topicSpeechConfiguration.length; ++n) {
                for (int i2 = 0; i2 < this.topicSpeechConfiguration[n].getCommandLength(); ++i2) {
                    IRemoteHMISpeechCommandSDS iRemoteHMISpeechCommandSDS = this.topicSpeechConfiguration[n].getCommand(i2);
                    buffer.append("-- Topic Command ");
                    buffer.append(iRemoteHMISpeechCommandSDS.getText());
                    buffer.append(", id ");
                    buffer.append(iRemoteHMISpeechCommandSDS.getID());
                    buffer.append("\n");
                }
            }
        }
        buffer.append("\n");
        buffer.append("SDS context configuration:\n");
        if (this.contextSpeechConfigurationSDS != null) {
            for (n = 0; n < this.contextSpeechConfigurationSDS.length; ++n) {
                buffer.append(new StringBuffer().append("\t* ").append(this.contextSpeechConfigurationSDS[n].getName()).append(", id ").append(this.contextSpeechConfigurationSDS[n].getId()).append("\n").toString());
            }
        }
        return buffer.toString();
    }

    private void appendContext(Buffer buffer, IRemoteHMISpeechContext iRemoteHMISpeechContext) {
        Object object;
        for (int i2 = 0; i2 < iRemoteHMISpeechContext.getCommandLength(); ++i2) {
            object = iRemoteHMISpeechContext.getCommand(i2);
            buffer.append("\t* command: ");
            buffer.append(object.getText());
            buffer.append("\n");
            buffer.append("\t\t\t");
            buffer.append("id: ");
            buffer.append(object.getID());
            buffer.append("\n");
            buffer.append("\t\t\t");
            buffer.append("idName: ");
            buffer.append(object.getIDName());
            buffer.append("\n");
            buffer.append("\t\t\t");
            buffer.append("longConfirmationPrompt: ");
            buffer.append(object.getConfirmationPrompts() != null ? StringUtils.toString(object.getConfirmationPrompts(), '|') : "null");
            buffer.append("\n");
            buffer.append("\t\t\t");
            buffer.append("shortConfirmationPrompt: ");
            buffer.append(object.getShortConfirmationPrompts() != null ? StringUtils.toString(object.getShortConfirmationPrompts(), '|') : "null");
            buffer.append("\n");
        }
        IRemoteHMISpeechEntity iRemoteHMISpeechEntity = iRemoteHMISpeechContext.getPrompt();
        buffer.append("\t* prompt: ");
        buffer.append(iRemoteHMISpeechEntity == null ? "null" : iRemoteHMISpeechEntity.getTexts()[0]);
        buffer.append(", id ");
        buffer.append(iRemoteHMISpeechEntity == null ? "null" : new StringBuffer().append("").append(iRemoteHMISpeechEntity.getId()).toString());
        buffer.append("\n");
        object = iRemoteHMISpeechContext.getPardonPrompt();
        buffer.append("\t* pardonPrompt: ");
        buffer.append(object == null ? "null" : object.getTexts()[0]);
        buffer.append("\t");
        buffer.append("id ");
        buffer.append(object == null ? "null" : new StringBuffer().append("").append(object.getId()).toString());
        buffer.append("\n");
    }

    @Override
    public void fireTimer(Timer timer) {
        if (this.localSpeechConfiguration != null && this.localSpeechConfiguration.isSkipSds()) {
            this.logChannel.log(-1601830656, "HMISpeechASRListener#fireTimer: SDS timeout occured in skip state, aborting dialog");
            this.performDialogMove(5);
            return;
        }
        this.logChannel.log(-1601830656, "HMISpeechASRListener#fireTimer: SDS timeout occured, closing dialog");
        this.performDialogMove(7);
    }

    @Override
    public void cancelTimer(Timer timer) {
    }

    @Override
    public void setRemoteHMINavDestFormFinished() {
        this.logChannel.log(1078071040, "HMISpeechASRListener#setRemoteHMINavDestFormFinished: Called.");
        this.finishNavDestFormInput();
    }

    @Override
    public void setRemoteHMIGlobalEnter() {
        this.logChannel.log(1078071040, "HMISpeechASRListener#setRemoteHMIGlobalEnter: Called.");
        this.handleRecognizedId(-1, 3);
        this.logChannel.log(1078071040, "HMISpeechASRListener#setRemoteHMIGlobalEnter: lastSpeechContext %1, localSpeechConfiguration %2", (Object)this.lastSpeechContext, (Object)this.localSpeechConfiguration);
        if (this.lastSpeechContext != null && this.lastSpeechContext.equals("top_wizard")) {
            try {
                this.logChannel.log(1078071040, "HMISpeechASRListener#setRemoteHMIGlobalEnter: Updating top_wizard.");
                this.indicateSpeechContext(this.localSpeechConfiguration);
            }
            catch (Exception exception) {
                this.logChannel.log(1078071040, "HMISpeechASRListener#setRemoteHMIGlobalEnter: exception occured %1", (Throwable)exception);
            }
        } else {
            this.logChannel.log(1078071040, "HMISpeechASRListener#setRemoteHMIGlobalEnter: last localSpeechContext is null or not ROOT_CONTEXT");
        }
    }

    @Override
    public void setDisclaimerResult(boolean bl) {
        this.logChannel.log(1078071040, "HMISpeechASRListener#setDisclaimerResult: Called %1.", bl);
        this.remoteHmiService.getInitializationHandler().processDisclaimerResult(bl);
    }

    protected RemoteHMIAction getAction(int n) {
        return this.remoteHmiService.getAction(n);
    }

    @Override
    public void remoteHMIUpdateHelp() {
        this.logChannel.log(1078071040, "HMISpeechASRListener#remoteHMIUpdateHelp: remoteHMIUpdateHelp %1", (Object)this.lastSpeechContext);
        if (this.contextSpeechConfiguration == null) {
            this.logChannel.log(-1601830656, "HMISpeechASRListener#remoteHMIUpdateHelp: No help config found.");
            this.loadHelpForSubTopic(null);
        } else {
            this.loadHelpForSubTopic(this.lastSpeechContext);
        }
    }

    @Override
    public void remoteHMISetRecognizedLineNumber() {
        this.logChannel.log(1078071040, "HMISpeechASRListener#remoteHMISetRecognizedLineNumber: Called");
        this.setCommandModeInPassiveSMEnabled(false);
        if (this.localSpeechConfiguration != null && this.localSpeechConfiguration.useLineNumbersStopDialog()) {
            this.setDialogMoveType(1);
        } else {
            this.setDialogMoveType(-1);
        }
    }

    public void forceCommandDisplayUpdate() {
        this.logChannel.log(1078071040, "HMISpeechASRListener#forceCommandDisplayUpdate: Called");
        this.setCommandModeInPassiveSMEnabled(true);
        this.setCommandDisplayType(100);
        this.processCommandDisplay(this.localSpeechConfiguration);
    }

    @Override
    public void remoteHMIResetNavLocationInput() {
        this.logChannel.log(1078071040, "HMISpeechASRListener#remoteHMIResetNavLocationInput: Called");
        this.remoteHmiService.getNaviComponent().setRemoteHMILocationInputMode(false);
    }

    @Override
    public void onExit() {
        this.setSystemCorrectionCommandDisabled(false);
    }

    public void helpClosed() {
        this.logChannel.log(1078071040, "HMISpeechASRListener#helpClosed: Called");
        this.unhideAllLineNumbers();
    }

    protected void unhideAllLineNumbers() {
        this.logChannel.log(1078071040, "HMISpeechASRListener#unhideAllLineNumbers: Called");
    }

    protected void unhideLineNumbers(int n) {
        ChoiceModelApp choiceModelApp = this.getModelBank().getChoiceModel(n);
        choiceModelApp.setValue(1);
    }

    public void indicateApplicationCommands(IRemoteHMISpeechContext$CommandDisplay iRemoteHMISpeechContext$CommandDisplay) {
    }

    public OnlineServiceListener getOnlineServiceListener() {
        return this.onlineServiceListener;
    }

    public boolean isSDSRunning() {
        if (this.getModelBank().getChoiceModel(335).getValue() == 2 || this.getModelBank().getChoiceModel(335).getValue() == 8) {
            this.logChannel.log(-2137614336, "HMISpeechASRListener#isSDSRunning: SDS running");
            return true;
        }
        return false;
    }

    static {
        SDS_HELP_DISPLAY_TEXT_MODELS = new int[]{-1776672000, -1759894784, -1608899840, -1592122624, -1575345408, -1558568192, -1541790976, -1525013760, -1508236544, -1491459328, -1743117568, -1726340352, -1709563136, -1692785920, -1676008704, -1659231488, -1642454272, -1625677056};
        SDS_HELP_DISPLAY_PROMPT_MODELS = new int[]{-2095439104, -2078661888, -1927666944, -1910889728, -1894112512, -1877335296, -1860558080, -1843780864, -1827003648, -1810226432, -2061884672, -2045107456, -2028330240, -2011553024, -1994775808, -1977998592, -1961221376, -1944444160};
        SDS_HELP_TOPICS_LABEL_MODELS = new int[]{-1038474496, -1021697280, -837147904, -753261824, -736484608, -719707392, -702930176, -686152960, -669375744, -652598528, -1004920064, -988142848, -971365632, -954588416, -937811200, -921033984, -904256768, -887479552, -870702336, -853925120, -820370688, -803593472, -786816256, -770039040};
        SDS_HELP_TOPICS_PROMPTS_MODELS = new int[]{-1457904896, -1441127680, -1256578304, -1172692224, -1155915008, -1139137792, -1122360576, -1105583360, -1088806144, -1072028928, -1424350464, -1407573248, -1390796032, -1374018816, -1357241600, -1340464384, -1323687168, -1306909952, -1290132736, -1273355520, -1239801088, -1223023872, -1206246656, -1189469440};
    }
}

