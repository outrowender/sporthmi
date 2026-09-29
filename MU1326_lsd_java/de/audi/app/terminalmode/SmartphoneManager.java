/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.SmartphoneManager$SmartphoneType;
import de.audi.app.terminalmode.audio.IAudioConnectionHandle;
import de.audi.app.terminalmode.audio.TMAudioConnection;
import de.audi.app.terminalmode.commands.TextInputStateChanged;
import de.audi.app.terminalmode.dsi.IAppState;
import de.audi.app.terminalmode.dsi.IResource;
import de.audi.app.terminalmode.keyevents.TMKeyEventsHandler;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManagerListener;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.commands.AbstractCommand;
import de.audi.app.terminalmode.statemachine.commands.AudioLowering;
import de.audi.app.terminalmode.statemachine.commands.SendResponseModeChanged;
import de.audi.app.terminalmode.statemachine.commands.StartService;
import de.audi.app.terminalmode.statemachine.commands.UpdateMode;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;
import de.esolutions.fw.util.commons.job.Job;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class SmartphoneManager
implements IDSISmartphoneManagerListener {
    private final String LOGCLASS;
    protected final LogChannel logger;
    protected final IContext context;
    protected final TMKeyEventsHandler keyEventsHandler;
    private final IDSISmartphoneManager dsiManager;
    private final SmartphoneManager$SmartphoneType type;
    private final IAudioConnectionHandle duckAudioCompletelyAudioConnectionHandle;
    private final IStateHandler stateHandler;
    static /* synthetic */ Class class$de$audi$app$terminalmode$SmartphoneManager$SmartphoneType;

    public SmartphoneManager(IContext iContext, SmartphoneManager$SmartphoneType smartphoneManager$SmartphoneType, IDSISmartphoneManager iDSISmartphoneManager, IStateHandler iStateHandler) {
        this.context = iContext;
        this.logger = iContext.getLogger().main();
        this.keyEventsHandler = iContext.getKeyEventsHandler();
        this.LOGCLASS = new StringBuffer().append("SmartphoneManager(").append(smartphoneManager$SmartphoneType.toString()).append(")").toString();
        this.type = smartphoneManager$SmartphoneType;
        this.duckAudioCompletelyAudioConnectionHandle = iContext.getAudioManager().createAudioConnectionHandle(TMAudioConnection.SPEECH_GUIDANCE);
        this.dsiManager = iDSISmartphoneManager;
        this.stateHandler = iStateHandler;
    }

    @Override
    public void updateMode(long l, IAppState[] iAppStateArray, IResource[] iResourceArray) {
        this.logger.log(1078071040, "[%1.updateMode]", (Object)this.LOGCLASS);
        AbstractCommand abstractCommand = this.getCurrentCommand();
        if (null == abstractCommand || !abstractCommand.updateStates(iAppStateArray, iResourceArray, l)) {
            this.context.getCommandListHelper().create().addSingle(new UpdateMode(this.context, this.dsiManager, iAppStateArray, iResourceArray, l, this.stateHandler)).addSingle(new SendResponseModeChanged(this.context, this.dsiManager, iAppStateArray, iResourceArray, l, this.stateHandler)).execute("SmartphoneManager.updateMode");
        }
    }

    @Override
    public void ignoreUpdateMode(long l) {
        this.logger.log(1078071040, "[%1.ignoreUpdateMode]", (Object)this.LOGCLASS);
        List list = this.context.getCommandListManager().getQueue().getCommandLists();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Job job = (Job)iterator.next();
            if (null == job) continue;
            CommandList commandList = (CommandList)job.getPayload();
            Collection collection = commandList.getCommands();
            Iterator iterator2 = collection.iterator();
            while (iterator2.hasNext()) {
                Command command = (Command)iterator2.next();
                if (null == command) continue;
                if (command instanceof UpdateMode) {
                    ((UpdateMode)command).ignoreUpdateWithMsgId(l);
                }
                if (!(command instanceof SendResponseModeChanged)) continue;
                ((SendResponseModeChanged)command).ignoreUpdateWithMsgId(l);
            }
        }
    }

    @Override
    public void duckAudio(int n, double d2) {
        this.logger.log(1078071040, "[%1.duckAudio]", (Object)this.LOGCLASS);
        this.context.getCommandListHelper().create().addSingle(new AudioLowering(this.context, true, n)).execute(new StringBuffer().append(this.LOGCLASS).append(".duckAudio").toString());
    }

    @Override
    public void duckAudioCompletely() {
        this.logger.log(1078071040, "[%1.duckAudioCompletely]", (Object)this.LOGCLASS);
        this.context.getCommandListHelper().create().addSingle(this.duckAudioCompletelyAudioConnectionHandle.createRequestCommand(false)).execute(new StringBuffer().append(this.LOGCLASS).append(".duckAudioCompletely").toString());
    }

    @Override
    public void releaseDuckAudioCompletely() {
        this.logger.log(1078071040, "[%1.releaseDuckAudioCompletely]", (Object)this.LOGCLASS);
        this.context.getCommandListHelper().create().addSingle(this.duckAudioCompletelyAudioConnectionHandle.createReleaseCommand()).execute(new StringBuffer().append(this.LOGCLASS).append(".releaseDuckAudioCompletely").toString());
    }

    @Override
    public void unduckAudio(int n) {
        this.logger.log(1078071040, "[%1.unduckAudio]", (Object)this.LOGCLASS);
        this.context.getCommandListHelper().create().addSingle(new AudioLowering(this.context, false, n)).execute(new StringBuffer().append(this.LOGCLASS).append(".unduckAudio").toString());
    }

    private AbstractCommand getCurrentCommand() {
        AbstractCommand abstractCommand = null;
        CommandList commandList = this.context.getCommandListManager().getActiveCommandList();
        if (null != commandList) {
            abstractCommand = (AbstractCommand)commandList.getActiveCommand();
        }
        return abstractCommand;
    }

    @Override
    public void updateTextInputState(boolean bl) {
        this.logger.log(1078071040, "[%1.updateTextInputState]", (Object)this.LOGCLASS);
        this.context.getCommandListHelper().create().addSingle(new TextInputStateChanged(this.context, bl, this.keyEventsHandler)).execute(new StringBuffer().append(this.LOGCLASS).append(".updateTextInputState").toString());
    }

    @Override
    public void updateDSIState(boolean bl) {
        if (bl) {
            this.logger.log(-2137614336, "[%1.updateDSIState] Starting service", (Object)this.LOGCLASS);
            this.context.getCommandListHelper().create().addSingle(new StartService(this.dsiManager, this.context, this.logger, this.stateHandler, this.dsiManager.getSmartphoneProperties())).execute(new StringBuffer().append(this.LOGCLASS).append(".updateDSIState(activated)").toString());
        }
    }

    public String toString() {
        return new StringBuffer().append("SmartphoneManager [type=").append(this.type).append("]").toString();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

