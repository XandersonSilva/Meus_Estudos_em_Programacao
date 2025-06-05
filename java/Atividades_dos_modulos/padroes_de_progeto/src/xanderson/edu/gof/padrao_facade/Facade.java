package xanderson.edu.gof.padrao_facade;

import xanderson.edu.gof.subsistema1.CepApi;
import xanderson.edu.gof.subsistema0.CRMService;

public class Facade {
    public void migrarCliente(String nome, String cep){


        CepApi cepApi = CepApi.getInstance();
        String cidade, estado;

        cidade = cepApi.recuperarCidade(cep);
        estado = cepApi.recuperarEstado(cep);


        CRMService.gravarCliente(nome, cep, cidade, estado);
    }
}
