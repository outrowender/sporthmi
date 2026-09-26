.version 50 0 
.class public super [108] 
.super [110] 
.field private static final [111] [112] 
.field private final [113] [114] 
.field private final [115] [116] 
.field private final [117] [118] 
.field private final [119] [120] 

.method private [122] : [123] 
    .attribute [121] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [14] 
L4:     aload_0 
L5:     ldc [2] 
L7:     putfield [18] 
L10:    aload_0 
L11:    ldc [2] 
L13:    putfield [19] 
L16:    aload_0 
L17:    iconst_0 
L18:    putfield [20] 
L21:    aload_0 
L22:    fconst_0 
L23:    putfield [21] 
L26:    return 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [124] : [125] 
    .attribute [121] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [14] 
L4:     aload_0 
L5:     fload_1 
L6:     putfield [18] 
L9:     aload_0 
L10:    fload_2 
L11:    putfield [19] 
L14:    aload_0 
L15:    iconst_1 
L16:    putfield [20] 
L19:    aload_0 
L20:    fload_3 
L21:    putfield [21] 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public interface [126] : [127] 
    .attribute [121] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [128] : [129] 
    .attribute [121] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [9] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [130] : [131] 
    .attribute [121] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [132] : [133] 
    .attribute [121] .code stack 1 locals 0 
L0:     getstatic [3] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public interface [134] : [135] 
    .attribute [121] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [12] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [136] : [137] 
    .attribute [121] .code stack 6 locals 3 
L0:     aload_0 
L1:     aload_1 
L2:     invokevirtual [13] 
L5:     ifeq L10 
L8:     aload_0 
L9:     areturn 
L10:    aload_0 
L11:    getfield [11] 
L14:    ifne L34 
L17:    new [22] 
L20:    dup 
L21:    aload_1 
L22:    getfield [9] 
L25:    aload_1 
L26:    getfield [10] 
L29:    fload_2 
L30:    invokespecial [16] 
L33:    areturn 
L34:    aload_1 
L35:    getfield [11] 
L38:    ifne L60 
L41:    new [22] 
L44:    dup 
L45:    aload_0 
L46:    getfield [9] 
L49:    aload_0 
L50:    getfield [10] 
L53:    fconst_1 
L54:    fload_2 
L55:    fsub 
L56:    invokespecial [16] 
L59:    areturn 
L60:    aload_0 
L61:    getfield [9] 
L64:    aload_1 
L65:    getfield [9] 
L68:    fload_2 
L69:    invokestatic [5] 
L72:    fstore_3 
L73:    aload_0 
L74:    getfield [10] 
L77:    aload_1 
L78:    getfield [10] 
L81:    fload_2 
L82:    invokestatic [5] 
L85:    fstore 4 
L87:    aload_0 
L88:    getfield [12] 
L91:    aload_1 
L92:    getfield [12] 
L95:    fload_2 
L96:    invokestatic [5] 
L99:    fstore 5 
L101:   new [22] 
L104:   dup 
L105:   fload_3 
L106:   fload 4 
L108:   fload 5 
L110:   invokespecial [16] 
L113:   areturn 
L114:   nop 
L115:   nop 
L116:   
    .end code 
.end method 

.method private static [138] : [139] 
    .attribute [121] .code stack 4 locals 0 
L0:     fload_0 
L1:     fload_2 
L2:     fload_1 
L3:     fload_0 
L4:     fsub 
L5:     fmul 
L6:     fadd 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [140] : [141] 
    .attribute [121] .code stack 2 locals 2 
L0:     iconst_1 
L1:     istore_2 
L2:     bipush 31 
L4:     iload_2 
L5:     imul 
L6:     aload_0 
L7:     getfield [9] 
L10:    invokestatic [6] 
L13:    iadd 
L14:    istore_2 
L15:    bipush 31 
L17:    iload_2 
L18:    imul 
L19:    aload_0 
L20:    getfield [10] 
L23:    invokestatic [6] 
L26:    iadd 
L27:    istore_2 
L28:    bipush 31 
L30:    iload_2 
L31:    imul 
L32:    aload_0 
L33:    getfield [12] 
L36:    invokestatic [6] 
L39:    iadd 
L40:    istore_2 
L41:    bipush 31 
L43:    iload_2 
L44:    imul 
L45:    aload_0 
L46:    getfield [11] 
L49:    ifeq L58 
L52:    sipush 1231 
L55:    goto L61 
L58:    sipush 1237 
L61:    iadd 
L62:    istore_2 
L63:    iload_2 
L64:    areturn 
L65:    nop 
L66:    nop 
L67:    nop 
L68:    
    .end code 
