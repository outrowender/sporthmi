/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.event.AsyncBitmapEvent;
import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.event.TouchEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.BaseListModel;
import de.audi.atip.hmi.model.list.GuiListRow;
import de.audi.atip.hmi.model.list.TiledListModelGUI;
import de.audi.atip.hmi.view.AnimationListener;
import de.audi.tghu.hmi.evo.IFocusedPropertyObject;
import de.audi.tghu.hmi.evo.IFocusedPropertyProvider;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.HMIImage;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimationController;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedTexture;
import de.esolutions.hmi.widgets.audi.base.eal.TextureDescription;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.FocusedPropertyObject;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.CompositeRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IPictureWallCallbackReceiver;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.ListScrollingController;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.PictureViewer;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.PictureWallCache;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.PictureWallCache$CachedTexture;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.PictureWallController$1;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.PictureWallIconRenderer;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.PictureWallLineController;
import de.esolutions.hmi.widgets.audi.evo.widgets.CompositeRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.FocusCursorController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.ScrollbarController;

public class PictureWallController
extends AbstractWidgetController
implements AnimationListener,
IFocusedPropertyProvider {
    public static PictureWallController singleton;
    public static final int BLOCK_SIZE;
    private static final int PIC_BOX_COLUMN_PROPERTY;
    protected static final int PICTURE_WIDTH;
    protected static final int PICTURE_HEIGHT;
    protected static final int PICTURE_GAP_VERTICAL;
    protected static final int PICTURE_WIDTH_LARGE;
    protected static final int PICTURE_HEIGHT_LARGE;
    private static final int INNER_CURSOR_HEIGHT;
    private static final int INNER_CURSOR_WIDTH;
    private static final int BORDER_LEFT;
    private static final int BORDER_RIGHT;
    private static final int BORDER_BOTTOM;
    private static final int BORDER_TOP;
    private static final int CURSOR_OFFSET_LEFT;
    private static final int CURSOR_OFFSET_TOP;
    protected static final int SMALL_OVERLAY_WIDTH;
    protected static final int LARGE_OVERLAY_LEFT_OFFSET;
    protected static final int LARGE_OVERLAY_TOP_OFFSET;
    protected static final int BORDER_WIDTH;
    protected static final int BORDER_HEIGHT;
    public static final int[] X_POS_LARGE_IMAGES;
    public static final int Y_POS_LARGE_IMAGES;
    private static final int CURSOR_ICON_WIDTH;
    private static final int CURSOR_ICON_HEIGHT;
    private static final int CURSOR_ICON_X;
    private static final int CURSOR_ICON_Y;
    public static final int ANIMATION_TYPE;
    public static final int ANIMATION_TYPE_FAST;
    protected static final int BITMAP_EMPTY;
    protected static final int BITMAP_GLASS;
    protected static final int BITMAP_GLASS2;
    protected static final int BITMAP_BLACK;
    protected static final int BITMAP_CURSOR_ICON;
    protected static final int BITMAP_CURSOR_ICON_HIGHLIGHTED;
    protected static final int BITMAP_FRAME;
    private static final int SCROLL;
    private static final int CURSOR;
    private static final int NUMBER_OF_LINES_IN_VIEWPORT;
    private static final int NUMBER_OF_VISIBLE_LINES;
    private PictureViewer parentController;
    private boolean isSetUp = false;
    private boolean singleMode = false;
    private PictureWallLineController[] lines;
    private int dy = 0;
    private int clicksToDo = 0;
    private int cursorOffset = 16;
    private int cursorPosition = 0;
    private int linePosition = 0;
    private int cursorPositionInSingleMode = 0;
    private IPictureWallCallbackReceiver dbgCache;
    private FocusCursorController cursor;
    private ScrollbarController scrollbar;
    private AbstractAnimation animation;
    private int currentAnimation = -1;
    private ListScrollingController listScroll;
    private PictureWallCache cache;
    private IconController cursorIcon;
    private CompositeRendererHigh renderer;

    @Override
    public void add(AbstractWidget abstractWidget) {
        if (abstractWidget instanceof FocusCursorController) {
            this.cursor = (FocusCursorController)abstractWidget;
            this.cursor.setBounds(12, 16, 644, 93);
        } else if (abstractWidget instanceof ScrollbarController) {
            this.scrollbar = (ScrollbarController)abstractWidget;
        }
        super.add(abstractWidget);
    }

    @Override
    public void bitmapLoaded(AsyncBitmapEvent asyncBitmapEvent) {
        pictureWallLogCh.log(-2137614336, "PictureWallController#bitmapLoaded");
        String string = asyncBitmapEvent.getResourceLocator().getResourceURI();
        EALManager eALManager = this.renderer.getEALManager();
        IWrappedTexture iWrappedTexture = null;
        boolean bl = false;
        TextureDescription textureDescription = eALManager.createTextureDescription(new HMIImage(string, 6), null, false);
        if (textureDescription != null) {
            iWrappedTexture = textureDescription.createTexture();
        } else {
            bl = true;
        }
        if (iWrappedTexture == null) {
            pictureWallLogCh.log(10000, "PictureWallController#bitmapLoaded Texture %1 is not valid.", (Object)string);
            bl = true;
        }
        if (!this.cache.containsTexture(string)) {
            pictureWallLogCh.log(10000, "PictureWallController#bitmapLoaded Texture %1 is not contained in the cache.", (Object)string);
            eALManager.destroy(iWrappedTexture);
        } else {
            PictureWallCache$CachedTexture pictureWallCache$CachedTexture = this.cache.retrieveCachedTexture(string);
            pictureWallCache$CachedTexture.data = iWrappedTexture;
            pictureWallCache$CachedTexture.loadingError = bl;
            pictureWallLogCh.log(-2137614336, "PictureWallController#bitmapLoaded Texture %1 loaded.", (Object)string);
            if (pictureWallCache$CachedTexture.listener != null) {
                pictureWallLogCh.log(-2137614336, "PictureWallController#bitmapLoaded Notify listener.");
                pictureWallCache$CachedTexture.listener.imageLoaded(pictureWallCache$CachedTexture.path);
            }
            this.cache.sendDbgCacheControllerCallback(5, null);
        }
    }

    private void bringCursorToFront() {
        this.remove(this.cursor);
        this.add(this.cursor);
        this.cursor.setY(this.cursorOffset);
    }

    @Override
    public void connected(InitializationContext initializationContext) {
        this.setUpWidget();
        super.connected(initializationContext);
        this.cache.connected(initializationContext);
        this.setLinesRows();
        this.setLinesY(0);
        this.setLinesPictures();
        this.remove(this.cursor);
        this.add(this.cursor);
        this.remove(this.scrollbar);
        this.add(this.scrollbar);
        this.updateScrollbar(0.0f);
        this.listScroll.connected(initializationContext);
        pictureWallLogCh.log(-2137614336, "PictureWallController#connected The widget is now connected.");
    }

    private void decreaseLinePosition() {
        --this.linePosition;
        this.cache.updateTextureCache(this.getLineIndex());
    }

    @Override
    protected void destroyWidget() {
    }

    private void hideLargePreview(int n, boolean bl) {
        pictureWallLogCh.log(-2137614336, "PictureWallController#hideLargePreview");
        this.lines[this.cursorPosition + 1].hideLargePreview(n, bl);
    }

    private void increaseLinePosition() {
        ++this.linePosition;
        this.cache.updateTextureCache(this.getLineIndex());
    }

    @Override
    protected void initializeWidget() {
        pictureWallLogCh.log(-2137614336, "PictureWallController#initializeWidget");
        this.terminal.getDrawerFocusManager().registerFocusPropertyProvider(this);
    }

    public boolean isSingleMode() {
        return this.singleMode;
    }

    private boolean isValidDestination(int n) {
        int n2 = this.cache.getNumberOfModelRows();
        return 0 <= n && n < n2;
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int n = keyEvent.getKeyCode();
        pictureWallLogCh.log(-2137614336, "PictureWallController#keyPressed key code = %1", (long)n);
        if (!(this.clicksToDo != 0 || this.animation != null && this.animation.isAnimating())) {
            if (n == 17) {
                if (!this.isSingleMode()) {
                    if (!this.listScroll.isCurrentlyScrolling()) {
                        this.enterSingleMode();
                    }
                } else if (this.cursorPositionInSingleMode == 4) {
                    this.exitSingleMode();
                } else {
                    this.sendSelectedPictureCallbackToApplication();
                }
            } else if (n == 15 && this.isSingleMode()) {
                this.exitSingleMode();
                keyEvent.consume();
            }
        }
    }

    @Override
    public void keyMoved(JoystickEvent joystickEvent) {
        if (this.clicksToDo == 0 && (this.animation == null || !this.animation.isAnimating()) && joystickEvent.getDirection() == 8 && this.isSingleMode()) {
            this.exitSingleMode();
            joystickEvent.consume();
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }

    @Override
    public void keyTurned(WheelButtonEvent wheelButtonEvent) {
        int n = wheelButtonEvent.getClickCount();
        int n2 = wheelButtonEvent.getSubClickCount();
        int n3 = wheelButtonEvent.getDirection();
        pictureWallLogCh.log(-2137614336, "PictureWallController#keyTurned clickCount = %1, subClickCount = %2, direction = %3", (long)n, (long)n2, (long)n3);
        if (n > 0) {
            if (!this.isSingleMode()) {
                this.processKeyTurned(wheelButtonEvent);
            } else {
                this.processKeyTurnedSingleMode(n, n3);
            }
        }
    }

    private void positionElements0(float f2) {
        pictureWallScrollingLogCh.log(-1601830656, "PictureWallController#positionElements0 pCurrent = %1", (double)f2);
        int n = this.listScroll.getCurrentLine();
        int n2 = this.linePosition - n;
        if (Math.abs(n2) == 1) {
            if (n2 > 0) {
                this.decreaseLinePosition();
            } else {
                this.increaseLinePosition();
            }
            this.rollLines(n2 > 0);
            this.setLinesPictures();
            this.cache.sendDbgCacheControllerCallback(1, new Object[]{new Integer(n)});
        } else if (n2 > 1) {
            pictureWallScrollingLogCh.log(-1601830656, "PictureWallController#positionElements0 More than 1 line (%1) passed in a single animation step!", (long)n2);
        }
        int n3 = this.getScrollStepLength();
        int n4 = n * n3;
        int n5 = (int)((float)n4 - f2);
        this.setLinesY(n5);
        this.updateScrollbar(-((float)n5) / (float)n3);
    }

    private void processKeyTurned(WheelButtonEvent wheelButtonEvent) {
        block15: {
            int n;
            int n2;
            block16: {
                n2 = wheelButtonEvent.getClickCount();
                n = wheelButtonEvent.getDirection();
                if (this.animation != null && this.animation.isAnimating()) break block15;
                if (n != 0) break block16;
                switch (this.cursorPosition) {
                    case 0: {
                        if (this.linePosition + 1 < this.getNumberOfLines()) {
                            this.dy = n2 * n == 0 ? 1 : -1;
                            this.currentAnimation = 1;
                            this.startAnimation(92);
                            break;
                        }
                        break block15;
                    }
                    case 1: {
                        if (this.linePosition + 3 < this.getNumberOfLines()) {
                            this.listScroll.setLineHeight(this.getScrollStepLength());
                            this.listScroll.setNumberOfLines(this.getNumberOfLines());
                            this.listScroll.keyTurned(wheelButtonEvent);
                            break;
                        }
                        this.dy = n2 * n == 0 ? 1 : -1;
                        this.currentAnimation = 1;
                        this.startAnimation(92);
                        break;
                    }
                    case 2: {
                        break;
                    }
                }
                break block15;
            }
            if (n == 1) {
                switch (this.cursorPosition) {
                    case 0: {
                        break;
                    }
                    case 1: {
                        if (this.linePosition - 1 >= 0) {
                            this.listScroll.setLineHeight(this.getScrollStepLength());
                            this.listScroll.setNumberOfLines(this.getNumberOfLines());
                            this.listScroll.keyTurned(wheelButtonEvent);
                            break;
                        }
                        if (!this.listScroll.isCurrentlyScrolling()) {
                            this.dy = n2 * n == 0 ? 1 : -1;
                            this.currentAnimation = 1;
                            this.startAnimation(92);
                            break;
                        }
                        this.listScroll.keyTurned(wheelButtonEvent);
                        break;
                    }
                    case 2: {
                        this.dy = n2 * n == 0 ? 1 : -1;
                        this.currentAnimation = 1;
                        this.startAnimation(92);
                        break;
                    }
                }
            }
        }
    }

    private void processKeyTurnedSingleMode(int n, int n2) {
        pictureWallLogCh.log(-2137614336, "PictureWallController#processKeyTurnedSingleMode clicks = %1, direction = %2", (long)n, (long)n2);
        if (n2 == 0) {
            if (this.cursorPositionInSingleMode < 4) {
                int n3;
                int n4 = this.getSelectedModelRow(n3);
                for (n3 = this.cursorPositionInSingleMode + 1; !this.isValidDestination(n4) && n3 < 4; ++n3) {
                    ++n4;
                }
                if (n3 == 4) {
                    this.showCursorCloseIcon(true, true);
                }
                if (n3 <= 4) {
                    this.hideLargePreview(this.cursorPositionInSingleMode, true);
                    this.cursorPositionInSingleMode = n3;
                }
                if (this.cursorPositionInSingleMode < 4) {
                    this.showLargePreview(this.cursorPositionInSingleMode);
                    this.sendFocusedPictureCallbackToApplication();
                    this.sendFocusedPropertyToDrawerConditionEngine();
                }
            }
        } else if (n2 == 1 && this.cursorPositionInSingleMode > 0) {
            int n5;
            int n6 = this.getSelectedModelRow(n5);
            for (n5 = this.cursorPositionInSingleMode - 1; !this.isValidDestination(n6) && n5 >= 0; --n5) {
                --n6;
            }
            if (n5 < 0) {
                n5 = 4;
            }
            if (this.cursorPositionInSingleMode == 4) {
                this.showCursorCloseIcon(true, false);
            } else if (this.cursorPositionInSingleMode < 4) {
                this.hideLargePreview(this.cursorPositionInSingleMode, true);
            }
            this.cursorPositionInSingleMode = n5;
            this.showLargePreview(this.cursorPositionInSingleMode);
            this.sendFocusedPictureCallbackToApplication();
            this.sendFocusedPropertyToDrawerConditionEngine();
        }
    }

    @Override
    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        pictureWallLogCh.log(-2137614336, "PictureWallController#processModelUpdateEvent");
        this.cache.processModelUpdateEvent(modelUpdateEvent);
        this.setLinesPictures();
        if (this.isSingleMode() && 0 <= this.cursorPositionInSingleMode && this.cursorPositionInSingleMode <= 4) {
            this.sendFocusedPictureCallbackToApplication();
            this.sendFocusedPropertyToDrawerConditionEngine();
        }
    }

    public void requestTexture(String string, int n, PictureWallIconRenderer pictureWallIconRenderer) {
        this.cache.requestTexture(string, n, pictureWallIconRenderer);
    }

    private void rollLines(boolean bl) {
        int n = 4;
        if (bl) {
            PictureWallLineController pictureWallLineController = this.lines[n];
            for (int i2 = n; i2 > 0; --i2) {
                this.lines[i2] = this.lines[i2 - 1];
            }
            this.lines[i2] = pictureWallLineController;
        } else {
            PictureWallLineController pictureWallLineController = this.lines[0];
            for (int i3 = 0; i3 < n; ++i3) {
                this.lines[i3] = this.lines[i3 + 1];
            }
            this.lines[i3] = pictureWallLineController;
        }
        this.setLinesRows();
        this.setLinesY(0);
    }

    private void setLinesPictures() {
        int n = 0;
        if (this.linePosition == 0) {
            n = 1;
        }
        int n2 = 5;
        if (this.linePosition + 3 >= this.getNumberOfLines()) {
            --n2;
        }
        while (n < n2) {
            for (int i2 = 0; i2 < 4; ++i2) {
                this.setPictureAt(n, i2, this.linePosition * 4 + (n - 1) * 4 + i2);
            }
            ++n;
        }
    }

    private void setLinesRows() {
        for (int i2 = 0; i2 < this.lines.length; ++i2) {
            this.lines[i2].setRow(i2 - 1);
        }
    }

    private void setLinesY(int n) {
        int n2 = (this.getHeight() - 24 - 24 - 56) / 3;
        int n3 = 24 + n - n2 - 28;
        for (int i2 = 0; i2 < 5; ++i2) {
            this.lines[i2].setY(n3);
            n3 += n2 + 28;
        }
    }

    private void sendFocusedPictureCallbackToApplication() {
        int n;
        BaseListModel baseListModel;
        GuiListRow guiListRow;
        if (this.model instanceof BaseListModel && (guiListRow = (baseListModel = (BaseListModel)this.model).getGuiRow(n = this.getSelectedModelRow())) != null) {
            long l = guiListRow.getUniqueID();
            pictureWallLogCh.log(-2137614336, "PictureWallController#sendFocusedPictureCallbackToApplication modelRow = %1, uniqueID = %2", (long)n, l);
            baseListModel.itemFocused(l, 0, this.terminal.getTerminalID());
        }
    }

    private void sendFocusedPropertyToDrawerConditionEngine() {
        IFocusedPropertyObject iFocusedPropertyObject = this.getCurrentFocusedPropertyObject();
        pictureWallLogCh.log(-2137614336, "PictureWallController#sendFocusedPropertyToDrawerConditionEngine focusedPropertyObject = %1", (Object)iFocusedPropertyObject);
        this.terminal.getDrawerConditionEngine().setFocusedProperty(iFocusedPropertyObject);
    }

    private void sendSelectedPictureCallbackToApplication() {
        if (this.model instanceof TiledListModelGUI) {
            TiledListModelGUI tiledListModelGUI = (TiledListModelGUI)this.model;
            int n = this.getSelectedModelRow();
            GuiListRow guiListRow = tiledListModelGUI.getGuiRow(n);
            if (guiListRow != null) {
                long l = guiListRow.getUniqueID();
                pictureWallLogCh.log(-2137614336, "PictureWallController#sendSelectedPictureCallbackToApplication modelRow = %1, uniqueID = %2", (Object)guiListRow, l);
                tiledListModelGUI.itemSelected(l, 0, this.terminal.getTerminalID());
            } else {
                pictureWallLogCh.log(-2137614336, "PictureWallController#sendSelectedPictureCallbackToApplication Can not select row. Row is null.");
            }
        }
    }

    private void setHueAndSaturation(boolean bl) {
        for (int i2 = 0; i2 < 3; ++i2) {
            if (i2 == this.cursorPosition) continue;
            this.lines[i2 + 1].setHueAndSaturation(bl);
        }
        this.lines[this.cursorPosition + 1].setHueAndSaturation(false);
    }

    public void setRenderer(CompositeRendererHigh compositeRendererHigh) {
        this.renderer = compositeRendererHigh;
        this.renderer.setClipping(true);
    }

    public void setDebugVisualizer(IPictureWallCallbackReceiver iPictureWallCallbackReceiver) {
        this.dbgCache = iPictureWallCallbackReceiver;
        if (this.cache != null) {
            this.cache.setDebugVisualizer(iPictureWallCallbackReceiver);
        }
    }

    private void setUpWidget() {
        if (!this.isSetUp) {
            AbstractRendererHigh abstractRendererHigh;
            this.isSetUp = true;
            int n = 24;
            int n2 = 24;
            int n3 = (this.getHeight() - 24 - 24 - 56) / 3;
            int n4 = this.getWidth() - 24 - 75;
            int n5 = 5;
            this.lines = new PictureWallLineController[n5];
            for (int i2 = 0; i2 < n5; ++i2) {
                this.lines[i2] = new PictureWallLineController();
                this.lines[i2].setBounds(n, n2, n4, n3);
                this.lines[i2].setParentController(this);
                this.lines[i2].setBitmaps(this.bitmapIndices);
                abstractRendererHigh = new CompositeRendererHigh(this.lines[i2]);
                this.lines[i2].setRenderer((CompositeRenderer)((Object)abstractRendererHigh));
                this.add(this.lines[i2]);
            }
            this.cursorIcon = new IconController();
            abstractRendererHigh = new IconRendererHigh(this.cursorIcon);
            this.cursorIcon.setRenderer((IconRenderer)((Object)abstractRendererHigh));
            this.cursorIcon.setBitmaps(new int[]{this.bitmapIndices[5], this.bitmapIndices[6]});
            this.cursorIcon.setWidth(26);
            this.cursorIcon.setHeight(87);
            this.cursorIcon.setVisible(false);
            this.add(this.cursorIcon);
            this.cache = new PictureWallCache();
            this.cache.setModelID(this.getModelID());
            this.cache.setModel(this.getModel());
            if (this.dbgCache != null) {
                this.cache.setDebugVisualizer(this.dbgCache);
            }
        }
    }

    public void setParentController(PictureViewer pictureViewer) {
        this.parentController = pictureViewer;
    }

    private void setPictureAt(int n, int n2, int n3) {
        HMIResourceLocator hMIResourceLocator = this.cache.getDataHMIResourceLocator(n3);
        this.lines[n].setPictureAt(n2, n3, hMIResourceLocator);
    }

    private void showCursorCloseIcon(boolean bl, boolean bl2) {
        if (bl) {
            if (!this.cursorIcon.isVisible()) {
                this.cursorIcon.setVisible(true);
            }
            if (bl2) {
                this.cursorIcon.setValue(1);
            } else {
                this.cursorIcon.setValue(0);
            }
            this.cursorIcon.setX(this.cursor.getX() + 612);
            this.cursorIcon.setY(this.cursor.getY() + 3);
            this.cursorIcon.setCompositesDirty(true);
        } else {
            this.cursorIcon.setVisible(false);
            this.cursorIcon.setCompositesDirty(true);
        }
    }

    private void showLargePreview(int n) {
        this.lines[this.cursorPosition + 1].showLargePreview(n);
    }

    private void startAnimation(int n) {
        if (this.isConnected() && (this.animation == null || !this.animation.isAnimating())) {
            this.getAnimation(n);
            this.animation.startDynamicAnimation(0.0f, 31300, n, false, this);
        }
    }

    public PictureWallController() {
        singleton = this;
        pictureWallScrollingLogCh.log(-2137614336, "PictureWallController#PictureWallController scrollStepLength = %1", (long)this.getScrollStepLength());
        this.listScroll = new PictureWallController$1(this, this.getScrollStepLength(), this.getNumberOfLines(), 3, 10);
        this.listScroll.setLogChannel(IWidgetLogChannel.pictureWallScrollingLogCh);
    }

    @Override
    public void touchPadAbandoned(TouchEvent touchEvent) {
    }

    @Override
    public void touchPadApproached(TouchEvent touchEvent) {
    }

    @Override
    public void touchPadCharactersRecognized(TouchEvent touchEvent) {
    }

    @Override
    public void touchPadPalmRecognized(TouchEvent touchEvent) {
    }

    @Override
    public void touchPadPositionMoved(TouchEvent touchEvent) {
        int n = touchEvent.getAngle();
        int n2 = touchEvent.getFingerCount();
        int n3 = touchEvent.getDistance();
        int n4 = touchEvent.getX();
        int n5 = touchEvent.getY();
        pictureWallLogCh.log(-2137614336, "PictureWallController#touchPadPositionMoved x = %1, y = %2, fingers = %3", (long)n4, (long)n5, (long)n2);
        pictureWallLogCh.log(-2137614336, "PictureWallController#touchPadPositionMoved angle = %1, distance = %2", (long)n, (long)n3);
    }

    @Override
    public void touchPadPressed(TouchEvent touchEvent) {
        pictureWallLogCh.log(-2137614336, "PictureWallController#touchPadPressed");
    }

    @Override
    public void touchPadReleased(TouchEvent touchEvent) {
        pictureWallLogCh.log(-2137614336, "PictureWallController#touchPadReleased");
    }

    private AbstractAnimationController getAnimationController() {
        return (AbstractAnimationController)this.getTerminal().getIAnimationController();
    }

    @Override
    public void disconnecting() {
        pictureWallLogCh.log(-2137614336, "PictureWallController#disconnecting");
        if (this.animation != null && this.animation.isAnimating()) {
            this.animation.stopAnimation();
        }
        this.exitSingleMode();
        this.linePosition = 0;
        this.cursorPosition = 0;
        this.clicksToDo = 0;
        this.dy = 0;
        this.cursorOffset = 16;
        this.cache.disconnecting();
        this.listScroll.disconnecting();
        super.disconnecting();
    }

    public String emptyPath() {
        CompositeRendererHigh compositeRendererHigh = (CompositeRendererHigh)this.getRenderer();
        return compositeRendererHigh.getBitmap(0).getPath();
    }

    private void enterSingleMode() {
        pictureWallLogCh.log(-2137614336, "PictureWallController#enterSingleMode");
        this.singleMode = true;
        this.cursorPositionInSingleMode = 0;
        this.cursor.setOptionsIconVisible(false);
        this.cursor.setCompositesDirty(true);
        this.showLargePreview(this.cursorPositionInSingleMode);
        this.showCursorCloseIcon(true, false);
        this.lines[this.cursorPosition + 1].bringToFront();
        this.setHueAndSaturation(true);
        this.cursor.setEnabled(false);
    }

    private void exitSingleMode() {
        if (this.isSingleMode()) {
            pictureWallLogCh.log(-2137614336, "PictureWallController#exitSingleMode");
            this.singleMode = false;
            this.cursor.setOptionsIconVisible(true);
            this.cursor.setCompositesDirty(true);
            this.showCursorCloseIcon(false, false);
            if (0 <= this.cursorPositionInSingleMode && this.cursorPositionInSingleMode < 4) {
                this.hideLargePreview(this.cursorPositionInSingleMode, false);
            }
            this.cursorPositionInSingleMode = 0;
            this.bringCursorToFront();
            this.setHueAndSaturation(false);
            this.cursor.setEnabled(true);
        } else {
            pictureWallLogCh.log(-2137614336, "PictureWallController#exitSingleMode Controller is not in single mode.");
        }
    }

    private AbstractAnimation getAnimation(int n) {
        if (this.animation == null || this.animation.getType() != n) {
            this.animation = (AbstractAnimation)this.getAnimationController().getIAnimation(n);
            this.animation.addListener(this);
        }
        return this.animation;
    }

    private PropertyListCell getDataProperty(int n) {
        GuiListRow guiListRow;
        if (!(this.model instanceof TiledListModelGUI)) {
            return null;
        }
        TiledListModelGUI tiledListModelGUI = (TiledListModelGUI)this.model;
        if (this.lines != null && (guiListRow = tiledListModelGUI.getGuiRow(n)) != null) {
            return (PropertyListCell)guiListRow.getCell(3);
        }
        return null;
    }

    public int[][] getLinesCoordinates() {
        int[][] nArray = new int[3][4];
        for (int i2 = 1; i2 < 4; ++i2) {
            int[] nArray2 = nArray[i2 - 1];
            nArray2[0] = this.lines[i2].getX();
            nArray2[1] = this.lines[i2].getY();
            nArray2[2] = this.lines[i2].getWidth();
            nArray2[3] = this.lines[i2].getHeight();
        }
        return nArray;
    }

    @Override
    public void animationStarted(int n, int n2) {
    }

    @Override
    public void animationFinished(int n, int n2) {
        switch (this.currentAnimation) {
            case 1: {
                this.cursorOffset += this.dy * this.getCursorStepLength();
                if (this.dy > 0) {
                    ++this.cursorPosition;
                    break;
                }
                --this.cursorPosition;
                break;
            }
            case 0: {
                if (this.dy > 0) {
                    this.decreaseLinePosition();
                } else {
                    this.increaseLinePosition();
                }
                this.rollLines(this.dy > 0);
                this.setLinesPictures();
                break;
            }
        }
        this.currentAnimation = -1;
        this.cache.sendDbgCacheControllerCallback(1, new Object[]{new Integer(this.linePosition)});
    }

    @Override
    public void animate(int n, float f2, int n2) {
        float f3 = f2 / 31300;
        switch (this.currentAnimation) {
            case 1: {
                int n3 = this.getCursorStepLength();
                this.cursor.setY((int)((float)this.cursorOffset + (float)this.dy * f3 * (float)n3));
                break;
            }
            case 0: {
                int n4 = this.getScrollStepLength();
                this.setLinesY((int)((float)this.dy * f3 * (float)n4));
                this.updateScrollbar((float)(-this.dy) * f3);
                break;
            }
        }
    }

    @Override
    public IFocusedPropertyObject getCurrentFocusedPropertyObject() {
        PropertyListCell propertyListCell;
        if (this.isSingleMode() && 0 <= this.cursorPositionInSingleMode && this.cursorPositionInSingleMode < 4 && (propertyListCell = this.getDataProperty(this.getSelectedModelRow())) != null) {
            FocusedPropertyObject focusedPropertyObject = new FocusedPropertyObject();
            focusedPropertyObject.setCategory(propertyListCell.getCategory());
            focusedPropertyObject.setProperties(propertyListCell.getProperties());
            if (pictureWallLogCh.isDebug()) {
                pictureWallLogCh.log(-2137614336, "PictureWallController#getCurrentFocusedPropertyObject category = %2, properties = %1", (Object)PictureWallController.intArrayToString(focusedPropertyObject.getProperties()), (long)focusedPropertyObject.getCategory());
            }
            return focusedPropertyObject;
        }
        return null;
    }

    private int getCursorStepLength() {
        return (this.getHeight() - 32) / 3 + 3;
    }

    private int getLineIndex() {
        return this.linePosition + this.cursorPosition;
    }

    private int getNumberOfLines() {
        if (this.model instanceof TiledListModelGUI) {
            int n = ((TiledListModelGUI)this.model).getLength();
            return (n + 3) / 4;
        }
        return 0;
    }

    public PictureViewer getParentController() {
        return this.parentController;
    }

    @Override
    public IRenderer getRenderer() {
        return this.renderer;
    }

    private int getScrollStepLength() {
        return (this.getHeight() - 24 - 24 - 56) / 3 + 28;
    }

    private int getSelectedModelRow() {
        return this.getSelectedModelRow(this.cursorPositionInSingleMode);
    }

    private int getSelectedModelRow(int n) {
        return this.getLineIndex() * 4 + n;
    }

    public PictureWallCache$CachedTexture getTexture(String string) {
        return this.cache.getTexture(string);
    }

    private void updateScrollbar(float f2) {
        int n = (int)((float)this.linePosition + f2);
        this.scrollbar.setInterval(n, n + 2, this.getNumberOfLines(), true);
    }

    private static String intArrayToString(int[] nArray) {
        Buffer buffer = new Buffer();
        if (nArray != null) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                buffer.append(nArray[i2]);
                buffer.append(',');
            }
        }
        return buffer.toString();
    }

    static /* synthetic */ void access$000(PictureWallController pictureWallController, float f2) {
        pictureWallController.positionElements0(f2);
    }

    static /* synthetic */ PictureWallCache access$100(PictureWallController pictureWallController) {
        return pictureWallController.cache;
    }

    static {
        X_POS_LARGE_IMAGES = new int[]{18, 113, 208, 302};
    }
}

