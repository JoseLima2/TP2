package Curso;

public class DocumentoID {
    TipoDocumento tipo;
    String cod;

    public DocumentoID(String tipo, String cod){
        this.tipo = gerarTipo(tipo);
    }


    private TipoDocumento gerarTipo(String doc){
        if(doc.equalsIgnoreCase("BI"))
            tipo = TipoDocumento.getBI();

        else if(doc.equalsIgnoreCase("PASSAPORTE"))
            tipo = TipoDocumento.getPASSAPORTE();

        else if(doc.equalsIgnoreCase("CUC"))
            tipo = TipoDocumento.getCUC();

        else if(doc.equalsIgnoreCase("TRE"))
            tipo = TipoDocumento.getTRE();

        else {System.out.println("Documento Invalido");
            System.exit(0);
        }

        return tipo;

    }

    public TipoDocumento getTipo() {
        return tipo;
    }

    public String getCod() {
        return cod;
    }


}
