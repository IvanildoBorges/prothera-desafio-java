package br.com.prothera.iniflex;
import br.com.prothera.iniflex.service.FuncionarioService;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        FuncionarioService service = new FuncionarioService();

        // Inserir todos os funcionários
        List<Funcionario> funcionarios = service.criarFuncionarios();

        // Remover funcionário João
        service.removerPorNome(funcionarios, "João");
    }
}