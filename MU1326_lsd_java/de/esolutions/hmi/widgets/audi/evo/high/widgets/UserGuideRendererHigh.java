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
    private static final int OFFSET_ICON_X = 10;
    private static final int OFFSET_ICON_X_MAP = 20;
    private static final int OFFSET_ICON_Y = 10;
    private static final int X_POS_POINTER = 14;
    private static final String PROPERTY_FAKE_SPELLER_VISIBLE = "ug_spellerVisible";
    private static final String PROPERTY_INFO_YPOS = "ug_info_Ypos";
    private static final String PROPERTY_INFO_XPOS = "ug_info_Xpos";
    private static final String PROPERTY_INFO_ICON_VISIBLE = "ug_infoIconVisible";
    private static final String PROPERTY_SEPERATOR_VISIBLE = "ug_seperatorVisible";
    private static final String PROPERTY_SEPERATOR_YPOS = "ug_seperator_Ypos";
    private static final String PROPERTY_POINTER_XPOS = "ug_pointer_Xpos";
    private static final String PROPERTY_POINTER_VISIBLE = "ug_pointerVisible";
    private static final String PROPERTY_PANEL_HEIGHT = "ug_panelHeight";
    private static final String PROPERTY_PANEL_WIDTH = "ug_panelWidth";
    private static final String PROPERTY_FIELD_COLOR = "Color";
    private static final String PROPERTY_ICON_COLOR = "if_iconColor";
    private static final String PROPERTY_MENU_SEPARATOR_VISIBLE = "ug_cursorSeperator_visible";
    private static final String PROPERTY_MENU_SEPARATOR_WIDTH = "ug_cursorSeperator_width";
    private static final String PROPERTY_MENU_SEPARATOR_YPOS = "ug_cursorSeperator_Ypos";
    private static final String PROPERTY_HINT_ANIMATION_PROGRESS = "ug_animationProgress";
    private int seperatorYPos;
    private final UserGuideController controller;
    private IWrappedNode3D nodeAnimation;

    public UserGuideRendererHigh(UserGuideController userGuideController) {
        this.controller = userGuideController;
    }

    public void connect(InitializationContext initializationContext) {
        super.connect(initializationContext);
        this.seperatorYPos = initializationContext.getTerminal().getLayout().getIntegerConstant(106);
    }

    public void render(RedrawContext redrawContext) {
        super.render(redrawContext);
        if (this.nodeAnimation == null) {
            this.nodeAnimation = this.getEALManager().createTemplateInstanceNode(this.node, EALManager.createNodeName("hintAnimationNode", this), 0.0f, 0.0f, 19, this.controller.getAnimationPrefabPath(), this.getInitContext().getScreenID());
        }
        if (this.nodeAnimation != null) {
            this.nodeAnimation.setPosition(this.controller.getAnimationXPos(), this.controller.getAnimationYPos(), 0.0f);
            if (this.getAbstractController().shouldRender() && this.nodeAnimation.getNode().hasProperty(PROPERTY_HINT_ANIMATION_PROGRESS)) {
                this.propertyCache.setProperty(this.nodeAnimation, PROPERTY_HINT_ANIMATION_PROGRESS, this.controller.getAnimProgress());
            }
        }
    }

    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        this.node.setPosition(this.controller.getX(), this.controller.getY(), 0.0f);
        this.setProperty(PROPERTY_PANEL_WIDTH, this.controller.getWidth());
        this.setProperty(PROPERTY_PANEL_HEIGHT, this.controller.getHeight());
        boolean bl = this.controller.hasPointer();
        if (bl) {
            this.setProperty(PROPERTY_POINTER_VISIBLE, true);
            this.setProperty(PROPERTY_POINTER_XPOS, 14.0f);
        } else {
            this.setProperty(PROPERTY_POINTER_VISIBLE, false);
        }
        this.setProperty(PROPERTY_INFO_ICON_VISIBLE, !this.controller.isMapHint());
        this.setProperty(PROPERTY_INFO_XPOS, this.controller.isMapHint() ? 20.0f : 10.0f);
        this.setProperty(PROPERTY_INFO_YPOS, 10.0f);
        int n = this.controller.getSeparatorYPosition();
        if (n != -1) {
            this.setProperty(PROPERTY_MENU_SEPARATOR_VISIBLE, true);
            this.setProperty(PROPERTY_MENU_SEPARATOR_YPOS, n);
            this.setProperty(PROPERTY_MENU_SEPARATOR_WIDTH, this.controller.getWidth() - 2);
        } else {
            this.setProperty(PROPERTY_MENU_SEPARATOR_VISIBLE, false);
        }
        if (this.controller.isMapHint()) {
            this.setProperty(PROPERTY_SEPERATOR_VISIBLE, true);
            this.setProperty(PROPERTY_SEPERATOR_YPOS, this.seperatorYPos);
        } else {
            this.setProperty(PROPERTY_SEPERATOR_VISIBLE, false);
        }
        if (this.controller.isInitialSpellerHint()) {
            this.setProperty(PROPERTY_FAKE_SPELLER_VISIBLE, 1.0f);
        } else {
            this.setProperty(PROPERTY_FAKE_SPELLER_VISIBLE, 0.0f);
        }
        this.setProperty("ug_speller_TouchIconVisible", this.controller.isTouchpadKeypanelWithActiveStatus() ? 1.0f : 0.0f);
        int n2 = EALManager.createColorCode(redrawContextHigh.getColor(0));
        int n3 = EALManager.createColorCode(redrawContextHigh.getColor(3));
        this.setColorProperty(PROPERTY_ICON_COLOR, n3);
        this.setColorProperty(PROPERTY_FIELD_COLOR, n2);
    }

    protected String getTemplateNodePath() {
        return "Prefabs/ug_frame";
    }

    protected String getEALNodeName() {
        return "hintGlassplate";
    }

    public void disconnect() {
        this.getEALManager().destroy(this.nodeAnimation);
        this.nodeAnimation = null;
        super.disconnect();
    }

    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    protected int getKzbConstant() {
        return 19;
    }
}

