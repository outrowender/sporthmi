/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.app;

public class CarVMOptions {
    private static final String PROPERTY_VMOPTION_CARMENUS_VISIBLE;
    private static final String PROPERTY_VMOPTION_DUMMY_CARFUNCADAP;
    private static final String PROPERTY_VMOPTION_SIMULATION_GUI;
    private static final String PROPERTY_VMOPTIONS_IS_BENTLEY_PROTOTYPE;

    public static boolean carMenusVisible() {
        String string = System.getProperty("SetCarMenusVisible", "false");
        return string.equalsIgnoreCase("true");
    }

    public static boolean carFuncAdapSimulated() {
        String string = System.getProperty("SetCarFuncAdapSimulated", "false");
        return string.equalsIgnoreCase("true");
    }

    public static boolean carSimulationGUI() {
        String string = System.getProperty("SetCarSimulationGUI", "false");
        return string.equalsIgnoreCase("true");
    }

    public static boolean isBentleyPrototype() {
        String string = System.getProperty("SetBentleyPrototype", "false");
        return string.equalsIgnoreCase("true");
    }
}

