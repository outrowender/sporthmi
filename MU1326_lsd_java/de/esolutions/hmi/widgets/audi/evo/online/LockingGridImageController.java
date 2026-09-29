/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.online;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.audi.atip.log.LogChannel;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.online.IGridImageLocker;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import java.util.ArrayList;

public class LockingGridImageController
extends AbstractWidgetController
implements IGridImageLocker {
    private static final int LOCKING_CODED_DISABLED;
    private static final int LOCKING_CODED_GREYOUT;
    private static final int LOCKING_CODED_INVISIBLE;
    private static final float LOCKING_DEFAULT_SHADING_OPACITY;
    private static final float LOCKING_FULL_OPACITY;
    ArrayList lockingImages = new ArrayList();
    int currentLockingState;
    private static final LogChannel log;

    @Override
    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        log.log(1078071040, "LockingGridImageController#processModelUpdateEvent() update type %1", (long)modelUpdateEvent.getUpdateType());
        if (modelUpdateEvent.getModelType() == 2 && modelUpdateEvent.getUpdateType() == 1) {
            int n = ((ChoiceModelGUI)this.model).getValue();
            log.log(1078071040, "LockingGridImageController#processModelUpdateEvent: new value %1 old value %2", (long)n, (long)this.currentLockingState);
            if (n != this.currentLockingState) {
                this.currentLockingState = n;
                this.applyLockingStateToAllImages();
            }
        }
    }

    @Override
    public IRenderer getRenderer() {
        return null;
    }

    @Override
    public void disconnecting() {
        this.clearMenuImages();
        super.disconnecting();
    }

    @Override
    protected void afterConnected() {
        if (this.model instanceof ChoiceModelGUI) {
            this.currentLockingState = ((ChoiceModelGUI)this.model).getValue();
        }
        log.log(1078071040, "LockingGridImageController#afterConnected locking state %1, number of referenced images is %2", (long)this.currentLockingState, (long)this.lockingImages.size());
    }

    @Override
    public void addLockImage(IconController iconController) {
        if (iconController != null) {
            this.lockingImages.add(iconController);
            this.applyLockingStateToImage(iconController);
        }
    }

    @Override
    public int getCurrentLockingState() {
        return this.currentLockingState;
    }

    @Override
    public void clearMenuImages() {
        if (this.lockingImages != null) {
            log.log(1078071040, "LockingGridImageController#clearMenuImages");
            this.lockingImages.clear();
        }
    }

    private void applyLockingStateToAllImages() {
        for (int i2 = 0; i2 < this.lockingImages.size(); ++i2) {
            this.applyLockingStateToImage((IconController)this.lockingImages.get(i2));
        }
    }

    private void applyLockingStateToImage(IconController iconController) {
        if (this.currentLockingState == 1) {
            iconController.setVisible(true);
            iconController.setOpacity(1.0f);
        } else if (this.currentLockingState == 2) {
            iconController.setOpacity(63);
        } else if (this.currentLockingState == 3) {
            iconController.setVisible(false);
        }
    }

    static {
        log = AbstractWidget.framework.getLogChannel("App.Online.RemoteHMI");
    }
}

