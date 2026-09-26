.version 50 0 
.class public super [99] 
.super [101] 
.field private [102] [103] 

.method public [105] : [106] 
    .attribute [104] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [14] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [18] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [107] : [108] 
    .attribute [104] .code stack 5 locals 0 
L0:     aload_0 
L1:     invokespecial [14] 
L4:     aload_0 
L5:     new [19] 
L8:     dup 
L9:     dload_1 
L10:    invokespecial [15] 
L13:    putfield [18] 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [109] : [110] 
    .attribute [104] .code stack 1 locals 0 
L0:     iconst_1 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public interface [111] : [112] 
    .attribute [104] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [113] : [114] 
    .attribute [104] .code stack 1 locals 0 
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

.method public [115] : [116] 
    .attribute [104] .code stack 6 locals 0 
L0:     new [20] 
L3:     dup 
L4:     aload_0 
L5:     getfield [8] 
L8:     invokevirtual [9] 
L11:    i2d 
L12:    dconst_0 
L13:    dcmpl 
L14:    ifeq L21 
L17:    iconst_1 
L18:    goto L22 
L21:    iconst_0 
L22:    invokespecial [16] 
L25:    areturn 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [117] : [118] 
    .attribute [104] .code stack 4 locals 0 
L0:     new [21] 
L3:     dup 
L4:     aload_0 
L5:     getfield [8] 
L8:     invokevirtual [10] 
L11:    d2i 
L12:    invokespecial [17] 
L15:    areturn 
L16:    
    .end code 
.end method 

.method public interface [119] : [120] 
    .attribute [104] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [121] : [122] 
    .attribute [104] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     invokevirtual [11] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [123] : [124] 
    .attribute [104] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     invokevirtual [11] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [125] : [126] 
    .attribute [104] .code stack 2 locals 1 
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
L22:    invokevirtual [12] 
L25:    areturn 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [127] : [128] 
    .attribute [104] .code stack 2 locals 1 
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
L21:    invokevirtual [13] 
L24:    iadd 
L25:    istore_1 
L26:    iload_1 
L27:    areturn 
L28:    
    .end code 
.end method 

.method public [129] : [130] 
    .attribute [104] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     ifnonnull L16 
