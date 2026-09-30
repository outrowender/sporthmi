/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.content.media.AbstractMediaPlayer;
import de.audi.app.media.content.media.AbstractPlaybackModeHandler;
import de.audi.app.media.sds.ISDSCommandListener;
import de.audi.app.media.source.IActivationContext;
import de.audi.app.media.source.ISourceSlot;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.ListListener;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.util.Util;
import java.util.Map;

public class PlaybackModeHandler
extends AbstractPlaybackModeHandler
implements ListListener,
ChoiceListener,
ISDSCommandListener {
    private static final String LOGCLASS = "PlaybackModeHandler";
    protected static final int DEFAULT_REPEAT_SCOPE_SETTING = 4;
    private static final int REPEAT_TOGGLE_OFF = 0;
    private static final int REPEAT_TOGGLE_TITLE = 2;
    private static final int REPEAT_TOGGLE_FOLDER_ALL = 3;
    private volatile IActivationContext activationContext;
    private volatile int hmiRepeatScope;
    private final ModelGroup playModeModelGroup = new ModelGroup();
    private volatile boolean resetRepeatTitleOnTrackChange;
    protected volatile boolean restorePlaybackMode = false;

    public PlaybackModeHandler(IMediaTerminal iMediaTerminal, AbstractMediaPlayer abstractMediaPlayer, boolean bl) {
        super(iMediaTerminal, abstractMediaPlayer);
        this.resetRepeatTitleOnTrackChange = bl;
    }

    public void activate(IActivationContext iActivationContext) {
        super.activate(iActivationContext);
        this.logger.main().log(1000000, "[%1.activate]", (Object)LOGCLASS);
        this.activationContext = iActivationContext;
        this.restorePlaybackMode = (Boolean)iActivationContext.getParameter("RESTORE_STATE");
        ChoiceModelApp choiceModelApp = this.getChoiceModel(200957);
        ChoiceModelApp choiceModelApp2 = this.getTerminal().getFramework().getHmiServiceApp().getChoiceModel(4437);
        ChoiceModelApp choiceModelApp3 = this.getTerminal().getFramework().getHmiServiceApp().getChoiceModel(5549);
        this.playModeModelGroup.add(choiceModelApp);
        this.playModeModelGroup.add(choiceModelApp2);
        this.playModeModelGroup.add(choiceModelApp3);
        choiceModelApp.setValue(0);
        choiceModelApp.setStatus(3);
        choiceModelApp.setButtonListener(this);
        choiceModelApp2.setValue(0);
        choiceModelApp2.setStatus(3);
        choiceModelApp2.setButtonListener(this);
        choiceModelApp3.setValue(0);
        choiceModelApp3.setStatus(3);
        choiceModelApp3.setButtonListener(this);
        this.playModeModelGroup.flush();
        this.getTerminal().getSDSDispatcher().addCommandListener(this.getTerminal().getTerminalID(), this);
    }

    public void deactivate() {
        this.logger.main().log(1000000, "[%1.deactivate]", (Object)LOGCLASS);
        this.getTerminal().getSDSDispatcher().removeCommandListener(this.getTerminal().getTerminalID(), this);
        ChoiceModelApp choiceModelApp = this.getTerminal().getFramework().getHmiServiceApp().getChoiceModel(4437);
        choiceModelApp.setValue(0);
        choiceModelApp.setStatus(3);
        choiceModelApp.setButtonListener(null);
        ChoiceModelApp choiceModelApp2 = this.getTerminal().getFramework().getHmiServiceApp().getChoiceModel(5549);
        choiceModelApp2.setValue(0);
        choiceModelApp2.setStatus(3);
        choiceModelApp2.setButtonListener(null);
        ChoiceModelApp choiceModelApp3 = this.getChoiceModel(200957);
        choiceModelApp3.setValue(0);
        choiceModelApp3.setStatus(3);
        choiceModelApp3.setButtonListener(null);
        this.playModeModelGroup.flush();
        this.playModeModelGroup.removeAll();
        this.activationContext = null;
    }

    public void updatePlaymodesAvailable(boolean bl) {
        super.updatePlaymodesAvailable(bl);
        if (!bl) {
            this.logger.main().log(1000000, "[%1.disable]", (Object)LOGCLASS);
            ChoiceModelApp choiceModelApp = this.getTerminal().getFramework().getHmiServiceApp().getChoiceModel(4437);
            ChoiceModelApp choiceModelApp2 = this.getTerminal().getFramework().getHmiServiceApp().getChoiceModel(5549);
            choiceModelApp.setStatus(3);
            choiceModelApp2.setStatus(3);
            this.getChoiceModel(200957).setStatus(3);
            this.playModeModelGroup.flush();
            this.getTerminal().getTitlelineHMIHandler().resetIcons();
            this.getTerminal().getTitlelineHMIHandler().flush();
        }
    }

    public boolean sendCurrentPlaybackMode() {
        return this.restoreLastPlaymode();
    }

    protected void playbackModeChanged() {
        this.logger.main().log(1000000, "[%1.playbackModeChanged] ", (Object)LOGCLASS);
        int n = this.getActiveRepeatScope();
        boolean bl = this.isMix();
        this.updateActiveRepeatScope(n);
        this.storeRepeatScope(n, bl);
        this.logger.main().log(1000000, "[%1.playbackModeChanged] scope='%2',mix='%3'.", (Object)LOGCLASS, (Object)PlaybackModeHandler.getRepeatScopeStr(n), (Object)String.valueOf(bl));
        this.getChoiceModel(200957).setStatus(this.isMixAvailable(n) ? 1 : 3);
        this.getChoiceModel(200957).setValue(bl ? 1 : 0);
        int n2 = this.isRepeatTrack() ? 1 : 0;
        ChoiceModelApp choiceModelApp = this.getTerminal().getFramework().getHmiServiceApp().getChoiceModel(4437);
        choiceModelApp.setStatus(this.isRepeatScopeAvailable(3) ? 1 : 3);
        choiceModelApp.setValue(n2);
        this.updateRepeatToggleModel();
        this.playModeModelGroup.flush();
        int n3 = this.supportsPlaybackModeToggle() ? this.getRepeatToggleMode() : n2;
        this.getTerminal().getTitlelineHMIHandler().setRepeatScopeIcon(n3);
        this.getTerminal().getTitlelineHMIHandler().setMixIcon(bl);
        this.getTerminal().getTitlelineHMIHandler().flush();
    }

    private void updateRepeatToggleModel() {
        ChoiceModelApp choiceModelApp = this.getTerminal().getFramework().getHmiServiceApp().getChoiceModel(5549);
        choiceModelApp.setStatus(this.supportsPlaybackModeToggle() ? 1 : 3);
        choiceModelApp.setValue(this.getRepeatToggleMode());
    }

    private int getRepeatToggleMode() {
        int n;
        if (this.isRepeatOff()) {
            this.logger.main().log(1000000, "[%1.getRepeatToggleMode] Repeat OFF.", (Object)LOGCLASS);
            n = 0;
        } else if (this.isRepeatTrack()) {
            this.logger.main().log(1000000, "[%1.getRepeatToggleMode] Repeat TITLE.", (Object)LOGCLASS);
            n = 2;
        } else if (this.isRepeatSelection()) {
            this.logger.main().log(1000000, "[%1.getRepeatToggleMode] Repeat FOLDER_ALL.", (Object)LOGCLASS);
            n = 3;
        } else {
            this.logger.main().log(100000, "[%1.getRepeatToggleMode] Repeat UNKNOWN", (Object)LOGCLASS);
            n = 0;
        }
        return n;
    }

    public void trackChanged() {
        if (this.isRepeatTrack() && this.resetRepeatTitleOnTrackChange) {
            this.logger.main().log(10000000, "[%1.trackChanged]repeat title disabled", (Object)LOGCLASS);
            this.setRepeatTitle(false);
        }
    }

    public void setResetRepeatTitleOnTrackChange(boolean bl) {
        this.logger.main().log(10000000, "[%1.setResetRepeatTitleOnTrackChange] %2", (Object)LOGCLASS, (Object)(bl ? "ENABLE" : "DISABLE"));
        this.resetRepeatTitleOnTrackChange = bl;
    }

    protected boolean restoreLastPlaymode() {
        ISourceSlot iSourceSlot = this.activationContext.getSlot();
        if (11 == iSourceSlot.getSource().getType() || iSourceSlot.getMediaType() == 24) {
            this.usePlaybackModeOfPlayer();
            return true;
        }
        if (this.restorePlaybackMode) {
            this.logger.main().log(1000000, "[%1.restoreLastPlaymode] Persistence mode.", (Object)LOGCLASS);
            int n = this.getTerminal().getMediaPersistence().getStorage().load(this.getTerminal(), 110, 4, 0, 4);
            boolean bl = this.getTerminal().getMediaPersistence().getStorage().load(this.getTerminal(), 120, 0, 0, 1) == 1;
            this.logger.main().log(1000000, "[%2.restoreLastPlaymode] lastScope='%3',lastMix='%1'.", bl, (Object)LOGCLASS, (Object)PlaybackModeHandler.getRepeatScopeStr(n));
            return this.setRepeatScope(n, bl) != 2;
        }
        return this.setRepeatScope(4, false) != 2;
    }

    protected void storeRepeatScope(int n, boolean bl) {
        this.logger.main().log(1000000, "[%1.storeRepeatScope] '%2',mix='%3'.", (Object)LOGCLASS, (Object)String.valueOf(n), (Object)String.valueOf(bl));
        this.getTerminal().getMediaPersistence().getStorage().persist(this.getTerminal(), 110, n);
        this.getTerminal().getMediaPersistence().getStorage().persist(this.getTerminal(), 120, bl ? 1 : 0);
    }

    public void resetPlaybackMode() {
        this.logger.main().log(1000000, "[%1.clearLastPlaymode]", (Object)LOGCLASS);
        this.storeRepeatScope(4, false);
        this.setRepeatScope(4, false);
    }

    protected final ModelGroup getPlayModeModelGroup() {
        return this.playModeModelGroup;
    }

    public int setRepeatTitle(boolean bl) {
        this.logger.hmi().log(1000000, "[%1.setRepeatTitle] '%2'", (Object)LOGCLASS, (Object)bl);
        this.hmiRepeatScope = bl ? 3 : 4;
        return this.setRepeatScope(this.hmiRepeatScope, this.isMix());
    }

    protected void updateActiveRepeatScope(int n) {
        switch (n) {
            case 3: 
            case 4: {
                this.hmiRepeatScope = n;
                break;
            }
        }
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    public void itemReleased(int n, int n2, int n3, int n4) {
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        switch (n) {
            case 200957: {
                this.logger.hmi().log(1000000, "[%1.itemSelected] PLAYMODE_MIX_CHOICE", (Object)LOGCLASS);
                if (this.mediaPlayer.supportsPlaybackModeToggle()) {
                    this.logger.hmi().log(1000000, "[%1.itemSelected] PLAYMODE_MIX_CHOICE -> Toggle", (Object)LOGCLASS);
                    this.toggleMixMode();
                    break;
                }
                this.logger.hmi().log(1000000, "[%1.itemSelected] PLAYMODE_MIX_CHOICE -> Select");
                boolean bl = this.getChoiceModel(200957).getValue() != 1;
                this.setRepeatScope(this.getActiveRepeatScope(), bl);
                break;
            }
            case 4437: {
                this.logger.hmi().log(1000000, "[%1.itemSelected] PLAYMODE_REPEAT_TITLE_CHOICE", (Object)LOGCLASS);
                boolean bl = this.getChoiceModel(4437).getValue() != 1;
                this.setRepeatTitle(bl);
                break;
            }
            case 5549: {
                this.logger.hmi().log(1000000, "[%1.itemSelected] PLAYMODE_TOGGLE_REPEAT_CHOICE", (Object)LOGCLASS);
                this.toggleRepeatMode();
                break;
            }
            default: {
                this.logger.main().log(100000, "[%1.itemSelected] unknown model id: '%2'", (Object)LOGCLASS, (long)n);
            }
        }
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public int[] getCommandIDs() {
        return new int[]{20008, 20006};
    }

    public Object performCommand(int n, Map map) {
        switch (n) {
            case 20008: {
                boolean bl = (Boolean)map.get("MIX");
                switch (this.setRepeatScope(this.getActiveRepeatScope(), bl)) {
                    case 1: {
                        return new Integer(11002);
                    }
                    case 3: {
                        return new Integer(11001);
                    }
                }
                return new Integer(11004);
            }
            case 20006: {
                int n2;
                Boolean bl = (Boolean)map.get("REPEAT_TRACK");
                if (null == bl) {
                    n2 = 11004;
                } else {
                    int n3 = this.setRepeatTitle(bl);
                    switch (n3) {
                        case 1: {
                            n2 = 11002;
                            break;
                        }
                        case 3: {
                            n2 = 11001;
                            break;
                        }
                        default: {
                            n2 = 11004;
                        }
                    }
                }
                return Util.createInteger(n2);
            }
        }
        return null;
    }
}

