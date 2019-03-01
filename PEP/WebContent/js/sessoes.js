var getMsgSessaoModal = function(idModal, msg){
	console.log('modal',msg);
  // Get the modal
  var modal = document.getElementById(idModal);
  modal.style.display = "block";

  document.getElementById('msgSessaoResult').innerHTML = msg;

  // When the user clicks anywhere outside of the modal, close it
  window.onclick = function(event) {
      if (event.target == modal) {
      	console.log('clickclose');
      		getListSessaoBtn();
          modal.style.display = "none";

      }
  }
}

var getMsgCanselBtn = function(idModal){
	console.log('clickclose');
  var modal = document.getElementById(idModal);
  getListSessaoBtn();
  modal.style.display = "none";
}


var getSessaoSaveBtn = function(idModal){
	var modal = document.getElementById(idModal);
	console.log('modelSessao: ', modal);
	var des = document.getElementById("sessaoD").value; 
}

var addSessaoBtn = function(idModal){
	var des = document.getElementById("sessaoD").value; 
	var obj = JSON.parse(sessionStorage.getItem("appSession"));
//	console.log(obj[0].name);
	var json = {'des':des, 'user_id':obj[0].user_id};

	var token = btoa(unescape(encodeURIComponent(JSON.stringify(json))));

	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
		  var obj = JSON.parse(this.responseText);
		  var modal = document.getElementById(idModal);
		  modal.style.display = "none";
		  getMsgSessaoModal('msgSessaoModal',obj.msg);
		}
	};

	xhttp.open("POST", "http://localhost:8080/PEP/serv/sessao?op=2&token="+token, false);
	xhttp.send();
}



var removeSessaoBtn = function(id){

	var json = {'id':id};

	var token = btoa(unescape(encodeURIComponent(JSON.stringify(json))));

	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
		  console.log(this.responseText);
		   var obj = JSON.parse(this.responseText);
		   getMsgSessaoModal('msgSessaoModal',obj.msg);
		}
	};

	xhttp.open("POST", "http://localhost:8080/PEP/serv/sessao?op=4&token="+token, false);
	xhttp.send();
}

var getListSessaoBtn = function(idModal){
	console.log('getListSessaoBtn');
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
		  var obj = JSON.parse(this.responseText);
		  var resutHeader = '<div class="table-wrapper-scroll-y"><table id="sessaoAlunosEscolha" class="table table-striped table-bordered" style="background-color: white;">'
		  +'<tbody><tr>'
		  +'<th><i class="icon_profile" id="idSessao"></i> ID</th>'
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
							+'<td>'+obj[i].id+'</td>'
							+'<td>'+obj[i].designacao+'</td>'
							+'<td>'
								+'<div class="btn-group">'
									+'<a class="btn btn-primary"  onclick="javascript:runSessaoBtn('+obj[i].id+');" id="'+obj[i].id+'"><i class="fa fa-arrow-alt-circle-right"></i></a>'
									+'</div>'
							+'</td>'
					+'</tr>';   
				}
				var resultFinal = (resutHeader + resultContent + resultFooter);

				if (obj.length == 0) {
					document.getElementById('tableSessaoAluno').innerHTML = 'No results ....';
				}else{
					document.getElementById('tableSessaoAluno').innerHTML = resultFinal;
				}
	
			}else{
					for (i in obj) {
						resultContent = resultContent
						+'<tr>'
								+'<td>'+obj[i].id+'</td>'
								+'<td>'+obj[i].designacao+'</td>'
								+'<td>'
									+'<div class="btn-group">'
//										+'<a class="btn btn-primary" href="#" onclick="javascript:editSessaoBtn('+obj[i].id+');" id="'+obj[i].id+'"><i class="fa fa-edit"></i></a>'
												+'<a class="btn btn-danger"  onclick="javascript:removeSessaoBtn('+obj[i].id+');" id="'+obj[i].id+'"><i class="fa fa-trash"></i></a>'
										+'</div>'
								+'</td>'
						+'</tr>';   
					}
					var resultFinal = (resutHeader + resultContent + resultFooter);

					if (obj.length == 0) {
						document.getElementById('tableSessao').innerHTML = 'No results ....';
					}else{
						document.getElementById('tableSessao').innerHTML = resultFinal;
					}
			}
		  
		  
		}
	};

	xhttp.open("POST", "http://localhost:8080/PEP/serv/sessao?op=5", false);
	xhttp.send();
}


var editSessaoBtn = function(id){
	var json = {'id':id};
	
//	var des = document.getElementById("editSessaoD").value; 
//	var obj = JSON.parse(sessionStorage.getItem("appSession"));
//	console.log(obj);
//	var json = {'des':des, 'user_id':obj[0].id};

	var token = btoa(unescape(encodeURIComponent(JSON.stringify(json))));

	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			console.log(this.responseText);
			var obj = JSON.parse(this.responseText);
			console.log(obj);
			document.getElementById("editSessaoD").value = 	obj[0].info_sessao; 
			document.getElementById('editSessaoModal').setAttribute('name',id);
			getModal('editSessaoModal');
		}
	};

	xhttp.open("POST", "http://localhost:8080/PEP/serv/sessao?op=1&token="+token, false);
	xhttp.send();
}


var updateSessaoBtn = function(idModal){
  var id = document.getElementById(idModal).getAttribute("name");
  var des = document.getElementById("editSessaoD").value;

  var json = {'id':id,'des':des};

  var token = btoa(unescape(encodeURIComponent(JSON.stringify(json))));

  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      console.log(this.responseText);
      var obj = JSON.parse(this.responseText);
      var modal = document.getElementById(idModal);
      console.log(modal);
      modal.style.display = "none";
      getMsgSessaoModal('msgSessaoModal',obj.msg);
    }
  };

  xhttp.open("POST", "http://localhost:8080/PEP/serv/sessao?op=3&token="+token, false);
  xhttp.send();
}

