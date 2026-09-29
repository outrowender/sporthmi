/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.search;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.IMessagingComponent;
import de.audi.app.messaging.core.component.MessagingComponentCollection;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.atip.log.LogChannel;
import de.audi.atip.search.AbstractGuiSearchHandler;
import de.audi.atip.search.AbstractSearch;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map$Entry;
import org.dsi.ifc.search.SearchFilter;

public final class MessagingSearch
extends AbstractSearch
implements IMessagingComponent {
    private final LogChannel log;
    private final MessagingComponentCollection subcomponents = new MessagingComponentCollection();
    private volatile Map searchFilters = Collections.EMPTY_MAP;

    public MessagingSearch(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext.getBundleContext(), messagingBundleContext.getFramework(), messagingBundleContext.getFramework().getLogChannel("App.Messaging.Search"), 6);
        this.log = this.framework.getLogChannel("App.Messaging.Main");
    }

    @Override
    public void addComponent(IMessagingComponent iMessagingComponent) {
        this.subcomponents.add(iMessagingComponent);
    }

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
    }

    @Override
    public void dispose() {
    }

    @Override
    public void connect(IServiceRegistry iServiceRegistry) {
        try {
            this.subcomponents.connectAll(iServiceRegistry);
            this.startDSI();
        }
        catch (Exception exception) {
            this.log.log(10000, "[MessagingSearch#connect] An error occurred: ", (Throwable)exception);
        }
    }

    @Override
    public void disconnect() {
        try {
            this.subcomponents.disconnectAll();
            this.stopDSI();
        }
        catch (Exception exception) {
            this.log.log(10000, "[MessagingSearch#disconnect] An error occurred: ", (Throwable)exception);
        }
    }

    public void switchConfiguration(AbstractGuiSearchHandler abstractGuiSearchHandler, Map map) {
        boolean bl;
        Map map2 = map != null ? map : Collections.EMPTY_MAP;
        boolean bl2 = abstractGuiSearchHandler != this.getActiveGuiSearchHandler();
        boolean bl3 = bl = this.searchFilters != map2;
        if (this.log.isDebug()) {
            this.log.log(-2137614336, "[MessagingSearch#switchConfiguration] guiSearchHandler = %1, hasHandlerChanged = %2, haveSearchFiltersChanged = %3", (Object)String.valueOf(abstractGuiSearchHandler), (Object)String.valueOf(bl2), (Object)String.valueOf(bl));
        }
        if (bl2 || bl) {
            this.cancelQuery();
        }
        if (bl) {
            this.searchFilters = map2;
            Iterator iterator = map2.entrySet().iterator();
            while (iterator.hasNext()) {
                Map$Entry map$Entry = (Map$Entry)iterator.next();
                int n = (Integer)map$Entry.getKey();
                SearchFilter searchFilter = (SearchFilter)map$Entry.getValue();
                this.setSearchFilter(n, searchFilter);
            }
        }
        if (bl2) {
            this.setActiveGuiSearchHandler(abstractGuiSearchHandler);
        }
        if (bl2 || bl) {
            abstractGuiSearchHandler.refreshQuery();
        }
    }
}

