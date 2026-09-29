.version 50 0 
.class public super abstract [119] 
.super [121] 
.implements [123] 
.field private final [124] [125] 
.field private final [126] [127] 
.field private final [128] [129] 

.method public [131] : [132] 
    .attribute [130] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [22] 
L4:     aload_0 
L5:     iload_1 
L6:     putfield [28] 
L9:     aload_0 
L10:    iload_2 
L11:    putfield [29] 
L14:    aload_0 
L15:    iload_3 
L16:    putfield [30] 
L19:    return 
L20:    
    .end code 
.end method 

.method public interface [133] : [134] 
    .attribute [130] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [17] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [135] : [136] 
    .attribute [130] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [18] 
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
L1:     getfield [19] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [139] : [140] 
    .attribute [130] .code stack 3 locals 1 
L0:     new [31] 
L3:     dup 
L4:     bipush 100 
L6:     invokespecial [23] 
L9:     astore_1 
L10:    aload_1 
L11:    ldc [3] 
L13:    invokevirtual [20] 
L16:    pop 
L17:    aload_1 
L18:    aload_0 
L19:    aload_0 
L20:    getfield [17] 
L23:    invokespecial [24] 
L26:    invokevirtual [20] 
L29:    pop 
L30:    aload_1 
L31:    ldc [4] 
L33:    invokevirtual [20] 
L36:    pop 
L37:    aload_1 
L38:    aload_0 
L39:    aload_0 
L40:    getfield [18] 
L43:    invokespecial [25] 
L46:    invokevirtual [20] 
L49:    pop 
L50:    aload_1 
L51:    ldc [5] 
L53:    invokevirtual [20] 
L56:    pop 
L57:    aload_1 
L58:    aload_0 
L59:    aload_0 
L60:    getfield [19] 
L63:    invokespecial [26] 
L66:    invokevirtual [20] 
L69:    pop 
L70:    aload_1 
L71:    ldc [6] 
L73:    invokevirtual [20] 
L76:    pop 
L77:    aload_1 
L78:    invokevirtual [21] 
L81:    areturn 
L82:    nop 
L83:    nop 
L84:    
    .end code 
.end method 

.method private [141] : [142] 
    .attribute [130] .code stack 1 locals 0 
L0:     iload_1 
L1:     lookupswitch 
            1 : L31 
            2 : L28 
            default : L34 

L28:    ldc [7] 
L30:    areturn 
L31:    ldc [8] 
L33:    areturn 
L34:    ldc [9] 
L36:    areturn 
L37:    nop 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method private [143] : [144] 
    .attribute [130] .code stack 1 locals 0 
L0:     iload_1 
L1:     lookupswitch 
            1 : L31 
            2 : L28 
            default : L34 

L28:    ldc [10] 
L30:    areturn 
L31:    ldc [11] 
L33:    areturn 
L34:    ldc [9] 
L36:    areturn 
L37:    nop 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method private [145] : [146] 
    .attribute [130] .code stack 1 locals 0 
L0:     iload_1 
L1:     tableswitch 1 
            L31 
            L28 
            L34 
            default : L37 

L28:    ldc [12] 
L30:    areturn 
L31:    ldc [13] 
L33:    areturn 
L34:    ldc [14] 
L36:    areturn 
L37:    ldc [9] 
L39:    areturn 
L40:    
    .end code 
.end method 

.method public [147] : [148] 
    .attribute [130] .code stack 2 locals 2 
L0:     iconst_1 
L1:     istore_2 
L2:     bipush 31 
L4:     iload_2 
L5:     imul 
L6:     aload_0 
L7:     getfield [17] 
L10:    iadd 
L11:    istore_2 
L12:    bipush 31 
L14:    iload_2 
L15:    imul 
L16:    aload_0 
L17:    getfield [18] 
L20:    iadd 
L21:    istore_2 
L22:    bipush 31 
L24:    iload_2 
L25:    imul 
L26:    aload_0 
L27:    getfield [19] 
L30:    iadd 
L31:    istore_2 
L32:    iload_2 
L33:    areturn 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [149] : [150] 
    .attribute [130] .code stack 2 locals 1 
