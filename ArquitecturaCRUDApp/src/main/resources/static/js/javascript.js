alert('hola')


document.getElementById('btn_iniciar-sesion').addEventListener("click", login)
document.getElementById('btn_Registrarse').addEventListener("click", register)

//Declaración de variables
var caja2 = document.querySelector(".caja2");
var formulario_login = document.querySelector(".formulario_login");
var formulario_register = document.querySelector(".formulario_Register");
var caja1_login = document.querySelector(".caja1-login");
var caja1_register = document.querySelector(".caja1-register");




function login(){
	
	formulario_register.style.display = "none";
	caja2.style.left = "10px";
	formulario_login.style.display ="block";
	caja1_register.style.opacity = "1";
	caja1_login.style.opacity = "0";
		
}

function register(){
	
	formulario_register.style.display = "block";
	caja2.style.left = "410px";
	formulario_login.style.display ="none";
	caja1_register.style.opacity = "0";
	caja1_login.style.opacity = "1";
}

//SLIDER


window.addEventListener('load', function(){
	console.log('El contenido ha cargado');

	document.slider.src = 'imagenes/slider1.jpg'
});