/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.transfer;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.configuration.IMediaConfiguration;
import de.audi.app.media.extension.IContentProvider;
import de.audi.app.media.extension.IMediaTerminalExtension;
import de.audi.app.media.transfer.TransferController;
import de.audi.app.media.transfer.TransferLogger;

public class MediaTransferTerminalExtension
implements IMediaTerminalExtension {
    private static final String LOGCLASS = "MediaTransferTerminalExtension";
    private volatile TransferLogger logger;
    private volatile TransferController transferController;

    public void initExtension(IMediaTerminal iMediaTerminal) {
        this.logger = new TransferLogger(iMediaTerminal.getFramework());
        this.logger.main().log(1000000, "[%1.initExtension]", (Object)LOGCLASS);
        IMediaConfiguration iMediaConfiguration = iMediaTerminal.getConfiguration();
        if (iMediaConfiguration.isImportEnabled() || iMediaConfiguration.isRippingEnabled()) {
            this.transferController = new TransferController(iMediaTerminal);
            this.transferController.init();
        } else {
            this.logger.main().log(1000000, "[%1.initExtension] Import disabled.", (Object)LOGCLASS);
            this.transferController = null;
        }
    }

    public void deinitExtension() {
        this.logger.main().log(1000000, "[%1.deinitExtension]", (Object)LOGCLASS);
        if (this.transferController != null) {
            this.transferController.deinit();
        }
    }

    public IContentProvider getContentProvider() {
        return null;
    }
}

