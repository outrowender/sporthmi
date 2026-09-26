/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.minimap;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.map.minimap.AbstractTrafficMiniMapView$1;
import de.audi.tghu.navi.app.map.minimap.ITrafficMiniMap;
import de.audi.tghu.navi.app.map.minimap.ITrafficMiniMapView;
import org.dsi.ifc.asiatrafficinfomenu.ResourceInformation;

public abstract class AbstractTrafficMiniMapView
implements ITrafficMiniMapView {
    public static final int POPUP_HIDDEN;
    public static final int POPUP_VISIBLE;
    protected static final int POPUP_MINIMAP_SHOWN_CHOICE_MODEL;
    protected final ITrafficMiniMap trafficMiniMap;
    protected boolean active;
    protected final LogChannel logChannel;
    protected ChoiceModelApp choiceModelImageID;
    protected ChoiceModelApp choiceModelSettingEnebled;
    protected ChoiceModelApp choiceModelPopupControl;

    public AbstractTrafficMiniMapView(ITrafficMiniMap iTrafficMiniMap, LogChannel logChannel) {
        this.trafficMiniMap = iTrafficMiniMap;
        this.logChannel = logChannel;
    }

    private void initListener() {
        this.choiceModelSettingEnebled.setChoiceListener(new AbstractTrafficMiniMapView$1(this));
    }

    @Override
    public void hideMiniMap() {
        if (this.choiceModelImageID != null) {
            this.choiceModelImageID.setValue(0);
            this.choiceModelPopupControl.setValue(0);
        }
    }

    @Override
    public void activateAndPersist() {
        this.setActive(true);
        this.trafficMiniMap.persistSettings();
    }

    @Override
    public void deactivateAndPersist() {
        this.setActive(false);
        this.hideMiniMap();
        this.trafficMiniMap.persistSettings();
    }

    @Override
    public boolean isActivated() {
        return this.active;
    }

    @Override
    public boolean displayMiniMap(ResourceInformation resourceInformation) {
        this.logChannel.log(-2137614336, "AbstractTrafficMiniMapView#displayMiniMap  active=%1 resourceInformation=%2", this.active, (Object)resourceInformation);
        if (this.isActivated()) {
            if (this.choiceModelImageID != null) {
                this.choiceModelImageID.setValue(resourceInformation.getResourceLocator().getId());
                this.choiceModelPopupControl.setValue(1);
                return true;
            }
            this.logChannel.log(10000, "AbstractTrafficMiniMapView#displayMiniMap choiceModelImageID = null");
        }
        return false;
    }

    @Override
    public abstract void initModels() {
    }

    public void init() {
        this.initModels();
        this.initListener();
    }

    @Override
    public void setActive(boolean bl) {
        this.logChannel.log(1078071040, "AbstractTrafficMiniMapView#setActive active=%1", bl);
        this.active = bl;
        if (this.choiceModelImageID != null) {
            this.choiceModelImageID.setValue(bl ? 1 : 0);
        }
        if (this.choiceModelSettingEnebled != null) {
            this.choiceModelSettingEnebled.setValue(bl ? 1 : 0);
        }
    }

    @Override
    public boolean isVisible() {
        return this.choiceModelPopupControl != null && this.choiceModelPopupControl.getValue() == 1;
    }
}

