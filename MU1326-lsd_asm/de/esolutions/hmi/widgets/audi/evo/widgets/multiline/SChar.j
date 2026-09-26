.version 50 0 
.class public super [55] 
.super [57] 
.field public static final [58] [59] 
.field public static final [60] [61] 
.field public static final [62] [63] 
.field public static final [64] [65] 
.field public [66] [67] 
.field public [68] [69] 
.field public [70] [71] 
.field public [72] [73] 
.field public [74] [75] 
.field public [76] [77] 

.method public [79] : [80] 
    .attribute [78] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [5] 
L4:     aload_0 
L5:     iload_1 
L6:     putfield [6] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [7] 
L14:    aload_0 
L15:    iload_3 
L16:    putfield [8] 
L19:    aload_0 
L20:    iconst_0 
L21:    putfield [9] 
L24:    aload_0 
L25:    iconst_m1 
L26:    putfield [10] 
L29:    aload_0 
L30:    iconst_0 
L31:    putfield [11] 
L34:    return 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [81] : [82] 
    .attribute [78] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [4] 
L4:     iload_1 
L5:     iand 
L6:     iload_1 
L7:     if_icmpne L14 
L10:    iconst_1 
L11:    goto L15 
L14:    iconst_0 
L15:    areturn 
L16:    
    .end code 
.end method 

.method public [83] : [84] 
    .attribute [78] .code stack 3 locals 0 
L0:     aload_0 
L1:     dup 
L2:     getfield [4] 
L5:     iload_1 
L6:     ior 
L7:     putfield [11] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [12] 
.const [3] = Class [13] 
.const [4] = Field [14] [15] 
.const [5] = Method [16] [17] 
.const [6] = Field [18] [19] 
.const [7] = Field [20] [21] 
.const [8] = Field [22] [23] 
.const [9] = Field [24] [25] 
.const [10] = Field [26] [27] 
.const [11] = Field [28] [29] 
.const [12] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/SChar 
.const [13] = Utf8 java/lang/Object 
.const [14] = Class [30] 
.const [15] = NameAndType [31] [32] 
.const [16] = Class [33] 
.const [17] = NameAndType [34] [35] 
.const [18] = Class [36] 
.const [19] = NameAndType [37] [38] 
.const [20] = Class [39] 
.const [21] = NameAndType [40] [41] 
.const [22] = Class [42] 
.const [23] = NameAndType [43] [44] 
.const [24] = Class [45] 
.const [25] = NameAndType [46] [47] 
.const [26] = Class [48] 
.const [27] = NameAndType [49] [50] 
.const [28] = Class [51] 
.const [29] = NameAndType [52] [53] 
.const [30] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/SChar 
.const [31] = Utf8 type 
.const [32] = Utf8 I 
.const [33] = Utf8 java/lang/Object 
.const [34] = Utf8 <init> 
.const [35] = Utf8 ()V 
.const [36] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/SChar 
.const [37] = Utf8 w 
.const [38] = Utf8 S 
.const [39] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/SChar 
.const [40] = Utf8 word 
.const [41] = Utf8 [S 
.const [42] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/SChar 
.const [43] = Utf8 idx 
.const [44] = Utf8 S 
.const [45] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/SChar 
.const [46] = Utf8 x 
.const [47] = Utf8 S 
.const [48] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/SChar 
.const [49] = Utf8 line 
.const [50] = Utf8 S 
.const [51] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/SChar 
.const [52] = Utf8 type 
.const [53] = Utf8 I 
.const [54] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/SChar 
.const [55] = Class [54] 
.const [56] = Utf8 java/lang/Object 
.const [57] = Class [56] 
.const [58] = Utf8 TYPE_NORMAL 
.const [59] = Utf8 I 
.const [60] = Utf8 TYPE_PREFIX_NEW_LINE 
.const [61] = Utf8 I 
.const [62] = Utf8 TYPE_PREFIX_FIRST_LINE_CHAR 
.const [63] = Utf8 I 
.const [64] = Utf8 TYPE_SUFFIX_LAST_CHAR 
.const [65] = Utf8 I 
.const [66] = Utf8 word 
.const [67] = Utf8 [S 
.const [68] = Utf8 w 
.const [69] = Utf8 S 
.const [70] = Utf8 x 
.const [71] = Utf8 S 
.const [72] = Utf8 line 
.const [73] = Utf8 S 
.const [74] = Utf8 idx 
.const [75] = Utf8 S 
.const [76] = Utf8 type 
.const [77] = Utf8 I 
.const [78] = Utf8 Code 
.const [79] = Utf8 <init> 
.const [80] = Utf8 (S[SS)V 
.const [81] = Utf8 isOfType 
.const [82] = Utf8 (I)Z 
.const [83] = Utf8 appendType 
.const [84] = Utf8 (I)V 
.end class 
