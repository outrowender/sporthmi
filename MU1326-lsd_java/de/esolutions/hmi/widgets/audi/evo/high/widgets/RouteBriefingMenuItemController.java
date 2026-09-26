/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.hmi.intercommunication.RouteSelectionConstants;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.LongListCell;
import de.audi.atip.hmi.modelaccess.ListModelGUI;
import de.audi.atip.i18n.ILanguageManager;
import de.audi.atip.metrics.DateMetric;
import de.audi.atip.metrics.Distance;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedFont;
import de.esolutions.hmi.widgets.audi.evo.LineElement;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.CompositeRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.LabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.TextDescriptorLabelRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.WaitAnimController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import java.util.ArrayList;
import java.util.Date;

public class RouteBriefingMenuItemController
extends MenuItemController
implements RouteSelectionConstants {
    private static final int TABULATOR;
    private static final int HEIGHT;
    private static final int HEIGHT_NO_TRAFFIC;
    private static final int WIDTH;
    private static final int HEIGHT_ASIA;
    private static final int HEIGHT_ASIA_NO_TRAFFIC;
    private static final String DEFAULT_TEXT;
    private static final int BITMAP_INDEX_ICON_ROUTE1;
    private static final int BITMAP_INDEX_ICON_ROUTE2;
    private static final int BITMAP_INDEX_ICON_ROUTE3;
    private static final int BITMAP_INDEX_ICON_TRAFFIC;
    private static final int BITMAP_INDEX_ICON_CLOSED_ROAD;
    private static final int BITMAP_INDEX_ICON_TRAFFIC_NAR;
    private static final int BITMAP_INDEX_ICON_CLOSED_ROAD_NAR;
    Distance dta;
    DateMetric eta;
    DateMetric trafficOffset;
    private IconController iconRoute;
    private IconController iconTraffic;
    private LabelController labelDTA;
    private LabelController labelETA;
    private LabelController labelTraffic;
    private LabelController labelRouteTag;
    private WaitAnimController updatingIcon;
    private int selectionNumber = -1;
    private boolean isSetUp = false;
    private ListCell[] listCells = null;
    private int trafficState = 0;

    @Override
    public void add(AbstractWidget abstractWidget) {
        if (abstractWidget instanceof WaitAnimController) {
            this.updatingIcon = (WaitAnimController)abstractWidget;
        } else {
            super.add(abstractWidget);
        }
    }

    private void add1(AbstractWidget abstractWidget) {
        super.add(abstractWidget);
    }

    @Override
    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
        if (!this.isSetUp) {
            this.setupWidgetsAndLayout();
            this.isSetUp = true;
        }
        this.setWithTraffic(0);
        this.updateContent();
        this.updateDimension();
    }

    private static IconController createIcon(int[] nArray, int[] nArray2, int n, int n2, int n3, int n4) {
        IconController iconController = new IconController();
        IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
        iconController.setRenderer(iconRendererHigh);
        if (nArray != null) {
            int[] nArray3 = new int[nArray2.length];
            for (int i2 = 0; i2 < nArray3.length; ++i2) {
                int n5 = nArray2[i2];
                if (n5 >= nArray.length) {
                    sideBarLogChannel.log(10000, "RouteBriefingMenuItemController#createIcon Bitmap with index %1 not available.", (long)n5);
                    break;
                }
                nArray3[i2] = nArray[n5];
            }
            iconController.setBitmaps(nArray3);
        }
        iconController.setBounds(n, n2, n3, n4);
        return iconController;
    }

    private static LabelController createLabel(int[] nArray, int n, int n2, int n3, int n4, int n5, int n6) {
        LabelController labelController = new LabelController();
        labelController.setBounds(n3, n4, n5, n6);
        LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
        labelRendererHigh.setAlignment(n, n2);
        labelController.setRenderer(labelRendererHigh);
        labelController.setTextIds(nArray);
        return labelController;
    }

    private static LabelController createLabelWithTextDescriptorRenderer(Object object, int n, int n2, int n3, int n4) {
        LabelController labelController = new LabelController();
        labelController.setBounds(n, n2, n3, n4);
        TextDescriptorLabelRenderer textDescriptorLabelRenderer = new TextDescriptorLabelRenderer(labelController);
        labelController.setRenderer(textDescriptorLabelRenderer);
        labelController.setModel(object);
        textDescriptorLabelRenderer.setTabulator(111);
        textDescriptorLabelRenderer.setAlignment(20, 4);
        textDescriptorLabelRenderer.setAbbreviateText(true);
        return labelController;
    }

    private int getRouteImageIndex() {
        switch (this.selectionNumber) {
            case 1: {
                return 0;
            }
            case 2: {
                return 1;
            }
            case 3: {
                return 2;
            }
        }
        sideBarLogChannel.log(10000, "RouteBriefingMenuItemController#getFlagImageIndex Invalid selection number %1", (long)this.selectionNumber);
        return -1;
    }

    private boolean isAsiaWrap() {
        return RouteBriefingMenuItemController.isAsia();
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (this.model != null && this.hasState(36) && keyEvent.getKeyCode() == 17) {
            ((ListModelGUI)this.model).itemSelected(RouteBriefingMenuItemController.mapSelectionNumberToRowIndex(this.selectionNumber), 0, this.terminal.getTerminalID());
            keyEvent.consume();
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }

    @Override
    public void keyMoved(JoystickEvent joystickEvent) {
    }

    @Override
    public void keyTurned(WheelButtonEvent wheelButtonEvent) {
    }

    private static int mapSelectionNumberToRowIndex(int n) {
        return n - 1;
    }

    @Override
    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        sideBarLogChannel.log(-2137614336, "RouteBriefingMenuItemController#processModelUpdateEvent %1", (Object)modelUpdateEvent);
        switch (modelUpdateEvent.getUpdateType()) {
            case 1: 
            case 8: 
            case 14: 
            case 16: {
                if (this.model == null) break;
                this.updateContent();
            }
        }
    }

    private void updateDimension() {
        this.setWidth(204);
        int n = this.isAsiaWrap() ? 128 : 98;
        int n2 = this.isAsiaWrap() ? 98 : 68;
        boolean bl = this.trafficState != 0;
        this.setHeight(bl ? n : n2);
        this.setPreferredWidth(204);
        this.setPreferredHeight(bl ? n : n2);
        this.setCompositesDirty(true);
    }

    @Override
    public void setFocused(boolean bl) {
        super.setFocused(bl);
        menuItemLogCh.log(-2137614336, "RouteBriefingMenuItem#setFocused on index = %2. Focused = %1", bl, (long)RouteBriefingMenuItemController.mapSelectionNumberToRowIndex(this.selectionNumber));
        if (bl && this.model != null && this.hasState(36)) {
            ((ListModelGUI)this.model).itemFocused(RouteBriefingMenuItemController.mapSelectionNumberToRowIndex(this.selectionNumber), 0, this.terminal.getTerminalID());
        }
    }

    @Override
    public void setOpacity(float f2) {
        super.setOpacity(f2);
        f2 = !this.isFocused() ? (float)-842249153 : 1.0f;
        if (this.isSetUp) {
            this.iconRoute.setOpacity(f2);
            this.iconTraffic.setOpacity(f2);
            this.labelETA.setOpacity(f2);
            this.labelDTA.setOpacity(f2);
            this.labelTraffic.setOpacity(f2);
            this.iconRoute.setCompositesDirty(true);
            this.iconTraffic.setCompositesDirty(true);
            this.labelETA.setCompositesDirty(true);
            this.labelDTA.setCompositesDirty(true);
            this.labelTraffic.setCompositesDirty(true);
        }
    }

    public void setSelectionNumber(int n) {
        this.selectionNumber = n;
    }

    private void setWithTraffic(int n) {
        if (n == 0) {
            this.iconTraffic.setVisible(false);
            this.labelTraffic.setVisible(false);
        } else if (n == 1) {
            this.iconTraffic.setVisible(true);
            this.labelTraffic.setVisible(true);
            if (!framework.isNar()) {
                this.iconTraffic.setValue(0);
            } else {
                this.iconTraffic.setValue(2);
            }
        } else if (n == 2) {
            this.iconTraffic.setVisible(true);
            this.labelTraffic.setVisible(true);
            if (!framework.isNar()) {
                this.iconTraffic.setValue(1);
            } else {
                this.iconTraffic.setValue(3);
            }
        }
        this.trafficState = n;
        this.updateDimension();
    }

    private void setupWidgetsAndLayout() {
        AbstractWidget abstractWidget;
        this.eta = new DateMetric(new Date(0L), 1);
        this.dta = new Distance(0.0f, 1);
        this.trafficOffset = new DateMetric(new Date(0L), 7);
        int[] nArray = this.getBitmapIndices();
        IWrappedFont[] iWrappedFontArray = ((CompositeRendererHigh)this.getRenderer()).getFonts();
        if (iWrappedFontArray == null) {
            sideBarLogChannel.log(-1601830656, "RouteBriefingMenuItem#setupWidgetsAndLayout No fonts have been set.");
        }
        if (nArray == null) {
            sideBarLogChannel.log(-1601830656, "RouteBriefingMenuItem#setupWidgetsAndLayout No bitmaps have been set.");
        }
        int n = this.isAsiaWrap() ? 30 : 0;
        this.iconRoute = RouteBriefingMenuItemController.createIcon(nArray, new int[]{this.getRouteImageIndex()}, 10, 14, 0, 0);
        this.iconTraffic = RouteBriefingMenuItemController.createIcon(nArray, new int[]{3, 4, 5, 6}, 10, n + 63, 0, 0);
        this.labelETA = RouteBriefingMenuItemController.createLabelWithTextDescriptorRenderer("--:--", 45, n + 40, 155, 100);
        this.labelDTA = RouteBriefingMenuItemController.createLabelWithTextDescriptorRenderer("--:--", 45, n + 10, 155, 100);
        this.labelTraffic = RouteBriefingMenuItemController.createLabelWithTextDescriptorRenderer("--:--", 45, n + 70, 155, 100);
        this.labelTraffic.setVisible(false);
        this.labelDTA.setModel(this.dta);
        this.labelETA.setModel(this.eta);
        this.add(this.iconRoute);
        this.add(this.iconTraffic);
        this.add(this.labelETA);
        this.add(this.labelDTA);
        this.add(this.labelTraffic);
        if (this.updatingIcon != null) {
            this.add1(this.updatingIcon);
        }
        if (this.isAsiaWrap()) {
            this.labelRouteTag = RouteBriefingMenuItemController.createLabel(this.getTextIds(), 3, -1, 47, 11, 150, 50);
            this.add(this.labelRouteTag);
        }
        if ((abstractWidget = this.getParent()) instanceof MenuController) {
            MenuController menuController = (MenuController)abstractWidget;
            menuController.getInitialization().setPersistentLayout(false);
        }
    }

    private void updateContent() {
        sideBarLogChannel.log(-2137614336, "RouteBriefingMenuItemController#updateContent");
        if (this.model != null && this.isSetUp) {
            if (this.listCells == null) {
                this.listCells = new ListCell[((ListModelGUI)this.model).getMaxColumns()];
            }
            if (((ListModelGUI)this.model).getRow(this.selectionNumber - 1, this.listCells)) {
                ListCell listCell;
                long l = ((LongListCell)this.listCells[1]).getValue();
                int n = ((IntegerListCell)this.listCells[0]).getValue();
                boolean bl = false;
                if (7 < this.listCells.length && (listCell = this.listCells[7]) instanceof IntegerListCell) {
                    boolean bl2 = bl = ((IntegerListCell)listCell).getValue() != 1;
                }
                if (this.updatingIcon != null) {
                    this.updatingIcon.setVisible(bl);
                    sideBarLogChannel.log(-2137614336, "RouteBriefingMenuItemController#updateContent Updating-Icon visible = %1", bl);
                }
                this.eta.setDate(l);
                this.dta.setValue((float)n / 31300);
                sideBarLogChannel.log(-2137614336, "RouteBriefingMenuItemController#updateContent ETA = %1, DTA = %2", (Object)this.eta.getFormattedValue(), (Object)this.dta.getFormattedValue());
                this.labelDTA.updateContent();
                this.labelETA.updateContent();
                int n2 = ((IntegerListCell)this.listCells[5]).getValue();
                this.setWithTraffic(n2);
                sideBarLogChannel.log(-2137614336, "RouteBriefingMenuItemController#updateContent Traffic available = %1", (long)n2);
                if (this.trafficState != 0) {
                    ListCell listCell2 = this.listCells[6];
                    if (listCell2 != null) {
                        long l2 = ((LongListCell)this.listCells[6]).getValue();
                        this.trafficOffset.setDate(l2);
                        String[] stringArray = this.trafficOffset.getStringValueAndUnit();
                        String string = this.trafficOffset.getText(58, -1);
                        ArrayList arrayList = new ArrayList();
                        if (this.isKoreanLanguage()) {
                            arrayList.add(new LineElement(stringArray[0], 0, 2));
                            arrayList.add(new LineElement(stringArray[1].trim(), 1, 2));
                            arrayList.add(new LineElement(string, 1));
                            this.updateTrafficLabel(-1, 2, 4, arrayList);
                        } else {
                            arrayList.add(new LineElement(string, 1, 2));
                            arrayList.add(new LineElement(stringArray[0], 0, 2));
                            arrayList.add(new LineElement(stringArray[1].trim(), 1, 1, false));
                            this.updateTrafficLabel(111, 20, 4, arrayList);
                        }
                    } else {
                        sideBarLogChannel.log(10000, "RouteBriefingMenuItemController#updateContent Traffic cell is null.");
                    }
                    this.labelTraffic.setVisible(true);
                } else {
                    this.labelTraffic.setVisible(false);
                }
                if (this.isAsiaWrap()) {
                    boolean bl3 = false;
                    if (8 < this.listCells.length) {
                        ListCell listCell3 = this.listCells[8];
                        if (listCell3 instanceof IntegerListCell) {
                            int n3 = ((IntegerListCell)listCell3).getValue();
                            this.labelRouteTag.setModel(new Integer(n3));
                            this.labelRouteTag.updateContent();
                            bl3 = true;
                            sideBarLogChannel.log(-2137614336, "RouteBriefingMenuItemController#updateContent Current tag is: %1.", (long)n3);
                        } else {
                            sideBarLogChannel.log(10000, "RouteBriefingMenuItemController#updateContent Data type of list cell for route tag is not integer (but %1)", (Object)listCell3);
                        }
                    } else {
                        sideBarLogChannel.log(10000, "RouteBriefingMenuItemController#updateContent List model does not contain a column for the route tag.");
                    }
                    this.labelRouteTag.setOnScreen(bl3);
                }
            } else {
                sideBarLogChannel.log(-2137614336, "RouteBriefingMenuItemController#updateValue couldn't get row: %1", (long)RouteBriefingMenuItemController.mapSelectionNumberToRowIndex(this.selectionNumber));
            }
        }
    }

    public boolean hasLabel() {
        return false;
    }

    public void setHasLabel(boolean bl) {
    }

    private void updateTrafficLabel(int n, int n2, int n3, ArrayList arrayList) {
        TextDescriptorLabelRenderer textDescriptorLabelRenderer = (TextDescriptorLabelRenderer)this.labelTraffic.getRenderer();
        textDescriptorLabelRenderer.setTabulator(n);
        textDescriptorLabelRenderer.setAlignment(n2, n3);
        this.labelTraffic.setLineDescription(arrayList);
        this.labelTraffic.updateContent();
    }

    private boolean isKoreanLanguage() {
        ILanguageManager iLanguageManager;
        IFrameworkAccess iFrameworkAccess = AbstractWidget.framework;
        if (iFrameworkAccess != null && (iLanguageManager = iFrameworkAccess.getLanguageMgr()) != null) {
            return iLanguageManager.getCurrentLanguage("LANG_COMPONENT_HMI").getLanguageIndex() == 16;
        }
        return false;
    }
}