L0:     aload_0 
L1:     aload_1 
L2:     if_acmpne L7 
L5:     iconst_1 
L6:     areturn 
L7:     aload_1 
L8:     ifnonnull L13 
L11:    iconst_0 
L12:    areturn 
L13:    aload_0 
L14:    invokespecial [27] 
L17:    aload_1 
L18:    invokespecial [27] 
L21:    if_acmpeq L26 
L24:    iconst_0 
L25:    areturn 
L26:    aload_1 
L27:    checkcast [15] 
L30:    astore_2 
L31:    aload_0 
L32:    getfield [17] 
L35:    aload_2 
L36:    getfield [17] 
L39:    if_icmpeq L44 
L42:    iconst_0 
L43:    areturn 
L44:    aload_0 
L45:    getfield [18] 
L48:    aload_2 
L49:    getfield [18] 
L52:    if_icmpeq L57 
L55:    iconst_0 
L56:    areturn 
L57:    aload_0 
L58:    getfield [19] 
L61:    aload_2 
L62:    getfield [19] 
L65:    if_icmpeq L70 
L68:    iconst_0 
L69:    areturn 
L70:    iconst_1 
L71:    areturn 
L72:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [32] 
.const [3] = String [33] 
.const [4] = String [34] 
.const [5] = String [35] 
.const [6] = String [36] 
.const [7] = String [37] 
.const [8] = String [38] 
.const [9] = String [39] 
.const [10] = String [40] 
.const [11] = String [41] 
.const [12] = String [42] 
.const [13] = String [43] 
.const [14] = String [44] 
.const [15] = Class [45] 
.const [16] = Class [46] 
.const [17] = Field [47] [48] 
.const [18] = Field [49] [50] 
.const [19] = Field [51] [52] 
.const [20] = Method [53] [54] 
.const [21] = Method [55] [56] 
.const [22] = Method [57] [58] 
.const [23] = Method [59] [60] 
.const [24] = Method [61] [62] 
.const [25] = Method [63] [64] 
.const [26] = Method [65] [66] 
.const [27] = Method [67] [68] 
.const [28] = Field [69] [70] 
.const [29] = Field [71] [72] 
.const [30] = Field [73] [74] 
.const [31] = Class [75] 
.const [32] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [33] = Utf8 'AppState [appStateId=' 
.const [34] = Utf8 ', owner=' 
.const [35] = Utf8 ', speechMode=' 
.const [36] = Utf8 ']' 
.const [37] = Utf8 RECOGNIZING 
.const [38] = Utf8 SPEEKING 
.const [39] = Utf8 UNKNOWN 
.const [40] = Utf8 DEVICE 
.const [41] = Utf8 MAINUNIT 
.const [42] = Utf8 NAVI 
.const [43] = Utf8 PHONE 
.const [44] = Utf8 SPEECH 
.const [45] = Utf8 de/audi/app/terminalmode/dsi/AbstractAppState 
.const [46] = Utf8 java/lang/Object 
.const [47] = Class [76] 
.const [48] = NameAndType [77] [78] 
.const [49] = Class [79] 
.const [50] = NameAndType [80] [81] 
.const [51] = Class [82] 
.const [52] = NameAndType [83] [84] 
.const [53] = Class [85] 
.const [54] = NameAndType [86] [87] 
.const [55] = Class [88] 
.const [56] = NameAndType [89] [90] 
.const [57] = Class [91] 
.const [58] = NameAndType [92] [93] 
.const [59] = Class [94] 
.const [60] = NameAndType [95] [96] 
.const [61] = Class [97] 
.const [62] = NameAndType [98] [99] 
.const [63] = Class [100] 
.const [64] = NameAndType [101] [102] 
.const [65] = Class [103] 
.const [66] = NameAndType [104] [105] 
.const [67] = Class [106] 
.const [68] = NameAndType [107] [108] 
.const [69] = Class [109] 
.const [70] = NameAndType [110] [111] 
.const [71] = Class [112] 
.const [72] = NameAndType [113] [114] 
.const [73] = Class [115] 
.const [74] = NameAndType [116] [117] 
.const [75] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [76] = Utf8 de/audi/app/terminalmode/dsi/AbstractAppState 
.const [77] = Utf8 appStateId 
.const [78] = Utf8 I 
.const [79] = Utf8 de/audi/app/terminalmode/dsi/AbstractAppState 
.const [80] = Utf8 owner 
.const [81] = Utf8 I 
.const [82] = Utf8 de/audi/app/terminalmode/dsi/AbstractAppState 
.const [83] = Utf8 speechMode 
.const [84] = Utf8 I 
.const [85] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [86] = Utf8 append 
.const [87] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [88] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [89] = Utf8 toString 
.const [90] = Utf8 ()Ljava/lang/String; 
.const [91] = Utf8 java/lang/Object 
.const [92] = Utf8 <init> 
.const [93] = Utf8 ()V 
.const [94] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [95] = Utf8 <init> 
.const [96] = Utf8 (I)V 
.const [97] = Utf8 de/audi/app/terminalmode/dsi/AbstractAppState 
.const [98] = Utf8 getApplicationString 
.const [99] = Utf8 (I)Ljava/lang/String; 
.const [100] = Utf8 de/audi/app/terminalmode/dsi/AbstractAppState 
.const [101] = Utf8 getOwnerString 
.const [102] = Utf8 (I)Ljava/lang/String; 
.const [103] = Utf8 de/audi/app/terminalmode/dsi/AbstractAppState 
.const [104] = Utf8 getSpeechModeString 
.const [105] = Utf8 (I)Ljava/lang/String; 
.const [106] = Utf8 java/lang/Object 
.const [107] = Utf8 getClass 
.const [108] = Utf8 ()Ljava/lang/Class; 
.const [109] = Utf8 de/audi/app/terminalmode/dsi/AbstractAppState 
.const [110] = Utf8 appStateId 
.const [111] = Utf8 I 
.const [112] = Utf8 de/audi/app/terminalmode/dsi/AbstractAppState 
.const [113] = Utf8 owner 
.const [114] = Utf8 I 
.const [115] = Utf8 de/audi/app/terminalmode/dsi/AbstractAppState 
.const [116] = Utf8 speechMode 
.const [117] = Utf8 I 
.const [118] = Utf8 de/audi/app/terminalmode/dsi/AbstractAppState 
.const [119] = Class [118] 
.const [120] = Utf8 java/lang/Object 
.const [121] = Class [120] 
.const [122] = Utf8 de/audi/app/terminalmode/dsi/IAppState 
.const [123] = Class [122] 
.const [124] = Utf8 appStateId 
.const [125] = Utf8 I 
.const [126] = Utf8 owner 
.const [127] = Utf8 I 
.const [128] = Utf8 speechMode 
.const [129] = Utf8 I 
.const [130] = Utf8 Code 
.const [131] = Utf8 <init> 
.const [132] = Utf8 (III)V 
.const [133] = Utf8 getAppStateId 
.const [134] = Utf8 ()I 
.const [135] = Utf8 getOwner 
.const [136] = Utf8 ()I 
.const [137] = Utf8 getSpeechMode 
.const [138] = Utf8 ()I 
.const [139] = Utf8 toString 
.const [140] = Utf8 ()Ljava/lang/String; 
.const [141] = Utf8 getSpeechModeString 
.const [142] = Utf8 (I)Ljava/lang/String; 
.const [143] = Utf8 getOwnerString 
.const [144] = Utf8 (I)Ljava/lang/String; 
.const [145] = Utf8 getApplicationString 
.const [146] = Utf8 (I)Ljava/lang/String; 
.const [147] = Utf8 hashCode 
.const [148] = Utf8 ()I 
.const [149] = Utf8 equals 
.const [150] = Utf8 (Ljava/lang/Object;)Z 
.end class 
