/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.cdda;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.content.media.AbstractMediaPlayer;
import de.audi.app.media.content.media.AbstractPlaybackModeHandler;
import de.audi.app.media.evo.content.PlaybackModeHandler;
import de.audi.app.media.source.IActivationContext;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;

public class CDDAPlaybackModeHandler
extends PlaybackModeHandler {
    private static final String LOGCLASS;
    private static final int DEFAULT_REPEAT_DEVICE_SETTING;
    private static final int DVDC_REPEAT_SCOPE_OFF;
    private static final int DVDC_REPEAT_SCOPE_MEDIUM;
    private volatile int repeatMedium;

    public CDDAPlaybackModeHandler(IMediaTerminal iMediaTerminal, AbstractMediaPlayer abstractMediaPlayer, boolean bl) {
        super(iMediaTerminal, abstractMediaPlayer, bl);
    }

    @Override
    public void activate(IActivationContext iActivationContext) {
        super.activate(iActivationContext);
        this.logger.main().log(1078071040, "[%1.activate].", (Object)"CDDAPlaybackModeHandler");
        ChoiceModelApp choiceModelApp = this.getChoiceModel(-32505088);
        choiceModelApp.setValue(0);
        choiceModelApp.setStatus(3);
        choiceModelApp.setButtonListener(this);
        this.getPlayModeModelGroup().add(choiceModelApp);
        this.getPlayModeModelGroup().flush();
    }

    @Override
    public void deactivate() {
        super.deactivate();
        this.logger.main().log(1078071040, "[%1.deactivate].", (Object)"CDDAPlaybackModeHandler");
        ChoiceModelApp choiceModelApp = this.getChoiceModel(-32505088);
        choiceModelApp.setValue(0);
        choiceModelApp.setStatus(3);
        choiceModelApp.setButtonListener(null);
    }

    @Override
    protected boolean restoreLastPlaymode() {
        int n;
        if (this.restorePlaybackMode) {
            this.logger.main().log(1078071040, "[%1.restoreLastPlaymode] Persistence mode.", (Object)"CDDAPlaybackModeHandler");
            int n2 = this.getTerminal().getMediaPersistence().getStorage().load(this.getTerminal(), 110, 4, 0, 4);
            boolean bl = this.getTerminal().getMediaPersistence().getStorage().load(this.getTerminal(), 120, 0, 0, 1) == 1;
            this.repeatMedium = this.getTerminal().getMediaPersistence().getGlobalIntProperty("GLOBAL_KEY_DVDC_REPEAT_SCOPE");
            this.logger.main().log(1078071040, "[%1.restoreLastPlaymode] repeatTrack='%3', repeatScope=%4,lastMix='%2'.", (Object)"CDDAPlaybackModeHandler", (Object)bl, (Object)(n2 == 3 ? 1 : 0), (Object)AbstractPlaybackModeHandler.getRepeatScopeStr(this.repeatMedium));
            n = this.setRepeatScope(n2 == 3 ? 3 : this.repeatMedium, bl);
        } else {
            n = this.setRepeatScope(0, false);
        }
        return n == 3;
    }

    @Override
    public void resetPlaybackMode() {
        this.logger.main().log(1078071040, "[%1.resetPlaybackMode]", (Object)"CDDAPlaybackModeHandler");
        this.repeatMedium = 0;
        this.storeRepeatScope(this.repeatMedium, false);
        this.setRepeatScope(this.repeatMedium, false);
    }

    @Override
    protected void storeRepeatScope(int n, boolean bl) {
        this.logger.main().log(1078071040, "[%1.storeRepeatScope] '%2',mix='%3'.", (Object)"CDDAPlaybackModeHandler", (Object)String.valueOf(n), (Object)String.valueOf(bl));
        switch (n) {
            case 0: 
            case 1: {
                this.getTerminal().getMediaPersistence().setGlobalIntProperty("GLOBAL_KEY_DVDC_REPEAT_SCOPE", n);
                super.storeRepeatScope(4, bl);
                break;
            }
            case 3: {
                super.storeRepeatScope(n, bl);
                break;
            }
        }
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        switch (n) {
            case 200958: {
                this.logger.hmi().log(1078071040, "[%1.itemSelected] DVDC_REPEAT_SCOPE_CHOICE", (Object)"CDDAPlaybackModeHandler");
                this.repeatMedium = n2 == 1 ? 1 : 0;
                this.getTerminal().getMediaPersistence().setGlobalIntProperty("GLOBAL_KEY_DVDC_REPEAT_SCOPE", this.repeatMedium);
                this.getChoiceModel(-32505088).setValue(this.repeatMedium == 1 ? 1 : 0);
                this.getChoiceModel(-32505088).setStatus(1);
                if (!this.isRepeatTrack()) {
                    this.setRepeatScope(this.repeatMedium, this.isMix());
                }
                this.getPlayModeModelGroup().flush();
                break;
            }
            default: {
                super.itemSelected(n, n2, n3, n4);
            }
        }
    }

    @Override
    public int setRepeatTitle(boolean bl) {
        this.logger.main().log(1078071040, "[%1.setRepeatTitle] '%2' '%3'", (Object)"CDDAPlaybackModeHandler", (Object)bl, (Object)CDDAPlaybackModeHandler.getRepeatScopeStr(this.repeatMedium));
        return this.setRepeatScope(bl ? 3 : this.repeatMedium, this.isMix());
    }

    @Override
    protected void updateActiveRepeatScope(int n) {
        this.logger.main().log(1078071040, "[%1.setRepeatTitle] '%2' ", (Object)"CDDAPlaybackModeHandler", (Object)CDDAPlaybackModeHandler.getRepeatScopeStr(n));
        switch (n) {
            case 0: 
            case 1: {
                this.repeatMedium = n;
                super.updateActiveRepeatScope(4);
                break;
            }
            default: {
                super.updateActiveRepeatScope(n);
            }
        }
    }

    @Override
    public void playbackModeChanged() {
        this.logger.main().log(1078071040, "[%1.updateActivePlaybackMode] '%2'.", (Object)"CDDAPlaybackModeHandler", (Object)CDDAPlaybackModeHandler.getRepeatScopeStr(this.getActiveRepeatScope()));
        if (this.getActiveRepeatScope() != 3) {
            this.repeatMedium = this.getActiveRepeatScope();
        }
        super.playbackModeChanged();
        this.getChoiceModel(-32505088).setValue(this.repeatMedium == 1 ? 1 : 0);
        this.getChoiceModel(-32505088).setStatus(1);
        this.getPlayModeModelGroup().flush();
    }

    @Override
    public boolean isRepeatOff() {
        return false;
    }
}

