/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.audi.atip.log.LogChannel;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MultiLineLabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MultiLineMenuItemController;
import java.util.Iterator;
import java.util.List;

public class SpeedDisclaimerController
extends AbstractWidgetController
implements IWidgetLogChannel {
    private static final LogChannel log = logDisclaimer;
    private MultiLineMenuItemController messageContainer;
    private MultiLineMenuItemController shortMessageContainer;
    private MenuItemController disclaimerContainer;
    private int speedThreshold = 1;
    private int maxLines = -1;
    private int minLines = 0;
    private int maxLinesOfMessage = 6;
    private int currentSpeed;
    private boolean activated = true;
    private LabelController messageLabel;

    private void updateModelValue() {
        if (this.model != null && this.model instanceof ChoiceModelGUI) {
            this.currentSpeed = ((ChoiceModelGUI)this.model).getValue();
            log.log(10000000, "SpeedDisclaimerController#updateModelValue Current value of Speed-Model is: %1", (long)this.currentSpeed);
        }
        this.processDisclaimer();
    }

    private void processDisclaimer() {
        if (this.isActivated()) {
            if (this.messageContainer != null && this.disclaimerContainer != null) {
                if (this.currentSpeed < this.speedThreshold) {
                    this.setDisclaimerVisible(false);
                    log.log(10000000, "SpeedDisclaimerController#processDisclaimer SpeedDisclaimer is visible: %1, maxLines: %2", this.disclaimerContainer.isVisible(), (long)this.messageLabel.getMaxLines());
                    return;
                }
                if (this.currentSpeed >= this.speedThreshold) {
                    int n = this.getNumberOfRows();
                    log.log(10000000, "SpeedDisclaimerController#processDisclaimer lines: %1", (long)n);
                    if (this.maxLinesOfMessage < n) {
                        this.setDisclaimerVisible(true);
                        log.log(10000000, "SpeedDisclaimerController#processDisclaimer SpeedDisclaimer is visible: %1, maxLines: %2", this.disclaimerContainer.isVisible(), (long)this.messageLabel.getMaxLines());
                    } else {
                        this.setDisclaimerVisible(false);
                        log.log(10000000, "SpeedDisclaimerController#processDisclaimer SpeedDisclaimer is visible: %1, maxLines: %2", this.disclaimerContainer.isVisible(), (long)this.messageLabel.getMaxLines());
                    }
                }
            } else {
                log.log(10000000, "SpeedDisclaimerController#processDisclaimer SpeedDisclaimer has no messageContainer or disclaimerContainer");
            }
        }
    }

    private void setDisclaimerVisible(boolean bl) {
        this.messageContainer.setVisible(!bl);
        this.shortMessageContainer.setVisible(bl);
        this.disclaimerContainer.setVisible(bl);
    }

    private int getNumberOfRows() {
        LabelController labelController = this.getLabelFromMenuItem(this.messageContainer);
        MultiLineLabelRendererHigh multiLineLabelRendererHigh = (MultiLineLabelRendererHigh)labelController.getRenderer();
        return multiLineLabelRendererHigh.getNumberOfRows(labelController.getWidth());
    }

    private LabelController getLabelFromMenuItem(MultiLineMenuItemController multiLineMenuItemController) {
        Object object;
        List list = multiLineMenuItemController.getChildren();
        if (list.size() >= 1 && (object = list.get(0)) instanceof LabelController) {
            log.log(10000000, "SpeedDisclaimerController#processDisclaimer SpeedDisclaimer has messageLabel with text: %1", (Object)((LabelController)object).getText());
            return (LabelController)object;
        }
        log.log(10000000, "SpeedDisclaimerController#processDisclaimer SpeedDisclaimer has no messageLabel");
        return null;
    }

    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        int n = this.currentSpeed;
        this.updateModelValue();
        if (n != this.currentSpeed) {
            modelUpdateEvent.consume();
        }
        super.processModelUpdateEvent(modelUpdateEvent);
    }

    protected void initializeWidget() {
        super.initializeWidget();
        this.setContentToContainers();
        this.messageLabel = this.getLabelFromMenuItem(this.shortMessageContainer);
        this.messageLabel.setMaxLines(this.minLines);
        this.updateModelValue();
    }

    public void setContentToContainers() {
        List list = this.parent.getChildren();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            if (object instanceof MultiLineMenuItemController) {
                if (this.messageContainer == null) {
                    this.messageContainer = (MultiLineMenuItemController)object;
                    this.messageContainer.setVisible(true);
                    log.log(10000000, "SpeedDisclaimerController#processDisclaimer SpeedDisclaimer has messageContainer: %1", (Object)this.messageContainer);
                } else {
                    this.shortMessageContainer = (MultiLineMenuItemController)object;
                    this.shortMessageContainer.setVisible(false);
                    log.log(10000000, "SpeedDisclaimerController#processDisclaimer SpeedDisclaimer has shortMessageContainer: %1", (Object)this.shortMessageContainer);
                }
            }
            if (!(object instanceof MenuItemController) || this.disclaimerContainer != null) continue;
            this.disclaimerContainer = (MenuItemController)object;
            this.disclaimerContainer.setVisible(false);
            log.log(10000000, "SpeedDisclaimerController#processDisclaimer SpeedDisclaimer has disclaimerContainer: %1", (Object)this.disclaimerContainer);
        }
    }

    public IRenderer getRenderer() {
        return null;
    }

    public void setMaxLine(int n) {
        this.maxLines = n;
    }

    public void setMinLines(int n) {
        this.minLines = n;
    }

    public int getMaxLines() {
        return this.maxLines;
    }

    public int getMinLines() {
        return this.minLines;
    }

    public void setSpeedThreshold(int n) {
        this.speedThreshold = n;
    }

    public int getSpeedThreshold() {
        return this.speedThreshold;
    }

    public void setActivated(boolean bl) {
        this.activated = bl;
    }

    public boolean isActivated() {
        return this.activated;
    }

    public int getMaxLinesOfMessage() {
        return this.maxLinesOfMessage;
    }

    public void setMaxLinesOfMessage(int n) {
        this.maxLinesOfMessage = n;
    }
}

