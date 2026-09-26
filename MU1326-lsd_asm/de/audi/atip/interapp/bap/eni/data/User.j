.version 50 0 
.class public final super [99] 
.super [101] 
.field private final [102] [103] 
.field private [104] [105] 

.method public static [107] : [108] 
    .attribute [106] .code stack 4 locals 0 
L0:     new [20] 
L3:     dup 
L4:     aload_0 
L5:     iload_1 
L6:     invokespecial [16] 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [109] : [110] 
    .attribute [106] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [17] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [21] 
L9:     aload_0 
L10:    iload_2 
L11:    putfield [22] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public interface [111] : [112] 
    .attribute [106] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [9] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [113] : [114] 
    .attribute [106] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [115] : [116] 
    .attribute [106] .code stack 2 locals 2 
L0:     iconst_1 
L1:     istore_2 
L2:     bipush 31 
L4:     iload_2 
L5:     imul 
L6:     aload_0 
L7:     getfield [10] 
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
L29:    getfield [9] 
L32:    ifnonnull L39 
L35:    iconst_0 
L36:    goto L46 
L39:    aload_0 
L40:    getfield [9] 
L43:    invokevirtual [11] 
L46:    iadd 
L47:    istore_2 
L48:    iload_2 
L49:    areturn 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [117] : [118] 
    .attribute [106] .code stack 2 locals 1 
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
L14:    invokespecial [18] 
L17:    aload_1 
L18:    invokespecial [18] 
L21:    if_acmpeq L26 
L24:    iconst_0 
L25:    areturn 
L26:    aload_1 
L27:    checkcast [2] 
L30:    astore_2 
L31:    aload_0 
L32:    getfield [10] 
L35:    aload_2 
L36:    getfield [10] 
L39:    if_icmpeq L44 
L42:    iconst_0 
L43:    areturn 
L44:    aload_0 
L45:    getfield [9] 
L48:    ifnonnull L60 
L51:    aload_2 
L52:    getfield [9] 
L55:    ifnull L76 
L58:    iconst_0 
L59:    areturn 
L60:    aload_0 
L61:    getfield [9] 
L64:    aload_2 
L65:    getfield [9] 
L68:    invokevirtual [12] 
L71:    ifne L76 
L74:    iconst_0 
L75:    areturn 
L76:    iconst_1 
L77:    areturn 
L78:    nop 
L79:    nop 
L80:    
    .end code 
.end method 

.method public [119] : [120] 
    .attribute [106] .code stack 2 locals 0 
