/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.graphics.eal.api.INode;
import de.esolutions.graphics.eal.api.INode2D;
import de.esolutions.graphics.eal.api.INode3D;
import de.esolutions.graphics.eal.api.IProperty;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.ARAController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IARARenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.IKanziTemplateRenderer;

public class ARARendererHigh
extends AbstractRendererHigh
implements IKanziTemplateRenderer,
IARARenderer {
    private static final String ARA_OFFSCREEN_ROOT = "ara_offscreen_root";
    private static final String PROPERTY_HOLDER_NODE_NAME = "ara_controls";
    private static final String PROPERTY_NAME_MAX_ANGLE = "ara_boundsAngle";
    private static final String PROPERTY_NAME_MAX_ANGLE_VISIBLE = "ara_boundsAngle_visible";
    private static final String PROPERTY_NAME_3D_TRAILER_ANGLE = "ara_trailerAngle";
    private static final String PROPERTY_NAME_CURRENT_ANGLE = "ara_currentDirection";
    private static final String PROPERTY_NAME_CURRENT_HAZINESS = "ara_currentAngle";
    private static final String PROPERTY_NAME_CURRENT_ANGLE_VISIBLE = "ara_currentIndicator_visible";
    private static final String PROPERTY_NAME_TARGET_ANGLE = "ara_targetDirection";
    private static final String PROPERTY_NAME_TARGET_HAZINESS = "ara_targetAngle";
    private static final String PROPERTY_NAME_TARGET_ANGLE_VISIBLE = "ara_targetIndicator_visible";
    private static final String PROPERTY_NAME_CLIP_ANGLE = "ara_clipAngle";
    private static final String PROPERTY_NAME_CLIP_ANGLE_VISIBLE = "ara_clipIndicator_visible";
    private final ARAController controller;
    private static INode2D mainNode;
    private static INode2D offscreenRoot;
    private static INode3D propertyHolderNode;
    private static IProperty property3DTrailerAngle;
    private static IProperty propertyMaxAngle;
    private static IProperty propertyMaxAngleVisible;
    private static IProperty propertyCurrentAngle;
    private static IProperty propertyCurrentHaziness;
    private static IProperty propertyCurrentAngleVisible;
    private static IProperty propertyTargetAngle;
    private static IProperty propertyTargetHaziness;
    private static IProperty propertyTargetAngleVisible;
    private static IProperty propertyClipAngle;
    private static IProperty propertyClipAngleVisible;
    private static boolean resourcesLoaded;

    public ARARendererHigh(ARAController aRAController) {
        this.controller = aRAController;
    }

    protected void applyProperties() {
        mainNode.setOpacity(this.controller.getRenderOpacity());
        property3DTrailerAngle.set(this.controller.getCurrentAngle());
        propertyMaxAngle.set(this.controller.getMaxAngle());
        propertyMaxAngleVisible.set(this.controller.isMaxAngleAvailable() ? 1.0f : 0.0f);
        propertyCurrentAngle.set(this.controller.getCurrentAngle());
        propertyCurrentHaziness.set(this.controller.isHazinessAngleAvailable() ? this.controller.getHazinessAngle() : 0.0f);
        propertyCurrentAngleVisible.set(this.controller.isCurrentAngleAvailable() && this.controller.isHazinessAngleAvailable() ? 1.0f : 0.0f);
        propertyTargetAngle.set(this.controller.getTargetAngle());
        propertyTargetHaziness.set(this.controller.isHazinessAngleAvailable() ? this.controller.getHazinessAngle() : 0.0f);
        propertyTargetAngleVisible.set(this.controller.isTargetAngleAvailable() ? 1.0f : 0.0f);
        propertyClipAngle.set(this.controller.getClipAngle());
        propertyClipAngleVisible.set(this.controller.isClipAngleAvailable() ? 1.0f : 0.0f);
        logChannelParking.log(10000000, "ARARendererHigh#applyProperties: properties applied");
    }

    private IProperty getProperty(INode iNode, String string) {
        IProperty iProperty = iNode.getProperty(string);
        if (!iProperty.isValid()) {
            logChannelParking.log(10000, "ARARendererHigh#getProperty: could not create property for node '%1', key '%2'", (Object)iNode.getName(), (Object)string);
            iProperty.dispose();
            return null;
        }
        return iProperty;
    }

    private INode3D getNode3D(String string) {
        INode3D iNode3D = this.getEALManager().getProject().getNode3D(string);
        if (!iNode3D.isValid()) {
            logChannelParking.log(10000, "ARARendererHigh#getNode3D: Could not get node '%1'", (Object)string);
            iNode3D.dispose();
            return null;
        }
        return iNode3D;
    }

    private INode2D getNode2D(String string) {
        INode2D iNode2D = this.getEALManager().getProject().getNode2D(string);
        if (!iNode2D.isValid()) {
            logChannelParking.log(10000, "ARARendererHigh#getNode2D: Could not get node '%1'", (Object)string);
            iNode2D.dispose();
            return null;
        }
        return iNode2D;
    }

    private void loadResources() {
        EALManager eALManager = this.getEALManager();
        INode2D iNode2D = eALManager.mergeProject(1, 100, this.getInitContext().getScreenID());
        if (iNode2D == null) {
            logChannelParking.log(10000, "ARARendererHigh#loadResources: unable to load KZB");
            return;
        }
        iNode2D.dispose();
        mainNode = eALManager.getProject().getNode2D("layer_ara_main");
        if (mainNode == null) {
            logChannelParking.log(10000, "ARARendererHigh#loadResources: layer_ara_main is null");
            return;
        }
        if (!mainNode.isValid()) {
            mainNode.dispose();
            mainNode = null;
            logChannelParking.log(10000, "ARARendererHigh#loadResources: could not get layer_ara_main from project");
            return;
        }
        offscreenRoot = this.getNode2D(ARA_OFFSCREEN_ROOT);
        if (offscreenRoot == null) {
            return;
        }
        propertyHolderNode = this.getNode3D(PROPERTY_HOLDER_NODE_NAME);
        if (propertyHolderNode == null) {
            return;
        }
        property3DTrailerAngle = this.getProperty(propertyHolderNode, PROPERTY_NAME_3D_TRAILER_ANGLE);
        propertyMaxAngle = this.getProperty(propertyHolderNode, PROPERTY_NAME_MAX_ANGLE);
        propertyMaxAngleVisible = this.getProperty(propertyHolderNode, PROPERTY_NAME_MAX_ANGLE_VISIBLE);
        propertyCurrentAngle = this.getProperty(propertyHolderNode, PROPERTY_NAME_CURRENT_ANGLE);
        propertyCurrentHaziness = this.getProperty(propertyHolderNode, PROPERTY_NAME_CURRENT_HAZINESS);
        propertyCurrentAngleVisible = this.getProperty(propertyHolderNode, PROPERTY_NAME_CURRENT_ANGLE_VISIBLE);
        propertyTargetAngle = this.getProperty(propertyHolderNode, PROPERTY_NAME_TARGET_ANGLE);
        propertyTargetHaziness = this.getProperty(propertyHolderNode, PROPERTY_NAME_TARGET_HAZINESS);
        propertyTargetAngleVisible = this.getProperty(propertyHolderNode, PROPERTY_NAME_TARGET_ANGLE_VISIBLE);
        propertyClipAngle = this.getProperty(propertyHolderNode, PROPERTY_NAME_CLIP_ANGLE);
        propertyClipAngleVisible = this.getProperty(propertyHolderNode, PROPERTY_NAME_CLIP_ANGLE_VISIBLE);
        resourcesLoaded = true;
        logChannelParking.log(10000000, "ARARendererHigh#loadResources: resources loaded");
    }

    public void render(RedrawContext redrawContext) {
        if (!this.controller.isVisible() || !this.controller.isOnScreen()) {
            return;
        }
        if (!resourcesLoaded) {
            this.loadResources();
            if (!resourcesLoaded) {
                return;
            }
        }
        this.applyProperties();
    }

    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    public void setKzbIDs(int[] nArray) {
    }

    public void setVisible(boolean bl) {
        if (resourcesLoaded) {
            propertyHolderNode.setVisible(bl);
            offscreenRoot.setVisible(bl);
        }
    }
}

