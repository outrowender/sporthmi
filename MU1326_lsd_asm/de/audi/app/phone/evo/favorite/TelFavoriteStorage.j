.version 50 0 
.class public super [115] 
.super [117] 
.implements [119] 
.field private static final [120] [121] 
.field private final [122] [123] 
.field private final [124] [125] 
.field private final [126] [127] 

.method public [129] : [130] 
    .attribute [128] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     iconst_0 
L4:     invokespecial [19] 
L7:     return 
L8:     
    .end code 
.end method 

.method public [131] : [132] 
    .attribute [128] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [20] 
L4:     aload_1 
L5:     ifnonnull L18 
L8:     new [24] 
L11:    dup 
L12:    ldc [3] 
L14:    invokespecial [21] 
L17:    athrow 
L18:    aload_2 
L19:    ifnonnull L32 
L22:    new [24] 
L25:    dup 
L26:    ldc [4] 
L28:    invokespecial [21] 
L31:    athrow 
L32:    aload_0 
L33:    aload_1 
L34:    putfield [25] 
L37:    aload_0 
L38:    aload_2 
L39:    putfield [26] 
L42:    aload_0 
L43:    iload_3 
L44:    putfield [27] 
L47:    return 
L48:    
    .end code 
.end method 

.method public interface [133] : [134] 
    .attribute [128] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [135] : [136] 
    .attribute [128] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [137] : [138] 
    .attribute [128] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [139] : [140] 
    .attribute [128] .code stack 2 locals 1 
L0:     new [28] 
L3:     dup 
L4:     invokespecial [22] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [6] 
L11:    invokevirtual [16] 
L14:    pop 
L15:    aload_1 
L16:    aload_0 
L17:    getfield [13] 
L20:    invokevirtual [16] 
L23:    pop 
L24:    aload_1 
L25:    ldc [7] 
L27:    invokevirtual [16] 
L30:    pop 
L31:    aload_1 
L32:    aload_0 
L33:    getfield [14] 
L36:    invokevirtual [16] 
L39:    pop 
L40:    aload_1 
L41:    ldc [8] 
L43:    invokevirtual [16] 
L46:    pop 
L47:    aload_1 
L48:    aload_0 
L49:    getfield [15] 
L52:    invokevirtual [17] 
L55:    pop 
L56:    aload_1 
L57:    ldc [9] 
L59:    invokevirtual [16] 
L62:    pop 
L63:    aload_1 
L64:    invokevirtual [18] 
L67:    areturn 
L68:    
    .end code 
.end method 

.method public [141] : [142] 
    .attribute [128] .code stack 3 locals 0 
