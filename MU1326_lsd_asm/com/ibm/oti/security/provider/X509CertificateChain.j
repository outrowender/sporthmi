.version 50 0 
.class public super [113] 
.super [115] 
.field [116] [117] 

.method public [119] : [120] 
    .attribute [118] .code stack 3 locals 2 
L0:     aload_0 
L1:     invokespecial [16] 
L4:     aload_0 
L5:     aconst_null 
L6:     putfield [20] 
L9:     aload_1 
L10:    ifnonnull L21 
L13:    new [21] 
L16:    dup 
L17:    invokespecial [17] 
L20:    athrow 
L21:    aload_0 
L22:    new [22] 
L25:    dup 
L26:    invokespecial [18] 
L29:    putfield [20] 
L32:    aload_0 
L33:    getfield [10] 
L36:    iconst_0 
L37:    aload_1 
L38:    invokevirtual [11] 
L41:    aload_1 
L42:    invokevirtual [12] 
L45:    aload_1 
L46:    invokevirtual [13] 
L49:    invokeinterface [23] 0 
L54:    ifeq L58 
L57:    return 
L58:    aload_2 
L59:    ifnonnull L63 
L62:    return 
L63:    aload_1 
L64:    invokevirtual [13] 
L67:    astore_3 
L68:    aload_0 
L69:    aload_3 
L70:    aload_2 
L71:    invokespecial [19] 
L74:    astore 4 
L76:    aload 4 
L78:    ifnull L94 
L81:    aload_0 
L82:    getfield [10] 
L85:    aload 4 
L87:    invokevirtual [14] 
L90:    pop 
L91:    goto L95 
L94:    return 
L95:    aload 4 
L97:    invokevirtual [12] 
L100:   aload 4 
L102:   invokevirtual [13] 
L105:   invokeinterface [23] 0 
L110:   ifeq L114 
L113:   return 
L114:   aload 4 
L116:   invokevirtual [13] 
L119:   astore_3 
L120:   goto L68 
L123:   nop 
L124:   
    .end code 
.end method 

.method public [121] : [122] 
    .attribute [118] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     invokevirtual [15] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method private [123] : [124] 
    .attribute [118] .code stack 2 locals 2 
