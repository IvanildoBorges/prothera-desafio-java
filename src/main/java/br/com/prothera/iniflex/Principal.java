package br.com.prothera.iniflex;
import br.com.prothera.iniflex.model.Funcionario;
import br.com.prothera.iniflex.service.FuncionarioService;
import br.com.prothera.iniflex.util.Formatador;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        FuncionarioService service = new FuncionarioService();

        // Inserir todos os funcionários
        List<Funcionario> funcionarios = service.criarFuncionarios();

        // Remover funcionário João
        service.removerPorNome(funcionarios, "João");

        // Imprimir todos os funcionários
        System.out.println("----- FUNCIONÁRIOS -----");
        imprimirFuncionarios(funcionarios);

        // Aumento de 10%
        service.aplicarAumento(funcionarios);
        System.out.println("\n----- FUNCIONÁRIOS APÓS AUMENTO DE 10% -----");
        imprimirFuncionarios(funcionarios);
    }

    private static void imprimirFuncionarios(List<Funcionario> funcionarios) {
        for (Funcionario funcionario : funcionarios) {
            System.out.println(
                "Nome: " + funcionario.getNome()
                + " | Data de nascimento: "
                + Formatador.formatarData(funcionario.getDataNascimento())
                + " | Salário: R$ "
                + Formatador.formatarValor(funcionario.getSalario())
                + " | Função: "
                + funcionario.getFuncao()
            );
        }
    }
}