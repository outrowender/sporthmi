.version 50 0 
.class public super [63] 
.super [65] 
.field private [66] [67] 
.field private [68] [69] 

.method public [71] : [72] 
    .attribute [70] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [10] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [12] 
L9:     aload_0 
L10:    new [13] 
L13:    dup 
L14:    invokespecial [11] 
L17:    putfield [14] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [73] : [74] 
    .attribute [70] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [10] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [12] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [14] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [75] : [76] 
    .attribute [70] .code stack 3 locals 1 
L0:     aload_1 
L1:     bipush 46 
L3:     invokestatic [3] 
L6:     astore_2 
L7:     aload_2 
L8:     ifnonnull L13 
L11:    aconst_null 
L12:    areturn 
L13:    aload_0 
L14:    getfield [9] 
L17:    aload_2 
L18:    aload_0 
L19:    getfield [8] 
L22:    invokeinterface [15] 0 
L27:    areturn 
L28:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [16] 
.const [3] = Method [17] [18] 
.const [4] = Class [19] 
.const [5] = Class [20] 
.const [6] = Class [21] 
.const [7] = Class [22] 
.const [8] = Field [23] [24] 
.const [9] = Field [25] [26] 
.const [10] = Method [27] [28] 
.const [11] = Method [29] [30] 
.const [12] = Field [31] [32] 
.const [13] = Class [33] 
.const [14] = Field [34] [35] 
.const [15] = InterfaceMethod [36] [37] 
.const [16] = Utf8 de/esolutions/fw/util/config/query/ConfigSimplePathResolver 
.const [17] = Class [38] 
.const [18] = NameAndType [39] [40] 
.const [19] = Utf8 de/esolutions/fw/util/config/query/ConfigPathQuery 
.const [20] = Utf8 de/esolutions/fw/util/config/query/AbstractConfigQuery 
.const [21] = Utf8 de/esolutions/fw/util/commons/StringUtils 
.const [22] = Utf8 de/esolutions/fw/util/config/query/IConfigPathResolver 
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
.const [33] = Utf8 de/esolutions/fw/util/config/query/ConfigSimplePathResolver 
.const [34] = Class [56] 
.const [35] = NameAndType [57] [58] 
.const [36] = Class [59] 
.const [37] = NameAndType [60] [61] 
.const [38] = Utf8 de/esolutions/fw/util/commons/StringUtils 
.const [39] = Utf8 splitString 
.const [40] = Utf8 (Ljava/lang/String;C)[Ljava/lang/String; 
.const [41] = Utf8 de/esolutions/fw/util/config/query/ConfigPathQuery 
.const [42] = Utf8 root 
.const [43] = Utf8 Lde/esolutions/fw/util/config/ConfigValue; 
.const [44] = Utf8 de/esolutions/fw/util/config/query/ConfigPathQuery 
.const [45] = Utf8 resolver 
.const [46] = Utf8 Lde/esolutions/fw/util/config/query/IConfigPathResolver; 
.const [47] = Utf8 de/esolutions/fw/util/config/query/AbstractConfigQuery 
.const [48] = Utf8 <init> 
.const [49] = Utf8 ()V 
.const [50] = Utf8 de/esolutions/fw/util/config/query/ConfigSimplePathResolver 
.const [51] = Utf8 <init> 
.const [52] = Utf8 ()V 
.const [53] = Utf8 de/esolutions/fw/util/config/query/ConfigPathQuery 
.const [54] = Utf8 root 
.const [55] = Utf8 Lde/esolutions/fw/util/config/ConfigValue; 
.const [56] = Utf8 de/esolutions/fw/util/config/query/ConfigPathQuery 
.const [57] = Utf8 resolver 
.const [58] = Utf8 Lde/esolutions/fw/util/config/query/IConfigPathResolver; 
.const [59] = Utf8 de/esolutions/fw/util/config/query/IConfigPathResolver 
.const [60] = Utf8 resolvePath 
.const [61] = Utf8 ([Ljava/lang/String;Lde/esolutions/fw/util/config/ConfigValue;)Lde/esolutions/fw/util/config/ConfigValue; 
.const [62] = Utf8 de/esolutions/fw/util/config/query/ConfigPathQuery 
.const [63] = Class [62] 
.const [64] = Utf8 de/esolutions/fw/util/config/query/AbstractConfigQuery 
.const [65] = Class [64] 
.const [66] = Utf8 root 
.const [67] = Utf8 Lde/esolutions/fw/util/config/ConfigValue; 
.const [68] = Utf8 resolver 
.const [69] = Utf8 Lde/esolutions/fw/util/config/query/IConfigPathResolver; 
.const [70] = Utf8 Code 
.const [71] = Utf8 <init> 
.const [72] = Utf8 (Lde/esolutions/fw/util/config/ConfigValue;)V 
.const [73] = Utf8 <init> 
.const [74] = Utf8 (Lde/esolutions/fw/util/config/ConfigValue;Lde/esolutions/fw/util/config/query/IConfigPathResolver;)V 
.const [75] = Utf8 getValue 
.const [76] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/config/ConfigValue; 
.end class 
