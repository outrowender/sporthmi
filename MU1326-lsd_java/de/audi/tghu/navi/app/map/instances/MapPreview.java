/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.instances;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.LocationSerializer;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.INaviInterface;
import de.audi.tghu.navi.app.map.MapConfig;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.map.MapManager;
import de.audi.tghu.navi.app.map.gui.GUIPreview;
import de.audi.tghu.navi.app.map.handler.selection.MapSelectionHandlerFactory;
import de.audi.tghu.navi.app.map.instances.MapAdditional;

public class MapPreview
extends MapAdditional {
    private static final String NAME;
    private boolean bIsMapPreviewInitiated = false;
    private int iPreviewMode = -1;

    public MapPreview(NavigationEnv navigationEnv, MapManager mapManager, MapConfig mapConfig, IconHandler iconHandler, MapInterface mapInterface, INaviInterface iNaviInterface, LocationSerializer locationSerializer, MapSelectionHandlerFactory mapSelectionHandlerFactory) {
        super(navigationEnv, mapManager, mapConfig, iconHandler, mapInterface, iNaviInterface, locationSerializer, mapSelectionHandlerFactory);
        this.setGUIInterface(new GUIPreview(navigationEnv, this));
    }

    @Override
    public String getName() {
        return "MapPreview";
    }

    private boolean isDSIForMapPreviewReady() {
        return this.getMainRequestCtl().isReady();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void initDSI() {
        Object object = this.getMutexSwitchToContext();
        synchronized (object) {
            if (this.isDSIForMapPreviewReady()) {
                if (!this.bIsMapPreviewInitiated) {
                    this.sMapLogChannel.log(1078071040, "%1#init() - all %1 DSIs received. Starting initialization...", (Object)this.getName());
                    this.bIsMapPreviewInitiated = true;
                    this.switchToContext(24);
                }
            } else if (this.bIsMapPreviewInitiated) {
                this.sMapLogChannel.log(-1601830656, "%1#init() - %1 DSIs failed! %1 is not operable any more!", (Object)this.getName());
                this.bIsMapPreviewInitiated = false;
                this.switchToContext(0);
            }
        }
    }

    @Override
    public void show() {
        this.show(0);
    }

    @Override
    public void show(int n) {
        this.switchToContext(30);
    }

    @Override
    public void hide() {
        this.switchToContext(31);
    }

    public void setPreviewMode(int n) {
        if (this.iPreviewMode != n) {
            // empty if block
        }
    }

    public int getPreviewMode() {
        return this.iPreviewMode;
    }

    @Override
    public void forceHiddenContextRefresh() {
    }

    @Override
    protected ChoiceModelApp getActiveRendererChoice() {
        return null;
    }
}

