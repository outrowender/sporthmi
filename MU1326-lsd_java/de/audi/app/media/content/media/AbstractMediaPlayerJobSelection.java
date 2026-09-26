/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.content.media.AbstractMediaPlayer;
import de.audi.app.media.content.media.AbstractMediaPlayerJob;
import de.audi.app.media.content.media.IPlayerSelectionRequest;
import de.audi.app.media.content.media.IPlayerViewListener;
import de.audi.atip.log.LogChannel;
import java.util.Iterator;
import java.util.Map;

public class AbstractMediaPlayerJobSelection
extends AbstractMediaPlayerJob {
    private final String LOGCLASS;
    private final IPlayerSelectionRequest request;
    private final Map playViewListener;

    public AbstractMediaPlayerJobSelection(LogChannel logChannel, AbstractMediaPlayer abstractMediaPlayer, IPlayerSelectionRequest iPlayerSelectionRequest, Map map) {
        super(logChannel, abstractMediaPlayer);
        this.LOGCLASS = "AbstractMediaPlayerJobSelection";
        this.request = iPlayerSelectionRequest;
        this.playViewListener = map;
    }

    @Override
    public int getType() {
        return 0;
    }

    @Override
    public String getName() {
        return "PLAYSELECTION";
    }

    @Override
    public void abort(boolean bl) {
        this.logger.log(1078071040, "[%2.abort]", (Object)"AbstractMediaPlayerJobSelection");
        this.request.responseSetSelection(false);
    }

    @Override
    public void start() {
        this.player.getDSIPlayer().setPlaySelection(this.request.getBrowserID(), this.request.getEntryID(), this.request.isSeamless());
    }

    @Override
    public void responseSetPlaySelection(boolean bl) {
        this.logger.log(1078071040, "[%2.responseSetPlaySelection] '%1'", bl, (Object)"AbstractMediaPlayerJobSelection");
        if (bl) {
            if (this.player.capabilities != null && this.player.capabilities.playView) {
                this.notifyListChanging();
            } else {
                if (this.player.capabilities == null) {
                    this.logger.log(10000, "[%1.responseSetPlaySelection] No capabilities yet. Still waiting for capabilities.", (Object)"AbstractMediaPlayerJobSelection");
                }
                this.player.waitForDetailInfos();
            }
        }
        if (bl && this.request.waitForPlayposition()) {
            return;
        }
        if (!bl && !this.player.capabilities.playView) {
            this.logger.log(1078071040, "[%2.responseSetPlaySelection] no playview available '%1'", bl, (Object)"AbstractMediaPlayerJobSelection");
            this.player.waitForDetailInfos();
        }
        if (!this.request.isSeamless()) {
            this.player.notifySelectionFinished();
        }
        this.request.responseSetSelection(bl);
        this.getExecutionContext().jobFinished();
    }

    @Override
    public void notifyPlayPosition() {
        this.logger.log(1078071040, "[%1.notifyPlayPosition]", (Object)"AbstractMediaPlayerJobSelection");
        this.request.responseSetSelection(true);
        this.getExecutionContext().jobFinished();
    }

    protected void notifyListChanging() {
        this.logger.log(1078071040, "[%1.notifyListChanging]", (Object)"AbstractMediaPlayerJobSelection");
        Iterator iterator = this.playViewListener.values().iterator();
        while (iterator.hasNext()) {
            try {
                ((IPlayerViewListener)iterator.next()).listChangeOnSelection(this.request.isSeamless());
            }
            catch (Exception exception) {
                this.logger.log(-1601830656, "[%1.notifyListChanging]", (Object)"AbstractMediaPlayerJobSelection", (Throwable)exception);
            }
        }
    }

    public String toString() {
        return "";
    }
}

