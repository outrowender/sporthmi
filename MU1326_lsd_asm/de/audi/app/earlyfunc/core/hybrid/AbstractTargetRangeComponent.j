.version 50 0 
.class public super abstract [205] 
.super [207] 
.field private [208] [209] 
.field private static final [210] [211] 
.field public static final [212] [213] 

.method public [215] : [216] 
    .attribute [214] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial [41] 
L6:     aload_0 
L7:     invokevirtual [22] 
L10:    ldc [2] 
L12:    ldc [3] 
L14:    invokevirtual [23] 
L17:    pop 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [217] : [218] 
    .attribute [214] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     ldc [4] 
L4:     invokespecial [41] 
L7:     return 
L8:     
    .end code 
.end method 

.method public [219] : [220] 
    .attribute [214] .code stack 1 locals 0 
L0:     aconst_null 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [221] : [222] 
    .attribute [214] .code stack 11 locals 0 
L0:     iconst_1 
L1:     anewarray [5] 
L4:     dup 
L5:     iconst_0 
L6:     new [45] 
L9:     dup 
L10:    iconst_0 
L11:    iconst_1 
L12:    newarray int 
L14:    dup 
L15:    iconst_0 
L16:    iconst_4 
L17:    iastore 
L18:    iconst_2 
L19:    newarray int 
L21:    dup 
L22:    iconst_0 
L23:    bipush 8 
L25:    iastore 
L26:    dup 
L27:    iconst_1 
L28:    bipush 9 
L30:    iastore 
L31:    invokespecial [42] 
L34:    aastore 
L35:    areturn 
L36:    
    .end code 
.end method 

.method public [223] : [224] 
    .attribute [214] .code stack 1 locals 0 
L0:     aconst_null 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method protected enum [225] : [226] 
    .attribute [214] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method protected enum [227] : [228] 
    .attribute [214] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method protected enum [229] : [230] 
    .attribute [214] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method protected enum [231] : [232] 
    .attribute [214] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [233] : [234] 
    .attribute [214] .code stack 6 locals 0 
L0:     aload_0 
L1:     invokevirtual [22] 
L4:     invokevirtual [24] 
L7:     ifeq L41 
L10:    aload_0 
L11:    invokevirtual [22] 
L14:    ldc [2] 
L16:    ldc [6] 
L18:    aload_1 
L19:    ifnull L33 
L22:    aload_0 
L23:    aload_1 
L24:    invokevirtual [25] 
L27:    invokevirtual [26] 
L30:    goto L35 
L33:    ldc [7] 
L35:    iload_2 
L36:    i2l 
L37:    invokevirtual [27] 
L40:    pop 
L41:    iload_2 
L42:    iconst_1 
L43:    if_icmpne L67 
L46:    aload_1 
L47:    ifnull L67 
L50:    aload_0 
L51:    aload_1 
L52:    putfield [46] 
L55:    aload_0 
L56:    aload_0 
L57:    getfield [28] 
L60:    invokevirtual [29] 
L63:    aload_0 
L64:    invokevirtual [30] 
L67:    return 
L68:    
    .end code 
.end method 

.method public [235] : [236] 
    .attribute [214] .code stack 6 locals 0 
L0:     aload_0 
L1:     invokevirtual [22] 
L4:     ldc [2] 
L6:     ldc [8] 
L8:     aload_1 
L9:     iload_2 
L10:    i2l 
L11:    invokevirtual [27] 
L14:    pop 
L15:    iload_2 
L16:    iconst_1 
L17:    if_icmpne L74 
L20:    aload_0 
L21:    getfield [28] 
L24:    invokevirtual [31] 
L27:    ifnull L74 
L30:    aload_0 
L31:    getfield [28] 
L34:    invokevirtual [31] 
L37:    getfield [32] 
L40:    iconst_3 
L41:    if_icmpne L74 
L44:    aload_0 
L45:    aload_1 
L46:    invokespecial [43] 
L49:    aload_0 
L50:    invokevirtual [22] 
L53:    ldc [2] 
L55:    ldc [9] 
L57:    aload_1 
L58:    invokevirtual [33] 
L61:    i2l 
L62:    invokevirtual [34] 
L65:    pop 
L66:    aload_0 
L67:    aload_1 
L68:    invokevirtual [33] 
L71:    invokevirtual [35] 
L74:    return 
L75:    nop 
L76:    
    .end code 