L0:     new [29] 
L3:     dup 
L4:     aload_0 
L5:     invokespecial [23] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [30] 
.const [3] = String [31] 
.const [4] = String [32] 
.const [5] = Class [33] 
.const [6] = String [34] 
.const [7] = String [35] 
.const [8] = String [36] 
.const [9] = String [37] 
.const [10] = Class [38] 
.const [11] = Class [39] 
.const [12] = Class [40] 
.const [13] = Field [41] [42] 
.const [14] = Field [43] [44] 
.const [15] = Field [45] [46] 
.const [16] = Method [47] [48] 
.const [17] = Method [49] [50] 
.const [18] = Method [51] [52] 
.const [19] = Method [53] [54] 
.const [20] = Method [55] [56] 
.const [21] = Method [57] [58] 
.const [22] = Method [59] [60] 
.const [23] = Method [61] [62] 
.const [24] = Class [63] 
.const [25] = Field [64] [65] 
.const [26] = Field [66] [67] 
.const [27] = Field [68] [69] 
.const [28] = Class [70] 
.const [29] = Class [71] 
.const [30] = Utf8 java/lang/IllegalArgumentException 
.const [31] = Utf8 'TelFavorite#combinedName is null!' 
.const [32] = Utf8 'TelFavorite#telNumber is null!' 
.const [33] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [34] = Utf8 'TelFavoriteStorage(combinedName=' 
.const [35] = Utf8 ', telNumber=' 
.const [36] = Utf8 ', phoneNumberType=' 
.const [37] = Utf8 ')' 
.const [38] = Utf8 de/audi/app/phone/evo/favorite/TelEvoFavoriteListRow 
.const [39] = Utf8 de/audi/app/phone/evo/favorite/TelFavoriteStorage 
.const [40] = Utf8 java/lang/Object 
.const [41] = Class [72] 
.const [42] = NameAndType [73] [74] 
.const [43] = Class [75] 
.const [44] = NameAndType [76] [77] 
.const [45] = Class [78] 
.const [46] = NameAndType [79] [80] 
.const [47] = Class [81] 
.const [48] = NameAndType [82] [83] 
.const [49] = Class [84] 
.const [50] = NameAndType [85] [86] 
.const [51] = Class [87] 
.const [52] = NameAndType [88] [89] 
.const [53] = Class [90] 
.const [54] = NameAndType [91] [92] 
.const [55] = Class [93] 
.const [56] = NameAndType [94] [95] 
.const [57] = Class [96] 
.const [58] = NameAndType [97] [98] 
.const [59] = Class [99] 
.const [60] = NameAndType [100] [101] 
.const [61] = Class [102] 
.const [62] = NameAndType [103] [104] 
.const [63] = Utf8 java/lang/IllegalArgumentException 
.const [64] = Class [105] 
.const [65] = NameAndType [106] [107] 
.const [66] = Class [108] 
.const [67] = NameAndType [109] [110] 
.const [68] = Class [111] 
.const [69] = NameAndType [112] [113] 
.const [70] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [71] = Utf8 de/audi/app/phone/evo/favorite/TelEvoFavoriteListRow 
.const [72] = Utf8 de/audi/app/phone/evo/favorite/TelFavoriteStorage 
.const [73] = Utf8 combinedName 
.const [74] = Utf8 Ljava/lang/String; 
.const [75] = Utf8 de/audi/app/phone/evo/favorite/TelFavoriteStorage 
.const [76] = Utf8 telNumber 
.const [77] = Utf8 Ljava/lang/String; 
.const [78] = Utf8 de/audi/app/phone/evo/favorite/TelFavoriteStorage 
.const [79] = Utf8 phoneNumberType 
.const [80] = Utf8 I 
.const [81] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [82] = Utf8 append 
.const [83] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [84] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [85] = Utf8 append 
.const [86] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [87] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [88] = Utf8 toString 
.const [89] = Utf8 ()Ljava/lang/String; 
.const [90] = Utf8 de/audi/app/phone/evo/favorite/TelFavoriteStorage 
.const [91] = Utf8 <init> 
.const [92] = Utf8 (Ljava/lang/String;Ljava/lang/String;I)V 
.const [93] = Utf8 java/lang/Object 
.const [94] = Utf8 <init> 
.const [95] = Utf8 ()V 
.const [96] = Utf8 java/lang/IllegalArgumentException 
.const [97] = Utf8 <init> 
.const [98] = Utf8 (Ljava/lang/String;)V 
.const [99] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [100] = Utf8 <init> 
.const [101] = Utf8 ()V 
.const [102] = Utf8 de/audi/app/phone/evo/favorite/TelEvoFavoriteListRow 
.const [103] = Utf8 <init> 
.const [104] = Utf8 (Lde/audi/app/phone/evo/favorite/ITelFavorite;)V 
.const [105] = Utf8 de/audi/app/phone/evo/favorite/TelFavoriteStorage 
.const [106] = Utf8 combinedName 
.const [107] = Utf8 Ljava/lang/String; 
.const [108] = Utf8 de/audi/app/phone/evo/favorite/TelFavoriteStorage 
.const [109] = Utf8 telNumber 
.const [110] = Utf8 Ljava/lang/String; 
.const [111] = Utf8 de/audi/app/phone/evo/favorite/TelFavoriteStorage 
.const [112] = Utf8 phoneNumberType 
.const [113] = Utf8 I 
.const [114] = Utf8 de/audi/app/phone/evo/favorite/TelFavoriteStorage 
.const [115] = Class [114] 
.const [116] = Utf8 java/lang/Object 
.const [117] = Class [116] 
.const [118] = Utf8 de/audi/app/phone/evo/favorite/ITelFavorite 
.const [119] = Class [118] 
.const [120] = Utf8 serialVersionUID 
.const [121] = Utf8 J 
.const [122] = Utf8 combinedName 
.const [123] = Utf8 Ljava/lang/String; 
.const [124] = Utf8 telNumber 
.const [125] = Utf8 Ljava/lang/String; 
.const [126] = Utf8 phoneNumberType 
.const [127] = Utf8 I 
.const [128] = Utf8 Code 
.const [129] = Utf8 <init> 
.const [130] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.const [131] = Utf8 <init> 
.const [132] = Utf8 (Ljava/lang/String;Ljava/lang/String;I)V 
.const [133] = Utf8 getName 
.const [134] = Utf8 ()Ljava/lang/String; 
.const [135] = Utf8 getTelNumber 
.const [136] = Utf8 ()Ljava/lang/String; 
.const [137] = Utf8 getPhoneNumberType 
.const [138] = Utf8 ()I 
.const [139] = Utf8 toString 
.const [140] = Utf8 ()Ljava/lang/String; 
.const [141] = Utf8 getFavoriteListRow 
.const [142] = Utf8 ()Lde/audi/atip/favorite/FavoriteListRow; 
.end class 
