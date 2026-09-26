.version 50 0 
.class public super [91] 
.super [93] 
.field private final [94] [95] 
.field private final [96] [97] 

.method public [99] : [100] 
    .attribute [98] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [17] 
L4:     aload_0 
L5:     iload_1 
L6:     putfield [19] 
L9:     aload_0 
L10:    iload_2 
L11:    putfield [20] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public interface [101] : [102] 
    .attribute [98] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [103] : [104] 
    .attribute [98] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [105] : [106] 
    .attribute [98] .code stack 3 locals 0 
L0:     new [21] 
L3:     dup 
L4:     invokespecial [18] 
L7:     ldc [3] 
L9:     invokevirtual [12] 
L12:    aload_0 
L13:    getfield [11] 
L16:    invokevirtual [13] 
L19:    ldc [4] 
L21:    invokevirtual [12] 
L24:    getstatic [5] 
L27:    aload_0 
L28:    getfield [10] 
L31:    aaload 
L32:    invokevirtual [12] 
L35:    ldc [6] 
L37:    invokevirtual [12] 
L40:    invokevirtual [14] 
L43:    areturn 
L44:    
    .end code 
.end method 

.method public [107] : [108] 
    .attribute [98] .code stack 2 locals 1 
L0:     aload_1 
L1:     instanceof [7] 
L4:     ifne L9 
L7:     iconst_0 
L8:     areturn 
L9:     aload_1 
L10:    checkcast [7] 
L13:    astore_2 
L14:    aload_2 
L15:    invokevirtual [15] 
L18:    aload_0 
L19:    invokevirtual [15] 
L22:    if_icmpne L40 
L25:    aload_2 
L26:    invokevirtual [16] 
L29:    aload_0 
L30:    invokevirtual [16] 
L33:    if_icmpne L40 
L36:    iconst_1 
L37:    goto L41 
L40:    iconst_0 
L41:    areturn 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [109] : [110] 
    .attribute [98] .code stack 3 locals 1 
L0:     iconst_1 
L1:     istore_1 
L2:     iload_1 
L3:     bipush 11 
L5:     aload_0 
L6:     getfield [10] 
L9:     imul 
L10:    iadd 
L11:    istore_1 
L12:    iload_1 
L13:    bipush 53 
L15:    aload_0 
L16:    getfield [11] 
L19:    imul 
L20:    iadd 
L21:    istore_1 
L22:    iload_1 
L23:    areturn 
L24:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [22] 
.const [3] = String [23] 
.const [4] = String [24] 
.const [5] = Field [25] [26] 
.const [6] = String [27] 
.const [7] = Class [28] 
.const [8] = Class [29] 
.const [9] = Class [30] 
.const [10] = Field [31] [32] 
.const [11] = Field [33] [34] 
.const [12] = Method [35] [36] 
.const [13] = Method [37] [38] 
.const [14] = Method [39] [40] 
.const [15] = Method [41] [42] 
.const [16] = Method [43] [44] 
.const [17] = Method [45] [46] 
.const [18] = Method [47] [48] 
.const [19] = Field [49] [50] 
.const [20] = Field [51] [52] 
.const [21] = Class [53] 
.const [22] = Utf8 java/lang/StringBuffer 
.const [23] = Utf8 '[' 
.const [24] = Utf8 ',' 
.const [25] = Class [54] 
.const [26] = NameAndType [55] [56] 
.const [27] = Utf8 ']' 
.const [28] = Utf8 de/esolutions/fw/util/tracing/entity/TraceEntityURI 
.const [29] = Utf8 java/lang/Object 
.const [30] = Utf8 de/esolutions/fw/util/tracing/entity/TraceEntityType 
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
.const [45] = Class [78] 
.const [46] = NameAndType [79] [80] 
.const [47] = Class [81] 
.const [48] = NameAndType [82] [83] 
.const [49] = Class [84] 
.const [50] = NameAndType [85] [86] 
.const [51] = Class [87] 
.const [52] = NameAndType [88] [89] 
.const [53] = Utf8 java/lang/StringBuffer 
.const [54] = Utf8 de/esolutions/fw/util/tracing/entity/TraceEntityType 
.const [55] = Utf8 names 
.const [56] = Utf8 [Ljava/lang/String; 
.const [57] = Utf8 de/esolutions/fw/util/tracing/entity/TraceEntityURI 
.const [58] = Utf8 type 
.const [59] = Utf8 S 
.const [60] = Utf8 de/esolutions/fw/util/tracing/entity/TraceEntityURI 
.const [61] = Utf8 id 
.const [62] = Utf8 I 
.const [63] = Utf8 java/lang/StringBuffer 
.const [64] = Utf8 append 
.const [65] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [66] = Utf8 java/lang/StringBuffer 
.const [67] = Utf8 append 
.const [68] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [69] = Utf8 java/lang/StringBuffer 
.const [70] = Utf8 toString 
.const [71] = Utf8 ()Ljava/lang/String; 
.const [72] = Utf8 de/esolutions/fw/util/tracing/entity/TraceEntityURI 
.const [73] = Utf8 getId 
.const [74] = Utf8 ()I 
.const [75] = Utf8 de/esolutions/fw/util/tracing/entity/TraceEntityURI 
.const [76] = Utf8 getType 
.const [77] = Utf8 ()S 
.const [78] = Utf8 java/lang/Object 
.const [79] = Utf8 <init> 
.const [80] = Utf8 ()V 
.const [81] = Utf8 java/lang/StringBuffer 
.const [82] = Utf8 <init> 
.const [83] = Utf8 ()V 
.const [84] = Utf8 de/esolutions/fw/util/tracing/entity/TraceEntityURI 
.const [85] = Utf8 type 
.const [86] = Utf8 S 
.const [87] = Utf8 de/esolutions/fw/util/tracing/entity/TraceEntityURI 
.const [88] = Utf8 id 
.const [89] = Utf8 I 
.const [90] = Utf8 de/esolutions/fw/util/tracing/entity/TraceEntityURI 
.const [91] = Class [90] 
.const [92] = Utf8 java/lang/Object 
.const [93] = Class [92] 
.const [94] = Utf8 type 
.const [95] = Utf8 S 
.const [96] = Utf8 id 
.const [97] = Utf8 I 
.const [98] = Utf8 Code 
.const [99] = Utf8 <init> 
.const [100] = Utf8 (SI)V 
.const [101] = Utf8 getType 
.const [102] = Utf8 ()S 
.const [103] = Utf8 getId 
.const [104] = Utf8 ()I 
.const [105] = Utf8 toString 
.const [106] = Utf8 ()Ljava/lang/String; 
.const [107] = Utf8 equals 
.const [108] = Utf8 (Ljava/lang/Object;)Z 
.const [109] = Utf8 hashCode 
.const [110] = Utf8 ()I 
.end class 
