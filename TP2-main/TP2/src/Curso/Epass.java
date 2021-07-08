package Curso;


import java.time.LocalDate;

public abstract class Epass implements Titulotransporte,CartaoPagamento{
    private String chave;
    private int nmrE;
    private Titular passageiro;
    private double saldo;
    private int pontos;
    private int numMovs;
    LocalDate dataNasc;
    private static int ultimoUsado;

    public Epass(String tipo, String cod, String nome, int telefone, LocalDate dataNasc){
        this.passageiro = new Titular(tipo,cod,nome, telefone,dataNasc);
        this.saldo = 0;
        this.numMovs = 0;
        this.pontos = 0;
        this.nmrE = ultimoUsado +1;
        setUltimoUsado(nmrE);
        this.chave = gerarChave();

    }
    public Epass(String tipo, String cod, String nome, String morada, String email, int telefone, LocalDate dataNasc){
        this.passageiro = new Titular (tipo,cod,nome,morada,email, telefone,dataNasc);
        this.saldo = 0;
        this.numMovs = 0;
        this.pontos = 0;
        this.nmrE = ultimoUsado +1;
        setUltimoUsado(nmrE);
        this.chave = gerarChave();

    }

    abstract public boolean passarSaldo(Epass pass, double saldoT);
    abstract public void carregarEpass(double valorT);
    abstract public char viajarGratis();
    abstract public String paraString();


    public void incNumMovs(){
        setNumMovs(+1);
    }
    public void incPontos(){
        if(getNumMovs()%10 == 0){
            setPontos(getPontos()+1);
        }
    }
    public final String gerarChave(){
        char C[];
        C = passageiro.getNome().toCharArray();
        StringBuilder nome = new StringBuilder();
        StringBuilder apelido = new StringBuilder();
        String chaveE;

        for(int i = 0; i< C.length -1; i++){
            if(C[i] == ' ')
                break;
            nome.append(C[i]);
        }

        for(int i = C.length -1; i >= 0; i--){
            if(C[i] == ' ')
                break;
            apelido.append(C[i]);
        }

        apelido.reverse();

        if(nome.length() > 5)
            nome.delete(5,nome.length() );

        if(apelido.length() > 5)
            apelido.delete(5,apelido.length() );

        chaveE = nome.reverse().toString().toUpperCase()+apelido.reverse().toString().toUpperCase()+passageiro.getDataNasc()+getNmrE();

        return chaveE;
    }


    @Override
    public void pagarViagem(){}
    @Override
    public void validarTitulo(){}
    @Override
    public void pagarConsumo(double valor){}


    public String getChave() {
        return chave;
    }

    public int getNmrE() {
        return nmrE;
    }

    public Titular getPassageiro() {
        return passageiro;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getPontos() {
        return pontos;
    }

    public int getNumMovs() {
        return numMovs;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public static int getUltimoUsado() {
        return ultimoUsado;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public void setNmrE(int nmrE) {
        this.nmrE = nmrE;
    }

    public void setPassageiro(Titular passageiro) {
        this.passageiro = passageiro;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public void setNumMovs(int numMovs) {
        this.numMovs = numMovs;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public static void setUltimoUsado(int ultimoUsado) {
        Epass.ultimoUsado=ultimoUsado;
    }




}