.end method 

.method public [142] : [143] 
    .attribute [121] .code stack 2 locals 1 
L0:     aload_0 
L1:     aload_1 
L2:     if_acmpne L7 
L5:     iconst_1 
L6:     areturn 
L7:     aload_1 
L8:     ifnonnull L13 
L11:    iconst_0 
L12:    areturn 
L13:    aload_1 
L14:    instanceof [4] 
L17:    ifne L22 
L20:    iconst_0 
L21:    areturn 
L22:    aload_1 
L23:    checkcast [4] 
L26:    astore_2 
L27:    aload_0 
L28:    getfield [9] 
L31:    invokestatic [6] 
L34:    aload_2 
L35:    getfield [9] 
L38:    invokestatic [6] 
L41:    if_icmpeq L46 
L44:    iconst_0 
L45:    areturn 
L46:    aload_0 
L47:    getfield [10] 
L50:    invokestatic [6] 
L53:    aload_2 
L54:    getfield [10] 
L57:    invokestatic [6] 
L60:    if_icmpeq L65 
L63:    iconst_0 
L64:    areturn 
L65:    aload_0 
L66:    getfield [12] 
L69:    invokestatic [6] 
L72:    aload_2 
L73:    getfield [12] 
L76:    invokestatic [6] 
L79:    if_icmpeq L84 
L82:    iconst_0 
L83:    areturn 
L84:    aload_0 
L85:    getfield [11] 
L88:    aload_2 
L89:    getfield [11] 
L92:    if_icmpeq L97 
L95:    iconst_0 
L96:    areturn 
L97:    iconst_1 
L98:    areturn 
L99:    nop 
L100:   
    .end code 
.end method 

.method static [144] : [145] 
    .attribute [121] .code stack 2 locals 0 
