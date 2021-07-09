package br.com.agendaweb.model;

public class Telefone {
   private String numero;
   private String tipo;

   public String getNumero() {
      return numero;
   }

   public void setNumero(String numero) {
      this.numero = numero;
   }

   public String getTipo() {
      return tipo;
   }

   public void setTipo(String tipo) {
      switch (tipo) {
         case "RES":
            this.tipo = "Residencial";
            break;
         case "COM":
            this.tipo = "Comercial";
            break;
         case "CEL":
            this.tipo = "Celular";
            break;
         default:
            this.tipo = tipo;
      }
   }

   public String numeroFormatado() {
      String ddd = getNumero().substring(0, 2);
      
      String n1 = getNumero().length() == 11 
         ? getNumero().substring(2, 7) : getNumero().substring(2, 6);

      String n2 = getNumero()
         .substring(getNumero().length() - 4, getNumero().length());


      return String.format("(%s) %s-%s", ddd, n1, n2);
   }
}
