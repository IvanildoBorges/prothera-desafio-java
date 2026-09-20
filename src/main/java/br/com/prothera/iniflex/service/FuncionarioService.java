package br.com.prothera.iniflex.service;
import br.com.prothera.iniflex.model.Funcionario;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FuncionarioService {
    public List<Funcionario> criarFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();

        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));

        return funcionarios;
    }

    public void removerPorNome(List<Funcionario> funcionarios, String nome) {
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getNome().equals(nome)) {
                funcionarios.remove(i);
                break;
            }
        }
    }

    public void aplicarAumento(List<Funcionario> funcionarios) {
        BigDecimal percentual = new BigDecimal("0.10");

        for (Funcionario funcionario : funcionarios) {
            BigDecimal aumento = funcionario.getSalario().multiply(percentual);
            BigDecimal novoSalario = funcionario.getSalario().add(aumento);
            funcionario.setSalario(novoSalario);
        }
    }

    public Map<String, List<Funcionario>> agruparPorFuncao(List<Funcionario> funcionarios) {
        Map<String, List<Funcionario>> funcionariosPorFuncao = new LinkedHashMap<>();

        for (Funcionario funcionario : funcionarios) {
            String funcao = funcionario.getFuncao();

            if (!funcionariosPorFuncao.containsKey(funcao)) {
                funcionariosPorFuncao.put(funcao, new ArrayList<>());
            }

            funcionariosPorFuncao.get(funcao).add(funcionario);
        }

        return funcionariosPorFuncao;
    }

    public List<Funcionario> buscarAniversariantes(List<Funcionario> funcionarios, int primeiroMes, int segundoMes) {
        List<Funcionario> aniversariantes = new ArrayList<>();

        for (Funcionario funcionario : funcionarios) {
            int mes = funcionario.getDataNascimento().getMonthValue();

            if (mes == primeiroMes || mes == segundoMes) {
                aniversariantes.add(funcionario);
            }
        }

        return aniversariantes;
    }

    public Funcionario buscarMaisVelho(List<Funcionario> funcionarios) {
        LocalDate hoje = LocalDate.now();
        Funcionario maisVelho = funcionarios.get(0);

        for (Funcionario funcionario : funcionarios) {
            int idadeFuncionario = calcularIdade(funcionario.getDataNascimento(), hoje);
            int idadeMaisVelho = calcularIdade(maisVelho.getDataNascimento(), hoje);
            if (idadeFuncionario > idadeMaisVelho) {
                maisVelho = funcionario;
            }
        }

        return maisVelho;
    }

    public int calcularIdade(LocalDate dataNascimento, LocalDate dataAtual) {
        return Period.between(dataNascimento, dataAtual).getYears();
    }

    public void ordenarPorNome(List<Funcionario> funcionarios) {
        funcionarios.sort(Comparator.comparing(Funcionario::getNome));
    }

    public BigDecimal calcularTotalSalarios(List<Funcionario> funcionarios) {
        BigDecimal total = BigDecimal.ZERO;

        for (Funcionario funcionario : funcionarios) {
            total = total.add(funcionario.getSalario());
        }

        return total;
    }

    
}