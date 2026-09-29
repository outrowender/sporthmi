.version 50 0 
.class public super [57] 
.super [59] 
.field private final [60] [61] 
.field private final [62] [63] 

.method public [65] : [66] 
    .attribute [64] .code stack 4 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     iload_2 
L3:     aload_3 
L4:     invokespecial [7] 
L7:     aload_0 
L8:     iload 4 
L10:    putfield [11] 
L13:    aload_0 
L14:    iload 5 
L16:    putfield [12] 
L19:    return 
L20:    
    .end code 
.end method 

.method public interface [67] : [68] 
    .attribute [64] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [5] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [69] : [70] 
    .attribute [64] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [6] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [71] : [72] 
    .attribute [64] .code stack 2 locals 2 
L0:     aload_0 
L1:     invokespecial [8] 
L4:     istore_2 
L5:     bipush 31 
L7:     iload_2 
L8:     imul 
L9:     aload_0 
L10:    getfield [6] 
L13:    iadd 
L14:    istore_2 
L15:    bipush 31 
L17:    iload_2 
L18:    imul 
L19:    aload_0 
L20:    getfield [5] 
L23:    iadd 
L24:    istore_2 
L25:    iload_2 
L26:    areturn 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [73] : [74] 
    .attribute [64] .code stack 2 locals 1 
L0:     aload_0 
L1:     aload_1 
L2:     if_acmpne L7 
L5:     iconst_1 
L6:     areturn 
L7:     aload_0 
L8:     aload_1 
L9:     invokespecial [9] 
L12:    ifne L17 
L15:    iconst_0 
L16:    areturn 
L17:    aload_0 
L18:    invokespecial [10] 
L21:    aload_1 
L22:    invokespecial [10] 
L25:    if_acmpeq L30 
L28:    iconst_0 
L29:    areturn 
L30:    aload_1 
L31:    checkcast [2] 
L34:    astore_2 
L35:    aload_0 
L36:    getfield [6] 
L39:    aload_2 
L40:    getfield [6] 
L43:    if_icmpeq L48 
L46:    iconst_0 
L47:    areturn 
L48:    aload_0 
L49:    getfield [5] 
L52:    aload_2 
L53:    getfield [5] 
L56:    if_icmpeq L61 
L59:    iconst_0 
L60:    areturn 
L61:    iconst_1 
L62:    areturn 
L63:    nop 
L64:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [13] 
.const [3] = Class [14] 
.const [4] = Class [15] 
.const [5] = Field [16] [17] 
.const [6] = Field [18] [19] 
.const [7] = Method [20] [21] 
.const [8] = Method [22] [23] 
.const [9] = Method [24] [25] 
.const [10] = Method [26] [27] 
.const [11] = Field [28] [29] 
.const [12] = Field [30] [31] 
.const [13] = Utf8 de/audi/app/combi/bap/fw/arrays/GetArrayIndicationAddressList 
.const [14] = Utf8 de/audi/app/bap/fw/arrays/GetArrayIndication 
.const [15] = Utf8 java/lang/Object 
.const [16] = Class [32] 
.const [17] = NameAndType [33] [34] 
.const [18] = Class [35] 
.const [19] = NameAndType [36] [37] 
.const [20] = Class [38] 
.const [21] = NameAndType [39] [40] 
.const [22] = Class [41] 
.const [23] = NameAndType [42] [43] 
.const [24] = Class [44] 
.const [25] = NameAndType [45] [46] 
.const [26] = Class [47] 
.const [27] = NameAndType [48] [49] 
.const [28] = Class [50] 
.const [29] = NameAndType [51] [52] 
.const [30] = Class [53] 
.const [31] = NameAndType [54] [55] 
.const [32] = Utf8 de/audi/app/combi/bap/fw/arrays/GetArrayIndicationAddressList 
.const [33] = Utf8 otherListType 
.const [34] = Utf8 I 
.const [35] = Utf8 de/audi/app/combi/bap/fw/arrays/GetArrayIndicationAddressList 
.const [36] = Utf8 otherListReference 
.const [37] = Utf8 I 
.const [38] = Utf8 de/audi/app/bap/fw/arrays/GetArrayIndication 
.const [39] = Utf8 <init> 
.const [40] = Utf8 (IILde/audi/app/bap/fw/arrays/IArrayHeader;)V 
.const [41] = Utf8 de/audi/app/bap/fw/arrays/GetArrayIndication 
.const [42] = Utf8 hashCode 
.const [43] = Utf8 ()I 
.const [44] = Utf8 de/audi/app/bap/fw/arrays/GetArrayIndication 
.const [45] = Utf8 equals 
.const [46] = Utf8 (Ljava/lang/Object;)Z 
.const [47] = Utf8 java/lang/Object 
.const [48] = Utf8 getClass 
.const [49] = Utf8 ()Ljava/lang/Class; 
.const [50] = Utf8 de/audi/app/combi/bap/fw/arrays/GetArrayIndicationAddressList 
.const [51] = Utf8 otherListType 
.const [52] = Utf8 I 
.const [53] = Utf8 de/audi/app/combi/bap/fw/arrays/GetArrayIndicationAddressList 
.const [54] = Utf8 otherListReference 
.const [55] = Utf8 I 
.const [56] = Utf8 de/audi/app/combi/bap/fw/arrays/GetArrayIndicationAddressList 
.const [57] = Class [56] 
.const [58] = Utf8 de/audi/app/bap/fw/arrays/GetArrayIndication 
.const [59] = Class [58] 
.const [60] = Utf8 otherListType 
.const [61] = Utf8 I 
.const [62] = Utf8 otherListReference 
.const [63] = Utf8 I 
.const [64] = Utf8 Code 
.const [65] = Utf8 <init> 
.const [66] = Utf8 (IILde/audi/app/bap/fw/arrays/IArrayHeader;II)V 
.const [67] = Utf8 getOtherListType 
.const [68] = Utf8 ()I 
.const [69] = Utf8 getOtherListReference 
.const [70] = Utf8 ()I 
.const [71] = Utf8 hashCode 
.const [72] = Utf8 ()I 
.const [73] = Utf8 equals 
.const [74] = Utf8 (Ljava/lang/Object;)Z 
.end class 
