/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.hmi.model.list.TiledListModelGUI;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.audi.atip.hmi.view.IKzbMergeListener;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.base.widgets.ModelStubController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IOPSRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.OPSController$ParkingHoseWidgetData;
import de.esolutions.hmi.widgets.audi.evo.widgets.OPSSectorController;
import de.esolutions.hmi.widgets.audi.evo.widgets.PLAController;

public class OPSController
extends AbstractWidgetController
implements IKzbMergeListener {
    public static final int SECTOR_FRONT_LEFT_INNER;
    public static final int SECTOR_FRONT_LEFT_OUTER;
    public static final int SECTOR_FRONT_RIGHT_INNER;
    public static final int SECTOR_FRONT_RIGHT_OUTER;
    public static final int SECTOR_REAR_LEFT_INNER;
    public static final int SECTOR_REAR_LEFT_OUTER;
    public static final int SECTOR_REAR_RIGHT_INNER;
    public static final int SECTOR_REAR_RIGHT_OUTER;
    public static final int SECTOR_SIDE_LEFT_FRONT_INNER;
    public static final int SECTOR_SIDE_LEFT_FRONT_OUTER;
    public static final int SECTOR_SIDE_LEFT_BACK_INNER;
    public static final int SECTOR_SIDE_LEFT_BACK_OUTER;
    public static final int SECTOR_SIDE_RIGHT_FRONT_INNER;
    public static final int SECTOR_SIDE_RIGHT_FRONT_OUTER;
    public static final int SECTOR_SIDE_RIGHT_BACK_INNER;
    public static final int SECTOR_SIDE_RIGHT_BACK_OUTER;
    public static final int NUM_SECTORS;
    private static final int INVISIBLE_SECTOR_VALUE;
    public static final int TOPVIEW_ERROR_NONE;
    public static final int TOPVIEW_ERROR_MIRROR;
    public static final int TOPVIEW_ERROR_DOOR;
    private OPSSectorController[] sectorControllers = new OPSSectorController[16];
    private int[] sectorValues = new int[16];
    private boolean[] sectorHighlights = new boolean[16];
    private int rctaLeftStatus;
    private int rctaRightStatus;
    private boolean topViewActive;
    private int topViewErrorLeft;
    private int topViewErrorRight;
    private boolean topViewErrorRear;
    private IOPSRenderer renderer;
    private float scaleFactor = 1.0f;
    private boolean dataChanged = true;
    private boolean opsVisible = true;
    private OPSController$ParkingHoseWidgetData parkingHoseData;
    private boolean isPLAWidget;
    private PLAController plaController;
    private boolean pDCFrontStatus;
    private boolean pDCRearStatus;
    private boolean trailerSymbol;
    private boolean brakeSymbol;
    private int pLADrivingDirection;
    private int steeringIntervention;
    private int viewMode;

    @Override
    public IRenderer getRenderer() {
        return this.renderer;
    }

    public void setRenderer(IOPSRenderer iOPSRenderer) {
        this.renderer = iOPSRenderer;
    }

    public void add(AbstractWidget abstractWidget, int n) {
        super.add(abstractWidget);
        if (abstractWidget instanceof ModelStubController) {
            return;
        }
        if (!(abstractWidget instanceof OPSSectorController)) {
            logChannelParking.log(10000, "OPSController#add unsupported child widget type");
        }
        if (n >= 0 && n < 16) {
            this.sectorControllers[n] = (OPSSectorController)abstractWidget;
        } else {
            logChannelParking.log(10000, "OPSController#add unsupported child widget type");
        }
    }

    @Override
    public void setVisible(boolean bl) {
        if (bl) {
            this.setDataChanged();
        }
        this.renderer.setVisible(bl);
        super.setVisible(bl);
    }

    @Override
    public void render(RedrawContext redrawContext) {
        if (this.dataChanged) {
            this.updateData();
            this.dataChanged = false;
        }
        super.render(redrawContext);
    }

    @Override
    protected void initializeWidget() {
        super.initializeWidget();
        this.setDataChanged();
    }

    private int getChoiceModelStubValue(int n, String string) {
        AbstractWidget abstractWidget = this.getChild(n);
        if (abstractWidget == null || !(abstractWidget instanceof ModelStubController)) {
            logChannelParking.log(10000, "OPSController#getChoiceModelStubValue modelStub for %1 not available", (Object)string);
            return 0;
        }
        ModelStubController modelStubController = (ModelStubController)abstractWidget;
        Object object = modelStubController.getModel();
        if (object == null || !(object instanceof ChoiceModelGUI)) {
            logChannelParking.log(10000, "OPSController#getChoiceModelStubValue modelStub for %1 has no ChoiceModel attached", (Object)string);
            return 0;
        }
        return ((ChoiceModelGUI)object).getValue();
    }

    private void getParkingHoseListModelStubValues(int n) {
        AbstractWidget abstractWidget;
        if (this.parkingHoseData == null) {
            this.parkingHoseData = new OPSController$ParkingHoseWidgetData(this);
        }
        if ((abstractWidget = this.getChild(n)) == null || !(abstractWidget instanceof ModelStubController)) {
            logChannelParking.log(10000, "OPSController#getParkingHoseListModelStubValues modelStub for parking hose not available");
            return;
        }
        ModelStubController modelStubController = (ModelStubController)abstractWidget;
        Object object = modelStubController.getModel();
        if (object == null || !(object instanceof TiledListModelGUI)) {
            logChannelParking.log(10000, "OPSController#getParkingHoseListModelStubValues modelStub for parking hose has no ListModel attached");
            return;
        }
        TiledListModelGUI tiledListModelGUI = (TiledListModelGUI)object;
        int n2 = tiledListModelGUI.getIndexForUniqueID(1L);
        this.parkingHoseData.trackDisplay = tiledListModelGUI.getGuiRow(n2).getInteger(0);
        this.parkingHoseData.direction = tiledListModelGUI.getGuiRow(n2).getInteger(1);
        this.parkingHoseData.wheelBase = tiledListModelGUI.getGuiRow(n2).getInteger(2);
        this.parkingHoseData.frontWheelRadius = tiledListModelGUI.getGuiRow(n2).getInteger(3);
        this.parkingHoseData.rearWheelRadius = tiledListModelGUI.getGuiRow(n2).getInteger(4);
        logChannelParking.log(1078071040, "OPSController#getChoiceModelStubValue %1", (Object)this.parkingHoseData);
    }

    private void updateData() {
        for (int i2 = 0; i2 < this.sectorControllers.length; ++i2) {
            if (this.sectorControllers[i2] == null) continue;
            this.sectorValues[i2] = this.sectorControllers[i2].isVisible() ? this.sectorControllers[i2].getValue() : -1;
            this.sectorHighlights[i2] = this.sectorControllers[i2].isHighlighted();
        }
        this.rctaLeftStatus = this.getChoiceModelStubValue(0, "RCTA left");
        this.rctaRightStatus = this.getChoiceModelStubValue(1, "RCTA right");
        this.topViewErrorLeft = this.getChoiceModelStubValue(2, "topview error left");
        this.topViewErrorRight = this.getChoiceModelStubValue(3, "topview error right");
        this.topViewErrorRear = this.getChoiceModelStubValue(4, "topview error rear") > 0;
        this.topViewActive = this.getChoiceModelStubValue(5, "topview active") == 1;
        this.getParkingHoseListModelStubValues(6);
        this.pDCFrontStatus = this.getChoiceModelStubValue(7, "pDCFrontStatus") > 0;
        boolean bl = this.pDCRearStatus = this.getChoiceModelStubValue(8, "pDCRearStatus") > 0;
        if (this.pDCRearStatus) {
            this.topViewErrorRear = false;
        }
        this.trailerSymbol = this.getChoiceModelStubValue(9, "trailerSymbol") == 1;
        this.brakeSymbol = this.getChoiceModelStubValue(10, "brakeSymbol") == 1;
        this.pLADrivingDirection = this.getChoiceModelStubValue(11, "pLADrivingDirection");
        this.steeringIntervention = this.getChoiceModelStubValue(12, "steeringIntervention");
        if (this.steeringIntervention == 0) {
            this.steeringIntervention = this.getChoiceModelStubValue(13, "araSteeringIntervention");
        }
        this.viewMode = this.getChoiceModelStubValue(14, "viewMode");
        logChannelParking.log(-2137614336, "OPSController#updateData data updated");
    }

    @Override
    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        this.setDataChanged();
        super.processModelUpdateEvent(modelUpdateEvent);
    }

    public int getSectorValue(int n) {
        return this.sectorValues[n];
    }

    public boolean getSectorHighlight(int n) {
        return this.sectorHighlights[n];
    }

    public int getRCTALeftStatus() {
        return this.rctaLeftStatus;
    }

    public int getRCTARightStatus() {
        return this.rctaRightStatus;
    }

    public int getTopViewErrorLeft() {
        return this.topViewErrorLeft;
    }

    public int getTopViewErrorRight() {
        return this.topViewErrorRight;
    }

    public boolean isTopViewErrorRear() {
        return this.topViewErrorRear;
    }

    public boolean isTopViewActive() {
        return this.topViewActive;
    }

    public OPSController$ParkingHoseWidgetData getParkingHoseData() {
        return this.parkingHoseData;
    }

    public void setDataChanged() {
        this.dataChanged = true;
        this.setCompositesDirty(true);
    }

    public void setScaleFactor(float f2) {
        this.scaleFactor = f2;
    }

    public float getScaleFactor() {
        return this.scaleFactor;
    }

    public void setOPSVisible(boolean bl) {
        this.opsVisible = bl;
    }

    public boolean isOPSVisible() {
        if (this.isPLAWidget) {
            if (this.plaController != null && this.plaController.getPLAStatus() != null) {
                return this.getPLAController().getPLAStatus().isSystemActiveOPS();
            }
            return this.opsVisible;
        }
        return this.opsVisible;
    }

    public boolean ispDCFrontStatus() {
        return this.pDCFrontStatus;
    }

    public boolean ispDCRearStatus() {
        return this.pDCRearStatus;
    }

    public boolean isTrailerSymbol() {
        return this.trailerSymbol;
    }

    public boolean isBrakeSymbol() {
        return this.brakeSymbol;
    }

    public int getpLADrivingDirection() {
        return this.pLADrivingDirection;
    }

    public int getSteeringIntervention() {
        return this.steeringIntervention;
    }

    public int getViewMode() {
        return this.viewMode;
    }

    public void setPLAModeActive(boolean bl) {
        this.isPLAWidget = bl;
        if (bl) {
            this.plaController = new PLAController(this);
            this.plaController.initTracker();
        }
    }

    public PLAController getPLAController() {
        return this.plaController;
    }

    public boolean isPLAModeActive() {
        return this.isPLAWidget;
    }

    @Override
    public void keyTurned(WheelButtonEvent wheelButtonEvent) {
        if (!this.isPLAModeActive()) {
            return;
        }
        this.plaController.keyTurned(wheelButtonEvent);
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (!this.isPLAModeActive()) {
            return;
        }
        this.plaController.keyPressed(keyEvent);
    }

    @Override
    public String getWidgetName() {
        return this.getClassName();
    }

    @Override
    public void mergeFinished(String string) {
        this.renderer.finalizeAsyncMerge(string);
        logChannelParking.log(-2137614336, "OPSController#mergeFinished: opsKZB merge finished. OpsPopup will updating now.");
        this.setDataChanged();
        this.triggerRepaint();
    }
}

