var App = {
	globals : { 
		button_Tab_mas : document.querySelectorAll(".button_Tab"),
		content_mas : document.querySelectorAll(".content"),
		uLogin: document.querySelector("#Login"),
		uPassword: document.querySelector("#Password"),
		uPassword2: document.querySelector("#Password2"),
	},
	init : function(){
		var len = App.globals.button_Tab_mas.length;
		for(var i = 0; i<len; i++){
			App.globals.button_Tab_mas[i].addEventListener("click", function(e){
				App.click_on_tubsButton(e.currentTarget);
			})
		}
		App.globals.uLogin.addEventListener("input",function(){
			var regEx = /^[A-Za-z][A-Za-z0-9_]{4}[A-Za-z0-9_]{0,}$/;
			var falseLogin = document.querySelector(".falseLogin");
			var trueLogin = document.querySelector(".trueLogin");
			if(App.globals.uLogin.value.match(regEx)){
				falseLogin.style.display="none";
				trueLogin.style.display="flex";
			}else{
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
			var falsePassword2 = document.querySelector(".falsePassword2");
			var truePassword2 = document.querySelector(".truePassword2");
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
	},
	click_on_tubsButton : function(click_button){
		console.log(click_button)
		var len = App.globals.button_Tab_mas.length;
		for(var i = 0; i<len; i++){
			App.globals.content_mas[i].className = App.globals.content_mas[i].className.replace("content content_click", "content");
		};
		for(var i = 0; i<len; i++){
			App.globals.button_Tab_mas[i].className = App.globals.button_Tab_mas[i].className.replace("click_button", "")
		};
		for(var i = 0; i<len; i++){
			if(click_button == App.globals.button_Tab_mas[i]){
				App.globals.button_Tab_mas[i].classList.toggle("click_button");
				App.globals.content_mas[i].classList.toggle("content_click");
				break;
			}
		}
	}
}

App.init();
