/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.evo.content.tv.DrawerContextHandler;
import de.audi.app.media.evo.content.tv.DrawerContextListRow;
import de.audi.app.media.osgi.IServiceManager;
import de.audi.app.media.source.ActiveSourceState;
import de.audi.app.media.source.IActiveSourceListener;
import de.audi.app.media.source.ISourceController;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.hmi.model.update.ModelTrigger;
import de.audi.atip.interapp.media.IMediaDrawerContextListener;
import de.audi.atip.interapp.media.IMediaDrawerElement;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import org.osgi.framework.ServiceRegistration;

public class MediaOnlineDrawerContextHandler
extends DrawerContextHandler
implements IActiveSourceListener {
    private static final String LOGCLASS;
    private final IServiceManager serviceManager;
    private volatile ServiceRegistration mediaDrawerServiceRegistration;
    private final ISourceController sourceController;
    private volatile int lastActiveSource;
    static /* synthetic */ Class class$de$audi$atip$interapp$media$IMediaDrawerContext;

    public MediaOnlineDrawerContextHandler(IMediaTerminal iMediaTerminal) {
        super(iMediaTerminal);
        this.serviceManager = iMediaTerminal.getServiceManager();
        this.sourceController = iMediaTerminal.getSourceController();
        this.lastActiveSource = -1;
    }

    @Override
    public void init() {
        super.init();
        this.logger.log(1078071040, "[%1.init]", (Object)"MediaOnlineDrawerContextHandler");
        this.sourceController.addActiveSourceListener(this);
        this.registerService();
    }

    @Override
    public void deinit() {
        this.logger.log(1078071040, "[%1.deinit]", (Object)"MediaOnlineDrawerContextHandler");
        this.unregisterService();
        this.sourceController.removeActiveSourceListener(this);
        this.lastActiveSource = -1;
        super.deinit();
    }

    @Override
    public void deactivate() {
        this.logger.log(1078071040, "[%1.deactivate]", (Object)"MediaOnlineDrawerContextHandler");
        this.state = 0;
        this.drawerContextListModel.removeAll();
        this.drawerContextListModel.resetListener();
    }

    private void registerService() {
        this.mediaDrawerServiceRegistration = this.serviceManager.registerService(class$de$audi$atip$interapp$media$IMediaDrawerContext == null ? (class$de$audi$atip$interapp$media$IMediaDrawerContext = MediaOnlineDrawerContextHandler.class$("de.audi.atip.interapp.media.IMediaDrawerContext")) : class$de$audi$atip$interapp$media$IMediaDrawerContext, this, new Hashtable(0));
    }

    private void unregisterService() {
        this.mediaDrawerServiceRegistration.unregister();
    }

    @Override
    public void activeSourceChanged(boolean bl, ActiveSourceState activeSourceState) {
        this.logger.log(-2137614336, "[%1.activeSourceChanged]", (Object)"MediaOnlineDrawerContextHandler");
        if (!bl) {
            return;
        }
        int n = activeSourceState.getSlot().getSource().getType();
        if (n != 13) {
            if (this.lastActiveSource == 13) {
                this.deactivate();
            }
            this.lastActiveSource = n;
            return;
        }
        this.lastActiveSource = n;
        this.logger.log(-2137614336, "[%1.activeSourceChanged] Active source changed to online.", (Object)"MediaOnlineDrawerContextHandler");
        this.activate();
    }

    @Override
    public void sourceDeactivated() {
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logger.log(1078071040, "[%1.itemSelected]", (Object)"MediaOnlineDrawerContextHandler");
        DrawerContextListRow drawerContextListRow = (DrawerContextListRow)evoListRow;
        IMediaDrawerElement iMediaDrawerElement = drawerContextListRow.getMediaDrawerElement();
        this.drawerContextListModel.setSelectedUniqueID(iMediaDrawerElement.getID());
        this.drawerContextListener.drawerElementSelected(iMediaDrawerElement);
        this.drawerContextListModel.fireEvent(n4);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void setDrawerElements(List list, IMediaDrawerContextListener iMediaDrawerContextListener) {
        this.logger.log(1078071040, "[%1.setDrawerElements]", (Object)"MediaOnlineDrawerContextHandler");
        if (this.state == 0) {
            this.logger.log(1078071040, "[%1.setDrawerElements] Online not active source ignore", (Object)"MediaOnlineDrawerContextHandler");
            return;
        }
        this.drawerContextListener = null == iMediaDrawerContextListener ? this.nullDrawerContextListener : iMediaDrawerContextListener;
        if (null == list || list.isEmpty()) {
            this.logger.log(1078071040, "[%1.setDrawerElements] List empty.", (Object)"MediaOnlineDrawerContextHandler");
            this.drawerContextListModel.removeAll();
            return;
        }
        BaseListModelApp baseListModelApp = this.drawerContextListModel.getCopy();
        if (this.newDataEqualsCurrentData(list, baseListModelApp)) {
            this.logger.log(1078071040, "[%1.setDrawerElements] ignore placeholder update", (Object)"MediaOnlineDrawerContextHandler");
            return;
        }
        try {
            baseListModelApp.removeAll();
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                IMediaDrawerElement iMediaDrawerElement = (IMediaDrawerElement)iterator.next();
                DrawerContextListRow drawerContextListRow = new DrawerContextListRow(iMediaDrawerElement, 0);
                baseListModelApp.append(drawerContextListRow);
                if (iMediaDrawerElement.isSelected()) {
                    baseListModelApp.setSelectedUniqueID(iMediaDrawerElement.getID());
                }
                if (!iMediaDrawerElement.isFocused() || baseListModelApp.getMenu() == null) continue;
                baseListModelApp.getMenu().setFocusedItem(baseListModelApp.getID(), FocusAdvice.KEEP_POSITION, iMediaDrawerElement.getID());
            }
        }
        finally {
            this.drawerContextListModel.update(baseListModelApp);
            if (baseListModelApp.getLength() <= 0) {
                this.drawerContextListModel.trigger(ModelTrigger.CLOSE_SELECTION_DRAWER);
            }
        }
    }

    boolean newDataEqualsCurrentData(List list, BaseListModelApp baseListModelApp) {
        if (list.size() == 1 && baseListModelApp.getLength() == 1) {
            IMediaDrawerElement iMediaDrawerElement = (IMediaDrawerElement)list.get(0);
            if (iMediaDrawerElement == null) {
                return false;
            }
            DrawerContextListRow drawerContextListRow = (DrawerContextListRow)baseListModelApp.getRow(0);
            if (drawerContextListRow == null) {
                return false;
            }
            IMediaDrawerElement iMediaDrawerElement2 = drawerContextListRow.getMediaDrawerElement();
            if (iMediaDrawerElement2 == null) {
                return false;
            }
            return iMediaDrawerElement.getName() == null && iMediaDrawerElement2.getName() == null;
        }
        return false;
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

