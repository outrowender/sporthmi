/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.search;

import de.audi.app.online.evo.search.OnlineSearchDataProvider;
import de.audi.app.online.evo.search.OnlineSearchGUIImpl;
import de.audi.app.online.evo.search.OnlineSearchImpl;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMIComponent;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.audi.tghu.online.app.remotehmi.search.ITruffleSearchHandler;
import java.lang.ref.WeakReference;

public class OnlineSearchComponent
extends AbstractRemoteHMIComponent {
    protected OnlineSearchDataProvider dataProvider;
    protected OnlineSearchImpl onlineSearchImpl;
    private OnlineSearchGUIImpl onlineSearchGUI;
    private static volatile WeakReference staticOnlineSearchImpl;

    public void init(LogChannel logChannel, RemoteHMIService remoteHMIService) {
        super.init(logChannel, remoteHMIService);
        boolean bl = Boolean.getBoolean("RHMI_VE_DISABLE_TRUFFEL_INSTANCE");
        if (!bl) {
            this.dataProvider = new OnlineSearchDataProvider(logChannel);
            this.dataProvider.init(this.getFrameworkAccess());
        }
        this.onlineSearchImpl = new OnlineSearchImpl(this.getFrameworkAccess().getBundleCxt(), this.getFrameworkAccess(), logChannel, 8);
        this.onlineSearchGUI = new OnlineSearchGUIImpl(logChannel, this.onlineSearchImpl, remoteHMIService.getModelBankAccess().getSpellerModel(2300766), bl);
        this.onlineSearchImpl.setActiveGuiSearchHandler(this.onlineSearchGUI);
        this.onlineSearchImpl.init();
        if (bl) {
            staticOnlineSearchImpl = new WeakReference(this.onlineSearchImpl);
        }
    }

    public static final OnlineSearchImpl getSearchImpl() {
        return staticOnlineSearchImpl == null ? null : (OnlineSearchImpl)staticOnlineSearchImpl.get();
    }

    public OnlineSearchDataProvider getDataProvider() {
        return this.dataProvider;
    }

    public ITruffleSearchHandler getOnlineSearchHandler() {
        return this.onlineSearchImpl;
    }
}

