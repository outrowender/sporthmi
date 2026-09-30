/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.HMIImageConstantsSystem;
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
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.job.Job;
import de.esolutions.hmi.widgets.audi.base.AbstractScreenWidget;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IUserHintHandler;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.StringUtility;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimationController;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.ISpellerListener;
import de.esolutions.hmi.widgets.audi.evo.widgets.ISpellerRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.ReusableInstanceCache;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerButtonArgument;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerCharsetDefinition;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerIterator;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchCharSetAndTTSHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchController;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchControllerDebugInfo;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SpellerController
extends AbstractWidgetController
implements AnimationListener,
ATIPEventListener,
IDrawerListener {
    public static final int MODE_FREETEXT = 0;
    public static final int MODE_PHONE_NUMBER = 1;
    public static final int MODE_PIN = 2;
    public static final int MODE_DMTF = 3;
    public static final int MODE_MULTILINE = 4;
    public static final int MODE_ADDRESSING = 5;
    public static final int MODE_WLAN = 6;
    public static final int MODE_TUNER_TV = 7;
    public static final int MODE_MATCH_PHONE = 8;
    public static final int MODE_MATCH_HOUSENUMBER = 9;
    public static final int MODE_CONNECT = 10;
    public static final int MODE_MATCHSPELLER = 11;
    public static final int MODE_ASIA_PASSWORD = 12;
    public static final int MODE_JP_MAPCODE = 13;
    public static final int MODE_TV_OPERATIONAL = 14;
    public static final int MODE_ONLINE = 15;
    public static final int MODE_VEHICLE_CODE = 16;
    public static final String SPACE_CHAR = " ";
    public static final String BACKSPACE = "\b";
    private static final int ANIMATION_TYPE_SPELLER_CURSOR = 73;
    private static final float ANIMATION_TARGET_SPELLER_CURSOR = 1000.0f;
    private static final long TIME_LONG_PRESS = 1000L;
    private static final long TIME_WRAP_AROUND = 500L;
    protected static final int ANIMATION_TYPE_SPELLER_EXPAND = 89;
    private static final float ANIMATION_TARGET_SPELLER_BAND_OPEN = 1000.0f;
    private static final ReusableInstanceCache SPELLER_ITEM_CACHE = new ReusableInstanceCache(SpellerController.createSpellerItemFactory());
    private static final int CURSOR_POSITION_LEFTMOST = 0;
    private static final int CURSOR_POSITION_MIDDLE = 1;
    private static final int CURSOR_POSITION_RIGHTMOST = 2;
    private int curCursorPostion = 0;
    private ISpellerBand currentSpellerBand;
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
    private AbstractExpandableItem itemToClose;
    protected ISpellerItem targetCursorItem;
    protected int spellerMode = 0;
    private String autoCompletionText;
    private boolean showAutoCompletion = false;
    private String currentValidChars = null;
    private List registeredSpellerListeners = new LinkedList();
    private ISpellerItem currentlyPressedItem;
    private boolean forceOKButton = false;
    private boolean showBoxNode = true;
    private boolean multilineAlternative = false;
    private float cursorMoveDuration = 1000.0f;
    public static final int BUTTON_CONFIRM_SDS_COMMAND = 0;
    private MenuItemController confirmButton = null;
    private boolean isDeleteDirectionRTL = true;
    private IDrawerFocusManagerEvo drawerFocusManager;
    private boolean lockingActive = false;
    protected final ISpellerListener spellerListenerNotifier = new ISpellerListener(){

        public void characterPressed(String string, boolean bl, boolean bl2) {
            Iterator iterator = SpellerController.this.registeredSpellerListeners.iterator();
            while (iterator.hasNext()) {
                ((ISpellerListener)iterator.next()).characterPressed(string, bl, bl2);
            }
        }

        public void focusChanged(ISpellerItem iSpellerItem, int n) {
            Iterator iterator = SpellerController.this.registeredSpellerListeners.iterator();
            while (iterator.hasNext()) {
                ((ISpellerListener)iterator.next()).focusChanged(iSpellerItem, n);
            }
        }

        public void buttonReleased(SpellerButtonType spellerButtonType) {
            Iterator iterator = SpellerController.this.registeredSpellerListeners.iterator();
            while (iterator.hasNext()) {
                ((ISpellerListener)iterator.next()).buttonReleased(spellerButtonType);
            }
        }

        public void buttonPressed(SpellerButtonType spellerButtonType, SpellerButtonArgument spellerButtonArgument) {
            Iterator iterator = SpellerController.this.registeredSpellerListeners.iterator();
            while (iterator.hasNext()) {
                ((ISpellerListener)iterator.next()).buttonPressed(spellerButtonType, spellerButtonArgument);
            }
        }

        public void buttonLongPressed(SpellerButtonType spellerButtonType) {
            Iterator iterator = SpellerController.this.registeredSpellerListeners.iterator();
            while (iterator.hasNext()) {
                ((ISpellerListener)iterator.next()).buttonLongPressed(spellerButtonType);
            }
        }

        public void focusedCharacterChanged(String string) {
            Iterator iterator = SpellerController.this.registeredSpellerListeners.iterator();
            while (iterator.hasNext()) {
                ((ISpellerListener)iterator.next()).focusedCharacterChanged(string);
            }
        }
    };
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
                spellerLogChannel.log(100000, "SpellerController#add added widget to Speller with wrong type or wrong role(%1)!", (long)n);
            }
        }
        this.add(abstractWidget);
    }

    protected SpellerButtonArgument getAdditionalOKArgument() {
        if (this.confirmButton == null) {
            return null;
        }
        final int n = this.confirmButton.getSdsCommand();
        final int n2 = this.confirmButton.getModelID();
        if (n != -1) {
            return new SpellerButtonArgument(){

                public void execute() {
                    if (AbstractWidget.sdsService != null) {
                        AbstractWidget.sdsService.keyTyped(n2, n);
                    } else {
                        IWidgetLogChannel.tpLogChannelInternal.log(100000, "SpellerController#SpellerButtonArgument#execute sdsService is NULL!");
                    }
                }
            };
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
        return new ReusableInstanceCache.AbstractInstanceFactory(){

            public ReusableInstanceCache.IReusable newInstance(String string) {
                if ("SingleCharItem".equals(string)) {
                    return new SingleCharItem();
                }
                if ("ExpandableItem.Char".equals(string)) {
                    return new AbstractExpandableItem.Char();
                }
                if ("ExpandableItem.CharSet".equals(string)) {
                    return new AbstractExpandableItem.CharSet();
                }
                if ("ButtonItem".equals(string)) {
                    return new ButtonItem();
                }
                if ("ToggleCharsetButtonItem".equals(string)) {
                    return new ToggleCharsetButtonItem();
                }
                if ("ToggleToSpellerButtonItem".equals(string)) {
                    return new ToggleToSpellerButtonItem();
                }
                IWidgetLogChannel.tpLogChannelInternal.log(10000, "SpellerController.AbstractInstanceFactory#newInstance: Could not create speller item, unkown type key %1.", (Object)string);
                return null;
            }
        };
    }

    protected static void addToSpellerItemCache(List list) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ReusableInstanceCache.IReusable iReusable = (ReusableInstanceCache.IReusable)iterator.next();
            if (iReusable instanceof AbstractExpandableItem) {
                SpellerController.addToSpellerItemCache(((AbstractExpandableItem)iReusable).getSubBand());
            }
            SPELLER_ITEM_CACHE.collect(iReusable);
        }
    }

    protected static void addToSpellerItemCache(ReusableInstanceCache.IReusable iReusable) {
        SPELLER_ITEM_CACHE.collect(iReusable);
    }

    protected SpellerIterator getCurrentSpellerIterator() {
        return this.getSpellerIterator(null, false, false);
    }

    public final void registerSpellerListener(ISpellerListener iSpellerListener) {
        this.registeredSpellerListeners.add(iSpellerListener);
    }

    protected void initializeWidget() {
        spellerLogChannel.log(1000000, "SpellerController#initializeWidget: Speller Mode=%1", (long)this.spellerMode);
        if (this.getCurrentSpellerBand() == null) {
            this.initializeSpellerBand();
        }
        this.setAutoCompletionText("", "");
        this.resetInitialItem();
    }

    private void initializeSpellerBand() {
        List list = SpellerCharsetDefinition.initSpellerBand(this.spellerMode, -1);
        SpellerBandImpl spellerBandImpl = new SpellerBandImpl(list, this.hasOKButton());
        this.setCurrentSpellerBand(spellerBandImpl, false);
    }

    protected ISpellerBand getSpellerBandForLanguage(TouchCharSetAndTTSHandler touchCharSetAndTTSHandler) {
        List list = SpellerCharsetDefinition.initSpellerBand(this.spellerMode, touchCharSetAndTTSHandler.getInternalLanguage());
        return new SpellerBandImpl(list, this.hasOKButton());
    }

    public IRenderer getRenderer() {
        return this.renderer;
    }

    public void setRenderer(ISpellerRenderer iSpellerRenderer) {
        this.renderer = iSpellerRenderer;
    }

    protected final void changeSpellerBand(ISpellerBand iSpellerBand) {
        this.setCurrentSpellerBand(iSpellerBand, false);
        iSpellerBand.resetInitialItem(false);
        this.targetCursorItem = iSpellerBand.getCurrentFocusedItem();
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
        spellerLogChannel.log(10000000, "[SpellerController#doCursorMove] Cursor at %3, move cursor to %1 with %2 clicks!", (long)n, (long)n2, (long)this.curCursorPostion);
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
            spellerLogChannel.log(10000000, "[SpellerController#updateValidChars] valid chars did not change!");
            return;
        }
        spellerLogChannel.log(10000000, "[SpellerController#updateValidChars] with %1", (Object)string);
        this.currentValidChars = string;
        SpellerIterator spellerIterator = this.getSpellerIterator(null, true, true, true);
        while (spellerIterator.hasNext()) {
            ISpellerItem iSpellerItem;
            boolean bl2;
            Object object = spellerIterator.next();
            boolean bl3 = bl2 = string2 != null && object instanceof ICharacterSpellerItem && ((ICharacterSpellerItem)object).getChar(true).equalsIgnoreCase(string2);
            if (bl2) break;
            if (object instanceof AbstractExpandableItem) {
                String string3;
                iSpellerItem = (AbstractExpandableItem)object;
                ((AbstractExpandableItem)iSpellerItem).setEnabled(false);
                if (((AbstractExpandableItem)iSpellerItem).type != 0 || (string3 = ((AbstractExpandableItem.Char)iSpellerItem).getChar(true)).length() <= 0) continue;
                ((AbstractExpandableItem)iSpellerItem).setEnabled(SpellerController.searchForCharacter(string, string3));
                continue;
            }
            if (!(object instanceof SingleCharItem) || ((SingleCharItem)(iSpellerItem = (SingleCharItem)object)).charactersUC.length() > 1) continue;
            boolean bl4 = SpellerController.searchForCharacter(string, ((SingleCharItem)iSpellerItem).charactersUC);
            ((SingleCharItem)iSpellerItem).setEnabled(bl4);
            if (!bl4 || ((SingleCharItem)iSpellerItem).parent == null) continue;
            this.enableParentIfNeeded((SingleCharItem)iSpellerItem, bl4);
        }
        this.updateCursorPosition();
        this.setCompositesDirty(true);
        this.renderer.refreshItemColors();
    }

    protected void enableParentIfNeeded(SingleCharItem singleCharItem, boolean bl) {
        if (((SingleCharItem)singleCharItem).parent.type != 0 || !(this.parent instanceof TouchController) || !((TouchController)this.parent).isMatchSpellerMode()) {
            singleCharItem.parent.setEnabled(bl);
        }
    }

    private void updateCursorPosition() {
        ISpellerItem iSpellerItem = this.getCurrentFocus();
        SpellerIterator spellerIterator = this.getSpellerIterator(null, true, false);
        while (spellerIterator.hasNext()) {
            ISpellerItem iSpellerItem2 = (ISpellerItem)spellerIterator.next();
            if (iSpellerItem != iSpellerItem2) continue;
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
        spellerLogChannel.log(10000000, "[SpellerController#updateCursorPosition] Cursor at %1 ", (long)this.curCursorPostion);
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
        this.longPressJob = AbstractWidget.framework.getHMIService().getEventDispatcher().postEvent(this.longPressEvent, 1000L);
    }

    protected void handlePressItem(ISpellerItem iSpellerItem) {
        if (!iSpellerItem.isEnabled()) {
            spellerLogChannel.log(10000000, "SpellerController#handlePressItem: ignore press event on disabled item: %1", (Object)iSpellerItem);
            return;
        }
        this.currentlyPressedItem = iSpellerItem;
        if (iSpellerItem instanceof SingleCharItem) {
            if (!this.isLongPressJobRunning()) {
                this.startLongPressJob();
            }
            this.handleSingleCharItemPressed((SingleCharItem)iSpellerItem);
        } else if (iSpellerItem instanceof ButtonItem) {
            ButtonItem buttonItem = (ButtonItem)iSpellerItem;
            SpellerButtonType spellerButtonType = buttonItem.getButtonType();
            SpellerButtonArgument spellerButtonArgument = buttonItem.getAdditionalArgument();
            this.spellerListenerNotifier.buttonPressed(spellerButtonType, spellerButtonArgument);
            if (spellerButtonType == SpellerButtonType.DELETE) {
                if (!this.isLongPressJobRunning()) {
                    this.startLongPressJob();
                }
            } else if (spellerButtonType == SpellerButtonType.SHIFT) {
                this.currentSpellerBand.setIsUpperCase(!this.currentSpellerBand.isUpperCase());
                this.renderer.switchCase();
                this.setCompositesDirty(true);
            }
        } else if (iSpellerItem instanceof AbstractExpandableItem) {
            AbstractExpandableItem abstractExpandableItem = (AbstractExpandableItem)iSpellerItem;
            if (abstractExpandableItem.type == 0) {
                if (!this.isLongPressJobRunning()) {
                    this.startLongPressJob();
                }
            } else {
                this.handleReleaseExpandedItem(abstractExpandableItem, false);
            }
        }
        this.currentSpellerBand.itemPressed(iSpellerItem);
    }

    public void setSpellerBandLanguage(TouchCharSetAndTTSHandler touchCharSetAndTTSHandler) {
        this.isDeleteDirectionRTL = touchCharSetAndTTSHandler.getInternalLanguage() != 26;
        int n = touchCharSetAndTTSHandler.getInternalLanguage();
        if (spellerLogChannel.isInfo()) {
            String string = "";
            if (I18NTarget.LANGUAGES != null && I18NTarget.LANGUAGES.length > n) {
                string = I18NTarget.LANGUAGES[n].getHmiCode();
            }
            spellerLogChannel.log(1000000, "SpellerController#setSpellerBandLanguage: langIndex=%2, langCode=%1", (Object)string, (long)n);
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

    private void closeAllOtherItems(AbstractExpandableItem abstractExpandableItem) {
        SpellerIterator spellerIterator = this.getSpellerIterator(null, false);
        while (spellerIterator.hasNext()) {
            AbstractExpandableItem abstractExpandableItem2;
            Object object = spellerIterator.next();
            if (!(object instanceof AbstractExpandableItem) || object == abstractExpandableItem || (abstractExpandableItem2 = (AbstractExpandableItem)object).closed) continue;
            this.startClosing(abstractExpandableItem2);
        }
    }

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
        if (this.currentlyPressedItem instanceof AbstractExpandableItem.Char) {
            this.handleReleaseExpandedItem((AbstractExpandableItem.Char)this.currentlyPressedItem, false);
        } else if (this.currentlyPressedItem instanceof SingleCharItem) {
            this.notifyCharacterPressed((ICharacterSpellerItem)this.currentlyPressedItem, false, false);
        }
        this.currentlyPressedItem = null;
        return true;
    }

    private void notifyButtonReleasedIfNeeded() {
        if (this.currentlyPressedItem instanceof ButtonItem) {
            this.spellerListenerNotifier.buttonReleased(((ButtonItem)this.currentlyPressedItem).getButtonType());
        }
    }

    private void handleReleaseExpandedItem(AbstractExpandableItem abstractExpandableItem, boolean bl) {
        if (abstractExpandableItem.type == 1 || abstractExpandableItem.type == 0 && bl) {
            if (abstractExpandableItem.closed) {
                this.closeAllOtherItems(abstractExpandableItem);
                abstractExpandableItem.closed = false;
                this.renderer.openItem();
            } else {
                this.startClosing(abstractExpandableItem);
            }
            this.startBandExpandAnimation();
            this.setCompositesDirty(true);
        } else if (abstractExpandableItem.isEnabled()) {
            this.notifyCharacterPressed((ICharacterSpellerItem)((Object)abstractExpandableItem), bl, true);
        } else {
            spellerLogChannel.log(10000000, "SpellerController#handlePressExpandedItem: ignore release event on disabled expand item: %1", (Object)abstractExpandableItem);
        }
    }

    protected void startBandExpandAnimation() {
        AbstractAnimation abstractAnimation = this.getBandOpenAnimation();
        if (abstractAnimation.isAnimating()) {
            abstractAnimation.setTarget(abstractAnimation.getTarget() + 1000.0f);
        } else {
            abstractAnimation.startDynamicAnimation(0.0f, 1000.0f, 89, false, this);
        }
    }

    private void startClosing(AbstractExpandableItem abstractExpandableItem) {
        if (this.itemToClose != null) {
            this.closeItem(this.itemToClose);
        }
        abstractExpandableItem.closed = true;
        this.itemToClose = abstractExpandableItem;
        this.startBandExpandAnimation();
    }

    private void closeItem(AbstractExpandableItem abstractExpandableItem) {
        abstractExpandableItem.closed = true;
        this.renderer.closeItem(abstractExpandableItem);
    }

    protected void handleSingleCharItemPressed(SingleCharItem singleCharItem) {
        if (singleCharItem.parent != null && ((SingleCharItem)singleCharItem).parent.type == 0) {
            this.startClosing(singleCharItem.parent);
            this.setCursorPosition(singleCharItem.parent);
            this.targetCursorItem = singleCharItem.parent;
        }
    }

    protected void notifyCharacterPressed(ICharacterSpellerItem iCharacterSpellerItem, boolean bl, boolean bl2) {
        String string = iCharacterSpellerItem.getChar(this.currentSpellerBand.isUpperCase());
        this.spellerListenerNotifier.characterPressed(string, bl, bl2);
    }

    public ISpellerBand getCurrentSpellerBand() {
        return this.currentSpellerBand;
    }

    protected final void setCurrentSpellerBand(ISpellerBand iSpellerBand, boolean bl) {
        if (bl && this.currentSpellerBand != null && this.currentSpellerBand != iSpellerBand) {
            this.currentSpellerBand.free(false);
        }
        this.currentSpellerBand = iSpellerBand;
    }

    public boolean setNewFocus(char c2) {
        if (!Character.isDefined(c2)) {
            return false;
        }
        SpellerIterator spellerIterator = this.getSpellerIterator(this.getFirstItem(), true, true, true);
        while (spellerIterator.hasNext()) {
            SingleCharItem singleCharItem;
            Object object = spellerIterator.next();
            if (!(object instanceof SingleCharItem) || (singleCharItem = (SingleCharItem)object).getChar(true).charAt(0) != c2) continue;
            if (singleCharItem.hasParent()) {
                singleCharItem.getParent().setClosed(false);
            }
            this.moveCursorToItem(singleCharItem);
            ((SpellerBandImpl)this.currentSpellerBand).moveDeleteButton(singleCharItem, false);
            return true;
        }
        return false;
    }

    protected void moveCursor(float f2, boolean bl) {
        AbstractAnimation abstractAnimation;
        SpellerIterator spellerIterator = this.getSpellerIterator(this.targetCursorItem, true, false);
        ISpellerItem iSpellerItem = this.targetCursorItem;
        boolean bl2 = false;
        if (f2 < 0.0f) {
            bl2 = true;
            f2 = -f2;
        }
        int n = 0;
        while ((float)n < f2) {
            if (bl2) {
                if (spellerIterator.hasPrevious()) {
                    iSpellerItem = (ISpellerItem)spellerIterator.previous();
                    if (!spellerIterator.hasPrevious()) {
                        this.startWrapAroundJob();
                        this.curCursorPostion = 0;
                        break;
                    }
                    this.curCursorPostion = 1;
                } else {
                    iSpellerItem = this.getLastItem();
                }
            } else if (spellerIterator.hasNext()) {
                iSpellerItem = (ISpellerItem)spellerIterator.next();
                if (!spellerIterator.hasNext()) {
                    this.startWrapAroundJob();
                    this.curCursorPostion = 2;
                    break;
                }
                this.curCursorPostion = 1;
            } else {
                iSpellerItem = this.getFirstItem();
            }
            ++n;
        }
        this.targetCursorItem = iSpellerItem;
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
            abstractAnimation.setTarget(abstractAnimation.getTarget() + 1000.0f);
        } else {
            abstractAnimation.startDynamicAnimation(0.0f, this.cursorMoveDuration, 73, false, this);
            this.cursorAnimationProgress = 0.0f;
            this.setCursorPosition(null);
        }
    }

    public void setCursorDuration(float f2) {
        this.cursorMoveDuration = f2;
    }

    public ISpellerItem getFirstItem() {
        return (ISpellerItem)this.getSpellerIterator(null, true, false).next();
    }

    public ISpellerItem getLastItem() {
        SpellerIterator spellerIterator = this.getSpellerIterator(null, true, false);
        ISpellerItem iSpellerItem = null;
        while (spellerIterator.hasNext()) {
            iSpellerItem = (ISpellerItem)spellerIterator.next();
        }
        return iSpellerItem;
    }

    private void startWrapAroundJob() {
        this.cancelWrapAroundJob();
        this.wrapAroundJobRunning = true;
        this.wrapAroundEvent = new TimerEvent(this);
        this.wrapAroundJob = AbstractWidget.framework.getHMIService().getEventDispatcher().postEvent(this.wrapAroundEvent, 500L);
    }

    public void setCursorPosition(ISpellerItem iSpellerItem) {
        this.spellerListenerNotifier.focusChanged(this.getCurrentFocus(), 0);
        this.currentSpellerBand.setCurrentFocusedItem(iSpellerItem);
        this.spellerListenerNotifier.focusedCharacterChanged(this.extractString(iSpellerItem));
        this.spellerListenerNotifier.focusChanged(iSpellerItem, 1);
        this.handleCursorPositionForAutoCompletion(iSpellerItem);
        this.setCompositesDirty(true);
    }

    protected void moveCursorToItem(ISpellerItem iSpellerItem) {
        this.targetCursorItem = iSpellerItem;
        this.setCursorPosition(iSpellerItem);
    }

    protected void handleCursorPositionForAutoCompletion(ISpellerItem iSpellerItem) {
        if (iSpellerItem != null) {
            this.setShowAutoCompletion(false);
        }
    }

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
        spellerLogChannel.log(10000000, "SpellerController#setSpellerMode: changing speller mode from %1 to %2", (long)this.spellerMode, (long)n);
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

    public void animationStarted(int n, int n2) {
    }

    public void animationFinished(int n, int n2) {
        if (n == 73) {
            this.cursorAnimationProgress = -1.0f;
            this.setCursorPosition(this.targetCursorItem);
        } else if (n == 89 && this.itemToClose != null) {
            this.closeItem(this.itemToClose);
            this.itemToClose = null;
        }
    }

    public boolean isCursorAnimating() {
        return this.getCursorAnimation() != null && this.getCursorAnimation().isAnimating();
    }

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
        if (this.currentlyPressedItem instanceof AbstractExpandableItem.Char) {
            AbstractExpandableItem.Char char_ = (AbstractExpandableItem.Char)this.currentlyPressedItem;
            this.expandSpellerExpandableItem(char_);
            String string = char_.getChar(this.getCurrentSpellerBand().isUpperCase());
            this.spellerListenerNotifier.characterPressed(string, true, true);
            this.currentlyPressedItem = null;
        } else if (this.currentlyPressedItem instanceof SingleCharItem) {
            String string = ((SingleCharItem)this.currentlyPressedItem).getChar(this.currentSpellerBand.isUpperCase());
            this.spellerListenerNotifier.characterPressed(string, true, false);
            this.currentlyPressedItem = null;
        } else if (this.currentlyPressedItem instanceof ButtonItem) {
            this.spellerListenerNotifier.buttonLongPressed(((ButtonItem)this.currentlyPressedItem).getButtonType());
        }
        if (this.currentSpellerBand.getCurrentFocusedItem() == this.currentSpellerBand.getDeleteButton()) {
            logRepaintCause.log(10000000, "SpellerController#fireTimer: long press timer on delete item. trigger repaint. screen: %1", (long)this.getScreenId());
            this.triggerRepaint();
        }
    }

    protected void expandSpellerExpandableItem(AbstractExpandableItem.Char char_) {
        AbstractExpandableItem.Char char_2 = char_;
        this.handleReleaseExpandedItem(char_2, true);
        this.updateCursorPosition();
        logRepaintCause.log(10000000, "SpellerController#expandSpellerExpandableItem: Expand speller item. trigger repaint. screen: %1", (long)this.getScreenId());
        this.triggerRepaint();
    }

    protected void closeSpellerExandableItem(AbstractExpandableItem.Char char_) {
        AbstractExpandableItem.Char char_2 = char_;
        this.startClosing(char_2);
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

    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
        this.drawerFocusManager = this.terminal.getDrawerFocusManager();
        if (this.drawerFocusManager != null) {
            this.drawerFocusManager.addDrawerListener(this);
        }
    }

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

    public SpellerIterator getSpellerIterator(ISpellerItem iSpellerItem, boolean bl) {
        return this.getSpellerIterator(iSpellerItem, bl, true, false);
    }

    public SpellerIterator getSpellerIterator(ISpellerItem iSpellerItem, boolean bl, boolean bl2) {
        return this.getSpellerIterator(iSpellerItem, bl, bl2, false);
    }

    public SpellerIterator getSpellerIterator(ISpellerItem iSpellerItem, boolean bl, boolean bl2, boolean bl3) {
        if (this.currentSpellerBand == null) {
            this.initializeSpellerBand();
        }
        return new SpellerIterator(this.currentSpellerBand.getSpellerItems(), iSpellerItem, bl2, bl, bl3, this.getMovingDeleteButtonOrNull(), this.getMovingDeleteNeighbourButtonItemOrNull());
    }

    public SpellerIterator getSubBandIterator(AbstractExpandableItem abstractExpandableItem) {
        return new SpellerIterator(abstractExpandableItem.subBand, null, true, true, true, this.getMovingDeleteButtonOrNull(), this.getMovingDeleteNeighbourButtonItemOrNull());
    }

    private ISpellerItem getMovingDeleteNeighbourButtonItemOrNull() {
        if (this.currentSpellerBand.hasMovingDeleteButton()) {
            return this.currentSpellerBand.getDeleteButtonNeighbor();
        }
        return null;
    }

    private ISpellerItem getMovingDeleteButtonOrNull() {
        if (this.currentSpellerBand.hasMovingDeleteButton()) {
            return this.currentSpellerBand.getDeleteButton();
        }
        return null;
    }

    public static boolean isButtonItem(ISpellerItem iSpellerItem) {
        if (iSpellerItem instanceof ButtonItem) {
            return true;
        }
        return iSpellerItem instanceof AbstractExpandableItem && ((AbstractExpandableItem)iSpellerItem).type == 1;
    }

    public static boolean isCharacterItem(ISpellerItem iSpellerItem) {
        return iSpellerItem instanceof ICharacterSpellerItem;
    }

    protected String extractString(ISpellerItem iSpellerItem) {
        if (iSpellerItem instanceof SingleCharItem) {
            return ((SingleCharItem)iSpellerItem).getChar(this.currentSpellerBand.isUpperCase());
        }
        if (iSpellerItem instanceof AbstractExpandableItem && ((AbstractExpandableItem)iSpellerItem).type == 0) {
            return ((AbstractExpandableItem.Char)iSpellerItem).getChar(this.currentSpellerBand.isUpperCase());
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
                tpLogChannelInternal.log(100000000, "SpellerController#updateCompletionValidity: Another hint is playing, %1 hint can not display.", 81L);
            }
        }
        this.setShowAutoCompletion(bl);
    }

    protected boolean isSugguestionValidAtCurrentSpellerFocus(String string, String string2) {
        boolean bl = true;
        ISpellerItem iSpellerItem = this.getCurrentFocus();
        if ((bl &= SpellerController.isCharacterItem(iSpellerItem)) && string.length() > 0) {
            ICharacterSpellerItem iCharacterSpellerItem = (ICharacterSpellerItem)iSpellerItem;
            String string3 = iCharacterSpellerItem.getChar(false);
            bl &= string3.equalsIgnoreCase(string.substring(string.length() - 1)) || string2.toLowerCase().startsWith(StringUtility.concatenate(string, string3).toLowerCase());
        }
        if (spellerLogChannel.isDebug()) {
            spellerLogChannel.log(10000000, "SpellerController#isSugguestionValidAtCurrentSpellerFocus currentText='%1' / autoCompletion='%2' / focused item='%3' / valid=%4", (Object)string, (Object)string2, (Object)iSpellerItem, (Object)Boolean.toString(bl));
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
        return -1.0f;
    }

    public AbstractExpandableItem getItemToClose() {
        return this.itemToClose;
    }

    public boolean isSmallBandCentered() {
        return true;
    }

    public boolean isUpperCase() {
        return this.currentSpellerBand == null ? false : this.currentSpellerBand.isUpperCase();
    }

    public ISpellerItem getCurrentFocus() {
        return this.currentSpellerBand == null ? null : this.currentSpellerBand.getCurrentFocusedItem();
    }

    public boolean hasMovingDeleteButton() {
        return this.currentSpellerBand == null ? false : this.currentSpellerBand.hasMovingDeleteButton();
    }

    protected void closed() {
    }

    public final ISpellerItem getCurrentCursorTarget() {
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

    public void optionDrawerActivated(IScreenData iScreenData, Screen screen, IDrawerControllerEvo iDrawerControllerEvo) {
    }

    public void optionDrawerLocked(Boolean bl) {
        if (bl != null) {
            logLocking.log(1000000, "SpellerController#optionDrawerLocked locked=%1", (Object)bl);
            this.lockingActive = bl;
            this.setCompositesDirty(true);
        }
    }

    public void screenSet(IScreenData iScreenData, Screen screen) {
    }

    public static class ButtonItem
    implements ISpellerItem {
        public static final String TYPE_KEY = "ButtonItem";
        private SpellerButtonType buttonType;
        private boolean enabled = true;
        private SpellerButtonArgument additionalArgument = null;

        public void setAdditionalArgument(SpellerButtonArgument spellerButtonArgument) {
            this.additionalArgument = spellerButtonArgument;
        }

        public SpellerButtonArgument getAdditionalArgument() {
            return this.additionalArgument;
        }

        private ButtonItem() {
            this.reset();
        }

        public static ButtonItem createInstance(SpellerButtonType spellerButtonType) {
            ButtonItem buttonItem = (ButtonItem)SPELLER_ITEM_CACHE.getOrCreateInstance(TYPE_KEY);
            buttonItem.setButtonType(spellerButtonType);
            return buttonItem;
        }

        public String getTypeKey() {
            return TYPE_KEY;
        }

        public void reset() {
            this.buttonType = SpellerButtonType.NULL;
            this.enabled = true;
        }

        public boolean isEnabled() {
            return this.enabled;
        }

        public void setEnabled(boolean bl) {
            this.enabled = bl;
        }

        public String toString() {
            return new StringBuffer().append("ButtonItem type:").append(this.buttonType).toString();
        }

        public boolean itemContentEquals(ISpellerItem iSpellerItem) {
            if (this == iSpellerItem) {
                return true;
            }
            if (iSpellerItem == null) {
                return false;
            }
            if (this.getClass() != iSpellerItem.getClass()) {
                return false;
            }
            ButtonItem buttonItem = (ButtonItem)iSpellerItem;
            return this.buttonType == buttonItem.getButtonType();
        }

        public SpellerButtonType getButtonType() {
            return this.buttonType;
        }

        protected void setButtonType(SpellerButtonType spellerButtonType) {
            this.buttonType = spellerButtonType;
        }
    }

    public static interface ISpellerBand {
        public List getSpellerItems();

        public ISpellerItem getCurrentFocusedItem();

        public void setCurrentFocusedItem(ISpellerItem var1);

        public ISpellerItem getCloseButton();

        public ISpellerItem getOkItem();

        public ISpellerItem getDeleteButton();

        public ISpellerItem getLeftButton();

        public ISpellerItem getRightButton();

        public ISpellerItem getDeleteButtonNeighbor();

        public boolean isUpperCase();

        public void setIsUpperCase(boolean var1);

        public void itemPressed(ISpellerItem var1);

        public void resetInitialItem(boolean var1);

        public boolean hasMovingDeleteButton();

        public void autoCompletionAccepted();

        public void free(boolean var1);
    }

    public static interface ISpellerItem
    extends ReusableInstanceCache.IReusable {
        public boolean isEnabled();

        public void setEnabled(boolean var1);

        public boolean itemContentEquals(ISpellerItem var1);
    }

    public static class SingleCharItem
    implements ICharacterSpellerItem {
        public static final String TYPE_KEY = "SingleCharItem";
        private String charactersUC;
        private String charactersLC;
        private boolean enabled = true;
        private AbstractExpandableItem parent;

        private SingleCharItem() {
        }

        public static SingleCharItem createInstance(String string) {
            return SingleCharItem.createInstance(null, string, null);
        }

        public static SingleCharItem createInstance(String string, String string2) {
            return SingleCharItem.createInstance(null, string, string2);
        }

        public static SingleCharItem createInstance(AbstractExpandableItem abstractExpandableItem, String string, String string2) {
            SingleCharItem singleCharItem = (SingleCharItem)SPELLER_ITEM_CACHE.getOrCreateInstance(TYPE_KEY);
            singleCharItem.setChar(string, string2);
            singleCharItem.parent = abstractExpandableItem;
            return singleCharItem;
        }

        public String getTypeKey() {
            return TYPE_KEY;
        }

        public void reset() {
            this.charactersUC = null;
            this.charactersLC = null;
            this.enabled = true;
            this.parent = null;
        }

        public void setChar(String string, String string2) {
            this.charactersUC = string;
            this.charactersLC = string2;
        }

        public boolean hasParent() {
            return this.parent != null;
        }

        public String getChar(boolean bl) {
            if (bl || this.charactersLC == null) {
                return this.charactersUC;
            }
            return this.charactersLC;
        }

        public void setEnabled(boolean bl) {
            this.enabled = bl;
        }

        public boolean isEnabled() {
            return this.enabled;
        }

        public AbstractExpandableItem getParent() {
            return this.parent;
        }

        public String toString() {
            return new StringBuffer().append("Character: ").append(this.charactersUC).toString();
        }

        public boolean itemContentEquals(ISpellerItem iSpellerItem) {
            if (this == iSpellerItem) {
                return true;
            }
            if (iSpellerItem == null) {
                return false;
            }
            if (this.getClass() != iSpellerItem.getClass()) {
                return false;
            }
            SingleCharItem singleCharItem = (SingleCharItem)iSpellerItem;
            if (this.charactersLC == null ? singleCharItem.charactersLC != null : !this.charactersLC.equals(singleCharItem.charactersLC)) {
                return false;
            }
            return !(this.charactersUC == null ? singleCharItem.charactersUC != null : !this.charactersUC.equals(singleCharItem.charactersUC));
        }
    }

    protected class SpellerBandImpl
    implements ISpellerBand {
        private List spellerItems;
        private ISpellerItem currentFocusedItem;
        private ISpellerItem closeButton;
        private ISpellerItem okItem;
        private ISpellerItem leftItem;
        private ISpellerItem rightItem;
        private ISpellerItem deleteItem;
        protected ISpellerItem deletePosItem;
        private boolean upperCase = true;

        public SpellerBandImpl(List list, boolean bl) {
            this(list, bl, spellerController.getSpellerMode() != 14, true);
        }

        protected SpellerBandImpl(List list, boolean bl, boolean bl2, boolean bl3) {
            this(list, bl, bl2, bl3, true);
        }

        protected SpellerBandImpl(List list, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
            ButtonItem buttonItem;
            this.spellerItems = list == null ? new ArrayList() : list;
            if (bl4) {
                buttonItem = ButtonItem.createInstance(SpellerButtonType.CLOSE);
                this.closeButton = buttonItem;
                this.spellerItems.add(0, buttonItem);
            }
            if (bl) {
                buttonItem = ButtonItem.createInstance(SpellerButtonType.OK);
                this.spellerItems.add(bl4 ? 1 : 0, buttonItem);
                buttonItem.setAdditionalArgument(SpellerController.this.getAdditionalOKArgument());
                this.okItem = buttonItem;
            } else {
                this.okItem = null;
            }
            this.deleteItem = bl2 ? ButtonItem.createInstance(SpellerButtonType.DELETE) : null;
            for (int i2 = 0; i2 < this.spellerItems.size(); ++i2) {
                if (!(this.spellerItems.get(i2) instanceof ButtonItem)) continue;
                ButtonItem buttonItem2 = (ButtonItem)this.spellerItems.get(i2);
                if (buttonItem2.getButtonType().equals(SpellerButtonType.LEFT)) {
                    this.leftItem = buttonItem2;
                }
                if (!buttonItem2.getButtonType().equals(SpellerButtonType.RIGHT)) continue;
                this.rightItem = buttonItem2;
            }
            this.upperCase = bl3;
            this.currentFocusedItem = this.spellerItems.isEmpty() ? null : (ISpellerItem)this.spellerItems.get(0);
        }

        public List getSpellerItems() {
            return this.spellerItems;
        }

        public ISpellerItem getCurrentFocusedItem() {
            return this.currentFocusedItem;
        }

        public void setCurrentFocusedItem(ISpellerItem iSpellerItem) {
            this.currentFocusedItem = iSpellerItem;
        }

        public ISpellerItem getOkItem() {
            return this.okItem;
        }

        public ISpellerItem getDeleteButton() {
            return this.deleteItem;
        }

        public ISpellerItem getCloseButton() {
            return this.closeButton;
        }

        public ISpellerItem getDeleteButtonNeighbor() {
            return this.deletePosItem;
        }

        public ISpellerItem getLeftButton() {
            return this.leftItem;
        }

        public ISpellerItem getRightButton() {
            return this.rightItem;
        }

        private void setItemNextToDelete(ISpellerItem iSpellerItem) {
            this.deletePosItem = iSpellerItem;
        }

        public boolean isUpperCase() {
            return this.upperCase;
        }

        public void setIsUpperCase(boolean bl) {
            this.upperCase = bl;
        }

        public void itemPressed(ISpellerItem iSpellerItem) {
            if (SpellerController.this.targetCursorItem == null || this.deletePosItem == SpellerController.this.targetCursorItem) {
                return;
            }
            if (SpellerController.this.targetCursorItem instanceof SingleCharItem) {
                SingleCharItem singleCharItem = (SingleCharItem)SpellerController.this.targetCursorItem;
                if (!singleCharItem.hasParent()) {
                    this.moveDeleteButton(SpellerController.this.targetCursorItem, true);
                } else if (singleCharItem.parent instanceof AbstractExpandableItem && ((SingleCharItem)singleCharItem).parent.type == 1) {
                    this.moveDeleteButton(SpellerController.this.targetCursorItem, true);
                }
            } else if (SpellerController.this.targetCursorItem instanceof AbstractExpandableItem) {
                SingleCharItem singleCharItem;
                AbstractExpandableItem abstractExpandableItem = (AbstractExpandableItem)SpellerController.this.targetCursorItem;
                if (abstractExpandableItem.type == 0) {
                    this.moveDeleteButton(SpellerController.this.targetCursorItem, true);
                } else if (this.deletePosItem instanceof SingleCharItem && (singleCharItem = (SingleCharItem)this.deletePosItem).hasParent() && singleCharItem.getParent().isClosed()) {
                    this.moveDeleteButton(((SingleCharItem)this.deletePosItem).getParent(), false);
                }
            } else if (SpellerController.this.targetCursorItem instanceof ButtonItem) {
                boolean bl;
                SpellerButtonType spellerButtonType = ((ButtonItem)SpellerController.this.targetCursorItem).getButtonType();
                boolean bl2 = bl = spellerButtonType == SpellerButtonType.NEWLINE || spellerButtonType == SpellerButtonType.SMILEY_SMILING || spellerButtonType == SpellerButtonType.SMILEY_LAUGHING || spellerButtonType == SpellerButtonType.SMILEY_WINKING || spellerButtonType == SpellerButtonType.SMILEY_DISAPPOINTED;
                if (bl) {
                    this.moveDeleteButton(SpellerController.this.targetCursorItem, true);
                }
            }
        }

        public void resetInitialItem(boolean bl) {
            if (this.getSpellerItems().size() < 1) {
                IWidgetLogChannel.spellerLogChannel.log(1000, "[SpellerController#findStartItem] Could not find a valid item for the initial focus.");
                return;
            }
            ISpellerItem iSpellerItem = this.getCurrentFocusedItem();
            this.setCurrentFocusedItem((ISpellerItem)this.getSpellerItems().get(0));
            SpellerController.this.targetCursorItem = this.getCurrentFocusedItem();
            if (SpellerController.this.renderer != null && bl && iSpellerItem != null && iSpellerItem != SpellerController.this.targetCursorItem) {
                SpellerController.this.renderer.startCursorAnimation(iSpellerItem, SpellerController.this.targetCursorItem);
            }
            ISpellerItem iSpellerItem2 = this.getCurrentFocusedItem();
            SpellerIterator spellerIterator = SpellerController.this.getCurrentSpellerIterator();
            while (spellerIterator.hasNext()) {
                ISpellerItem iSpellerItem3 = (ISpellerItem)spellerIterator.next();
                if (!SpellerController.isCharacterItem(iSpellerItem3)) continue;
                iSpellerItem2 = iSpellerItem3;
                break;
            }
            this.moveDeleteButton(iSpellerItem2, false);
        }

        public void moveDeleteButton(ISpellerItem iSpellerItem, boolean bl) {
            this.setItemNextToDelete(iSpellerItem);
            if (SpellerController.this.renderer != null) {
                SpellerController.this.renderer.deleteMoved();
                if (bl) {
                    SpellerController.this.setCompositesDirty(true);
                }
            }
        }

        public void autoCompletionAccepted() {
            this.moveDeleteButton(this.getCurrentFocusedItem(), false);
        }

        public boolean hasMovingDeleteButton() {
            return this.deleteItem != null;
        }

        public String toString() {
            return new StringBuffer().append("SpellerBandImpl [spellerItems=").append(this.spellerItems).append(", currentFocusedItem=").append(this.currentFocusedItem).append(", okItem=").append(this.okItem).append(", deleteItem=").append(this.deleteItem).append(", deletePosItem=").append(this.deletePosItem).append(", isUpperCase=").append(this.upperCase).append("]").toString();
        }

        public void free(boolean bl) {
            if (this.spellerItems != null) {
                SpellerController.addToSpellerItemCache(this.spellerItems);
                this.spellerItems = Collections.EMPTY_LIST;
            }
            if (this.deleteItem != null) {
                SpellerController.addToSpellerItemCache(this.deleteItem);
                this.deleteItem = null;
            }
            if (this.okItem != null) {
                SpellerController.addToSpellerItemCache(this.okItem);
                this.okItem = null;
            }
        }
    }

    public static final class SpellerButtonType {
        private static final SpellerButtonType[] SPELLER_BUTTON_TYPES = new SpellerButtonType[]{new SpellerButtonType("SPACE"), new SpellerButtonType("DELETE"), new SpellerButtonType("OK"), new SpellerButtonType("CLOSE"), new SpellerButtonType("SHIFT"), new SpellerButtonType("LEFT"), new SpellerButtonType("RIGHT"), new SpellerButtonType("TOGGLE_TO_SPELLER", 0, HMIImageConstantsSystem.mib2_speller_dummybutton, HMIImageConstantsSystem.mib2_speller_dummybutton), new SpellerButtonType("TOGGLE_LATIN_TO_PINYIN", 3, HMIImageConstantsSystem.mib2_speller_button_latin2pinyin, HMIImageConstantsSystem.mib2_speller_button_latin2pinyin_big), new SpellerButtonType("TOGGLE_LATIN_TO_STROKE", 4, HMIImageConstantsSystem.mib2_speller_button_latin2stroke, HMIImageConstantsSystem.mib2_speller_button_latin2pinyin_big), new SpellerButtonType("TOGGLE_PINYIN_TO_LATIN", 0, HMIImageConstantsSystem.mib2_speller_button_pinyin2latin, HMIImageConstantsSystem.mib2_speller_button_pinyin2latin_big), new SpellerButtonType("TOGGLE_STROKE_TO_LATIN", 0, HMIImageConstantsSystem.mib2_speller_button_stroke2latin, HMIImageConstantsSystem.mib2_speller_button_pinyin2latin_big), new SpellerButtonType("TOGGLE_LATIN_TO_TAIWAN", 5, HMIImageConstantsSystem.mib2_speller_button_latin2tw, HMIImageConstantsSystem.mib2_speller_button_latin2tw_big), new SpellerButtonType("TOGGLE_TAIWAN_TO_LATIN", 0, HMIImageConstantsSystem.mib2_speller_button_tw2latin, HMIImageConstantsSystem.mib2_speller_button_tw2latin_big), new SpellerButtonType("TOGGLE_LATIN_TO_JAPAN", 6, HMIImageConstantsSystem.mib2_speller_button_latin2jp, HMIImageConstantsSystem.mib2_speller_button_latin2jp_big), new SpellerButtonType("TOGGLE_JAPAN_TO_LATIN", 0, HMIImageConstantsSystem.mib2_speller_button_jp2latin, HMIImageConstantsSystem.mib2_speller_button_jp2latin_big), new SpellerButtonType("TOGGLE_LATIN_TO_KOREA", 7, HMIImageConstantsSystem.mib2_speller_button_latin2kr, HMIImageConstantsSystem.mib2_speller_button_latin2kr_big), new SpellerButtonType("TOGGLE_KOREA_TO_LATIN", 0, HMIImageConstantsSystem.mib2_speller_button_kr2latin, HMIImageConstantsSystem.mib2_speller_button_kr2latin_big), new SpellerButtonType("JP_TONE_LOWER_CASE_TOGGLE", -1, HMIImageConstantsSystem.mib2_speller_button_jp_ToneLowerCase, HMIImageConstantsSystem.mib2_speller_button_jp_ToneLowerCase_big), new SpellerButtonType("TOGGLE_TO_SPELLER_JAMO_LATIN", 0, HMIImageConstantsSystem.mib2_speller_button_toggle2speller_jamo_en, HMIImageConstantsSystem.mib2_speller_button_toggle2speller_jamo_en_big), new SpellerButtonType("TOGGLE_TO_SPELLER_JAMO_KOREA", 7, HMIImageConstantsSystem.mib2_speller_button_toggle2speller_jamo_kr, HMIImageConstantsSystem.mib2_speller_button_toggle2speller_jamo_kr_big), new SpellerButtonType("TOGGLE_TO_SPELLER_KANJI_LATIN", 0, HMIImageConstantsSystem.mib2_speller_button_toggle2speller_kanji_en, HMIImageConstantsSystem.mib2_speller_button_toggle2speller_kanji_en_big), new SpellerButtonType("TOGGLE_TO_SPELLER_KANJI_JAPAN", 6, HMIImageConstantsSystem.mib2_speller_button_toggle2speller_kanji_jp, HMIImageConstantsSystem.mib2_speller_button_toggle2speller_kanji_jp_big), new SpellerButtonType("TOGGLE_TO_SPELLER_PINYIN_PINYIN", 3, HMIImageConstantsSystem.mib2_speller_button_toggle2speller_pinyin_cn, HMIImageConstantsSystem.mib2_speller_button_toggle2speller_pinyin_cn_big), new SpellerButtonType("TOGGLE_TO_SPELLER_PINYIN_LATIN", 0, HMIImageConstantsSystem.mib2_speller_button_toggle2speller_pinyin_en, HMIImageConstantsSystem.mib2_speller_button_toggle2speller_pinyin_en_big), new SpellerButtonType("TOGGLE_TO_SPELLER_STROKE_STROKE", 4, HMIImageConstantsSystem.mib2_speller_button_toggle2speller_stroke_cn, HMIImageConstantsSystem.mib2_speller_button_toggle2speller_stroke_cn_big), new SpellerButtonType("TOGGLE_TO_SPELLER_STROKE_LATIN", 0, HMIImageConstantsSystem.mib2_speller_button_toggle2speller_stroke_en, HMIImageConstantsSystem.mib2_speller_button_toggle2speller_stroke_en_big), new SpellerButtonType("TOGGLE_TO_SPELLER_ZHUYIN_LATIN", 0, HMIImageConstantsSystem.mib2_speller_button_toggle2speller_zhuyin_en, HMIImageConstantsSystem.mib2_speller_button_toggle2speller_zhuyin_en_big), new SpellerButtonType("TOGGLE_TO_SPELLER_ZHUYIN_ZHUYIN", 5, HMIImageConstantsSystem.mib2_speller_button_toggle2speller_zhuyin_tw, HMIImageConstantsSystem.mib2_speller_button_toggle2speller_zhuyin_tw_big), new SpellerButtonType("NEWLINE", -1, HMIImageConstantsSystem.mib2_phone_return_button, HMIImageConstantsSystem.mib2_phone_return_button_magnifier), new SpellerButtonType("SMILEY_SMILING", -1, HMIImageConstantsSystem.mib2_speller_button_smiley_smiling, HMIImageConstantsSystem.mib2_speller_button_smiley_smiling_big), new SpellerButtonType("SMILEY_LAUGHING", -1, HMIImageConstantsSystem.mib2_speller_button_smiley_laughing, HMIImageConstantsSystem.mib2_speller_button_smiley_laughing_big), new SpellerButtonType("SMILEY_WINKING", -1, HMIImageConstantsSystem.mib2_speller_button_smiley_winking, HMIImageConstantsSystem.mib2_speller_button_smiley_winking_big), new SpellerButtonType("SMILEY_DISAPPOINTED", -1, HMIImageConstantsSystem.mib2_speller_button_smiley_disappointed, HMIImageConstantsSystem.mib2_speller_button_smiley_disappointed_big), new SpellerButtonType("ASIA_ACCEPT_TRUFFLE_SUGGESTION", -1, HMIImageConstantsSystem.mib2_speller_button_truffles_enabled, HMIImageConstantsSystem.mib2_speller_button_truffles_enabled_big)};
        private static final List SPELLER_BUTTON_TYPES_AS_LIST = Arrays.asList(SPELLER_BUTTON_TYPES);
        public static final SpellerButtonType NULL = new SpellerButtonType("NONE");
        public static final SpellerButtonType SPACE = SPELLER_BUTTON_TYPES[0];
        public static final SpellerButtonType DELETE = SPELLER_BUTTON_TYPES[1];
        public static final SpellerButtonType OK = SPELLER_BUTTON_TYPES[2];
        public static final SpellerButtonType CLOSE = SPELLER_BUTTON_TYPES[3];
        public static final SpellerButtonType SHIFT = SPELLER_BUTTON_TYPES[4];
        public static final SpellerButtonType LEFT = SPELLER_BUTTON_TYPES[5];
        public static final SpellerButtonType RIGHT = SPELLER_BUTTON_TYPES[6];
        public static final SpellerButtonType TOGGLE_HWR_TO_SPELLER = SPELLER_BUTTON_TYPES[7];
        public static final SpellerButtonType TOGGLE_LATIN_TO_PINYIN = SPELLER_BUTTON_TYPES[8];
        public static final SpellerButtonType TOGGLE_LATIN_TO_STROKE = SPELLER_BUTTON_TYPES[9];
        public static final SpellerButtonType TOGGLE_PINYIN_TO_LATIN = SPELLER_BUTTON_TYPES[10];
        public static final SpellerButtonType TOGGLE_STROKE_TO_LATIN = SPELLER_BUTTON_TYPES[11];
        public static final SpellerButtonType TOGGLE_LATIN_TO_TAIWAN = SPELLER_BUTTON_TYPES[12];
        public static final SpellerButtonType TOGGLE_TAIWAN_TO_LATIN = SPELLER_BUTTON_TYPES[13];
        public static final SpellerButtonType TOGGLE_LATIN_TO_JAPAN = SPELLER_BUTTON_TYPES[14];
        public static final SpellerButtonType TOGGLE_JAPAN_TO_LATIN = SPELLER_BUTTON_TYPES[15];
        public static final SpellerButtonType TOGGLE_LATIN_TO_KOREA = SPELLER_BUTTON_TYPES[16];
        public static final SpellerButtonType TOGGLE_KOREA_TO_LATIN = SPELLER_BUTTON_TYPES[17];
        public static final SpellerButtonType JP_TONE_LOWER_CASE_TOGGLE = SPELLER_BUTTON_TYPES[18];
        public static final SpellerButtonType TOGGLE_TO_SPELLER_JAMO_LATIN = SPELLER_BUTTON_TYPES[19];
        public static final SpellerButtonType TOGGLE_TO_SPELLER_JAMO_KOREA = SPELLER_BUTTON_TYPES[20];
        public static final SpellerButtonType TOGGLE_TO_SPELLER_KANJI_LATIN = SPELLER_BUTTON_TYPES[21];
        public static final SpellerButtonType TOGGLE_TO_SPELLER_KANJI_JAPAN = SPELLER_BUTTON_TYPES[22];
        public static final SpellerButtonType TOGGLE_TO_SPELLER_PINYIN_PINYIN = SPELLER_BUTTON_TYPES[23];
        public static final SpellerButtonType TOGGLE_TO_SPELLER_PINYIN_LATIN = SPELLER_BUTTON_TYPES[24];
        public static final SpellerButtonType TOGGLE_TO_SPELLER_STROKE_STROKE = SPELLER_BUTTON_TYPES[25];
        public static final SpellerButtonType TOGGLE_TO_SPELLER_STROKE_LATIN = SPELLER_BUTTON_TYPES[26];
        public static final SpellerButtonType TOGGLE_TO_SPELLER_ZHUYIN_LATIN = SPELLER_BUTTON_TYPES[27];
        public static final SpellerButtonType TOGGLE_TO_SPELLER_ZHUYIN_ZHUYIN = SPELLER_BUTTON_TYPES[28];
        public static final SpellerButtonType NEWLINE = SPELLER_BUTTON_TYPES[29];
        public static final SpellerButtonType SMILEY_SMILING = SPELLER_BUTTON_TYPES[30];
        public static final SpellerButtonType SMILEY_LAUGHING = SPELLER_BUTTON_TYPES[31];
        public static final SpellerButtonType SMILEY_WINKING = SPELLER_BUTTON_TYPES[32];
        public static final SpellerButtonType SMILEY_DISAPPOINTED = SPELLER_BUTTON_TYPES[33];
        public static final SpellerButtonType ASIA_ACCEPT_TRUFFLE_SUGGESTION = SPELLER_BUTTON_TYPES[34];
        private final String name;
        private final int toggleCharsetIndex;
        private final int bitmapIndex;
        private final int highlightedBitmapIndex;

        private SpellerButtonType(String string) {
            this(string, -1, -1, -1);
        }

        private SpellerButtonType(String string, int n, int n2, int n3) {
            this.name = string;
            this.toggleCharsetIndex = n;
            this.bitmapIndex = n2;
            this.highlightedBitmapIndex = n3;
        }

        public static SpellerButtonType getSpellerButtonType(int n) {
            if (n >= 0 && n < SPELLER_BUTTON_TYPES.length) {
                return SPELLER_BUTTON_TYPES[n];
            }
            return NULL;
        }

        public boolean isCharsetToggleButton() {
            return this.toggleCharsetIndex != -1;
        }

        public int getTargetToggleCharset() {
            return this.toggleCharsetIndex;
        }

        public int getBitmapIndex() {
            return this.bitmapIndex;
        }

        public int getHighlightedBitmapIndex() {
            return this.highlightedBitmapIndex;
        }

        public String getName() {
            return this.name;
        }

        public int getEnumValue() {
            return SPELLER_BUTTON_TYPES_AS_LIST.indexOf(this);
        }

        public String toString() {
            return this.name;
        }
    }

    public static interface ICharacterSpellerItem
    extends ISpellerItem {
        public String getChar(boolean var1);
    }

    public static abstract class AbstractExpandableItem
    implements ISpellerItem {
        public static final int TYPE_CHAR = 0;
        public static final int TYPE_CHARSET = 1;
        private static final String[] CHARSET_NAMES = new String[]{"SYMBOLS", "DIGITS", "UMLAUTS", "LATIN_A_Z", "NONE"};
        public static final int CHARSET_SYMBOLS = 0;
        public static final int CHARSET_DIGITS = 1;
        public static final int CHARSET_UMLAUTS = 2;
        public static final int CHARSET_LATIN_A_Z = 3;
        public static final int CHARSET_NONE = 4;
        public final int type;
        private List subBand;
        private boolean closed;
        private boolean enabled;

        private AbstractExpandableItem(List list, int n) {
            this.setSubBand(list);
            this.type = n;
            this.closed = true;
            this.enabled = true;
        }

        protected void setSubBand(List list) {
            this.subBand = list;
            if (list != null) {
                for (int i2 = 0; i2 < list.size(); ++i2) {
                    Object object = list.get(i2);
                    if (!(object instanceof SingleCharItem)) continue;
                    ((SingleCharItem)object).parent = this;
                }
            }
        }

        public List getSubBand() {
            return this.subBand;
        }

        public void reset() {
            this.closed = true;
            this.enabled = true;
            this.subBand = Collections.EMPTY_LIST;
        }

        public boolean isClosed() {
            return this.closed;
        }

        public void setClosed(boolean bl) {
            this.closed = bl;
        }

        public boolean isEnabled() {
            return this.enabled;
        }

        public void setEnabled(boolean bl) {
            this.enabled = bl;
        }

        public boolean itemContentEquals(ISpellerItem iSpellerItem) {
            if (this == iSpellerItem) {
                return true;
            }
            if (iSpellerItem == null) {
                return false;
            }
            if (this.getClass() != iSpellerItem.getClass()) {
                return false;
            }
            AbstractExpandableItem abstractExpandableItem = (AbstractExpandableItem)iSpellerItem;
            return this.itemListContentEqualsOthersList(abstractExpandableItem);
        }

        protected boolean itemListContentEqualsOthersList(AbstractExpandableItem abstractExpandableItem) {
            if (this.subBand == null) {
                return abstractExpandableItem.subBand == null;
            }
            if (this.subBand.size() != abstractExpandableItem.subBand.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.subBand.size(); ++i2) {
                ISpellerItem iSpellerItem;
                ISpellerItem iSpellerItem2 = (ISpellerItem)this.subBand.get(i2);
                if (iSpellerItem2.itemContentEquals(iSpellerItem = (ISpellerItem)abstractExpandableItem.subBand.get(i2))) continue;
                return false;
            }
            return true;
        }

        public static class Char
        extends AbstractExpandableItem
        implements ICharacterSpellerItem {
            public static final String TYPE_KEY = "ExpandableItem.Char";
            private String characterUC;
            private String characterLC;

            private Char() {
                super(Collections.EMPTY_LIST, 0);
                this.reset();
            }

            public static Char createInstance(List list, String string, String string2) {
                Char char_ = (Char)SPELLER_ITEM_CACHE.getOrCreateInstance(TYPE_KEY);
                char_.setSubBand(list);
                char_.setChar(string, string2);
                return char_;
            }

            public static Char createInstance(List list, String string) {
                return Char.createInstance(list, string, string);
            }

            public static Char createInstance(String string, List list) {
                return Char.createInstance(list, string, string);
            }

            public String getTypeKey() {
                return TYPE_KEY;
            }

            public void reset() {
                super.reset();
                this.setChar(null, null);
            }

            public String getChar(boolean bl) {
                if (bl || this.characterLC == null) {
                    return this.characterUC;
                }
                return this.characterLC;
            }

            private void setChar(String string, String string2) {
                this.characterUC = string;
                this.characterLC = string2;
            }

            public String toString() {
                return new Buffer("ExpandableItem.Char main: ").append(this.characterUC).append("[closed=").append(this.isClosed()).append("]").toString();
            }

            public boolean itemContentEquals(ISpellerItem iSpellerItem) {
                if (!super.itemContentEquals(iSpellerItem)) {
                    return false;
                }
                Char char_ = (Char)iSpellerItem;
                if (char_.characterLC != null && this.characterLC == null) {
                    return false;
                }
                if (this.characterLC != null && !this.characterLC.equals(char_.characterLC)) {
                    return false;
                }
                return !(this.characterUC == null ? char_.characterUC != null : !this.characterUC.equals(char_.characterUC));
            }
        }

        public static class CharSet
        extends AbstractExpandableItem {
            public static final String TYPE_KEY = "ExpandableItem.CharSet";
            private int charSetType;

            private CharSet() {
                super(Collections.EMPTY_LIST, 1);
                this.reset();
            }

            public static CharSet createInstance(List list, int n) {
                CharSet charSet = (CharSet)SPELLER_ITEM_CACHE.getOrCreateInstance(TYPE_KEY);
                charSet.setSubBand(list);
                charSet.setCharsetType(n);
                return charSet;
            }

            public String getTypeKey() {
                return TYPE_KEY;
            }

            public void reset() {
                super.reset();
                this.charSetType = 4;
            }

            public int getCharsetType() {
                return this.charSetType;
            }

            private void setCharsetType(int n) {
                this.charSetType = n;
            }

            public String toString() {
                return new Buffer("ExpandableItem.CharSet main: ").append(CHARSET_NAMES[this.getCharsetType()]).append("[closed=").append(this.isClosed()).append("]").toString();
            }

            public boolean itemContentEquals(ISpellerItem iSpellerItem) {
                return super.itemContentEquals(iSpellerItem) && this.getCharsetType() == ((CharSet)iSpellerItem).getCharsetType();
            }
        }
    }

    public static class ToggleCharsetButtonItem
    extends ButtonItem {
        public static final String TYPE_KEY_TOGGLE_BUTTON = "ToggleCharsetButtonItem";
        private TouchCharSetAndTTSHandler handler = null;

        private ToggleCharsetButtonItem() {
            this.reset();
        }

        public static ToggleCharsetButtonItem createInstance(TouchCharSetAndTTSHandler touchCharSetAndTTSHandler) {
            ToggleCharsetButtonItem toggleCharsetButtonItem = (ToggleCharsetButtonItem)SPELLER_ITEM_CACHE.getOrCreateInstance(TYPE_KEY_TOGGLE_BUTTON);
            toggleCharsetButtonItem.setTouchCharSetAndTTSHandler(touchCharSetAndTTSHandler);
            return toggleCharsetButtonItem;
        }

        public String getTypeKey() {
            return TYPE_KEY_TOGGLE_BUTTON;
        }

        public void reset() {
            super.reset();
            this.handler = null;
        }

        private void setTouchCharSetAndTTSHandler(TouchCharSetAndTTSHandler touchCharSetAndTTSHandler) {
            this.handler = touchCharSetAndTTSHandler;
            this.updateToggleButtonType();
        }

        private void updateToggleButtonType() {
            if (null == this.handler) {
                IWidgetLogChannel.spellerLogChannel.log(100000, "[SpellerController#ToggleButtonItem] Could not GET Touch Utils.");
                this.setButtonType(SpellerButtonType.TOGGLE_HWR_TO_SPELLER);
            } else {
                this.setButtonType(this.handler.getAsianToggleSpellerButtonType());
            }
        }
    }

    public static class ToggleToSpellerButtonItem
    extends ButtonItem {
        public static final String TYPE_KEY_TOGGLE_BUTTON = "ToggleToSpellerButtonItem";
        private TouchCharSetAndTTSHandler handler = null;

        private ToggleToSpellerButtonItem() {
            this.reset();
        }

        public static ToggleToSpellerButtonItem createInstance(TouchCharSetAndTTSHandler touchCharSetAndTTSHandler) {
            ToggleToSpellerButtonItem toggleToSpellerButtonItem = (ToggleToSpellerButtonItem)SPELLER_ITEM_CACHE.getOrCreateInstance(TYPE_KEY_TOGGLE_BUTTON);
            toggleToSpellerButtonItem.setTouchCharSetAndTTSHandler(touchCharSetAndTTSHandler);
            return toggleToSpellerButtonItem;
        }

        public String getTypeKey() {
            return TYPE_KEY_TOGGLE_BUTTON;
        }

        public void reset() {
            super.reset();
            this.handler = null;
        }

        public void setTouchCharSetAndTTSHandler(TouchCharSetAndTTSHandler touchCharSetAndTTSHandler) {
            this.handler = touchCharSetAndTTSHandler;
            this.updateToggleButtonType();
        }

        private void updateToggleButtonType() {
            if (null == this.handler) {
                IWidgetLogChannel.spellerLogChannel.log(100000, "[SpellerController#ToggleButtonItem] Could not GET Touch Utils.");
                this.setButtonType(SpellerButtonType.TOGGLE_HWR_TO_SPELLER);
            } else {
                this.setButtonType(this.handler.getAsianToggleToSpellerButtonType());
            }
        }
    }
}

