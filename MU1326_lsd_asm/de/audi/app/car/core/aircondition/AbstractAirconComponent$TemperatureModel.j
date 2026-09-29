.version 50 0 
.class super [249] 
.super [251] 
.field private static final [252] [253] 
.field private static final [254] [255] 
.field private static final [256] [257] 
.field private final [258] [259] 
.field private final [260] [261] 
.field private final [262] [263] 
.field private final [264] [265] 
.field private final [266] [267] 
.field private final [268] [269] 
.field private [270] [271] 
.field private [272] [273] 
.field private [274] [275] 
.field private [276] [277] 
.field private [278] [279] 
.field private final synthetic [280] [281] 

.method public [283] : [284] 
    .attribute [282] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [30] 
L5:     aload_0 
L6:     invokespecial [25] 
L9:     aload_0 
L10:    aconst_null 
L11:    putfield [31] 
L14:    aload_0 
L15:    aconst_null 
L16:    putfield [32] 
L19:    aload_0 
L20:    aconst_null 
L21:    putfield [33] 
L24:    aload_0 
L25:    aconst_null 
L26:    putfield [34] 
L29:    aload_0 
L30:    iconst_0 
L31:    putfield [35] 
L34:    aload_0 
L35:    aload_2 
L36:    putfield [31] 
L39:    aload_0 
L40:    aload_3 
L41:    putfield [32] 
L44:    aload_0 
L45:    aload 4 
L47:    putfield [33] 
L50:    aload_0 
L51:    aload 5 
L53:    putfield [34] 
L56:    aload_0 
L57:    fload 6 
L59:    putfield [36] 
L62:    aload_0 
L63:    fload 7 
L65:    putfield [37] 
L68:    aload_0 
L69:    fload 8 
L71:    putfield [38] 
L74:    aload_0 
L75:    fload 9 
L77:    putfield [39] 
L80:    aload_0 
L81:    fload 10 
L83:    putfield [40] 
L86:    aload_0 
L87:    fload 11 
L89:    putfield [41] 
L92:    return 
L93:    nop 
L94:    nop 
L95:    nop 
L96:    
    .end code 
.end method 

.method private [285] : [286] 
    .attribute [282] .code stack 3 locals 2 
L0:     iload_1 
L1:     aload_0 
L2:     getfield [12] 
L5:     invokeinterface [42] 0 
L10:    isub 
L11:    aload_0 
L12:    getfield [12] 
L15:    invokeinterface [43] 0 
L20:    idiv 
L21:    i2f 
L22:    fstore_2 
L23:    aload_0 
L24:    getfield [17] 
L27:    fload_2 
L28:    aload_0 
L29:    getfield [19] 
L32:    fmul 
L33:    fadd 
L34:    fstore_3 
L35:    fload_3 
L36:    aload_0 
L37:    getfield [17] 
L40:    aload_0 
L41:    getfield [18] 
L44:    invokestatic [2] 
L47:    areturn 
L48:    
    .end code 
.end method 

.method private [287] : [288] 
    .attribute [282] .code stack 3 locals 2 
L0:     iload_1 
L1:     aload_0 
L2:     getfield [13] 
L5:     invokeinterface [42] 0 
L10:    isub 
L11:    aload_0 
L12:    getfield [13] 
L15:    invokeinterface [43] 0 
L20:    idiv 
L21:    i2f 
L22:    fstore_2 
L23:    aload_0 
L24:    getfield [20] 
L27:    fload_2 
L28:    aload_0 
L29:    getfield [22] 
L32:    fmul 
L33:    fadd 
L34:    fstore_3 
L35:    fload_3 
L36:    aload_0 
L37:    getfield [20] 
L40:    aload_0 
L41:    getfield [21] 
L44:    invokestatic [2] 
L47:    areturn 
L48:    
    .end code 
.end method 

.method private [289] : [290] 
    .attribute [282] .code stack 4 locals 3 
