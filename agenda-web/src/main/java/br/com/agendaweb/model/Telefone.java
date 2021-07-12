package br.com.agendaweb.model;

public class Telefone {
   private int idTelefone;
   private String numero;
   private String tipo;

   public int getIdTelefone() {
      return idTelefone;
   }

   public void setIdTelefone(int idTelefone) {
      this.idTelefone = idTelefone;
   }

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
      this.tipo = tipo;
   }

   public String numeroFormatado() {
      String ddd = getNumero().substring(0, 2);
      
      String n1 = getNumero().length() == 11 
         ? getNumero().substring(2, 7) : getNumero().substring(2, 6);

      String n2 = getNumero()
         .substring(getNumero().length() - 4, getNumero().length());


      return String.format("(%s) %s-%s", ddd, n1, n2);
   }

   public String tipoFormatado() {
      switch (tipo) {
         case "RES":
            return "Residencial";
         case "COM":
            return "Comercial";
         case "CEL":
            return "Celular";
         default:
            return tipo;
      }
   }
}
