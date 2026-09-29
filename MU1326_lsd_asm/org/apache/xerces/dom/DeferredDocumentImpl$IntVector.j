.version 50 0 
.class super [51] 
.super [53] 
.field private [54] [55] 
.field private [56] [57] 

.method annotation [59] : [60] 
    .attribute [58] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [8] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [61] : [62] 
    .attribute [58] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [6] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [63] : [64] 
    .attribute [58] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [7] 
L4:     iload_1 
L5:     iaload 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [65] : [66] 
    .attribute [58] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_0 
L2:     getfield [6] 
L5:     iconst_1 
L6:     iadd 
L7:     invokespecial [9] 
L10:    aload_0 
L11:    getfield [7] 
L14:    aload_0 
L15:    dup 
L16:    getfield [6] 
L19:    dup_x1 
L20:    iconst_1 
L21:    iadd 
L22:    putfield [10] 
L25:    iload_1 
L26:    iastore 
L27:    return 
L28:    
    .end code 
.end method 

.method public [67] : [68] 
    .attribute [58] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [10] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method private [69] : [70] 
    .attribute [58] .code stack 5 locals 1 
L0:     aload_0 
L1:     getfield [7] 
L4:     ifnonnull L20 
L7:     aload_0 
L8:     iload_1 
L9:     bipush 15 
L11:    iadd 
L12:    newarray int 
L14:    putfield [11] 
L17:    goto L56 
L20:    iload_1 
L21:    aload_0 
L22:    getfield [7] 
L25:    arraylength 
L26:    if_icmple L56 
L29:    iload_1 
L30:    bipush 15 
L32:    iadd 
L33:    newarray int 
L35:    astore_2 
L36:    aload_0 
L37:    getfield [7] 
L40:    iconst_0 
L41:    aload_2 
L42:    iconst_0 
L43:    aload_0 
L44:    getfield [7] 
L47:    arraylength 
L48:    invokestatic [2] 
L51:    aload_0 
L52:    aload_2 
L53:    putfield [11] 
L56:    return 
L57:    nop 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [12] [13] 
.const [3] = Class [14] 
.const [4] = Class [15] 
.const [5] = Class [16] 
.const [6] = Field [17] [18] 
.const [7] = Field [19] [20] 
.const [8] = Method [21] [22] 
.const [9] = Method [23] [24] 
.const [10] = Field [25] [26] 
.const [11] = Field [27] [28] 
.const [12] = Class [29] 
.const [13] = NameAndType [30] [31] 
.const [14] = Utf8 org/apache/xerces/dom/DeferredDocumentImpl$IntVector 
.const [15] = Utf8 java/lang/Object 
.const [16] = Utf8 java/lang/System 
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
.const [29] = Utf8 java/lang/System 
.const [30] = Utf8 arraycopy 
.const [31] = Utf8 (Ljava/lang/Object;ILjava/lang/Object;II)V 
.const [32] = Utf8 org/apache/xerces/dom/DeferredDocumentImpl$IntVector 
.const [33] = Utf8 size 
.const [34] = Utf8 I 
.const [35] = Utf8 org/apache/xerces/dom/DeferredDocumentImpl$IntVector 
.const [36] = Utf8 data 
.const [37] = Utf8 [I 
.const [38] = Utf8 java/lang/Object 
.const [39] = Utf8 <init> 
.const [40] = Utf8 ()V 
.const [41] = Utf8 org/apache/xerces/dom/DeferredDocumentImpl$IntVector 
.const [42] = Utf8 ensureCapacity 
.const [43] = Utf8 (I)V 
.const [44] = Utf8 org/apache/xerces/dom/DeferredDocumentImpl$IntVector 
.const [45] = Utf8 size 
.const [46] = Utf8 I 
.const [47] = Utf8 org/apache/xerces/dom/DeferredDocumentImpl$IntVector 
.const [48] = Utf8 data 
.const [49] = Utf8 [I 
.const [50] = Utf8 org/apache/xerces/dom/DeferredDocumentImpl$IntVector 
.const [51] = Class [50] 
.const [52] = Utf8 java/lang/Object 
.const [53] = Class [52] 
.const [54] = Utf8 data 
.const [55] = Utf8 [I 
.const [56] = Utf8 size 
.const [57] = Utf8 I 
.const [58] = Utf8 Code 
.const [59] = Utf8 <init> 
.const [60] = Utf8 ()V 
.const [61] = Utf8 size 
.const [62] = Utf8 ()I 
.const [63] = Utf8 elementAt 
.const [64] = Utf8 (I)I 
.const [65] = Utf8 addElement 
.const [66] = Utf8 (I)V 
.const [67] = Utf8 removeAllElements 
.const [68] = Utf8 ()V 
.const [69] = Utf8 ensureCapacity 
.const [70] = Utf8 (I)V 
.end class 