L0:     new [22] 
L3:     dup 
L4:     invokespecial [17] 
L7:     putstatic [15] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 32959 
.const [3] = Field [23] [24] 
.const [4] = Class [25] 
.const [5] = Method [26] [27] 
.const [6] = Method [28] [29] 
.const [7] = Class [30] 
.const [8] = Class [31] 
.const [9] = Field [32] [33] 
.const [10] = Field [34] [35] 
.const [11] = Field [36] [37] 
.const [12] = Field [38] [39] 
.const [13] = Method [40] [41] 
.const [14] = Method [42] [43] 
.const [15] = Field [44] [45] 
.const [16] = Method [46] [47] 
.const [17] = Method [48] [49] 
.const [18] = Field [50] [51] 
.const [19] = Field [52] [53] 
.const [20] = Field [54] [55] 
.const [21] = Field [56] [57] 
.const [22] = Class [58] 
.const [23] = Class [59] 
.const [24] = NameAndType [60] [61] 
.const [25] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/ScrollbarInterval 
.const [26] = Class [62] 
.const [27] = NameAndType [63] [64] 
.const [28] = Class [65] 
.const [29] = NameAndType [66] [67] 
.const [30] = Utf8 java/lang/Object 
.const [31] = Utf8 java/lang/Float 
.const [32] = Class [68] 
.const [33] = NameAndType [69] [70] 
.const [34] = Class [71] 
.const [35] = NameAndType [72] [73] 
.const [36] = Class [74] 
.const [37] = NameAndType [75] [76] 
.const [38] = Class [77] 
.const [39] = NameAndType [78] [79] 
.const [40] = Class [80] 
.const [41] = NameAndType [81] [82] 
.const [42] = Class [83] 
.const [43] = NameAndType [84] [85] 
.const [44] = Class [86] 
.const [45] = NameAndType [87] [88] 
.const [46] = Class [89] 
.const [47] = NameAndType [90] [91] 
.const [48] = Class [92] 
.const [49] = NameAndType [93] [94] 
.const [50] = Class [95] 
.const [51] = NameAndType [96] [97] 
.const [52] = Class [98] 
.const [53] = NameAndType [99] [100] 
.const [54] = Class [101] 
.const [55] = NameAndType [102] [103] 
.const [56] = Class [104] 
.const [57] = NameAndType [105] [106] 
.const [58] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/ScrollbarInterval 
.const [59] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/ScrollbarInterval 
.const [60] = Utf8 invisibleInterval 
.const [61] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/ScrollbarInterval; 
.const [62] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/ScrollbarInterval 
.const [63] = Utf8 getAnimatedValue 
.const [64] = Utf8 (FFF)F 
.const [65] = Utf8 java/lang/Float 
.const [66] = Utf8 floatToIntBits 
.const [67] = Utf8 (F)I 
.const [68] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/ScrollbarInterval 
.const [69] = Utf8 firstPos 
.const [70] = Utf8 F 
.const [71] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/ScrollbarInterval 
.const [72] = Utf8 lastPos 
.const [73] = Utf8 F 
.const [74] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/ScrollbarInterval 
.const [75] = Utf8 visible 
.const [76] = Utf8 Z 
.const [77] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/ScrollbarInterval 
.const [78] = Utf8 opacity 
.const [79] = Utf8 F 
.const [80] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/ScrollbarInterval 
.const [81] = Utf8 equals 
.const [82] = Utf8 (Ljava/lang/Object;)Z 
.const [83] = Utf8 java/lang/Object 
.const [84] = Utf8 <init> 
.const [85] = Utf8 ()V 
.const [86] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/ScrollbarInterval 
.const [87] = Utf8 invisibleInterval 
.const [88] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/ScrollbarInterval; 
.const [89] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/ScrollbarInterval 
.const [90] = Utf8 <init> 
.const [91] = Utf8 (FFF)V 
.const [92] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/ScrollbarInterval 
.const [93] = Utf8 <init> 
.const [94] = Utf8 ()V 
.const [95] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/ScrollbarInterval 
.const [96] = Utf8 firstPos 
.const [97] = Utf8 F 
.const [98] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/ScrollbarInterval 
.const [99] = Utf8 lastPos 
.const [100] = Utf8 F 
.const [101] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/ScrollbarInterval 
.const [102] = Utf8 visible 
.const [103] = Utf8 Z 
.const [104] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/ScrollbarInterval 
.const [105] = Utf8 opacity 
.const [106] = Utf8 F 
.const [107] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/ScrollbarInterval 
.const [108] = Class [107] 
.const [109] = Utf8 java/lang/Object 
.const [110] = Class [109] 
.const [111] = Utf8 invisibleInterval 
.const [112] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/ScrollbarInterval; 
.const [113] = Utf8 firstPos 
.const [114] = Utf8 F 
.const [115] = Utf8 lastPos 
.const [116] = Utf8 F 
.const [117] = Utf8 visible 
.const [118] = Utf8 Z 
.const [119] = Utf8 opacity 
.const [120] = Utf8 F 
.const [121] = Utf8 Code 
.const [122] = Utf8 <init> 
.const [123] = Utf8 ()V 
.const [124] = Utf8 <init> 
.const [125] = Utf8 (FFF)V 
.const [126] = Utf8 isVisible 
.const [127] = Utf8 ()Z 
.const [128] = Utf8 getFirstPos 
.const [129] = Utf8 ()F 
.const [130] = Utf8 getLastPos 
.const [131] = Utf8 ()F 
.const [132] = Utf8 getInvisibleInterval 
.const [133] = Utf8 ()Lde/esolutions/hmi/widgets/audi/evo/widgets/ScrollbarInterval; 
.const [134] = Utf8 getOpacity 
.const [135] = Utf8 ()F 
.const [136] = Utf8 getAnimationInterval 
.const [137] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/widgets/ScrollbarInterval;F)Lde/esolutions/hmi/widgets/audi/evo/widgets/ScrollbarInterval; 
.const [138] = Utf8 getAnimatedValue 
.const [139] = Utf8 (FFF)F 
.const [140] = Utf8 hashCode 
.const [141] = Utf8 ()I 
.const [142] = Utf8 equals 
.const [143] = Utf8 (Ljava/lang/Object;)Z 
.const [144] = Utf8 <clinit> 
.const [145] = Utf8 ()V 
.end class 
