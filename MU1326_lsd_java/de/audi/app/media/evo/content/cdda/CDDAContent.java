/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.cdda;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.actionproxy.IActionProxyListener;
import de.audi.app.media.content.IContentContext;
import de.audi.app.media.content.media.AbstractMediaContent;
import de.audi.app.media.content.media.IPlayer;
import de.audi.app.media.dsi.media.IMediaDSIPlayerController;
import de.audi.app.media.evo.content.cdda.CDDAPlayer;
import de.audi.app.media.source.IActivationContext;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Map;

public class CDDAContent
extends AbstractMediaContent
implements IActionProxyListener,
TimerListener {
    private static final String LOGCLASS = "CDDAContent";
    private final CDDAPlayer cddaPlayer;
    private final Timer gracenoteTimer;

    public CDDAContent(IContentContext iContentContext, IMediaTerminal iMediaTerminal, IMediaDSIPlayerController iMediaDSIPlayerController) {
        super(0, iContentContext, iMediaTerminal);
        this.cddaPlayer = new CDDAPlayer(iMediaTerminal, this, iMediaDSIPlayerController);
        this.gracenoteTimer = new Timer("Gracenote", 3000L, true, this);
    }

    public void init() {
        this.logger.main().log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.cddaPlayer.init();
        this.getChoiceModel(200581).setValue(1);
    }

    public void deinit() {
        this.logger.main().log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.cddaPlayer.deinit();
    }

    public void activate(IActivationContext iActivationContext) {
        this.logger.main().log(1000000, "[%1.activate]", (Object)LOGCLASS);
        super.activate(iActivationContext);
        this.getTerminal().addActionProxyListener(36, (IActionProxyListener)this);
        this.cddaPlayer.activate(iActivationContext);
    }

    public void deactivate() {
        this.logger.main().log(1000000, "[%1.deactivate] Deactivate.", (Object)LOGCLASS);
        this.getTerminal().removeActionProxyListener(this);
        this.getChoiceModel(3941).setValue(0);
        super.deactivate();
        this.cddaPlayer.deactivate();
    }

    public IPlayer getPlayer() {
        return this.cddaPlayer;
    }

    public ButtonListener getHardKeyListener() {
        return this.cddaPlayer.getHardKeyListener();
    }

    public void resetSettings() {
        this.cddaPlayer.resetSettings();
    }

    public void fireTimer(Timer timer) {
        this.logger.main().log(1000000, "[%1.fireTimer] Remove gracenote icon.", (Object)LOGCLASS);
        this.getChoiceModel(3941).setValue(0);
    }

    public void cancelTimer(Timer timer) {
        this.logger.main().log(1000000, "[%1.cancelTimer]", (Object)LOGCLASS);
        this.getChoiceModel(3941).setValue(0);
    }

    public void actionProxyCallPerformed(int n, Map map) {
        if (36 == n) {
            this.logger.main().log(1000000, "[%1.actionProxyCallPerformed]", (Object)LOGCLASS);
            if (this.getTerminal().getConfiguration().isGracenoteEnabled()) {
                this.getChoiceModel(3941).setValue(1);
                this.gracenoteTimer.start();
            } else {
                this.logger.main().log(10000000, "[%1.actionProxyCallPerformed] Gracenote is not coded", (Object)LOGCLASS);
            }
        }
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append(LOGCLASS).append("@").append(this.hashCode());
        return buffer.toString();
    }
}

