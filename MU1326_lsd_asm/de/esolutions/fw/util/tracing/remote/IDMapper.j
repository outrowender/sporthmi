.version 50 0 
.class public super [103] 
.super [105] 
.field private [106] [107] 
.field private [108] [109] 
.field private [110] [111] 
.field private [112] [113] 

.method public [115] : [116] 
    .attribute [114] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [14] 
L4:     aload_0 
L5:     iload_1 
L6:     newarray int 
L8:     putfield [17] 
L11:    aload_0 
L12:    iload_1 
L13:    newarray short 
L15:    putfield [18] 
L18:    aload_0 
L19:    iload_1 
L20:    putfield [19] 
L23:    aload_0 
L24:    iconst_m1 
L25:    putfield [20] 
L28:    return 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method private [117] : [118] 
    .attribute [114] .code stack 5 locals 3 
L0:     aload_0 
L1:     getfield [7] 
L4:     astore_2 
L5:     aload_0 
L6:     getfield [8] 
L9:     astore_3 
L10:    aload_0 
L11:    getfield [9] 
L14:    istore 4 
L16:    aload_0 
L17:    iload_1 
L18:    putfield [19] 
L21:    aload_0 
L22:    aload_0 
L23:    getfield [9] 
L26:    newarray int 
L28:    putfield [17] 
L31:    aload_0 
L32:    aload_0 
L33:    getfield [9] 
L36:    newarray short 
L38:    putfield [18] 
L41:    aload_2 
L42:    iconst_0 
L43:    aload_0 
L44:    getfield [7] 
L47:    iconst_0 
L48:    iload 4 
L50:    invokestatic [2] 
L53:    aload_3 
L54:    iconst_0 
L55:    aload_0 
L56:    getfield [8] 
L59:    iconst_0 
L60:    iload 4 
L62:    invokestatic [2] 
L65:    return 
L66:    nop 
L67:    nop 
L68:    
    .end code 
.end method 

.method public [119] : [120] 
    .attribute [114] .code stack 3 locals 0 
L0:     iload_2 
L1:     aload_0 
L2:     getfield [9] 
L5:     if_icmplt L17 
L8:     aload_0 
L9:     iload_2 
L10:    sipush 256 
L13:    iadd 
L14:    invokespecial [15] 
L17:    aload_0 
L18:    getfield [8] 
L21:    iload_2 
L22:    iload_1 
L23:    sastore 
L24:    aload_0 
L25:    getfield [7] 
L28:    iload_2 
L29:    iload_3 
L30:    iastore 
L31:    iload_2 
L32:    aload_0 
L33:    getfield [10] 
L36:    if_icmple L44 
L39:    aload_0 
L40:    iload_2 
L41:    putfield [20] 
L44:    return 
L45:    nop 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method public interface [121] : [122] 
    .attribute [114] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [123] : [124] 
    .attribute [114] .code stack 2 locals 0 
L0:     iload_1 
L1:     aload_0 
L2:     getfield [9] 
L5:     if_icmplt L10 
L8:     iconst_0 
L9:     areturn 
L10:    aload_0 
L11:    getfield [8] 
L14:    iload_1 
L15:    saload 
L16:    areturn 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [125] : [126] 
    .attribute [114] .code stack 2 locals 0 
L0:     iload_1 
L1:     aload_0 
L2:     getfield [9] 
L5:     if_icmplt L10 
L8:     iconst_m1 
L9:     areturn 
L10:    aload_0 
L11:    getfield [7] 
L14:    iload_1 
L15:    iaload 
L16:    areturn 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [127] : [128] 
    .attribute [114] .code stack 5 locals 0 
L0:     iload_1 
L1:     aload_0 
L2:     getfield [9] 
L5:     if_icmplt L10 
L8:     aconst_null 
L9:     areturn 
L10:    new [21] 
L13:    dup 
L14:    aload_0 
L15:    getfield [8] 
L18:    iload_1 
L19:    saload 
L20:    aload_0 
L21:    getfield [7] 
L24:    iload_1 
L25:    iaload 
L26:    invokespecial [16] 
L29:    areturn 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [129] : [130] 
    .attribute [114] .code stack 4 locals 1 
