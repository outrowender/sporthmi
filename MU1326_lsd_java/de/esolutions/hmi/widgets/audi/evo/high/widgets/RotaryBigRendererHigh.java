/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.graphics.eal.api.INode;
import de.esolutions.graphics.eal.api.INode2D;
import de.esolutions.graphics.eal.api.INode3D;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractRotaryRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.RotaryController;
import de.esolutions.hmi.widgets.audi.evo.widgets.RotaryRenderer;

public class RotaryBigRendererHigh
extends AbstractRotaryRendererHigh
implements RotaryRenderer {
    public static final int PREFERRED_WIDTH = 100;
    public static final int PREFERRED_HEIGHT = 100;
    private static final float MIN_ANGLE_COLOR = 45.0f;
    private static final float MAX_ANGLE_COLOR = 315.0f;
    private static final String TEMPLATE_NODE_PATH_ROTATOR_BIG = "Prefabs/generic_rotator_big";
    private static final String TEMPLATE_NODE_PATH_ROTATOR_MEDIUM = "Prefabs/generic_rotator_medium";
    private static final String EAL_NODE_NAME = "rotaryBig";
    public static final int ROTARY_BIG_TYPE_DEFAULT = -1;
    public static final int ROTARY_BIG_TYPE_VIDEO_BRIGHTNESS = 1;
    public static final int ROTARY_BIG_TYPE_VIDEO_CONTRAST = 2;
    public static final int ROTARY_BIG_TYPE_VIDEO_SATURATION = 3;
    public static final int ROTARY_BIG_TYPE_DISTANCE_WARNER = 4;
    public static final int ROTARY_BIG_TYPE_COLOR = 5;
    private static final int VIDEO_ICON_TYPE_BRIGHTNESS = 1;
    private static final int VIDEO_ICON_TYPE_CONTRAST = 2;
    private static final int VIDEO_ICON_TYPE_SATURATION = 3;
    private boolean showMedialPosition = false;
    private int rotaryType = -1;
    private INode3D colorNode;

    public RotaryBigRendererHigh(RotaryController rotaryController) {
        super(rotaryController);
    }

    protected IWrappedNode3D createNode(IWrappedNode3D iWrappedNode3D, int n) {
        INode2D iNode2D;
        IWrappedNode3D iWrappedNode3D2 = super.createNode(iWrappedNode3D, n);
        if (this.rotaryType == 5 && (iNode2D = this.getEALManager().getProject().getNode2D("Layers/ambient_cake")) != null) {
            this.getEALManager().getMasterRoot().addAuto(iNode2D, -40);
            iNode2D.setVisible(true);
            iNode2D.dispose();
        }
        return iWrappedNode3D2;
    }

    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        int n = this.controller.getX();
        int n2 = this.controller.getY();
        this.node.setPosition(n, n2, 0.0f);
        int n3 = this.controller.getValue();
        if (n3 > this.controller.getMinPosition()) {
            int n4 = this.controller.getStep();
            int n5 = (n3 - this.controller.getMinPosition()) % this.controller.getStep();
            n3 -= n5;
            if (n5 * 2 > n4) {
                n3 += n4;
            }
        }
        float f2 = this.calculateAngle(n3);
        this.setProperty("rotatorBig_rotation", f2);
        float f3 = this.calculateAngle(this.controller.getMedPositon());
        this.setProperty("rotatorBig_scalesCenterRot", f3);
        this.setProperty("rotatorBig_scalesCenterToggle", this.showMedialPosition);
        int n6 = this.controller.getStep();
        if (n6 > 0) {
            int n7 = this.controller.getMaxPosition() - this.controller.getMinPosition() - 1;
            n7 = n7 < 0 ? 0 : n7;
            this.setProperty("rotatorBig_scalesNum", n7 /= n6);
        } else {
            logChannel.log(10000, "RotaryBigRendererHigh#applyProperties: Cannot configure number of scales because the step is 0 (modelId=%1)", (long)this.controller.getModelID());
        }
        float f4 = this.controller.getRenderOpacity();
        f4 = this.controller.isEnabled() ? f4 : f4 * 0.5f;
        this.node.setOpacity(f4);
        this.node.setScale(this.controller.getScaleFactor(), this.controller.getScaleFactor(), 1.0f);
        switch (this.rotaryType) {
            case -1: {
                this.setProperty("rotator_videoIcon", -1.0f);
                this.setProperty("rotator_distanceScales", false);
                this.setProperty("rotator_colorMode", false);
                break;
            }
            case 1: {
                this.setProperty("rotator_videoIcon", 1.0f);
                this.setProperty("rotator_distanceScales", false);
                this.setProperty("rotator_colorMode", false);
                break;
            }
            case 2: {
                this.setProperty("rotator_videoIcon", 2.0f);
                this.setProperty("rotator_distanceScales", false);
                this.setProperty("rotator_colorMode", false);
                break;
            }
            case 3: {
                this.setProperty("rotator_videoIcon", 3.0f);
                this.setProperty("rotator_distanceScales", false);
                this.setProperty("rotator_colorMode", false);
                break;
            }
            case 4: {
                this.setProperty("rotator_distanceScales", this.controller.showDistanceIndicatorLine());
                this.setProperty("rotator_videoIcon", -1.0f);
                this.setProperty("rotator_colorMode", false);
                break;
            }
            case 5: {
                if (this.colorNode == null) {
                    this.colorNode = this.getEALManager().getShortcutNode3D("ambient_cake_controls");
                    this.colorNode.setName("ColorNode");
                }
                this.setProperty("rotator_colorMode", true);
                int n8 = 255;
                this.propertyCache.setProperty((INode)this.colorNode, "ambient_colors", (float)this.controller.getAmbientColorNum());
                for (int i2 = 0; i2 < this.controller.getAmbientColorNum(); ++i2) {
                    int n9 = (this.controller.getColorRowAtIndex(i2).getInteger(0) & 0xFF) << 24;
                    int n10 = (this.controller.getColorRowAtIndex(i2).getInteger(1) & 0xFF) << 16;
                    int n11 = (this.controller.getColorRowAtIndex(i2).getInteger(2) & 0xFF) << 8;
                    int n12 = n9 | n10 | n11 | n8;
                    if (i2 < 10) {
                        this.propertyCache.setColorProperty(this.colorNode, "ambient_color0" + i2, n12);
                        continue;
                    }
                    this.propertyCache.setColorProperty(this.colorNode, "ambient_color" + i2, n12);
                }
                this.setProperty("rotator_videoIcon", -1.0f);
                this.setProperty("rotator_distanceScales", false);
                this.colorNode.setVisible(true);
                break;
            }
        }
    }

    protected String getTemplateNodePath() {
        if (this.rotaryType == 1 || this.rotaryType == 2 || this.rotaryType == 3) {
            return TEMPLATE_NODE_PATH_ROTATOR_MEDIUM;
        }
        return TEMPLATE_NODE_PATH_ROTATOR_BIG;
    }

    protected String getEALNodeName() {
        return EAL_NODE_NAME;
    }

    public void setShowMedialPosition(boolean bl) {
        this.showMedialPosition = bl;
    }

    public int getRotaryType() {
        return this.rotaryType;
    }

    public void setRotaryType(int n) {
        this.rotaryType = n;
    }

    public int getPreferredWidth() {
        return 100;
    }

    public int getPreferredHeight() {
        return 100;
    }

    protected float calculateAngle(int n) {
        if (this.getRotaryType() == 5 && this.controller.getAmbientColorNum() >= 3) {
            float f2 = 270.0f / (float)this.controller.getAmbientColorNum();
            float f3 = 45.0f + f2 / 2.0f;
            float f4 = 315.0f - f2 / 2.0f;
            float f5 = f3;
            if (this.controller.getMaxPosition() > this.controller.getMinPosition()) {
                f5 = f3 + (f4 - f3) / (float)(this.controller.getMaxPosition() - this.controller.getMinPosition()) * (float)(n - this.controller.getMinPosition());
            }
            return f5;
        }
        return super.calculateAngle(n);
    }

    public void disconnect() {
        super.disconnect();
        if (this.colorNode != null) {
            this.colorNode.dispose();
        }
        this.colorNode = null;
    }

    public int getPreferredWidth(HMITerminalImpl hMITerminalImpl) {
        return this.getPreferredWidth();
    }

    public int getPreferredHeight(HMITerminalImpl hMITerminalImpl) {
        return this.getPreferredHeight();
    }
}

