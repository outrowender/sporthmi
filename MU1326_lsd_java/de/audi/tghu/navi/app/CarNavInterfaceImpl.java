/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.atip.interapp.navcar.CarNavListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.PosPosition;

public final class CarNavInterfaceImpl
implements CarNavListener {
    private final NavigationEnv env;
    private List listeners = new ArrayList();
    private LogChannel logChannel;
    private int lastAngle;
    private int lastHeight;
    private int lastLatitude;
    private int lastLongitude;
    private String lastCountry;
    private String lastCity;
    private String lastZip;
    private String lastStreet;
    private String lastHousenr;
    private final IVehicle vehicle;

    public CarNavInterfaceImpl(NavigationEnv navigationEnv, IVehicle iVehicle) {
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getLogChannel();
        this.vehicle = iVehicle;
    }

    public void refreshPosPosition() {
        this.refreshPosPosition(false);
    }

    public void refreshPosPositionDescription() {
        this.refreshPosPositionDescription(false);
    }

    public void addListener(CarNavListener carNavListener) {
        this.logChannel.log(1078071040, "CarNavInterfaceImpl#setListener() - listener registered");
        this.listeners.add(carNavListener);
        this.refreshPosPosition(true);
        this.refreshPosPositionDescription(true);
    }

    public void removeListener(CarNavListener carNavListener) {
        this.logChannel.log(1078071040, "CarNavInterfaceImpl#removeListener() - listener deregistered");
        this.listeners.remove(carNavListener);
    }

    public void removeAllCarNavListeners() {
        this.logChannel.log(1078071040, "CarNavInterfaceImpl#removeAllCarNavListeners()");
        this.listeners.clear();
    }

    @Override
    public void updateVehicleHeading(int n, int n2, boolean bl) {
        for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
            CarNavListener carNavListener = (CarNavListener)this.listeners.get(i2);
            try {
                carNavListener.updateVehicleHeading(n, n2, bl);
                continue;
            }
            catch (Exception exception) {
                this.logChannel.log(10000, "CarNavInterfaceImpl#updateVehicleHeading()", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateVehicleHeight(int n, boolean bl) {
        for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
            CarNavListener carNavListener = (CarNavListener)this.listeners.get(i2);
            try {
                carNavListener.updateVehicleHeight(n, bl);
                continue;
            }
            catch (Exception exception) {
                this.logChannel.log(10000, "CarNavInterfaceImpl#updateVehicleHeight()", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateVehiclePosition(int n, int n2, boolean bl) {
        for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
            CarNavListener carNavListener = (CarNavListener)this.listeners.get(i2);
            try {
                carNavListener.updateVehiclePosition(n, n2, bl);
                continue;
            }
            catch (Exception exception) {
                this.logChannel.log(10000, "CarNavInterfaceImpl#updateVehiclePosition()", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateVehiclePositionDescription(String string, String string2, String string3, String string4, String string5, boolean bl) {
        for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
            CarNavListener carNavListener = (CarNavListener)this.listeners.get(i2);
            try {
                carNavListener.updateVehiclePositionDescription(string, string2, string3, string4, string5, bl);
                continue;
            }
            catch (Exception exception) {
                this.logChannel.log(10000, "CarNavInterfaceImpl#updateVehiclePositionDescription()", (Throwable)exception);
            }
        }
    }

    private int calculateHeading(int n) {
        int n2 = 0;
        int n3 = Util.convertRotatingDirection(n, 0);
        switch (n3) {
            case 0: {
                n2 = 0;
                break;
            }
            case 7: {
                n2 = 5;
                break;
            }
            case 1: {
                n2 = 4;
                break;
            }
            case 4: {
                n2 = 1;
                break;
            }
            case 5: {
                n2 = 7;
                break;
            }
            case 3: {
                n2 = 6;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }

    public void refreshPosPosition(boolean bl) {
        PosPosition posPosition = this.vehicle.getFrontUnitPosition();
        boolean bl2 = false;
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        if (posPosition != null && posPosition.isCalibrated()) {
            bl2 = true;
            n = this.vehicle.getHeading(posPosition);
            n3 = posPosition.getHeight();
            n4 = posPosition.getLatitude();
            n5 = posPosition.getLongitude();
        }
        if (bl || n != this.lastAngle) {
            n2 = this.calculateHeading(n);
            this.updateVehicleHeading(n2, n, bl2);
            this.lastAngle = n;
        }
        if (bl || n3 != this.lastHeight) {
            this.updateVehicleHeight(n3, bl2);
            this.lastHeight = n3;
        }
        if (bl || n4 != this.lastLatitude || n5 != this.lastLongitude) {
            this.updateVehiclePosition(n4, n5, bl2);
            this.lastLatitude = n4;
            this.lastLongitude = n5;
        }
    }

    public void refreshPosPositionDescription(boolean bl) {
        NavLocation navLocation = this.env.getContainer().getSoPosPositionDescription();
        boolean bl2 = false;
        String string = "";
        String string2 = "";
        String string3 = "";
        String string4 = "";
        String string5 = "";
        if (navLocation != null) {
            bl2 = true;
            string = LocationFormatter.formatCountry(navLocation);
            string2 = LocationFormatter.formatCityTitleWithoutCityCenter(navLocation);
            string3 = LocationFormatter.formatZIPCode(navLocation);
            string4 = LocationFormatter.formatStreet(navLocation);
            string5 = LocationFormatter.formatHousenumber(navLocation);
        }
        if (!(!bl && string.equals(this.lastCountry) && string2.equals(this.lastCity) && string3.equals(this.lastZip) && string4.equals(this.lastStreet) && string5.equals(this.lastHousenr))) {
            this.updateVehiclePositionDescription(string, string2, string3, string4, string5, bl2);
            this.lastCountry = string;
            this.lastCity = string2;
            this.lastZip = string3;
            this.lastStreet = string4;
            this.lastHousenr = string5;
        }
    }
}

