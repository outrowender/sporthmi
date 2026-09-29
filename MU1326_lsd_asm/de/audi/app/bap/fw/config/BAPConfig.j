.version 50 0 
.class public final super [165] 
.super [167] 
.field private final [168] [169] 
.field private final [170] [171] 
.field private final [172] [173] 
.field private final [174] [175] 

.method public static [177] : [178] 
    .attribute [176] .code stack 6 locals 0 
L0:     new [29] 
L3:     dup 
L4:     iload_0 
L5:     iload_1 
L6:     aload_2 
L7:     aload_3 
L8:     invokespecial [25] 
L11:    areturn 
L12:    
    .end code 
.end method 

.method private [179] : [180] 
    .attribute [176] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [26] 
L4:     aload_0 
L5:     iload_1 
L6:     putfield [30] 
L9:     aload_0 
L10:    iload_2 
L11:    putfield [31] 
L14:    aload_0 
L15:    aload_3 
L16:    putfield [32] 
L19:    aload_0 
L20:    aload 4 
L22:    putfield [33] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public interface [181] : [182] 
    .attribute [176] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [9] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [183] : [184] 
    .attribute [176] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [185] : [186] 
    .attribute [176] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [187] : [188] 
    .attribute [176] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [12] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [189] : [190] 
    .attribute [176] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [9] 
L4:     aload_1 
L5:     getfield [9] 
L8:     if_icmpne L64 
L11:    aload_0 
L12:    getfield [11] 
L15:    invokevirtual [13] 
L18:    aload_1 
L19:    getfield [11] 
L22:    invokevirtual [13] 
L25:    if_icmpne L64 
L28:    aload_0 
L29:    getfield [11] 
L32:    invokevirtual [14] 
L35:    aload_1 
L36:    getfield [11] 
L39:    invokevirtual [14] 
L42:    if_icmpne L64 
L45:    aload_0 
L46:    getfield [12] 
L49:    invokevirtual [15] 
L52:    aload_1 
L53:    getfield [12] 
L56:    invokevirtual [15] 
L59:    if_icmpne L64 
L62:    iconst_1 
L63:    areturn 
L64:    iconst_0 
L65:    areturn 
L66:    nop 
L67:    nop 
L68:    
    .end code 
.end method 

.method public [191] : [192] 
    .attribute [176] .code stack 2 locals 1 
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
L27:    checkcast [2] 
L30:    astore_2 
L31:    aload_0 
L32:    getfield [11] 
L35:    ifnonnull L47 
L38:    aload_2 
L39:    getfield [11] 
L42:    ifnull L63 
L45:    iconst_0 
L46:    areturn 
L47:    aload_0 
L48:    getfield [11] 
L51:    aload_2 
L52:    getfield [11] 
L55:    invokevirtual [16] 
L58:    ifne L63 
L61:    iconst_0 
L62:    areturn 
L63:    aload_0 
L64:    getfield [9] 
L67:    aload_2 
L68:    getfield [9] 
L71:    if_icmpeq L76 
L74:    iconst_0 
L75:    areturn 
L76:    aload_0 
L77:    getfield [10] 
L80:    aload_2 
L81:    getfield [10] 
L84:    if_icmpeq L89 
L87:    iconst_0 
L88:    areturn 
L89:    aload_0 
L90:    getfield [12] 
L93:    ifnonnull L105 
L96:    aload_2 
L97:    getfield [12] 
L100:   ifnull L121 
L103:   iconst_0 
L104:   areturn 
L105:   aload_0 
L106:   getfield [12] 
L109:   aload_2 
L110:   getfield [12] 
L113:   invokevirtual [17] 
L116:   ifne L121 
L119:   iconst_0 
L120:   areturn 
L121:   iconst_1 
L122:   areturn 
L123:   nop 
L124:   
    .end code 
.end method 

.method public [193] : [194] 
    .attribute [176] .code stack 2 locals 2 
