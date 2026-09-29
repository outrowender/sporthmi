/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.device.DeviceManager
 *  de.audi.atip.utils.generics.GList
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.device.DeviceManager;
import de.audi.app.terminalmode.device.DeviceManager$1;
import de.audi.app.terminalmode.device.TMDevice;
import de.audi.app.terminalmode.device.TMDevice$ConnectionState;
import de.audi.app.terminalmode.device.TMDeviceControl;
import de.audi.app.terminalmode.device.TMDeviceControl$IDeviceControlToDeviceManager;
import de.audi.atip.utils.generics.GIterator;
import de.audi.atip.utils.generics.GList;

class DeviceManager$DeviceActivationRequestHandler
implements TMDeviceControl$IDeviceControlToDeviceManager {
    private static final String LOGCLASS;
    private TMDeviceControl runningActivationRequest = null;
    private final /* synthetic */ DeviceManager this$0;

    private DeviceManager$DeviceActivationRequestHandler(DeviceManager deviceManager) {
        this.this$0 = deviceManager;
    }

    @Override
    public void requestActivation(TMDeviceControl tMDeviceControl) {
        if (tMDeviceControl.equals(DeviceManager.access$1100((DeviceManager)this.this$0)) && DeviceManager.access$1100((DeviceManager)this.this$0).isActive()) {
            DeviceManager.access$1200((DeviceManager)this.this$0).log(1078071040, "<!> [%1.requestActivation] NOP because already active - %2.", (Object)"DeviceManager.DeviceActivationRequestHandler", (Object)DeviceManager.access$1100((DeviceManager)this.this$0));
        } else {
            this.moveSelectionMarker(tMDeviceControl.getTmDevice());
            if (DeviceManager.access$1300().equals(DeviceManager.access$1100((DeviceManager)this.this$0))) {
                DeviceManager.access$1200((DeviceManager)this.this$0).log(1078071040, "<!> [%1.requestActivation] nothing active, activation confirmed for %2", (Object)"DeviceManager.DeviceActivationRequestHandler", (Object)tMDeviceControl.getTmDevice());
                this.confirmActivation(tMDeviceControl);
            } else {
                DeviceManager.access$1200((DeviceManager)this.this$0).log(1078071040, "<!> [%1.requestActivation] activation postponed because already active - %2", (Object)"DeviceManager.DeviceActivationRequestHandler", (Object)DeviceManager.access$1100((DeviceManager)this.this$0));
                DeviceManager.access$1200((DeviceManager)this.this$0).log(1078071040, "<!> [%1.requestActivation] saving request - %2", (Object)"DeviceManager.DeviceActivationRequestHandler", (Object)tMDeviceControl.getTmDevice());
                this.runningActivationRequest = tMDeviceControl;
                this.this$0.control(DeviceManager.access$1100((DeviceManager)this.this$0)).deactivationConfirmed();
            }
        }
    }

    @Override
    public void requestOtherModeActivation(TMDeviceControl tMDeviceControl) {
        DeviceManager.access$1200((DeviceManager)this.this$0).log(1078071040, "<!> [%1.requestOtherModeActivation] deviceToBeDeactivated: %2", (Object)"DeviceManager.DeviceActivationRequestHandler", (Object)tMDeviceControl);
        for (TMDevice tMDevice : DeviceManager.access$200((DeviceManager)this.this$0).getDeviceList()) {
            DeviceManager.access$1200((DeviceManager)this.this$0).log(1078071040, "<!> [%1.requestOtherModeActivation] deviceToBeChecked: %2", (Object)"DeviceManager.DeviceActivationRequestHandler", (Object)tMDevice);
            if (!tMDevice.getUniqueID().address.equals(DeviceManager.access$1100((DeviceManager)this.this$0).getUniqueID().address) || !tMDevice.smartphoneType().isNot(DeviceManager.access$1100((DeviceManager)this.this$0).smartphoneType())) continue;
            if (tMDevice.wasDisclaimerPreviouslyAccepted() || !DeviceManager.access$700((DeviceManager)this.this$0).getConfiguration().shouldShowDisclaimerAtLeastOnce()) {
                DeviceManager.access$1200((DeviceManager)this.this$0).log(1078071040, "<!> [%1.requestOtherModeActivation] requestActivation for device: id: %2 - uniqueid: %3", (Object)"DeviceManager.DeviceActivationRequestHandler", (Object)new Integer(tMDevice.getDeviceId()), (Object)tMDevice.getUniqueID());
                this.requestActivation(this.this$0.control(tMDevice));
                break;
            }
            DeviceManager.access$700((DeviceManager)this.this$0).getEventBus().requestUserDecision(tMDevice);
            break;
        }
    }

    @Override
    public void requestDeactivation(TMDeviceControl tMDeviceControl) {
        tMDeviceControl.getTmDevice().setSelected(false);
        DeviceManager.access$1600((DeviceManager)this.this$0, (GList)DeviceManager.access$1400((DeviceManager)this.this$0), (GList)DeviceManager.access$1500((DeviceManager)this.this$0), (String)"requestDeactivation");
        tMDeviceControl.deactivationConfirmed();
    }

    private void moveSelectionMarker(TMDevice tMDevice) {
        GIterator gIterator = DeviceManager.access$200((DeviceManager)this.this$0).getDeviceList().iterator();
        while (gIterator.hasNext()) {
            ((TMDevice)gIterator.next()).setSelected(false);
        }
        tMDevice.setSelected(true);
        DeviceManager.access$1600((DeviceManager)this.this$0, (GList)DeviceManager.access$1400((DeviceManager)this.this$0), (GList)DeviceManager.access$1500((DeviceManager)this.this$0), (String)"moveSelectionMarker");
    }

    private void confirmActivation(TMDeviceControl tMDeviceControl) {
        DeviceManager.access$1102((DeviceManager)this.this$0, (TMDevice)tMDeviceControl.getTmDevice());
        DeviceManager.access$1800((DeviceManager)this.this$0, (GList)DeviceManager.access$1700((DeviceManager)this.this$0), (TMDevice)DeviceManager.access$1100((DeviceManager)this.this$0), (String)"confirmActivation");
        tMDeviceControl.activationConfirmed();
    }

    @Override
    public void notifyAboutChange(TMDevice tMDevice, String string) {
        boolean bl = tMDevice.getUniqueID().equals(DeviceManager.access$1100((DeviceManager)this.this$0).getUniqueID());
        boolean bl2 = DeviceManager.access$1100((DeviceManager)this.this$0).connectionState().isOneOf(TMDevice$ConnectionState.ATTACHED, TMDevice$ConnectionState.NOT_ATTACHED);
        if (bl && bl2) {
            if (this.runningActivationRequest != null) {
                DeviceManager.access$1200((DeviceManager)this.this$0).log(1078071040, "<!> [%1.notifyAboutChange] activating pending request %2", (Object)"DeviceManager.DeviceActivationRequestHandler", (Object)this.runningActivationRequest.getTmDevice());
                this.confirmActivation(this.runningActivationRequest);
                this.runningActivationRequest.getTmDevice().setSelected(true);
                this.runningActivationRequest = null;
            } else {
                DeviceManager.access$1200((DeviceManager)this.this$0).log(1078071040, "[%1.notifyAboutChange] no pending requests present", (Object)"DeviceManager.DeviceActivationRequestHandler");
                DeviceManager.access$1100((DeviceManager)this.this$0).setSelected(false);
                DeviceManager.access$1102((DeviceManager)this.this$0, (TMDevice)DeviceManager.access$1300());
                DeviceManager.access$1800((DeviceManager)this.this$0, (GList)DeviceManager.access$1700((DeviceManager)this.this$0), (TMDevice)DeviceManager.access$1100((DeviceManager)this.this$0), (String)"active device deactivated");
            }
        }
        if (bl && !bl2) {
            DeviceManager.access$1800((DeviceManager)this.this$0, (GList)DeviceManager.access$1700((DeviceManager)this.this$0), (TMDevice)DeviceManager.access$1100((DeviceManager)this.this$0), (String)"active device changed");
        }
        if (!bl && tMDevice.isActive()) {
            DeviceManager.access$1200((DeviceManager)this.this$0).log(1078071040, "[%1.notifyAboutChange] setting active device as selected", (Object)"DeviceManager.DeviceActivationRequestHandler");
            DeviceManager.access$1102((DeviceManager)this.this$0, (TMDevice)tMDevice);
            DeviceManager.access$1100((DeviceManager)this.this$0).setSelected(true);
            this.runningActivationRequest = null;
            DeviceManager.access$1800((DeviceManager)this.this$0, (GList)DeviceManager.access$1700((DeviceManager)this.this$0), (TMDevice)DeviceManager.access$1100((DeviceManager)this.this$0), (String)"active device selected");
        }
        DeviceManager.access$1600((DeviceManager)this.this$0, (GList)DeviceManager.access$1400((DeviceManager)this.this$0), (GList)DeviceManager.access$1500((DeviceManager)this.this$0), (String)string);
    }

    @Override
    public void deleteMe(TMDeviceControl tMDeviceControl) {
        DeviceManager.access$200((DeviceManager)this.this$0).deleteDeviceFromPersistence(tMDeviceControl);
        if (tMDeviceControl.getTmDevice().equals(DeviceManager.access$1100((DeviceManager)this.this$0))) {
            DeviceManager.access$1102((DeviceManager)this.this$0, (TMDevice)DeviceManager.access$1300());
        }
        this.notifyAboutChange(DeviceManager.access$1300(), "deleted");
    }

    /* synthetic */ DeviceManager$DeviceActivationRequestHandler(DeviceManager deviceManager, DeviceManager$1 deviceManager$1) {
        this(deviceManager);
    }
}

