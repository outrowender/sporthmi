/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.modelaccess.TextEditorModelDDApp;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.evo.HMITerminalEvoImpl;
import de.esolutions.hmi.widgets.audi.evo.widgets.ISpellerRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.MultilineTextFieldController;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ISpellerBand;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ISpellerItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$SingleCharItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$SpellerBandImpl;
import java.util.ArrayList;

class MultilineTextFieldController$WordReplacer {
    private static final float CURSOR_MOVE_SPEED;
    TextEditorModelDDApp model;
    SpellerController alternativeSpeller;
    boolean focused;
    private final /* synthetic */ MultilineTextFieldController this$0;

    public MultilineTextFieldController$WordReplacer(MultilineTextFieldController multilineTextFieldController, TextEditorModelDDApp textEditorModelDDApp, SpellerController spellerController) {
        this.this$0 = multilineTextFieldController;
        IWidgetLogChannel.logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#WordReplacer#WordReplacer");
        this.focused = false;
        this.model = textEditorModelDDApp;
        this.alternativeSpeller = new SpellerController();
        this.alternativeSpeller.setCursorDuration(5699);
        this.alternativeSpeller.setBitmaps(spellerController.getBitmapIndices());
        this.alternativeSpeller.setColorIndices(spellerController.getColorIndices());
        this.alternativeSpeller.setSpellerMode(4);
        this.alternativeSpeller.setShowBoxNode(false);
        this.alternativeSpeller.setVisible(false);
        this.alternativeSpeller.setMultilineAlternative(true);
        ISpellerRenderer iSpellerRenderer = ((HMITerminalEvoImpl)MultilineTextFieldController.access$000(multilineTextFieldController)).getRendererFactory().createSpellerRendererEuropeHigh(this.alternativeSpeller, spellerController);
        this.alternativeSpeller.setRenderer(iSpellerRenderer);
    }

