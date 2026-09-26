.version 50 0 
.class public super [57] 
.super [59] 

.method public annotation [61] : [62] 
    .attribute [60] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [10] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [63] : [64] 
    .attribute [60] .code stack 4 locals 0 
L0:     new [13] 
L3:     dup 
L4:     lload_0 
L5:     invokestatic [3] 
L8:     invokespecial [11] 
L11:    areturn 
L12:    
    .end code 
.end method 

.method public static [65] : [66] 
    .attribute [60] .code stack 4 locals 1 
L0:     aload_0 
L1:     ifnonnull L6 
L4:     aconst_null 
L5:     areturn 
L6:     aload_0 
L7:     invokevirtual [8] 
L10:    ifne L15 
L13:    aconst_null 
L14:    areturn 
L15:    aload_0 
L16:    invokevirtual [9] 
L19:    astore_1 
L20:    aload_1 
L21:    ifnonnull L26 
L24:    aconst_null 
L25:    areturn 
L26:    new [14] 
L29:    dup 
L30:    aload_1 
L31:    invokestatic [5] 
L34:    invokespecial [12] 
L37:    areturn 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [15] 
.const [3] = Method [16] [17] 
.const [4] = Class [18] 
.const [5] = Method [19] [20] 
.const [6] = Class [21] 
.const [7] = Class [22] 
.const [8] = Method [23] [24] 
.const [9] = Method [25] [26] 
.const [10] = Method [27] [28] 
.const [11] = Method [29] [30] 
.const [12] = Method [31] [32] 
.const [13] = Class [33] 
.const [14] = Class [34] 
.const [15] = Utf8 de/esolutions/fw/util/config/model/ConfigString 
.const [16] = Class [35] 
.const [17] = NameAndType [36] [37] 
.const [18] = Utf8 java/lang/Long 
.const [19] = Class [38] 
.const [20] = NameAndType [39] [40] 
.const [21] = Utf8 java/lang/Object 
.const [22] = Utf8 de/esolutions/fw/util/config/ConfigValue 
.const [23] = Class [41] 
.const [24] = NameAndType [42] [43] 
.const [25] = Class [44] 
.const [26] = NameAndType [45] [46] 
.const [27] = Class [47] 
.const [28] = NameAndType [48] [49] 
.const [29] = Class [50] 
.const [30] = NameAndType [51] [52] 
.const [31] = Class [53] 
.const [32] = NameAndType [54] [55] 
.const [33] = Utf8 de/esolutions/fw/util/config/model/ConfigString 
.const [34] = Utf8 java/lang/Long 
.const [35] = Utf8 java/lang/Long 
.const [36] = Utf8 toString 
.const [37] = Utf8 (J)Ljava/lang/String; 
.const [38] = Utf8 java/lang/Long 
.const [39] = Utf8 parseLong 
.const [40] = Utf8 (Ljava/lang/String;)J 
.const [41] = Utf8 de/esolutions/fw/util/config/ConfigValue 
.const [42] = Utf8 isString 
.const [43] = Utf8 ()Z 
.const [44] = Utf8 de/esolutions/fw/util/config/ConfigValue 
.const [45] = Utf8 getString 
.const [46] = Utf8 ()Ljava/lang/String; 
.const [47] = Utf8 java/lang/Object 
.const [48] = Utf8 <init> 
.const [49] = Utf8 ()V 
.const [50] = Utf8 de/esolutions/fw/util/config/model/ConfigString 
.const [51] = Utf8 <init> 
.const [52] = Utf8 (Ljava/lang/String;)V 
.const [53] = Utf8 java/lang/Long 
.const [54] = Utf8 <init> 
.const [55] = Utf8 (J)V 
.const [56] = Utf8 de/esolutions/fw/util/config/ConfigValueHelper 
.const [57] = Class [56] 
.const [58] = Utf8 java/lang/Object 
.const [59] = Class [58] 
.const [60] = Utf8 Code 
.const [61] = Utf8 <init> 
.const [62] = Utf8 ()V 
.const [63] = Utf8 createConfigLong 
.const [64] = Utf8 (J)Lde/esolutions/fw/util/config/ConfigValue; 
.const [65] = Utf8 getConfigLong 
.const [66] = Utf8 (Lde/esolutions/fw/util/config/ConfigValue;)Ljava/lang/Long; 
.end class 
