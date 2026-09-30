/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.app;

public class CarVMOptions {
    private static final String PROPERTY_VMOPTION_CARMENUS_VISIBLE = "SetCarMenusVisible";
    private static final String PROPERTY_VMOPTION_DUMMY_CARFUNCADAP = "SetCarFuncAdapSimulated";
    private static final String PROPERTY_VMOPTION_SIMULATION_GUI = "SetCarSimulationGUI";
    private static final String PROPERTY_VMOPTIONS_IS_BENTLEY_PROTOTYPE = "SetBentleyPrototype";

    public static boolean carMenusVisible() {
        String string = System.getProperty(PROPERTY_VMOPTION_CARMENUS_VISIBLE, "false");
        return string.equalsIgnoreCase("true");
    }

    public static boolean carFuncAdapSimulated() {
        String string = System.getProperty(PROPERTY_VMOPTION_DUMMY_CARFUNCADAP, "false");
        return string.equalsIgnoreCase("true");
    }

    public static boolean carSimulationGUI() {
        String string = System.getProperty(PROPERTY_VMOPTION_SIMULATION_GUI, "false");
        return string.equalsIgnoreCase("true");
    }

    public static boolean isBentleyPrototype() {
        String string = System.getProperty(PROPERTY_VMOPTIONS_IS_BENTLEY_PROTOTYPE, "false");
        return string.equalsIgnoreCase("true");
    }
}

