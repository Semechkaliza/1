var App = {
	globals : { 
		button_Tab_mas : document.querySelectorAll(".button_Tab"),
		content_mas : document.querySelectorAll(".content"),
		uLogin: document.querySelector("#Login"),
		uPassword: document.querySelector("#Password"),
		uPassword2: document.querySelector("#Password2"),
		uEmail: document.querySelector("#Email"),
		uPhone: document.querySelector("#Phone"),
		uName: document.querySelector("#Name"),
		uSname: document.querySelector("#Sname")
	},
	init : function(){
		App.globals.uLogin.addEventListener("input",function(){
			var regEx = /^[A-Za-z][A-Za-z0-9_]{4}[A-Za-z0-9_]{0,}$/;
			var falseLogin = document.querySelector(".falseLogin");
			var trueLogin = document.querySelector(".trueLogin");
			if(App.globals.uLogin.value.match(regEx) && App.globals.uLogin.value.length>=5){
				falseLogin.style.display="none";
				trueLogin.style.display="flex";
			}else{
				console.log(2)
				falseLogin.style.display="flex";
				trueLogin.style.display="none";
			}
		})
		App.globals.uPassword.addEventListener("input",function(){
			var regEx = /(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{6,}/g;
			var falsePassword = document.querySelector(".falsePassword");
			var truePassword = document.querySelector(".truePassword");
			if(App.globals.uPassword.value.match(regEx)){
				falsePassword.style.display="none";
				truePassword.style.display="flex";
			}else{
				falsePassword.style.display="flex";
				truePassword.style.display="none";
			}
		})
		App.globals.uPassword2.addEventListener("input",function(){
			var falsePassword = document.querySelector(".falsePassword");
			var truePassword = document.querySelector(".truePassword");
			if(App.globals.uPassword.value == App.globals.uPassword2.value){
				console.log("ee");
				falsePassword2.style.display="none";
				truePassword2.style.display="flex";
			}else{
				console.log("ff")
				falsePassword2.style.display="flex";
				truePassword2.style.display="none";
			}
		})
        App.globals.uEmail.addEventListener("input",function(){
            var regEx = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
            var falseLogin = document.querySelector(".falseEmail");
            var trueLogin = document.querySelector(".trueEmail");
            if(App.globals.uEmail.value.match(regEx) && App.globals.uEmail.value.length>=5){
                falseLogin.style.display="none";
                trueLogin.style.display="flex";
            }else{
                console.log(2)
                falseLogin.style.display="flex";
                trueLogin.style.display="none";
            }
        })
        App.globals.uPhone.addEventListener("input",function(){
            var regEx = /^((9|\+3)[\- ]?)?(\(?\d{3}\)?[\- ]?)?[\d\- ]{7,10}$/;
            var falseLogin = document.querySelector(".falsePhone");
            var trueLogin = document.querySelector(".truePhone");
            if(App.globals.uPhone.value.match(regEx) && App.globals.uPhone.value.length>=5){
                falseLogin.style.display="none";
                trueLogin.style.display="flex";
            }else{
                console.log(2)
                falseLogin.style.display="flex";
                trueLogin.style.display="none";
            }
        })
	}

}

App.init();
