.version 50 0 
.class public super [75] 
.super [77] 
.field static final [78] [79] 
.field public static final [80] [81] 
.field public static final [82] [83] 
.field static final [84] [85] 
.field private static final [86] [87] 
.field private final [88] [89] 
.field private final [90] [91] 
.field private [92] [93] 

.method public [95] : [96] 
    .attribute [94] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [12] 
L4:     aload_0 
L5:     iconst_0 
L6:     putfield [14] 
L9:     aload_0 
L10:    aload_1 
L11:    ifnull L18 
L14:    aload_1 
L15:    goto L20 
L18:    ldc [2] 
L20:    putfield [15] 
L23:    aload_0 
L24:    aload_2 
L25:    ifnonnull L35 
L28:    iconst_0 
L29:    anewarray [3] 
L32:    goto L36 
L35:    aload_2 
L36:    putfield [17] 
L39:    aload_0 
L40:    iload_3 
L41:    putfield [14] 
L44:    return 
L45:    nop 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [97] : [98] 
    .attribute [94] .code stack 7 locals 2 
L0:     aload_0 
L1:     invokespecial [12] 
L4:     aload_0 
L5:     iconst_0 
L6:     putfield [14] 
L9:     aload_0 
L10:    aload_1 
L11:    ifnull L18 
L14:    aload_1 
L15:    goto L20 
L18:    ldc [2] 
L20:    putfield [15] 
L23:    aload_0 
L24:    iload_3 
L25:    putfield [14] 
L28:    aload_2 
L29:    invokestatic [4] 
L32:    ifeq L44 
L35:    aload_0 
L36:    iconst_0 
L37:    anewarray [3] 
L40:    putfield [17] 
L43:    return 
L44:    aload_2 
L45:    arraylength 
L46:    istore 4 
L48:    aload_0 
L49:    iload 4 
L51:    anewarray [3] 
L54:    putfield [17] 
L57:    iconst_0 
L58:    istore 5 
L60:    iload 5 
L62:    iload 4 
L64:    if_icmpge L92 
L67:    aload_0 
L68:    getfield [11] 
L71:    iload 5 
L73:    new [16] 
L76:    dup 
L77:    aload_2 
L78:    iload 5 
L80:    aaload 
L81:    lconst_0 
L82:    invokespecial [13] 
L85:    aastore 
L86:    iinc 5 1 
L89:    goto L60 
L92:    return 
L93:    nop 
L94:    nop 
L95:    nop 
L96:    
    .end code 
.end method 

.method public interface [99] : [100] 
    .attribute [94] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method interface [101] : [102] 
    .attribute [94] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method [103] : [104] 
    .attribute [94] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [14] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method interface [105] : [106] 
    .attribute [94] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [9] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [107] : [108] 
    .attribute [94] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     iconst_0 
