/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function ccheck()
{
uid=document.f1.uid.value;
cpass=document.f1.cpass.value;

if(uid=="" || uid==null)
{
alert("Plz. Enter Your User ID");
document.f1.uid.focus();
return false;
}
if(cpass=="" || cpass==null)
{
alert("Plz. Enter Your Password");
document.f1.cpass.focus();
return false;
}
return true;
}

