/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPlaceholderMenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SelectionDrawerPreviewIconController
extends ContainerController {
    private List previewItems = new ArrayList();
    private Object selectedItemEntry;
    private IconController mapBackgroundAbove;
    private IconController mapBackgroundBelow;

    public void setPreviewIcons(AbstractPlaceholderMenuController.PlaceholderItemEntry placeholderItemEntry, Collection collection) {
        this.previewItems.clear();
        this.selectedItemEntry = placeholderItemEntry;
        if (collection != null) {
            this.previewItems.addAll(collection);
        }
        this.updateIcons();
    }

    private void updateIcons() {
        List list = this.getChildren();
        if (list != null) {
            int n;
            int n2;
            int n3 = 999;
            int n4 = Math.min(list.size(), 6);
            int n5 = n4 / 2;
            int n6 = n5 - 1;
            int n7 = 0;
            for (n2 = 0; n2 < this.previewItems.size(); ++n2) {
                AbstractPlaceholderMenuController.PlaceholderItemEntry placeholderItemEntry = (AbstractPlaceholderMenuController.PlaceholderItemEntry)this.previewItems.get(n2);
                if (!placeholderItemEntry.equals(this.selectedItemEntry)) continue;
                n7 = n2;
                break;
            }
            n2 = n7;
            int n8 = 0;
            for (n = n5; n < n4; ++n) {
                IconController iconController = (IconController)list.get(n);
                if (++n2 >= this.previewItems.size()) {
                    iconController.setOnScreen(false);
                    continue;
                }
                n3 = Math.min(iconController.getDepth() - 1, n3);
                this.setPreviewIconOnScreen(n2, iconController);
                ++n8;
            }
            if (this.mapBackgroundBelow != null) {
                switch (n8) {
                    case 0: {
                        this.mapBackgroundBelow.setOnScreen(false);
                        break;
                    }
                    case 1: {
                        this.mapBackgroundBelow.setOnScreen(true);
                        this.mapBackgroundBelow.setValue(0);
                        this.mapBackgroundBelow.setDepth(n3);
                        break;
                    }
                    case 2: {
                        this.mapBackgroundBelow.setOnScreen(true);
                        this.mapBackgroundBelow.setValue(1);
                        this.mapBackgroundBelow.setDepth(n3);
                        break;
                    }
                    default: {
                        this.mapBackgroundBelow.setOnScreen(true);
                        this.mapBackgroundBelow.setValue(2);
                        this.mapBackgroundBelow.setDepth(n3);
                    }
                }
                this.mapBackgroundBelow.setCompositesDirty(true);
            }
            n2 = n7;
            n = 0;
            for (int i2 = n6; i2 >= 0; --i2) {
                IconController iconController = (IconController)list.get(i2);
                if (--n2 < 0) {
                    iconController.setOnScreen(false);
                    continue;
                }
                n3 = Math.min(iconController.getDepth() - 1, n3);
                this.setPreviewIconOnScreen(n2, iconController);
                ++n;
            }
            if (this.mapBackgroundAbove != null) {
                switch (n) {
                    case 0: {
                        this.mapBackgroundAbove.setOnScreen(false);
                        break;
                    }
                    case 1: {
                        this.mapBackgroundAbove.setOnScreen(true);
                        this.mapBackgroundAbove.setValue(0);
                        this.mapBackgroundAbove.setDepth(n3);
                        break;
                    }
                    case 2: {
                        this.mapBackgroundAbove.setOnScreen(true);
                        this.mapBackgroundAbove.setValue(1);
                        this.mapBackgroundAbove.setDepth(n3);
                        break;
                    }
                    default: {
                        this.mapBackgroundAbove.setOnScreen(true);
                        this.mapBackgroundAbove.setValue(2);
                        this.mapBackgroundAbove.setDepth(n3);
                    }
                }
                this.mapBackgroundAbove.setCompositesDirty(true);
            }
            this.setCompositesDirty(true);
        }
    }

    private void setPreviewIconOnScreen(int n, IconController iconController) {
        AbstractPlaceholderMenuController.PlaceholderItemEntry placeholderItemEntry = (AbstractPlaceholderMenuController.PlaceholderItemEntry)this.previewItems.get(n);
        Object object = placeholderItemEntry.getIconData(2);
        if (object != null) {
            if (object instanceof Integer) {
                int n2 = (Integer)object;
                iconController.setBitmaps(new int[]{n2});
            }
            iconController.setOnScreen(true);
        } else {
            iconController.setOnScreen(false);
            IWidgetLogChannel.logSelectionDrawerController.log(10000, "SelectionDrawerPreviewIconController#updateIcons icondata for entry %1 is null, probably GUIDE error", (Object)placeholderItemEntry.getLabelText());
        }
        iconController.setCompositesDirty(true);
    }

    public void add(AbstractWidget abstractWidget, int n) {
        if (n == 4) {
            if (abstractWidget instanceof IconController) {
                this.mapBackgroundAbove = (IconController)abstractWidget;
            } else {
                IWidgetLogChannel.logSelectionDrawerController.log(10000, "SelectionDrawerPreviewIconController#add role ROLE_SELECTION_DRAWER_PREVIEWS_BACKGROUND_TOP can only be used with IconController");
            }
        } else if (n == 5) {
            if (abstractWidget instanceof IconController) {
                this.mapBackgroundBelow = (IconController)abstractWidget;
            } else {
                IWidgetLogChannel.logSelectionDrawerController.log(10000, "SelectionDrawerPreviewIconController#add role ROLE_SELECTION_DRAWER_PREVIEWS_BACKGROUND_BOTTOM can only be used with IconController");
            }
        }
        super.add(abstractWidget, n);
    }
}

