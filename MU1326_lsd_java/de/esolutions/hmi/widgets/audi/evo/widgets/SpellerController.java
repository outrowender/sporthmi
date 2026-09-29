/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.TimerEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.hmi.view.AnimationListener;
import de.audi.atip.hmi.view.IPartialPopupController;
import de.audi.atip.hmi.view.IScreenData;
import de.audi.atip.hmi.view.Screen;
import de.audi.atip.i18n.I18NTarget;
import de.audi.atip.util.Util;
import de.audi.tghu.hmi.evo.IDrawerControllerEvo;
import de.audi.tghu.hmi.evo.IDrawerFocusManagerEvo;
import de.audi.tghu.hmi.evo.IDrawerListener;
import de.audi.tghu.hmi.evo.IPartialPopupManagerEvo;
import de.esolutions.fw.util.commons.job.Job;
import de.esolutions.hmi.widgets.audi.base.AbstractScreenWidget;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IUserHintHandler;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.StringUtility;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimationController;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.ISpellerListener;
import de.esolutions.hmi.widgets.audi.evo.widgets.ISpellerRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.ReusableInstanceCache;
import de.esolutions.hmi.widgets.audi.evo.widgets.ReusableInstanceCache$AbstractInstanceFactory;
import de.esolutions.hmi.widgets.audi.evo.widgets.ReusableInstanceCache$IReusable;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerButtonArgument;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerCharsetDefinition;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$1;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$2;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$3;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$AbstractExpandableItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$AbstractExpandableItem$Char;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ButtonItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ICharacterSpellerItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ISpellerBand;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ISpellerItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$SingleCharItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$SpellerBandImpl;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$SpellerButtonType;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerIterator;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchCharSetAndTTSHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchController;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchControllerDebugInfo;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SpellerController
extends AbstractWidgetController
implements AnimationListener,
ATIPEventListener,
IDrawerListener {
    public static final int MODE_FREETEXT;
    public static final int MODE_PHONE_NUMBER;
    public static final int MODE_PIN;
    public static final int MODE_DMTF;
    public static final int MODE_MULTILINE;
    public static final int MODE_ADDRESSING;
    public static final int MODE_WLAN;
    public static final int MODE_TUNER_TV;
    public static final int MODE_MATCH_PHONE;
    public static final int MODE_MATCH_HOUSENUMBER;
    public static final int MODE_CONNECT;
    public static final int MODE_MATCHSPELLER;
    public static final int MODE_ASIA_PASSWORD;
    public static final int MODE_JP_MAPCODE;
    public static final int MODE_TV_OPERATIONAL;
    public static final int MODE_ONLINE;
    public static final int MODE_VEHICLE_CODE;
    public static final String SPACE_CHAR;
    public static final String BACKSPACE;
    private static final int ANIMATION_TYPE_SPELLER_CURSOR;
    private static final float ANIMATION_TARGET_SPELLER_CURSOR;
    private static final long TIME_LONG_PRESS;
    private static final long TIME_WRAP_AROUND;
    protected static final int ANIMATION_TYPE_SPELLER_EXPAND;
    private static final float ANIMATION_TARGET_SPELLER_BAND_OPEN;
    private static final ReusableInstanceCache SPELLER_ITEM_CACHE;
    private static final int CURSOR_POSITION_LEFTMOST;
    private static final int CURSOR_POSITION_MIDDLE;
    private static final int CURSOR_POSITION_RIGHTMOST;
    private int curCursorPostion = 0;
    private SpellerController$ISpellerBand currentSpellerBand;
    private Job wrapAroundJob = null;
    private TimerEvent wrapAroundEvent = null;
    private boolean wrapAroundJobRunning = false;
    private Job longPressJob = null;
    private TimerEvent longPressEvent = null;
    private boolean longPressJobRunning = false;
    private ISpellerRenderer renderer;
    private AbstractAnimation cursorAnimation;
    private float cursorAnimationProgress;
    private AbstractAnimation openAnimation;
    private SpellerController$AbstractExpandableItem itemToClose;
    protected SpellerController$ISpellerItem targetCursorItem;
    protected int spellerMode = 0;
    private String autoCompletionText;
    private boolean showAutoCompletion = false;
    private String currentValidChars = null;
    private List registeredSpellerListeners = new LinkedList();
    private SpellerController$ISpellerItem currentlyPressedItem;
    private boolean forceOKButton = false;
    private boolean showBoxNode = true;
    private boolean multilineAlternative = false;
    private float cursorMoveDuration = 31300;
    public static final int BUTTON_CONFIRM_SDS_COMMAND;
    private MenuItemController confirmButton = null;
    private boolean isDeleteDirectionRTL = true;
    private IDrawerFocusManagerEvo drawerFocusManager;
    private boolean lockingActive = false;
    protected final ISpellerListener spellerListenerNotifier = new SpellerController$1(this);
    private boolean multilineAlternativeArrowDown = false;

    protected final List getSpellerListeners() {
        return this.registeredSpellerListeners;
    }

    public void add(AbstractWidget abstractWidget, int n) {
        switch (n) {
            case 0: {
                if (!(abstractWidget instanceof MenuItemController)) break;
                this.confirmButton = (MenuItemController)abstractWidget;
                break;
            }
            default: {
                spellerLogChannel.log(-1601830656, "SpellerController#add added widget to Speller with wrong type or wrong role(%1)!", (long)n);
            }
        }
        this.add(abstractWidget);
    }

    protected SpellerButtonArgument getAdditionalOKArgument() {
        if (this.confirmButton == null) {
            return null;
        }
        int n = this.confirmButton.getSdsCommand();
        int n2 = this.confirmButton.getModelID();
        if (n != -1) {
            return new SpellerController$2(this, n2, n);
        }
        return null;
    }

    public boolean shallShowOptionIcon() {
        return this.getSpellerMode() != 14 && this.getSpellerMode() != 4;
    }

    public void setShowBoxNode(boolean bl) {
        this.showBoxNode = bl;
    }

    public boolean showBox() {
        return this.showBoxNode;
    }

    public boolean isMultilineAlternative() {
        return this.multilineAlternative;
    }

    public void setMultilineAlternative(boolean bl) {
        this.multilineAlternative = bl;
    }

    public void setAlternativeArrowDown(boolean bl) {
        this.multilineAlternativeArrowDown = bl;
    }

    public boolean isAlternativeArrowDown() {
        return this.multilineAlternativeArrowDown;
    }

    private static ReusableInstanceCache.AbstractInstanceFactory createSpellerItemFactory() {
        return new SpellerController$3();
    }

    protected static void addToSpellerItemCache(List list) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ReusableInstanceCache$IReusable reusableInstanceCache$IReusable = (ReusableInstanceCache$IReusable)iterator.next();
            if (reusableInstanceCache$IReusable instanceof SpellerController$AbstractExpandableItem) {
                SpellerController.addToSpellerItemCache(((SpellerController$AbstractExpandableItem)reusableInstanceCache$IReusable).getSubBand());
            }
            SPELLER_ITEM_CACHE.collect(reusableInstanceCache$IReusable);
        }
    }

    protected static void addToSpellerItemCache(ReusableInstanceCache$IReusable reusableInstanceCache$IReusable) {
        SPELLER_ITEM_CACHE.collect(reusableInstanceCache$IReusable);
    }

    protected SpellerIterator getCurrentSpellerIterator() {
        return this.getSpellerIterator(null, false, false);
    }

    public final void registerSpellerListener(ISpellerListener iSpellerListener) {
        this.registeredSpellerListeners.add(iSpellerListener);
    }

    @Override
    protected void initializeWidget() {
        spellerLogChannel.log(1078071040, "SpellerController#initializeWidget: Speller Mode=%1", (long)this.spellerMode);
        if (this.getCurrentSpellerBand() == null) {
            this.initializeSpellerBand();
        }
        this.setAutoCompletionText("", "");
        this.resetInitialItem();
    }

    private void initializeSpellerBand() {
        List list = SpellerCharsetDefinition.initSpellerBand(this.spellerMode, -1);
        SpellerController$SpellerBandImpl spellerController$SpellerBandImpl = new SpellerController$SpellerBandImpl(this, list, this.hasOKButton());
        this.setCurrentSpellerBand(spellerController$SpellerBandImpl, false);
    }

    protected SpellerController$ISpellerBand getSpellerBandForLanguage(TouchCharSetAndTTSHandler touchCharSetAndTTSHandler) {
        List list = SpellerCharsetDefinition.initSpellerBand(this.spellerMode, touchCharSetAndTTSHandler.getInternalLanguage());
        return new SpellerController$SpellerBandImpl(this, list, this.hasOKButton());
    }

    @Override
    public IRenderer getRenderer() {
        return this.renderer;
    }

    public void setRenderer(ISpellerRenderer iSpellerRenderer) {
        this.renderer = iSpellerRenderer;
    }

    protected final void changeSpellerBand(SpellerController$ISpellerBand spellerController$ISpellerBand) {
        this.setCurrentSpellerBand(spellerController$ISpellerBand, false);
        spellerController$ISpellerBand.resetInitialItem(false);
        this.targetCursorItem = spellerController$ISpellerBand.getCurrentFocusedItem();
        this.renderer.switchCharSet();
        this.renderer.deleteMoved();
        this.setCompositesDirty(true);
    }

    protected boolean hasOKButton() {
        return this.forceOKButton || this.spellerMode == 3 || this.spellerMode == 2 || this.spellerMode == 1 || this.spellerMode == 10 || this.spellerMode == 8 || this.spellerMode == 15 || this.spellerMode == 16;
    }

    public void resetInitialItem() {
        this.currentSpellerBand.resetInitialItem(true);
        this.targetCursorItem = this.currentSpellerBand.getCurrentFocusedItem();
    }

    public boolean isDeleteDirectionRTL() {
        return this.isDeleteDirectionRTL;
    }

    public void setButtonStates(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        if (this.currentSpellerBand == null) {
            return;
        }
        boolean bl6 = false;
        if (this.currentSpellerBand.getDeleteButton() != null && this.currentSpellerBand.getDeleteButton().isEnabled() != bl) {
            this.currentSpellerBand.getDeleteButton().setEnabled(bl);
            bl6 = true;
        }
        if (this.currentSpellerBand.getOkItem() != null && this.currentSpellerBand.getOkItem().isEnabled() != bl2) {
            this.currentSpellerBand.getOkItem().setEnabled(bl2);
            bl6 = true;
        }
        if (this.currentSpellerBand.getCloseButton() != null && this.currentSpellerBand.getCloseButton().isEnabled() != bl3) {
            this.currentSpellerBand.getCloseButton().setEnabled(bl3);
            bl6 = true;
        }
        if (this.currentSpellerBand.getLeftButton() != null && this.currentSpellerBand.getLeftButton().isEnabled() != bl4) {
            this.currentSpellerBand.getLeftButton().setEnabled(bl4);
            bl6 = true;
        }
        if (this.currentSpellerBand.getRightButton() != null && this.currentSpellerBand.getRightButton().isEnabled() != bl5) {
            this.currentSpellerBand.getRightButton().setEnabled(bl5);
            bl6 = true;
        }
        if (bl6) {
            this.setCompositesDirty(true);
            this.renderer.refreshItemColors();
        }
    }

    @Override
    public void keyTurned(WheelButtonEvent wheelButtonEvent) {
        int n = wheelButtonEvent.getClickCount();
        if (n == 0) {
            wheelButtonEvent.consume(false);
            return;
        }
        this.setShowAutoCompletion(false);
        this.cancelLongPressTimer();
        this.notifyButtonReleasedIfNeeded();
        int n2 = wheelButtonEvent.getDirection();
        boolean bl = this.terminal.getFramework().getLanguageMgr().isLeftToRightOrientation();
        if (wheelButtonEvent.getKeyCode() == 20 || !bl) {
            int n3 = n2 = n2 == 0 ? 1 : 0;
        }
        if (n2 == 1) {
            n = -n;
        }
        this.doCursorMove(n2, n);
        wheelButtonEvent.consume();
    }

    private boolean isWrapAroundJobRunning() {
        return this.wrapAroundJobRunning;
    }

    private void doCursorMove(int n, int n2) {
        if (!this.isWrapAroundJobRunning()) {
            this.moveCursor(n2, true);
            return;
        }
        spellerLogChannel.log(-2137614336, "[SpellerController#doCursorMove] Cursor at %3, move cursor to %1 with %2 clicks!", (long)n, (long)n2, (long)this.curCursorPostion);
        if (this.curCursorPostion == 1) {
            this.moveCursor(n2, true);
            return;
        }
        if (n == 1) {
            if (this.curCursorPostion == 2) {
                this.moveCursor(n2, true);
            }
        } else if (this.curCursorPostion == 0) {
            this.moveCursor(n2, true);
        }
    }

    public void updateValidChars(String string) {
        this.updateValidChars(string, null, false);
    }

    public void updateValidChars(String string, boolean bl) {
        this.updateValidChars(string, null, bl);
    }

    protected void updateValidChars(String string, String string2) {
        this.updateValidChars(string, string2, false);
    }

    protected void updateValidChars(String string, String string2, boolean bl) {
        if (!bl && Util.equals(this.currentValidChars, string)) {
            spellerLogChannel.log(-2137614336, "[SpellerController#updateValidChars] valid chars did not change!");
            return;
        }
        spellerLogChannel.log(-2137614336, "[SpellerController#updateValidChars] with %1", (Object)string);
        this.currentValidChars = string;
        SpellerIterator spellerIterator = this.getSpellerIterator(null, true, true, true);
        while (spellerIterator.hasNext()) {
            SpellerController$ISpellerItem spellerController$ISpellerItem;
            boolean bl2;
            Object object = spellerIterator.next();
            boolean bl3 = bl2 = string2 != null && object instanceof SpellerController$ICharacterSpellerItem && ((SpellerController$ICharacterSpellerItem)object).getChar(true).equalsIgnoreCase(string2);
            if (bl2) break;
            if (object instanceof SpellerController$AbstractExpandableItem) {
                String string3;
                spellerController$ISpellerItem = (SpellerController$AbstractExpandableItem)object;
                ((SpellerController$AbstractExpandableItem)spellerController$ISpellerItem).setEnabled(false);
                if (((SpellerController$AbstractExpandableItem)spellerController$ISpellerItem).type != 0 || (string3 = ((SpellerController$AbstractExpandableItem$Char)spellerController$ISpellerItem).getChar(true)).length() <= 0) continue;
                ((SpellerController$AbstractExpandableItem)spellerController$ISpellerItem).setEnabled(SpellerController.searchForCharacter(string, string3));
                continue;
            }
            if (!(object instanceof SpellerController$SingleCharItem) || SpellerController$SingleCharItem.access$1200((SpellerController$SingleCharItem)(spellerController$ISpellerItem = (SpellerController$SingleCharItem)object)).length() > 1) continue;
            boolean bl4 = SpellerController.searchForCharacter(string, SpellerController$SingleCharItem.access$1200((SpellerController$SingleCharItem)spellerController$ISpellerItem));
            ((SpellerController$SingleCharItem)spellerController$ISpellerItem).setEnabled(bl4);
            if (!bl4 || SpellerController$SingleCharItem.access$300((SpellerController$SingleCharItem)spellerController$ISpellerItem) == null) continue;
            this.enableParentIfNeeded((SpellerController$SingleCharItem)spellerController$ISpellerItem, bl4);
        }
        this.updateCursorPosition();
        this.setCompositesDirty(true);
        this.renderer.refreshItemColors();
    }

    protected void enableParentIfNeeded(SpellerController$SingleCharItem spellerController$SingleCharItem, boolean bl) {
        if (SpellerController$SingleCharItem.access$300((SpellerController$SingleCharItem)spellerController$SingleCharItem).type != 0 || !(this.parent instanceof TouchController) || !((TouchController)this.parent).isMatchSpellerMode()) {
            SpellerController$SingleCharItem.access$300(spellerController$SingleCharItem).setEnabled(bl);
        }
    }

    private void updateCursorPosition() {
        SpellerController$ISpellerItem spellerController$ISpellerItem = this.getCurrentFocus();
        SpellerIterator spellerIterator = this.getSpellerIterator(null, true, false);
        while (spellerIterator.hasNext()) {
            SpellerController$ISpellerItem spellerController$ISpellerItem2 = (SpellerController$ISpellerItem)spellerIterator.next();
            if (spellerController$ISpellerItem != spellerController$ISpellerItem2) continue;
            if (!spellerIterator.hasNext()) {
                this.curCursorPostion = 2;
                break;
            }
            if (!spellerIterator.hasNext()) {
                this.curCursorPostion = 0;
                break;
            }
            this.curCursorPostion = 1;
            break;
        }
        spellerLogChannel.log(-2137614336, "[SpellerController#updateCursorPosition] Cursor at %1 ", (long)this.curCursorPostion);
    }

    private static boolean searchForCharacter(String string, String string2) {
        if (string == null || string2.length() > 1) {
            return true;
        }
        for (int i2 = 0; i2 < string.length(); ++i2) {
            if (Character.toUpperCase(string.charAt(i2)) != string2.charAt(0)) continue;
            return true;
        }
        return false;
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        this.handlePressItem(this.targetCursorItem);
        keyEvent.consume(true);
        super.keyPressed(keyEvent);
    }

    private boolean isLongPressJobRunning() {
        return this.longPressJobRunning;
    }

    private void startLongPressJob() {
        if (this.isLongPressJobRunning()) {
            this.cancelLongPressTimer();
        }
        this.longPressJobRunning = true;
        this.longPressEvent = new TimerEvent(this);
        this.longPressJob = AbstractWidget.framework.getHMIService().getEventDispatcher().postEvent(this.longPressEvent, 0);
    }

    protected void handlePressItem(SpellerController$ISpellerItem spellerController$ISpellerItem) {
        if (!spellerController$ISpellerItem.isEnabled()) {
            spellerLogChannel.log(-2137614336, "SpellerController#handlePressItem: ignore press event on disabled item: %1", (Object)spellerController$ISpellerItem);
            return;
        }
        this.currentlyPressedItem = spellerController$ISpellerItem;
        if (spellerController$ISpellerItem instanceof SpellerController$SingleCharItem) {
            if (!this.isLongPressJobRunning()) {
                this.startLongPressJob();
            }
            this.handleSingleCharItemPressed((SpellerController$SingleCharItem)spellerController$ISpellerItem);
        } else if (spellerController$ISpellerItem instanceof SpellerController$ButtonItem) {
            SpellerController$ButtonItem spellerController$ButtonItem = (SpellerController$ButtonItem)spellerController$ISpellerItem;
            SpellerController$SpellerButtonType spellerController$SpellerButtonType = spellerController$ButtonItem.getButtonType();
            SpellerButtonArgument spellerButtonArgument = spellerController$ButtonItem.getAdditionalArgument();
            this.spellerListenerNotifier.buttonPressed(spellerController$SpellerButtonType, spellerButtonArgument);
            if (spellerController$SpellerButtonType == SpellerController$SpellerButtonType.DELETE) {
                if (!this.isLongPressJobRunning()) {
                    this.startLongPressJob();
                }
            } else if (spellerController$SpellerButtonType == SpellerController$SpellerButtonType.SHIFT) {
                this.currentSpellerBand.setIsUpperCase(!this.currentSpellerBand.isUpperCase());
                this.renderer.switchCase();
                this.setCompositesDirty(true);
            }
        } else if (spellerController$ISpellerItem instanceof SpellerController$AbstractExpandableItem) {
            SpellerController$AbstractExpandableItem spellerController$AbstractExpandableItem = (SpellerController$AbstractExpandableItem)spellerController$ISpellerItem;
            if (spellerController$AbstractExpandableItem.type == 0) {
                if (!this.isLongPressJobRunning()) {
                    this.startLongPressJob();
                }
            } else {
                this.handleReleaseExpandedItem(spellerController$AbstractExpandableItem, false);
            }
        }
        this.currentSpellerBand.itemPressed(spellerController$ISpellerItem);
    }

    public void setSpellerBandLanguage(TouchCharSetAndTTSHandler touchCharSetAndTTSHandler) {
        this.isDeleteDirectionRTL = touchCharSetAndTTSHandler.getInternalLanguage() != 26;
        int n = touchCharSetAndTTSHandler.getInternalLanguage();
        if (spellerLogChannel.isInfo()) {
            String string = "";
            if (I18NTarget.LANGUAGES != null && I18NTarget.LANGUAGES.length > n) {
                string = I18NTarget.LANGUAGES[n].getHmiCode();
            }
            spellerLogChannel.log(1078071040, "SpellerController#setSpellerBandLanguage: langIndex=%2, langCode=%1", (Object)string, (long)n);
        }
        this.setCurrentSpellerBand(this.getSpellerBandForLanguage(touchCharSetAndTTSHandler), true);
        this.updateValidChars(this.currentValidChars, null, true);
        if (this.isConnected()) {
            this.setShowAutoCompletion(false);
            this.resetInitialItem();
            this.renderer.switchCharSet();
            this.setCompositesDirty(true);
        }
    }

    private void closeAllOtherItems(SpellerController$AbstractExpandableItem spellerController$AbstractExpandableItem) {
        SpellerIterator spellerIterator = this.getSpellerIterator(null, false);
        while (spellerIterator.hasNext()) {
            SpellerController$AbstractExpandableItem spellerController$AbstractExpandableItem2;
            Object object = spellerIterator.next();
            if (!(object instanceof SpellerController$AbstractExpandableItem) || object == spellerController$AbstractExpandableItem || SpellerController$AbstractExpandableItem.access$1300(spellerController$AbstractExpandableItem2 = (SpellerController$AbstractExpandableItem)object)) continue;
            this.startClosing(spellerController$AbstractExpandableItem2);
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        this.cancelLongPressTimer();
        if (keyEvent.getKeyCode() == 17) {
            this.releasePressedItem();
        }
        super.keyReleased(keyEvent);
    }

    protected boolean releasePressedItem() {
        if (this.currentlyPressedItem == null) {
            return false;
        }
        this.notifyButtonReleasedIfNeeded();
        if (this.currentlyPressedItem instanceof SpellerController$AbstractExpandableItem$Char) {
            this.handleReleaseExpandedItem((SpellerController$AbstractExpandableItem$Char)this.currentlyPressedItem, false);
        } else if (this.currentlyPressedItem instanceof SpellerController$SingleCharItem) {
            this.notifyCharacterPressed((SpellerController$ICharacterSpellerItem)this.currentlyPressedItem, false, false);
        }
        this.currentlyPressedItem = null;
        return true;
    }

    private void notifyButtonReleasedIfNeeded() {
        if (this.currentlyPressedItem instanceof SpellerController$ButtonItem) {
            this.spellerListenerNotifier.buttonReleased(((SpellerController$ButtonItem)this.currentlyPressedItem).getButtonType());
        }
    }

    private void handleReleaseExpandedItem(SpellerController$AbstractExpandableItem spellerController$AbstractExpandableItem, boolean bl) {
        if (spellerController$AbstractExpandableItem.type == 1 || spellerController$AbstractExpandableItem.type == 0 && bl) {
            if (SpellerController$AbstractExpandableItem.access$1300(spellerController$AbstractExpandableItem)) {
                this.closeAllOtherItems(spellerController$AbstractExpandableItem);
                SpellerController$AbstractExpandableItem.access$1302(spellerController$AbstractExpandableItem, false);
                this.renderer.openItem();
            } else {
                this.startClosing(spellerController$AbstractExpandableItem);
            }
            this.startBandExpandAnimation();
            this.setCompositesDirty(true);
        } else if (spellerController$AbstractExpandableItem.isEnabled()) {
            this.notifyCharacterPressed((SpellerController$ICharacterSpellerItem)((Object)spellerController$AbstractExpandableItem), bl, true);
        } else {
            spellerLogChannel.log(-2137614336, "SpellerController#handlePressExpandedItem: ignore release event on disabled expand item: %1", (Object)spellerController$AbstractExpandableItem);
        }
    }

    protected void startBandExpandAnimation() {
        AbstractAnimation abstractAnimation = this.getBandOpenAnimation();
        if (abstractAnimation.isAnimating()) {
            abstractAnimation.setTarget(abstractAnimation.getTarget() + 31300);
        } else {
            abstractAnimation.startDynamicAnimation(0.0f, 31300, 89, false, this);
        }
    }

    private void startClosing(SpellerController$AbstractExpandableItem spellerController$AbstractExpandableItem) {
        if (this.itemToClose != null) {
            this.closeItem(this.itemToClose);
        }
        SpellerController$AbstractExpandableItem.access$1302(spellerController$AbstractExpandableItem, true);
        this.itemToClose = spellerController$AbstractExpandableItem;
        this.startBandExpandAnimation();
    }

    private void closeItem(SpellerController$AbstractExpandableItem spellerController$AbstractExpandableItem) {
        SpellerController$AbstractExpandableItem.access$1302(spellerController$AbstractExpandableItem, true);
        this.renderer.closeItem(spellerController$AbstractExpandableItem);
    }

    protected void handleSingleCharItemPressed(SpellerController$SingleCharItem spellerController$SingleCharItem) {
        if (SpellerController$SingleCharItem.access$300(spellerController$SingleCharItem) != null && SpellerController$SingleCharItem.access$300((SpellerController$SingleCharItem)spellerController$SingleCharItem).type == 0) {
            this.startClosing(SpellerController$SingleCharItem.access$300(spellerController$SingleCharItem));
            this.setCursorPosition(SpellerController$SingleCharItem.access$300(spellerController$SingleCharItem));
            this.targetCursorItem = SpellerController$SingleCharItem.access$300(spellerController$SingleCharItem);
        }
    }

    protected void notifyCharacterPressed(SpellerController$ICharacterSpellerItem spellerController$ICharacterSpellerItem, boolean bl, boolean bl2) {
        String string = spellerController$ICharacterSpellerItem.getChar(this.currentSpellerBand.isUpperCase());
        this.spellerListenerNotifier.characterPressed(string, bl, bl2);
    }

    public SpellerController$ISpellerBand getCurrentSpellerBand() {
        return this.currentSpellerBand;
    }

    protected final void setCurrentSpellerBand(SpellerController$ISpellerBand spellerController$ISpellerBand, boolean bl) {
        if (bl && this.currentSpellerBand != null && this.currentSpellerBand != spellerController$ISpellerBand) {
            this.currentSpellerBand.free(false);
        }
        this.currentSpellerBand = spellerController$ISpellerBand;
    }

    public boolean setNewFocus(char c2) {
        if (!Character.isDefined(c2)) {
            return false;
        }
        SpellerIterator spellerIterator = this.getSpellerIterator(this.getFirstItem(), true, true, true);
        while (spellerIterator.hasNext()) {
            SpellerController$SingleCharItem spellerController$SingleCharItem;
            Object object = spellerIterator.next();
            if (!(object instanceof SpellerController$SingleCharItem) || (spellerController$SingleCharItem = (SpellerController$SingleCharItem)object).getChar(true).charAt(0) != c2) continue;
            if (spellerController$SingleCharItem.hasParent()) {
                spellerController$SingleCharItem.getParent().setClosed(false);
            }
            this.moveCursorToItem(spellerController$SingleCharItem);
            ((SpellerController$SpellerBandImpl)this.currentSpellerBand).moveDeleteButton(spellerController$SingleCharItem, false);
            return true;
        }
        return false;
    }

    protected void moveCursor(float f2, boolean bl) {
        AbstractAnimation abstractAnimation;
        SpellerIterator spellerIterator = this.getSpellerIterator(this.targetCursorItem, true, false);
        SpellerController$ISpellerItem spellerController$ISpellerItem = this.targetCursorItem;
        boolean bl2 = false;
        if (f2 < 0.0f) {
            bl2 = true;
            f2 = -f2;
        }
        int n = 0;
        while ((float)n < f2) {
            if (bl2) {
                if (spellerIterator.hasPrevious()) {
                    spellerController$ISpellerItem = (SpellerController$ISpellerItem)spellerIterator.previous();
                    if (!spellerIterator.hasPrevious()) {
                        this.startWrapAroundJob();
                        this.curCursorPostion = 0;
                        break;
                    }
                    this.curCursorPostion = 1;
                } else {
                    spellerController$ISpellerItem = this.getLastItem();
                }
            } else if (spellerIterator.hasNext()) {
                spellerController$ISpellerItem = (SpellerController$ISpellerItem)spellerIterator.next();
                if (!spellerIterator.hasNext()) {
                    this.startWrapAroundJob();
                    this.curCursorPostion = 2;
                    break;
                }
                this.curCursorPostion = 1;
            } else {
                spellerController$ISpellerItem = this.getFirstItem();
            }
            ++n;
        }
        this.targetCursorItem = spellerController$ISpellerItem;
        if (this.targetCursorItem == this.currentSpellerBand.getCurrentFocusedItem()) {
            return;
        }
        if (!bl) {
            this.setCursorPosition(this.targetCursorItem);
            return;
        }
        if (this.renderer != null) {
            this.renderer.startCursorAnimation(this.currentSpellerBand.getCurrentFocusedItem(), this.targetCursorItem);
        }
        if ((abstractAnimation = this.getCursorAnimation()).isAnimating()) {
            abstractAnimation.setTarget(abstractAnimation.getTarget() + 31300);
        } else {
            abstractAnimation.startDynamicAnimation(0.0f, this.cursorMoveDuration, 73, false, this);
            this.cursorAnimationProgress = 0.0f;
            this.setCursorPosition(null);
        }
    }

    public void setCursorDuration(float f2) {
        this.cursorMoveDuration = f2;
    }

    public SpellerController$ISpellerItem getFirstItem() {
        return (SpellerController$ISpellerItem)this.getSpellerIterator(null, true, false).next();
    }

    public SpellerController$ISpellerItem getLastItem() {
        SpellerIterator spellerIterator = this.getSpellerIterator(null, true, false);
        SpellerController$ISpellerItem spellerController$ISpellerItem = null;
        while (spellerIterator.hasNext()) {
            spellerController$ISpellerItem = (SpellerController$ISpellerItem)spellerIterator.next();
        }
        return spellerController$ISpellerItem;
    }

    private void startWrapAroundJob() {
        this.cancelWrapAroundJob();
        this.wrapAroundJobRunning = true;
        this.wrapAroundEvent = new TimerEvent(this);
        this.wrapAroundJob = AbstractWidget.framework.getHMIService().getEventDispatcher().postEvent(this.wrapAroundEvent, 0);
    }

    public void setCursorPosition(SpellerController$ISpellerItem spellerController$ISpellerItem) {
        this.spellerListenerNotifier.focusChanged(this.getCurrentFocus(), 0);
        this.currentSpellerBand.setCurrentFocusedItem(spellerController$ISpellerItem);
        this.spellerListenerNotifier.focusedCharacterChanged(this.extractString(spellerController$ISpellerItem));
        this.spellerListenerNotifier.focusChanged(spellerController$ISpellerItem, 1);
        this.handleCursorPositionForAutoCompletion(spellerController$ISpellerItem);
        this.setCompositesDirty(true);
    }

    protected void moveCursorToItem(SpellerController$ISpellerItem spellerController$ISpellerItem) {
        this.targetCursorItem = spellerController$ISpellerItem;
        this.setCursorPosition(spellerController$ISpellerItem);
    }

    protected void handleCursorPositionForAutoCompletion(SpellerController$ISpellerItem spellerController$ISpellerItem) {
        if (spellerController$ISpellerItem != null) {
            this.setShowAutoCompletion(false);
        }
    }

    @Override
    public void animate(int n, float f2) {
        if (n == 73) {
            this.cursorAnimationProgress = this.cursorAnimation.getProgress();
            this.setCompositesDirty(true);
        } else if (n == 89) {
            this.renderer.openItem();
            this.setCompositesDirty(true);
        }
    }

    public int getSpellerMode() {
        return this.spellerMode;
    }

    public void setSpellerMode(int n) {
        spellerLogChannel.log(-2137614336, "SpellerController#setSpellerMode: changing speller mode from %1 to %2", (long)this.spellerMode, (long)n);
        this.spellerMode = n;
        TouchControllerDebugInfo.showSpellerModelDebugInfo(this.terminal, this, this.getSpellerMode());
    }

    private AbstractAnimationController getAnimationController() {
        return (AbstractAnimationController)this.getTerminal().getIAnimationController();
    }

    private AbstractAnimation getCursorAnimation() {
        if (this.cursorAnimation == null) {
            this.cursorAnimation = (AbstractAnimation)this.getAnimationController().getIAnimation(73);
            this.cursorAnimation.addListener(this);
        }
        return this.cursorAnimation;
    }

    private AbstractAnimation getBandOpenAnimation() {
        if (this.openAnimation == null) {
            this.openAnimation = (AbstractAnimation)this.getAnimationController().getIAnimation(89);
            this.openAnimation.addListener(this);
        }
        return this.openAnimation;
    }

    @Override
    public void animationStarted(int n, int n2) {
    }

    @Override
    public void animationFinished(int n, int n2) {
        if (n == 73) {
            this.cursorAnimationProgress = 32959;
            this.setCursorPosition(this.targetCursorItem);
        } else if (n == 89 && this.itemToClose != null) {
            this.closeItem(this.itemToClose);
            this.itemToClose = null;
        }
    }

    public boolean isCursorAnimating() {
        return this.getCursorAnimation() != null && this.getCursorAnimation().isAnimating();
    }

    @Override
    public void processEvent(ATIPEvent aTIPEvent) {
        if (aTIPEvent.equals(this.longPressEvent)) {
            this.longPressJobRunning = false;
            this.fireTimerAction();
        }
        if (aTIPEvent.equals(this.wrapAroundEvent)) {
            this.wrapAroundJobRunning = false;
        }
    }

    protected void fireTimerAction() {
        if (this.currentlyPressedItem instanceof SpellerController$AbstractExpandableItem$Char) {
            SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char = (SpellerController$AbstractExpandableItem$Char)this.currentlyPressedItem;
            this.expandSpellerExpandableItem(spellerController$AbstractExpandableItem$Char);
            String string = spellerController$AbstractExpandableItem$Char.getChar(this.getCurrentSpellerBand().isUpperCase());
            this.spellerListenerNotifier.characterPressed(string, true, true);
            this.currentlyPressedItem = null;
        } else if (this.currentlyPressedItem instanceof SpellerController$SingleCharItem) {
            String string = ((SpellerController$SingleCharItem)this.currentlyPressedItem).getChar(this.currentSpellerBand.isUpperCase());
            this.spellerListenerNotifier.characterPressed(string, true, false);
            this.currentlyPressedItem = null;
        } else if (this.currentlyPressedItem instanceof SpellerController$ButtonItem) {
            this.spellerListenerNotifier.buttonLongPressed(((SpellerController$ButtonItem)this.currentlyPressedItem).getButtonType());
        }
        if (this.currentSpellerBand.getCurrentFocusedItem() == this.currentSpellerBand.getDeleteButton()) {
            logRepaintCause.log(-2137614336, "SpellerController#fireTimer: long press timer on delete item. trigger repaint. screen: %1", (long)this.getScreenId());
            this.triggerRepaint();
        }
    }

    protected void expandSpellerExpandableItem(SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char) {
        SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char2 = spellerController$AbstractExpandableItem$Char;
        this.handleReleaseExpandedItem(spellerController$AbstractExpandableItem$Char2, true);
        this.updateCursorPosition();
        logRepaintCause.log(-2137614336, "SpellerController#expandSpellerExpandableItem: Expand speller item. trigger repaint. screen: %1", (long)this.getScreenId());
        this.triggerRepaint();
    }

    protected void closeSpellerExandableItem(SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char) {
        SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char2 = spellerController$AbstractExpandableItem$Char;
        this.startClosing(spellerController$AbstractExpandableItem$Char2);
        this.triggerRepaint();
    }

    protected void cancelLongPressTimer() {
        if (this.longPressJob != null) {
            this.longPressJob.cancel();
            this.longPressJob = null;
        }
        if (this.longPressEvent != null) {
            this.longPressEvent.consume();
            this.longPressEvent = null;
        }
        this.longPressJobRunning = false;
    }

    protected void cancelWrapAroundJob() {
        if (this.wrapAroundJob != null) {
            this.wrapAroundJob.cancel();
            this.wrapAroundJob = null;
        }
        if (this.wrapAroundEvent != null) {
            this.wrapAroundEvent.consume();
            this.wrapAroundEvent = null;
        }
        this.wrapAroundJobRunning = false;
    }

    @Override
    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
        this.drawerFocusManager = this.terminal.getDrawerFocusManager();
        if (this.drawerFocusManager != null) {
            this.drawerFocusManager.addDrawerListener(this);
        }
    }

    @Override
    public void disconnecting() {
        this.cancelLongPressTimer();
        this.notifyButtonReleasedIfNeeded();
        this.cancelWrapAroundJob();
        if (this.cursorAnimation != null && this.cursorAnimation.isAnimating()) {
            this.cursorAnimation.stopAnimation();
        }
        this.cursorAnimation = null;
        if (this.openAnimation != null && this.openAnimation.isAnimating()) {
            this.openAnimation.stopAnimation();
        }
        this.openAnimation = null;
        if (this.currentSpellerBand != null) {
            this.currentSpellerBand.free(true);
            this.setCurrentSpellerBand(null, false);
        }
        if (this.drawerFocusManager != null) {
            this.drawerFocusManager.removeDrawerListener(this);
        }
        super.disconnecting();
    }

    public float getCursorAnimationProgress() {
        return this.cursorAnimationProgress;
    }

    public SpellerIterator getSpellerIterator(boolean bl) {
        if (this.currentSpellerBand == null) {
            return null;
        }
        return this.getSpellerIterator(null, bl);
    }

    public SpellerIterator getSpellerIterator(SpellerController$ISpellerItem spellerController$ISpellerItem, boolean bl) {
        return this.getSpellerIterator(spellerController$ISpellerItem, bl, true, false);
    }

    public SpellerIterator getSpellerIterator(SpellerController$ISpellerItem spellerController$ISpellerItem, boolean bl, boolean bl2) {
        return this.getSpellerIterator(spellerController$ISpellerItem, bl, bl2, false);
    }

    public SpellerIterator getSpellerIterator(SpellerController$ISpellerItem spellerController$ISpellerItem, boolean bl, boolean bl2, boolean bl3) {
        if (this.currentSpellerBand == null) {
            this.initializeSpellerBand();
        }
        return new SpellerIterator(this.currentSpellerBand.getSpellerItems(), spellerController$ISpellerItem, bl2, bl, bl3, this.getMovingDeleteButtonOrNull(), this.getMovingDeleteNeighbourButtonItemOrNull());
    }

    public SpellerIterator getSubBandIterator(SpellerController$AbstractExpandableItem spellerController$AbstractExpandableItem) {
        return new SpellerIterator(SpellerController$AbstractExpandableItem.access$1400(spellerController$AbstractExpandableItem), null, true, true, true, this.getMovingDeleteButtonOrNull(), this.getMovingDeleteNeighbourButtonItemOrNull());
    }

    private SpellerController$ISpellerItem getMovingDeleteNeighbourButtonItemOrNull() {
        if (this.currentSpellerBand.hasMovingDeleteButton()) {
            return this.currentSpellerBand.getDeleteButtonNeighbor();
        }
        return null;
    }

    private SpellerController$ISpellerItem getMovingDeleteButtonOrNull() {
        if (this.currentSpellerBand.hasMovingDeleteButton()) {
            return this.currentSpellerBand.getDeleteButton();
        }
        return null;
    }

    public static boolean isButtonItem(SpellerController$ISpellerItem spellerController$ISpellerItem) {
        if (spellerController$ISpellerItem instanceof SpellerController$ButtonItem) {
            return true;
        }
        return spellerController$ISpellerItem instanceof SpellerController$AbstractExpandableItem && ((SpellerController$AbstractExpandableItem)spellerController$ISpellerItem).type == 1;
    }

    public static boolean isCharacterItem(SpellerController$ISpellerItem spellerController$ISpellerItem) {
        return spellerController$ISpellerItem instanceof SpellerController$ICharacterSpellerItem;
    }

    protected String extractString(SpellerController$ISpellerItem spellerController$ISpellerItem) {
        if (spellerController$ISpellerItem instanceof SpellerController$SingleCharItem) {
            return ((SpellerController$SingleCharItem)spellerController$ISpellerItem).getChar(this.currentSpellerBand.isUpperCase());
        }
        if (spellerController$ISpellerItem instanceof SpellerController$AbstractExpandableItem && ((SpellerController$AbstractExpandableItem)spellerController$ISpellerItem).type == 0) {
            return ((SpellerController$AbstractExpandableItem$Char)spellerController$ISpellerItem).getChar(this.currentSpellerBand.isUpperCase());
        }
        return "";
    }

    public void setAutoCompletionText(String string, String string2) {
        this.autoCompletionText = string;
        this.updateCompletionValidity(string2);
        this.setCompositesDirty(true);
    }

    public String getAutoCompletion() {
        return this.autoCompletionText;
    }

    private void updateCompletionValidity(String string) {
        boolean bl;
        boolean bl2 = bl = this.autoCompletionText != null && this.autoCompletionText.length() > 0;
        if (bl) {
            bl &= this.isSugguestionValidAtCurrentSpellerFocus(string, this.autoCompletionText);
        }
        if (bl && this.initContext.getScreen() != null) {
            ((AbstractScreenWidget)this.initContext.getScreen()).getTitleArea().getScreenAreaWidget().setOnScreen(false);
            IPartialPopupManagerEvo iPartialPopupManagerEvo = this.terminal.getPartialPopupManagerEvo();
            IPartialPopupController iPartialPopupController = iPartialPopupManagerEvo.getCurrentVisiblePopup(10);
            if (iPartialPopupController == null) {
                IUserHintHandler iUserHintHandler = this.terminal.getUserHintHandler();
                AbstractWidget abstractWidget = this.parent;
                if (abstractWidget instanceof TouchController) {
                    iUserHintHandler.requestHintAnimation(81, TouchController.getAbsoluteX(abstractWidget) + abstractWidget.getWidth(), TouchController.getAbsoluteY(abstractWidget) + abstractWidget.getHeight() + ((TouchController)abstractWidget).getHintYOffset());
                }
            } else {
                tpLogChannelInternal.log(14808325, "SpellerController#updateCompletionValidity: Another hint is playing, %1 hint can not display.", (long)0);
            }
        }
        this.setShowAutoCompletion(bl);
    }

    protected boolean isSugguestionValidAtCurrentSpellerFocus(String string, String string2) {
        boolean bl = true;
        SpellerController$ISpellerItem spellerController$ISpellerItem = this.getCurrentFocus();
        if ((bl &= SpellerController.isCharacterItem(spellerController$ISpellerItem)) && string.length() > 0) {
            SpellerController$ICharacterSpellerItem spellerController$ICharacterSpellerItem = (SpellerController$ICharacterSpellerItem)spellerController$ISpellerItem;
            String string3 = spellerController$ICharacterSpellerItem.getChar(false);
            bl &= string3.equalsIgnoreCase(string.substring(string.length() - 1)) || string2.toLowerCase().startsWith(StringUtility.concatenate(string, string3).toLowerCase());
        }
        if (spellerLogChannel.isDebug()) {
            spellerLogChannel.log(-2137614336, "SpellerController#isSugguestionValidAtCurrentSpellerFocus currentText='%1' / autoCompletion='%2' / focused item='%3' / valid=%4", (Object)string, (Object)string2, (Object)spellerController$ISpellerItem, (Object)Boolean.toString(bl));
        }
        return bl;
    }

    public boolean shallShowAutoCompletion() {
        return this.showAutoCompletion;
    }

    private void setShowAutoCompletion(boolean bl) {
        this.showAutoCompletion = bl;
    }

    public float getOpenProgress() {
        if (this.openAnimation != null && this.openAnimation.isAnimating()) {
            return this.openAnimation.getProgress();
        }
        return 32959;
    }

    public SpellerController$AbstractExpandableItem getItemToClose() {
        return this.itemToClose;
    }

    public boolean isSmallBandCentered() {
        return true;
    }

    public boolean isUpperCase() {
        return this.currentSpellerBand == null ? false : this.currentSpellerBand.isUpperCase();
    }

    public SpellerController$ISpellerItem getCurrentFocus() {
        return this.currentSpellerBand == null ? null : this.currentSpellerBand.getCurrentFocusedItem();
    }

    public boolean hasMovingDeleteButton() {
        return this.currentSpellerBand == null ? false : this.currentSpellerBand.hasMovingDeleteButton();
    }

    protected void closed() {
    }

    public final SpellerController$ISpellerItem getCurrentCursorTarget() {
        return this.currentSpellerBand == null ? null : this.targetCursorItem;
    }

    public void setForceOKButton(boolean bl) {
        this.forceOKButton = bl;
    }

    public boolean isCloseButtonEnabled() {
        return this.currentSpellerBand.getCloseButton() != null && this.currentSpellerBand.getCloseButton().isEnabled();
    }

    public boolean isCloseButtonAvailable() {
        return this.currentSpellerBand.getCloseButton() != null;
    }

    public boolean isLockingActive() {
        return this.lockingActive;
    }

    @Override
    public void optionDrawerActivated(IScreenData iScreenData, Screen screen, IDrawerControllerEvo iDrawerControllerEvo) {
    }

    @Override
    public void optionDrawerLocked(Boolean bl) {
        if (bl != null) {
            logLocking.log(1078071040, "SpellerController#optionDrawerLocked locked=%1", (Object)bl);
            this.lockingActive = bl;
            this.setCompositesDirty(true);
        }
    }

    @Override
    public void screenSet(IScreenData iScreenData, Screen screen) {
    }

    static /* synthetic */ ReusableInstanceCache access$000() {
        return SPELLER_ITEM_CACHE;
    }

    static /* synthetic */ ISpellerRenderer access$500(SpellerController spellerController) {
        return spellerController.renderer;
    }

    static /* synthetic */ List access$600(SpellerController spellerController) {
        return spellerController.registeredSpellerListeners;
    }

    static {
        SPELLER_ITEM_CACHE = new ReusableInstanceCache(SpellerController.createSpellerItemFactory());
    }
}

