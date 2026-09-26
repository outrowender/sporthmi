/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.metrics.Pressure;
import de.audi.atip.metrics.Temperature;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DImage;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DText;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.TyrePressureController;
import java.util.HashMap;

public class TyrePressureRendererHigh
extends AbstractRendererHigh {
    private final TyrePressureController controller;
    private IWrappedNode3D rootNode;
    private IWrappedNode3DImage[] images;
    private IWrappedNode3DText[] texts;
    private int colorRed;
    private int colorYellow;
    private int colorGreen;
    private int colorWhite;
    private int[] stateColors;
    private HashMap tyreNodeMap = new HashMap();
    private static final String TYRE_PRESSURE_FL;
    private static final String TYRE_PRESSURE_RL;
    private static final String TYRE_PRESSURE_FR;
    private static final String TYRE_PRESSURE_RR;
    private static final String TYRE_TEMP_FL;
    private static final String TYRE_TEMP_RL;
    private static final String TYRE_TEMP_FR;
    private static final String TYRE_TEMP_RR;
    private boolean resourcesLoaded;

    public TyrePressureRendererHigh(TyrePressureController tyrePressureController) {
        this.controller = tyrePressureController;
    }

    private void createNodes(RedrawContextHigh redrawContextHigh) {
        this.colorRed = EALManager.createColorCode(65279);
        this.colorYellow = EALManager.createColorCode(637462015);
        this.colorGreen = EALManager.createColorCode(1105348607);
        this.colorWhite = EALManager.createColorCode(-1);
        this.stateColors = new int[]{this.colorGreen, this.colorYellow, this.colorRed, this.colorWhite};
        if (this.rootNode == null) {
            this.rootNode = this.getEALManager().createNode3D(redrawContextHigh.parentNode, EALManager.createNodeName("TyrePressureRootNode", this), this.controller.getWidth(), this.controller.getHeight());
        }
        if (this.images == null) {
            this.images = new IWrappedNode3DImage[9];
            this.texts = new IWrappedNode3DText[8];
            this.images[0] = this.getEALManager().createImage3D(this.rootNode, EALManager.createNodeName("TyrePressureCar", this), this.getTextureDescription(this.controller.getPictureIndexCar(), true), 0, true, (Object)this);
            this.images[0].setShouldFlipBack(false);
            int n = Math.round(this.images[0].getX() + this.images[0].getWidth() / 2.0f);
            int n2 = this.controller.getAxleWidth() / 2;
            int n3 = n - n2 + this.controller.getLeftTyreOffset();
            int n4 = n + n2 + this.controller.getRightTyreOffset();
            int n5 = this.controller.getPictureIndexLine();
            this.images[1] = this.getEALManager().createImage3D(this.rootNode, EALManager.createNodeName("TyrePressureWheelFR", this), this.getTextureDescription(this.controller.getPictureIndexWheelFront(), true), 0, true, (Object)this);
            this.images[1].setPosition(n4, this.controller.getFrontAxleYPosition(), 0.0f);
            this.images[2] = this.getEALManager().createImage3D(this.rootNode, EALManager.createNodeName("TyrePressureLine", this), this.getTextureDescription(n5, true), 0, true, (Object)this);
            this.images[2].setPosition(this.images[1].getX() - 1.0f + this.images[1].getWidth(), (float)Math.round(this.images[1].getHeight() / 2.0f) + this.images[1].getY() - 1.0f, 0.0f);
            this.images[3] = this.getEALManager().createImage3D(this.rootNode, EALManager.createNodeName("TyrePressureWheelFL", this), this.getTextureDescription(this.controller.getPictureIndexWheelFront(), true), 0, true, (Object)this);
            this.images[3].setPosition((float)n3 - this.images[3].getWidth(), this.controller.getFrontAxleYPosition(), 0.0f);
            this.images[4] = this.getEALManager().createImage3D(this.rootNode, EALManager.createNodeName("TyrePressureLine", this), this.getTextureDescription(n5, true), 0, true, (Object)this);
            this.images[4].setPosition(this.images[3].getX() + 1.0f - this.images[4].getWidth(), (float)Math.round(this.images[3].getHeight() / 2.0f) + this.images[3].getY() - 1.0f, 0.0f);
            this.images[5] = this.getEALManager().createImage3D(this.rootNode, EALManager.createNodeName("TyrePressureWheelRR", this), this.getTextureDescription(this.controller.getPictureIndexWheelBack(), true), 0, true, (Object)this);
            this.images[5].setPosition(n4, this.controller.getRearAxleYPosition(), 0.0f);
            this.images[6] = this.getEALManager().createImage3D(this.rootNode, EALManager.createNodeName("TyrePressureLine", this), this.getTextureDescription(n5, true), 0, true, (Object)this);
            this.images[6].setPosition(this.images[5].getX() - 1.0f + this.images[5].getWidth(), (float)Math.round(this.images[5].getHeight() / 2.0f) + this.images[5].getY() - 1.0f, 0.0f);
            this.images[7] = this.getEALManager().createImage3D(this.rootNode, EALManager.createNodeName("TyrePressureWheelRL", this), this.getTextureDescription(this.controller.getPictureIndexWheelBack(), true), 0, true, (Object)this);
            this.images[7].setPosition((float)n3 - this.images[7].getWidth(), this.controller.getRearAxleYPosition(), 0.0f);
            this.images[8] = this.getEALManager().createImage3D(this.rootNode, EALManager.createNodeName("TyrePressureLine", this), this.getTextureDescription(n5, true), 0, true, (Object)this);
            this.images[8].setPosition(this.images[7].getX() + 1.0f - this.images[8].getWidth(), (float)Math.round(this.images[7].getHeight() / 2.0f) + this.images[7].getY() - 1.0f, 0.0f);
        }
        this.resourcesLoaded = true;
    }

    private void applyChanges(RedrawContextHigh redrawContextHigh) {
        String string;
        String string2;
        int n;
        int[] nArray = this.controller.getTyrePressure();
        int[] nArray2 = this.controller.getTyreTemperature();
        int[] nArray3 = this.controller.getTyreState();
        int n2 = this.controller.getPressureUnit();
        int n3 = this.controller.getTemperatureUnit();
        for (n = 0; n <= 3; ++n) {
            string2 = this.calculatePressureText(n2, nArray[n]);
            string = "";
            if (string2 == null) continue;
            if (nArray3[n] == 3) {
                string2 = "---";
            }
            if (this.texts[n] == null) {
                this.texts[n] = this.getEALManager().createText3D(this.rootNode, EALManager.createNodeName("tyrePressureText", this), string2, redrawContextHigh.getCurrentFont());
            } else {
                this.texts[n].setText(string2, redrawContextHigh.getCurrentFont());
            }
            this.texts[n].getTextNode().setColor(this.stateColors[nArray3[n]]);
            this.images[(n + 1) * 2 - 1].getImageNode().setModulateColor(this.stateColors[nArray3[n]]);
            this.images[(n + 1) * 2].getImageNode().setModulateColor(this.stateColors[nArray3[n]]);
            if (n == 1 || n == 3) {
                string = n == 1 ? "TYRE_PRESSURE_FL" : "TYRE_PRESSURE_RL";
                this.texts[n].setPosition(this.images[(n + 1) * 2].getX(), this.images[(n + 1) * 2].getY() - 4161, 0.0f);
            } else {
                string = n == 2 ? "TYRE_PRESSURE_FR" : "TYRE_PRESSURE_RR";
                this.texts[n].setPosition(this.images[(n + 1) * 2].getX() + (this.images[2].getWidth() - this.texts[n].getWidth()), this.images[(n + 1) * 2].getY() - 4161, 0.0f);
            }
            if (!this.controller.shouldTextsBeBackmirrored()) continue;
            this.mirror(this.texts[n], string);
        }
        for (n = 4; n <= 7; ++n) {
            Temperature temperature;
            float f2;
            string2 = String.valueOf(nArray2[n - 4]);
            string = "";
            if (n3 == 2) {
                f2 = Math.round(nArray2[n - 4] / 2) * 2;
                temperature = new Temperature(f2, n3);
                temperature.setUseInstanceUnit(true);
                string2 = temperature.format(n3, 32);
            } else {
                f2 = nArray2[n - 4];
                temperature = new Temperature(f2, n3);
                temperature.setUseInstanceUnit(true);
                string2 = temperature.format(n3, 32);
            }
            if (nArray3[n - 4] == 3) {
                string2 = "---";
            }
            if (this.texts[n] == null) {
                this.texts[n] = this.getEALManager().createText3D(this.rootNode, EALManager.createNodeName("typePressureTemperatureText", this), string2, redrawContextHigh.getCurrentFont());
            } else {
                this.texts[n].setText(string2, redrawContextHigh.getCurrentFont());
            }
            this.texts[n].getTextNode().setColor(this.colorWhite);
            if (n == 5 || n == 7) {
                string = n == 5 ? "TYRE_TEMP_FL" : "TYRE_TEMP_RL";
                this.texts[n].setPosition(this.images[(n - 3) * 2].getX(), this.images[(n - 3) * 2].getY() + this.texts[n].getHeight() + 1.0f, 0.0f);
            } else {
                string = n == 6 ? "TYRE_TEMP_FR" : "TYRE_TEMP_RR";
                this.texts[n].setPosition(this.images[(n - 3) * 2].getX() + (this.images[2].getWidth() - this.texts[n].getWidth()), this.images[(n - 3) * 2].getY() + this.texts[n].getHeight() + 1.0f, 0.0f);
            }
            this.mirror(this.texts[n], string);
        }
    }

    public String calculatePressureText(int n, int n2) {
        switch (n) {
            case 1: {
                float f2 = (float)n2 * -842216387;
                Pressure pressure = new Pressure(f2, n);
                pressure.setUseInstanceUnit(true);
                return pressure.format();
            }
            case 2: {
                float f3 = (float)Math.round((float)n2 / 2.0f / 63) * 63;
                Pressure pressure = new Pressure(f3, n);
                pressure.setUseInstanceUnit(true);
                return pressure.format();
            }
            case 3: {
                float f4 = n2 * 10;
                Pressure pressure = new Pressure(f4, n);
                pressure.setUseInstanceUnit(true);
                return pressure.format();
            }
        }
        return null;
    }

    @Override
    public void render(RedrawContext redrawContext) {
        if (!this.controller.isVisible() || !this.controller.isOnScreen()) {
            if (this.rootNode != null) {
                this.rootNode.setVisible(false);
            }
            return;
        }
        RedrawContextHigh redrawContextHigh = (RedrawContextHigh)redrawContext;
        if (!this.resourcesLoaded) {
            this.createNodes(redrawContextHigh);
        }
        if (this.rootNode != null && this.rootNode.isValid()) {
            this.rootNode.setPosition(this.controller.getX(), this.controller.getY(), 0.0f);
            this.applyChanges(redrawContextHigh);
            this.rootNode.setVisible(true);
        }
    }

    @Override
    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    @Override
    public void disconnect() {
        int n;
        super.disconnect();
        if (this.images != null) {
            for (n = 0; n < this.images.length; ++n) {
                this.getEALManager().destroy(this.images[n]);
            }
            this.images = null;
        }
        if (this.texts != null) {
            for (n = 0; n < this.texts.length; ++n) {
                this.getEALManager().destroy(this.texts[n]);
            }
            this.texts = null;
        }
        if (this.rootNode != null) {
            this.getEALManager().destroy(this.rootNode);
            this.rootNode = null;
        }
        this.resourcesLoaded = false;
    }

    protected void mirror(IWrappedNode3D iWrappedNode3D, String string) {
        boolean bl;
        boolean bl2;
        boolean bl3;
        boolean bl4 = bl3 = iWrappedNode3D != this.tyreNodeMap.get(string);
        if (bl3) {
            this.nodeIsMirrored = false;
        }
        boolean bl5 = bl2 = !(bl = this.isLTR()) && this.controller.shouldTextsBeBackmirrored();
        if (bl2) {
            iWrappedNode3D.setPosition(bl ? iWrappedNode3D.getX() : iWrappedNode3D.getX() - iWrappedNode3D.getWidth(), iWrappedNode3D.getY(), iWrappedNode3D.getZ());
        }
        if (bl2 && !this.nodeIsMirrored) {
            iWrappedNode3D.setScale(bl ? iWrappedNode3D.getScaleX() : -iWrappedNode3D.getScaleX(), iWrappedNode3D.getScaleY(), iWrappedNode3D.getScaleZ());
            this.nodeIsMirrored = true;
            this.tyreNodeMap.put(string, iWrappedNode3D);
        }
    }
}

