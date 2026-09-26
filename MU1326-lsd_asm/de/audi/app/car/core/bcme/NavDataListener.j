.version 50 0 
.class public super [201] 
.super [203] 
.implements [205] 
.field private [206] [207] 
.field private [208] [209] 
.field private [210] [211] 
.field private final [212] [213] 
.field private static final [214] [215] 

.method public [217] : [218] 
    .attribute [216] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [30] 
L4:     aload_0 
L5:     aload 4 
L7:     putfield [38] 
L10:    aload_0 
L11:    aload_1 
L12:    putfield [39] 
L15:    aload_0 
L16:    aload_2 
L17:    putfield [40] 
L20:    aload_0 
L21:    aload_3 
L22:    putfield [41] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [219] : [220] 
    .attribute [216] .code stack 7 locals 0 
L0:     aload_0 
L1:     getfield [19] 
L4:     invokevirtual [23] 
L7:     ifeq L41 
L10:    aload_0 
L11:    getfield [19] 
L14:    ldc [2] 
L16:    ldc [3] 
L18:    new [42] 
L21:    dup 
L22:    iload_1 
L23:    invokespecial [31] 
L26:    new [42] 
L29:    dup 
L30:    iload_2 
L31:    invokespecial [31] 
L34:    iload_3 
L35:    invokestatic [5] 
L38:    invokevirtual [24] 
L41:    iload_3 
L42:    ifeq L69 
L45:    aload_0 
L46:    getfield [20] 
L49:    aload_0 
L50:    iload_2 
L51:    iload_1 
L52:    invokespecial [32] 
L55:    invokeinterface [43] 0 
L60:    aload_0 
L61:    getfield [20] 
L64:    invokeinterface [44] 0 
L69:    return 
L70:    nop 
L71:    nop 
L72:    
    .end code 
.end method 

.method public [221] : [222] 
    .attribute [216] .code stack 6 locals 1 
L0:     aload_0 
L1:     getfield [19] 
L4:     invokevirtual [23] 
L7:     ifeq L33 
L10:    aload_0 
L11:    getfield [19] 
L14:    ldc [2] 
L16:    ldc [6] 
L18:    new [42] 
L21:    dup 
L22:    iload_1 
L23:    invokespecial [31] 
L26:    iload_2 
L27:    invokestatic [5] 
L30:    invokevirtual [25] 
L33:    iload_2 
L34:    ifeq L73 
L37:    new [45] 
L40:    dup 
L41:    iload_1 
L42:    i2f 
L43:    iconst_5 
L44:    iconst_2 
L45:    invokespecial [33] 
L48:    astore_3 
L49:    aload_3 
L50:    iconst_0 
L51:    invokevirtual [26] 
L54:    aload_0 
L55:    getfield [21] 
L58:    aload_3 
L59:    invokeinterface [43] 0 
L64:    aload_0 
L65:    getfield [21] 
L68:    invokeinterface [44] 0 
L73:    return 
L74:    nop 
L75:    nop 
L76:    
    .end code 
.end method 

.method public [223] : [224] 
    .attribute [216] .code stack 7 locals 1 
L0:     aload_0 
L1:     getfield [19] 
L4:     invokevirtual [23] 
L7:     ifeq L41 
L10:    aload_0 
L11:    getfield [19] 
L14:    ldc [2] 
L16:    ldc [8] 
L18:    new [42] 
L21:    dup 
L22:    iload_1 
L23:    invokespecial [31] 
L26:    new [42] 
L29:    dup 
L30:    iload_2 
L31:    invokespecial [31] 
L34:    iload_3 
L35:    invokestatic [5] 
L38:    invokevirtual [24] 
L41:    iload_3 
L42:    ifeq L82 
L45:    new [46] 
L48:    dup 
L49:    iload_1 
L50:    iload_2 
L51:    invokespecial [34] 
L54:    astore 4 
L56:    aload 4 
L58:    iconst_0 
L59:    invokevirtual [27] 
L62:    aload_0 
L63:    getfield [22] 
L66:    aload 4 
L68:    invokeinterface [43] 0 
L73:    aload_0 
L74:    getfield [22] 
L77:    invokeinterface [44] 0 
L82:    return 
L83:    nop 
L84:    
    .end code 
.end method 

.method public enum [225] : [226] 
    .attribute [216] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method private [227] : [228] 
    .attribute [216] .code stack 4 locals 2 
L0:     aload_0 
L1:     iload_2 
L2:     invokespecial [35] 
L5:     istore_3 
L6:     aconst_null 
L7:     astore 4 
L9:     iload_3 
L10:    iconst_m1 
L11:    if_icmpne L28 
L14:    new [47] 
L17:    dup 
L18:    fconst_0 
L19:    iconst_1 
L20:    invokespecial [36] 
L23:    astore 4 
L25:    goto L40 
L28:    new [47] 
L31:    dup 
L32:    iload_1 
L33:    i2f 
L34:    iload_3 
L35:    invokespecial [36] 
L38:    astore 4 
L40:    aload 4 
L42:    iconst_0 
L43:    invokevirtual [28] 
L46:    aload 4 
L48:    areturn 
L49:    nop 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method private [229] : [230] 
    .attribute [216] .code stack 5 locals 0 
