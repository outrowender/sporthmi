.version 50 0 
.class public super [93] 
.super [95] 
.field private [96] [97] 

.method public [99] : [100] 
    .attribute [98] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [13] 
L4:     aload_0 
L5:     new [17] 
L8:     dup 
L9:     iload_1 
L10:    invokespecial [14] 
L13:    putfield [18] 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [101] : [102] 
    .attribute [98] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [13] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [18] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [103] : [104] 
    .attribute [98] .code stack 1 locals 0 
L0:     iconst_1 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public interface [105] : [106] 
    .attribute [98] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [107] : [108] 
    .attribute [98] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     ifnonnull L9 
L7:     aload_1 
L8:     areturn 
L9:     aload_0 
L10:    getfield [8] 
L13:    areturn 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public interface [109] : [110] 
    .attribute [98] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [111] : [112] 
    .attribute [98] .code stack 3 locals 0 
L0:     new [19] 
L3:     dup 
L4:     aload_0 
L5:     getfield [8] 
L8:     invokevirtual [9] 
L11:    ifeq L18 
L14:    iconst_1 
L15:    goto L19 
L18:    iconst_0 
L19:    invokespecial [15] 
L22:    areturn 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [113] : [114] 
    .attribute [98] .code stack 4 locals 0 
L0:     new [20] 
L3:     dup 
L4:     aload_0 
L5:     getfield [8] 
L8:     invokevirtual [9] 
L11:    ifeq L18 
L14:    dconst_1 
L15:    goto L19 
L18:    dconst_0 
L19:    invokespecial [16] 
L22:    areturn 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [115] : [116] 
    .attribute [98] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     invokevirtual [10] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [117] : [118] 
    .attribute [98] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     invokevirtual [10] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [119] : [120] 
    .attribute [98] .code stack 2 locals 1 
L0:     aload_1 
L1:     instanceof [5] 
L4:     ifne L9 
L7:     iconst_0 
L8:     areturn 
L9:     aload_1 
L10:    checkcast [5] 
L13:    astore_2 
L14:    aload_0 
L15:    getfield [8] 
L18:    aload_2 
L19:    getfield [8] 
L22:    invokevirtual [11] 
L25:    areturn 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [121] : [122] 
    .attribute [98] .code stack 2 locals 1 
L0:     iconst_1 
L1:     istore_1 
L2:     iload_1 
L3:     bipush 17 
L5:     imul 
L6:     aload_0 
L7:     getfield [8] 
L10:    ifnonnull L17 
L13:    iconst_0 
L14:    goto L24 
L17:    aload_0 
L18:    getfield [8] 
L21:    invokevirtual [12] 
L24:    iadd 
L25:    istore_1 
L26:    iload_1 
L27:    areturn 
L28:    
    .end code 
.end method 

.method public [123] : [124] 
    .attribute [98] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     ifnonnull L16 