L0:     iconst_1 
L1:     istore_2 
L2:     bipush 31 
L4:     iload_2 
L5:     imul 
L6:     aload_0 
L7:     getfield [11] 
L10:    ifnonnull L17 
L13:    iconst_0 
L14:    goto L24 
L17:    aload_0 
L18:    getfield [11] 
L21:    invokevirtual [18] 
L24:    iadd 
L25:    istore_2 
L26:    bipush 31 
L28:    iload_2 
L29:    imul 
L30:    aload_0 
L31:    getfield [9] 
L34:    iadd 
L35:    istore_2 
L36:    bipush 31 
L38:    iload_2 
L39:    imul 
L40:    aload_0 
L41:    getfield [10] 
L44:    iadd 
L45:    istore_2 
L46:    bipush 31 
L48:    iload_2 
L49:    imul 
L50:    aload_0 
L51:    getfield [12] 
L54:    ifnonnull L61 
L57:    iconst_0 
L58:    goto L68 
L61:    aload_0 
L62:    getfield [12] 
L65:    invokevirtual [19] 
L68:    iadd 
L69:    istore_2 
L70:    iload_2 
L71:    areturn 
L72:    
    .end code 
.end method 

.method public [195] : [196] 
    .attribute [176] .code stack 3 locals 1 
