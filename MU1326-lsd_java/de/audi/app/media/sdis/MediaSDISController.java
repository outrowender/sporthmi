/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sdis;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.sdis.MediaSDISBrowserASIProvider;
import de.audi.app.media.sdis.MediaSDISContentHandler;
import de.audi.app.media.sdis.MediaSDISNotifier;
import de.audi.app.media.sdis.MediaSDISPlayerASIProvider;
import de.audi.app.media.sdis.MediaSDISSourceHandler;
import de.audi.atip.log.LogChannel;

public class MediaSDISController {
    private static final String LOGCLASS;
    private final LogChannel logger;
    private final MediaSDISNotifier notifier;
    private final MediaSDISSourceHandler sourceHandler;
    private final MediaSDISContentHandler contentHandler;
    private final MediaSDISPlayerASIProvider playerASIProvider;
    private final MediaSDISBrowserASIProvider browserASIProvider;
    private final MediaSDISBrowserASIProvider browserASIProvider2;

    public MediaSDISController(IMediaTerminal iMediaTerminal) {
        this.logger = iMediaTerminal.getFramework().getLogChannel("App.Media.SDIS");
        boolean bl = iMediaTerminal.getConfiguration().isIAP2Supported();
        this.notifier = new MediaSDISNotifier(this.logger, bl);
        this.sourceHandler = new MediaSDISSourceHandler(this.logger, iMediaTerminal);
        this.contentHandler = new MediaSDISContentHandler(this.logger, iMediaTerminal);
        this.playerASIProvider = new MediaSDISPlayerASIProvider(this.logger, iMediaTerminal);
        this.browserASIProvider = new MediaSDISBrowserASIProvider(iMediaTerminal, 4);
        this.browserASIProvider2 = new MediaSDISBrowserASIProvider(iMediaTerminal, 5);
    }

    public void init() {
        this.logger.log(1078071040, "[%1.init]", (Object)"MediaSDISController");
        this.notifier.init(this.playerASIProvider);
        this.sourceHandler.init(this.notifier);
        this.contentHandler.init(this.notifier);
        this.playerASIProvider.init(this.sourceHandler, this.contentHandler);
        this.browserASIProvider.init();
        this.browserASIProvider2.init();
    }

    public void deinit() {
        this.logger.log(1078071040, "[%1.deinit]", (Object)"MediaSDISController");
        this.browserASIProvider.deinit();
        this.browserASIProvider2.deinit();
        this.playerASIProvider.deinit();
        this.sourceHandler.deinit();
        this.contentHandler.deinit();
        this.notifier.deinit();
    }
}

