.version 50 0 
.class public super [97] 
.super [99] 
.field private static final [100] [101] 
.field private static final [102] [103] 
.field private static final [104] [105] 
.field private static final [106] [107] 
.field private final [108] [109] 
.field private final [110] [111] 
.field private final [112] [113] 
.field private final [114] [115] 
.field private final [116] [117] 
.field private final [118] [119] 
.field public static final [120] [121] 
.field public static final [122] [123] 

.method public [125] : [126] 
    .attribute [124] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [13] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [14] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [15] 
L14:    aload_0 
L15:    aload_1 
L16:    sipush 167 
L19:    invokevirtual [8] 
L22:    putfield [16] 
L25:    aload_0 
L26:    aload_1 
L27:    sipush 4181 
L30:    invokevirtual [8] 
L33:    putfield [17] 
L36:    aload_0 
L37:    aload_1 
L38:    sipush 161 
L41:    invokevirtual [8] 
L44:    putfield [18] 
L47:    aload_0 
L48:    aload_1 
L49:    sipush 177 
L52:    invokevirtual [8] 
L55:    putfield [19] 
L58:    return 
L59:    nop 
L60:    
    .end code 
.end method 

.method public [127] : [128] 
    .attribute [124] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     iconst_0 
L5:     invokeinterface [20] 0 
L10:    aload_0 
L11:    getfield [9] 
L14:    iconst_0 
L15:    invokeinterface [20] 0 
L20:    aload_0 
L21:    getfield [9] 
L24:    iconst_1 
L25:    invokestatic [2] 
L28:    aload_0 
L29:    getfield [10] 
L32:    iconst_1 
L33:    invokeinterface [20] 0 
L38:    aload_0 
L39:    getfield [12] 
L42:    iconst_0 
L43:    invokeinterface [20] 0 
L48:    return 
L49:    nop 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [129] : [130] 
    .attribute [124] .code stack 2 locals 3 
L0:     iload_1 
L1:     iconst_2 
L2:     if_icmpne L16 
L5:     iconst_0 
L6:     istore_3 
L7:     iconst_1 
L8:     istore 4 
L10:    iconst_1 
L11:    istore 5 
L13:    goto L65 
L16:    iload_1 
L17:    iconst_4 
L18:    if_icmpne L32 
L21:    iload_2 
L22:    istore_3 
L23:    iconst_0 
L24:    istore 4 
L26:    iconst_2 
L27:    istore 5 
L29:    goto L65 
L32:    iload_1 
L33:    iconst_3 
L34:    if_icmpne L48 
L37:    iconst_0 
L38:    istore_3 
L39:    iconst_m1 
L40:    istore 4 
L42:    iconst_1 
L43:    istore 5 
L45:    goto L65 
L48:    iload_1 
L49:    iconst_1 
L50:    if_icmpne L64 
L53:    iconst_0 
L54:    istore_3 
L55:    iconst_0 
L56:    istore 4 
L58:    iconst_0 
L59:    istore 5 
L61:    goto L65 
L64:    return 
L65:    aload_0 
L66:    getfield [11] 
L69:    iload_3 
L70:    invokeinterface [20] 0 
L75:    aload_0 
L76:    getfield [9] 
L79:    iload 4 
L81:    invokeinterface [20] 0 
L86:    aload_0 
L87:    getfield [9] 
L90:    iload 5 
L92:    invokestatic [2] 
L95:    aload_0 
L96:    getfield [10] 
L99:    iload 5 
L101:   invokeinterface [20] 0 
L106:   return 
L107:   nop 
L108:   
    .end code 
.end method 

.method public [131] : [132] 
    .attribute [124] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [12] 
L4:     iload_1 
L5:     ifeq L12 
L8:     iconst_1 
L9:     goto L13 
L12:    iconst_0 
L13:    invokeinterface [20] 0 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public interface [133] : [134] 
    .attribute [124] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [9] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [21] [22] 
