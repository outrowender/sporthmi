.version 50 0 
.class public final super [111] 
.super [113] 
.field private final [114] [115] 
.field private final [116] [117] 
.field private final [118] [119] 

.method public static [121] : [122] 
    .attribute [120] .code stack 5 locals 0 
L0:     new [21] 
L3:     dup 
L4:     iload_0 
L5:     iload_1 
L6:     iload_2 
L7:     invokespecial [17] 
L10:    areturn 
L11:    nop 
L12:    
    .end code 
.end method 

.method public static [123] : [124] 
    .attribute [120] .code stack 3 locals 0 
L0:     iconst_m1 
L1:     iconst_0 
L2:     iconst_0 
L3:     invokestatic [3] 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 

.method private [125] : [126] 
    .attribute [120] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [18] 
L4:     aload_0 
L5:     iload_1 
L6:     putfield [22] 
L9:     aload_0 
L10:    iload_2 
L11:    putfield [23] 
L14:    aload_0 
L15:    iload_3 
L16:    putfield [24] 
L19:    return 
L20:    
    .end code 
.end method 

.method public interface [127] : [128] 
    .attribute [120] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [129] : [130] 
    .attribute [120] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [131] : [132] 
    .attribute [120] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [12] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [133] : [134] 
    .attribute [120] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokevirtual [13] 
L4:     bipush 7 
L6:     if_icmpne L13 
L9:     iconst_1 
L10:    goto L14 
L13:    iconst_0 
L14:    areturn 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [135] : [136] 
    .attribute [120] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokevirtual [13] 
L4:     iconst_1 
L5:     if_icmpne L12 
L8:     iconst_1 
L9:     goto L13 
L12:    iconst_0 
L13:    areturn 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [137] : [138] 
    .attribute [120] .code stack 2 locals 2 
L0:     iconst_1 
L1:     istore_2 
L2:     bipush 31 
L4:     iload_2 
L5:     imul 
L6:     aload_0 
L7:     getfield [10] 
L10:    iadd 
L11:    istore_2 
L12:    bipush 31 
L14:    iload_2 
L15:    imul 
L16:    aload_0 
L17:    getfield [11] 
L20:    iadd 
L21:    istore_2 
L22:    bipush 31 
L24:    iload_2 
L25:    imul 
L26:    aload_0 
L27:    getfield [12] 
L30:    iadd 
L31:    istore_2 
L32:    iload_2 
L33:    areturn 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [139] : [140] 
    .attribute [120] .code stack 2 locals 1 
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
L14:    invokespecial [19] 
L17:    aload_1 
L18:    invokespecial [19] 
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
L45:    getfield [11] 
L48:    aload_2 
L49:    getfield [11] 
L52:    if_icmpeq L57 
L55:    iconst_0 
L56:    areturn 
L57:    aload_0 
L58:    getfield [12] 
L61:    aload_2 
L62:    getfield [12] 
L65:    if_icmpeq L70 
L68:    iconst_0 
L69:    areturn 
L70:    iconst_1 
L71:    areturn 
L72:    
    .end code 
.end method 

.method public [141] : [142] 
    .attribute [120] .code stack 3 locals 0 
