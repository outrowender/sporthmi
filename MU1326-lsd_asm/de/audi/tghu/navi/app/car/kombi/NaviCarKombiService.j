.version 50 0 
.class public super [117] 
.super [119] 
.implements [121] 
.implements [123] 
.field private final [124] [125] 
.field private [126] [127] 
.field private [128] [129] 

.method public [131] : [132] 
    .attribute [130] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [22] 
L4:     aload_0 
L5:     iconst_4 
L6:     putfield [24] 
L9:     aload_0 
L10:    iconst_4 
L11:    putfield [25] 
L14:    aload_0 
L15:    aload_1 
L16:    putfield [26] 
L19:    aload_2 
L20:    aload_0 
L21:    invokeinterface [27] 0 
L26:    return 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [133] : [134] 
    .attribute [130] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [14] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     aload_1 
L9:     invokevirtual [15] 
L12:    pop 
L13:    aload_1 
L14:    invokevirtual [16] 
L17:    astore_2 
L18:    aload_2 
L19:    ifnonnull L35 
L22:    aload_0 
L23:    getfield [14] 
L26:    ldc [4] 
L28:    ldc [5] 
L30:    invokevirtual [17] 
L33:    pop 
L34:    return 
L35:    aload_0 
L36:    aload_2 
L37:    invokevirtual [18] 
L40:    putfield [24] 
L43:    aload_0 
L44:    aload_2 
L45:    invokevirtual [19] 
L48:    putfield [25] 
L51:    return 
L52:    
    .end code 
.end method 

.method public interface [135] : [136] 
    .attribute [130] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [12] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [137] : [138] 
    .attribute [130] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [139] : [140] 
    .attribute [130] .code stack 2 locals 1 
L0:     aload_0 
L1:     aload_0 
L2:     invokevirtual [20] 
L5:     invokespecial [23] 
L8:     ifeq L18 
L11:    aload_0 
L12:    invokevirtual [21] 
L15:    goto L22 
L18:    aload_0 
L19:    invokevirtual [20] 
L22:    istore_1 
L23:    iload_1 
L24:    areturn 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [141] : [142] 
    .attribute [130] .code stack 2 locals 1 
L0:     aload_0 
L1:     aload_0 
L2:     invokevirtual [21] 
L5:     invokespecial [23] 
L8:     ifeq L18 
L11:    aload_0 
L12:    invokevirtual [21] 
L15:    goto L22 
L18:    aload_0 
L19:    invokevirtual [20] 
L22:    istore_1 
L23:    iload_1 
L24:    areturn 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method private [143] : [144] 
    .attribute [130] .code stack 2 locals 0 
