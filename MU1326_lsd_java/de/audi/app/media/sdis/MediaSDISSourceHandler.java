/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sdis;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.sdis.IMediaSDISNotifier;
import de.audi.app.media.sdis.SelectionData;
import de.audi.app.media.source.ActivationContext;
import de.audi.app.media.source.ActiveSourceState;
import de.audi.app.media.source.IActiveSourceListener;
import de.audi.app.media.source.ISource;
import de.audi.app.media.source.ISourceListListener;
import de.audi.atip.log.LogChannel;
import java.util.Map;

public class MediaSDISSourceHandler
implements ISourceListListener,
IActiveSourceListener {
    private static final String LOGCLASS = "MediaSDISSourceHandler";
    private final LogChannel logger;
    private final IMediaTerminal terminal;
    private volatile IMediaSDISNotifier notifier;

    public MediaSDISSourceHandler(LogChannel logChannel, IMediaTerminal iMediaTerminal) {
        this.logger = logChannel;
        this.terminal = iMediaTerminal;
    }

    public void init(IMediaSDISNotifier iMediaSDISNotifier) {
        this.logger.log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.notifier = iMediaSDISNotifier;
        this.terminal.getSourceController().addSourceListListener(this);
        this.terminal.getSourceController().addActiveSourceListener(this);
    }

    public void deinit() {
        this.logger.log(1000000, "[%1.deinit]", (Object)LOGCLASS);
    }

    public void activate(final int n, final int n2, final SelectionData selectionData) {
        this.logger.log(1000000, "[%1.activate] '%2','%3'", (Object)LOGCLASS, (long)n, (long)n2);
        this.terminal.getDispatcher().execute(new AbstractDispatcherRunnable("SDIS.activateSource"){

            public void run() {
                MediaSDISSourceHandler.this.logger.log(1000000, "[%1.onActivate] '%2','%3'", (Object)MediaSDISSourceHandler.LOGCLASS, (long)n, (long)n2);
                ISource iSource = MediaSDISSourceHandler.this.terminal.getSourceController().getSource(n);
                if (iSource == null) {
                    MediaSDISSourceHandler.this.logger.log(1000000, "[%1.onActivate] Source not available.", (Object)MediaSDISSourceHandler.LOGCLASS);
                    return;
                }
                ActivationContext activationContext = new ActivationContext(iSource.getSlot(n2));
                if (selectionData != null) {
                    activationContext.addParameter("SETPLAYSELECTION_BROWSERID", new Integer(selectionData.getBrowserInstance()));
                    activationContext.addParameter("SETPLAYSELECTION_TRACKID", new Long(selectionData.getTrackID()));
                }
                MediaSDISSourceHandler.this.terminal.getSourceController().activateSource(activationContext);
            }
        });
    }

    public void sourceListChanged(Map map) {
        this.logger.log(1000000, "[%1.sourceListChanged]", (Object)LOGCLASS);
        this.notifier.updateSourceList(map);
    }

    public void activeSourceChanged(boolean bl, ActiveSourceState activeSourceState) {
        this.logger.log(1000000, "[%1.activeSourceChanged] '%2'", (Object)LOGCLASS, (Object)activeSourceState);
        boolean bl2 = activeSourceState.getSlot().getContentType() == 7;
        boolean bl3 = activeSourceState.getState() == 17 || activeSourceState.getState() == 16;
        boolean bl4 = activeSourceState.getSlot().getContentType() == 0 && activeSourceState.getSlot().getFlags().isImportRunning();
        this.notifier.updatePlaybackPossible(!bl2 && !bl3 && !bl4);
        this.notifier.updateActiveSourceState(activeSourceState);
    }

    public void sourceDeactivated() {
    }
}

