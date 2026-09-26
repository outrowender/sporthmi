.version 50 0 
.class public super [73] 
.super [75] 

.method public annotation [77] : [78] 
    .attribute [76] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [19] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [79] : [80] 
    .attribute [76] .code stack 4 locals 7 
L0:     aload_1 
L1:     ldc [2] 
L3:     ldc [3] 
L5:     invokevirtual [13] 
L8:     pop 
L9:     aload_0 
L10:    invokevirtual [14] 
L13:    astore_3 
L14:    aload_0 
L15:    invokevirtual [15] 
L18:    astore 4 
L20:    aload_3 
L21:    ifnull L30 
L24:    aload_3 
L25:    arraylength 
L26:    iconst_1 
L27:    if_icmpgt L33 
L30:    aload 4 
L32:    areturn 
        .catch [6] from L33 to L116 using L117 
L33:    iconst_0 
L34:    istore 5 
L36:    iconst_0 
L37:    istore 6 
L39:    new [21] 
L42:    dup 
L43:    invokespecial [20] 
L46:    astore 7 
L48:    iconst_0 
L49:    istore 8 
L51:    iload 8 
L53:    aload_3 
L54:    arraylength 
L55:    if_icmpge L111 
L58:    aload_3 
L59:    iload 8 
L61:    iaload 
L62:    iconst_m1 
L63:    if_icmpne L77 
L66:    aload 7 
L68:    ldc [5] 
L70:    invokevirtual [16] 
L73:    pop 
L74:    goto L105 
L77:    iload 6 
L79:    aload_3 
L80:    iload 8 
L82:    iaload 
L83:    iadd 
L84:    istore 6 
L86:    aload 7 
L88:    aload 4 
L90:    iload 5 
L92:    iload 6 
L94:    invokevirtual [17] 
L97:    invokevirtual [16] 
L100:   pop 
L101:   iload 6 
L103:   istore 5 
L105:   iinc 8 1 
L108:   goto L51 
L111:   aload 7 
L113:   invokevirtual [18] 
L116:   areturn 
L117:   astore 5 
L119:   aload_1 
L120:   ldc [7] 
L122:   ldc [8] 
L124:   invokevirtual [13] 
L127:   pop 
L128:   aload 4 
L130:   areturn 
L131:   nop 
L132:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 1078071040 
.const [3] = String [22] 
.const [4] = Class [23] 
.const [5] = String [24] 
.const [6] = Class [25] 
.const [7] = Int -1601830656 
.const [8] = String [26] 
.const [9] = Class [27] 
.const [10] = Class [28] 
.const [11] = Class [29] 
.const [12] = Class [30] 
.const [13] = Method [31] [32] 
.const [14] = Method [33] [34] 
.const [15] = Method [35] [36] 
.const [16] = Method [37] [38] 
.const [17] = Method [39] [40] 
.const [18] = Method [41] [42] 
.const [19] = Method [43] [44] 
.const [20] = Method [45] [46] 
.const [21] = Class [47] 
.const [22] = Utf8 '[ConcatenatedSMS#checkEllipsis]' 
.const [23] = Utf8 java/lang/StringBuffer 
.const [24] = Utf8 '(...)' 
.const [25] = Utf8 java/lang/Exception 
.const [26] = Utf8 '[ConcatenatedSMS#checkEllipsis] Modification of the bodytext failed. Return original body!' 
.const [27] = Utf8 java/lang/Object 
.const [28] = Utf8 de/audi/atip/log/LogChannel 
.const [29] = Utf8 org/dsi/ifc/messaging/MessageDetails 
.const [30] = Utf8 java/lang/String 
.const [31] = Class [48] 
.const [32] = NameAndType [49] [50] 
.const [33] = Class [51] 
.const [34] = NameAndType [52] [53] 
.const [35] = Class [54] 
.const [36] = NameAndType [55] [56] 
.const [37] = Class [57] 
.const [38] = NameAndType [58] [59] 
.const [39] = Class [60] 
.const [40] = NameAndType [61] [62] 
.const [41] = Class [63] 
.const [42] = NameAndType [64] [65] 
.const [43] = Class [66] 
.const [44] = NameAndType [67] [68] 
.const [45] = Class [69] 
.const [46] = NameAndType [70] [71] 
.const [47] = Utf8 java/lang/StringBuffer 
.const [48] = Utf8 de/audi/atip/log/LogChannel 
.const [49] = Utf8 log 
.const [50] = Utf8 (ILjava/lang/String;)Z 
.const [51] = Utf8 org/dsi/ifc/messaging/MessageDetails 
.const [52] = Utf8 getSegmentLengths 
.const [53] = Utf8 ()[I 
.const [54] = Utf8 org/dsi/ifc/messaging/MessageDetails 
.const [55] = Utf8 getBody 
.const [56] = Utf8 ()Ljava/lang/String; 
.const [57] = Utf8 java/lang/StringBuffer 
.const [58] = Utf8 append 
.const [59] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [60] = Utf8 java/lang/String 
.const [61] = Utf8 substring 
.const [62] = Utf8 (II)Ljava/lang/String; 
.const [63] = Utf8 java/lang/StringBuffer 
.const [64] = Utf8 toString 
.const [65] = Utf8 ()Ljava/lang/String; 
.const [66] = Utf8 java/lang/Object 
.const [67] = Utf8 <init> 
.const [68] = Utf8 ()V 
.const [69] = Utf8 java/lang/StringBuffer 
.const [70] = Utf8 <init> 
.const [71] = Utf8 ()V 
.const [72] = Utf8 de/audi/app/messaging/core/viewmessage/ConcatenatedSMS 
.const [73] = Class [72] 
.const [74] = Utf8 java/lang/Object 
.const [75] = Class [74] 
.const [76] = Utf8 Code 
.const [77] = Utf8 <init> 
.const [78] = Utf8 ()V 
.const [79] = Utf8 checkEllipsis 
.const [80] = Utf8 (Lorg/dsi/ifc/messaging/MessageDetails;Lde/audi/atip/log/LogChannel;)Ljava/lang/String; 
.end class 
