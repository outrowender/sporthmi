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
    private static final String LOGCLASS = "AbstractContent";
    private final int contentType;
    private final IContentContext contentContext;
    private volatile IActivationContext activationContext;

    public AbstractContent(int n, IContentContext iContentContext, IMediaTerminal iMediaTerminal) {
        super(iMediaTerminal);
        this.contentContext = iContentContext;
        this.contentType = n;
    }

    public void init() {
    }

    public void deinit() {
    }

    public void activate(IActivationContext iActivationContext) {
        this.logger.main().log(1000000, "[%1.activate]", (Object)LOGCLASS);
        this.setActivationContext(iActivationContext);
    }

    public void deactivate() {
        this.logger.main().log(1000000, "[%1.deactivate]", (Object)LOGCLASS);
        this.setActivationContext(null);
    }

    public final void notifyContentActivationFinished() {
        if (!this.isActive()) {
            this.logger.main().log(1000000, "[%1.notifyContentActivationFinished] Not active.", (Object)LOGCLASS);
            return;
        }
        this.logger.main().log(1000000, "[%1.notifyContentActivationFinished]", (Object)LOGCLASS);
        this.contentContext.notifyContentActivationFinished(this);
    }

    private void setActivationContext(IActivationContext iActivationContext) {
        this.activationContext = iActivationContext;
    }

    public IActivationContext getContext() {
        return this.activationContext;
    }

    public final ISourceSlot getActiveSlot() {
        IActivationContext iActivationContext = this.activationContext;
        if (iActivationContext != null) {
            return iActivationContext.getSlot();
        }
        return null;
    }

    public final boolean isActive() {
        return this.getActiveSlot() != null;
    }

    public final int getContentType() {
        return this.contentType;
    }

    public void vehicleMoving(boolean bl) {
    }

    public ButtonListener getHardKeyListener() {
        return null;
    }

    public void resetSettings() {
    }
}

