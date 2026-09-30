/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.IContext;
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
import de.audi.app.terminalmode.util.Enum;
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
    private final SmartphoneType type;
    private final IAudioConnectionHandle duckAudioCompletelyAudioConnectionHandle;
    private final IStateHandler stateHandler;
    static /* synthetic */ Class class$de$audi$app$terminalmode$SmartphoneManager$SmartphoneType;

    public SmartphoneManager(IContext iContext, SmartphoneType smartphoneType, IDSISmartphoneManager iDSISmartphoneManager, IStateHandler iStateHandler) {
        this.context = iContext;
        this.logger = iContext.getLogger().main();
        this.keyEventsHandler = iContext.getKeyEventsHandler();
        this.LOGCLASS = new StringBuffer().append("SmartphoneManager(").append(smartphoneType.toString()).append(")").toString();
        this.type = smartphoneType;
        this.duckAudioCompletelyAudioConnectionHandle = iContext.getAudioManager().createAudioConnectionHandle(TMAudioConnection.SPEECH_GUIDANCE);
        this.dsiManager = iDSISmartphoneManager;
        this.stateHandler = iStateHandler;
    }

    public void updateMode(long l, IAppState[] iAppStateArray, IResource[] iResourceArray) {
        this.logger.log(1000000, "[%1.updateMode]", (Object)this.LOGCLASS);
        AbstractCommand abstractCommand = this.getCurrentCommand();
        if (null == abstractCommand || !abstractCommand.updateStates(iAppStateArray, iResourceArray, l)) {
            this.context.getCommandListHelper().create().addSingle(new UpdateMode(this.context, this.dsiManager, iAppStateArray, iResourceArray, l, this.stateHandler)).addSingle(new SendResponseModeChanged(this.context, this.dsiManager, iAppStateArray, iResourceArray, l, this.stateHandler)).execute("SmartphoneManager.updateMode");
        }
    }

    public void ignoreUpdateMode(long l) {
        this.logger.log(1000000, "[%1.ignoreUpdateMode]", (Object)this.LOGCLASS);
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

    public void duckAudio(int n, double d2) {
        this.logger.log(1000000, "[%1.duckAudio]", (Object)this.LOGCLASS);
        this.context.getCommandListHelper().create().addSingle(new AudioLowering(this.context, true, n)).execute(new StringBuffer().append(this.LOGCLASS).append(".duckAudio").toString());
    }

    public void duckAudioCompletely() {
        this.logger.log(1000000, "[%1.duckAudioCompletely]", (Object)this.LOGCLASS);
        this.context.getCommandListHelper().create().addSingle(this.duckAudioCompletelyAudioConnectionHandle.createRequestCommand(false)).execute(new StringBuffer().append(this.LOGCLASS).append(".duckAudioCompletely").toString());
    }

    public void releaseDuckAudioCompletely() {
        this.logger.log(1000000, "[%1.releaseDuckAudioCompletely]", (Object)this.LOGCLASS);
        this.context.getCommandListHelper().create().addSingle(this.duckAudioCompletelyAudioConnectionHandle.createReleaseCommand()).execute(new StringBuffer().append(this.LOGCLASS).append(".releaseDuckAudioCompletely").toString());
    }

    public void unduckAudio(int n) {
        this.logger.log(1000000, "[%1.unduckAudio]", (Object)this.LOGCLASS);
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

    public void updateTextInputState(boolean bl) {
        this.logger.log(1000000, "[%1.updateTextInputState]", (Object)this.LOGCLASS);
        this.context.getCommandListHelper().create().addSingle(new TextInputStateChanged(this.context, bl, this.keyEventsHandler)).execute(new StringBuffer().append(this.LOGCLASS).append(".updateTextInputState").toString());
    }

    public void updateDSIState(boolean bl) {
        if (bl) {
            this.logger.log(10000000, "[%1.updateDSIState] Starting service", (Object)this.LOGCLASS);
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

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static class SmartphoneType
    extends Enum<SmartphoneType> {
        public static final SmartphoneType CARPLAY = new SmartphoneType(1, "CARPLAY");
        public static final SmartphoneType ANDROIDAUTO2 = new SmartphoneType(2, "ANDROIDAUTO2");
        public static final SmartphoneType CARLIFE = new SmartphoneType(3, "CARLIFE");
        public static final SmartphoneType UNKNOWN = new SmartphoneType(0, "UNKNOWN");

        private SmartphoneType(int n, String string) {
            super(n, string);
        }

        public static SmartphoneType valueOf(String string) throws IllegalArgumentException, SecurityException, IllegalAccessException, NoSuchFieldException {
            return (SmartphoneType)(class$de$audi$app$terminalmode$SmartphoneManager$SmartphoneType == null ? (class$de$audi$app$terminalmode$SmartphoneManager$SmartphoneType = SmartphoneManager.class$("de.audi.app.terminalmode.SmartphoneManager$SmartphoneType")) : class$de$audi$app$terminalmode$SmartphoneManager$SmartphoneType).getField(string).get(null);
        }
    }
}