var runSessaoBtn = function (id) {
	var json = {'id':id};
	var token = btoa(unescape(encodeURIComponent(JSON.stringify(json))));

	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			console.log(this.responseText);
			var obj = JSON.parse(this.responseText);
			console.log('obj[0].info_sessao: ',obj[0].info_sessao);

			var objInfo = JSON.parse(obj[0].info_sessao);
			console.log('objInfo[0]: ',objInfo);
			var jsonTema = {'id':objInfo.tema};
			
			var tokenTema = btoa(unescape(encodeURIComponent(JSON.stringify(jsonTema))));
			var temaName = getTemaSessao(tokenTema);
			document.getElementById('temaSessaoRun').innerHTML = temaName;
			console.log('temaName: ',temaName);

			console.log('partea: ', objInfo.partea);
			getExerciciosSessao(objInfo.partea);
			getModal('runSessaoModal');
			
		}
	};

	xhttp.open("POST", "http://localhost:8080/PEP/serv/sessao?op=1&token="+token, false);
	xhttp.send();
	
}


var getTemaSessao = function (token) {
	var temaName = null;
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var objTema = JSON.parse(this.responseText);
			temaName = objTema[0].designacao;
		}
	};
	xhttp.open("POST", "http://localhost:8080/PEP/serv/tema?op=1&token="+token, false);
	xhttp.send();

	return temaName;
}

var getExerciciosSessao = function(ex){
	console.log('ex: ',ex);
	var cond;
	for (i in ex) {
		if(i==0) cond = " id=" + ex[i].id.replace("E", "");
		else cond = cond + " OR id=" + ex[i].id.replace("E", "");
	}
	console.log(cond);

	var json = {'cond':cond};
	var token = btoa(unescape(encodeURIComponent(JSON.stringify(json))));

	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var obj = JSON.parse(this.responseText);
			console.log('ex obj:',obj);
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
      
        for (i in obj) {
          resultContent = resultContent
          +'<tr>'
              +'<td style="display:none;">'+obj[i].id+'</td>'
              +'<td>'+obj[i].designacao+'</td>'
              +'<td>'
                +'<div class="btn-group">'
//					+'<a class="btn btn-primary" href="#" onclick="javascript:runExercicioBtn('+obj[i].id+');" id="'+obj[i].id+'"><i class="fas fa-arrow-alt-circle-right"></i></a>'
//										+'<input type="checkbox" class="checkbox" name="exercicioChk" onclick="checkAndUncheck("ck1");" id="ck'+obj[i].id+'" style="-ms-transform: scale(2); /* IE */ -moz-transform: scale(2); /* FF */ -webkit-transform: scale(2); /* Safari and Chrome */ -o-transform: scale(2); /* Opera */">'
										+'<input type="checkbox" class="checkbox" name="exercicioChk"  id="ck'+obj[i].id+'" style="-ms-transform: scale(2); /* IE */ -moz-transform: scale(2); /* FF */ -webkit-transform: scale(2); /* Safari and Chrome */ -o-transform: scale(2); /* Opera */">'

									+'</div>'
              +'</td>'
          +'</tr>';   
        }
        var resultFinal = (resutHeaderAluno + resultContent + resultFooter);
        console.log(obj.length);
        console.log(obj);
        if (obj.length == 0) {
        	 document.getElementById('tableExercicioSessaoAluno').innerHTML = 'No results ....';
        }else{
          document.getElementById('tableExercicioSessaoAluno').innerHTML = resultFinal;
        }
		}
	};
	xhttp.open("POST", "http://localhost:8080/PEP/serv/exercicio?op=1&token="+token, false);
	xhttp.send();

}


var getExToBeRun = function(){
	var idVal = $('input[name="exercicioChk"]:checked').attr('id');
	console.log(idVal.replace("ck", ""));
	var json = {'id':idVal.replace("ck", "")};
  var token = btoa(unescape(encodeURIComponent(JSON.stringify(json))));

  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      console.log(this.responseText);
      var obj = JSON.parse(this.responseText);
      document.getElementById("lblEnunciado").innerHTML = obj[0].enunciado;
    }
  };

  xhttp.open("POST", "http://localhost:8080/PEP/serv/exercicio?op=1&token="+token, false);
  xhttp.send();
}

var getExToBeDebug = function(){
	var ecercicio = document.getElementById("txtExercicio").value;
	console.log(ecercicio);
	var text = "public class YourClassNameHere { "
        + "public static void main(String[] args) {"
        + ecercicio
        + " } "
				+ "}";
				
	var res = encodeURIComponent(text);
	var url = "http://pythontutor.com/java.html#code="+res+"&cumulative=false&heapPrimitives=nevernest&mode=display&origin=opt-frontend.js&py=java&rawInputLstJSON=%5B%5D&textReferences=true";
	console.log(url);
	document.getElementById('debugExercicioSessao').setAttribute('src',url);
}

//var checkAndUncheck = function(idVal){
//	console.log('olaoalooalloa: ',idVal);
//	// in the handler, 'this' refers to the box clicked on
//	 $('input[name="exercicioChk"]:checked').prop("checked", false);
//console.log($('input[name="exercicioChk"]:checked').attr('id'));
//var id = $('input[name="exercicioChk"]:checked').attr('id');
//	 $('#'+id).prop('checked', true);
//
//}
