/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sdis;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.sdis.IMediaSDISNotifier;
import de.audi.app.media.sdis.MediaSDISSourceHandler$1;
import de.audi.app.media.sdis.SelectionData;
import de.audi.app.media.source.ActiveSourceState;
import de.audi.app.media.source.IActiveSourceListener;
import de.audi.app.media.source.ISourceListListener;
import de.audi.atip.log.LogChannel;
import java.util.Map;

public class MediaSDISSourceHandler
implements ISourceListListener,
IActiveSourceListener {
    private static final String LOGCLASS;
    private final LogChannel logger;
    private final IMediaTerminal terminal;
    private volatile IMediaSDISNotifier notifier;

    public MediaSDISSourceHandler(LogChannel logChannel, IMediaTerminal iMediaTerminal) {
        this.logger = logChannel;
        this.terminal = iMediaTerminal;
    }

    public void init(IMediaSDISNotifier iMediaSDISNotifier) {
        this.logger.log(1078071040, "[%1.init]", (Object)"MediaSDISSourceHandler");
        this.notifier = iMediaSDISNotifier;
        this.terminal.getSourceController().addSourceListListener(this);
        this.terminal.getSourceController().addActiveSourceListener(this);
    }

    public void deinit() {
        this.logger.log(1078071040, "[%1.deinit]", (Object)"MediaSDISSourceHandler");
    }

    public void activate(int n, int n2, SelectionData selectionData) {
        this.logger.log(1078071040, "[%1.activate] '%2','%3'", (Object)"MediaSDISSourceHandler", (long)n, (long)n2);
        this.terminal.getDispatcher().execute(new MediaSDISSourceHandler$1(this, "SDIS.activateSource", n, n2, selectionData));
    }

    @Override
    public void sourceListChanged(Map map) {
        this.logger.log(1078071040, "[%1.sourceListChanged]", (Object)"MediaSDISSourceHandler");
        this.notifier.updateSourceList(map);
    }

    @Override
    public void activeSourceChanged(boolean bl, ActiveSourceState activeSourceState) {
        this.logger.log(1078071040, "[%1.activeSourceChanged] '%2'", (Object)"MediaSDISSourceHandler", (Object)activeSourceState);
        boolean bl2 = activeSourceState.getSlot().getContentType() == 7;
        boolean bl3 = activeSourceState.getState() == 17 || activeSourceState.getState() == 16;
        boolean bl4 = activeSourceState.getSlot().getContentType() == 0 && activeSourceState.getSlot().getFlags().isImportRunning();
        this.notifier.updatePlaybackPossible(!bl2 && !bl3 && !bl4);
        this.notifier.updateActiveSourceState(activeSourceState);
    }

    @Override
    public void sourceDeactivated() {
    }

    static /* synthetic */ LogChannel access$000(MediaSDISSourceHandler mediaSDISSourceHandler) {
        return mediaSDISSourceHandler.logger;
    }

    static /* synthetic */ IMediaTerminal access$100(MediaSDISSourceHandler mediaSDISSourceHandler) {
        return mediaSDISSourceHandler.terminal;
    }
}

