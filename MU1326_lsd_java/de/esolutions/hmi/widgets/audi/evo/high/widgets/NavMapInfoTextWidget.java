/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.intercommunication.MapTooltipConstants;
import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.IconCell;
import de.audi.atip.hmi.model.ResourceLocatorModel;
import de.audi.atip.hmi.model.list.BaseListModel;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.eal.StringUtilityEAL;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.CompositeRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconLabelController;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconLabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MixedListController2;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.NavMapInfoTextWidget$DoubleLineGridCell;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.NavMapInfoTextWidget$GridCell;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.NavMapInfoTextWidget$Spacing;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.NavMapInfoTextWidget$WidgetGridCell;
import de.esolutions.hmi.widgets.audi.evo.widgets.IEmptyableWidget;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LayoutContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.MapOverlayPlateController;
import de.esolutions.hmi.widgets.audi.evo.widgets.WaitAnimController;
import java.util.ArrayList;
import java.util.List;

public class NavMapInfoTextWidget
extends LayoutContainerController
implements MapTooltipConstants {
    public static final int ROLE_PIC_NAV_IMAGE;
    public static final int ROLE_GSV_ICON;
    public static final int ROLE_DISTANCE;
    public static final int ROLE_DIRECTION;
    public static final int ROLE_LABEL_LINE1;
    public static final int ROLE_LABEL_LINE2;
    private static final int BITMAP_GSV_MAN;
    private static final int BITMAP_ONLINE;
    private static final int BITMAP_STACK;
    private static final int BITMAP_GSV_MAN_AND_STACK;
    private static final int BITMAP_GSV_MAN_AND_ONLINE;
    private static final int NUMBER_OF_BITMAPS;
    private static final int BITMAP_POI_ICON;
    private static final int BITMAP_ROADSIGN_ICON;
    private static final int BITMAP_TRAFFIC_ICON;
    private static final int BITMAP_PIC_NAV_ICON;
    public static final int MAX_ICON_HEIGHT;
    public static final int GAP_TOP;
    public static final int GAP_LEFT_RIGHT;
    public static final int MAX_WIDTH_TEXT;
    public static final int MAX_HEIGHT_SINGLE_LINE;
    public static final int MAX_HEIGHT_DOUBLE_LINE;
    public static final int MAX_TOOLTIP_WIDTH_IN_SCREEN_RES_800;
    public static final int MAX_TOOLTIP_WIDTH_IN_SCREEN_RES_1024;
    public static final int MAX_TOOLTIP_WIDTH_IN_SCREEN_RES_1440;
    public static final int PIC_NAV_IMAGE_WIDTH;
    public static final int PIC_NAV_IMAGE_HEIGHT;
    public static final int WIDTH_POI_ICON;
    public static final int WIDTH_GSV_ICON;
    public static final int Y_LABEL1;
    public static final int Y_LABEL2;
    public static final int Y_LABEL1_IF_SINGLE_LINE_VISIBLE;
    public static final int X_TEXT_PIC_NAV;
    public static final int X_DIRECTION_ICON;
    public static final int X_DISTANCE_LABEL;
    public static final int X_LABEL2;
    private int format = -1;
    private IconLabelController poiIcon;
    private IconLabelController roadSignIcon;
    private IconLabelController trafficIcon;
    private MapOverlayPlateController plate;
    private IconController picNavImage;
    private IconController smallIcon;
    private IconController smallIcon2;
    private LabelController label1;
    private LabelController label2;
    private IconController gsvIcon;
    private IconController directionIcon;
    private LabelController distanceLabel;
    private WaitAnimController updatingIcon;
    private String text;
    private int iconIndex;
    private int[] bmpIndex = new int[2];
    private boolean isSetUp = false;
    private boolean showDistanceAndDirection = false;
    private int ydouble;
    private int ySingle;

    @Override
    public void add(AbstractWidget abstractWidget, int n) {
        super.add(abstractWidget);
        switch (n) {
            case 43536: {
                this.picNavImage = (IconController)abstractWidget;
                break;
            }
            case 43537: {
                this.gsvIcon = (IconController)abstractWidget;
                break;
            }
            case 43538: {
                this.distanceLabel = (LabelController)abstractWidget;
                break;
            }
            case 43539: {
                this.directionIcon = (IconController)abstractWidget;
                break;
            }
            case 43540: {
                this.label1 = (LabelController)abstractWidget;
                break;
            }
            case 43541: {
                this.label2 = (LabelController)abstractWidget;
                break;
            }
            default: {
                navMapInfotextLogChannel.log(-2137614336, "NaviMapInfoTextWidget#add role %1 not known.", (long)n);
            }
        }
        if (abstractWidget instanceof MapOverlayPlateController) {
            this.plate = (MapOverlayPlateController)abstractWidget;
        } else if (abstractWidget instanceof WaitAnimController) {
            this.updatingIcon = (WaitAnimController)abstractWidget;
        }
    }

    @Override
    public void connected(InitializationContext initializationContext) {
        this.setUpWidget();
        super.connected(initializationContext);
        this.updateContent();
        this.layoutElements();
    }

    private static IconController createIcon(int[] nArray) {
        IconController iconController = new IconController();
        IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
        iconController.setRenderer(iconRendererHigh);
        iconController.setBitmaps(nArray);
        return iconController;
    }

    private static IconLabelController createIconLabel(IconCell iconCell) {
        IconLabelController iconLabelController = new IconLabelController();
        IconLabelRendererHigh iconLabelRendererHigh = new IconLabelRendererHigh(iconLabelController);
        iconLabelRendererHigh.debug = !NavMapInfoTextWidget.isTarget();
        iconLabelController.setRenderer(iconLabelRendererHigh);
        iconLabelController.setModel(iconCell);
        return iconLabelController;
    }

    public static boolean isTarget() {
        return framework.isTarget();
    }

    @Override
    public void invalidateLayout(AbstractWidget abstractWidget) {
        if (!this.isConnected()) {
            return;
        }
        if (!abstractWidget.equals(this.gsvIcon) && !(abstractWidget instanceof IEmptyableWidget)) {
            return;
        }
        if (abstractWidget instanceof IEmptyableWidget) {
            if (((IEmptyableWidget)((Object)abstractWidget)).hasContent()) {
                navMapInfotextLogChannel.log(-2137614336, "NavMapInfoTextWidget#invalidateLayout relayout because of IconLabel content change!");
                this.layoutElements();
            }
        } else {
            this.processModelUpdateEvent();
        }
    }

    private void layoutElements() {
        NavMapInfoTextWidget$GridCell navMapInfoTextWidget$GridCell;
        int n;
        if (this.label1 == null || this.label2 == null || this.gsvIcon == null || this.directionIcon == null || this.distanceLabel == null || this.picNavImage == null) {
            return;
        }
        this.gsvIcon.setOnScreen(this.format != 2);
        ArrayList arrayList = new ArrayList();
        StringUtilityEAL stringUtilityEAL = (StringUtilityEAL)this.terminal.getStringUtility();
        stringUtilityEAL.setCurrentFont(((CompositeRendererHigh)this.renderer).getInheritedFont());
        List list = null;
        int n2 = -1;
        if (this.text != null) {
            list = stringUtilityEAL.wrapOnLineBreak(this.text, '\n');
            n2 = list.size();
        }
        if (list != null) {
            this.label1.setText((String)list.get(0));
            if (n2 >= 2) {
                this.label2.setText((String)list.get(1));
            } else {
                this.label2.setText("");
            }
        }
        navMapInfotextLogChannel.log(-2137614336, "NavMapInfoTextWidget#layoutElements numberOfLine = %3, text1 = %1, text2 = %2.", (Object)this.label1.getText(), (Object)this.label2.getText(), (long)n2);
        NavMapInfoTextWidget$DoubleLineGridCell navMapInfoTextWidget$DoubleLineGridCell = new NavMapInfoTextWidget$DoubleLineGridCell();
        navMapInfoTextWidget$DoubleLineGridCell.line1 = new NavMapInfoTextWidget$WidgetGridCell(this.label1);
        navMapInfoTextWidget$DoubleLineGridCell.line2 = new NavMapInfoTextWidget$WidgetGridCell(this.label2);
        if (this.showDistanceAndDirection) {
            this.distanceLabel.setVisible(true);
            this.directionIcon.setVisible(true);
        } else {
            this.distanceLabel.setVisible(false);
            this.directionIcon.setVisible(false);
        }
        this.poiIcon.setVisible(this.format == 1);
        this.roadSignIcon.setVisible(this.format == 2 && (this.roadSignIcon.getID() != -1 || !NavMapInfoTextWidget.isTarget()));
        this.trafficIcon.setVisible(this.format == 2 && (this.trafficIcon.getID() != -1 || !NavMapInfoTextWidget.isTarget()));
        this.label1.setVisible(n2 > 0);
        this.label2.setVisible(n2 > 1);
        this.smallIcon.setVisible(false);
        if (this.bmpIndex[1] == -1 && this.bmpIndex[0] != 0) {
            this.bmpIndex[1] = this.bmpIndex[0];
        }
        this.smallIcon2.setValue(this.bmpIndex[1]);
        this.smallIcon2.setVisible(this.bmpIndex[1] != -1);
        this.picNavImage.setVisible(this.format == 3);
        switch (this.format) {
            case -1: {
                break;
            }
            case 0: {
                NavMapInfoTextWidget$DoubleLineGridCell navMapInfoTextWidget$DoubleLineGridCell2 = new NavMapInfoTextWidget$DoubleLineGridCell();
                navMapInfoTextWidget$DoubleLineGridCell2.line1 = new NavMapInfoTextWidget$WidgetGridCell(this.gsvIcon, 17, 2);
                navMapInfoTextWidget$DoubleLineGridCell2.line2 = new NavMapInfoTextWidget$WidgetGridCell(this.smallIcon2, this.smallIcon2.getPreferredWidth(), 2);
                arrayList.add(new NavMapInfoTextWidget$Spacing(9));
                arrayList.add(navMapInfoTextWidget$DoubleLineGridCell);
                arrayList.add(new NavMapInfoTextWidget$Spacing(9));
                arrayList.add(navMapInfoTextWidget$DoubleLineGridCell2);
                arrayList.add(new NavMapInfoTextWidget$Spacing(9));
                break;
            }
            case 1: {
                arrayList.add(new NavMapInfoTextWidget$Spacing(9));
                arrayList.add(new NavMapInfoTextWidget$WidgetGridCell(this.poiIcon));
                arrayList.add(new NavMapInfoTextWidget$Spacing(9));
                arrayList.add(navMapInfoTextWidget$DoubleLineGridCell);
                arrayList.add(new NavMapInfoTextWidget$Spacing(9));
                arrayList.add(new NavMapInfoTextWidget$WidgetGridCell(this.gsvIcon, 17));
                arrayList.add(new NavMapInfoTextWidget$Spacing(9));
                break;
            }
            case 2: {
                NavMapInfoTextWidget$DoubleLineGridCell navMapInfoTextWidget$DoubleLineGridCell2 = new NavMapInfoTextWidget$DoubleLineGridCell();
                navMapInfoTextWidget$DoubleLineGridCell2.line1 = new NavMapInfoTextWidget$WidgetGridCell(this.roadSignIcon, this.roadSignIcon.getPreferredWidth(), 2);
                navMapInfoTextWidget$DoubleLineGridCell2.line2 = new NavMapInfoTextWidget$WidgetGridCell(this.trafficIcon, this.trafficIcon.getPreferredWidth(), 2);
                arrayList.add(new NavMapInfoTextWidget$Spacing(5));
                arrayList.add(navMapInfoTextWidget$DoubleLineGridCell2);
                arrayList.add(new NavMapInfoTextWidget$Spacing(9));
                arrayList.add(navMapInfoTextWidget$DoubleLineGridCell);
                arrayList.add(new NavMapInfoTextWidget$Spacing(25));
                break;
            }
            case 3: {
                arrayList.add(new NavMapInfoTextWidget$Spacing(8));
                arrayList.add(new NavMapInfoTextWidget$WidgetGridCell(this.picNavImage, 73));
                arrayList.add(new NavMapInfoTextWidget$Spacing(9));
                arrayList.add(navMapInfoTextWidget$DoubleLineGridCell);
                arrayList.add(new NavMapInfoTextWidget$Spacing(9));
                arrayList.add(new NavMapInfoTextWidget$WidgetGridCell(this.gsvIcon, 17));
                arrayList.add(new NavMapInfoTextWidget$Spacing(9));
                break;
            }
            default: {
                navMapInfotextLogChannel.log(-2137614336, "NavMapInfoTextWidget#layoutElements Format %1 is not valid.", (long)this.format);
            }
        }
        int n3 = 0;
        int n4 = arrayList.size();
        for (n = 0; n < n4; ++n) {
            navMapInfoTextWidget$GridCell = (NavMapInfoTextWidget$GridCell)arrayList.get(n);
            n3 += navMapInfoTextWidget$GridCell.getDesiredWidth();
            navMapInfotextLogChannel.log(-2137614336, "NavMapInfoTextWidget#layoutElements cell %1 preferredWidth = %2", (long)n, (long)navMapInfoTextWidget$GridCell.getDesiredWidth());
        }
        navMapInfotextLogChannel.log(-2137614336, "NavMapInfoTextWidget#layoutElements sumOfDesiredWidths = %1", (long)n3);
        for (n = 0; n < n4; ++n) {
            navMapInfoTextWidget$GridCell = (NavMapInfoTextWidget$GridCell)arrayList.get(n);
            navMapInfoTextWidget$GridCell.setAvailableWidth(navMapInfoTextWidget$GridCell.getDesiredWidth());
        }
        int n5 = this.changeMaxTooltipWidthBasedOnResolution();
        int n6 = 0;
        if (n3 > n5) {
            n6 = n3 - n5;
            n3 = n5;
        }
        navMapInfoTextWidget$DoubleLineGridCell.setAvailableWidth(navMapInfoTextWidget$DoubleLineGridCell.getDesiredWidth() - n6);
        int n7 = 0;
        for (n = 0; n < n4; ++n) {
            NavMapInfoTextWidget$GridCell navMapInfoTextWidget$GridCell2 = (NavMapInfoTextWidget$GridCell)arrayList.get(n);
            navMapInfoTextWidget$GridCell2.setXPosition(n7);
            n7 += navMapInfoTextWidget$GridCell2.getAvailableWidth();
        }
        if (this.plate != null) {
            if (!(n2 != 1 || this.smallIcon2.isVisible() && this.gsvIcon.isVisible() || this.format == 3 || this.roadSignIcon.isVisible() && this.trafficIcon.isVisible())) {
                this.plate.setBounds(0, 0, n3, 45);
                if (MixedListController2.isMMIKombi()) {
                    this.setY(this.ySingle);
                }
            } else if (n2 >= 2 || this.smallIcon2.isVisible() && this.gsvIcon.isVisible() || this.format == 3 || this.roadSignIcon.isVisible() && this.trafficIcon.isVisible()) {
                this.plate.setBounds(0, 0, n3, 78);
                if (MixedListController2.isMMIKombi()) {
                    this.setY(this.ydouble);
                }
            }
        }
        this.label1.setY(11);
        if (!this.showDistanceAndDirection && n2 == 1) {
            this.label1.setY(14);
        }
        this.label2.setY(49);
        if (this.directionIcon != null) {
            this.directionIcon.setY(42);
        }
        if (this.distanceLabel != null) {
            this.distanceLabel.setY(51);
        }
        if (this.gsvIcon != null) {
            this.gsvIcon.setY(11);
        }
        if (this.gsvIcon.isVisible()) {
            this.smallIcon2.setY(45);
            if (this.updatingIcon != null) {
                this.updatingIcon.setX(this.gsvIcon.getX() - 1);
                this.updatingIcon.setY(this.gsvIcon.getY());
            }
        } else {
            this.smallIcon2.setY(11);
        }
        this.picNavImage.setY(10);
        this.poiIcon.setY(4);
        this.roadSignIcon.setY(20 - this.roadSignIcon.getPreferredHeight() / 2);
        this.trafficIcon.setY(57 - this.trafficIcon.getPreferredHeight() / 2);
        if (!this.roadSignIcon.isVisible() && !this.label2.isVisible()) {
            this.trafficIcon.setY(20 - this.trafficIcon.getPreferredHeight() / 2);
        }
    }

    private int[] mapIconIndexToBitmapIndex(int n) {
        int n2 = -1;
        int n3 = -1;
        if (0 <= n && n <= 2) {
            n2 = n;
        } else if (n == 3) {
            n2 = 0;
            n3 = 2;
        } else if (n == 4) {
            n2 = 0;
            n3 = 1;
        }
        return new int[]{n2, n3};
    }

    @Override
    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        navMapInfotextLogChannel.log(-2137614336, "NavMapInfoTextWidget#processModelUpdateEvent Model-ID %1, Typ %2", (long)modelUpdateEvent.getModelId(), (long)modelUpdateEvent.getUpdateType());
        if (!this.isConnected()) {
            navMapInfotextLogChannel.log(-2137614336, "NavMapInfoTextWidget#processModelUpdateEvent Return: Widget is not connected.");
            return;
        }
        this.processModelUpdateEvent();
    }

    private void processModelUpdateEvent() {
        this.updateContent();
        this.layoutElements();
    }

    private void setUpWidget() {
        if (!this.isSetUp) {
            this.isSetUp = true;
            this.ydouble = this.getY();
            this.ySingle = this.ydouble + 78 - 45;
            this.poiIcon = NavMapInfoTextWidget.createIconLabel(null);
            this.roadSignIcon = NavMapInfoTextWidget.createIconLabel(null);
            this.trafficIcon = NavMapInfoTextWidget.createIconLabel(null);
            this.smallIcon = NavMapInfoTextWidget.createIcon(this.getBitmapIndices());
            this.smallIcon2 = NavMapInfoTextWidget.createIcon(this.getBitmapIndices());
            super.add(this.poiIcon);
            super.add(this.roadSignIcon);
            super.add(this.trafficIcon);
            super.add(this.smallIcon);
            super.add(this.smallIcon2);
            if (!NavMapInfoTextWidget.isTarget()) {
                this.poiIcon.setBitmaps(new int[]{this.getBitmap(3)});
                this.roadSignIcon.setBitmaps(new int[]{this.getBitmap(4)});
                this.trafficIcon.setBitmaps(new int[]{this.getBitmap(5)});
                this.picNavImage.setBitmaps(new int[]{this.getBitmap(6)});
            }
            this.poiIcon.setVisible(false);
            this.roadSignIcon.setVisible(false);
            this.trafficIcon.setVisible(false);
            if (this.picNavImage != null) {
                this.picNavImage.setVisible(false);
                this.picNavImage.setBounds(0, 0, 73, 56);
                IconRendererHigh iconRendererHigh = (IconRendererHigh)this.picNavImage.getRenderer();
                iconRendererHigh.setScaleMode(3);
            }
        }
    }

    @Override
    public void setVisible(boolean bl) {
        super.setVisible(bl);
    }

    private void updateContent() {
        navMapInfotextLogChannel.log(-2137614336, "NavMapInfoTextWidget#updateContent");
        if (this.model instanceof BaseListModel) {
            EvoListRow evoListRow = ((BaseListModel)this.model).getRow(0);
            if (evoListRow == null) {
                navMapInfotextLogChannel.log(-2137614336, "NavMapInfoTextWidget#updateContent List row is null.");
                return;
            }
            if (evoListRow.getColumnCount() != 6) {
                navMapInfotextLogChannel.log(-2137614336, "NavMapInfoTextWidget#updateContent Number of model columns is NOK: %1", (long)evoListRow.getColumnCount());
                return;
            }
            this.format = (Integer)evoListRow.getCell(0);
            this.text = (String)evoListRow.getCell(1);
            if (NavMapInfoTextWidget.isTarget()) {
                this.poiIcon.setModel(evoListRow.getCell(2));
                this.poiIcon.processModelUpdateEvent(null);
                this.roadSignIcon.setModel(evoListRow.getCell(3));
                this.roadSignIcon.processModelUpdateEvent(null);
                this.trafficIcon.setModel(evoListRow.getCell(4));
                this.trafficIcon.processModelUpdateEvent(null);
            }
            this.iconIndex = (Integer)evoListRow.getCell(5);
            this.bmpIndex = this.mapIconIndexToBitmapIndex(this.iconIndex);
            this.smallIcon.setValue(this.bmpIndex[0]);
            this.smallIcon2.setValue(this.bmpIndex[1]);
            if (this.format == -1) {
                ResourceLocatorModel resourceLocatorModel = (ResourceLocatorModel)this.picNavImage.getModel();
                resourceLocatorModel.setResourceLocator(new HMIResourceLocator(-1));
            }
            navMapInfotextLogChannel.log(-2137614336, "NavMapInfoTextWidget#updateContent Text = %1, format = %2", (Object)this.text, (long)this.format);
        } else {
            navMapInfotextLogChannel.log(-2137614336, "NavMapInfoTextWidget#updateContent wrong model");
        }
    }

    private int getScreenResolution() {
        return framework.getScreenRes();
    }

    private int changeMaxTooltipWidthBasedOnResolution() {
        int n = 0;
        int n2 = this.getScreenResolution();
        switch (n2) {
            case 1: {
                n = 390;
                break;
            }
            case 2: {
                n = 482;
                break;
            }
            case 4: {
                n = 497;
                break;
            }
            default: {
                navMapInfotextLogChannel.log(10000, "NavMapInfoTextWidget#screen resolution is wrong");
            }
        }
        return n;
    }
}