L0:     new [34] 
L3:     dup 
L4:     bipush 45 
L6:     invokespecial [28] 
L9:     astore_1 
L10:    aload_1 
L11:    aload_0 
L12:    getfield [11] 
L15:    invokevirtual [20] 
L18:    invokevirtual [21] 
L21:    pop 
L22:    aload_1 
L23:    aload_0 
L24:    getfield [12] 
L27:    invokevirtual [22] 
L30:    invokevirtual [21] 
L33:    pop 
L34:    aload_1 
L35:    ldc [4] 
L37:    invokevirtual [21] 
L40:    pop 
L41:    aload_1 
L42:    aload_0 
L43:    getfield [9] 
L46:    invokevirtual [23] 
L49:    pop 
L50:    aload_1 
L51:    ldc [5] 
L53:    invokevirtual [21] 
L56:    pop 
L57:    aload_1 
L58:    aload_0 
L59:    getfield [10] 
L62:    invokevirtual [23] 
L65:    pop 
L66:    aload_1 
L67:    invokevirtual [24] 
L70:    areturn 
L71:    nop 
L72:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [35] 
.const [3] = Class [36] 
.const [4] = String [37] 
.const [5] = String [38] 
.const [6] = Class [39] 
.const [7] = Class [40] 
.const [8] = Class [41] 
.const [9] = Field [42] [43] 
.const [10] = Field [44] [45] 
.const [11] = Field [46] [47] 
.const [12] = Field [48] [49] 
.const [13] = Method [50] [51] 
.const [14] = Method [52] [53] 
.const [15] = Method [54] [55] 
.const [16] = Method [56] [57] 
.const [17] = Method [58] [59] 
.const [18] = Method [60] [61] 
.const [19] = Method [62] [63] 
.const [20] = Method [64] [65] 
.const [21] = Method [66] [67] 
.const [22] = Method [68] [69] 
.const [23] = Method [70] [71] 
.const [24] = Method [72] [73] 
.const [25] = Method [74] [75] 
.const [26] = Method [76] [77] 
.const [27] = Method [78] [79] 
.const [28] = Method [80] [81] 
.const [29] = Class [82] 
.const [30] = Field [83] [84] 
.const [31] = Field [85] [86] 
.const [32] = Field [87] [88] 
.const [33] = Field [89] [90] 
.const [34] = Class [91] 
.const [35] = Utf8 de/audi/app/bap/fw/config/BAPConfig 
.const [36] = Utf8 java/lang/StringBuffer 
.const [37] = Utf8 '\n - LSG_Class - ' 
.const [38] = Utf8 '\n - LSG_SubClass - ' 
.const [39] = Utf8 java/lang/Object 
.const [40] = Utf8 de/audi/app/bap/fw/config/BAPVersion 
.const [41] = Utf8 de/audi/app/bap/fw/config/LSGVersion 
.const [42] = Class [92] 
.const [43] = NameAndType [93] [94] 
.const [44] = Class [95] 
.const [45] = NameAndType [96] [97] 
.const [46] = Class [98] 
.const [47] = NameAndType [99] [100] 
.const [48] = Class [101] 
.const [49] = NameAndType [102] [103] 
.const [50] = Class [104] 
.const [51] = NameAndType [105] [106] 
.const [52] = Class [107] 
.const [53] = NameAndType [108] [109] 
.const [54] = Class [110] 
.const [55] = NameAndType [111] [112] 
.const [56] = Class [113] 
.const [57] = NameAndType [114] [115] 
.const [58] = Class [116] 
.const [59] = NameAndType [117] [118] 
.const [60] = Class [119] 
.const [61] = NameAndType [120] [121] 
.const [62] = Class [122] 
.const [63] = NameAndType [123] [124] 
.const [64] = Class [125] 
.const [65] = NameAndType [126] [127] 
.const [66] = Class [128] 
.const [67] = NameAndType [129] [130] 
.const [68] = Class [131] 
.const [69] = NameAndType [132] [133] 
.const [70] = Class [134] 
.const [71] = NameAndType [135] [136] 
.const [72] = Class [137] 
.const [73] = NameAndType [138] [139] 
.const [74] = Class [140] 
.const [75] = NameAndType [141] [142] 
.const [76] = Class [143] 
.const [77] = NameAndType [144] [145] 
.const [78] = Class [146] 
.const [79] = NameAndType [147] [148] 
.const [80] = Class [149] 
.const [81] = NameAndType [150] [151] 
.const [82] = Utf8 de/audi/app/bap/fw/config/BAPConfig 
.const [83] = Class [152] 
.const [84] = NameAndType [153] [154] 
.const [85] = Class [155] 
.const [86] = NameAndType [156] [157] 
.const [87] = Class [158] 
.const [88] = NameAndType [159] [160] 
.const [89] = Class [161] 
.const [90] = NameAndType [162] [163] 
.const [91] = Utf8 java/lang/StringBuffer 
.const [92] = Utf8 de/audi/app/bap/fw/config/BAPConfig 
.const [93] = Utf8 lsgClass 
.const [94] = Utf8 I 
.const [95] = Utf8 de/audi/app/bap/fw/config/BAPConfig 
.const [96] = Utf8 lsgSubclass 
.const [97] = Utf8 I 
.const [98] = Utf8 de/audi/app/bap/fw/config/BAPConfig 
.const [99] = Utf8 bapVersion 
.const [100] = Utf8 Lde/audi/app/bap/fw/config/BAPVersion; 
.const [101] = Utf8 de/audi/app/bap/fw/config/BAPConfig 
.const [102] = Utf8 lsgVersion 
.const [103] = Utf8 Lde/audi/app/bap/fw/config/LSGVersion; 
.const [104] = Utf8 de/audi/app/bap/fw/config/BAPVersion 
.const [105] = Utf8 getMajor 
.const [106] = Utf8 ()I 
.const [107] = Utf8 de/audi/app/bap/fw/config/BAPVersion 
.const [108] = Utf8 getMinor 
.const [109] = Utf8 ()I 
.const [110] = Utf8 de/audi/app/bap/fw/config/LSGVersion 
.const [111] = Utf8 getMajor 
.const [112] = Utf8 ()I 
.const [113] = Utf8 de/audi/app/bap/fw/config/BAPVersion 
.const [114] = Utf8 equals 
.const [115] = Utf8 (Ljava/lang/Object;)Z 
.const [116] = Utf8 de/audi/app/bap/fw/config/LSGVersion 
.const [117] = Utf8 equals 
.const [118] = Utf8 (Ljava/lang/Object;)Z 
.const [119] = Utf8 de/audi/app/bap/fw/config/BAPVersion 
.const [120] = Utf8 hashCode 
.const [121] = Utf8 ()I 
.const [122] = Utf8 de/audi/app/bap/fw/config/LSGVersion 
.const [123] = Utf8 hashCode 
.const [124] = Utf8 ()I 
.const [125] = Utf8 de/audi/app/bap/fw/config/BAPVersion 
.const [126] = Utf8 toString 
.const [127] = Utf8 ()Ljava/lang/String; 
.const [128] = Utf8 java/lang/StringBuffer 
.const [129] = Utf8 append 
.const [130] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [131] = Utf8 de/audi/app/bap/fw/config/LSGVersion 
.const [132] = Utf8 toString 
.const [133] = Utf8 ()Ljava/lang/String; 
.const [134] = Utf8 java/lang/StringBuffer 
.const [135] = Utf8 append 
.const [136] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [137] = Utf8 java/lang/StringBuffer 
.const [138] = Utf8 toString 
.const [139] = Utf8 ()Ljava/lang/String; 
.const [140] = Utf8 de/audi/app/bap/fw/config/BAPConfig 
.const [141] = Utf8 <init> 
.const [142] = Utf8 (IILde/audi/app/bap/fw/config/BAPVersion;Lde/audi/app/bap/fw/config/LSGVersion;)V 
.const [143] = Utf8 java/lang/Object 
.const [144] = Utf8 <init> 
.const [145] = Utf8 ()V 
.const [146] = Utf8 java/lang/Object 
.const [147] = Utf8 getClass 
.const [148] = Utf8 ()Ljava/lang/Class; 
.const [149] = Utf8 java/lang/StringBuffer 
.const [150] = Utf8 <init> 
.const [151] = Utf8 (I)V 
.const [152] = Utf8 de/audi/app/bap/fw/config/BAPConfig 
.const [153] = Utf8 lsgClass 
.const [154] = Utf8 I 
.const [155] = Utf8 de/audi/app/bap/fw/config/BAPConfig 
.const [156] = Utf8 lsgSubclass 
.const [157] = Utf8 I 
.const [158] = Utf8 de/audi/app/bap/fw/config/BAPConfig 
.const [159] = Utf8 bapVersion 
.const [160] = Utf8 Lde/audi/app/bap/fw/config/BAPVersion; 
.const [161] = Utf8 de/audi/app/bap/fw/config/BAPConfig 
.const [162] = Utf8 lsgVersion 
.const [163] = Utf8 Lde/audi/app/bap/fw/config/LSGVersion; 
.const [164] = Utf8 de/audi/app/bap/fw/config/BAPConfig 
.const [165] = Class [164] 
.const [166] = Utf8 java/lang/Object 
.const [167] = Class [166] 
.const [168] = Utf8 lsgClass 
.const [169] = Utf8 I 
.const [170] = Utf8 lsgSubclass 
.const [171] = Utf8 I 
.const [172] = Utf8 bapVersion 
.const [173] = Utf8 Lde/audi/app/bap/fw/config/BAPVersion; 
.const [174] = Utf8 lsgVersion 
.const [175] = Utf8 Lde/audi/app/bap/fw/config/LSGVersion; 
.const [176] = Utf8 Code 
.const [177] = Utf8 getInstance 
.const [178] = Utf8 (IILde/audi/app/bap/fw/config/BAPVersion;Lde/audi/app/bap/fw/config/LSGVersion;)Lde/audi/app/bap/fw/config/BAPConfig; 
.const [179] = Utf8 <init> 
.const [180] = Utf8 (IILde/audi/app/bap/fw/config/BAPVersion;Lde/audi/app/bap/fw/config/LSGVersion;)V 
.const [181] = Utf8 getLsgClass 
.const [182] = Utf8 ()I 
.const [183] = Utf8 getLsgSubclass 
.const [184] = Utf8 ()I 
.const [185] = Utf8 getBapVersion 
.const [186] = Utf8 ()Lde/audi/app/bap/fw/config/BAPVersion; 
.const [187] = Utf8 getLsgVersion 
.const [188] = Utf8 ()Lde/audi/app/bap/fw/config/LSGVersion; 
.const [189] = Utf8 isCompatibleWith 
.const [190] = Utf8 (Lde/audi/app/bap/fw/config/BAPConfig;)Z 
.const [191] = Utf8 equals 
.const [192] = Utf8 (Ljava/lang/Object;)Z 
.const [193] = Utf8 hashCode 
.const [194] = Utf8 ()I 
.const [195] = Utf8 toString 
.const [196] = Utf8 ()Ljava/lang/String; 
.end class 
