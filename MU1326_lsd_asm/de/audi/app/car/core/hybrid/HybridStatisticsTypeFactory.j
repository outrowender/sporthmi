.version 50 0 
.class public final super [123] 
.super [125] 
.field static synthetic [126] [127] 
.field static synthetic [128] [129] 
.field static synthetic [130] [131] 

.method public annotation [133] : [134] 
    .attribute [132] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [21] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [135] : [136] 
    .attribute [132] .code stack 2 locals 1 
L0:     iload_0 
L1:     tableswitch 0 
            L28 
            L39 
            L50 
            default : L61 

L28:    new [29] 
L31:    dup 
L32:    invokespecial [22] 
L35:    astore_1 
L36:    goto L63 
L39:    new [30] 
L42:    dup 
L43:    invokespecial [23] 
L46:    astore_1 
L47:    goto L63 
L50:    new [31] 
L53:    dup 
L54:    invokespecial [24] 
L57:    astore_1 
L58:    goto L63 
L61:    aconst_null 
L62:    astore_1 
L63:    aload_1 
L64:    areturn 
L65:    nop 
L66:    nop 
L67:    nop 
L68:    
    .end code 
.end method 

.method public static [137] : [138] 
    .attribute [132] .code stack 1 locals 1 
L0:     iload_0 
L1:     tableswitch 0 
            L28 
            L36 
            L44 
            default : L52 

L28:    iload_1 
L29:    anewarray [5] 
L32:    astore_2 
L33:    goto L54 
L36:    iload_1 
L37:    anewarray [6] 
L40:    astore_2 
L41:    goto L54 
L44:    iload_1 
L45:    anewarray [7] 
L48:    astore_2 
L49:    goto L54 
L52:    aconst_null 
L53:    astore_2 
L54:    aload_2 
L55:    areturn 
L56:    
    .end code 
.end method 

.method public static [139] : [140] 
    .attribute [132] .code stack 1 locals 0 
L0:     iload_0 
L1:     tableswitch 0 
            L28 
            L28 
            L28 
            default : L30 

L28:    iconst_1 
L29:    areturn 
L30:    iconst_0 
L31:    areturn 
L32:    
    .end code 
.end method 

.method public static [141] : [142] 
    .attribute [132] .code stack 2 locals 0 
L0:     iload_0 
L1:     tableswitch 0 
            L28 
            L53 
            L78 
            default : L103 

L28:    getstatic [8] 
L31:    ifnonnull L46 
L34:    ldc [9] 
L36:    invokestatic [10] 
L39:    dup 
L40:    putstatic [25] 
L43:    goto L49 
L46:    getstatic [8] 
L49:    invokevirtual [19] 
L52:    areturn 
L53:    getstatic [11] 
L56:    ifnonnull L71 
L59:    ldc [12] 
L61:    invokestatic [10] 
L64:    dup 
L65:    putstatic [26] 
L68:    goto L74 
L71:    getstatic [11] 
L74:    invokevirtual [19] 
L77:    areturn 
L78:    getstatic [13] 
L81:    ifnonnull L96 
L84:    ldc [14] 
L86:    invokestatic [10] 
L89:    dup 
L90:    putstatic [27] 
L93:    goto L99 
L96:    getstatic [13] 
L99:    invokevirtual [19] 
L102:   areturn 
L103:   aconst_null 
L104:   areturn 
L105:   nop 
L106:   nop 
L107:   nop 
L108:   
    .end code 
.end method 

.method static synthetic [143] : [144] 
    .attribute [132] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [28] 
