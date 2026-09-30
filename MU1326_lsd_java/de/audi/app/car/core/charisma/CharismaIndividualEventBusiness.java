/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.charisma;

import de.audi.app.car.common.handler.ButtonModelHandler;
import de.audi.app.car.common.handler.ChoiceModelHandler;
import de.audi.app.car.common.handler.business.ChoiceModelEventBusinessAdapter;
import de.audi.app.car.common.handler.business.HandlerTransactionData;
import de.audi.app.car.core.charisma.CharismaIndivEntryBusinessConfig;
import de.audi.app.car.core.charisma.CharismaIndividualChoiceModelHandler;
import de.audi.app.car.core.charisma.CharismaIndividualEntryTransactionData;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithOptionMask;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithoutOptionMask;
import org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics;

public class CharismaIndividualEventBusiness
extends ChoiceModelEventBusinessAdapter {
    private boolean infoReceived = false;
    private final int dsiFunctionID;
    private final String dsiFunctionName;
    private int listPos = -1;
    protected int mask = 0;
    protected int setupValue = 1;
    private ChoiceModelApp availableModel;
    private final ChoiceModelApp selectedProfileModel;
    private CharismaIndividualChoiceModelHandler handler;
    private CharismaIndividualEntryTransactionData.CharismaIndivOptionMapping optionMapping;
    private CharismaIndivEntryBusinessConfig.BusinessEventProcessingConfig eventProcessingConfig = CharismaIndivEntryBusinessConfig.BusinessEventProcessingConfig.EVENT_PROCESS_CONFIG_ITEM_SELECTED_ONLY;
    private boolean enforceProfileIndivActivation = true;
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$CharismaSetupTableWithoutOptionMask;
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$CharismaSetupTableWithOptionMask;

    public CharismaIndividualEventBusiness(DSIBase dSIBase, int n, String string, LogChannel logChannel, ChoiceModelApp choiceModelApp) {
        super(dSIBase, logChannel);
        this.dsiFunctionID = n;
        this.dsiFunctionName = string;
        this.selectedProfileModel = choiceModelApp;
    }

    public void init(CharismaIndividualChoiceModelHandler charismaIndividualChoiceModelHandler, CharismaIndivEntryBusinessConfig charismaIndivEntryBusinessConfig) {
        this.setHandler(charismaIndividualChoiceModelHandler);
        this.setOptionMapping(charismaIndivEntryBusinessConfig.getOptionMapping());
        this.setEventProcessingConfig(charismaIndivEntryBusinessConfig.getEventProcessingConfig());
        this.enforceProfileIndivActivation = charismaIndivEntryBusinessConfig.enforceProfileIndivActivation();
    }

    public boolean processKeyPressed(HandlerTransactionData handlerTransactionData, ButtonModelHandler buttonModelHandler) {
        if (this.supportsKeyPressed()) {
            return this.processBusinessEvent(handlerTransactionData, buttonModelHandler, "processKeyPressed");
        }
        return false;
    }

    public boolean processItemSelected(HandlerTransactionData handlerTransactionData, ChoiceModelHandler choiceModelHandler) {
        if (this.supportsItemSelected()) {
            return this.processBusinessEvent(handlerTransactionData, choiceModelHandler, "processItemSelected");
        }
        return false;
    }

    public boolean processSetSetupValue(int n) {
        this.enforceProfileIndivActivation();
        CharismaSetupTableWithoutOptionMask charismaSetupTableWithoutOptionMask = this.createCompatibleSetupTable(n);
        if (null != charismaSetupTableWithoutOptionMask) {
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1000000, "[%1#processSetSetupValue] dsi.requestCharismaProfileFunction(): selectedDSIOption='%2' ", (Object)this, (long)charismaSetupTableWithoutOptionMask.getSetupValue());
            }
            CharismaSetupTableWithoutOptionMask[] charismaSetupTableWithoutOptionMaskArray = new CharismaSetupTableWithoutOptionMask[]{charismaSetupTableWithoutOptionMask};
            this.getDSICarDrivingCharacteristics().requestCharismaProfileFunction(7, charismaSetupTableWithoutOptionMaskArray);
        }
        return true;
    }

    private boolean processBusinessEvent(HandlerTransactionData handlerTransactionData, ButtonModelHandler buttonModelHandler, String string) {
        this.enforceProfileIndivActivation();
        CharismaIndividualEntryTransactionData charismaIndividualEntryTransactionData = (CharismaIndividualEntryTransactionData)handlerTransactionData;
        CharismaSetupTableWithoutOptionMask charismaSetupTableWithoutOptionMask = this.createCompatibleSetupTable(charismaIndividualEntryTransactionData);
        if (charismaSetupTableWithoutOptionMask != null) {
            CharismaSetupTableWithoutOptionMask[] charismaSetupTableWithoutOptionMaskArray = new CharismaSetupTableWithoutOptionMask[]{charismaSetupTableWithoutOptionMask};
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1000000, "[%1#%2] dsi.requestCharismaProfileFunction(): selectedDSIOption='%3' ", (Object)this, (Object)string, (long)charismaSetupTableWithoutOptionMaskArray[0].getSetupValue());
            }
            this.getDSICarDrivingCharacteristics().requestCharismaProfileFunction(7, charismaSetupTableWithoutOptionMaskArray);
        }
        return true;
    }

    private void enforceProfileIndivActivation() {
        if (this.enforceProfileIndivActivation && this.selectedProfileModel != null && this.selectedProfileModel.getValue() != 6) {
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1000000, "[%1#enforceProfileIndivActivation] calls dsi.setCharismaActiveProfile(DSICarDrivingCharacteristics.CHARISMAPROFILES_INDIVIDUAL)", (Object)this);
            }
            this.getDSICarDrivingCharacteristics().setCharismaActiveProfile(7);
        }
    }

    public CharismaSetupTableWithoutOptionMask createCompatibleSetupTable(int n) {
        Class clazz = class$org$dsi$ifc$cardrivingcharacteristics$CharismaSetupTableWithoutOptionMask == null ? (class$org$dsi$ifc$cardrivingcharacteristics$CharismaSetupTableWithoutOptionMask = CharismaIndividualEventBusiness.class$("org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithoutOptionMask")) : class$org$dsi$ifc$cardrivingcharacteristics$CharismaSetupTableWithoutOptionMask;
        try {
            Field field = clazz.getField("listPosition");
            if (field.getType() == Integer.TYPE) {
                Constructor constructor = clazz.getConstructor(new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                Object[] objectArray = new Object[]{new Integer(this.getListPos()), new Integer(this.getDsiFunctionID()), new Integer(n)};
                CharismaSetupTableWithoutOptionMask charismaSetupTableWithoutOptionMask = (CharismaSetupTableWithoutOptionMask)constructor.newInstance(objectArray);
                return charismaSetupTableWithoutOptionMask;
            }
            if (field.getType() == Byte.TYPE) {
                Constructor constructor = clazz.getConstructor(new Class[]{Byte.TYPE, Integer.TYPE, Integer.TYPE});
                Object[] objectArray = new Object[]{new Byte((byte)this.getListPos()), new Integer(this.getDsiFunctionID()), new Integer(n)};
                CharismaSetupTableWithoutOptionMask charismaSetupTableWithoutOptionMask = (CharismaSetupTableWithoutOptionMask)constructor.newInstance(objectArray);
                return charismaSetupTableWithoutOptionMask;
            }
            this.getLogChannel().log(10000, "No compatible type found for class def CharismaSetupTableWithoutOptionMask");
        }
        catch (SecurityException securityException) {
            this.getLogChannel().log(10000, "Exception in createCompatibleSetupTable", (Throwable)securityException);
        }
        catch (NoSuchFieldException noSuchFieldException) {
            this.getLogChannel().log(10000, "Exception in createCompatibleSetupTable", (Throwable)noSuchFieldException);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            this.getLogChannel().log(10000, "Exception in createCompatibleSetupTable", (Throwable)noSuchMethodException);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            this.getLogChannel().log(10000, "Exception in createCompatibleSetupTable", (Throwable)illegalArgumentException);
        }
        catch (InstantiationException instantiationException) {
            this.getLogChannel().log(10000, "Exception in createCompatibleSetupTable", (Throwable)instantiationException);
        }
        catch (IllegalAccessException illegalAccessException) {
            this.getLogChannel().log(10000, "Exception in createCompatibleSetupTable", (Throwable)illegalAccessException);
        }
        catch (InvocationTargetException invocationTargetException) {
            this.getLogChannel().log(10000, "Exception in createCompatibleSetupTable", (Throwable)invocationTargetException);
        }
        return null;
    }

    private CharismaSetupTableWithoutOptionMask createCompatibleSetupTable(CharismaIndividualEntryTransactionData charismaIndividualEntryTransactionData) {
        return this.createCompatibleSetupTable(charismaIndividualEntryTransactionData.getDataID(this));
    }

    private int getSetupTableField(CharismaSetupTableWithOptionMask charismaSetupTableWithOptionMask, String string) {
        int n = 0;
        Class clazz = class$org$dsi$ifc$cardrivingcharacteristics$CharismaSetupTableWithOptionMask == null ? (class$org$dsi$ifc$cardrivingcharacteristics$CharismaSetupTableWithOptionMask = CharismaIndividualEventBusiness.class$("org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithOptionMask")) : class$org$dsi$ifc$cardrivingcharacteristics$CharismaSetupTableWithOptionMask;
        try {
            Field field = clazz.getField(string);
            Object object = field.get(charismaSetupTableWithOptionMask);
            if (object instanceof Integer) {
                n = (Integer)object;
            } else if (object instanceof Byte) {
                n = ((Byte)object).intValue();
            } else {
                this.getLogChannel().log(10000, "Field not found in the CharismaSetupTableWithOptionMask : '%1'", (Object)string);
            }
        }
        catch (SecurityException securityException) {
            this.getLogChannel().log(10000, "Exception in getSetupTableField(CharismaSetupTableWithOptionMask, String)", (Throwable)securityException);
        }
        catch (NoSuchFieldException noSuchFieldException) {
            this.getLogChannel().log(10000, "Exception in getSetupTableField(CharismaSetupTableWithOptionMask, String)", (Throwable)noSuchFieldException);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            this.getLogChannel().log(10000, "Exception in getSetupTableField(CharismaSetupTableWithOptionMask, String)", (Throwable)illegalArgumentException);
        }
        catch (IllegalAccessException illegalAccessException) {
            this.getLogChannel().log(10000, "Exception in getSetupTableField(CharismaSetupTableWithOptionMask, String)", (Throwable)illegalAccessException);
        }
        return n;
    }

    private int getSetupTableField(CharismaSetupTableWithoutOptionMask charismaSetupTableWithoutOptionMask, String string) {
        int n = 0;
        Class clazz = class$org$dsi$ifc$cardrivingcharacteristics$CharismaSetupTableWithoutOptionMask == null ? (class$org$dsi$ifc$cardrivingcharacteristics$CharismaSetupTableWithoutOptionMask = CharismaIndividualEventBusiness.class$("org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithoutOptionMask")) : class$org$dsi$ifc$cardrivingcharacteristics$CharismaSetupTableWithoutOptionMask;
        try {
            Field field = clazz.getField(string);
            Object object = field.get(charismaSetupTableWithoutOptionMask);
            if (object instanceof Integer) {
                n = (Integer)object;
            } else if (object instanceof Byte) {
                n = ((Byte)object).intValue();
            } else {
                this.getLogChannel().log(10000, "Field not found in the CharismaSetupTableWithoutOptionMask : '%1'", (Object)string);
            }
        }
        catch (SecurityException securityException) {
            this.getLogChannel().log(10000, "Exception in getSetupTableField(CharismaSetupTableWithoutOptionMask, String)", (Throwable)securityException);
        }
        catch (NoSuchFieldException noSuchFieldException) {
            this.getLogChannel().log(10000, "Exception in getSetupTableField(CharismaSetupTableWithoutOptionMask, String)", (Throwable)noSuchFieldException);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            this.getLogChannel().log(10000, "Exception in getSetupTableField(CharismaSetupTableWithoutOptionMask, String)", (Throwable)illegalArgumentException);
        }
        catch (IllegalAccessException illegalAccessException) {
            this.getLogChannel().log(10000, "Exception in getSetupTableField(CharismaSetupTableWithoutOptionMask, String)", (Throwable)illegalAccessException);
        }
        return n;
    }

    public void processSetupTableEntryWithoutOptionMask(CharismaSetupTableWithoutOptionMask charismaSetupTableWithoutOptionMask) {
        this.processSetupTableEntry(charismaSetupTableWithoutOptionMask.getSetupValue(), this.getSetupTableField(charismaSetupTableWithoutOptionMask, "listPosition"));
        this.setSetupValue(charismaSetupTableWithoutOptionMask.getSetupValue());
    }

    public void processSetupTableEntryWithoutOptionMask(CharismaSetupTableWithoutOptionMask charismaSetupTableWithoutOptionMask, boolean bl) {
        this.processSetupTableEntry(charismaSetupTableWithoutOptionMask.getSetupValue(), this.getSetupTableField(charismaSetupTableWithoutOptionMask, "listPosition"));
        this.setVisibility(bl);
        this.setSetupValue(charismaSetupTableWithoutOptionMask.getSetupValue());
    }

    public void processSetupTableEntryWithOptionMask(CharismaSetupTableWithOptionMask charismaSetupTableWithOptionMask) {
        this.processSetupTableEntry(charismaSetupTableWithOptionMask.getSetupValue(), this.getSetupTableField(charismaSetupTableWithOptionMask, "listPosition"));
        this.setMask(this.getSetupTableField(charismaSetupTableWithOptionMask, "mask"));
        this.useOptionMaskToSetFunctionAvailability();
        this.setSetupValue(charismaSetupTableWithOptionMask.getSetupValue());
    }

    private void processSetupTableEntry(int n, int n2) {
        CharismaIndividualEntryTransactionData charismaIndividualEntryTransactionData = new CharismaIndividualEntryTransactionData(this.getOptionMapping());
        charismaIndividualEntryTransactionData.setData(n, this);
        if (this.getHandler() != null) {
            this.getHandler().updateDSIOption(charismaIndividualEntryTransactionData);
        }
        this.setListPos(n2);
        this.setInfoReceived(true);
    }

    public void useOptionMaskToSetFunctionAvailability() {
        boolean bl;
        boolean bl2 = bl = this.getMask() != 0;
        if (bl) {
            CharismaIndividualEntryTransactionData charismaIndividualEntryTransactionData = new CharismaIndividualEntryTransactionData(this.getOptionMapping());
            charismaIndividualEntryTransactionData.setHint(this.getMask());
            if (this.getHandler() != null) {
                this.getHandler().setHintsToConfigureEntriesInComboBox(charismaIndividualEntryTransactionData);
            }
        } else if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[%1#useOptionMaskToSetFunctionAvailability] empty mask ", (Object)this);
        }
        this.setVisibility(bl);
    }

    public void setInvisibleWhenNoInfoWasReceived() {
        if (!this.isInfoReceived()) {
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1000000, "[%1#setInvisibleWhenNoInfoWasReceived] no matching CharismaSetupTableWithOptionMask received --> set invisible", (Object)this);
            }
            this.setVisibility(false);
        }
    }

    private void setVisibility(boolean bl) {
        if (this.getAvailableModel() != null) {
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1000000, "[%1#setVisibility] %2 charisma individual entry", (Object)this, (Object)(bl ? "show" : "hide"));
            }
            this.getAvailableModel().setValue(bl ? 0 : 1);
        }
    }

    public void clear() {
        this.listPos = -1;
        this.infoReceived = false;
        this.mask = 0;
    }

    public String toString() {
        Buffer buffer = new Buffer(120);
        buffer.append("CharismaIndividualEventBusiness(funcName=");
        buffer.append(this.dsiFunctionName);
        buffer.append(", dsiFuncId=");
        buffer.append(this.dsiFunctionID);
        buffer.append(", listPos=");
        buffer.append(this.listPos);
        buffer.append(", infoReceived=");
        buffer.append(this.infoReceived);
        buffer.append(", mask=");
        buffer.append(this.mask);
        if (this.availableModel != null) {
            buffer.append(", availableModelID=");
            buffer.append(this.availableModel.getID());
        }
        buffer.append(')');
        return buffer.toString();
    }

    public ChoiceModelApp getAvailableModel() {
        return this.availableModel;
    }

    public void setAvailableModel(ChoiceModelApp choiceModelApp) {
        if (choiceModelApp == null) {
            this.getLogChannel().log(1000000, "[%1#setAvailableModel] set available model to NULL", (Object)this);
        }
        this.availableModel = choiceModelApp;
    }

    public boolean isInfoReceived() {
        return this.infoReceived;
    }

    private void setInfoReceived(boolean bl) {
        this.infoReceived = bl;
    }

    public int getListPos() {
        return this.listPos;
    }

    private void setListPos(int n) {
        this.listPos = n;
    }

    public int getMask() {
        return this.mask;
    }

    private void setMask(int n) {
        this.mask = n;
    }

    public int getSetupValue() {
        return this.setupValue;
    }

    private void setSetupValue(int n) {
        this.setupValue = n;
    }

    public int getDsiFunctionID() {
        return this.dsiFunctionID;
    }

    public String getDsiFunctionName() {
        return this.dsiFunctionName;
    }

    public CharismaIndividualChoiceModelHandler getHandler() {
        return this.handler;
    }

    private void setHandler(CharismaIndividualChoiceModelHandler charismaIndividualChoiceModelHandler) {
        this.handler = charismaIndividualChoiceModelHandler;
    }

    private DSICarDrivingCharacteristics getDSICarDrivingCharacteristics() {
        return (DSICarDrivingCharacteristics)this.getDSI();
    }

    protected CharismaIndividualEntryTransactionData.CharismaIndivOptionMapping getOptionMapping() {
        return this.optionMapping;
    }

    private void setOptionMapping(CharismaIndividualEntryTransactionData.CharismaIndivOptionMapping charismaIndivOptionMapping) {
        this.optionMapping = charismaIndivOptionMapping;
    }

    public boolean supportsKeyPressed() {
        return CharismaIndivEntryBusinessConfig.BusinessEventProcessingConfig.EVENT_PROCESS_CONFIG_KEY_PRESSED_ONLY.equalsConfig(this.eventProcessingConfig);
    }

    public boolean supportsItemSelected() {
        return CharismaIndivEntryBusinessConfig.BusinessEventProcessingConfig.EVENT_PROCESS_CONFIG_ITEM_SELECTED_ONLY.equalsConfig(this.eventProcessingConfig);
    }

    private void setEventProcessingConfig(CharismaIndivEntryBusinessConfig.BusinessEventProcessingConfig businessEventProcessingConfig) {
        this.eventProcessingConfig = businessEventProcessingConfig;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

