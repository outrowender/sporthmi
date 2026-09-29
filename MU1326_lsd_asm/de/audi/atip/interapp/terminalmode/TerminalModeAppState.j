.version 50 0 
.class public super [93] 
.super [95] 
.field public static final [96] [97] 
.field public static final [98] [99] 
.field public static final [100] [101] 
.field public static final [102] [103] 
.field private final [104] [105] 
.field private final [106] [107] 

.method public [109] : [110] 
    .attribute [108] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [19] 
L4:     aload_0 
L5:     iload_1 
L6:     putfield [22] 
L9:     aload_0 
L10:    iload_2 
L11:    putfield [23] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public interface [111] : [112] 
    .attribute [108] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [113] : [114] 
    .attribute [108] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [115] : [116] 
    .attribute [108] .code stack 2 locals 2 
L0:     iconst_1 
L1:     istore_2 
L2:     bipush 31 
L4:     iload_2 
L5:     imul 
L6:     aload_0 
L7:     getfield [13] 
L10:    iadd 
L11:    istore_2 
L12:    bipush 31 
L14:    iload_2 
L15:    imul 
L16:    aload_0 
L17:    getfield [14] 
L20:    ifeq L29 
L23:    sipush 1231 
L26:    goto L32 
L29:    sipush 1237 
L32:    iadd 
L33:    istore_2 
L34:    iload_2 
L35:    areturn 
L36:    
    .end code 
.end method 

.method public [117] : [118] 
    .attribute [108] .code stack 2 locals 1 
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
L14:    invokespecial [20] 
L17:    aload_1 
L18:    invokespecial [20] 
L21:    if_acmpeq L26 
L24:    iconst_0 
L25:    areturn 
L26:    aload_1 
L27:    checkcast [2] 
L30:    astore_2 
L31:    aload_0 
L32:    getfield [13] 
L35:    aload_2 
L36:    getfield [13] 
L39:    if_icmpeq L44 
L42:    iconst_0 
L43:    areturn 
L44:    aload_0 
L45:    getfield [14] 
L48:    aload_2 
L49:    getfield [14] 
L52:    if_icmpeq L57 
L55:    iconst_0 
L56:    areturn 
L57:    iconst_1 
L58:    areturn 
L59:    nop 
L60:    
    .end code 
.end method 

.method public [119] : [120] 
    .attribute [108] .code stack 2 locals 1 
L0:     new [24] 
L3:     dup 
L4:     invokespecial [21] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [4] 
L11:    invokevirtual [15] 
L14:    aload_0 
L15:    getfield [13] 
L18:    invokevirtual [16] 
L21:    ldc [5] 
L23:    invokevirtual [15] 
L26:    pop 
L27:    aload_0 
L28:    getfield [13] 
L31:    tableswitch 0 
            L60 
            L70 
            L80 
            L90 
            default : L100 

