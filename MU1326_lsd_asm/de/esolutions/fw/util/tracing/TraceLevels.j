.version 50 0 
.class public super [45] 
.super [47] 
.field public static final [48] [49] 
.field public static final [50] [51] 
.field public static final [52] [53] 
.field public static final [54] [55] 
.field public static final [56] [57] 
.field public static final [58] [59] 
.field public static final [60] [61] 
.field public static final [62] [63] 
.field public static final [64] [65] 
.field public static final [66] [67] 
.field public static final [68] [69] 
.field public static final [70] [71] 

.method public annotation [73] : [74] 
    .attribute [72] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [15] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [75] : [76] 
    .attribute [72] .code stack 2 locals 0 
L0:     iload_0 
L1:     iflt L13 
L4:     iload_0 
L5:     iconst_5 
L6:     if_icmpgt L13 
L9:     iconst_1 
L10:    goto L14 
L13:    iconst_0 
L14:    areturn 
L15:    nop 
L16:    
    .end code 
.end method 

.method public static [77] : [78] 
    .attribute [72] .code stack 2 locals 0 
L0:     iload_0 
L1:     iflt L14 
L4:     iload_0 
L5:     bipush 7 
L7:     if_icmpgt L14 
L10:    iconst_1 
L11:    goto L15 
L14:    iconst_0 
L15:    areturn 
L16:    
    .end code 
.end method 

.method public static [79] : [80] 
    .attribute [72] .code stack 2 locals 0 
L0:     iload_0 
L1:     iflt L16 
L4:     iload_0 
L5:     bipush 8 
L7:     if_icmpgt L16 
L10:    getstatic [2] 
L13:    iload_0 
L14:    aaload 
L15:    areturn 
L16:    aconst_null 
L17:    areturn 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method static [81] : [82] 
    .attribute [72] .code stack 4 locals 0 
L0:     bipush 9 
L2:     anewarray [3] 
L5:     dup 
L6:     iconst_0 
L7:     ldc [4] 
L9:     aastore 
L10:    dup 
L11:    iconst_1 
L12:    ldc [5] 
L14:    aastore 
L15:    dup 
L16:    iconst_2 
L17:    ldc [6] 
L19:    aastore 
L20:    dup 
L21:    iconst_3 
L22:    ldc [7] 
L24:    aastore 
L25:    dup 
L26:    iconst_4 
L27:    ldc [8] 
L29:    aastore 
L30:    dup 
L31:    iconst_5 
L32:    ldc [9] 
L34:    aastore 
L35:    dup 
L36:    bipush 6 
L38:    ldc [10] 
L40:    aastore 
L41:    dup 
L42:    bipush 7 
L44:    ldc [11] 
L46:    aastore 
L47:    dup 
L48:    bipush 8 
L50:    ldc [12] 
L52:    aastore 
L53:    putstatic [16] 
L56:    return 
L57:    nop 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [17] [18] 
.const [3] = Class [19] 
.const [4] = String [20] 
.const [5] = String [21] 
.const [6] = String [22] 
.const [7] = String [23] 
.const [8] = String [24] 
.const [9] = String [25] 
.const [10] = String [26] 
.const [11] = String [27] 
.const [12] = String [28] 
.const [13] = Class [29] 
.const [14] = Class [30] 
.const [15] = Method [31] [32] 
.const [16] = Field [33] [34] 
.const [17] = Class [35] 
.const [18] = NameAndType [36] [37] 
.const [19] = Utf8 java/lang/String 
.const [20] = Utf8 trace 
.const [21] = Utf8 debug 
.const [22] = Utf8 info 
.const [23] = Utf8 warn 
.const [24] = Utf8 ERROR 
.const [25] = Utf8 FATAL 
.const [26] = Utf8 OFF 
.const [27] = Utf8 NONE 
.const [28] = Utf8 Disabled 
.const [29] = Utf8 de/esolutions/fw/util/tracing/TraceLevels 
.const [30] = Utf8 java/lang/Object 
.const [31] = Class [38] 
.const [32] = NameAndType [39] [40] 
.const [33] = Class [41] 
.const [34] = NameAndType [42] [43] 
.const [35] = Utf8 de/esolutions/fw/util/tracing/TraceLevels 
.const [36] = Utf8 levelNames 
.const [37] = Utf8 [Ljava/lang/String; 
.const [38] = Utf8 java/lang/Object 
.const [39] = Utf8 <init> 
.const [40] = Utf8 ()V 
.const [41] = Utf8 de/esolutions/fw/util/tracing/TraceLevels 
.const [42] = Utf8 levelNames 
.const [43] = Utf8 [Ljava/lang/String; 
.const [44] = Utf8 de/esolutions/fw/util/tracing/TraceLevels 
.const [45] = Class [44] 
.const [46] = Utf8 java/lang/Object 
.const [47] = Class [46] 
.const [48] = Utf8 TRACE 
.const [49] = Utf8 S 
.const [50] = Utf8 DEBUG 
.const [51] = Utf8 S 
.const [52] = Utf8 INFO 
.const [53] = Utf8 S 
.const [54] = Utf8 WARN 
.const [55] = Utf8 S 
.const [56] = Utf8 ERROR 
.const [57] = Utf8 S 
.const [58] = Utf8 FATAL 
.const [59] = Utf8 S 
.const [60] = Utf8 OFF 
.const [61] = Utf8 S 
.const [62] = Utf8 NONE 
.const [63] = Utf8 S 
.const [64] = Utf8 DISABLED 
.const [65] = Utf8 S 
.const [66] = Utf8 _LAST 
.const [67] = Utf8 S 
.const [68] = Utf8 NUM_VISIBLE_MESSAGES 
.const [69] = Utf8 S 
.const [70] = Utf8 levelNames 
.const [71] = Utf8 [Ljava/lang/String; 
.const [72] = Utf8 Code 
.const [73] = Utf8 <init> 
.const [74] = Utf8 ()V 
.const [75] = Utf8 isValidLogLevel 
.const [76] = Utf8 (S)Z 
.const [77] = Utf8 isValidFilterLevel 
.const [78] = Utf8 (S)Z 
.const [79] = Utf8 getName 
.const [80] = Utf8 (S)Ljava/lang/String; 
.const [81] = Utf8 <clinit> 
.const [82] = Utf8 ()V 
.end class 
