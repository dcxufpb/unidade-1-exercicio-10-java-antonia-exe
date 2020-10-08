package com.example.project;

public class Loja {

    private static final String ENDLN = System.lineSeparator();
	private static boolean isEmpty(String str){
		if(str == null) return true;
		int spaceCount = str.length() - str.replace(".", "").length();
        return (spaceCount == str.length());
    }

    private String nomeLoja;
    private String logradouro;
    private int numero;
    private String complemento;
    private String bairro;
    private String municipio;
    private String estado;
    private String cep;
    private String telefone;
    private String observacao;
    private String cnpj;
    private String inscricaoEstadual;

    public Loja(String nomeLoja, String logradouro, int numero, String complemento, String bairro, String municipio,
            String estado, String cep, String telefone, String observacao, String cnpj, String inscricaoEstadual) {
        this.nomeLoja = nomeLoja;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.municipio = municipio;
        this.estado = estado;
        this.cep = cep;
        this.telefone = telefone;
        this.observacao = observacao;
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getNomeLoja() {
        return this.nomeLoja;
    }

    public String getLogradouro() {
        return this.logradouro;
    }

    public int getNumero() {
        return this.numero;
    }

    public String getComplemento() {
        return this.complemento;
    }

    public String getBairro() {
        return this.bairro;
    }

    public String getMunicipio() {
        return this.municipio;
    }

    public String getEstado() {
        return this.estado;
    }

    public String getCep() {
        return this.cep;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public String getObservacao() {
        return this.observacao;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public String getInscricaoEstadual() {
        return this.inscricaoEstadual;
    }

    public String dadosLojaObjeto() {
		if (isEmpty(this.getNomeLoja())){
            throw new RuntimeException("O campo nome da loja é obrigatório");
        }

		if(isEmpty(this.getLogradouro())){
			throw new RuntimeException("O campo logradouro do endereço é obrigatório");
		}

		String numero1 = this.getNumero() + "";
		if(this.getNumero() == 0){
			numero1 = "s/n";
		}

		if(isEmpty(this.getMunicipio())){
			throw new RuntimeException("O campo município do endereço é obrigatório");
		}
		
		if(isEmpty(this.getEstado())){
			throw new RuntimeException("O campo estado do endereço é obrigatório");
		}

		if(isEmpty(this.getCnpj())){
			throw new RuntimeException("O campo cnpj da loja é obrigatório");
		}

		if(isEmpty(this.getInscricaoEstadual())){
			throw new RuntimeException("O campo inscrição estadual da loja é obrigatório");
		}

		String linha2 = this.getLogradouro() + ", " + numero1;
		if (! isEmpty(this.getComplemento())){
			linha2 += " " + this.getComplemento();
		}
		
		String linha3 = "";
		if (! isEmpty(this.getBairro())){
		  linha3 += this.getBairro() + " - ";
		}
		linha3 += this.getMunicipio() + " - " + this.getEstado();
	  
		String linha4 = "";
		if (! isEmpty(this.getCep())){
		  linha4 = "CEP:" + this.getCep();
		}
		if (! isEmpty(this.getTelefone())){
		  if (! isEmpty(linha4)){
			linha4 += " ";
		  }
		  linha4 += "Tel " + this.getTelefone();
		}
		if (! isEmpty(linha4)){
		  linha4 += ENDLN;
		}
	  
		String linha5 = "";
		if (! isEmpty(this.getObservacao())){
		  linha5 += this.getObservacao();
		}
	  
		String output = this.getNomeLoja() + ENDLN;
		output += linha2 + ENDLN;
		output += linha3 + ENDLN;
		output += linha4;
		output += linha5 + ENDLN;
		output += "CNPJ: " + this.getCnpj() + ENDLN;
		output += "IE: " + this.getInscricaoEstadual() + ENDLN;
	  
		return output;
	}

}