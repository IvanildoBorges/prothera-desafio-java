package br.com.prothera.iniflex;
import br.com.prothera.iniflex.model.Funcionario;
import br.com.prothera.iniflex.service.FuncionarioService;
import br.com.prothera.iniflex.util.Formatador;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

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

        // Agrupa e imprimi por função
        Map<String, List<Funcionario>> porFuncao = service.agruparPorFuncao(funcionarios);
        System.out.println("\n----- FUNCIONÁRIOS POR FUNÇÃO -----");
        for (String funcao : porFuncao.keySet()) {
            System.out.println("\nFunção: " + funcao);
            for (Funcionario funcionario : porFuncao.get(funcao)) {
                System.out.println(
                    funcionario.getNome() + " - R$ " + Formatador.formatarValor(funcionario.getSalario())
                );
            }
        }

        // Aniversariantes de outubro e dezembro
        List<Funcionario> aniversariantes = service.buscarAniversariantes(funcionarios, 10, 12);
        System.out.println("\n----- ANIVERSARIANTES DE OUTUBRO E DEZEMBRO -----");
        for (Funcionario funcionario : aniversariantes) {
            System.out.println(
                funcionario.getNome() + " - " + Formatador.formatarData(funcionario.getDataNascimento())
            );
        }

        // Funcionário com maior idade
        Funcionario maisVelho = service.buscarMaisVelho(funcionarios);
        int idadeMaisVelho = service.calcularIdade(maisVelho.getDataNascimento(), LocalDate.now());
        System.out.println("\n----- FUNCIONÁRIO MAIS VELHO -----");
        System.out.println("Nome: " + maisVelho.getNome() + " | Idade: " + idadeMaisVelho);

        // Ordem alfabética
        service.ordenarPorNome(funcionarios);
        System.out.println("\n----- FUNCIONÁRIOS EM ORDEM ALFABÉTICA -----");
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.getNome());
        }

        // Total dos salários
        BigDecimal total = service.calcularTotalSalarios(funcionarios);
        System.out.println("\n----- TOTAL DOS SALÁRIOS -----");
        System.out.println("Total: R$ " + Formatador.formatarValor(total));

        // Quantidade de salários mínimos que cada funcionário recebe
        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        Map<String, BigDecimal> salariosMinimos = service.calcularSalariosMinimos(funcionarios, salarioMinimo);
        System.out.println("\n----- SALÁRIOS MÍNIMOS -----");
        for (String nome : salariosMinimos.keySet()) {
            System.out.println(nome + " recebe aproximadamente " + salariosMinimos.get(nome) + " salários mínimos.");
        }
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