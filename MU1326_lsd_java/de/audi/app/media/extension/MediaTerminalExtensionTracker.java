/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.extension;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.extension.IMediaTerminalExtension;
import de.audi.app.media.osgi.AbstractServiceListTracker;
import de.audi.app.media.osgi.IServiceManager;
import java.util.Dictionary;

public class MediaTerminalExtensionTracker
extends AbstractServiceListTracker {
    private static final String LOGCLASS;
    private final IMediaTerminal terminal;
    static /* synthetic */ Class class$de$audi$app$media$extension$IMediaTerminalExtension;

    public MediaTerminalExtensionTracker(IMediaTerminal iMediaTerminal, IServiceManager iServiceManager) {
        super(iMediaTerminal.getLogger().main(), iServiceManager);
        this.terminal = iMediaTerminal;
    }

    @Override
    public void init() {
        this.logger.log(1078071040, "[%1.init]", (Object)"MediaTerminalExtensionTracker");
        super.init();
    }

    @Override
    public void deinit() {
        this.logger.log(1078071040, "[%1.deinit]", (Object)"MediaTerminalExtensionTracker");
        super.deinit();
    }

    @Override
    protected Class getTrackedServiceClass() {
        return class$de$audi$app$media$extension$IMediaTerminalExtension == null ? (class$de$audi$app$media$extension$IMediaTerminalExtension = MediaTerminalExtensionTracker.class$("de.audi.app.media.extension.IMediaTerminalExtension")) : class$de$audi$app$media$extension$IMediaTerminalExtension;
    }

    @Override
    protected void serviceRemoved(Object object) {
        this.logger.log(1078071040, "[%1.serviceRemoved] Extension removed '%2'.", (Object)"MediaTerminalExtensionTracker", object);
        ((IMediaTerminalExtension)object).deinitExtension();
    }

    @Override
    protected void serviceAdded(Object object) {
        this.logger.log(1078071040, "[%1.serviceAdded] Extension added '%2'.", (Object)"MediaTerminalExtensionTracker", object);
        ((IMediaTerminalExtension)object).initExtension(this.terminal);
    }

    @Override
    protected boolean checkServiceProperties(Dictionary dictionary) {
        try {
            return ((Integer)dictionary.get("TERMINALID")).intValue() == this.terminal.getTerminalID();
        }
        catch (Exception exception) {
            return false;
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

