/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.view.IPartialPopupController;
import de.audi.atip.hmi.view.IPartialPopupListener;
import de.audi.tghu.hmi.evo.DrawerAnimationListener;
import de.audi.tghu.hmi.evo.HMITerminalEvo;
import de.audi.tghu.hmi.evo.IDrawerFocusManagerEvo;
import de.audi.tghu.hmi.evo.IPartialPopupControllerEvo;
import de.audi.tghu.hmi.evo.IPopupManagerEvo;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.AbstractPartialPopupManager;
import de.esolutions.hmi.widgets.audi.base.AbstractScreenWidget;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.ScreenMainArea;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimationController;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.evo.widgets.ContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.PartialPopupActivatorController;
import java.util.List;
import org.osgi.framework.BundleContext;

public class PartialPopupManagerEvoHigh
extends AbstractPartialPopupManager
implements DrawerAnimationListener {
    private static final float FIXED_PP_DRAWER_OPACITY = 0.75f;
    private static final int PP_SKIN_CHANGE = 95;
    protected IPopupManagerEvo popupManagerEvo;
    private boolean registeredAtDrawerFocusManager;
    private final ContainerController.MutableAnimationTransformation mainAreaTransform = new ContainerController.MutableAnimationTransformation();

    public PartialPopupManagerEvoHigh(HMITerminalImpl hMITerminalImpl, BundleContext bundleContext, IFrameworkAccess iFrameworkAccess, boolean bl) {
        super(hMITerminalImpl, bundleContext, iFrameworkAccess);
    }

    public PartialPopupManagerEvoHigh(HMITerminalImpl hMITerminalImpl, BundleContext bundleContext, IFrameworkAccess iFrameworkAccess) {
        this(hMITerminalImpl, bundleContext, iFrameworkAccess, true);
    }

    public String getPopupName(int n) {
        Buffer buffer = new Buffer();
        buffer.append(n);
        if (n == 52) {
            buffer.append(" (VolumePopup)");
        } else if (n == 62) {
            buffer.append(" (StatusBarG22)");
        } else if (n == 101) {
            buffer.append(" (StatusBarG24)");
        } else if (n == 2100008) {
            buffer.append(" (Car OPS)");
        } else if (n == 65) {
            buffer.append(" (DebugInfos)");
        } else if (n == 72) {
            buffer.append(" (Standby)");
        } else if (n == 85) {
            buffer.append(" (Presets)");
        } else if (n == 61) {
            buffer.append(" (TrafficAnnouncement)");
        } else if (n == 2100017) {
            buffer.append(" (SeatLeft)");
        } else if (n == 2100016) {
            buffer.append(" (SeatRight)");
        } else if (n == 75 || n == 76 || n == 78 || n == 80 || n == 96 || n == 97 || n == 98 || n == 103 || n == 105 || n == 81) {
            buffer.append(" (UserHint)");
        } else if (n == 119) {
            buffer.append(" (Conversion Matrix)");
        }
        return buffer.toString();
    }

    protected boolean isSDSPartialPopup(IPartialPopupControllerEvo iPartialPopupControllerEvo) {
        return false;
    }

    protected boolean shouldShowWithFixedWidth(IPartialPopupController iPartialPopupController, int n) {
        return false;
    }

    protected int getPopupIdStatusLine() {
        return 62;
    }

    protected int getPopupIdVolume() {
        return 52;
    }

    protected int getPopupIdInvalid() {
        return -1;
    }

    protected IPartialPopupListener getActivatorListener(List list) {
        PartialPopupActivatorController partialPopupActivatorController = null;
        for (int i2 = 0; i2 < list.size(); ++i2) {
            IPartialPopupListener iPartialPopupListener = (IPartialPopupListener)list.get(i2);
            if (!(iPartialPopupListener instanceof PartialPopupActivatorController)) continue;
            partialPopupActivatorController = (PartialPopupActivatorController)iPartialPopupListener;
        }
        return partialPopupActivatorController;
    }

    protected void repaintScreen() {
        if (this.currentConnectedScreen != null) {
            ((AbstractScreenWidget)this.currentConnectedScreen).doCheckedRepaint();
        } else if (((AbstractAnimationController)this.terminal.getIAnimationController()).isFirstScreenShown()) {
            LOGPOPUPS.log(10000, "PartialPopupManager#repaintScreen currentConnectedScreen is null (has not been set correctly)");
        } else {
            LOGPOPUPS.log(10000000, "PartialPopupManager#repaintScreen first screen was not shown, repaint will be triggered by first screen");
        }
    }

    protected boolean shouldCheckModelStatusOnExecutePopupAllowance(int n) {
        return true;
    }

    public int getHMIPrio(int n, int n2) {
        if (this.popupManagerEvo == null) {
            this.popupManagerEvo = (IPopupManagerEvo)((Object)this.framework.getHMIService().getPopupManager(this.terminal.getTerminalID()));
        }
        if (this.popupManagerEvo != null) {
            return this.popupManagerEvo.getHMIInternalPrio(n, n2);
        }
        return 0;
    }

    private void updateDrawerTransformation(float[] fArray) {
        float f2;
        IWidgetLogChannel iWidgetLogChannel;
        float f3;
        if (this.currentConnectedScreen == null) {
            return;
        }
        ScreenMainArea screenMainArea = ((AbstractScreenWidget)this.currentConnectedScreen).getMainArea();
        this.mainAreaTransform.resetToIdentityTransformation();
        boolean bl = false;
        if (screenMainArea == null || !(screenMainArea instanceof ContainerController)) {
            LOGPOPUPS.log(1000000, "PartialPopupManager#updateDrawerTransforma current connected screen has no MainArea");
            f3 = 1.0f;
        } else {
            iWidgetLogChannel = (ContainerController)screenMainArea;
            this.mainAreaTransform.combine(((ContainerController)iWidgetLogChannel).getSelectionDrawerTransformation()).combine(((ContainerController)iWidgetLogChannel).getOptionDrawerTransformation()).combine(((ContainerController)iWidgetLogChannel).getEntertainmentDrawerTransformation());
            f3 = ((ContainerController)iWidgetLogChannel).getSmallStageSelectionDrawerOpacity();
            bl = ((ContainerController)iWidgetLogChannel).isPassOnOpacityToPartialPopups();
        }
        iWidgetLogChannel = (EALManager)this.terminal.getGUIManager();
        ((EALManager)iWidgetLogChannel).getPartialPopupsBackNode().setPosition(this.mainAreaTransform.getTransX(), this.mainAreaTransform.getTransY(), 0.0f);
        ((EALManager)iWidgetLogChannel).getPartialPopupsBackNode().setScale(this.mainAreaTransform.getScale(), this.mainAreaTransform.getScale(), 1.0f);
        if (bl) {
            f2 = this.mainAreaTransform.getOpacity();
        } else {
            float f4 = Math.max(fArray[2], fArray[0]);
            f4 = Math.max(fArray[4], f4);
            f2 = 1.0f - 0.25f * f4;
        }
        ((EALManager)iWidgetLogChannel).getPartialPopupsBackNode().setOpacity(f2 * f3);
    }

    public int showPopup(int n) {
        int n2 = 3;
        if (n == 95) {
            ((HMITerminalEvo)((Object)this.terminal)).setSkin(1);
            n2 = 1;
        } else {
            IDrawerFocusManagerEvo iDrawerFocusManagerEvo;
            if (!this.registeredAtDrawerFocusManager && (iDrawerFocusManagerEvo = this.terminal.getDrawerFocusManager()) != null) {
                iDrawerFocusManagerEvo.registerDrawerAnimationListener(this);
                this.registeredAtDrawerFocusManager = true;
            }
            n2 = super.showPopup(n);
        }
        return n2;
    }

    public int hidePopup(int n) {
        if (n == 95) {
            ((HMITerminalEvo)((Object)this.terminal)).setSkin(0);
            return 2;
        }
        return super.hidePopup(n);
    }

    public void initializeDrawerAnimation(float[] fArray, float[] fArray2) {
        this.updateDrawerTransformation(fArray);
    }

    public void drawerAnimationTargetChanged(float[] fArray, float[] fArray2, int n) {
    }

    public void setDrawerAnimation(float[] fArray, float[] fArray2, int n) {
        this.updateDrawerTransformation(fArray);
    }

    public void drawerAnimationFinished(float[] fArray, float[] fArray2, int n) {
        this.updateDrawerTransformation(fArray);
    }

    public int getDrawerAnimationMask() {
        return 4117;
    }
}

