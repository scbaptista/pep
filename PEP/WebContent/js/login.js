/* LOGIN - MAIN.JS - dp 2017 */

// LOGIN TABS
$(function() {
	var tab = $('.tabs h3 a');
	tab.on('click', function(event) {
		event.preventDefault();
		tab.removeClass('active');
		$(this).addClass('active');
		tab_content = $(this).attr('href');
		$('div[id$="tab-content"]').removeClass('active');
		$(tab_content).addClass('active');
	});
});

// SLIDESHOW
$(function() {
	$('#slideshow > div:gt(0)').hide();
	setInterval(function() {
		$('#slideshow > div:first')
		.fadeOut(1000)
		.next()
		.fadeIn(1000)
		.end()
		.appendTo('#slideshow');
	}, 3850);
});

// CUSTOM JQUERY FUNCTION FOR SWAPPING CLASSES
(function($) {
	'use strict';
	$.fn.swapClass = function(remove, add) {
		this.removeClass(remove).addClass(add);
		return this;
	};
}(jQuery));

// SHOW/HIDE PANEL ROUTINE (needs better methods)
// I'll optimize when time permits.
$(function() {
	$('.agree,.forgot, #toggle-terms, .log-in, .sign-up').on('click', function(event) {
		event.preventDefault();
		var terms = $('.terms'),
        recovery = $('.recovery'),
        close = $('#toggle-terms'),
        arrow = $('.tabs-content .fa');
		if ($(this).hasClass('agree') || $(this).hasClass('log-in') || ($(this).is('#toggle-terms')) && terms.hasClass('open')) {
			if (terms.hasClass('open')) {
				terms.swapClass('open', 'closed');
				close.swapClass('open', 'closed');
				arrow.swapClass('active', 'inactive');
			} else {
				if ($(this).hasClass('log-in')) {
					return;
				}
				terms.swapClass('closed', 'open').scrollTop(0);
				close.swapClass('closed', 'open');
				arrow.swapClass('inactive', 'active');
			}
		}
		else if ($(this).hasClass('forgot') || $(this).hasClass('sign-up') || $(this).is('#toggle-terms')) {
			if (recovery.hasClass('open')) {
				recovery.swapClass('open', 'closed');
				close.swapClass('open', 'closed');
				arrow.swapClass('active', 'inactive');
			} else {
				if ($(this).hasClass('sign-up')) {
					return;
				}
				recovery.swapClass('closed', 'open');
				close.swapClass('closed', 'open');
				arrow.swapClass('inactive', 'active');
			}
		}
	});
});

// DISPLAY MSSG
$(function() {
	$('.recovery .button').on('click', function(event) {
		event.preventDefault();
		$('.recovery .mssg').addClass('animate');

		var user_recover = document.getElementById('user_recover').value;
		var json = {'user':user_recover};
		var token = btoa(unescape(encodeURIComponent(JSON.stringify(json))));
		var valResponse = ajax('user',token,'6');
		console.log('result -> ',valResponse);
		if(valResponse != null){
			var obj = JSON.parse(valResponse);
			console.log('obj -> ',obj);

			if(obj[0].val == 1){
					$('.recovery').swapClass('open', 'closed');
					$('#toggle-terms').swapClass('open', 'closed');
					$('.tabs-content .fa').swapClass('active', 'inactive');
					$('.recovery .mssg').removeClass('animate');
			}
		}

	});
});

// DISABLE SUBMIT FOR DEMO
$(function() {
	$('.button').on('click', function(event) {
		$(this).stop();
		event.preventDefault();
		return false;
	});
});




$('.form').find('input, textarea').on('keyup blur focus', function (e) {
  
	var $this = $(this),
		label = $this.prev('label');
  
	  if (e.type === 'keyup') {
		if ($this.val() === '') {
			label.removeClass('active highlight');
		  } else {
			label.addClass('active highlight');
		  }
	  } else if (e.type === 'blur') {
		if( $this.val() === '' ) {
		  label.removeClass('active highlight'); 
		} else {
		  label.removeClass('highlight');   
		}   
	  } else if (e.type === 'focus') {
		
		if( $this.val() === '' ) {
		  label.removeClass('highlight'); 
		} 
		else if( $this.val() !== '' ) {
		  label.addClass('highlight');
		}
	  }
  
});
  
