.version 50 0 
.class super [55] 
.super [57] 
.field [58] [59] 
.field [60] [61] 
.field final [62] [63] 
.field private final synthetic [64] [65] 

.method public [67] : [68] 
    .attribute [66] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [8] 
L5:     aload_0 
L6:     invokespecial [7] 
L9:     aload_0 
L10:    iload_2 
L11:    putfield [9] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [69] : [70] 
    .attribute [66] .code stack 3 locals 0 
L0:     aload_0 
L1:     dup 
L2:     getfield [5] 
L5:     iconst_1 
L6:     iadd 
L7:     putfield [10] 
L10:    aload_0 
L11:    getfield [4] 
L14:    iconst_3 
L15:    iand 
L16:    ifeq L32 
L19:    aload_0 
L20:    dup 
L21:    getfield [6] 
L24:    iload_1 
L25:    iadd 
L26:    putfield [11] 
L29:    goto L63 
L32:    aload_0 
L33:    getfield [4] 
L36:    bipush 8 
L38:    iand 
L39:    ifeq L58 
L42:    iload_1 
L43:    aload_0 
L44:    getfield [6] 
L47:    if_icmple L63 
L50:    aload_0 
L51:    iload_1 
L52:    putfield [11] 
L55:    goto L63 
L58:    aload_0 
L59:    iload_1 
L60:    putfield [11] 
L63:    return 
L64:    
    .end code 
.end method 

.method public [71] : [72] 
    .attribute [66] .code stack 2 locals 1 
L0:     iconst_0 
L1:     istore_1 
L2:     aload_0 
L3:     getfield [4] 
L6:     iconst_1 
L7:     iand 
L8:     ifeq L31 
L11:    aload_0 
L12:    getfield [5] 
L15:    ifle L36 
L18:    aload_0 
L19:    getfield [6] 
L22:    aload_0 
L23:    getfield [5] 
L26:    idiv 
L27:    istore_1 
L28:    goto L36 
L31:    aload_0 
L32:    getfield [6] 
L35:    istore_1 
L36:    aload_0 
L37:    getfield [4] 
L40:    iconst_4 
L41:    iand 
L42:    ifeq L55 
L45:    aload_0 
L46:    iconst_0 
L47:    putfield [10] 
L50:    aload_0 
L51:    iconst_0 
L52:    putfield [11] 
L55:    iload_1 
L56:    areturn 
L57:    nop 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [12] 
.const [3] = Class [13] 
.const [4] = Field [14] [15] 
.const [5] = Field [16] [17] 
.const [6] = Field [18] [19] 
.const [7] = Method [20] [21] 
.const [8] = Field [22] [23] 
.const [9] = Field [24] [25] 
.const [10] = Field [26] [27] 
.const [11] = Field [28] [29] 
.const [12] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreStats$Stats 
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
.const [30] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreStats$Stats 
.const [31] = Utf8 flags 
.const [32] = Utf8 I 
.const [33] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreStats$Stats 
.const [34] = Utf8 count 
.const [35] = Utf8 I 
.const [36] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreStats$Stats 
.const [37] = Utf8 value 
.const [38] = Utf8 I 
.const [39] = Utf8 java/lang/Object 
.const [40] = Utf8 <init> 
.const [41] = Utf8 ()V 
.const [42] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreStats$Stats 
.const [43] = Utf8 this$0 
.const [44] = Utf8 Lde/esolutions/fw/util/tracing/core/TraceCoreStats; 
.const [45] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreStats$Stats 
.const [46] = Utf8 flags 
.const [47] = Utf8 I 
.const [48] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreStats$Stats 
.const [49] = Utf8 count 
.const [50] = Utf8 I 
.const [51] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreStats$Stats 
.const [52] = Utf8 value 
.const [53] = Utf8 I 
.const [54] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreStats$Stats 
.const [55] = Class [54] 
.const [56] = Utf8 java/lang/Object 
.const [57] = Class [56] 
.const [58] = Utf8 count 
.const [59] = Utf8 I 
.const [60] = Utf8 value 
.const [61] = Utf8 I 
.const [62] = Utf8 flags 
.const [63] = Utf8 I 
.const [64] = Utf8 this$0 
.const [65] = Utf8 Lde/esolutions/fw/util/tracing/core/TraceCoreStats; 
.const [66] = Utf8 Code 
.const [67] = Utf8 <init> 
.const [68] = Utf8 (Lde/esolutions/fw/util/tracing/core/TraceCoreStats;I)V 
.const [69] = Utf8 update 
.const [70] = Utf8 (I)V 
.const [71] = Utf8 read 
.const [72] = Utf8 ()I 
.end class 
