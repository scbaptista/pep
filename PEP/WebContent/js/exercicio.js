var getMsgExercicioModal = function(idModal, msg){
	console.log('modal',msg);
  // Get the modal
  var modal = document.getElementById(idModal);
  modal.style.display = "block";

  document.getElementById('msgExercicioResult').innerHTML = msg;

  // When the user clicks anywhere outside of the modal, close it
  window.onclick = function(event) {
      if (event.target == modal) {
      	getListExerciciosBtn();
        modal.style.display = "none";

      }
  }
}

var getExercicioMsgCanselBtn = function(idModal){
  var modal = document.getElementById(idModal);
  getListExerciciosBtn();
  modal.style.display = "none";
}

var getListExerciciosBtn = function(idModal){
  console.log('getListExerciciosBtn');
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      var r = this.responseText;
      var obj = JSON.parse(this.responseText);

      var resutHeader = '<div class="table-wrapper-scroll-y"><table class="table table-bordered table-striped">'
      +'<tbody><tr>'
      +'<th style="display:none;"><i class="icon_profile" id="idExer"></i> ID</th>'
      +'<th><i class="icon_profile"></i> Designação</th>'
      +'<th><i class="icon_profile"></i> Nivel de Dificuldade</th>'
      +'<th><i class="icon_cogs"></i></th>'
      +'</tr>';
      
      var resutHeaderAluno = '<div class="table-wrapper-scroll-y"><table class="table table-bordered table-striped">'
          +'<tbody><tr>'
          +'<th style="display:none;"><i class="icon_profile" id="idExer"></i> ID</th>'
          +'<th><i class="icon_profile"></i> Designação</th>'
          +'<th><i class="icon_cogs"></i></th>'
          +'</tr>';

      var resultContent = '';

      var resultFooter = '</tbody> </table></div>';
      var sessionVal = JSON.parse(sessionStorage.getItem("appSession"));
      
      if (sessionVal[0].user_type_id == 3) {
        for (i in obj) {
          resultContent = resultContent
          +'<tr>'
              +'<td style="display:none;">'+obj[i].id+'</td>'
              +'<td>'+obj[i].designacao+'</td>'
              +'<td>'
                +'<div class="btn-group">'
                  +'<a class="btn btn-primary" href="#" onclick="javascript:runExercicioBtn('+obj[i].id+');" id="'+obj[i].id+'"><i class="fas fa-arrow-alt-circle-right"></i></a>'
                +'</div>'
              +'</td>'
          +'</tr>';   
        }
        var resultFinal = (resutHeaderAluno + resultContent + resultFooter);
        console.log(obj.length);
        console.log(obj);
        if (obj.length == 0) {
        	 document.getElementById('tableExercicioAluno').innerHTML = 'No results ....';
        }else{
          document.getElementById('tableExercicioAluno').innerHTML = resultFinal;
        }
      }else{

        for (i in obj) {
          resultContent = resultContent
          +'<tr>'
              +'<td style="display:none;">'+obj[i].id+'</td>'
              +'<td>'+obj[i].designacao+'</td>'
              +'<td>'+obj[i].dificuldade+'</td>'
              +'<td>'
                +'<div class="btn-group">'
                  +'<a class="btn btn-primary" href="#" onclick="javascript:editExercicioBtn('+obj[i].id+');" id="'+obj[i].id+'"><i class="fa fa-edit"></i></a>'
                  +'<a class="btn btn-danger" href="#" onclick="javascript:removeExercicioBtn('+obj[i].id+');" id="'+obj[i].id+'"><i class="fa fa-trash"></i></a>'
                  +'<a class="btn btn-primary" href="#" onclick="javascript:viewExercicioBtn('+obj[i]+');" id="'+obj[i].id+'"><i class="fa fa-eye"></i></a>'
                +'</div>'
              +'</td>'
          +'</tr>';   
        }
        var resultFinal = (resutHeader + resultContent + resultFooter);
        console.log(obj.length);
        console.log(obj);
        if (obj.length == 0) {
        	 document.getElementById('tableExercicio').innerHTML = 'No results ....';
        }else{
        	document.getElementById('tableExercicio').innerHTML = resultFinal;
        }
        
      } 

    }
  };

  xhttp.open("POST", "http://localhost:8080/PEP/serv/exercicio?op=5", false);
  xhttp.send();
}

