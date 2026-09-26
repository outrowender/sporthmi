.version 50 0 
.class final super [83] 
.super [85] 
.field private [86] [87] 
.field private [88] [89] 
.field private [90] [91] 
.field private [92] [93] 

.method [95] : [96] 
    .attribute [94] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [12] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [14] 
L9:     aload_0 
L10:    aconst_null 
L11:    putfield [15] 
L14:    aload_0 
L15:    iconst_0 
L16:    putfield [16] 
L19:    aload_0 
L20:    invokespecial [13] 
L23:    return 
L24:    
    .end code 
.end method 

.method [97] : [98] 
    .attribute [94] .code stack 2 locals 3 
L0:     aload_0 
L1:     invokespecial [12] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [14] 
L9:     aload_2 
L10:    ifnull L93 
L13:    aload_0 
L14:    aload_2 
L15:    invokevirtual [10] 
L18:    putfield [16] 
L21:    aload_0 
L22:    aconst_null 
L23:    putfield [15] 
L26:    aload_2 
L27:    invokevirtual [11] 
L30:    astore_3 
L31:    aload_1 
L32:    instanceof [5] 
L35:    ifeq L103 
L38:    aload_3 
L39:    ifnull L103 
L42:    iconst_0 
L43:    istore 4 
L45:    goto L76 
L48:    aload_3 
L49:    invokeinterface [17] 0 
L54:    checkcast [7] 
L57:    astore 5 
L59:    aload 5 
L61:    instanceof [5] 
L64:    ifeq L76 
L67:    aload_0 
L68:    aload 5 
L70:    putfield [15] 
L73:    iconst_1 
L74:    istore 4 
L76:    aload_3 
L77:    invokeinterface [18] 0 
L82:    ifeq L103 
L85:    iload 4 
L87:    ifeq L48 
L90:    goto L103 
L93:    aload_0 
L94:    iconst_0 
L95:    putfield [16] 
L98:    aload_0 
L99:    aconst_null 
L100:   putfield [15] 
L103:   aload_0 
L104:   invokespecial [13] 
L107:   return 
L108:   
    .end code 
.end method 

.method private [99] : [100] 
    .attribute [94] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [19] 
L5:     aload_0 
L6:     getfield [9] 
L9:     ifnull L27 
L12:    aload_0 
L13:    getfield [9] 
L16:    instanceof [8] 
L19:    ifeq L27 
L22:    aload_0 
L23:    iconst_1 
L24:    putfield [19] 
L27:    return 
L28:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [20] 
.const [3] = Class [21] 
.const [4] = Class [22] 
.const [5] = Class [23] 
.const [6] = Class [24] 
.const [7] = Class [25] 
.const [8] = Class [26] 
.const [9] = Field [27] [28] 
.const [10] = Method [29] [30] 
.const [11] = Method [31] [32] 
.const [12] = Method [33] [34] 
.const [13] = Method [35] [36] 
.const [14] = Field [37] [38] 
.const [15] = Field [39] [40] 
.const [16] = Field [41] [42] 
.const [17] = InterfaceMethod [43] [44] 
.const [18] = InterfaceMethod [45] [46] 
.const [19] = Field [47] [48] 
.const [20] = Utf8 java/net/GenericIPMreq 
.const [21] = Utf8 java/lang/Object 
.const [22] = Utf8 java/net/NetworkInterface 
.const [23] = Utf8 java/net/Inet4Address 
.const [24] = Utf8 java/util/Enumeration 
.const [25] = Utf8 java/net/InetAddress 
.const [26] = Utf8 java/net/Inet6Address 
.const [27] = Class [49] 
.const [28] = NameAndType [50] [51] 
.const [29] = Class [52] 
.const [30] = NameAndType [53] [54] 
.const [31] = Class [55] 
.const [32] = NameAndType [56] [57] 
.const [33] = Class [58] 
.const [34] = NameAndType [59] [60] 
.const [35] = Class [61] 
.const [36] = NameAndType [62] [63] 
.const [37] = Class [64] 
.const [38] = NameAndType [65] [66] 
.const [39] = Class [67] 
.const [40] = NameAndType [68] [69] 
.const [41] = Class [70] 
.const [42] = NameAndType [71] [72] 
.const [43] = Class [73] 
.const [44] = NameAndType [74] [75] 
.const [45] = Class [76] 
.const [46] = NameAndType [77] [78] 
.const [47] = Class [79] 
.const [48] = NameAndType [80] [81] 
.const [49] = Utf8 java/net/GenericIPMreq 
.const [50] = Utf8 multiaddr 
.const [51] = Utf8 Ljava/net/InetAddress; 
.const [52] = Utf8 java/net/NetworkInterface 
.const [53] = Utf8 getIndex 
.const [54] = Utf8 ()I 
.const [55] = Utf8 java/net/NetworkInterface 
.const [56] = Utf8 getInetAddresses 
.const [57] = Utf8 ()Ljava/util/Enumeration; 
.const [58] = Utf8 java/lang/Object 
.const [59] = Utf8 <init> 
.const [60] = Utf8 ()V 
.const [61] = Utf8 java/net/GenericIPMreq 
.const [62] = Utf8 init 
.const [63] = Utf8 ()V 
.const [64] = Utf8 java/net/GenericIPMreq 
.const [65] = Utf8 multiaddr 
.const [66] = Utf8 Ljava/net/InetAddress; 
.const [67] = Utf8 java/net/GenericIPMreq 
.const [68] = Utf8 interfaceAddr 
.const [69] = Utf8 Ljava/net/InetAddress; 
.const [70] = Utf8 java/net/GenericIPMreq 
.const [71] = Utf8 interfaceIdx 
.const [72] = Utf8 I 
.const [73] = Utf8 java/util/Enumeration 
.const [74] = Utf8 nextElement 
.const [75] = Utf8 ()Ljava/lang/Object; 
.const [76] = Utf8 java/util/Enumeration 
.const [77] = Utf8 hasMoreElements 
.const [78] = Utf8 ()Z 
.const [79] = Utf8 java/net/GenericIPMreq 
.const [80] = Utf8 isIPV6Address 
.const [81] = Utf8 Z 
.const [82] = Utf8 java/net/GenericIPMreq 
.const [83] = Class [82] 
.const [84] = Utf8 java/lang/Object 
.const [85] = Class [84] 
.const [86] = Utf8 multiaddr 
.const [87] = Utf8 Ljava/net/InetAddress; 
.const [88] = Utf8 interfaceAddr 
.const [89] = Utf8 Ljava/net/InetAddress; 
.const [90] = Utf8 isIPV6Address 
.const [91] = Utf8 Z 
.const [92] = Utf8 interfaceIdx 
.const [93] = Utf8 I 
.const [94] = Utf8 Code 
.const [95] = Utf8 <init> 
.const [96] = Utf8 (Ljava/net/InetAddress;)V 
.const [97] = Utf8 <init> 
.const [98] = Utf8 (Ljava/net/InetAddress;Ljava/net/NetworkInterface;)V 
.const [99] = Utf8 init 
.const [100] = Utf8 ()V 
.end class 
