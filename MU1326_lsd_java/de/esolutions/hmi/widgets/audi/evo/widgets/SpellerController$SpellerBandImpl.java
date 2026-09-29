/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$AbstractExpandableItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ButtonItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ISpellerBand;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ISpellerItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$SingleCharItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$SpellerButtonType;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpellerController$SpellerBandImpl
implements SpellerController$ISpellerBand {
    private List spellerItems;
    private SpellerController$ISpellerItem currentFocusedItem;
    private SpellerController$ISpellerItem closeButton;
    private SpellerController$ISpellerItem okItem;
    private SpellerController$ISpellerItem leftItem;
    private SpellerController$ISpellerItem rightItem;
    private SpellerController$ISpellerItem deleteItem;
    protected SpellerController$ISpellerItem deletePosItem;
    private boolean upperCase = true;
    private final /* synthetic */ SpellerController this$0;

    public SpellerController$SpellerBandImpl(SpellerController spellerController, List list, boolean bl) {
        this(spellerController, list, bl, spellerController.getSpellerMode() != 14, true);
    }

    protected SpellerController$SpellerBandImpl(SpellerController spellerController, List list, boolean bl, boolean bl2, boolean bl3) {
        this(spellerController, list, bl, bl2, bl3, true);
    }

    protected SpellerController$SpellerBandImpl(SpellerController spellerController, List list, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        SpellerController$ButtonItem spellerController$ButtonItem;
        this.this$0 = spellerController;
        this.spellerItems = list == null ? new ArrayList() : list;
        if (bl4) {
            spellerController$ButtonItem = SpellerController$ButtonItem.createInstance(SpellerController$SpellerButtonType.CLOSE);
            this.closeButton = spellerController$ButtonItem;
            this.spellerItems.add(0, spellerController$ButtonItem);
        }
        if (bl) {
            spellerController$ButtonItem = SpellerController$ButtonItem.createInstance(SpellerController$SpellerButtonType.OK);
            this.spellerItems.add(bl4 ? 1 : 0, spellerController$ButtonItem);
            spellerController$ButtonItem.setAdditionalArgument(spellerController.getAdditionalOKArgument());
            this.okItem = spellerController$ButtonItem;
        } else {
            this.okItem = null;
        }
        this.deleteItem = bl2 ? SpellerController$ButtonItem.createInstance(SpellerController$SpellerButtonType.DELETE) : null;
        for (int i2 = 0; i2 < this.spellerItems.size(); ++i2) {
            if (!(this.spellerItems.get(i2) instanceof SpellerController$ButtonItem)) continue;
            SpellerController$ButtonItem spellerController$ButtonItem2 = (SpellerController$ButtonItem)this.spellerItems.get(i2);
            if (spellerController$ButtonItem2.getButtonType().equals(SpellerController$SpellerButtonType.LEFT)) {
                this.leftItem = spellerController$ButtonItem2;
            }
            if (!spellerController$ButtonItem2.getButtonType().equals(SpellerController$SpellerButtonType.RIGHT)) continue;
            this.rightItem = spellerController$ButtonItem2;
        }
        this.upperCase = bl3;
        this.currentFocusedItem = this.spellerItems.isEmpty() ? null : (SpellerController$ISpellerItem)this.spellerItems.get(0);
    }

    @Override
    public List getSpellerItems() {
        return this.spellerItems;
    }

    @Override
    public SpellerController$ISpellerItem getCurrentFocusedItem() {
        return this.currentFocusedItem;
    }

    @Override
    public void setCurrentFocusedItem(SpellerController$ISpellerItem spellerController$ISpellerItem) {
        this.currentFocusedItem = spellerController$ISpellerItem;
    }

    @Override
    public SpellerController$ISpellerItem getOkItem() {
        return this.okItem;
    }

    @Override
    public SpellerController$ISpellerItem getDeleteButton() {
        return this.deleteItem;
    }

    @Override
    public SpellerController$ISpellerItem getCloseButton() {
        return this.closeButton;
    }

    @Override
    public SpellerController$ISpellerItem getDeleteButtonNeighbor() {
        return this.deletePosItem;
    }

    @Override
    public SpellerController$ISpellerItem getLeftButton() {
        return this.leftItem;
    }

    @Override
    public SpellerController$ISpellerItem getRightButton() {
        return this.rightItem;
    }

    private void setItemNextToDelete(SpellerController$ISpellerItem spellerController$ISpellerItem) {
        this.deletePosItem = spellerController$ISpellerItem;
    }

    @Override
    public boolean isUpperCase() {
        return this.upperCase;
    }

    @Override
    public void setIsUpperCase(boolean bl) {
        this.upperCase = bl;
    }

    @Override
    public void itemPressed(SpellerController$ISpellerItem spellerController$ISpellerItem) {
        if (this.this$0.targetCursorItem == null || this.deletePosItem == this.this$0.targetCursorItem) {
            return;
        }
        if (this.this$0.targetCursorItem instanceof SpellerController$SingleCharItem) {
            SpellerController$SingleCharItem spellerController$SingleCharItem = (SpellerController$SingleCharItem)this.this$0.targetCursorItem;
            if (!spellerController$SingleCharItem.hasParent()) {
                this.moveDeleteButton(this.this$0.targetCursorItem, true);
            } else if (SpellerController$SingleCharItem.access$300(spellerController$SingleCharItem) instanceof SpellerController$AbstractExpandableItem && SpellerController$SingleCharItem.access$300((SpellerController$SingleCharItem)spellerController$SingleCharItem).type == 1) {
                this.moveDeleteButton(this.this$0.targetCursorItem, true);
            }
        } else if (this.this$0.targetCursorItem instanceof SpellerController$AbstractExpandableItem) {
            SpellerController$SingleCharItem spellerController$SingleCharItem;
            SpellerController$AbstractExpandableItem spellerController$AbstractExpandableItem = (SpellerController$AbstractExpandableItem)this.this$0.targetCursorItem;
            if (spellerController$AbstractExpandableItem.type == 0) {
                this.moveDeleteButton(this.this$0.targetCursorItem, true);
            } else if (this.deletePosItem instanceof SpellerController$SingleCharItem && (spellerController$SingleCharItem = (SpellerController$SingleCharItem)this.deletePosItem).hasParent() && spellerController$SingleCharItem.getParent().isClosed()) {
                this.moveDeleteButton(((SpellerController$SingleCharItem)this.deletePosItem).getParent(), false);
            }
        } else if (this.this$0.targetCursorItem instanceof SpellerController$ButtonItem) {
            boolean bl;
            SpellerController$SpellerButtonType spellerController$SpellerButtonType = ((SpellerController$ButtonItem)this.this$0.targetCursorItem).getButtonType();
            boolean bl2 = bl = spellerController$SpellerButtonType == SpellerController$SpellerButtonType.NEWLINE || spellerController$SpellerButtonType == SpellerController$SpellerButtonType.SMILEY_SMILING || spellerController$SpellerButtonType == SpellerController$SpellerButtonType.SMILEY_LAUGHING || spellerController$SpellerButtonType == SpellerController$SpellerButtonType.SMILEY_WINKING || spellerController$SpellerButtonType == SpellerController$SpellerButtonType.SMILEY_DISAPPOINTED;
            if (bl) {
                this.moveDeleteButton(this.this$0.targetCursorItem, true);
            }
        }
    }

    @Override
    public void resetInitialItem(boolean bl) {
        if (this.getSpellerItems().size() < 1) {
            IWidgetLogChannel.spellerLogChannel.log(1000, "[SpellerController#findStartItem] Could not find a valid item for the initial focus.");
            return;
        }
        SpellerController$ISpellerItem spellerController$ISpellerItem = this.getCurrentFocusedItem();
        this.setCurrentFocusedItem((SpellerController$ISpellerItem)this.getSpellerItems().get(0));
        this.this$0.targetCursorItem = this.getCurrentFocusedItem();
        if (SpellerController.access$500(this.this$0) != null && bl && spellerController$ISpellerItem != null && spellerController$ISpellerItem != this.this$0.targetCursorItem) {
            SpellerController.access$500(this.this$0).startCursorAnimation(spellerController$ISpellerItem, this.this$0.targetCursorItem);
        }
        SpellerController$ISpellerItem spellerController$ISpellerItem2 = this.getCurrentFocusedItem();
        SpellerIterator spellerIterator = this.this$0.getCurrentSpellerIterator();
        while (spellerIterator.hasNext()) {
            SpellerController$ISpellerItem spellerController$ISpellerItem3 = (SpellerController$ISpellerItem)spellerIterator.next();
            if (!SpellerController.isCharacterItem(spellerController$ISpellerItem3)) continue;
            spellerController$ISpellerItem2 = spellerController$ISpellerItem3;
            break;
        }
        this.moveDeleteButton(spellerController$ISpellerItem2, false);
    }

    public void moveDeleteButton(SpellerController$ISpellerItem spellerController$ISpellerItem, boolean bl) {
        this.setItemNextToDelete(spellerController$ISpellerItem);
        if (SpellerController.access$500(this.this$0) != null) {
            SpellerController.access$500(this.this$0).deleteMoved();
            if (bl) {
                this.this$0.setCompositesDirty(true);
            }
        }
    }

    @Override
    public void autoCompletionAccepted() {
        this.moveDeleteButton(this.getCurrentFocusedItem(), false);
    }

    @Override
    public boolean hasMovingDeleteButton() {
        return this.deleteItem != null;
    }

    public String toString() {
        return new StringBuffer().append("SpellerBandImpl [spellerItems=").append(this.spellerItems).append(", currentFocusedItem=").append(this.currentFocusedItem).append(", okItem=").append(this.okItem).append(", deleteItem=").append(this.deleteItem).append(", deletePosItem=").append(this.deletePosItem).append(", isUpperCase=").append(this.upperCase).append("]").toString();
    }

    @Override
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

