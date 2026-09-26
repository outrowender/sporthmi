/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractKanziTemplateRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.UserGuideController;

public class UserGuideRendererHigh
extends AbstractKanziTemplateRenderer {
    private static final int OFFSET_ICON_X;
    private static final int OFFSET_ICON_X_MAP;
    private static final int OFFSET_ICON_Y;
    private static final int X_POS_POINTER;
    private static final String PROPERTY_FAKE_SPELLER_VISIBLE;
    private static final String PROPERTY_INFO_YPOS;
    private static final String PROPERTY_INFO_XPOS;
    private static final String PROPERTY_INFO_ICON_VISIBLE;
    private static final String PROPERTY_SEPERATOR_VISIBLE;
    private static final String PROPERTY_SEPERATOR_YPOS;
    private static final String PROPERTY_POINTER_XPOS;
    private static final String PROPERTY_POINTER_VISIBLE;
    private static final String PROPERTY_PANEL_HEIGHT;
    private static final String PROPERTY_PANEL_WIDTH;
    private static final String PROPERTY_FIELD_COLOR;
    private static final String PROPERTY_ICON_COLOR;
    private static final String PROPERTY_MENU_SEPARATOR_VISIBLE;
    private static final String PROPERTY_MENU_SEPARATOR_WIDTH;
    private static final String PROPERTY_MENU_SEPARATOR_YPOS;
    private static final String PROPERTY_HINT_ANIMATION_PROGRESS;
    private int seperatorYPos;
    private final UserGuideController controller;
    private IWrappedNode3D nodeAnimation;

    public UserGuideRendererHigh(UserGuideController userGuideController) {
        this.controller = userGuideController;
    }

    @Override
    public void connect(InitializationContext initializationContext) {
        super.connect(initializationContext);
        this.seperatorYPos = initializationContext.getTerminal().getLayout().getIntegerConstant(106);
    }

    @Override
    public void render(RedrawContext redrawContext) {
        super.render(redrawContext);
        if (this.nodeAnimation == null) {
            this.nodeAnimation = this.getEALManager().createTemplateInstanceNode(this.node, EALManager.createNodeName("hintAnimationNode", this), 0.0f, 0.0f, 19, this.controller.getAnimationPrefabPath(), this.getInitContext().getScreenID());
        }
        if (this.nodeAnimation != null) {
            this.nodeAnimation.setPosition(this.controller.getAnimationXPos(), this.controller.getAnimationYPos(), 0.0f);
            if (this.getAbstractController().shouldRender() && this.nodeAnimation.getNode().hasProperty("ug_animationProgress")) {
                this.propertyCache.setProperty(this.nodeAnimation, "ug_animationProgress", this.controller.getAnimProgress());
            }
        }
    }

    @Override
    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        this.node.setPosition(this.controller.getX(), this.controller.getY(), 0.0f);
        this.setProperty("ug_panelWidth", this.controller.getWidth());
        this.setProperty("ug_panelHeight", this.controller.getHeight());
        boolean bl = this.controller.hasPointer();
        if (bl) {
            this.setProperty("ug_pointerVisible", true);
            this.setProperty("ug_pointer_Xpos", 24641);
        } else {
            this.setProperty("ug_pointerVisible", false);
        }
        this.setProperty("ug_infoIconVisible", !this.controller.isMapHint());
        this.setProperty("ug_info_Xpos", this.controller.isMapHint() ? 41025 : 8257);
        this.setProperty("ug_info_Ypos", 8257);
        int n = this.controller.getSeparatorYPosition();
        if (n != -1) {
            this.setProperty("ug_cursorSeperator_visible", true);
            this.setProperty("ug_cursorSeperator_Ypos", n);
            this.setProperty("ug_cursorSeperator_width", this.controller.getWidth() - 2);
        } else {
            this.setProperty("ug_cursorSeperator_visible", false);
        }
        if (this.controller.isMapHint()) {
            this.setProperty("ug_seperatorVisible", true);
            this.setProperty("ug_seperator_Ypos", this.seperatorYPos);
        } else {
            this.setProperty("ug_seperatorVisible", false);
        }
        if (this.controller.isInitialSpellerHint()) {
            this.setProperty("ug_spellerVisible", 1.0f);
        } else {
            this.setProperty("ug_spellerVisible", 0.0f);
        }
        this.setProperty("ug_speller_TouchIconVisible", this.controller.isTouchpadKeypanelWithActiveStatus() ? 1.0f : 0.0f);
        int n2 = EALManager.createColorCode(redrawContextHigh.getColor(0));
        int n3 = EALManager.createColorCode(redrawContextHigh.getColor(3));
        this.setColorProperty("if_iconColor", n3);
        this.setColorProperty("Color", n2);
    }

    @Override
    protected String getTemplateNodePath() {
        return "Prefabs/ug_frame";
    }

    @Override
    protected String getEALNodeName() {
        return "hintGlassplate";
    }

    @Override
    public void disconnect() {
        this.getEALManager().destroy(this.nodeAnimation);
        this.nodeAnimation = null;
        super.disconnect();
    }

    @Override
    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    @Override
    protected int getKzbConstant() {
        return 19;
    }
}

