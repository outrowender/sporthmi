/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.guidance;

import de.audi.atip.hmi.model.ModelGroup;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.guidance.IVehicleModelAccess;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

public class CoreVehicleModelAccess
implements IVehicleModelAccess {
    protected NavigationEnv env;
    private ModelGroup positionDescriptionGroup = new ModelGroup();
    private ModelGroup gpsInfoGroup = new ModelGroup();

    public CoreVehicleModelAccess(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
        navigationEnv.getLabelModel(400835).setText("");
        navigationEnv.getLabelModel(400829).setText("");
        navigationEnv.getLabelModel(400828).setText("");
        navigationEnv.getLabelModel(401938).setText("");
        this.positionDescriptionGroup.add(navigationEnv.getLabelModel(400829));
        this.positionDescriptionGroup.add(navigationEnv.getLabelModel(400828));
        navigationEnv.getLabelModel(400833).setText("");
        navigationEnv.getLabelModel(400834).setText("");
        navigationEnv.getChoiceModel(400830).setValue(-1);
        navigationEnv.getLabelModel(400831).setText("");
        navigationEnv.getLabelModel(400837).setText("");
        navigationEnv.getLabelModel(400836).setText("");
        this.gpsInfoGroup.add(navigationEnv.getLabelModel(400833));
        this.gpsInfoGroup.add(navigationEnv.getLabelModel(400834));
        this.gpsInfoGroup.add(navigationEnv.getChoiceModel(400830));
        this.gpsInfoGroup.add(navigationEnv.getLabelModel(400831));
        this.gpsInfoGroup.add(navigationEnv.getLabelModel(400837));
        this.gpsInfoGroup.add(navigationEnv.getLabelModel(400836));
        this.gpsInfoGroup.add(navigationEnv.getChoiceModel(402266));
        navigationEnv.getLabelModel(400832).setText("");
        navigationEnv.getLabelModel(26).setText("");
    }

    public void clearList() {
    }

    public void updateStreet(String string) {
        if (Util.isEmpty(string)) {
            string = "---";
        }
        this.env.getLabelModel(400835).setText(string);
    }

    public void updateCountryNCity(String string, String string2, String string3) {
        this.env.getLabelModel(400829).setText(string);
        this.env.getLabelModel(400828).setText(string3);
        this.positionDescriptionGroup.flush();
    }

    public void updateSatInfo(String string, String string2, int n, int n2, int n3, int n4) {
        this.env.getLabelModel(400833).setText(string);
        this.env.getLabelModel(400834).setText(string2);
        this.env.getChoiceModel(400830).setValue(n);
        this.env.getLabelModel(400831).setText(this.formatHeading(n));
        this.env.getLabelModel(400837).setText(Integer.toString(n2));
        this.env.getLabelModel(400836).setText(Integer.toString(n3));
        this.env.getChoiceModel(402266).setValue(n4);
        this.gpsInfoGroup.flush();
    }

    protected String formatHeading(int n) {
        return 360 - n % 360 + "\u00b0";
    }

    public void updateHeight(int n) {
        String string = Util.formatHeight(n);
        this.env.getLabelModel(400832).setText(string);
        this.env.getLabelModel(26).setText(string);
    }

    public void buildRows() {
    }

    public void updateZip(String string) {
        this.env.getLabelModel(401938).setText(string);
    }

    public void updateRoadSign(NavLocation navLocation) {
    }
}

