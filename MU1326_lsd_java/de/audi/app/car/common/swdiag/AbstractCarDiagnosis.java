/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.swdiag;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.AbstractCarComponent;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.comp.ICarComponent;
import de.audi.app.car.common.mer.MenuEntryRegistry;
import de.audi.app.car.common.swdiag.IDiagnosisCommand;
import de.audi.app.car.common.swdiag.IDiagnosisCommandCollection;
import de.audi.app.car.common.swdiag.InvalidCommandParameterException;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class AbstractCarDiagnosis
extends AbstractSwDiagnosis {
    protected static final String KEYPREFIX_VIEWOPTIONS;
    protected static final String KEY_MODELBANK;
    protected static final String KEY_ALLVIEWOPTIONS;
    protected static final String KEY_DSIATTRIBUTES;
    protected static final String KEY_VEHICLESTATUS;
    protected static final String KEY_MENUENTRIES;
    protected Map diagnosisCommands;
    protected List componentIDs;
    protected ICarApplication application;
    private Map componentNameToID = new HashMap();

    protected AbstractCarDiagnosis(ICarApplication iCarApplication) {
        this.application = iCarApplication;
        this.componentIDs = new ArrayList();
        this.diagnosisCommands = new HashMap();
        this.createCommands();
    }

    protected abstract void createCommands() {
    }

    protected void addAllDiagnosisCommands(IDiagnosisCommandCollection iDiagnosisCommandCollection) {
        Collection collection = iDiagnosisCommandCollection.getDiagnosisCommands();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            IDiagnosisCommand iDiagnosisCommand = (IDiagnosisCommand)iterator.next();
            this.diagnosisCommands.put(iDiagnosisCommand.getCommandString(), iDiagnosisCommand);
        }
    }

    @Override
    public String[] getKeys() {
        Object[] objectArray;
        ArrayList arrayList = new ArrayList();
        Object[] objectArray2 = this.componentIDs.iterator();
        while (objectArray2.hasNext()) {
            objectArray = (Object[])objectArray2.next();
            ICarComponent iCarComponent = this.application.getComponent(objectArray.intValue());
            if (iCarComponent == null) continue;
            String string = this.createViewOptionsKey(iCarComponent);
            this.componentNameToID.put(iCarComponent.getName(), objectArray);
            arrayList.add(string);
        }
        arrayList.add("ViewOptions");
        arrayList.add("DSIattributes");
        arrayList.add("VehicleStatus");
        arrayList.add("MenuEntries");
        objectArray2 = super.getKeys();
        arrayList.addAll(Arrays.asList(objectArray2));
        objectArray = new String[arrayList.size()];
        arrayList.toArray(objectArray);
        return objectArray;
    }

    private String createViewOptionsKey(ICarComponent iCarComponent) {
        Buffer buffer = new Buffer();
        buffer.append("ViewOptions - ");
        buffer.append(iCarComponent.getName());
        return buffer.toString();
    }

    @Override
    public String[] getCommands() {
        Iterator iterator = this.diagnosisCommands.keySet().iterator();
        String[] stringArray = new String[this.diagnosisCommands.keySet().size()];
        int n = 0;
        while (iterator.hasNext()) {
            stringArray[n] = (String)iterator.next();
            ++n;
        }
        String[] stringArray2 = super.getCommands();
        String[] stringArray3 = new String[stringArray.length + stringArray2.length];
        System.arraycopy((Object)stringArray, 0, (Object)stringArray3, 0, stringArray.length);
        System.arraycopy((Object)stringArray2, 0, (Object)stringArray3, stringArray.length, stringArray2.length);
        return stringArray3;
    }

    @Override
    public Object getValue(String string) {
        Object object = null;
        object = string.startsWith("ViewOptions - ") ? this.getViewOptions(string) : ("ViewOptions".equals(string) ? this.getAllViewOptions() : ("DSIattributes".equals(string) ? this.getDSIAttributes() : ("VehicleStatus".equals(string) ? this.getVehicleStatus() : ("MenuEntries".equals(string) ? this.getMenuEntries() : super.getValue(string)))));
        return object;
    }

    @Override
    public Object processNewCommand(String string, Object object) {
        Object object2;
        block7: {
            object2 = new Integer(-10);
            try {
                Object object3 = this.diagnosisCommands.get(string);
                if (object3 instanceof IDiagnosisCommand) {
                    try {
                        ((IDiagnosisCommand)object3).parseParameters((String)object);
                    }
                    catch (InvalidCommandParameterException invalidCommandParameterException) {
                        return invalidCommandParameterException.getMessage();
                    }
                    String string2 = ((IDiagnosisCommand)object3).run();
                    if (string2 == null || string2.length() == 0) {
                        object2 = "   Call executed successfully.";
                    } else {
                        Buffer buffer = new Buffer("   An error occured:\n").append("   ").append(string2);
                        object2 = buffer.toString();
                    }
                    break block7;
                }
                object2 = super.processNewCommand(string, object);
            }
            catch (Exception exception) {
                exception.printStackTrace();
                object2 = new Integer(-1);
            }
        }
        return object2;
    }

    private String getViewOptions(String string) {
        String string2 = string.substring("ViewOptions - ".length());
        int n = (Integer)this.componentNameToID.get(string2);
        return this.getViewOptionsString(n);
    }

    private String getAllViewOptions() {
        Buffer buffer = new Buffer();
        Iterator iterator = this.componentIDs.iterator();
        while (iterator.hasNext()) {
            int n = (Integer)iterator.next();
            try {
                buffer.append(this.getViewOptionsString(n));
            }
            catch (Exception exception) {
                buffer.append("exception occurred");
            }
        }
        return buffer.toString();
    }

    private String getViewOptionsString(int n) {
        Buffer buffer = new Buffer();
        ICarComponent iCarComponent = this.application.getComponent(n);
        if (iCarComponent == null) {
            buffer.append("Component with ID ");
            buffer.append(n);
            buffer.append(" is null. Check if coded (Key values -> SysApp -> getCarMenuFlags)!");
            buffer.append('\n');
        } else {
            buffer.append("ViewOptions for component ");
            buffer.append(super.getClass().getName());
            buffer.append(":\n");
            buffer.append(iCarComponent.getCurrentViewOptions() != null ? this.formatViewOptionsLog(iCarComponent.getCurrentViewOptions()) : "null");
            buffer.append("\n\n");
        }
        return buffer.toString();
    }

    private String formatViewOptionsLog(String string) {
        Buffer buffer = new Buffer(100);
        int n = 0;
        int n2 = 0;
        boolean bl = false;
        for (int i2 = 0; i2 < string.length(); ++i2) {
            int n3;
            if (string.charAt(i2) == ',') {
                if (bl) continue;
                for (n3 = 0; n3 < n; ++n3) {
                    buffer.append("\t");
                }
                buffer.append(string.substring(n2, i2 + 1));
                buffer.append("\n");
                n2 = i2 + 1;
            }
            if (string.charAt(i2) == '(') {
                if (string.substring(i2 - "ViewOption".length(), i2).equals("ViewOption")) {
                    bl = true;
                    continue;
                }
                for (n3 = 0; n3 < n; ++n3) {
                    buffer.append("\t");
                }
                ++n;
                buffer.append(string.substring(n2, i2 + 1));
                buffer.append("\n");
                n2 = i2 + 1;
                continue;
            }
            if (string.charAt(i2) != ')') continue;
            if (bl) {
                bl = false;
                continue;
            }
            for (n3 = 0; n3 < n; ++n3) {
                buffer.append("\t");
            }
            --n;
            buffer.append(string.substring(n2, i2 + 1));
            buffer.append("\n");
            n2 = i2 + 1;
        }
        buffer.append(string.substring(n2, string.length()));
        return buffer.toString();
    }

    private String getDSIAttributes() {
        Buffer buffer = new Buffer();
        Iterator iterator = this.componentIDs.iterator();
        while (iterator.hasNext()) {
            int n = (Integer)iterator.next();
            ICarComponent iCarComponent = this.application.getComponent(n);
            if (iCarComponent == null) {
                buffer.append("Component with ID ");
                buffer.append(n);
                buffer.append(" is null. Check if coded (Key values -> SysApp -> getCarMenuFlags)!");
                buffer.append("\n\n");
                continue;
            }
            buffer.append("Attributes for component ");
            buffer.append(super.getClass().getName());
            buffer.append(":\n");
            CarDSIAttributesSet[] carDSIAttributesSetArray = ((AbstractCarComponent)iCarComponent).getLifeAttributesSets();
            if (carDSIAttributesSetArray.length == 0) {
                buffer.append("no DSI attributes (empty)");
            } else {
                for (int i2 = 0; i2 < carDSIAttributesSetArray.length; ++i2) {
                    buffer.append(carDSIAttributesSetArray[i2].toString());
                    if (i2 >= carDSIAttributesSetArray.length - 1) continue;
                    buffer.append(", ");
                }
            }
            buffer.append("\n\n");
        }
        return buffer.toString();
    }

    private Object getVehicleStatus() {
        return this.application.getMenuEntryRegistry().getVehicleStatusDump();
    }

    private String getMenuEntries() {
        Buffer buffer = new Buffer();
        ArrayList arrayList = ((MenuEntryRegistry)this.application.getMenuEntryRegistry()).getDebugData();
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            String string = (String)iterator.next();
            buffer.append(string);
            buffer.append("\n");
        }
        return buffer.toString();
    }
}

