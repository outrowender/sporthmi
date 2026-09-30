/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media;

import de.audi.app.media.evo.transfer.MediaEvoTransferTerminalExtension;
import de.audi.atip.activator.AbstractActivator;
import java.util.Dictionary;
import java.util.Hashtable;
import org.osgi.framework.BundleContext;

public class MediaTransferActivator
extends AbstractActivator {
    static /* synthetic */ Class class$de$audi$app$media$extension$IMediaTerminalExtension;

    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        if (!this.getFramework().isFrontMU()) {
            return;
        }
        Hashtable hashtable = new Hashtable(1);
        hashtable.put("TERMINALID", new Integer(0));
        this.registerService((class$de$audi$app$media$extension$IMediaTerminalExtension == null ? (class$de$audi$app$media$extension$IMediaTerminalExtension = MediaTransferActivator.class$("de.audi.app.media.extension.IMediaTerminalExtension")) : class$de$audi$app$media$extension$IMediaTerminalExtension).getName(), (Object)new MediaEvoTransferTerminalExtension(), (Dictionary)hashtable);
    }

    public void stop(BundleContext bundleContext) {
        super.stop(bundleContext);
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

