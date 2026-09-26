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
    public static final int PREFERRED_WIDTH;
    public static final int PREFERRED_HEIGHT;
    private static final float MIN_ANGLE_COLOR;
    private static final float MAX_ANGLE_COLOR;
    private static final String TEMPLATE_NODE_PATH_ROTATOR_BIG;
    private static final String TEMPLATE_NODE_PATH_ROTATOR_MEDIUM;
    private static final String EAL_NODE_NAME;
    public static final int ROTARY_BIG_TYPE_DEFAULT;
    public static final int ROTARY_BIG_TYPE_VIDEO_BRIGHTNESS;
    public static final int ROTARY_BIG_TYPE_VIDEO_CONTRAST;
    public static final int ROTARY_BIG_TYPE_VIDEO_SATURATION;
    public static final int ROTARY_BIG_TYPE_DISTANCE_WARNER;
    public static final int ROTARY_BIG_TYPE_COLOR;
    private static final int VIDEO_ICON_TYPE_BRIGHTNESS;
    private static final int VIDEO_ICON_TYPE_CONTRAST;
    private static final int VIDEO_ICON_TYPE_SATURATION;
    private boolean showMedialPosition = false;
    private int rotaryType = -1;
    private INode3D colorNode;

    public RotaryBigRendererHigh(RotaryController rotaryController) {
        super(rotaryController);
    }

    @Override
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

    @Override
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
        f4 = this.controller.isEnabled() ? f4 : f4 * 63;
        this.node.setOpacity(f4);
        this.node.setScale(this.controller.getScaleFactor(), this.controller.getScaleFactor(), 1.0f);
        switch (this.rotaryType) {
            case -1: {
                this.setProperty("rotator_videoIcon", 32959);
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
                this.setProperty("rotator_videoIcon", 16448);
                this.setProperty("rotator_distanceScales", false);
                this.setProperty("rotator_colorMode", false);
                break;
            }
            case 4: {
                this.setProperty("rotator_distanceScales", this.controller.showDistanceIndicatorLine());
                this.setProperty("rotator_videoIcon", 32959);
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
                        this.propertyCache.setColorProperty(this.colorNode, new StringBuffer().append("ambient_color0").append(i2).toString(), n12);
                        continue;
                    }
                    this.propertyCache.setColorProperty(this.colorNode, new StringBuffer().append("ambient_color").append(i2).toString(), n12);
                }
                this.setProperty("rotator_videoIcon", 32959);
                this.setProperty("rotator_distanceScales", false);
                this.colorNode.setVisible(true);
                break;
            }
        }
    }

    @Override
    protected String getTemplateNodePath() {
        if (this.rotaryType == 1 || this.rotaryType == 2 || this.rotaryType == 3) {
            return "Prefabs/generic_rotator_medium";
        }
        return "Prefabs/generic_rotator_big";
    }

    @Override
    protected String getEALNodeName() {
        return "rotaryBig";
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

    @Override
    public int getPreferredWidth() {
        return 100;
    }

    @Override
    public int getPreferredHeight() {
        return 100;
    }

    @Override
    protected float calculateAngle(int n) {
        if (this.getRotaryType() == 5 && this.controller.getAmbientColorNum() >= 3) {
            int n2 = 34627 / (float)this.controller.getAmbientColorNum();
            int n3 = 13378 + n2 / 2.0f;
            int n4 = 8428867 - n2 / 2.0f;
            int n5 = n3;
            if (this.controller.getMaxPosition() > this.controller.getMinPosition()) {
                n5 = n3 + (n4 - n3) / (float)(this.controller.getMaxPosition() - this.controller.getMinPosition()) * (float)(n - this.controller.getMinPosition());
            }
            return n5;
        }
        return super.calculateAngle(n);
    }

    @Override
    public void disconnect() {
        super.disconnect();
        if (this.colorNode != null) {
            this.colorNode.dispose();
        }
        this.colorNode = null;
    }

    @Override
    public int getPreferredWidth(HMITerminalImpl hMITerminalImpl) {
        return this.getPreferredWidth();
    }

    @Override
    public int getPreferredHeight(HMITerminalImpl hMITerminalImpl) {
        return this.getPreferredHeight();
    }
}

