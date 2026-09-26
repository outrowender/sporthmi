.version 50 0 
.class public super [77] 
.super [79] 
.field private [80] [81] 

.method public [83] : [84] 
    .attribute [82] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [13] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [15] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [85] : [86] 
    .attribute [82] .code stack 1 locals 0 
L0:     iconst_1 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public interface [87] : [88] 
    .attribute [82] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [89] : [90] 
    .attribute [82] .code stack 1 locals 0 
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

.method public interface [91] : [92] 
    .attribute [82] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [93] : [94] 
    .attribute [82] .code stack 2 locals 0 
L0:     new [16] 
L3:     dup 
L4:     invokespecial [14] 
L7:     ldc [3] 
L9:     invokevirtual [9] 
L12:    aload_0 
L13:    getfield [8] 
L16:    invokevirtual [9] 
L19:    ldc [3] 
L21:    invokevirtual [9] 
L24:    invokevirtual [10] 
L27:    areturn 
L28:    
    .end code 
.end method 

.method public [95] : [96] 
    .attribute [82] .code stack 2 locals 1 
L0:     aload_1 
L1:     instanceof [4] 
L4:     ifne L9 
L7:     iconst_0 
L8:     areturn 
L9:     aload_1 
L10:    checkcast [4] 
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

.method public [97] : [98] 
    .attribute [82] .code stack 2 locals 1 
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

.method public [99] : [100] 
    .attribute [82] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     ifnonnull L16 
L7:     aload_1 
L8:     invokeinterface [17] 0 
L13:    goto L26 
L16:    aload_1 
L17:    aload_0 
L18:    getfield [8] 
L21:    invokeinterface [18] 0 
L26:    return 
L27:    nop 
L28:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [19] 
.const [3] = String [20] 
.const [4] = Class [21] 
.const [5] = Class [22] 
.const [6] = Class [23] 
.const [7] = Class [24] 
.const [8] = Field [25] [26] 
.const [9] = Method [27] [28] 
.const [10] = Method [29] [30] 
.const [11] = Method [31] [32] 
.const [12] = Method [33] [34] 
.const [13] = Method [35] [36] 
.const [14] = Method [37] [38] 
.const [15] = Field [39] [40] 
.const [16] = Class [41] 
.const [17] = InterfaceMethod [42] [43] 
.const [18] = InterfaceMethod [44] [45] 
.const [19] = Utf8 java/lang/StringBuffer 
.const [20] = Utf8 '"' 
.const [21] = Utf8 de/esolutions/fw/util/config/model/ConfigString 
.const [22] = Utf8 de/esolutions/fw/util/config/model/ConfigScalar 
.const [23] = Utf8 java/lang/String 
.const [24] = Utf8 de/esolutions/fw/util/config/writer/IConfigExporter 
.const [25] = Class [46] 
.const [26] = NameAndType [47] [48] 
.const [27] = Class [49] 
.const [28] = NameAndType [50] [51] 
.const [29] = Class [52] 
.const [30] = NameAndType [53] [54] 
.const [31] = Class [55] 
.const [32] = NameAndType [56] [57] 
.const [33] = Class [58] 
.const [34] = NameAndType [59] [60] 
.const [35] = Class [61] 
.const [36] = NameAndType [62] [63] 
.const [37] = Class [64] 
.const [38] = NameAndType [65] [66] 
.const [39] = Class [67] 
.const [40] = NameAndType [68] [69] 
.const [41] = Utf8 java/lang/StringBuffer 
.const [42] = Class [70] 
.const [43] = NameAndType [71] [72] 
.const [44] = Class [73] 
.const [45] = NameAndType [74] [75] 
.const [46] = Utf8 de/esolutions/fw/util/config/model/ConfigString 
.const [47] = Utf8 value 
.const [48] = Utf8 Ljava/lang/String; 
.const [49] = Utf8 java/lang/StringBuffer 
.const [50] = Utf8 append 
.const [51] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [52] = Utf8 java/lang/StringBuffer 
.const [53] = Utf8 toString 
.const [54] = Utf8 ()Ljava/lang/String; 
.const [55] = Utf8 java/lang/String 
.const [56] = Utf8 equals 
.const [57] = Utf8 (Ljava/lang/Object;)Z 
.const [58] = Utf8 java/lang/String 
.const [59] = Utf8 hashCode 
.const [60] = Utf8 ()I 
.const [61] = Utf8 de/esolutions/fw/util/config/model/ConfigScalar 
.const [62] = Utf8 <init> 
.const [63] = Utf8 ()V 
.const [64] = Utf8 java/lang/StringBuffer 
.const [65] = Utf8 <init> 
.const [66] = Utf8 ()V 
.const [67] = Utf8 de/esolutions/fw/util/config/model/ConfigString 
.const [68] = Utf8 value 
.const [69] = Utf8 Ljava/lang/String; 
.const [70] = Utf8 de/esolutions/fw/util/config/writer/IConfigExporter 
.const [71] = Utf8 writeNull 
.const [72] = Utf8 ()V 
.const [73] = Utf8 de/esolutions/fw/util/config/writer/IConfigExporter 
.const [74] = Utf8 writeString 
.const [75] = Utf8 (Ljava/lang/String;)V 
.const [76] = Utf8 de/esolutions/fw/util/config/model/ConfigString 
.const [77] = Class [76] 
.const [78] = Utf8 de/esolutions/fw/util/config/model/ConfigScalar 
.const [79] = Class [78] 
.const [80] = Utf8 value 
.const [81] = Utf8 Ljava/lang/String; 
.const [82] = Utf8 Code 
.const [83] = Utf8 <init> 
.const [84] = Utf8 (Ljava/lang/String;)V 
.const [85] = Utf8 isString 
.const [86] = Utf8 ()Z 
.const [87] = Utf8 getString 
.const [88] = Utf8 ()Ljava/lang/String; 
.const [89] = Utf8 getString 
.const [90] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [91] = Utf8 convertToString 
.const [92] = Utf8 ()Ljava/lang/String; 
.const [93] = Utf8 toString 
.const [94] = Utf8 ()Ljava/lang/String; 
.const [95] = Utf8 equals 
.const [96] = Utf8 (Ljava/lang/Object;)Z 
.const [97] = Utf8 hashCode 
.const [98] = Utf8 ()I 
.const [99] = Utf8 export 
.const [100] = Utf8 (Lde/esolutions/fw/util/config/writer/IConfigExporter;)V 
.end class 
