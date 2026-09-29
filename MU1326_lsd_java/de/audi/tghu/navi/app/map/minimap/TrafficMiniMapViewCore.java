/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.minimap;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.minimap.ITrafficMiniMapView;
import org.dsi.ifc.asiatrafficinfomenu.ResourceInformation;
import org.dsi.ifc.global.ResourceLocator;

public class TrafficMiniMapViewCore
implements ITrafficMiniMapView {
    public static int SHOW_CHOICE_VALUE_HIDDEN = 0;
    public static int SHOW_CHOICE_VALUE_VISIBLE = 1;
    private LogChannel logger;
    private ResourceLocatorModelApp pic;
    private ChoiceModelApp showChoice;
    private boolean isActive;
    private boolean isVisible;

    public TrafficMiniMapViewCore(LogChannel logChannel, ResourceLocatorModelApp resourceLocatorModelApp, ChoiceModelApp choiceModelApp) {
        this.setMembers(logChannel, resourceLocatorModelApp, choiceModelApp);
    }

    public TrafficMiniMapViewCore(NavigationEnv navigationEnv, int n) {
        ChoiceModelApp choiceModelApp = navigationEnv.getChoiceModel(-81656320);
        ResourceLocatorModelApp resourceLocatorModelApp = navigationEnv.getResourceLocatorModel(n);
        this.setMembers(navigationEnv.getLogChannel(), resourceLocatorModelApp, choiceModelApp);
    }

    private void setMembers(LogChannel logChannel, ResourceLocatorModelApp resourceLocatorModelApp, ChoiceModelApp choiceModelApp) {
        this.logger = logChannel;
        this.pic = resourceLocatorModelApp;
        this.showChoice = choiceModelApp;
    }

    @Override
    public boolean displayMiniMap(ResourceInformation resourceInformation) {
        this.setVisible(false);
        if (null == resourceInformation) {
            this.logger.log(-1601830656, "TrafficMiniMapViewCore#displayMiniMap resourceInformation param not given!");
            return false;
        }
        ResourceLocator resourceLocator = resourceInformation.getResourceLocator();
        if (null == resourceLocator) {
            this.logger.log(-1601830656, "TrafficMiniMapViewCore#displayMiniMap resourceInformation.getResourceLocator() not given!");
            return false;
        }
        if (!this.isValid(resourceLocator)) {
            this.logger.log(-1601830656, "TrafficMiniMapViewCore#displayMiniMap invalid resourceInformation.getResourceLocator()=%1!", (Object)resourceLocator);
            return false;
        }
        this.logger.log(1078071040, "TrafficMiniMapViewCore#displayMiniMap resourceInformation=%1", (Object)resourceInformation);
        this.pic.setResourceLocator(resourceLocator.getId(), resourceLocator.getUrl());
        this.setVisible(true);
        return true;
    }

    private boolean isValid(ResourceLocator resourceLocator) {
        boolean bl = false;
        String string = resourceLocator.getUrl();
        if (null != string && string.length() > 0) {
            bl = true;
        } else if (resourceLocator.getId() > 0) {
            bl = true;
        }
        return bl;
    }

    private void setVisible(boolean bl) {
        this.logger.log(1078071040, "TrafficMiniMapViewCore#setVisible isVisible=%1", bl);
        this.isVisible = bl;
        if (null == this.showChoice) {
            this.logger.log(-1601830656, "TrafficMiniMapViewCore#setVisible no show choice given!");
        } else {
            this.showChoice.setValue(bl ? SHOW_CHOICE_VALUE_VISIBLE : SHOW_CHOICE_VALUE_HIDDEN);
        }
    }

    @Override
    public boolean isVisible() {
        return this.isVisible;
    }

    @Override
    public void hideMiniMap() {
        this.logger.log(1078071040, "TrafficMiniMapViewCore#hideMiniMap");
        this.setVisible(false);
    }

    @Override
    public void activateAndPersist() {
        this.logger.log(1078071040, "TrafficMiniMapViewCore#activateAndPersist");
    }

    @Override
    public void deactivateAndPersist() {
        this.logger.log(1078071040, "TrafficMiniMapViewCore#deactivateAndPersist");
    }

    @Override
    public void initModels() {
        this.logger.log(1078071040, "TrafficMiniMapViewCore#initModels");
    }

    @Override
    public void setActive(boolean bl) {
        this.logger.log(1078071040, "TrafficMiniMapViewCore#setActive isActive=%1", bl);
        this.isActive = bl;
    }

    @Override
    public boolean isActivated() {
        return this.isActive;
    }
}

