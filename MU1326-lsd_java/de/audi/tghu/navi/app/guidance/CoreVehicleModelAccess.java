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
        navigationEnv.getLabelModel(-1021508096).setText("");
        navigationEnv.getLabelModel(-1122171392).setText("");
        navigationEnv.getLabelModel(-1138948608).setText("");
        navigationEnv.getLabelModel(304219648).setText("");
        this.positionDescriptionGroup.add(navigationEnv.getLabelModel(-1122171392));
        this.positionDescriptionGroup.add(navigationEnv.getLabelModel(-1138948608));
        navigationEnv.getLabelModel(-1055062528).setText("");
        navigationEnv.getLabelModel(-1038285312).setText("");
        navigationEnv.getChoiceModel(-1105394176).setValue(-1);
        navigationEnv.getLabelModel(-1088616960).setText("");
        navigationEnv.getLabelModel(-987953664).setText("");
        navigationEnv.getLabelModel(-1004730880).setText("");
        this.gpsInfoGroup.add(navigationEnv.getLabelModel(-1055062528));
        this.gpsInfoGroup.add(navigationEnv.getLabelModel(-1038285312));
        this.gpsInfoGroup.add(navigationEnv.getChoiceModel(-1105394176));
        this.gpsInfoGroup.add(navigationEnv.getLabelModel(-1088616960));
        this.gpsInfoGroup.add(navigationEnv.getLabelModel(-987953664));
        this.gpsInfoGroup.add(navigationEnv.getLabelModel(-1004730880));
        this.gpsInfoGroup.add(navigationEnv.getChoiceModel(1512244736));
        navigationEnv.getLabelModel(-1071839744).setText("");
        navigationEnv.getLabelModel(26).setText("");
    }

    public void clearList() {
    }

    @Override
    public void updateStreet(String string) {
        if (Util.isEmpty(string)) {
            string = "---";
        }
        this.env.getLabelModel(-1021508096).setText(string);
    }

    @Override
    public void updateCountryNCity(String string, String string2, String string3) {
        this.env.getLabelModel(-1122171392).setText(string);
        this.env.getLabelModel(-1138948608).setText(string3);
        this.positionDescriptionGroup.flush();
    }

    @Override
    public void updateSatInfo(String string, String string2, int n, int n2, int n3, int n4) {
        this.env.getLabelModel(-1055062528).setText(string);
        this.env.getLabelModel(-1038285312).setText(string2);
        this.env.getChoiceModel(-1105394176).setValue(n);
        this.env.getLabelModel(-1088616960).setText(this.formatHeading(n));
        this.env.getLabelModel(-987953664).setText(Integer.toString(n2));
        this.env.getLabelModel(-1004730880).setText(Integer.toString(n3));
        this.env.getChoiceModel(1512244736).setValue(n4);
        this.gpsInfoGroup.flush();
    }

    protected String formatHeading(int n) {
        return new StringBuffer().append(360 - n % 360).append("\u00b0").toString();
    }

    @Override
    public void updateHeight(int n) {
        String string = Util.formatHeight(n);
        this.env.getLabelModel(-1071839744).setText(string);
        this.env.getLabelModel(26).setText(string);
    }

    @Override
    public void buildRows() {
    }

    @Override
    public void updateZip(String string) {
        this.env.getLabelModel(304219648).setText(string);
    }

    @Override
    public void updateRoadSign(NavLocation navLocation) {
    }
}

