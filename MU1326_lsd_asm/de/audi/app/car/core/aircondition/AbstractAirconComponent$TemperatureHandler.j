.version 50 0 
.class public super [265] 
.super [267] 
.field private final [268] [269] 
.field private final [270] [271] 
.field private final [272] [273] 
.field private final synthetic [274] [275] 

.method public [277] : [278] 
    .attribute [276] .code stack 14 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [49] 
L5:     aload_0 
L6:     invokespecial [45] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [50] 
L14:    aload_0 
L15:    iload_3 
L16:    putfield [51] 
L19:    aload_0 
L20:    new [52] 
L23:    dup 
L24:    aload_1 
L25:    aload_1 
L26:    iload 4 
L28:    invokestatic [3] 
L31:    aload_1 
L32:    iload 5 
L34:    invokestatic [4] 
L37:    aload_1 
L38:    iload 6 
L40:    invokestatic [5] 
L43:    aload_1 
L44:    iload 7 
L46:    invokestatic [6] 
L49:    aload_1 
L50:    invokevirtual [28] 
L53:    invokevirtual [29] 
L56:    aload_1 
L57:    invokevirtual [28] 
L60:    invokevirtual [30] 
L63:    aload_1 
L64:    invokevirtual [28] 
L67:    invokevirtual [31] 
L70:    aload_1 
L71:    invokevirtual [28] 
L74:    invokevirtual [32] 
L77:    aload_1 
L78:    invokevirtual [28] 
L81:    invokevirtual [33] 
L84:    aload_1 
L85:    invokevirtual [28] 
L88:    invokevirtual [34] 
L91:    invokespecial [46] 
L94:    putfield [53] 
L97:    return 
L98:    nop 
L99:    nop 
L100:   
    .end code 
.end method 

.method private [279] : [280] 
    .attribute [276] .code stack 5 locals 1 
L0:     aload_0 
L1:     getfield [25] 
L4:     aload_0 
L5:     getfield [27] 
L8:     invokevirtual [36] 
L11:    istore_2 
L12:    iconst_m1 
L13:    iload_2 
L14:    if_icmpeq L54 
L17:    aload_0 
L18:    getfield [25] 
L21:    iconst_1 
L22:    invokevirtual [37] 
L25:    ldc [7] 
L27:    ldc [8] 
L29:    iload_2 
L30:    invokestatic [9] 
L33:    aload_1 
L34:    invokevirtual [38] 
L37:    invokevirtual [39] 
L40:    aload_0 
L41:    getfield [25] 
L44:    invokevirtual [40] 
L47:    iload_2 
L48:    aload_1 
L49:    invokeinterface [54] 0 
L54:    return 
L55:    nop 
L56:    
    .end code 
.end method 

.method public [281] : [282] 
    .attribute [276] .code stack 8 locals 3 
L0:     invokestatic [10] 
L3:     invokestatic [11] 
L6:     istore_3 
L7:     iload_2 
L8:     invokestatic [11] 
L11:    istore 4 
L13:    iconst_m1 
L14:    iload_3 
L15:    if_icmpeq L63 
L18:    iload_3 
L19:    iload 4 
L21:    if_icmpne L63 
L24:    new [55] 
L27:    dup 
L28:    invokespecial [47] 
L31:    astore 5 
L33:    aload 5 
L35:    aload_0 
L36:    getfield [35] 
L39:    invokevirtual [41] 
L42:    iload_1 
L43:    iadd 
L44:    putfield [56] 
L47:    aload 5 
L49:    iload 4 
L51:    putfield [57] 
L54:    aload_0 
L55:    aload 5 
L57:    invokespecial [48] 
L60:    goto L87 
L63:    aload_0 
L64:    getfield [25] 
L67:    invokevirtual [42] 
L70:    ldc [13] 
L72:    ldc [14] 
L74:    aload_0 
L75:    getfield [26] 
L78:    iload_3 
L79:    i2l 
L80:    iload 4 
L82:    i2l 
L83:    invokevirtual [43] 
L86:    pop 
L87:    return 
L88:    
    .end code 
.end method 

.method public [283] : [284] 
    .attribute [276] .code stack 8 locals 3 