L7:     aload_1 
L8:     invokeinterface [21] 0 
L13:    goto L29 
L16:    aload_1 
L17:    aload_0 
L18:    getfield [8] 
L21:    invokevirtual [9] 
L24:    invokeinterface [22] 0 
L29:    return 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [23] 
.const [3] = Class [24] 
.const [4] = Class [25] 
.const [5] = Class [26] 
.const [6] = Class [27] 
.const [7] = Class [28] 
.const [8] = Field [29] [30] 
.const [9] = Method [31] [32] 
.const [10] = Method [33] [34] 
.const [11] = Method [35] [36] 
.const [12] = Method [37] [38] 
.const [13] = Method [39] [40] 
.const [14] = Method [41] [42] 
.const [15] = Method [43] [44] 
.const [16] = Method [45] [46] 
.const [17] = Class [47] 
.const [18] = Field [48] [49] 
.const [19] = Class [50] 
.const [20] = Class [51] 
.const [21] = InterfaceMethod [52] [53] 
.const [22] = InterfaceMethod [54] [55] 
.const [23] = Utf8 java/lang/Boolean 
.const [24] = Utf8 java/lang/Integer 
.const [25] = Utf8 java/lang/Double 
.const [26] = Utf8 de/esolutions/fw/util/config/model/ConfigBoolean 
.const [27] = Utf8 de/esolutions/fw/util/config/model/ConfigScalar 
.const [28] = Utf8 de/esolutions/fw/util/config/writer/IConfigExporter 
.const [29] = Class [56] 
.const [30] = NameAndType [57] [58] 
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
.const [47] = Utf8 java/lang/Boolean 
.const [48] = Class [83] 
.const [49] = NameAndType [84] [85] 
.const [50] = Utf8 java/lang/Integer 
.const [51] = Utf8 java/lang/Double 
.const [52] = Class [86] 
.const [53] = NameAndType [87] [88] 
.const [54] = Class [89] 
.const [55] = NameAndType [90] [91] 
.const [56] = Utf8 de/esolutions/fw/util/config/model/ConfigBoolean 
.const [57] = Utf8 value 
.const [58] = Utf8 Ljava/lang/Boolean; 
.const [59] = Utf8 java/lang/Boolean 
.const [60] = Utf8 booleanValue 
.const [61] = Utf8 ()Z 
.const [62] = Utf8 java/lang/Boolean 
.const [63] = Utf8 toString 
.const [64] = Utf8 ()Ljava/lang/String; 
.const [65] = Utf8 java/lang/Boolean 
.const [66] = Utf8 equals 
.const [67] = Utf8 (Ljava/lang/Object;)Z 
.const [68] = Utf8 java/lang/Boolean 
.const [69] = Utf8 hashCode 
.const [70] = Utf8 ()I 
.const [71] = Utf8 de/esolutions/fw/util/config/model/ConfigScalar 
.const [72] = Utf8 <init> 
.const [73] = Utf8 ()V 
.const [74] = Utf8 java/lang/Boolean 
.const [75] = Utf8 <init> 
.const [76] = Utf8 (Z)V 
.const [77] = Utf8 java/lang/Integer 
.const [78] = Utf8 <init> 
.const [79] = Utf8 (I)V 
.const [80] = Utf8 java/lang/Double 
.const [81] = Utf8 <init> 
.const [82] = Utf8 (D)V 
.const [83] = Utf8 de/esolutions/fw/util/config/model/ConfigBoolean 
.const [84] = Utf8 value 
.const [85] = Utf8 Ljava/lang/Boolean; 
.const [86] = Utf8 de/esolutions/fw/util/config/writer/IConfigExporter 
.const [87] = Utf8 writeNull 
.const [88] = Utf8 ()V 
.const [89] = Utf8 de/esolutions/fw/util/config/writer/IConfigExporter 
.const [90] = Utf8 writeBoolean 
.const [91] = Utf8 (Z)V 
.const [92] = Utf8 de/esolutions/fw/util/config/model/ConfigBoolean 
.const [93] = Class [92] 
.const [94] = Utf8 de/esolutions/fw/util/config/model/ConfigScalar 
.const [95] = Class [94] 
.const [96] = Utf8 value 
.const [97] = Utf8 Ljava/lang/Boolean; 
.const [98] = Utf8 Code 
.const [99] = Utf8 <init> 
.const [100] = Utf8 (Z)V 
.const [101] = Utf8 <init> 
.const [102] = Utf8 (Ljava/lang/Boolean;)V 
.const [103] = Utf8 isBoolean 
.const [104] = Utf8 ()Z 
.const [105] = Utf8 getBoolean 
.const [106] = Utf8 ()Ljava/lang/Boolean; 
.const [107] = Utf8 getBoolean 
.const [108] = Utf8 (Ljava/lang/Boolean;)Ljava/lang/Boolean; 
.const [109] = Utf8 convertToBoolean 
.const [110] = Utf8 ()Ljava/lang/Boolean; 
.const [111] = Utf8 convertToInteger 
.const [112] = Utf8 ()Ljava/lang/Integer; 
.const [113] = Utf8 convertToDouble 
.const [114] = Utf8 ()Ljava/lang/Double; 
.const [115] = Utf8 convertToString 
.const [116] = Utf8 ()Ljava/lang/String; 
.const [117] = Utf8 toString 
.const [118] = Utf8 ()Ljava/lang/String; 
.const [119] = Utf8 equals 
.const [120] = Utf8 (Ljava/lang/Object;)Z 
.const [121] = Utf8 hashCode 
.const [122] = Utf8 ()I 
.const [123] = Utf8 export 
.const [124] = Utf8 (Lde/esolutions/fw/util/config/writer/IConfigExporter;)V 
.end class 
