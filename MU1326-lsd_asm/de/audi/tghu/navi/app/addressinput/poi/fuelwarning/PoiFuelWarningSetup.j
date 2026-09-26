.version 50 0 
.class public super [164] 
.super [166] 
.field private static final [167] [168] 
.field private static final [169] [170] 
.field private [171] [172] 
.field private final [173] [174] 
.field private final [175] [176] 

.method public [178] : [179] 
    .attribute [177] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [25] 
L4:     aload_0 
L5:     aload_0 
L6:     invokespecial [26] 
L9:     invokestatic [2] 
L12:    putfield [32] 
L15:    aload_0 
L16:    aload_1 
L17:    putfield [33] 
L20:    aload_0 
L21:    aload_1 
L22:    invokevirtual [16] 
L25:    invokeinterface [34] 0 
L30:    aload_1 
L31:    invokevirtual [17] 
L34:    invokespecial [27] 
L37:    return 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public final interface [180] : [181] 
    .attribute [177] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method private [182] : [183] 
    .attribute [177] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [35] 
L5:     aload_0 
L6:     invokespecial [28] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [184] : [185] 
    .attribute [177] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     iload_2 
L3:     invokespecial [29] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [186] : [187] 
    .attribute [177] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [28] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method private [188] : [189] 
    .attribute [177] .code stack 4 locals 2 
L0:     aload_0 
L1:     getfield [15] 
L4:     invokevirtual [16] 
L7:     invokeinterface [34] 0 
L12:    astore_1 
L13:    new [36] 
L16:    dup 
L17:    aload_1 
L18:    aload_0 
L19:    getfield [15] 
L22:    invokevirtual [17] 
L25:    invokespecial [30] 
L28:    astore_2 
L29:    aload_2 
L30:    aload_0 
L31:    getfield [18] 
L34:    ifeq L41 
L37:    iconst_0 
L38:    goto L42 
L41:    iconst_1 
L42:    invokevirtual [19] 
L45:    aload_2 
L46:    invokevirtual [20] 
L49:    return 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method public final [190] : [191] 
    .attribute [177] .code stack 4 locals 2 
L0:     aload_1 
L1:     ifnonnull L19 
L4:     aload_2 
L5:     sipush 10000 
L8:     ldc [4] 
L10:    aload_0 
L11:    getfield [14] 
L14:    invokevirtual [21] 
L17:    pop 
L18:    return 
L19:    new [36] 
L22:    dup 
L23:    aload_1 
L24:    aload_2 
L25:    invokespecial [30] 
L28:    astore_3 
L29:    aload_3 
L30:    invokevirtual [22] 
L33:    aload_3 
L34:    invokevirtual [23] 
L37:    iconst_1 
L38:    if_icmpne L45 
L41:    iconst_0 
L42:    goto L46 
L45:    iconst_1 
L46:    istore 4 
L48:    aload_0 
L49:    iload 4 
L51:    iconst_0 
L52:    invokespecial [29] 
L55:    return 
L56:    
    .end code 
.end method 

.method [192] : [193] 
    .attribute [177] .code stack 4 locals 2 
L0:     aload_1 
L1:     ifnonnull L19 
L4:     aload_2 
L5:     sipush 10000 
L8:     ldc [5] 
L10:    aload_0 
L11:    getfield [14] 
L14:    invokevirtual [21] 
L17:    pop 
L18:    return 
L19:    new [36] 
L22:    dup 
L23:    aload_1 
L24:    aload_2 
L25:    invokespecial [30] 
L28:    astore_3 
L29:    aload_0 
L30:    invokespecial [31] 
L33:    ifeq L40 
L36:    iconst_0 
L37:    goto L41 
L40:    iconst_1 
L41:    istore 4 
L43:    aload_3 
L44:    iload 4 
L46:    invokevirtual [19] 
L49:    aload_3 
L50:    invokevirtual [20] 
L53:    return 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method public [194] : [195] 
    .attribute [177] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     invokevirtual [17] 
