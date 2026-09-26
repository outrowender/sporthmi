.version 50 0 
.class public super [41] 
.super [43] 

.method public annotation [45] : [46] 
    .attribute [44] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [16] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [47] : [48] 
    .attribute [44] .code stack 2 locals 0 
L0:     iload_0 
L1:     iconst_1 
L2:     iand 
L3:     iconst_1 
L4:     if_icmpne L17 
L7:     aload_1 
L8:     ldc [2] 
L10:    invokevirtual [15] 
L13:    pop 
L14:    goto L31 
L17:    iload_0 
L18:    iconst_2 
L19:    iand 
L20:    iconst_2 
L21:    if_icmpne L31 
L24:    aload_1 
L25:    ldc [3] 
L27:    invokevirtual [15] 
L30:    pop 
L31:    iload_0 
L32:    bipush 8 
L34:    iand 
L35:    bipush 8 
L37:    if_icmpne L50 
L40:    aload_1 
L41:    ldc [4] 
L43:    invokevirtual [15] 
L46:    pop 
L47:    goto L102 
L50:    iload_0 
L51:    iconst_4 
L52:    iand 
L53:    iconst_4 
L54:    if_icmpne L67 
L57:    aload_1 
L58:    ldc [5] 
L60:    invokevirtual [15] 
L63:    pop 
L64:    goto L102 
L67:    iload_0 
L68:    bipush 16 
L70:    iand 
L71:    bipush 16 
L73:    if_icmpne L86 
L76:    aload_1 
L77:    ldc [6] 
L79:    invokevirtual [15] 
L82:    pop 
L83:    goto L102 
L86:    iload_0 
L87:    bipush 32 
L89:    iand 
L90:    bipush 32 
L92:    if_icmpne L102 
L95:    aload_1 
L96:    ldc [7] 
L98:    invokevirtual [15] 
L101:   pop 
L102:   iload_0 
L103:   sipush 256 
L106:   iand 
L107:   sipush 256 
L110:   if_icmpne L123 
L113:   aload_1 
L114:   ldc [8] 
L116:   invokevirtual [15] 
L119:   pop 
L120:   goto L204 
L123:   iload_0 
L124:   sipush 512 
L127:   iand 
L128:   sipush 512 
L131:   if_icmpne L144 
L134:   aload_1 
L135:   ldc [9] 
L137:   invokevirtual [15] 
L140:   pop 
L141:   goto L204 
L144:   iload_0 
L145:   sipush 1024 
L148:   iand 
L149:   sipush 1024 
L152:   if_icmpne L165 
L155:   aload_1 
L156:   ldc [10] 
L158:   invokevirtual [15] 
L161:   pop 
L162:   goto L204 
L165:   iload_0 
L166:   sipush 2048 
L169:   iand 
L170:   sipush 2048 
L173:   if_icmpne L186 
L176:   aload_1 
L177:   ldc [11] 
L179:   invokevirtual [15] 
L182:   pop 
L183:   goto L204 
L186:   iload_0 
L187:   sipush 4096 
L190:   iand 
L191:   sipush 4096 
L194:   if_icmpne L204 
L197:   aload_1 
L198:   ldc [12] 
L200:   invokevirtual [15] 
L203:   pop 
L204:   return 
L205:   nop 
L206:   nop 
L207:   nop 
L208:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [17] 
.const [3] = String [18] 
.const [4] = String [19] 
.const [5] = String [20] 
.const [6] = String [21] 
.const [7] = String [22] 
.const [8] = String [23] 
.const [9] = String [24] 
.const [10] = String [25] 
.const [11] = String [26] 
.const [12] = String [27] 
.const [13] = Class [28] 
.const [14] = Class [29] 
.const [15] = Method [30] [31] 
.const [16] = Method [32] [33] 
.const [17] = Utf8 'TX ' 
.const [18] = Utf8 'rx ' 
.const [19] = Utf8 'enter ' 
.const [20] = Utf8 'inside ' 
.const [21] = Utf8 'leave ' 
.const [22] = Utf8 'ERROR ' 
.const [23] = Utf8 'syscall ' 
.const [24] = Utf8 'packet ' 
.const [25] = Utf8 'queue ' 
.const [26] = Utf8 'app ' 
.const [27] = Utf8 callback 
.const [28] = Utf8 java/lang/Object 
.const [29] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [30] = Class [34] 
.const [31] = NameAndType [35] [36] 
.const [32] = Class [37] 
.const [33] = NameAndType [38] [39] 
.const [34] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [35] = Utf8 append 
.const [36] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [37] = Utf8 java/lang/Object 
.const [38] = Utf8 <init> 
.const [39] = Utf8 ()V 
.const [40] = Utf8 de/esolutions/fw/util/transport/debug/TransportDebugTool 
.const [41] = Class [40] 
.const [42] = Utf8 java/lang/Object 
.const [43] = Class [42] 
.const [44] = Utf8 Code 
.const [45] = Utf8 <init> 
.const [46] = Utf8 ()V 
.const [47] = Utf8 decodeState 
.const [48] = Utf8 (ILde/esolutions/fw/util/commons/Buffer;)V 
.end class 
