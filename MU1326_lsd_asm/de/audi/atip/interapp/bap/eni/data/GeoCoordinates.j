.version 50 0 
.class public final super [85] 
.super [87] 
.field private final [88] [89] 
.field private final [90] [91] 

.method public static [93] : [94] 
    .attribute [92] .code stack 4 locals 0 
L0:     new [17] 
L3:     dup 
L4:     iload_0 
L5:     iload_1 
L6:     invokespecial [13] 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [95] : [96] 
    .attribute [92] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [14] 
L4:     aload_0 
L5:     iload_1 
L6:     putfield [18] 
L9:     aload_0 
L10:    iload_2 
L11:    putfield [19] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public interface [97] : [98] 
    .attribute [92] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [99] : [100] 
    .attribute [92] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [9] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [101] : [102] 
    .attribute [92] .code stack 2 locals 2 
L0:     iconst_1 
L1:     istore_2 
L2:     bipush 31 
L4:     iload_2 
L5:     imul 
L6:     aload_0 
L7:     getfield [9] 
L10:    iadd 
L11:    istore_2 
L12:    bipush 31 
L14:    iload_2 
L15:    imul 
L16:    aload_0 
L17:    getfield [8] 
L20:    iadd 
L21:    istore_2 
L22:    iload_2 
L23:    areturn 
L24:    
    .end code 
.end method 

.method public [103] : [104] 
    .attribute [92] .code stack 2 locals 1 
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
L14:    invokespecial [15] 
L17:    aload_1 
L18:    invokespecial [15] 
L21:    if_acmpeq L26 
L24:    iconst_0 
L25:    areturn 
L26:    aload_1 
L27:    checkcast [2] 
L30:    astore_2 
L31:    aload_0 
L32:    getfield [9] 
L35:    aload_2 
L36:    getfield [9] 
L39:    if_icmpeq L44 
L42:    iconst_0 
L43:    areturn 
L44:    aload_0 
L45:    getfield [8] 
L48:    aload_2 
L49:    getfield [8] 
L52:    if_icmpeq L57 
L55:    iconst_0 
L56:    areturn 
L57:    iconst_1 
L58:    areturn 
L59:    nop 
L60:    
    .end code 
.end method 

.method public [105] : [106] 
    .attribute [92] .code stack 3 locals 0 
L0:     new [20] 
L3:     dup 
L4:     ldc [4] 
L6:     invokespecial [16] 
L9:     aload_0 
L10:    getfield [8] 
L13:    invokevirtual [10] 
L16:    ldc [5] 
L18:    invokevirtual [11] 
L21:    aload_0 
L22:    getfield [9] 
L25:    invokevirtual [10] 
L28:    ldc [6] 
L30:    invokevirtual [11] 
L33:    invokevirtual [12] 
L36:    areturn 
L37:    nop 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [21] 
.const [3] = Class [22] 
.const [4] = String [23] 
.const [5] = String [24] 
.const [6] = String [25] 
.const [7] = Class [26] 
.const [8] = Field [27] [28] 
.const [9] = Field [29] [30] 
.const [10] = Method [31] [32] 
.const [11] = Method [33] [34] 
.const [12] = Method [35] [36] 
.const [13] = Method [37] [38] 
.const [14] = Method [39] [40] 
.const [15] = Method [41] [42] 
.const [16] = Method [43] [44] 
.const [17] = Class [45] 
.const [18] = Field [46] [47] 
.const [19] = Field [48] [49] 
.const [20] = Class [50] 
.const [21] = Utf8 de/audi/atip/interapp/bap/eni/data/GeoCoordinates 
.const [22] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [23] = Utf8 'GeoCoordinates [longitude=' 
.const [24] = Utf8 ', latitude=' 
.const [25] = Utf8 ']' 
.const [26] = Utf8 java/lang/Object 
.const [27] = Class [51] 
.const [28] = NameAndType [52] [53] 
.const [29] = Class [54] 
.const [30] = NameAndType [55] [56] 
.const [31] = Class [57] 
.const [32] = NameAndType [58] [59] 
.const [33] = Class [60] 
.const [34] = NameAndType [61] [62] 
.const [35] = Class [63] 
.const [36] = NameAndType [64] [65] 
.const [37] = Class [66] 
.const [38] = NameAndType [67] [68] 
.const [39] = Class [69] 
.const [40] = NameAndType [70] [71] 
.const [41] = Class [72] 
.const [42] = NameAndType [73] [74] 
.const [43] = Class [75] 
.const [44] = NameAndType [76] [77] 
.const [45] = Utf8 de/audi/atip/interapp/bap/eni/data/GeoCoordinates 
.const [46] = Class [78] 
.const [47] = NameAndType [79] [80] 
.const [48] = Class [81] 
.const [49] = NameAndType [82] [83] 
.const [50] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [51] = Utf8 de/audi/atip/interapp/bap/eni/data/GeoCoordinates 
.const [52] = Utf8 longitude 
.const [53] = Utf8 I 
.const [54] = Utf8 de/audi/atip/interapp/bap/eni/data/GeoCoordinates 
.const [55] = Utf8 latitude 
.const [56] = Utf8 I 
.const [57] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [58] = Utf8 append 
.const [59] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [60] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [61] = Utf8 append 
.const [62] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [63] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [64] = Utf8 toString 
.const [65] = Utf8 ()Ljava/lang/String; 
.const [66] = Utf8 de/audi/atip/interapp/bap/eni/data/GeoCoordinates 
.const [67] = Utf8 <init> 
.const [68] = Utf8 (II)V 
.const [69] = Utf8 java/lang/Object 
.const [70] = Utf8 <init> 
.const [71] = Utf8 ()V 
.const [72] = Utf8 java/lang/Object 
.const [73] = Utf8 getClass 
.const [74] = Utf8 ()Ljava/lang/Class; 
.const [75] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [76] = Utf8 <init> 
.const [77] = Utf8 (Ljava/lang/String;)V 
.const [78] = Utf8 de/audi/atip/interapp/bap/eni/data/GeoCoordinates 
.const [79] = Utf8 longitude 
.const [80] = Utf8 I 
.const [81] = Utf8 de/audi/atip/interapp/bap/eni/data/GeoCoordinates 
.const [82] = Utf8 latitude 
.const [83] = Utf8 I 
.const [84] = Utf8 de/audi/atip/interapp/bap/eni/data/GeoCoordinates 
.const [85] = Class [84] 
.const [86] = Utf8 java/lang/Object 
.const [87] = Class [86] 
.const [88] = Utf8 longitude 
.const [89] = Utf8 I 
.const [90] = Utf8 latitude 
.const [91] = Utf8 I 
.const [92] = Utf8 Code 
.const [93] = Utf8 getInstance 
.const [94] = Utf8 (II)Lde/audi/atip/interapp/bap/eni/data/GeoCoordinates; 
.const [95] = Utf8 <init> 
.const [96] = Utf8 (II)V 
.const [97] = Utf8 getLongitude 
.const [98] = Utf8 ()I 
.const [99] = Utf8 getLatitude 
.const [100] = Utf8 ()I 
.const [101] = Utf8 hashCode 
.const [102] = Utf8 ()I 
.const [103] = Utf8 equals 
.const [104] = Utf8 (Ljava/lang/Object;)Z 
.const [105] = Utf8 toString 
.const [106] = Utf8 ()Ljava/lang/String; 
.end class 