L60:    aload_1 
L61:    ldc [6] 
L63:    invokevirtual [15] 
L66:    pop 
L67:    goto L107 
L70:    aload_1 
L71:    ldc [7] 
L73:    invokevirtual [15] 
L76:    pop 
L77:    goto L107 
L80:    aload_1 
L81:    ldc [8] 
L83:    invokevirtual [15] 
L86:    pop 
L87:    goto L107 
L90:    aload_1 
L91:    ldc [9] 
L93:    invokevirtual [15] 
L96:    pop 
L97:    goto L107 
L100:   aload_1 
L101:   ldc [10] 
L103:   invokevirtual [15] 
L106:   pop 
L107:   aload_1 
L108:   ldc [11] 
L110:   invokevirtual [15] 
L113:   aload_0 
L114:   getfield [14] 
L117:   invokevirtual [17] 
L120:   pop 
L121:   aload_1 
L122:   invokevirtual [18] 
L125:   areturn 
L126:   nop 
L127:   nop 
L128:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [25] 
.const [3] = Class [26] 
.const [4] = String [27] 
.const [5] = String [28] 
.const [6] = String [29] 
.const [7] = String [30] 
.const [8] = String [31] 
.const [9] = String [32] 
.const [10] = String [33] 
.const [11] = String [34] 
.const [12] = Class [35] 
.const [13] = Field [36] [37] 
.const [14] = Field [38] [39] 
.const [15] = Method [40] [41] 
.const [16] = Method [42] [43] 
.const [17] = Method [44] [45] 
.const [18] = Method [46] [47] 
.const [19] = Method [48] [49] 
.const [20] = Method [50] [51] 
.const [21] = Method [52] [53] 
.const [22] = Field [54] [55] 
.const [23] = Field [56] [57] 
.const [24] = Class [58] 
.const [25] = Utf8 de/audi/atip/interapp/terminalmode/TerminalModeAppState 
.const [26] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [27] = Utf8 'appID=' 
.const [28] = Utf8 ' (' 
.const [29] = Utf8 UNKNOWN 
.const [30] = Utf8 NAVIGATION 
.const [31] = Utf8 PHONE 
.const [32] = Utf8 SPEECH 
.const [33] = Utf8 TYPE_MISSING 
.const [34] = Utf8 '), runningOnDevice=' 
.const [35] = Utf8 java/lang/Object 
.const [36] = Class [59] 
.const [37] = NameAndType [60] [61] 
.const [38] = Class [62] 
.const [39] = NameAndType [63] [64] 
.const [40] = Class [65] 
.const [41] = NameAndType [66] [67] 
.const [42] = Class [68] 
.const [43] = NameAndType [69] [70] 
.const [44] = Class [71] 
.const [45] = NameAndType [72] [73] 
.const [46] = Class [74] 
.const [47] = NameAndType [75] [76] 
.const [48] = Class [77] 
.const [49] = NameAndType [78] [79] 
.const [50] = Class [80] 
.const [51] = NameAndType [81] [82] 
.const [52] = Class [83] 
.const [53] = NameAndType [84] [85] 
.const [54] = Class [86] 
.const [55] = NameAndType [87] [88] 
.const [56] = Class [89] 
.const [57] = NameAndType [90] [91] 
.const [58] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [59] = Utf8 de/audi/atip/interapp/terminalmode/TerminalModeAppState 
.const [60] = Utf8 appId 
.const [61] = Utf8 I 
.const [62] = Utf8 de/audi/atip/interapp/terminalmode/TerminalModeAppState 
.const [63] = Utf8 runningOnDevice 
.const [64] = Utf8 Z 
.const [65] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [66] = Utf8 append 
.const [67] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [68] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [69] = Utf8 append 
.const [70] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [71] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [72] = Utf8 append 
.const [73] = Utf8 (Z)Lde/esolutions/fw/util/commons/Buffer; 
.const [74] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [75] = Utf8 toString 
.const [76] = Utf8 ()Ljava/lang/String; 
.const [77] = Utf8 java/lang/Object 
.const [78] = Utf8 <init> 
.const [79] = Utf8 ()V 
.const [80] = Utf8 java/lang/Object 
.const [81] = Utf8 getClass 
.const [82] = Utf8 ()Ljava/lang/Class; 
.const [83] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [84] = Utf8 <init> 
.const [85] = Utf8 ()V 
.const [86] = Utf8 de/audi/atip/interapp/terminalmode/TerminalModeAppState 
.const [87] = Utf8 appId 
.const [88] = Utf8 I 
.const [89] = Utf8 de/audi/atip/interapp/terminalmode/TerminalModeAppState 
.const [90] = Utf8 runningOnDevice 
.const [91] = Utf8 Z 
.const [92] = Utf8 de/audi/atip/interapp/terminalmode/TerminalModeAppState 
.const [93] = Class [92] 
.const [94] = Utf8 java/lang/Object 
.const [95] = Class [94] 
.const [96] = Utf8 APP_UNKNOWN 
.const [97] = Utf8 I 
.const [98] = Utf8 APP_NAVIGATION 
.const [99] = Utf8 I 
.const [100] = Utf8 APP_PHONE 
.const [101] = Utf8 I 
.const [102] = Utf8 APP_SPEECH 
.const [103] = Utf8 I 
.const [104] = Utf8 appId 
.const [105] = Utf8 I 
.const [106] = Utf8 runningOnDevice 
.const [107] = Utf8 Z 
.const [108] = Utf8 Code 
.const [109] = Utf8 <init> 
.const [110] = Utf8 (IZ)V 
.const [111] = Utf8 getAppId 
.const [112] = Utf8 ()I 
.const [113] = Utf8 isRunningOnDevice 
.const [114] = Utf8 ()Z 
.const [115] = Utf8 hashCode 
.const [116] = Utf8 ()I 
.const [117] = Utf8 equals 
.const [118] = Utf8 (Ljava/lang/Object;)Z 
.const [119] = Utf8 toString 
.const [120] = Utf8 ()Ljava/lang/String; 
.end class 