$('.tab a').on('click', function (e) {
	
	e.preventDefault();
	
	$(this).parent().addClass('active');
	$(this).parent().siblings().removeClass('active');
	
	target = $(this).attr('href');
  
	$('.tab-content > div').not(target).hide();
	
	$(target).fadeIn(600);
	
});
  
	
var dologin = function (){
  
	var user_login = document.getElementById('user_login').value;
	var user_pass = document.getElementById('user_pass').value;
  
	var json = {'user_login':user_login};
	var token = btoa(unescape(encodeURIComponent(JSON.stringify(json))));

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {   
     if (this.readyState == 4 && this.status == 200) {
    	 if(this.responseText == null || this.responseText == "[]"){
					console.log('Utilizador não existe');
    	 }else{
			var obj = JSON.parse(this.responseText);
			if(obj[0].ativo == 1){
				if(obj[0].rgpd){
					sessionStorage.setItem("appSession", this.responseText);
					var decryptPass = decryptValue(obj[0].pass_word);
					if(user_pass == decryptPass){
						if(obj[0].user_type_id == 1 || obj[0].user_type_id == 2){
								window.location.href = "admin.html";
						}if (obj[0].user_type_id == 4) {
							window.location.href = "professor.html";
						} if (obj[0].user_type_id == 3) {
							window.location.href = "aluno.html";
						} else {
							console.log('Erro.....type');
						}
					} else{
						console.log('Erro.....pass');
					}
				}else{
					console.log('Erro.....rgpd');
				}
			}else{
				console.log('Utilizador não ativo');
			}
			
    	    
    	 }      
    }
  
  };

  xhttp.open("POST", "http://localhost:8080/PEP/serv/login?op=1&token="+token, false);
  xhttp.send();

  }
  
  
  var setCheckboxAluno = function() {
  
	  if ($('#professor_id').is(":checked"))
	  {
		$('#professor_id').prop('checked', false);
	  }
  }
  
  var setCheckboxProfessor = function() {
  
	  if ($('#aluno_id').is(":checked") )
	  {
		$('#aluno_id').prop('checked', false);
	  }
	  
  }
  
  
var doregist = function(){
		var user_type = null;
		var user_name = null;
		var user_email = null;
		var username = null;
		var user_pass = null;
		var rgpd = null;
		var ativo = null;
		var validate = null;
	  
	  if ($('#aluno_id').is(":checked"))
	  {
			user_type = 3;
			ativo = 1;
			rgpd = true;
	  }
	  
	  if ($('#professor_id').is(":checked"))
	  {
			user_type = 4;
			ativo = 0;
			rgpd = true;
		}

		user_name = document.getElementById("user_name_r").value;
		user_email = document.getElementById("user_email").value;
		username = document.getElementById('username').value;
		user_pass = document.getElementById('user_pass_r').value;
		

		if(user_type == null || user_type == ""){
			console.log('Erro.....type');
		}else if(user_name == null || user_name == ""){
			console.log('Erro.....name');
		}else if(user_email == null || user_email == ""){
			console.log('Erro.....email');
		}else	if(username == null || username == ""){
			console.log('Erro.....username');
		}else if(user_pass == null || user_pass == ""){
			console.log('Erro.....pass');
		}else if(!$('#agree_terms').is(":checked")){
			console.log('Erro.....termos');
		}else{
			validate = true;
		}
									
									
							
	  if(validate){
			var json = {'user_name':user_name,'user_email':user_email, 'user_type':user_type, 'username':username, 'user_pass':encryptValue(user_pass), 'ativo':ativo, 'rgpd':rgpd};
			var token = btoa(unescape(encodeURIComponent(JSON.stringify(json))));
									
			var xhttp = new XMLHttpRequest();
			xhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
				console.log(this.responseText);
			//      document.getElementById('msgResult').innerHTML = msg;
				}
			};
			
			xhttp.open("POST", warUrl+"serv/user?op=2&token="+token, false);
			xhttp.send();
		}
  
	
  
}