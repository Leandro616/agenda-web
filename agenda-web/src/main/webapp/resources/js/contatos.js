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
            + '<option selected value="1">Celular</option><option value="2">'
            + 'Comercial</option><option value="3">Residencial</option></select></div></div>';

      
                        
         $("#telefone-tipo").append(novaLinha);
         $(".telefone").mask("(00) 0000-00009");
      }
   });

   $(".telefone").mask("(00) 0000-00009");

   $(".telefone").blur(function (event) { 
      
      if ($(this).val().length == 15) {
         $(".telefone").mask("(00) 00000-0009");
      }
      else {
         $(".telefone").mask("(00) 0000-00009");
      }
   });
});


