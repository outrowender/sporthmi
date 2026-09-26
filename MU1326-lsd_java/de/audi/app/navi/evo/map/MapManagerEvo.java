/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.map;

import de.audi.app.navi.evo.map.SatelliteMapsGUIEVO;
import de.audi.app.navi.evo.map.context.ContextFactoryEvo;
import de.audi.app.navi.evo.map.handler.DrawerStateHandlerEvo;
import de.audi.app.navi.evo.map.handler.preview.PreviewMapHandlerEvo;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.LocationSerializer;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.IGUIFactory;
import de.audi.tghu.navi.app.map.IMapFactory;
import de.audi.tghu.navi.app.map.IMapPartialPopupHandler;
import de.audi.tghu.navi.app.map.IMapPropertyProvider;
import de.audi.tghu.navi.app.map.INaviInterface;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.map.MapManager;
import de.audi.tghu.navi.app.map.SatelliteMapsMediator;
import de.audi.tghu.navi.app.map.context.IContextFactory;
import de.audi.tghu.navi.app.map.gui.MapPartialPopupEvoHandler;
import de.audi.tghu.navi.app.map.handler.IDrawerStateHandler;
import de.audi.tghu.navi.app.map.handler.ISetupHandler;
import de.audi.tghu.navi.app.map.handler.NullPreviewMapHandler;
import de.audi.tghu.navi.app.map.handler.selection.MapSelectionHandlerFactory;
import de.audi.tghu.navi.app.map.instances.MapMain;
import de.audi.tghu.navi.app.map.settings.MapOptionValidator;
import de.audi.tghu.navi.app.sds.ISDSController;
import de.audi.tghu.navi.app.util.FunctionCounter;
import de.audi.tghu.navi.app.util.Util;

public class MapManagerEvo
extends MapManager {
    private SatelliteMapsGUIEVO satelliteMapsGUI;

    public MapManagerEvo(NavigationEnv navigationEnv, IconHandler iconHandler, INaviInterface iNaviInterface, FunctionCounter functionCounter, ISDSController iSDSController, IMapPropertyProvider iMapPropertyProvider, IMapFactory iMapFactory, IGUIFactory iGUIFactory, LocationSerializer locationSerializer, ICommandListFactory iCommandListFactory, ISetupHandler iSetupHandler, MapOptionValidator mapOptionValidator, MapSelectionHandlerFactory mapSelectionHandlerFactory) {
        super(navigationEnv, iconHandler, iNaviInterface, functionCounter, iSDSController, iMapPropertyProvider, iMapFactory, iGUIFactory, locationSerializer, iCommandListFactory, iSetupHandler, new MapInterface(navigationEnv, iSDSController, iCommandListFactory, mapOptionValidator), mapOptionValidator, mapSelectionHandlerFactory);
    }

    @Override
    protected IPreviewMap initPreviewMapHandler(MapMain mapMain) {
        if (Util.isPreviewMapPresent(this.env.getFramework())) {
            return new PreviewMapHandlerEvo(this.env, mapMain, this.env.getFramework().getHMIService().getScreenManager(0), this.env.getFramework().getHMIService().getPopupManager(0));
        }
        this.getLogChannel().log(1078071040, "MapManagerEvo#initPreviewMapHandler() - preview map not available, deactivating feature");
        return new NullPreviewMapHandler();
    }

    @Override
    protected SatelliteMapsMediator createSatelliteMapsMediator(NavigationEnv navigationEnv, IconHandler iconHandler) {
        this.satelliteMapsGUI = new SatelliteMapsGUIEVO(navigationEnv);
        return new SatelliteMapsMediator(navigationEnv, this, this.satelliteMapsGUI, iconHandler);
    }

    @Override
    protected IDrawerStateHandler initDrawerStateHandler() {
        return new DrawerStateHandlerEvo(this.getNavigationEnv(), this.getMapInterface());
    }

    @Override
    public IContextFactory getContextFactory() {
        if (this.mCtxFactory == null) {
            this.mCtxFactory = new ContextFactoryEvo();
        }
        return this.mCtxFactory;
    }

    @Override
    protected IMapPartialPopupHandler createMapPartialPopupHandler() {
        return new MapPartialPopupEvoHandler(this.env);
    }

    @Override
    public void cleanup() {
        super.cleanup();
        if (this.satelliteMapsGUI != null) {
            this.satelliteMapsGUI.cleanUp();
        }
    }
}