L0:     invokestatic [10] 
L3:     invokestatic [11] 
L6:     istore_3 
L7:     iload_2 
L8:     invokestatic [11] 
L11:    istore 4 
L13:    iconst_m1 
L14:    iload_3 
L15:    if_icmpeq L63 
L18:    iload_3 
L19:    iload 4 
L21:    if_icmpne L63 
L24:    new [55] 
L27:    dup 
L28:    invokespecial [47] 
L31:    astore 5 
L33:    aload 5 
L35:    aload_0 
L36:    getfield [35] 
L39:    invokevirtual [41] 
L42:    iload_1 
L43:    isub 
L44:    putfield [56] 
L47:    aload 5 
L49:    iload 4 
L51:    putfield [57] 
L54:    aload_0 
L55:    aload 5 
L57:    invokespecial [48] 
L60:    goto L87 
L63:    aload_0 
L64:    getfield [25] 
L67:    invokevirtual [42] 
L70:    ldc [13] 
L72:    ldc [15] 
L74:    aload_0 
L75:    getfield [26] 
L78:    iload_3 
L79:    i2l 
L80:    iload 4 
L82:    i2l 
L83:    invokevirtual [43] 
L86:    pop 
L87:    return 
L88:    
    .end code 
.end method 

.method public [285] : [286] 
    .attribute [276] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [35] 
