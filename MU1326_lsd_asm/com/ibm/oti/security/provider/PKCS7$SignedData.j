.version 50 0 
.class public super [99] 
.super [101] 
.field private [102] [103] 
.field private [104] [105] 

.method [107] : [108] 
    .attribute [106] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [19] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [22] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [23] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [109] : [110] 
    .attribute [106] .code stack 6 locals 4 
        .catch [7] from L0 to L63 using L63 
        .catch [8] from L0 to L63 using L66 
L0:     aload_0 
L1:     getfield [14] 
L4:     getfield [16] 
L7:     checkcast [5] 
L10:    astore_1 
L11:    aload_1 
L12:    aload_1 
L13:    arraylength 
L14:    iconst_1 
L15:    isub 
L16:    aaload 
L17:    getfield [16] 
L20:    checkcast [5] 
L23:    astore_2 
L24:    aload_2 
L25:    arraylength 
L26:    anewarray [6] 
L29:    astore_3 
L30:    iconst_0 
L31:    istore 4 
L33:    goto L54 
L36:    aload_3 
L37:    iload 4 
L39:    new [24] 
L42:    dup 
L43:    aload_2 
L44:    iload 4 
L46:    aaload 
L47:    invokespecial [20] 
L50:    aastore 
L51:    iinc 4 1 
L54:    iload 4 
L56:    aload_2 
L57:    arraylength 
L58:    if_icmplt L36 
L61:    aload_3 
L62:    areturn 
L63:    pop 
L64:    aconst_null 
L65:    areturn 
L66:    pop 
L67:    aconst_null 
L68:    areturn 
L69:    nop 
L70:    nop 
L71:    nop 
L72:    
    .end code 
.end method 

.method public [111] : [112] 
    .attribute [106] .code stack 3 locals 4 
L0:     new [25] 
L3:     dup 
L4:     invokespecial [21] 
L7:     astore_1 
        .catch [7] from L8 to L72 using L72 
        .catch [8] from L8 to L72 using L75 
L8:     aload_0 
L9:     getfield [14] 
L12:    getfield [16] 
L15:    checkcast [5] 
L18:    iconst_3 
L19:    aaload 
L20:    astore_2 
L21:    aload_2 
L22:    getfield [17] 
L25:    ifeq L30 
L28:    aload_1 
L29:    areturn 
L30:    aload_2 
L31:    getfield [16] 
L34:    checkcast [5] 
L37:    astore_3 
L38:    iconst_0 
L39:    istore 4 
L41:    goto L63 
L44:    aload_1 
L45:    aload_3 
L46:    iload 4 
L48:    aaload 
L49:    aload_0 
L50:    getfield [15] 
L53:    invokestatic [11] 
L56:    invokevirtual [18] 
L59:    pop 
L60:    iinc 4 1 
L63:    iload 4 
L65:    aload_3 
L66:    arraylength 
L67:    if_icmplt L44 
L70:    aload_1 
L71:    areturn 
L72:    pop 
L73:    aload_1 
L74:    areturn 
L75:    pop 
L76:    aload_1 
L77:    areturn 
L78:    nop 
L79:    nop 
L80:    
    .end code 
.end method 

.method public [113] : [114] 
    .attribute [106] .code stack 3 locals 4 
L0:     new [25] 
L3:     dup 
L4:     invokespecial [21] 
L7:     astore_1 
        .catch [7] from L8 to L94 using L94 
        .catch [8] from L8 to L94 using L97 