L0:     new [23] 
L3:     dup 
L4:     invokespecial [19] 
L7:     ldc [4] 
L9:     invokevirtual [13] 
L12:    aload_0 
L13:    getfield [9] 
L16:    invokevirtual [13] 
L19:    ldc [5] 
L21:    invokevirtual [13] 
L24:    aload_0 
L25:    getfield [10] 
L28:    invokevirtual [14] 
L31:    ldc [6] 
L33:    invokevirtual [13] 
L36:    invokevirtual [15] 
L39:    areturn 
L40:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [24] 
.const [3] = Class [25] 
.const [4] = String [26] 
.const [5] = String [27] 
.const [6] = String [28] 
.const [7] = Class [29] 
.const [8] = Class [30] 
.const [9] = Field [31] [32] 
.const [10] = Field [33] [34] 
.const [11] = Method [35] [36] 
.const [12] = Method [37] [38] 
.const [13] = Method [39] [40] 
.const [14] = Method [41] [42] 
.const [15] = Method [43] [44] 
.const [16] = Method [45] [46] 
.const [17] = Method [47] [48] 
.const [18] = Method [49] [50] 
.const [19] = Method [51] [52] 
.const [20] = Class [53] 
.const [21] = Field [54] [55] 
.const [22] = Field [56] [57] 
.const [23] = Class [58] 
.const [24] = Utf8 de/audi/atip/interapp/bap/eni/data/User 
.const [25] = Utf8 java/lang/StringBuffer 
.const [26] = Utf8 'OnlineUser [login=' 
.const [27] = Utf8 ', isMainUser=' 
.const [28] = Utf8 ']' 
.const [29] = Utf8 java/lang/Object 
.const [30] = Utf8 java/lang/String 
.const [31] = Class [59] 
.const [32] = NameAndType [60] [61] 
.const [33] = Class [62] 
.const [34] = NameAndType [63] [64] 
.const [35] = Class [65] 
.const [36] = NameAndType [66] [67] 
.const [37] = Class [68] 
.const [38] = NameAndType [69] [70] 
.const [39] = Class [71] 
.const [40] = NameAndType [72] [73] 
.const [41] = Class [74] 
.const [42] = NameAndType [75] [76] 
.const [43] = Class [77] 
.const [44] = NameAndType [78] [79] 
.const [45] = Class [80] 
.const [46] = NameAndType [81] [82] 
.const [47] = Class [83] 
.const [48] = NameAndType [84] [85] 
.const [49] = Class [86] 
.const [50] = NameAndType [87] [88] 
.const [51] = Class [89] 
.const [52] = NameAndType [90] [91] 
.const [53] = Utf8 de/audi/atip/interapp/bap/eni/data/User 
.const [54] = Class [92] 
.const [55] = NameAndType [93] [94] 
.const [56] = Class [95] 
.const [57] = NameAndType [96] [97] 
.const [58] = Utf8 java/lang/StringBuffer 
.const [59] = Utf8 de/audi/atip/interapp/bap/eni/data/User 
.const [60] = Utf8 login 
.const [61] = Utf8 Ljava/lang/String; 
.const [62] = Utf8 de/audi/atip/interapp/bap/eni/data/User 
.const [63] = Utf8 isMainUser 
.const [64] = Utf8 Z 
.const [65] = Utf8 java/lang/String 
.const [66] = Utf8 hashCode 
.const [67] = Utf8 ()I 
.const [68] = Utf8 java/lang/String 
.const [69] = Utf8 equals 
.const [70] = Utf8 (Ljava/lang/Object;)Z 
.const [71] = Utf8 java/lang/StringBuffer 
.const [72] = Utf8 append 
.const [73] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [74] = Utf8 java/lang/StringBuffer 
.const [75] = Utf8 append 
.const [76] = Utf8 (Z)Ljava/lang/StringBuffer; 
.const [77] = Utf8 java/lang/StringBuffer 
.const [78] = Utf8 toString 
.const [79] = Utf8 ()Ljava/lang/String; 
.const [80] = Utf8 de/audi/atip/interapp/bap/eni/data/User 
.const [81] = Utf8 <init> 
.const [82] = Utf8 (Ljava/lang/String;Z)V 
.const [83] = Utf8 java/lang/Object 
.const [84] = Utf8 <init> 
.const [85] = Utf8 ()V 
.const [86] = Utf8 java/lang/Object 
.const [87] = Utf8 getClass 
.const [88] = Utf8 ()Ljava/lang/Class; 
.const [89] = Utf8 java/lang/StringBuffer 
.const [90] = Utf8 <init> 
.const [91] = Utf8 ()V 
.const [92] = Utf8 de/audi/atip/interapp/bap/eni/data/User 
.const [93] = Utf8 login 
.const [94] = Utf8 Ljava/lang/String; 
.const [95] = Utf8 de/audi/atip/interapp/bap/eni/data/User 
.const [96] = Utf8 isMainUser 
.const [97] = Utf8 Z 
.const [98] = Utf8 de/audi/atip/interapp/bap/eni/data/User 
.const [99] = Class [98] 
.const [100] = Utf8 java/lang/Object 
.const [101] = Class [100] 
.const [102] = Utf8 login 
.const [103] = Utf8 Ljava/lang/String; 
.const [104] = Utf8 isMainUser 
.const [105] = Utf8 Z 
.const [106] = Utf8 Code 
.const [107] = Utf8 getInstance 
.const [108] = Utf8 (Ljava/lang/String;Z)Lde/audi/atip/interapp/bap/eni/data/User; 
.const [109] = Utf8 <init> 
.const [110] = Utf8 (Ljava/lang/String;Z)V 
.const [111] = Utf8 getLogin 
.const [112] = Utf8 ()Ljava/lang/String; 
.const [113] = Utf8 isMainUser 
.const [114] = Utf8 ()Z 
.const [115] = Utf8 hashCode 
.const [116] = Utf8 ()I 
.const [117] = Utf8 equals 
.const [118] = Utf8 (Ljava/lang/Object;)Z 
.const [119] = Utf8 toString 
.const [120] = Utf8 ()Ljava/lang/String; 
.end class 