L5:     invokestatic [5] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [18] 
.const [3] = Class [19] 
.const [4] = Method [20] [21] 
.const [5] = Method [22] [23] 
.const [6] = Class [24] 
.const [7] = Class [25] 
.const [8] = Class [26] 
.const [9] = Field [27] [28] 
.const [10] = Field [29] [30] 
.const [11] = Field [31] [32] 
.const [12] = Method [33] [34] 
.const [13] = Method [35] [36] 
.const [14] = Field [37] [38] 
.const [15] = Field [39] [40] 
.const [16] = Class [41] 
.const [17] = Field [42] [43] 
.const [18] = Utf8 UNK 
.const [19] = Utf8 de/audi/atip/interapp/SDSListEntry 
.const [20] = Class [44] 
.const [21] = NameAndType [45] [46] 
.const [22] = Class [47] 
.const [23] = NameAndType [48] [49] 
.const [24] = Utf8 de/audi/app/sdsmanager/grammar/DynamicSlotContent 
.const [25] = Utf8 java/lang/Object 
.const [26] = Utf8 de/audi/app/sdsmanager/common/SDSUtils 
.const [27] = Class [50] 
.const [28] = NameAndType [51] [52] 
.const [29] = Class [53] 
.const [30] = NameAndType [54] [55] 
.const [31] = Class [56] 
.const [32] = NameAndType [57] [58] 
.const [33] = Class [59] 
.const [34] = NameAndType [60] [61] 
.const [35] = Class [62] 
.const [36] = NameAndType [63] [64] 
.const [37] = Class [65] 
.const [38] = NameAndType [66] [67] 
.const [39] = Class [68] 
.const [40] = NameAndType [69] [70] 
.const [41] = Utf8 de/audi/atip/interapp/SDSListEntry 
.const [42] = Class [71] 
.const [43] = NameAndType [72] [73] 
.const [44] = Utf8 de/audi/app/sdsmanager/common/SDSUtils 
.const [45] = Utf8 isEmpty 
.const [46] = Utf8 ([Ljava/lang/String;)Z 
.const [47] = Utf8 de/audi/app/sdsmanager/common/SDSUtils 
.const [48] = Utf8 toString 
.const [49] = Utf8 ([Ljava/lang/Object;Z)Ljava/lang/String; 
.const [50] = Utf8 de/audi/app/sdsmanager/grammar/DynamicSlotContent 
.const [51] = Utf8 status 
.const [52] = Utf8 B 
.const [53] = Utf8 de/audi/app/sdsmanager/grammar/DynamicSlotContent 
.const [54] = Utf8 description 
.const [55] = Utf8 Ljava/lang/String; 
.const [56] = Utf8 de/audi/app/sdsmanager/grammar/DynamicSlotContent 
.const [57] = Utf8 slotEntries 
.const [58] = Utf8 [Lde/audi/atip/interapp/SDSListEntry; 
.const [59] = Utf8 java/lang/Object 
.const [60] = Utf8 <init> 
.const [61] = Utf8 ()V 
.const [62] = Utf8 de/audi/atip/interapp/SDSListEntry 
.const [63] = Utf8 <init> 
.const [64] = Utf8 (Ljava/lang/String;J)V 
.const [65] = Utf8 de/audi/app/sdsmanager/grammar/DynamicSlotContent 
.const [66] = Utf8 status 
.const [67] = Utf8 B 
.const [68] = Utf8 de/audi/app/sdsmanager/grammar/DynamicSlotContent 
.const [69] = Utf8 description 
.const [70] = Utf8 Ljava/lang/String; 
.const [71] = Utf8 de/audi/app/sdsmanager/grammar/DynamicSlotContent 
.const [72] = Utf8 slotEntries 
.const [73] = Utf8 [Lde/audi/atip/interapp/SDSListEntry; 
.const [74] = Utf8 de/audi/app/sdsmanager/grammar/DynamicSlotContent 
.const [75] = Class [74] 
.const [76] = Utf8 java/lang/Object 
.const [77] = Class [76] 
.const [78] = Utf8 DESCR_UNK 
.const [79] = Utf8 Ljava/lang/String; 
.const [80] = Utf8 SLOT_CONTENT_NEW 
.const [81] = Utf8 B 
.const [82] = Utf8 SLOT_CONTENT_NEW_AND_TO_BE_LOADED 
.const [83] = Utf8 B 
.const [84] = Utf8 SLOT_CONTENT_OLD 
.const [85] = Utf8 B 
.const [86] = Utf8 DUMMY_ID 
.const [87] = Utf8 J 
.const [88] = Utf8 description 
.const [89] = Utf8 Ljava/lang/String; 
.const [90] = Utf8 slotEntries 
.const [91] = Utf8 [Lde/audi/atip/interapp/SDSListEntry; 
.const [92] = Utf8 status 
.const [93] = Utf8 B 
.const [94] = Utf8 Code 
.const [95] = Utf8 <init> 
.const [96] = Utf8 (Ljava/lang/String;[Lde/audi/atip/interapp/SDSListEntry;B)V 
.const [97] = Utf8 <init> 
.const [98] = Utf8 (Ljava/lang/String;[Ljava/lang/String;B)V 
.const [99] = Utf8 getEntries 
.const [100] = Utf8 ()[Lde/audi/atip/interapp/SDSListEntry; 
.const [101] = Utf8 getDescription 
.const [102] = Utf8 ()Ljava/lang/String; 
.const [103] = Utf8 setStatus 
.const [104] = Utf8 (B)V 
.const [105] = Utf8 getStatus 
.const [106] = Utf8 ()B 
.const [107] = Utf8 toString 
.const [108] = Utf8 ()Ljava/lang/String; 
.end class 
