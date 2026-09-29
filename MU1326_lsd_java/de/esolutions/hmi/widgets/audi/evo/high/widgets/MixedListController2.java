/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.intercommunication.MixedListConstants;
import de.audi.atip.hmi.intercommunication.MixedListConstants$LaneGuidance;
import de.audi.atip.hmi.intercommunication.MixedListConstants$TollGateInfo;
import de.audi.atip.hmi.model.IconCell;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.LongListCell;
import de.audi.atip.hmi.model.MetricsListCell;
import de.audi.atip.hmi.model.ObjectListCell;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.atip.hmi.modelaccess.ListModelGUI;
import de.audi.atip.hmi.view.AnimationListener;
import de.audi.atip.timer.Timer;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimationController;
import de.esolutions.hmi.widgets.audi.base.eal.IMixedListCallback;
import de.esolutions.hmi.widgets.audi.base.eal.MixedListKZBMerger;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.high.AnimationControllerMIB2High;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MixedListController2$1;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MixedListItemController2;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MixedListLayout;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MixedListLayoutPackage;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MixedListRenderer;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MixedListVisibilityController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LayoutContainerController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class MixedListController2
extends AbstractWidgetController
implements AnimationListener,
MixedListConstants,
IMixedListCallback {
    public static MixedListController2 singleton;
    public boolean simulateScreenChangeAnimationRunning = false;
    public boolean animationDisabled = false;
    public static boolean onScreen;
    private int[] textIDs;
    private static final int ID_CALC_ROUTE;
    private static final int ID_BORDER_PASSING_DOUBLE;
    private static final int ID_PICTURE_NAV_DOUBLE;
    private static final int ID_UNCHANGED;
    private static final int ID_NO_ANIMATION;
    public static final int BITMAP_INDEX_TURN_ARROW;
    public static final int BITMAP_INDEX_ROADSIGNICON;
    public static final int BITMAP_INDEX_COUNTRY_FLAG;
    public static final int BITMAP_INDEX_POI_ICON;
    public static final int BITMAP_INDEX_SPEEDWARNING_ZONE;
    public static final int BITMAP_INDEX_SPEEDWARNING;
    public static final int BITMAP_INDEX_RECOMMENDEDSPEED;
    public static final int BITMAP_INDEX_CAR2X;
    public static final int BITMAP_INDEX_ASIA_IC_MOTORWAY;
    public static final int BITMAP_INDEX_ASIA_ETC;
    public static final int BITMAP_INDEX_JAPAN_ETC;
    public static final int BITMAP_INDEX_KOREA_ETC;
    public static final int BITMAP_INDEX_TRAFFIC;
    public static final int BITMAP_INDEX_EXIT_SIGN;
    public static final int BITMAP_INDEX_TRAFFIC_NAR;
    public static final int BITMAP_INDEX_ROADSIGNICON_NAR;
    public static final int BITMAP_INDEX_EMPTY;
    public static final int BITMAP_INDEX_EMPTY_TARGET;
    private static final int SRC_2;
    private static final int SRC_1;
    private static final int SRC_0;
    public static final int ITEM_INNER_HEIGHT_HIGH;
    public static final int ITEM_INNER_HEIGHT_KOMBI;
    public int itemInnerHeight;
    public static final int ITEM_INNER_WIDTH;
    public static final int ITEM_INNER_WIDTH_KOMBI;
    public static final int ITEM_INNER_WIDTH_NAR;
    public static final int ITEM_INNER_HEIGHT_DOUBLE_SIZED_BOX;
    public static final int ITEM_INNER_HEIGHT_DOUBLE_SIZED_BOX_KOMBI;
    public static final int BOX_STREET_HEIGHT;
    public static final int BOX_HEIGHT;
    public static final int Y_ORIGIN;
    public static final int Y_POSITION_BOX0;
    public static final int Y_POSITION_BOX1;
    public static final int Y_POSITION_BOX1_KOMBI;
    public static final int Y_POSITION_BOX2;
    public static final int Y_POSITION_BOX3;
    public static final int Y_POSITION_BOX4;
    private static final int Y_POSITION_OFF_SCREEN;
    public static final int ANIMATION_DURATION;
    public static final int ANIMATION_DURATION_DEBUG;
    public static final int ANIMATION_TYPE;
    public static final int ANIMATION_TYPE_DEBUG;
    public static final int ANIMATION_TYPE_FADING;
    private static final int ANIMATION_ID_EEE_1EE;
    private static final int ANIMATION_ID_EEE_12E;
    private static final int ANIMATION_ID_EEE_123;
    private static final int ANIMATION_ID_1EE_12E;
    private static final int ANIMATION_ID_1EE_2EE;
    private static final int ANIMATION_ID_1EE_123;
    private static final int ANIMATION_ID_1EE_22E;
    private static final int ANIMATION_ID_12E_123;
    private static final int ANIMATION_ID_12E_2EE;
    private static final int ANIMATION_ID_123_234;
    private static final int ANIMATION_ID_123_345;
    private static final int ANIMATION_ID_123_345_B;
    private static final int ANIMATION_ID_123_142;
    private static final int ANIMATION_ID_123_124;
    private static final int ANIMATION_ID_123_145;
    private static final int ANIMATION_ID_123_145_B;
    private static final int ANIMATION_ID_123_412;
    private static final int ANIMATION_ID_123_23E;
    private static final int ANIMATION_ID_123_3EE;
    private static final int ANIMATION_ID_123_3EE_B;
    private static final int ANIMATION_ID_123_443;
    private static final int ANIMATION_ID_123_244;
    private static final int ANIMATION_ID_123_442;
    private static final int ANIMATION_ID_123_344;
    private static final int ANIMATION_ID_123_144;
    private static final int ANIMATION_ID_123_344_B;
    private static final int ANIMATION_ID_122_223;
    private static final int ANIMATION_ID_112_2EE;
    private static final int ANIMATION_ID_112_233;
    private static final int ANIMATION_ID_112_23E;
    private static final int ANIMATION_ID_112_234;
    private static final int ANIMATION_ID_11E_2EE;
    private static final int ANIMATION_ID_11E_22E;
    private static final int ANIMATION_ID_123_134;
    private static final int ANIMATION_ID_122_22E;
    private static final int ANIMATION_ID_1EE_EEE;
    private static final int ANIMATION_ID_11E_EEE;
    private static final int ANIMATION_ID_FADE_OUT;
    private static final int ANIMATION_ID_FADE_IN;
    private static final int ANIMATION_ID_UPDATE_ANIMATION;
    private static final int DOWN;
    private static final int UP;
    private static final int SINGLE_HEIGHT;
    private static final int DOUBLE_HEIGHT;
    private int animationDirection = -1;
    private int animationHeight = 104;
    private int[] startPositions = new int[4];
    private boolean[] isBoxAnimated = new boolean[4];
    private static final int STATE_ID_EMPTY;
    private static final int STATE_ID_BOX3;
    private static final int STATE_ID_BOX2;
    private static final int STATE_ID_BOX1;
    private static final int STATE_ID_BOX23;
    private static final int STATE_ID_BOX23_BOX1;
    private static final int STATE_ID_BOX3_BOX12;
    private MixedListRenderer renderer;
    private AbstractAnimation animation;
    private MixedListItemController2[] items;
    private MixedListItemController2 item;
    private HashMap layouts = new HashMap(10);
    private HashMap pixelExactLayouts = new HashMap(10);
    private boolean layoutsSet = false;
    public boolean isInDebugMode = false;
    private long[] oldDataIDs;
    private long[] newDataIDs;
    protected int[] oldFormatIDs;
    protected int[] newFormatIDs;
    private ListCell[][] oldData;
    private ListCell[][] newData;
    private List bufferedEvents = new ArrayList();
    private List bufferedAnimations = new ArrayList();
    private int currentAnimationID = -1;
    private int currentStateID = 0;
    private boolean animationStarted = false;
    private float lastAnimationValue;
    private ListModelGUI listModel;
    private float w140_height_0 = 0.0f;
    private float w140_height_1 = 0.0f;
    private float w140_height_2 = 0.0f;
    private float w140_height_3 = 0.0f;
    private float w140_pos_0 = 53314;
    private float w140_pos_1 = 20547;
    private float w140_pos_2 = 40003;
    private float w140_pos_3 = 0.0f;
    private float w140_contentOpacity_0 = 1.0f;
    private float w140_contentOpacity_1 = 1.0f;
    private float w140_contentOpacity_2 = 1.0f;
    private float w140_contentOpacity_3 = 1.0f;
    private boolean w140_footerVisibility = true;
    private int visibleStateBeforeKZBMerged = -1;
    private boolean isActiveInG24 = false;
    private boolean justSetOnScreen = false;
    private Random random = new Random();

    public MixedListController2() {
        singleton = this;
    }

    private boolean accessModel() {
        if (this.isDebugMode()) {
            return true;
        }
        if (this.listModel == null) {
            if (this.model != null) {
                this.listModel = (ListModelGUI)this.model;
            } else {
                mixedListLogChannel.log(-1601830656, "MixedListController#accessModel Could not access the model. No model available.");
                return false;
            }
        }
        int n = this.listModel.getLength();
        int n2 = this.listModel.getMaxColumns();
        if (n != 3) {
            mixedListLogChannel.log(10000, "MixedListController#accessModel Model has less than 3 rows.");
            return false;
        }
        this.oldData = this.newData;
        this.newData = new ListCell[n][n2];
        boolean bl = this.readDataFromModel(this.newData);
        if (bl) {
            this.newData = MixedListController2.copy(this.newData);
        }
        return bl;
    }

    @Override
    public void add(AbstractWidget abstractWidget) {
        if (abstractWidget instanceof MixedListVisibilityController) {
            mixedListLogChannel.log(-2137614336, "MixedListController2#add widget is instance of MixedListVisibilityController");
        } else if (abstractWidget instanceof MixedListItemController2) {
            int n;
            int n2 = 4;
            if (MixedListController2.isMMIKombi()) {
                n2 = 2;
            }
            if (this.items == null) {
                this.items = new MixedListItemController2[n2];
            }
            for (n = 0; n < n2; ++n) {
                if (this.items[n] != null) continue;
                this.items[n] = (MixedListItemController2)abstractWidget;
                this.items[n].setParentController(this);
                break;
            }
            if (n == n2) {
                mixedListLogChannel.log(-2137614336, "MixedListController2#add There are already %1 items.", (long)n2);
                return;
            }
        } else if (abstractWidget instanceof MixedListLayout) {
            MixedListLayout mixedListLayout = (MixedListLayout)abstractWidget;
            this.addLayout(mixedListLayout, mixedListLayout.getLayoutFormat());
        }
        super.add(abstractWidget);
    }

    private void addLayout(MixedListLayout mixedListLayout, int n) {
        Integer n2 = new Integer(n);
        if (!this.layouts.containsKey(n2)) {
            this.layouts.put(n2, mixedListLayout);
        } else {
            mixedListLogChannel.log(-1601830656, "MixedListController#addLayout Layout with key %1 already added to the widget.", (long)n);
        }
    }

    @Override
    protected void afterConnected() {
        mixedListAfterPaint.log(-2137614336, "MixedListController2#afterConnected");
        super.afterConnected();
    }

    @Override
    protected void afterPaint(RedrawContext redrawContext) {
        if (mixedListAfterPaint.isDebug()) {
            for (int i2 = 0; i2 < this.items.length; ++i2) {
                if (this.items[i2] == null) continue;
                mixedListAfterPaint.log(-2137614336, "MixedListController#afterPaint Item %1", (long)i2);
                MixedListRenderer.printWidget(this.items[i2], "", mixedListAfterPaint, -2137614336);
                mixedListAfterPaint.log(-2137614336, "Content = %1", (long)this.items[i2].getCurrentContentNode());
                mixedListAfterPaint.log(-2137614336, "Source = %1", (long)this.items[i2].getCurrentModelRow());
                mixedListAfterPaint.log(-2137614336, "Position = %1", (long)this.items[i2].getCurrentPosition());
            }
            this.renderer.printProperties(mixedListAfterPaint, -2137614336);
            mixedListAfterPaint.log(-2137614336, "");
            this.renderer.printWrappedNodes(mixedListAfterPaint, -2137614336);
            mixedListAfterPaint.log(-2137614336, "");
            this.renderer.printNodes(mixedListAfterPaint, -2137614336);
            mixedListAfterPaint.log(-2137614336, "");
        }
        super.afterPaint(redrawContext);
    }

    @Override
    public void animate(int n, float f2, int n2) {
        float f3;
        mixedListLogChannel.log(-2137614336, "MixedListController#animate value = %1", (double)f2);
        this.lastAnimationValue = f3 = f2 / 31300;
        this.onStart(this.currentAnimationID);
        this.animation(this.currentAnimationID, f3);
        this.setCompositesDirty(true);
    }

    private void animation(int n, float f2) {
        switch (n) {
            case 1: {
                if (!MixedListController2.isMMIKombi()) {
                    this.doAnimate(f2);
                    break;
                }
                this.animationFadeIn0(f2);
                break;
            }
            case 2: 
            case 3: 
            case 7: 
            case 14: 
            case 20: 
            case 24: 
            case 50: 
            case 51: 
            case 52: 
            case 53: 
            case 58: 
            case 62: 
            case 64: 
            case 73: 
            case 80: 
            case 103: 
            case 113: 
            case 114: 
            case 120: 
            case 122: 
            case 160: 
            case 170: 
            case 1000: 
            case 1003: 
            case 1004: 
            case 1005: {
                this.doAnimate(f2);
                break;
            }
            case 9: 
            case 90: {
                if (!MixedListController2.isMMIKombi()) break;
                this.animationFadeOver0(f2);
                break;
            }
            case 140: 
            case 143: {
                if (MixedListController2.isMMIKombi()) {
                    this.animationFadeOut0(f2);
                    break;
                }
                this.doAnimate(f2);
                break;
            }
            case 78: {
                this.animationBorderCrossingScaleUp(f2);
                break;
            }
            case 79: {
                this.animationBorderCrossingScaleUp2(f2);
                break;
            }
            case 77: {
                this.animationBorderCrossingScaleUp3(f2);
                break;
            }
            case 81: {
                this.animationBorderCrossingScaleUp4(f2);
                break;
            }
            case 17: {
                if (!MixedListController2.isMMIKombi()) break;
                this.animationFadeSingleDouble(f2);
                break;
            }
            case 95: {
                this.animationFadeDoubleSingle(f2);
                break;
            }
            case 1001: {
                this.animationFadeOut(f2);
                break;
            }
            case 1002: {
                this.animationFadeIn(f2);
                break;
            }
            case 2000: {
                break;
            }
            default: {
                mixedListLogChannel.log(10000, "MixedListController#animation Invalid animation id: %1", (long)n);
            }
        }
    }

    private void animationBorderCrossingScaleUp(float f2) {
        int n = 208 - this.itemInnerHeight;
        int n2 = (int)(f2 * (float)n);
        this.setW140_height_1(this.itemInnerHeight + n2);
        this.setW140_pos_0(208 - n2);
        this.setW140_pos_3(104 - n2);
    }

    private void animationBorderCrossingScaleUp2(float f2) {
        int n = 208 - this.itemInnerHeight;
        int n2 = (int)(f2 * (float)n);
        this.setW140_height_3(this.itemInnerHeight + n2);
        this.setW140_pos_3(104 + n2);
        this.setW140_pos_0(208 + n2);
        this.setW140_pos_1(312 + n2);
    }

    private void animationBorderCrossingScaleUp3(float f2) {
        int n = 208 - this.itemInnerHeight;
        int n2 = (int)(f2 * (float)n);
        this.setW140_height_0(this.itemInnerHeight + n2);
        this.setW140_pos_0(208 + n2);
        this.setW140_pos_1(312 + n2);
    }

    private void animationBorderCrossingScaleUp4(float f2) {
        int n = 208 - this.itemInnerHeight;
        int n2 = (int)(f2 * (float)n);
        this.setW140_height_0(this.itemInnerHeight + n2);
        this.setW140_pos_3(104 - n2);
    }

    private void animationFadeIn(float f2) {
        this.setOpacity(f2);
    }

    private void animationFadeIn0(float f2) {
        this.setW140_contentOpacity_0(f2);
        this.setOpacity(f2);
    }

    private void doAnimate(float f2) {
        float f3 = (float)(this.animationDirection * this.animationHeight) * f2;
        if (this.isBoxAnimated[0]) {
            this.setW140_pos_0((float)this.startPositions[0] + f3);
        }
        if (this.isBoxAnimated[1]) {
            this.setW140_pos_1((float)this.startPositions[1] + f3);
        }
        if (this.isBoxAnimated[2]) {
            this.setW140_pos_2((float)this.startPositions[2] + f3);
        }
        if (this.isBoxAnimated[3]) {
            this.setW140_pos_3((float)this.startPositions[3] + f3);
        }
    }

    private void animationFadeOut(float f2) {
        this.setOpacity(1.0f - f2);
    }

    private void animationFadeOut0(float f2) {
        this.setW140_contentOpacity_0(1.0f - f2);
        this.setOpacity(1.0f - f2);
    }

    private void animationFadeOver0(float f2) {
        this.items[0].setOpacity(Math.max(1.0f - 2.0f * f2, 0.0f));
        this.items[0].setCompositesDirty(true);
        this.items[1].setOpacity(Math.max(2.0f * (f2 - 63), 0.0f));
        this.items[1].setCompositesDirty(true);
    }

    private void animationFadeSingleDouble(float f2) {
        if ((double)f2 <= 0.5) {
            this.setOpacity(Math.max(1.0f - 2.0f * f2, 0.0f));
        } else {
            this.setW140_pos_0(31300);
            this.setW140_pos_1(8259);
            this.setOpacity(Math.max(2.0f * (f2 - 63), 0.0f));
        }
        this.items[0].setCompositesDirty(true);
        this.items[1].setCompositesDirty(true);
    }

    private void animationFadeDoubleSingle(float f2) {
        if ((double)f2 <= 0.5) {
            this.setOpacity(Math.max(1.0f - 2.0f * f2, 0.0f));
        } else {
            this.setW140_pos_0(31300);
            this.setW140_pos_1(53314);
            this.setOpacity(Math.max(2.0f * (f2 - 63), 0.0f));
        }
        this.items[0].setCompositesDirty(true);
        this.items[1].setCompositesDirty(true);
    }

    @Override
    public void animationFinished(int n, int n2) {
        mixedListLogChannel.log(-2137614336, "MixedListController#animationFinished for Transition %1 in State %2", (Object)MixedListController2.getAnimationName(this.currentAnimationID), (Object)MixedListController2.getStateName(this.currentStateID));
        switch (this.currentAnimationID) {
            case 53: {
                this.pushAnimation(1000);
                this.currentAnimationID = -1;
                this.animationStarted = false;
                break;
            }
            case 52: {
                this.pushAnimation(1003);
                this.currentAnimationID = -1;
                this.animationStarted = false;
                break;
            }
            case 1001: {
                this.setVisibleInternal(false);
                this.currentAnimationID = -1;
                this.animationStarted = false;
                break;
            }
            case 1002: {
                this.currentAnimationID = -1;
                this.animationStarted = false;
                this.setDefaultState(false);
                break;
            }
            case 2000: {
                this.currentAnimationID = -1;
                this.animationStarted = false;
                break;
            }
            case 73: {
                this.pushAnimation(1004);
                this.currentAnimationID = -1;
                this.animationStarted = false;
                break;
            }
            case 80: {
                this.pushAnimation(1005);
                this.currentAnimationID = -1;
                this.animationStarted = false;
                break;
            }
            default: {
                this.setDefaultState(false);
            }
        }
        this.popAnimation();
    }

    private static boolean checkForMultipleEventsWithIdenticalIDs(long[] lArray) {
        if (!(lArray[0] != lArray[1] && lArray[1] != lArray[2] || lArray[1] == -1L || MixedListController2.isIDForDoubleManeuver(lArray[1]) || lArray[1] == -2L)) {
            mixedListLogChannel.log(-1601830656, "MixedListController#checkForMultipleIDs Multiple events with the same ID %1 not allowed.", lArray[1]);
            return false;
        }
        return true;
    }

    private static long[] calculateIDs(ListCell[][] listCellArray, int[] nArray) {
        if (listCellArray == null) {
            mixedListLogChannel.log(10000, "MixedListController2#calculateIDs Data is completely null");
            return new long[]{-1L, -1L, -1L};
        }
        int n = listCellArray.length;
        if (listCellArray.length > nArray.length) {
            n = nArray.length;
            mixedListLogChannel.log(10000, "MixedListController2#calculateIDs More data delivered than expected (%1)", (long)listCellArray.length);
        } else if (listCellArray.length < nArray.length) {
            mixedListLogChannel.log(10000, "MixedListController2#calculateIDs Less data delivered than expected (%1)", (long)listCellArray.length);
        }
        long[] lArray = new long[n];
        int n2 = 0;
        while (n2 < n) {
            if (listCellArray[n2] == null) {
                lArray[n2] = -1L;
                mixedListLogChannel.log(10000, "MixedListController2#calculateIDs %1-th model row is null", (long)(++n2));
                continue;
            }
            int n3 = -1;
            if (listCellArray[n2][0] != null) {
                n3 = ((IntegerListCell)listCellArray[n2][0]).getValue();
            } else {
                mixedListLogChannel.log(10000, "MixedListController2#calculateIDs format column in %1-th model row is null", (long)n2);
            }
            nArray[n2] = n3;
            long l = -1L;
            switch (n3) {
                case -1: {
                    l = -1L;
                    break;
                }
                case 3: {
                    l = -2L;
                    break;
                }
                case 6: 
                case 7: {
                    l = -3L;
                    break;
                }
                case 9: 
                case 10: {
                    l = -4L;
                    break;
                }
                default: {
                    long l2;
                    int n4 = 0;
                    if (listCellArray[n2][48] != null) {
                        n4 = ((IntegerListCell)listCellArray[n2][48]).getValue();
                    } else {
                        mixedListLogChannel.log(10000, "MixedListController2#calculateIDs Unifier ID cell is null");
                    }
                    if (mixedListLogChannel.isDebug()) {
                        l2 = 0L;
                        if (listCellArray[n2][47] != null) {
                            l2 = ((LongListCell)listCellArray[n2][47]).getValue();
                        }
                        Buffer buffer = new Buffer();
                        buffer.append(MixedListController2.getFormatName(n3));
                        buffer.append(" ");
                        buffer.append(MixedListController2.getEventName(listCellArray[n2]));
                        mixedListLogChannel.log(-2137614336, "MixedListController2#calculateIDs format = %1, id = %2, DTD = %3", (Object)buffer.toString(), (long)n4, l2);
                    }
                    if ((l = (long)n4) == 0L) {
                        l2 = 0L;
                        if (listCellArray[n2][47] != null) {
                            l2 = ((LongListCell)listCellArray[n2][47]).getValue();
                        } else {
                            mixedListLogChannel.log(10000, "MixedListController2#calculateIDs Distance to dest cell is null");
                        }
                        long l3 = l2;
                        l = l3 * 0 + (long)n3;
                    }
                    mixedListLogChannel.log(-2137614336, "MixedListController2#calculateIDs unique id = %1", l);
                    break;
                }
            }
            lArray[n2] = l;
            ++n2;
        }
        return lArray;
    }

    @Override
    public void animationStarted(int n, int n2) {
        mixedListLogChannel.log(-2137614336, "MixedListController#animationStarted for Transition %1", (Object)MixedListController2.getAnimationName(this.currentAnimationID));
    }

    private int calculateTransitions(long[] lArray, long[] lArray2) {
        mixedListLogChannel.log(-2137614336, "MixedListController#calculateTransitions current state = %1", (long)this.currentStateID);
        int n = -5;
        if (!MixedListController2.isMMIKombi()) {
            if (lArray2[0] == lArray[0] && lArray2[1] == lArray[1] && lArray2[2] == lArray[2]) {
                return n;
            }
            switch (this.currentStateID) {
                case 0: {
                    n = this.calculateTransitionsState0(lArray, lArray2);
                    break;
                }
                case 1: {
                    n = this.calculateTransitionsState1(lArray, lArray2);
                    break;
                }
                case 2: {
                    n = this.calculateTransitionsState2(lArray, lArray2);
                    break;
                }
                case 3: {
                    n = this.calculateTransitionsState3(lArray, lArray2);
                    break;
                }
                case 4: {
                    n = this.calculateTransitionsState4(lArray, lArray2);
                    break;
                }
                case 5: {
                    n = this.calculateTransitionsState5(lArray, lArray2);
                    break;
                }
                case 6: {
                    n = this.calculateTransitionsState6(lArray, lArray2);
                    break;
                }
                default: {
                    mixedListLogChannel.log(10000, "MixedListController#calculateTransitions Current state ID is not valid: %1", (long)this.currentStateID);
                    n = -1;
                    break;
                }
            }
        } else {
            if (lArray2[2] == lArray[2]) {
                return n;
            }
            switch (this.currentStateID) {
                case 0: {
                    n = this.calculateTransitionsState0Kombi(lArray, lArray2);
                    break;
                }
                case 1: {
                    n = this.calculateTransitionsState1Kombi(lArray, lArray2);
                    break;
                }
                case 4: {
                    n = this.calculateTransitionsState4Kombi(lArray, lArray2);
                    break;
                }
                default: {
                    mixedListLogChannel.log(-1601830656, "MixedListController#calculateTransitions Current state ID is not valid: %1", (long)this.currentStateID);
                    n = -1;
                }
            }
        }
        if (n == -1) {
            mixedListLogChannel.log(10000, "MixedListController2#calculateTransitions No transition could be found. State = %1", (Object)MixedListController2.getStateName(this.currentStateID));
        }
        return n;
    }

    private int calculateTransitionsState0(long[] lArray, long[] lArray2) {
        int n = -1;
        if (lArray2[2] != -1L && lArray2[2] != -2L && lArray2[2] == lArray2[1] && MixedListController2.isIDForDoubleManeuver(lArray2[1])) {
            n = 4;
            if (lArray2[0] != -1L) {
                n = 5;
            }
            return n;
        }
        if (lArray2[0] != -1L && lArray2[0] != -2L && lArray2[0] == lArray2[1] && MixedListController2.isIDForDoubleManeuver(lArray2[1])) {
            return 6;
        }
        n = -1;
        if (lArray2[2] != -1L) {
            n = 1;
        }
        if (lArray2[1] != -1L) {
            n = 2;
        }
        if (lArray2[0] != -1L) {
            n = 3;
        }
        return n;
    }

    private int calculateTransitionsState0Kombi(long[] lArray, long[] lArray2) {
        int n = -1;
        if (lArray2[2] != -1L && (lArray2[2] == -3L || lArray2[2] == -4L) && lArray2[2] == lArray2[1]) {
            return 4;
        }
        if (lArray2[2] != -1L) {
            return 1;
        }
        return n;
    }

    private int calculateTransitionsState1(long[] lArray, long[] lArray2) {
        int n = -1;
        if (lArray2[2] == lArray[2] && lArray2[0] != -1L && lArray2[0] != -2L && lArray2[0] == lArray2[1]) {
            return 15;
        }
        if (lArray2[0] != -1L && lArray2[0] == lArray[2] && lArray2[1] != -2L && lArray2[1] == lArray2[2]) {
            return 16;
        }
        if (lArray2[0] == -1L && lArray2[2] != -1L && lArray2[1] != -2L && lArray2[1] != lArray[2] && lArray2[1] == lArray2[2]) {
            return 17;
        }
        if (lArray2[0] != -1L && lArray2[0] != -2L && lArray2[0] == lArray2[1] && lArray2[0] != lArray[2] && lArray2[2] != lArray[2]) {
            return 18;
        }
        if (lArray2[0] != -1L && lArray2[0] != lArray[2] && lArray2[1] != -2L && lArray2[1] == lArray2[2] && lArray2[1] != lArray[2]) {
            return 19;
        }
        if (lArray[2] == lArray2[2]) {
            n = -1;
            if (lArray2[1] != -1L) {
                n = 7;
            }
            if (lArray2[0] != -1L) {
                n = 14;
            }
            return n;
        }
        if (lArray[2] == lArray2[1] && lArray2[0] == -1L) {
            return 8;
        }
        if (lArray2[0] == -1L && lArray2[1] == -1L && lArray2[2] != -1L && lArray2[2] != lArray[2]) {
            return 9;
        }
        if (lArray2[0] == -1L && lArray2[1] != -1L && lArray2[1] != lArray[2] && lArray2[2] != lArray[2]) {
            return 10;
        }
        if (lArray2[0] != -1L && lArray2[0] != lArray[2] && lArray2[1] != lArray[2] && lArray2[2] != lArray[2]) {
            return 11;
        }
        if (lArray2[0] != -1L && lArray2[0] == lArray[2]) {
            return 12;
        }
        if (lArray2[0] != -1L && lArray2[1] == lArray[2]) {
            return 13;
        }
        if (lArray2[2] == -1L) {
            return 140;
        }
        return n;
    }

    private int calculateTransitionsState1Kombi(long[] lArray, long[] lArray2) {
        int n = -1;
        if (lArray2[1] != -1L && (lArray2[1] == -3L || lArray2[1] == -4L) && lArray2[1] == lArray2[2]) {
            return 17;
        }
        if (lArray2[2] == -1L) {
            return 140;
        }
        if (lArray2[2] != lArray[2]) {
            return 9;
        }
        return n;
    }

    private int calculateTransitionsState2(long[] lArray, long[] lArray2) {
        int n = -1;
        if (lArray2[2] == -1L) {
            return 141;
        }
        if (lArray[1] == lArray2[1] && lArray[2] == lArray2[2] && lArray2[0] != -1L) {
            return 20;
        }
        if (lArray2[1] == -1L && lArray2[2] == lArray[2]) {
            return 21;
        }
        if (lArray2[0] == lArray[1] && lArray2[1] == lArray[2]) {
            return 22;
        }
        if (lArray2[0] == -1L && lArray2[1] == lArray[1] && lArray2[2] != lArray[2]) {
            return 23;
        }
        if (lArray2[1] == -1L && lArray2[2] == lArray[1]) {
            return 24;
        }
        if (lArray2[1] == -1L && lArray[1] != lArray2[2] && lArray[2] != lArray2[2]) {
            return 25;
        }
        if (lArray2[0] == -1L && lArray2[2] == lArray[2] && lArray2[1] != lArray[1]) {
            return 26;
        }
        if (lArray2[0] == -1L && lArray2[2] == lArray[1] && lArray2[1] != lArray[0]) {
            return 27;
        }
        if (lArray2[0] == -1L && lArray2[1] == lArray[2] && lArray2[0] != lArray[1]) {
            return 28;
        }
        if (lArray2[0] == -1L && lArray2[1] != lArray[1] && lArray2[1] != lArray[2] && lArray2[2] != lArray[1] && lArray2[2] != lArray[2] && lArray2[1] != lArray2[2]) {
            return 29;
        }
        if (lArray2[0] != -1L && lArray2[0] == lArray[2] && lArray2[1] != lArray[1] && lArray2[0] != lArray[1] && lArray2[1] != lArray2[2]) {
            return 30;
        }
        if (lArray2[0] != -1L && lArray2[0] == lArray[1] && lArray2[2] == lArray[2]) {
            return 31;
        }
        if (lArray2[0] != -1L && lArray2[0] == lArray[1] && lArray2[1] != lArray[2] && lArray2[2] != lArray[2] && lArray2[1] != lArray2[2]) {
            return 32;
        }
        if (lArray2[0] != -1L && lArray2[2] == lArray[2] && lArray2[0] != lArray[1] && lArray2[1] != lArray[1] && lArray2[0] != lArray2[1]) {
            return 33;
        }
        if (lArray2[0] != -1L && lArray2[1] != -1L && lArray2[0] != lArray[1] && lArray2[0] != lArray[2] && lArray2[1] != lArray[1] && lArray2[1] != lArray[2] && lArray2[2] != lArray[1] && lArray2[2] != lArray[2] && (lArray2[0] != lArray2[1] && lArray2[1] != lArray2[2] || lArray2[0] == -2L || lArray2[1] == -2L || lArray2[2] == -2L)) {
            return 34;
        }
        if (lArray2[0] != -1L && lArray2[0] != -2L && lArray2[2] == lArray[1] && lArray2[0] == lArray2[1]) {
            return 35;
        }
        if (lArray2[0] != -1L && lArray2[0] != -2L && lArray2[2] == lArray[2] && lArray2[0] != lArray[1] && lArray2[0] == lArray2[1]) {
            return 36;
        }
        if (lArray2[0] != -1L && lArray2[0] == lArray[2] && lArray2[1] != -1L && lArray2[1] != -2L && lArray2[1] == lArray2[2]) {
            return 37;
        }
        if (lArray2[0] != -1L && lArray2[0] == lArray[1] && lArray2[1] != -2L && lArray2[1] == lArray2[2] && lArray2[1] != lArray[0]) {
            return 38;
        }
        if (lArray2[0] != -1L && lArray2[0] != lArray[1] && lArray2[0] != lArray[2] && lArray2[1] != -2L && lArray2[1] == lArray2[2]) {
            return 39;
        }
        if (lArray2[0] != -1L && lArray2[0] != -2L && lArray2[0] == lArray2[1] && lArray2[2] != lArray[1] && lArray2[2] != lArray[2]) {
            return 40;
        }
        if (lArray2[0] == -1L && lArray2[1] != -2L && lArray2[1] == lArray2[2]) {
            return 41;
        }
        return n;
    }

    private int calculateTransitionsState3(long[] lArray, long[] lArray2) {
        int n = -1;
        if (lArray2[2] == -1L) {
            return 142;
        }
        if (lArray2[0] != -1L && lArray2[1] == lArray[0] && lArray2[2] == lArray[1]) {
            return 50;
        }
        if (lArray2[2] == lArray[2] && lArray2[0] == lArray[1] && lArray2[2] != lArray[0]) {
            return 51;
        }
        if (lArray2[0] != -1L && lArray2[2] == lArray[2] && lArray2[1] != lArray[1] && lArray2[1] != lArray[0] && lArray2[0] != lArray[1] && lArray2[0] != lArray[0] && lArray2[0] != lArray2[1]) {
            return 52;
        }
        if (lArray2[0] != -1L && lArray2[0] != lArray[0] && lArray2[0] != lArray[1] && lArray2[0] != lArray[2] && lArray2[1] != lArray[0] && lArray2[1] != lArray[1] && lArray2[1] != lArray[2] && lArray2[2] == lArray[0] && lArray2[0] != lArray2[1]) {
            return 53;
        }
        if (lArray2[0] != -1L && lArray2[0] != lArray[0] && lArray2[0] != lArray[1] && lArray2[0] != lArray[2] && lArray2[2] != lArray[0] && lArray2[2] != lArray[1] && lArray2[2] != lArray[2] && lArray2[1] == lArray[2]) {
            return 54;
        }
        if (lArray2[0] == lArray[0] && lArray2[2] == lArray[1] && lArray2[1] != lArray[2]) {
            return 55;
        }
        if (lArray2[0] != -1L && lArray2[2] == lArray[1] && lArray2[0] != lArray[0] && lArray2[0] != lArray[2] && lArray2[1] != lArray[0] && lArray2[1] != lArray[2] && lArray2[0] != lArray2[1]) {
            return 56;
        }
        if (lArray2[0] == lArray[2] && lArray2[1] != lArray[0] && lArray2[1] != lArray[1] && lArray2[2] != lArray[0] && lArray2[2] != lArray[1] && lArray2[1] != lArray2[2]) {
            return 57;
        }
        if (lArray2[0] != -1L && lArray2[0] != lArray[0] && lArray2[1] == lArray[1] && lArray2[2] == lArray[2]) {
            return 58;
        }
        if (lArray2[0] != -1L && lArray2[0] != lArray[0] && lArray2[0] != lArray[2] && lArray2[2] != lArray[0] && lArray2[2] != lArray[2] && lArray2[1] == lArray[1]) {
            return 59;
        }
        if (lArray2[0] == lArray[0] && lArray2[1] != lArray[1] && lArray2[1] != lArray[2] && lArray2[2] != lArray[1] && lArray2[2] != lArray[2] && lArray2[1] != lArray2[2]) {
            return 60;
        }
        if (lArray2[0] != -1L && lArray2[0] != lArray[1] && lArray2[0] != lArray[2] && lArray2[2] != lArray[1] && lArray2[2] != lArray[2] && lArray2[1] == lArray[0]) {
            return 61;
        }
        if (lArray2[0] == lArray[1] && lArray2[1] == lArray[2] && lArray2[2] != lArray[0]) {
            return 62;
        }
        if (lArray2[0] == -1L && lArray2[1] == lArray[1] && lArray2[2] == lArray[2] && lArray2[1] != lArray2[2]) {
            return 63;
        }
        if (lArray2[0] == -1L && lArray2[1] == lArray[0] && lArray2[2] == lArray[1] && lArray2[1] != lArray2[2]) {
            return 64;
        }
        if (lArray2[0] == -1L && lArray2[2] == lArray[2] && lArray2[1] == lArray[0] && lArray2[1] != lArray2[2]) {
            return 65;
        }
        if (lArray2[0] == -1L && lArray2[1] != -1L && lArray2[1] != lArray[0] && lArray2[1] != lArray[1] && lArray2[2] == lArray[2]) {
            return 66;
        }
        if (lArray2[0] == -1L && lArray2[1] == lArray[2] && lArray2[2] != lArray[0] && lArray2[2] != lArray[1]) {
            return 67;
        }
        if (lArray2[0] == -1L && lArray2[1] != -1L && lArray2[2] == lArray[1] && lArray2[1] != lArray[0] && lArray2[1] != lArray[2]) {
            return 68;
        }
        if (lArray2[0] == -1L && lArray2[1] == lArray[1] && lArray2[2] != lArray[0] && lArray2[2] != lArray[2]) {
            return 69;
        }
        if (lArray2[0] == -1L && lArray2[1] == lArray[0] && lArray2[2] != lArray[1] && lArray2[2] != lArray[2]) {
            return 70;
        }
        if (lArray2[0] == -1L && lArray2[1] != -1L && lArray2[2] == lArray[0] && lArray2[1] != lArray[1] && lArray2[1] != lArray[2]) {
            return 71;
        }
        if (lArray2[0] == -1L && lArray2[1] != -1L && lArray2[1] != lArray[0] && lArray2[1] != lArray[1] && lArray2[1] != lArray[2] && lArray2[2] != lArray[0] && lArray2[2] != lArray[1] && lArray2[2] != lArray[2] && lArray2[1] != lArray2[2]) {
            return 72;
        }
        if (lArray2[0] == -1L && lArray2[1] == -1L) {
            if (lArray2[2] == lArray[0]) {
                return 73;
            }
            if (lArray2[2] == lArray[1]) {
                return 74;
            }
            if (lArray2[2] == lArray[2]) {
                return 75;
            }
            if (lArray2[2] != -1L) {
                return 85;
            }
        }
        if (lArray2[0] == lArray[2] && lArray2[1] != -2L && lArray2[1] == lArray2[2] && MixedListController2.isIDForDoubleManeuver(lArray2[1])) {
            return 76;
        }
        if (lArray2[2] == lArray[2] && lArray2[0] != -1L && lArray2[0] != -2L && lArray2[0] == lArray2[1] && MixedListController2.isIDForDoubleManeuver(lArray2[0])) {
            return 77;
        }
        if (lArray2[2] == lArray[1] && lArray2[0] != -1L && lArray2[0] != -2L && lArray2[0] == lArray2[1] && MixedListController2.isIDForDoubleManeuver(lArray2[0])) {
            return 78;
        }
        if (lArray2[0] == lArray[1] && lArray2[1] != -2L && lArray2[1] == lArray2[2] && MixedListController2.isIDForDoubleManeuver(lArray2[1])) {
            return 79;
        }
        if (lArray2[0] != -1L && lArray2[0] != -2L && lArray2[0] == lArray2[1] && lArray2[2] == lArray[0] && MixedListController2.isIDForDoubleManeuver(lArray2[0])) {
            return 80;
        }
        if (lArray2[0] == lArray[0] && lArray2[1] != -2L && lArray2[1] == lArray2[2] && MixedListController2.isIDForDoubleManeuver(lArray2[1])) {
            return 81;
        }
        if (lArray2[0] != -1L && lArray2[0] != -2L && lArray2[0] == lArray2[1] && lArray2[2] != lArray[0] && lArray2[2] != lArray[1] && lArray2[2] != lArray[2] && MixedListController2.isIDForDoubleManeuver(lArray2[0])) {
            return 82;
        }
        if (lArray2[0] != -1L && lArray2[0] != lArray[0] && lArray2[0] != lArray[1] && lArray2[0] != lArray[2] && lArray2[1] != -2L && lArray2[1] == lArray2[2] && MixedListController2.isIDForDoubleManeuver(lArray2[1])) {
            return 83;
        }
        if (lArray2[0] == -1L && lArray2[1] != -1L && lArray2[1] != -2L && lArray2[1] == lArray2[2]) {
            return 84;
        }
        if (lArray2[0] != -1L && lArray2[0] != lArray[0] && lArray2[0] != lArray[1] && lArray2[0] != lArray[2] && lArray2[1] != lArray[0] && lArray2[1] != lArray[1] && lArray2[1] != lArray[2] && lArray2[2] != lArray[0] && lArray2[2] != lArray[1] && lArray2[2] != lArray[2]) {
            return 150;
        }
        if (lArray2[0] != -1L && lArray2[1] == lArray[0] && lArray2[2] == lArray[2]) {
            return 160;
        }
        return n;
    }

    private int calculateTransitionsState4(long[] lArray, long[] lArray2) {
        int n = -1;
        if (lArray2[2] == -1L) {
            return 143;
        }
        if (lArray2[0] != -1L && lArray2[1] != -2L && lArray2[1] == lArray2[2] && lArray2[1] == lArray[1] && lArray2[2] == lArray[2]) {
            return 91;
        }
        if (lArray2[0] == -1L && lArray2[1] != -1L && lArray2[1] != lArray[1] && lArray2[1] != -2L && lArray2[1] == lArray2[2]) {
            return 90;
        }
        if (lArray2[0] == lArray[1]) {
            return 92;
        }
        if (lArray2[0] != -1L && lArray2[1] != -2L && lArray2[1] == lArray2[2] && lArray2[1] != lArray[1]) {
            return 93;
        }
        if (lArray2[0] != -1L && lArray2[0] != -2L && lArray2[0] == lArray2[1] && lArray2[0] != lArray[1]) {
            return 94;
        }
        if (lArray2[0] == -1L && lArray2[1] == -1L && lArray2[2] != -1L) {
            return 95;
        }
        if (lArray2[0] == -1L && lArray2[1] != -1L && lArray2[1] != lArray[1]) {
            return 96;
        }
        if (lArray2[0] != -1L && lArray2[0] != lArray[1] && lArray2[1] != lArray[1]) {
            return 97;
        }
        return n;
    }

    private int calculateTransitionsState4Kombi(long[] lArray, long[] lArray2) {
        int n = -1;
        if (lArray2[2] != -1L && lArray2[1] != lArray2[2]) {
            return 95;
        }
        if (lArray2[2] != -1L && lArray2[2] == lArray2[1] && lArray2[2] != lArray[2]) {
            return 90;
        }
        if (lArray2[2] == -1L) {
            return 143;
        }
        return n;
    }

    private int calculateTransitionsState5(long[] lArray, long[] lArray2) {
        int n = -1;
        if (lArray2[2] == -1L) {
            return 144;
        }
        if (lArray2[0] == -1L && lArray2[1] == -1L && lArray2[2] == lArray[0]) {
            return 103;
        }
        if (lArray2[0] == -1L && lArray2[1] == lArray[1]) {
            return 100;
        }
        if (lArray2[0] != -1L && lArray2[0] != lArray[0] && lArray2[1] == lArray[1] && lArray2[2] == lArray[2]) {
            return 101;
        }
        if (lArray2[0] == lArray[1] && lArray2[2] != lArray[0]) {
            return 102;
        }
        if (lArray2[0] == -1L && lArray2[1] != -1L && lArray2[1] != -2L && lArray2[1] != lArray[1] && lArray2[1] == lArray2[2]) {
            return 104;
        }
        if (lArray2[0] != -1L && lArray2[0] != lArray[0] && lArray2[1] != -2L && lArray2[1] == lArray2[2] && lArray2[1] != lArray[1]) {
            return 105;
        }
        if (lArray2[0] != -1L && lArray2[0] != -2L && lArray2[0] == lArray2[1] && lArray2[0] != lArray[1] && lArray2[2] != lArray[0]) {
            return 106;
        }
        if (lArray2[0] == -1L && lArray2[1] == lArray[0]) {
            return 107;
        }
        if (lArray2[0] != -1L && lArray2[1] == lArray[0]) {
            return 108;
        }
        if (lArray2[0] == lArray[0] && lArray2[1] != lArray2[2]) {
            return 109;
        }
        if (lArray2[0] == -1L && lArray2[1] == -1L && lArray2[2] != lArray[0]) {
            return 110;
        }
        if (lArray2[0] == -1L && lArray2[1] != -1L && lArray2[1] != lArray[0] && lArray2[2] != lArray[0]) {
            return 111;
        }
        if (lArray2[0] != -1L && lArray2[0] != lArray[0] && lArray2[1] != lArray[0] && lArray2[2] != lArray[0]) {
            return 112;
        }
        if (lArray2[0] == -1L && lArray2[2] == lArray[0]) {
            return 113;
        }
        if (lArray2[0] != -1L && lArray2[2] == lArray[0] && lArray2[0] != lArray2[1]) {
            return 114;
        }
        if (lArray2[0] != -1L && lArray2[2] == lArray[0] && lArray2[0] == lArray2[1]) {
            return 170;
        }
        return n;
    }

    private int calculateTransitionsState6(long[] lArray, long[] lArray2) {
        int n = -1;
        if (lArray2[2] == -1L) {
            return 145;
        }
        if (lArray2[0] == -1L && lArray2[1] == lArray[0] && lArray2[1] == lArray2[2]) {
            return 120;
        }
        if (lArray2[0] == lArray[0] && lArray2[1] == lArray[1] && lArray2[2] != lArray[2]) {
            return 121;
        }
        if (lArray2[0] != -1L && lArray2[1] == lArray[0] && lArray2[0] != lArray[2]) {
            return 122;
        }
        if (lArray2[1] == -1L && lArray2[2] == lArray[2]) {
            return 123;
        }
        if (lArray2[0] == -1L && lArray2[2] == lArray[2]) {
            return 124;
        }
        if (lArray2[0] != -1L && lArray2[2] == lArray[2]) {
            return 125;
        }
        if (lArray2[0] == -1L && lArray2[1] == lArray[2]) {
            return 126;
        }
        if (lArray2[0] != -1L && lArray2[1] == lArray[2]) {
            return 127;
        }
        if (lArray2[0] == lArray[2] && lArray2[1] != lArray2[2]) {
            return 128;
        }
        if (lArray2[0] == -1L && lArray2[1] != -2L && lArray2[1] == lArray2[2] && lArray2[1] != lArray[0]) {
            return 129;
        }
        if (lArray2[0] != -1L && lArray2[0] != lArray[2] && lArray2[1] != -2L && lArray2[1] == lArray2[2] && lArray2[1] != lArray[0]) {
            return 130;
        }
        if (lArray2[0] != -1L && lArray2[0] != -2L && lArray2[0] == lArray2[1] && lArray2[0] != lArray[0] && lArray2[2] != lArray[2]) {
            return 1331;
        }
        if (lArray2[0] != -1L && lArray2[0] != lArray[2] && lArray2[1] != lArray[2] && lArray2[2] != lArray[2]) {
            return 132;
        }
        if (lArray2[0] == -1L && lArray2[1] != -1L && lArray2[1] != lArray[2] && lArray2[2] != lArray[2] && lArray2[1] != lArray2[2]) {
            return 133;
        }
        if (lArray2[1] == -1L && lArray2[2] != lArray[2]) {
            return 134;
        }
        return n;
    }

    private boolean checkModelAccess() {
        if (this.accessModel() && onScreen) {
            this.justSetOnScreen = false;
            if (!this.isOnScreen()) {
                this.justSetOnScreen = true;
                this.setOnScreen(true);
                this.setOpacity(1.0f);
                mixedListLogChannel.log(-2137614336, "MixedListController2#checkModelAccess Set on screen to true.");
            }
            return true;
        }
        mixedListLogChannel.log(10000, "MixedListController2#checkModelAccess Could not access the model. Set on screen to false.");
        this.setOnScreen(false);
        return false;
    }

    @Override
    public void connected(InitializationContext initializationContext) {
        mixedListLogChannel.log(-2137614336, "MixedListController2#connected isVisible = %1, isOnScreen = %2", this.isVisible(), this.isOnScreen());
        singleton = this;
        MixedListLayoutPackage.isKombi = MixedListController2.isMMIKombi();
        MixedListLayoutPackage.isNAR = this.isNAR();
        MixedListLayoutPackage.isAsia = MixedListController2.isAsia();
        MixedListLayoutPackage.isJp = MixedListController2.isJp();
        MixedListLayoutPackage.isKr = MixedListController2.isKr();
        if (!this.isActive()) {
            super.connected(initializationContext);
            return;
        }
        if (!this.layoutsSet) {
            this.layoutsSet = true;
            this.pixelExactLayouts.put(new Integer(-1), MixedListLayoutPackage.createDefaultLayout());
            this.pixelExactLayouts.put(new Integer(3), MixedListLayoutPackage.createCalculatingLayout());
            this.pixelExactLayouts.put(new Integer(16), MixedListLayoutPackage.createDestinationLayout());
            if (MixedListLayoutPackage.isNAR) {
                this.pixelExactLayouts.put(new Integer(0), MixedListLayoutPackage.isKombi ? MixedListLayoutPackage.createTurnLayoutNAR_G24() : MixedListLayoutPackage.createTurnLayoutNAR());
                this.pixelExactLayouts.put(new Integer(1), MixedListLayoutPackage.createPOILayoutNAR());
                this.pixelExactLayouts.put(new Integer(2), MixedListLayoutPackage.createTMCLayoutNAR());
                this.pixelExactLayouts.put(new Integer(8), MixedListLayoutPackage.createBorderCrossingSingleLayoutNAR());
                this.pixelExactLayouts.put(new Integer(9), MixedListLayoutPackage.createPictureNavLayoutNAR());
                this.pixelExactLayouts.put(new Integer(17), MixedListLayoutPackage.createPictureNavSingleLayoutNAR());
                this.pixelExactLayouts.put(new Integer(21), MixedListLayoutPackage.createTrafficConceptNAR());
            } else {
                this.pixelExactLayouts.put(new Integer(0), MixedListLayoutPackage.createTurnLayout());
                this.pixelExactLayouts.put(new Integer(1), MixedListLayoutPackage.isAsia ? MixedListLayoutPackage.createAsiaPOILayout() : MixedListLayoutPackage.createPOILayout());
                this.pixelExactLayouts.put(new Integer(2), MixedListLayoutPackage.createTMCLayout());
                this.pixelExactLayouts.put(new Integer(18), MixedListLayoutPackage.createTMCCar2XLayout());
                this.pixelExactLayouts.put(new Integer(8), MixedListLayoutPackage.createBorderCrossingSingleLayout());
                this.pixelExactLayouts.put(new Integer(6), MixedListLayoutPackage.createBorderCrossingLayout());
                this.pixelExactLayouts.put(new Integer(9), MixedListLayoutPackage.createPictureNavLayout());
                this.pixelExactLayouts.put(new Integer(17), MixedListLayoutPackage.createPictureNavSingleLayout());
                this.pixelExactLayouts.put(new Integer(21), MixedListLayoutPackage.createTrafficConcept());
                if (MixedListLayoutPackage.isAsia) {
                    this.pixelExactLayouts.put(new Integer(22), MixedListLayoutPackage.createTMCLayoutAsia());
                    this.pixelExactLayouts.put(new Integer(80), MixedListLayoutPackage.createAsiaSimpleEventLayout(80));
                    this.pixelExactLayouts.put(new Integer(84), MixedListLayoutPackage.createAsiaSimpleEventLayout(84));
                    this.pixelExactLayouts.put(new Integer(90), MixedListLayoutPackage.createAsiaSimpleEventLayout(90));
                    this.pixelExactLayouts.put(new Integer(91), MixedListLayoutPackage.createAsiaSimpleEventLayout(91));
                    this.pixelExactLayouts.put(new Integer(81), MixedListLayoutPackage.createAsiaSimpleEvent2Layout(81));
                    this.pixelExactLayouts.put(new Integer(88), MixedListLayoutPackage.createAsiaSimpleEvent3Layout(88));
                    this.pixelExactLayouts.put(new Integer(82), MixedListLayoutPackage.createAsiaDestinationLayout(82));
                    this.pixelExactLayouts.put(new Integer(83), MixedListLayoutPackage.createAsiaDestination2Layout(83));
                    this.pixelExactLayouts.put(new Integer(89), MixedListLayoutPackage.createAsiaOffroadWarningLayout());
                    this.pixelExactLayouts.put(new Integer(75), MixedListLayoutPackage.createAsiaParkingAreaLayout());
                    this.pixelExactLayouts.put(new Integer(70), MixedListLayoutPackage.createAsiaLaneGuidanceLayout1());
                    this.pixelExactLayouts.put(new Integer(71), MixedListLayoutPackage.createAsiaLaneGuidanceLayout2());
                    this.pixelExactLayouts.put(new Integer(92), MixedListLayoutPackage.createAsiaETCLayout());
                    this.pixelExactLayouts.put(new Integer(97), MixedListLayoutPackage.createAsiaTollPaymentGateLayout());
                    this.pixelExactLayouts.put(new Integer(93), MixedListLayoutPackage.createAsiaMotorwayEntranceLayout());
                    this.pixelExactLayouts.put(new Integer(95), MixedListLayoutPackage.createAsiaMotorwaySAPALayout());
                    this.pixelExactLayouts.put(new Integer(94), MixedListLayoutPackage.createAsiaMotorwayICLayout());
                    this.pixelExactLayouts.put(new Integer(96), MixedListLayoutPackage.createAsiaMotorwayJCTLayout());
                }
            }
        }
        super.connected(initializationContext);
        this.itemInnerHeight = MixedListController2.getInnerHeight();
        for (int i2 = 0; i2 < this.items.length; ++i2) {
            if (this.items[i2] == null) continue;
            this.items[i2].setWidth(MixedListController2.getInnerWidth());
            this.items[i2].setHeight(MixedListController2.getInnerHeight());
            this.items[i2].removeChildren();
        }
        this.initDataIDs();
        if (this.newData == null) {
            this.newData = new ListCell[3][69];
        }
        if (this.oldData == null) {
            this.oldData = new ListCell[3][69];
        }
        if (MixedListController2.isMMIKombi()) {
            this.setW140_footerVisibility(false);
        } else {
            this.renderer.setW140FooterVisibility(true);
        }
        this.setOpacity(1.0f);
        this.renderer.setW140Opacity(1.0f);
        if (this.currentAnimationID != -1 || this.animationStarted || !this.bufferedAnimations.isEmpty()) {
            mixedListLogChannel.log(10000, "MixedListController2#show Transitions not finished properly.");
            this.animationStarted = false;
            this.currentAnimationID = -1;
            this.bufferedAnimations.clear();
        }
        this.setDefaultState(false);
        MixedListKZBMerger.addCallbackListener(this);
    }

    private static final ListCell[][] copy(ListCell[][] listCellArray) {
        if (listCellArray != null) {
            mixedListLogChannel.log(-2137614336, "MixedListController2#copy");
            ListCell[][] listCellArray2 = new ListCell[listCellArray.length][];
            for (int i2 = 0; i2 < listCellArray.length; ++i2) {
                listCellArray2[i2] = new ListCell[listCellArray[i2].length];
                for (int i3 = 0; i3 < listCellArray[i2].length; ++i3) {
                    listCellArray2[i2][i3] = MixedListController2.copyListCell(listCellArray[i2][i3], i2, i3);
                }
            }
            return listCellArray2;
        }
        return null;
    }

    private static final Class classOf(Object object) {
        if (object != null) {
            return object.getClass();
        }
        return null;
    }

    private static final ListCell copyListCell(ListCell listCell, int n, int n2) {
        if (listCell instanceof TextListCell) {
            String string = ((TextListCell)listCell).getText();
            return new TextListCell(string != null ? new String(string) : null);
        }
        if (listCell instanceof IntegerListCell) {
            IntegerListCell integerListCell = (IntegerListCell)listCell;
            return new IntegerListCell(integerListCell.getValue(), integerListCell.getMaxValue());
        }
        if (listCell instanceof LongListCell) {
            return new LongListCell(((LongListCell)listCell).getValue());
        }
        if (listCell instanceof IconCell) {
            return listCell;
        }
        if (listCell instanceof MetricsListCell) {
            return ((MetricsListCell)listCell).copy();
        }
        if (listCell instanceof ObjectListCell) {
            Object object = ((ObjectListCell)listCell).getValue();
            if (object instanceof MixedListConstants$LaneGuidance || object instanceof MixedListConstants$TollGateInfo) {
                return listCell;
            }
            mixedListLogChannel.log(-1601830656, "MixedListController#copyListCell Copying for ObjectListCell @(%2, %3) cell %1 not possible.", object, (long)n, (long)n2);
            return null;
        }
        if (listCell == null) {
            return null;
        }
        mixedListLogChannel.log(-1601830656, "MixedListController#copyListCell Copying for list cell %1, %2 not possible.", (Object)listCell, (Object)MixedListController2.classOf(listCell));
        return null;
    }

    private AbstractAnimationController getAnimationController() {
        return (AbstractAnimationController)this.getTerminal().getIAnimationController();
    }

    private AbstractAnimation getAnimation(int n) {
        if (this.animation == null || this.animation.getType() != n) {
            this.animation = (AbstractAnimation)this.getAnimationController().getIAnimation(n);
            this.animation.addListener(this);
        }
        return this.animation;
    }

    @Override
    public void predisconnecting() {
        mixedListLogChannel.log(-2137614336, "MixedListController2#predisconnecting");
        super.predisconnecting();
        this.skipAnimation();
        this.renderer.removeContent(new int[]{1, 2, 3, 4});
        MixedListKZBMerger.removeCallbackListener(this);
        ((MixedListRenderer)this.getRenderer()).shutDown();
    }

    @Override
    public void disconnecting() {
        mixedListLogChannel.log(-2137614336, "MixedListController2#disconnecting");
        super.disconnecting();
    }

    private static String getEventName(ListCell[] listCellArray) {
        int n = ((IntegerListCell)listCellArray[0]).getValue();
        int n2 = -1;
        switch (n) {
            case 0: {
                n2 = 18;
                break;
            }
            case 1: {
                n2 = 11;
                break;
            }
            default: {
                n2 = -1;
            }
        }
        if (n2 != -1) {
            return ((TextListCell)listCellArray[n2]).getText();
        }
        return "";
    }

    private MixedListItemController2 getFreeItem() {
        for (int i2 = 0; i2 < this.items.length; ++i2) {
            if (this.items[i2].getCurrentPosition() != -1) continue;
            return this.items[i2];
        }
        return null;
    }

    private MixedListItemController2 getItemAtPosition(int n) {
        for (int i2 = 0; i2 < this.items.length; ++i2) {
            if (this.items[i2].getCurrentPosition() != n) continue;
            return this.items[i2];
        }
        return this.getFreeItem();
    }

    public LayoutContainerController getLayout(int n) {
        mixedListLogChannel.log(14808325, "MixedListController#getLayout for format = %1", (long)n);
        return (LayoutContainerController)this.layouts.get(new Integer(n));
    }

    private void initDataIDs() {
        if (this.oldDataIDs == null) {
            this.oldDataIDs = new long[3];
        }
        if (this.newDataIDs == null) {
            this.newDataIDs = new long[3];
        }
        for (int i2 = 0; i2 < 3; ++i2) {
            this.oldDataIDs[i2] = -1L;
            this.newDataIDs[i2] = -1L;
        }
    }

    @Override
    public boolean isActive() {
        return super.isActive() && (this.isActiveInG24 && MixedListController2.isMMIKombi() || !this.isActiveInG24 && !MixedListController2.isMMIKombi());
    }

    public boolean isDebugMode() {
        return this.isInDebugMode;
    }

    private static final boolean isIDForDoubleManeuver(long l) {
        return l == -3L || l == -4L;
    }

    public static boolean isMMIKombi() {
        return AbstractWidget.isScreenResolution1440();
    }

    public boolean isNAR() {
        return framework.isNar();
    }

    @Override
    public void managePaint(RedrawContext redrawContext) {
        mixedListAfterPaint.log(-2137614336, "MixedListController2#managePaint invalid = %1", this.isInvalid());
        super.managePaint(redrawContext);
    }

    private void onStart(int n) {
        if (!this.animationStarted) {
            mixedListLogChannel.log(-1601830656, "MixedListController2#onStart tID = %1", (long)n);
            this.animationStarted = true;
            switch (n) {
                case 1: {
                    if (!MixedListController2.isMMIKombi()) {
                        this.setUpAnimation_EEE_1EE();
                        break;
                    }
                    this.setUpAnimation_EEE_1EE_Kombi();
                    break;
                }
                case 2: {
                    this.setUpAnimation_EEE_12E();
                    break;
                }
                case 3: {
                    this.setUpAnimation_EEE_123();
                    break;
                }
                case 20: {
                    this.setUpAnimation_12E_123();
                    break;
                }
                case 7: {
                    this.setUpAnimation_1EE_12E();
                    break;
                }
                case 14: {
                    this.setUpAnimation_1EE_123();
                    break;
                }
                case 50: {
                    this.setUpAnimation_123_234();
                    break;
                }
                case 53: {
                    this.setUpAnimation_123_345();
                    break;
                }
                case 1000: {
                    this.setUpAnimation_123_345_B();
                    break;
                }
                case 9: {
                    if (!MixedListController2.isMMIKombi()) break;
                    this.setUpAnimation_1EE_2EE_Kombi();
                    break;
                }
                case 24: {
                    this.setUpAnimation_12E_2EE();
                    break;
                }
                case 64: {
                    this.setUpAnimation_123_23E();
                    break;
                }
                case 62: {
                    this.setUpAnimation_123_412();
                    break;
                }
                case 140: {
                    break;
                }
                case 77: 
                case 78: 
                case 79: 
                case 81: {
                    this.onStartAnimationBorderCrossingScaleUp();
                    break;
                }
                case 80: {
                    this.setUpAnimation_123_344();
                    break;
                }
                case 1005: {
                    this.setUpAnimation_123_344_B();
                    break;
                }
                case 51: {
                    this.setUpAnimation_123_142();
                    break;
                }
                case 58: {
                    this.setUpAnimation_123_124();
                    break;
                }
                case 73: {
                    this.setUpAnimation_123_23E();
                    break;
                }
                case 1004: {
                    this.setUpAnimation_123_23E_B();
                    break;
                }
                case 17: {
                    if (!MixedListController2.isMMIKombi()) break;
                    this.setUpAnimation_1EE_22E_Kombi();
                    break;
                }
                case 90: {
                    this.onStartAnimationFadeOverDoubleDouble();
                    break;
                }
                case 95: {
                    this.setUpAnimation_11E_2EE_Kombi();
                    break;
                }
                case 160: {
                    this.setUpAnimation_123_134();
                    break;
                }
                case 52: {
                    this.setUpAnimation_123_145();
                    break;
                }
                case 1003: {
                    this.setUpAnimation_123_145_B();
                    break;
                }
                case 2000: {
                    break;
                }
                case 122: {
                    this.setUpAnimation_122_223();
                    break;
                }
                case 114: {
                    this.setUpAnimation_112_234();
                    break;
                }
                case 103: {
                    this.setUpAnimation_112_2EE();
                    break;
                }
                case 113: {
                    this.setUpAnimation_112_23E();
                    break;
                }
                case 170: {
                    this.setUpAnimation_112_233();
                    break;
                }
                case 120: {
                    this.setUpAnimation_122_22E();
                    break;
                }
                case 143: {
                    if (MixedListController2.isMMIKombi()) break;
                    this.setUpAnimation_11E_EEE();
                    break;
                }
                case 1001: 
                case 1002: {
                    break;
                }
                default: {
                    mixedListLogChannel.log(10000, "MixedListController#onStart Invalid animation id %1", (long)n);
                }
            }
        }
    }

    private void setUpAnimation_11E_EEE() {
        this.animationDirection = -1;
        this.animationHeight = 208;
        this.setStartPositions(208, -1, -1, -1);
        this.setBoxIsAnimated(true, false, false, false);
    }

    private void setUpAnimation_EEE_1EE_Kombi() {
        this.item = this.getFreeItem();
        this.setupItem(this.item, this.newData, 2, 1, 0, true, false);
        this.setW140_pos_0(53314);
        this.setW140_height_0(this.itemInnerHeight);
        this.setW140_contentOpacity_0(0.0f);
        this.setOpacity(0.0f);
    }

    private void setUpAnimation_1EE_2EE_Kombi() {
        this.item = this.getFreeItem();
        this.setupItem(this.item, this.newData, 2, 1, 1, false, false);
        this.item.setOpacity(0.0f);
    }

    private void setUpAnimation_1EE_22E_Kombi() {
        this.item = this.getFreeItem();
        this.setW140_pos_1(31300);
        this.setW140_height_1(7491);
        this.item.setDoubleSized(true);
        this.setupItem(this.item, this.newData, 1, 2, 1, false, false);
    }

    private void onStartAnimationFadeOverDoubleDouble() {
        this.item = this.getFreeItem();
        this.setupItem(this.item, this.newData, 1, 1, 1, false, false);
        this.item.setDoubleSized(true);
        this.item.setOpacity(0.0f);
    }

    private void setUpAnimation_11E_2EE_Kombi() {
        this.item = this.getFreeItem();
        this.setW140_pos_1(31300);
        this.setW140_height_1(50754);
        this.item.setDoubleSized(false);
        this.setupItem(this.item, this.newData, 2, 2, 1, false, false);
    }

    private void setUpAnimation_12E_2EE() {
        this.animationDirection = -1;
        this.animationHeight = 104;
        this.setStartPositions(104, 208, -1, -1);
        this.setBoxIsAnimated(true, true, false, false);
    }

    private void setUpAnimation_123_412() {
        this.item = this.getItemAtPosition(0);
        this.setupItem(this.item, this.oldData, 2, 1, 0, true, true);
        this.item = this.getItemAtPosition(1);
        this.setupItem(this.item, this.oldData, 1, 2, 1, true, true);
        this.item = this.getItemAtPosition(2);
        this.setupItem(this.item, this.oldData, 0, 3, 2, true, true);
        this.item = this.getFreeItem();
        this.setupItem(this.item, this.newData, 2, 4, 3, true, false);
        this.setW140_height_0(this.itemInnerHeight);
        this.setW140_height_1(this.itemInnerHeight);
        this.setW140_height_2(this.itemInnerHeight);
        this.setW140_height_3(this.itemInnerHeight);
        this.animationDirection = 1;
        this.animationHeight = 104;
        this.setStartPositions(104, 208, 312, 0);
        this.setBoxIsAnimated(true, true, true, true);
    }

    private void setUpAnimation_123_23E() {
        this.animationDirection = -1;
        this.animationHeight = 104;
        this.setStartPositions(104, 208, 312, -1);
        this.setBoxIsAnimated(true, true, true, false);
    }

    private void setUpAnimation_123_23E_B() {
        this.animationDirection = -1;
        this.animationHeight = 104;
        this.setStartPositions(-1, 104, 208, -1);
        this.setBoxIsAnimated(false, true, true, false);
    }

    private void setUpAnimation_112_2EE() {
        this.animationDirection = -1;
        this.animationHeight = 208;
        this.setStartPositions(208, 312, -1, -1);
        this.setBoxIsAnimated(true, true, false, false);
    }

    private void setUpAnimation_112_233() {
        this.item = this.getItemAtPosition(2);
        this.setupItem(this.item, this.newData, 0, 3, 2, true, false);
        this.setW140_height_2(20547);
        this.animationDirection = -1;
        this.animationHeight = 208;
        this.setStartPositions(208, 312, 520, -1);
        this.setBoxIsAnimated(true, true, true, false);
    }

    private void setUpAnimation_112_23E() {
        this.item = this.getItemAtPosition(2);
        this.setupItem(this.item, this.newData, 1, 3, 2, true, false);
        this.setW140_height_2(this.itemInnerHeight);
        this.animationDirection = -1;
        this.animationHeight = 208;
        this.setStartPositions(208, 312, 416, -1);
        this.setBoxIsAnimated(true, true, true, false);
    }

    private void setUpAnimation_123_134() {
        this.item = this.getItemAtPosition(1);
        this.setupItem(this.item, this.oldData, 1, 2, 1, true, true);
        this.item = this.getItemAtPosition(2);
        this.setupItem(this.item, this.oldData, 0, 3, 2, true, true);
        this.item = this.getFreeItem();
        this.setupItem(this.item, this.newData, 0, 4, 3, true, false);
        this.setW140_height_3(this.itemInnerHeight);
        this.animationDirection = -1;
        this.animationHeight = 104;
        this.setStartPositions(-1, 208, 312, 416);
        this.setBoxIsAnimated(false, true, true, true);
    }

    private void setUpAnimation_EEE_1EE() {
        this.item = this.getFreeItem();
        this.setupItem(this.item, this.newData, 2, 1, 0, true, false);
        this.setW140_height_0(this.itemInnerHeight);
        this.setW140_pos_1(0.0f);
        this.setW140_pos_2(0.0f);
        this.animationDirection = 1;
        this.animationHeight = 104;
        this.setStartPositions(0, -1, -1, -1);
        this.setBoxIsAnimated(true, false, false, false);
    }

    private void setUpAnimation_122_22E() {
        this.animationDirection = -1;
        this.animationHeight = 104;
        this.setStartPositions(104, 312, -1, -1);
        this.setBoxIsAnimated(true, true, false, false);
    }

    private void setUpAnimation_EEE_12E() {
        this.item = this.getFreeItem();
        this.setupItem(this.item, this.newData, 2, 1, 0, true, false);
        this.item = this.getFreeItem();
        this.setupItem(this.item, this.newData, 1, 2, 1, true, false);
        this.setW140_height_0(this.itemInnerHeight);
        this.setW140_height_1(this.itemInnerHeight);
        this.animationDirection = 1;
        this.animationHeight = 104;
        this.setStartPositions(0, 104, -1, -1);
        this.setBoxIsAnimated(true, true, false, false);
    }

    private void setUpAnimation_EEE_123() {
        this.item = this.getFreeItem();
        this.setupItem(this.item, this.newData, 2, 1, 0, true, false);
        this.item = this.getFreeItem();
        this.setupItem(this.item, this.newData, 1, 2, 1, true, false);
        this.item = this.getFreeItem();
        this.setupItem(this.item, this.newData, 0, 3, 2, true, false);
        this.setW140_height_0(this.itemInnerHeight);
        this.setW140_height_1(this.itemInnerHeight);
        this.setW140_height_2(this.itemInnerHeight);
        this.animationDirection = 1;
        this.animationHeight = 104;
        this.setStartPositions(0, 104, 208, -1);
        this.setBoxIsAnimated(true, true, true, false);
    }

    private void setUpAnimation_1EE_12E() {
        this.item = this.getFreeItem();
        this.setupItem(this.item, this.newData, 1, 2, 1, true, false);
        this.setW140_height_1(this.itemInnerHeight);
        this.animationDirection = 1;
        this.animationHeight = 104;
        this.setStartPositions(-1, 104, -1, -1);
        this.setBoxIsAnimated(false, true, false, false);
    }

    private void setUpAnimation_1EE_123() {
        this.item = this.getFreeItem();
        this.setupItem(this.item, this.newData, 1, 2, 1, true, false);
        this.item = this.getFreeItem();
        this.setupItem(this.item, this.newData, 0, 3, 2, true, false);
        this.setW140_height_1(this.itemInnerHeight);
        this.setW140_height_2(this.itemInnerHeight);
        this.animationDirection = 1;
        this.animationHeight = 104;
        this.setStartPositions(-1, 104, 208, -1);
        this.setBoxIsAnimated(false, true, true, false);
    }

    private void setUpAnimation_12E_123() {
        this.item = this.getFreeItem();
        this.setupItem(this.item, this.newData, 0, 3, 2, true, false);
        this.setW140_height_2(this.itemInnerHeight);
        this.animationDirection = 1;
        this.animationHeight = 104;
        this.setStartPositions(-1, -1, 208, -1);
        this.setBoxIsAnimated(false, false, true, false);
    }

    private void setUpAnimation_112_234() {
        this.item = this.getItemAtPosition(0);
        this.setupItem(this.item, this.oldData, 1, 4, 0, true, true);
        this.item = this.getItemAtPosition(1);
        this.setupItem(this.item, this.oldData, 0, 1, 1, true, true);
        this.item = this.getItemAtPosition(2);
        this.setupItem(this.item, this.newData, 1, 2, 2, true, false);
        this.item = this.getFreeItem();
        this.setupItem(this.item, this.newData, 0, 3, 3, true, false);
        this.setW140_height_3(20547);
        this.setW140_height_0(this.itemInnerHeight);
        this.setW140_height_1(this.itemInnerHeight);
        this.setW140_height_2(this.itemInnerHeight);
        this.animationDirection = -1;
        this.animationHeight = 208;
        this.setStartPositions(312, 416, 520, 208);
        this.setBoxIsAnimated(true, true, true, true);
    }

    private void setUpAnimation_123_234() {
        this.item = this.getItemAtPosition(0);
        this.setupItem(this.item, this.oldData, 2, 4, 0, true, true);
        this.item = this.getItemAtPosition(1);
        this.setupItem(this.item, this.oldData, 1, 1, 1, true, true);
        this.item = this.getItemAtPosition(2);
        this.setupItem(this.item, this.oldData, 0, 2, 2, true, true);
        this.item = this.getFreeItem();
        this.setupItem(this.item, this.newData, 0, 3, 3, true, false);
        this.setW140_height_3(this.itemInnerHeight);
        this.setW140_height_0(this.itemInnerHeight);
        this.setW140_height_1(this.itemInnerHeight);
        this.setW140_height_2(this.itemInnerHeight);
        this.animationDirection = -1;
        this.animationHeight = 104;
        this.setStartPositions(208, 312, 416, 104);
        this.setBoxIsAnimated(true, true, true, true);
    }

    private void setUpAnimation_123_345() {
        this.item = this.getItemAtPosition(0);
        this.setupItem(this.item, this.oldData, 2, 4, 0, true, true);
        this.item = this.getItemAtPosition(1);
        this.setupItem(this.item, this.oldData, 1, 1, 1, true, true);
        this.item = this.getItemAtPosition(2);
        this.setupItem(this.item, this.oldData, 0, 2, 2, true, true);
        this.item = this.getFreeItem();
        this.setupItem(this.item, this.newData, 1, 3, 3, true, false);
        this.setW140_height_3(this.itemInnerHeight);
        this.setW140_height_0(this.itemInnerHeight);
        this.setW140_height_1(this.itemInnerHeight);
        this.setW140_height_2(this.itemInnerHeight);
        this.animationDirection = -1;
        this.animationHeight = 104;
        this.setStartPositions(208, 312, 416, 104);
        this.setBoxIsAnimated(true, true, true, true);
    }

    private void setUpAnimation_123_345_B() {
        this.item = this.getItemAtPosition(0);
        this.setupItem(this.item, this.oldData, 1, 4, 0, true, true);
        this.item = this.getItemAtPosition(1);
        this.setupItem(this.item, this.oldData, 0, 1, 1, true, true);
        this.item = this.getItemAtPosition(2);
        this.setupItem(this.item, this.newData, 1, 2, 2, true, false);
        this.item = this.getItemAtPosition(3);
        this.setupItem(this.item, this.newData, 0, 3, 3, true, false);
        this.setW140_height_3(this.itemInnerHeight);
        this.setW140_height_0(this.itemInnerHeight);
        this.setW140_height_1(this.itemInnerHeight);
        this.setW140_height_2(this.itemInnerHeight);
        this.animationDirection = -1;
        this.animationHeight = 104;
        this.setStartPositions(208, 312, 416, 104);
        this.setBoxIsAnimated(true, true, true, true);
    }

    private void setUpAnimation_123_124() {
        this.item = this.getItemAtPosition(0);
        this.setupItem(this.item, this.oldData, 2, 1, 0, true, true);
        this.item = this.getItemAtPosition(1);
        this.setupItem(this.item, this.oldData, 1, 2, 1, true, true);
        this.item = this.getItemAtPosition(2);
        this.setupItem(this.item, this.oldData, 0, 3, 2, true, true);
        this.item = this.getFreeItem();
        this.setupItem(this.item, this.newData, 0, 4, 3, true, false);
        this.setW140_height_0(this.itemInnerHeight);
        this.setW140_height_1(this.itemInnerHeight);
        this.setW140_height_2(this.itemInnerHeight);
        this.setW140_height_3(this.itemInnerHeight);
        this.animationDirection = -1;
        this.animationHeight = 104;
        this.setStartPositions(-1, -1, 312, 416);
        this.setBoxIsAnimated(false, false, true, true);
    }

    private void setUpAnimation_123_145() {
        this.item = this.getItemAtPosition(1);
        this.setupItem(this.item, this.oldData, 1, 2, 1, true, true);
        this.item = this.getItemAtPosition(2);
        this.setupItem(this.item, this.oldData, 0, 3, 2, true, true);
        this.item = this.getFreeItem();
        this.setupItem(this.item, this.newData, 1, 4, 3, true, false);
        this.setW140_height_0(this.itemInnerHeight);
        this.setW140_height_1(this.itemInnerHeight);
        this.setW140_height_2(this.itemInnerHeight);
        this.setW140_height_3(this.itemInnerHeight);
        this.animationDirection = -1;
        this.animationHeight = 104;
        this.setStartPositions(-1, 208, 312, 416);
        this.setBoxIsAnimated(false, true, true, true);
    }

    private void setUpAnimation_123_145_B() {
        this.item = this.getItemAtPosition(1);
        this.setupItem(this.item, this.oldData, 0, 2, 1, true, true);
        this.item = this.getItemAtPosition(2);
        this.setupItem(this.item, this.newData, 1, 3, 2, true, false);
        this.item = this.getItemAtPosition(3);
        this.setupItem(this.item, this.newData, 0, 4, 3, true, false);
        this.setW140_height_0(this.itemInnerHeight);
        this.setW140_height_1(this.itemInnerHeight);
        this.setW140_height_2(this.itemInnerHeight);
        this.setW140_height_3(this.itemInnerHeight);
        this.animationDirection = -1;
        this.animationHeight = 104;
        this.setStartPositions(-1, 208, 312, 416);
        this.setBoxIsAnimated(false, true, true, true);
    }

    private void setUpAnimation_123_344() {
        this.item = this.getItemAtPosition(0);
        this.setupItem(this.item, this.oldData, 2, 4, 0, true, true);
        this.item = this.getItemAtPosition(1);
        this.setupItem(this.item, this.oldData, 1, 1, 1, true, true);
        this.item = this.getItemAtPosition(2);
        this.setupItem(this.item, this.oldData, 0, 2, 2, true, true);
        this.item = this.getFreeItem();
        this.setupItem(this.item, this.newData, 0, 3, 3, true, false);
        this.item.setDoubleSized(true);
        this.setW140_height_0(this.itemInnerHeight);
        this.setW140_height_1(this.itemInnerHeight);
        this.setW140_height_2(20547);
        this.setW140_height_3(this.itemInnerHeight);
        this.animationDirection = -1;
        this.animationHeight = 104;
        this.setStartPositions(208, 312, 520, 104);
        this.setBoxIsAnimated(true, true, true, true);
    }

    private void setUpAnimation_123_344_B() {
        this.setW140_pos_0(31300);
        this.animationDirection = -1;
        this.animationHeight = 104;
        this.setStartPositions(104, 208, 416, -1);
        this.setBoxIsAnimated(true, true, true, false);
    }

    private void setUpAnimation_122_223() {
        this.item = this.getItemAtPosition(0);
        this.setupItem(this.item, this.oldData, 2, 4, 0, true, true);
        this.item = this.getItemAtPosition(1);
        this.setupItem(this.item, this.oldData, 0, 1, 1, true, true);
        this.item = this.getFreeItem();
        this.setupItem(this.item, this.newData, 0, 2, 2, true, false);
        this.setW140_height_0(20547);
        this.setW140_height_1(this.itemInnerHeight);
        this.setW140_height_3(this.itemInnerHeight);
        this.animationDirection = -1;
        this.animationHeight = 104;
        this.setStartPositions(312, 416, -1, 104);
        this.setBoxIsAnimated(true, true, false, true);
    }

    private void onStartAnimationBorderCrossingScaleUp() {
        this.item = this.getItemAtPosition(0);
        this.setupItem(this.item, this.oldData, 2, 4, 0, true, true);
        this.item = this.getItemAtPosition(1);
        this.setupItem(this.item, this.oldData, 1, 1, 1, true, true);
        this.item = this.getItemAtPosition(2);
        this.setupItem(this.item, this.oldData, 0, 2, 2, true, true);
        this.setW140_height_3(this.itemInnerHeight);
        this.setW140_pos_3(53314);
        this.setW140_pos_0(20547);
        this.setW140_pos_1(40003);
        this.setW140_pos_2(31300);
    }

    private void setUpAnimation_123_142() {
        this.item = this.getItemAtPosition(0);
        this.setupItem(this.item, this.oldData, 2, 1, 0, true, true);
        this.item = this.getItemAtPosition(1);
        this.setupItem(this.item, this.newData, 1, 2, 1, true, false);
        this.item = this.getItemAtPosition(2);
        this.setupItem(this.item, this.oldData, 1, 3, 2, true, true);
        this.item = this.getFreeItem();
        this.setupItem(this.item, this.oldData, 0, 4, 3, true, true);
        this.setW140_height_3(this.itemInnerHeight);
        this.setW140_height_0(this.itemInnerHeight);
        this.setW140_height_1(this.itemInnerHeight);
        this.setW140_height_2(this.itemInnerHeight);
        this.animationDirection = 1;
        this.animationHeight = 104;
        this.setStartPositions(-1, 104, 208, 312);
        this.setBoxIsAnimated(false, true, true, true);
    }

    private void popAnimation() {
        if (this.currentAnimationID == -1) {
            if (!this.bufferedAnimations.isEmpty()) {
                Integer n = (Integer)this.bufferedAnimations.remove(0);
                mixedListLogChannel.log(-2137614336, "MixedListController#popTransition %1", (Object)MixedListController2.getAnimationName(n));
                this.processTransition(n);
            } else if (!this.bufferedEvents.isEmpty()) {
                mixedListLogChannel.log(-2137614336, "MixedListController#popTransition pop event. %1 remaining.", (long)this.bufferedEvents.size());
                this.processModelUpdateEvent((ModelUpdateEvent)this.bufferedEvents.remove(0));
            }
        }
    }

    @Override
    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        if (modelUpdateEvent != null) {
            mixedListLogChannel.log(-2137614336, "MixedListController#processModelUpdateEvent %1", (Object)modelUpdateEvent);
        }
        if (!this.isActive()) {
            return;
        }
        if (!this.isConnected() || !this.shouldRender()) {
            mixedListLogChannel.log(-2137614336, "MixedListController#processModelUpdateEvent Return - Not visible %1 or not connected %2.", !this.shouldRender(), !this.isConnected());
            this.setDefaultState(true);
            return;
        }
        if (this.currentAnimationID != -1 || this.animationStarted || this.bufferedAnimations.size() > 0) {
            mixedListLogChannel.log(-2137614336, "MixedListController#processModelUpdateEvent Return - Animation is running %1, %2, %3.", (long)this.currentAnimationID, this.animationStarted ? 0L : 1L, (long)this.bufferedAnimations.size());
            return;
        }
        int n = modelUpdateEvent.getUpdateType();
        switch (n) {
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 16: {
                if (!this.checkModelAccess()) break;
                int[] nArray = new int[3];
                long[] lArray = MixedListController2.calculateIDs(this.newData, nArray);
                this.processModelUpdateEvent(lArray, nArray);
                break;
            }
            default: {
                mixedListLogChannel.log(10000, "MixedListController#processModelUpdateEvent unhandled updateType: %1", (long)n);
            }
        }
        if (this.isInvalid()) {
            this.renderer.invalidate();
        }
    }

    public void processModelUpdateEvent(long[] lArray, int[] nArray) {
        if (this.isDebugMode() && (!this.bufferedAnimations.isEmpty() || this.currentAnimationID != -1)) {
            new Timer("DebugTimer", 0, true, new MixedListController2$1(this)).start();
            return;
        }
        this.oldDataIDs = this.newDataIDs;
        this.newDataIDs = lArray;
        this.oldFormatIDs = this.newFormatIDs;
        this.newFormatIDs = nArray;
        int n = this.calculateTransitions(this.oldDataIDs, this.newDataIDs);
        if (n != -5) {
            if (!MixedListController2.checkForMultipleEventsWithIdenticalIDs(lArray)) {
                n = -6;
            }
            if (mixedListLogChannel.isDebug()) {
                mixedListLogChannel.log(-2137614336, "MixedListController#processModelUpdateEvent old IDs | new IDs");
                for (int i2 = 0; i2 < 3; ++i2) {
                    mixedListLogChannel.log(-2137614336, new StringBuffer().append(this.oldDataIDs[i2]).append(" ").append(this.newDataIDs[i2]).append(" ").append(MixedListController2.getFormatName(this.newFormatIDs[i2])).toString());
                }
            }
            this.pushAnimation(n);
        } else {
            this.refreshLabelTexts();
        }
        this.popAnimation();
    }

    private void pushAnimation(int n) {
        mixedListLogChannel.log(-2137614336, "MixedListController2#pushTransition %1", (Object)MixedListController2.getAnimationName(n));
        this.bufferedAnimations.add(new Integer(n));
    }

    private static String getFormatName(int n) {
        switch (n) {
            case -1: {
                return "NoContent";
            }
            case 3: {
                return "RouteCalc";
            }
            case 6: {
                return "BorderPassingTop";
            }
            case 7: {
                return "BorderPassingBottom";
            }
            case 9: {
                return "PicNavTop";
            }
            case 10: {
                return "PicNavBottom";
            }
            case 0: {
                return "Turn";
            }
            case 1: {
                return "POI";
            }
            case 2: {
                return "TMC";
            }
            case 8: {
                return "BorderPassingSingle";
            }
            case 5: {
                return "VZAPreview";
            }
            case 4: {
                return "LastExitWarning";
            }
        }
        return new StringBuffer().append("").append(n).toString();
    }

    private static String getStateName(int n) {
        switch (n) {
            case 3: {
                return "Box1";
            }
            case 2: {
                return "Box2";
            }
            case 1: {
                return "Box3";
            }
            case 4: {
                return "Box23";
            }
            case 5: {
                return "Box23_Box1";
            }
            case 6: {
                return "Box3_Box12";
            }
            case 0: {
                return "Empty";
            }
        }
        return new StringBuffer().append("Invalid state with ID ").append(n).toString();
    }

    private static String getAnimationName(int n) {
        switch (n) {
            case 1: {
                return "Move_In_0";
            }
            case 50: {
                return "Roll_Down";
            }
        }
        return new StringBuffer().append("Invalid animation ID: ").append(n).toString();
    }

    private void processTransition(int n) {
        mixedListLogChannel.log(-2137614336, "MixedListController2#processTransition %1, %2", (Object)MixedListController2.getAnimationName(n), (long)n);
        mixedListAfterPaint.log(-2137614336, "MixedListController2#processTransition %1, %2", (Object)MixedListController2.getAnimationName(n), (long)n);
        this.currentAnimationID = n;
        if (!this.isConnected() || !this.isVisible()) {
            mixedListLogChannel.log(-2137614336, "MixedListController#processTransition bypass animation due to connection = %1, visibility = %2", this.isConnected(), this.shouldRender());
            return;
        }
        boolean bl = false;
        switch (n) {
            case 1: 
            case 2: 
            case 3: 
            case 7: 
            case 14: 
            case 20: 
            case 24: 
            case 50: 
            case 51: 
            case 52: 
            case 53: 
            case 58: 
            case 62: 
            case 64: 
            case 73: 
            case 80: 
            case 103: 
            case 113: 
            case 114: 
            case 120: 
            case 122: 
            case 140: 
            case 160: 
            case 170: 
            case 1000: 
            case 1003: 
            case 1004: 
            case 1005: {
                this.startAnimation(90);
                bl = true;
                break;
            }
            case 1001: 
            case 1002: 
            case 2000: {
                this.startAnimation(31);
                bl = true;
                break;
            }
            case 9: 
            case 17: 
            case 90: 
            case 95: {
                if (!MixedListController2.isMMIKombi()) break;
                this.startAnimation(90);
                bl = true;
                break;
            }
            case 143: {
                this.startAnimation(90);
                bl = true;
                break;
            }
            case 78: {
                if (this.oldFormatIDs[0] != 8 || this.newFormatIDs[0] != 6 || this.newFormatIDs[1] != 7) break;
                this.startAnimation(90);
                bl = true;
                break;
            }
            case 79: {
                if (this.oldFormatIDs[2] != 8 || this.newFormatIDs[1] != 6 || this.newFormatIDs[2] != 7) break;
                this.startAnimation(90);
                bl = true;
                break;
            }
            case 77: {
                if (this.oldFormatIDs[1] != 8 || this.newFormatIDs[0] != 6 || this.newFormatIDs[1] != 7) break;
                this.startAnimation(90);
                bl = true;
                break;
            }
            case 81: {
                if (this.oldFormatIDs[1] != 8 || this.newFormatIDs[1] != 6 || this.newFormatIDs[2] != 7) break;
                this.startAnimation(90);
                bl = true;
                break;
            }
        }
        if (!bl) {
            this.setDefaultState(false);
            if (!framework.isTarget()) {
                this.pushAnimation(2000);
                this.popAnimation();
            }
            mixedListLogChannel.log(-2137614336, "MixedListController2#processTransition No animation implemented for transition %1", (long)n);
        }
    }

    public void setTextIds(int[] nArray) {
        this.textIDs = nArray;
    }

    private void setupItem(MixedListItemController2 mixedListItemController2, ListCell[][] listCellArray, int n, int n2, int n3, boolean bl, boolean bl2) {
        mixedListLogChannel.log(-2137614336, "MixedListController2#setupItem src = %1, content = %2, pos = %3", (long)n, (long)n2, (long)n3);
        if (n != -1) {
            if (listCellArray != null) {
                if (listCellArray[n] != null) {
                    if (bl) {
                        this.renderer.removeContent(new int[]{n2});
                    }
                    mixedListItemController2.removeChildren();
                    mixedListItemController2.setCurrentPosition(n3);
                    mixedListItemController2.setCurrentContentNode(n2);
                    mixedListItemController2.setupWidgetAndLayout(listCellArray[n], n, bl2);
                    mixedListItemController2.destroyRendererNode();
                } else {
                    mixedListLogChannel.log(-1601830656, "MixedListItemController2#setupItem Data item is null.");
                }
            } else {
                mixedListLogChannel.log(-1601830656, "MixedListItemController2#setupItem Data array is null.");
            }
        }
    }

    public void randomItemSetup() {
        int n = this.random.nextInt(3);
        this.item = this.getItemAtPosition(0);
        this.setupItem(this.item, this.oldData, n, 4, 0, true, true);
        this.setW140_pos_3(53314);
        this.setW140_height_3(this.itemInnerHeight);
        if (!MixedListController2.isMMIKombi()) {
            this.item = this.getItemAtPosition(1);
            this.setupItem(this.item, this.oldData, (n + 1) % 3, 1, 1, true, true);
            this.item = this.getItemAtPosition(2);
            this.setupItem(this.item, this.oldData, (n + 2) % 3, 2, 2, true, true);
            this.setW140_pos_0(20547);
            this.setW140_pos_1(40003);
            this.setW140_height_0(this.itemInnerHeight);
            this.setW140_height_1(this.itemInnerHeight);
        }
        this.setCompositesDirty(true);
    }

    private boolean readDataFromModel(ListCell[][] listCellArray) {
        if (this.listModel != null) {
            if (listCellArray.length != this.listModel.getMaxRows()) {
                mixedListLogChannel.log(10000, "MixedListController#readDataFromModel Dimensions don't fit.");
                return false;
            }
            for (int i2 = 0; i2 < listCellArray.length; ++i2) {
                if (this.listModel.getRow(i2, listCellArray[i2])) continue;
                mixedListLogChannel.log(10000, "MixedListController#readDataFromModel couldn't get row: %1", (long)i2);
                return false;
            }
            return true;
        }
        return false;
    }

    private void refreshLabelTexts() {
        mixedListLogChannel.log(-2137614336, "MixedListController#refreshLabelTexts");
        for (int i2 = 0; i2 < this.items.length; ++i2) {
            int n;
            MixedListItemController2 mixedListItemController2 = this.items[i2];
            if (mixedListItemController2 == null || mixedListItemController2.isOldData() || (n = mixedListItemController2.getCurrentPosition()) == -1) continue;
            int n2 = mixedListItemController2.getCurrentModelRow();
            mixedListItemController2.refreshLabelTexts(this.newData[n2], this.oldData[n2]);
        }
    }

    private void skipAnimation() {
        if (this.currentAnimationID != -1 && this.animation != null && this.animation.isAnimating()) {
            mixedListLogChannel.log(-2137614336, "MixedListController2#seekAnimation Last animation value was %1.", (double)this.lastAnimationValue);
            this.animation(this.currentAnimationID, 1.0f);
            this.animation.stopAnimation();
        }
    }

    @Override
    public void render(RedrawContext redrawContext) {
        mixedListAfterPaint.log(-2137614336, "MixedListController2#render");
        super.render(redrawContext);
    }

    @Override
    public void setBounds(int n, int n2, int n3, int n4) {
        super.setBounds(n, n2, n3, n4);
    }

    @Override
    public void setCompositesDirty(boolean bl) {
        super.setCompositesDirty(bl);
        this.renderer.invalidate();
    }

    /*
     * Unable to fully structure code
     */
    private void setDefaultState(boolean var1_1) {
        block13: {
            block14: {
                MixedListController2.mixedListLogChannel.log(-2137614336, "");
                MixedListController2.mixedListLogChannel.log(-2137614336, "MixedListController#setDefaultState");
                if (!this.checkModelAccess()) break block13;
                var2_2 = null;
                if (!this.isDebugMode()) break block14;
                var2_2 = this.newDataIDs;
                ** GOTO lbl-1000
            }
            this.oldDataIDs = this.newDataIDs;
            this.oldFormatIDs = this.newFormatIDs;
            var3_3 = new int[3];
            this.newDataIDs = var2_2 = MixedListController2.calculateIDs(this.newData, var3_3);
            this.newFormatIDs = var3_3;
            if (var1_1 && !this.justSetOnScreen && this.oldDataIDs != null && this.oldDataIDs[0] == this.newDataIDs[0] && this.oldDataIDs[1] == this.newDataIDs[1] && this.oldDataIDs[2] == this.newDataIDs[2]) {
                MixedListController2.mixedListLogChannel.log(-2137614336, "MixedListController#setDefaultState No state change.");
            } else lbl-1000:
            // 3 sources

            {
                for (var3_4 = 0; var3_4 < this.items.length; ++var3_4) {
                    this.items[var3_4].setCurrentContentNode(-1);
                    this.items[var3_4].setCurrentPosition(-1);
                }
                this.setW140_pos_0(31300);
                this.setW140_pos_1(31300);
                this.setW140_pos_2(31300);
                this.setW140_pos_3(31300);
                this.currentStateID = 0;
                var4_5 = this.calculateTransitions(new long[]{-1L, -1L, -1L}, var2_2);
                this.bufferedAnimations.clear();
                MixedListController2.mixedListLogChannel.log(-2137614336, "MixedListController#setDefaultState t_id = %1", (long)var4_5);
                switch (var4_5) {
                    case 1: {
                        this.item = this.items[0];
                        this.setupItem(this.item, this.newData, 2, 1, 0, true, false);
                        this.setW140_pos_0(53314);
                        this.setW140_height_0(this.itemInnerHeight);
                        this.item.setDoubleSized(false);
                        this.item.setOpacity(1.0f);
                        this.setW140_pos_1(31300);
                        this.setW140_pos_2(31300);
                        this.setW140_pos_3(31300);
                        this.items[1].setCurrentPosition(-1);
                        if (!MixedListController2.isMMIKombi()) {
                            this.items[2].setCurrentPosition(-1);
                            this.items[3].setCurrentPosition(-1);
                        }
                        this.currentStateID = 1;
                        break;
                    }
                    case 2: {
                        this.item = this.items[0];
                        this.setupItem(this.item, this.newData, 2, 1, 0, true, false);
                        this.setW140_pos_0(53314);
                        this.setW140_height_0(this.itemInnerHeight);
                        this.item.setDoubleSized(false);
                        this.item = this.items[1];
                        this.setupItem(this.item, this.newData, 1, 2, 1, true, false);
                        this.setW140_pos_1(20547);
                        this.setW140_height_1(this.itemInnerHeight);
                        this.item.setDoubleSized(false);
                        this.setW140_pos_2(31300);
                        this.setW140_pos_3(31300);
                        this.items[2].setCurrentPosition(-1);
                        this.items[3].setCurrentPosition(-1);
                        this.currentStateID = 2;
                        break;
                    }
                    case 3: {
                        this.item = this.items[0];
                        this.setupItem(this.item, this.newData, 2, 1, 0, true, false);
                        this.setW140_pos_0(53314);
                        this.setW140_height_0(this.itemInnerHeight);
                        this.item.setDoubleSized(false);
                        this.item = this.items[1];
                        this.setupItem(this.item, this.newData, 1, 2, 1, true, false);
                        this.setW140_pos_1(20547);
                        this.setW140_height_1(this.itemInnerHeight);
                        this.item.setDoubleSized(false);
                        this.item = this.items[2];
                        this.setupItem(this.item, this.newData, 0, 3, 2, true, false);
                        this.setW140_pos_2(40003);
                        this.setW140_height_2(this.itemInnerHeight);
                        this.item.setDoubleSized(false);
                        this.setW140_pos_3(31300);
                        this.items[3].setCurrentPosition(-1);
                        this.currentStateID = 3;
                        break;
                    }
                    case 4: {
                        this.item = this.items[0];
                        this.setupItem(this.item, this.newData, 1, 1, 0, true, false);
                        this.setW140_pos_0(MixedListController2.isMMIKombi() != false ? 8259 : 20547);
                        this.setW140_height_0(MixedListController2.isMMIKombi() != false ? 7491 : 20547);
                        this.item.setDoubleSized(true);
                        this.item.setOpacity(1.0f);
                        this.setW140_pos_1(31300);
                        this.setW140_pos_2(31300);
                        this.setW140_pos_3(31300);
                        this.items[1].setCurrentPosition(-1);
                        if (!MixedListController2.isMMIKombi()) {
                            this.items[2].setCurrentPosition(-1);
                            this.items[3].setCurrentPosition(-1);
                        }
                        this.currentStateID = 4;
                        break;
                    }
                    case 5: {
                        this.item = this.items[0];
                        this.setupItem(this.item, this.newData, 1, 1, 0, true, false);
                        this.setW140_pos_0(20547);
                        this.setW140_height_0(20547);
                        this.item.setDoubleSized(true);
                        this.item = this.items[1];
                        this.setupItem(this.item, this.newData, 0, 2, 1, true, false);
                        this.setW140_pos_1(40003);
                        this.setW140_height_1(this.itemInnerHeight);
                        this.item.setDoubleSized(false);
                        this.setW140_pos_2(31300);
                        this.setW140_pos_3(31300);
                        this.items[2].setCurrentPosition(-1);
                        this.items[3].setCurrentPosition(-1);
                        this.currentStateID = 5;
                        break;
                    }
                    case 6: {
                        this.item = this.items[0];
                        this.setupItem(this.item, this.newData, 2, 1, 0, true, false);
                        this.setW140_pos_0(53314);
                        this.setW140_height_0(this.itemInnerHeight);
                        this.item.setDoubleSized(false);
                        this.item = this.items[1];
                        this.setupItem(this.item, this.newData, 0, 2, 1, true, false);
                        this.setW140_pos_1(40003);
                        this.setW140_height_1(20547);
                        this.item.setDoubleSized(true);
                        this.setW140_pos_2(31300);
                        this.setW140_pos_3(31300);
                        this.items[2].setCurrentPosition(-1);
                        this.items[3].setCurrentPosition(-1);
                        this.currentStateID = 6;
                        break;
                    }
                    default: {
                        MixedListController2.mixedListLogChannel.log(-2137614336, "MixedListController2#setDefaultState Invalid transition ID: %1", (long)var4_5);
                    }
                }
                MixedListController2.mixedListLogChannel.log(-2137614336, "MixedListController2#setDefaultState %1", (Object)MixedListController2.getStateName(this.currentStateID));
                MixedListController2.mixedListLogChannel.log(-2137614336, "");
                this.setCompositesDirty(true);
            }
        }
        this.currentAnimationID = -1;
        this.animationStarted = false;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void setVisible(boolean bl) {
        mixedListLogChannel.log(-2137614336, "MixedListController2#setVisible %1", bl);
        mapControllerLogCh.log(-2137614336, "MixedListController2#setVisible %1", bl);
        if (!this.isActive()) {
            if (!this.isVisible()) return;
            this.setVisibleInternal(false);
            return;
        }
        if (MixedListRenderer.isKZBMerged()) {
            if (!MixedListController2.isMMIKombi() && this.currentStateID != 0 && this.isConnected()) {
                boolean bl2;
                boolean bl3 = this.simulateScreenChangeAnimationRunning;
                AbstractAnimationController abstractAnimationController = (AbstractAnimationController)this.getTerminal().getIAnimationController();
                if (abstractAnimationController instanceof AnimationControllerMIB2High) {
                    bl3 = abstractAnimationController.isScreenChangeAnimationRunning();
                }
                boolean bl4 = this.isVisible() && !bl;
                boolean bl5 = bl2 = !this.isVisible() && bl;
                if (this.animation != null && this.animation.isAnimating()) {
                    if (!(this.currentAnimationID == 1002 && bl || this.currentAnimationID == 1001 && !bl)) {
                        mixedListLogChannel.log(-2137614336, "MixedListController2#setVisible Stop animation.");
                        if (bl4 || bl2) {
                            this.skipAnimation();
                        }
                    } else {
                        mixedListLogChannel.log(-2137614336, "MixedListController2#setVisible No state change. Return (1).");
                        return;
                    }
                }
                if (bl4) {
                    if (!bl3) {
                        this.pushAnimation(1001);
                        this.popAnimation();
                        return;
                    }
                    this.setVisibleInternal(bl);
                    mixedListLogChannel.log(-2137614336, "MixedListController2#setVisible Screen-Change animation is running.");
                    return;
                }
                if (bl2) {
                    this.setOpacity(0.0f);
                    this.setVisibleInternal(bl);
                    this.pushAnimation(1002);
                    this.popAnimation();
                    return;
                }
                mixedListLogChannel.log(-2137614336, "MixedListController2#setVisible No state change. Return (2).");
                return;
            }
            if (this.isVisible() == bl) return;
            this.setVisibleInternal(bl);
            return;
        }
        this.visibleStateBeforeKZBMerged = bl ? 1 : 0;
        mixedListLogChannel.log(-2137614336, "MixedListController2#setVisible not successful: Renderer is not ready.");
    }

    private void setVisibleInternal(boolean bl) {
        mixedListLogChannel.log(-2137614336, "MixedListController2#setVisibleInternal %1", bl);
        super.setVisible(bl);
        if (!this.isConnected()) {
            return;
        }
    }

    private void startAnimation(int n) {
        if (!(this.animation != null && this.animation.isAnimating() || this.animationDisabled)) {
            this.getAnimation(n);
            this.animation.startDynamicAnimation(0.0f, 31300, n, false, this);
        }
    }

    public MixedListLayout getPixelExactLayout(int n) {
        mixedListLogChannel.log(-2137614336, "MixedListController#getPixelExactLayout for format = %1", (long)n);
        return (MixedListLayout)this.pixelExactLayouts.get(new Integer(n));
    }

    @Override
    public IRenderer getRenderer() {
        return this.renderer;
    }

    public String getText(int n) {
        if (this.textIDs != null && 0 <= n && n < this.textIDs.length) {
            return this.getInitContext().getScreenFactory().getText(this.textIDs[n]);
        }
        return "";
    }

    public void setIsActiveOnG24(boolean bl) {
        this.isActiveInG24 = bl;
    }

    public void setRenderer(MixedListRenderer mixedListRenderer) {
        this.renderer = mixedListRenderer;
    }

    public float getW140_height_0() {
        return this.w140_height_0;
    }

    private void setW140_height_0(float f2) {
        this.w140_height_0 = f2;
    }

    public float getW140_height_1() {
        return this.w140_height_1;
    }

    private void setW140_height_1(float f2) {
        this.w140_height_1 = f2;
    }

    public float getW140_height_2() {
        return this.w140_height_2;
    }

    private void setW140_height_2(float f2) {
        this.w140_height_2 = f2;
    }

    public float getW140_height_3() {
        return this.w140_height_3;
    }

    private void setW140_height_3(float f2) {
        this.w140_height_3 = f2;
    }

    public float getW140_pos_0() {
        return this.w140_pos_0;
    }

    private void setW140_pos_0(float f2) {
        this.w140_pos_0 = f2;
    }

    public float getW140_pos_1() {
        return this.w140_pos_1;
    }

    private void setW140_pos_1(float f2) {
        this.w140_pos_1 = f2;
    }

    public float getW140_pos_2() {
        return this.w140_pos_2;
    }

    private void setW140_pos_2(float f2) {
        this.w140_pos_2 = f2;
    }

    public float getW140_pos_3() {
        return this.w140_pos_3;
    }

    private void setW140_pos_3(float f2) {
        this.w140_pos_3 = f2;
    }

    public float getW140_contentOpacity_0() {
        return this.w140_contentOpacity_0;
    }

    public boolean getW140_footerVisibility() {
        return this.w140_footerVisibility;
    }

    private void setW140_contentOpacity_0(float f2) {
        this.w140_contentOpacity_0 = f2;
    }

    public float getW140_contentOpacity_1() {
        return this.w140_contentOpacity_1;
    }

    public float getW140_contentOpacity_2() {
        return this.w140_contentOpacity_2;
    }

    public float getW140_contentOpacity_3() {
        return this.w140_contentOpacity_3;
    }

    public float getW140_overallHeight() {
        float[] fArray = new float[]{this.w140_pos_0, this.w140_pos_1, this.w140_pos_2, this.w140_pos_3};
        float f2 = 0.0f;
        for (int i2 = 0; i2 < fArray.length; ++i2) {
            if (!(fArray[i2] < 31300) || !(fArray[i2] > f2)) continue;
            f2 = fArray[i2];
        }
        float f3 = Math.min(f2, (float)40003);
        return f3;
    }

    private void setW140_footerVisibility(boolean bl) {
        this.w140_footerVisibility = bl;
    }

    @Override
    public List getDiagnosisChildren() {
        return null;
    }

    private void setBoxIsAnimated(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.isBoxAnimated[0] = bl;
        this.isBoxAnimated[1] = bl2;
        this.isBoxAnimated[2] = bl3;
        this.isBoxAnimated[3] = bl4;
    }

    private void setStartPositions(int n, int n2, int n3, int n4) {
        this.startPositions[0] = n;
        this.startPositions[1] = n2;
        this.startPositions[2] = n3;
        this.startPositions[3] = n4;
    }

    @Override
    public void kZBMergedCallback(boolean bl) {
        mixedListLogChannel.log(-2137614336, "MixedListController#kZBMergedCallback success = %1, visibleStateBeforeConnected = %2", bl, (long)this.visibleStateBeforeKZBMerged);
        if (this.visibleStateBeforeKZBMerged != -1) {
            if (this.visibleStateBeforeKZBMerged == 0 && this.isVisible() || this.visibleStateBeforeKZBMerged == 1 && !this.isVisible()) {
                this.setVisible(this.visibleStateBeforeKZBMerged == 1);
            }
            this.visibleStateBeforeKZBMerged = -1;
        }
    }

    public static int getInnerWidth() {
        if (MixedListLayoutPackage.isKombi) {
            return 241;
        }
        if (!MixedListLayoutPackage.isNAR) {
            return 241;
        }
        return 268;
    }

    public static int getInnerHeight() {
        return MixedListController2.isMMIKombi() ? 99 : 104;
    }

    public static int getInnerHeightDoubleSize() {
        return MixedListController2.isMMIKombi() ? 157 : 208;
    }

    public void setDebugMode(boolean bl) {
        this.isInDebugMode = bl;
    }

    static /* synthetic */ long[] access$000(MixedListController2 mixedListController2) {
        return mixedListController2.newDataIDs;
    }

    static {
        onScreen = true;
    }
}