var addExercicioBtn = function(idModal){
  var designacao = document.getElementById("exDesg").value;
  var dica = document.getElementById("exDica").value;
  var solucao = document.getElementById('exSolucao').value;
  var enunciado = document.getElementById("exEnunciado").value;
  var dificuldade = document.getElementById('exNivel').value;

  var json = {'designacao':designacao, 'dica':dica, 'solucao':solucao, 'enunciado':enunciado,  'dificuldade':dificuldade};

  var token = btoa(unescape(encodeURIComponent(JSON.stringify(json))));

  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      console.log(this.responseText);
      var obj = JSON.parse(this.responseText);
      var modal = document.getElementById(idModal);
      modal.style.display = "none";
      getMsgExercicioModal('msgExercicioModal',obj.msg);
    }
  };

  xhttp.open("POST", "http://localhost:8080/PEP/serv/exercicio?op=2&token="+token, false);
  xhttp.send();
}

var removeExercicioBtn = function(id){
  var json = {'id':id};

  var token = btoa(unescape(encodeURIComponent(JSON.stringify(json))));

  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      console.log(this.responseText);
       var obj = JSON.parse(this.responseText);
       getMsgExercicioModal('msgExercicioModal',obj.msg);
    }
  };

  xhttp.open("POST", "http://localhost:8080/PEP/serv/exercicio?op=4&token="+token, false);
  xhttp.send();
}

var runExercicioBtn = function (id) {

  
	var json = {'id':id};

	  var token = btoa(unescape(encodeURIComponent(JSON.stringify(json))));

	  var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
        
        var obj = JSON.parse(this.responseText);

        var text = "public class YourClassNameHere { "
        + "public static void main(String[] args) {"
        + obj[0].solucao
        + " } "
        + "}";

        
        var res = encodeURIComponent(text);
        var url = "http://pythontutor.com/java.html#code="+res+"&cumulative=false&heapPrimitives=nevernest&mode=display&origin=opt-frontend.js&py=java&rawInputLstJSON=%5B%5D&textReferences=true";
        console.log(url);
        document.getElementById('debugExercicio').setAttribute('src',url);
        getModal('debugExercicioModal');

	    }
	  };

	  xhttp.open("POST", "http://localhost:8080/PEP/serv/exercicio?op=1&token="+token, false);
	  xhttp.send();


}

var editExercicioBtn = function(id){
  var json = {'id':id};
  console.log(id);
  var token = btoa(unescape(encodeURIComponent(JSON.stringify(json))));

  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      console.log(this.responseText);
      var obj = JSON.parse(this.responseText);
      
      document.getElementById('editExercicioModal').setAttribute('name',id);

      var designacao = document.getElementById("editExDesg").value = obj[0].designacao;
      var dica = document.getElementById("editExDica").value = obj[0].dica;
      var solucao = document.getElementById('editExSolucao').value = obj[0].solucao;
      var enunciado = document.getElementById("editExEnunciado").value = obj[0].enunciado;
      var dificuldade = document.getElementById('editExNivel').value = obj[0].dificuldade;

      getModal('editExercicioModal');
    }
  };

  xhttp.open("POST", "http://localhost:8080/PEP/serv/exercicio?op=1&token="+token, false);
  xhttp.send();
}


var updateExercicioBtn = function(idModal){
  var id = document.getElementById(idModal).getAttribute("name");
  var designacao = document.getElementById("editExDesg").value;
  var dica = document.getElementById("editExDica").value;
  var solucao = document.getElementById('editExSolucao').value;
  var enunciado = document.getElementById("editExEnunciado").value;
   var dificuldade = document.getElementById('editExNivel').value;

  var json = {'id':id,'designacao':designacao, 'dica':dica, 'solucao':solucao, 'enunciado':enunciado,  'dificuldade':dificuldade};

  var token = btoa(unescape(encodeURIComponent(JSON.stringify(json))));

  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      console.log(this.responseText);
      var obj = JSON.parse(this.responseText);
      var modal = document.getElementById(idModal);
      console.log(modal);
      modal.style.display = "none";
      getMsgExercicioModal('msgExercicioModal',obj.msg);
    }
  };

  xhttp.open("POST", "http://localhost:8080/PEP/serv/exercicio?op=3&token="+token, false);
  xhttp.send();
}


