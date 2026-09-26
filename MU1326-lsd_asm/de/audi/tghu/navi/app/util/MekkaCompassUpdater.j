.version 50 0 
.class public super [174] 
.super [176] 
.field public static final [177] [178] 
.field public static final [179] [180] 
.field public static final [181] [182] 
.field private final [183] [184] 
.field private final [185] [186] 
.field public final [187] [188] 

.method public [190] : [191] 
    .attribute [189] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [31] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [35] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [36] 
L14:    aload_0 
L15:    aload_1 
L16:    ldc [2] 
L18:    invokevirtual [22] 
L21:    putfield [37] 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method private [192] : [193] 
    .attribute [189] .code stack 3 locals 3 
L0:     aload_0 
L1:     getfield [21] 
L4:     invokeinterface [38] 0 
L9:     astore_1 
L10:    aload_1 
L11:    ifnonnull L16 
L14:    iconst_m1 
L15:    areturn 
L16:    aload_1 
L17:    invokevirtual [24] 
L20:    ifne L32 
L23:    aload_1 
L24:    invokevirtual [24] 
L27:    ifne L32 
L30:    iconst_m1 
L31:    areturn 
L32:    aload_1 
L33:    invokevirtual [25] 
L36:    istore_2 
L37:    iload_2 
L38:    ldc [3] 
L40:    if_icmpne L45 
L43:    iconst_m1 
L44:    areturn 
L45:    aload_1 
L46:    getstatic [4] 
L49:    invokevirtual [26] 
L52:    getstatic [4] 
L55:    invokevirtual [27] 
L58:    invokestatic [5] 
L61:    istore_3 
L62:    sipush 360 
L65:    iload_3 
L66:    isub 
L67:    iload_2 
L68:    iadd 
L69:    sipush 360 
L72:    irem 
L73:    areturn 
L74:    nop 
L75:    nop 
L76:    
    .end code 
.end method 

.method public [194] : [195] 
    .attribute [189] .code stack 5 locals 1 
L0:     aload_0 
L1:     getfield [23] 
L4:     ifnull L42 
L7:     aload_0 
L8:     invokespecial [33] 
L11:    istore_1 
L12:    aload_0 
L13:    getfield [20] 
L16:    invokevirtual [28] 
L19:    ldc [6] 
L21:    ldc [7] 
L23:    iload_1 
L24:    i2l 
L25:    invokevirtual [29] 
L28:    pop 
L29:    aload_0 
L30:    getfield [23] 
L33:    iload_1 
L34:    invokeinterface [39] 0 
L39:    goto L57 
L42:    aload_0 
L43:    getfield [20] 
L46:    invokevirtual [28] 
L49:    ldc [6] 
L51:    ldc [8] 
L53:    invokevirtual [30] 
L56:    pop 
L57:    return 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method static [196] : [197] 
    .attribute [189] .code stack 5 locals 0 