L0:     aload_2 
L1:     invokeinterface [24] 0 
L6:     astore_3 
L7:     goto L38 
L10:    aload_3 
L11:    invokeinterface [25] 0 
L16:    checkcast [6] 
L19:    astore 4 
L21:    aload 4 
L23:    invokevirtual [12] 
L26:    aload_1 
L27:    invokeinterface [23] 0 
L32:    ifeq L38 
L35:    aload 4 
L37:    areturn 
L38:    aload_3 
L39:    invokeinterface [26] 0 
L44:    ifne L10 
L47:    aconst_null 
L48:    areturn 
L49:    nop 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [27] 
.const [3] = Class [28] 
.const [4] = Class [29] 
.const [5] = Class [30] 
.const [6] = Class [31] 
.const [7] = Class [32] 
.const [8] = Class [33] 
.const [9] = Class [34] 
.const [10] = Field [35] [36] 
.const [11] = Method [37] [38] 
.const [12] = Method [39] [40] 
.const [13] = Method [41] [42] 
.const [14] = Method [43] [44] 
.const [15] = Method [45] [46] 
.const [16] = Method [47] [48] 
.const [17] = Method [49] [50] 
.const [18] = Method [51] [52] 
.const [19] = Method [53] [54] 
.const [20] = Field [55] [56] 
.const [21] = Class [57] 
.const [22] = Class [58] 
.const [23] = InterfaceMethod [59] [60] 
.const [24] = InterfaceMethod [61] [62] 
.const [25] = InterfaceMethod [63] [64] 
.const [26] = InterfaceMethod [65] [66] 
.const [27] = Utf8 com/ibm/oti/security/provider/X509CertificateChain 
.const [28] = Utf8 java/lang/Object 
.const [29] = Utf8 java/lang/IllegalArgumentException 
.const [30] = Utf8 java/util/LinkedList 
.const [31] = Utf8 java/security/cert/X509Certificate 
.const [32] = Utf8 java/security/Principal 
.const [33] = Utf8 java/util/Collection 
.const [34] = Utf8 java/util/Iterator 
.const [35] = Class [67] 
.const [36] = NameAndType [68] [69] 
.const [37] = Class [70] 
.const [38] = NameAndType [71] [72] 
.const [39] = Class [73] 
.const [40] = NameAndType [74] [75] 
.const [41] = Class [76] 
.const [42] = NameAndType [77] [78] 
.const [43] = Class [79] 
.const [44] = NameAndType [80] [81] 
.const [45] = Class [82] 
.const [46] = NameAndType [83] [84] 
.const [47] = Class [85] 
.const [48] = NameAndType [86] [87] 
.const [49] = Class [88] 
.const [50] = NameAndType [89] [90] 
.const [51] = Class [91] 
.const [52] = NameAndType [92] [93] 
.const [53] = Class [94] 
.const [54] = NameAndType [95] [96] 
.const [55] = Class [97] 
.const [56] = NameAndType [98] [99] 
.const [57] = Utf8 java/lang/IllegalArgumentException 
.const [58] = Utf8 java/util/LinkedList 
.const [59] = Class [100] 
.const [60] = NameAndType [101] [102] 
.const [61] = Class [103] 
.const [62] = NameAndType [104] [105] 
.const [63] = Class [106] 
.const [64] = NameAndType [107] [108] 
.const [65] = Class [109] 
.const [66] = NameAndType [110] [111] 
.const [67] = Utf8 com/ibm/oti/security/provider/X509CertificateChain 
.const [68] = Utf8 chain 
.const [69] = Utf8 Ljava/util/LinkedList; 
.const [70] = Utf8 java/util/LinkedList 
.const [71] = Utf8 add 
.const [72] = Utf8 (ILjava/lang/Object;)V 
.const [73] = Utf8 java/security/cert/X509Certificate 
.const [74] = Utf8 getSubjectDN 
.const [75] = Utf8 ()Ljava/security/Principal; 
.const [76] = Utf8 java/security/cert/X509Certificate 
.const [77] = Utf8 getIssuerDN 
.const [78] = Utf8 ()Ljava/security/Principal; 
.const [79] = Utf8 java/util/LinkedList 
.const [80] = Utf8 add 
.const [81] = Utf8 (Ljava/lang/Object;)Z 
.const [82] = Utf8 java/util/LinkedList 
.const [83] = Utf8 iterator 
.const [84] = Utf8 ()Ljava/util/Iterator; 
.const [85] = Utf8 java/lang/Object 
.const [86] = Utf8 <init> 
.const [87] = Utf8 ()V 
.const [88] = Utf8 java/lang/IllegalArgumentException 
.const [89] = Utf8 <init> 
.const [90] = Utf8 ()V 
.const [91] = Utf8 java/util/LinkedList 
.const [92] = Utf8 <init> 
.const [93] = Utf8 ()V 
.const [94] = Utf8 com/ibm/oti/security/provider/X509CertificateChain 
.const [95] = Utf8 findCertForSubject 
.const [96] = Utf8 (Ljava/security/Principal;Ljava/util/Collection;)Ljava/security/cert/X509Certificate; 
.const [97] = Utf8 com/ibm/oti/security/provider/X509CertificateChain 
.const [98] = Utf8 chain 
.const [99] = Utf8 Ljava/util/LinkedList; 
.const [100] = Utf8 java/security/Principal 
.const [101] = Utf8 equals 
.const [102] = Utf8 (Ljava/lang/Object;)Z 
.const [103] = Utf8 java/util/Collection 
.const [104] = Utf8 iterator 
.const [105] = Utf8 ()Ljava/util/Iterator; 
.const [106] = Utf8 java/util/Iterator 
.const [107] = Utf8 next 
.const [108] = Utf8 ()Ljava/lang/Object; 
.const [109] = Utf8 java/util/Iterator 
.const [110] = Utf8 hasNext 
.const [111] = Utf8 ()Z 
.const [112] = Utf8 com/ibm/oti/security/provider/X509CertificateChain 
.const [113] = Class [112] 
.const [114] = Utf8 java/lang/Object 
.const [115] = Class [114] 
.const [116] = Utf8 chain 
.const [117] = Utf8 Ljava/util/LinkedList; 
.const [118] = Utf8 Code 
.const [119] = Utf8 <init> 
.const [120] = Utf8 (Ljava/security/cert/X509Certificate;Ljava/util/Collection;)V 
.const [121] = Utf8 iterator 
.const [122] = Utf8 ()Ljava/util/Iterator; 
.const [123] = Utf8 findCertForSubject 
.const [124] = Utf8 (Ljava/security/Principal;Ljava/util/Collection;)Ljava/security/cert/X509Certificate; 
.end class 