L0:     new [25] 
L3:     dup 
L4:     ldc [5] 
L6:     invokespecial [20] 
L9:     aload_0 
L10:    getfield [10] 
L13:    invokevirtual [14] 
L16:    ldc [6] 
L18:    invokevirtual [15] 
L21:    aload_0 
L22:    getfield [11] 
L25:    invokevirtual [14] 
L28:    ldc [7] 
L30:    invokevirtual [15] 
L33:    aload_0 
L34:    getfield [12] 
L37:    invokevirtual [14] 
L40:    ldc [8] 
L42:    invokevirtual [15] 
L45:    invokevirtual [16] 
L48:    areturn 
L49:    nop 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [26] 
.const [3] = Method [27] [28] 
.const [4] = Class [29] 
.const [5] = String [30] 
.const [6] = String [31] 
.const [7] = String [32] 
.const [8] = String [33] 
.const [9] = Class [34] 
.const [10] = Field [35] [36] 
.const [11] = Field [37] [38] 
.const [12] = Field [39] [40] 
.const [13] = Method [41] [42] 
.const [14] = Method [43] [44] 
.const [15] = Method [45] [46] 
.const [16] = Method [47] [48] 
.const [17] = Method [49] [50] 
.const [18] = Method [51] [52] 
.const [19] = Method [53] [54] 
.const [20] = Method [55] [56] 
.const [21] = Class [57] 
.const [22] = Field [58] [59] 
.const [23] = Field [60] [61] 
.const [24] = Field [62] [63] 
.const [25] = Class [64] 
.const [26] = Utf8 de/audi/atip/interapp/bap/ecall/data/PhoneCall 
.const [27] = Class [65] 
.const [28] = NameAndType [66] [67] 
.const [29] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [30] = Utf8 'PhoneCall [id=' 
.const [31] = Utf8 ', kind=' 
.const [32] = Utf8 ', state=' 
.const [33] = Utf8 ']' 
.const [34] = Utf8 java/lang/Object 
.const [35] = Class [68] 
.const [36] = NameAndType [69] [70] 
.const [37] = Class [71] 
.const [38] = NameAndType [72] [73] 
.const [39] = Class [74] 
.const [40] = NameAndType [75] [76] 
.const [41] = Class [77] 
.const [42] = NameAndType [78] [79] 
.const [43] = Class [80] 
.const [44] = NameAndType [81] [82] 
.const [45] = Class [83] 
.const [46] = NameAndType [84] [85] 
.const [47] = Class [86] 
.const [48] = NameAndType [87] [88] 
.const [49] = Class [89] 
.const [50] = NameAndType [90] [91] 
.const [51] = Class [92] 
.const [52] = NameAndType [93] [94] 
.const [53] = Class [95] 
.const [54] = NameAndType [96] [97] 
.const [55] = Class [98] 
.const [56] = NameAndType [99] [100] 
.const [57] = Utf8 de/audi/atip/interapp/bap/ecall/data/PhoneCall 
.const [58] = Class [101] 
.const [59] = NameAndType [102] [103] 
.const [60] = Class [104] 
.const [61] = NameAndType [105] [106] 
.const [62] = Class [107] 
.const [63] = NameAndType [108] [109] 
.const [64] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [65] = Utf8 de/audi/atip/interapp/bap/ecall/data/PhoneCall 
.const [66] = Utf8 getInstance 
.const [67] = Utf8 (III)Lde/audi/atip/interapp/bap/ecall/data/PhoneCall; 
.const [68] = Utf8 de/audi/atip/interapp/bap/ecall/data/PhoneCall 
.const [69] = Utf8 id 
.const [70] = Utf8 I 
.const [71] = Utf8 de/audi/atip/interapp/bap/ecall/data/PhoneCall 
.const [72] = Utf8 kind 
.const [73] = Utf8 I 
.const [74] = Utf8 de/audi/atip/interapp/bap/ecall/data/PhoneCall 
.const [75] = Utf8 state 
.const [76] = Utf8 I 
.const [77] = Utf8 de/audi/atip/interapp/bap/ecall/data/PhoneCall 
.const [78] = Utf8 getKind 
.const [79] = Utf8 ()I 
.const [80] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [81] = Utf8 append 
.const [82] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [83] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [84] = Utf8 append 
.const [85] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [86] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [87] = Utf8 toString 
.const [88] = Utf8 ()Ljava/lang/String; 
.const [89] = Utf8 de/audi/atip/interapp/bap/ecall/data/PhoneCall 
.const [90] = Utf8 <init> 
.const [91] = Utf8 (III)V 
.const [92] = Utf8 java/lang/Object 
.const [93] = Utf8 <init> 
.const [94] = Utf8 ()V 
.const [95] = Utf8 java/lang/Object 
.const [96] = Utf8 getClass 
.const [97] = Utf8 ()Ljava/lang/Class; 
.const [98] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [99] = Utf8 <init> 
.const [100] = Utf8 (Ljava/lang/String;)V 
.const [101] = Utf8 de/audi/atip/interapp/bap/ecall/data/PhoneCall 
.const [102] = Utf8 id 
.const [103] = Utf8 I 
.const [104] = Utf8 de/audi/atip/interapp/bap/ecall/data/PhoneCall 
.const [105] = Utf8 kind 
.const [106] = Utf8 I 
.const [107] = Utf8 de/audi/atip/interapp/bap/ecall/data/PhoneCall 
.const [108] = Utf8 state 
.const [109] = Utf8 I 
.const [110] = Utf8 de/audi/atip/interapp/bap/ecall/data/PhoneCall 
.const [111] = Class [110] 
.const [112] = Utf8 java/lang/Object 
.const [113] = Class [112] 
.const [114] = Utf8 id 
.const [115] = Utf8 I 
.const [116] = Utf8 kind 
.const [117] = Utf8 I 
.const [118] = Utf8 state 
.const [119] = Utf8 I 
.const [120] = Utf8 Code 
.const [121] = Utf8 getInstance 
.const [122] = Utf8 (III)Lde/audi/atip/interapp/bap/ecall/data/PhoneCall; 
.const [123] = Utf8 getNullInstance 
.const [124] = Utf8 ()Lde/audi/atip/interapp/bap/ecall/data/PhoneCall; 
.const [125] = Utf8 <init> 
.const [126] = Utf8 (III)V 
.const [127] = Utf8 getId 
.const [128] = Utf8 ()I 
.const [129] = Utf8 getKind 
.const [130] = Utf8 ()I 
.const [131] = Utf8 getState 
.const [132] = Utf8 ()I 
.const [133] = Utf8 isServiceCall 
.const [134] = Utf8 ()Z 
.const [135] = Utf8 isLowPrioritySOSCall 
.const [136] = Utf8 ()Z 
.const [137] = Utf8 hashCode 
.const [138] = Utf8 ()I 
.const [139] = Utf8 equals 
.const [140] = Utf8 (Ljava/lang/Object;)Z 
.const [141] = Utf8 toString 
.const [142] = Utf8 ()Ljava/lang/String; 
.end class 
