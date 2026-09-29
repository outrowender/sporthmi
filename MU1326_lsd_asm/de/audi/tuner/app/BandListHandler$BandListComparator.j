.version 50 0 
.class super [45] 
.super [47] 
.implements [49] 
.implements [51] 
.field private static final [52] [53] 
.field private static final [54] [55] 

.method private annotation [57] : [58] 
    .attribute [56] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [8] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [59] : [60] 
    .attribute [56] .code stack 2 locals 2 
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

.method private [61] : [62] 
    .attribute [56] .code stack 2 locals 1 
L0:     iconst_0 
L1:     istore_2 
L2:     iload_2 
L3:     getstatic [2] 
L6:     arraylength 
L7:     if_icmpge L33 
L10:    getstatic [2] 
L13:    iload_2 
L14:    iaload 
L15:    aload_1 
L16:    checkcast [3] 
L19:    invokevirtual [6] 
L22:    if_icmpne L27 
L25:    iload_2 
L26:    areturn 
L27:    iinc 2 1 
L30:    goto L2 
L33:    iconst_m1 
L34:    areturn 
L35:    nop 
L36:    
    .end code 
.end method 

.method synthetic [63] : [64] 
    .attribute [56] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [7] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static [65] : [66] 
    .attribute [56] .code stack 4 locals 0 
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
L25:    iconst_1 
L26:    iastore 
L27:    dup 
L28:    iconst_5 
L29:    iconst_4 
L30:    iastore 
L31:    dup 
L32:    bipush 6 
L34:    bipush 7 
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
.const [2] = Field [11] [12] 
.const [3] = Class [13] 
.const [4] = Class [14] 
.const [5] = Class [15] 
.const [6] = Method [16] [17] 
.const [7] = Method [18] [19] 
.const [8] = Method [20] [21] 
.const [9] = Method [22] [23] 
.const [10] = Field [24] [25] 
.const [11] = Class [26] 
.const [12] = NameAndType [27] [28] 
.const [13] = Utf8 java/lang/Integer 
.const [14] = Utf8 de/audi/tuner/app/BandListHandler$BandListComparator 
.const [15] = Utf8 java/lang/Object 
.const [16] = Class [29] 
.const [17] = NameAndType [30] [31] 
.const [18] = Class [32] 
.const [19] = NameAndType [33] [34] 
.const [20] = Class [35] 
.const [21] = NameAndType [36] [37] 
.const [22] = Class [38] 
.const [23] = NameAndType [39] [40] 
.const [24] = Class [41] 
.const [25] = NameAndType [42] [43] 
.const [26] = Utf8 de/audi/tuner/app/BandListHandler$BandListComparator 
.const [27] = Utf8 order 
.const [28] = Utf8 [I 
.const [29] = Utf8 java/lang/Integer 
.const [30] = Utf8 intValue 
.const [31] = Utf8 ()I 
.const [32] = Utf8 de/audi/tuner/app/BandListHandler$BandListComparator 
.const [33] = Utf8 <init> 
.const [34] = Utf8 ()V 
.const [35] = Utf8 java/lang/Object 
.const [36] = Utf8 <init> 
.const [37] = Utf8 ()V 
.const [38] = Utf8 de/audi/tuner/app/BandListHandler$BandListComparator 
.const [39] = Utf8 getIndex 
.const [40] = Utf8 (Ljava/lang/Object;)I 
.const [41] = Utf8 de/audi/tuner/app/BandListHandler$BandListComparator 
.const [42] = Utf8 order 
.const [43] = Utf8 [I 
.const [44] = Utf8 de/audi/tuner/app/BandListHandler$BandListComparator 
.const [45] = Class [44] 
.const [46] = Utf8 java/lang/Object 
.const [47] = Class [46] 
.const [48] = Utf8 java/util/Comparator 
.const [49] = Class [48] 
.const [50] = Utf8 java/io/Serializable 
.const [51] = Class [50] 
.const [52] = Utf8 serialVersionUID 
.const [53] = Utf8 J 
.const [54] = Utf8 order 
.const [55] = Utf8 [I 
.const [56] = Utf8 Code 
.const [57] = Utf8 <init> 
.const [58] = Utf8 ()V 
.const [59] = Utf8 compare 
.const [60] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)I 
.const [61] = Utf8 getIndex 
.const [62] = Utf8 (Ljava/lang/Object;)I 
.const [63] = Utf8 <init> 
.const [64] = Utf8 (Lde/audi/tuner/app/BandListHandler$1;)V 
.const [65] = Utf8 <clinit> 
.const [66] = Utf8 ()V 
.end class 