L7:     ldc [6] 
L9:     ldc [7] 
L11:    aload_0 
L12:    getfield [14] 
L15:    invokevirtual [21] 
L18:    pop 
L19:    aload_0 
L20:    iconst_1 
L21:    iconst_1 
L22:    invokevirtual [24] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [37] [38] 
.const [3] = Class [39] 
.const [4] = String [40] 
.const [5] = String [41] 
.const [6] = Int -2137614336 
.const [7] = String [42] 
.const [8] = Class [43] 
.const [9] = Class [44] 
.const [10] = Class [45] 
.const [11] = Class [46] 
.const [12] = Class [47] 
.const [13] = Class [48] 
.const [14] = Field [49] [50] 
.const [15] = Field [51] [52] 
.const [16] = Method [53] [54] 
.const [17] = Method [55] [56] 
.const [18] = Field [57] [58] 
.const [19] = Method [59] [60] 
.const [20] = Method [61] [62] 
.const [21] = Method [63] [64] 
.const [22] = Method [65] [66] 
.const [23] = Method [67] [68] 
.const [24] = Method [69] [70] 
.const [25] = Method [71] [72] 
.const [26] = Method [73] [74] 
.const [27] = Method [75] [76] 
.const [28] = Method [77] [78] 
.const [29] = Method [79] [80] 
.const [30] = Method [81] [82] 
.const [31] = Method [83] [84] 
.const [32] = Field [85] [86] 
.const [33] = Field [87] [88] 
.const [34] = InterfaceMethod [89] [90] 
.const [35] = Field [91] [92] 
.const [36] = Class [93] 
.const [37] = Class [94] 
.const [38] = NameAndType [95] [96] 
.const [39] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningSetup$FuelWarningState 
.const [40] = Utf8 '%1#loadState() - no storage manager available!!!' 
.const [41] = Utf8 '%1#saveState() - no storage manager available!!!' 
.const [42] = Utf8 '%1#resetSettings() - reset FuelWarningActive - true' 
.const [43] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningSetup 
.const [44] = Utf8 java/lang/Object 
.const [45] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [46] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [47] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [48] = Utf8 de/audi/atip/log/LogChannel 
.const [49] = Class [97] 
.const [50] = NameAndType [98] [99] 
.const [51] = Class [100] 
.const [52] = NameAndType [101] [102] 
.const [53] = Class [103] 
.const [54] = NameAndType [104] [105] 
.const [55] = Class [106] 
.const [56] = NameAndType [107] [108] 
.const [57] = Class [109] 
.const [58] = NameAndType [110] [111] 
.const [59] = Class [112] 
.const [60] = NameAndType [113] [114] 
.const [61] = Class [115] 
.const [62] = NameAndType [116] [117] 
.const [63] = Class [118] 
.const [64] = NameAndType [119] [120] 
.const [65] = Class [121] 
.const [66] = NameAndType [122] [123] 
.const [67] = Class [124] 
.const [68] = NameAndType [125] [126] 
.const [69] = Class [127] 
.const [70] = NameAndType [128] [129] 
.const [71] = Class [130] 
.const [72] = NameAndType [131] [132] 
.const [73] = Class [133] 
.const [74] = NameAndType [134] [135] 
.const [75] = Class [136] 
.const [76] = NameAndType [137] [138] 
.const [77] = Class [139] 
.const [78] = NameAndType [140] [141] 
.const [79] = Class [142] 
.const [80] = NameAndType [143] [144] 
.const [81] = Class [145] 
.const [82] = NameAndType [146] [147] 
.const [83] = Class [148] 
.const [84] = NameAndType [149] [150] 
.const [85] = Class [151] 
.const [86] = NameAndType [152] [153] 
.const [87] = Class [154] 
.const [88] = NameAndType [155] [156] 
.const [89] = Class [157] 
.const [90] = NameAndType [158] [159] 
.const [91] = Class [160] 
.const [92] = NameAndType [161] [162] 
.const [93] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningSetup$FuelWarningState 
.const [94] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [95] = Utf8 getClassNameFromPackageName 
.const [96] = Utf8 (Ljava/lang/Class;)Ljava/lang/String; 
.const [97] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningSetup 
.const [98] = Utf8 CLASS_NAME 
.const [99] = Utf8 Ljava/lang/String; 
.const [100] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningSetup 
.const [101] = Utf8 env 
.const [102] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [103] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [104] = Utf8 getFramework 
.const [105] = Utf8 ()Lde/audi/atip/base/IFrameworkAccess; 
.const [106] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [107] = Utf8 getLogChannel 
.const [108] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [109] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningSetup 
.const [110] = Utf8 fuelWarningActive 
.const [111] = Utf8 Z 
.const [112] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningSetup$FuelWarningState 
.const [113] = Utf8 setRecommendation 
.const [114] = Utf8 (I)V 
.const [115] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningSetup$FuelWarningState 
.const [116] = Utf8 serializeAndWrite 
.const [117] = Utf8 ()V 
.const [118] = Utf8 de/audi/atip/log/LogChannel 
.const [119] = Utf8 log 
.const [120] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [121] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningSetup$FuelWarningState 
.const [122] = Utf8 readAndDeserialize 
.const [123] = Utf8 ()V 
.const [124] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningSetup$FuelWarningState 
.const [125] = Utf8 getRecommendation 
.const [126] = Utf8 ()I 
.const [127] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningSetup 
.const [128] = Utf8 setFuelWarningActive 
.const [129] = Utf8 (ZZ)V 
.const [130] = Utf8 java/lang/Object 
.const [131] = Utf8 <init> 
.const [132] = Utf8 ()V 
.const [133] = Utf8 java/lang/Object 
.const [134] = Utf8 getClass 
.const [135] = Utf8 ()Ljava/lang/Class; 
.const [136] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningSetup 
.const [137] = Utf8 loadState 
.const [138] = Utf8 (Lde/audi/atip/storage/IStorageAccess;Lde/audi/atip/log/LogChannel;)V 
.const [139] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningSetup 
.const [140] = Utf8 doPersistFuelWarningActive 
.const [141] = Utf8 ()V 
.const [142] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningSetup 
.const [143] = Utf8 doSetFuelWarningActive 
.const [144] = Utf8 (ZZ)V 
.const [145] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningSetup$FuelWarningState 
.const [146] = Utf8 <init> 
.const [147] = Utf8 (Lde/audi/atip/storage/IStorageAccess;Lde/audi/atip/log/LogChannel;)V 
.const [148] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningSetup 
.const [149] = Utf8 isFuelWarningActive 
.const [150] = Utf8 ()Z 
.const [151] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningSetup 
.const [152] = Utf8 CLASS_NAME 
.const [153] = Utf8 Ljava/lang/String; 
.const [154] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningSetup 
.const [155] = Utf8 env 
.const [156] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [157] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [158] = Utf8 getStorageMgr 
.const [159] = Utf8 ()Lde/audi/atip/storage/IStorageAccess; 
.const [160] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningSetup 
.const [161] = Utf8 fuelWarningActive 
.const [162] = Utf8 Z 
.const [163] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningSetup 
.const [164] = Class [163] 
.const [165] = Utf8 java/lang/Object 
.const [166] = Class [165] 
.const [167] = Utf8 FUEL_WARNING_RECOMMENDATION_ON 
.const [168] = Utf8 I 
.const [169] = Utf8 FUEL_WARNING_RECOMMENDATION_OFF 
.const [170] = Utf8 I 
.const [171] = Utf8 fuelWarningActive 
.const [172] = Utf8 Z 
.const [173] = Utf8 env 
.const [174] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [175] = Utf8 CLASS_NAME 
.const [176] = Utf8 Ljava/lang/String; 
.const [177] = Utf8 Code 
.const [178] = Utf8 <init> 
.const [179] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;)V 
.const [180] = Utf8 isFuelWarningActive 
.const [181] = Utf8 ()Z 
.const [182] = Utf8 doSetFuelWarningActive 
.const [183] = Utf8 (ZZ)V 
.const [184] = Utf8 setFuelWarningActive 
.const [185] = Utf8 (ZZ)V 
.const [186] = Utf8 persistFuelWarningActive 
.const [187] = Utf8 ()V 
.const [188] = Utf8 doPersistFuelWarningActive 
.const [189] = Utf8 ()V 
.const [190] = Utf8 loadState 
.const [191] = Utf8 (Lde/audi/atip/storage/IStorageAccess;Lde/audi/atip/log/LogChannel;)V 
.const [192] = Utf8 saveState 
.const [193] = Utf8 (Lde/audi/atip/storage/IStorageAccess;Lde/audi/atip/log/LogChannel;)V 
.const [194] = Utf8 resetSettings 
.const [195] = Utf8 ()V 
.end class 
