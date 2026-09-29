.version 50 0 
.class public super [35] 
.super [37] 
.field public static final [38] [39] 
.field public static final [40] [41] 
.field private static final [42] [43] 

.method public annotation [45] : [46] 
    .attribute [44] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [6] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [47] : [48] 
    .attribute [44] .code stack 3 locals 0 
L0:     iload_0 
L1:     bipush -7 
L3:     if_icmplt L12 
L6:     iload_0 
L7:     bipush 127 
L9:     if_icmple L21 
L12:    new [9] 
L15:    dup 
L16:    iload_0 
L17:    invokespecial [7] 
L20:    areturn 
L21:    getstatic [3] 
L24:    iload_0 
L25:    bipush -7 
L27:    isub 
L28:    aaload 
L29:    areturn 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method static [49] : [50] 
    .attribute [44] .code stack 5 locals 1 
L0:     sipush 135 
L3:     anewarray [2] 
L6:     putstatic [8] 
L9:     bipush -7 
L11:    istore_0 
L12:    iload_0 
L13:    bipush 127 
L15:    if_icmpgt L40 
L18:    getstatic [3] 
L21:    iload_0 
L22:    bipush -7 
L24:    isub 
L25:    new [9] 
L28:    dup 
L29:    iload_0 
L30:    invokespecial [7] 
L33:    aastore 
L34:    iinc 0 1 
L37:    goto L12 
L40:    return 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [10] 
.const [3] = Field [11] [12] 
.const [4] = Class [13] 
.const [5] = Class [14] 
.const [6] = Method [15] [16] 
.const [7] = Method [17] [18] 
.const [8] = Field [19] [20] 
.const [9] = Class [21] 
.const [10] = Utf8 java/lang/Integer 
.const [11] = Class [22] 
.const [12] = NameAndType [23] [24] 
.const [13] = Utf8 de/audi/app/media/content/media/utils/Integers 
.const [14] = Utf8 java/lang/Object 
.const [15] = Class [25] 
.const [16] = NameAndType [26] [27] 
.const [17] = Class [28] 
.const [18] = NameAndType [29] [30] 
.const [19] = Class [31] 
.const [20] = NameAndType [32] [33] 
.const [21] = Utf8 java/lang/Integer 
.const [22] = Utf8 de/audi/app/media/content/media/utils/Integers 
.const [23] = Utf8 cache 
.const [24] = Utf8 [Ljava/lang/Integer; 
.const [25] = Utf8 java/lang/Object 
.const [26] = Utf8 <init> 
.const [27] = Utf8 ()V 
.const [28] = Utf8 java/lang/Integer 
.const [29] = Utf8 <init> 
.const [30] = Utf8 (I)V 
.const [31] = Utf8 de/audi/app/media/content/media/utils/Integers 
.const [32] = Utf8 cache 
.const [33] = Utf8 [Ljava/lang/Integer; 
.const [34] = Utf8 de/audi/app/media/content/media/utils/Integers 
.const [35] = Class [34] 
.const [36] = Utf8 java/lang/Object 
.const [37] = Class [36] 
.const [38] = Utf8 MAX_CACHE_VALUE 
.const [39] = Utf8 I 
.const [40] = Utf8 MIN_CACHE_VALUE 
.const [41] = Utf8 I 
.const [42] = Utf8 cache 
.const [43] = Utf8 [Ljava/lang/Integer; 
.const [44] = Utf8 Code 
.const [45] = Utf8 <init> 
.const [46] = Utf8 ()V 
.const [47] = Utf8 valueOf 
.const [48] = Utf8 (I)Ljava/lang/Integer; 
.const [49] = Utf8 <clinit> 
.const [50] = Utf8 ()V 
.end class 
