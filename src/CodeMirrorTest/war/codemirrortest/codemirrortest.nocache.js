function codemirrortest(){var Q='',wb='" for "gwt:onLoadErrorFn"',ub='" for "gwt:onPropertyErrorFn"',db='"><\/script>',fb='#',Tb='.cache.html',hb='/',Ob='08B6D218077B44D83D20179C66FF7C70',Pb='30097B69F3C570BD834572CA14C08E5B',Qb='9DA41B7373FDB582CAF21647BA37C0E8',Sb=':',ob='::',ec='<script defer="defer">codemirrortest.onInjectionDone(\'codemirrortest\')<\/script>',cb='<script id="',cc='<script language="javascript" src="',rb='=',gb='?',tb='Bad handler "',ac='DOMContentLoaded',Rb='FAAA200D26BE5F9A22117C8EF8A8626F',eb='SCRIPT',bb='__gwt_marker_codemirrortest',ib='base',$='baseUrl',U='begin',T='bootstrap',kb='clear.cache.gif',bc='cm/codemirror.js',dc='cm/codemirror.js"><\/script>',R='codemirrortest',ab='codemirrortest.nocache.js',nb='codemirrortest::',qb='content',Ub='css/docs.css',$b='css/lineno.css',Z='end',Ib='gecko',Jb='gecko1_8',V='gwt.codesvr=',W='gwt.hosted=',X='gwt.hybrid',_b='gwt/standard/standard.css',vb='gwt:onLoadErrorFn',sb='gwt:onPropertyErrorFn',pb='gwt:property',Zb='head',Mb='hosted.html?codemirrortest',Yb='href',Hb='ie6',Gb='ie8',xb='iframe',jb='img',yb="javascript:''",Vb='link',Lb='loadExternalRefs',lb='meta',Ab='moduleRequested',Y='moduleStartup',Fb='msie',mb='name',Cb='opera',zb='position:absolute;width:0;height:0;border:none',Wb='rel',Eb='safari',_='script',Nb='selectingPermutation',S='startup',Xb='stylesheet',Kb='unknown',Bb='user.agent',Db='webkit';var m=window,n=document,o=m.__gwtStatsEvent?function(a){return m.__gwtStatsEvent(a)}:null,p=m.__gwtStatsSessionId?m.__gwtStatsSessionId:null,q,r,s,t=Q,u={},v=[],w=[],x=[],y=0,z,A;o&&o({moduleName:R,sessionId:p,subSystem:S,evtGroup:T,millis:(new Date).getTime(),type:U});if(!m.__gwt_stylesLoaded){m.__gwt_stylesLoaded={}}if(!m.__gwt_scriptsLoaded){m.__gwt_scriptsLoaded={}}function B(){var b=false;try{var c=m.location.search;return (c.indexOf(V)!=-1||(c.indexOf(W)!=-1||m.external&&m.external.gwtOnLoad))&&c.indexOf(X)==-1}catch(a){}B=function(){return b};return b}
function C(){if(q&&r){var b=n.getElementById(R);var c=b.contentWindow;if(B()){c.__gwt_getProperty=function(a){return I(a)}}codemirrortest=null;c.gwtOnLoad(z,R,t,y);o&&o({moduleName:R,sessionId:p,subSystem:S,evtGroup:Y,millis:(new Date).getTime(),type:Z})}}
function D(){if(u[$]){t=u[$];return t}var e;var f=n.getElementsByTagName(_);for(var g=0;g<f.length;++g){if(f[g].src.indexOf(ab)!=-1){e=f[g]}}if(!e){var h=bb;var i;n.write(cb+h+db);i=n.getElementById(h);e=i&&i.previousSibling;while(e&&e.tagName!=eb){e=e.previousSibling}}function j(a){var b=a.lastIndexOf(fb);if(b==-1){b=a.length}var c=a.indexOf(gb);if(c==-1){c=a.length}var d=a.lastIndexOf(hb,Math.min(c,b));return d>=0?a.substring(0,d+1):Q}
;if(e&&e.src){t=j(e.src)}if(t==Q){var k=n.getElementsByTagName(ib);if(k.length>0){t=k[k.length-1].href}else{t=j(n.location.href)}}else if(t.match(/^\w+:\/\//)){}else{var l=n.createElement(jb);l.src=t+kb;t=j(l.src)}if(i){i.parentNode.removeChild(i)}return t}
function E(){var b=document.getElementsByTagName(lb);for(var c=0,d=b.length;c<d;++c){var e=b[c],f=e.getAttribute(mb),g;if(f){f=f.replace(nb,Q);if(f.indexOf(ob)>=0){continue}if(f==pb){g=e.getAttribute(qb);if(g){var h,i=g.indexOf(rb);if(i>=0){f=g.substring(0,i);h=g.substring(i+1)}else{f=g;h=Q}u[f]=h}}else if(f==sb){g=e.getAttribute(qb);if(g){try{A=eval(g)}catch(a){alert(tb+g+ub)}}}else if(f==vb){g=e.getAttribute(qb);if(g){try{z=eval(g)}catch(a){alert(tb+g+wb)}}}}}}
function H(a,b){var c=x;for(var d=0,e=a.length-1;d<e;++d){c=c[a[d]]||(c[a[d]]=[])}c[a[e]]=b}
function I(a){var b=w[a](),c=v[a];if(b in c){return b}var d=[];for(var e in c){d[c[e]]=e}if(A){A(a,d,b)}throw null}
var J;function K(){if(!J){J=true;var a=n.createElement(xb);a.src=yb;a.id=R;a.style.cssText=zb;a.tabIndex=-1;n.body.appendChild(a);o&&o({moduleName:R,sessionId:p,subSystem:S,evtGroup:Y,millis:(new Date).getTime(),type:Ab});a.contentWindow.location.replace(t+M)}}
w[Bb]=function(){var b=navigator.userAgent.toLowerCase();var c=function(a){return parseInt(a[1])*1000+parseInt(a[2])};if(b.indexOf(Cb)!=-1){return Cb}else if(b.indexOf(Db)!=-1){return Eb}else if(b.indexOf(Fb)!=-1){if(document.documentMode>=8){return Gb}else{var d=/msie ([0-9]+)\.([0-9]+)/.exec(b);if(d&&d.length==3){var e=c(d);if(e>=6000){return Hb}}}}else if(b.indexOf(Ib)!=-1){var d=/rv:([0-9]+)\.([0-9]+)/.exec(b);if(d&&d.length==3){if(c(d)>=1008)return Jb}return Ib}return Kb};v[Bb]={gecko:0,gecko1_8:1,ie6:2,ie8:3,opera:4,safari:5};codemirrortest.onScriptLoad=function(){if(J){r=true;C()}};codemirrortest.onInjectionDone=function(){q=true;o&&o({moduleName:R,sessionId:p,subSystem:S,evtGroup:Lb,millis:(new Date).getTime(),type:Z});C()};E();D();var L;var M;if(B()){if(m.external&&(m.external.initModule&&m.external.initModule(R))){m.location.reload();return}M=Mb;L=Q}o&&o({moduleName:R,sessionId:p,subSystem:S,evtGroup:T,millis:(new Date).getTime(),type:Nb});if(!B()){try{H([Hb],Ob);H([Gb],Ob);H([Ib],Pb);H([Jb],Pb);H([Cb],Qb);H([Eb],Rb);L=x[I(Bb)];var N=L.indexOf(Sb);if(N!=-1){y=Number(L.substring(N+1));L=L.substring(0,N)}M=L+Tb}catch(a){return}}var O;function P(){if(!s){s=true;if(!__gwt_stylesLoaded[Ub]){var a=n.createElement(Vb);__gwt_stylesLoaded[Ub]=a;a.setAttribute(Wb,Xb);a.setAttribute(Yb,t+Ub);n.getElementsByTagName(Zb)[0].appendChild(a)}if(!__gwt_stylesLoaded[$b]){var a=n.createElement(Vb);__gwt_stylesLoaded[$b]=a;a.setAttribute(Wb,Xb);a.setAttribute(Yb,t+$b);n.getElementsByTagName(Zb)[0].appendChild(a)}if(!__gwt_stylesLoaded[_b]){var a=n.createElement(Vb);__gwt_stylesLoaded[_b]=a;a.setAttribute(Wb,Xb);a.setAttribute(Yb,t+_b);n.getElementsByTagName(Zb)[0].appendChild(a)}C();if(n.removeEventListener){n.removeEventListener(ac,P,false)}if(O){clearInterval(O)}}}
if(n.addEventListener){n.addEventListener(ac,function(){K();P()},false)}var O=setInterval(function(){if(/loaded|complete/.test(n.readyState)){K();P()}},50);o&&o({moduleName:R,sessionId:p,subSystem:S,evtGroup:T,millis:(new Date).getTime(),type:Z});o&&o({moduleName:R,sessionId:p,subSystem:S,evtGroup:Lb,millis:(new Date).getTime(),type:U});if(!__gwt_scriptsLoaded[bc]){__gwt_scriptsLoaded[bc]=true;document.write(cc+t+dc)}n.write(ec)}
codemirrortest();