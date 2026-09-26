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
    private static final String LOGCLASS;
    private volatile TransferLogger logger;
    private volatile TransferController transferController;

    @Override
    public void initExtension(IMediaTerminal iMediaTerminal) {
        this.logger = new TransferLogger(iMediaTerminal.getFramework());
        this.logger.main().log(1078071040, "[%1.initExtension]", (Object)"MediaTransferTerminalExtension");
        IMediaConfiguration iMediaConfiguration = iMediaTerminal.getConfiguration();
        if (iMediaConfiguration.isImportEnabled() || iMediaConfiguration.isRippingEnabled()) {
            this.transferController = new TransferController(iMediaTerminal);
            this.transferController.init();
        } else {
            this.logger.main().log(1078071040, "[%1.initExtension] Import disabled.", (Object)"MediaTransferTerminalExtension");
            this.transferController = null;
        }
    }

    @Override
    public void deinitExtension() {
        this.logger.main().log(1078071040, "[%1.deinitExtension]", (Object)"MediaTransferTerminalExtension");
        if (this.transferController != null) {
            this.transferController.deinit();
        }
    }

    @Override
    public IContentProvider getContentProvider() {
        return null;
    }
}

