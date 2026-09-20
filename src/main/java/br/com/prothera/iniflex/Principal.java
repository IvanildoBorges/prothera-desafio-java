package br.com.prothera.iniflex;
import br.com.prothera.iniflex.service.FuncionarioService;

public class Principal {
    public static void main(String[] args) {
        FuncionarioService service = new FuncionarioService();

        // Inserir todos os funcionários
        List<Funcionario> funcionarios = service.criarFuncionarios();
    }
}