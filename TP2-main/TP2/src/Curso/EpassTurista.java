package Curso;

import java.time.LocalDate;

public class EpassTurist extends Epass implements Titulotransporte{
    private final double valorBilhete = 50;
    private  int tipoT;

    EpassTurist(String tipo, String cod, String nome, String morada, String email, int telefone, LocalDate dataNasc, int duracao, LocalDate hoje){
        super(tipo,cod,nome,morada,email, telefone,dataNasc);
        setTipoT(duracao);
        gerarSaldo(duracao);
    }

    EpassTurist(String nome, String morada, int telefone, LocalDate nascimento, String email, String doc, String cod, int diasVal, LocalDate hoje) {
        super(doc,cod,nome,morada,email, telefone,nascimento);

    }

    private void gerarSaldo(int length){
        switch (length) {
            case 1:
                setSaldo(500);
                break;
            case 3:
                setSaldo(700);
                break;
            case 7:
                setSaldo(1500);
                break;
            default:
                System.out.println("-ERRO");
                System.out.println("A DURACAO A ESCOLHER TEM DE SER 1,3 OU 7.");
                break;
        }

    }
    @Override
    public boolean passarSaldo(Epass pass, double saldoT) {
        boolean result = false;

        if( pass.getClass().getName().equalsIgnoreCase("EpassTurist") ){
            if(getSaldo() > saldoT){
                setSaldo(-saldoT);
                pass.setSaldo(+saldoT);
                result = true;
            }
                else{
                    System.out.println("NÃO FOI POSSÍVEL REALIZAR TRANSFERENCIA");
                    System.out.println("O SEU SALDO É INFERIOR AO VALOR DE TRANSFERENCIA");
                }
        }
        else {
            System.out.println("NÃO FOI POSSÍVEL REALIZAR TRANSFERENCIA");
            System.out.println("NÃO PODE TRANSFERIR SALDO PARA EPASS DE TIPO DIFERENTE");
            System.out.println("SEU EPASS É DO TIPO "+getClass().getName() +
                    " MAS QUER TRANFERIR SALDO PARA EPASS DO TIPO "+pass.getClass().getName() );
        }



        return result;
    }

    @Override
    public char viajarFree(){return 'N';}

    @Override
    public void carregarEpass(double valorT) {
        System.out.println("NÃO FOI POSSIVEL CARREGAR O EPASS DO TIPO TURISTA.");
    }


    @Override
    public void pagarViagem(){
        char t;
        if(getSaldo()> getValorBilhete() && getPontos()>100){
            System.out.println("S - Pagar com saldo \t  P - Pagar com pontos");
            t = Ler.umChar();
            switch(t){
                case 'S':
                    setSaldo(getSaldo() -getValorBilhete());
                    incNumMovs();
                    incPontos();
                    System.out.println("Pagamento com saldo efetuado com sucesso");
                    System.out.println("OK VIAJAR!");
                    System.out.println("SALDO ACTUAL => "+getSaldo());
                    break;
                case 'P':
                    setPontos(getPontos()-40);
                    incNumMovs();
                    incPontos();
                    System.out.println("Pagamento com pontos efetuado com sucesso");
                    System.out.println("OK VIAJAR!");
                    System.out.println("PONTOS ACTUAIS => "+getPontos());
                    break;
                default:
                    System.out.println("OPÇÃO INVALIADA!!!");
                    System.out.println("Pagamento não realizado.");
                    System.out.println("NÃO OK PARA VIAJAR!");
            }
        }
                else if(getSaldo()> getValorBilhete() && getPontos()<100){
                    setSaldo(getSaldo()-getValorBilhete());
                    incNumMovs();
                    incPontos();
                    System.out.println("Pagamento com saldo efetuado com sucesso");
                    System.out.println("OK VIAJAR!");
                    System.out.println("SALDO ACTUAL => "+getSaldo());
                }
                    else if(getSaldo()<getValorBilhete() && getPontos()>100){
                        setPontos(-40);
                        incNumMovs();
                        incPontos();
                        System.out.println("Pagamento com pontos efetuado com sucesso");
                        System.out.println("OK VIAJAR!");
                        System.out.println("PONTOS ACTUAIS => "+getPontos());
                    }
                        else{
                            System.out.println("SALDO ACTUAL => "+getSaldo() +"\tPONTOS ACTUAIS => "+getPontos() );
                            System.out.println("Pagamento não realizado.");
                            System.out.println("NÃO OK PARA VIAJAR!");
                        }
    }



    @Override
    public void validarTitulo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String paraString(){
        StringBuilder s = new StringBuilder();
        s.append("-Epass Nr : "); s.append(getNmrE());
        s.append("\n-Tipo de ePass: ePass Turist");
        s.append("\n-Chave : "); s.append(getChave());
        s.append("\n-Nome titular: "); s.append(getPassageiro().getNome());
        s.append("\n-Tipo DOC: "); s.append(getPassageiro().getDocID().getTipo() );
        s.append("\n-Codigo DOC: "); s.append(getPassageiro().getDocID().getCod() );
        s.append("\n-Morada : "); s.append(getPassageiro().getMorada());
        s.append("\n-Email : "); s.append(getPassageiro().getEmail() );
        s.append("\n-Telefone: "); s.append(getPassageiro().getTelefone());
        s.append("\n-Saldo actual: "); s.append(getSaldo());
        s.append("\n-Número de viagens: "); s.append(getNumMovs());
        s.append("\n-");
        s.append("\n-DADOS UNICOS");
        s.append("\n-Duracao de ePassTurist: ");s.append(getTipoT());
        return s.toString();

    }
    public double getValorBilhete() {
        return valorBilhete;
    }

    public int getTipoT() {
        return tipoT;
    }
    public void setTipoT(int duracao){
        this.tipoT = duracao;
    }
}
