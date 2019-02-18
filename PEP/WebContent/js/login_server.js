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

  var json = {'user_login':user_login,'user_pass':user_pass};

  var token = btoa(unescape(encodeURIComponent(JSON.stringify(json))));
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
   console.log(this);
   
     if (this.readyState == 4 && this.status == 200) {
    	 if(this.responseText == null){
    		 
    	 }else{
    	      var obj = JSON.parse(this.responseText);
    	      sessionStorage.setItem("appSession", this.responseText);
            console.log(sessionStorage.getItem("appSession"));
            if(obj[0].user_type_id == 1 || obj[0].user_type_id == 2){
                window.location.href = "admin.html";
            }if (obj[0].user_type_id == 4) {
              window.location.href = "professor.html";
            } if (obj[0].user_type_id == 3) {
              window.location.href = "aluno.html";
            } else {
              console.log('Erro.....');
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
	var user_type;
	var ativo;
	
	if ($('#aluno_id').is(":checked"))
	{
	  user_type = 3;
	  ativo = true;
	}
	
	if ($('#professor_id').is(":checked"))
	{
	  user_type = 4;
	  ativo = false;
	}
	
  var user_name = document.getElementById("user_name").value;
  var user_email = document.getElementById("user_email").value;
  var username = document.getElementById('username').value;
  var user_pass = document.getElementById('user_pass').value;

//  var name = firstname + " " + lastname;
//
//
  var json = {'user_name':user_name,'user_email':user_email, 'user_type':user_type, 'username':username, 'user_pass':user_pass, 'ativo':ativo};
  var token = btoa(unescape(encodeURIComponent(JSON.stringify(json))));

  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      console.log(this.responseText);
//      document.getElementById('msgResult').innerHTML = msg;
    }
  };

  xhttp.open("POST", "http://localhost:8080/PEP/serv/user?op=2&token="+token, false);
  xhttp.send();

}