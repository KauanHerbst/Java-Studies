package main.java.ClientSerivce;

import main.java.ClienteDao.IClienteDao;

public class ClienteService {

    private IClienteDao iClienteDao;

    public ClienteService(IClienteDao iClienteDao) {
        this.iClienteDao = iClienteDao;
    }

    public String salvarDados(){
        iClienteDao.receberDados();
        return "Dados Salvos";
    }


}
