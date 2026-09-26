.version 50 0 
.class public final super [49] 
.super [51] 
.field private [52] [53] 

.method public [55] : [56] 
    .attribute [54] .code stack 2 locals 0 
L0:     aload_0 
L1:     aconst_null 
L2:     invokespecial [9] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [57] : [58] 
    .attribute [54] .code stack 4 locals 0 
L0:     aload_0 
L1:     aconst_null 
L2:     aload_1 
L3:     invokestatic [2] 
L6:     aconst_null 
L7:     invokespecial [10] 
L10:    aload_0 
L11:    aload_1 
L12:    putfield [11] 
L15:    return 
L16:    
    .end code 
.end method 

.method public [59] : [60] 
    .attribute [54] .code stack 4 locals 0 
L0:     aload_0 
L1:     aconst_null 
L2:     aload_2 
L3:     aconst_null 
L4:     invokespecial [10] 
L7:     aload_0 
L8:     aload_1 
L9:     putfield [11] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public interface [61] : [62] 
    .attribute [54] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [63] : [64] 
    .attribute [54] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [11] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method private static [65] : [66] 
    .attribute [54] .code stack 1 locals 1 
L0:     aload_0 
L1:     ifnull L17 
        .catch [3] from L4 to L10 using L11 
        .catch [4] from L4 to L10 using L14 
L4:     aload_0 
L5:     invokeinterface [12] 0 
L10:    areturn 
L11:    astore_1 
L12:    aconst_null 
L13:    areturn 
L14:    astore_1 
L15:    aconst_null 
L16:    areturn 
L17:    aconst_null 
L18:    areturn 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [13] [14] 
.const [3] = Class [15] 
.const [4] = Class [16] 
.const [5] = Class [17] 
.const [6] = Class [18] 
.const [7] = Class [19] 
.const [8] = Field [20] [21] 
.const [9] = Method [22] [23] 
.const [10] = Method [24] [25] 
.const [11] = Field [26] [27] 
.const [12] = InterfaceMethod [28] [29] 
.const [13] = Class [30] 
.const [14] = NameAndType [31] [32] 
.const [15] = Utf8 java/lang/NoSuchMethodError 
.const [16] = Utf8 java/lang/Exception 
.const [17] = Utf8 org/apache/xerces/util/DOMInputSource 
.const [18] = Utf8 org/apache/xerces/xni/parser/XMLInputSource 
.const [19] = Utf8 org/w3c/dom/Node 
.const [20] = Class [33] 
.const [21] = NameAndType [34] [35] 
.const [22] = Class [36] 
.const [23] = NameAndType [37] [38] 
.const [24] = Class [39] 
.const [25] = NameAndType [40] [41] 
.const [26] = Class [42] 
.const [27] = NameAndType [43] [44] 
.const [28] = Class [45] 
.const [29] = NameAndType [46] [47] 
.const [30] = Utf8 org/apache/xerces/util/DOMInputSource 
.const [31] = Utf8 getSystemIdFromNode 
.const [32] = Utf8 (Lorg/w3c/dom/Node;)Ljava/lang/String; 
.const [33] = Utf8 org/apache/xerces/util/DOMInputSource 
.const [34] = Utf8 fNode 
.const [35] = Utf8 Lorg/w3c/dom/Node; 
.const [36] = Utf8 org/apache/xerces/util/DOMInputSource 
.const [37] = Utf8 <init> 
.const [38] = Utf8 (Lorg/w3c/dom/Node;)V 
.const [39] = Utf8 org/apache/xerces/xni/parser/XMLInputSource 
.const [40] = Utf8 <init> 
.const [41] = Utf8 (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V 
.const [42] = Utf8 org/apache/xerces/util/DOMInputSource 
.const [43] = Utf8 fNode 
.const [44] = Utf8 Lorg/w3c/dom/Node; 
.const [45] = Utf8 org/w3c/dom/Node 
.const [46] = Utf8 getBaseURI 
.const [47] = Utf8 ()Ljava/lang/String; 
.const [48] = Utf8 org/apache/xerces/util/DOMInputSource 
.const [49] = Class [48] 
.const [50] = Utf8 org/apache/xerces/xni/parser/XMLInputSource 
.const [51] = Class [50] 
.const [52] = Utf8 fNode 
.const [53] = Utf8 Lorg/w3c/dom/Node; 
.const [54] = Utf8 Code 
.const [55] = Utf8 <init> 
.const [56] = Utf8 ()V 
.const [57] = Utf8 <init> 
.const [58] = Utf8 (Lorg/w3c/dom/Node;)V 
.const [59] = Utf8 <init> 
.const [60] = Utf8 (Lorg/w3c/dom/Node;Ljava/lang/String;)V 
.const [61] = Utf8 getNode 
.const [62] = Utf8 ()Lorg/w3c/dom/Node; 
.const [63] = Utf8 setNode 
.const [64] = Utf8 (Lorg/w3c/dom/Node;)V 
.const [65] = Utf8 getSystemIdFromNode 
.const [66] = Utf8 (Lorg/w3c/dom/Node;)Ljava/lang/String; 
.end class 