.const [3] = Class [23] 
.const [4] = Class [24] 
.const [5] = Class [25] 
.const [6] = Class [26] 
.const [7] = Class [27] 
.const [8] = Method [28] [29] 
.const [9] = Field [30] [31] 
.const [10] = Field [32] [33] 
.const [11] = Field [34] [35] 
.const [12] = Field [36] [37] 
.const [13] = Method [38] [39] 
.const [14] = Field [40] [41] 
.const [15] = Field [42] [43] 
.const [16] = Field [44] [45] 
.const [17] = Field [46] [47] 
.const [18] = Field [48] [49] 
.const [19] = Field [50] [51] 
.const [20] = InterfaceMethod [52] [53] 
.const [21] = Class [54] 
.const [22] = NameAndType [55] [56] 
.const [23] = Utf8 de/audi/tghu/navi/app/OperationManagerModelAccess 
.const [24] = Utf8 java/lang/Object 
.const [25] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [26] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [27] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [28] = Class [57] 
.const [29] = NameAndType [58] [59] 
.const [30] = Class [60] 
.const [31] = NameAndType [61] [62] 
.const [32] = Class [63] 
.const [33] = NameAndType [64] [65] 
.const [34] = Class [66] 
.const [35] = NameAndType [67] [68] 
.const [36] = Class [69] 
.const [37] = NameAndType [70] [71] 
.const [38] = Class [72] 
.const [39] = NameAndType [73] [74] 
.const [40] = Class [75] 
.const [41] = NameAndType [76] [77] 
.const [42] = Class [78] 
.const [43] = NameAndType [79] [80] 
.const [44] = Class [81] 
.const [45] = NameAndType [82] [83] 
.const [46] = Class [84] 
.const [47] = NameAndType [85] [86] 
.const [48] = Class [87] 
.const [49] = NameAndType [88] [89] 
.const [50] = Class [90] 
.const [51] = NameAndType [91] [92] 
.const [52] = Class [93] 
.const [53] = NameAndType [94] [95] 
.const [54] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [55] = Utf8 setModelStatus 
.const [56] = Utf8 (Lde/audi/atip/hmi/modelaccess/HMIModelApp;I)V 
.const [57] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [58] = Utf8 getChoiceModel 
.const [59] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [60] = Utf8 de/audi/tghu/navi/app/OperationManagerModelAccess 
.const [61] = Utf8 initializationChoice 
.const [62] = Utf8 Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [63] = Utf8 de/audi/tghu/navi/app/OperationManagerModelAccess 
.const [64] = Utf8 initializationMediatorChoice 
.const [65] = Utf8 Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [66] = Utf8 de/audi/tghu/navi/app/OperationManagerModelAccess 
.const [67] = Utf8 errorChoice 
.const [68] = Utf8 Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [69] = Utf8 de/audi/tghu/navi/app/OperationManagerModelAccess 
.const [70] = Utf8 naviReady2navigateChoice 
.const [71] = Utf8 Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [72] = Utf8 java/lang/Object 
.const [73] = Utf8 <init> 
.const [74] = Utf8 ()V 
.const [75] = Utf8 de/audi/tghu/navi/app/OperationManagerModelAccess 
.const [76] = Utf8 env 
.const [77] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [78] = Utf8 de/audi/tghu/navi/app/OperationManagerModelAccess 
.const [79] = Utf8 logChannel 
.const [80] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [81] = Utf8 de/audi/tghu/navi/app/OperationManagerModelAccess 
.const [82] = Utf8 initializationChoice 
.const [83] = Utf8 Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [84] = Utf8 de/audi/tghu/navi/app/OperationManagerModelAccess 
.const [85] = Utf8 initializationMediatorChoice 
.const [86] = Utf8 Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [87] = Utf8 de/audi/tghu/navi/app/OperationManagerModelAccess 
.const [88] = Utf8 errorChoice 
.const [89] = Utf8 Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [90] = Utf8 de/audi/tghu/navi/app/OperationManagerModelAccess 
.const [91] = Utf8 naviReady2navigateChoice 
.const [92] = Utf8 Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [93] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [94] = Utf8 setValue 
.const [95] = Utf8 (I)V 
.const [96] = Utf8 de/audi/tghu/navi/app/OperationManagerModelAccess 
.const [97] = Class [96] 
.const [98] = Utf8 java/lang/Object 
.const [99] = Class [98] 
.const [100] = Utf8 CHOICE_INIT_VALUE_NOTCALIBRATED 
.const [101] = Utf8 I 
.const [102] = Utf8 CHOICE_INIT_VALUE_UNDEFINED 
.const [103] = Utf8 I 
.const [104] = Utf8 CHOICE_INIT_VALUE_AVAILABLE 
.const [105] = Utf8 I 
.const [106] = Utf8 CHOICE_ERROR_DEFAULT 
.const [107] = Utf8 I 
.const [108] = Utf8 env 
.const [109] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [110] = Utf8 logChannel 
.const [111] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [112] = Utf8 initializationChoice 
.const [113] = Utf8 Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [114] = Utf8 initializationMediatorChoice 
.const [115] = Utf8 Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [116] = Utf8 errorChoice 
.const [117] = Utf8 Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [118] = Utf8 naviReady2navigateChoice 
.const [119] = Utf8 Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [120] = Utf8 CHOICE_READY_TO_NAVIGATE_TRUE 
.const [121] = Utf8 I 
.const [122] = Utf8 CHOICE_READY_TO_NAVIGATE_FALSE 
.const [123] = Utf8 I 
.const [124] = Utf8 Code 
.const [125] = Utf8 <init> 
.const [126] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;Lde/audi/atip/log/LogChannel;)V 
.const [127] = Utf8 onStart 
.const [128] = Utf8 ()V 
.const [129] = Utf8 onNavStateUpdated 
.const [130] = Utf8 (II)V 
.const [131] = Utf8 onPropagateStateToOtherApps 
.const [132] = Utf8 (Z)V 
.const [133] = Utf8 getInitializationChoice 
.const [134] = Utf8 ()Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.end class 