L0:     iload_1 
L1:     iconst_3 
L2:     if_icmpeq L17 
L5:     iload_1 
L6:     bipush 8 
L8:     if_icmpeq L17 
L11:    iload_1 
L12:    bipush 9 
L14:    if_icmpne L21 
L17:    iconst_1 
L18:    goto L22 
L21:    iconst_0 
L22:    areturn 
L23:    nop 
L24:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [28] 
.const [4] = Int 1078071040 
.const [5] = String [29] 
.const [6] = Class [30] 
.const [7] = Class [31] 
.const [8] = Class [32] 
.const [9] = Class [33] 
.const [10] = Class [34] 
.const [11] = Class [35] 
.const [12] = Field [36] [37] 
.const [13] = Field [38] [39] 
.const [14] = Field [40] [41] 
.const [15] = Method [42] [43] 
.const [16] = Method [44] [45] 
.const [17] = Method [46] [47] 
.const [18] = Method [48] [49] 
.const [19] = Method [50] [51] 
.const [20] = Method [52] [53] 
.const [21] = Method [54] [55] 
.const [22] = Method [56] [57] 
.const [23] = Method [58] [59] 
.const [24] = Field [60] [61] 
.const [25] = Field [62] [63] 
.const [26] = Field [64] [65] 
.const [27] = InterfaceMethod [66] [67] 
.const [28] = Utf8 'NaviDSICarKombiListener#updateBCViewOptions( %1 )' 
.const [29] = Utf8 'NaviDSICarKombiListener#updateBCViewOptions() - configuration is null' 
.const [30] = Utf8 de/audi/tghu/navi/app/car/kombi/NaviCarKombiService 
.const [31] = Utf8 java/lang/Object 
.const [32] = Utf8 de/audi/tghu/navi/app/car/kombi/ICarKombiEventsProvider 
.const [33] = Utf8 de/audi/atip/log/LogChannel 
.const [34] = Utf8 org/dsi/ifc/carkombi/BCViewOptions 
.const [35] = Utf8 org/dsi/ifc/carkombi/BCConfiguration 
.const [36] = Class [68] 
.const [37] = NameAndType [69] [70] 
.const [38] = Class [71] 
.const [39] = NameAndType [72] [73] 
.const [40] = Class [74] 
.const [41] = NameAndType [75] [76] 
.const [42] = Class [77] 
.const [43] = NameAndType [78] [79] 
.const [44] = Class [80] 
.const [45] = NameAndType [81] [82] 
.const [46] = Class [83] 
.const [47] = NameAndType [84] [85] 
.const [48] = Class [86] 
.const [49] = NameAndType [87] [88] 
.const [50] = Class [89] 
.const [51] = NameAndType [90] [91] 
.const [52] = Class [92] 
.const [53] = NameAndType [93] [94] 
.const [54] = Class [95] 
.const [55] = NameAndType [96] [97] 
.const [56] = Class [98] 
.const [57] = NameAndType [99] [100] 
.const [58] = Class [101] 
.const [59] = NameAndType [102] [103] 
.const [60] = Class [104] 
.const [61] = NameAndType [105] [106] 
.const [62] = Class [107] 
.const [63] = NameAndType [108] [109] 
.const [64] = Class [110] 
.const [65] = NameAndType [111] [112] 
.const [66] = Class [113] 
.const [67] = NameAndType [114] [115] 
.const [68] = Utf8 de/audi/tghu/navi/app/car/kombi/NaviCarKombiService 
.const [69] = Utf8 engineTypePrimary 
.const [70] = Utf8 I 
.const [71] = Utf8 de/audi/tghu/navi/app/car/kombi/NaviCarKombiService 
.const [72] = Utf8 engineTypeSecondary 
.const [73] = Utf8 I 
.const [74] = Utf8 de/audi/tghu/navi/app/car/kombi/NaviCarKombiService 
.const [75] = Utf8 logChannel 
.const [76] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [77] = Utf8 de/audi/atip/log/LogChannel 
.const [78] = Utf8 log 
.const [79] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [80] = Utf8 org/dsi/ifc/carkombi/BCViewOptions 
.const [81] = Utf8 getConfiguration 
.const [82] = Utf8 ()Lorg/dsi/ifc/carkombi/BCConfiguration; 
.const [83] = Utf8 de/audi/atip/log/LogChannel 
.const [84] = Utf8 log 
.const [85] = Utf8 (ILjava/lang/String;)Z 
.const [86] = Utf8 org/dsi/ifc/carkombi/BCConfiguration 
.const [87] = Utf8 getPrimaryEngineType 
.const [88] = Utf8 ()I 
.const [89] = Utf8 org/dsi/ifc/carkombi/BCConfiguration 
.const [90] = Utf8 getSecondaryEngineType 
.const [91] = Utf8 ()I 
.const [92] = Utf8 de/audi/tghu/navi/app/car/kombi/NaviCarKombiService 
.const [93] = Utf8 getEngineTypeSecondary 
.const [94] = Utf8 ()I 
.const [95] = Utf8 de/audi/tghu/navi/app/car/kombi/NaviCarKombiService 
.const [96] = Utf8 getEngineTypePrimary 
.const [97] = Utf8 ()I 
.const [98] = Utf8 java/lang/Object 
.const [99] = Utf8 <init> 
.const [100] = Utf8 ()V 
.const [101] = Utf8 de/audi/tghu/navi/app/car/kombi/NaviCarKombiService 
.const [102] = Utf8 isFuelTypeAlternative 
.const [103] = Utf8 (I)Z 
.const [104] = Utf8 de/audi/tghu/navi/app/car/kombi/NaviCarKombiService 
.const [105] = Utf8 engineTypePrimary 
.const [106] = Utf8 I 
.const [107] = Utf8 de/audi/tghu/navi/app/car/kombi/NaviCarKombiService 
.const [108] = Utf8 engineTypeSecondary 
.const [109] = Utf8 I 
.const [110] = Utf8 de/audi/tghu/navi/app/car/kombi/NaviCarKombiService 
.const [111] = Utf8 logChannel 
.const [112] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [113] = Utf8 de/audi/tghu/navi/app/car/kombi/ICarKombiEventsProvider 
.const [114] = Utf8 registerListener 
.const [115] = Utf8 (Lde/audi/tghu/navi/app/car/kombi/ICarKombiObserver;)V 
.const [116] = Utf8 de/audi/tghu/navi/app/car/kombi/NaviCarKombiService 
.const [117] = Class [116] 
.const [118] = Utf8 java/lang/Object 
.const [119] = Class [118] 
.const [120] = Utf8 de/audi/tghu/navi/app/car/kombi/ICarKombiObserver 
.const [121] = Class [120] 
.const [122] = Utf8 de/audi/tghu/navi/app/car/kombi/ICarKombiService 
.const [123] = Class [122] 
.const [124] = Utf8 logChannel 
.const [125] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [126] = Utf8 engineTypePrimary 
.const [127] = Utf8 I 
.const [128] = Utf8 engineTypeSecondary 
.const [129] = Utf8 I 
.const [130] = Utf8 Code 
.const [131] = Utf8 <init> 
.const [132] = Utf8 (Lde/audi/atip/log/LogChannel;Lde/audi/tghu/navi/app/car/kombi/ICarKombiEventsProvider;)V 
.const [133] = Utf8 updateBCViewOptions 
.const [134] = Utf8 (Lorg/dsi/ifc/carkombi/BCViewOptions;)V 
.const [135] = Utf8 getEngineTypePrimary 
.const [136] = Utf8 ()I 
.const [137] = Utf8 getEngineTypeSecondary 
.const [138] = Utf8 ()I 
.const [139] = Utf8 getConventionalEngineType 
.const [140] = Utf8 ()I 
.const [141] = Utf8 getAlternativeEngineType 
.const [142] = Utf8 ()I 
.const [143] = Utf8 isFuelTypeAlternative 
.const [144] = Utf8 (I)Z 
.end class 
