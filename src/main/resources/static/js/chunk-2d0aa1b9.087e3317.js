(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d0aa1b9"],{1037:function(t,e,n){"use strict";n.r(e);var s=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("a-result",{attrs:{status:"success",title:t.msg,"sub-title":t.description},scopedSlots:t._u([{key:"extra",fn:function(){return[n("a-button",{staticStyle:{"margin-left":"8px"},attrs:{size:"large"},on:{click:t.goHomeHandle}},[t._v("马上登录")])]},proxy:!0}])})},a=[],r=(n("a4d3"),n("e01a"),n("99af"),{name:"RegisterResult",data:function(){return{description:"",form:{}}},computed:{msg:function(){var t=this.form&&this.form.nickname||"xxx";return"您的账户：".concat(t," --\x3e 注册成功")}},created:function(){this.form=this.$route.params,this.description="---账号：".concat(this.$route.params.username,"  ---  密码").concat(this.$route.params.password,"---")},methods:{goHomeHandle:function(){this.$router.push({name:"login"})}}}),o=r,i=n("2877"),c=Object(i["a"])(o,s,a,!1,null,"df10f8f8",null);e["default"]=c.exports}}]);
//# sourceMappingURL=chunk-2d0aa1b9.087e3317.js.map