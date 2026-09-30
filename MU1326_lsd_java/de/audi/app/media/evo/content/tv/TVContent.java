/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.tv;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.content.IContentContext;
import de.audi.app.media.content.media.AbstractMediaContent;
import de.audi.app.media.evo.content.tv.DrawerContextHandler;
import de.audi.app.media.evo.utils.MediaEvoUtils;
import de.audi.app.media.source.IActivationContext;
import de.audi.app.media.source.media.AbstractTVSource;
import de.audi.atip.interapp.tv.ITVComponentListener;
import de.audi.atip.interapp.tv.ITVService;
import java.util.Hashtable;
import org.osgi.framework.ServiceRegistration;

public class TVContent
extends AbstractMediaContent {
    private static final String LOGCLASS = "TVContent";
    private final DrawerContextHandler drawerContextHandler;
    private ITVComponentListener componentListener = new ITVComponentListener(){

        public void stopComponentCalled() {
            TVContent.this.componentStarted = false;
        }

        public void startComponenCalled() {
            TVContent.this.componentStarted = true;
            TVContent.this.notifyContentActivationFinished();
        }
    };
    private ServiceRegistration componentServiceRegistration;
    private boolean componentStarted = false;
    static /* synthetic */ Class class$de$audi$atip$interapp$tv$ITVComponentListener;

    public TVContent(IContentContext iContentContext, IMediaTerminal iMediaTerminal) {
        super(3, iContentContext, iMediaTerminal);
        this.drawerContextHandler = new DrawerContextHandler(iMediaTerminal);
    }

    public void init() {
        super.init();
        this.componentServiceRegistration = this.getTerminal().getServiceManager().registerService(class$de$audi$atip$interapp$tv$ITVComponentListener == null ? (class$de$audi$atip$interapp$tv$ITVComponentListener = TVContent.class$("de.audi.atip.interapp.tv.ITVComponentListener")) : class$de$audi$atip$interapp$tv$ITVComponentListener, this.componentListener, new Hashtable());
        this.logger.main().log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.drawerContextHandler.init();
    }

    public void deinit() {
        this.logger.main().log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.drawerContextHandler.deinit();
        this.getTerminal().getServiceManager().unregisterService(this.componentServiceRegistration);
        super.deinit();
    }

    public void activate(IActivationContext iActivationContext) {
        super.activate(iActivationContext);
        this.logger.main().log(1000000, "[%1.activate]", (Object)LOGCLASS);
        this.drawerContextHandler.activate();
        this.getChoiceModel(200823).setValue(0);
        ITVService iTVService = MediaEvoUtils.getTVService(this.getTerminal().getServiceManager());
        if (null != iTVService) {
            iTVService.activate(((AbstractTVSource)iActivationContext.getSlot().getSource()).getExternalSourceType(), this.drawerContextHandler);
            if (this.componentStarted) {
                this.notifyContentActivationFinished();
            }
        }
    }

    public void deactivate() {
        this.logger.main().log(1000000, "[%1.deactivate]", (Object)LOGCLASS);
        this.drawerContextHandler.deactivate();
        super.deactivate();
        ITVService iTVService = MediaEvoUtils.getTVService(this.getTerminal().getServiceManager());
        if (null != iTVService) {
            iTVService.deactivate();
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

