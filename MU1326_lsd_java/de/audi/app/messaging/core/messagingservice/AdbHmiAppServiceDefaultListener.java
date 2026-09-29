/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.messagingservice;

import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.atip.interapp.ADBHMIAppServiceListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.AdbEntry;

public final class AdbHmiAppServiceDefaultListener
extends AbstractMessagingComponent
implements ADBHMIAppServiceListener,
DSIListener {
    public AdbHmiAppServiceDefaultListener(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    @Override
    public void responseParseVCards(int n, AdbEntry[] adbEntryArray) {
        this.log.log(-1601830656, "[AdbHmiAppServiceDefaultListener#responseParseVCards] Not implemented.");
    }

    @Override
    public void responseInsertEntry(int n) {
        this.log.log(-1601830656, "[AdbHmiAppServiceDefaultListener#responseInsertEntry] Not implemented.");
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.log.log(-1601830656, "[AdbHmiAppServiceDefaultListener#asyncException] Not implemented.");
    }
}

