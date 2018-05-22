
// contiudo para login 


var  btnLoginLogout  = function(){

	var btn = document.getElementById('crt-login');

	if(btn.textContent == "Logout"){
		window.location.href="../index.html";
	}else{
		window.location.href="login.html";
	}

	

}


var validateLogin = function (){
	
		var email = document.getElementById("email_login").value; 
		var pass = document.getElementById("pass_login").value; 


		if( email==""    || email.indexOf('@')==-1  || email.indexOf('.')==-1 )	{
				document.getElementById("erroDivLogin").innerText  = "Por favor, informe um EMAIL válido!";
			
		}else{
			if (email=="gestao@teste.com" && pass=="admin") {
				window.location.href="home.html?user=admin";
			}else if(email=="aluno@teste.com" && pass=="teste") {
				window.location.href="alunos_home.html?user=aluno";
			}else{
				document.getElementById("erroDivLogin").innerText  = "Sua password ou email estão errados";
			}
		}

	
	
}


var newUser = function (){
	
	var name = document.getElementById("name").value; 
	var pass = document.getElementById("pass").value; 
	var passconf = document.getElementById("pass_conf").value;
	var email = document.getElementById("email").value;


	if( email==""    || email.indexOf('@')==-1  || email.indexOf('.')==-1 )	{
			document.getElementById("erroDivLogin").innerText  = "Por favor, informe um EMAIL válido!";
		
	}else if(pass == passconf){
		console.log('olaqwqw');
		var token = '{"name":"'+name+'","email":"'+email+'","pass":"'+pass+'"}';
		var tokenfinal = btoa(unescape(encodeURIComponent(token)));
	
		  var xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		      console.log(this.responseText);
		    
		  };
		  xhttp.open("POST", "http://localhost:8081/PEP/serv/user?op=newuser&token="+tokenfinal, true);
		  xhttp.send();
		  
		
	}else{
		document.getElementById("erroDivLogin").innerText  = "As passwords não são iguais";
	}



}

var onLoadLoginPage = function (){
	$("#pass_login").keyup(function(event) {
	    if (event.keyCode === 13) {
	        validateLogin();
	    }
	});
}


// gestao do index page do projecto
var loadPageIndex = function (){
	
	var queryString = window.location.search.substring(1);
    var varArray = queryString.split("="); //eg. index.html?msg=1
    var token = varArray[1];

    document.getElementById("userNameSession").innerText  = token;
    document.getElementById("crt-login").innerText = "Logout";
    

    if(token == null){
    	document.getElementById("hist").children[0].style.display = "none";
    	document.getElementById("news").children[0].style.display = "none";
    	document.getElementById("port").children[0].style.display = "none";
    	document.getElementById("userFromProfile").children[0].style.display = "none";
    	document.getElementById("crt-login").innerText = "Login";	
    }else{
    	if(token == 'aluno'){
    		document.getElementById("nameUser").innerText = token;	
    		document.getElementById("sessoes_admin").children[0].style.display = "none";
    		setNewPage('../page/sessoes_aluno.html');

    	}
    	if(token == 'admin'){
    		document.getElementById("sessoes_aluno").children[0].style.display = "none";
    		setNewPage('../page/sessoes_admin.html');
    	}
    }


    


}


// contiudo geral
// esta funcao altera o contiudo do elemento com id pages
var setNewPage = function(url){
	document.getElementById("pages").setAttribute('data', url);
}

