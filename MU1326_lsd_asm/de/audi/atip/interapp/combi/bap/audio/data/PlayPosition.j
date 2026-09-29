.version 50 0 
.class public final super [127] 
.super [129] 
.field private final [130] [131] 
.field private final [132] [133] 
.field private final [134] [135] 

.method public static [137] : [138] 
    .attribute [136] .code stack 2 locals 0 
L0:     new [25] 
L3:     dup 
L4:     invokespecial [21] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method private [139] : [140] 
    .attribute [136] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [22] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [26] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [27] 
L14:    aload_0 
L15:    iload_3 
L16:    putfield [28] 
L19:    return 
L20:    
    .end code 
.end method 

.method public interface [141] : [142] 
    .attribute [136] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [143] : [144] 
    .attribute [136] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [12] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [145] : [146] 
    .attribute [136] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [147] : [148] 
    .attribute [136] .code stack 2 locals 1 
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
L14:    invokespecial [23] 
L17:    aload_1 
L18:    invokespecial [23] 
L21:    if_acmpeq L26 
L24:    iconst_0 
L25:    areturn 
L26:    aload_1 
L27:    checkcast [3] 
L30:    astore_2 
L31:    aload_0 
L32:    getfield [13] 
L35:    aload_2 
L36:    getfield [13] 
L39:    if_icmpeq L44 
L42:    iconst_0 
L43:    areturn 
L44:    aload_0 
L45:    getfield [11] 
L48:    ifnonnull L60 
L51:    aload_2 
L52:    getfield [11] 
L55:    ifnull L76 
L58:    iconst_0 
L59:    areturn 
L60:    aload_0 
L61:    getfield [11] 
L64:    aload_2 
L65:    getfield [11] 
L68:    invokevirtual [14] 
L71:    ifne L76 
L74:    iconst_0 
L75:    areturn 
L76:    aload_0 
L77:    getfield [12] 
L80:    ifnonnull L92 
L83:    aload_2 
L84:    getfield [12] 
L87:    ifnull L108 
L90:    iconst_0 
L91:    areturn 
L92:    aload_0 
L93:    getfield [12] 
L96:    aload_2 
L97:    getfield [12] 
L100:   invokevirtual [14] 
L103:   ifne L108 
L106:   iconst_0 
L107:   areturn 
L108:   iconst_1 
L109:   areturn 
L110:   nop 
L111:   nop 
L112:   
    .end code 
.end method 

.method public [149] : [150] 
    .attribute [136] .code stack 2 locals 2 
L0:     iconst_1 
L1:     istore_2 
L2:     bipush 31 
L4:     iload_2 
L5:     imul 
L6:     aload_0 
L7:     getfield [13] 
L10:    ifeq L19 
L13:    sipush 1231 
L16:    goto L22 
L19:    sipush 1237 
L22:    iadd 
L23:    istore_2 
L24:    bipush 31 
L26:    iload_2 
L27:    imul 
L28:    aload_0 
L29:    getfield [11] 
L32:    ifnonnull L39 
L35:    iconst_0 
L36:    goto L46 
L39:    aload_0 
L40:    getfield [11] 
L43:    invokevirtual [15] 
L46:    iadd 
L47:    istore_2 
L48:    bipush 31 
L50:    iload_2 
L51:    imul 
L52:    aload_0 
L53:    getfield [12] 
L56:    ifnonnull L63 
L59:    iconst_0 
L60:    goto L70 
L63:    aload_0 
L64:    getfield [12] 
L67:    invokevirtual [15] 
L70:    iadd 
L71:    istore_2 
L72:    iload_2 
L73:    areturn 
L74:    nop 
L75:    nop 
L76:    
    .end code 
.end method 

.method public [151] : [152] 
    .attribute [136] .code stack 2 locals 0 
L0:     new [29] 
L3:     dup 
L4:     invokespecial [24] 
L7:     ldc [5] 
L9:     invokevirtual [16] 
L12:    aload_0 
L13:    getfield [11] 
L16:    invokevirtual [17] 
L19:    ldc [6] 
L21:    invokevirtual [16] 
L24:    aload_0 
L25:    getfield [12] 
L28:    invokevirtual [17] 
L31:    ldc [7] 
L33:    invokevirtual [16] 
L36:    aload_0 
L37:    getfield [13] 
L40:    invokevirtual [18] 
L43:    ldc [8] 
L45:    invokevirtual [16] 
L48:    invokevirtual [19] 
L51:    areturn 
L52:    
    .end code 
