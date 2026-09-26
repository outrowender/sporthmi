/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.tv;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.content.IContentContext;
import de.audi.app.media.content.media.AbstractMediaContent;
import de.audi.app.media.evo.content.tv.DrawerContextHandler;
import de.audi.app.media.evo.content.tv.TVContent$1;
import de.audi.app.media.evo.utils.MediaEvoUtils;
import de.audi.app.media.source.IActivationContext;
import de.audi.app.media.source.media.AbstractTVSource;
import de.audi.atip.interapp.tv.ITVComponentListener;
import de.audi.atip.interapp.tv.ITVService;
import java.util.Hashtable;
import org.osgi.framework.ServiceRegistration;

public class TVContent
extends AbstractMediaContent {
    private static final String LOGCLASS;
    private final DrawerContextHandler drawerContextHandler;
    private ITVComponentListener componentListener = new TVContent$1(this);
    private ServiceRegistration componentServiceRegistration;
    private boolean componentStarted = false;
    static /* synthetic */ Class class$de$audi$atip$interapp$tv$ITVComponentListener;

    public TVContent(IContentContext iContentContext, IMediaTerminal iMediaTerminal) {
        super(3, iContentContext, iMediaTerminal);
        this.drawerContextHandler = new DrawerContextHandler(iMediaTerminal);
    }

    @Override
    public void init() {
        super.init();
        this.componentServiceRegistration = this.getTerminal().getServiceManager().registerService(class$de$audi$atip$interapp$tv$ITVComponentListener == null ? (class$de$audi$atip$interapp$tv$ITVComponentListener = TVContent.class$("de.audi.atip.interapp.tv.ITVComponentListener")) : class$de$audi$atip$interapp$tv$ITVComponentListener, this.componentListener, new Hashtable());
        this.logger.main().log(1078071040, "[%1.init]", (Object)"TVContent");
        this.drawerContextHandler.init();
    }

    @Override
    public void deinit() {
        this.logger.main().log(1078071040, "[%1.deinit]", (Object)"TVContent");
        this.drawerContextHandler.deinit();
        this.getTerminal().getServiceManager().unregisterService(this.componentServiceRegistration);
        super.deinit();
    }

    @Override
    public void activate(IActivationContext iActivationContext) {
        super.activate(iActivationContext);
        this.logger.main().log(1078071040, "[%1.activate]", (Object)"TVContent");
        this.drawerContextHandler.activate();
        this.getChoiceModel(1997538048).setValue(0);
        ITVService iTVService = MediaEvoUtils.getTVService(this.getTerminal().getServiceManager());
        if (null != iTVService) {
            iTVService.activate(((AbstractTVSource)iActivationContext.getSlot().getSource()).getExternalSourceType(), this.drawerContextHandler);
            if (this.componentStarted) {
                this.notifyContentActivationFinished();
            }
        }
    }

    @Override
    public void deactivate() {
        this.logger.main().log(1078071040, "[%1.deactivate]", (Object)"TVContent");
        this.drawerContextHandler.deactivate();
        super.deactivate();
        ITVService iTVService = MediaEvoUtils.getTVService(this.getTerminal().getServiceManager());
        if (null != iTVService) {
            iTVService.deactivate();
        }
    }

    static /* synthetic */ boolean access$002(TVContent tVContent, boolean bl) {
        tVContent.componentStarted = bl;
        return tVContent.componentStarted;
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

