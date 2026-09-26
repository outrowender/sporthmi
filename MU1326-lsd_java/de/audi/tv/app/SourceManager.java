/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app;

import de.audi.atip.log.LogChannel;
import de.audi.atip.util.Util;
import de.audi.atip.utils.generics.Consumer;
import de.audi.tv.app.ISourceChanger;
import de.audi.tv.app.SourceManager$1;
import de.audi.tv.app.SourceManager$2;
import de.audi.tv.app.SourceManager$Properties;
import de.audi.tv.app.SourceManager$SourceChangeRequest;
import de.audi.tv.app.SourceManager$TVListener;
import de.audi.tv.app.TVUtil;
import de.audi.tv.app.base.NotificationHandler;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.dsi.DSIHandler;
import de.audi.tv.app.storage.TVStorage;

public class SourceManager
implements ISourceChanger {
    private final TVEnv env;
    private final DSIHandler dsi;
    private final TVStorage storage;
    private final SourceManager$Properties myProperties;
    private final LogChannel log;
    private final NotificationHandler notificationHandler;
    public SourceManager$TVListener tvListener = new SourceManager$TVListener(this, null);

    public SourceManager(TVEnv tVEnv, DSIHandler dSIHandler, TVStorage tVStorage, NotificationHandler notificationHandler) {
        this.env = tVEnv;
        this.log = tVEnv.lcMain;
        this.dsi = dSIHandler;
        this.storage = tVStorage;
        this.myProperties = this.env.properties.source;
        this.notificationHandler = notificationHandler;
        SourceManager$Properties.access$100(this.myProperties).accept(new Boolean(tVStorage.isAvSourceAvailable()));
        this.myProperties.desiredSource.async(tVEnv.dispatch).subscribe((Consumer)new SourceManager$1(this));
        this.myProperties.currentSource.async(tVEnv.dispatch).subscribe((Consumer)new SourceManager$2(this));
    }

    @Override
    public void switchSource(int n, boolean bl) {
        this.myProperties.desiredSource.accept(new SourceManager$SourceChangeRequest(n, bl));
    }

    private void doSwitchSource(int n, boolean bl) {
        this.log.log(-2137614336, "[SourceManager.doSwitchSource] %2 (from user: %1)", bl, (long)n);
        if (!(((Boolean)this.myProperties.avSourceAvailable.get()).booleanValue() || n != 1 && n != 5)) {
            throw new IllegalArgumentException("AV source was selected but is not available!");
        }
        if (n == 1 && (Integer)this.env.properties.displayContext.currentDisplayContext.get() != 1) {
            this.log.log(-2137614336, "[SourceManager.doSwitchSource] send an extra setTerminalMode (0,0) to clean up the AV screen !!!");
            this.dsi.setTerminalMode(0, 0);
        }
        this.setHmiSource(n);
        this.dsi.switchSource(n, bl);
        if (Util.createInteger(n).equals(this.myProperties.currentSource.get())) {
            this.notificationHandler.setNotification(5);
        }
    }

    private void setHmiSource(int n) {
        int n2 = TVUtil.getInternalSourceRepresentation(n);
        if (n2 != -1) {
            this.env.getChoiceModel(1521231616).setValue(n2);
        }
    }

    static /* synthetic */ LogChannel access$200(SourceManager sourceManager) {
        return sourceManager.log;
    }

    static /* synthetic */ void access$300(SourceManager sourceManager, int n, boolean bl) {
        sourceManager.doSwitchSource(n, bl);
    }

    static /* synthetic */ void access$400(SourceManager sourceManager, int n) {
        sourceManager.setHmiSource(n);
    }

    static /* synthetic */ SourceManager$Properties access$500(SourceManager sourceManager) {
        return sourceManager.myProperties;
    }

    static /* synthetic */ TVStorage access$600(SourceManager sourceManager) {
        return sourceManager.storage;
    }
}