L0:     iload_1 
L1:     iflt L18 
L4:     iload_1 
L5:     getstatic [11] 
L8:     arraylength 
L9:     if_icmpge L18 
L12:    getstatic [11] 
L15:    iload_1 
L16:    iaload 
L17:    areturn 
L18:    aload_0 
L19:    getfield [19] 
L22:    ldc [12] 
L24:    ldc [13] 
L26:    iload_1 
L27:    i2l 
L28:    invokevirtual [29] 
L31:    pop 
L32:    iconst_m1 
L33:    areturn 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method static [231] : [232] 
    .attribute [216] .code stack 4 locals 0 
L0:     bipush 8 
L2:     newarray int 
L4:     dup 
L5:     iconst_0 
L6:     iconst_1 
L7:     iastore 
L8:     dup 
L9:     iconst_1 
L10:    bipush 9 
L12:    iastore 
L13:    dup 
L14:    iconst_2 
L15:    iconst_5 
L16:    iastore 
L17:    dup 
L18:    iconst_3 
L19:    bipush 13 
L21:    iastore 
L22:    dup 
L23:    iconst_4 
L24:    iconst_3 
L25:    iastore 
L26:    dup 
L27:    iconst_5 
L28:    bipush 15 
L30:    iastore 
L31:    dup 
L32:    bipush 6 
L34:    bipush 7 
L36:    iastore 
L37:    dup 
L38:    bipush 7 
L40:    bipush 11 
L42:    iastore 
L43:    putstatic [37] 
L46:    return 
L47:    nop 
L48:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 1078071040 
.const [3] = String [48] 
.const [4] = Class [49] 
.const [5] = Method [50] [51] 
.const [6] = String [52] 
.const [7] = Class [53] 
.const [8] = String [54] 
.const [9] = Class [55] 
.const [10] = Class [56] 
.const [11] = Field [57] [58] 
.const [12] = Int -1601830656 
.const [13] = String [59] 
.const [14] = Class [60] 
.const [15] = Class [61] 
.const [16] = Class [62] 
.const [17] = Class [63] 
.const [18] = Class [64] 
.const [19] = Field [65] [66] 
.const [20] = Field [67] [68] 
.const [21] = Field [69] [70] 
.const [22] = Field [71] [72] 
.const [23] = Method [73] [74] 
.const [24] = Method [75] [76] 
.const [25] = Method [77] [78] 
.const [26] = Method [79] [80] 
.const [27] = Method [81] [82] 
.const [28] = Method [83] [84] 
.const [29] = Method [85] [86] 
.const [30] = Method [87] [88] 
.const [31] = Method [89] [90] 
.const [32] = Method [91] [92] 
.const [33] = Method [93] [94] 
.const [34] = Method [95] [96] 
.const [35] = Method [97] [98] 
.const [36] = Method [99] [100] 
.const [37] = Field [101] [102] 
.const [38] = Field [103] [104] 
.const [39] = Field [105] [106] 
.const [40] = Field [107] [108] 
.const [41] = Field [109] [110] 
.const [42] = Class [111] 
.const [43] = InterfaceMethod [112] [113] 
.const [44] = InterfaceMethod [114] [115] 
.const [45] = Class [116] 
.const [46] = Class [117] 
.const [47] = Class [118] 
.const [48] = Utf8 "[NavDataListener#updateVehicleHeading] heading='%1', angle='%2', isValid='%3'" 
.const [49] = Utf8 java/lang/Integer 
.const [50] = Class [119] 
.const [51] = NameAndType [120] [121] 
.const [52] = Utf8 "[NavDataListener#updateVehicleHeight] height='%1', isValid='%2'" 
.const [53] = Utf8 de/audi/atip/metrics/Distance 
.const [54] = Utf8 "[NavDataListener#updateVehiclePosition] latitude='%1', longitude='%2' , isValid='%3'" 
.const [55] = Utf8 de/audi/atip/metrics/GeoMetric 
.const [56] = Utf8 de/audi/atip/metrics/CompassMetric 
.const [57] = Class [122] 
.const [58] = NameAndType [123] [124] 
.const [59] = Utf8 "[NavDataListener#mapHeadingToCompassMetricOrientation] received invalid heading value from Navi App: '%1'" 
.const [60] = Utf8 de/audi/app/car/core/bcme/NavDataListener 
.const [61] = Utf8 java/lang/Object 
.const [62] = Utf8 de/audi/atip/log/LogChannel 
.const [63] = Utf8 java/lang/Boolean 
.const [64] = Utf8 de/audi/atip/hmi/modelaccess/MetricsModelApp 
.const [65] = Class [125] 
.const [66] = NameAndType [126] [127] 
.const [67] = Class [128] 
.const [68] = NameAndType [129] [130] 
.const [69] = Class [131] 
.const [70] = NameAndType [132] [133] 
.const [71] = Class [134] 
.const [72] = NameAndType [135] [136] 
.const [73] = Class [137] 
.const [74] = NameAndType [138] [139] 
.const [75] = Class [140] 
.const [76] = NameAndType [141] [142] 
.const [77] = Class [143] 
.const [78] = NameAndType [144] [145] 
.const [79] = Class [146] 
.const [80] = NameAndType [147] [148] 
.const [81] = Class [149] 
.const [82] = NameAndType [150] [151] 
.const [83] = Class [152] 
.const [84] = NameAndType [153] [154] 
.const [85] = Class [155] 
.const [86] = NameAndType [156] [157] 
.const [87] = Class [158] 
.const [88] = NameAndType [159] [160] 
.const [89] = Class [161] 
.const [90] = NameAndType [162] [163] 
.const [91] = Class [164] 
.const [92] = NameAndType [165] [166] 
.const [93] = Class [167] 
.const [94] = NameAndType [168] [169] 
.const [95] = Class [170] 
.const [96] = NameAndType [171] [172] 
.const [97] = Class [173] 
.const [98] = NameAndType [174] [175] 
.const [99] = Class [176] 
.const [100] = NameAndType [177] [178] 
.const [101] = Class [179] 
.const [102] = NameAndType [180] [181] 
.const [103] = Class [182] 
.const [104] = NameAndType [183] [184] 
.const [105] = Class [185] 
.const [106] = NameAndType [186] [187] 
.const [107] = Class [188] 
.const [108] = NameAndType [189] [190] 
.const [109] = Class [191] 
.const [110] = NameAndType [192] [193] 
.const [111] = Utf8 java/lang/Integer 
.const [112] = Class [194] 
.const [113] = NameAndType [195] [196] 
.const [114] = Class [197] 
.const [115] = NameAndType [198] [199] 
.const [116] = Utf8 de/audi/atip/metrics/Distance 
.const [117] = Utf8 de/audi/atip/metrics/GeoMetric 
.const [118] = Utf8 de/audi/atip/metrics/CompassMetric 
.const [119] = Utf8 java/lang/Boolean 
.const [120] = Utf8 valueOf 
.const [121] = Utf8 (Z)Ljava/lang/Boolean; 
.const [122] = Utf8 de/audi/app/car/core/bcme/NavDataListener 
.const [123] = Utf8 HEADING_TO_COMPASS_METRIC_ORIENTATION_MAPPING 
.const [124] = Utf8 [I 
.const [125] = Utf8 de/audi/app/car/core/bcme/NavDataListener 
.const [126] = Utf8 logChannel 
.const [127] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [128] = Utf8 de/audi/app/car/core/bcme/NavDataListener 
.const [129] = Utf8 compass 
.const [130] = Utf8 Lde/audi/atip/hmi/modelaccess/MetricsModelApp; 
.const [131] = Utf8 de/audi/app/car/core/bcme/NavDataListener 
.const [132] = Utf8 altitude 
.const [133] = Utf8 Lde/audi/atip/hmi/modelaccess/MetricsModelApp; 
.const [134] = Utf8 de/audi/app/car/core/bcme/NavDataListener 
.const [135] = Utf8 gpsCoordinates 
.const [136] = Utf8 Lde/audi/atip/hmi/modelaccess/MetricsModelApp; 
.const [137] = Utf8 de/audi/atip/log/LogChannel 
.const [138] = Utf8 isInfo 
.const [139] = Utf8 ()Z 
.const [140] = Utf8 de/audi/atip/log/LogChannel 
.const [141] = Utf8 log 
.const [142] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [143] = Utf8 de/audi/atip/log/LogChannel 
.const [144] = Utf8 log 
.const [145] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [146] = Utf8 de/audi/atip/metrics/Distance 
.const [147] = Utf8 setUseInstanceUnit 
.const [148] = Utf8 (Z)V 
.const [149] = Utf8 de/audi/atip/metrics/GeoMetric 
.const [150] = Utf8 setUseInstanceUnit 
.const [151] = Utf8 (Z)V 
.const [152] = Utf8 de/audi/atip/metrics/CompassMetric 
.const [153] = Utf8 setUseInstanceUnit 
.const [154] = Utf8 (Z)V 
.const [155] = Utf8 de/audi/atip/log/LogChannel 
.const [156] = Utf8 log 
.const [157] = Utf8 (ILjava/lang/String;J)Z 
.const [158] = Utf8 java/lang/Object 
.const [159] = Utf8 <init> 
.const [160] = Utf8 ()V 
.const [161] = Utf8 java/lang/Integer 
.const [162] = Utf8 <init> 
.const [163] = Utf8 (I)V 
.const [164] = Utf8 de/audi/app/car/core/bcme/NavDataListener 
.const [165] = Utf8 createCompassMetric 
.const [166] = Utf8 (II)Lde/audi/atip/metrics/CompassMetric; 
.const [167] = Utf8 de/audi/atip/metrics/Distance 
.const [168] = Utf8 <init> 
.const [169] = Utf8 (FII)V 
.const [170] = Utf8 de/audi/atip/metrics/GeoMetric 
.const [171] = Utf8 <init> 
.const [172] = Utf8 (II)V 
.const [173] = Utf8 de/audi/app/car/core/bcme/NavDataListener 
.const [174] = Utf8 mapHeadingToCompassMetricOrientation 
.const [175] = Utf8 (I)I 
.const [176] = Utf8 de/audi/atip/metrics/CompassMetric 
.const [177] = Utf8 <init> 
.const [178] = Utf8 (FI)V 
.const [179] = Utf8 de/audi/app/car/core/bcme/NavDataListener 
.const [180] = Utf8 HEADING_TO_COMPASS_METRIC_ORIENTATION_MAPPING 
.const [181] = Utf8 [I 
.const [182] = Utf8 de/audi/app/car/core/bcme/NavDataListener 
.const [183] = Utf8 logChannel 
.const [184] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [185] = Utf8 de/audi/app/car/core/bcme/NavDataListener 
.const [186] = Utf8 compass 
.const [187] = Utf8 Lde/audi/atip/hmi/modelaccess/MetricsModelApp; 
.const [188] = Utf8 de/audi/app/car/core/bcme/NavDataListener 
.const [189] = Utf8 altitude 
.const [190] = Utf8 Lde/audi/atip/hmi/modelaccess/MetricsModelApp; 
.const [191] = Utf8 de/audi/app/car/core/bcme/NavDataListener 
.const [192] = Utf8 gpsCoordinates 
.const [193] = Utf8 Lde/audi/atip/hmi/modelaccess/MetricsModelApp; 
.const [194] = Utf8 de/audi/atip/hmi/modelaccess/MetricsModelApp 
.const [195] = Utf8 setMetric 
.const [196] = Utf8 (Lde/audi/atip/metrics/AbstractMetrics;)V 
.const [197] = Utf8 de/audi/atip/hmi/modelaccess/MetricsModelApp 
.const [198] = Utf8 formatChanged 
.const [199] = Utf8 ()V 
.const [200] = Utf8 de/audi/app/car/core/bcme/NavDataListener 
.const [201] = Class [200] 
.const [202] = Utf8 java/lang/Object 
.const [203] = Class [202] 
.const [204] = Utf8 de/audi/atip/interapp/navcar/CarNavListener 
.const [205] = Class [204] 
.const [206] = Utf8 compass 
.const [207] = Utf8 Lde/audi/atip/hmi/modelaccess/MetricsModelApp; 
.const [208] = Utf8 altitude 
.const [209] = Utf8 Lde/audi/atip/hmi/modelaccess/MetricsModelApp; 
.const [210] = Utf8 gpsCoordinates 
.const [211] = Utf8 Lde/audi/atip/hmi/modelaccess/MetricsModelApp; 
.const [212] = Utf8 logChannel 
.const [213] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [214] = Utf8 HEADING_TO_COMPASS_METRIC_ORIENTATION_MAPPING 
.const [215] = Utf8 [I 
.const [216] = Utf8 Code 
.const [217] = Utf8 <init> 
.const [218] = Utf8 (Lde/audi/atip/hmi/modelaccess/MetricsModelApp;Lde/audi/atip/hmi/modelaccess/MetricsModelApp;Lde/audi/atip/hmi/modelaccess/MetricsModelApp;Lde/audi/atip/log/LogChannel;)V 
.const [219] = Utf8 updateVehicleHeading 
.const [220] = Utf8 (IIZ)V 
.const [221] = Utf8 updateVehicleHeight 
.const [222] = Utf8 (IZ)V 
.const [223] = Utf8 updateVehiclePosition 
.const [224] = Utf8 (IIZ)V 
.const [225] = Utf8 updateVehiclePositionDescription 
.const [226] = Utf8 (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V 
.const [227] = Utf8 createCompassMetric 
.const [228] = Utf8 (II)Lde/audi/atip/metrics/CompassMetric; 
.const [229] = Utf8 mapHeadingToCompassMetricOrientation 
.const [230] = Utf8 (I)I 
.const [231] = Utf8 <clinit> 
.const [232] = Utf8 ()V 
.end class 