.end method 

.method public [237] : [238] 
    .attribute [214] .code stack 6 locals 0 
L0:     aload_0 
L1:     invokevirtual [22] 
L4:     ldc [2] 
L6:     ldc [10] 
L8:     aload_1 
L9:     iload_2 
L10:    i2l 
L11:    invokevirtual [27] 
L14:    pop 
L15:    iload_2 
L16:    iconst_1 
L17:    if_icmpne L74 
L20:    aload_0 
L21:    getfield [28] 
L24:    invokevirtual [31] 
L27:    ifnull L74 
L30:    aload_0 
L31:    getfield [28] 
L34:    invokevirtual [31] 
L37:    getfield [36] 
L40:    iconst_3 
L41:    if_icmpne L74 
L44:    aload_0 
L45:    aload_1 
L46:    invokespecial [43] 
L49:    aload_0 
L50:    invokevirtual [22] 
L53:    ldc [2] 
L55:    ldc [11] 
L57:    aload_1 
L58:    invokevirtual [33] 
L61:    i2l 
L62:    invokevirtual [34] 
L65:    pop 
L66:    aload_0 
L67:    aload_1 
L68:    invokevirtual [33] 
L71:    invokevirtual [35] 
L74:    return 
L75:    nop 
L76:    
    .end code 
.end method 

.method private [239] : [240] 
    .attribute [214] .code stack 4 locals 1 
L0:     aload_1 
L1:     invokevirtual [33] 
L4:     iconst_1 
L5:     if_icmpne L88 
L8:     aconst_null 
L9:     astore_2 
L10:    aload_1 
L11:    invokevirtual [37] 
L14:    ifne L34 
L17:    new [47] 
L20:    dup 
L21:    aload_1 
L22:    invokevirtual [38] 
L25:    i2f 
L26:    iconst_1 
L27:    invokespecial [44] 
L30:    astore_2 
L31:    goto L60 
L34:    aload_1 
L35:    invokevirtual [37] 
L38:    iconst_1 
L39:    if_icmpne L60 
L42:    iconst_2 
L43:    invokestatic [13] 
L46:    new [47] 
L49:    dup 
L50:    aload_1 
L51:    invokevirtual [38] 
L54:    i2f 
L55:    iconst_2 
L56:    invokespecial [44] 
L59:    astore_2 
L60:    aload_2 
L61:    iconst_1 
L62:    invokevirtual [39] 
L65:    aload_0 
L66:    ldc [14] 
L68:    invokevirtual [40] 
L71:    aload_2 
L72:    invokeinterface [48] 0 
L77:    aload_0 
L78:    ldc [14] 
L80:    invokevirtual [40] 
L83:    invokeinterface [49] 0 
L88:    return 
L89:    nop 
L90:    nop 
L91:    nop 
L92:    
    .end code 
.end method 

.method protected abstract [241] : [242] 
    .attribute [214] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected abstract [243] : [244] 
    .attribute [214] .code stack 0 locals 0 