.end method 

.method synthetic [153] : [154] 
    .attribute [136] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     iload_3 
L4:     invokespecial [20] 
L7:     return 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [30] 
.const [3] = Class [31] 
.const [4] = Class [32] 
.const [5] = String [33] 
.const [6] = String [34] 
.const [7] = String [35] 
.const [8] = String [36] 
.const [9] = Class [37] 
.const [10] = Class [38] 
.const [11] = Field [39] [40] 
.const [12] = Field [41] [42] 
.const [13] = Field [43] [44] 
.const [14] = Method [45] [46] 
.const [15] = Method [47] [48] 
.const [16] = Method [49] [50] 
.const [17] = Method [51] [52] 
.const [18] = Method [53] [54] 
.const [19] = Method [55] [56] 
.const [20] = Method [57] [58] 
.const [21] = Method [59] [60] 
.const [22] = Method [61] [62] 
.const [23] = Method [63] [64] 
.const [24] = Method [65] [66] 
.const [25] = Class [67] 
.const [26] = Field [68] [69] 
.const [27] = Field [70] [71] 
.const [28] = Field [72] [73] 
.const [29] = Class [74] 
.const [30] = Utf8 de/audi/atip/interapp/combi/bap/audio/data/PlayPosition$Builder 
.const [31] = Utf8 de/audi/atip/interapp/combi/bap/audio/data/PlayPosition 
.const [32] = Utf8 java/lang/StringBuffer 
.const [33] = Utf8 'PlayPosition [timePosition=' 
.const [34] = Utf8 ', totalPlayTime=' 
.const [35] = Utf8 ', isVariableBitRate=' 
.const [36] = Utf8 ']' 
.const [37] = Utf8 java/lang/Object 
.const [38] = Utf8 de/audi/atip/interapp/bap/data/TimeStamp 
.const [39] = Class [75] 
.const [40] = NameAndType [76] [77] 
.const [41] = Class [78] 
.const [42] = NameAndType [79] [80] 
.const [43] = Class [81] 
.const [44] = NameAndType [82] [83] 
.const [45] = Class [84] 
.const [46] = NameAndType [85] [86] 
.const [47] = Class [87] 
.const [48] = NameAndType [88] [89] 
.const [49] = Class [90] 
.const [50] = NameAndType [91] [92] 
.const [51] = Class [93] 
.const [52] = NameAndType [94] [95] 
.const [53] = Class [96] 
.const [54] = NameAndType [97] [98] 
.const [55] = Class [99] 
.const [56] = NameAndType [100] [101] 
.const [57] = Class [102] 
.const [58] = NameAndType [103] [104] 
.const [59] = Class [105] 
.const [60] = NameAndType [106] [107] 
.const [61] = Class [108] 
.const [62] = NameAndType [109] [110] 
.const [63] = Class [111] 
.const [64] = NameAndType [112] [113] 
.const [65] = Class [114] 
.const [66] = NameAndType [115] [116] 
.const [67] = Utf8 de/audi/atip/interapp/combi/bap/audio/data/PlayPosition$Builder 
.const [68] = Class [117] 
.const [69] = NameAndType [118] [119] 
.const [70] = Class [120] 
.const [71] = NameAndType [121] [122] 
.const [72] = Class [123] 
.const [73] = NameAndType [124] [125] 
.const [74] = Utf8 java/lang/StringBuffer 
.const [75] = Utf8 de/audi/atip/interapp/combi/bap/audio/data/PlayPosition 
.const [76] = Utf8 timePosition 
.const [77] = Utf8 Lde/audi/atip/interapp/bap/data/TimeStamp; 
.const [78] = Utf8 de/audi/atip/interapp/combi/bap/audio/data/PlayPosition 
.const [79] = Utf8 totalPlayTime 
.const [80] = Utf8 Lde/audi/atip/interapp/bap/data/TimeStamp; 
.const [81] = Utf8 de/audi/atip/interapp/combi/bap/audio/data/PlayPosition 
.const [82] = Utf8 isVariableBitRate 
.const [83] = Utf8 Z 
.const [84] = Utf8 de/audi/atip/interapp/bap/data/TimeStamp 
.const [85] = Utf8 equals 
.const [86] = Utf8 (Ljava/lang/Object;)Z 
.const [87] = Utf8 de/audi/atip/interapp/bap/data/TimeStamp 
.const [88] = Utf8 hashCode 
.const [89] = Utf8 ()I 
.const [90] = Utf8 java/lang/StringBuffer 
.const [91] = Utf8 append 
.const [92] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [93] = Utf8 java/lang/StringBuffer 
.const [94] = Utf8 append 
.const [95] = Utf8 (Ljava/lang/Object;)Ljava/lang/StringBuffer; 
.const [96] = Utf8 java/lang/StringBuffer 
.const [97] = Utf8 append 
.const [98] = Utf8 (Z)Ljava/lang/StringBuffer; 
.const [99] = Utf8 java/lang/StringBuffer 
.const [100] = Utf8 toString 
.const [101] = Utf8 ()Ljava/lang/String; 
.const [102] = Utf8 de/audi/atip/interapp/combi/bap/audio/data/PlayPosition 
.const [103] = Utf8 <init> 
.const [104] = Utf8 (Lde/audi/atip/interapp/bap/data/TimeStamp;Lde/audi/atip/interapp/bap/data/TimeStamp;Z)V 
.const [105] = Utf8 de/audi/atip/interapp/combi/bap/audio/data/PlayPosition$Builder 
.const [106] = Utf8 <init> 
.const [107] = Utf8 ()V 
.const [108] = Utf8 java/lang/Object 
.const [109] = Utf8 <init> 
.const [110] = Utf8 ()V 
.const [111] = Utf8 java/lang/Object 
.const [112] = Utf8 getClass 
.const [113] = Utf8 ()Ljava/lang/Class; 
.const [114] = Utf8 java/lang/StringBuffer 
.const [115] = Utf8 <init> 
.const [116] = Utf8 ()V 
.const [117] = Utf8 de/audi/atip/interapp/combi/bap/audio/data/PlayPosition 
.const [118] = Utf8 timePosition 
.const [119] = Utf8 Lde/audi/atip/interapp/bap/data/TimeStamp; 
.const [120] = Utf8 de/audi/atip/interapp/combi/bap/audio/data/PlayPosition 
.const [121] = Utf8 totalPlayTime 
.const [122] = Utf8 Lde/audi/atip/interapp/bap/data/TimeStamp; 
.const [123] = Utf8 de/audi/atip/interapp/combi/bap/audio/data/PlayPosition 
.const [124] = Utf8 isVariableBitRate 
.const [125] = Utf8 Z 
.const [126] = Utf8 de/audi/atip/interapp/combi/bap/audio/data/PlayPosition 
.const [127] = Class [126] 
.const [128] = Utf8 java/lang/Object 
.const [129] = Class [128] 
.const [130] = Utf8 timePosition 
.const [131] = Utf8 Lde/audi/atip/interapp/bap/data/TimeStamp; 
.const [132] = Utf8 totalPlayTime 
.const [133] = Utf8 Lde/audi/atip/interapp/bap/data/TimeStamp; 
.const [134] = Utf8 isVariableBitRate 
.const [135] = Utf8 Z 
.const [136] = Utf8 Code 
.const [137] = Utf8 builder 
.const [138] = Utf8 ()Lde/audi/atip/interapp/combi/bap/audio/data/PlayPosition$Builder; 
.const [139] = Utf8 <init> 
.const [140] = Utf8 (Lde/audi/atip/interapp/bap/data/TimeStamp;Lde/audi/atip/interapp/bap/data/TimeStamp;Z)V 
.const [141] = Utf8 getTimePosition 
.const [142] = Utf8 ()Lde/audi/atip/interapp/bap/data/TimeStamp; 
.const [143] = Utf8 getTotalPlayTime 
.const [144] = Utf8 ()Lde/audi/atip/interapp/bap/data/TimeStamp; 
.const [145] = Utf8 isVariableBitRate 
.const [146] = Utf8 ()Z 
.const [147] = Utf8 equals 
.const [148] = Utf8 (Ljava/lang/Object;)Z 
.const [149] = Utf8 hashCode 
.const [150] = Utf8 ()I 
.const [151] = Utf8 toString 
.const [152] = Utf8 ()Ljava/lang/String; 
.const [153] = Utf8 <init> 
.const [154] = Utf8 (Lde/audi/atip/interapp/bap/data/TimeStamp;Lde/audi/atip/interapp/bap/data/TimeStamp;ZLde/audi/atip/interapp/combi/bap/audio/data/PlayPosition$1;)V 
.end class 