L0:     fload_1 
L1:     fload_2 
L2:     fload_3 
L3:     invokestatic [2] 
L6:     fstore 5 
L8:     fload 5 
L10:    fload_2 
L11:    fcmpl 
L12:    ifne L19 
L15:    iconst_1 
L16:    goto L31 
L19:    fload 5 
L21:    fload_3 
L22:    fcmpl 
L23:    ifne L30 
L26:    iconst_2 
L27:    goto L31 
L30:    iconst_0 
L31:    istore 6 
L33:    new [44] 
L36:    dup 
L37:    fload_1 
L38:    iload 4 
L40:    invokespecial [26] 
L43:    astore 7 
L45:    aload_0 
L46:    getfield [14] 
L49:    iload 6 
L51:    invokeinterface [45] 0 
L56:    aload_0 
L57:    getfield [15] 
L60:    aload 7 
L62:    invokeinterface [46] 0 
L67:    return 
L68:    
    .end code 
.end method 

.method public interface [291] : [292] 
    .attribute [282] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [293] : [294] 
    .attribute [282] .code stack 5 locals 0 
L0:     aload_1 
L1:     invokevirtual [23] 
L4:     lookupswitch 
            0 : L32 
            1 : L98 
            default : L164 

L32:    aload_0 
L33:    aload_1 
L34:    invokevirtual [24] 
L37:    aload_0 
L38:    getfield [12] 
L41:    invokeinterface [42] 0 
L46:    aload_0 
L47:    getfield [12] 
L50:    invokeinterface [47] 0 
L55:    invokestatic [4] 
L58:    putfield [35] 
L61:    aload_0 
L62:    getfield [12] 
L65:    aload_0 
L66:    getfield [16] 
L69:    invokeinterface [48] 0 
L74:    aload_0 
L75:    aload_0 
L76:    aload_0 
L77:    getfield [16] 
L80:    invokespecial [27] 
L83:    aload_0 
L84:    getfield [17] 
L87:    aload_0 
L88:    getfield [18] 
L91:    iconst_1 
L92:    invokespecial [28] 
L95:    goto L164 
L98:    aload_0 
L99:    aload_1 
L100:   invokevirtual [24] 
L103:   aload_0 
L104:   getfield [13] 
L107:   invokeinterface [42] 0 
L112:   aload_0 
L113:   getfield [13] 
L116:   invokeinterface [47] 0 
L121:   invokestatic [4] 
L124:   putfield [35] 
L127:   aload_0 
L128:   getfield [13] 
L131:   aload_0 
L132:   getfield [16] 
L135:   invokeinterface [48] 0 
L140:   aload_0 
L141:   aload_0 
L142:   aload_0 
L143:   getfield [16] 
L146:   invokespecial [29] 
L149:   aload_0 
L150:   getfield [20] 
L153:   aload_0 
L154:   getfield [21] 
L157:   iconst_2 
L158:   invokespecial [28] 
L161:   goto L164 
L164:   return 
L165:   nop 
L166:   nop 
L167:   nop 
L168:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [49] [50] 
.const [3] = Class [51] 
.const [4] = Method [52] [53] 
.const [5] = Class [54] 
.const [6] = Class [55] 
.const [7] = Class [56] 
.const [8] = Class [57] 
.const [9] = Class [58] 
.const [10] = Class [59] 
.const [11] = Class [60] 
.const [12] = Field [61] [62] 
.const [13] = Field [63] [64] 
.const [14] = Field [65] [66] 
.const [15] = Field [67] [68] 
.const [16] = Field [69] [70] 
.const [17] = Field [71] [72] 
.const [18] = Field [73] [74] 
.const [19] = Field [75] [76] 
.const [20] = Field [77] [78] 
.const [21] = Field [79] [80] 
.const [22] = Field [81] [82] 
.const [23] = Method [83] [84] 
.const [24] = Method [85] [86] 
.const [25] = Method [87] [88] 
.const [26] = Method [89] [90] 
.const [27] = Method [91] [92] 
.const [28] = Method [93] [94] 
.const [29] = Method [95] [96] 
.const [30] = Field [97] [98] 
.const [31] = Field [99] [100] 
.const [32] = Field [101] [102] 
.const [33] = Field [103] [104] 
.const [34] = Field [105] [106] 
.const [35] = Field [107] [108] 
.const [36] = Field [109] [110] 
.const [37] = Field [111] [112] 
.const [38] = Field [113] [114] 
.const [39] = Field [115] [116] 
.const [40] = Field [117] [118] 
.const [41] = Field [119] [120] 
.const [42] = InterfaceMethod [121] [122] 
.const [43] = InterfaceMethod [123] [124] 
.const [44] = Class [125] 
.const [45] = InterfaceMethod [126] [127] 
.const [46] = InterfaceMethod [128] [129] 
.const [47] = InterfaceMethod [130] [131] 
.const [48] = InterfaceMethod [132] [133] 
.const [49] = Class [134] 
.const [50] = NameAndType [135] [136] 
.const [51] = Utf8 de/audi/atip/metrics/Temperature 
.const [52] = Class [137] 
.const [53] = NameAndType [138] [139] 
.const [54] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent$TemperatureModel 
.const [55] = Utf8 java/lang/Object 
.const [56] = Utf8 de/audi/atip/hmi/modelaccess/RangeModelApp 
.const [57] = Utf8 de/audi/app/car/common/comp/AbstractCarComponent 
.const [58] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [59] = Utf8 de/audi/atip/hmi/modelaccess/MetricsModelApp 
.const [60] = Utf8 org/dsi/ifc/caraircondition/AirconTemp 
.const [61] = Class [140] 
.const [62] = NameAndType [141] [142] 
.const [63] = Class [143] 
.const [64] = NameAndType [144] [145] 
.const [65] = Class [146] 
.const [66] = NameAndType [147] [148] 
.const [67] = Class [149] 
.const [68] = NameAndType [150] [151] 
.const [69] = Class [152] 
.const [70] = NameAndType [153] [154] 
.const [71] = Class [155] 
.const [72] = NameAndType [156] [157] 
.const [73] = Class [158] 
.const [74] = NameAndType [159] [160] 
.const [75] = Class [161] 
.const [76] = NameAndType [162] [163] 
.const [77] = Class [164] 
.const [78] = NameAndType [165] [166] 
.const [79] = Class [167] 
.const [80] = NameAndType [168] [169] 
.const [81] = Class [170] 
.const [82] = NameAndType [171] [172] 
.const [83] = Class [173] 
.const [84] = NameAndType [174] [175] 
.const [85] = Class [176] 
.const [86] = NameAndType [177] [178] 
.const [87] = Class [179] 
.const [88] = NameAndType [180] [181] 
.const [89] = Class [182] 
.const [90] = NameAndType [183] [184] 
.const [91] = Class [185] 
.const [92] = NameAndType [186] [187] 
.const [93] = Class [188] 
.const [94] = NameAndType [189] [190] 
.const [95] = Class [191] 
.const [96] = NameAndType [192] [193] 
.const [97] = Class [194] 
.const [98] = NameAndType [195] [196] 
.const [99] = Class [197] 
.const [100] = NameAndType [198] [199] 
.const [101] = Class [200] 
.const [102] = NameAndType [201] [202] 
.const [103] = Class [203] 
.const [104] = NameAndType [204] [205] 
.const [105] = Class [206] 
.const [106] = NameAndType [207] [208] 
.const [107] = Class [209] 
.const [108] = NameAndType [210] [211] 
.const [109] = Class [212] 
.const [110] = NameAndType [213] [214] 
.const [111] = Class [215] 
.const [112] = NameAndType [216] [217] 
.const [113] = Class [218] 
.const [114] = NameAndType [219] [220] 
.const [115] = Class [221] 
.const [116] = NameAndType [222] [223] 
.const [117] = Class [224] 
.const [118] = NameAndType [225] [226] 
.const [119] = Class [227] 
.const [120] = NameAndType [228] [229] 
.const [121] = Class [230] 
.const [122] = NameAndType [231] [232] 
.const [123] = Class [233] 
.const [124] = NameAndType [234] [235] 
.const [125] = Utf8 de/audi/atip/metrics/Temperature 
.const [126] = Class [236] 
.const [127] = NameAndType [237] [238] 
.const [128] = Class [239] 
.const [129] = NameAndType [240] [241] 
.const [130] = Class [242] 
.const [131] = NameAndType [243] [244] 
.const [132] = Class [245] 
.const [133] = NameAndType [246] [247] 
.const [134] = Utf8 de/audi/app/car/common/comp/AbstractCarComponent 
.const [135] = Utf8 clip 
.const [136] = Utf8 (FFF)F 
.const [137] = Utf8 de/audi/app/car/common/comp/AbstractCarComponent 
.const [138] = Utf8 clip 
.const [139] = Utf8 (III)I 
.const [140] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent$TemperatureModel 
.const [141] = Utf8 celsiusRange 
.const [142] = Utf8 Lde/audi/atip/hmi/modelaccess/RangeModelApp; 
.const [143] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent$TemperatureModel 
.const [144] = Utf8 fahrenheitRange 
.const [145] = Utf8 Lde/audi/atip/hmi/modelaccess/RangeModelApp; 
.const [146] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent$TemperatureModel 
.const [147] = Utf8 labelChoice 
.const [148] = Utf8 Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [149] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent$TemperatureModel 
.const [150] = Utf8 tempMetric 
.const [151] = Utf8 Lde/audi/atip/hmi/modelaccess/MetricsModelApp; 
.const [152] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent$TemperatureModel 
.const [153] = Utf8 currentTemperature 
.const [154] = Utf8 I 
.const [155] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent$TemperatureModel 
.const [156] = Utf8 tempStartCelsius 
.const [157] = Utf8 F 
.const [158] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent$TemperatureModel 
.const [159] = Utf8 tempEndCelsius 
.const [160] = Utf8 F 
.const [161] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent$TemperatureModel 
.const [162] = Utf8 tempStepCelsius 
.const [163] = Utf8 F 
.const [164] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent$TemperatureModel 
.const [165] = Utf8 tempStartFahrenheit 
.const [166] = Utf8 F 
.const [167] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent$TemperatureModel 
.const [168] = Utf8 tempEndFahrenheit 
.const [169] = Utf8 F 
.const [170] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent$TemperatureModel 
.const [171] = Utf8 tempStepFahrenheit 
.const [172] = Utf8 F 
.const [173] = Utf8 org/dsi/ifc/caraircondition/AirconTemp 
.const [174] = Utf8 getTempUnit 
.const [175] = Utf8 ()I 
.const [176] = Utf8 org/dsi/ifc/caraircondition/AirconTemp 
.const [177] = Utf8 getTempValue 
.const [178] = Utf8 ()I 
.const [179] = Utf8 java/lang/Object 
.const [180] = Utf8 <init> 
.const [181] = Utf8 ()V 
.const [182] = Utf8 de/audi/atip/metrics/Temperature 
.const [183] = Utf8 <init> 
.const [184] = Utf8 (FI)V 
.const [185] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent$TemperatureModel 
.const [186] = Utf8 dsiToCelsius 
.const [187] = Utf8 (I)F 
.const [188] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent$TemperatureModel 
.const [189] = Utf8 updateTemperatureModels 
.const [190] = Utf8 (FFFI)V 
.const [191] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent$TemperatureModel 
.const [192] = Utf8 dsiToFahrenheit 
.const [193] = Utf8 (I)F 
.const [194] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent$TemperatureModel 
.const [195] = Utf8 this$0 
.const [196] = Utf8 Lde/audi/app/car/core/aircondition/AbstractAirconComponent; 
.const [197] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent$TemperatureModel 
.const [198] = Utf8 celsiusRange 
.const [199] = Utf8 Lde/audi/atip/hmi/modelaccess/RangeModelApp; 
.const [200] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent$TemperatureModel 
.const [201] = Utf8 fahrenheitRange 
.const [202] = Utf8 Lde/audi/atip/hmi/modelaccess/RangeModelApp; 
.const [203] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent$TemperatureModel 
.const [204] = Utf8 labelChoice 
.const [205] = Utf8 Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [206] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent$TemperatureModel 
.const [207] = Utf8 tempMetric 
.const [208] = Utf8 Lde/audi/atip/hmi/modelaccess/MetricsModelApp; 
.const [209] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent$TemperatureModel 
.const [210] = Utf8 currentTemperature 
.const [211] = Utf8 I 
.const [212] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent$TemperatureModel 
.const [213] = Utf8 tempStartCelsius 
.const [214] = Utf8 F 
.const [215] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent$TemperatureModel 
.const [216] = Utf8 tempEndCelsius 
.const [217] = Utf8 F 
.const [218] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent$TemperatureModel 
.const [219] = Utf8 tempStepCelsius 
.const [220] = Utf8 F 
.const [221] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent$TemperatureModel 
.const [222] = Utf8 tempStartFahrenheit 
.const [223] = Utf8 F 
.const [224] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent$TemperatureModel 
.const [225] = Utf8 tempEndFahrenheit 
.const [226] = Utf8 F 
.const [227] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent$TemperatureModel 
.const [228] = Utf8 tempStepFahrenheit 
.const [229] = Utf8 F 
.const [230] = Utf8 de/audi/atip/hmi/modelaccess/RangeModelApp 
.const [231] = Utf8 getMinimum 
.const [232] = Utf8 ()I 
.const [233] = Utf8 de/audi/atip/hmi/modelaccess/RangeModelApp 
.const [234] = Utf8 getStep 
.const [235] = Utf8 ()I 
.const [236] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [237] = Utf8 setValue 
.const [238] = Utf8 (I)V 
.const [239] = Utf8 de/audi/atip/hmi/modelaccess/MetricsModelApp 
.const [240] = Utf8 setMetric 
.const [241] = Utf8 (Lde/audi/atip/metrics/AbstractMetrics;)V 
.const [242] = Utf8 de/audi/atip/hmi/modelaccess/RangeModelApp 
.const [243] = Utf8 getMaximum 
.const [244] = Utf8 ()I 
.const [245] = Utf8 de/audi/atip/hmi/modelaccess/RangeModelApp 
.const [246] = Utf8 setValue 
.const [247] = Utf8 (I)V 
.const [248] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent$TemperatureModel 
.const [249] = Class [248] 
.const [250] = Utf8 java/lang/Object 
.const [251] = Class [250] 
.const [252] = Utf8 LABEL_TEMP_VALUE 
.const [253] = Utf8 I 
.const [254] = Utf8 LABEL_LO_SYMBOL 
.const [255] = Utf8 I 
.const [256] = Utf8 LABEL_HI_SYMBOL 
.const [257] = Utf8 I 
.const [258] = Utf8 tempStartCelsius 
.const [259] = Utf8 F 
.const [260] = Utf8 tempEndCelsius 
.const [261] = Utf8 F 
.const [262] = Utf8 tempStepCelsius 
.const [263] = Utf8 F 
.const [264] = Utf8 tempStartFahrenheit 
.const [265] = Utf8 F 
.const [266] = Utf8 tempEndFahrenheit 
.const [267] = Utf8 F 
.const [268] = Utf8 tempStepFahrenheit 
.const [269] = Utf8 F 
.const [270] = Utf8 celsiusRange 
.const [271] = Utf8 Lde/audi/atip/hmi/modelaccess/RangeModelApp; 
.const [272] = Utf8 fahrenheitRange 
.const [273] = Utf8 Lde/audi/atip/hmi/modelaccess/RangeModelApp; 
.const [274] = Utf8 labelChoice 
.const [275] = Utf8 Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [276] = Utf8 tempMetric 
.const [277] = Utf8 Lde/audi/atip/hmi/modelaccess/MetricsModelApp; 
.const [278] = Utf8 currentTemperature 
.const [279] = Utf8 I 
.const [280] = Utf8 this$0 
.const [281] = Utf8 Lde/audi/app/car/core/aircondition/AbstractAirconComponent; 
.const [282] = Utf8 Code 
.const [283] = Utf8 <init> 
.const [284] = Utf8 (Lde/audi/app/car/core/aircondition/AbstractAirconComponent;Lde/audi/atip/hmi/modelaccess/RangeModelApp;Lde/audi/atip/hmi/modelaccess/RangeModelApp;Lde/audi/atip/hmi/modelaccess/ChoiceModelApp;Lde/audi/atip/hmi/modelaccess/MetricsModelApp;FFFFFF)V 
.const [285] = Utf8 dsiToCelsius 
.const [286] = Utf8 (I)F 
.const [287] = Utf8 dsiToFahrenheit 
.const [288] = Utf8 (I)F 
.const [289] = Utf8 updateTemperatureModels 
.const [290] = Utf8 (FFFI)V 
.const [291] = Utf8 getCurrentTemperature 
.const [292] = Utf8 ()I 
.const [293] = Utf8 updateHMI 
.const [294] = Utf8 (Lorg/dsi/ifc/caraircondition/AirconTemp;)V 
.end class 
