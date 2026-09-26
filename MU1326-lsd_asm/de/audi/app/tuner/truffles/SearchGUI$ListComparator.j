.version 50 0 
.class super [51] 
.super [53] 
.implements [55] 
.field private static final [56] [57] 
.field private [58] [59] 

.method public [61] : [62] 
    .attribute [60] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [8] 
L4:     aload_0 
L5:     iload_1 
L6:     putfield [11] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [63] : [64] 
    .attribute [60] .code stack 2 locals 2 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [9] 
L5:     istore_3 
L6:     aload_0 
L7:     aload_2 
L8:     invokespecial [9] 
L11:    istore 4 
L13:    iload_3 
L14:    iload 4 
L16:    isub 
L17:    areturn 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method private [65] : [66] 
    .attribute [60] .code stack 2 locals 2 
L0:     aload_1 
L1:     checkcast [2] 
L4:     invokevirtual [7] 
L7:     istore_2 
L8:     iload_2 
L9:     aload_0 
L10:    getfield [6] 
L13:    if_icmpne L19 
L16:    bipush -10 
L18:    areturn 
L19:    iconst_0 
L20:    istore_3 
L21:    iload_3 
L22:    getstatic [3] 
L25:    arraylength 
L26:    if_icmpge L46 
L29:    getstatic [3] 
L32:    iload_3 
L33:    iaload 
L34:    iload_2 
L35:    if_icmpne L40 
L38:    iload_3 
L39:    areturn 
L40:    iinc 3 1 
L43:    goto L21 
L46:    iconst_m1 
L47:    areturn 
L48:    
    .end code 
.end method 

.method static [67] : [68] 
    .attribute [60] .code stack 4 locals 0 
L0:     bipush 7 
L2:     newarray int 
L4:     dup 
L5:     iconst_0 
L6:     bipush 12 
L8:     iastore 
L9:     dup 
L10:    iconst_1 
L11:    bipush 13 
L13:    iastore 
L14:    dup 
L15:    iconst_2 
L16:    bipush 11 
L18:    iastore 
L19:    dup 
L20:    iconst_3 
L21:    iconst_5 
L22:    iastore 
L23:    dup 
L24:    iconst_4 
L25:    bipush 7 
L27:    iastore 
L28:    dup 
L29:    iconst_5 
L30:    iconst_1 
L31:    iastore 
L32:    dup 
L33:    bipush 6 
L35:    iconst_4 
L36:    iastore 
L37:    putstatic [10] 
L40:    return 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [12] 
.const [3] = Field [13] [14] 
.const [4] = Class [15] 
.const [5] = Class [16] 
.const [6] = Field [17] [18] 
.const [7] = Method [19] [20] 
.const [8] = Method [21] [22] 
.const [9] = Method [23] [24] 
.const [10] = Field [25] [26] 
.const [11] = Field [27] [28] 
.const [12] = Utf8 java/lang/Integer 
.const [13] = Class [29] 
.const [14] = NameAndType [30] [31] 
.const [15] = Utf8 de/audi/app/tuner/truffles/SearchGUI$ListComparator 
.const [16] = Utf8 java/lang/Object 
.const [17] = Class [32] 
.const [18] = NameAndType [33] [34] 
.const [19] = Class [35] 
.const [20] = NameAndType [36] [37] 
.const [21] = Class [38] 
.const [22] = NameAndType [39] [40] 
.const [23] = Class [41] 
.const [24] = NameAndType [42] [43] 
.const [25] = Class [44] 
.const [26] = NameAndType [45] [46] 
.const [27] = Class [47] 
.const [28] = NameAndType [48] [49] 
.const [29] = Utf8 de/audi/app/tuner/truffles/SearchGUI$ListComparator 
.const [30] = Utf8 order 
.const [31] = Utf8 [I 
.const [32] = Utf8 de/audi/app/tuner/truffles/SearchGUI$ListComparator 
.const [33] = Utf8 activeList 
.const [34] = Utf8 I 
.const [35] = Utf8 java/lang/Integer 
.const [36] = Utf8 intValue 
.const [37] = Utf8 ()I 
.const [38] = Utf8 java/lang/Object 
.const [39] = Utf8 <init> 
.const [40] = Utf8 ()V 
.const [41] = Utf8 de/audi/app/tuner/truffles/SearchGUI$ListComparator 
.const [42] = Utf8 getIndex 
.const [43] = Utf8 (Ljava/lang/Object;)I 
.const [44] = Utf8 de/audi/app/tuner/truffles/SearchGUI$ListComparator 
.const [45] = Utf8 order 
.const [46] = Utf8 [I 
.const [47] = Utf8 de/audi/app/tuner/truffles/SearchGUI$ListComparator 
.const [48] = Utf8 activeList 
.const [49] = Utf8 I 
.const [50] = Utf8 de/audi/app/tuner/truffles/SearchGUI$ListComparator 
.const [51] = Class [50] 
.const [52] = Utf8 java/lang/Object 
.const [53] = Class [52] 
.const [54] = Utf8 java/util/Comparator 
.const [55] = Class [54] 
.const [56] = Utf8 order 
.const [57] = Utf8 [I 
.const [58] = Utf8 activeList 
.const [59] = Utf8 I 
.const [60] = Utf8 Code 
.const [61] = Utf8 <init> 
.const [62] = Utf8 (I)V 
.const [63] = Utf8 compare 
.const [64] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)I 
.const [65] = Utf8 getIndex 
.const [66] = Utf8 (Ljava/lang/Object;)I 
.const [67] = Utf8 <clinit> 
.const [68] = Utf8 ()V 
.end class 