L0:     new [40] 
L3:     dup 
L4:     ldc2_w [41] 
L7:     invokestatic [10] 
L10:    ldc2_w [43] 
L13:    invokestatic [10] 
L16:    invokespecial [34] 
L19:    putstatic [32] 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 1445070336 
.const [3] = Int -65536 
.const [4] = Field [45] [46] 
.const [5] = Method [47] [48] 
.const [6] = Int -2137614336 
.const [7] = String [49] 
.const [8] = String [50] 
.const [9] = Class [51] 
.const [10] = Method [52] [53] 
.const [11] = Class [54] 
.const [12] = Class [55] 
.const [13] = Class [56] 
.const [14] = Class [57] 
.const [15] = Class [58] 
.const [16] = Class [59] 
.const [17] = Class [60] 
.const [18] = Class [61] 
.const [19] = Class [62] 
.const [20] = Field [63] [64] 
.const [21] = Field [65] [66] 
.const [22] = Method [67] [68] 
.const [23] = Field [69] [70] 
.const [24] = Method [71] [72] 
.const [25] = Method [73] [74] 
.const [26] = Method [75] [76] 
.const [27] = Method [77] [78] 
.const [28] = Method [79] [80] 
.const [29] = Method [81] [82] 
.const [30] = Method [83] [84] 
.const [31] = Method [85] [86] 
.const [32] = Field [87] [88] 
.const [33] = Method [89] [90] 
.const [34] = Method [91] [92] 
.const [35] = Field [93] [94] 
.const [36] = Field [95] [96] 
.const [37] = Field [97] [98] 
.const [38] = InterfaceMethod [99] [100] 
.const [39] = InterfaceMethod [101] [102] 
.const [40] = Class [103] 
.const [41] = Double +0x13E9C04C8BC9CDp-47 
.const [43] = Double +0x156C28F5C28F5Cp-48 
.const [45] = Class [104] 
.const [46] = NameAndType [105] [106] 
.const [47] = Class [107] 
.const [48] = NameAndType [108] [109] 
.const [49] = Utf8 'QiblaUpdater#onSoPosPositionUpdated() - direction to Kaaba: %1' 
.const [50] = Utf8 'QiblaUpdater#onSoPosPositionUpdated() - model not available' 
.const [51] = Utf8 org/dsi/ifc/global/NavLocationWgs84 
.const [52] = Class [110] 
.const [53] = NameAndType [111] [112] 
.const [54] = Utf8 de/audi/tghu/navi/app/util/MekkaCompassUpdater 
.const [55] = Utf8 java/lang/Object 
.const [56] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [57] = Utf8 de/audi/tghu/navi/app/guidance/IVehicle 
.const [58] = Utf8 org/dsi/ifc/navigation/PosPosition 
.const [59] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [60] = Utf8 de/audi/atip/log/LogChannel 
.const [61] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [62] = Utf8 de/audi/atip/interapp/NavigationUtilities 
.const [63] = Class [113] 
.const [64] = NameAndType [114] [115] 
.const [65] = Class [116] 
.const [66] = NameAndType [117] [118] 
.const [67] = Class [119] 
.const [68] = NameAndType [120] [121] 
.const [69] = Class [122] 
.const [70] = NameAndType [123] [124] 
.const [71] = Class [125] 
.const [72] = NameAndType [126] [127] 
.const [73] = Class [128] 
.const [74] = NameAndType [129] [130] 
.const [75] = Class [131] 
.const [76] = NameAndType [132] [133] 
.const [77] = Class [134] 
.const [78] = NameAndType [135] [136] 
.const [79] = Class [137] 
.const [80] = NameAndType [138] [139] 
.const [81] = Class [140] 
.const [82] = NameAndType [141] [142] 
.const [83] = Class [143] 
.const [84] = NameAndType [144] [145] 
.const [85] = Class [146] 
.const [86] = NameAndType [147] [148] 
.const [87] = Class [149] 
.const [88] = NameAndType [150] [151] 
.const [89] = Class [152] 
.const [90] = NameAndType [153] [154] 
.const [91] = Class [155] 
.const [92] = NameAndType [156] [157] 
.const [93] = Class [158] 
.const [94] = NameAndType [159] [160] 
.const [95] = Class [161] 
.const [96] = NameAndType [162] [163] 
.const [97] = Class [164] 
.const [98] = NameAndType [165] [166] 
.const [99] = Class [167] 
.const [100] = NameAndType [168] [169] 
.const [101] = Class [170] 
.const [102] = NameAndType [171] [172] 
.const [103] = Utf8 org/dsi/ifc/global/NavLocationWgs84 
.const [104] = Utf8 de/audi/tghu/navi/app/util/MekkaCompassUpdater 
.const [105] = Utf8 kaabaPosition 
.const [106] = Utf8 Lorg/dsi/ifc/global/NavLocationWgs84; 
.const [107] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [108] = Utf8 computeAbsoluteDirection 
.const [109] = Utf8 (Lorg/dsi/ifc/navigation/PosPosition;II)I 
.const [110] = Utf8 de/audi/atip/interapp/NavigationUtilities 
.const [111] = Utf8 degreeToWgs84 
.const [112] = Utf8 (D)I 
.const [113] = Utf8 de/audi/tghu/navi/app/util/MekkaCompassUpdater 
.const [114] = Utf8 navigationEnv 
.const [115] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [116] = Utf8 de/audi/tghu/navi/app/util/MekkaCompassUpdater 
.const [117] = Utf8 vehicle 
.const [118] = Utf8 Lde/audi/tghu/navi/app/guidance/IVehicle; 
.const [119] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [120] = Utf8 getChoiceModel 
.const [121] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [122] = Utf8 de/audi/tghu/navi/app/util/MekkaCompassUpdater 
.const [123] = Utf8 directionToMekkaModel 
.const [124] = Utf8 Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [125] = Utf8 org/dsi/ifc/navigation/PosPosition 
.const [126] = Utf8 getLatitude 
.const [127] = Utf8 ()I 
.const [128] = Utf8 org/dsi/ifc/navigation/PosPosition 
.const [129] = Utf8 getDirectionAngle 
.const [130] = Utf8 ()I 
.const [131] = Utf8 org/dsi/ifc/global/NavLocationWgs84 
.const [132] = Utf8 getLongitude 
.const [133] = Utf8 ()I 
.const [134] = Utf8 org/dsi/ifc/global/NavLocationWgs84 
.const [135] = Utf8 getLatitude 
.const [136] = Utf8 ()I 
.const [137] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [138] = Utf8 getLogChannel 
.const [139] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [140] = Utf8 de/audi/atip/log/LogChannel 
.const [141] = Utf8 log 
.const [142] = Utf8 (ILjava/lang/String;J)Z 
.const [143] = Utf8 de/audi/atip/log/LogChannel 
.const [144] = Utf8 log 
.const [145] = Utf8 (ILjava/lang/String;)Z 
.const [146] = Utf8 java/lang/Object 
.const [147] = Utf8 <init> 
.const [148] = Utf8 ()V 
.const [149] = Utf8 de/audi/tghu/navi/app/util/MekkaCompassUpdater 
.const [150] = Utf8 kaabaPosition 
.const [151] = Utf8 Lorg/dsi/ifc/global/NavLocationWgs84; 
.const [152] = Utf8 de/audi/tghu/navi/app/util/MekkaCompassUpdater 
.const [153] = Utf8 getDirectionToKaaba 
.const [154] = Utf8 ()I 
.const [155] = Utf8 org/dsi/ifc/global/NavLocationWgs84 
.const [156] = Utf8 <init> 
.const [157] = Utf8 (II)V 
.const [158] = Utf8 de/audi/tghu/navi/app/util/MekkaCompassUpdater 
.const [159] = Utf8 navigationEnv 
.const [160] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [161] = Utf8 de/audi/tghu/navi/app/util/MekkaCompassUpdater 
.const [162] = Utf8 vehicle 
.const [163] = Utf8 Lde/audi/tghu/navi/app/guidance/IVehicle; 
.const [164] = Utf8 de/audi/tghu/navi/app/util/MekkaCompassUpdater 
.const [165] = Utf8 directionToMekkaModel 
.const [166] = Utf8 Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [167] = Utf8 de/audi/tghu/navi/app/guidance/IVehicle 
.const [168] = Utf8 getFrontUnitPosition 
.const [169] = Utf8 ()Lorg/dsi/ifc/navigation/PosPosition; 
.const [170] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [171] = Utf8 setValue 
.const [172] = Utf8 (I)V 
.const [173] = Utf8 de/audi/tghu/navi/app/util/MekkaCompassUpdater 
.const [174] = Class [173] 
.const [175] = Utf8 java/lang/Object 
.const [176] = Class [175] 
.const [177] = Utf8 KAABA_POSITION_LATITUDE 
.const [178] = Utf8 D 
.const [179] = Utf8 KAABA_POSITION_LONGITUDE 
.const [180] = Utf8 D 
.const [181] = Utf8 kaabaPosition 
.const [182] = Utf8 Lorg/dsi/ifc/global/NavLocationWgs84; 
.const [183] = Utf8 navigationEnv 
.const [184] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [185] = Utf8 vehicle 
.const [186] = Utf8 Lde/audi/tghu/navi/app/guidance/IVehicle; 
.const [187] = Utf8 directionToMekkaModel 
.const [188] = Utf8 Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [189] = Utf8 Code 
.const [190] = Utf8 <init> 
.const [191] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;Lde/audi/tghu/navi/app/guidance/IVehicle;)V 
.const [192] = Utf8 getDirectionToKaaba 
.const [193] = Utf8 ()I 
.const [194] = Utf8 onSoPosPositionUpdated 
.const [195] = Utf8 ()V 
.const [196] = Utf8 <clinit> 
.const [197] = Utf8 ()V 
.end class 