    public void updateAlternatives() {
        SpellerController$ISpellerItem spellerController$ISpellerItem;
        IWidgetLogChannel.logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#WordReplacer#updateAlternatives");
        String[] stringArray = this.model.getCursor().getAlternatives();
        if (stringArray == null) {
            this.close();
            return;
        }
        IWidgetLogChannel.logMessagingMultiline.log(-2137614336, "MultilineTextFieldController#Wordreplacer#updateAlternatives alternatives found:%1", (long)stringArray.length);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 1; i2 < stringArray.length; ++i2) {
            spellerController$ISpellerItem = SpellerController$SingleCharItem.createInstance(stringArray[i2]);
            arrayList.add(spellerController$ISpellerItem);
        }
        if (arrayList.isEmpty()) {
            this.close();
            return;
        }
        SpellerController spellerController = this.alternativeSpeller;
        super.getClass();
        SpellerController$SpellerBandImpl spellerController$SpellerBandImpl = new SpellerController$SpellerBandImpl(spellerController, arrayList, false, false, false);
        this.alternativeSpeller.changeSpellerBand(spellerController$SpellerBandImpl);
        this.alternativeSpeller.setHighlighted(false);
        if (this.alternativeSpeller.getCurrentSpellerBand() == null || this.alternativeSpeller.getCurrentSpellerBand().getSpellerItems() == null || this.alternativeSpeller.getCurrentSpellerBand().getSpellerItems().get(1) == null) {
            return;
        }
        spellerController$ISpellerItem = (SpellerController$ISpellerItem)this.alternativeSpeller.getCurrentSpellerBand().getSpellerItems().get(1);
        this.alternativeSpeller.setCursorPosition(spellerController$ISpellerItem);
        if (MultilineTextFieldController.access$100(this.this$0) == null) {
            return;
        }
        this.updateBounds();
    }

    private int computeX() {
        return MultilineTextFieldController.access$100(this.this$0).getX() - this.this$0.getDescriptiveTextLength();
    }

    private int computeY() {
        return this.this$0.getY() - this.computeHeight() - 16;
    }

    private int computeWidth() {
        return this.this$0.getWidth() + -10 - this.this$0.getOffsetBecauseOfLabel();
    }

    private int computeHeight() {
        return 38;
    }

    public void updateX() {
        int n = this.computeX();
        IWidgetLogChannel.logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#WordReplacer#updateX: %1", (long)n);
        this.alternativeSpeller.setX(n);
    }

    public void updateY() {
        int n = this.computeY();
        IWidgetLogChannel.logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#WordReplacer#updateY: %1", (long)n);
        this.alternativeSpeller.setY(n);
    }

    public void updateHeight() {
        int n = this.computeHeight();
        IWidgetLogChannel.logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#WordReplacer#updateHeight: %1", (long)n);
        this.alternativeSpeller.setHeight(n);
    }

    public void updateBounds() {
        int n = this.computeX();
        int n2 = this.computeY();
        int n3 = this.computeWidth();
        int n4 = this.computeHeight();
        IWidgetLogChannel.logMessagingMultiline.log(-2137614336, new StringBuffer().append("MultiLineTextFieldController#WordReplacer#updateBounds: ").append(n).append(" ").append(n2).append(" ").append(n3).append(" ").append(n4).toString());
        this.alternativeSpeller.setBounds(n, n2, n3, n4);
    }

    public boolean areAlternativesAvailable() {
        boolean bl = !this.alternativeSpeller.getCurrentSpellerBand().getSpellerItems().isEmpty();
        IWidgetLogChannel.logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#WordReplacer#areAlternativesAvailable available:%1", bl);
        return bl;
    }

    public boolean isVisible() {
        boolean bl = this.alternativeSpeller != null ? this.alternativeSpeller.isVisible() : false;
        IWidgetLogChannel.logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#WordReplacer#isVisible visible:%1", bl);
        return bl;
    }

    public void open() {
        IWidgetLogChannel.logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#WordReplacer#open bounds:%1", (Object)this.boundsToString());
        this.setFocused(false);
        this.alternativeSpeller.setVisible(true);
    }

    public void close() {
        IWidgetLogChannel.logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#WordReplacer#close");
        SpellerController$ISpellerBand spellerController$ISpellerBand = this.alternativeSpeller.getCurrentSpellerBand();
        if (spellerController$ISpellerBand != null) {
            spellerController$ISpellerBand.free(true);
        }
        this.alternativeSpeller.setVisible(false);
        this.setFocused(false);
    }

    public SpellerController getSpeller() {
        IWidgetLogChannel.logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#WordReplacer#getSpeller");
        return this.alternativeSpeller;
    }

    public boolean isFocused() {
        IWidgetLogChannel.logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#WordReplacer#isFocused  isfocused:%1", this.focused);
        return this.focused;
    }

    public void setFocused(boolean bl) {
        IWidgetLogChannel.logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#WordReplacer#setFocused  value:%1", bl);
        this.focused = bl;
        this.alternativeSpeller.setAlternativeArrowDown(bl);
        this.alternativeSpeller.setFocused(bl);
        this.alternativeSpeller.setCompositesDirty(true);
    }

    private String boundsToString() {
        return new StringBuffer().append("[").append(MultilineTextFieldController.access$200(this.this$0)).append(" ").append(MultilineTextFieldController.access$300(this.this$0)).append(" ").append(MultilineTextFieldController.access$400(this.this$0)).append(" ").append(MultilineTextFieldController.access$500(this.this$0)).append("]").toString();
    }

    public void showIfAvailable() {
        this.updateAlternatives();
        boolean bl = this.areAlternativesAvailable();
        IWidgetLogChannel.logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#WordReplacer#showIfAvailable  show:%1 bounds:%2", bl, (Object)this.boundsToString());
        if (bl) {
            this.open();
            this.alternativeSpeller.setCompositesDirty(true);
        }
    }
}