L9:     dup 
L10:    invokespecial [20] 
L13:    aload_1 
L14:    invokevirtual [18] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [32] [33] 
.const [3] = Class [34] 
.const [4] = Class [35] 
.const [5] = Class [36] 
.const [6] = Class [37] 
.const [7] = Class [38] 
.const [8] = Field [39] [40] 
.const [9] = String [41] 
.const [10] = Method [42] [43] 
.const [11] = Field [44] [45] 
.const [12] = String [46] 
.const [13] = Field [47] [48] 
.const [14] = String [49] 
.const [15] = Class [50] 
.const [16] = Class [51] 
.const [17] = Class [52] 
.const [18] = Method [53] [54] 
.const [19] = Method [55] [56] 
.const [20] = Method [57] [58] 
.const [21] = Method [59] [60] 
.const [22] = Method [61] [62] 
.const [23] = Method [63] [64] 
.const [24] = Method [65] [66] 
.const [25] = Field [67] [68] 
.const [26] = Field [69] [70] 
.const [27] = Field [71] [72] 
.const [28] = Class [73] 
.const [29] = Class [74] 
.const [30] = Class [75] 
.const [31] = Class [76] 
.const [32] = Class [77] 
.const [33] = NameAndType [78] [79] 
.const [34] = Utf8 java/lang/ClassNotFoundException 
.const [35] = Utf8 java/lang/NoClassDefFoundError 
.const [36] = Utf8 de/audi/app/car/core/hybrid/StatisticsShortTermEntry 
.const [37] = Utf8 de/audi/app/car/core/hybrid/StatisticsLongTermEntry 
.const [38] = Utf8 de/audi/app/car/core/hybrid/StatisticsZeroEmissionEntry 
.const [39] = Class [80] 
.const [40] = NameAndType [81] [82] 
.const [41] = Utf8 'de.audi.app.car.core.hybrid.StatisticsShortTermEntry' 
.const [42] = Class [83] 
.const [43] = NameAndType [84] [85] 
.const [44] = Class [86] 
.const [45] = NameAndType [87] [88] 
.const [46] = Utf8 'de.audi.app.car.core.hybrid.StatisticsLongTermEntry' 
.const [47] = Class [89] 
.const [48] = NameAndType [90] [91] 
.const [49] = Utf8 'de.audi.app.car.core.hybrid.StatisticsZeroEmissionEntry' 
.const [50] = Utf8 de/audi/app/car/core/hybrid/HybridStatisticsTypeFactory 
.const [51] = Utf8 java/lang/Object 
.const [52] = Utf8 java/lang/Class 
.const [53] = Class [92] 
.const [54] = NameAndType [93] [94] 
.const [55] = Class [95] 
.const [56] = NameAndType [96] [97] 
.const [57] = Class [98] 
.const [58] = NameAndType [99] [100] 
.const [59] = Class [101] 
.const [60] = NameAndType [102] [103] 
.const [61] = Class [104] 
.const [62] = NameAndType [105] [106] 
.const [63] = Class [107] 
.const [64] = NameAndType [108] [109] 
.const [65] = Class [110] 
.const [66] = NameAndType [111] [112] 
.const [67] = Class [113] 
.const [68] = NameAndType [114] [115] 
.const [69] = Class [116] 
.const [70] = NameAndType [117] [118] 
.const [71] = Class [119] 
.const [72] = NameAndType [120] [121] 
.const [73] = Utf8 java/lang/NoClassDefFoundError 
.const [74] = Utf8 de/audi/app/car/core/hybrid/StatisticsShortTermEntry 
.const [75] = Utf8 de/audi/app/car/core/hybrid/StatisticsLongTermEntry 
.const [76] = Utf8 de/audi/app/car/core/hybrid/StatisticsZeroEmissionEntry 
.const [77] = Utf8 java/lang/Class 
.const [78] = Utf8 forName 
.const [79] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [80] = Utf8 de/audi/app/car/core/hybrid/HybridStatisticsTypeFactory 
.const [81] = Utf8 class$de$audi$app$car$core$hybrid$StatisticsShortTermEntry 
.const [82] = Utf8 Ljava/lang/Class; 
.const [83] = Utf8 de/audi/app/car/core/hybrid/HybridStatisticsTypeFactory 
.const [84] = Utf8 class$ 
.const [85] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [86] = Utf8 de/audi/app/car/core/hybrid/HybridStatisticsTypeFactory 
.const [87] = Utf8 class$de$audi$app$car$core$hybrid$StatisticsLongTermEntry 
.const [88] = Utf8 Ljava/lang/Class; 
.const [89] = Utf8 de/audi/app/car/core/hybrid/HybridStatisticsTypeFactory 
.const [90] = Utf8 class$de$audi$app$car$core$hybrid$StatisticsZeroEmissionEntry 
.const [91] = Utf8 Ljava/lang/Class; 
.const [92] = Utf8 java/lang/NoClassDefFoundError 
.const [93] = Utf8 initCause 
.const [94] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [95] = Utf8 java/lang/Class 
.const [96] = Utf8 getName 
.const [97] = Utf8 ()Ljava/lang/String; 
.const [98] = Utf8 java/lang/NoClassDefFoundError 
.const [99] = Utf8 <init> 
.const [100] = Utf8 ()V 
.const [101] = Utf8 java/lang/Object 
.const [102] = Utf8 <init> 
.const [103] = Utf8 ()V 
.const [104] = Utf8 de/audi/app/car/core/hybrid/StatisticsShortTermEntry 
.const [105] = Utf8 <init> 
.const [106] = Utf8 ()V 
.const [107] = Utf8 de/audi/app/car/core/hybrid/StatisticsLongTermEntry 
.const [108] = Utf8 <init> 
.const [109] = Utf8 ()V 
.const [110] = Utf8 de/audi/app/car/core/hybrid/StatisticsZeroEmissionEntry 
.const [111] = Utf8 <init> 
.const [112] = Utf8 ()V 
.const [113] = Utf8 de/audi/app/car/core/hybrid/HybridStatisticsTypeFactory 
.const [114] = Utf8 class$de$audi$app$car$core$hybrid$StatisticsShortTermEntry 
.const [115] = Utf8 Ljava/lang/Class; 
.const [116] = Utf8 de/audi/app/car/core/hybrid/HybridStatisticsTypeFactory 
.const [117] = Utf8 class$de$audi$app$car$core$hybrid$StatisticsLongTermEntry 
.const [118] = Utf8 Ljava/lang/Class; 
.const [119] = Utf8 de/audi/app/car/core/hybrid/HybridStatisticsTypeFactory 
.const [120] = Utf8 class$de$audi$app$car$core$hybrid$StatisticsZeroEmissionEntry 
.const [121] = Utf8 Ljava/lang/Class; 
.const [122] = Utf8 de/audi/app/car/core/hybrid/HybridStatisticsTypeFactory 
.const [123] = Class [122] 
.const [124] = Utf8 java/lang/Object 
.const [125] = Class [124] 
.const [126] = Utf8 class$de$audi$app$car$core$hybrid$StatisticsShortTermEntry 
.const [127] = Utf8 Ljava/lang/Class; 
.const [128] = Utf8 class$de$audi$app$car$core$hybrid$StatisticsLongTermEntry 
.const [129] = Utf8 Ljava/lang/Class; 
.const [130] = Utf8 class$de$audi$app$car$core$hybrid$StatisticsZeroEmissionEntry 
.const [131] = Utf8 Ljava/lang/Class; 
.const [132] = Utf8 Code 
.const [133] = Utf8 <init> 
.const [134] = Utf8 ()V 
.const [135] = Utf8 create 
.const [136] = Utf8 (I)Lde/audi/app/car/core/hybrid/IMemoryBufferEntry; 
.const [137] = Utf8 create 
.const [138] = Utf8 (II)[Lde/audi/app/car/core/hybrid/IMemoryBufferEntry; 
.const [139] = Utf8 isSupported 
.const [140] = Utf8 (I)Z 
.const [141] = Utf8 getEntryClassName 
.const [142] = Utf8 (I)Ljava/lang/String; 
.const [143] = Utf8 class$ 
.const [144] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
