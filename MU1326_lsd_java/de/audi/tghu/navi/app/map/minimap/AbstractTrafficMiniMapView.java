/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.minimap;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.map.minimap.ChoiceListenerAdapter;
import de.audi.tghu.navi.app.map.minimap.ITrafficMiniMap;
import de.audi.tghu.navi.app.map.minimap.ITrafficMiniMapView;
import org.dsi.ifc.asiatrafficinfomenu.ResourceInformation;

public abstract class AbstractTrafficMiniMapView
implements ITrafficMiniMapView {
    public static final int POPUP_HIDDEN = 0;
    public static final int POPUP_VISIBLE = 1;
    protected static final int POPUP_MINIMAP_SHOWN_CHOICE_MODEL = 402171;
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
        this.choiceModelSettingEnebled.setChoiceListener(new ChoiceListenerAdapter(){

            public void itemSelected(int n, int n2, int n3, int n4) {
                if (n2 == 0) {
                    AbstractTrafficMiniMapView.this.deactivateAndPersist();
                } else {
                    AbstractTrafficMiniMapView.this.activateAndPersist();
                }
            }
        });
    }

    public void hideMiniMap() {
        if (this.choiceModelImageID != null) {
            this.choiceModelImageID.setValue(0);
            this.choiceModelPopupControl.setValue(0);
        }
    }

    public void activateAndPersist() {
        this.setActive(true);
        this.trafficMiniMap.persistSettings();
    }

    public void deactivateAndPersist() {
        this.setActive(false);
        this.hideMiniMap();
        this.trafficMiniMap.persistSettings();
    }

    public boolean isActivated() {
        return this.active;
    }

    public boolean displayMiniMap(ResourceInformation resourceInformation) {
        this.logChannel.log(10000000, "AbstractTrafficMiniMapView#displayMiniMap  active=%1 resourceInformation=%2", this.active, (Object)resourceInformation);
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

    public abstract void initModels();

    public void init() {
        this.initModels();
        this.initListener();
    }

    public void setActive(boolean bl) {
        this.logChannel.log(1000000, "AbstractTrafficMiniMapView#setActive active=%1", bl);
        this.active = bl;
        if (this.choiceModelImageID != null) {
            this.choiceModelImageID.setValue(bl ? 1 : 0);
        }
        if (this.choiceModelSettingEnebled != null) {
            this.choiceModelSettingEnebled.setValue(bl ? 1 : 0);
        }
    }

    public boolean isVisible() {
        return this.choiceModelPopupControl != null && this.choiceModelPopupControl.getValue() == 1;
    }
}

