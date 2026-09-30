/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.charisma;

import de.audi.app.car.common.handler.business.HandlerTransactionData;
import de.audi.app.car.core.charisma.CharismaIndivOption;
import de.audi.app.car.core.charisma.CharismaIndividualChoiceModelHandler;
import de.audi.app.car.core.charisma.CharismaIndividualEventBusiness;

public class CharismaIndividualEntryTransactionData
implements HandlerTransactionData {
    private int hint;
    private CharismaIndivOptionMapping mapper;
    private CharismaIndivOption option;
    public static final CharismaIndivOptionMapping DEFAULT_MAPPER = CharismaIndivOptionMapping.DDB_TO_DSI_PROFILE_MAPPER;

    public CharismaIndividualEntryTransactionData() {
        this.mapper = DEFAULT_MAPPER;
        this.option = this.mapper.getDefaultOption();
    }

    public CharismaIndividualEntryTransactionData(CharismaIndivOptionMapping charismaIndivOptionMapping) {
        this.mapper = charismaIndivOptionMapping != null ? charismaIndivOptionMapping : DEFAULT_MAPPER;
        this.option = this.mapper.getDefaultOption();
    }

    private CharismaIndivOption getOption() {
        return this.option;
    }

    protected void setOption(CharismaIndivOption charismaIndivOption) {
        this.option = charismaIndivOption;
    }

    public void setData(int n, CharismaIndividualEventBusiness charismaIndividualEventBusiness) {
        this.setOption(this.mapper.getOptionByDsiID(n));
    }

    public void setData(int n, CharismaIndividualChoiceModelHandler charismaIndividualChoiceModelHandler) {
        this.setOption(this.mapper.getOptionByID(n));
    }

    public int getDataID(CharismaIndividualEventBusiness charismaIndividualEventBusiness) {
        return this.getOption().getDsiOption();
    }

    public int getDataID(CharismaIndividualChoiceModelHandler charismaIndividualChoiceModelHandler) {
        return this.getOption().getOptionID();
    }

    public void setHint(int n) {
        this.hint = this.mapper.getHintsForMask(n);
    }

    public int getHint() {
        return this.hint;
    }

    public static class CharismaIndivOptionMapping {
        private static final int DDB_COMFORT = 0;
        private static final int DDB_AUTO = 1;
        private static final int DDB_DYNAMIC = 2;
        private static final int DDB_EFFICIENCY = 3;
        private static final int DDB_ALLROAD_OFFROAD = 4;
        private static final int CB_INACTIVE = 0;
        private static final int CB_ACTIVE = 1;
        private static final int RB_NORMAL_COMFORT = 0;
        private static final int RB_SPORT = 1;
        private static final int RB_SPORT_PLUS = 2;
        private static final int RB_POSITION1 = 0;
        private static final int RB_POSITION2 = 1;
        private static final int RB_POSITION3 = 2;
        private static final int RB_POSITION4 = 3;
        private static final int RB_POSITION5 = 4;
        private final CharismaIndivOption[] options;
        private final String mappingName;
        public static final CharismaIndivOptionMapping DDB_TO_DSI_PROFILE_MAPPER = new CharismaIndivOptionMapping("DDB_TO_DSI_PROFILE_MAPPER", new CharismaIndivOption[]{new CharismaIndivOption("CHARISMA_INDIVIDUAL_OPTION_COMFORT", 0, 1, 2), new CharismaIndivOption("CHARISMA_INDIVIDUAL_OPTION_AUTO", 1, 2, 4), new CharismaIndivOption("CHARISMA_INDIVIDUAL_OPTION_DYNAMIC", 2, 3, 8), new CharismaIndivOption("CHARISMA_INDIVIDUAL_OPTION_EFFICIENCY", 3, 5, 32), new CharismaIndivOption("CHARISMA_INDIVIDUAL_OPTION_ALLROAD_OFFROAD", 4, 4, 16)});
        public static final CharismaIndivOptionMapping PROFILE_RADIOBTN_TO_DSI_VALUE_MAPPER = new CharismaIndivOptionMapping("PROFILE_RADIOBTN_TO_DSI_VALUE_MAPPER", new CharismaIndivOption[]{new CharismaIndivOption("DRIVEMODE_NORMAL/COMFORT", 0, 1, 2), new CharismaIndivOption("DRIVEMODE_SPORT", 1, 2, 4), new CharismaIndivOption("DRIVEMODE_SPORT_PLUS", 2, 3, 8)});
        public static final CharismaIndivOptionMapping CHECKBOX_TO_DSI_VALUE_MAPPER = new CharismaIndivOptionMapping("CHECKBOX_TO_DSI_VALUE_MAPPER", new CharismaIndivOption[]{new CharismaIndivOption("CHARISMA_INDIVIDUAL_OPTION_INACTIVE", 0, 1, 2), new CharismaIndivOption("CHARISMA_INDIVIDUAL_OPTION_ACTIVE", 1, 2, 4)});
        public static final CharismaIndivOptionMapping CHECKBOX_TO_DSI_VALUE_REVERTED_MAPPER = new CharismaIndivOptionMapping("CHECKBOX_TO_DSI_VALUE_REVERTED_MAPPER", new CharismaIndivOption[]{new CharismaIndivOption("CHARISMA_INDIVIDUAL_OPTION_ACTIVE", 1, 1, 2), new CharismaIndivOption("CHARISMA_INDIVIDUAL_OPTION_INACTIVE", 0, 2, 4)});
        public static final CharismaIndivOptionMapping POSITION_RADIOBTN_TO_DSI_VALUE_MAPPER = new CharismaIndivOptionMapping("POSITION_RADIOBTN_TO_DSI_VALUE_MAPPER", new CharismaIndivOption[]{new CharismaIndivOption("CHARISMA_INDIVIDUAL_OPTION_POSITION1", 0, 1, 2), new CharismaIndivOption("CHARISMA_INDIVIDUAL_OPTION_POSITION2", 1, 2, 4), new CharismaIndivOption("CHARISMA_INDIVIDUAL_OPTION_POSITION3", 2, 3, 8), new CharismaIndivOption("CHARISMA_INDIVIDUAL_OPTION_POSITION4", 3, 4, 16), new CharismaIndivOption("CHARISMA_INDIVIDUAL_OPTION_POSITION5", 4, 5, 32)});
        public static final CharismaIndivOptionMapping ONE_TO_ONE_VALUE_MAPPER = new CharismaIndivOptionMapping("POSITION_RADIOBTN_TO_DSI_VALUE_MAPPER", new CharismaIndivOption[]{new CharismaIndivOption("CHARISMA_INDIVIDUAL_OPTION1", 1, 1, 2), new CharismaIndivOption("CHARISMA_INDIVIDUAL_OPTION2", 2, 2, 4), new CharismaIndivOption("CHARISMA_INDIVIDUAL_OPTION3", 3, 3, 8), new CharismaIndivOption("CHARISMA_INDIVIDUAL_OPTION4", 4, 4, 16), new CharismaIndivOption("CHARISMA_INDIVIDUAL_OPTION5", 5, 5, 32)});

        private CharismaIndivOptionMapping(String string, CharismaIndivOption[] charismaIndivOptionArray) {
            this.mappingName = string;
            this.options = charismaIndivOptionArray;
        }

        public CharismaIndivOption[] getOptions() {
            return this.options;
        }

        public String getMappingName() {
            return this.mappingName;
        }

        public int getHintsForMask(int n) {
            int n2 = 0;
            for (int i2 = 0; i2 < this.getOptions().length; ++i2) {
                n2 = this.getOptions()[i2].useMaskOnHint(n2, n);
            }
            return n2;
        }

        public CharismaIndivOption getDefaultOption() {
            return this.getOptions()[0];
        }

        public CharismaIndivOption getOptionByDsiID(int n) {
            for (int i2 = 0; i2 < this.getOptions().length; ++i2) {
                CharismaIndivOption charismaIndivOption = this.getOptions()[i2];
                if (!charismaIndivOption.hasDsiOption(n)) continue;
                return charismaIndivOption;
            }
            return this.getDefaultOption();
        }

        public CharismaIndivOption getOptionByID(int n) {
            for (int i2 = 0; i2 < this.getOptions().length; ++i2) {
                CharismaIndivOption charismaIndivOption = this.getOptions()[i2];
                if (!charismaIndivOption.hasOptionID(n)) continue;
                return charismaIndivOption;
            }
            return this.getDefaultOption();
        }
    }
}