L7:     aload_1 
L8:     invokeinterface [22] 0 
L13:    goto L29 
L16:    aload_1 
L17:    aload_0 
L18:    getfield [8] 
L21:    invokevirtual [10] 
L24:    invokeinterface [23] 0 
L29:    return 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [24] 
.const [3] = Class [25] 
.const [4] = Class [26] 
.const [5] = Class [27] 
.const [6] = Class [28] 
.const [7] = Class [29] 
.const [8] = Field [30] [31] 
.const [9] = Method [32] [33] 
.const [10] = Method [34] [35] 
.const [11] = Method [36] [37] 
.const [12] = Method [38] [39] 
.const [13] = Method [40] [41] 
.const [14] = Method [42] [43] 
.const [15] = Method [44] [45] 
.const [16] = Method [46] [47] 
.const [17] = Method [48] [49] 
.const [18] = Field [50] [51] 
.const [19] = Class [52] 
.const [20] = Class [53] 
.const [21] = Class [54] 
.const [22] = InterfaceMethod [55] [56] 
.const [23] = InterfaceMethod [57] [58] 
.const [24] = Utf8 java/lang/Double 
.const [25] = Utf8 java/lang/Boolean 
.const [26] = Utf8 java/lang/Integer 
.const [27] = Utf8 de/esolutions/fw/util/config/model/ConfigDouble 
.const [28] = Utf8 de/esolutions/fw/util/config/model/ConfigScalar 
.const [29] = Utf8 de/esolutions/fw/util/config/writer/IConfigExporter 
.const [30] = Class [59] 
.const [31] = NameAndType [60] [61] 
.const [32] = Class [62] 
.const [33] = NameAndType [63] [64] 
.const [34] = Class [65] 
.const [35] = NameAndType [66] [67] 
.const [36] = Class [68] 
.const [37] = NameAndType [69] [70] 
.const [38] = Class [71] 
.const [39] = NameAndType [72] [73] 
.const [40] = Class [74] 
.const [41] = NameAndType [75] [76] 
.const [42] = Class [77] 
.const [43] = NameAndType [78] [79] 
.const [44] = Class [80] 
.const [45] = NameAndType [81] [82] 
.const [46] = Class [83] 
.const [47] = NameAndType [84] [85] 
.const [48] = Class [86] 
.const [49] = NameAndType [87] [88] 
.const [50] = Class [89] 
.const [51] = NameAndType [90] [91] 
.const [52] = Utf8 java/lang/Double 
.const [53] = Utf8 java/lang/Boolean 
.const [54] = Utf8 java/lang/Integer 
.const [55] = Class [92] 
.const [56] = NameAndType [93] [94] 
.const [57] = Class [95] 
.const [58] = NameAndType [96] [97] 
.const [59] = Utf8 de/esolutions/fw/util/config/model/ConfigDouble 
.const [60] = Utf8 value 
.const [61] = Utf8 Ljava/lang/Double; 
.const [62] = Utf8 java/lang/Double 
.const [63] = Utf8 intValue 
.const [64] = Utf8 ()I 
.const [65] = Utf8 java/lang/Double 
.const [66] = Utf8 doubleValue 
.const [67] = Utf8 ()D 
.const [68] = Utf8 java/lang/Double 
.const [69] = Utf8 toString 
.const [70] = Utf8 ()Ljava/lang/String; 
.const [71] = Utf8 java/lang/Double 
.const [72] = Utf8 equals 
.const [73] = Utf8 (Ljava/lang/Object;)Z 
.const [74] = Utf8 java/lang/Double 
.const [75] = Utf8 hashCode 
.const [76] = Utf8 ()I 
.const [77] = Utf8 de/esolutions/fw/util/config/model/ConfigScalar 
.const [78] = Utf8 <init> 
.const [79] = Utf8 ()V 
.const [80] = Utf8 java/lang/Double 
.const [81] = Utf8 <init> 
.const [82] = Utf8 (D)V 
.const [83] = Utf8 java/lang/Boolean 
.const [84] = Utf8 <init> 
.const [85] = Utf8 (Z)V 
.const [86] = Utf8 java/lang/Integer 
.const [87] = Utf8 <init> 
.const [88] = Utf8 (I)V 
.const [89] = Utf8 de/esolutions/fw/util/config/model/ConfigDouble 
.const [90] = Utf8 value 
.const [91] = Utf8 Ljava/lang/Double; 
.const [92] = Utf8 de/esolutions/fw/util/config/writer/IConfigExporter 
.const [93] = Utf8 writeNull 
.const [94] = Utf8 ()V 
.const [95] = Utf8 de/esolutions/fw/util/config/writer/IConfigExporter 
.const [96] = Utf8 writeDouble 
.const [97] = Utf8 (D)V 
.const [98] = Utf8 de/esolutions/fw/util/config/model/ConfigDouble 
.const [99] = Class [98] 
.const [100] = Utf8 de/esolutions/fw/util/config/model/ConfigScalar 
.const [101] = Class [100] 
.const [102] = Utf8 value 
.const [103] = Utf8 Ljava/lang/Double; 
.const [104] = Utf8 Code 
.const [105] = Utf8 <init> 
.const [106] = Utf8 (Ljava/lang/Double;)V 
.const [107] = Utf8 <init> 
.const [108] = Utf8 (D)V 
.const [109] = Utf8 isDouble 
.const [110] = Utf8 ()Z 
.const [111] = Utf8 getDouble 
.const [112] = Utf8 ()Ljava/lang/Double; 
.const [113] = Utf8 getDouble 
.const [114] = Utf8 (Ljava/lang/Double;)Ljava/lang/Double; 
.const [115] = Utf8 convertToBoolean 
.const [116] = Utf8 ()Ljava/lang/Boolean; 
.const [117] = Utf8 convertToInteger 
.const [118] = Utf8 ()Ljava/lang/Integer; 
.const [119] = Utf8 convertToDouble 
.const [120] = Utf8 ()Ljava/lang/Double; 
.const [121] = Utf8 convertToString 
.const [122] = Utf8 ()Ljava/lang/String; 
.const [123] = Utf8 toString 
.const [124] = Utf8 ()Ljava/lang/String; 
.const [125] = Utf8 equals 
.const [126] = Utf8 (Ljava/lang/Object;)Z 
.const [127] = Utf8 hashCode 
.const [128] = Utf8 ()I 
.const [129] = Utf8 export 
.const [130] = Utf8 (Lde/esolutions/fw/util/config/writer/IConfigExporter;)V 
.end class 
