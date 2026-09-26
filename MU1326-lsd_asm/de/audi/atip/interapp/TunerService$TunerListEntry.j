.version 50 0 
.class public super [77] 
.super [79] 
.field public final [80] [81] 

.method public [83] : [84] 
    .attribute [82] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [17] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [19] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [85] : [86] 
    .attribute [82] .code stack 4 locals 3 
L0:     aload_0 
L1:     getfield [11] 
L4:     ifnonnull L10 
L7:     ldc [2] 
L9:     areturn 
L10:    aload_0 
L11:    getfield [11] 
L14:    arraylength 
L15:    istore_1 
L16:    new [20] 
L19:    dup 
L20:    ldc [4] 
L22:    invokespecial [18] 
L25:    astore_2 
L26:    iconst_0 
L27:    istore_3 
L28:    iload_3 
L29:    iload_1 
L30:    iconst_1 
L31:    isub 
L32:    if_icmpge L57 
L35:    aload_2 
L36:    aload_0 
L37:    getfield [11] 
L40:    iload_3 
L41:    aaload 
L42:    invokevirtual [12] 
L45:    ldc [5] 
L47:    invokevirtual [13] 
L50:    pop 
L51:    iinc 3 1 
L54:    goto L28 
L57:    aload_2 
L58:    aload_0 
L59:    getfield [11] 
L62:    iload_1 
L63:    iconst_1 
L64:    isub 
L65:    aaload 
L66:    invokevirtual [12] 
L69:    ldc [6] 
L71:    invokevirtual [13] 
L74:    pop 
L75:    aload_2 
L76:    invokevirtual [14] 
L79:    areturn 
L80:    
    .end code 
.end method 

.method public [87] : [88] 
    .attribute [82] .code stack 4 locals 3 
L0:     aload_0 
L1:     getfield [11] 
L4:     arraylength 
L5:     istore_1 
L6:     iload_1 
L7:     newarray long 
L9:     astore_2 
L10:    iconst_0 
L11:    istore_3 
L12:    iload_3 
L13:    iload_1 
L14:    if_icmpge L35 
L17:    aload_2 
L18:    iload_3 
L19:    aload_0 
L20:    getfield [11] 
L23:    iload_3 
L24:    aaload 
L25:    invokevirtual [15] 
L28:    lastore 
L29:    iinc 3 1 
L32:    goto L12 
L35:    aload_2 
L36:    areturn 
L37:    nop 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [89] : [90] 
    .attribute [82] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [11] 
L4:     arraylength 
L5:     istore_2 
L6:     iload_1 
L7:     iload_2 
L8:     if_icmplt L14 
L11:    ldc [7] 
L13:    areturn 
L14:    aload_0 
L15:    getfield [11] 
L18:    iload_1 
L19:    aaload 
L20:    invokevirtual [16] 
L23:    areturn 
L24:    
    .end code 
.end method 

.method public [91] : [92] 
    .attribute [82] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     iconst_0 
L5:     aaload 
L6:     invokevirtual [16] 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [21] 
.const [3] = Class [22] 
.const [4] = String [23] 
.const [5] = String [24] 
.const [6] = String [25] 
.const [7] = String [26] 
.const [8] = Class [27] 
.const [9] = Class [28] 
.const [10] = Class [29] 
.const [11] = Field [30] [31] 
.const [12] = Method [32] [33] 
.const [13] = Method [34] [35] 
.const [14] = Method [36] [37] 
.const [15] = Method [38] [39] 
.const [16] = Method [40] [41] 
.const [17] = Method [42] [43] 
.const [18] = Method [44] [45] 
.const [19] = Field [46] [47] 
.const [20] = Class [48] 
.const [21] = Utf8 'entryVariants=[ ]' 
.const [22] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [23] = Utf8 'entryVariants=[ ' 
.const [24] = Utf8 ', ' 
.const [25] = Utf8 ' ]' 
.const [26] = Utf8 '' 
.const [27] = Utf8 de/audi/atip/interapp/TunerService$TunerListEntry 
.const [28] = Utf8 java/lang/Object 
.const [29] = Utf8 de/audi/atip/interapp/SDSListEntry 
.const [30] = Class [49] 
.const [31] = NameAndType [50] [51] 
.const [32] = Class [52] 
.const [33] = NameAndType [53] [54] 
.const [34] = Class [55] 
.const [35] = NameAndType [56] [57] 
.const [36] = Class [58] 
.const [37] = NameAndType [59] [60] 
.const [38] = Class [61] 
.const [39] = NameAndType [62] [63] 
.const [40] = Class [64] 
.const [41] = NameAndType [65] [66] 
.const [42] = Class [67] 
.const [43] = NameAndType [68] [69] 
.const [44] = Class [70] 
.const [45] = NameAndType [71] [72] 
.const [46] = Class [73] 
.const [47] = NameAndType [74] [75] 
.const [48] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [49] = Utf8 de/audi/atip/interapp/TunerService$TunerListEntry 
.const [50] = Utf8 entryVariants 
.const [51] = Utf8 [Lde/audi/atip/interapp/SDSListEntry; 
.const [52] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [53] = Utf8 append 
.const [54] = Utf8 (Ljava/lang/Object;)Lde/esolutions/fw/util/commons/Buffer; 
.const [55] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [56] = Utf8 append 
.const [57] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [58] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [59] = Utf8 toString 
.const [60] = Utf8 ()Ljava/lang/String; 
.const [61] = Utf8 de/audi/atip/interapp/SDSListEntry 
.const [62] = Utf8 getId 
.const [63] = Utf8 ()J 
.const [64] = Utf8 de/audi/atip/interapp/SDSListEntry 
.const [65] = Utf8 getName 
.const [66] = Utf8 ()Ljava/lang/String; 
.const [67] = Utf8 java/lang/Object 
.const [68] = Utf8 <init> 
.const [69] = Utf8 ()V 
.const [70] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [71] = Utf8 <init> 
.const [72] = Utf8 (Ljava/lang/String;)V 
.const [73] = Utf8 de/audi/atip/interapp/TunerService$TunerListEntry 
.const [74] = Utf8 entryVariants 
.const [75] = Utf8 [Lde/audi/atip/interapp/SDSListEntry; 
.const [76] = Utf8 de/audi/atip/interapp/TunerService$TunerListEntry 
.const [77] = Class [76] 
.const [78] = Utf8 java/lang/Object 
.const [79] = Class [78] 
.const [80] = Utf8 entryVariants 
.const [81] = Utf8 [Lde/audi/atip/interapp/SDSListEntry; 
.const [82] = Utf8 Code 
.const [83] = Utf8 <init> 
.const [84] = Utf8 ([Lde/audi/atip/interapp/SDSListEntry;)V 
.const [85] = Utf8 toString 
.const [86] = Utf8 ()Ljava/lang/String; 
.const [87] = Utf8 getEntryVariantIds 
.const [88] = Utf8 ()[J 
.const [89] = Utf8 getNameOfEntryVariant 
.const [90] = Utf8 (I)Ljava/lang/String; 
.const [91] = Utf8 getName 
.const [92] = Utf8 ()Ljava/lang/String; 
.end class 
