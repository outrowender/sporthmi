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
    private static final String LOGCLASS;
    private final CDDAPlayer cddaPlayer;
    private final Timer gracenoteTimer;

    public CDDAContent(IContentContext iContentContext, IMediaTerminal iMediaTerminal, IMediaDSIPlayerController iMediaDSIPlayerController) {
        super(0, iContentContext, iMediaTerminal);
        this.cddaPlayer = new CDDAPlayer(iMediaTerminal, this, iMediaDSIPlayerController);
        this.gracenoteTimer = new Timer("Gracenote", 0, true, this);
    }

    @Override
    public void init() {
        this.logger.main().log(1078071040, "[%1.init]", (Object)"CDDAContent");
        this.cddaPlayer.init();
        this.getChoiceModel(-2062613760).setValue(1);
    }

    @Override
    public void deinit() {
        this.logger.main().log(1078071040, "[%1.deinit]", (Object)"CDDAContent");
        this.cddaPlayer.deinit();
    }

    @Override
    public void activate(IActivationContext iActivationContext) {
        this.logger.main().log(1078071040, "[%1.activate]", (Object)"CDDAContent");
        super.activate(iActivationContext);
        this.getTerminal().addActionProxyListener(36, (IActionProxyListener)this);
        this.cddaPlayer.activate(iActivationContext);
    }

    @Override
    public void deactivate() {
        this.logger.main().log(1078071040, "[%1.deactivate] Deactivate.", (Object)"CDDAContent");
        this.getTerminal().removeActionProxyListener(this);
        this.getChoiceModel(3941).setValue(0);
        super.deactivate();
        this.cddaPlayer.deactivate();
    }

    @Override
    public IPlayer getPlayer() {
        return this.cddaPlayer;
    }

    @Override
    public ButtonListener getHardKeyListener() {
        return this.cddaPlayer.getHardKeyListener();
    }

    @Override
    public void resetSettings() {
        this.cddaPlayer.resetSettings();
    }

    @Override
    public void fireTimer(Timer timer) {
        this.logger.main().log(1078071040, "[%1.fireTimer] Remove gracenote icon.", (Object)"CDDAContent");
        this.getChoiceModel(3941).setValue(0);
    }

    @Override
    public void cancelTimer(Timer timer) {
        this.logger.main().log(1078071040, "[%1.cancelTimer]", (Object)"CDDAContent");
        this.getChoiceModel(3941).setValue(0);
    }

    @Override
    public void actionProxyCallPerformed(int n, Map map) {
        if (36 == n) {
            this.logger.main().log(1078071040, "[%1.actionProxyCallPerformed]", (Object)"CDDAContent");
            if (this.getTerminal().getConfiguration().isGracenoteEnabled()) {
                this.getChoiceModel(3941).setValue(1);
                this.gracenoteTimer.start();
            } else {
                this.logger.main().log(-2137614336, "[%1.actionProxyCallPerformed] Gracenote is not coded", (Object)"CDDAContent");
            }
        }
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append("CDDAContent").append("@").append(this.hashCode());
        return buffer.toString();
    }
}