L0:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 1078071040 
.const [3] = String [50] 
.const [4] = String [51] 
.const [5] = Class [52] 
.const [6] = String [53] 
.const [7] = String [54] 
.const [8] = String [55] 
.const [9] = String [56] 
.const [10] = String [57] 
.const [11] = String [58] 
.const [12] = Class [59] 
.const [13] = Method [60] [61] 
.const [14] = Int -1693704192 
.const [15] = Class [62] 
.const [16] = Class [63] 
.const [17] = Class [64] 
.const [18] = Class [65] 
.const [19] = Class [66] 
.const [20] = Class [67] 
.const [21] = Class [68] 
.const [22] = Method [69] [70] 
.const [23] = Method [71] [72] 
.const [24] = Method [73] [74] 
.const [25] = Method [75] [76] 
.const [26] = Method [77] [78] 
.const [27] = Method [79] [80] 
.const [28] = Field [81] [82] 
.const [29] = Method [83] [84] 
.const [30] = Method [85] [86] 
.const [31] = Method [87] [88] 
.const [32] = Field [89] [90] 
.const [33] = Method [91] [92] 
.const [34] = Method [93] [94] 
.const [35] = Method [95] [96] 
.const [36] = Field [97] [98] 
.const [37] = Method [99] [100] 
.const [38] = Method [101] [102] 
.const [39] = Method [103] [104] 
.const [40] = Method [105] [106] 
.const [41] = Method [107] [108] 
.const [42] = Method [109] [110] 
.const [43] = Method [111] [112] 
.const [44] = Method [113] [114] 
.const [45] = Class [115] 
.const [46] = Field [116] [117] 
.const [47] = Class [118] 
.const [48] = InterfaceMethod [119] [120] 
.const [49] = InterfaceMethod [121] [122] 
.const [50] = Utf8 'Initiate TargetRangeComponent' 
.const [51] = Utf8 'App.Car.Charge.TargetRange' 
.const [52] = Utf8 de/audi/app/car/common/comp/CarDSIAttributesSet 
.const [53] = Utf8 'AbstractTargetRangeComponent#updateBatteryControlViewOptions(%1), valid=%2' 
.const [54] = Utf8 null 
.const [55] = Utf8 'AbstractTargetRangeComponent#updateBCCurrentRange1: currentRange=%1, validFlag=%2' 
.const [56] = Utf8 'AbstractTargetRangeComponent#updateBCCurrentRange1: currentRange.getState() is %1' 
.const [57] = Utf8 'AbstractTargetRangeComponent#updateBCCurrentRange2: currentRange=%1, validFlag=%2' 
.const [58] = Utf8 'AbstractTargetRangeComponent#updateBCCurrentRange2: currentRange.getState() is %1' 
.const [59] = Utf8 de/audi/app/car/common/util/CarDistance 
.const [60] = Class [123] 
.const [61] = NameAndType [124] [125] 
.const [62] = Utf8 de/audi/app/earlyfunc/core/hybrid/AbstractTargetRangeComponent 
.const [63] = Utf8 de/audi/app/car/common/adapter/AbstractDSICarKombiAdapter 
.const [64] = Utf8 de/audi/atip/log/LogChannel 
.const [65] = Utf8 org/dsi/ifc/carkombi/BCViewOptions 
.const [66] = Utf8 org/dsi/ifc/carkombi/BCConfiguration 
.const [67] = Utf8 org/dsi/ifc/global/CarBCCurrentRange 
.const [68] = Utf8 de/audi/atip/hmi/modelaccess/MetricsModelApp 
.const [69] = Class [126] 
.const [70] = NameAndType [127] [128] 
.const [71] = Class [129] 
.const [72] = NameAndType [130] [131] 
.const [73] = Class [132] 
.const [74] = NameAndType [133] [134] 
.const [75] = Class [135] 
.const [76] = NameAndType [136] [137] 
.const [77] = Class [138] 
.const [78] = NameAndType [139] [140] 
.const [79] = Class [141] 
.const [80] = NameAndType [142] [143] 
.const [81] = Class [144] 
.const [82] = NameAndType [145] [146] 
.const [83] = Class [147] 
.const [84] = NameAndType [148] [149] 
.const [85] = Class [150] 
.const [86] = NameAndType [151] [152] 
.const [87] = Class [153] 
.const [88] = NameAndType [154] [155] 
.const [89] = Class [156] 
.const [90] = NameAndType [157] [158] 
.const [91] = Class [159] 
.const [92] = NameAndType [160] [161] 
.const [93] = Class [162] 
.const [94] = NameAndType [163] [164] 
.const [95] = Class [165] 
.const [96] = NameAndType [166] [167] 
.const [97] = Class [168] 
.const [98] = NameAndType [169] [170] 
.const [99] = Class [171] 
.const [100] = NameAndType [172] [173] 
.const [101] = Class [174] 
.const [102] = NameAndType [175] [176] 
.const [103] = Class [177] 
.const [104] = NameAndType [178] [179] 
.const [105] = Class [180] 
.const [106] = NameAndType [181] [182] 
.const [107] = Class [183] 
.const [108] = NameAndType [184] [185] 
.const [109] = Class [186] 
.const [110] = NameAndType [187] [188] 
.const [111] = Class [189] 
.const [112] = NameAndType [190] [191] 
.const [113] = Class [192] 
.const [114] = NameAndType [193] [194] 
.const [115] = Utf8 de/audi/app/car/common/comp/CarDSIAttributesSet 
.const [116] = Class [195] 
.const [117] = NameAndType [196] [197] 
.const [118] = Utf8 de/audi/app/car/common/util/CarDistance 
.const [119] = Class [198] 
.const [120] = NameAndType [199] [200] 
.const [121] = Class [201] 
.const [122] = NameAndType [202] [203] 
.const [123] = Utf8 de/audi/app/car/common/util/CarDistance 
.const [124] = Utf8 setSystemUnit 
.const [125] = Utf8 (I)V 
.const [126] = Utf8 de/audi/app/earlyfunc/core/hybrid/AbstractTargetRangeComponent 
.const [127] = Utf8 getLogChannel 
.const [128] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [129] = Utf8 de/audi/atip/log/LogChannel 
.const [130] = Utf8 log 
.const [131] = Utf8 (ILjava/lang/String;)Z 
.const [132] = Utf8 de/audi/atip/log/LogChannel 
.const [133] = Utf8 isInfo 
.const [134] = Utf8 ()Z 
.const [135] = Utf8 org/dsi/ifc/carkombi/BCViewOptions 
.const [136] = Utf8 toString 
.const [137] = Utf8 ()Ljava/lang/String; 
.const [138] = Utf8 de/audi/app/earlyfunc/core/hybrid/AbstractTargetRangeComponent 
.const [139] = Utf8 formatViewOptionsLog 
.const [140] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [141] = Utf8 de/audi/atip/log/LogChannel 
.const [142] = Utf8 log 
.const [143] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [144] = Utf8 de/audi/app/earlyfunc/core/hybrid/AbstractTargetRangeComponent 
.const [145] = Utf8 bcViewOpts 
.const [146] = Utf8 Lorg/dsi/ifc/carkombi/BCViewOptions; 
.const [147] = Utf8 de/audi/app/earlyfunc/core/hybrid/AbstractTargetRangeComponent 
.const [148] = Utf8 updateMenuEntryVisibility 
.const [149] = Utf8 (Lorg/dsi/ifc/carkombi/BCViewOptions;)V 
.const [150] = Utf8 de/audi/app/earlyfunc/core/hybrid/AbstractTargetRangeComponent 
.const [151] = Utf8 primaryAttributeFirstSetReceived 
.const [152] = Utf8 ()V 
.const [153] = Utf8 org/dsi/ifc/carkombi/BCViewOptions 
.const [154] = Utf8 getConfiguration 
.const [155] = Utf8 ()Lorg/dsi/ifc/carkombi/BCConfiguration; 
.const [156] = Utf8 org/dsi/ifc/carkombi/BCConfiguration 
.const [157] = Utf8 primaryEngineType 
.const [158] = Utf8 I 
.const [159] = Utf8 org/dsi/ifc/global/CarBCCurrentRange 
.const [160] = Utf8 getState 
.const [161] = Utf8 ()I 
.const [162] = Utf8 de/audi/atip/log/LogChannel 
.const [163] = Utf8 log 
.const [164] = Utf8 (ILjava/lang/String;J)Z 
.const [165] = Utf8 de/audi/app/earlyfunc/core/hybrid/AbstractTargetRangeComponent 
.const [166] = Utf8 updateVisibilityForRangeAtStateChange 
.const [167] = Utf8 (I)V 
.const [168] = Utf8 org/dsi/ifc/carkombi/BCConfiguration 
.const [169] = Utf8 secondaryEngineType 
.const [170] = Utf8 I 
.const [171] = Utf8 org/dsi/ifc/global/CarBCCurrentRange 
.const [172] = Utf8 getCurrentRangeUnit 
.const [173] = Utf8 ()I 
.const [174] = Utf8 org/dsi/ifc/global/CarBCCurrentRange 
.const [175] = Utf8 getCurrentRangeValue 
.const [176] = Utf8 ()I 
.const [177] = Utf8 de/audi/app/car/common/util/CarDistance 
.const [178] = Utf8 setUseInstanceUnit 
.const [179] = Utf8 (Z)V 
.const [180] = Utf8 de/audi/app/earlyfunc/core/hybrid/AbstractTargetRangeComponent 
.const [181] = Utf8 getMetricsModel 
.const [182] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/MetricsModelApp; 
.const [183] = Utf8 de/audi/app/car/common/adapter/AbstractDSICarKombiAdapter 
.const [184] = Utf8 <init> 
.const [185] = Utf8 (Lde/audi/app/car/common/app/ICarApplication;Ljava/lang/String;)V 
.const [186] = Utf8 de/audi/app/car/common/comp/CarDSIAttributesSet 
.const [187] = Utf8 <init> 
.const [188] = Utf8 (I[I[I)V 
.const [189] = Utf8 de/audi/app/earlyfunc/core/hybrid/AbstractTargetRangeComponent 
.const [190] = Utf8 refreshBCCurrentRangeDistanceMetric 
.const [191] = Utf8 (Lorg/dsi/ifc/global/CarBCCurrentRange;)V 
.const [192] = Utf8 de/audi/app/car/common/util/CarDistance 
.const [193] = Utf8 <init> 
.const [194] = Utf8 (FI)V 
.const [195] = Utf8 de/audi/app/earlyfunc/core/hybrid/AbstractTargetRangeComponent 
.const [196] = Utf8 bcViewOpts 
.const [197] = Utf8 Lorg/dsi/ifc/carkombi/BCViewOptions; 
.const [198] = Utf8 de/audi/atip/hmi/modelaccess/MetricsModelApp 
.const [199] = Utf8 setMetric 
.const [200] = Utf8 (Lde/audi/atip/metrics/AbstractMetrics;)V 
.const [201] = Utf8 de/audi/atip/hmi/modelaccess/MetricsModelApp 
.const [202] = Utf8 formatChanged 
.const [203] = Utf8 ()V 
.const [204] = Utf8 de/audi/app/earlyfunc/core/hybrid/AbstractTargetRangeComponent 
.const [205] = Class [204] 
.const [206] = Utf8 de/audi/app/car/common/adapter/AbstractDSICarKombiAdapter 
.const [207] = Class [206] 
.const [208] = Utf8 bcViewOpts 
.const [209] = Utf8 Lorg/dsi/ifc/carkombi/BCViewOptions; 
.const [210] = Utf8 LOGCHANNEL_NAME 
.const [211] = Utf8 Ljava/lang/String; 
.const [212] = Utf8 CODING_ID 
.const [213] = Utf8 S 
.const [214] = Utf8 Code 
.const [215] = Utf8 <init> 
.const [216] = Utf8 (Lde/audi/app/car/common/app/ICarApplication;Ljava/lang/String;)V 
.const [217] = Utf8 <init> 
.const [218] = Utf8 (Lde/audi/app/car/common/app/ICarApplication;)V 
.const [219] = Utf8 getName 
.const [220] = Utf8 ()Ljava/lang/String; 
.const [221] = Utf8 getDSIAttributesSets 
.const [222] = Utf8 ()[Lde/audi/app/car/common/comp/CarDSIAttributesSet; 
.const [223] = Utf8 getCurrentViewOptions 
.const [224] = Utf8 ()Ljava/lang/String; 
.const [225] = Utf8 initModels 
.const [226] = Utf8 ()V 
.const [227] = Utf8 deinitModels 
.const [228] = Utf8 ()V 
.const [229] = Utf8 initVisibility 
.const [230] = Utf8 ()V 
.const [231] = Utf8 deinitVisibility 
.const [232] = Utf8 ()V 
.const [233] = Utf8 updateBCViewOptions 
.const [234] = Utf8 (Lorg/dsi/ifc/carkombi/BCViewOptions;I)V 
.const [235] = Utf8 updateBCCurrentRange1 
.const [236] = Utf8 (Lorg/dsi/ifc/global/CarBCCurrentRange;I)V 
.const [237] = Utf8 updateBCCurrentRange2 
.const [238] = Utf8 (Lorg/dsi/ifc/global/CarBCCurrentRange;I)V 
.const [239] = Utf8 refreshBCCurrentRangeDistanceMetric 
.const [240] = Utf8 (Lorg/dsi/ifc/global/CarBCCurrentRange;)V 
.const [241] = Utf8 updateMenuEntryVisibility 
.const [242] = Utf8 (Lorg/dsi/ifc/carkombi/BCViewOptions;)V 
.const [243] = Utf8 updateVisibilityForRangeAtStateChange 
.const [244] = Utf8 (I)V 
.end class 
