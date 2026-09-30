/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app;

import de.audi.atip.log.LogChannel;
import de.audi.atip.util.Util;
import de.audi.atip.utils.generics.Consumer;
import de.audi.atip.utils.reactive.properties.Property;
import de.audi.atip.utils.reactive.properties.PropertyFactory;
import de.audi.atip.utils.reactive.properties.ReadOnlyProperty;
import de.audi.tv.app.ISourceChanger;
import de.audi.tv.app.TVUtil;
import de.audi.tv.app.base.NotificationHandler;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.dsi.DSIHandler;
import de.audi.tv.app.dsi.DefaultTVListener;
import de.audi.tv.app.storage.TVStorage;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.tvtuner.StartUpConfig;

public class SourceManager
implements ISourceChanger {
    private final TVEnv env;
    private final DSIHandler dsi;
    private final TVStorage storage;
    private final Properties myProperties;
    private final LogChannel log;
    private final NotificationHandler notificationHandler;
    public TVListener tvListener = new TVListener();

    public SourceManager(TVEnv tVEnv, DSIHandler dSIHandler, TVStorage tVStorage, NotificationHandler notificationHandler) {
        this.env = tVEnv;
        this.log = tVEnv.lcMain;
        this.dsi = dSIHandler;
        this.storage = tVStorage;
        this.myProperties = this.env.properties.source;
        this.notificationHandler = notificationHandler;
        this.myProperties.writeableAvSourceAvailable().accept(new Boolean(tVStorage.isAvSourceAvailable()));
        this.myProperties.desiredSource.async(tVEnv.dispatch).subscribe(new Consumer<SourceChangeRequest>(){

            @Override
            public void accept(SourceChangeRequest sourceChangeRequest) {
                SourceManager.this.log.log(10000000, "[SourceManager. property desiredSource.accept] %2 (from user: %1)", sourceChangeRequest.isUserCall, (long)sourceChangeRequest.source);
                SourceManager.this.doSwitchSource(sourceChangeRequest.source, sourceChangeRequest.isUserCall);
            }

            @Override
            public /* synthetic */ void accept(Object object) {
                this.accept((SourceChangeRequest)object);
            }
        });
        this.myProperties.currentSource.async(tVEnv.dispatch).subscribe(new Consumer<Integer>(){

            @Override
            public void accept(Integer n) {
                SourceManager.this.log.log(10000000, "[SourceManager. property currentSource.accept] %1 ", (Object)n);
                SourceManager.this.setHmiSource(n);
            }

            @Override
            public /* synthetic */ void accept(Object object) {
                this.accept((Integer)object);
            }
        });
    }

    public void switchSource(int n, boolean bl) {
        this.myProperties.desiredSource.accept(new SourceChangeRequest(n, bl));
    }

    private void doSwitchSource(int n, boolean bl) {
        this.log.log(10000000, "[SourceManager.doSwitchSource] %2 (from user: %1)", bl, (long)n);
        if (!(((Boolean)this.myProperties.avSourceAvailable.get()).booleanValue() || n != 1 && n != 5)) {
            throw new IllegalArgumentException("AV source was selected but is not available!");
        }
        if (n == 1 && (Integer)this.env.properties.displayContext.currentDisplayContext.get() != 1) {
            this.log.log(10000000, "[SourceManager.doSwitchSource] send an extra setTerminalMode (0,0) to clean up the AV screen !!!");
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
            this.env.getChoiceModel(2600026).setValue(n2);
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static class Properties {
        public final Property<SourceChangeRequest> desiredSource;
        public final ReadOnlyProperty<Integer> currentSource;
        public final ReadOnlyProperty<Boolean> avSourceAvailable;

        public Properties(PropertyFactory propertyFactory) {
            this.desiredSource = propertyFactory.createProperty("SourceManager.desiredSource");
            this.currentSource = propertyFactory.createProperty("SourceManager.currentSource");
            this.avSourceAvailable = propertyFactory.createProperty("SourceManager.avSourceAvailable");
        }

        private Property<Integer> writeableCurrentSource() {
            return (Property)this.currentSource;
        }

        private Property<Boolean> writeableAvSourceAvailable() {
            return (Property)this.avSourceAvailable;
        }
    }

    private class TVListener
    extends DefaultTVListener {
        private TVListener() {
        }

        public void updateStartUpMUConfig(StartUpConfig startUpConfig) {
            SourceManager.this.myProperties.writeableAvSourceAvailable().accept(new Boolean(startUpConfig.isAvSrcAvail()));
            SourceManager.this.storage.setAvSourceAvailable(startUpConfig.avSrcAvail);
            SourceManager.this.log.log(1000000, "[SourceManager.updateStartUpMUConfig] AV source available: %1", startUpConfig.isAvSrcAvail());
        }

        public void updateSelectedSource(int n) {
            SourceManager.this.myProperties.writeableCurrentSource().accept(new Integer(n));
            SourceManager.this.log.log(1000000, "[SourceManager.TVListener.updateSelectedSource] Source selected: %1", (long)n);
        }
    }

    public static class SourceChangeRequest {
        public final int source;
        public final boolean isUserCall;

        public SourceChangeRequest(int n, boolean bl) {
            this.source = n;
            this.isUserCall = bl;
        }

        public int hashCode() {
            int n = 31 + (this.isUserCall ? 1231 : 1237);
            n = 31 * n + this.source;
            return n;
        }

        public boolean equals(Object object) {
            if (object instanceof SourceChangeRequest) {
                SourceChangeRequest sourceChangeRequest = (SourceChangeRequest)object;
                return this.source == sourceChangeRequest.source && this.isUserCall == sourceChangeRequest.isUserCall;
            }
            return false;
        }

        public String toString() {
            return new Buffer(50).append("SourceChangeRequest: source ").append(this.source).append(", isUserCall ").append(this.isUserCall).toString();
        }
    }
}

