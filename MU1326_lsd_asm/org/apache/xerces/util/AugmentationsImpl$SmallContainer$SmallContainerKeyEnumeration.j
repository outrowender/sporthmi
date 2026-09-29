.version 50 0 
.class super [73] 
.super [75] 
.implements [77] 
.field [78] [79] 
.field [80] [81] 
.field private final synthetic [82] [83] 

.method [85] : [86] 
    .attribute [84] .code stack 5 locals 1 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [13] 
L5:     aload_0 
L6:     invokespecial [11] 
L9:     aload_0 
L10:    aload_0 
L11:    getfield [6] 
L14:    getfield [7] 
L17:    anewarray [2] 
L20:    putfield [14] 
L23:    aload_0 
L24:    iconst_0 
L25:    putfield [15] 
L28:    iconst_0 
L29:    istore_2 
L30:    iload_2 
L31:    aload_1 
L32:    getfield [7] 
L35:    if_icmpge L58 
L38:    aload_0 
L39:    getfield [8] 
L42:    iload_2 
L43:    aload_1 
L44:    getfield [10] 
L47:    iload_2 
L48:    iconst_2 
L49:    imul 
L50:    aaload 
L51:    aastore 
L52:    iinc 2 1 
L55:    goto L30 
L58:    return 
L59:    nop 
L60:    
    .end code 
.end method 

.method public [87] : [88] 
    .attribute [84] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [9] 
L4:     aload_0 
L5:     getfield [8] 
L8:     arraylength 
L9:     if_icmpge L16 
L12:    iconst_1 
L13:    goto L17 
L16:    iconst_0 
L17:    areturn 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [89] : [90] 
    .attribute [84] .code stack 3 locals 1 
L0:     aload_0 
L1:     getfield [9] 
L4:     aload_0 
L5:     getfield [8] 
L8:     arraylength 
L9:     if_icmplt L20 
L12:    new [16] 
L15:    dup 
L16:    invokespecial [12] 
L19:    athrow 
L20:    aload_0 
L21:    getfield [8] 
L24:    aload_0 
L25:    getfield [9] 
L28:    aaload 
L29:    astore_1 
L30:    aload_0 
L31:    getfield [8] 
L34:    aload_0 
L35:    getfield [9] 
L38:    aconst_null 
L39:    aastore 
L40:    aload_0 
L41:    dup 
L42:    getfield [9] 
L45:    iconst_1 
L46:    iadd 
L47:    putfield [15] 
L50:    aload_1 
L51:    areturn 
L52:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [17] 
.const [3] = Class [18] 
.const [4] = Class [19] 
.const [5] = Class [20] 
.const [6] = Field [21] [22] 
.const [7] = Field [23] [24] 
.const [8] = Field [25] [26] 
.const [9] = Field [27] [28] 
.const [10] = Field [29] [30] 
.const [11] = Method [31] [32] 
.const [12] = Method [33] [34] 
.const [13] = Field [35] [36] 
.const [14] = Field [37] [38] 
.const [15] = Field [39] [40] 
.const [16] = Class [41] 
.const [17] = Utf8 java/lang/Object 
.const [18] = Utf8 java/util/NoSuchElementException 
.const [19] = Utf8 org/apache/xerces/util/AugmentationsImpl$SmallContainer$SmallContainerKeyEnumeration 
.const [20] = Utf8 org/apache/xerces/util/AugmentationsImpl$SmallContainer 
.const [21] = Class [42] 
.const [22] = NameAndType [43] [44] 
.const [23] = Class [45] 
.const [24] = NameAndType [46] [47] 
.const [25] = Class [48] 
.const [26] = NameAndType [49] [50] 
.const [27] = Class [51] 
.const [28] = NameAndType [52] [53] 
.const [29] = Class [54] 
.const [30] = NameAndType [55] [56] 
.const [31] = Class [57] 
.const [32] = NameAndType [58] [59] 
.const [33] = Class [60] 
.const [34] = NameAndType [61] [62] 
.const [35] = Class [63] 
.const [36] = NameAndType [64] [65] 
.const [37] = Class [66] 
.const [38] = NameAndType [67] [68] 
.const [39] = Class [69] 
.const [40] = NameAndType [70] [71] 
.const [41] = Utf8 java/util/NoSuchElementException 
.const [42] = Utf8 org/apache/xerces/util/AugmentationsImpl$SmallContainer$SmallContainerKeyEnumeration 
.const [43] = Utf8 this$1 
.const [44] = Utf8 Lorg/apache/xerces/util/AugmentationsImpl$SmallContainer; 
.const [45] = Utf8 org/apache/xerces/util/AugmentationsImpl$SmallContainer 
.const [46] = Utf8 fNumEntries 
.const [47] = Utf8 I 
.const [48] = Utf8 org/apache/xerces/util/AugmentationsImpl$SmallContainer$SmallContainerKeyEnumeration 
.const [49] = Utf8 enumArray 
.const [50] = Utf8 [Ljava/lang/Object; 
.const [51] = Utf8 org/apache/xerces/util/AugmentationsImpl$SmallContainer$SmallContainerKeyEnumeration 
.const [52] = Utf8 next 
.const [53] = Utf8 I 
.const [54] = Utf8 org/apache/xerces/util/AugmentationsImpl$SmallContainer 
.const [55] = Utf8 fAugmentations 
.const [56] = Utf8 [Ljava/lang/Object; 
.const [57] = Utf8 java/lang/Object 
.const [58] = Utf8 <init> 
.const [59] = Utf8 ()V 
.const [60] = Utf8 java/util/NoSuchElementException 
.const [61] = Utf8 <init> 
.const [62] = Utf8 ()V 
.const [63] = Utf8 org/apache/xerces/util/AugmentationsImpl$SmallContainer$SmallContainerKeyEnumeration 
.const [64] = Utf8 this$1 
.const [65] = Utf8 Lorg/apache/xerces/util/AugmentationsImpl$SmallContainer; 
.const [66] = Utf8 org/apache/xerces/util/AugmentationsImpl$SmallContainer$SmallContainerKeyEnumeration 
.const [67] = Utf8 enumArray 
.const [68] = Utf8 [Ljava/lang/Object; 
.const [69] = Utf8 org/apache/xerces/util/AugmentationsImpl$SmallContainer$SmallContainerKeyEnumeration 
.const [70] = Utf8 next 
.const [71] = Utf8 I 
.const [72] = Utf8 org/apache/xerces/util/AugmentationsImpl$SmallContainer$SmallContainerKeyEnumeration 
.const [73] = Class [72] 
.const [74] = Utf8 java/lang/Object 
.const [75] = Class [74] 
.const [76] = Utf8 java/util/Enumeration 
.const [77] = Class [76] 
.const [78] = Utf8 enumArray 
.const [79] = Utf8 [Ljava/lang/Object; 
.const [80] = Utf8 next 
.const [81] = Utf8 I 
.const [82] = Utf8 this$1 
.const [83] = Utf8 Lorg/apache/xerces/util/AugmentationsImpl$SmallContainer; 
.const [84] = Utf8 Code 
.const [85] = Utf8 <init> 
.const [86] = Utf8 (Lorg/apache/xerces/util/AugmentationsImpl$SmallContainer;)V 
.const [87] = Utf8 hasMoreElements 
.const [88] = Utf8 ()Z 
.const [89] = Utf8 nextElement 
.const [90] = Utf8 ()Ljava/lang/Object; 
.end class 
