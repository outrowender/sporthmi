/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.li;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.LIGetLocationDescriptionTransformCommand;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.li.AddressInputWizard$1;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

public class AddressInputWizard
implements ButtonListener {
    public static final int COLOR_BLUE;
    public static final int COLOR_GREEN;
    private final NavigationEnv env;
    private final IVehicle vehicle;
    private final ICommandListFactory commandListFactory;
    private LogChannel logChannel;
    private HomeAddressHandler homeAddressHandler;

    public AddressInputWizard(NavigationEnv navigationEnv, IVehicle iVehicle, ICommandListFactory iCommandListFactory, HomeAddressHandler homeAddressHandler) {
        this.env = navigationEnv;
        this.vehicle = iVehicle;
        this.commandListFactory = iCommandListFactory;
        this.homeAddressHandler = homeAddressHandler;
        this.logChannel = navigationEnv.getLogChannel();
        this.setListeners();
    }

    private void setListeners() {
        this.env.getButtonModel(-283507200).setButtonListener(this);
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.logChannel.log(-2137614336, "AddressInputWizard#keyPressed( %1 )", (long)n);
        CommandList commandList = null;
        this.refreshColor(n);
        switch (n) {
            case 400111: {
                commandList = this.commandListFactory.createCommandList();
                commandList.add(this.getCurrentCarPosition());
                commandList.add(new AddressInputWizard$1(this, "ResolveTransformedLocation", n));
                commandList.execute("AddressInputWizard#keyPressed.NAV_ADB_WIZARD_CURRENT_CAR_POS_BUTTON");
                this.env.fireModelEvent(n, n3);
                break;
            }
            default: {
                this.logChannel.log(-1601830656, "AddressInputWizard#keyPressed() - unsupported modelID: %1", (long)n);
            }
        }
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    private CommandList getCurrentCarPosition() {
        NavLocation navLocation = this.vehicle.getVehicleLocation();
        NavLocation navLocation2 = Util.getLocationFromGeoPos(navLocation.getLongitude(), navLocation.getLatitude());
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LIGetLocationDescriptionTransformCommand(navLocation2));
        return commandList;
    }

    private void refreshColor(int n) {
        switch (n) {
            case 400111: 
            case 400112: {
                this.setColor(this.getAddressBookColor());
                break;
            }
            default: {
                this.setColor(0);
            }
        }
    }

    private void setColor(int n) {
        this.logChannel.log(-2137614336, "AddressInputWizard#setColor( %1 )", (long)n);
        this.env.getChoiceModel(19).setValue(n);
    }

    private int getAddressBookColor() {
        int n = this.env.getFramework().getHmiServiceApp().getChoiceModel(17).getValue();
        return n == 0 ? 1 : 0;
    }

    static /* synthetic */ HomeAddressHandler access$000(AddressInputWizard addressInputWizard) {
        return addressInputWizard.homeAddressHandler;
    }

    static /* synthetic */ LogChannel access$100(AddressInputWizard addressInputWizard) {
        return addressInputWizard.logChannel;
    }
}

