$(function () {
   var incremento = 0;

   $("#add-telefone").click(function () { 
      
      incremento++;

      if (incremento >= 3) {
         alert("Máximo de 3 telefones por contato");
      }
      else {
         var novaLinha = '<div class="row mt-3"><div class="col-6">'
            + '<input type="tel" name="telefone[' + incremento + ']"' 
            + 'class="form-control telefone" placeholder="Telefone"></div><div class="col-6">'
            + '<select class="form-select" name="tipo[' + incremento + ']">'
            + '<option selected value="CEL">Celular</option><option value="COM">'
            + 'Comercial</option><option value="RES">Residencial</option></select></div></div>';

      
                        
         $("#telefone-tipo").append(novaLinha);
         
         aplicarMask();
      }
   });

   aplicarMask();

   $("#editar-contato").hide();

   $("#cancelar-editor").click(function () { 
      $("#novo-contato").show();
      $("#editar-contato").hide();   
      
   });

});

function mostrarEditor(id, nome, email, ids, telefones, tipos) {
   $("#novo-contato").hide();
   $("main").hide();
   $("#editar-contato").show();

   $("#id-contato").val(id);
   $("#nome").val(nome);
   $("#email").val(email);
   $("#telefone0").val(telefones[0]);
   $("#tipo0").val(tipos[0]);
   $("#id-telefone0").val(ids[0]);


   for (var i = 1; i < telefones.length; i++) {
      
      var novaLinha = '<input type="hidden" name="idTelefone['+ i +']" id="id-telefone'+ i +'" value="">'
            + '<div class="row mt-3"><div class="col-6">'
            + '<input type="tel" name="telefone[' + i + ']" id="telefone'+ i + '"' 
            + 'class="form-control telefone" placeholder="Telefone"></div><div class="col-6">'
            + '<select class="form-select" name="tipo[' + i + ']" id="tipo'+ i +'">'
            + '<option selected value="CEL">Celular</option><option value="COM">'
            + 'Comercial</option><option value="RES">Residencial</option></select></div></div>';

      $("#telefone-tipo-editar").append(novaLinha);
      
      
      
      $("#id-telefone" + i).val(ids[i]);
      $("#telefone" + i).val(telefones[i]);
      $("#tipo" + i).val(tipos[i]);
   }
   
   var $telefones = $("#telefone-tipo-editar").find(".telefone").val();

   if ($telefones.length == 15) {
      $("#telefone-tipo-editar").find(".telefone").mask("(00) 00000-0009");
   }
   else {
      $("#telefone-tipo-editar").find(".telefone").mask("(00) 0000-00009");
   }

   //$("#telefone-tipo-editar").find("input").mask("(00) 0000-00009");
   
}

function aplicarMask() {
   $("#telefone-tipo").find("input").mask("(00) 0000-00009");

   $("#telefone-tipo").find("input").change(function () { 
         
      if ($(this).val().length === 15) {
         $(".telefone").mask("(00) 00000-0009");
      }
      else {
         $(".telefone").mask("(00) 0000-00009");
      }
   });

}