L4:     aload_1 
L5:     invokevirtual [44] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [58] 
.const [3] = Method [59] [60] 
.const [4] = Method [61] [62] 
.const [5] = Method [63] [64] 
.const [6] = Method [65] [66] 
.const [7] = Int 1078071040 
.const [8] = String [67] 
.const [9] = Method [68] [69] 
.const [10] = Method [70] [71] 
.const [11] = Method [72] [73] 
.const [12] = Class [74] 
.const [13] = Int -1601830656 
.const [14] = String [75] 
.const [15] = String [76] 
.const [16] = Class [77] 
.const [17] = Class [78] 
.const [18] = Class [79] 
.const [19] = Class [80] 
.const [20] = Class [81] 
.const [21] = Class [82] 
.const [22] = Class [83] 
.const [23] = Class [84] 
.const [24] = Class [85] 
.const [25] = Field [86] [87] 
.const [26] = Field [88] [89] 
.const [27] = Field [90] [91] 
.const [28] = Method [92] [93] 
.const [29] = Method [94] [95] 
.const [30] = Method [96] [97] 
.const [31] = Method [98] [99] 
.const [32] = Method [100] [101] 
.const [33] = Method [102] [103] 
.const [34] = Method [104] [105] 
.const [35] = Field [106] [107] 
.const [36] = Method [108] [109] 
.const [37] = Method [110] [111] 
.const [38] = Method [112] [113] 
.const [39] = Method [114] [115] 
.const [40] = Method [116] [117] 
.const [41] = Method [118] [119] 
.const [42] = Method [120] [121] 
.const [43] = Method [122] [123] 
.const [44] = Method [124] [125] 
.const [45] = Method [126] [127] 
.const [46] = Method [128] [129] 
.const [47] = Method [130] [131] 
.const [48] = Method [132] [133] 
.const [49] = Field [134] [135] 
.const [50] = Field [136] [137] 
.const [51] = Field [138] [139] 
.const [52] = Class [140] 
.const [53] = Field [141] [142] 
.const [54] = InterfaceMethod [143] [144] 
.const [55] = Class [145] 
.const [56] = Field [146] [147] 
.const [57] = Field [148] [149] 
.const [58] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent$TemperatureModel 
.const [59] = Class [150] 
.const [60] = NameAndType [151] [152] 
.const [61] = Class [153] 
.const [62] = NameAndType [154] [155] 
.const [63] = Class [156] 
.const [64] = NameAndType [157] [158] 
.const [65] = Class [159] 
.const [66] = NameAndType [160] [161] 
.const [67] = Utf8 '---> DSI.setAirconTempZone(%1, %2)' 
.const [68] = Class [162] 
.const [69] = NameAndType [163] [164] 
.const [70] = Class [165] 
.const [71] = NameAndType [166] [167] 
.const [72] = Class [168] 
.const [73] = NameAndType [169] [170] 
.const [74] = Utf8 org/dsi/ifc/caraircondition/AirconTemp 
.const [75] = Utf8 "[TemperatureHandler(%1)#incrementTemperature] Trying to update DSI with wrong unit: Master='%2', Model='%3'" 
.const [76] = Utf8 "[TemperatureHandler(%1)#decrementTemperature] Trying to update DSI with wrong unit: Master='%2', Model='%3'" 
.const [77] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent$TemperatureHandler 
.const [78] = Utf8 java/lang/Object 
.const [79] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent 
.const [80] = Utf8 de/audi/app/car/core/aircondition/AirconConfig 
.const [81] = Utf8 java/lang/Integer 
.const [82] = Utf8 de/audi/atip/log/LogChannel 
.const [83] = Utf8 org/dsi/ifc/caraircondition/DSICarAirCondition 
.const [84] = Utf8 de/audi/atip/metrics/Temperature 
.const [85] = Utf8 de/audi/app/car/common/util/ValueConverterCollection 
.const [86] = Class [171] 
.const [87] = NameAndType [172] [173] 
.const [88] = Class [174] 
.const [89] = NameAndType [175] [176] 
.const [90] = Class [177] 
.const [91] = NameAndType [178] [179] 
.const [92] = Class [180] 
.const [93] = NameAndType [181] [182] 
.const [94] = Class [183] 
.const [95] = NameAndType [184] [185] 
.const [96] = Class [186] 
.const [97] = NameAndType [187] [188] 
.const [98] = Class [189] 
.const [99] = NameAndType [190] [191] 
.const [100] = Class [192] 
.const [101] = NameAndType [193] [194] 
.const [102] = Class [195] 
.const [103] = NameAndType [196] [197] 
.const [104] = Class [198] 
.const [105] = NameAndType [199] [200] 
.const [106] = Class [201] 
.const [107] = NameAndType [202] [203] 
.const [108] = Class [204] 
.const [109] = NameAndType [205] [206] 
.const [110] = Class [207] 
.const [111] = NameAndType [208] [209] 
.const [112] = Class [210] 
.const [113] = NameAndType [211] [212] 
.const [114] = Class [213] 
.const [115] = NameAndType [214] [215] 
.const [116] = Class [216] 
.const [117] = NameAndType [217] [218] 
.const [118] = Class [219] 
.const [119] = NameAndType [220] [221] 
.const [120] = Class [222] 
.const [121] = NameAndType [223] [224] 
.const [122] = Class [225] 
.const [123] = NameAndType [226] [227] 
.const [124] = Class [228] 
.const [125] = NameAndType [229] [230] 
.const [126] = Class [231] 
.const [127] = NameAndType [232] [233] 
.const [128] = Class [234] 
.const [129] = NameAndType [235] [236] 
.const [130] = Class [237] 
.const [131] = NameAndType [238] [239] 
.const [132] = Class [240] 
.const [133] = NameAndType [241] [242] 
.const [134] = Class [243] 
.const [135] = NameAndType [244] [245] 
.const [136] = Class [246] 
.const [137] = NameAndType [247] [248] 
.const [138] = Class [249] 
.const [139] = NameAndType [250] [251] 
.const [140] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent$TemperatureModel 
.const [141] = Class [252] 
.const [142] = NameAndType [253] [254] 
.const [143] = Class [255] 
.const [144] = NameAndType [256] [257] 
.const [145] = Utf8 org/dsi/ifc/caraircondition/AirconTemp 
.const [146] = Class [258] 
.const [147] = NameAndType [259] [260] 
.const [148] = Class [261] 
.const [149] = NameAndType [262] [263] 
.const [150] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent 
.const [151] = Utf8 access$000 
.const [152] = Utf8 (Lde/audi/app/car/core/aircondition/AbstractAirconComponent;I)Lde/audi/atip/hmi/modelaccess/RangeModelApp; 
.const [153] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent 
.const [154] = Utf8 access$100 
.const [155] = Utf8 (Lde/audi/app/car/core/aircondition/AbstractAirconComponent;I)Lde/audi/atip/hmi/modelaccess/RangeModelApp; 
.const [156] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent 
.const [157] = Utf8 access$200 
.const [158] = Utf8 (Lde/audi/app/car/core/aircondition/AbstractAirconComponent;I)Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [159] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent 
.const [160] = Utf8 access$300 
.const [161] = Utf8 (Lde/audi/app/car/core/aircondition/AbstractAirconComponent;I)Lde/audi/atip/hmi/modelaccess/MetricsModelApp; 
.const [162] = Utf8 java/lang/Integer 
.const [163] = Utf8 toString 
.const [164] = Utf8 (I)Ljava/lang/String; 
.const [165] = Utf8 de/audi/atip/metrics/Temperature 
.const [166] = Utf8 getSystemUnit 
.const [167] = Utf8 ()I 
.const [168] = Utf8 de/audi/app/car/common/util/ValueConverterCollection 
.const [169] = Utf8 convertTemperatureUnitHMI2DSI 
.const [170] = Utf8 (I)I 
.const [171] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent$TemperatureHandler 
.const [172] = Utf8 this$0 
.const [173] = Utf8 Lde/audi/app/car/core/aircondition/AbstractAirconComponent; 
.const [174] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent$TemperatureHandler 
.const [175] = Utf8 name 
.const [176] = Utf8 Ljava/lang/String; 
.const [177] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent$TemperatureHandler 
.const [178] = Utf8 hmiZone 
.const [179] = Utf8 I 
.const [180] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent 
.const [181] = Utf8 getConfig 
.const [182] = Utf8 ()Lde/audi/app/car/core/aircondition/AirconConfig; 
.const [183] = Utf8 de/audi/app/car/core/aircondition/AirconConfig 
.const [184] = Utf8 getTemperatureStartCelsius 
.const [185] = Utf8 ()F 
.const [186] = Utf8 de/audi/app/car/core/aircondition/AirconConfig 
.const [187] = Utf8 getTemperatureEndCelsius 
.const [188] = Utf8 ()F 
.const [189] = Utf8 de/audi/app/car/core/aircondition/AirconConfig 
.const [190] = Utf8 getTemperatureStepCelsius 
.const [191] = Utf8 ()F 
.const [192] = Utf8 de/audi/app/car/core/aircondition/AirconConfig 
.const [193] = Utf8 getTemperatureStartFahrenheit 
.const [194] = Utf8 ()F 
.const [195] = Utf8 de/audi/app/car/core/aircondition/AirconConfig 
.const [196] = Utf8 getTemperatureEndFahrenheit 
.const [197] = Utf8 ()F 
.const [198] = Utf8 de/audi/app/car/core/aircondition/AirconConfig 
.const [199] = Utf8 getTemperatureStepFahrenheit 
.const [200] = Utf8 ()F 
.const [201] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent$TemperatureHandler 
.const [202] = Utf8 temperatureModel 
.const [203] = Utf8 Lde/audi/app/car/core/aircondition/AbstractAirconComponent$TemperatureModel; 
.const [204] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent 
.const [205] = Utf8 convertZoneHMI2DSI 
.const [206] = Utf8 (I)I 
.const [207] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent 
.const [208] = Utf8 getLogChannel 
.const [209] = Utf8 (I)Lde/audi/atip/log/LogChannel; 
.const [210] = Utf8 org/dsi/ifc/caraircondition/AirconTemp 
.const [211] = Utf8 toString 
.const [212] = Utf8 ()Ljava/lang/String; 
.const [213] = Utf8 de/audi/atip/log/LogChannel 
.const [214] = Utf8 log 
.const [215] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [216] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent 
.const [217] = Utf8 getDSI 
.const [218] = Utf8 ()Lorg/dsi/ifc/caraircondition/DSICarAirCondition; 
.const [219] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent$TemperatureModel 
.const [220] = Utf8 getCurrentTemperature 
.const [221] = Utf8 ()I 
.const [222] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent 
.const [223] = Utf8 getLogChannel 
.const [224] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [225] = Utf8 de/audi/atip/log/LogChannel 
.const [226] = Utf8 log 
.const [227] = Utf8 (ILjava/lang/String;Ljava/lang/Object;JJ)Z 
.const [228] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent$TemperatureModel 
.const [229] = Utf8 updateHMI 
.const [230] = Utf8 (Lorg/dsi/ifc/caraircondition/AirconTemp;)V 
.const [231] = Utf8 java/lang/Object 
.const [232] = Utf8 <init> 
.const [233] = Utf8 ()V 
.const [234] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent$TemperatureModel 
.const [235] = Utf8 <init> 
.const [236] = Utf8 (Lde/audi/app/car/core/aircondition/AbstractAirconComponent;Lde/audi/atip/hmi/modelaccess/RangeModelApp;Lde/audi/atip/hmi/modelaccess/RangeModelApp;Lde/audi/atip/hmi/modelaccess/ChoiceModelApp;Lde/audi/atip/hmi/modelaccess/MetricsModelApp;FFFFFF)V 
.const [237] = Utf8 org/dsi/ifc/caraircondition/AirconTemp 
.const [238] = Utf8 <init> 
.const [239] = Utf8 ()V 
.const [240] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent$TemperatureHandler 
.const [241] = Utf8 callDSISetAirconTempZone 
.const [242] = Utf8 (Lorg/dsi/ifc/caraircondition/AirconTemp;)V 
.const [243] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent$TemperatureHandler 
.const [244] = Utf8 this$0 
.const [245] = Utf8 Lde/audi/app/car/core/aircondition/AbstractAirconComponent; 
.const [246] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent$TemperatureHandler 
.const [247] = Utf8 name 
.const [248] = Utf8 Ljava/lang/String; 
.const [249] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent$TemperatureHandler 
.const [250] = Utf8 hmiZone 
.const [251] = Utf8 I 
.const [252] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent$TemperatureHandler 
.const [253] = Utf8 temperatureModel 
.const [254] = Utf8 Lde/audi/app/car/core/aircondition/AbstractAirconComponent$TemperatureModel; 
.const [255] = Utf8 org/dsi/ifc/caraircondition/DSICarAirCondition 
.const [256] = Utf8 setAirconTempZone 
.const [257] = Utf8 (ILorg/dsi/ifc/caraircondition/AirconTemp;)V 
.const [258] = Utf8 org/dsi/ifc/caraircondition/AirconTemp 
.const [259] = Utf8 tempValue 
.const [260] = Utf8 I 
.const [261] = Utf8 org/dsi/ifc/caraircondition/AirconTemp 
.const [262] = Utf8 tempUnit 
.const [263] = Utf8 I 
.const [264] = Utf8 de/audi/app/car/core/aircondition/AbstractAirconComponent$TemperatureHandler 
.const [265] = Class [264] 
.const [266] = Utf8 java/lang/Object 
.const [267] = Class [266] 
.const [268] = Utf8 name 
.const [269] = Utf8 Ljava/lang/String; 
.const [270] = Utf8 hmiZone 
.const [271] = Utf8 I 
.const [272] = Utf8 temperatureModel 
.const [273] = Utf8 Lde/audi/app/car/core/aircondition/AbstractAirconComponent$TemperatureModel; 
.const [274] = Utf8 this$0 
.const [275] = Utf8 Lde/audi/app/car/core/aircondition/AbstractAirconComponent; 
.const [276] = Utf8 Code 
.const [277] = Utf8 <init> 
.const [278] = Utf8 (Lde/audi/app/car/core/aircondition/AbstractAirconComponent;Ljava/lang/String;IIIII)V 
.const [279] = Utf8 callDSISetAirconTempZone 
.const [280] = Utf8 (Lorg/dsi/ifc/caraircondition/AirconTemp;)V 
.const [281] = Utf8 incrementTemperature 
.const [282] = Utf8 (II)V 
.const [283] = Utf8 decrementTemperature 
.const [284] = Utf8 (II)V 
.const [285] = Utf8 updateTemperature 
.const [286] = Utf8 (Lorg/dsi/ifc/caraircondition/AirconTemp;)V 
.end class 
