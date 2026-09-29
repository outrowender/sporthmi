/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content;

import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.content.IContent;
import de.audi.app.media.content.IContentContext;
import de.audi.app.media.source.IActivationContext;
import de.audi.app.media.source.ISourceSlot;
import de.audi.atip.hmi.model.ButtonListener;

public abstract class AbstractContent
extends AbstractMediaTerminalComponent
implements IContent {
    private static final String LOGCLASS;
    private final int contentType;
    private final IContentContext contentContext;
    private volatile IActivationContext activationContext;

    public AbstractContent(int n, IContentContext iContentContext, IMediaTerminal iMediaTerminal) {
        super(iMediaTerminal);
        this.contentContext = iContentContext;
        this.contentType = n;
    }

    @Override
    public void init() {
    }

    @Override
    public void deinit() {
    }

    @Override
    public void activate(IActivationContext iActivationContext) {
        this.logger.main().log(1078071040, "[%1.activate]", (Object)"AbstractContent");
        this.setActivationContext(iActivationContext);
    }

    @Override
    public void deactivate() {
        this.logger.main().log(1078071040, "[%1.deactivate]", (Object)"AbstractContent");
        this.setActivationContext(null);
    }

    @Override
    public final void notifyContentActivationFinished() {
        if (!this.isActive()) {
            this.logger.main().log(1078071040, "[%1.notifyContentActivationFinished] Not active.", (Object)"AbstractContent");
            return;
        }
        this.logger.main().log(1078071040, "[%1.notifyContentActivationFinished]", (Object)"AbstractContent");
        this.contentContext.notifyContentActivationFinished(this);
    }

    private void setActivationContext(IActivationContext iActivationContext) {
        this.activationContext = iActivationContext;
    }

    @Override
    public IActivationContext getContext() {
        return this.activationContext;
    }

    @Override
    public final ISourceSlot getActiveSlot() {
        IActivationContext iActivationContext = this.activationContext;
        if (iActivationContext != null) {
            return iActivationContext.getSlot();
        }
        return null;
    }

    @Override
    public final boolean isActive() {
        return this.getActiveSlot() != null;
    }

    @Override
    public final int getContentType() {
        return this.contentType;
    }

    @Override
    public void vehicleMoving(boolean bl) {
    }

    @Override
    public ButtonListener getHardKeyListener() {
        return null;
    }

    @Override
    public void resetSettings() {
    }
}