L0:     aload_0 
L1:     aload_1 
L2:     invokevirtual [11] 
L5:     invokevirtual [12] 
L8:     istore_2 
L9:     iload_2 
L10:    iconst_m1 
L11:    if_icmpeq L27 
L14:    new [21] 
L17:    dup 
L18:    aload_1 
L19:    invokevirtual [13] 
L22:    iload_2 
L23:    invokespecial [16] 
L26:    areturn 
L27:    aconst_null 
L28:    areturn 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [22] [23] 
.const [3] = Class [24] 
.const [4] = Class [25] 
.const [5] = Class [26] 
.const [6] = Class [27] 
.const [7] = Field [28] [29] 
.const [8] = Field [30] [31] 
.const [9] = Field [32] [33] 
.const [10] = Field [34] [35] 
.const [11] = Method [36] [37] 
.const [12] = Method [38] [39] 
.const [13] = Method [40] [41] 
.const [14] = Method [42] [43] 
.const [15] = Method [44] [45] 
.const [16] = Method [46] [47] 
.const [17] = Field [48] [49] 
.const [18] = Field [50] [51] 
.const [19] = Field [52] [53] 
.const [20] = Field [54] [55] 
.const [21] = Class [56] 
.const [22] = Class [57] 
.const [23] = NameAndType [58] [59] 
.const [24] = Utf8 de/esolutions/fw/util/tracing/entity/TraceEntityURI 
.const [25] = Utf8 de/esolutions/fw/util/tracing/remote/IDMapper 
.const [26] = Utf8 java/lang/Object 
.const [27] = Utf8 java/lang/System 
.const [28] = Class [60] 
.const [29] = NameAndType [61] [62] 
.const [30] = Class [63] 
.const [31] = NameAndType [64] [65] 
.const [32] = Class [66] 
.const [33] = NameAndType [67] [68] 
.const [34] = Class [69] 
.const [35] = NameAndType [70] [71] 
.const [36] = Class [72] 
.const [37] = NameAndType [73] [74] 
.const [38] = Class [75] 
.const [39] = NameAndType [76] [77] 
.const [40] = Class [78] 
.const [41] = NameAndType [79] [80] 
.const [42] = Class [81] 
.const [43] = NameAndType [82] [83] 
.const [44] = Class [84] 
.const [45] = NameAndType [85] [86] 
.const [46] = Class [87] 
.const [47] = NameAndType [88] [89] 
.const [48] = Class [90] 
.const [49] = NameAndType [91] [92] 
.const [50] = Class [93] 
.const [51] = NameAndType [94] [95] 
.const [52] = Class [96] 
.const [53] = NameAndType [97] [98] 
.const [54] = Class [99] 
.const [55] = NameAndType [100] [101] 
.const [56] = Utf8 de/esolutions/fw/util/tracing/entity/TraceEntityURI 
.const [57] = Utf8 java/lang/System 
.const [58] = Utf8 arraycopy 
.const [59] = Utf8 (Ljava/lang/Object;ILjava/lang/Object;II)V 
.const [60] = Utf8 de/esolutions/fw/util/tracing/remote/IDMapper 
.const [61] = Utf8 map 
.const [62] = Utf8 [I 
.const [63] = Utf8 de/esolutions/fw/util/tracing/remote/IDMapper 
.const [64] = Utf8 typeMap 
.const [65] = Utf8 [S 
.const [66] = Utf8 de/esolutions/fw/util/tracing/remote/IDMapper 
.const [67] = Utf8 size 
.const [68] = Utf8 I 
.const [69] = Utf8 de/esolutions/fw/util/tracing/remote/IDMapper 
.const [70] = Utf8 max 
.const [71] = Utf8 I 
.const [72] = Utf8 de/esolutions/fw/util/tracing/entity/TraceEntityURI 
.const [73] = Utf8 getId 
.const [74] = Utf8 ()I 
.const [75] = Utf8 de/esolutions/fw/util/tracing/remote/IDMapper 
.const [76] = Utf8 getInternalID 
.const [77] = Utf8 (I)I 
.const [78] = Utf8 de/esolutions/fw/util/tracing/entity/TraceEntityURI 
.const [79] = Utf8 getType 
.const [80] = Utf8 ()S 
.const [81] = Utf8 java/lang/Object 
.const [82] = Utf8 <init> 
.const [83] = Utf8 ()V 
.const [84] = Utf8 de/esolutions/fw/util/tracing/remote/IDMapper 
.const [85] = Utf8 grow 
.const [86] = Utf8 (I)V 
.const [87] = Utf8 de/esolutions/fw/util/tracing/entity/TraceEntityURI 
.const [88] = Utf8 <init> 
.const [89] = Utf8 (SI)V 
.const [90] = Utf8 de/esolutions/fw/util/tracing/remote/IDMapper 
.const [91] = Utf8 map 
.const [92] = Utf8 [I 
.const [93] = Utf8 de/esolutions/fw/util/tracing/remote/IDMapper 
.const [94] = Utf8 typeMap 
.const [95] = Utf8 [S 
.const [96] = Utf8 de/esolutions/fw/util/tracing/remote/IDMapper 
.const [97] = Utf8 size 
.const [98] = Utf8 I 
.const [99] = Utf8 de/esolutions/fw/util/tracing/remote/IDMapper 
.const [100] = Utf8 max 
.const [101] = Utf8 I 
.const [102] = Utf8 de/esolutions/fw/util/tracing/remote/IDMapper 
.const [103] = Class [102] 
.const [104] = Utf8 java/lang/Object 
.const [105] = Class [104] 
.const [106] = Utf8 map 
.const [107] = Utf8 [I 
.const [108] = Utf8 typeMap 
.const [109] = Utf8 [S 
.const [110] = Utf8 size 
.const [111] = Utf8 I 
.const [112] = Utf8 max 
.const [113] = Utf8 I 
.const [114] = Utf8 Code 
.const [115] = Utf8 <init> 
.const [116] = Utf8 (I)V 
.const [117] = Utf8 grow 
.const [118] = Utf8 (I)V 
.const [119] = Utf8 setMapping 
.const [120] = Utf8 (SII)V 
.const [121] = Utf8 getMaxExtern 
.const [122] = Utf8 ()I 
.const [123] = Utf8 getType 
.const [124] = Utf8 (I)S 
.const [125] = Utf8 getInternalID 
.const [126] = Utf8 (I)I 
.const [127] = Utf8 getInternalURI 
.const [128] = Utf8 (I)Lde/esolutions/fw/util/tracing/entity/TraceEntityURI; 
.const [129] = Utf8 getInternalURI 
.const [130] = Utf8 (Lde/esolutions/fw/util/tracing/entity/TraceEntityURI;)Lde/esolutions/fw/util/tracing/entity/TraceEntityURI; 
.end class 