L8:     aload_0 
L9:     getfield [14] 
L12:    getfield [16] 
L15:    checkcast [5] 
L18:    iconst_3 
L19:    aaload 
L20:    astore_2 
L21:    aload_2 
L22:    getfield [17] 
L25:    iconst_1 
L26:    if_icmpeq L52 
L29:    aload_0 
L30:    getfield [14] 
L33:    getfield [16] 
L36:    checkcast [5] 
L39:    iconst_4 
L40:    aaload 
L41:    astore_2 
L42:    aload_2 
L43:    getfield [17] 
L46:    iconst_1 
L47:    if_icmpeq L52 
L50:    aload_1 
L51:    areturn 
L52:    aload_2 
L53:    getfield [16] 
L56:    checkcast [5] 
L59:    astore_3 
L60:    iconst_0 
L61:    istore 4 
L63:    goto L85 
L66:    aload_1 
L67:    aload_3 
L68:    iload 4 
L70:    aaload 
L71:    aload_0 
L72:    getfield [15] 
L75:    invokestatic [13] 
L78:    invokevirtual [18] 
L81:    pop 
L82:    iinc 4 1 
L85:    iload 4 
L87:    aload_3 
L88:    arraylength 
L89:    if_icmplt L66 
L92:    aload_1 
L93:    areturn 
L94:    pop 
L95:    aload_1 
L96:    areturn 
L97:    pop 
L98:    aload_1 
L99:    areturn 
L100:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [26] 
.const [3] = Class [27] 
.const [4] = Class [28] 
.const [5] = Class [29] 
.const [6] = Class [30] 
.const [7] = Class [31] 
.const [8] = Class [32] 
.const [9] = Class [33] 
.const [10] = Class [34] 
.const [11] = Method [35] [36] 
.const [12] = Class [37] 
.const [13] = Method [38] [39] 
.const [14] = Field [40] [41] 
.const [15] = Field [42] [43] 
.const [16] = Field [44] [45] 
.const [17] = Field [46] [47] 
.const [18] = Method [48] [49] 
.const [19] = Method [50] [51] 
.const [20] = Method [52] [53] 
.const [21] = Method [54] [55] 
.const [22] = Field [56] [57] 
.const [23] = Field [58] [59] 
.const [24] = Class [60] 
.const [25] = Class [61] 
.const [26] = Utf8 com/ibm/oti/security/provider/PKCS7$SignedData 
.const [27] = Utf8 java/lang/Object 
.const [28] = Utf8 com/ibm/oti/util/ASN1Decoder$Node 
.const [29] = Utf8 [Lcom/ibm/oti/util/ASN1Decoder$Node; 
.const [30] = Utf8 com/ibm/oti/security/provider/PKCS7$SignerInfo 
.const [31] = Utf8 java/lang/ArrayIndexOutOfBoundsException 
.const [32] = Utf8 java/lang/ClassCastException 
.const [33] = Utf8 java/util/Vector 
.const [34] = Utf8 com/ibm/oti/security/provider/X509Certificate 
.const [35] = Class [62] 
.const [36] = NameAndType [63] [64] 
.const [37] = Utf8 com/ibm/oti/security/provider/X509CRL 
.const [38] = Class [65] 
.const [39] = NameAndType [66] [67] 
.const [40] = Class [68] 
.const [41] = NameAndType [69] [70] 
.const [42] = Class [71] 
.const [43] = NameAndType [72] [73] 
.const [44] = Class [74] 
.const [45] = NameAndType [75] [76] 
.const [46] = Class [77] 
.const [47] = NameAndType [78] [79] 
.const [48] = Class [80] 
.const [49] = NameAndType [81] [82] 
.const [50] = Class [83] 
.const [51] = NameAndType [84] [85] 
.const [52] = Class [86] 
.const [53] = NameAndType [87] [88] 
.const [54] = Class [89] 
.const [55] = NameAndType [90] [91] 
.const [56] = Class [92] 
.const [57] = NameAndType [93] [94] 
.const [58] = Class [95] 
.const [59] = NameAndType [96] [97] 
.const [60] = Utf8 com/ibm/oti/security/provider/PKCS7$SignerInfo 
.const [61] = Utf8 java/util/Vector 
.const [62] = Utf8 com/ibm/oti/security/provider/X509Certificate 
.const [63] = Utf8 certificateFromASN1Object 
.const [64] = Utf8 (Lcom/ibm/oti/util/ASN1Decoder$Node;[B)Lcom/ibm/oti/security/provider/X509Certificate; 
.const [65] = Utf8 com/ibm/oti/security/provider/X509CRL 
.const [66] = Utf8 CRLFromASN1Object 
.const [67] = Utf8 (Lcom/ibm/oti/util/ASN1Decoder$Node;[B)Ljava/security/cert/CRL; 
.const [68] = Utf8 com/ibm/oti/security/provider/PKCS7$SignedData 
.const [69] = Utf8 contents 
.const [70] = Utf8 Lcom/ibm/oti/util/ASN1Decoder$Node; 
.const [71] = Utf8 com/ibm/oti/security/provider/PKCS7$SignedData 
.const [72] = Utf8 encoded 
.const [73] = Utf8 [B 
.const [74] = Utf8 com/ibm/oti/util/ASN1Decoder$Node 
.const [75] = Utf8 data 
.const [76] = Utf8 Ljava/lang/Object; 
.const [77] = Utf8 com/ibm/oti/util/ASN1Decoder$Node 
.const [78] = Utf8 originalType 
.const [79] = Utf8 I 
.const [80] = Utf8 java/util/Vector 
.const [81] = Utf8 add 
.const [82] = Utf8 (Ljava/lang/Object;)Z 
.const [83] = Utf8 java/lang/Object 
.const [84] = Utf8 <init> 
.const [85] = Utf8 ()V 
.const [86] = Utf8 com/ibm/oti/security/provider/PKCS7$SignerInfo 
.const [87] = Utf8 <init> 
.const [88] = Utf8 (Lcom/ibm/oti/util/ASN1Decoder$Node;)V 
.const [89] = Utf8 java/util/Vector 
.const [90] = Utf8 <init> 
.const [91] = Utf8 ()V 
.const [92] = Utf8 com/ibm/oti/security/provider/PKCS7$SignedData 
.const [93] = Utf8 contents 
.const [94] = Utf8 Lcom/ibm/oti/util/ASN1Decoder$Node; 
.const [95] = Utf8 com/ibm/oti/security/provider/PKCS7$SignedData 
.const [96] = Utf8 encoded 
.const [97] = Utf8 [B 
.const [98] = Utf8 com/ibm/oti/security/provider/PKCS7$SignedData 
.const [99] = Class [98] 
.const [100] = Utf8 java/lang/Object 
.const [101] = Class [100] 
.const [102] = Utf8 contents 
.const [103] = Utf8 Lcom/ibm/oti/util/ASN1Decoder$Node; 
.const [104] = Utf8 encoded 
.const [105] = Utf8 [B 
.const [106] = Utf8 Code 
.const [107] = Utf8 <init> 
.const [108] = Utf8 (Lcom/ibm/oti/util/ASN1Decoder$Node;[B)V 
.const [109] = Utf8 signerInfos 
.const [110] = Utf8 ()[Lcom/ibm/oti/security/provider/PKCS7$SignerInfo; 
.const [111] = Utf8 certificates 
.const [112] = Utf8 ()Ljava/util/Vector; 
.const [113] = Utf8 CRLs 
.const [114] = Utf8 ()Ljava/util/Vector; 
.end class 
